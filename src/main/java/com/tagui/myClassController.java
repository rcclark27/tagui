package com.tagui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.Objects;

public class myClassController
{
    // Not sure if there is a easier way to do this but it works
    public void backButton(ActionEvent event) throws IOException
    {
        Parent homePageParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("homePage.fxml")));
        Scene homePageScene = new Scene(homePageParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(homePageScene);
        window.show();
    }

}
