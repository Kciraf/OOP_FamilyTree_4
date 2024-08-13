package org.example.view.commands;

import org.example.view.ConsoleUI;

public class GetFamilyInfo extends Command{
    public GetFamilyInfo(ConsoleUI consoleUI){
        super("Вывести все семейное дерево", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().getFamilyInfo() ;
    }
}
