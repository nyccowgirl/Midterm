package Midterm;

import java.util.*;

public class MidtermExamTester {

	public static void main(String[] args) {
		System.out.println("******************************* TESTING LINKEDBAG DOUBLE METHOD *******************************");
		// parameter 1: the contents of the bag
		// parameter 2: a description of the test
		testDuplicateTheBag(new Integer[] {1, 2, 3}, 			"odd length bag");
		testDuplicateTheBag(new Integer[] {4, 5, 6, 7}, 		"even length bag");
		testDuplicateTheBag(new Integer[] {4, 4, 4}, 			"odd length bag with duplicates");
		testDuplicateTheBag(new Integer[] {3, 4, 5, 4, 3}, 		"odd length bag with duplicates");
		testDuplicateTheBag(new Integer[] {1, 1, 2, 2, 3, 3}, 	"even length bag with duplicates");
		testDuplicateTheBag(new Integer[] {1, 2, 3, 1, 2, 3}, 	"even length bag with duplicates");
		testDuplicateTheBag(new Integer[] {}, 					"empty bag");
		testDuplicateTheBag(new Integer[] {4}, 					"singleton bag");
		testDuplicateTheBag(new String[] {"a", "b", "c"}, 		"test with Strings");

		
		System.out.println("\n\n******************************* TESTING LISTINTERFACE CLIENT DUPLICATE NEIGHBOR METHOD *******************************");
		// parameter 1: the contents of the list
		// parameter 2: a description of the test
		testAddDuplicateNeighbors(new String[] {"a", "b", "c"}, 	 "odd length list");
		testAddDuplicateNeighbors(new String[] {"a", "b", "c", "d"}, "even length list");
		testAddDuplicateNeighbors(new String[] {"a", "b", "a", "b"}, "list with repeats");
		testAddDuplicateNeighbors(new String[] {"a"}, 				 "singleton list");
		testAddDuplicateNeighbors(new String[] {}, 					 "empty list");


		System.out.println("\n\n******************************* TESTING ALIST ADDTOFRONT METHOD *******************************");
		// parameter 1: the contents of the list
		// parameter 2: the chain contents to add to the front (e.g., {1, 2, 3} is the chain 1->2->3
		// parameter 3: a description of the test
		testAddToFront(new Integer[] {1, 2, 3, 4, 5}, 	new Integer[] {10, 11, 12}, 	"odd length chain being added to front of odd length list");
		testAddToFront(new Integer[] {1, 2, 3, 4}, 		new Integer[] {10, 11, 12, 13}, "even length chain being added to front of even length list");
		testAddToFront(new Integer[] {1, 2, 4, 2}, 		new Integer[] {2, 4, 2, 1}, 	"chain with duplicates being added to front of list with duplicates");
		testAddToFront(new Integer[] {1}, 				new Integer[] {8}, 				"singleton chain being added to front of singleton list");
		testAddToFront(new Integer[] {}, 				new Integer[] {5, 6, 7, 8}, 	"even length chain being added to front of empty list");
		testAddToFront(new Integer[] {}, 				new Integer[] {9, 10, 11}, 		"odd length chain being added to front of empty list");
		testAddToFront(new Integer[] {1, 2, 3, 4}, 		new Integer[] {}, 				"empty chain being added to front of even length list");
		testAddToFront(new Integer[] {1, 2, 3, 4, 5}, 	new Integer[] {}, 				"empty chain being added to front of odd length list");
		testAddToFront(new Integer[] {}, 				new Integer[] {}, 				"empty chain being added to front of empty list");
		testAddToFront(new String[] {"w", "o", "r", "k"}, new String[] {"n", "i", "c", "e"}, "test with Strings");
		testAddToFront(new Integer[] {2, 2, 2, 2, 2, 2},  new Integer[] {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, },
																						"long chain that will require the list array to expand");
	}
	
	public static void addDuplicateNeighbors(ListInterface<String> list) {
		for (int i = 1; i <= list.getLength(); i += 2) {		// O(n) to go through each element in list -> O(n^2) total
			list.add(i, list.getEntry(i));						// O(n) to add at a position
		}
	}

	
	/*
	 * The methods below are designed to help support the tests cases run from main. You don't
	 * need to use, modify, or understand these methods. You can safely ignore them. :) 
	 * 
	 * Also, you can ignore the use of generics in the tester methods. These methods use
	 * generics at a level beyond which we use in our class. I only use them here to make this a robust 
	 * and useful testing file. You are NOT required to understand the use of generics in this way.
	 */
	
	public static <T> void testDuplicateTheBag(T[] originalBagContents, String testDescription) {
		LinkedBag<T> actualBag = new LinkedBag<T>();
		LinkedBag<T> duplicatedBag = new LinkedBag<T>();
		int originalSize = originalBagContents.length;
		int expectedDoubleSize = originalSize*2;
		for(T element : originalBagContents) {
			actualBag.add(element);
			duplicatedBag.add(element);
			duplicatedBag.add(element);
		}
		actualBag.duplicateTheBag();
		int actualDuplicatedSize = actualBag.getCurrentSize();
		T[] duplicatedBagArray = duplicatedBag.toArray();
		T[] actualBagArray = actualBag.toArray();
		boolean match = true;
		while(!duplicatedBag.isEmpty()) {
			T element = duplicatedBag.remove();
			if(!actualBag.remove(element)) {
				match = false;
			}
		}
		System.out.println("\n\tBefore bag=" + Arrays.toString(originalBagContents) + " \t\t  (before size=" + originalSize + ")");
		System.out.println("Expected after bag=" + Arrays.toString(duplicatedBagArray)+ " \t(expected size=" + expectedDoubleSize + ")");
		System.out.println("  Actual after bag=" +  Arrays.toString(actualBagArray) + " \t  (actual size=" + actualDuplicatedSize + ")");
		if(!match || !actualBag.isEmpty()) {
				System.out.println("\t***Test failed. Contents not correct for test: " + testDescription);
		}
		if(actualDuplicatedSize!=expectedDoubleSize) {
			System.out.println("\t***Test failed. Size is not correct for: " + testDescription);
		}
	}
		
	public static <T extends Comparable<? super T>> void testAddToFront(T[] listContents, T[] nodeContents, String testDescription) {
		AList<T> list = new AList<T>();
		AList<T> expectedList = new AList<T>();
		for(T element : nodeContents) {
			expectedList.add(element);
		}
		for(T element : listContents) {
			list.add(element);
			expectedList.add(element);
		}
		ANode<T> chain = createANodeChain(nodeContents);
		list.addToFront(chain);
		
		boolean matchingContents = true;
		int listPos = 1;
		for(int i=0; i<nodeContents.length && matchingContents; i++, listPos++) {
			if(listPos>list.getLength() || !list.getEntry(listPos).equals(nodeContents[i])) {
				matchingContents = false;
			}
		}
		for(int i=0; i<listContents.length && matchingContents; i++, listPos++) {
			if(!list.getEntry(listPos).equals(listContents[i])) {
				matchingContents = false;
			}
		}
		System.out.println("\n\t  Before list=" + Arrays.toString(listContents) + " \t\t(before size=" + listContents.length + ")");
		System.out.println("Chain to add to front=" +  Arrays.toString(nodeContents) + "\t\t(chain size=" + nodeContents.length + ")");
		System.out.println("  Expected list after=" + Arrays.toString(expectedList.toArray()) +  "\t(expected size=" + expectedList.getLength() + ")");
		System.out.println("    Actual list after=" + Arrays.toString(list.toArray()) +  "\t  (actual size=" + list.getLength() + ")");

		if(!matchingContents) {
			System.out.println("\t***Test failed. Contents not correct for: " + testDescription);
		}
		if(expectedList.getLength()!=list.getLength()) {
			System.out.println("\t***Test failed. Size not correct for: " + testDescription);
		}		
	}
	
	private static <T> ANode<T> createANodeChain(T[] array) {
		ANode<T> firstNode = null;
		if(array.length>0) {
			ANode<T> node = new ANode<T>(array[0]);
			firstNode = node;
			for(int i=1; i<array.length; i++) {
				ANode<T> newNode = new ANode<T>(array[i]);
				node.next = newNode;
				node = node.next;
			}
		}
		return firstNode;
	}
	
	public static void testAddDuplicateNeighbors(String[] contents, String testDescription) {
		ListInterface<String> list;
		ListInterface<String> expectedList;
		Random generator = new Random();
		if(generator.nextBoolean()) {
			list = new AList<String>();
			expectedList = new AList<String>();
		} else {
			list = new LList<String>();
			expectedList = new LList<String>();
		}
		for(String element : contents) {
			list.add(element);
			expectedList.add(element);
			expectedList.add(element);
		}
		addDuplicateNeighbors(list);
		
		boolean match = true;
		if(list.getLength()!=expectedList.getLength()) {
			match = false;
		}
		for(int i=1; i<=list.getLength() && match; i++) {
			if(!list.getEntry(i).equals(expectedList.getEntry(i)) ) {
				match = false;
			}
		}
		System.out.println("\n\tBefore list=" + Arrays.toString(contents)); 
		System.out.println("Expected list after=" + Arrays.toString(expectedList.toArray()));
		System.out.println("  Actual list after=" +  Arrays.toString(list.toArray()));
		if(!match) {
				System.out.println("\t***Test failed for: " + testDescription);
		}

		
	}

	
	


}
