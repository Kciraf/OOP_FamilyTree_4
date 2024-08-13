package org.example;

import org.example.Human.Gender;
import org.example.Human.Human;
import org.example.writer.FileHandler;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //FamilyTree tree = treeForUse();

//        writeTree(tree);
//        System.out.println(tree);

        FamilyTree tree = readTree();
        System.out.println(tree);
    }
        private static void writeTree(FamilyTree tree){
            FileHandler fileHandler = new FileHandler();
            fileHandler.write(tree);
        }

        private static FamilyTree readTree(){
            FileHandler fileHandler = new FileHandler();
            return (FamilyTree) fileHandler.read();
        }

        private static FamilyTree treeForUse() {
            FamilyTree tree = new FamilyTree();

            Human galya = new Human("Galya", LocalDate.of(1945, 10, 1), LocalDate.of(2001, 2, 3), Gender.Female);
            Human petya = new Human("Petya", LocalDate.of(1941, 1, 20), LocalDate.of(1941, 1, 20), Gender.Male);
            Human ann = new Human("Ann", LocalDate.of(1943, 9, 14), LocalDate.of(1999, 12, 11), Gender.Female);
            tree.add(galya);
            tree.add(petya);
            tree.add(ann);

            Human tom = new Human("Tom", LocalDate.of(1967, 5, 10), Gender.Male, petya, galya);
            Human peter = new Human("Peter", LocalDate.of(1970, 6, 29), LocalDate.of(2009, 11, 15), Gender.Male, petya, galya);
            Human max = new Human("Max", LocalDate.of(1971, 2, 5), Gender.Male, petya, ann);
            Human gena = new Human("Gena", LocalDate.of(1973, 11, 2), Gender.Male, petya, ann);
            Human ira = new Human("Ira", LocalDate.of(1975, 10, 2), Gender.Female, petya, ann);
            tree.add(tom);
            tree.add(peter);
            tree.add(max);
            tree.add(gena);
            tree.add(ira);

            galya.addChild(tom);
            galya.addChild(peter);
            petya.addChild(tom);
            petya.addChild(peter);
            petya.addChild(max);
            petya.addChild(gena);
            petya.addChild(ira);
            ann.addChild(max);
            ann.addChild(gena);
            ann.addChild(ira);

            Human katya = new Human("Katya", LocalDate.of(1970, 12, 1), Gender.Female);
            Human lena = new Human("Lena", LocalDate.of(1974, 3, 22), Gender.Female);
            Human alena = new Human("Alena", LocalDate.of(1977, 12, 6), Gender.Female);
            Human oksana = new Human("Oksana", LocalDate.of(1980, 5, 6), Gender.Female);

            tree.add(katya);
            tree.add(lena);
            tree.add(alena);
            tree.add(oksana);
            return tree;
        }
}