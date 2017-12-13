package cn.sykyd.db.mapper;

import cn.sykyd.db.model.CsdTickets;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

public interface CsdTicketsMapper {
    int deleteByPrimaryKey(Integer ticketId);

    int insert(CsdTickets record);

    int insertSelective(CsdTickets record);

    CsdTickets selectByPrimaryKey(Integer ticketId);

    int updateByPrimaryKeySelective(CsdTickets record);

    int updateByPrimaryKey(CsdTickets record);

    //{"mac":"aaa","type":2,"data":{"id":1,"row":1,"column":1,"status":1}}
    @Update("UPDATE csd_tickets SET `status` = #{status} WHERE unit_id = #{unitId} AND `id` = #{id} AND `row` = #{row} AND `column` = #{column}")
    int updateStatusByParam(CsdTickets record);
}