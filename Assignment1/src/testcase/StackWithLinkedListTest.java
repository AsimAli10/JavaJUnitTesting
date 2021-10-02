package testcase;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import StackwithLinkedList.Stack;

public class StackWithLinkedListTest {

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
		Stack MS = new Stack();
		MS.push(5);
		MS.push(67);
		MS.push(56);
		MS.push(14);
		MS.push(00);
		MS.push(-99);
		MS.display();
		assertEquals("Stack : [ -99 0 14 56 67 5 ]", Output.toString());
		MS.push(-99);
	}
	@Test
	public void test2() throws Exception {
		Stack MS = new Stack();
		MS.push(5);
		MS.push(67);
		MS.pop();
		MS.push(56);
		MS.push(14);
		MS.pop();
		MS.push(00);
		MS.pop();
		MS.push(-99);
		MS.display();
		assertEquals("Stack : [ -99 56 5 ]", Output.toString());
	}
	@Test
	public void test3() throws Throwable {
		Stack MS = new Stack();
		MS.push(5);
		MS.push(67);
		MS.pop();
		assertEquals(5,MS.pop());
		MS.pop();
		assertEquals("Empty Stack.", Output.toString());
	}
	@Test
	public void test4() throws Throwable {
		Stack MS = new Stack();
		MS.push(5);
		MS.push(67);
		MS.pop();
		MS.push(68);
		MS.push(67);
		assertEquals(67, MS.top());
		assertEquals(3,MS.getSize());
		MS.pop();
		MS.pop();
		MS.pop();
		assertEquals(-1, MS.top());
	}
}
