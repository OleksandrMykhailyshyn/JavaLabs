package temp.document;

public class ID {
    private String series;
    private int number;
    private int dayDateOfIssue;
    private int monthDateOfIssue;
    private int yearDateOfIssue;
    private int authority;

    public ID(String series, int number, int dayDateOfIssue, int monthDateOfIssue, int yearDateOfIssue, int authority) {
        this.series = series;
        this.number = number;
        this.dayDateOfIssue = dayDateOfIssue;
        this.monthDateOfIssue = monthDateOfIssue;
        this.yearDateOfIssue = yearDateOfIssue;
        this.authority = authority;
    }

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

    public int getAuthority() {
        return authority;
    }

    public void setAuthority(int authority) {
        this.authority = authority;
    }

    @Override
    public String toString() {
        return "ID{" +
                "series='" + series + '\'' +
                ", number=" + number +
                ", dayDateOfIssue=" + dayDateOfIssue +
                ", monthDateOfIssue=" + monthDateOfIssue +
                ", yearDateOfIssue=" + yearDateOfIssue +
                ", authority=" + authority +
                '}';
    }
}
