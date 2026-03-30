package common;

import java.util.List;
import java.util.Map;
import java.util.Queue;

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

    int recursiveSequence(int n);

    boolean isSpecialString(String text);

    String reverseWithStack(String text);

    void cycleQueue(Queue<Integer> values, int positions);

    Map<String, Integer> countStrings(List<String> words);
}
