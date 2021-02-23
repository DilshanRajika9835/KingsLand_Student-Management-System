package lk.kingsland.pos.dao.Impl;

import lk.kingsland.pos.dao.CrudUtill;
import lk.kingsland.pos.dao.QueryDao;

import java.sql.ResultSet;

public class QueryDaoImpl implements QueryDao {
    @Override
    public String getID(String id) throws Exception {
        String regno="SID001";
        ResultSet rst= CrudUtill.execute("SELECT  RegNo from registration where CourseCode=? order by regNO desc limit 1",id);
        if(rst.next()){
            String temp = rst.getString("RegNO");
            String[] split = temp.split("SID");
            int code=1+Integer.parseInt(split[1]);
            regno="SID00"+code;
        }
        return regno;
    }
}
