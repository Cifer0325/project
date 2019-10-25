package sydney.au.project.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import sydney.au.project.model.Admin;
import sydney.au.project.model.Organization;
import sydney.au.project.model.User;
import sydney.au.project.service.OrganizationService;

@Controller
public class OrganizationController {

	@Resource
	private OrganizationService organizationService;
	
	
	@ModelAttribute(value = "user")
    public void getUser1(@RequestParam(value = "uid", required = false) Integer uid, Map<String, Object> map) {
        if (uid != null) {
            User user = organizationService.findUserByUid1(uid);
            map.put("user", user);
        }
    }

    //更新用户
    @RequestMapping(value = "/updateUser1")
    public ModelAndView updateUser1(@ModelAttribute("user") User user) {
    	organizationService.updateUser1(user);
        ModelAndView model = new ModelAndView();
        model.setViewName("redirect:/listUser1/1");
        return model;
    }

    //修改用户
    @RequestMapping(value = "/editUser1/{uid}")
    public String editUser1(@PathVariable("uid") Integer uid, @ModelAttribute("user") User user, Map<String, Object>
            map) {
        user = organizationService.findUserByUid1(uid);
        map.put("user", user);
        return "organization/user/edit";
    }

    //删除用户 uid:用户的id page:当前第几页
    @RequestMapping(value = "/deleteUser1/{uid}/{page}")
    public ModelAndView deleteUser1(@PathVariable("uid") Integer uid, @PathVariable("page") Integer page) {
    	organizationService.deleteUser1(uid);
        ModelAndView model = new ModelAndView();
        model.setViewName("redirect:/listUser/" + page);
        return model;
    }

    //管理员查询用户
    @RequestMapping(value = "/listUser1/{page}")
    public String listUser1(@PathVariable("page") Integer page, Map<String, Object> map) {
        //保存所有用户的集合
        List<User> users = organizationService.findUser1(page);
        //查询用多少页
        Integer count = organizationService.countUser1();
        map.put("count", count);
        map.put("page", page);
        map.put("users", users);
        return "organization/user/list";
    }

    // 处理Organization登陆
    @RequestMapping(value = "/organizationLogin", method = RequestMethod.GET)
    public String organizationLogin(Organization organization,
                             HttpSession session) {
        Organization checkUser1 = organizationService.checkUser1(organization);
        if (null == checkUser1) {
            return "organization/index";
        } else {
            session.setAttribute("organization", organization);
        }
        return "organization/home";
    }

    // 跳转到Organization的登陆界面
    @RequestMapping(value = "/organizationIndex")
    public String organizationIndex() {
        return "organization/index";
    }

    //Organization首页顶部的界面
    @RequestMapping("/organizationTop")
    public String organizationTop() {
        return "organization/top";
    }

    //Organization首页左侧的界面
    @RequestMapping("/organizationLeft")
    public String organizationLeft() {
        return "organization/left";
    }

    //Organization登陆成功的右侧的界面
    @RequestMapping("/organizationWelcome")
    public String organizationWelcome() {
        return "organization/welcome";
    }

    //Organization首页底部的界面
    @RequestMapping("/organizationBottom")
    public String organizationBottom() {
        return "organization/bottom";
    }
}
