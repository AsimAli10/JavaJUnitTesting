package testcase;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import QueueImplementation.Queue;

public class QueueTest {

	private final ByteArrayOutputStream Output = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;	
	//	For Checking the console output
	@Before
	public void setUpStreams() { 
		System.setOut(new PrintStream(Output));
	}
	@After 
	public void restoreStreams() {
		System.setOut(originalOut);
	}
	@Test
	public void test1() throws Exception {
		Queue Q=new Queue(5);
		Q.enqueue(5);
		Q.enqueue(-1);
		Q.dequeue();
		Q.enqueue(90);
		Q.enqueue(0);
		Q.display();
	    assertEquals("Queue : -1 90 0 ", Output.toString());
	}
	@Test
	public void test2() throws Exception {
		Queue Q=new Queue(5);
		Q.enqueue(0);
		Q.dequeue();
		Q.display();
	    assertEquals("Empty Queue.", Output.toString());
	    assertEquals(0, Q.size());
	}
	@Test
	public void test3() throws Exception {
		Queue Q=new Queue(1);
		Q.enqueue(0);
		Q.dequeue();
		Q.display();
	    assertEquals("Empty Queue.", Output.toString());
	    assertEquals(0, Q.size());
	}
	@Test(expected=Exception.class)
	public void test4() throws Exception {
		Queue Q=new Queue(1);
		Q.enqueue(0);
		Q.enqueue(6);
	}
	@Test(expected=Exception.class)
	public void test5() throws Exception {
		Queue Q=new Queue(2);
		Q.enqueue(0);
		assertFalse(Q.empty());
		Q.dequeue();
		Q.enqueue(6);
		Q.dequeue();
		assertTrue(Q.empty());
		Q.dequeue();
		
	}
	@Test(expected=Exception.class)
	public void test6() throws Exception {
		Queue Q=new Queue(2);
		Q.enqueue(0);
		Q.enqueue(6);
		Q.dequeue();
		Q.enqueue(8);
		Q.enqueue(6);
		
	}

}
