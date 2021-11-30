package com.tagui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.controlsfx.control.action.Action;

import java.io.*;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class behaviorPopUpTwoController implements Initializable
{
    @FXML private Label studentName;
    public static Label static_label;

    @Override
    public void initialize(URL location, ResourceBundle arg1)
    {
        static_label = studentName;
    }


    public void backButton(ActionEvent event) throws IOException
    {
        Parent homePageParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("behaviorlog.fxml")));
        Scene homePageScene = new Scene(homePageParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(homePageScene);
        window.show();
    }

    public void rewardButton(ActionEvent event) throws IOException {
        String line = ""; // used to read the file line by line
        String splitBy = ","; // delimiter used to split line into an array
        // loads the classTest.txt file into the scanner for reading
        BufferedReader nameScan = new BufferedReader(new FileReader("C:\\Users\\rebec\\IdeaProjects\\dbtest2\\tagui\\src\\main\\resources\\com\\tagui\\classTest.txt"));
        String[][] studentToBeAltered = new String[15][5]; // where we will store the updated student
        int counterVar=0;

        // reads through the classTest.txt file
        while ((line = nameScan.readLine()) != null) {
            // cuts up the file line everytime it reads a ',' and creates an array of the size [4]
            String[] student = line.split(splitBy);
            // student[]'s makeup is (Name, Grade, Behavior, Seat Number, Attendance
            String name = student[0]; // name will always be [0]
            String nameTo = studentName.getText();
            String[] nameToTest = nameTo.split("'");

            // displays name of the student if there is a student with the same name that has been entered
            if (Objects.equals(name, nameToTest[0])) {
                for (int i=0;i<5;i++){
                    studentToBeAltered[counterVar][i]=student[i];
                }
                // changes "red light" to "yellow light"
                if (Objects.equals(student[2], "red light")){
                    studentToBeAltered[counterVar][2] = "yellow light";
                }
                // changes "yellow light" to "green light
                else if (Objects.equals(student[2], "yellow light")){
                    studentToBeAltered[counterVar][2]="green light";
                }
                // does nothing if already "green light"
                else {
                    studentToBeAltered[counterVar][2]=student[2];
                }
            }

            // if its not the student we want to change it simply copies the information
            else {
                // copies the information of the student we want to adjust
                studentToBeAltered[counterVar][0] = student[0];
                studentToBeAltered[counterVar][1] = student[1];
                studentToBeAltered[counterVar][2] = student[2];
                studentToBeAltered[counterVar][3] = student[3];
                studentToBeAltered[counterVar][4] = student[4];
            }


            // increment counter every loop
            counterVar++;
        }

        // closes the reader
        nameScan.close();

        // gets ready to update the file
        BufferedWriter file = new BufferedWriter(new FileWriter("C:\\Users\\rebec\\IdeaProjects\\dbtest2\\tagui\\src\\main\\resources\\com\\tagui\\classTest.txt"));
        // updates file as it goes
        for (int i=0;i<15;i++) {
            for (int x=0;x<5;x++) {
                String messageToBeWritten = studentToBeAltered[i][x];
                file.write(messageToBeWritten);
                if (x!=4) {
                    file.write(",");
                }
            }
            file.newLine();
        }
        // closes the file
        file.close();


    }

    public void infractionButton(ActionEvent event) throws IOException {
        String line = ""; // used to read the file line by line
        String splitBy = ","; // delimiter used to split line into an array
        // loads the classTest.txt file into the scanner for reading
        BufferedReader nameScan = new BufferedReader(new FileReader("C:\\Users\\rebec\\IdeaProjects\\dbtest2\\tagui\\src\\main\\resources\\com\\tagui\\classTest.txt"));
        String[][] studentToBeAltered = new String[15][5]; // where we will store the updated student
        int counterVar=0;

        // reads through the classTest.txt file
        while ((line = nameScan.readLine()) != null) {
            // cuts up the file line everytime it reads a ',' and creates an array of the size [4]
            String[] student = line.split(splitBy);
            // student[]'s makeup is (Name, Grade, Behavior, Seat Number, Attendance
            String name = student[0]; // name will always be [0]
            String nameTo = studentName.getText();
            String[] nameToTest = nameTo.split("'");

            // displays name of the student if there is a student with the same name that has been entered
            if (Objects.equals(name, nameToTest[0])) {
                for (int i=0;i<5;i++){
                    studentToBeAltered[counterVar][i]=student[i];
                }
                // changes "green light" to "yellow light"
                if (Objects.equals(student[2], "green light")){
                    studentToBeAltered[counterVar][2] = "yellow light";
                }
                // changes "yellow light" to "red light
                else if (Objects.equals(student[2], "yellow light")){
                    studentToBeAltered[counterVar][2]="red light";
                }
                // does nothing if already "red light"
                else {
                    studentToBeAltered[counterVar][2]=student[2];
                }
            }

            // if its not the student we want to change it simply copies the information
            else {
                // copies the information of the student we want to adjust
                studentToBeAltered[counterVar][0] = student[0];
                studentToBeAltered[counterVar][1] = student[1];
                studentToBeAltered[counterVar][2] = student[2];
                studentToBeAltered[counterVar][3] = student[3];
                studentToBeAltered[counterVar][4] = student[4];
            }


            // increment counter every loop
            counterVar++;
        }

        // closes the reader
        nameScan.close();

        // gets ready to update the file
        BufferedWriter file = new BufferedWriter(new FileWriter("C:\\Users\\rebec\\IdeaProjects\\dbtest2\\tagui\\src\\main\\resources\\com\\tagui\\classTest.txt"));
        // updates file as it goes
        for (int i=0;i<15;i++) {
            for (int x=0;x<5;x++) {
                String messageToBeWritten = studentToBeAltered[i][x];
                file.write(messageToBeWritten);
                if (x!=4) {
                    file.write(",");
                }
            }
            file.newLine();
        }
        // closes the file
        file.close();


    }
}
