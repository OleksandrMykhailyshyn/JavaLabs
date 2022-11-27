package commands;

import java.io.IOException;

public class ViewInsurance implements Command{
    Menu menu;

    public ViewInsurance(Menu menu) {
        this.menu = menu;
    }
    @Override
    public void execute() throws IOException {
        menu.viewInsurance();
    }
}
