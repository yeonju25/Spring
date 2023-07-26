package org.zerock.sample;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Component
@ToString
@Getter
//@AllArgsConstructor		// 생성자 생성해줌
@RequiredArgsConstructor 	// 이걸 하면 final 키워드 추가해줘야 함
public class SampleHotel {
//	private Chef chef;
	
	private final Chef chef; // @RequiredArgsConstructor 쓸 때는 final 추가됨, 최근 선호하는 방식
	
//	public SampleHotel(Chef chef) {
//		this.chef = chef;
//	}
		
	
}
