package sydney.au.project.service;

import java.util.List;

import sydney.au.project.model.Post;

public interface AdminPostService {
    //分页查询Post
    public List<Post> listPost(Integer page);

    //查询Post的页数
    public Integer countPost();

    //保存Post
    public void savePost(Post post);

    //查找某个具体的Post
    public Post findPost(Integer pid);

    //删除Post
    public void deletePost(Post post);

    //修改Post
    public void updatePost(Post post);
}

