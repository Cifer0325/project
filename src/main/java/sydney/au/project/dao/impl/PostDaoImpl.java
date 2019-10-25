package sydney.au.project.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import org.hibernate.Query;
import sydney.au.project.dao.PostDao;
import sydney.au.project.model.CategorySecond;
import sydney.au.project.model.Post;

@Repository("postDao")
@SuppressWarnings("all")
public class PostDaoImpl extends BaseDaoImpl<Post> implements PostDao {

    final String selecthql = "select p.pid,p.image,p.is_hot,"
            + "p.pdate,p.pdesc,p.pname ";

    public Integer CountPagePostFromCategory(Integer cid) {
        String hql = "select count(*) from Post p, Category c, CategorySecond cs ";
        hql += "where p.categorySecond.csid = cs.csid and cs.category.cid = c.cid and c.cid = ?";
        return count(hql, cid);
    }

    public Integer CountPagePostFromCategorySecond(Integer csid) {
        String hql = "select count(*) from Post p ,CategorySecond cs ";
        hql += "where p.categorySecond.csid = cs.csid and cs.csid = ?";
        return count(hql, csid);
    }

    public Integer CountPost() {
        String hql = "select count(*) from Post";
        return count(hql);
    }

    public List<Post> findByCategorySecondCategoryCid(Integer cid,
                                                         Integer page) {
        String hql = selecthql + "from Post p,Category c, CategorySecond cs ";
        hql += "where p.categorySecond.csid = cs.csid and cs.category.cid = c.cid and c.cid = ?";
        return Query(cid, page, hql);
    }

    public List<Post> findByCategorySecondCsid(Integer csid, Integer page) {
        String hql = selecthql + "from Post p ,CategorySecond cs ";
        hql += "where p.categorySecond.csid = cs.csid and cs.csid = ?";
        return Query(csid, page, hql);
    }

    private List<Post> Query(Integer csid, Integer page, String hql) {

        int rows = 12;
        Query query = this.getCurrentSession().createQuery(hql);
        query.setParameter(0, csid);
        List list = query.setFirstResult((page - 1) * rows).setMaxResults(rows).list();

        List<Post> posts = new ArrayList<Post>();
        Iterator iter = list.iterator();

        while (iter.hasNext()) {

            Object[] obj = (Object[]) iter.next();
            Post post = new Post();

            int pid = (Integer) obj[0];
            post.setPid(pid);
            post.setImage((String) obj[1]);
            post.setIs_hot((Integer) obj[2]);
            post.setPdesc((String) obj[4]);
            post.setPname((String) obj[5]);
  

            posts.add(post);
        }
        return posts;
    }

    public List<Post> findHot() {
        String hql = "from Post p where p.is_hot = 1 ";
        hql += "order by p.pdate desc";
        int rows = 10;
        return find(hql, 1, rows);
    }

    public Post findOne(Integer pid) {
        String hql = "from Post p where p.pid = ?";
        Query query = this.getCurrentSession().createQuery(hql);
        query.setParameter(0, pid);
        return (Post) query.uniqueResult();
    }

    public CategorySecond findOneSecond(Integer csid) {
        String hql = "from CategorySecond p where p.scid = ?";
        Query query = this.getCurrentSession().createQuery(hql);
        query.setParameter(0, csid);
        return (CategorySecond) query.uniqueResult();
    }

    public List<Post> findNew() {
        String hql = "from Post p ";
        hql += "order by p.pdate desc";
        int rows = 10;
        return find(hql, 1, rows);
    }

    public List<Post> findAll(Integer page) {
        String hql = "from Post";
        int rows = 12;
        int page1 = page;
        return find(hql, page1, rows);
    }

}

