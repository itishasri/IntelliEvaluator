package com.ie.pkg;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class DatabaseConnect {
	    Connection con;
	   	    public DatabaseConnect(){
	   	        try {
	            Class.forName("oracle.jdbc.OracleDriver");
	            try {
	                con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","3222");
	            } catch (SQLException ex) {
	                Logger.getLogger(DatabaseConnect.class.getName()).log(Level.SEVERE, null, ex);
	            }
	        } catch (ClassNotFoundException ex) {
	            Logger.getLogger(DatabaseConnect.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }
	   	    public Connection getDBConnection(){
	   return con;
	  }
	 }