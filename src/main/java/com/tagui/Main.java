package com.tagui;


//"C:\Program Files\sqljdbc_9.4.0.0_enu"

//"C:\Program Files\sqljdbc_9.4.0.0_enu\sqljdbc_9.4\enu\samples\adaptive"

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application
{
    @Override
    public void start(Stage stage) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("tagui.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("SideWalk Virtual Teacher Assistant");
        //We can use this to change that default icon in the top left-hand corner by the way
        //stage.getIcons().add(new Image(<yourclassname>.class.getResourceAsStream( "icon.png" )));
        stage.show();
    }

    public static void main(String[] args)
    {
        launch();
    }
}