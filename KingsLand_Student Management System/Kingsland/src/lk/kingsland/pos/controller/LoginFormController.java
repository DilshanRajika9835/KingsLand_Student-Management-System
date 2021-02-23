package lk.kingsland.pos.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class LoginFormController {
    public TextField txtusername;
    public AnchorPane root;
    public TextField txtpassword;

    public void btnloginOnAction(ActionEvent actionEvent) throws IOException {
        if(txtpassword.getText().length()>0&&txtusername.getText().length()>0){
            if (txtusername.getText().equalsIgnoreCase("Admin")&&txtpassword.getText().equalsIgnoreCase("1234")) {
                this.root.getChildren().clear();
                this.root.getChildren().add(FXMLLoader.load(this.getClass().getResource("/lk/kingsland/pos/view/DashBoardForm.fxml")));
            } else{
                new Alert(Alert.AlertType.WARNING, "Invalid UserName or Password!", ButtonType.OK).show();
                txtusername.requestFocus();
                txtpassword.requestFocus();
            }
        }else {
            new Alert(Alert.AlertType.WARNING, "Enter User and Password", ButtonType.OK).show();
            txtusername.requestFocus();
        }


        }
    }

