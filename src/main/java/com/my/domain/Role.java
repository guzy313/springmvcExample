package com.my.domain;

public class Role {
    private int id;
    private String roleName;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "role{id:\t"+id+"\t"+
                "roleName:"+roleName+"\t"+
                "}";
    }
}
