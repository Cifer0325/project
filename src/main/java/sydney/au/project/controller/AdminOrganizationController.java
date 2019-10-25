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


import sydney.au.project.model.Organization;
import sydney.au.project.service.AdminOrganizationService;

@Controller
public class AdminOrganizationController {

	@Resource
	private AdminOrganizationService adminOrganizationService;
	
	@ModelAttribute("organization")
    public void getOrganization(@RequestParam(value = "oid", required = false) Integer oid, Map<String, Object> map) {
        if (oid != null) {
            Organization organization = adminOrganizationService.findOrganization(oid);
            map.put("organization", organization);
        }
    }

    //修改一级分类
    @RequestMapping(value = "/updateOrganization")
    public ModelAndView updateOrganization(@ModelAttribute("organization") Organization organization) {
    	adminOrganizationService.updateOrganization(organization);
        ModelAndView modelAndView = new ModelAndView("redirect:/listOrganization/1");
        return modelAndView;
    }

    //跳转到修改一级分类
    @RequestMapping(value = "/gotoEditOrganization/{oid}")
    public String gotoEditOrganization(@PathVariable("oid") Integer oid, Map<String, Object> map) {
        Organization organization = adminOrganizationService.findOrganization(oid);
        map.put("organization", organization);
        return "admin/organization/edit";
    }

    //删除一级分类
    @RequestMapping(value = "/deleteOrganization/{oid}/{page}")
    public ModelAndView deleteOrganization(@PathVariable("oid") Integer oid, @PathVariable("page") Integer page) {
    	adminOrganizationService.deleteOrganization(oid);
        ModelAndView modelAndView = new ModelAndView("redirect:/listOrganization/" + page);
        return modelAndView;
    }

    //添加一级分类，parameter为前台传过来的一级分类的名称
    @RequestMapping(value = "/addOrganization")
    public ModelAndView addOrganization(@RequestParam(value = "organname", required = true) String organname,
    		                            @RequestParam(value = "password", required = true) String password) {
        //创建一级分类的对象
        Organization organization = new Organization();
        organization.setOrganname(organname);
        organization.setPassword(password);
        adminOrganizationService.saveOrganization(organization);
        ModelAndView modelAndView = new ModelAndView("redirect:listOrganization/1");
        return modelAndView;
    }

    //跳转到添加一级分类
    @RequestMapping(value = "/gotoAddOrganization")
    public String gotoOrganization() {
        return "admin/organization/add";
    }

    //查询一级分类
    @RequestMapping(value = "/listOrganization/{page}")
    public String listOrganization(@PathVariable("page") Integer page, Map<String, Object> map) {
        List<Organization> organizations = adminOrganizationService.listOrganization(page);
        map.put("organizations", organizations);
        map.put("page", page);
        //查询一级分类的页数
        Integer count = adminOrganizationService.countOrganization();
        map.put("count", count);
        return "admin/organization/list";
    }
}
