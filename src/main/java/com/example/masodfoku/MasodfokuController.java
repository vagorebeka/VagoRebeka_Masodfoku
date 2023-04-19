package com.example.masodfoku;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class MasodfokuController {
    public Button szamolButton;
    public Label eredmenyLabel;
    public TextField aField;
    public TextField bField;
    public TextField cField;
    double a;
    double b;
    double c;

    @FXML

    public boolean szamokEllenoriz(){
        boolean szamokKitoltve = false;
        if (aField.getText().trim() == "" || bField.getText().trim() == "" || cField.getText().trim() == ""){
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Nem lett szám megadva!", ButtonType.OK);
            alert.showAndWait();
        }else{
            try {
                a = Double.parseDouble(aField.getText());
                b = Double.parseDouble(bField.getText());
                c = Double.parseDouble(cField.getText());
                szamokKitoltve = true;
            }catch(Exception e){
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Csak számot adjon meg!", ButtonType.OK);
                alert.showAndWait();
            }
        }
        return szamokKitoltve;
    }

    public boolean diszkriminansEllenoriz(){
        boolean diszkriminansNemNegativ = true;
        double diszkriminans = Math.pow(b,b)-4*a*c;
        if (diszkriminans<0){
            diszkriminansNemNegativ = false;
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Nem oldható meg a valós számok halmazán", ButtonType.OK);
            alert.showAndWait();
        }
        return diszkriminansNemNegativ;
    }

    public void szamolButtonClick(ActionEvent actionEvent) {
        if (szamokEllenoriz() && diszkriminansEllenoriz()){
            a = Double.parseDouble(aField.getText());
            b = Double.parseDouble(bField.getText());
            c = Double.parseDouble(cField.getText());
            double x1 = 0;
            double x2 = 0;
            x1 = (0-b+(Math.sqrt(Math.pow(b,b)-4*a*c)))/(2*a);
            x2 = (0-b-(Math.sqrt(Math.pow(b,b)-4*a*c)))/(2*a);
            if (x1 == x2){
                eredmenyLabel.setText("x1 = x2 = " + String.valueOf(x1));
            }else{
                eredmenyLabel.setText("x1 = " + String.valueOf(x1) + "\nx2 = " + String.valueOf(x2));
            }
        }
    }
}