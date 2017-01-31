package com.ironyard.services;

import com.ironyard.data.Pet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jasonskipper on 1/30/17.
 */
public class PetService {
    /**
     * Get Pet that matches the given id
     * @param id
     * @return
     */
    public Pet getPetById(long id){
        Pet found = null;
        try {
            DbService dbService = new DbService();
            Connection con = dbService.getConnection();
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM helloworld.pets where pet_id= "+id);

            while (rs.next()) {

                found = getPet(rs);
            }
        }catch(Throwable t){
            t.printStackTrace();
        }
        return found;
    }

    public Pet save(Pet aPetToSave){
        try {
            DbService dbService = new DbService();
            Connection con = dbService.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO helloworld.pets " +
                            "(pet_name, pet_type, pet_age, pet_own_name, pet_color) " +
                            "VALUES (?, ?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
            // set values
            ps.setString(1,aPetToSave.getName());
            ps.setString(2,aPetToSave.getType());
            ps.setInt(3,aPetToSave.getAge());
            ps.setString(4,aPetToSave.getOwner());
            ps.setString(5,aPetToSave.getColor());
            ps.execute();

            // populate id that was generated from DB
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                aPetToSave.setId(rs.getLong("pet_id"));
            }

        }catch(Throwable t){
            t.printStackTrace();
        }
        return aPetToSave;
    }

    /**
     * Get Pet By the name given from database
     * @param aPetName
     * @return
     */
    public Pet getPetByName(String aPetName){
        Pet found = null;
        try {
            DbService dbService = new DbService();
            Connection con = dbService.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM helloworld.pets where pet_name= ?");
            ps.setString(1,aPetName);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                found = getPet(rs);
            }
        }catch(Throwable t){
            t.printStackTrace();
        }
        return found;
    }

    public List<Pet> getAllPetsFromDatabase(){
        List<Pet> foundPets = new ArrayList<Pet>();
        try {
            DbService dbService = new DbService();
            Connection con = dbService.getConnection();
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM helloworld.pets");

            while (rs.next()) {
                foundPets.add(getPet(rs));
            }
        }catch(Throwable t){
            t.printStackTrace();
        }
        return foundPets;
    }

    private Pet getPet(ResultSet rs) throws SQLException {
        String name = rs.getString("pet_name");
        String type = rs.getString("pet_type");
        String ownName = rs.getString("pet_own_name");
        String color = rs.getString("pet_color");
        int age = rs.getInt("pet_age");
        long id = rs.getLong("pet_id");
        return new Pet(name, age, ownName, color, type, id);
    }
}
