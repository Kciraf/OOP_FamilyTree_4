package org.example.model.Service;

import org.example.model.FamilyTree.FamilyTree;
import org.example.model.Human.Gender;
import org.example.model.Human.Human;
import org.example.model.writer.FileHandler;

import java.time.LocalDate;

public class Service {

    private int idMemb;
    private FamilyTree tree;
    private FileHandler fileHandler;

    public Service() {
        tree = new FamilyTree();
        fileHandler = new FileHandler();
    }

    public Service(FamilyTree tree) {
        this.tree = tree;
    }

    public FamilyTree getTree() {
        return tree;
    }

    public void sortByName() {
        this.tree.sortByName();
    }

    public void sortByAge() {
        this.tree.sortByAge();
    }

    public void addFamilyMemb(String name, LocalDate dayBirth, Gender gender){
        Human member = new Human(idMemb++, name, dayBirth, gender);
        tree.add(member);
    }

//    public void writeTree(FamilyTree tree){
//        FileHandler fileHandler = new FileHandler();
//        fileHandler.write(tree);
//    }
//
//    public FamilyTree readTree(){
//        FileHandler fileHandler = new FileHandler();
//        return (FamilyTree) fileHandler.read();
//    }
    public String getFamilyInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(tree.toString());
        return stringBuilder.toString();
    }
}
