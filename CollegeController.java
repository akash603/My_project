package college.com.college.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import college.com.college.entity.CollegeEntity;
import college.com.college.service.CollegeService;

@RestController
public class CollegeController {

	
	@Autowired
	CollegeService service=null;
	@PostMapping("/addData")
	public String addData(@RequestBody CollegeEntity college) throws Exception
	{
		
		return service.addData(college);
		
	}
	@GetMapping("/findAll")
	public List<CollegeEntity> findAll() throws Exception
	{
		
		return service.findAll();
		
	}
	
	@GetMapping("/findByid")
	public CollegeEntity findById(@RequestParam int Id) throws Exception
	{
		return service.findById(Id);
	}
	
	@DeleteMapping("/deleteByid")
	public String deleteByid(@RequestParam int Id) throws Exception
	{
		return service.deleteByid(Id);
	}
	
	@PutMapping("/updateByid")
	public String updateById (@RequestBody CollegeEntity collegeEntity) throws Exception
	{
		return service.updateById(collegeEntity);
	}
	
	
}
