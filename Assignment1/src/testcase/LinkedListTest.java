package testcase;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import LinkedListImplementation.LinkedList;


public class LinkedListTest {

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
		LinkedList LL=new LinkedList();
		LL.add(5);
		LL.add(19);
		LL.add(89);
		assertEquals(5,LL.topFront());
		assertEquals(89,LL.topBack());
		LL.display();
		assertEquals("LinkedList : [ 5 19 89 ]", Output.toString());
	}
	@Test
	public void test2() throws Exception {
		LinkedList LL1=new LinkedList();
		LL1.add(5);
		LL1.add(19);
		LL1.pushFront(89);
		LL1.pushBack(56); 
		assertEquals(89,LL1.topFront());
		assertEquals(56,LL1.topBack());
	}
	@Test(expected=Exception.class)
	public void test3() throws Throwable {
		LinkedList Temp=new LinkedList();
		Temp.add(5);
		Temp.add(19);
		Temp.popFront(); 
		Temp.pushFront(89);
		Temp.popFront();
		Temp.popFront();
		Temp.popFront();
	}
	@Test(expected=Exception.class)
	public void test4() throws Throwable {
		LinkedList Temp=new LinkedList();
		Temp.add(5);
		Temp.add(19);
		Temp.popFront(); 
		Temp.popFront();
		Temp.pushBack(6);
		Temp.popFront();
		Temp.pushFront(6);
		assertEquals(1,Temp.size());
		Temp.topFront();
		Temp.pushBack(0);
		Temp.popFront();
		Temp.popFront();
		Temp.topBack();
		
	}
}
 