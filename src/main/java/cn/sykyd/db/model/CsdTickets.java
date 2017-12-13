package cn.sykyd.db.model;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

public class CsdTickets implements Serializable {
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    private Integer ticketId;

    private Integer unitId;

    private Integer roomId;

    private Integer id;

    private Integer row;

    private Integer column;

    private String sn;

    private Integer lineId;

    private String lineName;

    private Integer status;

    private String alarmTime;

    private String created;

    private String modified;

    private static final long serialVersionUID = 1L;

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getColumn() {
        return column;
    }

    public void setColumn(Integer column) {
        this.column = column;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn == null ? null : sn.trim();
    }

    public Integer getLineId() {
        return lineId;
    }

    public void setLineId(Integer lineId) {
        this.lineId = lineId;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName == null ? null : lineName.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAlarmTime() {
        return alarmTime;
    }

    public void setAlarmTime(String alarmTime) {
        this.alarmTime = alarmTime == null ? null : alarmTime.trim();
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
        CsdTickets other = (CsdTickets) that;
        return (this.getTicketId() == null ? other.getTicketId() == null : this.getTicketId().equals(other.getTicketId()))
                && (this.getUnitId() == null ? other.getUnitId() == null : this.getUnitId().equals(other.getUnitId()))
                && (this.getRoomId() == null ? other.getRoomId() == null : this.getRoomId().equals(other.getRoomId()))
                && (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getRow() == null ? other.getRow() == null : this.getRow().equals(other.getRow()))
                && (this.getColumn() == null ? other.getColumn() == null : this.getColumn().equals(other.getColumn()))
                && (this.getSn() == null ? other.getSn() == null : this.getSn().equals(other.getSn()))
                && (this.getLineId() == null ? other.getLineId() == null : this.getLineId().equals(other.getLineId()))
                && (this.getLineName() == null ? other.getLineName() == null : this.getLineName().equals(other.getLineName()))
                && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
                && (this.getAlarmTime() == null ? other.getAlarmTime() == null : this.getAlarmTime().equals(other.getAlarmTime()))
                && (this.getCreated() == null ? other.getCreated() == null : this.getCreated().equals(other.getCreated()))
                && (this.getModified() == null ? other.getModified() == null : this.getModified().equals(other.getModified()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTicketId() == null) ? 0 : getTicketId().hashCode());
        result = prime * result + ((getUnitId() == null) ? 0 : getUnitId().hashCode());
        result = prime * result + ((getRoomId() == null) ? 0 : getRoomId().hashCode());
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getRow() == null) ? 0 : getRow().hashCode());
        result = prime * result + ((getColumn() == null) ? 0 : getColumn().hashCode());
        result = prime * result + ((getSn() == null) ? 0 : getSn().hashCode());
        result = prime * result + ((getLineId() == null) ? 0 : getLineId().hashCode());
        result = prime * result + ((getLineName() == null) ? 0 : getLineName().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getAlarmTime() == null) ? 0 : getAlarmTime().hashCode());
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
        sb.append(", ticketId=").append(ticketId);
        sb.append(", unitId=").append(unitId);
        sb.append(", roomId=").append(roomId);
        sb.append(", id=").append(id);
        sb.append(", row=").append(row);
        sb.append(", column=").append(column);
        sb.append(", sn=").append(sn);
        sb.append(", lineId=").append(lineId);
        sb.append(", lineName=").append(lineName);
        sb.append(", status=").append(status);
        sb.append(", alarmTime=").append(alarmTime);
        sb.append(", created=").append(created);
        sb.append(", modified=").append(modified);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public void fromJSONObject(JSONObject obj) {
        unitId = obj.getInteger("unit_id");
        id = obj.getInteger("id");
        row = obj.getInteger("row");
        column = obj.getInteger("column");
        status = obj.getInteger("status");
    }
}