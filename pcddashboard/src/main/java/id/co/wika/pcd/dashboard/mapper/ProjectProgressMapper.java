package id.co.wika.pcd.dashboard.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import id.co.wika.pcd.dashboard.model.Project;
import id.co.wika.pcd.dashboard.model.ProjectProgress;

@Mapper
public interface ProjectProgressMapper {
	
	@Insert("INSERT into project_progress(month, year, "
			+ "prognosa_lk, prognosa_ok, prognosa_op, "
			+ "realisasi_lk, realisasi_ok, realisasi_op, "
			+ "rkap_lk, rkap_ok, rkap_op,"
			+ "project_id"
			+ ") VALUES(#{month}, #{year}, "
			+ "#{prognosaLk}, #{prognosaOk}, #{prognosaOp}, "
			+ "#{realisasiLk}, #{realisasiOk}, #{realisasiOp}, "
			+ "#{rkapLk}, #{rkapOk}, #{rkapOp}, "
			+ "#{project.id})")
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
        @Result(property = "project", column = "project_id", javaType=Project.class, 
        		one=@One(select="id.co.wika.pcd.dashboard.mapper.ProjectMapper.findById")),
      })
	@Select("SELECT * FROM project_progress pp LEFT JOIN project p ON "
			+ "pp.project_id = p.id "
			+ "WHERE p.code=#{code} and month=#{month} and year=#{year}")
	ProjectProgress findByCodeMonthYear(@Param("code") String code, @Param("month") int month, @Param("year") int year);
	
	@Update("UPDATE project_progress SET month=#{month}, year=#{year}, "
			+ "prognosa_lk=#{prognosaLk}, "
			+ "prognosa_ok=#{prognosaOk}, "
			+ "prognosa_op=#{prognosaOp}, "
			+ "realisasi_lk=#{realisasiLk}, "
			+ "realisasi_ok=#{realisasiOk}, "
			+ "realisasi_op=#{realisasiOp}, "
			+ "rkap_lk=#{rkapLk}, "
			+ "rkap_ok=#{rkapOk}, "
			+ "rkap_op=#{rkapOp} "
			+ "WHERE id = #{id}")
	public void update(ProjectProgress projectProgress);

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
	@Select("SELECT * FROM project_progress WHERE month=#{month} and year=#{year}")
	public List<ProjectProgress> findByMonthAndYear(@Param("month") int month, @Param("year") int year);

}
