package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.Criterial;
import org.zerock.domain.ReplyPageDTO;
import org.zerock.domain.ReplyVO;
import org.zerock.mapper.BoardMapper;
import org.zerock.mapper.ReplyMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService{

	private final ReplyMapper replyMapper;
	private final BoardMapper boardMapper;
	
	@Transactional
	@Override
	public int register(ReplyVO vo) {
		boardMapper.updateReplyCnt(vo.getBno(), 1);
		return replyMapper.insert(vo);
	}

	@Override
	public ReplyVO get(Long rno) {
		return replyMapper.read(rno);
	}

	@Override
	public int modify(ReplyVO vo) {
		return replyMapper.update(vo);
	}

	
	@Transactional
	@Override
	public int remove(Long rno) {
	
		ReplyVO vo = replyMapper.read(rno);
		boardMapper.updateReplyCnt(vo.getBno(), -1);
		// 이렇게 읽어오는 방식은 추천하지 않지만 bno 값을 알아야하니까 어쩔 수 없이 read해오는 것.
		// 받는게 rno 밖에 없으니까 rno를 받아와서 read로 읽어서 bno가 뭔지 알아냄 >> 해당 bno의 replyCnt의 양 -1함
		
		return replyMapper.delete(rno);
	}

	@Override
	public List<ReplyVO> getList(Criterial cri, Long bno) {
		return replyMapper.getListWithPaging(cri, bno);
	}

	@Override
	public ReplyPageDTO getListPage(Criterial cri, Long bno) {
	    return new ReplyPageDTO(
	           replyMapper.getCountByBno(bno),
	           replyMapper.getListWithPaging(cri, bno));
	}

}
