package sydney.au.project.service;

import java.util.List;

import sydney.au.project.model.Activity;

public interface AdminActivityService {

	 public List<Activity> listActivity(Integer page);

	    //统计活动的个数
	    public Integer countActivity();

	    //保存活动
	    public void saveActivity(Activity activity);

	    //删除活动
	    public void deleteActivity(Integer acid);

	    //查找具体某个活动
	    public Activity findActivity(Integer acid);

	    //更新活动
	    public void updateActivity(Activity activity);

	    //查找所有的活动
	    public List<Activity> listActivity();
}
