package com.example.everydaypractice.question;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @Description: Day17
 * @Author: lhb
 * @Date: 2021/7/16 下午6:29
 *
 * 1.说明：
 *      按YYYY-MM-DD格式给一个日期字符串，返回该日期是当前的第几天
 * 2.限制：
 *
 * 3.示例：
 *      输入："2019-01-09"
 *      输出：9
 */

public class Day17 {

    public static int solution1(String date) throws Exception {
        if (StringUtils.isEmpty(date)) {
            throw new Exception("日期不能为空");
        }

        String[] split = date.split("-");
        if (split.length != 3) {
            throw new Exception("日期格式错误");
        }

        LocalDate localDate = LocalDate.of(Integer.valueOf(split[0]), Integer.valueOf(split[1]), Integer.valueOf(split[2]));
        int dayOfYear = localDate.getDayOfYear();
        return dayOfYear;
    }
}

