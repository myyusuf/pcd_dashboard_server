package id.co.wika.pcd.dashboard.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import id.co.wika.pcd.dashboard.model.Project;

@Mapper
public interface ProjectMapper {
	
	@Results({
        @Result(property = "projectType", column = "project_type")
      })
	@Select("SELECT * FROM project WHERE id = #{id}")
    Project findById(@Param("id") int id);
	
	
	@Results({
        @Result(property = "projectType", column = "project_type")
      })
	@Select("SELECT * FROM project WHERE code = #{code}")
    Project findByCode(@Param("code") String code);
	
	@Results({
		@Result(property = "projectType", column = "project_type")
      })
	@Select("SELECT * FROM project")
	List<Project> findAll();
	
	@Insert("INSERT into project(code, name, description, project_type) VALUES(#{code}, #{name}, #{description}, #{projectType})")
	void create(Project project);
	
	@Update("UPDATE project SET name=#{name}, description=#{description}, project_type=#{projectType} WHERE code = #{code}")
	void update(Project project);
	
	@Delete("DELETE FROM project WHERE code = #{code}")
	void delete(String code);

}
