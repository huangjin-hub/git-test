package com.woniu.permission.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 功能描述:<br>
 * 〈〉
 *
 * @author wugd
 * @create 2020/3/31
 * @since 1.0.0
 */
@Data
public class Role implements Serializable {
    private Integer roleid;
    private String rname;
}
