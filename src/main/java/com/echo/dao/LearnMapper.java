package com.echo.dao;

import com.echo.entity.LearnResource;
import com.mysql.jdbc.StringUtils;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by echo on 2017/7/17.
 */
@Component
@Mapper
public interface LearnMapper {
    @Insert("insert into learn_resource(author, title, url) values (#{author}, #{title}, #{url})")
    int add(LearnResource learnResource);

    @Update("update learn_resource set author=#{author}， title=#{title}, url=#{url} where id={id}")
    int update(LearnResource learnResource);

    @DeleteProvider(type = LearnSqlBuilder.class, method = "deleteByids")
    int deleteByIds(@Param("ids") String[] ids);

    @Select("select * from learn_resource where id = #{id}")
    @Results(id = "learnMap", value = {
            @Result(column = "id", property = "id", javaType = Long.class),
            @Result(column = "author", property = "author", javaType = String.class),
            @Result(column = "title", property = "title", javaType = String.class)
    })
    LearnResource queryLearnResourceById(@Param("id") Long id);

    @SelectProvider(type = LearnSqlBuilder.class, method = "queryLearnResourceByParams")
    List<LearnResource> queryLearnResourceList(Map<String, Object> params);


    class LearnSqlBuilder {
        public String queryLearnResourceByParams(final Map<String, Object> params){
            StringBuffer sql = new StringBuffer();
            sql.append("select * from learn_resource where 1=1");
            if(!StringUtils.isNullOrEmpty( (String) params.get("author") )){
                sql.append(" and author like '%").append((String) params.get("author")).append("%'");
            }
            if(!StringUtils.isNullOrEmpty( (String) params.get("title") )){
                sql.append(" and title like '%").append((String) params.get("title")).append("%'");
            }
            return sql.toString();
        }

        public String deleteByids(@Param("ids") final String[] ids){
            StringBuffer sql = new StringBuffer();
            sql.append("Delete from learn_resource where id in (");
            for (int i=0; i<ids.length; i++){
                if(i == ids.length-1){
                    sql.append(ids[i]);
                } else {
                    sql.append(ids[i]+",");
                }
            }
            sql.append(")");
            return sql.toString();
        }
    }
}
