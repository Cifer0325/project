package sydney.au.project.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sydney.au.project.dao.OrganizationDao;
import sydney.au.project.model.Organization;
import sydney.au.project.service.AdminOrganizationService;

@Transactional
@Service("adminOrganization")
public class AdminOrganizationServiceImpl implements AdminOrganizationService {

	@Resource
	private OrganizationDao organizationDao;
	
	public List<Organization> listOrganization(Integer page) {
		// TODO Auto-generated method stub
		return organizationDao.findAll(page);
	}

	public Integer countOrganization() {
		// TODO Auto-generated method stub
		 Integer count = organizationDao.countOrganization();
	     return (count % 15 == 0 ? (count / 15) : (count / 15 + 1));
	}

	public void saveOrganization(Organization organization) {
		// TODO Auto-generated method stub
		organizationDao.save(organization);
	}

	public void deleteOrganization(Integer oid) {
		// TODO Auto-generated method stub
		organizationDao.delete(oid);
	}

	public Organization findOrganization(Integer oid) {
		// TODO Auto-generated method stub
		return organizationDao.findOne1(oid);
	}

	public void updateOrganization(Organization organization) {
		// TODO Auto-generated method stub
		organizationDao.update(organization);
	}

	public List<Organization> listOrganization() {
		// TODO Auto-generated method stub
		return organizationDao.findAll();
	}

}
