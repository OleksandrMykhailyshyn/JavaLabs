package insurance;

import risks.Risk;

import java.util.Calendar;
import java.util.Date;

public abstract class Insurance {// наслідки і пріорітетність

    protected Date startDate;
    protected Calendar calendar;
    protected String company;
    protected String[] risks;
    protected Risk[] risksR;
    protected double cost; // вартіссть
    protected int validity;  // термін дії // кількість днів
    protected int levelOfRisk; // рівень ризику
    private int n;

    public int getN() {
        return n;
    }

    public int getLevelOfRisk() {
        return levelOfRisk;
    }

    public void setLevelOfRisk(int levelOfRisk) {
        this.levelOfRisk = levelOfRisk;
    }

    public void setValidity(int validity) {
        this.validity = validity;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

    public int getValidity() {
        return validity;
    }
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String[] getRisks() {
        return risks;
    }

    public void setRisks(String[] risks) {
        this.risks = risks;
    }

    public Risk[] getRisksR() {
        return risksR;
    }

    public void setRisksR(Risk[] risksR) {
        this.risksR = risksR;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public Insurance(Date startDate, Calendar calendar, String company, String[] risks, Risk[] risksR, double cost, int validity, int levelOfRisk) {
        startDate = new Date();
        calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        calendar.add(Calendar.DAY_OF_YEAR, validity);
        this.startDate = startDate;
        this.calendar = calendar;
        this.company = company;
        this.risks = risks;
        this.risksR = risksR;
        this.cost = cost;
        this.validity = validity;
        this.levelOfRisk = levelOfRisk;
    }
}
