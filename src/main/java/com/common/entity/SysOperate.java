package com.common.entity;

import javax.persistence.Table;

import com.base.baseEntity.RecordEntity;
@Table(name="t_sys_operate")

public class SysOperate extends RecordEntity {
    private Integer id;

    private Integer menuId;

    private String op;

    private String name;

    private String icon;

    private String remark;

    private Integer ordno;

    private Integer display;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op == null ? null : op.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getOrdno() {
        return ordno;
    }

    public void setOrdno(Integer ordno) {
        this.ordno = ordno;
    }

    public Integer getDisplay() {
        return display;
    }

    public void setDisplay(Integer display) {
        this.display = display;
    }
}