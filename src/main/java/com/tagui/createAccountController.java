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



    }

}