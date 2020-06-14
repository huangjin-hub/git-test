package com.woniu.permission.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述:<br>
 * 〈〉
 *
 * @author wugd
 * @create 2020/4/1
 * @since 1.0.0
 */
@Data
public class Permission {
    private Integer id;
    private String name;
    private String url;
    private Integer pid;
    private boolean open = true;
    private boolean checked = false;
    private String icon;
    private List<Permission> children = new ArrayList<Permission>();
}
