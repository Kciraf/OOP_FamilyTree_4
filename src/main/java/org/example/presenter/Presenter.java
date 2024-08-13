package org.example.presenter;

import org.example.model.FamilyTree.FamilyTree;
import org.example.model.Human.Gender;
import org.example.model.Service.Service;
import org.example.view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

//    public void loadTreeFromFile() {
//        service.readTree();
//        getFamilyInfo();
//    }
//
//    public void saveTreeInFile(FamilyTree tree){
//        service.writeTree(tree);
//        System.out.println("Операция записи в файл завершена");
//    }

    public void addFamilyMemb(String name, LocalDate dayBirth, Gender gender) {
        service.addFamilyMemb(name, dayBirth, gender);
        getFamilyInfo(); //Подтверждение добавления
    }

    public void getFamilyInfo() {
        String answer = service.getFamilyInfo();
        view.printAnswer(answer);
    }

    public void sortByName(){
        service.sortByName();
        getFamilyInfo();
    }

    public void sortByAge(){
        service.sortByAge();
        getFamilyInfo();
    }

}
