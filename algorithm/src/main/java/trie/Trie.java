//package trie;
//
///**
// * @Date: 2022-03-13 14:17
// * @Author: liushengxi
// * @Description:
// */
//class Trie {
//    private Trie[] children;
//    private boolean isEnd;
//
//    public boolean isEnd() {
//        return isEnd;
//    }
//
//    public Trie() {
//        children = new Trie[26];
//        // [0,1,2,3,4,5,6,7,8,9,10]
//        // 数组下标表示 字符-`a` 的值
//        isEnd = false;
//    }
//
//    public void insert(String word) {
//        // node 刚开始指向的是 trie 的 树根，以后依次向下指向，所以最后其 isEnd = true
//        Trie node = this;
//        for (int i = 0; i < word.length(); i++) {
//            int index = word.charAt(i) - 'a';
//            if (node.children[index] == null) {
//                // 注意 isEnd 都是 false
//                node.children[index] = new Trie();
//            }
//            // 如果还是空，先创建，再移动 node 指针
//            node = node.children[index];
//        }
//        node.isEnd = true;
//    }
//
//    public boolean search(String word) {
//        Trie node = helperSearchPrefix(word);
//        // 这里指针已经指向了 search 的最后一个字符，所以直接判断是否是结束字符即可。
//        return node != null && node.isEnd;
//    }
//
//    public boolean startsWith(String prefix) {
//        return helperSearchPrefix(prefix) != null;
//    }
//
//    public Trie helperSearchPrefix(String prefix) {
//        Trie node = this;
//        for (int i = 0; i < prefix.length(); i++) {
//            char ch = prefix.charAt(i);
//            int index = ch - 'a';
//            if (node.children[index] == null) {
//                return null;
//            }
//            node = node.children[index];
//        }
//        return node;
//    }
//
//
//    public static void main(String[] args) {
//        Trie obj = new Trie();
//        obj.insert("hello");
//        System.out.println(obj.search("hello"));
//        System.out.println(obj.search("hell"));
//        System.out.println(obj.search("helloa"));
//
//        System.out.println(obj.startsWith("hell"));
//        System.out.println(obj.startsWith("helloa"));
//        System.out.println(obj.startsWith("hello"));
//    }
//}
//
///**
// * Your trie.Trie object will be instantiated and called as such:
// * trie.Trie obj = new trie.Trie();
// * obj.insert(word);
// * boolean param_2 = obj.search(word);
// * boolean param_2 = obj.search(word);
// */
