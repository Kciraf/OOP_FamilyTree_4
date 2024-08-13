package org.example.view.commands;

import org.example.view.ConsoleUI;

public class LoadTreeFromFile extends Command {
    public LoadTreeFromFile(ConsoleUI consoleUI){
        super("Загрузить фамильное дерево из файла", consoleUI);
    }

    @Override
    public void execute() {
//        getConsoleUI().loadTreeFromFile();
    }
}
