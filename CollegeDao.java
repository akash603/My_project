package college.com.college.dao;

 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import college.com.college.entity.CollegeEntity;
@Repository
public class CollegeDao {
	String connectionString="jdbc:mysql://localhost:3306/college";
	String user="root";
	String pass="12345";
	
	public String addData(@RequestBody CollegeEntity college) throws Exception
	{
		 
		
		Connection connection=DriverManager.getConnection(connectionString,user,pass);
		String insertQuery="insert into std values('"+college.getId()+"','"+college.getStdName()+"','"+college.getStdAddress()+"')";
		Statement statment=connection.createStatement();// to create the link with database and query
		statment.executeUpdate(insertQuery);
		
		return "Data Saved";
		
	}
	public List<CollegeEntity> findAll() throws Exception
	{
		int index=0;
		CollegeEntity college=new CollegeEntity();
		 

	List <CollegeEntity> list=new ArrayList<CollegeEntity>();
	Connection connection=DriverManager.getConnection(connectionString,user,pass);
	String selectQuety="select * from std";
	Statement statement=connection.createStatement();
	ResultSet resultset=statement.executeQuery(selectQuety);
	while(resultset.next())
	{
		college.setId(resultset.getInt("id"));
		college.setStdName(resultset.getString("stdname"));
		college.setStdAddress(resultset.getString("stdaddress"));				
		
		System.out.print(resultset.getInt("id"));
		 
	}
	
	list.add(college); 
	
	
//	System.out.print(list.get(0));
	return list;
	
		
	}
 
	public  CollegeEntity findById(@RequestParam int Id) throws Exception
	{
		 CollegeEntity college=null;
		Connection connection=DriverManager.getConnection(connectionString,user,pass);
		String selectQuery="select * from std where id="+Id;
		Statement statement=connection.createStatement();
		ResultSet resultset=statement.executeQuery(selectQuery);
		if(resultset.next())
		{college=new CollegeEntity();
			college.setId(resultset.getInt("id"));
			college.setStdName(resultset.getString("stdname"));
			college.setStdAddress(resultset.getString("stdaddress"));				
			 
		}	
	 
			return college;
	}
	
	public String deleteByid(@RequestParam int Id) throws Exception
	{
		Connection connection=DriverManager.getConnection(connectionString,user,pass);
		String deleteQuery="DELETE FROM std WHERE Id="+Id;
		Statement statement=connection.createStatement();// to create the link with database and query
		statement.executeUpdate(deleteQuery);
		
		return "Data Deleted";

	}
	
	public String updateById(@RequestBody CollegeEntity collegeEntity) throws Exception
	{
		Connection connection=DriverManager.getConnection(connectionString,user,pass);
		String updateQuery="update std set stdname='"+collegeEntity.getStdName()+"',stdaddress='"+collegeEntity.getStdAddress()+"' where id='"+collegeEntity.getId()+"'"; 
		Statement statement=connection.createStatement();
		statement.executeUpdate(updateQuery);
		
		return "Data Updated Successfully";
		}
}
