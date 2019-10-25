package sydney.au.project.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import sydney.au.project.dao.OrganizationDao;
import sydney.au.project.model.CategorySecond;
import sydney.au.project.model.Organization;

@Repository("organizationDao")
@SuppressWarnings("all")
public class OrganizationDaoImpl extends BaseDaoImpl<Organization> implements OrganizationDao{

	public Organization findByOrganizationnameAndPassword1(String organname, String password) {
		// TODO Auto-generated method stub
		 String hql = "from Organization og where og.organname = ? and og.password = ?";
	        Query query = this.getCurrentSession().createQuery(hql);
	        query.setParameter(0, organname);
	        query.setParameter(1, password);
	        return (Organization) query.uniqueResult();
	}

	public Organization findOne1(Integer oid) {
		// TODO Auto-generated method stub
		String hql = "from organization where oid=?";
        Query query = this.getCurrentSession().createQuery(hql);
        query.setParameter(0, oid);
        return (Organization) query.uniqueResult();
	}

	public Integer countOrganization() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Organization";
        return count(hql);
	}

	public List<Organization> findAll(Integer page) {
		// TODO Auto-generated method stub
		 String hql = "from Organization";
	        int rows = 15;
	        int page1 = page;
	        return find(hql, page1, rows);
	}

	public List<Organization> findAll() {
		// TODO Auto-generated method stub
		String hql = "from Organization";
        return find(hql);
	}


}
