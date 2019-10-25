package sydney.au.project.dao;



import java.util.List;

import sydney.au.project.model.User;

public interface UserDao extends BaseDao<User> {

    /**
     * 根据用户名查询用户
     *
     * @param userName
     * @return
     */
    public User findByUsername(String userName);

    /**
     * 根据用户名和密码查询用户
     *
     * @param username
     * @param password
     * @return
     */
    public User findByUsernameAndPassword(String username, String password);

    /**
     * 忘记密码
     *
     * @param code
     * @return
     */
    public User findByCode(String code);

    /**
     * 计算用户数量
     *
     * @return
     */
    public Integer countUser();

    /**
     * 分页查找所有用户
     *
     * @param page
     * @return
     */
    public List<User> findAll(Integer page);

    /**
     * 查找单个用户
     *
     * @param uid
     * @return
     */
    public User findOne(Integer uid);

}
