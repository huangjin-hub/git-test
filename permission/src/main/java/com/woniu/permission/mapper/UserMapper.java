package com.woniu.permission.mapper;

import com.woniu.permission.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 功能描述:<br>
 * 〈〉
 *
 * @author wugd
 * @create 2020/3/31
 * @since 1.0.0
 */
@Mapper
@Repository
public interface UserMapper {

    @Select("select * from t_user  where id = #{id}")
    public User selectUserByKey(int id);

    @Select("select * from t_user where username =#{username} and password =#{password}")
    User selectUserByLogin(User user);

    List<User> selectUserList(String name);

    void insertUser(User user);

    void insertUserRole(@Param("userid") Integer userid, @Param("roleid") Integer roleid);

    @Delete("delete from t_userrole where userid = #{userid} and roleid = #{roleid}")
    void deleteUserRole(@Param("userid") Integer userid, @Param("roleid") Integer i);
}
