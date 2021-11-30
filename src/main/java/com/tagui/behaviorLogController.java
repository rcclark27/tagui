package com.tagui;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.io.*;
import java.time.chrono.AbstractChronology;
import java.util.Objects;
import java.util.Scanner;

public class behaviorLogController
{
    public void logBehavior(ActionEvent event) throws IOException
    {
        Parent popUpParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("behaviorpopup.fxml")));
        Scene popUpScene = new Scene(popUpParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(popUpScene);
        window.show();
    }

    public void greenButton(ActionEvent event) throws IOException {
        AnchorPane popup = new AnchorPane();
        Scene popupScene = new Scene(popup, 600, 400);
        Stage newPopup = new Stage();

        Image icon = new Image(getClass().getResourceAsStream("GreenMonster.png"));

        newPopup.setTitle("Good Behavior");
        newPopup.getIcons().add(icon);
        newPopup.setScene(popupScene);

        displayBehavior("green light",newPopup);
    }

    public void yellowButton(ActionEvent event) throws IOException
    {
        AnchorPane popup = new AnchorPane();
        Scene popupScene = new Scene(popup,600,400);
        Stage newPopup = new Stage();

        Image icon = new Image(getClass().getResourceAsStream("YellowMonster.png"));

        newPopup.setTitle("Warning Behavior");
        newPopup.getIcons().add(icon);
        newPopup.setScene(popupScene);

        displayBehavior("yellow light",newPopup);
    }

    public void redButton(ActionEvent event) throws IOException
    {
        AnchorPane popup = new AnchorPane();
        Scene popupScene = new Scene(popup,600,400);
        Stage newPopup = new Stage();

        Image icon = new Image(getClass().getResourceAsStream("RedMonster.png"));

        newPopup.setTitle("Bad Behavior");
        newPopup.setScene(popupScene);
        newPopup.getIcons().add(icon);

        displayBehavior("red light",newPopup);
    }

    public void backButton(ActionEvent event) throws IOException
    {
        Parent homePageParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("homePage.fxml")));
        Scene homePageScene = new Scene(homePageParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(homePageScene);
        window.show();
    }

    public void displayBehavior(String desiredBehavior, Stage currentStage) throws IOException {
        String line = ""; // used to read the file line by line
        String splitBy = ","; // delimiter used to split line into an array
        // loads the classTest.txt file into the scanner for reading
        BufferedReader behaviorScan = new BufferedReader(new FileReader("C:\\Users\\rebec\\IdeaProjects\\dbtest2\\tagui\\src\\main\\resources\\com\\tagui\\classTest.txt"));
        VBox displayedBehavior = new VBox(15); // create a vbox so we can actually display info

        // reads through the classTest.txt file
        while ((line = behaviorScan.readLine()) != null) {
            // cuts up the file line everytime it reads a ',' and creates an array of the size [4]
            String[] student = line.split(splitBy);
            // student[]'s makeup is (Name, Grade, Behavior, Seat Number, Attendance
            String behavior = student[2]; // behavior will always be [2]

            // displays name and behavior of the student if behavior == desiredBehavior
            if (Objects.equals(behavior, desiredBehavior)) {
                // adds a button to the vbox
                displayedBehavior.getChildren().add(new Button(student[0]));
                // System.out.print(System.lineSeparator() + student[0] + ", " + student[2]);
            }
        }

        // displays the students of the selected behavior type
        Scene behaviorScene = new Scene(displayedBehavior, 300, 300);
        currentStage.setScene(behaviorScene);
        currentStage.show();
    }
}
