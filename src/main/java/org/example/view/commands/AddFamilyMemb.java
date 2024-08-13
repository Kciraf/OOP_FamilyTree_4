package org.example.view.commands;

import org.example.view.ConsoleUI;

public class AddFamilyMemb extends Command{
    public AddFamilyMemb(ConsoleUI consoleUI){
        super("Добавить нового родственника", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().finish();
    }
}
