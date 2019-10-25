package sydney.au.project.dao;

import java.util.List;

import sydney.au.project.model.CategorySecond;
import sydney.au.project.model.Post;

public interface PostDao extends BaseDao<Post> {


    public List<Post> findHot();

    /**
     * 查找最新的十个Post
     *
     * @return
     */
    public List<Post> findNew();

  
    public List<Post> findByCategorySecondCsid(Integer csid, Integer page);

  
    public List<Post> findByCategorySecondCategoryCid(Integer cid, Integer page);

    public Integer CountPagePostFromCategory(Integer cid);

    public Integer CountPagePostFromCategorySecond(Integer csid);

    public Integer CountPost();

    public Post findOne(Integer pid);

    public CategorySecond findOneSecond(Integer csid);

    public List<Post> findAll(Integer page);
}
