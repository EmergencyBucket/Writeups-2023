package me.mrxbox98;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import static spark.Spark.*;

public class Main {

    public static Connection con;

    static {
        try {
            con = DriverManager.getConnection(
                    "jdbc:mysql://database.com/database","root","password");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
        port(80);
        
        get("/", (req, res) -> {
            return "<form action=\"login\" method=\"post\">\n" +
                    "    <fieldset>\n" +
                    "        <p>Name</p>\n" +
                    "        <input type=\"text\" name=\"userName\" required=\"true\">\n" +
                    "\n" +
                    "        <p>Email</p>\n" +
                    "        <input type=\"password\" name=\"password\" required=\"true\">\n" +
                    "        <input type=\"submit\" value=\"submit\">\n" +
                    "    </fieldset>\n" +
                    "</form>";
        });
        
        post("/login", (req, res) -> {
            try {
                String username = req.queryParams("userName");

                String password = req.queryParams("password");
                
                if(username.contains(";") || password.contains(";")) {
                    return "NO SEMICOLONS!";
                }

                ResultSet resultSet = con.createStatement().executeQuery("SELECT * FROM Users WHERE username = '" + username + "' AND password = '" + password+"';");
                return resultSet.next() ? "bucket{m3d1um_sq11_693f79541}" : "no";
            }
            catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        });
    }
    
}
