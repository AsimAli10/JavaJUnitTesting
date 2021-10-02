package testcase;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import QueuewithLinkedList.Queue;

public class QueueWithLinkedListTest {

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
		Queue Q=new Queue();
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
		Queue Q=new Queue();
		Q.enqueue(0);
		Q.dequeue();
		Q.dequeue();
	    assertEquals("Empty queue.", Output.toString());
	}

}

