package cn.sykyd.db.model;

import java.io.Serializable;

public class CsdCabinets implements Serializable {
    private Integer cabinetId;

    private Integer unitId;

    private Integer roomId;

    private String name;

    private String sn;

    private Integer row;

    private Integer column;

    private Integer total;

    private Integer used;

    private Integer unused;

    private Byte order;

    private String created;

    private String modified;

    private static final long serialVersionUID = 1L;

    public Integer getCabinetId() {
        return cabinetId;
    }

    public void setCabinetId(Integer cabinetId) {
        this.cabinetId = cabinetId;
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

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn == null ? null : sn.trim();
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

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getUsed() {
        return used;
    }

    public void setUsed(Integer used) {
        this.used = used;
    }

    public Integer getUnused() {
        return unused;
    }

    public void setUnused(Integer unused) {
        this.unused = unused;
    }

    public Byte getOrder() {
        return order;
    }

    public void setOrder(Byte order) {
        this.order = order;
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
        CsdCabinets other = (CsdCabinets) that;
        return (this.getCabinetId() == null ? other.getCabinetId() == null : this.getCabinetId().equals(other.getCabinetId()))
                && (this.getUnitId() == null ? other.getUnitId() == null : this.getUnitId().equals(other.getUnitId()))
                && (this.getRoomId() == null ? other.getRoomId() == null : this.getRoomId().equals(other.getRoomId()))
                && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
                && (this.getSn() == null ? other.getSn() == null : this.getSn().equals(other.getSn()))
                && (this.getRow() == null ? other.getRow() == null : this.getRow().equals(other.getRow()))
                && (this.getColumn() == null ? other.getColumn() == null : this.getColumn().equals(other.getColumn()))
                && (this.getTotal() == null ? other.getTotal() == null : this.getTotal().equals(other.getTotal()))
                && (this.getUsed() == null ? other.getUsed() == null : this.getUsed().equals(other.getUsed()))
                && (this.getUnused() == null ? other.getUnused() == null : this.getUnused().equals(other.getUnused()))
                && (this.getOrder() == null ? other.getOrder() == null : this.getOrder().equals(other.getOrder()))
                && (this.getCreated() == null ? other.getCreated() == null : this.getCreated().equals(other.getCreated()))
                && (this.getModified() == null ? other.getModified() == null : this.getModified().equals(other.getModified()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCabinetId() == null) ? 0 : getCabinetId().hashCode());
        result = prime * result + ((getUnitId() == null) ? 0 : getUnitId().hashCode());
        result = prime * result + ((getRoomId() == null) ? 0 : getRoomId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getSn() == null) ? 0 : getSn().hashCode());
        result = prime * result + ((getRow() == null) ? 0 : getRow().hashCode());
        result = prime * result + ((getColumn() == null) ? 0 : getColumn().hashCode());
        result = prime * result + ((getTotal() == null) ? 0 : getTotal().hashCode());
        result = prime * result + ((getUsed() == null) ? 0 : getUsed().hashCode());
        result = prime * result + ((getUnused() == null) ? 0 : getUnused().hashCode());
        result = prime * result + ((getOrder() == null) ? 0 : getOrder().hashCode());
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
        sb.append(", cabinetId=").append(cabinetId);
        sb.append(", unitId=").append(unitId);
        sb.append(", roomId=").append(roomId);
        sb.append(", name=").append(name);
        sb.append(", sn=").append(sn);
        sb.append(", row=").append(row);
        sb.append(", column=").append(column);
        sb.append(", total=").append(total);
        sb.append(", used=").append(used);
        sb.append(", unused=").append(unused);
        sb.append(", order=").append(order);
        sb.append(", created=").append(created);
        sb.append(", modified=").append(modified);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}