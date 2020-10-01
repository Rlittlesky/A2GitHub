package com.rtl.dao;

import com.rtl.po.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author rentianlun
 * @create 2020-10-01-8:52
 */
public interface DeptDao {

    /**
     * 查询全部
     * @return
     */
    @Select("select * from dept")
    //手动配置
  /*  @Results(id = "deptResult",value = {
            @Result(id = true,property = "dept_id",column = "dept_id"),
            @Result(property = "dept_name",column = "dept_name")
    })*/
    List<Dept> selectAll();

    /**
     * 根据ID查询
     * @param dept_id
     * @return
     */
   /* @ResultMap("deptResult")*/
    @Select("select * from dept where dept_id=#{dept_id}")
    Dept selectOne(int dept_id);

    @Insert("insert into dept(dept_name) values (#{dept_name})")
    int insert(Dept dept);

    @Update("update dept set dept_name=#{dept_name} where dept_id=#{dept_id}")
    int update(Dept dept);

    @Delete("delete from dept where dept_id=#{dept_id}")
    int delete(int dept_id);
}
