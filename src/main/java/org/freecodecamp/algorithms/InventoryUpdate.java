package org.freecodecamp.algorithms;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.util.Map;

//https://www.freecodecamp.org/learn/coding-interview-prep/algorithms/inventory-update
public class InventoryUpdate {
    public Multimap<Integer, String> updateInventory1(Multimap<Integer, String> currentInventory, Multimap<Integer, String> newInventory) {
        Multimap<Integer, String> result = ArrayListMultimap.create();
        Multimap<Integer, String> temp = ArrayListMultimap.create();

        for (Map.Entry<Integer, String> e : newInventory.entries()) {
            Integer key = keyFromValue(currentInventory, e.getValue());
            if (key == null) {
                temp.put(e.getKey(), e.getValue());

            } else {
                Integer k = keyFromValue(currentInventory, e.getValue());
                temp.put(k + e.getKey(), e.getValue());
            }
        }
        for (Map.Entry<Integer, String> e : currentInventory.entries()) {
            Integer key = keyFromValue(temp, e.getValue());
            if (key == null) {
                temp.put(e.getKey(), e.getValue());

            }
        }
        temp.entries().stream().sorted(Map.Entry.comparingByValue()).forEach(integerStringEntry -> result.put(integerStringEntry.getKey(), integerStringEntry.getValue()));
        return result;
    }

    public Multimap<Integer, String> updateInventory2(Multimap<Integer, String> currentInventory, Multimap<Integer, String> newInventory) {
        Multimap<Integer, String> result = ArrayListMultimap.create();
//        var index;
//        var arrCurInvName = []; // Names of arr1's items
//        var arrNeInvName = []; // Names of arr2's items
//
//        // Same as using two for loops, this takes care of increasing the number of stock quantity.
//        arr1.forEach(function(item1) {
//            arr2.forEach(function(item2) {
//                if (item1[1] === item2[1]) {
//                    item1[0] = item1[0] + item2[0]; //Increase number of stock
//                }
//            });
//        });
//
//        // Get item's name for new Inventory
//        arr2.forEach(function(item) {
//            arrNeInvName.push(item[1]);
//        });
//
//        // Get item's name for Current Inventory
//        arr1.forEach(function(item) {
//            arrCurInvName.push(item[1]);
//        });
//
//        // Add new inventory items to current inventory.
//        arrNeInvName.forEach(function(item) {
//            if (arrCurInvName.indexOf(item) === -1) {
//                index = arrNeInvName.indexOf(item);
//                arr1.push(arr2[index]);
//            }
//        });
//
//        // Sort the array alphabetically using the second element of the array as base.
//        arr1.sort(function(currItem, nextItem) {
//            //Ternary function to avoid using if else
//            return currItem[1] > nextItem[1] ? 1 : -1;
//        });
        return result;
    }

    // A helper method to return the index of a specified product (undefined if not found)
    private Integer keyFromValue(Multimap<Integer, String> inventory, String val) {
        for (Map.Entry<Integer, String> e : inventory.entries()) {
            if (val.equalsIgnoreCase(e.getValue())) {
                return e.getKey();
            }
        }
        return null;
    }

    ;
}
