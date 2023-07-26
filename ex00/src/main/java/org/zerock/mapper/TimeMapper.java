package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	
	@Select("select sysdate from dual")  // dual은 가상데이터
	public String getTime();

	public String getTime2();
}
