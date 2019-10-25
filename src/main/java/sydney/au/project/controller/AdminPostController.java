package sydney.au.project.controller;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import sydney.au.project.model.Admin;
import sydney.au.project.model.CategorySecond;
import sydney.au.project.model.Post;
import sydney.au.project.service.AdminCategorySecondService;
import sydney.au.project.service.AdminPostService;
import sydney.au.project.service.AdminService;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class AdminPostController {

    @Resource
    private AdminPostService adminPostService;
    @Resource
    private AdminCategorySecondService adminCategorySecondService;
    @Resource
    private AdminService adminService;

    //更新Post
    @RequestMapping(value = "/updatePost")
    public ModelAndView updatePost(@ModelAttribute("post") Post post
            , @RequestParam("upload") CommonsMultipartFile upload, HttpServletRequest request, Integer csid) {
        ServletContext servletContext = request.getSession().getServletContext();
        //查询该Post
        Post oldPost = adminPostService.findPost(post.getPid());
        //从字符串截出该图片的名称
        int begin = oldPost.getImage().lastIndexOf("/");
        String filename = oldPost.getImage().substring(begin + 1, oldPost.getImage().length());
        System.out.println(filename);
        //获取文件的名称
        String uploadFilename = upload.getOriginalFilename();
        //如果上传的图片的名称和旧的照片不一致
        if (filename != uploadFilename && !"".equals(uploadFilename)) {
            //获取文件保存目录
            String path = servletContext.getRealPath("/posts/3");
            try {
                FileUtils.writeByteArrayToFile(new File(path, uploadFilename), upload.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
            //重新设置文件的路径
            post.setImage("posts/3/" + uploadFilename);
            //更新Post的时间
            post.setPdate(new Date());
            //删除旧的Post图片
            path = request.getSession().getServletContext().getRealPath("/" + oldPost.getImage());
            File file = new File(path);
            file.delete();
        } else {
            post.setPdate(new Date());
        }
        //更新Post
        if (csid != null) {
            //该Post所属的二级分类
            CategorySecond categorySecond = adminCategorySecondService.findCategorySecond(csid);
            post.setCategorySecond(categorySecond);
        }
        adminPostService.updatePost(post);
        ModelAndView modelAndView = new ModelAndView("redirect:/listPost/1");
        return modelAndView;
    }

    //修改Post
    @RequestMapping(value = "/editPost/{pid}")
    public ModelAndView editPost(@PathVariable("pid") Integer pid) {
        ModelAndView modelAndView = new ModelAndView("admin/post/edit");
        //获取管理员信息
        Admin admin = adminService.findAdminByAid(1);
        //查询所有二级分类的集合
        List<CategorySecond> categorySeconds = adminCategorySecondService.listCategorySecond();
        modelAndView.addObject("categorySeconds", categorySeconds);
        //查询Post
        Post post = adminPostService.findPost(pid);
        modelAndView.addObject("admin", admin);
        modelAndView.addObject("post", post);
        return modelAndView;
    }

    //删除Post
    @RequestMapping(value = "/deletePost/{pid}")
    public ModelAndView deletePost(@PathVariable("pid") Integer pid, HttpServletRequest request) {
        //获取该Post的对象
        Post post = adminPostService.findPost(pid);
        //获取文件保存目录
        String path = request.getSession().getServletContext().getRealPath("/" + post.getImage());
        File file = new File(path);
        // 删除Post服务器上的图片:
        file.delete();
        //删除Post在数据库中的记录
        adminPostService.deletePost(post);
        ModelAndView modelAndView = new ModelAndView("redirect:/listPost/1");
        return modelAndView;
    }

    //上传Post
    @RequestMapping(value = "/addPost", method = RequestMethod.POST)
    public ModelAndView addPost(@ModelAttribute("post") Post post,
                                   @RequestParam("upload") CommonsMultipartFile upload, HttpServletRequest request,
                                   Integer csid) {
        //获取文件保存目录
        ServletContext servletContext = request.getSession().getServletContext();
        String path = servletContext.getRealPath("/posts/3");
        //获取文件的名称
        String filename = upload.getOriginalFilename();
        try {
            FileUtils.writeByteArrayToFile(new File(path, filename), upload.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //设置文件的路径
        post.setImage("posts/3/" + filename);
        //设置上传的时间
        post.setPdate(new Date());
        //该商品所属的二级分类
        CategorySecond categorySecond = adminCategorySecondService.findCategorySecond(csid);
        post.setCategorySecond(categorySecond);
        //保存Post
        adminPostService.savePost(post);
        ModelAndView modelAndView = new ModelAndView("redirect:/listPost/1");
        return modelAndView;
    }

    //跳转到添加Post
    @RequestMapping(value = "/gotoAddPost")
    public ModelAndView gotoAddPost() {
        ModelAndView modelAndView = new ModelAndView("admin/post/add");
        //查询所有二级分类的集合
        List<CategorySecond> categorySeconds = adminCategorySecondService.listCategorySecond();
        modelAndView.addObject("categorySeconds", categorySeconds);
        return modelAndView;
    }

    //分页查询所有的Post
    @RequestMapping(value = "/listPost/{page}")
    public String listPost(@PathVariable("page") Integer page, Map<String, Object> map) {
        //分页查询Post
        List<Post> posts = adminPostService.listPost(page);
        //查询Post的页数
        Integer count = adminPostService.countPost();
        map.put("posts", posts);
        map.put("page", page);
        map.put("count", count);
        return "admin/post/list";
    }
}

