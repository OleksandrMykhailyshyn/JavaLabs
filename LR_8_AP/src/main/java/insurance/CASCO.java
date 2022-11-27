package insurance;

import risks.Risk;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class CASCO extends Insurance{

    private String carBrand;
    private String carModel;
    private int yearOfManufactureOfTheCar;
    private int carPrice;
    private final int n = 1;

    public int getN() {
        return n;
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

    public int getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(int carPrice) {
        this.carPrice = carPrice;
    }

    public CASCO(Date startDate, Calendar calendar, String company, String[] risks, Risk[] risksR, double cost, int validity, int levelOfRisk, String carBrand, String carModel, int yearOfManufactureOfTheCar, int carPrice) {
        super(startDate, calendar, company, risks, risksR, cost, validity, levelOfRisk);
        this.carBrand = carBrand;
        this.carModel = carModel;
        this.yearOfManufactureOfTheCar = yearOfManufactureOfTheCar;
        this.carPrice = carPrice;
    }

    @Override
    public String toString() {
        return "CASCO{" +
                "carBrand='" + carBrand  +
                ", carModel='" + carModel  +
                ", yearOfManufactureOfTheCar=" + yearOfManufactureOfTheCar +
                ", carPrice=" + carPrice +
                ", startDate=" + startDate +
                ", calendar=" + calendar.getTime() +
                ", company='" + company  +
                ", risks=" + Arrays.toString(risks) +
                ", cost=" + cost +
                ", validity=" + validity +
                ", levelOfRisk=" + levelOfRisk +
                '}';
    }
}
