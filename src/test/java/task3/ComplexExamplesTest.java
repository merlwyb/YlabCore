package task3;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static task3.ComplexExamples.Person;


public class ComplexExamplesTest {

    @Test
    public void sortDataAndGetMap() {
        Person[] data = new Person[]{
                new Person(0, "Harry"),
                new Person(1, "John"),
                new Person(2, "Emily"),
        };
        Map<String, Long> expected = ComplexExamples.sortDataAndGetMap(data);

        Map<String, Long> actual = new HashMap<>();
        actual.put("Harry", 1L);
        actual.put("John", 1L);
        actual.put("Emily", 1L);

        assertEquals(expected, actual);
    }

    @Test
    public void sortDataAndGetMap_SAME_NAME() {
        Person[] data = new Person[]{
                new Person(0, "Harry"),
                new Person(1, "Harry"),
                new Person(2, "Emily"),
        };
        Map<String, Long> expected = ComplexExamples.sortDataAndGetMap(data);

        Map<String, Long> actual = new HashMap<>();
        actual.put("Harry", 2L);
        actual.put("Emily", 1L);

        assertEquals(expected, actual);
    }

    @Test
    public void sortDataAndGetMap_SAME_ID() {
        Person[] data = new Person[]{
                new Person(1, "Harry"),
                new Person(1, "John"),
                new Person(3, "Emily"),
        };
        Map<String, Long> expected = ComplexExamples.sortDataAndGetMap(data);

        Map<String, Long> actual = new HashMap<>();
        actual.put("Harry", 1L);
        actual.put("John", 1L);
        actual.put("Emily", 1L);

        assertEquals(expected, actual);
    }

    @Test
    public void sortDataAndGetMap_SAME_ID_AND_NAME() {
        Person[] data = new Person[]{
                new Person(1, "Harry"),
                new Person(1, "Harry"),
                new Person(2, "Emily"),
        };
        Map<String, Long> expected = ComplexExamples.sortDataAndGetMap(data);

        Map<String, Long> actual = new HashMap<>();
        actual.put("Harry", 1L);
        actual.put("Emily", 1L);

        assertEquals(expected, actual);
    }

    @Test
    public void sortDataAndGetMap_NULL() {
        Person[] data = new Person[]{
                null,
                new Person(0, "Harry"),
                null
        };
        Map<String, Long> expected = ComplexExamples.sortDataAndGetMap(data);

        Map<String, Long> actual = new HashMap<>();
        actual.put("Harry", 1L);

        assertEquals(expected, actual);
    }

    @Test
    public void getSumNumbers() {
        int[] ints = new int[]{3, 4, 2, 7, 7, 9, 1};
        int[] expected = ComplexExamples.getSumNumbers(ints, 9);

        assertArrayEquals(expected, new int[]{2,7});
    }

    @Test
    public void getSumNumbers_NO_NUMBERS() {
        int[] ints = new int[]{3, 4, 2, 7, 7, 9, 1};
        int[] expected = ComplexExamples.getSumNumbers(ints, 100);

        assertArrayEquals(expected, new int[0]);
    }

    @Test
    public void getSumNumbers_NULL() {
        int[] expected = ComplexExamples.getSumNumbers(null, 1);

        assertArrayEquals(expected, new int[0]);
    }

    @Test
    public void getSumNumbers_EMPTY_ARRAY() {
        int[] ints = new int[]{};
        int[] expected = ComplexExamples.getSumNumbers(ints, 9);

        assertArrayEquals(expected, new int[]{});
    }

    @Test
    public void fuzzySearch() {
        assertTrue(ComplexExamples.fuzzySearch("b", "abc"));
        assertTrue(ComplexExamples.fuzzySearch("abc", "aaaaaabbbbbccccc"));
        assertTrue(ComplexExamples.fuzzySearch("abc", "a_84^*$!b*%&(c"));
        assertTrue(ComplexExamples.fuzzySearch("", "abc"));

        assertFalse(ComplexExamples.fuzzySearch("cba", "abc"));
        assertFalse(ComplexExamples.fuzzySearch("abc", "ab"));
        assertFalse(ComplexExamples.fuzzySearch("abc", null));
        assertFalse(ComplexExamples.fuzzySearch(null, "abc"));
        assertFalse(ComplexExamples.fuzzySearch(null, null));
    }
}