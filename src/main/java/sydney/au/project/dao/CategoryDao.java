package sydney.au.project.dao;

import java.util.Date;
import java.util.List;

import sydney.au.project.model.Category;

public interface CategoryDao extends BaseDao<Category> {

    /**
     * 查询一级分类的总的个数
     *
     * @return
     */
    public Integer countCategory();

    /**
     * 分页查找所有用户
     *
     * @param page
     * @return
     */
    public List<Category> findAll(Integer page);

    public List<Category> findAll();

    public Category findOne(Integer cid);


}

