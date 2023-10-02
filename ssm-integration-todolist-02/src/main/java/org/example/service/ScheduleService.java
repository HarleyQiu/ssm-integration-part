package org.example.service;

import org.example.pojo.Schedule;
import org.example.utils.R;

public interface ScheduleService {
    R page(Integer pageSize, Integer currentPage);

    R remove(Integer id);

    R save(Schedule schedule);

    R update(Schedule schedule);
}
