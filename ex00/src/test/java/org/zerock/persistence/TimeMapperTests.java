package org.zerock.persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.mapper.TimeMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class TimeMapperTests {

	@Autowired
	private TimeMapper timeMapper;
	
//	@Test
//	public void testGetTime() {
//		log.info("timeMapper : {}", timeMapper );
//	}
	@Test
	public void testGetTime2() {
		log.info("getTime2 : {}", timeMapper.getTime2() );
	}
}
