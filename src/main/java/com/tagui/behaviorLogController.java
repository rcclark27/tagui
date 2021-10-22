package com.tagui;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.chrono.AbstractChronology;
import java.util.Objects;

public class behaviorLogController
{
    public void logBehavior(ActionEvent event) throws IOException
    {
        Parent popUpParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("behaviorpopup.fxml")));
        Scene popUpScene = new Scene(popUpParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(popUpScene);
        window.show();
    }

    public void greenButton(ActionEvent event) throws IOException
    {
        AnchorPane popup = new AnchorPane();
        Scene popupScene = new Scene(popup,600,400);
        Stage newPopup = new Stage();

        Image icon = new Image(getClass().getResourceAsStream("GreenMonster.png"));

        newPopup.setTitle("Good Behavior");
        newPopup.getIcons().add(icon);
        newPopup.setScene(popupScene);
        newPopup.show();

    }

    public void yellowButton(ActionEvent event) throws IOException
    {
        AnchorPane popup = new AnchorPane();
        Scene popupScene = new Scene(popup,600,400);
        Stage newPopup = new Stage();

        Image icon = new Image(getClass().getResourceAsStream("YellowMonster.png"));

        newPopup.setTitle("Warning Behavior");
        newPopup.getIcons().add(icon);
        newPopup.setScene(popupScene);
        newPopup.show();

    }

    public void redButton(ActionEvent event) throws IOException
    {
        AnchorPane popup = new AnchorPane();
        Scene popupScene = new Scene(popup,600,400);
        Stage newPopup = new Stage();

        Image icon = new Image(getClass().getResourceAsStream("RedMonster.png"));

        newPopup.setTitle("Bad Behavior");
        newPopup.setScene(popupScene);
        newPopup.getIcons().add(icon);
        newPopup.show();

    }

    public void backButton(ActionEvent event) throws IOException
    {
        Parent homePageParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("homePage.fxml")));
        Scene homePageScene = new Scene(homePageParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(homePageScene);
        window.show();
    }

}
