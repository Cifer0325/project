package sydney.au.project.service.Impl;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sydney.au.project.dao.CategoryDao;
import sydney.au.project.model.Category;
import sydney.au.project.service.CategoryService;

@Transactional
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryDao categoryDao;

    public List<Category> getCategory() {
        return categoryDao.findAll();
    }
}
