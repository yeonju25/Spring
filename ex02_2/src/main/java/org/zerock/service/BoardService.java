package org.zerock.service;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criterial;

import java.util.List;

public interface BoardService {

    public void register(BoardVO vo);

    public BoardVO get(Long bno);

    public boolean modify(BoardVO vo);

    public boolean remove(Long bno);

    public List<BoardVO> getList(Criterial cri);

    public int getTotal(Criterial criterial);
}
