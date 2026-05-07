/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ua.org.olden.visualizingmathematics;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author olden
 */
public class AboutController {

    @FXML
    private DialogPane dialog;

    @FXML
    private Button closeBtn;

    @FXML
    private void close() {
        ((Stage) dialog.getScene().getWindow()).close();
        //((Stage) closeBtn.getScene().getWindow()).close();
    }

}
