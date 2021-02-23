package lk.kingsland.pos.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.kingsland.pos.bo.BoFactory;
import lk.kingsland.pos.bo.CourseBo;
import lk.kingsland.pos.dto.CourseDTO;

import java.util.Optional;

public class AddCourseFormController {
    public AnchorPane root;
    public TextField txtcode;
    public TextField txtname;
    public TextField txtdeuration;
    public TextField txtregfree;
    public TextField txtcoursetype;
    public TableView<CourseDTO> tblcourse;
    public TableColumn colcoursecode;
    public TableColumn colcoursename;
    public TableColumn colcoursetype;
    public TableColumn colregfree;
    public TableColumn coldeuration;
    CourseBo courseBo = BoFactory.getInstance().getBO(BoFactory.BOType.Course);
        public void initialize(){
            colcoursecode.setCellValueFactory(new PropertyValueFactory<>("CourseCode"));
            colcoursename.setCellValueFactory(new PropertyValueFactory<>("CourseName"));
            colcoursetype.setCellValueFactory(new PropertyValueFactory<>("CourseType"));
            coldeuration.setCellValueFactory(new PropertyValueFactory<>("Dueration"));
            colregfree.setCellValueFactory(new PropertyValueFactory<>("RegFree"));
          loadAllCourse();
        tblcourse.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            LoadUniqueData(newValue);
        });
        }

    private void LoadUniqueData(CourseDTO newValue) {
        if(newValue!=null){
            txtcode.setText(newValue.getCourseCode());
            txtname.setText(newValue.getCourseName());
            txtcoursetype.setText(newValue.getCourseType());
            txtdeuration.setText(newValue.getDueration());
            txtregfree.setText(Double.toString(newValue.getRegFree()));

        }
    }

    private void loadAllCourse() {
        try {
            ObservableList<CourseDTO> allCourse = courseBo.getAllCourse();
            tblcourse.setItems(allCourse);
        } catch (Exception ex) {
            new Alert(Alert.AlertType.CONFIRMATION,ex.getMessage(), ButtonType.OK).show();

        }
    }

    public void txtsearchCodeOnAction(ActionEvent actionEvent) {
            if(txtcode.getText().length()>0){
                try {

                    CourseDTO course = courseBo.getCourse(txtcode.getText());
                    if(course!=null){
                        txtcode.setText(course.getCourseCode());
                        txtname.setText(course.getCourseName());
                        txtcoursetype.setText(course.getCourseType());
                        txtdeuration.setText(course.getDueration());
                        txtregfree.setText(Double.toString(course.getRegFree()));

                    }else {
                        new Alert(Alert.AlertType.CONFIRMATION,"Course Not Found", ButtonType.OK).show();

                    }


                } catch (Exception ex) {
                    new Alert(Alert.AlertType.CONFIRMATION,ex.getMessage(), ButtonType.OK).show();

                }
            }else {

                new Alert(Alert.AlertType.WARNING, "Select Course ID And Search It!", ButtonType.OK).show();

            }

    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
            try {
                if(txtcode.getText().length()>0){
                    ButtonType ok = new ButtonType("OK");
                    ButtonType no = new ButtonType("No");
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure Delete " + txtcode.getText() + " This Student", ok, no);
                    Optional<ButtonType> buttonType = alert.showAndWait();
                    if(buttonType.orElse(no)==ok){
                        try {
                            boolean deleted = courseBo.deleteCourse(txtcode.getText());
                            if(deleted){
                                new Alert(Alert.AlertType.CONFIRMATION, "Course Delete Successfully", ButtonType.OK).show();
                                btnClearOnAction(actionEvent);
                                loadAllCourse();
                            }
                        } catch (Exception ex) {
                            new Alert(Alert.AlertType.CONFIRMATION,ex.getMessage(), ButtonType.OK).show();

                        }

                    }
                }else{
                    new Alert(Alert.AlertType.WARNING, "Select Course First!", ButtonType.OK).show();

                }

            }catch (NullPointerException ex){
                new Alert(Alert.AlertType.WARNING, "Select Course First!", ButtonType.OK).show();

            }

    }

    public void btnAddOnAction(ActionEvent actionEvent) {
            try {
                if(txtcode.getText().length()>0&&txtname.getText().length()>0) {
                    try {
                        boolean added = courseBo.AddCourse(new CourseDTO(txtcode.getText(), txtname.getText(), txtcoursetype.getText(), txtdeuration.getText(), Double.parseDouble(txtregfree.getText())));
                        if (added) {
                            new Alert(Alert.AlertType.CONFIRMATION, "Course Add Successfully!", ButtonType.OK).show();
                            btnClearOnAction(actionEvent);
                            loadAllCourse();
                        } else {
                            new Alert(Alert.AlertType.CONFIRMATION, "Course Add fail!", ButtonType.OK).show();

                        }
                    } catch (Exception ex) {
                        new Alert(Alert.AlertType.CONFIRMATION, ex.getMessage(), ButtonType.OK).show();

                    }
                }
                else {
                    new Alert(Alert.AlertType.CONFIRMATION,"Please Fill The Data First", ButtonType.OK).show();

                }

            }catch (NullPointerException ex){
                new Alert(Alert.AlertType.CONFIRMATION,"Please Fill The Data First", ButtonType.OK).show();

            }


    }

    public void btnClearOnAction(ActionEvent actionEvent) {
            txtcode.setText(null);
            txtname.setText(null);
            txtcoursetype.setText(null);
            txtregfree.setText(null);
            txtdeuration.setText(null);

    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
            try {
                if(txtcode.getText().length()>0&&txtcoursetype.getText().length()>0){
                    try {
                        boolean update = courseBo.updateCourse(new CourseDTO(txtcode.getText(), txtname.getText(), txtcoursetype.getText(), txtdeuration.getText(), Double.parseDouble(txtregfree.getText())));
                        if(update){
                            new Alert(Alert.AlertType.CONFIRMATION,"Course Update Successfully", ButtonType.OK).show();
                            loadAllCourse();
                            btnClearOnAction(actionEvent);
                        }else {
                            new Alert(Alert.AlertType.CONFIRMATION,"Course Update Fail!", ButtonType.OK).show();

                        }
                    } catch (Exception ex) {
                        new Alert(Alert.AlertType.CONFIRMATION,ex.getMessage(), ButtonType.OK).show();

                    }
                }else {
                    new Alert(Alert.AlertType.CONFIRMATION,"Please Select Data And Update!", ButtonType.OK).show();

                }

            }catch (NullPointerException ex){
                new Alert(Alert.AlertType.CONFIRMATION,"Please Select Data And Update!", ButtonType.OK).show();

            }


    }
}
