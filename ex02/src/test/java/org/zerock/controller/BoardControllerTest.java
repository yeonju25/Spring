package org.zerock.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
	"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@Slf4j
@WebAppConfiguration
public class BoardControllerTest {

	@Autowired	// 주입
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc; // 가짜, 가상서버 쓰겠다는 것
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test
	public void testList() throws Exception{
		log.info("{}",
				mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))
						.andReturn()
						.getModelAndView()
						.getModelMap() // 결과값 날아올 때 = select일 때
						);
	}
	
	@Test
	public void testRegister() throws Exception{
		log.info("{}",
				mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
				.param("title","오라클")
				.param("content", "view 공부중")
				.param("writer", "이지스퍼블리싱"))
				.andReturn()
				.getModelAndView()
				.getViewName() // 결과값 안 날아올때
				);
	}
	
	@Test
	public void testGet() throws Exception{
		log.info("{}",
				mockMvc.perform(MockMvcRequestBuilders.get("/board/get")
						.param("bno","22"))
				.andReturn()
				.getModelAndView()
				.getModelMap() 
				);
	}
	
	@Test
	public void testRemove() throws Exception{
		log.info("{}",
				mockMvc.perform(MockMvcRequestBuilders.post("/board/remove")
						.param("bno","22"))
				.andReturn()
				.getModelAndView()
				.getViewName()
				);
	}

	
	@Test
	public void testModify() throws Exception{
		log.info("{}",
				mockMvc.perform(MockMvcRequestBuilders.post("/board/modify")
						.param("bno","1")
						.param("title", "타이틀")
						.param("content", "1번이다")
						.param("writer", "일번"))
				.andReturn()
				.getModelAndView()
				.getViewName()
				);
	}
// getModelMap()과 getViewName() 차이 : 리턴값이 있냐 없냐 -> select면 getModelMap() 쓰면 됨
	
	

}
