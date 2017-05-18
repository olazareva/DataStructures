package ua.lazareva.datastructures.queue;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedQueueTest {
    private LinkedQueue queueWithFiveElements = new LinkedQueue();
    private LinkedQueue queueWithOneElement = new LinkedQueue();
    private LinkedQueue queueWithoutElements = new LinkedQueue();

    @Before
    @SuppressWarnings("unchecked")
    public void before() {
        queueWithFiveElements.push(1);
        queueWithFiveElements.push(2);
        queueWithFiveElements.push(3);
        queueWithFiveElements.push(4);
        queueWithFiveElements.push(5);

        queueWithOneElement.push("The one element in queue");
    }

    @Test
    public void testGetSize() {
        assertEquals(5, queueWithFiveElements.getSize());
        assertEquals(1, queueWithOneElement.getSize());
        assertEquals(0, queueWithoutElements.getSize());
    }

    @Test(expected = IllegalArgumentException.class)
    @SuppressWarnings("unchecked")
    public void testPushNullValue() {
        queueWithOneElement.push("");
            }

    @Test(expected = RuntimeException.class)
    @SuppressWarnings("unchecked")
    public void testPushOverMaxSize() {
        queueWithFiveElements.push(6);
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testExtendMaxSizeAndPush() {
        queueWithFiveElements.setMaxQueueSize(queueWithFiveElements.getMaxQueueSize()+1);
        queueWithFiveElements.push(6);
        assertEquals(6, queueWithFiveElements.getSize());
    }


    @Test
    public void testPeekFromQueueWithElements() {
        assertEquals(1, queueWithFiveElements.peek());
        assertEquals(5, queueWithFiveElements.getSize());

        assertEquals("The one element in queue", queueWithOneElement.peek());
        assertEquals(1, queueWithOneElement.getSize());

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testPeekFromEmptyQueue() {
        queueWithoutElements.peek();
    }


    @Test
    public void testPollFromQueueWithElements() {
        assertEquals(1, queueWithFiveElements.poll());
        assertEquals(2, queueWithFiveElements.poll());
        assertEquals(3, queueWithFiveElements.poll());
        assertEquals(4, queueWithFiveElements.poll());
        assertEquals(5, queueWithFiveElements.poll());
        assertEquals(0, queueWithFiveElements.getSize());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testPollFromEmptyQueue() {
        queueWithoutElements.poll();
    }
}