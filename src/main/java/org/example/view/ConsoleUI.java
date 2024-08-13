package org.example.view;

import org.example.model.FamilyTree.FamilyTree;
import org.example.presenter.Presenter;

import java.util.Scanner;
import java.util.SortedMap;

public class ConsoleUI implements View {
    private static final String INPUT_ERROR = "Вы ввели неверное значение";
    private Scanner scanner;
    private boolean run;
    private Presenter presenter;
    private MainMenu menu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        run = true;
        presenter = new Presenter(this);
        menu = new MainMenu(this);
    }

    @Override
    public void start() {
        System.out.println("Здравствуйте!");
        while (run) {
            System.out.println(menu.menu());
            String choiceStr = scanner.nextLine();
            int choice = Integer.parseInt(choiceStr);
            menu.execute(choice);
        }
    }
    public void finish() {
        run = false;
        scanner.close();
        System.out.println("Работа завершена");
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void sortByAge(){
        presenter.sortByAge();
    }

    public void getFamilyInfo() {
        presenter.getFamilyInfo();
    }

//    public void saveTreeInFile(FamilyTree tree){
//        presenter.saveTreeInFile(tree);
//    }
//
//    public void loadTreeFromFile(){
//        presenter.loadTreeFromFile();
//    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }

}



