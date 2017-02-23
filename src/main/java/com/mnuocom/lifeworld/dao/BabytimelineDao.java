package com.mnuocom.lifeworld.dao;

import java.util.List;

import com.mnuocom.lifeworld.entity.Babytimeline;

public interface BabytimelineDao {

    int insert(Babytimeline record);
    
    List<Babytimeline> selectByTime(Babytimeline record);
    List<Babytimeline> selectByOneTime(Babytimeline record);
}