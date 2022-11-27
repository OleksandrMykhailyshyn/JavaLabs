package area;

import droid.Droid;
import droid.GunDroid;
import droid.ShieldDroid;
import droid.SwordDroid;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class BattleArea {
    private static final Scanner myScanner = new Scanner(System.in);
    private static final String filename = "D:\\InteliJ IDEA Java\\Droid fight result\\DroidWrite.txt";
    private static final FileWriter myWriter;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    static {
        try {
            myWriter = new FileWriter(filename);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static Droid[] battle(Droid my, Droid enemy) throws IOException {
        Droid[] arr = new Droid[2];

        int numb = 0;
        while (my.getHealth() > 0.0 && enemy.getHealth() > 0.0)
        {

            numb++;
            System.out.println(ANSI_BLACK+"Fight number "+ANSI_BLACK+ numb);
            myWriter.write("Fight number "+ numb);

            System.out.println("Your turn: ");
            System.out.println("1 >> Attack ");
            System.out.println("2 >> Heal "+ "("+my.getNumberOfHealPotion()+")");
            System.out.println("3 >> Block (-"+my.getBlockPercentage()+"% damage)");
            if(my.superPowerIsReady())
            {
                System.out.println("4 >> Use super power ");
            }

            Random rand = new Random();
            int enemyChoice = rand.nextInt(4)+1;
            enemyChoice = checkEnemyChoice(enemyChoice, enemy);

            int myChoice = myScanner.nextInt();
            myChoice = checkMyChoice(myChoice, my);
            switch (myChoice)
            {
                case 1->{
                    my.hit(enemy);
                    my.setSuperPower(my.getSuperPower()+20);
                }
                case 2->{
                    my.heal();
                    my.setNumberOfHealPotion(my.getNumberOfHealPotion()-1);
                }
                case 3-> my.setBlocked(true);
                case 4->{
                    if (Objects.equals(my.getWeapon(), "sword"))
                    {
                        my.useSuperPower(enemy);

                    }
                    else if (Objects.equals(my.getWeapon(), "gun"))
                    {
                        my.useSuperPower(enemy);

                    }
                    else if (Objects.equals(my.getWeapon(), "shield"))
                    {
                        my.useSuperPower(enemy);

                    }
                    my.setSuperPower(my.getSuperPower()-100.0);
                }
            }

            switch (enemyChoice)
            {
                case 1->{
                    enemy.hit(my);
                    enemy.setSuperPower(enemy.getSuperPower()+20);
                }
                case 2->{
                    enemy.heal();
                    enemy.setNumberOfHealPotion(enemy.getNumberOfHealPotion()-1);
                }
                case 3-> enemy.setBlocked(true);
                case 4->{
                    if (Objects.equals(enemy.getWeapon(), "sword"))
                    {
                        enemy.useSuperPower(my);

                    }
                    else if (Objects.equals(enemy.getWeapon(), "gun"))
                    {
                        enemy.useSuperPower(my);

                    }
                    else if (Objects.equals(enemy.getWeapon(), "shield"))
                    {
                        enemy.useSuperPower(my);

                    }
                }
            }
            my.setBlocked(false);
            enemy.setBlocked(false);

            print(my, enemy);
            write(my, enemy);

        }
        arr[0] = my;
        arr[1] = enemy;
        return arr;
    }
    /*static void F1() throws IOException {

        String myInputString;
        boolean check = true;
        do {
            System.out.print("Choose your weapon(sword, gun, shield): ");
            myInputString = myScanner.nextLine();
            switch (myInputString) {
                case "sword", "shield", "gun" -> check = false;
            }
        }while(check);
        check = true;
        String enemyInputString;
        do {
            System.out.print("Choose enemy`s weapon(sword, gun, shield): ");
            enemyInputString = myScanner.nextLine();
            switch (enemyInputString) {
                case "sword", "shield", "gun" -> check = false;
            }
        }while(check);

        droid.Droid my;
        droid.Droid enemy;
        switch(myInputString){
            case "sword"-> my = new droid.SwordDroid("Oda Nobunaga",1000,200,100, 3, 0.0,"Kotegiri Masamune");
            case "gun"-> my = new droid.GunDroid("Rick",1000,200,100,3, 0.0,"Railgun");
            case "shield"-> my = new droid.ShieldDroid("Paladin",1000,200,100,3,0.0,  "paladin shield");
            default-> my = new droid.Droid("Temp",0,0,0, 0, 0.0);
        }
        switch(enemyInputString){
            case "sword"-> enemy = new droid.SwordDroid("Griffith",1000,200,100, 3, 0.0,"Griffith`s sword");
            case "gun"-> enemy = new droid.GunDroid("Griffith",1000,200,100,3, 0.0,"Railgun");
            case "shield"-> enemy = new droid.ShieldDroid("Griffith",1000,200,100,3,0.0,  "Griffith`s shield");
            default-> enemy = new droid.Droid("Temp",0,0,0, 0, 0.0);
        }
        System.out.println("Fight 1x1");


        droid.Droid[] arr;
        arr = battle(my,enemy);

        my = arr[0];
        enemy = arr[1];

        if (my.getHealth() <= 0)
        {
            System.out.println(enemy.getName() +" win\n");
            myWriter.write(enemy.getName() +" win\n");
        }
        else
        {
            System.out.println(my.getName() +" win\n");
            myWriter.write(my.getName() +" win\n");
        }
        myWriter.close();
        System.out.println("Successfully wrote to the file.");
    }*/
    public static void FN(final int inNumb) throws IOException {
        Droid[] my = new Droid[inNumb];
        Droid[] enemy = new Droid[inNumb];
        for (int i = 0; i < inNumb; i++) // create massive
        {
            System.out.println(ANSI_BLUE+"Your droid.Droid №"+ANSI_BLUE+(i+1));
            //myWriter.write("Your droid.Droid №"+(i+1)+"\n");
            String myInputString;
            boolean check = true;
            do {
                System.out.print(ANSI_YELLOW+"Choose your weapon(sword, gun, shield): "+ANSI_YELLOW);
                //myWriter.write("Choose your weapon(sword, gun, shield): ");
                myInputString = myScanner.nextLine();
                //myWriter.write(myInputString+"\n");
                switch (myInputString) {
                    case "sword", "shield", "gun" -> check = false;
                }
            }while(check);
            check = true;
            System.out.println(ANSI_PURPLE+"Enemy`s droid.Droid №"+ANSI_PURPLE+(i+1));
            //myWriter.write("Enemy`s droid.Droid №"+(i+1)+"\n");
            String enemyInputString;
            do {
                System.out.print(ANSI_YELLOW+"Choose enemy`s weapon(sword, gun, shield): "+ANSI_YELLOW);
                //myWriter.write("Choose enemy`s weapon(sword, gun, shield): ");
                enemyInputString = myScanner.nextLine();
                //myWriter.write(enemyInputString+"\n");
                switch (enemyInputString) {
                    case "sword", "shield", "gun" -> check = false;
                }
            }while(check);

            switch(myInputString){
                case "sword"-> my[i] = new SwordDroid("Oda Nobunaga",1000,200,100, 3, 0.0,"Kotegiri Masamune");
                case "gun"-> my[i] = new GunDroid("Rick",1000,200,100,3, 0.0,"Railgun");
                case "shield"-> my[i] = new ShieldDroid("Paladin",1000,200,100,3,0.0,  "paladin shield");
                default-> my[i] = new Droid("Temp",0,0,0, 0, 0.0);
            }
            switch(enemyInputString){
                case "sword"-> enemy[i] = new SwordDroid("Griffith",1000,200,100, 3, 0.0,"Kotegiri Masamune");
                case "gun"-> enemy[i] = new GunDroid("Griffith",1000,200,100,3, 0.0,"Railgun");
                case "shield"-> enemy[i] = new ShieldDroid("Griffith",1000,200,100,3,0.0,  "paladin shield");
                default-> enemy[i] = new Droid("Temp",0,0,0, 0, 0.0);
            }
        }
        System.out.println("\n\n" +ANSI_RED+ "Fight "+inNumb+"x"+inNumb+ANSI_RED);
        //myWriter.write("Fight "+inNumb+"x"+inNumb);


        while (my.length > 0.0 && enemy.length > 0.0)/////
        {

            System.out.println(ANSI_BLUE+"Your droids: "+ANSI_BLUE);
            myWriter.write("Your droids: ");
            for (int i = 0; i<my.length; i++)
            {
                System.out.println((i+1)+" "+my[i].getName()+" "+my[i].getWeapon());
                myWriter.write((i+1)+" "+my[i].getName()+" "+my[i].getWeapon()+"\n");
            }

            System.out.println(ANSI_PURPLE+"Enemy`s droids: "+ANSI_PURPLE);
            myWriter.write("Enemy`s droids: ");
            for (int i = 0; i<enemy.length; i++)
            {
                System.out.println((i+1)+" "+enemy[i].getName()+" "+enemy[i].getWeapon());
                myWriter.write((i+1)+" "+enemy[i].getName()+" "+enemy[i].getWeapon()+"\n");
            }

            System.out.println(ANSI_GREEN+"Choose your droid for battle: "+ANSI_GREEN);
            myWriter.write("Choose your droid for battle: ");
            int k = myScanner.nextInt()-1;
            myWriter.write(k+"\n");

            System.out.println("Choose enemy droid for battle: ");
            myWriter.write("Choose enemy droid for battle: ");
            int e = myScanner.nextInt()-1;
            myWriter.write(e+"\n");

            battle(my[k],enemy[e]);

            if (!my[k].isAlive()) {
                Droid temp = my[k];
                my[k] = my[my.length-1];
                my[my.length-1] = temp;
                my = Arrays.copyOf(my, my.length - 1);

            }
            if (!enemy[e].isAlive()) {
                Droid temp = enemy[e];
                enemy[e] = enemy[enemy.length-1];
                enemy[enemy.length-1] = temp;
                enemy = Arrays.copyOf(enemy, enemy.length - 1);

            }

        }
        if (my.length == 0)
        {
            System.out.println("enemy win\n");
            myWriter.write("enemy win\n");
        }
        else
        {
            System.out.println("you win\n");
            myWriter.write("you win\n");
        }
        myWriter.close();
        System.out.println("Successfully wrote to the file.");
    }
    static int checkMyChoice(int myChoice, Droid my) {
        while (myChoice>=5 || myChoice<=0)
        {
            System.out.println("Your turn: ");
            System.out.println("1 >> Attack ");
            System.out.println("2 >> Heal "+ "("+my.getNumberOfHealPotion()+")");
            System.out.println("3 >> Block (-"+my.getBlockPercentage()+"% damage)");
            if(my.superPowerIsReady())
            {
                System.out.println("4 >> Use super power ");
            }
            myChoice = myScanner.nextInt();
        }
        while (myChoice == 4 && !my.superPowerIsReady())
        {
            System.out.println("Your superpower isn`t ready!");
            System.out.println("Your turn: ");
            System.out.println("1 >> Attack ");
            System.out.println("2 >> Heal "+ "("+my.getNumberOfHealPotion()+")");
            System.out.println("3 >> Block (-"+my.getBlockPercentage()+"% damage)");

            myChoice = myScanner.nextInt();
        }
        while (myChoice == 2 && my.getNumberOfHealPotion() == 0)
        {
            System.out.println("Your number of heal potion equals 0!");
            System.out.println("Your turn: ");
            System.out.println("1 >> Attack ");
            System.out.println("2 >> Heal "+ "("+my.getNumberOfHealPotion()+")");
            System.out.println("3 >> Block (-"+my.getBlockPercentage()+"% damage)");
            if(my.superPowerIsReady())
            {
                System.out.println("4 >> Use super power ");
            }
            myChoice = myScanner.nextInt();
        }
        return myChoice;
    }
    static int checkEnemyChoice(int enemyChoice, Droid enemy) {
        while ((enemyChoice == 4 && !enemy.superPowerIsReady())||(enemyChoice == 2 && enemy.getNumberOfHealPotion() == 0))
        {
            Random rand = new Random();
            enemyChoice = rand.nextInt(4)+1;
        }
        return enemyChoice;
    }
    static void print(Droid ... obj) {
        //System.out.println("Data: ");

        for(int i = 0; i < obj.length; i++) {
            printData(obj[i]);
            if (obj.length - 1 == i)
            {
                System.out.println("\n\n");
            }
        }


    }
    static void printData(Droid obj) {
        System.out.println("Name"+"\t"+(obj.getName()));
        System.out.println("Health"+"\t"+ obj.getHealth());
        System.out.println("Damage"+"\t"+ obj.getDamage());
        System.out.println("Armor"+"\t"+ obj.getArmor());
        System.out.println("Weapon"+"\t"+(obj.getWeapon()));
        System.out.println("--------------");
    }
    static void write( Droid ... obj) throws IOException {
        for(int i = 0; i < obj.length; i++) {
            writeData(obj[i]);
            if (obj.length - 1 == i)
            {
                myWriter.write("\n\n");
            }
        }
    }
    static void writeData( Droid obj) throws IOException {
        myWriter.write("\nName"+"\t"+(obj.getName()));
        myWriter.write("\nHealth"+"\t"+ obj.getHealth());
        myWriter.write("\nDamage"+"\t"+ obj.getDamage());
        myWriter.write("\nArmor"+"\t"+ obj.getArmor());
        myWriter.write("\nWeapon"+"\t"+(obj.getWeapon()));
        myWriter.write("\n--------------");
    }
}
