package cn.sykyd.db.mapper;

import cn.sykyd.db.model.CsdCabinets;

public interface CsdCabinetsMapper {
    int deleteByPrimaryKey(Integer cabinetId);

    int insert(CsdCabinets record);

    int insertSelective(CsdCabinets record);

    CsdCabinets selectByPrimaryKey(Integer cabinetId);

    int updateByPrimaryKeySelective(CsdCabinets record);

    int updateByPrimaryKey(CsdCabinets record);
}