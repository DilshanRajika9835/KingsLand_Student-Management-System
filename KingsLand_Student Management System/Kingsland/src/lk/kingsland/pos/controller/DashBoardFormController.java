package lk.kingsland.pos.controller;

import javafx.beans.property.ObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.kingsland.pos.bo.BoFactory;
import lk.kingsland.pos.bo.StudentBo;
import lk.kingsland.pos.dto.StudentDTO;

import javax.swing.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

public class DashBoardFormController {

    public AnchorPane root;
    public TextField txtid;
    public TextField txtcontact;
    public TextField txtname;
    public TextField txtaddress;
    public DatePicker txtbirthdate;
    public ComboBox cmbgender;
    public TableView <StudentDTO>tblstudent;
    public TableColumn colid;
    public TableColumn colname;
    public TableColumn coladdress;
    public TableColumn colnumber;
    public TableColumn colbirthday;
    public TableColumn colgender;
    StudentBo studentbo = BoFactory.getInstance().getBO(BoFactory.BOType.Student);
    public void initialize(){
      cmbgender.setItems( FXCollections.observableArrayList("Male","Female"));
      colid.setCellValueFactory(new PropertyValueFactory<>("StudentID"));
      colname.setCellValueFactory(new PropertyValueFactory<>("StudentName"));
      coladdress.setCellValueFactory(new PropertyValueFactory<>("Address"));
      colnumber.setCellValueFactory(new PropertyValueFactory<>("Contact"));
      colbirthday.setCellValueFactory(new PropertyValueFactory<>("Dob"));
      colgender.setCellValueFactory(new PropertyValueFactory<>("Gender"));

      tblstudent.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
         LoadUniqueData(newValue);
      });

        try {
            ObservableList<StudentDTO> allStudent = studentbo.getAllStudent();
            tblstudent.setItems(allStudent);
        } catch (Exception ex) {
            new Alert(Alert.AlertType.CONFIRMATION,ex.getMessage(),ButtonType.OK).show();

        }
    }

    private void LoadUniqueData(StudentDTO newValue) {
        if(newValue!=null){
            txtid.setText(newValue.getStudentID());
            txtname.setText(newValue.getStudentName());
            txtaddress.setText(newValue.getAddress());
            txtcontact.setText(Integer.toString(newValue.getContact()));
            txtbirthdate.setValue(LocalDate.parse(newValue.getDob()));
            cmbgender.setValue(newValue.getGender());
        }
    }


    public void btnAddCourseOnAction(ActionEvent actionEvent) throws IOException {
        InitUI("AddCourseForm.fxml");

    }
    public void InitUI(String Location){

        try {
            this.root.getChildren().clear();
            this.root.getChildren().add(FXMLLoader.load(this.getClass().getResource("/lk/kingsland/pos/view/"+Location)));
        } catch (IOException ex) {
            new Alert(Alert.AlertType.CONFIRMATION,ex.getMessage(),ButtonType.OK).show();

        }
    }
    public void btnABCDCourseOnAction(ActionEvent actionEvent) {
        InitUI("ABCDCourseForm.fxml");
    }

    public void btnBCSCCourseOnAction(ActionEvent actionEvent) {
        InitUI("BCSCCourseForm.fxml");
    }

    public void btnDFHSCourseOnAction(ActionEvent actionEvent) {
        InitUI("DFHSCourseForm.fxml");
    }
    public void btnRegCourseOnAction(ActionEvent actionEvent) throws IOException { InitUI("RegForm.fxml"); }



    public void btnUpdateOnAction(ActionEvent actionEvent) {
        try {
            boolean update = studentbo.updateStudent(new StudentDTO(txtid.getText(), txtname.getText(), txtaddress.getText(), Integer.parseInt(txtcontact.getText()), txtbirthdate.getValue().toString(), cmbgender.getValue().toString()));
            if(update){
                new Alert(Alert.AlertType.CONFIRMATION,"Student Update Successfully",ButtonType.OK).show();
                initialize();
                btnClearOnAction(actionEvent);
            }else {
                new Alert(Alert.AlertType.CONFIRMATION,"Student Update fail",ButtonType.OK).show();

            }
        } catch (Exception ex) {
            new Alert(Alert.AlertType.WARNING,ex.getMessage(),ButtonType.OK);

        }

    }

    public void btnClearOnAction(ActionEvent actionEvent) {
        txtid.setText(null);
        txtname.setText(null);
        txtaddress.setText(null);
        txtcontact.setText(null);
        txtbirthdate.setValue(null);
        cmbgender.setValue(null);
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        if(txtid.getText().length()>0 && txtaddress.getText().length()>0) try {
            boolean added = studentbo.saveStudent(new StudentDTO(txtid.getText(), txtname.getText(), txtaddress.getText(), Integer.parseInt(txtcontact.getText()), txtbirthdate.getValue().toString(), cmbgender.getValue().toString()));
            if (added) {
                new Alert(Alert.AlertType.CONFIRMATION, "Student Added Successfully", ButtonType.OK).show();
                initialize();
                btnClearOnAction(actionEvent);
            } else {
                new Alert(Alert.AlertType.CONFIRMATION, "Student Student Added Is fail", ButtonType.OK).show();

            }
        } catch (Exception ex) {
            new Alert(Alert.AlertType.CONFIRMATION, "This Student Is Allready Added", ButtonType.OK).show();
        }
        else {
            new Alert(Alert.AlertType.CONFIRMATION, "Please Fill The Data First", ButtonType.OK).show();

        }
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        if(txtid.getText().length()>0&&txtname.getText().length()>0) {


            ButtonType ok = new ButtonType("OK");
            ButtonType no = new ButtonType("No");
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure Delete " + txtid.getText() + " This Student", ok, no);
            Optional<ButtonType> buttonType = alert.showAndWait();
            if (buttonType.orElse(no) == ok) {
                try {
                    boolean deleted = studentbo.deleteStudent(txtid.getText());
                    if (deleted) {
                        new Alert(Alert.AlertType.CONFIRMATION, "Student Delete Successfully", ButtonType.OK).show();
                        initialize();
                        btnClearOnAction(actionEvent);

                    }
                } catch (Exception ex) {
                    new Alert(Alert.AlertType.CONFIRMATION, ex.getMessage(), ButtonType.OK).show();

                }
            }
        }else {
            new Alert(Alert.AlertType.CONFIRMATION, "Please Select The Student!", ButtonType.OK).show();

        }

    }

    public void txtSIDSearchOnAction(ActionEvent actionEvent) {
        try {
            StudentDTO student = studentbo.getStudent(txtid.getText());
           if(student!=null){
               txtid.setText(student.getStudentID());
               txtname.setText(student.getStudentName());
               txtaddress.setText(student.getAddress());
               txtcontact.setText(Integer.toString(student.getContact()));
               txtbirthdate.setValue(LocalDate.parse(student.getDob()));
               cmbgender.setValue(student.getGender());
           } else {
               new Alert(Alert.AlertType.CONFIRMATION,"Student NotFound",ButtonType.OK).show();

           }
        } catch (Exception ex) {
            new Alert(Alert.AlertType.CONFIRMATION,ex.getMessage(),ButtonType.OK).show();

        }

    }
}
