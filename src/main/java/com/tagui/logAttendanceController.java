package com.tagui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class logAttendanceController implements Initializable
{
    
    @FXML GridPane gridpane;
    @FXML Label present0, absent0, name0;
    @FXML CheckBox present1, present2, present3, present4, present5, present6, present7, present8, present9, present10, present11, present12, present13, present14, present15, present16;
    @FXML CheckBox absent1, absent2, absent3, absent4, absent5, absent6, absent7, absent8, absent9, absent10, absent11, absent12, absent13, absent14, absent15, absent16;

    @Override
    public void initialize(URL location, ResourceBundle arg1)
    {

        Label student1 = new Label();
        Label student2 = new Label();
        Label student3 = new Label();
        Label student4 = new Label();
        Label student5 = new Label();
        Label student6 = new Label();
        Label student7 = new Label();
        Label student8 = new Label();
        Label student9 = new Label();
        Label student10 = new Label();
        Label student11 = new Label();
        Label student12 = new Label();
        Label student13 = new Label();
        Label student14 = new Label();
        Label student15 = new Label();

        String studs[] = new String[15];
        File classText = new File("C:\\Users\\rebec\\IdeaProjects\\dbtest2\\tagui\\src\\main\\resources\\com\\tagui\\classTest.txt");//adds a class csv file

        for (int y = 0; y<15; y++)//fills studs array with blank students to prevent null errors
        {
            studs[y] = "No Student, 0.0, No Behavior, 0, No Attendance/";
        }

        Scanner sc1 = null;
        try {
            sc1 = new Scanner(classText);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
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

        student1.setText(names[0]);
        student2.setText(names[1]);
        student3.setText(names[2]);
        student4.setText(names[3]);
        student5.setText(names[4]);
        student6.setText(names[5]);
        student7.setText(names[6]);
        student8.setText(names[7]);
        student9.setText(names[8]);
        student10.setText(names[9]);
        student11.setText(names[10]);
        student12.setText(names[11]);
        student13.setText(names[12]);
        student14.setText(names[13]);
        student15.setText(names[14]);

        gridpane.add(student1,0,1);
        gridpane.add(student2, 0, 2);
        gridpane.add(student3, 0, 3);
        gridpane.add(student4,0,4);
        gridpane.add(student5, 0, 5);
        gridpane.add(student6, 0, 6);
        gridpane.add(student7,0,7);
        gridpane.add(student8, 0, 8);
        gridpane.add(student9, 0, 9);
        gridpane.add(student10,0,10);
        gridpane.add(student11, 0, 11);
        gridpane.add(student12, 0, 12);
        gridpane.add(student13,0,13);
        gridpane.add(student14, 0, 14);
        gridpane.add(student15, 0, 15);

        GridPane.setHalignment(student1, HPos.CENTER);
        GridPane.setHalignment(student2, HPos.CENTER);
        GridPane.setHalignment(student3, HPos.CENTER);
        GridPane.setHalignment(student4, HPos.CENTER);
        GridPane.setHalignment(student5, HPos.CENTER);
        GridPane.setHalignment(student6, HPos.CENTER);
        GridPane.setHalignment(student7, HPos.CENTER);
        GridPane.setHalignment(student8, HPos.CENTER);
        GridPane.setHalignment(student9, HPos.CENTER);
        GridPane.setHalignment(student10, HPos.CENTER);
        GridPane.setHalignment(student11, HPos.CENTER);
        GridPane.setHalignment(student12, HPos.CENTER);
        GridPane.setHalignment(student13, HPos.CENTER);
        GridPane.setHalignment(student14, HPos.CENTER);
        GridPane.setHalignment(student15, HPos.CENTER);

        setAlignment();

    }

    public void setAlignment()
    {
        GridPane.setHalignment(present0, HPos.CENTER);
        GridPane.setHalignment(absent0, HPos.CENTER);
        GridPane.setHalignment(name0, HPos.CENTER);
        GridPane.setHalignment(present1, HPos.CENTER);
        GridPane.setHalignment(present2, HPos.CENTER);
        GridPane.setHalignment(present3, HPos.CENTER);
        GridPane.setHalignment(present4, HPos.CENTER);
        GridPane.setHalignment(present5, HPos.CENTER);
        GridPane.setHalignment(present6, HPos.CENTER);
        GridPane.setHalignment(present7, HPos.CENTER);
        GridPane.setHalignment(present8, HPos.CENTER);
        GridPane.setHalignment(present9, HPos.CENTER);
        GridPane.setHalignment(present10, HPos.CENTER);
        GridPane.setHalignment(present11, HPos.CENTER);
        GridPane.setHalignment(present12, HPos.CENTER);
        GridPane.setHalignment(present13, HPos.CENTER);
        GridPane.setHalignment(present14, HPos.CENTER);
        GridPane.setHalignment(present15, HPos.CENTER);
        GridPane.setHalignment(present16, HPos.CENTER);
        GridPane.setHalignment(absent1, HPos.CENTER);
        GridPane.setHalignment(absent2, HPos.CENTER);
        GridPane.setHalignment(absent3, HPos.CENTER);
        GridPane.setHalignment(absent4, HPos.CENTER);
        GridPane.setHalignment(absent5, HPos.CENTER);
        GridPane.setHalignment(absent6, HPos.CENTER);
        GridPane.setHalignment(absent7, HPos.CENTER);
        GridPane.setHalignment(absent8, HPos.CENTER);
        GridPane.setHalignment(absent9, HPos.CENTER);
        GridPane.setHalignment(absent10, HPos.CENTER);
        GridPane.setHalignment(absent11, HPos.CENTER);
        GridPane.setHalignment(absent12, HPos.CENTER);
        GridPane.setHalignment(absent13, HPos.CENTER);
        GridPane.setHalignment(absent14, HPos.CENTER);
        GridPane.setHalignment(absent15, HPos.CENTER);
        GridPane.setHalignment(absent16, HPos.CENTER);
    }


}
