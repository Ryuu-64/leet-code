package org.ryuu;

import java.util.*;

/*
 * <a href="https://leetcode.cn/problems/maximum-depth-of-binary-tree">104.二叉树的最大深度</a>
 * TODO 缺少深度优先遍历
 */
public class LeetCode104 {
    static class BFS {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int depth = 0;
            Queue<TreeNode> layerNodes = new LinkedList<>();
            layerNodes.add(root);
            while (!layerNodes.isEmpty()) {
                int layerNodeSize = layerNodes.size();
                while (layerNodeSize > 0) {
                    TreeNode node = layerNodes.poll();
                    if (node.left != null) {
                        layerNodes.add(node.left);
                    }
                    if (node.right != null) {
                        layerNodes.add(node.right);
                    }
                    layerNodeSize--;
                }
                depth++;
            }

            return depth;
        }
    }

    static class DFS {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
