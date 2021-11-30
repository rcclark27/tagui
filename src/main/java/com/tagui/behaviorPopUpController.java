package com.tagui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.application.Application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class behaviorPopUpController extends behaviorPopUpTwoController implements Initializable
{
    @FXML private TextField tfStudentName;
    public boolean doTheyExist=false; // students must prove they exist

    public void enterStudent(ActionEvent event) throws IOException {
        String line = ""; // used to read the file line by line
        String splitBy = ","; // delimiter used to split line into an array
        // loads the classTest.txt file into the scanner for reading
        BufferedReader nameScan = new BufferedReader(new FileReader("C:\\Users\\rebec\\IdeaProjects\\dbtest2\\tagui\\src\\main\\resources\\com\\tagui\\classTest.txt"));

        // reads through the classTest.txt file
        while ((line = nameScan.readLine()) != null) {
            // cuts up the file line everytime it reads a ',' and creates an array of the size [4]
            String[] student = line.split(splitBy);
            // student[]'s makeup is (Name, Grade, Behavior, Seat Number, Attendance
            String name = student[0]; // name will always be [0]
            String nameToTest = tfStudentName.getText();
            // displays name of the student if there is a student with the same name that has been entered
            if (Objects.equals(name,nameToTest)) {
                doTheyExist=true;
            }
        }

        // continues only if the student exists
        if (doTheyExist) {
            Parent popUpParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("behaviorpopuptwo.fxml")));
            Scene popUpScene = new Scene(popUpParent);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(popUpScene);
            static_label.setText(tfStudentName.getText() + "'s");
        }

    }
}
