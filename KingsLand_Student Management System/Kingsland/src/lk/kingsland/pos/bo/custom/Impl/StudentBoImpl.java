package lk.kingsland.pos.bo.custom.Impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.kingsland.pos.bo.StudentBo;
import lk.kingsland.pos.dao.DaoFactory;
import lk.kingsland.pos.dao.StudentDao;
import lk.kingsland.pos.dto.StudentDTO;
import lk.kingsland.pos.entity.Student;

import java.util.ArrayList;

public class StudentBoImpl implements StudentBo {
    StudentDao studentdao = DaoFactory.getInstance().getDao(DaoFactory.DaoType.Student);

    @Override
    public boolean saveStudent(StudentDTO dto) throws Exception {

        return studentdao.save(new Student(dto.getStudentID(), dto.getStudentName(), dto.getAddress(), dto.getContact(), dto.getDob(), dto.getGender()));

    }

    @Override
    public boolean updateStudent(StudentDTO dto) throws Exception {
        return studentdao.update(new Student(dto.getStudentID(), dto.getStudentName(), dto.getAddress(), dto.getContact(), dto.getDob(), dto.getGender()));
    }

    @Override
    public boolean deleteStudent(String id) throws Exception {
        return studentdao.delete(id);
    }

    @Override
    public StudentDTO getStudent(String id) throws Exception {
        Student student = studentdao.Search(id);
        return new StudentDTO(student.getStudentID(), student.getStudentName(), student.getAddress(), student.getContact(), student.getDob(), student.getGender());
    }

    @Override
    public ObservableList<StudentDTO> getAllStudent() throws Exception {
        ObservableList studentlist= FXCollections.observableArrayList();
        ArrayList<Student> all = studentdao.getAll();
        for (Student student:all) {
            studentlist.add(new StudentDTO(student.getStudentID(),student.getStudentName(),student.getAddress(),student.getContact(),student.getDob(),student.getGender()));

        }
        return studentlist;
    }


}
