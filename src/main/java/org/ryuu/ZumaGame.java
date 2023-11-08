package org.ryuu;

import lombok.AllArgsConstructor;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/zuma-game/description/">488. 祖玛游戏</a>
 */
public class ZumaGame {
    public static int findMinStep(String board, String hand) {
        char[] arr = hand.toCharArray();
        Arrays.sort(arr);
        hand = new String(arr);

        // 初始化用队列维护的状态队列：其中的三个元素分别为桌面球状态、手中球状态和回合数
        State initState = new State(board, hand, 0);
        Deque<State> stateDeque = new ArrayDeque<>();
        stateDeque.offer(initState);

        // 初始化用哈希集合维护的已访问过的状态
        Set<String> visited = new HashSet<>();
        visited.add(initState.board + " " + initState.hand);

        while (!stateDeque.isEmpty()) {
            State state = stateDeque.poll();
            String curBoard = state.board;
            String curHand = state.hand;
            int step = state.step;
            for (int i = 0; i <= curBoard.length(); ++i) {
                for (int j = 0; j < curHand.length(); ++j) {
                    //region 剪枝
                    //region 第 1 个剪枝条件: hand 当前球的颜色和上一个球的颜色相同
                    if (j > 0 && curHand.charAt(j) == curHand.charAt(j - 1)) {
                        continue;
                    }
                    //endregion
                    //region 第 2 个剪枝条件: 仅在 board 连续相同颜色的球的开头位置插入新球
                    if (i > 0 && curBoard.charAt(i - 1) == curHand.charAt(j)) {
                        continue;
                    }
                    //endregion
                    //region 第 3 个剪枝条件: 只在以下两种情况放置新球
                    boolean shoot = false;
                    //region - 第 1 种情况 : 当前球颜色与后面的球的颜色相同
                    if (
                            i < curBoard.length() &&
                                    curBoard.charAt(i) == curHand.charAt(j)
                    ) {
                        shoot = true;
                    }
                    //endregion
                    //region - 第 2 种情况 : board 前后球颜色相同，但与 hand 的球颜色不同
                    if (
                            i > 0 &&
                                    i < curBoard.length() &&
                                    curBoard.charAt(i - 1) == curBoard.charAt(i) &&
                                    curBoard.charAt(i - 1) != curHand.charAt(j)
                    ) {
                        shoot = true;
                    }
                    //endregion
                    if (!shoot) {
                        continue;
                    }
                    //endregion
                    //endregion

                    String newBoard = clean(curBoard.substring(0, i) + curHand.charAt(j) + curBoard.substring(i));
                    String newHand = curHand.substring(0, j) + curHand.substring(j + 1);
                    if (newBoard.length() == 0) {
                        return step + 1;
                    }

                    String str = newBoard + " " + newHand;
                    if (visited.add(str)) {
                        stateDeque.offer(new State(newBoard, newHand, step + 1));
                    }
                }
            }
        }
        return -1;
    }

    @SuppressWarnings("DataFlowIssue")
    static String clean(String s) {
        Deque<Character> letterDeque = new ArrayDeque<>();
        Deque<Integer> countDeque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //region 消除球
            if (
                    !letterDeque.isEmpty() &&
                            c != letterDeque.peekLast() &&
                            countDeque.peekLast() >= 3
            ) {
                letterDeque.pollLast();
                countDeque.pollLast();
            }
            //endregion
            //region 更新连续字符和数量记录队列
            if (letterDeque.isEmpty() || c != letterDeque.peekLast()) {
                letterDeque.offerLast(c);
                countDeque.offerLast(1);
            } else if (c == letterDeque.peekLast()) {
                countDeque.offerLast(countDeque.pollLast() + 1);
            }
            //endregion
        }
        //region 消除球 (针对全场仅剩三个同色球的情况)
        if (!letterDeque.isEmpty() && countDeque.peekLast() >= 3) {
            letterDeque.pollLast();
            countDeque.pollLast();
        }
        //endregion
        //region 构建结果
        StringBuilder stringBuilder = new StringBuilder();
        while (!letterDeque.isEmpty()) {
            char c = letterDeque.pollFirst();
            int count = countDeque.pollFirst();
            for (int i = 0; i < count; i++) {
                stringBuilder.append(c);
            }
        }
        //endregion
        return stringBuilder.toString();
    }
}

@AllArgsConstructor
class State {
    final String board;
    final String hand;
    final int step;
}
