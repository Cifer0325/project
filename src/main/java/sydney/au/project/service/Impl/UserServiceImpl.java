package sydney.au.project.service.Impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sydney.au.project.dao.UserDao;
import sydney.au.project.model.User;
import sydney.au.project.service.UserService;
import sydney.au.project.utils.MailUitls;
import sydney.au.project.utils.UUIDUtils;

import javax.annotation.Resource;

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    public User active(String code) {
        return userDao.findByCode(code);
    }

    public User findUserByUsernameAndPassword(User user) {
        return userDao.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    public User existUser(String userName) {
        return userDao.findByUsername(userName);
    }

    public void register(User user) {
        user.setState(1);
        String code = UUIDUtils.getUUID() + UUIDUtils.getUUID();
        user.setCode(code);
        userDao.save(user);
        //���ͼ����ʼ�
        MailUitls.sendMail(user.getEmail(), code);
    }

    public void update(User user) {
        userDao.update(user);

    }

    public User findByUid(Integer uid) {
        return userDao.findOne(uid);
    }

}
