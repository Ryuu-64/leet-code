package org.ryuu;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/design-a-food-rating-system/"></a>
 */
public class LeetCode2353 {
    /**
     * 有序集合
     */
    public static class Solution1 {
        public static class FoodRatings {
            private static final Comparator<Pair<Integer, String>> RATTING_FOOD_COMPARATOR =
                    (a, b) ->
                            !Objects.equals(a.getKey(), b.getKey()) ?
                                    b.getKey() - a.getKey() :
                                    a.getValue().compareTo(b.getValue());

            private final Map<String, Pair<Integer, String>> foodMap = new HashMap<>();
            private final Map<String, TreeSet<Pair<Integer, String>>> cuisineMap = new HashMap<>();

            public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
                for (int i = 0; i < foods.length; i++) {
                    String food = foods[i];
                    String cuisine = cuisines[i];
                    int rating = ratings[i];
                    foodMap.put(food, new ImmutablePair<>(rating, cuisine));
                    cuisineMap.computeIfAbsent(
                            cuisine, k -> new TreeSet<>(RATTING_FOOD_COMPARATOR)
                    ).add(
                            new ImmutablePair<>(rating, food)
                    );
                }
            }

            public void changeRating(String food, int newRating) {
                Pair<Integer, String> ratingCuisine = foodMap.get(food);
                String cuisine = ratingCuisine.getValue();
                Set<Pair<Integer, String>> ratingFood = cuisineMap.get(cuisine);
                int ratting = ratingCuisine.getKey();
                ratingFood.remove(new ImmutablePair<>(ratting, food));
                ratingFood.add(new ImmutablePair<>(newRating, food));
                foodMap.put(food, new ImmutablePair<>(newRating, cuisine));
            }

            public String highestRated(String cuisine) {
                return cuisineMap.get(cuisine).first().getValue();
            }
        }
    }

    /**
     * 懒删除堆
     */
    public static class Solution2 {
        public static class FoodRatings {
            private static final Comparator<Pair<Integer, String>> CUISINE_COMPARATOR =
                    (a, b) ->
                            !Objects.equals(a.getKey(), b.getKey()) ?
                                    b.getKey() - a.getKey() :
                                    a.getValue().compareTo(b.getValue());
            private final Map<String, Pair<Integer, String>> foodMap = new HashMap<>();
            private final Map<String, PriorityQueue<Pair<Integer, String>>> cuisineMap = new HashMap<>();

            public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
                for (int i = 0; i < foods.length; i++) {
                    String food = foods[i];
                    String cuisine = cuisines[i];
                    int rating = ratings[i];
                    foodMap.put(food, new ImmutablePair<>(rating, cuisine));
                    cuisineMap.computeIfAbsent(
                            cuisine, k -> new PriorityQueue<>(CUISINE_COMPARATOR)
                    ).offer(
                            new ImmutablePair<>(rating, food)
                    );
                }
            }

            public void changeRating(String food, int newRating) {
                String cuisine = foodMap.get(food).getValue();
                cuisineMap.get(cuisine).offer(new ImmutablePair<>(newRating, food));
                foodMap.put(food, new ImmutablePair<>(newRating, cuisine));
            }

            public String highestRated(String cuisine) {
                PriorityQueue<Pair<Integer, String>> cuisineQueue = cuisineMap.get(cuisine);
                while (true) {
                    Pair<Integer, String> rattingFood = cuisineQueue.peek();
                    if (rattingFood == null) {
                        throw new IllegalStateException();
                    }

                    int rattingFromCuisine = rattingFood.getKey();
                    String food = rattingFood.getValue();
                    Pair<Integer, String> rattingCuisine = foodMap.get(food);
                    int rattingFromFood = rattingCuisine.getKey();
                    if (Objects.equals(rattingFromCuisine, rattingFromFood)) {
                        break;
                    }

                    cuisineQueue.poll();
                }

                Pair<Integer, String> rattingFood = cuisineQueue.peek();
                if (rattingFood == null) {
                    throw new IllegalStateException();
                }

                return rattingFood.getValue();
            }
        }
    }
}
