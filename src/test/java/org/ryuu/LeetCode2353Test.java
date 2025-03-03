package org.ryuu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeetCode2353Test {
    @Test
    void solution2() {
        LeetCode2353.Solution2.FoodRatings foodRatings = new LeetCode2353.Solution2.FoodRatings(
                new String[]{"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"},
                new String[]{"korean", "japanese", "japanese", "greek", "japanese", "korean"},
                new int[]{9, 12, 8, 15, 14, 7}
        );

        String highestRated = foodRatings.highestRated("korean");// 返回 "kimchi"
        assertEquals("kimchi", highestRated);

        highestRated = foodRatings.highestRated("japanese");// 返回 "ramen"
        assertEquals("ramen", highestRated);

        foodRatings.changeRating("sushi", 16); // "sushi" 现在评分变更为 16 。
        highestRated = foodRatings.highestRated("japanese"); // 返回 "sushi"
        assertEquals("sushi", highestRated);

        foodRatings.changeRating("ramen", 16); // "ramen" 现在评分变更为 16 。
        highestRated = foodRatings.highestRated("japanese"); // 返回 "ramen"
        assertEquals("ramen", highestRated);
    }
}
