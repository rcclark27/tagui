package com.tagui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;

public class Controller
{
    @FXML
    Label tfMessage;

    @FXML
    Label tfOutput;

    @FXML
    TextField userLogin;

    public void click()
    {
        String message = userLogin.getText();
        String output = "Hello " + message;
        tfOutput.setText(output);
    }
}