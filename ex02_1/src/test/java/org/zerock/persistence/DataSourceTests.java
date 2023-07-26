package org.zerock.persistence;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Slf4j
public class DataSourceTests {
	@Autowired
	private DataSource dataSource;
	
	@Test
	public void testConnection() {
		try(Connection conn = dataSource.getConnection()) {
			log.info("conn :{}", conn);
		} catch (Exception e) {	
			e.printStackTrace();
		}
	}
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void testMybatis() {
		try(SqlSession session = sqlSessionFactory.openSession();
				Connection conn = session.getConnection();) {
			log.info("session : {}", session);
			log.info("conn : {} ", conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
