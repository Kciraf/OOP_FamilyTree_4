package org.example;

import org.example.Human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private List<Human> family;
    private long memberId;

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<Human> family) {
        this.family = family;
    }

    public List<Human> getFamily() {
        return family;
    }


    public boolean add(Human member) {
        if (member == null) {
            return false;
        }
        if (!family.contains(member)) {
            family.add(member);
            member.setId(memberId++);

            addToParents(member);
            addToChildren(member);
            return true;
        }
        return false;
    }

    private void addToParents(Human member) {
        for (Human parent : member.getParents()) {
            parent.addChild(member);
        }
    }

    private void addToChildren(Human member) {
        for (Human child : member.getChildren()) {
            child.addParent(member);
        }
    }

    public List<Human> getBroSis(int id) {
        Human member = getById(id);
        boolean personDublFlag = false;
        if (member == null) {
            return null;
        }
        List<Human> broSis = new ArrayList<>();
        for (Human parent : member.getParents()) {
            for (Human child : parent.getChildren()) {
                // Исключаем из перечня себя и задвоение имен брат/сестра от родителей
                // Мать и отец имеют одинаковый перечень детей. Когда пробегаемся по детям родителей,
                // то задваиваем всех, кроме того, для кого ищем братьев/сестер
                personDublFlag = false;
                for (Human checkChild : broSis) {
                    if (checkChild.equals(child)) {
                        personDublFlag = true;
                        break;
                    }
                }
                if (!child.equals(member) && !personDublFlag) {
                    broSis.add(child);
                }
            }
        }
        return broSis;
    }

    public List<Human> getByName(String name) {
        List<Human> list = new ArrayList<>();
        for (Human familyMember : family) {
            if (familyMember.getName().equals(name)) {
                list.add(familyMember);
            }
        }
        return list;
    }

    public List<String> getMemberChildren(String name) {
        for (Human familyMember : family) {
            if (familyMember.getName().equals(name)) {
                List<String> membersChildren = new ArrayList<>();
                for (Human child :
                        familyMember.getChildren()) {
                    membersChildren.add(child.getName());
                }
                return membersChildren;
            }
        }
        return null;
    }

    public boolean remove(long id) {
        if (checkId(id)) {
            Human member = getById(id);
            return family.remove(member);
        }
        return false;
    }

    private boolean checkId(long id) {
        return id < memberId && id >= 0;
    }

    public Human getById(long id) {
        for (Human member : family) {
            if (member.getId() == id) {
                return member;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder treeAll = new StringBuilder();
        treeAll.append("В семейном древе находятся: ");
        treeAll.append(family.size());
        treeAll.append(" членов: \n");
        for (Human member : family) {
            treeAll.append(member);
        }
        return treeAll.toString();
    }
}
