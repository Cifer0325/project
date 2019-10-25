package sydney.au.project.service.Impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sydney.au.project.dao.PostDao;
import sydney.au.project.model.Post;
import sydney.au.project.service.AdminPostService;

import java.util.List;

import javax.annotation.Resource;

@Transactional
@Service("adminPostService")
public class AdminPostServiceImpl implements AdminPostService {

    @Resource
    private PostDao postDao;

    public Integer countPost() {
        Integer count = postDao.CountPost();
        return (count % 8 == 0 ? (count / 8) : (count / 8 + 1));
    }

    public void deletePost(Post post) {
    	postDao.delete(post);
    }

    public Post findPost(Integer pid) {
        return postDao.findOne(pid);
    }

    public List<Post> listPost(Integer page) {
        return postDao.findAll(page);
    }

    public void savePost(Post post) {
    	postDao.save(post);
    }

    public void updatePost(Post post) {
    	postDao.update(post);
    }

}

