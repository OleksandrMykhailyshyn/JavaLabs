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

import java.util.*;

public class Menu {
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

    public void logIn()
    {
        boolean check = true;
        while (check)
        {
            System.out.println("Enter email: ");
            String email = scanner.nextLine();
            //check
            System.out.println("Enter password: ");
            String password = scanner.nextLine();
            //check
            user.setLogInData(new LogInData(email,password));
            for (int i = 0; i<userList.size(); i++)
            {
                if (Objects.equals(userList.get(i).getLogInData().getEmail(), user.getLogInData().getEmail()) && Objects.equals(userList.get(i).getLogInData().getPassword(), user.getLogInData().getPassword()))
                {
                    check = false;
                    break;
                }
            }
            System.out.println("Do you want to continue(0): ");
            int con = scanner.nextInt();
            if (con == 0)
            {
                break;
            }
        }

    }
    public void register()
    {
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        System.out.println("Enter surname: ");
        String surname = scanner.nextLine();
        System.out.println("Enter email: ");
        String email = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();
        while(true)
        {
            System.out.println("Enter password again: ");
            String password2 = scanner.nextLine();
            if (Objects.equals(password, password2)) { break; }
        }
        user.setLogInData(new LogInData(name,surname,email,password));

        // passport
        // DataOfTheInsured
        // Payment



    }
    public void logOut()
    {
        System.out.println("You are logged out");
    }
    public void selectInsurance(){
        boolean boolContinue = true;
        while(boolContinue)
        {
            System.out.println("Enter the type of insurance: ");
            System.out.println("1.CASCO\n2.MotorLiability\n3.GreenCard\n0.Exit");
            int choice = scanner.nextInt();
            //check choice
            System.out.println("Enter the data");
            switch(choice)
            {
                case 1:
                    //info about insurance
                    Calendar tempCalendar = Calendar.getInstance();
                    Date tempDate = new Date();
                    scanner.nextLine();
                    System.out.println("Enter the car brand: ");
                    String carBrand = scanner.nextLine();
                    //check
                    System.out.println("Enter the car model: ");
                    String carModel = scanner.nextLine();
                    //check
                    System.out.println("Enter the year of manufacture of the car: ");
                    int yearOfManufactureOfTheCar = scanner.nextInt();
                    //check
                    System.out.println("Enter the car price: ");
                    int carPrice = scanner.nextInt();
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

                    int tempInt = 1;
                    //check
                    for (int j = 0; tempInt!=0; j++)
                    {
                        tempInt = scanner.nextInt();
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
                                risksR[j] = new FallingObjects();
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
                    int validity = scanner.nextInt();


                    String tempString = "1." + String.valueOf(levelOfRisk);
                    double k = Double.parseDouble(tempString);

                    double cost = carPrice*k;


                    user.getList().add(new CASCO(tempDate, tempCalendar, "VUSO", risks,risksR, cost,validity, levelOfRisk, carBrand, carModel, yearOfManufactureOfTheCar, carPrice ));

                    break;
                case 2:
                    //info about insurance
                    Calendar tempCalendar1 = Calendar.getInstance();
                    Date tempDate1 = new Date();
                    scanner.nextLine();
                    System.out.println("Enter the car number: ");
                    String carNumber1 = scanner.nextLine();
                    //check
                    System.out.println("Enter the car brand: ");
                    String carBrand1 = scanner.nextLine();
                    //check
                    System.out.println("Enter the car model: ");
                    String carModel1 = scanner.nextLine();
                    //check
                    System.out.println("Enter the year of manufacture of the car: ");
                    int yearOfManufactureOfTheCar1 = scanner.nextInt();
                    //check
                    System.out.println("Enter the body number: ");
                    scanner.nextLine();
                    String bodyNumber = scanner.nextLine();
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
                    scanner.nextLine();

                    String[] risks2 = new String[]{"ДТП"};
                    Risk[] risksR2 = new Risk[]{new RoadAccident()};
                    int levelOfRisk2 = risksR2[0].getLevelOfRisk();
                    int validity2 = 365;

                    double cost2 = 1500*(Math.random()+1);

                    System.out.println("Enter the region of stay: ");
                    String regionOfStay = scanner.nextLine();
                    //check
                    System.out.println("Enter the vehicle: ");
                    String vehicle = scanner.nextLine();
                    //check
                    System.out.println("Enter the term of stay: ");
                    int termOfStay = scanner.nextInt();
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
        scanner.nextLine();
        String name = scanner.nextLine();

        System.out.println("Enter thr surname:");
        String surname = scanner.nextLine();

        System.out.println("Enter thr middle name:");
        String middleName = scanner.nextLine();

        System.out.println("Enter thr TIN:");
        String TIN = scanner.nextLine();

        System.out.println("Enter thr email:");
        String email = scanner.nextLine();

        System.out.println("Enter thr phoneNumber:");
        String phoneNumber = scanner.nextLine();

        System.out.println("Enter thr city:");
        String city = scanner.nextLine();

        System.out.println("Enter thr street:");
        String street = scanner.nextLine();

        System.out.println("Enter thr house:");
        int house = scanner.nextInt();

        System.out.println("Enter thr apartment:");
        int apartment = scanner.nextInt();


        System.out.println("Enter thr cardNumber:");
        scanner.nextLine();
        String cardNumber = scanner.nextLine();

        System.out.println("Enter thr monthValidity:");
        int monthValidity = scanner.nextInt();

        System.out.println("Enter thr yearValidity:");
        int yearValidity = scanner.nextInt();

        System.out.println("Enter thr CVV2:");
        int CVV2 = scanner.nextInt();


        user.setData(new DataOfTheInsured(name,surname,middleName,TIN,email,phoneNumber,city,street,house,apartment));
        user.setPayment(new Payment(cardNumber,monthValidity,yearValidity,CVV2));

    }
    public void updateInsurance()
    {

        boolean boolFinish = true;
        System.out.println(user);
        do {
            System.out.println("Select the insurance that you want to update");
            int choice = scanner.nextInt();
            //check
            System.out.println("Select the action that you want to update:\n" +
                    "1.Company\n" +
                    "2.Risks\n" +
                    "3.Validity\n");
            int choiceAction = scanner.nextInt();
            switch (choiceAction)
            {
                case 1:
                {
                    System.out.println("Enter the new company:");
                    scanner.nextLine();
                    String company = scanner.nextLine();
                    user.getList().get(choice).setCompany(company);
                    break;
                }
                case 2:
                {
                    /*System.out.println("Enter new risks:");*/
                    System.out.println("Enter the number risk that you want to update:");
                    int number = scanner.nextInt();
                    System.out.println("Enter the new risk: ");
                    String newRisk = scanner.nextLine();
                    user.getList().get(choice).getRisks()[number] = newRisk;
                    //update level of risk
                    //update cost
                    break;
                }
                case 3:
                {
                    System.out.println("Enter the new validity: ");
                    int validity = scanner.nextInt();
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
            int cont = scanner.nextInt();
            boolFinish = cont == 1;
        }while (boolFinish);

    }
/*    public void updateCASCO()
    {
        System.out.println("Select the action that you want to update:" +
                "\n1.Car brand" +
                "\n2.Car model" +
                "\n3.Year of manufacture of the car" +
                "\n4.Car price");
        int choiceAction = scanner.nextInt();
        //check
        switch (choiceAction)
        {
            case 1:
            {
                System.out.println("Enter new car brand: ");
                String carBrand = scanner.nextLine();
                //check
                user.getList().get(choiceAction).set
            }
            case 2:
            {

            }
            case 3:
            {

            }
            case 4:
            {

            }
        }

    }
    public void updateGreenCard()
    {

    }
    public void updateMotorLiability()
    {

    }*/
    public void viewInsurance()
    {
        System.out.println("Select an option to sort by:\n1.Level of risk\n2.Date\n3.Cost\n4.Validity");
        int choice = scanner.nextInt();
        //check choice
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


    }
    public void searchInsurance()
    {
        System.out.println("Select an option to search:" +
                "\n1.Level of risk" +
                "\n2.Cost" +
                "\n3.Validity");
        int[] choiceArr = new int[]{-1,-1,-1,-1};

        int tempInt = 1;
        //check
        for (int j = 0; tempInt!=0; j++)
        {
            tempInt = scanner.nextInt();
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

        int lowerLevelOfRisk = -1;
        int upperLevelOfRisk = 1000;

        double lowerCost = -1;
        double upperCost = 1000000;

        int lowerValidity = -1;
        int upperValidity = 100;





        for (int i = 0; i<size; i++)
        {
            switch (choiceArr[i])
            {
                case 1:
                {
                    System.out.println("Enter the range of level of risk");
                    System.out.println("Lower:");
                    lowerLevelOfRisk = scanner.nextInt();
                    System.out.println("Upper:");
                    upperLevelOfRisk = scanner.nextInt();
                    //check
                    break;
                }
                case 2:
                {
                    System.out.println("Enter the range of cost");
                    System.out.println("Lower:");
                    lowerCost = scanner.nextDouble();
                    System.out.println("Upper:");
                    upperCost = scanner.nextDouble();
                    //check
                    break;

                }
                case 3:
                {
                    System.out.println("Enter the range of validity");
                    System.out.println("Lower:");
                    lowerValidity = scanner.nextInt();
                    System.out.println("Upper:");
                    upperValidity = scanner.nextInt();
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


    }

    public void help()
    {
        System.out.println("Provides classes that are fundamental to the design of the Java programming language. The most important classes are Object, which is the root of the class hierarchy, and Class, instances of which represent classes at run time.\n" +
                "Frequently it is necessary to represent a value of primitive type as if it were an object. The wrapper classes Boolean, Character, Integer, Long, Float, and Double serve this purpose. An object of type Double, for example, contains a field whose type is double, representing that value in such a way that a reference to it can be stored in a variable of reference type. These classes also provide a number of methods for converting among primitive values, as well as supporting such standard methods as equals and hashCode. The Void class is a non-instantiable class that holds a reference to a Class object representing the type void.\n" +
                "The class Math provides commonly used mathematical functions such as sine, cosine, and square root. The classes String, StringBuffer, and StringBuilder similarly provide commonly used operations on character strings.");
    }
    public void deleteInsurance()
    {
        System.out.println(user);
        System.out.println("Select the insurance that you want to delete");
        int choice = scanner.nextInt();
        //check
        user.getList().remove(choice);
        System.out.println("The insurance deleted");
        System.out.println(user);
    }


}
