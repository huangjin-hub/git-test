package com.woniu.permission.controller;

import com.woniu.permission.entity.Permission;
import com.woniu.permission.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 功能描述:<br>
 * 〈〉
 *
 * @author wugd
 * @create 2020/4/1
 * @since 1.0.0
 */
@Controller
public class PermissionController {

    @Autowired
    IPermissionService permissionService ;

    @RequestMapping("/perlist")
    public String perlist(){

        return "permission/permission";
    }

    @RequestMapping("/loadData")
    @ResponseBody
    public List<Permission> loadDate(){
        /*List<Permission> lists = new ArrayList<>();
        Permission p1 = new Permission();
        p1.setId(1);
        p1.setPid(0);
        p1.setName("控制面板");

        Permission p2 = new Permission();
        p2.setId(2);
        p2.setPid(1);
        p2.setName("权限管理");
        lists.add(p1);
        lists.add(p2);
        lists.add(root);*/
        return permissionService.findAll() ;
    }

    @RequestMapping("/addNodeView")
    public String addNodeView(Integer id, Model model){
        model.addAttribute("id",id);

        return "permission/addNode";
    }

    @RequestMapping("/saveNode")
    public String saveNode(Permission permission){

        permissionService.saveNode(permission);

        return "redirect:perlist";
    }

}
