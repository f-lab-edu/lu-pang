package com.lab.lupang.payment;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PgControllerTest {

    @Test
    public void reqPayPop() {
        PgController pg = new PgController();
        assertNotNull(pg);
    }


}