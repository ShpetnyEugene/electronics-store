package com.shpetny.backendusers.models;

/**
 * @author Shpetny Eugene
 * @version 1.0
 */
public enum Role {
    USER(2), ADMIN(1);

    private int roleId;

    Role(int roleId) {
        this.roleId = roleId;
    }

    public static Role roleFromId(Integer roleId) {
        for (Role role : Role.values()) {
            if (role.roleId == roleId) {
                return role;
            }
        }
        throw new IllegalArgumentException();
    }
}
