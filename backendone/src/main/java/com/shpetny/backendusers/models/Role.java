package com.shpetny.backendusers.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author Shpetny Eugene
 * @version 1.0
 */
public enum Role {
    USER(0), ADMIN(1);

    private int roleId;

    Role(int roleId) {
        this.roleId = roleId;
    }

    @JsonCreator
    public static Role roleFromId(Integer roleId) {
        for (Role role : Role.values()) {
            if (role.roleId == roleId) {
                return role;
            }
        }
        throw new IllegalArgumentException();
    }

    @JsonValue
    public int getCode() {
        return roleId;
    }

}
