package sydney.au.project.service;

import java.util.List;

import sydney.au.project.model.Category;

public interface AdminCategoryService {

    // 分页查询一级分类
    public List<Category> listCategory(Integer page);

    // 查询一级分类的页数
    public Integer countCategory();

    //添加二级分类
    public void addCategory(Category category);

    //删除二级分类
    public void deleteCategory(Integer cid);

    //查询某个具体的一级分类
    public Category findCategory(Integer cid);

    //更新一级分类
    public void updateCategory(Category category);

    public List<Category> findCategory();
}
