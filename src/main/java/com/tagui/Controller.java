package com.tagui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
//import javafx.scene.control.Button;
import javafx.scene.control.Label;
//import javafx.scene.text.Text;
import javafx.scene.control.TextField;
//import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.Node;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Controller
{
    @FXML Label tfMessage;
    @FXML Label tfOutput;
    @FXML TextField userLogin;
    @FXML TextField pwdLogin;

    public void showHomePage(ActionEvent event) throws IOException
    {
        // Get rid of this when you get the login thing working
        Parent homeParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("homePage.fxml")));
        Scene homeScene = new Scene(homeParent);

        //This gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(homeScene);
        window.show();

        String user = userLogin.getText();
        String password = pwdLogin.getText();
        Boolean correctCredentials = false;

//        fileName = "users.csv";
//        CSVReader reader = new CSVReader(new FileReader(fileName));


    }

    public void createAccount(ActionEvent event) throws IOException
    {
        Parent createAccountParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("createaccount.fxml")));
        Scene createAccountScene = new Scene(createAccountParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(createAccountScene);
        window.show();

    }

}