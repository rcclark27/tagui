package com.tagui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.*;

public class createAccountController
{
    @FXML TextField enterEmail, enterPassword, enterFirst, enterLast;

    public void submitClicked(ActionEvent event) throws IOException, ClassNotFoundException
    {

        String email = enterEmail.getText();
        String password = enterPassword.getText();
        String first = enterFirst.getText();
        String last = enterLast.getText();

        User newUser = new User();
        newUser.setFirst(first);
        newUser.setLast(last);
        newUser.setPassword(password);
        newUser.setEmailAddress(email);
        newUser.setUserID(2); // will need to make this better obviously

        /*Driver myDriver = new com.microsoft.sqlserver.jdbc.SQLServerDriver();
        DriverManager.registerDriver(myDriver);
        String URL = "jdbc:sqlserver://localhost:49679;databaseName=ta";
        String user = "guest";
        String pass = "password";
        Connection conn = DriverManager.getConnection(URL, user, pass);
        String sql = "INSERT INTO dbo.userinfo (userID, first_name, last_name, create_date, email, passwd) " +
                "VALUES (?, ?, ?, ?, ?, ?);";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, String.valueOf(newUser.getUserID()));
        stmt.setString(2, newUser.getFirst());
        stmt.setString(3, newUser.getLast());
        stmt.setString(4, "2021-10-28");
        stmt.setString(5, newUser.getEmailAddress());
        stmt.setString(6, newUser.getPassword());

        int rowsInserted = stmt.executeUpdate();
        if (rowsInserted > 0)
        {
            System.out.println("A new user was created successfully!");
        }

        conn.close();*/

    }

}