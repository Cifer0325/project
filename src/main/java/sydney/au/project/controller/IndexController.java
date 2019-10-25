package sydney.au.project.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import sydney.au.project.service.CategoryService;
import sydney.au.project.service.PostService;


@Controller
public class IndexController {
    @Resource
    private CategoryService categoryService;

    @Resource
    private PostService postService;

    //Post首页的action
    @RequestMapping(value = "/index")
    public String showIndex(Map<String, Object> map, HttpSession session) {
        //把所有的一级分类都存入到session中
        session.setAttribute("cList", categoryService.getCategory());

        //把最新的10条Post存放到map集合中
        map.put("nList", postService.findNew());
        //把最热的10条Post添加到map集合中
        map.put("hList", postService.findHot());

        return "index";
    }
}
