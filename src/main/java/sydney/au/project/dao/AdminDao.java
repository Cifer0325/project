package sydney.au.project.dao;

import sydney.au.project.model.Admin;

public interface AdminDao extends BaseDao<Admin> {

    public Admin findByAdminnameAndPassword(String username, String password);

    public Admin findOne(Integer aid);
}
