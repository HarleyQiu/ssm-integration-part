package org.example.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.example.mapper.ScheduleMapper;
import org.example.pojo.Schedule;
import org.example.service.ScheduleService;
import org.example.utils.PageBean;
import org.example.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleMapper scheduleMapper;

    @Override
    public R page(Integer pageSize, Integer currentPage) {
        // 分页
        PageHelper.startPage(pageSize, currentPage);

        // 查询
        List<Schedule> scheduleList = scheduleMapper.queryList();
        // 装配分页数据
        PageInfo<Schedule> schedulePageInfo = new PageInfo<>(scheduleList);

        // 装配配置Bean
        PageBean<Schedule> schedulePageBean = new PageBean<>(currentPage, pageSize, schedulePageInfo.getTotal(), schedulePageInfo.getList());

        return R.ok(schedulePageBean);
    }


    @Override
    public R remove(Integer id) {

        int rows = scheduleMapper.deleteById(id);

        if (rows > 0) {
            return R.ok(null);
        }

        return R.fail(null);
    }

    @Override
    public R save(Schedule schedule) {

        int rows = scheduleMapper.insert(schedule);

        if (rows > 0) {
            return R.ok(null);
        }
        return R.fail(null);
    }

    @Override
    public R update(Schedule schedule) {
        //判断id不能为null
        if (schedule.getId() == null) {
            return R.fail("核心参数为null，无法修改！");
        }

        int rows = scheduleMapper.update(schedule);

        if (rows > 0) {
            return R.ok(null);
        }

        return R.fail(null);
    }

}
