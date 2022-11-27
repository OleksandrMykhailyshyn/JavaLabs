package commands;

import insurance.CASCO;
import insurance.GreenCard;
import insurance.Insurance;
import insurance.MotorLiability;
import risks.*;
import user.DataOfTheInsured;
import user.LogInData;
import user.Payment;
import user.User;
import virtualConsole.VirtualConsole;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Menu {
    private VirtualConsole virtualConsole = new VirtualConsole();

    public VirtualConsole getVirtualConsole() {
        return virtualConsole;
    }

    public void setVirtualConsole(VirtualConsole virtualConsole) {
        this.virtualConsole = virtualConsole;
    }

    private Scanner scanner = new Scanner(System.in);
    private ArrayList<User> userList;
    private User user =  new User(
                new LogIn(this),
                new Register(this),
                new LogOut(this),
                new Help(this),
                new UpdateInsurance(this),
                new SelectInsurance(this),
                new DeleteInsurance(this),
                new ViewInsurance(this),
                new SearchInsurance(this)
        );

    public Menu(ArrayList<User> userList) {
        this.userList = userList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean logIn() throws IOException {

        boolean check = true;
        while (check)
        {
            System.out.println("Enter email: ");
            if (virtualConsole.email==null)
            {
                virtualConsole.email= scanner.nextLine();
            }
            String email = virtualConsole.email;
            //check
            System.out.println("Enter password: ");
            if (virtualConsole.password==null)
            {
                virtualConsole.password= scanner.nextLine();
            }
            String password = virtualConsole.password;
            //check
            user.setLogInData(new LogInData(email,password));
            for (int i = 0; i<userList.size(); i++)
            {
                if (userList.get(i).getLogInData().getEmail() == user.getLogInData().getEmail() && userList.get(i).getLogInData().getPassword() == user.getLogInData().getPassword())
                {
                    check = false;
                    break;
                }
            }
            if (!check) {break;}
        }
       // user.setLogInData(new LogInData("",""));
        return true;

    }
    public boolean register() throws IOException {
        System.out.println("Enter name: ");
        if (virtualConsole.name==null)
        {
            virtualConsole.name= scanner.nextLine();
        }
        String name = virtualConsole.name;

        System.out.println("Enter surname: ");
        if (virtualConsole.surname==null)
        {
            virtualConsole.surname= scanner.nextLine();
        }
        String surname = virtualConsole.surname;

        System.out.println("Enter email: ");
        if (virtualConsole.email==null)
        {
            virtualConsole.email= scanner.nextLine();
        }
        String email = virtualConsole.email;

        System.out.println("Enter password: ");
        if (virtualConsole.password==null)
        {
            virtualConsole.password= scanner.nextLine();
        }
        String password = virtualConsole.password;
        while(true)
        {
            System.out.println("Enter password again: ");
            if (virtualConsole.password2==null)
            {
                virtualConsole.password2= scanner.nextLine();
            }
            String password2 = virtualConsole.password2;
            if (Objects.equals(password, password2)) { break; }
        }
        user.setLogInData(new LogInData(name,surname,email,password));
        return true;

    }
    public boolean logOut()
    {
        System.out.println("You are logged out");
        return true;
    }
    public boolean selectInsurance() throws IOException {
        boolean boolContinue = true;
        for(int q=0;boolContinue;q++)
        {
            int choice;
            do{
                System.out.println("Enter the type of insurance: ");
                System.out.println("1.CASCO\n2.MotorLiability\n3.GreenCard\n0.Exit");
                if (virtualConsole.choice1[q]==-1)
                {
                    virtualConsole.choice1[q]= scanner.nextInt();
                }
                choice =  virtualConsole.choice1[q];
            }while (choice<0 || choice>3);
            System.out.println("Enter the data");
            switch(choice)
            {
                case 1:
                    //info about insurance
                    Calendar tempCalendar = Calendar.getInstance();
                    Date tempDate = new Date();
                    //scanner.nextLine();
                    System.out.println("Enter the car brand: ");
                    if (virtualConsole.carBrand==null)
                    {
                        virtualConsole.carBrand= scanner.nextLine();
                    }
                    String carBrand = virtualConsole.carBrand;
                    //check
                    System.out.println("Enter the car model: ");
                    if (virtualConsole.carModel==null)
                    {
                        virtualConsole.carModel= scanner.nextLine();
                    }
                    String carModel = virtualConsole.carModel;
                    //check
                    System.out.println("Enter the year of manufacture of the car: ");
                    if (virtualConsole.yearOfManufactureOfTheCar==-1)
                    {
                        virtualConsole.yearOfManufactureOfTheCar= scanner.nextInt();
                    }
                    int yearOfManufactureOfTheCar =  virtualConsole.yearOfManufactureOfTheCar;
                    //check
                    System.out.println("Enter the car price: ");
                    if (virtualConsole.carPrice==-1)
                    {
                        virtualConsole.carPrice= scanner.nextInt();
                    }
                    int carPrice =  virtualConsole.carPrice;

                    //check

                    // кожен ризик має свій рівень ризику
                    System.out.println("Select the risks: " +
                            "\n1.Викрадення" + // 8
                            "\n2.Повна загибель авто (тотал)" + //6
                            "\n3.ДТП" + // 9
                            "\n4.Стихійне лихо" + // 4
                            "\n5.Падіння предметів" + // 3
                            "\n6.Напад тварин" + // 1
                            "\n7.Протиправні дії третіх осіб" + // 7
                            "\n8.Пожежа, вибух" + // 2
                            "\n9.Військові ризики"); // 5
                    int[] choiceArr = new int[]{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};

                    int tempInt1 = 1;

                    for (int j = 0; tempInt1!=0; j++)
                    {
                        do {
                            if (virtualConsole.tempInt1[j]==-1)
                            {
                                virtualConsole.tempInt1[j] = scanner.nextInt();
                            }
                            tempInt1 =  virtualConsole.tempInt1[j];
                        }while(tempInt1<0 || tempInt1>9);

                        boolean tempBool = true;
                        for (int g = 0; g<j;g++)
                        {
                            if (choiceArr[g] == tempInt1)
                            {
                                tempBool = false;
                                break;
                            }
                        }
                        if (tempBool)
                        {
                            choiceArr[j] = tempInt1;
                        }

                    }
                    int size = 0;

                    for (int j = 0; j<10;j++)
                    {
                        if (choiceArr[j]==-1)
                        {
                            break;
                        }
                        size = j;
                    }
                    choiceArr = Arrays.copyOfRange(choiceArr,0,size);
                    String[] risks = new String[size];
                    Risk[] risksR = new Risk[size];
                    int levelOfRisk=0;
                    for(int j = 0; j<size; j++)
                    {
                        switch (choiceArr[j])
                        {
                            case 1:
                                risks[j] = "Викрадення";
                                risksR[j] = new CarTheft();
                                levelOfRisk+=risksR[j].getLevelOfRisk();
                                break;
                            case 2:
                                risks[j] = "Повна загибель авто (тотал)";
                                risksR[j] = new CompleteDeathOfTheCar();
                                levelOfRisk+=risksR[j].getLevelOfRisk();
                                break;
                            case 3:
                                risks[j] = "ДТП";
                                risksR[j] = new RoadAccident();
                                levelOfRisk+=risksR[j].getLevelOfRisk();
                                break;
                            case 4:
                                risks[j] = "Стихійне лихо";
                                risksR[j] = new Disaster();
                                levelOfRisk+=risksR[j].getLevelOfRisk();
                                break;
                            case 5:
                                risks[j] = "Падіння предметів";
                                risksR[j] = new FallingObjects();
                                levelOfRisk+=risksR[j].getLevelOfRisk();
                                break;
                            case 6:
                                risks[j] = "Напад тварин";
                                risksR[j] = new AnimalAttack();
                                levelOfRisk+=risksR[j].getLevelOfRisk();
                                break;
                            case 7:
                                risks[j] = "Протиправні дії третіх осіб";
                                risksR[j] = new IllegalActionsOfThirdParties();
                                levelOfRisk+=risksR[j].getLevelOfRisk();
                                break;
                            case 8:
                                risks[j] = "Пожежа, вибух";
                                risksR[j] = new FireExplosion();
                                levelOfRisk+=risksR[j].getLevelOfRisk();
                                break;
                            case 9:
                                risks[j] = "Військові ризики";
                                risksR[j] = new MilitaryRisks();
                                levelOfRisk+=risksR[j].getLevelOfRisk();
                                break;
                        }
                    }
                    System.out.println("Enter the validity: ");
                    if (virtualConsole.validity==-1)
                    {
                        virtualConsole.validity= scanner.nextInt();
                    }
                    int validity =  virtualConsole.validity;


                    String tempString = "1." + String.valueOf(levelOfRisk);
                    double k = Double.parseDouble(tempString);

                    double cost = carPrice*k;


                    user.getList().add(new CASCO(tempDate, tempCalendar, "VUSO", risks,risksR, cost,validity, levelOfRisk, carBrand, carModel, yearOfManufactureOfTheCar, carPrice ));

                    break;
                case 2:
                    //info about insurance
                    Calendar tempCalendar1 = Calendar.getInstance();
                    Date tempDate1 = new Date();
                    //scanner.nextLine();
                    System.out.println("Enter the car number: ");
                    if (virtualConsole.carNumber1==null)
                    {
                        virtualConsole.carNumber1= scanner.nextLine();
                    }
                    String carNumber1 = virtualConsole.carNumber1;
                    //check
                    System.out.println("Enter the car brand: ");
                    if (virtualConsole.carBrand1==null)
                    {
                        virtualConsole.carBrand1= scanner.nextLine();
                    }
                    String carBrand1 = virtualConsole.carBrand1;
                    //check
                    System.out.println("Enter the car model: ");
                    if (virtualConsole.carModel1==null)
                    {
                        virtualConsole.carModel1= scanner.nextLine();
                    }
                    String carModel1 = virtualConsole.carModel1;
                    //check
                    System.out.println("Enter the year of manufacture of the car: ");
                    if (virtualConsole.yearOfManufactureOfTheCar1==-1)
                    {
                        virtualConsole.yearOfManufactureOfTheCar1= scanner.nextInt();
                    }
                    int yearOfManufactureOfTheCar1 =  virtualConsole.yearOfManufactureOfTheCar1;
                    //check
                    System.out.println("Enter the body number: ");
                    //scanner.nextLine();
                    if (virtualConsole.bodyNumber==null)
                    {
                        virtualConsole.bodyNumber= scanner.nextLine();
                    }
                    String bodyNumber = virtualConsole.bodyNumber;
                    //check

                    String[] risks1 = new String[]{"ДТП"};
                    Risk[] risksR1 = new Risk[]{new RoadAccident()};
                    int levelOfRisk1 = risksR1[0].getLevelOfRisk();
                    int validity1 = 365;

                    double cost1 = 1500*(Math.random()+1);

                    user.getList().add(new MotorLiability(tempDate1,tempCalendar1,"VUSO",risks1,risksR1, cost1, validity1, levelOfRisk1, carNumber1, carBrand1, carModel1,yearOfManufactureOfTheCar1,bodyNumber));

                    break;
                case 3:
                    /*private String regionOfStay;
                    private String vehicle; // транспортний засіб
                    private int termOfStay;*/

                    Calendar tempCalendar2 = Calendar.getInstance();
                    Date tempDate2 = new Date();
                    //scanner.nextLine();

                    String[] risks2 = new String[]{"ДТП"};
                    Risk[] risksR2 = new Risk[]{new RoadAccident()};
                    int levelOfRisk2 = risksR2[0].getLevelOfRisk();
                    int validity2 = 365;

                    double cost2 = 1500*(Math.random()+1);

                    System.out.println("Enter the region of stay: ");
                    if (virtualConsole.regionOfStay==null)
                    {
                        virtualConsole.regionOfStay= scanner.nextLine();
                    }
                    String regionOfStay = virtualConsole.regionOfStay;

                    //check
                    System.out.println("Enter the vehicle: ");
                    if (virtualConsole.vehicle==null)
                    {
                        virtualConsole.vehicle= scanner.nextLine();
                    }
                    String vehicle = virtualConsole.vehicle;
                    //check
                    System.out.println("Enter the term of stay: ");
                    if (virtualConsole.termOfStay==-1)
                    {
                        virtualConsole.termOfStay= scanner.nextInt();
                    }
                    int termOfStay =  virtualConsole.termOfStay;
                    //check

                    user.getList().add(new GreenCard(tempDate2,tempCalendar2,"VUSO",risks2,risksR2,cost2,validity2,levelOfRisk2, regionOfStay,vehicle,termOfStay));


                    break;
                case 0:
                    boolContinue = false;
                    break;
            }
        }
        /*private Payment payment;
        private DataOfTheInsured data;*/

        System.out.println("Enter your data:");
        System.out.println("Enter thr name:");
        //scanner.nextLine();
        if (virtualConsole.name==null)
        {
            virtualConsole.name= scanner.nextLine();
        }
        String name = virtualConsole.name;

        System.out.println("Enter thr surname:");
        if (virtualConsole.surname==null)
        {
            virtualConsole.surname= scanner.nextLine();
        }
        String surname = virtualConsole.surname;

        System.out.println("Enter thr middle name:");
        if (virtualConsole.middleName==null)
        {
            virtualConsole.middleName= scanner.nextLine();
        }
        String middleName = virtualConsole.middleName;

        System.out.println("Enter thr TIN:");
        if (virtualConsole.TIN==null)
        {
            virtualConsole.TIN= scanner.nextLine();
        }
        String TIN = virtualConsole.TIN;

        System.out.println("Enter thr email:");
        if (virtualConsole.email==null)
        {
            virtualConsole.email= scanner.nextLine();
        }
        String email = virtualConsole.email;

        System.out.println("Enter thr phoneNumber:");
        if (virtualConsole.phoneNumber==null)
        {
            virtualConsole.phoneNumber= scanner.nextLine();
        }
        String phoneNumber = virtualConsole.phoneNumber;

        System.out.println("Enter thr city:");
        if (virtualConsole.city==null)
        {
            virtualConsole.city= scanner.nextLine();
        }
        String city = virtualConsole.city;

        System.out.println("Enter thr street:");
        if (virtualConsole.street==null)
        {
            virtualConsole.street= scanner.nextLine();
        }
        String street = virtualConsole.street;

        System.out.println("Enter thr house:");
        if (virtualConsole.house==-1)
        {
            virtualConsole.house= scanner.nextInt();
        }
        int house =  virtualConsole.house;

        System.out.println("Enter thr apartment:");
        if (virtualConsole.apartment==-1)
        {
            virtualConsole.apartment= scanner.nextInt();
        }
        int apartment =  virtualConsole.apartment;


        System.out.println("Enter thr cardNumber:");
        //scanner.nextLine();
        if (virtualConsole.cardNumber==null)
        {
            virtualConsole.cardNumber= scanner.nextLine();
        }
        String cardNumber = virtualConsole.cardNumber;

        System.out.println("Enter thr monthValidity:");
        if (virtualConsole.monthValidity==-1)
        {
            virtualConsole.monthValidity= scanner.nextInt();
        }
        int monthValidity =  virtualConsole.monthValidity;

        System.out.println("Enter thr yearValidity:");
        if (virtualConsole.yearValidity==-1)
        {
            virtualConsole.yearValidity= scanner.nextInt();
        }
        int yearValidity =  virtualConsole.yearValidity;

        System.out.println("Enter thr CVV2:");
        if (virtualConsole.CVV2==-1)
        {
            virtualConsole.CVV2= scanner.nextInt();
        }
        int CVV2 =  virtualConsole.CVV2;


        user.setData(new DataOfTheInsured(name,surname,middleName,TIN,email,phoneNumber,city,street,house,apartment));
        user.setPayment(new Payment(cardNumber,monthValidity,yearValidity,CVV2));
        return true;

    }
    public boolean updateInsurance() throws IOException {

        boolean boolFinish = true;
        System.out.println(user);
        do {

            int choice;
            do {
                System.out.println("Select the insurance that you want to update");
                if (virtualConsole.choice==-1)
                {
                    virtualConsole.choice= scanner.nextInt();
                }
                choice =  virtualConsole.choice;
            }while(choice<-1 || choice>user.getList().size());

            int choiceAction;

            do {
                System.out.println("Select the action that you want to update:\n" +
                        "1.Company\n" +
                        "2.Risks\n" +
                        "3.Validity\n");
                if (virtualConsole.choiceAction==-1)
                {
                    virtualConsole.choiceAction= scanner.nextInt();
                }
                choiceAction =  virtualConsole.choiceAction;

            }while(choiceAction<0 || choiceAction>3);

            switch (choiceAction)
            {
                case 1:
                {
                    System.out.println("Enter the new company:");
                    //scanner.nextLine();
                    if (virtualConsole.company==null)
                    {
                        virtualConsole.company= scanner.nextLine();
                    }
                    String company = virtualConsole.company;
                    user.getList().get(choice).setCompany(company);
                    break;
                }
                case 2:
                {
                    /*System.out.println("Enter new risks:");*/
                    System.out.println("Enter the number risk that you want to update:");
                    if (virtualConsole.number==-1)
                    {
                        virtualConsole.number= scanner.nextInt();
                    }
                    int number =  virtualConsole.number;
                    System.out.println("Enter the new risk: ");
                    if (virtualConsole.newRisk==null)
                    {
                        virtualConsole.newRisk= scanner.nextLine();
                    }
                    String newRisk = virtualConsole.newRisk;
                    user.getList().get(choice).getRisks()[number] = newRisk;
                    //update level of risk
                    //update cost
                    break;
                }
                case 3:
                {
                    System.out.println("Enter the new validity: ");
                    if (virtualConsole.validity==-1)
                    {
                        virtualConsole.validity= scanner.nextInt();
                    }
                    int validity =  virtualConsole.validity;
                    //check
                    user.getList().get(choice).setValidity(validity);
                /*calendar.setTime(startDate);
        calendar.add(Calendar.DAY_OF_YEAR, validity);*/
                    user.getList().get(choice).getCalendar().setTime(user.getList().get(choice).getStartDate());
                    user.getList().get(choice).getCalendar().add(Calendar.DAY_OF_YEAR, validity);
                    break;
                }
            }
            System.out.println("Do you want to continue update:\n" +
                    "1.Yes\n" +
                    "2.No\n");
            if (virtualConsole.cont==-1)
            {
                virtualConsole.cont= scanner.nextInt();
            }
            int cont =  virtualConsole.cont;
            boolFinish = cont != 1;
        }while (!boolFinish);
        return true;

    }
    public boolean viewInsurance() throws IOException {

        int choice=0;

        do {
            System.out.println("Select an option to sort by:\n1.Level of risk\n2.Date\n3.Cost\n4.Validity");
            if (virtualConsole.choice==-1)
            {
                virtualConsole.choice= scanner.nextInt();
            }
            choice =  virtualConsole.choice;
        }while(choice<0 || choice>4);

        switch (choice)
        {
            case 1:
            {
                Collections.sort(user.getList(), new Comparator<Insurance>() {
                    @Override
                    public int compare(Insurance o1, Insurance o2) {
                        return o1.getLevelOfRisk() - o2.getLevelOfRisk();
                    }
                });
                System.out.println(user);
                break;
            }
            case 2:
            {
                Collections.sort(user.getList(), new Comparator<Insurance>() {
                    @Override
                    public int compare(Insurance o1, Insurance o2) {
                        return o1.getStartDate().compareTo(o2.getStartDate());
                    }
                });
                System.out.println(user);
                break;
            }
            case 3:
            {
                Collections.sort(user.getList(), new Comparator<Insurance>() {
                    @Override
                    public int compare(Insurance o1, Insurance o2) {
                        return (int)(o1.getCost() - o2.getCost());
                    }
                });
                System.out.println(user);
                break;
            }
            case 4:
            {
                Collections.sort(user.getList(), new Comparator<Insurance>() {
                    @Override
                    public int compare(Insurance o1, Insurance o2) {
                        return o1.getValidity() - o2.getValidity();
                    }
                });
                System.out.println(user);
                break;
            }
        }
        return true;


    }
    public boolean searchInsurance() throws IOException {
        System.out.println("Select an option to search:" +
                "\n1.Level of risk" +
                "\n2.Cost" +
                "\n3.Validity");
        int[] choiceArr = new int[]{-1,-1,-1,-1};

        int tempInt = 1;
        //check
        for (int j = 0; tempInt!=0; j++)
        {
            do {
                if (virtualConsole.tempInt[j]==-1)
                {
                    virtualConsole.tempInt[j]= scanner.nextInt();
                }
                tempInt =  virtualConsole.tempInt[j];
            }while(tempInt<0 || tempInt>3);

            boolean tempBool = true;
            for (int g = 0; g<j;g++)
            {
                if (choiceArr[g] == tempInt)
                {
                    tempBool = false;
                    break;
                }
            }
            if (tempBool)
            {
                choiceArr[j] = tempInt;
            }

        }
        int size = 0;

        for (int j = 0; j<4;j++)
        {
            if (choiceArr[j]==-1)
            {
                break;
            }
            size = j;
        }
        choiceArr = Arrays.copyOfRange(choiceArr,0,size);

        int lowerLevelOfRisk = 0;
        int upperLevelOfRisk = 10000;

        double lowerCost = 0;
        double upperCost = 10000;

        int lowerValidity = 0;
        int upperValidity = 10000;





        for (int i = 0; i<size; i++)
        {
            switch (choiceArr[i])
            {
                case 1:
                {
                    System.out.println("Enter the range of level of risk");
                    System.out.println("Lower:");
                    if (virtualConsole.lowerLevelOfRisk==-1)
                    {
                        virtualConsole.lowerLevelOfRisk= scanner.nextInt();
                    }
                    lowerLevelOfRisk =  virtualConsole.lowerLevelOfRisk;

                    System.out.println("Upper:");
                    if (virtualConsole.upperLevelOfRisk==-1)
                    {
                        virtualConsole.upperLevelOfRisk= scanner.nextInt();
                    }
                    upperLevelOfRisk =  virtualConsole.upperLevelOfRisk;
                    //check
                    break;
                }
                case 2:
                {
                    System.out.println("Enter the range of cost");
                    System.out.println("Lower:");
                    if (virtualConsole.lowerCost==-1)
                    {
                        virtualConsole.lowerCost= scanner.nextDouble();
                    }
                    lowerCost =  virtualConsole.lowerCost;

                    System.out.println("Upper:");

                    if (virtualConsole.upperCost==-1)
                    {
                        virtualConsole.upperCost= scanner.nextDouble();
                    }
                    upperCost =  virtualConsole.upperCost;
                    //check
                    break;

                }
                case 3:
                {
                    System.out.println("Enter the range of validity");
                    System.out.println("Lower:");
                    if (virtualConsole.lowerValidity==-1)
                    {
                        virtualConsole.lowerValidity= scanner.nextInt();
                    }
                    lowerValidity =  virtualConsole.lowerValidity;
                    System.out.println("Upper:");
                    if (virtualConsole.upperValidity==-1)
                    {
                        virtualConsole.upperValidity= scanner.nextInt();
                    }
                    upperValidity =  virtualConsole.upperValidity;
                    //check
                    break;
                }
            }
        }
        System.out.println("Found insurance:");
        boolean isFounded = false;
        for (int i = 0; i<user.getList().size(); i++)
        {
            if (user.getList().get(i).getLevelOfRisk()>lowerLevelOfRisk &&
                    user.getList().get(i).getLevelOfRisk()<upperLevelOfRisk &&

                    user.getList().get(i).getCost()>lowerCost &&
                    user.getList().get(i).getCost()<upperCost &&

                    user.getList().get(i).getValidity()>lowerValidity &&
                    user.getList().get(i).getValidity()<upperValidity)
            {
                System.out.println(user.getList().get(i));
                isFounded = true;
            }
        }
        if (!isFounded)
        {
            System.out.println("No insurance found");
        }


        return true;
    }

    public boolean help()
    {
        System.out.println("Provides classes that are fundamental to the design of the Java programming language. The most important classes are Object, which is the root of the class hierarchy, and Class, instances of which represent classes at run time.\n" +
                "Frequently it is necessary to represent a value of primitive type as if it were an object. The wrapper classes Boolean, Character, Integer, Long, Float, and Double serve this purpose. An object of type Double, for example, contains a field whose type is double, representing that value in such a way that a reference to it can be stored in a variable of reference type. These classes also provide a number of methods for converting among primitive values, as well as supporting such standard methods as equals and hashCode. The Void class is a non-instantiable class that holds a reference to a Class object representing the type void.\n" +
                "The class Math provides commonly used mathematical functions such as sine, cosine, and square root. The classes String, StringBuffer, and StringBuilder similarly provide commonly used operations on character strings.");
        return true;
    }
    public boolean deleteInsurance() throws IOException {
        System.out.println(user);
        int choice;
        do {
            System.out.println("Select the insurance that you want to delete");
            if (virtualConsole.choice==-1)
            {
                virtualConsole.choice= scanner.nextInt();
            }
            choice =  virtualConsole.choice;
        }while(choice<-1 || choice>user.getList().size());

        user.getList().remove(choice);
        System.out.println("The insurance deleted");
        System.out.println(user);
        return true;
    }


}
