package com.jrp.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jrp.pma.dto.ChartData;
import com.jrp.pma.dto.TimelinesData;
import com.jrp.pma.entities.Project;

public interface ProjectRepository extends CrudRepository<Project, Long>{
	@Override
	public List<Project> findAll();
	
	@Query(nativeQuery = true, value="select stage as label, COUNT(*) as value "
			+ "FROM project "
			+ "GROUP BY stage")
	public List<ChartData> projectStages();
	
	@Query(nativeQuery = true, value="select name, start_date as startDate, end_date as endDate"
			+ "FROM project ")
	public List<TimelinesData> projectTenures();

}