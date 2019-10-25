package sydney.au.project.service;

import java.util.List;

import sydney.au.project.model.Organization;
import sydney.au.project.model.User;

public interface OrganizationService {

	public void updateUser1(User user);

    public Organization checkUser1(Organization organization);

    public void deleteUser1(Integer oid);

    // 查询所有的用户
    public List<User> findUser1(Integer page);

    // 统计有多少页的用户
    public Integer countUser1();

    // 根据用户的uid查询用户信息
    public User findUserByUid1(Integer oid);

    //根据管理员id查询管理员的信息
    public Organization findOrganizationByAid1(Integer oid);
}
