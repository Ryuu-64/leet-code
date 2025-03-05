package org.ryuu;

import java.util.*;

/**
 * <a href=""></a>
 */
public class LeetCode380 {
    public static class Solution1 {
        public static class RandomizedSet {
            private final Random random = new Random();
            private final Map<Integer, Integer> valueIndexMap = new HashMap<>();
            private final List<Integer> randoms = new ArrayList<>();

            public RandomizedSet() {
            }

            public boolean insert(int val) {
                if (valueIndexMap.containsKey(val)) {
                    return false;
                }

                int index = randoms.size();
                valueIndexMap.put(val, index);
                randoms.add(val);
                return true;
            }

            public boolean remove(int val) {
                if (!valueIndexMap.containsKey(val)) {
                    return false;
                }

                int lastIndex = randoms.size() - 1;
                int lastValue = randoms.get(lastIndex);

                int index = valueIndexMap.get(val);
                valueIndexMap.put(lastValue, index);
                randoms.set(index, lastValue);

                randoms.remove(lastIndex);
                valueIndexMap.remove(val);
                return true;
            }

            public int getRandom() {
                int size = randoms.size();
                int index = random.nextInt(size);
                return randoms.get(index);
            }
        }
    }
}
