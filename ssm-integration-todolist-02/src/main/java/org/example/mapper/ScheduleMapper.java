package org.example.mapper;

import org.example.pojo.Schedule;

import java.util.List;

/**
 * @author 21055
 * @description 针对表【schedule】的数据库操作Mapper
 * @createDate 2023-10-02 15:48:06
 * @Entity org.example.pojo.Schedule
 */
public interface ScheduleMapper {

    List<Schedule> queryList();

    int deleteById(Integer id);

    int insert(Schedule schedule);

    int update(Schedule schedule);
}




