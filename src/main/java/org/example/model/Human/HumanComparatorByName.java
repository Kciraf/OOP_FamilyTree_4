package org.example.model.Human;

import org.example.model.FamilyTree.MemberFamilyTree;

import java.util.Comparator;

public class HumanComparatorByName<H extends MemberFamilyTree> implements Comparator<H> {
    @Override
    public int compare(H o1, H o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
