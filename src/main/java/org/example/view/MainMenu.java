package org.example.view;

import org.example.view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commands;

    public MainMenu(ConsoleUI consoleUI){
        commands = new ArrayList<>();
        commands.add(new AddFamilyMemb(consoleUI));
        commands.add(new GetFamilyInfo(consoleUI));
//        commands.add(new LoadTreeFromFile(consoleUI));
//        commands.add(new SaveTreeInFile(consoleUI, tree));
        commands.add(new SortByName(consoleUI));
        commands.add(new SortByAge(consoleUI));
        commands.add(new Finish(consoleUI));
    }

    public String menu(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Меню\n");
        for (int i = 0; i < commands.size(); i++) {
            stringBuilder.append(i+1 + ". ");
            stringBuilder.append(commands.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choice){
        Command command = commands.get(choice - 1);
        command.execute();
    }

    public int size(){
        return commands.size();
    }
}
