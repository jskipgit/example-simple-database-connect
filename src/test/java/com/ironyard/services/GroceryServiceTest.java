package com.ironyard.services;

import com.ironyard.data.GroceryItem;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jasonskipper on 1/31/17.
 */
public class GroceryServiceTest {
    @Before
    public void truncateBefore(){
        DbService ds = new DbService();
        ds.truncate("helloworld.grocery_item");
    }

    @Test
    public void testFindAllGroceryItems(){
        GroceryService gs = new GroceryService();
        // save items
        GroceryItem tmp = new GroceryItem(2.99, "milk", "food", 7);
        gs.save(tmp);
        tmp = new GroceryItem(3.99, "milk1", "food", 7);
        gs.save(tmp);
        tmp = new GroceryItem(20.99, "milk2", "food", 7);
        gs.save(tmp);

        List<GroceryItem> foundList = gs.getAllPetsFromDatabase();
        assertEquals("size not matched", 3, foundList.size());
    }

    @Test
    public void testSave(){
        GroceryService gs = new GroceryService();
        // save items
        GroceryItem tmp = new GroceryItem(2.99, "milk", "food", 7);
        GroceryItem saved = gs.save(tmp);
        System.out.println("Equal?"+(tmp == saved));

        saved = gs.getGroceryById(saved.getId());
        System.out.println("Equal?"+(tmp == saved));

//        List<GroceryItem> foundList = gs.getAllPetsFromDatabase();
        assertEquals("name", tmp.getName(), saved.getName());
        assertEquals("getId", tmp.getId(), saved.getId());
        assertEquals("getCategory", tmp.getCategory(), saved.getCategory());
        assertEquals("getIsle", tmp.getIsle(), saved.getIsle());
        assertEquals("getPrice", tmp.getPrice(), saved.getPrice(), .00001);
        System.out.println("Done with a single test..");
    }

    @Test
    public void testMulitSave(){

        List<Thread> t = new ArrayList<Thread>();
        for(int i=0; i<100; i++) {
            t.add(new Thread(new Runnable() {
                public void run() {
                    testSave();
                }
            }));
        }
        for(int i=0; i<100; i++) {
            t.get(i).start();

        }
        System.out.println("Done Scheduling..");

    }
}
