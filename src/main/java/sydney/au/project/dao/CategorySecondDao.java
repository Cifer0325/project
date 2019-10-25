package sydney.au.project.dao;

import java.util.List;

import sydney.au.project.model.CategorySecond;

public interface CategorySecondDao extends BaseDao<CategorySecond> {

    /**
     * 查询二级分类的总的个数
     *
     * @return
     */
    public Integer countCategorySecond();

    /**
     * 分页查找所有用户
     *
     * @param page
     * @return
     */
    public List<CategorySecond> findAll(Integer page);

    public List<CategorySecond> findAll();

    public CategorySecond findOne(Integer cid);

}
