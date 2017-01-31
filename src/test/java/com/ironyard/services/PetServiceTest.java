package com.ironyard.services;

import com.ironyard.data.Pet;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by jasonskipper on 1/30/17.
 */
public class PetServiceTest {

    @Before
    public void truncateBefore(){
        DbService ds = new DbService();
        ds.truncate("helloworld.pets");
    }

    @Test
    public void getAllPetsFromDatabase() throws Exception {
        PetService ps = new PetService();
        ps.save(new Pet("pet1", 1, "owner1", "color1", "dog"));
        ps.save(new Pet("pet2", 1, "owner2", "color2", "cat"));
        ps.save(new Pet("pet3", 1, "owner3", "color3", "bird"));
        List<Pet> found = ps.getAllPetsFromDatabase();
        assertEquals("Found unexpected number of rows.",3, found.size());
    }

    @Test
    public void getPetByIdFromDatabase() throws Exception {
        // Create pet with a known name
        PetService ps = new PetService();
        Pet saveMe = ps.save(new Pet("pet2", 1, "owner2", "color2", "cat"));

        // now get pet by id and ensure it's the same pet
        Pet found = ps.getPetById(saveMe.getId());
        assertEquals("Name 404",saveMe.getName(), found.getName());
        assertEquals("getColor 404",saveMe.getColor(), found.getColor());
        assertEquals("getType 404",saveMe.getType(), found.getType());
        assertEquals("getAge 404",saveMe.getAge(), found.getAge());
        assertEquals("getOwner 404",saveMe.getOwner(), found.getOwner());    }

    @Test
    public void getPetByNameFromDatabase() throws Exception {
        // TODO .. Fist insert stuff
        System.out.println("getPetByNameFromDatabase");
        PetService ps = new PetService();
        Pet saveMe = ps.save(new Pet("pepper", 1, "owner2", "color2", "cat"));
        Pet found = ps.getPetByName("pepper");
        assertEquals("Name 404",saveMe.getName(), found.getName());
        assertEquals("getColor 404",saveMe.getColor(), found.getColor());
        assertEquals("getType 404",saveMe.getType(), found.getType());
        assertEquals("getAge 404",saveMe.getAge(), found.getAge());
        assertEquals("getOwner 404",saveMe.getOwner(), found.getOwner());
    }

    @Test
    public void saveToDatabase() throws Exception {
        System.out.println("saveToDatabase");
        PetService ps = new PetService();
        Pet saveMe = new Pet("test",7,"skipper","brown","mouse");
        //
        ps.save(saveMe);

        // fetch by name
        Pet found = ps.getPetByName("test");
        assertEquals("Name 404",saveMe.getName(), found.getName());
        assertEquals("getColor 404",saveMe.getColor(), found.getColor());
        assertEquals("getType 404",saveMe.getType(), found.getType());
        assertEquals("getAge 404",saveMe.getAge(), found.getAge());
        assertEquals("getOwner 404",saveMe.getOwner(), found.getOwner());

    }
}