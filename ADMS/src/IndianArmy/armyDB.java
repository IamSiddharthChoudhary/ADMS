package IndianArmy;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class armyDB {
    
    public void CreateDataBase(String name)
    {
        try {
            String url = "ADMS:mysql://localhost:3306";
            String user = "root";
            String password = "sid@4444";
            Connection conn = DriverManager.getConnection(url,user,password);
            Statement stm = conn.createStatement(); 

            String query = "create database " + name;
            stm.execute(query);
            System.out.println("Created DataBase Successfully");
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void CreateTable(String DBname, String tname)
    {
        try {
            String url = "ADMS:mysql://localhost:3306/"+DBname;
            String user = "root";
            String password = "sid@4444";
            Connection conn = DriverManager.getConnection(url,user,password);
            Statement stm = conn.createStatement(); 

            String query = "create table" + tname + "(id INT PRIMARY KEY,name VARCHAR(50) NOT NULL,rank VARCHAR(50) ,phone VARCHAR(20));";
            stm.execute(query);
            System.out.println("Created Table Successfully");
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void CreateNewSoldier(String DBname, String tname , int id, String name, String rank, String ph)
    {
        try {
            String url = "ADMS:mysql://localhost:3306/"+DBname;
            String user = "root";
            String password = "sid@4444";
            Connection conn = DriverManager.getConnection(url,user,password);
            String query = "INSERT INTO " + tname + " (id,name,rank,phone) VALUES (?,?,?,?)";

            PreparedStatement prstm = conn.prepareStatement(query);
            prstm.setInt(1, id);
            prstm.setString(2,name);
            prstm.setString(3,rank);
            prstm.setString(4,ph);

            prstm.execute();
            System.out.println("Created new data successfully");
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getRecord(String DBname, String tname)
    {
        try {
            String url = "ADMS:mysql://localhost:3306/"+DBname;
            String user = "root";
            String password = "sid@4444";
            Connection conn = DriverManager.getConnection(url,user,password);
            Statement stm = conn.createStatement(); 

            String query = "SELECT * from " + tname;
            ResultSet rs = stm.executeQuery(query);
            while(rs.next())
            {
                System.out.println(" ID = "+ rs.getInt(1));
                System.out.println(" NAME = "+ rs.getInt(2));
                System.out.println(" RANK = "+ rs.getInt(3));
                System.out.println(" PHONE = "+ rs.getInt(4));
            }
            System.out.println("Data fetched successfully");
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateRank(String DBname, String tname, int id, String newRank)
    {
        try {
            String url = "ADMS:mysql://localhost:3306/"+DBname;
            String user = "root";
            String password = "sid@4444";
            Connection conn = DriverManager.getConnection(url,user,password);
            String query = "UPDATE ? set rank = ? where id = ?";

            PreparedStatement prstm = conn.prepareStatement(query);
            prstm.setString(1, tname);
            prstm.setString(2, newRank);
            prstm.setInt(1, id);

            prstm.execute();
            System.out.println("Data updated successfully");
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updatePhone(String DBname, String tname, int id, String phone)
    {
        try {
            String url = "ADMS:mysql://localhost:3306/"+DBname;
            String user = "root";
            String password = "sid@4444";
            Connection conn = DriverManager.getConnection(url,user,password);
            String query = "UPDATE ? set phone = ? where id = ?";

            PreparedStatement prstm = conn.prepareStatement(query);
            prstm.setString(1, tname);
            prstm.setString(2, phone);
            prstm.setInt(1, id);

            prstm.execute();
            System.out.println("Data updated successfully");
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteData(String DBname, String tname, int id)
    {
        try {
            String url = "ADMS:mysql://localhost:3306";
            String user = "root";
            String password = "sid@4444";
            Connection conn = DriverManager.getConnection(url,user,password);
            Statement stm = conn.createStatement(); 

            String query = "DELETE FROM " + DBname + " where id = " + id;
            stm.execute(query);
            System.out.println("Deleted Successfully");
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
