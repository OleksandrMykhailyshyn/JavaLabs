package insurance;

import risks.Risk;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class MotorLiability extends Insurance{

    private String carNumber;
    private String carBrand;
    private String carModel;
    private int yearOfManufactureOfTheCar;
    private String bodyNumber;
    private final int n = 3;

    public int getN() {
        return n;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public int getYearOfManufactureOfTheCar() {
        return yearOfManufactureOfTheCar;
    }

    public void setYearOfManufactureOfTheCar(int yearOfManufactureOfTheCar) {
        this.yearOfManufactureOfTheCar = yearOfManufactureOfTheCar;
    }

    public String getBodyNumber() {
        return bodyNumber;
    }

    public void setBodyNumber(String bodyNumber) {
        this.bodyNumber = bodyNumber;
    }

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
                ", calendar=" + calendar.getTime() +
                ", company='" + company + '\'' +
                ", risks=" + Arrays.toString(risks) +
                ", cost=" + cost +
                ", validity=" + validity +
                ", levelOfRisk=" + levelOfRisk +
                '}';
    }
}
