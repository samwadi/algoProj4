package com.example.demo3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button button4;
    @FXML
    private Button button5;
    @FXML
    private Button button6;
    @FXML
    private Button button7;
    @FXML
    private Button button8;
    @FXML
    private Button button9;
    @FXML
    private Button start;
    @FXML
    private ToggleGroup chooseDifficulty;
    @FXML
    private RadioButton easy;
    @FXML
    private RadioButton medium;
    @FXML
    private RadioButton hard;
    @FXML
     private TextArea showWinner;
    @FXML
    private Label turns;


    //game board
    int[][] xo=new int[3][3];
//    booleans
    boolean clicked=false ,started=false, oTurn=false ,ended=false;
    String difficulty ,label;
    int oPlayer=0,xPlayer=5;
    @FXML
    protected void startGame(){
        if (chooseDifficulty.getSelectedToggle()==null){
            new Alert(Alert.AlertType.ERROR, "Please Choose Difficulty").showAndWait();
            return;
        }
        resetGame();
        String s = (String) chooseDifficulty.getSelectedToggle().toString().subSequence(15,19);
        System.out.println(s.trim());
        label="Game Mode: ";
        switch (s){
            case "medi":
                difficulty="medium";
                started=true;
                oTurn=false;
                ended=false;
                xPlayer=5;oPlayer=0;
                label+="PVP";
                break;
            case "hard":
                difficulty="hard";
                started=true;
                oTurn=false;
                ended=false;
                xPlayer=5;oPlayer=0;
                label+="hard";
                break;
            case "easy":
                difficulty="easy";
                started=true;
                oTurn=false;
                ended=false;
                xPlayer=5;oPlayer=0;
                label+="easy";
                break;
        }
        System.out.println(difficulty);turns.setText(label+" turn: X's Turn!");
        resetGame();
    }
    @FXML
    protected void onHelloButtonClick(ActionEvent actionEvent) {
        if (!started){
            new Alert(Alert.AlertType.ERROR, "choose difficulty and start the game").showAndWait();
            return;
        }if (ended){
            new Alert(Alert.AlertType.ERROR, "THE GAME HAS ENDED").showAndWait();
            return;
        }
        if (clicked) {
            new Alert(Alert.AlertType.ERROR, "its not your turn").showAndWait();
            return;
        }
        if (xPlayer==0){
            printOutResults(0);
            new Alert(Alert.AlertType.ERROR, "THE GAME HAS ENDED").showAndWait();
            return;
        }
//        if (oTurn){
//            new Alert(Alert.AlertType.ERROR, "its not your turn").showAndWait();
//            return;
//        }

        String s= (String) actionEvent.getSource().toString().subSequence(10,17);
//        red
//        button2.setStyle("-fx-background-color: #7d0013");
//        green
//        #0abf00
//        System.out.println(s);
//        oTurn=true;
        clicked=true;
        switch (s){
            case "button1":
                if (oTurn){
                    midMood(button1,0,0);
                    oTurn=false;
                }
                else if (xo[0][0]!=1||xo[0][0]!=2){
                    xo[0][0]=1;
                    button1.setText("X");
                    button1.setStyle("-fx-background-color: #7d0013");
                    xPlayer--;
                    if (thereAWinner()==1||thereAWinner()==2)printOutResults(thereAWinner());
                    if (difficulty.equalsIgnoreCase("medium")) {
                        oTurn=true;
                        turns.setText(label+" turn: O's Turn!");
                    }else {
                        compMove(difficulty);
                    }                }else {
                    new Alert(Alert.AlertType.ERROR, "box already chosen").showAndWait();
                    clicked=false;
                    oTurn=false;
                    return;
                }


                break;
                case "button2":
                    if (oTurn){
                        midMood(button2,0,1);
                        oTurn=false;
                    }
                    else if (xo[0][1]!=1||xo[0][1]!=2){
                    xo[0][1]=1;
                    button2.setText("X");
                        button2.setStyle("-fx-background-color: #7d0013");
                    xPlayer--;
                        if (thereAWinner()==1||thereAWinner()==2)printOutResults(thereAWinner());
                        if (difficulty.equalsIgnoreCase("medium")) {
                            oTurn=true;
                            turns.setText(label+" turn: O's Turn!");
                        }else {
                            compMove(difficulty);
                        }                    }else {
                        new Alert(Alert.AlertType.ERROR, "box already chosen").showAndWait();
                        clicked=false;
                        oTurn=false;
                        return;
                    }

                break;
                case "button3":
                    if (oTurn){
                        midMood(button3,0,2);
                        oTurn=false;
                    }
                    else if (xo[0][2]!=1||xo[0][2]!=2){
                    xo[0][2]=1;
                    button3.setText("X");
                        button3.setStyle("-fx-background-color: #7d0013");
                        xPlayer--;
                        if (thereAWinner()==1||thereAWinner()==2)printOutResults(thereAWinner());
                        if (difficulty.equalsIgnoreCase("medium")) {
                            oTurn=true;
                            turns.setText(label+" turn: O's Turn!");
                        }else {
                            compMove(difficulty);
                        }                    }else {
                    new Alert(Alert.AlertType.ERROR, "box already chosen").showAndWait();
                    clicked=false;
                    oTurn=false;
                    return;
                }
                break;
                case "button4":
                    if (oTurn){
                        midMood(button4,1,0);
                        oTurn=false;
                    }
                    else if (xo[1][0]!=1||xo[1][0]!=2){
                    xo[1][0]=1;
                    button4.setText("X");
                        button4.setStyle("-fx-background-color: #7d0013");
                        xPlayer--;
                        if (thereAWinner()==1||thereAWinner()==2)printOutResults(thereAWinner());
                        if (difficulty.equalsIgnoreCase("medium")) {
                            oTurn=true;
                            turns.setText(label+" turn: O's Turn!");
                        }else {
                            compMove(difficulty);
                        }                    }else {
                    new Alert(Alert.AlertType.ERROR, "box already chosen").showAndWait();
                    clicked=false;
                    oTurn=false;
                    return;
                }
                break;
                case "button5":
                    if (oTurn){
                        midMood(button5,1,1);
                        oTurn=false;
                    }
                    else if (xo[1][1]!=1||xo[1][1]!=2){
                    xo[1][1]=1;
                    button5.setText("X");
                        button5.setStyle("-fx-background-color: #7d0013");
                        xPlayer--;
                        if (thereAWinner()==1||thereAWinner()==2)printOutResults(thereAWinner());
                        if (difficulty.equalsIgnoreCase("medium")) {
                            oTurn=true;
                            turns.setText(label+" turn: O's Turn!");
                        }else {
                            compMove(difficulty);
                        }                    }else {
                        new Alert(Alert.AlertType.ERROR, "box already chosen").showAndWait();
                        clicked=false;
                        oTurn=false;
                        return;
                    }
                break;
                case "button6":
                    if (oTurn){
                        midMood(button6,1,2);
                        oTurn=false;
                    }
                    else  if (xo[1][2]!=1||xo[1][2]!=2){
                        xo[1][2]=1;

                    button6.setText("X");
                        button6.setStyle("-fx-background-color: #7d0013");
                        xPlayer--;
                        if (thereAWinner()==1||thereAWinner()==2)printOutResults(thereAWinner());
                        if (difficulty.equalsIgnoreCase("medium")) {
                           oTurn=true;
                            turns.setText(label+" turn: O's Turn!");
                        }else {
                            compMove(difficulty);
                        }
                    }else {
                        new Alert(Alert.AlertType.ERROR, "box already chosen").showAndWait();
                        clicked=false;
                        oTurn=false;
                        return;
                    }
                break;
                case "button7":
                    if (oTurn){
                        midMood(button7,2,0);
                        oTurn=false;
                    }
                    else if (xo[2][0]!=1||xo[2][0]!=2){
                    xo[2][0]=1;
                    button7.setText("X");
                        button7.setStyle("-fx-background-color: #7d0013");
                        xPlayer--;
                    if (thereAWinner()==1||thereAWinner()==2)printOutResults(thereAWinner());
                        if (difficulty.equalsIgnoreCase("medium")) {
                            oTurn=true;
                            turns.setText(label+" turn: O's Turn!");
                        }else {
                            compMove(difficulty);
                        }                    }else {
                    new Alert(Alert.AlertType.ERROR, "box already chosen").showAndWait();
                    clicked=false;
                    oTurn=false;
                    return;
                }
                break;
                case "button8":
                    if (oTurn){
                        midMood(button8,2,1);
                        oTurn=false;
                    }
                    else if (xo[2][1]!=1||xo[2][1]!=2){
                    xo[2][1]=1;
                    button8.setText("X");
                        xPlayer--;
                        button8.setStyle("-fx-background-color: #7d0013");
                        if (thereAWinner()==1||thereAWinner()==2)printOutResults(thereAWinner());
                        if (difficulty.equalsIgnoreCase("medium")) {
                           oTurn=true;
                            turns.setText(label+" turn: O's Turn!");
                        }else {
                            compMove(difficulty);
                        }
                    }else {
                    new Alert(Alert.AlertType.ERROR, "box already chosen").showAndWait();
                    clicked=false;
                    oTurn=false;
                    return;
                }
                break;
                case "button9":
                    if (oTurn){
                        midMood(button9,2,2);
                        oTurn=false;
                    }
                    else if (xo[2][2]!=1||xo[2][2]!=2){
                      xo[2][2]=1;
                      button9.setText("X");
                        button9.setStyle("-fx-background-color: #7d0013");
                        xPlayer--;
                        if (thereAWinner()==1||thereAWinner()==2)printOutResults(thereAWinner());
                        if (difficulty.equalsIgnoreCase("medium")) {
                            oTurn=true;
                            turns.setText(label+" turn: O's Turn!");
                        }else {
                            compMove(difficulty);
                        }
                    }else {
                       new Alert(Alert.AlertType.ERROR, "box already chosen").showAndWait();
                        clicked=false;
                        oTurn=false;
                        return;
                     }
                break;
        }
        clicked=false;

    }
    public void compMove(String difficulty){
        switch (difficulty){
            case "easy": easyMood();
            break;
            case "hard":hardMood();
            break;
        }
    }
    public void easyMood(){
        System.out.println(Math.random()*10);
        int random = (int) (Math.random()*10);
        if (xPlayer>0) {


            switch (random) {
                case 0:
                    if (xo[0][0] == 0) {
                        xo[0][0] = 2;
                        button1.setStyle("-fx-background-color: #0abf00");
                        button1.setText("O");
                        oPlayer++;
                        if (thereAWinner() == 1 || thereAWinner() == 2) printOutResults(thereAWinner());
                    } else easyMood();
                    break;
                case 1:
                    if (xo[0][1] == 0) {
                        xo[0][1] = 2;
                        button2.setStyle("-fx-background-color: #0abf00");
                        button2.setText("O");
                        oPlayer++;
                        if (thereAWinner() == 1 || thereAWinner() == 2) printOutResults(thereAWinner());
                    } else easyMood();
                    break;

                case 2:
                    if (xo[0][2] == 0) {
                        xo[0][2] = 2;
                        button3.setStyle("-fx-background-color: #0abf00");
                        button3.setText("O");
                        oPlayer++;
                        if (thereAWinner() == 1 || thereAWinner() == 2) printOutResults(thereAWinner());
                    } else easyMood();
                    break;
                case 3:
                    if (xo[1][0] == 0) {
                        xo[1][0] = 2;
                        button4.setStyle("-fx-background-color: #0abf00");
                        button4.setText("O");
                        oPlayer++;
                        if (thereAWinner() == 1 || thereAWinner() == 2) printOutResults(thereAWinner());
                    } else easyMood();
                    break;
                case 4:
                    if (xo[1][1] == 0) {
                        xo[1][1] = 2;
                        button5.setStyle("-fx-background-color: #0abf00");
                        button5.setText("O");
                        oPlayer++;
                        if (thereAWinner() == 1 || thereAWinner() == 2) printOutResults(thereAWinner());
                    } else easyMood();
                    break;
                case 5:
                    if (xo[1][2] == 0) {
                        xo[1][2] = 2;
                        button6.setStyle("-fx-background-color: #0abf00");
                        button6.setText("O");
                        oPlayer++;
                        if (thereAWinner() == 1 || thereAWinner() == 2) printOutResults(thereAWinner());
                    } else easyMood();
                    break;
                case 6:
                    if (xo[2][0] == 0) {
                        xo[2][0] = 2;
                        button7.setStyle("-fx-background-color: #0abf00");
                        button7.setText("O");
                        oPlayer++;
                        if (thereAWinner() == 1 || thereAWinner() == 2) printOutResults(thereAWinner());
                    } else easyMood();
                    break;
                case 7:
                    if (xo[2][1] == 0) {
                        xo[2][1] = 2;
                        button8.setStyle("-fx-background-color: #0abf00");
                        button8.setText("O");
                        oPlayer++;
                        if (thereAWinner() == 1 || thereAWinner() == 2) printOutResults(thereAWinner());
                    } else easyMood();
                    break;
                case 8:
                    if (xo[2][2] == 0) {
                        xo[2][2] = 2;
                        button9.setStyle("-fx-background-color: #0abf00");
                        button9.setText("O");
                        oPlayer++;
                        if (thereAWinner() == 1 || thereAWinner() == 2) printOutResults(thereAWinner());
                    } else easyMood();
                    break;
                case 9:
                    easyMood();
                    break;
            }
        }else printOutResults(thereAWinner());
//        if (oPlayer==4){
//            ended=true;
//            printOutResults(thereAWinner());
//
//        }
    }
    public void hardMood(){
        System.out.println(Math.random()*10);
    }public void midMood(Button button,int i,int j){
        if (oTurn&&xo[i][j]==0){
            xo[i][j]=2;
            oTurn=false;clicked=false;
          button.setText("O");button.setStyle("-fx-background-color: #0abf00");
            turns.setText(label+" turn: X's Turn!");
            if (thereAWinner()==1||thereAWinner()==2)printOutResults(thereAWinner());
        }else{new Alert(Alert.AlertType.ERROR, "box already chosen").showAndWait();
            clicked=false;}
    }
    public int thereAWinner(){
        //horizontal
        for (int i = 0; i < 3; i++) {
            if (equals3(xo[i][0], xo[i][1], xo[i][2])) {
                return xo[i][0];
            }
        }
        // Vertical
        for (int i = 0; i < 3; i++) {
            if (equals3(xo[0][i], xo[1][i], xo[2][i])) {
                return xo[0][i];
            }
        }
        // Diagonal
        if (equals3(xo[0][0], xo[1][1], xo[2][2])) {
            return xo[0][0];
        }
        if (equals3(xo[2][0], xo[1][1], xo[0][2])) {
            return xo[2][0];
        }
        return 0;
    }
    private boolean equals3(int a, int b, int c) {
        return a == b && b == c && a != 0;
    }
    private void printOutResults(int winner){
        started=false;
        if (winner==1){
            showWinner.setText("The Winner Is" +
                    "\n" +
                    "X");
        }else if (winner==2){
            showWinner.setText("The Winner Is" +
                    "\n" +
                    "O");
        }else{
            showWinner.setText("The Winner Is" +
                    "\n" +
                    "none" +
                    "\n" +
                    "Its A Tied");
        }

    }
    public void resetGame(){
        button1.setText("");
        button2.setText("");
        button3.setText("");
        button4.setText("");
        button5.setText("");
        button6.setText("");
        button7.setText("");
        button8.setText("");
        button9.setText("");
        button1.setStyle("-fx-background-color: #ffffff");
        button2.setStyle("-fx-background-color: #ffffff");
        button3.setStyle("-fx-background-color: #ffffff");
        button4.setStyle("-fx-background-color: #ffffff");
        button5.setStyle("-fx-background-color: #ffffff");
        button6.setStyle("-fx-background-color: #ffffff");
        button7.setStyle("-fx-background-color: #ffffff");
        button8.setStyle("-fx-background-color: #ffffff");
        button9.setStyle("-fx-background-color: #ffffff");
        for (int i = 0; i < xo.length; i++) {
            for (int j = 0; j < xo.length; j++) {
                xo[i][j]=0;

            }

        }showWinner.setText("");
    }
}