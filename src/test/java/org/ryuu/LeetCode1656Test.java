package org.ryuu;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LeetCode1656Test {
    @Test
    public void solution1() {
        LeetCode1656.Solution1.OrderedStream orderedStream = new LeetCode1656.Solution1.OrderedStream(5);
        List<String> l1 = orderedStream.insert(3, "ccccc");
        assertEquals(Collections.emptyList(), l1);
        List<String> l2 = orderedStream.insert(1, "aaaaa");
        assertEquals(Collections.singletonList("aaaaa"), l2);
        List<String> l3 = orderedStream.insert(2, "bbbbb");
        assertEquals(Arrays.asList("bbbbb", "ccccc"), l3);
        List<String> l4 = orderedStream.insert(5, "eeeee");
        assertEquals(Collections.emptyList(), l4);
        List<String> l5 = orderedStream.insert(4, "ddddd");
        assertEquals(Arrays.asList("ddddd", "eeeee"), l5);
    }

    @Test
    public void solution2() {
        LeetCode1656.Solution2.OrderedStream orderedStream = new LeetCode1656.Solution2.OrderedStream(5);
        List<String> l1 = orderedStream.insert(3, "ccccc");
        assertEquals(Collections.emptyList(), l1);
        List<String> l2 = orderedStream.insert(1, "aaaaa");
        assertEquals(Collections.singletonList("aaaaa"), l2);
        List<String> l3 = orderedStream.insert(2, "bbbbb");
        assertEquals(Arrays.asList("bbbbb", "ccccc"), l3);
        List<String> l4 = orderedStream.insert(5, "eeeee");
        assertEquals(Collections.emptyList(), l4);
        List<String> l5 = orderedStream.insert(4, "ddddd");
        assertEquals(Arrays.asList("ddddd", "eeeee"), l5);
    }
}
