package cn.sykyd.db.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

public class CsdSecurities implements Serializable {
    private Integer securityId;

    private Integer securityZone;

    private Integer unitId;

    private Integer roomId;

    private String name;

    private Integer type;

    private String param;

    private Integer status;

    private String created;

    private String modified;

    private static final long serialVersionUID = 1L;

    public Integer getSecurityId() {
        return securityId;
    }

    public void setSecurityId(Integer securityId) {
        this.securityId = securityId;
    }

    public Integer getSecurityZone() {
        return securityZone;
    }

    public void setSecurityZone(Integer securityZone) {
        this.securityZone = securityZone;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param == null ? null : param.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created == null ? null : created.trim();
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified == null ? null : modified.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        CsdSecurities other = (CsdSecurities) that;
        return (this.getSecurityId() == null ? other.getSecurityId() == null : this.getSecurityId().equals(other.getSecurityId()))
                && (this.getSecurityZone() == null ? other.getSecurityZone() == null : this.getSecurityZone().equals(other.getSecurityZone()))
                && (this.getUnitId() == null ? other.getUnitId() == null : this.getUnitId().equals(other.getUnitId()))
                && (this.getRoomId() == null ? other.getRoomId() == null : this.getRoomId().equals(other.getRoomId()))
                && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
                && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
                && (this.getParam() == null ? other.getParam() == null : this.getParam().equals(other.getParam()))
                && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
                && (this.getCreated() == null ? other.getCreated() == null : this.getCreated().equals(other.getCreated()))
                && (this.getModified() == null ? other.getModified() == null : this.getModified().equals(other.getModified()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSecurityId() == null) ? 0 : getSecurityId().hashCode());
        result = prime * result + ((getSecurityZone() == null) ? 0 : getSecurityZone().hashCode());
        result = prime * result + ((getUnitId() == null) ? 0 : getUnitId().hashCode());
        result = prime * result + ((getRoomId() == null) ? 0 : getRoomId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getParam() == null) ? 0 : getParam().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreated() == null) ? 0 : getCreated().hashCode());
        result = prime * result + ((getModified() == null) ? 0 : getModified().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", securityId=").append(securityId);
        sb.append(", securityZone=").append(securityZone);
        sb.append(", unitId=").append(unitId);
        sb.append(", roomId=").append(roomId);
        sb.append(", name=").append(name);
        sb.append(", type=").append(type);
        sb.append(", param=").append(param);
        sb.append(", status=").append(status);
        sb.append(", created=").append(created);
        sb.append(", modified=").append(modified);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public void fromJSONObject(JSONObject obj) {
        unitId = obj.getInteger("unit_id");
        securityZone = obj.getInteger("security_zone");
        roomId = obj.getInteger("room_id");
        status = obj.getInteger("status");
    }
}