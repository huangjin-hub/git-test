package com.woniu.permission.controller;

import com.github.pagehelper.PageInfo;
import com.woniu.permission.entity.Role;
import com.woniu.permission.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 功能描述:<br>
 * 〈〉
 *
 * @author wugd
 * @create 2020/3/31
 * @since 1.0.0
 */
@Controller
public class RoleController {

    @Autowired
    IRoleService roleService ;

    @RequestMapping("/rolelist")
    public String rolelist(@RequestParam(value = "now",defaultValue = "1") Integer now,
                           @RequestParam(value = "size",defaultValue = "20") Integer size,
                           String name , Model model){
        PageInfo<Role> pageInfo = roleService.findRolePage(now,size,name);
        model.addAttribute("pageInfo",pageInfo);

        return "role/role";
    }

    @RequestMapping("/assignPerView")
    public String assignPerView(int id,Model model){

        model.addAttribute("id",id);

        return "role/assignPermission" ;
    }


    @RequestMapping("/saveRolePer")
    @ResponseBody
    public String saveRolePer(Integer roleid ,Integer[] perids){
        roleService.saveRolePer(roleid,perids);
        return "1" ;
    }

    @RequestMapping("/showRole/{id}")
    @ResponseBody
    public Role showRole(@PathVariable("id") int id){


        return roleService.findRoleByKey(id);
    }


}
