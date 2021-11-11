//(')>

package com.tagui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

//NOTE: THIS WILL AUTOMATICALLY EDIT THE CSV SO BE READY TO HAVE BACKUPS IN CASE OF ERRORS (there shouldn't be any errors that break the whole file anymore but still be careful lol)

public class creStuController extends myClassController
{
    @FXML
    private TextField attField;
    @FXML
    private TextField behField;
    @FXML
    private TextField gpaField;
    @FXML
    private Label myLabel;
    @FXML
    private TextField nameField;
    @FXML
    private TextField seatField;
    @FXML
    private Button createButton;

    String stuName;
    double stuGpa;
    String stuBeh;
    int stuSeat;
    String stuAtt;
    String[] newStuds = HomePage.studs;
    File classText = new File("C:\\Users\\rebec\\IdeaProjects\\dbtest2\\tagui\\src\\main\\resources\\com\\tagui\\classTest.txt");
    StringBuilder tempClass = new StringBuilder();
    String newStu;

    public void create(ActionEvent event) throws IOException
    {
        stuName = nameField.getText();//fills student info with user completed fields
        stuGpa = Double.parseDouble(gpaField.getText());
        stuBeh = behField.getText();
        stuSeat = Integer.parseInt(seatField.getText());
        stuAtt = attField.getText();
        newStu = (stuName+","+String.valueOf(stuGpa)+","+stuBeh+","+String.valueOf(stuSeat)+","+stuAtt);
        String tempStu = String.valueOf(newStuds[stuSeat-1]);//used for checking if a student is occupying the seat
        System.out.println(tempStu);
        //BIG NEST ALERT!
        if(!Objects.equals(tempStu, "No Student, 0.0, No Behavior, 0, No Attendance"))//if a student is already in the requested seat
        {
            int ii = 0;
            while (ii<15)
            {//outer loop goes through each student in newStuds
                if(Objects.equals(newStuds[ii], "No Student, 0.0, No Behavior, 0, No Attendance"))//find the next available spot
                {
                    Scanner sc2 = new Scanner(String.valueOf(tempStu));
                    sc2.useDelimiter(",");
                    String[] tempStuInfo = new String[5];
                    for (int w = 0; w < 5; w++)
                    {//inner loop fills a temporary student info array with ONE student's info
                        tempStuInfo[w] = String.valueOf(sc2.next());
                    }
                    tempStuInfo[3] = String.valueOf(ii+1);//updates tempStu's seat
                    tempStu = String.valueOf(tempStuInfo[0]+","+ tempStuInfo[1]+","+ tempStuInfo[2]+","+ tempStuInfo[3]+","+ tempStuInfo[4]);//re writes tempStu
                    newStuds[ii] = tempStu;//put old student in next available seat
                    newStuds[stuSeat-1] = newStu;//put new student in requested seat
                    break;
                }
                ii++;
            }

        }
        if (Objects.equals(tempStu,"No Student, 0.0, No Behavior, 0, No Attendance"))
        {//if a student is not in the seat add new student to requested seat
            newStuds[stuSeat-1] = newStu;
        }

        /*int p = 0;//just for testing if the array is being changed
        while(p<15)
        {
            System.out.println((p+1)+": "+newStuds[p]);
            p++;
        }*/

        FileWriter writer = new FileWriter(classText);
        int xx=0;
        while(xx<15)//recreates the class with the new student added
        {
            if(Objects.equals(newStuds[xx], "No Student, 0.0, No Behavior, 0, No Attendance/"))
            {tempClass.append(newStuds[xx]);}else{tempClass.append(newStuds[xx]).append("/");}
            //no student already has a / and // breaks everything so this checks before adding a /
            xx++;
        }

        writer.write(String.valueOf(tempClass));//rewrites the csv with the updated class
        writer.flush();
        writer.close();
        HomePage.studs = newStuds;

        // re calls the HomePage methods to open myClass, this time with the new class
        Parent myClassParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("myclass.fxml")));
        Scene myClassScene = new Scene(myClassParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(myClassScene);

        /*for (int y = 0; y<15; y++)
        {//only used to fix null issue when creating new array in HomePage
            newStuds[y] = "No Student, 0.0, No Behavior, 0, No Attendance";
        }
        still useful to keep in case you want to empty the class and make it all No Student*/

        Scanner sc1 = new Scanner(classText);
        sc1.useDelimiter("/");
        int i = 0;
        while (sc1.hasNext())//reads class and separates students and places them into newStuds array, prolly dont need to do this again but it works
        {
            newStuds[i] = sc1.next();
            i++;
        }

        String[] names = new String[15];
        String[] stuInfo = new String[5];
        for (int x=0; x<15; x++)//NESTED LOOP ALERT WOOP WOOP
        {
            Scanner sc2 = new Scanner(String.valueOf(newStuds[x]));
            sc2.useDelimiter(",");//outer loop goes through each student in newStuds

            for (int c = 0; c < 5; c++)
            {
                stuInfo[c] = String.valueOf(sc2.next());//inner loop fills a temporary student info array with ONE student's info
            }

            names[x] = String.valueOf(stuInfo[0]);//fills up an array with the names of each student
            sc2.close();
        }

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
}