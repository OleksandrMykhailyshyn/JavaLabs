package commands;

public class SearchInsurance implements Command{
    Menu menu;

    public SearchInsurance(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void execute() {
        menu.searchInsurance();
    }
}
