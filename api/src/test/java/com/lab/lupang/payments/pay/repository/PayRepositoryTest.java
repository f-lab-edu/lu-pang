package com.lab.lupang.payments.pay.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lab.lupang.payments.domain.PayDTO;
import com.lab.lupang.payments.domain.PayVO;
import com.lab.lupang.payments.dummy.PayTestComponent;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PayRepositoryTest {

    PayRepository payRepository = new PayRepository(new PayTestComponent());

    @Test
    public void usePay() {
        // 1. 파라미터설정.
        PayDTO dto = new PayDTO();
        dto.setAmount(5000);
        dto.setOrderId("id000001");
        dto.setOrderName("탁상시계");
        dto.setSuccessUrl("http://127.0.0.1:8080/success_url");
        dto.setFailUrl("http://127.0.0.1:8080/fail_url");

        // 2. 결제요청
        String resJsonData = payRepository.usePay(dto);

        // 3. 요청결과 맵핑
        PayVO payVo = new PayVO();
        try{
            // 3-1. Object -> Json 변환
            ObjectMapper mapper = new ObjectMapper();
            payVo = mapper.readValue(resJsonData, PayVO.class);
        }catch (JsonProcessingException jse) {
            jse.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
        assertThat(payVo.getRet_code()).isEqualTo("0000");

    }
}
