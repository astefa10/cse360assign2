/**
 * Author: Anthony Stefano
 * Class ID: 116
 * Assignment 1
 * 
 * This file contains the SimpleList class.
 * 
 */

package cse360assign2;

import java.awt.print.Printable;
import java.text.BreakIterator;
import java.util.function.IntPredicate;


/**
 * 
 * @author Anthony
 * Represents a simple array capable of holding 10 integers.
 * Elements can be added to, removed from, and searched for in the array.
 * The elements in the array can be returned as a string.
 *
 */
public class SimpleList {
	
	private int[] list;
	private int count;
	
	
	/**
	 * Creates a new SimpleList with 0 elements.
	 */
	public SimpleList() {
		this.list = new int[10];
		this.count = 0;
	}
	
	/**
	 * Adds an element to this SimpleList and increments the count.
	 * Elements are added at the beginning of the array, with the current
	 * elements shifted to the right to make room.
	 * If the array is full, the last element is simply overwritten.
	 * 
	 * @param value The new element's value.
	 */
	public void add(int value) {
		int[] tempList = list.clone();
		
		for(int index = 0; index < count; index++) {
			/** Stay in bounds of array */
			if(index != 9)
				list[index + 1] = tempList[index];
		}
		list[0] = value;
		if(count != 10)
			count++;
	}
	
	/**
	 * Removes an element from this SimpleList.
	 * If the element does not exist, nothing is done.
	 * If the element does exist, it is removed, and the remaining
	 * elements are moved down as needed. 
	 * 
	 * @param value	The value of the element to be removed.
	 */
	public void remove(int value) {
		int[] tempList = list.clone();
		
		if(search(value) == -1)
			return;
		
		for(int index = search(value); index < count - 1; index++) {
			list[index] = tempList[index + 1];
		}
		
		if(count != 0)
			count--;
	}
	
	/**
	 * Returns the number of elements currently in the array.
	 * 
	 * @return	Number of values in array.
	 */
	public int count() {
		return count;
	}
	
	/**
	 * Returns this SimpleList as a String.
	 * The elements are separated by a space.
	 * 
	 * @return The elements in this SimpleList as a string.
	 */
	public String toString() {
		String listAsString = "";
		for(int index = 0; index < count; index++) {
			if(index == count - 1) 
				listAsString += String.valueOf(list[index]);
			else
				listAsString += String.valueOf(list[index]) + " ";
		}
		return listAsString;
	}
	
	/**
	 * Returns the index of the element in this SimpleList.
	 * If the element does not exist, -1 is returned instead.
	 * 
	 * @param value Value of element being searched for.
	 * @return		Index of the element.
	 * 				-1 if element is not in list.
	 */
	public int search(int value) {
		for(int index = 0; index < count; index++) {
			if(list[index] == value)
				return index;
		}
		return -1;
	}
}
