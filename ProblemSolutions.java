
/******************************************************************
 *
 *   CEPHER ONANO / COMP 400C - 002
 * 
 * Last modified 3/26/2025
 *
 *   This java file contains the problem solutions of isSubSet, findKthLargest,
 *   and sort2Arrays methods. You should utilize the Java Collection Framework for
 *   these methods.
 *
 ********************************************************************/

import java.util.*;

class ProblemSolutions {

    /**
     * Method: isSubset()
     *
     * Given two arrays of integers, A and B, return whether
     * array B is a subset if array A. Example:
     * Input: [1,50,55,80,90], [55,90]
     * Output: true
     * Input: [1,50,55,80,90], [55,90, 99]
     * Output: false
     *
     * The solution time complexity must NOT be worse than O(n).
     * For the solution, use a Hash Table.
     *
     * @param list1 - Input array A
     * @param list2 - input array B
     * @return - returns boolean value B is a subset of A.
     */

    public boolean isSubset(int list1[], int list2[]) {

        // ADD YOU CODE HERE -- DON'T FORGET TO ADD YOR NAME AT TOP OF FILE
        // Create a HashSet to store elements of list
        Set<Integer> set = new HashSet<>();
        // Add each element of list 1 to the set
        for (int num : list1) {
            set.add(num);
        }
        // Assume list2 is a subset of list1
        boolean isSubset = true;
        // Check if each elelemt in list2 is present in the set
        for (int num : list2) {
            // If any element is missing , then set is set to false.
            if (!set.contains(num)) {
                isSubset = false;
            }
        }
        // return is if list2 is a subset of list1
        return isSubset;

        // return false;
    }

    /**
     * Method: findKthLargest
     *
     * Given an Array A and integer K, return the k-th maximum element in the array.
     * Example:
     * Input: [1,7,3,10,34,5,8], 4
     * Output: 7
     *
     * @param array - Array of integers
     * @param k     - the kth maximum element
     * @return - the value in the array which is the kth maximum value
     */

    public int findKthLargest(int[] array, int k) {

        // ADD YOUR CODE HERE
        // Start by creating a minimum heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // Loop through each element in the array
        for (int num : array) {
            // Add number to the heap
            minHeap.add(num);
            // If heap size exceeds k, rmeove the smallest element.
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        // the top element is k largest
        return minHeap.peek();

        // return 0;
    }

    /**
     * Method: sort2Arrays
     *
     * Given two arrays A and B with n and m integers respectively, return
     * a single array of all the elements in A and B in sorted order. Example:
     * Input: [4,1,5], [3,2]
     * Output: 1 2 3 4 5
     *
     * @param array1 - Input array 1
     * @param array2 - Input array 2
     * @return - Sorted array with all elements in A and B.
     */

    public int[] sort2Arrays(int[] array1, int[] array2) {

        // ADD YOU CODE HERE
        // First create a list to hold all the elelemts from both arrays
        List<Integer> mergedList = new ArrayList<>();
        // Add elements from the first array to the list.
        for (int num : array1) {
            mergedList.add(num);
        }
        // Next add all the elements from the second array to the list.
        for (int num : array2) {
            mergedList.add(num);
        }
        // Sort the merged list in ascending order.
        Collections.sort(mergedList);

        // Convert sorted list back to an array.
        return mergedList.stream().mapToInt(Integer::intValue).toArray();

        // return null;
    }

}