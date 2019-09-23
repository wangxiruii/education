package com.edu.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: 王玺瑞
 * @Date: 2019/9/16 20:04
 * @Description:
 */
@Data
public class Roles implements Serializable {
    private int roleId;        //角色编号
    private String roleName;   //角色名称

    public Roles() {
    }

    public Roles(int roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }
}
