package sydney.au.project.service;

import java.util.List;

import sydney.au.project.model.Post;

public interface PostService {

    // 根据二级分类查询Post
    public List<Post> findByCsid(Integer csid, Integer page);

    // 根据一级分类查询Post
    public List<Post> findByCid(Integer cid, Integer page);

    public List<Post> findHot();

    // 查找最新的Post10条
    public List<Post> findNew();

    // 根据Post的pid的值查询Post
    public Post findByPid(Integer pid);

    // 返回一级有多少页的数据
    public Integer CountPagePostFromCategory(Integer cid);

    // 返回二级分类下游多少的数据
    public Integer CountPagePostFromCategorySecond(Integer csid);

    // 更新Post的信息
    public void update(Post post);

    // 保存Post信息
    public void save(Post save);
}
