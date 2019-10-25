package sydney.au.project.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sydney.au.project.dao.ActivityDao;
import sydney.au.project.dao.CategorySecondDao;
import sydney.au.project.model.Activity;
import sydney.au.project.service.AdminActivityService;

@Transactional
@Service("adminActivityService")
public class AdminActivityServiceImpl implements AdminActivityService{

	@Resource
    private ActivityDao activityDao;
	
	public List<Activity> listActivity(Integer page) {
		// TODO Auto-generated method stub
		return activityDao.findAll(page);
	}

	public Integer countActivity() {
		// TODO Auto-generated method stub
		 Integer count = activityDao.countActivity();
	     return (count % 15 == 0 ? (count / 15) : (count / 15 + 1));
	}

	public void saveActivity(Activity activity) {
		// TODO Auto-generated method stub
		activityDao.save(activity);
	}

	public void deleteActivity(Integer acid) {
		// TODO Auto-generated method stub
		activityDao.delete(acid);
	}

	public Activity findActivity(Integer acid) {
		// TODO Auto-generated method stub
		return activityDao.findOne(acid);
	}

	public void updateActivity(Activity activity) {
		// TODO Auto-generated method stub
		activityDao.update(activity);
	}

	public List<Activity> listActivity() {
		// TODO Auto-generated method stub
		return activityDao.findAll();
	}

}
