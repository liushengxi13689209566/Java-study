package graph;

/*
*{"USD", "JPY", 110.0},
{"USD", "AUD", 1.45},
{"JPY", "GBP", 0.007}

需求：原始数据是一个一个的货币兑换数据，如上所示。输入一个货币对，求他们之间的汇率。
思路：图的 DFS/bfs 搜索问题
* */


import java.util.*;

public class CurrencyConverter {
    private Map<String, Map<String, Double>> graph;

    public CurrencyConverter(List<RateData> rateData) {
        this.graph = new HashMap<>();
        buildGraph(rateData);
    }

    // 汇率数据类
    public static class RateData {
        String fromCurrency;
        String toCurrency;
        double rate;

        public RateData(String fromCurrency, String toCurrency, double rate) {
            this.fromCurrency = fromCurrency;
            this.toCurrency = toCurrency;
            this.rate = rate;
        }
    }

    // 路径结果类
    public static class PathResult {
        List<String> path;
        double rate;

        public PathResult(List<String> path, double rate) {
            this.path = path;
            this.rate = rate;
        }

        @Override
        public String toString() {
            return String.format("路径: %s (汇率: %.6f)",
                    String.join(" -> ", path), rate);
        }
    }

    private void buildGraph(List<RateData> rateData) {
        for (RateData data : rateData) {
            // 添加正向汇率
            graph.computeIfAbsent(data.fromCurrency, k -> new HashMap<>())
                    .put(data.toCurrency, data.rate);

            // 添加反向汇率
            graph.computeIfAbsent(data.toCurrency, k -> new HashMap<>())
                    .put(data.fromCurrency, 1.0 / data.rate);
        }
    }

    /**
     * 获取两个货币之间的汇率
     *
     * @param fromCurrency 源货币
     * @param toCurrency   目标货币
     * @return 汇率值，如果无法兑换返回 null
     */
    public Double getExchangeRate(String fromCurrency, String toCurrency) {
        // 如果是同一种货币
        if (fromCurrency.equals(toCurrency)) {
            return 1.0;
        }

        // 使用DFS查找兑换路径
        Set<String> visited = new HashSet<>();
        return dfs(fromCurrency, toCurrency, 1.0, visited);
    }

    private Double dfs(String current, String target, double currentRate, Set<String> visited) {
        // 如果找到目标货币
        if (current.equals(target)) {
            return currentRate;
        }

        visited.add(current);

        // 遍历所有相邻货币
        Map<String, Double> neighbors = graph.get(current);
        if (neighbors != null) {
            for (Map.Entry<String, Double> entry : neighbors.entrySet()) {
                String neighbor = entry.getKey();
                double rate = entry.getValue();

                if (!visited.contains(neighbor)) {
                    // 计算到邻居的汇率
                    double newRate = currentRate * rate;
                    Double result = dfs(neighbor, target, newRate, visited);
                    if (result != null) {
                        return result;
                    }
                }
            }
        }

        visited.remove(current);
        return null;
    }

    /**
     * 获取所有可能的兑换路径
     *
     * @param fromCurrency 源货币
     * @param toCurrency   目标货币
     * @return 所有路径列表
     */
    public List<PathResult> getAllPaths(String fromCurrency, String toCurrency) {
        List<PathResult> allPaths = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        List<String> currentPath = new ArrayList<>();
        currentPath.add(fromCurrency);

        findAllPaths(fromCurrency, toCurrency, currentPath, 1.0, visited, allPaths);
        return allPaths;
    }

    private void findAllPaths(String current, String target,
                              List<String> currentPath, double currentRate,
                              Set<String> visited, List<PathResult> allPaths) {
        if (current.equals(target)) {
            allPaths.add(new PathResult(new ArrayList<>(currentPath), currentRate));
            return;
        }

        visited.add(current);

        Map<String, Double> neighbors = graph.get(current);
        if (neighbors != null) {
            for (Map.Entry<String, Double> entry : neighbors.entrySet()) {
                String neighbor = entry.getKey();
                double rate = entry.getValue();

                if (!visited.contains(neighbor)) {
                    currentPath.add(neighbor);
                    findAllPaths(neighbor, target, currentPath, currentRate * rate,
                            visited, allPaths);
                    currentPath.remove(currentPath.size() - 1);
                }
            }
        }

        visited.remove(current);
    }

    /**
     * 获取最佳路径（兑换次数最少）
     *
     * @param fromCurrency 源货币
     * @param toCurrency   目标货币
     * @return 最佳路径结果
     */
    public PathResult getBestPath(String fromCurrency, String toCurrency) {
        List<PathResult> allPaths = getAllPaths(fromCurrency, toCurrency);
        if (allPaths.isEmpty()) {
            return null;
        }

        // 选择路径最短的
        return allPaths.stream()
                .min(Comparator.comparingInt(p -> p.path.size()))
                .orElse(null);
    }

    /**
     * 添加新的汇率关系
     *
     * @param fromCurrency 源货币
     * @param toCurrency   目标货币
     * @param rate         汇率
     */
    public void addExchangeRate(String fromCurrency, String toCurrency, double rate) {
        graph.computeIfAbsent(fromCurrency, k -> new HashMap<>())
                .put(toCurrency, rate);

        graph.computeIfAbsent(toCurrency, k -> new HashMap<>())
                .put(fromCurrency, 1.0 / rate);
    }

    /**
     * 显示所有货币节点
     */
    public void displayAllCurrencies() {
        System.out.println("可用的货币列表:");
        for (String currency : graph.keySet()) {
            System.out.println("- " + currency);
        }
    }

    public static void main(String[] args) {
        // 创建汇率数据
        List<RateData> rateData = Arrays.asList(
                new RateData("USD", "JPY", 110.0),
                new RateData("USD", "AUD", 1.45),
                new RateData("JPY", "GBP", 0.007)
        );

        // 创建转换器
        CurrencyConverter converter = new CurrencyConverter(rateData);

        // 测试用例
        List<String[]> testCases = Arrays.asList(
                new String[]{"USD", "JPY"},    // 直接汇率
                new String[]{"JPY", "USD"},    // 反向汇率
                new String[]{"USD", "GBP"},    // 间接汇率：USD->JPY->GBP
                new String[]{"AUD", "JPY"},    // 间接汇率：AUD->USD->JPY
                new String[]{"GBP", "AUD"},    // 间接汇率：GBP->JPY->USD->AUD
                new String[]{"USD", "EUR"},    // 无汇率
                new String[]{"USD", "USD"}     // 同种货币
        );

        System.out.println("汇率查询结果:");
//        System.out.println("=".repeat(50));

        for (String[] testCase : testCases) {
            String fromCurrency = testCase[0];
            String toCurrency = testCase[1];

            Double rate = converter.getExchangeRate(fromCurrency, toCurrency);

            System.out.printf("%s -> %s: ", fromCurrency, toCurrency);
            if (rate != null) {
                System.out.printf("%.6f%n", rate);

                // 显示最佳路径
                PathResult bestPath = converter.getBestPath(fromCurrency, toCurrency);
                if (bestPath != null) {
                    System.out.println("  " + bestPath);
                }
            } else {
                System.out.println("无法兑换");
            }
            System.out.println();
        }

        // 显示所有可能的 USD->GBP 路径
        System.out.println("\n所有可能的 USD->GBP 路径:");
        for (PathResult path : converter.getAllPaths("USD", "GBP")) {
            System.out.println("  " + path);
        }

        // 显示所有货币
        System.out.println("\n");
        converter.displayAllCurrencies();

        // 测试添加新的汇率
        System.out.println("\n添加新汇率: GBP -> EUR = 1.18");
        converter.addExchangeRate("GBP", "EUR", 1.18);

        System.out.println("查询 USD -> EUR:");
        Double rate = converter.getExchangeRate("USD", "EUR");
        if (rate != null) {
            System.out.printf("汇率: %.6f%n", rate);
            PathResult path = converter.getBestPath("USD", "EUR");
            System.out.println("  " + path);
        }
    }
}










