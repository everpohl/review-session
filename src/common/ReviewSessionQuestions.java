package common;

import java.util.List;
import itsc2214.Node;
import itsc2214.QueueADT;

/**
 * Shared contract for the review-session problems.
 *
 * Both the student starter code and the answer key should implement the same
 * method signatures so they stay aligned throughout the session.
 *
 * @author Everett
 * @version Mar 30, 2026
 */
public interface ReviewSessionQuestions {

    /**
     * Returns the sum of two nonnegative integers using recursion.
     *
     * Students may choose any recursive strategy that produces the correct
     * result. The method should return the same value as the expression
     * {@code x + y}.
     *
     * @param x a nonnegative integer
     * @param y a nonnegative integer
     * @return the sum of {@code x} and {@code y}
     */
    int add(int x, int y);

    /**
     * Recursively counts how many times {@code substr} appears in {@code text}.
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
    int countString(String text, String substr);

    /**
     * Returns the list that remains after removing the first two nodes.
     *
     * If the list has 0 or 1 nodes, return {@code null}. Otherwise, return the
     * node that was originally third in the list.
     *
     * @param elements the head of the input list
     * @param <E> the element type stored in the nodes
     * @return the head of the shortened list, or {@code null} when fewer than
     *         two nodes are present
     */
    <E> Node<E> removeFirst2(Node<E> elements);

    /**
     * Removes up to the first {@code n} values from the front of the queue.
     *
     * If {@code n} is 0, the queue should be unchanged. If {@code n} is larger
     * than the queue size, remove all values currently in the queue.
     *
     * @param values the queue to mutate
     * @param n the number of front values to remove; assume {@code n >= 0}
     */
    void removeFirstN(QueueADT<Integer> values, int n);

    /**
     * Counts duplicate entries in a list of words using a map-based approach.
     *
     * A duplicate is any repeated occurrence after the first appearance of a
     * word. For example, the list {@code ["a", "a", "a", "b", "b"]} contains
     * 3 duplicates.
     *
     * @param words the words to analyze
     * @return the number of repeated occurrences past the first
     */
    int countDuplicates(List<String> words);
}
