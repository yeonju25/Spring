package org.zerock.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.SampleVO;
import org.zerock.domain.Ticket;

import lombok.extern.slf4j.Slf4j;

@RestController	// @Controller + @ResponseBody
// view화면 찾아가지 않고 모든 걸 문자열로 전송하겠다는 뜻, @ResponseBody 안적어도 그렇게 함
@RequestMapping("/sample")
@Slf4j
public class SampleController {

	@GetMapping(value = "/getText", produces = "text/html; charset=utf-8")
	public String getText() {
		log.info("MIME Type : {}", MediaType.TEXT_PLAIN_VALUE);
		return "안녕하세요";
	}
	
	// ResponseBody없으면 안녕하세요.jsp화면을 찾아가는데 ResponseBody넣으면 문자열을 바로 전송함
//	@GetMapping(value = "/getText", produces = "text/html; charset=utf-8")
//	public @ResponseBody String getText() {
//		log.info("MIME Type : {}", MediaType.TEXT_PLAIN_VALUE);
//		return "안녕하세요";
//	}
	
	@GetMapping(value = "/getSample", produces = {MediaType.APPLICATION_JSON_VALUE,
							MediaType.APPLICATION_XML_VALUE})
	public SampleVO getSample() {
		return new SampleVO(112, "스타", "로드");
	}
	
	@GetMapping("/getList")
	public List<SampleVO> getList(){
		
//		List<SampleVO> list = new ArrayList<SampleVO>();
//		for(int i=1; i<=10; i++) {
//			list.add(new SampleVO(i, i+"FirstName", i+"LastName"));
//		}
//		return list;
		
		// 위 내용을 한줄로 쓴 것
		return IntStream.range(1, 10).mapToObj(i-> new SampleVO(i, i+"FirstName", i+"LastName"))
				.collect(Collectors.toList());
	}
	
	
	@GetMapping("/getMap")
	public Map<String, SampleVO> getMap(){
		Map<String, SampleVO> map = new HashMap<String, SampleVO>();
		
		map.put("first", new SampleVO(111, "크루트", "주니어"));
		return map;
	}
	
	// 상태 코드 같이 전달
	@GetMapping(value = "/check", params = {"height", "weight"})
	public ResponseEntity<SampleVO> check(Double height, Double weight){
		SampleVO vo = new SampleVO(0, ""+height, ""+weight);
		
		ResponseEntity<SampleVO> result = null;
		
		if(height<150)
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
		else
			result = ResponseEntity.status(HttpStatus.OK).body(vo);
			
		return result;
	}
	
	
	// http://localhost:8081/sample/product/조조.json
	// 주소창에 내가 필요한 값을 실어서 보낼 수 있다. 주소창의 값을 path가 취한다
	@GetMapping("/product/{name}")	// PathVariable() 괄호안의 값은 다 같으면 생략가틍
	public String[] getPath(@PathVariable() String name) {
		return new String[] {"name : "+ name};
	}
	
	@GetMapping("/delete/{age}")	// 같지 않으면 생략할 수 없다.
	public String[] getPath(@PathVariable("age") int no) {
		return new String[] {"name : "+ no};
	}
	
	
	@PostMapping("/ticket")
	public Ticket convert(@RequestBody Ticket ticket) {
		log.info("ticket => {}", ticket.toString());
		return ticket;
	}
	
	
}
