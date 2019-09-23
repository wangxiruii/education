package com.edu.mapper;

import com.edu.pojo.Powers;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Auther: 王玺瑞
 * @Date: 2019/9/16 20:35
 * @Description:
 */
@Mapper
public interface PowersMapper {
    public List<Powers> loadPowerByPid(List<Integer> poId);
    public String findAdressByName(String poName);
}
