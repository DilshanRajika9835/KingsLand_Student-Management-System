package lk.kingsland.pos.bo.custom.Impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.kingsland.pos.bo.RegistrationBo;
import lk.kingsland.pos.dao.DaoFactory;
import lk.kingsland.pos.dao.QueryDao;
import lk.kingsland.pos.dao.RegistrationDao;
import lk.kingsland.pos.dto.RegistrationDTO;
import lk.kingsland.pos.entity.Registration;
import lk.kingsland.pos.view.TM.CourseTM;
import sun.rmi.runtime.NewThreadAction;

import java.util.ArrayList;

public class RegistrationBoImpl implements RegistrationBo {
    RegistrationDao registrationDao = DaoFactory.getInstance().getDao(DaoFactory.DaoType.registration);
    QueryDao query = DaoFactory.getInstance().getDao(DaoFactory.DaoType.query);


    @Override
    public boolean RegStudent(RegistrationDTO dto) throws Exception {
  return   registrationDao.save(new Registration( dto.getRegNo(),dto.getRegDate(),dto.getStudentID(),dto.getCourseCode(),dto.getRegFree()));
    }

    @Override
    public boolean updateStudent(RegistrationDTO dto) throws Exception {
        return false;
    }

    @Override
    public boolean deleteStudent(String id) throws Exception {
        return false;
    }

    @Override
    public RegistrationDTO getStudent(String id) throws Exception {
      return null;
    }

    @Override
    public ObservableList<RegistrationDTO > getRegAllStudent() throws Exception {
        ObservableList<Registration> all = registrationDao.getAll();
        ObservableList reglist= FXCollections.observableArrayList();
        for (Registration reg:all) {
            reglist.add(new RegistrationDTO(reg.getRegNo(),reg.getRegDate(),reg.getStudentID(),reg.getCourseCode(),reg.getRegFree()));
        }
        return reglist;
    }

    @Override
    public String getID(String id) throws Exception {
        return query.getID(id);
    }

    @Override
    public ObservableList<CourseTM> getregStudent(String ID) throws Exception {
        return registrationDao.getregStudent(ID);
    }

}
