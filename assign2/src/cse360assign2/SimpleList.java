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
	 * If the array is full, the size of the array is increased by
	 * 50% so that there will be room for the new element.
	 * 
	 * @param value The new element's value.
	 */
	public void add(int value) {
		int[] tempList = list.clone();
		
		if(count == list.length) {
			int[] temp = new int[(int) (list.length * 1.5)];
			for(int i = 0; i < list.length; i++) {
				temp[i] = list[i]; 
			}
			list = temp;
		}
		for(int index = 0; index < count; index++) {
			/** Stay in bounds of array */
			if(index != list.length - 1)
				list[index + 1] = tempList[index];
		}
		list[0] = value;
		count++;
	}
	
	/**
	 * Removes an element from this SimpleList.
	 * If the element does not exist, nothing is done.
	 * If the element does exist, it is removed, and the remaining
	 * elements are moved down as needed. 
	 * If the list has more than 25% empty places, the size of
	 * the list is decreased by 25%.
	 * List will always be able to hold at least one entry.
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
		
		if(size() != 1) {
			if(((double) (count)/ (double) (list.length))  < .75) {
				int newSize = (int) (list.length * .75);
				int[] temp = new int[newSize];
				for(int i = 0; i < newSize; i++) {
					temp[i] = list[i]; 
				}
				list = temp;
			}
		}
		
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
	
	/**
	 * Returns the first element in the list.
	 * If the list is empty, -1 is returned instead.
	 * 
	 * @return	First element in the list
	 * 			-1 if list is empty.
	 */
	public int first() {
		if(count == 0)
			return -1;
		return list[0];
	}
	
	/**
	 * Returns the last element in the list.
	 * If the list is empty, -1 is returned instead.
	 * 
	 * @return	Last element in the list
	 * 			-1 if the list is empty.
	 */
	public int last() {
		if(count == 0)
			return -1;
		return list[count - 1];
	}
	
	/**
	 * Returns the current number of possible
	 * locations in the list.
	 * 
	 * @return	Number of possible locations in the list.
	 */
	public int size() {
		return list.length;
	}
	
	/**
	 * Adds an element to this SimpleList and increments the count.
	 * Elements are added at the end of the array.
	 * If the array is full, the size of the array is increased by
	 * 50% so that there will be room for the new element.
	 * 
	 * @param value	The new element's value.
	 */
	public void append(int value) {
		if(count == list.length) {
			int[] temp = new int[(int) (list.length * 1.5)];
			for(int i = 0; i < list.length; i++) {
				temp[i] = list[i]; 
			}
			list = temp;
		}
		list[count] = value;
		count++;
	}
}
