package user;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentTest {
    Payment payment = new Payment("5555444433332222",12,22,111);
    Payment tempPayment = new Payment();
    @Test
    void testToString() {
        Assert.assertEquals(payment.toString(),"Payment{" +
                "cardNumber='" + "5555444433332222" + '\'' +
                ", monthValidity=" + 12 +
                ", yearValidity=" + 22 +
                ", CVV2=" + 111 +
                '}');
    }

    @Test
    void getCardNumber() {
        Assert.assertEquals("5555444433332222",payment.getCardNumber());
    }

    @Test
    void setCardNumber() {
        tempPayment.setCardNumber("5555444433332222");
        Assert.assertEquals("5555444433332222",tempPayment.getCardNumber());
    }

    @Test
    void getMonthValidity() {
        Assert.assertEquals(12,payment.getMonthValidity());
    }

    @Test
    void setMonthValidity() {
        tempPayment.setMonthValidity(12);
        Assert.assertEquals(12,tempPayment.getMonthValidity());
    }

    @Test
    void getYearValidity() {
        Assert.assertEquals(22,payment.getYearValidity());
    }

    @Test
    void setYearValidity() {
        tempPayment.setYearValidity(22);
        Assert.assertEquals(22,tempPayment.getYearValidity());
    }

    @Test
    void getCVV2() {
        Assert.assertEquals(111,payment.getCVV2());
    }

    @Test
    void setCVV2() {
        tempPayment.setCVV2(111);
        Assert.assertEquals(111,tempPayment.getCVV2());
    }
}