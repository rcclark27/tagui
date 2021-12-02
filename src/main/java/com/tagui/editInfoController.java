package com.tagui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Objects;
import java.util.Scanner;
import java.util.Vector;

public class editInfoController
{

    @FXML
    private Button backButton;

    @FXML
    private TextField enterEmail;

    @FXML
    private TextField enterFirst;

    @FXML
    private TextField enterLast;

    @FXML
    private TextField enterPassword;

    @FXML
    private Button submitButton;

    public void editBackButton(ActionEvent event) throws IOException
    {
        Parent myInfoParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("myinfo.fxml")));
        Scene myInfoScene = new Scene(myInfoParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(myInfoScene);
        window.show();
    }

    public void editSubmitClicked(ActionEvent event) throws IOException
    {//loop thru users.csv and find the user by email, put user info into array, edit array with new info

        File users = new File("C:\\Users\\rebec\\IdeaProjects\\dbtest2\\tagui\\src\\main\\resources\\com\\tagui\\users.csv");
        Scanner sc1 = new Scanner(users);
        sc1.useDelimiter(",");

        int i = 0;
        while(sc1.hasNextLine())
        {
            String next = sc1.nextLine();
            String[] bleh = next.split(",");
            if(bleh[0] == Controller.userEmail)
            {
                bleh[0] = enterEmail.getText();
                bleh[1] = enterFirst.getText();
                bleh[2] = enterPassword.getText();
                String editedUser = bleh[0]+", "+bleh[1]+", "+bleh[2];
                Vector<String> wholeThing = new Vector<String>();
                Scanner sc2 = new Scanner(users);
                int z = 0;
                while (sc2.hasNext())
                {
                    String next2 = sc2.nextLine();
                    wholeThing.set(z, next2);
                    z++;
                }
                wholeThing.set(i,editedUser);
                FileWriter writer = new FileWriter(users);
                writer.write(String.valueOf(wholeThing));
                writer.close();
                break;
            }

            i++;

        }

        Controller.userEmail = enterEmail.getText();
        Controller.userName = enterFirst.getText();
        Controller.userPw = enterPassword.getText();



    }

}