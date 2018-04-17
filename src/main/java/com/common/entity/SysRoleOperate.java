package com.common.entity;

import javax.persistence.Table;

import com.base.baseEntity.RecordEntity;
@Table(name="t_sys_role_operate")

public class SysRoleOperate extends RecordEntity {
    private Integer roleId;

    private Integer operateId;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getOperateId() {
        return operateId;
    }

    public void setOperateId(Integer operateId) {
        this.operateId = operateId;
    }
}