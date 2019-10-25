/**
 * 
 */
package sydney.au.project.dao;

import java.util.List;

import sydney.au.project.model.Activity;
import sydney.au.project.model.CategorySecond;

/**
 * @author Administrator
 *
 */
public interface ActivityDao extends BaseDao<Activity>{

	  public Integer countActivity();


	    public List<Activity> findAll(Integer page);

	    public List<Activity> findAll();

	    public Activity findOne(Integer acid);
}
