package common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

import itsc2214.Node;
import itsc2214.QueueADT;
import itsc2214.QueueNode;

/**
 * Shared behavioral tests for both the student starter and the instructor
 * answer key implementations.
 */
public abstract class ReviewSessionTestBase {

    protected abstract ReviewSessionQuestions makeSubject();

    @Test
    public void addReturnsTheOtherValueWhenOneInputIsZero() {
        ReviewSessionQuestions subject = makeSubject();

        assertEquals(7, subject.add(0, 7));
        assertEquals(12, subject.add(12, 0));
    }

    @Test
    public void addReturnsTheSumForPositiveInputs() {
        ReviewSessionQuestions subject = makeSubject();

        assertEquals(13, subject.add(4, 9));
        assertEquals(579, subject.add(123, 456));
    }

    @Test
    public void countStringReturnsZeroWhenTextIsTooShort() {
        ReviewSessionQuestions subject = makeSubject();

        assertEquals(0, subject.countString("cat", "cats"));
    }

    @Test
    public void countStringCountsSingleCharacterMatches() {
        ReviewSessionQuestions subject = makeSubject();

        assertEquals(4, subject.countString("banana", "a"));
    }

    @Test
    public void countStringCountsOverlappingMatches() {
        ReviewSessionQuestions subject = makeSubject();

        assertEquals(3, subject.countString("ababa", "aba"));
        assertEquals(3, subject.countString("aaaa", "aa"));
    }

    @Test
    public void removeFirst2ReturnsNullForEmptyList() {
        ReviewSessionQuestions subject = makeSubject();

        assertNull(subject.removeFirst2(null));
    }

    @Test
    public void removeFirst2ReturnsNullWhenListHasFewerThanTwoNodes() {
        ReviewSessionQuestions subject = makeSubject();
        Node<String> single = chain("only");

        assertNull(subject.removeFirst2(single));
    }

    @Test
    public void removeFirst2ReturnsTheThirdNodeWhenPresent() {
        ReviewSessionQuestions subject = makeSubject();
        Node<Integer> third = new Node<Integer>(3, new Node<Integer>(4));
        Node<Integer> head = new Node<Integer>(1, new Node<Integer>(2, third));

        Node<Integer> result = subject.removeFirst2(head);

        assertSame(third, result);
        assertEquals(Integer.valueOf(3), result.getData());
        assertEquals(Integer.valueOf(4), result.getNext().getData());
    }

    @Test
    public void removeFirstNLeavesQueueUnchangedWhenNIsZero() {
        ReviewSessionQuestions subject = makeSubject();
        QueueADT<Integer> queue = queueOf(10, 20, 30);

        subject.removeFirstN(queue, 0);

        assertQueueContents(queue, 10, 20, 30);
    }

    @Test
    public void removeFirstNRemovesOnlyTheRequestedPrefix() {
        ReviewSessionQuestions subject = makeSubject();
        QueueADT<Integer> queue = queueOf(1, 2, 3, 4, 5);

        subject.removeFirstN(queue, 2);

        assertQueueContents(queue, 3, 4, 5);
    }

    @Test
    public void removeFirstNCanEmptyTheQueue() {
        ReviewSessionQuestions subject = makeSubject();
        QueueADT<Integer> queue = queueOf(8, 9);

        subject.removeFirstN(queue, 2);

        assertTrue(queue.size() == 0);
    }

    @Test
    public void removeFirstNStopsCleanlyWhenNExceedsTheQueueSize() {
        ReviewSessionQuestions subject = makeSubject();
        QueueADT<Integer> queue = queueOf(4, 5);

        subject.removeFirstN(queue, 10);

        assertTrue(queue.size() == 0);
    }

    @Test
    public void countDuplicatesReturnsZeroWhenAllWordsAreUnique() {
        ReviewSessionQuestions subject = makeSubject();

        assertEquals(0, subject.countDuplicates(Arrays.asList("red", "blue", "green")));
    }

    @Test
    public void countDuplicatesReturnsTheNumberOfRepeatedEntriesPastTheFirst() {
        ReviewSessionQuestions subject = makeSubject();

        assertEquals(3, subject.countDuplicates(
                Arrays.asList("apple", "apple", "banana", "banana", "banana", "pear")));
    }

    @Test
    public void countDuplicatesTreatsAnEmptyListAsHavingNoDuplicates() {
        ReviewSessionQuestions subject = makeSubject();

        assertEquals(0, subject.countDuplicates(Collections.<String>emptyList()));
    }

    protected static <E> Node<E> chain(E... values) {
        Node<E> head = null;

        for (int i = values.length - 1; i >= 0; i--) {
            head = new Node<E>(values[i], head);
        }

        return head;
    }

    protected static QueueADT<Integer> queueOf(Integer... values) {
        QueueADT<Integer> queue = new QueueNode<Integer>();

        for (Integer value : values) {
            queue.enqueue(value);
        }

        return queue;
    }

    protected static void assertQueueContents(QueueADT<Integer> queue, Integer... expected) {
        assertEquals(expected.length, queue.size());

        for (Integer value : expected) {
            assertFalse(queue.size() == 0);
            assertEquals(value, queue.dequeue());
        }

        assertTrue(queue.size() == 0);
    }
}
