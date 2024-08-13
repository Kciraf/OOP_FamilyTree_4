package org.example.FamilyTree;

import java.util.List;

public interface MemberFamilyTree<H> {
    String getName();
    int getAge();
    long getId();
    void setId(long id);
    boolean addChild(H child);
    boolean addParent(H parent);

    List<H> getChildren();
    List<H> getParents();
}
