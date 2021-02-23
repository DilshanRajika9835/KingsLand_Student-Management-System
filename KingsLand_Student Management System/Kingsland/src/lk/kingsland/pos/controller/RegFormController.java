package lk.kingsland.pos.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import lk.kingsland.pos.bo.BoFactory;
import lk.kingsland.pos.bo.CourseBo;
import lk.kingsland.pos.bo.RegistrationBo;
import lk.kingsland.pos.bo.StudentBo;
import lk.kingsland.pos.dao.DaoFactory;
import lk.kingsland.pos.dto.CourseDTO;
import lk.kingsland.pos.dto.RegistrationDTO;
import lk.kingsland.pos.dto.StudentDTO;

import javax.swing.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class RegFormController {
    public AnchorPane root;
    public TextField txtid;
    public DatePicker txtregdate;
    public TextField lblRegNo;
    public ComboBox cmbRegFree;
    public Label lblName;
    public Label lblAddress;
    public Label lblBirthDay;
    public TableView<RegistrationDTO> tblregistorStudent;
    public TableColumn colid;
    public TableColumn colcoursecode;
    public TableColumn coldate;
    public TableColumn colregFree;
    public Label lblGender;
    public ComboBox cmbcoursecode;
    public Label lblcontactnumber;
    public ComboBox cmbStudentID;
    public TableColumn colregno;
    RegistrationBo registrationBo = BoFactory.getInstance().getBO(BoFactory.BOType.registration);
    StudentBo Studentbo = BoFactory.getInstance().getBO(BoFactory.BOType.Student);
    CourseBo coursebo = BoFactory.getInstance().getBO(BoFactory.BOType.Course);

    public void initialize(){
colid.setCellValueFactory(new PropertyValueFactory<>("StudentID"));
colcoursecode.setCellValueFactory(new PropertyValueFactory<>("CourseCode"));
coldate.setCellValueFactory(new PropertyValueFactory<>("RegDate"));
colregFree.setCellValueFactory(new PropertyValueFactory<>("RegFree"));
colregno.setCellValueFactory(new PropertyValueFactory<>("RegNo"));



        LoadStudentID();
        LoadCoursePrice();
        LoadCourseCode();
        LoadAllRegStudent();
        tblregistorStudent.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            LoadUniqueData(newValue);
        });
    }

    private void LoadUniqueData(RegistrationDTO newValue) {
        if(newValue!=null){
            LoadStudentData(newValue.getStudentID());

        }

    }

    private void LoadAllRegStudent() {
        try {
            ObservableList<RegistrationDTO> allregStudent = registrationBo.getRegAllStudent();
            tblregistorStudent.setItems(allregStudent);
        } catch (Exception ex) {
           // new Alert(Alert.AlertType.CONFIRMATION,ex.getMessage(), ButtonType.OK).show();

        }
    }


    private void LoadCourseCode() {
        try {
            ObservableList courseCode=FXCollections.observableArrayList();
            ObservableList<CourseDTO>   allCourse = coursebo.getAllCourse();
            for (CourseDTO dto:allCourse) {
                courseCode.add(dto.getCourseCode());
            }
            cmbcoursecode.setItems(courseCode);
        } catch (Exception ex) {
            //new Alert(Alert.AlertType.CONFIRMATION,ex.getMessage(), ButtonType.OK).show();
        }

        }


    private void LoadCoursePrice() {
        try {
            ObservableList courseprice=FXCollections.observableArrayList();
            ObservableList<CourseDTO> allCourse = coursebo.getAllCourse();
            for (CourseDTO dto:allCourse) {
               courseprice.add(dto.getRegFree());
            }

            cmbRegFree.setItems(courseprice);
        } catch (Exception ex) {
            //new Alert(Alert.AlertType.CONFIRMATION,ex.getMessage(), ButtonType.OK).show();

        }

    }

    private void LoadStudentID() {
        try {
            ObservableList<StudentDTO> allStudent = Studentbo.getAllStudent();
            ObservableList sidlist= FXCollections.observableArrayList();
            for (StudentDTO dto:allStudent) {
             sidlist.add(dto.getStudentID());

            }
            cmbStudentID.setItems(sidlist);
        } catch (Exception ex) {
           // new Alert(Alert.AlertType.CONFIRMATION,ex.getMessage(), ButtonType.OK).show();

        }
    }


    public void cmbSelectIDOnAction(ActionEvent actionEvent) {
        LoadStudentData((String) cmbStudentID.getValue());
    }

    public void btnregistorOnAction(ActionEvent actionEvent) {
        try {
            boolean registered = registrationBo.RegStudent(new RegistrationDTO(lblRegNo.getText(), txtregdate.getValue().toString(), txtid.getText(), cmbcoursecode.getValue().toString(), Double.parseDouble(cmbRegFree.getValue().toString())));
            if(registered){
                new Alert(Alert.AlertType.CONFIRMATION,"Student Registered Successfully", ButtonType.OK).show();
                LoadAllRegStudent();
                btnClearOnAction(actionEvent);
                return;
            }else {
                new Alert(Alert.AlertType.CONFIRMATION,"Student Registration if fail!", ButtonType.OK).show();

            }
        } catch (Exception ex) {
            //new Alert(Alert.AlertType.CONFIRMATION,ex.getMessage(), ButtonType.OK).show();
        }
    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) this.root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/lk/kingsland/pos/view/DashBoardForm.fxml"))));
    }

    public void cmbSelectCourseCodeOnAction(ActionEvent actionEvent) {
        try {
            lblRegNo.setText(null);
            String id = registrationBo.getID(cmbcoursecode.getValue().toString());
            lblRegNo.setText(id);
        } catch (Exception ex) {
        }

    }

    public void txtSearchIDOnAction(ActionEvent actionEvent) {
        LoadStudentData(txtid.getText());

    }
    public  void LoadStudentData(String id){
        try {
            StudentDTO student = Studentbo.getStudent(id);
            txtid.setText(student.getStudentID());
            lblName.setText(student.getStudentName());
            lblAddress.setText(student.getAddress());
            lblcontactnumber.setText(Integer.toString(student.getContact()));
            lblBirthDay.setText(student.getDob());
            lblGender.setText(student.getGender());

        } catch (Exception ex) {
           // new Alert(Alert.AlertType.CONFIRMATION,ex.getMessage(), ButtonType.OK).show();
        }

    }
    public void btnClearOnAction(ActionEvent actionEvent) {
        txtid.setText(null);
        txtregdate.setValue(null);
        lblRegNo.setText(null);
        lblGender.setText(null);
        lblBirthDay.setText(null);
        lblcontactnumber.setText(null);
        lblAddress.setText(null);
        lblName.setText(null);
        cmbStudentID.setValue(null);
        cmbRegFree.setValue(null);
        cmbcoursecode.setValue(null);
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {

    }
}
