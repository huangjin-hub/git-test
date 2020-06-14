package com.woniu.permission.controller;

import com.github.pagehelper.PageInfo;
import com.woniu.permission.entity.Permission;
import com.woniu.permission.entity.Role;
import com.woniu.permission.entity.User;
import com.woniu.permission.service.IPermissionService;
import com.woniu.permission.service.IRoleService;
import com.woniu.permission.service.IUerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 功能描述:<br>
 * 〈〉
 * @author wugd
 * @create 2020/3/31
 * @since 1.0.0
 */
@Controller
//@RequestMapping("user")
public class UserController {
    @Autowired
    IUerService uerService ;
    @Autowired
    IRoleService roleService ;

    @Autowired
    IPermissionService permissionService ;

    @GetMapping("/user/{id}")
    @ResponseBody
    public User showUser(@PathVariable("id") Integer id) {

        return uerService.findUserByKey(id);


    }

    //prefix="/templates/"  login  subfix=".html" = /templates/login.html

   /* @RequestMapping("/login.html")
    public String login(){

        return "login" ;
    }*/

   @RequestMapping("/login")
   public String login(User user, HttpSession httpSession, Model model){
       User userInfo = uerService.findUserByLogin(user);

       if (userInfo != null) {
           httpSession.setAttribute("userInfo",userInfo);  //将来可以存储到redis

           //查询权限
           List<Permission> plists = permissionService.findPerByUser(userInfo.getId());
           Map<Integer, Permission> permissionMap = new HashMap<Integer, Permission>();
           Permission root = null;
           for ( Permission permission : plists ) {
               permissionMap.put(permission.getId(),permission);
           }

           for ( Permission permission : plists ) {
               Permission child = permission;
               if ( child.getPid() == 0 ) {
                   root = permission;
               } else {
                   Permission parent = permissionMap.get(child.getPid());
                   parent.getChildren().add(child);
               }
           }
           httpSession.setAttribute("rootPermission", root);
           //转到主页面
           return "redirect:main.html" ;
       }else {
            model.addAttribute("errorInfo","用户名或者密码错误");
           return "login.html" ;
       }
   }


   @RequestMapping("/userlist")
   public String userlist(@RequestParam(value = "now",defaultValue = "1") Integer now,
                          @RequestParam(value = "size",defaultValue = "20") Integer size,
                          String name ,Model model){
      PageInfo<User> pageInfo =  uerService.findUserPage(now,size,name);
      model.addAttribute("pageInfo" ,pageInfo);

      return "user/user";
   }

   @RequestMapping("/userView")
   public String userView(){

       return "user/add" ;
   }

   @RequestMapping("/saveUser")
   public String saveUser(User user){
       uerService.saveUser(user);
       return "redirect:userlist";
   }

   @RequestMapping("/assingnRole")
   public String assingnRole(int id,Model model){
       //System.out.println(id+"===================================='");
        model.addAttribute("id",id);

        //查询所有角色
       List<Role> lists = roleService.findAllRole();
       model.addAttribute("lists",lists);
       //????
       return "user/assignRole";
   }


   @RequestMapping("/addUseRole")
   @ResponseBody
   public String addUseRole(Integer userid,Integer[] leftRoles){
      // System.out.println(userid);
       uerService.saveUserRole(userid,leftRoles);
       return "1" ;
   }

    @RequestMapping("/removeUseRole")
    @ResponseBody
    public String removeUseRole(Integer userid,Integer[] rightRoles){
        // System.out.println(userid);
        uerService.removeUserRole(userid,rightRoles);
        return "1" ;
    }

}
