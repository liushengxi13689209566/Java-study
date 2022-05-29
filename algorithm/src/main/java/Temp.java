import com.google.common.collect.Lists;

import java.util.*;


public class Temp {
    class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            int[] result = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                result[i] = i;
            }
            if (prerequisites == null || prerequisites.length <= 0) {
                return result;
            }
            for (int[] prerequisite : prerequisites) {
                if (prerequisite[0] < prerequisite[1]) {
                    int tmp = result[prerequisite[0]];
                    result[prerequisite[0]] = result[prerequisite[1]];
                    result[prerequisite[1]] = tmp;
                }
            }
            return result;
        }
    }
}

