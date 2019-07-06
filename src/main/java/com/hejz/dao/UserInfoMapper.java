package com.hejz.dao;

import com.hejz.entity.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;


public interface UserInfoMapper {

 public List<UserInfo> findAll();

  @Insert("upsert into USER (ID,NAME) VALUES (#{user.id},#{user.name})")
  public void addUser(@Param("user") UserInfo userInfo);

 @Delete("delete from USER WHERE ID=#{id}")
  public void deleteUser(@Param("id") int id);

  @Results( value = {
          @Result(property = "id", column = "ID", id = true),
          @Result(property = "name", column = "NAME")
  })
  @Select("select * from USER WHERE ID=#{id}")
  public UserInfo findById(int id);

  @Results( value = {
          @Result(property = "id", column = "ID", id = true),
          @Result(property = "name", column = "NAME")
  })
  @Select("select * from USER WHERE NAME=#{name}")
  public List<UserInfo> getUserByName(@Param("name") String name);

  @Results( value = {
          @Result(property = "id", column = "ID", id = true),
          @Result(property = "name", column = "NAME")
  })
  @Select("select * from USER")
  public List<UserInfo> getUsers();

 @Results( value = {
         @Result(property = "id", column = "ID", id = true),
         @Result(property = "name", column = "NAME")
 })
 @Select("select * from USER left join bj on user.id= bj.user_id where id=3")
 public Map getUsers1();


}
