package com.jiniubao.demo.mapper;

import com.jiniubao.demo.entity.App;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AppMapper {
    @Select("SELECT app_name FROM app WHERE app_name = 'pc-jiniubao'")
    App findPcJiniubaoApp();
}
