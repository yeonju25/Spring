package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criterial;
import org.zerock.mapper.BoardMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

	// 자동 주입, @RequiredArgsConstructor 쓰고 final 붙여서 쓰면 자동 주입됨, @Autowired 안써도 된다
	private final BoardMapper mapper;
	
	@Override
	public void register(BoardVO vo) {
		log.info("register : {}", vo);
		mapper.insertSelectKey(vo);
	}

	// 1건 추출
	@Override
	public BoardVO get(Long bno) {
		log.info("get : {}",bno);
		return mapper.read(bno);
	}

	// 수정
	@Override
	public boolean modify(BoardVO vo) {
		log.info("modify : {}", vo);
		return mapper.update(vo)==1 ? true : false;
		// 넘어온 게 1이면 참, 아니면 거짓
	}

	// 삭제
	@Override
	public boolean remove(Long bno) {
		log.info("remove : {}", bno);
		return mapper.delete(bno)==1 ? true : false;
	}

//	// 전체 가져오기
//	@Override
//	public List<BoardVO> getList() {
//		log.info("getList");
//		return mapper.getList();
//	}
	
    @Override
    public List<BoardVO> getList(Criterial cri){
        log.info("getList");
        return mapper.getListWithPaging(cri);
    }

    @Override
    public int getTotal(Criterial cri) {
        return mapper.getTotalCount(cri);
    }

}
