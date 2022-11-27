package insurance;

import risks.Risk;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class MotorLiability extends Insurance{
// лише дтп
    private String carNumber;
    private String carBrand;
    private String carModel;
    private int yearOfManufactureOfTheCar;
    private String bodyNumber;
    private final int n = 3;

    public int getN() {
        return n;
    }

    // номер машини
    // виробник
    // модель
    // рік випуску
    // номер кузова

    /* страхувальник */
    /* паспорт */

    public MotorLiability(Date startDate, Calendar calendar, String company, String[] risks, Risk[] risksR, double cost, int validity, int levelOfRisk, String carNumber, String carBrand, String carModel, int yearOfManufactureOfTheCar, String bodyNumber) {
        super(startDate, calendar, company, risks, risksR, cost, validity, levelOfRisk);
        this.carNumber = carNumber;
        this.carBrand = carBrand;
        this.carModel = carModel;
        this.yearOfManufactureOfTheCar = yearOfManufactureOfTheCar;
        this.bodyNumber = bodyNumber;
    }

    @Override
    public String toString() {
        return "MotorLiability{" +
                "carNumber='" + carNumber + '\'' +
                ", carBrand='" + carBrand + '\'' +
                ", carModel='" + carModel + '\'' +
                ", yearOfManufactureOfTheCar=" + yearOfManufactureOfTheCar +
                ", bodyNumber='" + bodyNumber + '\'' +
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
