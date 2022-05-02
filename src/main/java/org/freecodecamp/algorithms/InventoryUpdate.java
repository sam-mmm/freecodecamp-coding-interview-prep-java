package org.freecodecamp.algorithms;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.util.ArrayList;
import java.util.List;
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
        List<String> arrCurInvName = currentInventory.values().stream().toList(); // Names of arr1's items
        List<String> arrNeInvName = newInventory.values().stream().toList(); // Names of arr2's items
        Multimap<Integer, String> updatedInventory = ArrayListMultimap.create();
        // Same as using two for loops, this takes care of increasing the number of stock quantity.
        currentInventory.forEach((integer, s) -> {
            newInventory.forEach((integer1, s1) -> {
                if (s.equalsIgnoreCase(s1)) {
                    updatedInventory.put((integer + integer1), s);
                }
            });
        });
        currentInventory.forEach((integer, s) -> {
            if (!updatedInventory.containsValue(s)) {
                updatedInventory.put(integer, s);
            }
        });


        // Add new inventory items to current inventory.
        arrNeInvName.forEach(s -> {
            if (!arrCurInvName.contains(s)) {
                updatedInventory.put(keyFromValue(newInventory, s), s);
            }
        });
        // Sort the array alphabetically using the second element of the array as base.
        updatedInventory.entries().stream().sorted(Map.Entry.comparingByValue()).forEach(integerStringEntry -> result.put(integerStringEntry.getKey(), integerStringEntry.getValue()));
        return result;
    }

    public Multimap<Integer, String> updateInventory3(Multimap<Integer, String> currentInventory, Multimap<Integer, String> newInventory) {
        Multimap<Integer, String> result = ArrayListMultimap.create();

//        // convert current inventory (arr1) to an one-dimensional array
        ArrayList inventory = new ArrayList();
        currentInventory.entries().stream().forEach(e -> {
            inventory.add(e.getKey());
            inventory.add(e.getValue());
        });
//  const inventory = Array.prototype.concat.apply([],arr1);

//
//        ############# Don';t know how to do this in Java, Maps return Sets which doesn't have get(i) method.
//
//        // loop through new delivery (arr2)
//        for (let i = 0; i < arr2.length; i++) {
//            // extract item properties for easy reference
//    const item = arr2[i][1];
//    const quantity = arr2[i][0];
//
//            // check if item already exists in inventory
//    const position = inventory.indexOf(item);
//
//            // exsisting item: update quantity
//            if (position != = -1) {
//      const row = Math.floor(position / 2);
//                arr1[row][0] += quantity;
//                continue;
//            }
//
//            // alien item: add to inventory
//            arr1.push([quantity, item]);
//        }
//
//        // sort inventory in alphabetical order
//        arr1.sort((previous, next) =>(previous[1] >[next[1]] ? 1 : -1));
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

}
