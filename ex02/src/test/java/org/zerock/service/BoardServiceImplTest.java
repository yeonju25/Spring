package org.zerock.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Slf4j
public class BoardServiceImplTest {
	
	@Autowired
	private BoardService service;
	
	@Test
	public void testGetList() {
		log.info("------------------------GetList");
		service.getList().forEach(
					(list)->{
						log.info("list : {}", list);
		});
	}
	
	@Test
	public void testRemove() {
		log.info("------------------------Remove");
		log.info("delete ===> : {}", service.remove(2L));
	}
	
	@Test
	public void testModify() {
		log.info("------------------------Modify");
		BoardVO vo = new BoardVO();
		vo.setTitle("JSP");
		vo.setContent("JSP 마스터중");
		vo.setWriter("성윤정");
		vo.setBno(3L);
		
		log.info("modify : {}", service.modify(vo));
	}

	@Test
	public void testGet() {
		log.info("------------------------Get");
		log.info("Get ===> : {}", service.get(3L));
	}
	
	@Test
	public void testRegister() {
		log.info("------------------------Register");
		BoardVO vo = new BoardVO();
		vo.setBno(4L);
		vo.setTitle("추가하는중");
		vo.setContent("추가가 잘되나");
		vo.setWriter("김추가");
		service.register(vo);
	}
	
}
