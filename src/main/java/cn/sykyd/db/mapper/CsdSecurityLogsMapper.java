package cn.sykyd.db.mapper;

import cn.sykyd.db.model.CsdSecurityLogs;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

public interface CsdSecurityLogsMapper {
    int deleteByPrimaryKey(Integer securityLogId);

    int insert(CsdSecurityLogs record);

    int insertSelective(CsdSecurityLogs record);

    CsdSecurityLogs selectByPrimaryKey(Integer securityLogId);

    int updateByPrimaryKeySelective(CsdSecurityLogs record);

    int updateByPrimaryKey(CsdSecurityLogs record);

    @Insert("INSERT INTO csd_security_logs (security_zone, unit_id, room_id, status, created) VALUES (#{securityZone}, #{unitId}, #{roomId}, #{status}, #{created})")
    int insertLog(CsdSecurityLogs record);
}