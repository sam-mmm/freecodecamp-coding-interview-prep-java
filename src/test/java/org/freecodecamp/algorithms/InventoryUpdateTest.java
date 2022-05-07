package org.freecodecamp.algorithms;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Multimap;
import com.google.common.collect.Table;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class InventoryUpdateTest {

//    Map<Integer, String> curInv = Map.of(21, "Bowling Ball",2, "Dirty Sock",1, "Hair Pin",5, "Microphone");
//    Map<Integer, String> newInv = Map.of(2, "Hair Pin",3, "Half-Eaten Apple",67, "Bowling Ball",7, "Toothpaste");

    Map<Map<Integer, String>, Map<Integer, String>> maps = Map.of(
            Map.of(21, "Bowling Ball", 2, "Dirty Sock", 1, "Hair Pin", 5, "Microphone"),
            Map.of(2, "Hair Pin", 3, "Half-Eaten Apple", 67, "Bowling Ball", 7, "Toothpaste")
    );

    //    Map<Integer, String>[] r = new Map[]{
//            Map.of(88, "Bowling Ball", 2, "Dirty Sock", 3, "Hair Pin", 3, "Half-Eaten Apple", 5, "Microphone", 7, "Toothpaste")
//    };
    Table<Multimap<Integer, String>, Multimap<Integer, String>, Multimap<Integer, String>> table = HashBasedTable.create();
    InventoryUpdate iu = new InventoryUpdate();

    @BeforeEach
    void setUp() {

        data1();
        data2();
        data3();
        data4();

    }

    private void data4() {
        Multimap<Integer, String> a = ArrayListMultimap.create();
        Multimap<Integer, String> b = ArrayListMultimap.create();
        Multimap<Integer, String> r = ArrayListMultimap.create();
        a.put(0, "Bowling Ball");
        a.put(0, "Dirty Sock");
        a.put(0, "Hair Pin");
        a.put(0, "Microphone");
        b.put(1, "Hair Pin");
        b.put(1, "Half-Eaten Apple");
        b.put(1, "Bowling Ball");
        b.put(1, "Toothpaste");
        r.put(1, "Bowling Ball");
        r.put(0, "Dirty Sock");
        r.put(1, "Hair Pin");
        r.put(1, "Half-Eaten Apple");
        r.put(0, "Microphone");
        r.put(1, "Toothpaste");
        table.put(a, b, r);
    }

    private void data3() {
        Multimap<Integer, String> a = ArrayListMultimap.create();
        Multimap<Integer, String> b = ArrayListMultimap.create();
        Multimap<Integer, String> r = ArrayListMultimap.create();
        b.put(2, "Hair Pin");
        b.put(3, "Half-Eaten Apple");
        b.put(67, "Bowling Ball");
        b.put(7, "Toothpaste");
        r.put(67, "Bowling Ball");
        r.put(2, "Hair Pin");
        r.put(3, "Half-Eaten Apple");
        r.put(7, "Toothpaste");
        table.put(a, b, r);
    }

    private void data2() {
        Multimap<Integer, String> a = ArrayListMultimap.create();
        Multimap<Integer, String> b = ArrayListMultimap.create();
        Multimap<Integer, String> r = ArrayListMultimap.create();
        a.put(21, "Bowling Ball");
        a.put(2, "Dirty Sock");
        a.put(1, "Hair Pin");
        a.put(5, "Microphone");
        r.put(21, "Bowling Ball");
        r.put(2, "Dirty Sock");
        r.put(1, "Hair Pin");
        r.put(5, "Microphone");
        table.put(a, b, r);
    }

    private void data1() {
        Multimap<Integer, String> a = ArrayListMultimap.create();
        Multimap<Integer, String> b = ArrayListMultimap.create();
        Multimap<Integer, String> r = ArrayListMultimap.create();
        a.put(21, "Bowling Ball");
        a.put(2, "Dirty Sock");
        a.put(1, "Hair Pin");
        a.put(5, "Microphone");
        b.put(2, "Hair Pin");
        b.put(3, "Half-Eaten Apple");
        b.put(67, "Bowling Ball");
        b.put(7, "Toothpaste");

        r.put(88, "Bowling Ball");
        r.put(2, "Dirty Sock");
        r.put(3, "Hair Pin");
        r.put(3, "Half-Eaten Apple");
        r.put(5, "Microphone");
        r.put(7, "Toothpaste");
        table.put(a, b, r);
    }

    private boolean equals(Multimap<Integer, String> a, Multimap<Integer, String> b) {
        boolean bool = true;
//        Verifying content
        for (Map.Entry<Integer, String> e : a.entries()) {
            if (!b.containsEntry(e.getKey(), e.getValue())) {
                bool = false;
                break;
            }
        }

//        Verifying order
        var c = a.values().stream().toList();
        var d = b.values().stream().toList();
        for (int i = 0; i < a.size(); i++) {
            if (!c.get(i).equalsIgnoreCase(d.get(i))) {
                bool = false;
            }
        }
        return bool;
    }


    @Test
    void updateInventory1() {
        table.cellSet().forEach(cell -> {
            var a = cell.getRowKey();
            var b = cell.getColumnKey();
            var r = cell.getValue();
            var val = iu.updateInventory1(cell.getRowKey(), cell.getColumnKey());
            assertEquals(r.size(), val.size());
            assertTrue(equals(r, val));
        });
    }

    @Test
    void updateInventory2() {
        table.cellSet().forEach(cell -> {
            var a = cell.getRowKey();
            var b = cell.getColumnKey();
            var r = cell.getValue();
            var val = iu.updateInventory2(cell.getRowKey(), cell.getColumnKey());

            assertEquals(r.size(), val.size());
//            assertTrue(equals(r, val));
        });
    }
}