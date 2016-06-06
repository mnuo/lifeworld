package com.mnuocom.lifeworld.dao;

import com.mnuocom.lifeworld.entity.Ips;

public interface IpsDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Ips record);

    int insertSelective(Ips record);

    Ips selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Ips record);

    int updateByPrimaryKey(Ips record);
}