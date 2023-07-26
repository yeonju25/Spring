package org.zerock.domain;

import java.util.Date;

import lombok.Data;

/*
create table tbl_board(
	    bno number(10,0),
	    title VARCHAR2(200) not null,
	    content VARCHAR2(2000) not null,
	    writer VARCHAR2(50) not null,
	    regdate date DEFAULT sysdate,
	    updatedate date DEFAULT sysdate
	);
*/

@Data
public class BoardVO {
	// long bno랑 다름, long은 기본 자료형, Long은 객체
	// (객체엔 null값 들어갈 수 있기 때문에 에러방지차원에서.. 기본 자료형은 null 들어가면 에러!)
	private Long bno;	
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private Date updateDate;
	
}
