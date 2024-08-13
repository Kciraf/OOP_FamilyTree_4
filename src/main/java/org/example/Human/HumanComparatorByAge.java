package org.example.Human;

import org.example.FamilyTree.MemberFamilyTree;

import java.util.Comparator;

public class HumanComparatorByAge<H extends MemberFamilyTree> implements Comparator<H> {
    @Override
    public int compare(H o1, H o2) {
        return o1.getAge() - o2.getAge();
    }
}
