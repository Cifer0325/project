package sydney.au.project.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sydney.au.project.dao.OrganizationDao;
import sydney.au.project.dao.UserDao;
import sydney.au.project.model.Organization;
import sydney.au.project.model.User;
import sydney.au.project.service.OrganizationService;

@Transactional
@Service("organizationService")
public class OrganizationServiceImpl implements OrganizationService{

	
	@Resource
    private OrganizationDao organizationDao;
    @Resource
    private UserDao userDao;
    
	public void updateUser1(User user) {
		// TODO Auto-generated method stub
		userDao.update(user);
	}

	public Organization checkUser1(Organization organization) {
		// TODO Auto-generated method stub
		return organizationDao.findByOrganizationnameAndPassword1(organization.getOrganname(), organization.getPassword());
	}

	public void deleteUser1(Integer oid) {
		// TODO Auto-generated method stub
		userDao.delete(oid);
	}

	public List<User> findUser1(Integer page) {
		// TODO Auto-generated method stub
		return userDao.findAll(page);
	}

	public Integer countUser1() {
		// TODO Auto-generated method stub
		Integer count = userDao.countUser();
        return (count % 20 == 0 ? (count / 20) : (count / 20 + 1));
	}

	public User findUserByUid1(Integer oid) {
		// TODO Auto-generated method stub
		return userDao.findOne(oid);
	}

	public Organization findOrganizationByAid1(Integer oid) {
		// TODO Auto-generated method stub
		return organizationDao.findOne1(oid);
	}

}
