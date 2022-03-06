package com.example.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField resultTV;

    @FXML
    private TextField historyTV;


    public void clear(ActionEvent actionEvent) {
        resultTV.setText("");
        historyTV.setText("");
    }

    public void squareRoot(ActionEvent actionEvent) {
        String number = resultTV.getText();
        double int_number = Double.parseDouble(number);
        int_number = Math.pow(int_number,0.5);
        resultTV.setText(Double.toString(int_number));
        historyTV.setText(number);
    }

    public void backspace(ActionEvent actionEvent) {
        String content = resultTV.getText();

        if (content.length() >0){
            content = content.substring(0, content.length()-1);
        }

        resultTV.setText(content);

    }


    public void number(ActionEvent actionEvent) {

        String content = resultTV.getText();
        Button button = (Button) actionEvent.getSource();
        content += button.getId();
        resultTV.setText(content);

    }


    public double result;
    boolean firstNumber = true;
    public String operator, history = "";

    public void operation(ActionEvent actionEvent){
        Button button = (Button) actionEvent.getSource();


        if (resultTV.getText().length() > 0){
            switch (button.getId()){
                case "+":
                    history += resultTV.getText() + " + ";
                    historyTV.setText(history);

                    if (!firstNumber)
                    {
                        switch (operator){
                            case "+":
                                result = result + Double.parseDouble(resultTV.getText());
                                break;
                            case "-":
                                result = result - Double.parseDouble(resultTV.getText());
                                break;
                            case "x":
                                result = result * Double.parseDouble(resultTV.getText());
                                break;
                            case "/":
                                result = result / Double.parseDouble(resultTV.getText());
                                break;
                        }
                        operator = "+";

                    }
                    else
                    {
                        firstNumber=false;
                        result = Double.parseDouble(resultTV.getText());
                        operator = "+";

                    }
                    resultTV.setText("");


                    break;
                case "-":
                    history += resultTV.getText() + " - ";
                    historyTV.setText(history);

                    if (!firstNumber)
                    {
                        switch (operator){
                            case "+":
                                result = result + Double.parseDouble(resultTV.getText());
                                break;
                            case "-":
                                result = result - Double.parseDouble(resultTV.getText());
                                break;
                            case "x":
                                result = result * Double.parseDouble(resultTV.getText());
                                break;
                            case "/":
                                result = result / Double.parseDouble(resultTV.getText());
                                break;
                        }
                        operator = "-";

                    }
                    else
                    {
                        firstNumber=false;
                        result = Double.parseDouble(resultTV.getText());
                        operator = "-";

                    }
                    resultTV.setText("");

                    break;
                case "x":
                    history += resultTV.getText() + " x ";
                    historyTV.setText(history);

                    if (!firstNumber)
                    {
                        switch (operator){
                            case "+":
                                result = result + Double.parseDouble(resultTV.getText());
                                break;
                            case "-":
                                result = result - Double.parseDouble(resultTV.getText());
                                break;
                            case "x":
                                result = result * Double.parseDouble(resultTV.getText());
                                break;
                            case "/":
                                result = result / Double.parseDouble(resultTV.getText());
                                break;
                        }
                        operator = "x";

                    }
                    else
                    {
                        firstNumber=false;
                        result = Double.parseDouble(resultTV.getText());
                        operator = "x";

                    }

                    resultTV.setText("");

                    break;
                case "/":
                    history += resultTV.getText() + " / ";
                    historyTV.setText(history);

                    if (!firstNumber)
                    {
                        switch (operator){
                            case "+":
                                result = result + Double.parseDouble(resultTV.getText());
                                break;
                            case "-":
                                result = result - Double.parseDouble(resultTV.getText());
                                break;
                            case "x":
                                result = result * Double.parseDouble(resultTV.getText());
                                break;
                            case "/":
                                result = result / Double.parseDouble(resultTV.getText());
                                break;
                        }
                        operator = "/";

                    }
                    else
                    {
                        firstNumber=false;
                        result = Double.parseDouble(resultTV.getText());
                        operator = "/";

                    }
                    
                    resultTV.setText("");
                    break;
                case "=":
                    history += resultTV.getText();
                    switch (operator){
                        case "+":
                            result = result + Double.parseDouble(resultTV.getText());
                            break;
                        case "-":
                            result = result - Double.parseDouble(resultTV.getText());
                            break;
                        case "x":
                            result = result * Double.parseDouble(resultTV.getText());
                            break;
                        case "/":
                            result = result / Double.parseDouble(resultTV.getText());
                            break;
                    }
                    resultTV.setText(Double.toString(result));
                    historyTV.setText(history);
                    history = "";
                    firstNumber=true;
                    break;


                default:
                    System.out.println("Operator not found!");
            }


        }





    }
}