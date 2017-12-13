package cn.sykyd.biz;

import java.io.Serializable;

// {"mac":"aaaa", "type":1, "data":{"room_id":1,"security_zone":1,"unit_id":1,"status":1}}
public class Test implements Serializable {
    public Integer getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Integer room_id) {
        this.room_id = room_id;
    }

    private Integer room_id;

    public Integer getSecurity_zone() {
        return security_zone;
    }

    public void setSecurity_zone(Integer security_zone) {
        this.security_zone = security_zone;
    }

    private Integer security_zone;

    public Integer getUnit_id() {
        return unit_id;
    }

    public void setUnit_id(Integer unit_id) {
        this.unit_id = unit_id;
    }

    private Integer unit_id;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    private Integer status;
}
