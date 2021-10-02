package testcase;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import DequeueImplementation.Dequeue;



public class DeQueueTest {

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
		Dequeue DQ=new Dequeue(5);
		DQ.addLeft(2);
		DQ.addRight(3);
		DQ.addRight(4);
		DQ.addRight(5);
		DQ.addLeft(1);
		DQ.display();
		assertEquals("DeQueue : 2 1 5 4 3 ", Output.toString());
	}
	@Test
	public void test2() throws Exception {
		Dequeue DQ=new Dequeue(5);
		DQ.addLeft(2);
		DQ.addRight(3);
		DQ.addRight(4);
		DQ.addRight(5);
		DQ.addLeft(1);
		DQ.addLeft(3);
		DQ.addRight(4);
		DQ.display();
		assertEquals("DeQueue : 2 1 5 4 3 ", Output.toString());
	}
	@Test
	public void test3() throws Exception {
		Dequeue DQ=new Dequeue(3);
		DQ.addLeft(2);
		DQ.addLeft(4);
		DQ.addLeft(5);
		DQ.addLeft(7);
		DQ.display();
		assertEquals("DeQueue : 2 4 5 ", Output.toString());
	}
}
