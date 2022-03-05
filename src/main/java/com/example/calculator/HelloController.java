package com.example.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField textField;



    public void clear(ActionEvent actionEvent) {
    }

    public void squareRoot(ActionEvent actionEvent) {
    }

    public void backspace(ActionEvent actionEvent) {
    }


    public void number(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        System.out.println(button.getId());

    }

    public void operation(ActionEvent actionEvent){

    }


    public void equal(ActionEvent actionEvent) {
    }
}