package com.tagui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


public class attendanceLogController implements Initializable
{

    @FXML VBox hereTodayVBox;

    @Override
    public void initialize(URL location, ResourceBundle arg1)
    {

        List<String> students = HomePage.values;
        int count = 0;

        hereTodayVBox.setAlignment(Pos.BASELINE_CENTER);

        for (int i = 0; i < students.size(); i++)
        {
           count = count + 1;
        }
        System.out.println("Count " + count);
        Label lbs[];
        lbs = new Label[count];

        for (int i = 0; i < lbs.length; i++)
        {
            lbs[i] = new Label(students.get(i));
        }

        for (int i = 0; i < lbs.length; i++)
        {
            hereTodayVBox.getChildren().add(lbs[i]);
        }

    }

    public void logAttendance(ActionEvent event) throws IOException
    {
        Parent popUpParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("logattendance.fxml")));
        Scene popUpScene = new Scene(popUpParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(popUpScene);
        window.show();
    }

    public void backButton(ActionEvent event) throws IOException
    {
        Parent homePageParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("homePage.fxml")));
        Scene homePageScene = new Scene(homePageParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(homePageScene);
        window.show();
    }

}
