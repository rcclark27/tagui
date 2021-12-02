package com.tagui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class myInfoController implements Initializable
{
    public void close()
    {
        System.exit(0);
    }

    @FXML
    private Button backButton;

    @FXML
    private Button emailButt;

    @FXML
    private Label emailLabel;

    @FXML
    private Button nameButt;

    @FXML
    private Label nameLabel;

    @FXML
    private Button pwButt;

    @FXML
    private Label pwLabel;

    @FXML
    private Button editButt;


    public void editButton(ActionEvent event) throws IOException
    {
        Parent homePageParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("editinfo.fxml")));
        Scene homePageScene = new Scene(homePageParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(homePageScene);
        window.show();
    }

    public void backButton(ActionEvent event) throws IOException
    {
        Parent homePageParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("homePage.fxml")));
        Scene homePageScene = new Scene(homePageParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(homePageScene);
        window.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        emailLabel.setText(Controller.userEmail);
        nameLabel.setText(Controller.userName);
        pwLabel.setText(Controller.userPw);
    }
}
