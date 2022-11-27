package commands;

import java.io.IOException;

public class SearchInsurance implements Command{
    Menu menu;

    public SearchInsurance(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void execute() throws IOException {
        menu.searchInsurance();
    }
}
