package testcase;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.internal.MethodSorter;

import LinkedListSwapNodes.LinkedList;

//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LinkedListSwapTest {

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
		LinkedList CLL=new LinkedList();
		CLL.pushFront(5);
		CLL.pushFront(8);
		CLL.pushBack(45);
		CLL.swap();
		CLL.display();
		assertEquals("List : 45 5 8 ", Output.toString());
	}
	@Test
	public void test2() {
		LinkedList CLL=new LinkedList();
		CLL.pushFront(5);
		CLL.pushFront(8);  
		CLL.pushBack(45);
		CLL.pushFront(7);
		CLL.swap();
		CLL.display();
		assertEquals("List : 45 8 5 7 ", Output.toString());
		
	}

}
