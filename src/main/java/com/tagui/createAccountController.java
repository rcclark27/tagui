package com.tagui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;
import java.util.Vector;

public class createAccountController
{
    @FXML TextField enterEmail, enterPassword, enterFirst;

    public void submitClicked(ActionEvent event) throws IOException
    {

        String email = enterEmail.getText();
        String password = enterPassword.getText();
        String name = enterFirst.getText();

        User newUser = new User();
        newUser.setName(name);
        newUser.setPassword(password);
        newUser.setEmailAddress(email);
        newUser.setUserID(2); // will need to make this better obviously

        String users;

        users = newUser.getEmailAddress() + ", " + newUser.getName() + ", " +
        newUser.getPassword();

        FileWriter writer = new FileWriter("C:\\Users\\rebec\\IdeaProjects\\dbtest2\\tagui\\src\\main\\resources\\com\\tagui\\users.csv", true);
        writer.append("\n" + users);
        writer.close();

    }

    public void loginBackButton(ActionEvent event) throws IOException
    {
        Parent myLoginParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("tagui.fxml")));
        Scene myLoginScene = new Scene(myLoginParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(myLoginScene);
        window.show();
    }

}