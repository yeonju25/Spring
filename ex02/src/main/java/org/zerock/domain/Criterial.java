package org.zerock.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Criterial {
	private int pageNum;	// 페이지번호
	private int amount; 	// page당 몇개 보여줄건지 : 10개로 설정

	public Criterial() {
		this(1,10);
	}

	public Criterial(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}

}
