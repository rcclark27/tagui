package com.tagui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.FileWriter;

public class logAttendanceController implements Initializable
{
    
    @FXML GridPane gridpane;
    @FXML Label present0, absent0, name0;
    @FXML Label student1, student2, student3, student4, student5, student6, student7, student8, student9, student10, student11, student12, student13, student14, student15;
    @FXML CheckBox present1, present2, present3, present4, present5, present6, present7, present8, present9, present10, present11, present12, present13, present14, present15;
    @FXML CheckBox absent1, absent2, absent3, absent4, absent5, absent6, absent7, absent8, absent9, absent10, absent11, absent12, absent13, absent14, absent15;

    public void close()
    {
        System.exit(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle arg1)
    {

        String studs[] = new String[15];
        File classText = new File("C:\\Users\\rebec\\IdeaProjects\\dbtest2\\tagui\\src\\main\\resources\\com\\tagui\\classTest.txt");//adds a class csv file

        for (int y = 0; y<15; y++)//fills studs array with blank students to prevent null errors
        {
            studs[y] = "No Student,0.0,No Behavior,0,No Attendance\n";
        }

        Scanner sc1 = null;
        try {
            sc1 = new Scanner(classText);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        sc1.useDelimiter("\n");
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

    }

    public void submit(ActionEvent event) throws IOException
    {
        FileWriter writer = new FileWriter("C:\\Users\\rebec\\IdeaProjects\\dbtest2\\tagui\\src\\main\\resources\\com\\tagui\\attendancelog.csv", true);
        writer.append("\n" + getDate() + "\nHere:\n");

        if (present1.isSelected() && !absent1.isSelected())
        {
            writer.append(student1.getText() + ",");
        }

        if (present2.isSelected() && !absent2.isSelected())
        {
            writer.append(student2.getText() + ",");
        }

        if (present3.isSelected() && !absent3.isSelected())
        {
            writer.append(student3.getText() + ",");
        }

        if (present4.isSelected() && !absent4.isSelected())
        {
            writer.append(student4.getText() + ",");
        }

        if (present5.isSelected() && !absent5.isSelected())
        {
            writer.append(student5.getText() + ",");
        }

        if (present6.isSelected() && !absent6.isSelected())
        {
            writer.append(student6.getText() + ",");
        }

        if (present7.isSelected() && !absent7.isSelected())
        {
            writer.append(student7.getText() + ",");
        }

        if (present8.isSelected() && !absent8.isSelected())
        {
            writer.append(student8.getText() + ",");
        }

        if (present9.isSelected() && !absent9.isSelected())
        {
            writer.append(student9.getText() + ",");
        }

        if (present10.isSelected() && !absent10.isSelected())
        {
            writer.append(student10.getText() + ",");
        }

        if (present11.isSelected() && !absent11.isSelected())
        {
            writer.append(student11.getText() + ",");
        }

        if (present12.isSelected() && !absent12.isSelected())
        {
            writer.append(student12.getText() + ",");
        }

        if (present13.isSelected() && !absent13.isSelected())
        {
            writer.append(student13.getText() + ",");
        }

        if (present14.isSelected() && !absent14.isSelected())
        {
            writer.append(student14.getText() + ",");
        }

        if (present15.isSelected() && !absent15.isSelected())
        {
            writer.append(student15.getText() + ",");
        }

        writer.append("\nAbsent:\n");

        if (absent1.isSelected() && !present1.isSelected())
        {
            writer.append(student1.getText() + ",");
        }

        if (absent2.isSelected() && !present2.isSelected())
        {
            writer.append(student2.getText() + ",");
        }

        if (absent3.isSelected() && !present3.isSelected())
        {
            writer.append(student3.getText() + ",");
        }

        if (absent4.isSelected() && !present4.isSelected())
        {
            writer.append(student4.getText() + ",");
        }

        if (absent5.isSelected() && !present5.isSelected())
        {
            writer.append(student5.getText() + ",");
        }

        if (absent6.isSelected() && !present6.isSelected())
        {
            writer.append(student6.getText() + ",");
        }

        if (absent7.isSelected() && !present7.isSelected())
        {
            writer.append(student7.getText() + ",");
        }

        if (absent8.isSelected() && !present8.isSelected())
        {
            writer.append(student8.getText() + ",");
        }

        if (absent9.isSelected() && !present9.isSelected())
        {
            writer.append(student9.getText() + ",");
        }

        if (absent10.isSelected() && !present10.isSelected())
        {
            writer.append(student10.getText() + ",");
        }

        if (absent11.isSelected() && !present11.isSelected())
        {
            writer.append(student11.getText() + ",");
        }

        if (absent12.isSelected() && !present12.isSelected())
        {
            writer.append(student12.getText() + ",");
        }

        if (absent13.isSelected() && !present13.isSelected())
        {
            writer.append(student13.getText() + ",");
        }

        if (absent14.isSelected() && !present14.isSelected())
        {
            writer.append(student14.getText() + ",");
        }

        if (absent15.isSelected() && !present15.isSelected())
        {
            writer.append(student15.getText() + ",");
        }

        // Write an else for an error pop-up if they pick two or don't pick one
        writer.append("\n");
        writer.close();

        Parent attendanceLogParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("attendancelog.fxml")));
        Scene attendanceLogScene = new Scene(attendanceLogParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(attendanceLogScene);
        window.show();

    }

    private String getDate()
    {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        df.setTimeZone(TimeZone.getTimeZone("CST"));
        return (df.format(new Date()));
    }


}
