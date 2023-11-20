package college.com.college.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import college.com.college.dao.CollegeDao;
import college.com.college.entity.CollegeEntity;

@Service 
public class CollegeService {

	
	
	@Autowired
	CollegeDao dao=null;
	public String addData(@RequestBody CollegeEntity college) throws Exception
	{
		
		return dao.addData(college);
		
	}
	public List<CollegeEntity> findAll() throws Exception
	{
		
		return dao.findAll();
		
	}
	
	public CollegeEntity findById(@RequestParam int Id) throws Exception
	{
		
		return dao.findById(Id);
			
		
	}
	
	public String deleteByid(@RequestParam int Id) throws Exception
	{
		return dao.deleteByid(Id);
	}
	
	public String updateById(@RequestBody CollegeEntity collegeEntity) throws Exception
	{
		return dao.updateById(collegeEntity);
	}
	
}
