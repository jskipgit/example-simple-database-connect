package com.ironyard.services;

import java.sql.*;

/**
 * Created by jasonskipper on 9/29/16.
 */
public class DbService {
    String url = "jdbc:postgresql://localhost:5432/postgres";
    String user = "postgres";
    String password = "admin";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public void truncate(String tablename){
        try {
            Connection con = this.getConnection();
            Statement s = con.createStatement();
            s.execute("TRUNCATE "+tablename);
        }catch(Throwable t){
            t.printStackTrace();
        }

    }

}
