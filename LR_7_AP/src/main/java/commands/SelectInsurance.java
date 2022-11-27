package commands;

import java.io.IOException;

public class SelectInsurance  implements Command{
    Menu menu;

    public SelectInsurance(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void execute() throws IOException {
        menu.selectInsurance();
    }
}
