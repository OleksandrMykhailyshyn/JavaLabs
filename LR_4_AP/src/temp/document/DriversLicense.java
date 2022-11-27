package temp.document;

public class DriversLicense {
    private String series;
    private int number;
    private int dayDateOfIssue;
    private int monthDateOfIssue;
    private int yearDateOfIssue;
    private String authority;

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getDayDateOfIssue() {
        return dayDateOfIssue;
    }

    public void setDayDateOfIssue(int dayDateOfIssue) {
        this.dayDateOfIssue = dayDateOfIssue;
    }

    public int getMonthDateOfIssue() {
        return monthDateOfIssue;
    }

    public void setMonthDateOfIssue(int monthDateOfIssue) {
        this.monthDateOfIssue = monthDateOfIssue;
    }

    public int getYearDateOfIssue() {
        return yearDateOfIssue;
    }

    public void setYearDateOfIssue(int yearDateOfIssue) {
        this.yearDateOfIssue = yearDateOfIssue;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public DriversLicense(String series, int number, int dayDateOfIssue, int monthDateOfIssue, int yearDateOfIssue, String authority) {
        this.series = series;
        this.number = number;
        this.dayDateOfIssue = dayDateOfIssue;
        this.monthDateOfIssue = monthDateOfIssue;
        this.yearDateOfIssue = yearDateOfIssue;
        this.authority = authority;
    }

    @Override
    public String toString() {
        return "DriversLicense{" +
                "series='" + series + '\'' +
                ", number=" + number +
                ", dayDateOfIssue=" + dayDateOfIssue +
                ", monthDateOfIssue=" + monthDateOfIssue +
                ", yearDateOfIssue=" + yearDateOfIssue +
                ", authority='" + authority + '\'' +
                '}';
    }
}
