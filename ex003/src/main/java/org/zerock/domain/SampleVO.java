package org.zerock.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor	// 디폴트 생성자를 만들어 준다

public class SampleVO {

	private Integer mno;
	private String firstName;
	private String lastName;
	
}
