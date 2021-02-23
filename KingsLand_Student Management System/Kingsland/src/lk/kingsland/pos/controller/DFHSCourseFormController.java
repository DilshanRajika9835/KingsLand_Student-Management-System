package lk.kingsland.pos.controller;

import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.kingsland.pos.bo.BoFactory;
import lk.kingsland.pos.bo.RegistrationBo;
import lk.kingsland.pos.view.TM.CourseTM;

public class DFHSCourseFormController {
    public TableView tblDFHSCourse;
    public TableColumn colregNumber;
    public TableColumn colid;
    public TableColumn colname;
    public TableColumn colcontact;
    public TableColumn colcoursecode;
    public TableColumn colregfree;
    RegistrationBo registrationBo = BoFactory.getInstance().getBO(BoFactory.BOType.registration);

    public void initialize(){
        colid.setCellValueFactory(new PropertyValueFactory<>("StudentID"));
        colregNumber.setCellValueFactory(new PropertyValueFactory<>("RegNO"));
        colcontact.setCellValueFactory(new PropertyValueFactory<>("ContactNumber"));
        colcoursecode.setCellValueFactory(new PropertyValueFactory<>("CourseCode"));
        colregfree.setCellValueFactory(new PropertyValueFactory<>("regFree"));
        try {
            ObservableList<CourseTM> regAllStudent = registrationBo.getregStudent("C003");
            tblDFHSCourse.setItems(regAllStudent);
        } catch (Exception ex) {

        }

    }
}
