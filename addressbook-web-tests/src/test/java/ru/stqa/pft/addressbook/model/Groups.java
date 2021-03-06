package ru.stqa.pft.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

public class Groups extends ForwardingSet<GroupData>{

    private Set<GroupData> gelegate;

    public Groups(Groups groups) {
        this.gelegate = new HashSet<GroupData>(groups.gelegate);
    }

    public Groups() {
        this.gelegate = new HashSet<GroupData>();
    }


    @Override
    protected Set<GroupData> delegate() {
        return gelegate;
    }

    public Groups withAdded(GroupData group){
        Groups groups  = new Groups(this);
        groups.add(group);
        return groups;
    }

    public Groups without(GroupData group){
        Groups groups  = new Groups(this);
        groups.remove(group);
        return groups;
    }
}
