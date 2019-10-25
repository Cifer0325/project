package sydney.au.project.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sydney.au.project.dao.PostDao;
import sydney.au.project.model.Post;
import sydney.au.project.service.PostService;

@Transactional
@Service("postService")
public class PostServiceImpl implements PostService {

    @Resource
    private PostDao postDao;

    public Integer CountPagePostFromCategory(Integer cid) {
        Integer count = postDao.CountPagePostFromCategory(cid);
        return (count % 12 == 0 ? (count / 12) : (count / 12 + 1));
    }

    public Integer CountPagePostFromCategorySecond(Integer csid) {
        Integer count = postDao.CountPagePostFromCategorySecond(csid);
        return (count % 12 == 0 ? (count / 12) : (count / 12 + 1));
    }

    public List<Post> findByCid(Integer cid, Integer page) {
        return postDao.findByCategorySecondCategoryCid(cid, page);
    }

    public List<Post> findByCsid(Integer csid, Integer page) {
        return postDao.findByCategorySecondCsid(csid, page);
    }

    public Post findByPid(Integer pid) {
        return postDao.findOne(pid);
    }

    public List<Post> findHot() {
        return postDao.findHot();
    }

    public List<Post> findNew() {
        return postDao.findNew();
    }

    public void update(Post post) {
    	postDao.update(post);
    }

    public void save(Post save) {
    	postDao.save(save);
    }

}

