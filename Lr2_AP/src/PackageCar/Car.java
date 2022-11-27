package PackageCar;

public class Car
{
    private String id;
    private String model;
    private int year;
    private int price;
    private String register_number;
    public Car(){}
    public Car(String id, String model, int year, int price, String register_number)
    {
        this.id = id;
        this.model = model;
        this.year = year;
        this.price = price;
        this.register_number = register_number;
    }

    @Override
    public String toString() {
        return "----------------\nid: " + id + "\nmodel: " + model + "\nyear = " + year + "\nprice = " + price + "$\nregister_number: " + register_number;
    }

    public String getId()
    {
        return id;
    }
    public String getModel()
    {
        return model;
    }
    public int getYear()
    {
        return year;
    }
    public int getPrice()
    {
        return price;
    }
    public String getReg_Numb()
    {
        return register_number;
    }

    public void setId(String id)
    {
        this.id = id;
    }
    public void setModel(String model)
    {
        this.model = model;
    }
    public void setYear(int year)
    {
        this.year = year;
    }
    public void setPrice(int price)
    {
        this.price = price;
    }
    public void setReg_Numb(String register_number)
    {
        this.register_number = register_number;
    }

}
