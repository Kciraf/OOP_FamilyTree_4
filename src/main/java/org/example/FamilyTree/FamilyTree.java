package org.example.FamilyTree;

import org.example.Human.Human;
import org.example.Human.HumanComparatorByAge;

import java.io.Serializable;
import java.util.*;

public class FamilyTree<T extends MemberFamilyTree> implements Serializable, Iterable<T> {
    private List<T> family;
    private long memberId;

    public FamilyTree() {
        family = new ArrayList<>();
    }

    public FamilyTree(List<T> family) {
        this.family = family;
    }

    public List<T> getFamily() {
        return family;
    }


    public boolean add(T member) {
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

    private void addToParents(T member) {
        for (T parent : (List<T>) member.getParents()) {
            parent.addChild(member);
        }
    }

    private void addToChildren(T member) {
        for (T child : (List<T>) member.getChildren()) {
            child.addParent(member);
        }
    }

    public List<T> getBroSis(int id) {
        T member = getById(id);
        boolean personDublFlag = false;
        if (member == null) {
            return null;
        }
        List<T> broSis = new ArrayList<>();
        for (T parent : (List<T>) member.getParents()) {
            for (T child : (List<T>) parent.getChildren()) {
                // Исключаем из перечня себя и задвоение имен брат/сестра от родителей
                // Мать и отец имеют одинаковый перечень детей. Когда пробегаемся по детям родителей,
                // то задваиваем всех, кроме того, для кого ищем братьев/сестер
                personDublFlag = false;
                for (T checkChild : broSis) {
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

    public List<T> getByName(String name) {
        List<T> list = new ArrayList<>();
        for (T familyMember : family) {
            if (familyMember.getName().equals(name)) {
                list.add(familyMember);
            }
        }
        return list;
    }

    public List<String> getMemberChildren(String name) {
        for (T familyMember : family) {
            if (familyMember.getName().equals(name)) {
                List<String> membersChildren = new ArrayList<>();
                for (T child : (List<T>) familyMember.getChildren()) {
                    membersChildren.add(child.getName());
                }
                return membersChildren;
            }
        }
        return null;
    }

    public boolean remove(long id) {
        if (checkId(id)) {
            T member = getById(id);
            return family.remove(member);
        }
        return false;
    }

    private boolean checkId(long id) {
        return id < memberId && id >= 0;
    }

    public T getById(long id) {
        for (T member : family) {
            if (member.getId() == id) {
                return member;
            }
        }
        return null;
    }

    public void sortByName() {
        Collections.sort(family, new HumanComparatorByAge<>());
    }

    public void sortByAge() {
        Collections.sort(family, new HumanComparatorByAge());
    }

    @Override
    public String toString() {
        StringBuilder treeAll = new StringBuilder();
        treeAll.append("В семейном древе находятся: ");
        treeAll.append(family.size());
        treeAll.append(" членов: \n");
        for (T member : family) {
            treeAll.append(member);
        }
        return treeAll.toString();
    }


    @Override
    public Iterator<T> iterator() {
        return new MembersIterator<>(family);
    }

}
