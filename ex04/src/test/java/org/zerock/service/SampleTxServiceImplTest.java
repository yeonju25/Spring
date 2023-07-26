package org.zerock.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Slf4j
public class SampleTxServiceImplTest {
	
	@Autowired
	private SampleTxService service;

	@Test
	public void test() {
		String data = "(서울=연합뉴스) 전성훈 김다혜 기자 = 쿠팡은 헬스앤뷰티(H&B) 국내 1위 업체인 CJ올리브영을 대규모유통업법 위반 혐의로 공정거래위원회(공정위)에 신고했다고 24일 밝혔다."
				+"\r\n"
				+"쿠팡 측은 신고서에서 올리브영이 2019년부터 현재까지 쿠팡의 뷰티 시장 진출을 막고자 뷰티업체에 납품하지 말라고 압력을 넣는 등 지속해 거래를 방해했다고 주장했다.";
		
		log.info("length : {} ", data.getBytes().length);
		
		service.addData(data);
	}

}
