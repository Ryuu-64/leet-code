package org.ryuu;

/**
 * <a href="https://leetcode.cn/problems/find-nearest-point-that-has-the-same-x-or-y-coordinate/">1779. 找到最近的有相同 X 或 Y 坐标的点</a>
 */
public class LeetCode1779 {
    public static int nearestValidPoint(int x, int y, int[][] points) {
        int len = points.length;
        int closetDistance = Integer.MAX_VALUE;
        int index = -1;

        for (int i = 0; i < len; i++) {
            int pointX = points[i][0];
            int pointY = points[i][1];
            if (x == pointX) {
                int distance = Math.abs(pointY - y);
                if (distance < closetDistance) {
                    closetDistance = distance;
                    index = i;
                }
            }
            if (y == pointY) {
                int distance = Math.abs(pointX - x);
                if (distance < closetDistance) {
                    closetDistance = distance;
                    index = i;
                }
            }
        }

        return index;
    }
}