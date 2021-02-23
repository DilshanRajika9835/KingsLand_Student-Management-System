package lk.kingsland.pos.bo.custom.Impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.kingsland.pos.bo.CourseBo;
import lk.kingsland.pos.dao.CourseDao;
import lk.kingsland.pos.dao.DaoFactory;
import lk.kingsland.pos.dao.RegistrationDao;
import lk.kingsland.pos.dto.CourseDTO;
import lk.kingsland.pos.dto.RegistrationDTO;
import lk.kingsland.pos.entity.Course;
import lk.kingsland.pos.entity.Registration;

import java.util.ArrayList;

public class CourseBoImpl  implements CourseBo {
    CourseDao dao = DaoFactory.getInstance().getDao(DaoFactory.DaoType.Course);
    @Override
    public boolean AddCourse(CourseDTO dto) throws Exception {
       return dao.save(new Course(dto.getCourseCode(),dto.getCourseName(),dto.getCourseType(),dto.getDueration(),dto.getRegFree()));
    }

    @Override
    public boolean updateCourse(CourseDTO dto) throws Exception {
        return dao.updatet(new Course(dto.getCourseCode(),dto.getCourseName(),dto.getCourseType(),dto.getDueration(),dto.getRegFree()));
    }

    @Override
    public boolean deleteCourse(String id) throws Exception {
        return dao.delete(id);
    }

    @Override
    public CourseDTO getCourse(String id) throws Exception {
        Course search = dao.Search(id);
      return new CourseDTO(search.getCourseCode(),search.getCourseName(),search.getCourseType(),search.getDueration(),search.getRegFree());
    }

    @Override
    public ObservableList<CourseDTO> getAllCourse() throws Exception {
        ObservableList<Course> all = dao.getAll();
        ObservableList Courselist= FXCollections.observableArrayList();
        for (Course dto:all) {
         Courselist.add(new CourseDTO(dto.getCourseCode(),dto.getCourseName(),dto.getCourseType(),dto.getDueration(),dto.getRegFree())) ;
        }
        return Courselist;
    }


}
