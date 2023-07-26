package org.zerock.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criterial;

public interface BoardMapper {
	
	// 이렇게 어노테이션 통해서 하거나 BoardMapper.xml 추가해서 하거나 둘 중 하나
//	@Select("select * from tbl_board where bno>0")
	public List<BoardVO> getList();
	
	public BoardVO read(Long bno);
	
	public int insert(BoardVO vo);
	
	// 추가할 때 시퀀스로 자동 추가되는 bno 알아보기 위해 만듦
	public int insertSelectKey(BoardVO vo);
	
	public int update(BoardVO vo);

	public int delete(Long bno);
	
    public List<BoardVO> getListTest();

    public List<BoardVO> getListWithPaging(Criterial cri);

    public int getTotalCount(Criterial criterial);
	
	public List<BoardVO> searchTest(Map<String, Map<String, String>> map);
	
}
