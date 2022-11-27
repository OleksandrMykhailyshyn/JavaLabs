package commands;

public class SelectInsurance  implements Command{
    Menu menu;

    public SelectInsurance(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void execute() {
        menu.selectInsurance();
    }
}
