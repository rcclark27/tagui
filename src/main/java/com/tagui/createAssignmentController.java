//Written By Ethan Blum in CSC 331 using JAVA
package com.tagui;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.logging.Logger;
import static java.util.logging.Level.SEVERE;


public class createAssignmentController implements Initializable { //adds an assignment to a specific student

    //Scene builder items
    @FXML TextField createAssignName;

    @FXML TextField StudentScore;

    @FXML TextField totalPoints;

    @FXML Button addAssignment;

    @FXML Button close;

    @FXML TextField studName;

    //file to be edited
    File CSC331 = new File("C:\\Users\\rebec\\IdeaProjects\\dbtest2\\tagui\\src\\main\\resources\\com\\tagui\\CSC_331.txt");
    @Override
    public void initialize(URL location, ResourceBundle resources) { //sets add assignment button to disabled unless all the boxes are compelete
        addAssignment.setDisable(true);
        if((studName.getText() != null) && (createAssignName.getText() != null)
                && (StudentScore.getText() != null) && (totalPoints.getText() != null)){
            addAssignment.setDisable(false);
        }

    }

    @FXML
    public void closeWindow(ActionEvent event) throws IOException{ //in case the teacher doesn't want to add an assignmet
                                                                   //brings teacher back to gradebookHomePage
        Parent gradeBookHomePage = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("gradeBookHomePage.fxml")));
        Scene creStuScene = new Scene(gradeBookHomePage);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(creStuScene);
        window.show();
    }//end close Window

    @FXML
    public void addAnAssignment(ActionEvent event) throws IOException{
        // temp variables
        String studSelected;
        String assignmentName;
        String stuGrade;
        String totGrade;

        //creates a writer object to edit CSC331 file
        PrintWriter addToFile = new PrintWriter(new FileWriter(CSC331, true));
        //reads file
        Scanner fileRead = new Scanner(CSC331);
        //vector that contains everything in the file
        Vector<String> FileRewrite = new Vector<>();

        int lines = 0; //counts number of lines in file
        while (fileRead.hasNextLine()){
            FileRewrite.add(fileRead.nextLine()); //adds everything to FileRewrite vector
            lines++;
        }

        //Delete Contents of CSC 331 Class to allow for updated contents
        new FileOutputStream(CSC331).close();

        try{
                    if (addAssignment.isHover()) { //if the add assignment button is clicked do this
                        studSelected = studName.getText(); //gets the user input and adds it to the studSelected temp variable
                        System.out.println(studSelected);// prints out tem variables
                        assignmentName = createAssignName.getText();////gets the user input and adds it to the assignmentName temp variable
                        System.out.println(assignmentName);// prints out tem variables
                        stuGrade = StudentScore.getText();//gets the user input and adds it to the stuGrade tem variable
                        System.out.println(stuGrade);// prints out tem variables
                        totGrade = totalPoints.getText();//gets the user input and adds it to the totGrade temp variable
                        System.out.println(totGrade);// prints out tem variables



                        String z = null; //creates a temp string and sets it to null
                        for (int i = 0; i < FileRewrite.size(); i++)
                        {
                            if(z == null) {
                                z = FileRewrite.elementAt(i); //adds line to temp variable z
                                if (z.startsWith(studSelected)) { //if the temp variable z starts with the student selected

                                    //adds on to the end of the line selected
                                    String newLine = FileRewrite.elementAt(i) + "," + assignmentName + "," + stuGrade + "," + totGrade;
                                    FileRewrite.set(i, newLine); // overwrites new line with changes
                                    System.out.println(FileRewrite.elementAt(i));//prints out to make sure success


                                    for(int g = 0; g < FileRewrite.size(); g++){ //adds to file with changes
                                        System.out.println(FileRewrite.elementAt(g) + "\n"); //prints out to check for success
                                        addToFile.append(FileRewrite.elementAt(g) + "\n"); //adds to file
                                    }
                                }

                            }
                            else{
                                z = null; // sets z to null if it isn't equal to null
                            }
                        }

                        addToFile.close();//needs to be closed twice for some reason. Do not delete I know it looks weird

                        //goes back to grade book home page with file added
                        Parent gradeBookHomePage = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("gradeBookHomePage.fxml")));
                        Scene creStuScene = new Scene(gradeBookHomePage);
                        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        window.setScene(creStuScene);
                        window.show();
                    }
                }
        catch (IOException e){
            Logger.getLogger(getClass().getName()).log(SEVERE, null, e); // logs IOException
        }

        fileRead.close(); //closes file read
        addToFile.flush(); //flushes the data from the ram and into storage
        addToFile.close(); //needs to be closed twice for some reason. Do not delete I know it looks weird
    }//end addAssignment



}
