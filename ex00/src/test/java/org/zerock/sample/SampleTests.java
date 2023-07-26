package org.zerock.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;



// 테스트 환경
@RunWith(SpringJUnit4ClassRunner.class)	// Spring test 하려면 써야함
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") 
@Slf4j // log 기능쓰려면 넣어야하고
public class SampleTests {
	
	@Autowired
	private Restaurant restaurant;
	
	@Autowired
	private SampleHotel hotel;
	
	@Test // test쓰려면 이거도 또 추가해놔야함
	public void testExist() {
		log.info("restaurant : {} ", restaurant);
		log.info("restaurant : {} ", restaurant.getChef());
	}
	
	@Test
	public void testHotel() {
		log.info("hotel : {} ", hotel.getChef());
	}
}
