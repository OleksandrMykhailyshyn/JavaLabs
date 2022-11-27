package user;

import commands.Command;
import insurance.Insurance;

import java.util.ArrayList;

public class User {

    /**/
    private Payment payment;
    private DataOfTheInsured data;
    private LogInData logInData;

    public LogInData getLogInData() {
        return logInData;
    }

    public void setLogInData(LogInData logInData) {
        this.logInData = logInData;
    }

    private ArrayList<Insurance> list = new ArrayList<Insurance>();
    Command logIn;
    Command register;
    Command logOut;
    Command help;
    Command update;
    Command select;
    Command delete;
    Command view;
    Command search;

    public Command getLogIn() {
        return logIn;
    }

    public Command getRegister() {
        return register;
    }

    public Command getLogOut() {
        return logOut;
    }

    public Command getHelp() {
        return help;
    }

    public Command getUpdate() {
        return update;
    }

    public Command getSelect() {
        return select;
    }

    public Command getDelete() {
        return delete;
    }

    public Command getView() {
        return view;
    }

    public Command getSearch() {
        return search;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public DataOfTheInsured getData() {
        return data;
    }

    public void setData(DataOfTheInsured data) {
        this.data = data;
    }
    public ArrayList<Insurance> getList() {
        return list;
    }

    public void setList(ArrayList<Insurance> list) {
        this.list = list;
    }

    public User(Payment payment, DataOfTheInsured data, ArrayList<Insurance> list) {
        this.payment = payment;
        this.data = data;
        this.list = list;
    }

    public User(Command logIn, Command register, Command logOut, Command help, Command update, Command select, Command delete, Command view, Command search) {
        this.logIn = logIn;
        this.register = register;
        this.logOut = logOut;
        this.help = help;
        this.update = update;
        this.select = select;
        this.delete = delete;
        this.view = view;
        this.search = search;
    }

    @Override
    public String toString() {
        return "User{" + "list=" + list + '}';
    }

    public void logIn()
    {
        logIn.execute();
    }
    public void logOut()
    {
        logOut.execute();
    }
    public void register()
    {
        register.execute();
    }
    public void help()
    {
        help.execute();
    }
    public void update()
    {
        update.execute();
    }
    public void select(){select.execute();}
    public void delete(){delete.execute();}
}
