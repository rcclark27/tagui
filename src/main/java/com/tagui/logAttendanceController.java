package com.tagui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class logAttendanceController implements Initializable
{
    // Design grid pane with choice boxes in here for log controller
    // Field 1 will be labels with student names entered in
    // Field 2 will be choice box for present
    // Field 3 will be choice box for absent

    @FXML GridPane gridpane;

    @Override
    public void initialize(URL location, ResourceBundle arg1)
    {
        //Set sizes of grid pane
        gridpane.setHgap(5);
        gridpane.setVgap(5);
        gridpane.setPrefSize(600,400); // this is not working how i want it to be...
        ColumnConstraints column1 = new ColumnConstraints();
        ColumnConstraints column2 = new ColumnConstraints();
        ColumnConstraints column3 = new ColumnConstraints();
        column1.setPercentWidth(33);
        column2.setPercentWidth(33);
        column3.setPercentWidth(33);
        gridpane.getColumnConstraints().addAll(column1,column2,column3);

        Label student1 = new Label();
        Label student2 = new Label();
        Label student3 = new Label();
        student1.setText("Student 1");
        student2.setText("Student 2");
        student3.setText("Student 3");

        gridpane.add(student1,0,0);
        gridpane.add(student2, 0, 1);
        gridpane.add(student3, 0, 2);


    }

}
