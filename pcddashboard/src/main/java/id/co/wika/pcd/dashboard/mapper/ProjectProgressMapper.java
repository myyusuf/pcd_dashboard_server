package id.co.wika.pcd.dashboard.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import id.co.wika.pcd.dashboard.model.Project;
import id.co.wika.pcd.dashboard.model.ProjectProgress;

@Mapper
public interface ProjectProgressMapper {
	
	@Insert("INSERT into project_progress(month, year, "
			+ "prognosa_lk, prognosa_ok, prognosa_op, "
			+ "realisasi_lk, realisasi_ok, realisasi_op, "
			+ "rkap_lk, rkap_ok, rkap_op "
			+ ") VALUES(#{month}, #{year}, "
			+ "#{prognosaLk}, #{prognosaOk}, #{prognosaOp}, "
			+ "#{realisasiLk}, #{realisasiOk}, #{realisasiOp}, "
			+ "#{rkapLk}, #{rkapOk}, #{rkapOp} "
			+ ")")
	void create(ProjectProgress projectProgress);

	@Results({
        @Result(property = "prognosaLk", column = "prognosa_lk"),
        @Result(property = "prognosaOk", column = "prognosa_ok"),
        @Result(property = "prognosaOp", column = "prognosa_op"),
        @Result(property = "realisasiLk", column = "realisasi_lk"),
        @Result(property = "realisasiOk", column = "realisasi_ok"),
        @Result(property = "realisasiOp", column = "realisasi_op"),
        @Result(property = "rkapLk", column = "rkap_lk"),
        @Result(property = "rkapOk", column = "rkap_ok"),
        @Result(property = "rkapOp", column = "rkap_op"),
        @Result(property = "project", column = "project_id", javaType=Project.class, 
        		one=@One(select="id.co.wika.pcd.dashboard.mapper.ProjectMapper.findById")),
      })
	@Select("SELECT * FROM project_progress ")
	List<ProjectProgress> findAll();

	@Results({
        @Result(property = "prognosaLk", column = "prognosa_lk"),
        @Result(property = "prognosaOk", column = "prognosa_ok"),
        @Result(property = "prognosaOp", column = "prognosa_op"),
        @Result(property = "realisasiLk", column = "realisasi_lk"),
        @Result(property = "realisasiOk", column = "realisasi_ok"),
        @Result(property = "realisasiOp", column = "realisasi_op"),
        @Result(property = "rkapLk", column = "rkap_lk"),
        @Result(property = "rkapOk", column = "rkap_ok"),
        @Result(property = "rkapOp", column = "rkap_op"),
      })
	@Select("SELECT * FROM project_progress WHERE code = #{code}")
	ProjectProgress findByCodeMonthYear(String code, int month, int year);

	public void update(ProjectProgress projectProgress);

	public List<ProjectProgress> findByMonthAndYear(int month, int year);

}
