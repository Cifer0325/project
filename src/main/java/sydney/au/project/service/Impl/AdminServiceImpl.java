package sydney.au.project.service.Impl;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sydney.au.project.dao.AdminDao;
import sydney.au.project.dao.UserDao;
import sydney.au.project.model.Admin;
import sydney.au.project.model.User;
import sydney.au.project.service.AdminService;

@Transactional
@Service("adminService")
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminDao adminDao;
    @Resource
    private UserDao userDao;

    //更新用户
    public void updateUser(User user) {
        userDao.update(user);
    }

    // 根據用戶名和密碼查詢
    public Admin checkUser(Admin adminUser) {
        return adminDao.findByAdminnameAndPassword(
                adminUser.getUsername(), adminUser.getPassword());
    }

    // 根据用户的uid删除用户
    public void deleteUser(Integer uid) {
        userDao.delete(uid);
    }

    // 查询所有的用户
    public List<User> findUser(Integer page) {
        return userDao.findAll(page);
    }

    // 统计有多少页的用户
    public Integer countUser() {
        Integer count = userDao.countUser();
        return (count % 20 == 0 ? (count / 20) : (count / 20 + 1));
    }

    // 根据用户的uid查询用户信息
    public User findUserByUid(Integer uid) {
        return userDao.findOne(uid);
    }

    // 根据管理员的aid查询管理员信息
    public Admin findAdminByAid(Integer aid) {

        return adminDao.findOne(aid);
    }
}

