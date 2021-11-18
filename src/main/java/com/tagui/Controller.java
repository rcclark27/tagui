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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Controller
{
    @FXML Label tfMessage;
    @FXML Label tfOutput;
    @FXML TextField userLogin;
    @FXML TextField pwdLogin;

    public void showHomePage(ActionEvent event) throws IOException {

        String userLoginText = userLogin.getText();
        String passwordLoginText = pwdLogin.getText();
        Boolean correctCredentials = false;

//        System.out.println(userLoginText);
//        System.out.println(passwordLoginText);

        File file = new File("C:\\Users\\rebec\\IdeaProjects\\dbtest2\\tagui\\src\\main\\resources\\com\\tagui\\users.csv");
        BufferedReader reader = new BufferedReader(new FileReader(file));

        String line = null;
        Scanner scrn = null;

        User usr = null;
        while ((line = reader.readLine()) != null)
        {

            String[] values = line.split(",");
            String email = values[0];
            String name = values[1];
            String password = values[2];

//            System.out.println("Array was created");
//            System.out.println(values[0]);
//            System.out.println(values[1]);
//            System.out.println(values[2]);

            if (userLoginText.equals(email) && (" " + passwordLoginText).equals(password))
            {
                correctCredentials = true;
//                System.out.println("Credentials are true");
                break;
            }
        }
        reader.close();

        if (correctCredentials == true)
        {
            // Get rid of this when you get the login thing working
            Parent homeParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("homePage.fxml")));
            Scene homeScene = new Scene(homeParent);

            //This gets the Stage information
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(homeScene);
            window.show();
        }

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