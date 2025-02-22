package org.ryuu;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/valid-parentheses">20. 有效的括号</a>
 * <p>
 * # 思路
 * <p>
 * 根据题目要求可知，**最后出现的左括号必须先闭合**，这一特点符合 LIFO（后进先出）, 因此可使用栈
 * <p>
 * 具体地, 此问题使用的栈类型为辅助栈 (Auxiliary Stack), 用于辅助遍历
 * 辅助遍历: 在进行数据结构的遍历或者搜索时，辅助栈可以用于记录遍历过程中的一些信息，帮助完成遍历任务
 * <p>
 * # 复杂度
 * <p>
 * 时间复杂度:
 * 需要将输入的字符串遍历一遍
 * > $O(n)$
 * <p>
 * 空间复杂度:
 * 需要使用辅助栈记录需要出现的右括号
 * > $O(n)$
 * <p>
 * # 总结
 * 此题目考察了对于栈运用的敏感程度
 */
public class LeetCode20 {
    static class AuxiliaryStackWithMap {
        public boolean isValid(String s) {
            if (s.isEmpty()) {
                return true;
            }

            Map<Character, Character> characterMap = new HashMap<>();
            characterMap.put('(', ')');
            characterMap.put('[', ']');
            characterMap.put('{', '}');

            char[] chars = s.toCharArray();
            Stack<Character> rightChars = new Stack<>();
            Set<Character> leftChars = characterMap.keySet();
            for (char currChar : chars) {
                boolean isLeftChar = false;
                for (Character leftChar : leftChars) {
                    if (currChar != leftChar) {
                        continue;
                    }

                    Character rightChar = characterMap.get(leftChar);
                    rightChars.push(rightChar);
                    isLeftChar = true;
                    break;
                }

                if (isLeftChar) {
                    continue;
                }

                if (rightChars.empty() || currChar != rightChars.pop()) {
                    return false;
                }
            }

            return rightChars.empty();
        }
    }

    static class AuxiliaryStackWithoutMap {
        public boolean isValid(String s) {
            if (s.isEmpty()) {
                return true;
            }

            Stack<Character> rightChars = new Stack<>();
            for (char currChar : s.toCharArray()) {
                switch (currChar) {
                    case '(':
                        rightChars.push(')');
                        break;
                    case '{':
                        rightChars.push('}');
                        break;
                    case '[':
                        rightChars.push(']');
                        break;
                    default:
                        if (rightChars.empty() || currChar != rightChars.pop()) {
                            return false;
                        }
                }
            }
            return rightChars.empty();
        }
    }
}
