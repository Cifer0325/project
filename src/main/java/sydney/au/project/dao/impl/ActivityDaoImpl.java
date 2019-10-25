package sydney.au.project.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import sydney.au.project.dao.ActivityDao;
import sydney.au.project.model.Activity;
import sydney.au.project.model.CategorySecond;


@Repository("activityDao")
@SuppressWarnings("all")
public class ActivityDaoImpl extends BaseDaoImpl<Activity> implements ActivityDao{

	public Integer countActivity() {
		// TODO Auto-generated method stub
		 String hql = "select count(*) from Activity";
	     return count(hql);
	}

	public List<Activity> findAll(Integer page) {
		// TODO Auto-generated method stub
		 String hql = "from Activity";
	        int rows = 15;
	        int page1 = page;
	        return find(hql, page1, rows);
	}

	public List<Activity> findAll() {
		// TODO Auto-generated method stub
		String hql = "from Activity";
        return find(hql);
	}

	public Activity findOne(Integer acid) {
		// TODO Auto-generated method stub
		String hql = "from Activity a where a.acid = ?";
        Query query = this.getCurrentSession().createQuery(hql);
        query.setParameter(0, acid);
        return (Activity) query.uniqueResult();
	}

}
