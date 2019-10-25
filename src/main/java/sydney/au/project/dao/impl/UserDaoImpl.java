package sydney.au.project.dao.impl;


import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import sydney.au.project.dao.UserDao;
import sydney.au.project.model.User;

import java.util.List;

@Repository("userDao")
@SuppressWarnings("all")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

    public Integer countUser() {
        String hql = "select count(*) from User";
        return count(hql);
    }

    public User findByCode(String code) {
        String hql = "from User u where u.code = ?";
        Query query = this.getCurrentSession().createQuery(hql);
        query.setParameter(0, code);
        return (User) query.uniqueResult();
    }

    public User findByUsername(String userName) {
        String hql = "from User u where u.username = ?";
        Query query = this.getCurrentSession().createQuery(hql);
        query.setParameter(0, userName);
        return (User) query.uniqueResult();
    }

    public User findByUsernameAndPassword(String username, String password) {
        String hql = "from User u where u.username = ? and u.password = ?";
        System.out.println("sdfsdfsfgwe");
        Query query = this.getCurrentSession().createQuery(hql);
        query.setParameter(0, username);
        query.setParameter(1, password);
        return (User) query.uniqueResult();
    }

    public List<User> findAll(Integer page) {
        String hql = "from User";
        int rows = 20;
        int page1 = page;
        return find(hql, page1, rows);
    }

    public User findOne(Integer uid) {
        String hql = "from User u where u.uid = ?";
        Query query = this.getCurrentSession().createQuery(hql);
        query.setParameter(0, uid);
        return (User) query.uniqueResult();
    }

}
