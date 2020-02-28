/**
 * Author: Anthony Stefano
 * Class ID: 116
 * Assignment 1
 * 
 * This file contains the Junit test cases used to test the SimpleList
 * class methods.
 */

package cse360assign2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.omg.CORBA.portable.RemarshalException;

import junit.framework.TestListener;

public class SimpleListTest {

	
	@Test
	void testSimpleList() {
		SimpleList testList = new SimpleList();
		assertNull (testList);
	}
	
	@Test
	void testSimpleList2() {
		SimpleList testList = new SimpleList();
		assertNotNull (testList);
	}
	
	@Test
	void testAddToEmptyList() {
		SimpleList testList = new SimpleList();
		testList.add(5);
		assertEquals(1, testList.count());
	}
	
	@Test
	void testAddToFullList() {
		SimpleList testList = new SimpleList();
		testList.add(1);
		testList.add(2);
		testList.add(3);
		testList.add(4);
		testList.add(5);
		testList.add(6);
		testList.add(7);
		testList.add(8);
		testList.add(9);
		testList.add(10);
		testList.add(11);
		assertEquals(11, testList.count());
	}

	@Test
	void testRemoveFromEmptyList() {
		SimpleList testList = new SimpleList();
		testList.remove(0);
		assertEquals(0, testList.count());
	}
	
	@Test
	void testRemoveElement() {
		SimpleList testList = new SimpleList();
		testList.add(5);
		testList.remove(5);
		assertEquals(0, testList.count());
	}
	
	@Test
	void testRemoveNonexistentElement() {
		SimpleList testList = new SimpleList();
		testList.add(5);
		testList.remove(10);
		assertEquals(0, testList.count());
	}
	
	@Test
	void testCountEmptyList() {
		SimpleList testList = new SimpleList();
		assertEquals (0, testList.count());
	}
	
	@Test
	void testCountEmptyList2() {
		SimpleList testList = new SimpleList();
		assertEquals (1, testList.count());
	}
	
	@Test 
	void testToStringEmptyList() {
		SimpleList testList = new SimpleList();
		assertEquals("", testList.toString());
	}
	
	@Test
	void testToStringSingleElement() {
		SimpleList testList = new SimpleList();
		testList.add(5);
		assertEquals("5", testList.toString());
	}
	
	@Test
	void testToStringMultipleElements() {
		SimpleList testList = new SimpleList();
		testList.add(5);
		testList.add(10);
		testList.add(20);
		assertEquals("20 10 5", testList.toString());
	}
	
	@Test
	void testToStringRepeatedElements() {
		SimpleList testList = new SimpleList();
		testList.add(5);
		testList.add(5);
		testList.add(5);
		assertEquals("5 5 5", testList.toString());
	}
	
	@Test
	void testToStringCorrectOrder() {
		SimpleList testList = new SimpleList();
		testList.add(5);
		testList.add(10);
		testList.add(20);
		assertEquals("5 10 20", testList.toString());
	}
	
	@Test
	void testToStringFullList() {
		SimpleList testList = new SimpleList();
		testList.add(1);
		testList.add(2);
		testList.add(3);
		testList.add(4);
		testList.add(5);
		testList.add(6);
		testList.add(7);
		testList.add(8);
		testList.add(9);
		testList.add(10);
		testList.add(11);
		assertEquals("11 10 9 8 7 6 5 4 3 2", testList.toString());
	}
	
	@Test
	void testToStringRemoveElement() {
		SimpleList testList = new SimpleList();
		testList.add(1);
		testList.add(2);
		testList.add(3);
		testList.add(4);
		testList.add(5);
		testList.remove(5);
		testList.add(6);
		testList.add(7);
		testList.add(8);
		testList.add(9);
		testList.add(10);
		testList.add(11);
		assertEquals("11 10 9 8 7 6 4 3 2 1", testList.toString());
	}
	
	@Test
	void testToStringMoveElements() {
		SimpleList testList = new SimpleList();
		testList.add(1);
		testList.add(2);
		testList.add(3);
		testList.add(4);
		testList.add(5);
		testList.remove(5);
		testList.add(6);
		testList.add(7);
		testList.add(8);
		testList.add(9);
		testList.add(10);
		testList.add(11);
		testList.remove(11);
		assertEquals("10 9 8 7 6 4 3 2 1", testList.toString());
	}
	
	@Test
	void testSearchMultipleElements() {
		SimpleList testList = new SimpleList();
		testList.add(5);
		testList.add(10);
		testList.add(20);
		assertEquals(2, testList.search(5));
	}
	
	@Test
	void testSearchNonexistentElement() {
		SimpleList testList = new SimpleList();
		testList.add(5);
		testList.add(10);
		testList.add(20);
		assertEquals(-1, testList.search(15));
	}
	
	@Test
	void testSearchEmptyList() {
		SimpleList testList = new SimpleList();
		assertEquals(-1, testList.search(5));
	}
	
	@Test
	void testSearchSingleElement() {
		SimpleList testList = new SimpleList();
		testList.add(5);
		assertEquals(1, testList.search(5));
	}
	
	@Test
	void testSearchRepeatingElements() {
		SimpleList testList = new SimpleList();
		testList.add(5);
		testList.add(5);
		testList.add(5);
		assertEquals(0, testList.search(5));
	}
	
	@Test
	void testFirstElementSingle() {
		SimpleList testList = new SimpleList();
		testList.add(5);
		assertEquals(5, testList.first());
	}
	
	@Test
	void testFirstElementMultiple() {
		SimpleList testList = new SimpleList();
		testList.add(5);
		testList.add(10);
		assertEquals(5, testList.first());
	}
	
	@Test
	void testFirstElementEmpty() {
		SimpleList testList = new SimpleList();
		assertEquals(-1, testList.first());
	}
	
	@Test 
	void testLastElementSingle() {
		SimpleList testList = new SimpleList();
		testList.add(5);
		assertEquals(5, testList.last());
	}
	
	@Test
	void testLastElementMultiple() {
		SimpleList testList = new SimpleList();
		testList.add(5);
		testList.add(10);
		assertEquals(10, testList.last());
	}
	
	@Test
	void testLastElementEmpty() {
		SimpleList testList = new SimpleList();
		assertEquals(-1, testList.last());
	}
	
	@Test
	void testResizeListAdd() {
		SimpleList testList = new SimpleList();
		testList.add(5);
		testList.add(10);
		testList.add(5);
		testList.add(10);
		testList.add(5);
		testList.add(10);
		testList.add(5);
		testList.add(10);
		testList.add(5);
		testList.add(10);
		testList.add(5);
		testList.add(10);
		testList.add(5);
		testList.add(10);
		testList.add(5);
		testList.add(10);
		assertEquals(22, testList.size());
	}
	
	@Test
	void testResizeListRemove() {
		SimpleList testList = new SimpleList();
		testList.add(5);
		testList.remove(5);
		assertEquals(7, testList.size());
	}
	
	@Test
	void testAppendEmptyList() {
		SimpleList testList = new SimpleList();
		testList.append(5);
		assertEquals(5, testList.last());
	}
	
	@Test
	void testAppendNonEmptyList() {
		SimpleList testList = new SimpleList();
		testList.add(5);
		testList.append(10);
		assertEquals(10, testList.last());
	}
	
	@Test
	void testResizeListAppend() {
		SimpleList testList = new SimpleList();
		testList.append(5);
		testList.append(10);
		testList.append(5);
		testList.append(10);
		testList.append(5);
		testList.append(10);
		testList.append(5);
		testList.append(10);
		testList.append(5);
		testList.append(10);
		testList.append(5);
		testList.append(10);
		testList.append(5);
		testList.append(10);
		testList.append(5);
		testList.append(10);
		assertEquals(22, testList.size());
	}
	
	@Test
	void testAppendFullList() {
		SimpleList testList = new SimpleList();
		testList.add(1);
		testList.add(2);
		testList.add(3);
		testList.add(4);
		testList.add(5);
		testList.add(6);
		testList.add(7);
		testList.add(8);
		testList.add(9);
		testList.add(10);
		testList.append(11);
		assertEquals(10, testList.search(11));
	}
	
	@Test
	void testResizeListMinimum() {
		SimpleList testList = new SimpleList();
		testList.add(5);
		testList.remove(5);
		testList.add(5);
		testList.remove(5);
		testList.add(5);
		testList.remove(5);
		testList.add(5);
		testList.remove(5);
		testList.add(5);
		testList.remove(5);
		testList.add(5);
		testList.remove(5);
		testList.add(5);
		testList.remove(5);
		assertEquals(1, testList.size());
	}

}
