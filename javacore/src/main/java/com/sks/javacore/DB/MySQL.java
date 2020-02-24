package com.sks.javacore.DB;

import java.sql.*;

public class MySQL {

	public static void main(String[] args) {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:30306/zimbra", "zimbra", "pv1bce0stoukbwy");
            Statement stmt = con.createStatement();
            ResultSet rs=stmt.executeQuery("select concat(id,',',group_id,',',account_id) from mailbox"); 
            while(rs.next())  
                System.out.println("From zimbra.mailbox \n" + rs.getString(1));
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
	}

}
