package org.freecodecamp.algorithms;

import java.util.ArrayList;

public class BinarySearch {
    public int[] binarySearch(int[] searchList, int value) {
        ArrayList<Integer> arrayPath = new ArrayList<>();
//        int first = 0;
//        int last = arr.length;
//        int mid = (first + last) / 2;
//        if(arr[mid] == element){
//            list.add(arr[mid]);
//        }
//        while (first <= last) {
//            if (arr[mid] < element) {
//                first = mid + 1;
//            } else if (arr[mid] == element) {
//                break;
//            } else {
//                last = mid - 1;
//            }
//            mid = (first + last) / 2;
//
//        }
        //set initial L - M - R
        int left = 0;
        int right = searchList.length - 1;
        int middle = (int) Math.floor(right / 2);

        //if first comparison finds value
        if (searchList[middle] == value) {
            arrayPath.add(searchList[middle]);
            return makeArray(arrayPath);
        }

        while (searchList[middle] != value) {
            //add to output array
            arrayPath.add(searchList[middle]);

            //not found
            if (right < left) {
                return null;
            }
            // value is in left or right portion of array
            // update L - M - R
            if (searchList[middle] > value) {
                right = middle - 1;
                middle = (int) (left + Math.floor((right - left) / 2));
            } else {
                left = middle + 1;
                middle = (int) (left + Math.floor((right - left) / 2));
            }

            //if found update output array and exit
            if (searchList[middle] == value) {
                arrayPath.add(searchList[middle]);

                break;
            }
        }

        return makeArray(arrayPath);
    }

    private int[] makeArray(ArrayList<Integer> arrayPath) {
        // Storing it inside array of strings
        int[] res = new int[arrayPath.size()];

        // Converting ArrayList to Array
        // using get() method
        for (int i = 0; i < arrayPath.size(); i++)
            res[i] = arrayPath.get(i);
        return res;
    }
}
