package org.example.FamilyTree;

import org.example.Human.Human;

import java.util.Iterator;
import java.util.List;

public class MembersIterator implements Iterator<Human> {
    private int curId;
    private List<Human> family;

    public MembersIterator(List<Human> family){
        this.family = family;
    };

    @Override
    public boolean hasNext() {
        return family.size() > curId;
    }

    @Override
    public Human next() {
        return family.get(curId++);
    }
}
