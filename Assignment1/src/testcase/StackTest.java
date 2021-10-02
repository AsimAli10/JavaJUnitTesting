package testcase;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import StackImplementation.MyStack;

public class StackTest {

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
	@Test(expected=Exception.class)
	public void test1() throws Exception {
		MyStack MS = new MyStack(6);
		MS.push(5);
		MS.push(67);
		MS.push(56);
		MS.push(14);
		MS.push(00);
		MS.push(-99);
		MS.displayStack();
		assertEquals("Stack : [ 5 67 56 14 0 -99 ]", Output.toString());
		MS.push(-99);
	}
	@Test
	public void test2() throws Exception {
		MyStack MS = new MyStack(6);
		MS.push(5);
		MS.push(67);
		MS.pop();
		MS.push(56);
		MS.push(14);
		MS.pop();
		MS.push(00);
		MS.pop();
		MS.push(-99);
		MS.displayStack();
		assertEquals("Stack : [ 5 56 -99 ]", Output.toString());
	}
	@Test(expected=Exception.class)
	public void test3() throws Throwable {
		MyStack MS = new MyStack(6);
		MS.push(5);
		MS.push(67);
		MS.pop();
		MS.pop();
		MS.pop();
		assertEquals("Stack : [ 5 56 -99 ]", Output.toString());
		assertEquals(6,MS.top());
	}
	@Test(expected=Exception.class)
	public void test4() throws Throwable {
		MyStack MS = new MyStack(6);
		MS.push(5);
		MS.push(67);
		MS.pop();
		MS.push(68);
		MS.push(67);
		assertEquals(67, MS.top());
		assertEquals(3,MS.size());
		MS.pop();
		MS.pop();
		MS.pop();
		assertEquals(67, MS.top());
	}
}
