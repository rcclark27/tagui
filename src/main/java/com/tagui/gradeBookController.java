//Written By Ethan Blum in CSC 331 using JAVA
package com.tagui;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.*;
import java.net.URL;
import java.util.*;

public class gradeBookController implements Initializable {
    //global variables
    int read = 0;
    int addToVector = 0;
    private ObservableList<Assignment> data = FXCollections.observableArrayList();

    //scene builder items
    @FXML
    public ChoiceBox<String> chooseClass; //left pane

    @FXML
    public Label totalGradeFinalNum;

    @FXML
    public VBox studentVBox;

    @FXML
    public static ListView<String> studentSelection; //list of classes

    @FXML
    public TableView<Assignment> assignmentView;

    @FXML
    public TableColumn<Assignment, String> allAssignments; //assignments column

    @FXML
    public TableColumn<Assignment, String> Grades; // grades column

    @FXML
    public TableColumn<Assignment, String> totalGrade; //total Grades column

    //student buttons from scene builder
    @FXML
    public Button StudentButton;
    @FXML
    public Button student1;
    @FXML
    public Button student2;
    @FXML
    public Button student3;
    @FXML
    public Button student4;
    @FXML
    public Button student5;
    @FXML
    public Button student6;
    @FXML
    public Button student7;
    @FXML
    public Button student8;
    @FXML
    public Button student9;
    @FXML
    public Button student10;
    @FXML
    public Button student11;
    @FXML
    public Button student12;
    @FXML
    public Button student13;
    @FXML
    public Button student14;

    //add assignment button in the bottom right
    @FXML
    public Button addAssignment;
    //file with student assignment info
    File CSC331 = new File("C:\\Users\\rebec\\IdeaProjects\\dbtest2\\tagui\\src\\main\\resources\\com\\tagui\\CSC_331.txt");
    Reader fileReader = new FileReader(CSC331);

    // list of students in the class
    @FXML
    Vector<String> students = new Vector<>();

    public gradeBookController() throws FileNotFoundException {
    }

    @FXML
    public void initialize(URL location, ResourceBundle resourcesS) {

        chooseClass.setValue("Choose Your Class!");//title of class selection
        chooseClass.getItems().add("CSC 331");//values in the list

        //Set up columns in the table
        allAssignments.setCellValueFactory(new PropertyValueFactory<Assignment, String>("assignment"));
        Grades.setCellValueFactory(new PropertyValueFactory<Assignment, String>("grade"));
        totalGrade.setCellValueFactory(new PropertyValueFactory<Assignment, String>("maxScore"));

        //asserts that the columns aren't null to get rid of errors
        assert assignmentView.getRowFactory() != null : "true";
        assert allAssignments == null : "true";
        assert Grades == null : "true";
        assert totalGrade == null : "true";

        //asserts that the student button isn't null getting rid of errors
        assert StudentButton == null : "true";
        assert student1 == null : "true";
        assert student2 == null : "true";
        assert student3 == null : "true";
        assert student4 == null : "true";
        assert student5 == null : "true";
        assert student6 == null : "true";
        assert student7 == null : "true";
        assert student8 == null : "true";
        assert student9 == null : "true";
        assert student10 == null : "true";
        assert student11 == null : "true";
        assert student12 == null : "true";
        assert student13 == null : "true";
        assert student14 == null : "true";
        
        //makes the buttons unable to be seen until the class is selected
        StudentButton.setVisible(false);
        student1.setVisible(false);
        student2.setVisible(false);
        student3.setVisible(false);
        student4.setVisible(false);
        student5.setVisible(false);
        student6.setVisible(false);
        student7.setVisible(false);
        student8.setVisible(false);
        student9.setVisible(false);
        student10.setVisible(false);
        student11.setVisible(false);
        student12.setVisible(false);
        student13.setVisible(false);
        student14.setVisible(false);

    }//end Initialize

    public void backButton(ActionEvent event) throws IOException // takes user to home page
    {
        Parent homePageParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("homePage.fxml")));
        Scene homePageScene = new Scene(homePageParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(homePageScene);
        window.show();
    }//end backButton

    public void showTeacherClasses(ActionEvent event) throws IOException
    {
        //gets selected class and sends it to classSelection method
        String getSelectedClass = chooseClass.getSelectionModel().getSelectedItem();
        classSelection(getSelectedClass);
    }//end showTeacherClasses

    public void classSelection(String selectedClass)throws IOException{
        Vector<String> classes = new Vector<>();
        classes.add("CSC 331");
        Scanner scanner = new Scanner(CSC331);

        //list of student names
        scanner.useDelimiter(",");
        int i = 0;

        //Gets the name of every student and puts it into "students" vector
        while(scanner.hasNextLine())
        {
            String z = scanner.nextLine();
            String [] zip = z.split(",");
            students.add(zip[0]);
            System.out.println(students.elementAt(i));
            i++;
        }

        scanner.close(); // close scanner

        if(classes.contains(selectedClass)){ //if teacher selectes a class that is on the list then make buttons
                                             //visible
            
            StudentButton.setVisible(true);
            student1.setVisible(true);
            student2.setVisible(true);
            student3.setVisible(true);
            student4.setVisible(true);
            student5.setVisible(true);
            student6.setVisible(true);
            student7.setVisible(true);
            student8.setVisible(true);
            student9.setVisible(true);
            student10.setVisible(true);
            student11.setVisible(true);
            student12.setVisible(true);
            student13.setVisible(true);
            student14.setVisible(true);

            //loop that declares all the students in selected class Changes the names of the buttons
            for (i = 0; i <= students.size(); i++) {

                switch (i){

                    case 0:
                        StudentButton.setText(students.get(i));
                        break;

                    case 1:
                        student1.setText(students.get(i));
                        break;

                    case 2:
                        student2.setText(students.get(i));
                        break;

                    case 3:
                        student3.setText(students.get(i));
                        break;

                    case 4:
                        student4.setText(students.get(i));
                        break;

                    case 5:
                        student5.setText(students.get(i));
                        break;

                    case 6:
                        student6.setText(students.get(i));
                        break;

                    case 7:
                        student7.setText(students.get(i));
                        break;

                    case 8:
                        student8.setText(students.get(i));
                        break;

                    case 9:
                        student9.setText(students.get(i));
                        break;

                    case 10:
                        student10.setText(students.get(i));
                        break;

                    case 11:
                        student11.setText(students.get(i));
                        break;
                    case 12:
                        student12.setText(students.get(i));
                        break;

                    case 13:
                        student13.setText(students.get(i));
                        break;

                    case 14:
                        student14.setText(students.get(i));
                        break;

                }//end switch statement

            }//end for loop

        }//end if statement

    }//end classSelection

    @FXML
    public void getStudSelection(ActionEvent event) throws IOException {//gets the student the user selects

        //if a button is pressed, the student grade is called
        if(StudentButton.isHover()) {
            String getStudentName = students.elementAt(0);
            System.out.println(getStudentName);
            data.clear();
            showStudGrades(getStudentName);
        }//end if statement
        if(student1.isHover()) {
            String getStudentName = students.elementAt(1);
            System.out.println(getStudentName);
            data.clear();
            showStudGrades(getStudentName);
        }//end if statement
        if(student2.isHover()) {
            String getStudentName = students.elementAt(2);
            System.out.println(getStudentName);
            data.clear();
            showStudGrades(getStudentName);
        }//end if statement
        if(student3.isHover()) {
            String getStudentName = students.elementAt(3);
            data.clear();
            showStudGrades(getStudentName);
        }//end if statement
        if(student4.isHover()) {
            String getStudentName = students.elementAt(4);
            data.clear();
            showStudGrades(getStudentName);
        }// end if statement
        if(student5.isHover()) {
            String getStudentName = students.elementAt(5);
            data.clear();
            showStudGrades(getStudentName);
        }//end if statement
        if(student6.isHover()) {
            String getStudentName = students.elementAt(6);
            data.clear();
            showStudGrades(getStudentName);
        }//end if statement
        if(student7.isHover()) {
            String getStudentName = students.elementAt(7);
            data.clear();
            showStudGrades(getStudentName);
        }//end if statement
        if(student8.isHover()) {
            String getStudentName = students.elementAt(8);
            data.clear();
            showStudGrades(getStudentName);
        }//end if statement
        if(student9.isHover()) {
            String getStudentName = students.elementAt(9);
            data.clear();
            showStudGrades(getStudentName);
        }//end if statement
        if(student10.isHover()) {
            String getStudentName = students.elementAt(10);
            data.clear();
            showStudGrades(getStudentName);
        }//end if statement
        if(student11.isHover()) {
            String getStudentName = students.elementAt(11);
            data.clear();
            showStudGrades(getStudentName);
        }//end if statement
        if(student12.isHover()) {
            String getStudentName = students.elementAt(12);
            data.clear();
            showStudGrades(getStudentName);
        }//end if statement
        if(student13.isHover()) {
            String getStudentName = students.elementAt(13);
            data.clear();
            showStudGrades(getStudentName);
        }//end if statement
        if(student14.isHover()) {
            String getStudentName = students.elementAt(14);
            data.clear();
            showStudGrades(getStudentName);
        }//end if statement

    }

    public ObservableList<Assignment> getAssignments(){//creates a list and initializes it
        ObservableList<Assignment> data = FXCollections.observableArrayList();
        data.add(new Assignment("hello", "hello", "hello"));
        return data;
    }

    public void showStudGrades(String studSelected) throws IOException {//shows the grades of the assignments of the selected student
        Scanner stuAssign = new Scanner(CSC331);//reads file
        Vector<String> StuInfo = new Vector<>();//the selected students info
        stuAssign.useDelimiter(",");//selects what the scanner should read

        //creates temp values and initializes them
        String anAssignment = "none";
        String assignGrade = "0";
        String totalPoints = "100";

        data.addListener(new InvalidationListener() {//adds listener to notify the system when the tableView is edited
            @Override
            public void invalidated(Observable observable) {
                    System.out.println("Data Updated");
                    assignmentView.setItems(data);
            }
        });

        Vector<Integer> realScore = new Vector<>(); //vector of the actual score the student got on the assignment
        Vector<Integer> maxScore = new Vector<>();  //vector of the total score the student could've gotten on the assignment
        String z = null;//temp string to find the student info
        while(stuAssign.hasNextLine()) //runs until the file is empty
        {
            if(z == null) { // makes sure z is empty
                z = stuAssign.nextLine(); // sets z to next line from file
                if (z.startsWith(studSelected)) { // if z starts with the name of the student
                    String[] zip = z.split(","); //splits the temp string z and adds the split string into a array
                    for (int i = 1; i < zip.length; i++) {// adds the array to the Student Info Vector skipping the first line
                                                          // of the array as it contains the students name
                        StuInfo.add(zip[i]);
                    }
                }
            }
            else{ //if z doesn't equal null it is set to null
                z = null;
            }
        }

        int g = 0; //counts the size of StuInfo for future book keeping info
            for (int i = 0; i < StuInfo.size();) {
                    read++;
                    anAssignment = StuInfo.elementAt(i); //assigns the first element in StuInfo to the temp String
                    i++; // next element

                    assignGrade = StuInfo.elementAt(i); //assigns the second element in StuInfo to the temp String
                    realScore.add(Integer.parseInt(assignGrade)); // makes the string into an int and adds it to the vector realScore
                    i++; // next element

                    totalPoints = StuInfo.elementAt(i); //assigns the third element in StuInfo to the temp String
                    maxScore.add(Integer.parseInt(totalPoints)); // makes the string into an int and adds it to the vector maxScore
                    i++; // next element

                    data.add(new Assignment(anAssignment, assignGrade, totalPoints)); // adds info into the ListView

                    g++;
        }

            addToVector += read;
            read = 0;
            getStudTotalGrade(realScore, maxScore);

        stuAssign.close();
    }

    public void getStudTotalGrade(Vector<Integer> realGrade, Vector<Integer> maxGrade){ //calculates students grade in class

        //variables
        double studScore = 0;
        double maxStudScore = 0;

        for(int i = 0; i < maxGrade.size(); i++){
            maxStudScore += maxGrade.elementAt(i); //adds total grade together
            if(!realGrade.isEmpty()) { // makes sure real grade isn't empty (student might not have a grade on an assignment)
                studScore += realGrade.elementAt(i); // adds students grades together
            }
            else{
                studScore += 0; // if students doesn't have a grade, add 0
            }
        }
        System.out.println(maxStudScore); // prints the totals
        System.out.println(studScore); //prints the totals

        double gradeInClass = Math.round((studScore / maxStudScore * 100)); // calculates total score and rounds it
        System.out.println(gradeInClass); // prints grade in class
        totalGradeFinalNum.setText(String.valueOf(gradeInClass) + "%"); // adds to scene
    }

    @FXML
    public void userAddAssignment(ActionEvent event) throws IOException { // brings user to another tab to add an assignment
        Parent createAssignment = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("createAssignment.fxml")));
        Scene creStuScene = new Scene(createAssignment);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(creStuScene);
        window.show();
    }
}
