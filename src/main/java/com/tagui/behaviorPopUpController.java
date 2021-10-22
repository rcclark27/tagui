package com.tagui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.application.Application;

import java.io.IOException;
import java.util.Objects;

public class behaviorPopUpController extends behaviorPopUpTwoController implements Initializable
{
    @FXML private TextField tfStudentName;

    public void enterStudent(ActionEvent event) throws IOException
    {
        Parent popUpParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("behaviorpopuptwo.fxml")));
        Scene popUpScene = new Scene(popUpParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(popUpScene);
        static_label.setText(tfStudentName.getText() + "'s");

        window.show();
    }


}
