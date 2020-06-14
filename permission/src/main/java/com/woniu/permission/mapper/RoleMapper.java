package com.woniu.permission.mapper;

import com.woniu.permission.entity.Role;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RoleMapper {

    @Select("select * from t_role ")
    List<Role> selectRolePage(String name);

    @Select("select * from t_role ")
    List<Role> selectAll();

    @Insert("insert into t_roleper (id,roleid) values(#{id} ,#{rid}) ")
    void insertRolePer(@Param("rid") Integer roleid, @Param("id") Integer id);

    @Select("select * from t_role where roleid = #{id}")
    Role selectRoleByKey(int id);
}
