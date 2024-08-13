package org.example.model.FamilyTree;

import java.io.Serializable;
import java.util.List;

public interface MemberFamilyTree<H> extends Serializable {
    String getName();
    H getFather();
    H getMother();
    int getAge();
    long getId();
    void setId(long id);
    boolean addChild(H child);
    boolean addParent(H parent);

    List<H> getChildren();
    List<H> getParents();
}
