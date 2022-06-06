package com.lab.lupang.payments.dummy;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lab.lupang.payments.domain.PayDTO;
import com.lab.lupang.payments.domain.PayVO;
import org.springframework.stereotype.Component;

@Component
public class PayTestComponent {

    // 카드 사용
    public String useCard(PayDTO payDto) {
        String jsonToString = "";

        // 1. 테스트 리턴 데이터 생성.
        PayVO vo = new PayVO();
        vo.setPg_tr_id("거래번호");
        vo.setReq_amount(payDto.getAmount());
        vo.setRet_code("0000");
        vo.setRet_msg("SUCCESS");

        try{
            // 2.Object -> Json 변환
            ObjectMapper mapper = new ObjectMapper();
            jsonToString = mapper.writeValueAsString(vo);
        }catch (JsonProcessingException jse) {
            jse.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return jsonToString;
    }

}
