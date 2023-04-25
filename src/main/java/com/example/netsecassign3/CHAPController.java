package com.example.netsecassign3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;

import java.util.Random;

public class CHAPController {

    public static int status = 0;
    public int answer;

    @FXML
    private Button NodeAButton;
    static Random rand = new Random();

    @FXML
    private Button NodeBButton;

    @FXML
    private TextArea aArea;

    @FXML
    private TextArea bArea;

    @FXML
    private Label label;

    @FXML
    void reset(ActionEvent event) {
        status = 0;
        label.setText("Click Request to initiate the CHAP");
        aArea.setText("");
        bArea.setText("");
        NodeBButton.setVisible(false);
        NodeAButton.setVisible(true);
        NodeAButton.setText("REQUEST");
        label.setTextFill(Color.BLACK);
    }


    @FXML
    void requestFunc(ActionEvent event) {
        if(status == 1){
            if(aArea.getText().isEmpty()){
                label.setText("Enter Text");
                label.setTextFill(Color.RED);
                return;
            }
            String nodeAAnswer = aArea.getText();
            NodeAButton.setVisible(false);
            aArea.setText("");
            if(nodeAAnswer.equals(String.valueOf(answer))) {
                label.setText("Authentication Successful");
                label.setTextFill(Color.GREEN);
                return;
            }
            label.setText("Authentication Failed");
            label.setTextFill(Color.RED);
            return;


        }
        NodeAButton.setVisible(false);
        label.setText("Node A is waiting for Challenge Packet");
        NodeBButton.setVisible(true);
        status = 1;
        bArea.setWrapText(true);
        bArea.setText("Acknowledgement Received. Challenge Packet Pending");




    }

    @FXML
    void sendAction(ActionEvent event) {
        NodeBButton.setVisible(false);
        NodeAButton.setVisible(true);
        NodeAButton.setText("VERIFY");
        int challenge = rand.nextInt(100);

        bArea.setText("Challenge: " + challenge + "\nUse the correct formula to verify your identity.");
        bArea.setWrapText(true);

        answer = challenge * challenge % challenge * 10;
        label.setText("Use Area Below to Verify the Challenge");



    }



}
