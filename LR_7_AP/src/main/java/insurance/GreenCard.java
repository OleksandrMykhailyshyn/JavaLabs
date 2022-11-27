package insurance;

import risks.Risk;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class GreenCard extends Insurance{

    private String regionOfStay;
    private String vehicle; // транспортний засіб
    private int termOfStay;
    private final int n = 2;

    public int getN() {
        return n;
    }

    public String getRegionOfStay() {
        return regionOfStay;
    }

    public void setRegionOfStay(String regionOfStay) {
        this.regionOfStay = regionOfStay;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public int getTermOfStay() {
        return termOfStay;
    }

    public void setTermOfStay(int termOfStay) {
        this.termOfStay = termOfStay;
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
                ", calendar=" + calendar.getTime() +
                ", company='" + company + '\'' +
                ", risks=" + Arrays.toString(risks) +
                ", cost=" + cost +
                ", validity=" + validity +
                ", levelOfRisk=" + levelOfRisk +
                '}';
    }
}
