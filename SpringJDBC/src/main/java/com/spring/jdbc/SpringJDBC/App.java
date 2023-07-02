package com.spring.jdbc.SpringJDBC;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.SpringJDBC.Dao.StudentDao;
import com.spring.jdbc.SpringJDBC.Entity.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "My Programm Started" );
        
        
        // spring jdbc => jdbcTemplate        
        ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/SpringJDBC/config.xml");
        
        StudentDao studentDao = context.getBean("studentDao",StudentDao.class);
        
        Student student = new Student();
        student.setId(666);
        student.setName("John");
        student.setCity("hbsdbfb");
        
        int result = studentDao.insert(student);
        
        System.out.println(result);
    }
}
