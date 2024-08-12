package org.example;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private long id;
    private String name;
    private LocalDate dayBirth, dayDeath;
    private Gender gender;
    private Human father, mother;
    private List<Human> children;

    //Полный вариант для создания
    public Human(String name, LocalDate dayBirth, LocalDate dayDeath, Gender gender, Human father, Human mother) {
        id = -1;
        this.name = name;
        this.dayBirth = dayBirth;
        this.dayDeath = dayDeath;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        children = new ArrayList<>();
    }

    //Для предков, родители которых не известны
    public Human(String name, LocalDate dayBirth, LocalDate dayDeath, Gender gender) {
        this(name, dayBirth, dayDeath, gender, null, null);
    }


    //Еще живой человек, второй вариант полный
    public Human(String name, LocalDate do_birth, Gender gender, Human father, Human mother) {
        this(name, do_birth, null, gender, father, mother);
    }

    //Минимальный вариант для человека. Не знаем его родственных связей.
    public Human(String name, LocalDate do_birth, Gender gender) {
        this(name, do_birth, null, gender, null, null);
    }

    public boolean addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    public boolean addParent(Human parent) {
        if (parent.getGender().equals(Gender.Male) && this.father == null) {
            setFather(parent);
            return true;
        }
        if (parent.getGender().equals(Gender.Female) && this.mother == null) {
            setMother(parent);
            return true;
        }
        return false;
    }

    public List<Human> getParents(){
        List<Human> list = new ArrayList<>(2);
        if (father != null){
            list.add(father);
        }
        if (mother != null){
            list.add(mother);
        }
        return list;
    }

    public int getAge() {
        if (dayDeath == null) {
            return getPeriod(dayBirth, LocalDate.now());
        } else {
            return getPeriod(dayBirth, dayDeath);
        }
    }

    private int getPeriod(LocalDate dayBirth, LocalDate dayDeath) {
        Period diff = Period.between(dayBirth, dayDeath);
        return diff.getYears();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDayBirth(LocalDate dayBirth) {
        this.dayBirth = dayBirth;
    }

    public void setDayDeath(LocalDate do_death) {
        this.dayDeath = do_death;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDayBirth() {
        return dayBirth;
    }

    public LocalDate getDayDeath() {
        return dayDeath;
    }

    public Gender getGender() {
        return gender;
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Human> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Имя: " + name + "\n");
        stringBuilder.append("Дата рождения: " + dayBirth + "\n");
        if (dayDeath != null) {
            stringBuilder.append("Дата смерти: " + dayDeath + "\n");
        }
        stringBuilder.append("Пол: " + dayDeath + "\n");
        if (father != null) {
            stringBuilder.append("Имя отца: " + father.getName() + "\n");
        } else {
            stringBuilder.append("Имя отца: неизвестно \n");
        }
        if (mother != null) {
            stringBuilder.append("Имя матери: " + mother.getName() + "\n");
        } else {
            stringBuilder.append("Имя матери: неизвестно \n");
        }
        if (children == null) {
            stringBuilder.append("Детей нет\n");
        } else {
            stringBuilder.append("Список детей: ");
            for (Human familyMem : this.children) {
                stringBuilder.append(familyMem.getName());
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Human)) {
            return false;
        }
        Human human = (Human) obj;
        return human.getId() == getId();
    }
}
