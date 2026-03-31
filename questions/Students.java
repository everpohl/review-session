package questions;

import common.ReviewSessionQuestions;
import itsc2214.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Student starter implementations for the review-session problems.
 * 
 * Each method matches the shared interface and is left unfinished on purpose
 * so students can complete the exercises during the session.
 * 
 * @author Everett
 * @version Mar 30, 2026
 */
@SuppressWarnings("unused")
public class Students implements ReviewSessionQuestions {

    /**
     * Return the sum of two nonnegative integers using recursion.
     *
     * You may use any recursive strategy that produces the correct result.
     * The returned value should match the result of {@code x + y}.
     * 
     * @param x a nonnegative integer
     * @param y a nonnegative integer
     * @return the sum of {@code x} and {@code y}
     */
    @Override
    public int add(int x, int y) {
        return //TODO: Implement;
    }

    /**
     * Recursively count how many times {@code substr} appears in {@code text}.
     *
     * Overlapping matches do count. For example, {@code "aa"} appears 3 times
     * in {@code "aaaa"}.
     *
     * You may assume {@code substr} is not empty.
     * 
     * @param text the text to search
     * @param substr the non-empty substring to count
     * @return the number of occurrences of {@code substr} in {@code text}
     */
    @Override
    public int countString(String text, String substr) {
        return //TODO: Implement;
    }

    /**
     * Return the list that remains after removing the first two nodes.
     *
     * If the list has 0 or 1 nodes, return {@code null}. Otherwise, return the
     * node that was originally third in the list.
     */
    @Override
    public <E> Node<E> removeFirst2(Node<E> elements) {
        return //TODO: Implement;
    }

    /**
     * Remove up to the first {@code n} values from the front of the queue.
     *
     * If {@code n} is 0, leave the queue unchanged. If {@code n} is larger
     * than the queue size, remove all values currently in the queue.
     */
    @Override
    public void removeFirstN(QueueADT<Integer> values, int n) {
        // TODO: Implement;
    }

    /**
     * Count duplicate entries in the list using a map-based approach.
     *
     * A duplicate is any repeated occurrence after the first appearance of a
     * word. For example, the list {@code ["a", "a", "a", "b", "b"]} contains
     * 3 duplicates.
     */
    @Override
    public int countDuplicates(List<String> words) {
        Map<String, Integer> theMap = new HashMap<String, Integer>();
        return //TODO: Implement;
    }

}
