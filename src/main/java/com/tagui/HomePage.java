package com.tagui;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HomePage
{
    @FXML Label testLabel;

    public void openMyClass(ActionEvent event) throws IOException
    {
        Parent myClassParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("myclass.fxml")));
        Scene myClassScene = new Scene(myClassParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(myClassScene);
        window.show();

    }

    public void openMyInfo(ActionEvent event) throws IOException
    {
        Parent myInfoParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("myinfo.fxml")));
        Scene myInfoScene = new Scene(myInfoParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(myInfoScene);
        window.show();

    }

    public void openGradebook(ActionEvent event) throws IOException
    {
        Parent gradebookParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("gradebook.fxml")));
        Scene gradebookScene = new Scene(gradebookParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(gradebookScene);
        window.show();

    }

    public void openAttendanceLog(ActionEvent event) throws IOException
    {
        Parent attendanceLogParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("attendancelog.fxml")));
        Scene attendanceLogScene = new Scene(attendanceLogParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(attendanceLogScene);
        window.show();

    }

    public void openBehaviorLog(ActionEvent event) throws IOException
    {
        Parent behaviorLogParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("behaviorlog.fxml")));
        Scene behaviorLogScene = new Scene(behaviorLogParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(behaviorLogScene);
        window.show();

    }

    public void openSeatingChart(ActionEvent event) throws IOException
    {
        Parent seatingChartParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("seatingchart.fxml")));
        Scene seatingChartScene = new Scene(seatingChartParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(seatingChartScene);
        window.show();

    }


}
