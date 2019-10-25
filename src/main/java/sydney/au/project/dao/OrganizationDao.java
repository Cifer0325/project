package sydney.au.project.dao;

import java.util.List;

import sydney.au.project.model.CategorySecond;
import sydney.au.project.model.Organization;

public interface OrganizationDao extends BaseDao<Organization>{

	public Organization findByOrganizationnameAndPassword1(String organname, String password);

    public Organization findOne1(Integer oid);
    
    public Integer countOrganization();

    /**
     * 分页查找所有用户
     *
     * @param page
     * @return
     */
    public List<Organization> findAll(Integer page);

    public List<Organization> findAll();

}
