package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.pojo.Schedule;
import org.example.service.ScheduleService;
import org.example.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @GetMapping("{pageSize}/{currentPage}")
    public R page(
            @PathVariable Integer pageSize,
            @PathVariable Integer currentPage
    ) {
        R r = scheduleService.page(pageSize, currentPage);
        log.info("查询的数据为: {}", r);
        return r;
    }

    @DeleteMapping("/{id}")
    public R remove(@PathVariable Integer id) {
        return scheduleService.remove(id);
    }

    @PostMapping
    public R save(@Validated @RequestBody Schedule schedule, BindingResult result) {
        if (result.hasErrors()) {
            return R.fail("参数为null,不能保存！");
        }
        return scheduleService.save(schedule);
    }

    @PutMapping
    public R update(@Validated @RequestBody Schedule schedule, BindingResult result) {
        if (result.hasErrors()) {
            return R.fail("参数为null,不能修改！");
        }
        return scheduleService.update(schedule);
    }
}
