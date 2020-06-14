package com.woniu.permission.mapper;

import com.woniu.permission.entity.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PermissionMapper {

    @Select("select * from t_permission")
    List<Permission> selectAll();

    @Insert("insert into t_permission (name,pid,url,icon) values (#{name},#{pid},#{url},#{icon})")
    void insertPermission(Permission permission);

    List<Permission> selectPerByUser(@Param("id") Integer id);
}
