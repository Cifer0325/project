package sydney.au.project.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import sydney.au.project.model.Activity;
import sydney.au.project.model.Category;
import sydney.au.project.service.AdminActivityService;



@Controller
public class AdminActivityController {

	@Resource
    private AdminActivityService adminActivityService;
	
	 @ModelAttribute("activity")
	    public void getActivity(@RequestParam(value = "acid", required = false) Integer acid, Map<String, Object> map) {
	        if (acid != null) {
	            Activity activity = adminActivityService.findActivity(acid);
	            map.put("activity", activity);
	        }
	    }
	 
	//修改一级分类
	    @RequestMapping(value = "/updateActivity")
	    public ModelAndView updateActivity(@ModelAttribute("activity") Activity activity) {
	    	adminActivityService.updateActivity(activity);
	        ModelAndView modelAndView = new ModelAndView("redirect:/listActivity/1");
	        return modelAndView;
	    }
	    
	  //跳转到修改一级分类
	    @RequestMapping(value = "/gotoEditActivity/{acid}")
	    public String gotoEditActivity(@PathVariable("acid") Integer acid, Map<String, Object> map) {
	        Activity activity = adminActivityService.findActivity(acid);
	        map.put("activity", activity);
	        return "admin/activity/edit";
	    }
	    
	  //删除一级分类
	    @RequestMapping(value = "/deleteActivity/{acid}/{page}")
	    public ModelAndView deleteActivity(@PathVariable("acid") Integer acid, @PathVariable("page") Integer page) {
	    	adminActivityService.deleteActivity(acid);
	        ModelAndView modelAndView = new ModelAndView("redirect:/listActivity/" + page);
	        return modelAndView;
	    }
	    
	  //添加一级分类，parameter为前台传过来的一级分类的名称
	    @RequestMapping(value = "/addActivity")
	    public ModelAndView addActivity(@RequestParam(value = "actitle", required = true) String actitle,
	    		                        @RequestParam(value = "activetime", required = true) String activetime,
	    		                        @RequestParam(value = "activeaddr", required = true) String activeaddr,
	    		                        @RequestParam(value = "information", required = true) String information) {
	        //创建一级分类的对象
	        Activity activity = new Activity();
	        activity.setActitle(actitle);
	        activity.setActivetime(activetime);
	        activity.setActiveaddr(activeaddr);
	        activity.setInformation(information);
	        adminActivityService.saveActivity(activity);
	        ModelAndView modelAndView = new ModelAndView("redirect:listActivity/1");
	        return modelAndView;
	    }
	    
	  //跳转到添加一级分类
	    @RequestMapping(value = "/gotoAddActivity")
	    public String gotoAddActivity() {
	        return "admin/activity/add";
	    }
	    
	    //查询一级分类
	    @RequestMapping(value = "/listActivity/{page}")
	    public String listActivity(@PathVariable("page") Integer page, Map<String, Object> map) {
	        List<Activity> activities = adminActivityService.listActivity(page);
	        map.put("activities", activities);
	        map.put("page", page);
	        //查询一级分类的页数
	        Integer count = adminActivityService.countActivity();
	        map.put("count", count);
	        return "admin/activity/list";
	    }
}
