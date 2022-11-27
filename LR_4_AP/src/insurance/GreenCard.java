package insurance;

import risks.Risk;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class GreenCard extends Insurance{
    /*
    * регіон перебування
    * транспортний засіб
    * строк перебування
    * */
    private String regionOfStay;
    private String vehicle; // транспортний засіб
    private int termOfStay;
    private final int n = 2;

    public int getN() {
        return n;
    }

    public GreenCard(Date startDate, Calendar calendar, String company, String[] risks, Risk[] risksR, double cost, int validity, int levelOfRisk, String regionOfStay, String vehicle, int termOfStay) {
        super(startDate, calendar, company, risks, risksR, cost, validity, levelOfRisk);
        this.regionOfStay = regionOfStay;
        this.vehicle = vehicle;
        this.termOfStay = termOfStay;
    }

    @Override
    public String toString() {
        return "GreenCard{" +
                "regionOfStay='" + regionOfStay + '\'' +
                ", vehicle='" + vehicle + '\'' +
                ", termOfStay=" + termOfStay +
                ", startDate=" + startDate +
                ", calendar=" + calendar +
                ", company='" + company + '\'' +
                ", risks=" + Arrays.toString(risks) +
                ", risksR=" + Arrays.toString(risksR) +
                ", cost=" + cost +
                ", validity=" + validity +
                ", levelOfRisk=" + levelOfRisk +
                '}';
    }
}
