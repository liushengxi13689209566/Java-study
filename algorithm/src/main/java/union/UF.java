package union;

/**
 * @Date: 2022-03-10 22:34
 * @Author: liushengxi
 * @Description:
 */
public class UF {
    private int[] roots;

    public UF(int n) {
        roots = new int[n];
        for (int i = 0; i < n; i++) {
            roots[i] = i;
        }
    }

    // 确定元素属于哪⼀个⼦集，返回 集合 的老大
    public int find(int x) {
        if (roots[x] == x) {
            return x;
        }
        return find(roots[x]);
    }

    // 将两个⼦集合并成同⼀个集合
    public void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);
        // 相交, 跳过
        if (xRoot == yRoot) {
            return;
        }
        // x 集合的老大归属了 y 集合的老大
        roots[xRoot] = yRoot;
    }

    public static void main(String[] args) {
        UF uf = new UF(10);
        uf.union(1, 2);
        uf.union(2, 3);

        uf.union(4, 5);

        System.out.println(uf.find(1));
        System.out.println(uf.find(2));
        System.out.println(uf.find(3));

        System.out.println(uf.find(4));
        System.out.println(uf.find(5));
    }
}
