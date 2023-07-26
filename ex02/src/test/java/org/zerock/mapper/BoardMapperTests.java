package org.zerock.mapper;

import java.nio.MappedByteBuffer;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criterial;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Slf4j
public class BoardMapperTests {
	
	@Autowired
	private BoardMapper boardMapper;
	
	
	
	@Test		// console 중간에 DB데이터 들어오면 성공
	public void testGetList() {
//		List<BoardVO> list = boardMapper.getList();
//		
//		for(BoardVO vo : list) {
//			log.info("vo : {}", vo);
//		}
		
		// 위 내용과 같음
		boardMapper.getList().forEach((vo)->{
			log.info("vo : {}", vo);
		});
	}
	
	@Test
	public void testInsert() {
		BoardVO vo = new BoardVO();
		
		vo.setTitle("java");
		vo.setContent("자바 공부 중");
		vo.setWriter("김자바");
		
		int result = boardMapper.insert(vo);
		log.info("result : {}", result);
	}
	
	@Test
	public void testInsertSelectKey() {
		BoardVO vo = new BoardVO();
		
		vo.setTitle("React");
		vo.setContent("리액트 공부 중");
		vo.setWriter("리액트");
		
		int result = boardMapper.insertSelectKey(vo);
		log.info("result : {}", result);
	}
	
	@Test
	public void testUpdate() {
		BoardVO vo = new BoardVO();
		
		vo.setBno(3L);
		vo.setTitle("Spring");
		vo.setContent("스프링 공부 중");
		vo.setWriter("스프링");
		
		int result = boardMapper.update(vo);
		log.info("result : {}", result);
	}
	
	@Test
	public void testRead() {
		BoardVO vo = boardMapper.read(4L);
		log.info("vo : {} ", vo);
	}
	
	@Test
	public void testDelete() {
		int result = boardMapper.delete(4L);
		log.info("result : {}", result);
	}
	
	@Test
	public void testInsert2() {
		BoardVO vo = new BoardVO();
		vo.setTitle("미미");
		vo.setContent("미생물이다");
		vo.setWriter("린클");
		
		int result = boardMapper.insert(vo);
		log.info("result : {}", result);
	}
	
	@Test
	public void testUpdate2() {
		BoardVO vo = new BoardVO();
		vo.setBno(23L);
		vo.setContent("미생물 먹는다");
		vo.setTitle("미미2");
		vo.setWriter("린클이다");
		int result = boardMapper.update(vo);
		log.info("result : {}", result);
	}
	
	@Test
	public void testPaging() {
		Criterial cri = new Criterial();
		
		List<BoardVO> list = boardMapper.getListWithPaging(cri);
		
		list.forEach(vo -> log.info("vo : {}", vo));
	}
	
}
