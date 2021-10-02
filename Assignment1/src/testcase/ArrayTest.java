package testcase;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import FullArray.Array;


public class ArrayTest {

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
	public void Test1() {
		Array AD=new Array();
		for (int i = 0; i < 5; i++) 
		{
			  AD.insert(6, i);
			  //AD.display();
		}
		AD.display();
	    assertEquals("6 6 6 6 6 ", Output.toString());
	}
	@Test
	public void Test2() {
		Array ADD=new Array();
		ADD.insert(6,0);
		ADD.insert(15,1);
		ADD.insert(56,2);
		ADD.insert(0,3);
		ADD.insert(99,4);
		ADD.insert(-7,5);
		ADD.insert(-6,6);
		ADD.bubbleSort();
		ADD.delete(0);
	    assertTrue(ADD.linearSearch(99));
	    assertFalse(ADD.linearSearch(-7));    
	}
	@Test
	public void Test3() {
		Array ADD=new Array();
		ADD.insert(6,0);
		ADD.insert(15,1);
		ADD.insert(56,2);
		ADD.insert(0,3);
		ADD.insert(99,4);
		ADD.insert(-7,5);
		ADD.insert(-6,6);
		ADD.bubbleSort();
		ADD.delete(0);
		ADD.display();
	    assertEquals("-6 0 6 15 56 99 ", Output.toString());
	}
	@Test
	public void Test4() {
		Array ADD=new Array();
		ADD.insert(6,0);
		ADD.insert(15,1);
		ADD.insert(56,2);
		ADD.insert(0,3);
		ADD.insert(99,4);
		ADD.insert(-7,5);
		ADD.insert(-6,6);
		ADD.delete(0);
	    assertTrue(ADD.binarySearch(56, 0, 7));
	}
	@Test
	public void Test5() {
		Array ADD=new Array();
		for(int i=0; i < 100;i++)
		{
			if(i%2==0)
				ADD.insert(i+1, i);
			else
				ADD.insert(i*2, i);
		}
	    assertTrue(ADD.binarySearch(2, 0, 100));
	}
}

