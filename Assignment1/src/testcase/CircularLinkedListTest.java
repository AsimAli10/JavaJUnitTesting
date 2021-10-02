package testcase;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import CircularLinkedList.CircularLinkedList;


public class CircularLinkedListTest {

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
	public void test1() {
		CircularLinkedList CLL=new CircularLinkedList();
		CLL.pushFront(5);
		CLL.pushBack(6);
		CLL.pushFront(8);
		CLL.pushBack(45);
		CLL.display();
		assertEquals("List : 8 5 6 45", Output.toString());
	}
	@Test
	public void test2() {
		CircularLinkedList CLL=new CircularLinkedList();
		CLL.pushBack(6);
		CLL.pushFront(5);
		CLL.pushFront(8);  
		CLL.pushBack(45);
		CLL.popBack();
		CLL.pushFront(7);
		CLL.popFront();
		CLL.popBack();
		CLL.popFront();
		CLL.popFront();
		CLL.popFront();
		CLL.display();
		assertEquals("List : Empty List.", Output.toString());
		
	}
	@Test
	public void test3() {
		CircularLinkedList CLL=new CircularLinkedList();
		CLL.pushBack(6);
		CLL.pushFront(5);
		CLL.popBack();
		CLL.popBack();
		CLL.popBack();
		CLL.display();
		assertEquals("List : Empty List.", Output.toString());
		
	}

}
