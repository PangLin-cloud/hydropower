package com.panglin.mapper;

import com.panglin.pojo.TbSettings;
import com.panglin.pojo.TbSettingsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbSettingsMapper {
    int countByExample(TbSettingsExample example);

    int deleteByExample(TbSettingsExample example);

    int insert(TbSettings record);

    int insertSelective(TbSettings record);

    List<TbSettings> selectByExample(TbSettingsExample example);

    int updateByExampleSelective(@Param("record") TbSettings record, @Param("example") TbSettingsExample example);

    int updateByExample(@Param("record") TbSettings record, @Param("example") TbSettingsExample example);
}