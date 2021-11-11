package com.tagui;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class HomePage extends myClassController implements Initializable
{
    @FXML Label testLabel;

    public static String[] studs = new String[15];//allows you to access studs array in other classes
    File classText = new File("C:\\Users\\rebec\\IdeaProjects\\dbtest2\\tagui\\src\\main\\resources\\com\\tagui\\classTest.txt");//adds a class csv file

    public void openMyClass(ActionEvent event) throws IOException
    {
        Parent myClassParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("myclass.fxml")));
        Scene myClassScene = new Scene(myClassParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(myClassScene);

        for (int y = 0; y<15; y++)//fills studs array with blank students to prevent null errors
        {
            studs[y] = "No Student, 0.0, No Behavior, 0, No Attendance/";
        }

        Scanner sc1 = new Scanner(classText);
        sc1.useDelimiter("/");
        int i = 0;
        while (sc1.hasNext())//fills studs array with students separated with /
        {
            studs[i] = sc1.next();
            i++;
        }

        String[] stuInfo = new String[5];
        String[] names = new String[15];
        for (int x=0; x<15; x++)//NESTED LOOP ALERT WOOP WOOP
        {
            Scanner sc2 = new Scanner(String.valueOf(studs[x]));
            sc2.useDelimiter(",");//outer loop goes through each student

            for (int c = 0; c < 5; c++)
            {
                stuInfo[c] = String.valueOf(sc2.next());//inner loop fills a temp array with ONE student's info
            }

            names[x] = String.valueOf(stuInfo[0]);//fills with the names of each student or non student
            sc2.close();
        }
        sc1.close();
        seatOne.setText(names[0]);//sets the buttons to each student's name
        seatTwo.setText(names[1]);
        seatThree.setText(names[2]);
        seatFour.setText(names[3]);
        seatFive.setText(names[4]);
        seatSix.setText(names[5]);
        seatSeven.setText(names[6]);
        seatEight.setText(names[7]);
        seatNine.setText(names[8]);
        seatTen.setText(names[9]);
        seatEleven.setText(names[10]);
        seatTwelve.setText(names[11]);
        seat3Teen.setText(names[12]);
        seat4Teen.setText(names[13]);
        seat5Teen.setText(names[14]);


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