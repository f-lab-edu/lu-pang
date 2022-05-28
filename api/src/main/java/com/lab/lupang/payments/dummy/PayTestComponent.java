package com.lab.lupang.payments.dummy;

import com.google.gson.JsonObject;
import org.springframework.stereotype.Component;
import java.util.HashMap;

@Component
public class PayTestComponent {

    // 카드 사용
    public String useCard(HashMap<String, String> params) {
        JsonObject obj = new JsonObject();
        obj.addProperty("pg_tr_id",    "pg_tr_id");     // 1. 거래번호
        obj.addProperty("req_amount",  params.get("amount")); // 2. 결제금액
        obj.addProperty("ret_code",    "0000");         // 3. 응답코드
        obj.addProperty("ret_msg",     "SUCCESS");      // 4. 응답메시지
        return obj.toString();
    }

}
