//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @Date: 2022-03-18 15:00
// * @Author: liushengxi
// * @Description:
// */
//public class TTES {
//    class Solution {
//        private List<Integer> InOrderResult = new ArrayList<>();
//
//        void InOrder(TreeNode root) {
//            // 中序: 左 根 右
//            if (root.left != null)
//                InOrder(root.left);
//            if (root != null) {
//                InOrderResult.add(root.val);
//            }
//            if (root.right != null)
//                InOrder(root.right);
//        }
//
//        public int kthLargest(TreeNode root, int k) {
//            InOrder(root);
//            return InOrderResult.get(InOrderResult.size() - k);
//        }
//    }
//}
