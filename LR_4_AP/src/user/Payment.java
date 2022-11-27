package user;

public class Payment {
    /* оплата */
    // номер карти
    // термін дії
    // CVV2(3 цифри)
    private String cardNumber;
    private int monthValidity;
    private int yearValidity;
    private int CVV2;

    @Override
    public String toString() {
        return "Payment{" +
                "cardNumber='" + cardNumber + '\'' +
                ", monthValidity=" + monthValidity +
                ", yearValidity=" + yearValidity +
                ", CVV2=" + CVV2 +
                '}';
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getMonthValidity() {
        return monthValidity;
    }

    public void setMonthValidity(int monthValidity) {
        this.monthValidity = monthValidity;
    }

    public int getYearValidity() {
        return yearValidity;
    }

    public void setYearValidity(int yearValidity) {
        this.yearValidity = yearValidity;
    }

    public int getCVV2() {
        return CVV2;
    }

    public void setCVV2(int CVV2) {
        this.CVV2 = CVV2;
    }

    public Payment(String cardNumber, int monthValidity, int yearValidity, int CVV2) {
        this.cardNumber = cardNumber;
        this.monthValidity = monthValidity;
        this.yearValidity = yearValidity;
        this.CVV2 = CVV2;
    }
}
