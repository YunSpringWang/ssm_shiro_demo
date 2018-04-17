package com.common.entity;

import javax.persistence.Table;

import com.base.baseEntity.RecordEntity;
@Table(name="t_sys_menu")

public class SysMenu extends RecordEntity {
    private Integer id;

    private String name;

    private String remark;

    private String icon;

    private String channel;

    private String param;

    private Boolean locked;

    private Integer paterId;

    private Integer ordno;

    private Integer nLevel;

    private String scort;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel == null ? null : channel.trim();
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param == null ? null : param.trim();
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public Integer getPaterId() {
        return paterId;
    }

    public void setPaterId(Integer paterId) {
        this.paterId = paterId;
    }

    public Integer getOrdno() {
        return ordno;
    }

    public void setOrdno(Integer ordno) {
        this.ordno = ordno;
    }

    public Integer getnLevel() {
        return nLevel;
    }

    public void setnLevel(Integer nLevel) {
        this.nLevel = nLevel;
    }

    public String getScort() {
        return scort;
    }

    public void setScort(String scort) {
        this.scort = scort == null ? null : scort.trim();
    }
}