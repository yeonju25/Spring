package org.zerock.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class CommonExceptionAdvice {

	//servlet-context 18번줄 아래 참고 / 이 때문에 views로 날려주는 것
	//servlet-context에 component-scan 추가해줘야 함
	@ExceptionHandler
	public String except(Exception ex, Model model) {
		log.error("Exception: {}", ex.getMessage());
		model.addAttribute("exception",ex);
		log.error("model : {}", model);
		return "error_page";
	}
}
