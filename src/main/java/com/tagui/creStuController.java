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
        System.out.println(newStu);
        //BIG NEST ALERT!
        if(!Objects.equals(tempStu, "No Student, 0.0, No Behavior, 0, No Attendance\r"))//if a student is already in the requested seat
        {
            System.out.println("enters if 1");
            int ii = 0;
            while (ii<15)
            {//outer loop goes through each student in newStuds
                System.out.println(newStuds[ii]);
                if(Objects.equals(newStuds[ii], "No Student, 0.0, No Behavior, 0, No Attendance\r"))//find the next available spot
                {
                    System.out.println("enters if 1A");

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
        if (Objects.equals(tempStu,"No Student, 0.0, No Behavior, 0, No Attendance\r"))
        {//if a student is not in the seat add new student to requested seat
            System.out.println("enters if 2");

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
            if(Objects.equals(newStuds[xx], "No Student, 0.0, No Behavior, 0, No Attendance\n"))
            {tempClass.append(newStuds[xx]);}else{tempClass.append(newStuds[xx]).append("\n");}
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
        sc1.useDelimiter("\n");
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

        seatOne.setText("Seat 1\n"+names[0]);//sets the buttons to each student's name
        seatTwo.setText("Seat 2\n"+names[1]);
        seatThree.setText("Seat 3\n"+names[2]);
        seatFour.setText("Seat 4\n"+names[3]);
        seatFive.setText("Seat 5\n"+names[4]);
        seatSix.setText("Seat 6\n"+names[5]);
        seatSeven.setText("Seat 7\n"+names[6]);
        seatEight.setText("Seat 8\n"+names[7]);
        seatNine.setText("Seat 9\n"+names[8]);
        seatTen.setText("Seat 10\n"+names[9]);
        seatEleven.setText("Seat 11\n"+names[10]);
        seatTwelve.setText("Seat 12\n"+names[11]);
        seat3Teen.setText("Seat 13\n"+names[12]);
        seat4Teen.setText("Seat 14\n"+names[13]);
        seat5Teen.setText("Seat 15\n"+names[14]);

        window.show();
    }

    public void cancel(ActionEvent event) throws IOException
    {
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
        sc1.useDelimiter("\n");
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

        seatOne.setText("Seat 1\n"+names[0]);//sets the buttons to each student's name
        seatTwo.setText("Seat 2\n"+names[1]);
        seatThree.setText("Seat 3\n"+names[2]);
        seatFour.setText("Seat 4\n"+names[3]);
        seatFive.setText("Seat 5\n"+names[4]);
        seatSix.setText("Seat 6\n"+names[5]);
        seatSeven.setText("Seat 7\n"+names[6]);
        seatEight.setText("Seat 8\n"+names[7]);
        seatNine.setText("Seat 9\n"+names[8]);
        seatTen.setText("Seat 10\n"+names[9]);
        seatEleven.setText("Seat 11\n"+names[10]);
        seatTwelve.setText("Seat 12\n"+names[11]);
        seat3Teen.setText("Seat 13\n"+names[12]);
        seat4Teen.setText("Seat 14\n"+names[13]);
        seat5Teen.setText("Seat 15\n"+names[14]);

        window.show();
    }
}