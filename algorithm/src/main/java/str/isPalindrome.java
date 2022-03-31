package str;

/**
 * @Date: 2022-03-17 20:36
 * @Author: liushengxi
 * @Description:
 */
public class isPalindrome {
    static class Solution {

        public boolean isPalindrome(String s) {
            if (s == null) {
                return false;
            }
            int len = s.length();
            if (len == 1) {
                return true;
            }
            int left = 0;
            int right = len - 1;
            System.out.println(s);
            while (left < right) {
                while (left < right && Character.isLetterOrDigit(s.charAt(left))) {
                    left++;
                }
                while (left < right && Character.isLetterOrDigit(s.charAt(right))) {
                    right--;
                }
                if (left >= right || Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.isPalindrome("A man, a plan, a canal: Panama");

    }
}
