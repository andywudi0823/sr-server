package cn.sykyd.db.mapper;

import java.util.List;

import cn.sykyd.db.model.CsdSecurities;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface CsdSecuritiesMapper {
    int deleteByPrimaryKey(Integer securityId);

    int insert(CsdSecurities record);

    int insertSelective(CsdSecurities record);

    CsdSecurities selectByPrimaryKey(Integer securityId);

    int updateByPrimaryKeySelective(CsdSecurities record);

    int updateByPrimaryKey(CsdSecurities record);

    @Update("UPDATE csd_securities SET status = #{status}, modified = #{modified} WHERE security_zone = #{securityZone} AND room_id = #{roomId} AND unit_id = #{unitId}")
    int updateStatusByUnitIdSecurityZoneRoomId(CsdSecurities record);

    @Select("SELECT * FROM csd_securities WHERE security_zone = #{securityZone}")
    List<CsdSecurities> selectBySecurityZone(Integer securityZone);
}