package org.zerock.mapper;

import org.apache.ibatis.annotations.Insert;

public interface Sample2Mapper {
	
	@Insert("insert into tbl_sample2(col1) values(#{data})")
	public int insertCol2(String data);
}
