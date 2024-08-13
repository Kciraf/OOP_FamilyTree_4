package org.example.view.commands;

import org.example.model.FamilyTree.FamilyTree;
import org.example.view.ConsoleUI;

public class SaveTreeInFile extends Command {
    FamilyTree tree = new FamilyTree<>();
    public SaveTreeInFile(ConsoleUI consoleUI, FamilyTree tree) {
        super("Сохранить фамильное дерево в файле", consoleUI);
        this.tree = tree;
    }

    @Override
    public void execute() {
//        getConsoleUI().saveTreeInFile(tree);
    }
}
