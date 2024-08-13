package org.example.Service;

import org.example.FamilyTree.FamilyTree;
import org.example.writer.FileHandler;

public class Service {

    private FamilyTree tree;
    private FileHandler fileHandler;

    public Service(){
        tree = new FamilyTree();
        fileHandler = new FileHandler();
    }

    public Service(FamilyTree tree){
        this.tree = tree;
    }

    public void sortByName(){
        this.tree.sortByName();
    }

    public void sortByAge(){
        this.tree.sortByAge();
    }

    public String getFamilyInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(tree.toString());
        return stringBuilder.toString();
    }




}
