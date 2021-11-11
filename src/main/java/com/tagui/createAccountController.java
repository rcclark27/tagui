package com.tagui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

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

        String users;

        users = newUser.getEmailAddress() + ", " + newUser.getFirst() + " " + newUser.getLast() + ", " +
        newUser.getPassword();

        FileWriter writer = new FileWriter("C:\\Users\\rebec\\IdeaProjects\\dbtest2\\tagui\\src\\main\\resources\\com\\tagui\\users.csv", true);
        writer.append("\n" + users);
        writer.close();

    }

}