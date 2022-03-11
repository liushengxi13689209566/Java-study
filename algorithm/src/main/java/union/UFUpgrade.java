package union;

/**
 * @Date: 2022-03-10 22:34
 * @Author: liushengxi
 * @Description:
 */
public class UFUpgrade {
    private int[] roots;
    // 即：树高
    private int[] rank;


    public UFUpgrade(int n) {
        roots = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            roots[i] = i;
            rank[i] = 1;
        }
    }

    // 确定元素属于哪⼀个⼦集，返回 集合 的老大
    public int find(int x) {
        while (x != roots[x]) {
            roots[x] = roots[roots[x]];
            rank[x] -= 1;
            x = roots[x];
        }
        return x;
    }

    // 将两个⼦集合并成同⼀个集合
    public void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);
        // 相交, 跳过
        if (xRoot == yRoot) {
            return;
        }
        // 在每次合并的时候，总是树低的往树高的合并
        if (rank[xRoot] < rank[yRoot]) {
            // x 集合的老大归属了 y 集合的老大
            roots[xRoot] = yRoot;
            rank[xRoot] += 1;

        } else {
            roots[yRoot] = xRoot;
            rank[yRoot] += 1;
        }
    }

    public static void main(String[] args) {
        UFUpgrade uf = new UFUpgrade(10);
        uf.union(1, 2);
        uf.union(2, 3);

        uf.union(4, 5);


        for (int i = 0; i < 5; i++) {
            System.out.print(uf.roots[i]);
        }
        System.out.println();

        System.out.println(uf.find(1));
        System.out.println(uf.find(2));
        System.out.println(uf.find(3));

        System.out.println(uf.find(4));
        System.out.println(uf.find(5));
    }
}
