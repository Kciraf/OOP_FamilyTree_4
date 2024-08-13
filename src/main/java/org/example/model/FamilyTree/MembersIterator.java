package org.example.model.FamilyTree;

import java.util.Iterator;
import java.util.List;

public class MembersIterator<H extends MemberFamilyTree> implements Iterator<H> {
    private int curId;
    private List<H> family;

    public MembersIterator(List<H> family){
        this.family = family;
    };

    @Override
    public boolean hasNext() {
        return family.size() > curId;
    }

    @Override
    public H next() {
        return family.get(curId++);
    }
}
