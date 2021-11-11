//(')>

package com.tagui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Scanner;

public class myClassController implements Initializable
{


    @FXML
    private Button newStuButton;
    @FXML
    private Button seat1;
    @FXML
    private Button seat10;
    @FXML
    private Button seat11;
    @FXML
    private Button seat12;
    @FXML
    private Button seat13;
    @FXML
    private Button seat14;
    @FXML
    private Button seat15;
    @FXML
    private Button seat2;
    @FXML
    private Button seat3;
    @FXML
    private Button seat4;
    @FXML
    private Button seat5;
    @FXML
    private Button seat6;
    @FXML
    private Button seat7;
    @FXML
    private Button seat8;
    @FXML
    private Button seat9;
    @FXML
    private Button updateButt;
    @FXML
    private Label testLab;
    @FXML
    private Label stuAttLabel;
    @FXML
    private Label stuBehLab;
    @FXML
    private Label stuGpaLabel;
    @FXML
    private Label stuNamLabel;
    @FXML
    private Label stuSeaLabel;

    public static Button seatOne;
    public static Button seatTwo;
    public static Button seatThree;
    public static Button seatFour;
    public static Button seatFive;
    public static Button seatSix;
    public static Button seatSeven;
    public static Button seatEight;
    public static Button seatNine;
    public static Button seatTen;
    public static Button seatEleven;
    public static Button seatTwelve;
    public static Button seat3Teen;
    public static Button seat4Teen;
    public static Button seat5Teen;


    public void createNewStuClicked(ActionEvent event) throws IOException//opens create new student window
    {
        Parent creStuParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("createStu.fxml")));
        Scene creStuScene = new Scene(creStuParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(creStuScene);
        window.show();
    }

    @FXML
    public void showStu1(ActionEvent event)//displays student info, exact same for each button
    {
        String[] newStuds = HomePage.studs;
        String[] stuInfo = new String[5];

        Scanner sc2 = new Scanner(String.valueOf(newStuds[0]));
        sc2.useDelimiter(",");
        for (int c = 0; c < 5; c++)
        {
            stuInfo[c] = String.valueOf(sc2.next());//makes an array with this student's info
        }
        sc2.close();

        stuNamLabel.setText("Name: "+stuInfo[0]);//sets the labels as the student's info
        stuGpaLabel.setText("GPA: "+stuInfo[1]);
        stuBehLab.setText("Behavior "+stuInfo[2]);
        stuSeaLabel.setText("Seat: "+stuInfo[3]);
        stuAttLabel.setText("Attendance: "+stuInfo[4]);
    }

    @FXML
    public void showStu2(ActionEvent event)
    {
        String[] newStuds = HomePage.studs;
        String[] stuInfo = new String[5];

        Scanner sc2 = new Scanner(String.valueOf(newStuds[1]));
        sc2.useDelimiter(",");
        for (int c = 0; c < 5; c++)
        {
            stuInfo[c] = String.valueOf(sc2.next());
        }
        sc2.close();

        stuNamLabel.setText("Name: "+stuInfo[0]);
        stuGpaLabel.setText("GPA: "+stuInfo[1]);
        stuBehLab.setText("Behavior "+stuInfo[2]);
        stuSeaLabel.setText("Seat: "+stuInfo[3]);
        stuAttLabel.setText("Attendance: "+stuInfo[4]);
    }

    @FXML
    public void showStu3(ActionEvent event)
    {
        String[] newStuds = HomePage.studs;
        String[] stuInfo = new String[5];

        Scanner sc2 = new Scanner(String.valueOf(newStuds[2]));
        sc2.useDelimiter(",");
        for (int c = 0; c < 5; c++)
        {
            stuInfo[c] = String.valueOf(sc2.next());
        }
        sc2.close();

        stuNamLabel.setText("Name: "+stuInfo[0]);
        stuGpaLabel.setText("GPA: "+stuInfo[1]);
        stuBehLab.setText("Behavior "+stuInfo[2]);
        stuSeaLabel.setText("Seat: "+stuInfo[3]);
        stuAttLabel.setText("Attendance: "+stuInfo[4]);
    }

    @FXML
    public void showStu4(ActionEvent event)
    {
        String[] newStuds = HomePage.studs;
        String[] stuInfo = new String[5];

        Scanner sc2 = new Scanner(String.valueOf(newStuds[3]));
        sc2.useDelimiter(",");
        for (int c = 0; c < 5; c++)
        {
            stuInfo[c] = String.valueOf(sc2.next());
        }
        sc2.close();

        stuNamLabel.setText("Name: "+stuInfo[0]);
        stuGpaLabel.setText("GPA: "+stuInfo[1]);
        stuBehLab.setText("Behavior "+stuInfo[2]);
        stuSeaLabel.setText("Seat: "+stuInfo[3]);
        stuAttLabel.setText("Attendance: "+stuInfo[4]);
    }

    @FXML
    public void showStu5(ActionEvent event)
    {
        String[] newStuds = HomePage.studs;
        String[] stuInfo = new String[5];

        Scanner sc2 = new Scanner(String.valueOf(newStuds[4]));
        sc2.useDelimiter(",");
        for (int c = 0; c < 5; c++)
        {
            stuInfo[c] = String.valueOf(sc2.next());
        }
        sc2.close();

        stuNamLabel.setText("Name: "+stuInfo[0]);
        stuGpaLabel.setText("GPA: "+stuInfo[1]);
        stuBehLab.setText("Behavior "+stuInfo[2]);
        stuSeaLabel.setText("Seat: "+stuInfo[3]);
        stuAttLabel.setText("Attendance: "+stuInfo[4]);
    }

    @FXML
    public void showStu6(ActionEvent event)
    {
        String[] newStuds = HomePage.studs;
        String[] stuInfo = new String[5];

        Scanner sc2 = new Scanner(String.valueOf(newStuds[5]));
        sc2.useDelimiter(",");
        for (int c = 0; c < 5; c++)
        {
            stuInfo[c] = String.valueOf(sc2.next());
        }
        sc2.close();

        stuNamLabel.setText("Name: "+stuInfo[0]);
        stuGpaLabel.setText("GPA: "+stuInfo[1]);
        stuBehLab.setText("Behavior "+stuInfo[2]);
        stuSeaLabel.setText("Seat: "+stuInfo[3]);
        stuAttLabel.setText("Attendance: "+stuInfo[4]);
    }

    @FXML
    public void showStu7(ActionEvent event)
    {
        String[] newStuds = HomePage.studs;
        String[] stuInfo = new String[5];

        Scanner sc2 = new Scanner(String.valueOf(newStuds[6]));
        sc2.useDelimiter(",");
        for (int c = 0; c < 5; c++)
        {
            stuInfo[c] = String.valueOf(sc2.next());
        }
        sc2.close();

        stuNamLabel.setText("Name: "+stuInfo[0]);
        stuGpaLabel.setText("GPA: "+stuInfo[1]);
        stuBehLab.setText("Behavior "+stuInfo[2]);
        stuSeaLabel.setText("Seat: "+stuInfo[3]);
        stuAttLabel.setText("Attendance: "+stuInfo[4]);
    }

    @FXML
    public void showStu8(ActionEvent event)
    {
        String[] newStuds = HomePage.studs;
        String[] stuInfo = new String[5];

        Scanner sc2 = new Scanner(String.valueOf(newStuds[7]));
        sc2.useDelimiter(",");
        for (int c = 0; c < 5; c++)
        {
            stuInfo[c] = String.valueOf(sc2.next());
        }
        sc2.close();

        stuNamLabel.setText("Name: "+stuInfo[0]);
        stuGpaLabel.setText("GPA: "+stuInfo[1]);
        stuBehLab.setText("Behavior "+stuInfo[2]);
        stuSeaLabel.setText("Seat: "+stuInfo[3]);
        stuAttLabel.setText("Attendance: "+stuInfo[4]);
    }

    @FXML
    public void showStu9(ActionEvent event)
    {
        String[] newStuds = HomePage.studs;
        String[] stuInfo = new String[5];

        Scanner sc2 = new Scanner(String.valueOf(newStuds[8]));
        sc2.useDelimiter(",");
        for (int c = 0; c < 5; c++)
        {
            stuInfo[c] = String.valueOf(sc2.next());
        }
        sc2.close();

        stuNamLabel.setText("Name: "+stuInfo[0]);
        stuGpaLabel.setText("GPA: "+stuInfo[1]);
        stuBehLab.setText("Behavior "+stuInfo[2]);
        stuSeaLabel.setText("Seat: "+stuInfo[3]);
        stuAttLabel.setText("Attendance: "+stuInfo[4]);
    }

    @FXML
    public void showStu10(ActionEvent event)
    {
        String[] newStuds = HomePage.studs;
        String[] stuInfo = new String[5];

        Scanner sc2 = new Scanner(String.valueOf(newStuds[9]));
        sc2.useDelimiter(",");
        for (int c = 0; c < 5; c++)
        {
            stuInfo[c] = String.valueOf(sc2.next());
        }
        sc2.close();

        stuNamLabel.setText("Name: "+stuInfo[0]);
        stuGpaLabel.setText("GPA: "+stuInfo[1]);
        stuBehLab.setText("Behavior "+stuInfo[2]);
        stuSeaLabel.setText("Seat: "+stuInfo[3]);
        stuAttLabel.setText("Attendance: "+stuInfo[4]);
    }

    @FXML
    public void showStu11(ActionEvent event)
    {
        String[] newStuds = HomePage.studs;
        String[] stuInfo = new String[5];

        Scanner sc2 = new Scanner(String.valueOf(newStuds[10]));
        sc2.useDelimiter(",");
        for (int c = 0; c < 5; c++)
        {
            stuInfo[c] = String.valueOf(sc2.next());
        }
        sc2.close();

        stuNamLabel.setText("Name: "+stuInfo[0]);
        stuGpaLabel.setText("GPA: "+stuInfo[1]);
        stuBehLab.setText("Behavior "+stuInfo[2]);
        stuSeaLabel.setText("Seat: "+stuInfo[3]);
        stuAttLabel.setText("Attendance: "+stuInfo[4]);
    }

    @FXML
    public void showStu12(ActionEvent event)
    {
        String[] newStuds = HomePage.studs;
        String[] stuInfo = new String[5];

        Scanner sc2 = new Scanner(String.valueOf(newStuds[11]));
        sc2.useDelimiter(",");
        for (int c = 0; c < 5; c++)
        {
            stuInfo[c] = String.valueOf(sc2.next());
        }
        sc2.close();

        stuNamLabel.setText("Name: "+stuInfo[0]);
        stuGpaLabel.setText("GPA: "+stuInfo[1]);
        stuBehLab.setText("Behavior "+stuInfo[2]);
        stuSeaLabel.setText("Seat: "+stuInfo[3]);
        stuAttLabel.setText("Attendance: "+stuInfo[4]);
    }

    @FXML
    public void showStu13(ActionEvent event)
    {
        String[] newStuds = HomePage.studs;
        String[] stuInfo = new String[5];

        Scanner sc2 = new Scanner(String.valueOf(newStuds[12]));
        sc2.useDelimiter(",");
        for (int c = 0; c < 5; c++)
        {
            stuInfo[c] = String.valueOf(sc2.next());
        }
        sc2.close();

        stuNamLabel.setText("Name: "+stuInfo[0]);
        stuGpaLabel.setText("GPA: "+stuInfo[1]);
        stuBehLab.setText("Behavior "+stuInfo[2]);
        stuSeaLabel.setText("Seat: "+stuInfo[3]);
        stuAttLabel.setText("Attendance: "+stuInfo[4]);
    }

    @FXML
    public void showStu14(ActionEvent event)
    {
        String[] newStuds = HomePage.studs;
        String[] stuInfo = new String[5];

        Scanner sc2 = new Scanner(String.valueOf(newStuds[13]));
        sc2.useDelimiter(",");
        for (int c = 0; c < 5; c++)
        {
            stuInfo[c] = String.valueOf(sc2.next());
        }
        sc2.close();

        stuNamLabel.setText("Name: "+stuInfo[0]);
        stuGpaLabel.setText("GPA: "+stuInfo[1]);
        stuBehLab.setText("Behavior "+stuInfo[2]);
        stuSeaLabel.setText("Seat: "+stuInfo[3]);
        stuAttLabel.setText("Attendance: "+stuInfo[4]);
    }

    @FXML
    public void showStu15(ActionEvent event)
    {
        String[] newStuds = HomePage.studs;
        String[] stuInfo = new String[5];

        Scanner sc2 = new Scanner(String.valueOf(newStuds[14]));
        sc2.useDelimiter(",");
        for (int c = 0; c < 5; c++)
        {
            stuInfo[c] = String.valueOf(sc2.next());
        }
        sc2.close();

        stuNamLabel.setText("Name: "+stuInfo[0]);
        stuGpaLabel.setText("GPA: "+stuInfo[1]);
        stuBehLab.setText("Behavior "+stuInfo[2]);
        stuSeaLabel.setText("Seat: "+stuInfo[3]);
        stuAttLabel.setText("Attendance: "+stuInfo[4]);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        seatOne = seat1;//sets the buttons to automatically show names
        seatTwo = seat2;
        seatThree = seat3;
        seatFour = seat4;
        seatFive = seat5;
        seatSix = seat6;
        seatSeven = seat7;
        seatEight = seat8;
        seatNine = seat9;
        seatTen = seat10;
        seatEleven = seat11;
        seatTwelve = seat12;
        seat3Teen = seat13;
        seat4Teen = seat14;
        seat5Teen = seat15;
    }
}