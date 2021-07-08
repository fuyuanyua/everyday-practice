package com.example.everydaypractice.question;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description: Day09Test
 * @Author: lhb
 * @Date: 2021/7/6 下午7:10
 */

@Slf4j
class Day09Test {

    public static class GroupResult implements Serializable {
        /**
         *
         */
        private static final long serialVersionUID = 4719453000146453142L;
        public String id;
        public String link;
        public String groupId;
        public String createBy;
        public String messageBy;
        public String helperBy;
        public List<String> ignores = new ArrayList<String>();
        public int createStatus = 0;
        public int adminStatus = 0;
        public int linkStatus = 0;
        public int descriptionStatus = 0;
        public int iconStatus = 0;
        public int messageStatus = 0;
        public int syncStatus = 1 ;
        public int lockStatus = 0;
        public int muteStatus = 0;
        public int menberStatus = 0;

        public int started;
        public int forbidden;
    }

    @Test
    void solution1() {
        int a = 5;
        log.info("input = {}", a);
        int result = Day09.solution1(a);
        log.info("output = {}", result);
    }

    @Test
    void solution2() {
        int a = Integer.MAX_VALUE;
        log.info("input = {}", a);
        int result = Day09.solution2(a);
        log.info("output = {}", result);
    }

    @Test
    void test() {
        GroupResult groupResult = new GroupResult();
        String s = JSON.toJSONString(groupResult, SerializerFeature.WriteMapNullValue);
        log.info("{}", s);
    }
}