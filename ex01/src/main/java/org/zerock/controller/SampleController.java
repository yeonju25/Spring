package org.zerock.controller;

import java.lang.ProcessBuilder.Redirect;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.propertyeditors.CurrencyEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.TodoDTO;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/sample/")
@Slf4j
public class SampleController {

//	@RequestMapping("")
	@GetMapping("/")	// GET방식 쓸거면 바로 @GetMapping 써도됨
	public void basic() {
		log.info("basic......");
	}
	
//	@RequestMapping(value="/list", method = RequestMethod.POST)
//	@PostMapping("/list")	// 마찬가지로 POST방식 쓸 때 @PostMapping
	@GetMapping("/list")
	public String list(String name, Model model) {
		log.info("list......{}", name);
		model.addAttribute("name", name);
		return "list";	// list.jsp 화면이 나올 것
	}
	
	@GetMapping("/ex1")		// 값을 넘겨주지 않으면 오류남
	public void ex01(String name, int age) {
		log.info("name : {} ", name);
		log.info("age : {} ", age);
	}

	@GetMapping("/ex2")		// 값을 넘겨주지 않으면 기본값으로 이걸 쓸거야하는 내용 추가
	public void ex02(@RequestParam(name="name", defaultValue="kim") String name, 
			@RequestParam(name="age", defaultValue = "0") int age) {
		log.info("name : {} ", name);
		log.info("age : {} ", age);
	}
	
	@GetMapping("/ex3")  // 주소창에 ?name=kim으로 보내도 받을 수 있게 @RequestParam("name")
	public void ex03(@RequestParam("name") String n, 
			@RequestParam("age") int a) {
		log.info("name : {} ", n);
		log.info("age : {} ", a);
	}
	
	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("ids")ArrayList<String> ids) {
		log.info("ids: " + ids);
		
		return "ex02List";
	}
	
	@GetMapping("/ex02Array")
	public String ex02Array(@RequestParam("ids") String[] ids) {
		log.info("array ids : " + Arrays.toString(ids));
		return "ex02Array";
	}
	
	@GetMapping("/ex4")	
	// view로 보낼 때 : 객체는 그냥 넘길 수 있다. 변수는 넘겨주려면 @ModelAttribute로 넘겨줌. 
	// 객체 이름 바꿔서 넘기고 싶을 때도 @ModelAttribute 사용하면 됨
	public String ex04(SampleDTO dto, @ModelAttribute("page") int page) {
		log.info("dto : {}", dto);
		return "ex04";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	@GetMapping("/ex5")
	public String ex05(TodoDTO todo) {
		log.info("date : {}", todo);
		return "ex05";
	}

	// 교재 139p, Model이라는 데이터 전달자
	@GetMapping("/ex6")
	public String ex06(Model model) {
		model.addAttribute("text", "Hello World");
		return "ex06";
	}
	
	// 일회성으로 데이터를 전달 / 교재 143p인데 책에는 설명이 부실한 내용 
	@GetMapping("/ex7")
	public String ex07(RedirectAttributes rttr) {
		rttr.addAttribute("name", "AAA");
		rttr.addFlashAttribute("age", 10);
		return "redirect:/sample/list";
		// ex7로 실행해서 가보면 화면에 age는 나타나는데 name은 나타나지 않음, name은 주소창에 나타남 
		// 그런데 여기서 새로고침하여 재요청하면 10도 날아감 / Flash - 한 번 번쩍하고 사라진다고 생각
		// 위 list메소드에 model을 추가해서 그걸로 name전달해주니까 화면상에 name 나타남
	}

	@GetMapping("/ex08")
	public void ex8() {
		log.info("/ex08");
		// type이 void면 views밑에 /sample/ex08 경로를 찾아감, type이 String일 때랑은 다름
	}
	
	// String 타입은 views밑에 jsp를 자동으로 찾아감, void는 경로 다 만들어줘야함
	@GetMapping("/list/ex09")
	public void ex9() {
		log.info("/ex09");
	}
	
	// String은 redirect등으로 여기저기 날릴때 사용한다구 함, 보통은 void쓰나?
	@GetMapping("/ex10")
	public void ex10() {
		log.info("/ex10");
	}
	
	// 객체 모델로 넘기기
	@GetMapping("/ex11")
	public SampleDTO ex11(Model model) {
		SampleDTO dto = new SampleDTO();
		dto.setName("kim");
		dto.setAge(20);
		model.addAttribute("dto", dto);
		return dto;
	}
	
	// 객체 모델로 넘기는 것 보다 더 좋은 방법
	// 자바 객체를 JSON(제이슨)타입으로 자동변환시켜서 화면에 값만 띄워줌, jsp파일 없어도 값 보여줌
	@GetMapping("/ex12")
	public @ResponseBody SampleDTO ex12() {
		SampleDTO dto = new SampleDTO();
		dto.setName("kim");
		dto.setAge(20);
		return dto;
	}
	
	
//	@DeleteMapping("/list/{id}") // 삭제하는 거라는데 다음에 보게 될거라고 하심
	
	@GetMapping("/ex13/{id}")	
			// ex13은 실제 경로 {}안은 값이 들어감
// @PathVariable()안의 이름은 getmapping {}안의 이름과 같으면 생략가능
//	public String ex13(@PathVariable("id") String id) {
	public String ex13(@PathVariable() String id) {
		log.info("id : {}", id);
		return "/sample/ex13";
	}
	
	@GetMapping("/upload")
	public void upload() {
		log.info("/exUpload.....");
	}	// views/sample/upload.jsp 찾아감
	
	
	@PostMapping("/exUploadPost")
	public void exUploadPost(ArrayList<MultipartFile> files) {
//		files.forEach(file->{
//			log.info("----------------------------");
//			log.info("name : {} " , file.getOriginalFilename());
//			log.info("size : {} " , file.getSize());
//		});
		
		// 위 구문 익숙하지 않으면 이렇게 for문으로 써도 됨
		for(MultipartFile file : files) {
			log.info("----------------------------");
			log.info("name2 : {} " , file.getOriginalFilename());
			log.info("size2 : {} " , file.getSize());
		}
	}
	
	
}
