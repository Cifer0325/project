package sydney.au.project.service.Impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sydney.au.project.dao.CategorySecondDao;
import sydney.au.project.model.CategorySecond;
import sydney.au.project.service.AdminCategorySecondService;

import java.util.List;

@Transactional
@Service("adminCategorySecondService")
public class AdminCategorySecondServiceImpl implements AdminCategorySecondService {

    @Resource
    private CategorySecondDao categorySecondDao;

    public void addCategorySecond(CategorySecond categorySecond) {
        categorySecondDao.save(categorySecond);
    }

    public void deleteCategorySecond(Integer csid) {
        categorySecondDao.delete(csid);
    }

    public void updateCategorySecond(CategorySecond categorySecond) {
        categorySecondDao.update(categorySecond);
    }

    public Integer countCategorySecond() {
        Integer count = categorySecondDao.countCategorySecond();
        return (count % 15 == 0 ? (count / 15) : (count / 15 + 1));
    }


    public CategorySecond findCategorySecond(Integer csid) {
        return categorySecondDao.findOne(csid);
    }

    public List<CategorySecond> listCategorySecond(Integer page) {
        return categorySecondDao.findAll(page);
    }

    public List<CategorySecond> listCategorySecond() {
        return categorySecondDao.findAll();
    }

}

