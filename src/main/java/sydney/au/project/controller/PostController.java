package sydney.au.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sydney.au.project.model.Category;
import sydney.au.project.model.CategorySecond;
import sydney.au.project.model.Post;
import sydney.au.project.service.PostService;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

@Controller
public class PostController {

    @Resource
    private PostService postService;

    //根据二级分类查询Post
    @RequestMapping(value = "findByCsid/{csid}/{page}")
    public String findByCsid(@PathVariable("csid") Integer csid, @PathVariable("page") Integer page
            , Map<String, Object> map) {
        Integer count = postService.CountPagePostFromCategorySecond(csid);
        if (page > count) {
            page = 1;
        }
        List<Post> posts = postService.findByCsid(csid, page);
        map.put("posts", posts);
        //把当前的页数存放到map中
        map.put("page", page);
        //总共有多少页
        map.put("count", count);
        map.put("csid", csid);
        return "postList";
    }

    //首页中点击一级分类查询Post
    @RequestMapping(value = "/findByCid/{cid}/{page}")
    public String findByCid(@PathVariable("cid") Integer cid, @PathVariable("page") Integer page
            , Map<String, Object> map) {

        List<Post> posts = postService.findByCid(cid, page);
        Integer count = postService.CountPagePostFromCategory(cid);
        if (page > count) {
            page = 1;
        }
        map.put("posts", posts);
        //把当前的页数存放到map中
        map.put("page", page);
        //总共有多少页
        map.put("count", count);
        map.put("cid", cid);
        return "postList";
    }

    //根据Post的pid查询Post
    @RequestMapping(value = "findByPid/{pid}", method = RequestMethod.GET)
    public String findByPid(@PathVariable("pid") Integer pid, Map<String, Object> map) {

//		map.put("product", productService.findByPid(pid));
        Post posts = postService.findByPid(pid);
        map.put("posts", posts);    //put product

        CategorySecond categorySecond = posts.getCategorySecond();
//		map.put("categorySecond", categorySecond);

        Category category = categorySecond.getCategory();
//		map.put("category", category);


//		int length = privilegeTime.length();

        return "post";
    }
}

