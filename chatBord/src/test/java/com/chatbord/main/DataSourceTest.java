package com.chatbord.main;



import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/wepapp/WEB-INF/spring/applicationContext.xml"})
public class DataSourceTest {

	@Inject
	private DataSource dataSource;
	
	@Test
	public void testConnection() throws Exception {
		try(Connection connection = dataSource.getConnection()){
			System.out.println("커넥션 성공" + connection);
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}
