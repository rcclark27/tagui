package com.tagui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application
{

    @Override
    public void start(Stage stage) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("tagui.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("SideWalk Teacher Assistant");
        //We can use this to change that default icon in the top left-hand corner by the way
        Image icon = new Image(getClass().getResourceAsStream("sidewalk.png"));
        stage.getIcons().add(icon);
        //stage.getIcons().add(new Image(<yourclassname>.class.getResourceAsStream( "icon.png" )));
        stage.show();

    }

    public static void main(String[] args)
    {
        launch();
    }
}