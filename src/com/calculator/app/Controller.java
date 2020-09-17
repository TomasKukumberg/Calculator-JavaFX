package com.calculator.app;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;


public class Controller {

    @FXML
    private Text output;
    private long firstNumber = 0; //only one screen so we need to cache the first number

    private String operator = ""; //rework to enum

    private Model model = new Model();

    private boolean start = true;

    @FXML
    private void processNumpad(ActionEvent event) {
        if(start) {
            output.setText("");
            start = false;
        }
        String value = ((Button)event.getSource()).getText();
        output.setText(output.getText() + value);
    }

    @FXML
    private void processOperator(ActionEvent event) {
        String value = ((Button)event.getSource()).getText();

        if(! "=".equals(value)) {
            if(!operator.isEmpty()) {
                return; //return because we have already pressed some operator
            }
            operator = value;
            firstNumber = Long.parseLong(output.getText());
            output.setText("");
        } else {
            if(operator.isEmpty()) {
                return;
            }
            output.setText(String.valueOf(model.calculate(firstNumber, Long.parseLong(output.getText()), operator))); //calculate
            operator = ""; //clear the operator
            start = true;
        }
    }
}
