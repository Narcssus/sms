package com.narc.sms.service.sms.dao.service;

import com.alibaba.fastjson.JSON;
import com.narc.sms.service.sms.dao.mapper.TxtSmsTaskMapper;
import com.narc.sms.service.sms.dao.mapper.TxtSmsTaskMapperExtend;
import com.narc.sms.service.sms.entity.TxtSmsTask;
import javax.annotation.Resource;

import com.narc.sms.service.sms.entity.TxtSmsTaskExample;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * DaoService
 * @author NarcMybatisGenerator
 * @date 2021-03-19
 */
@Service
public class TxtSmsTaskDaoService {
    @Resource
    private TxtSmsTaskMapper txtSmsTaskMapper;

    @Resource
    private TxtSmsTaskMapperExtend txtSmsTaskMapperExtend;

    public void insertOne(TxtSmsTask task){
        txtSmsTaskMapper.insertSelective(task);
    }

    public List<TxtSmsTask> selectByPhoneNo(String phoneNo){
        TxtSmsTaskExample example = new TxtSmsTaskExample();
        example.createCriteria().andPhoneNumberSetEqualTo(JSON.toJSONString(Collections.singletonList(phoneNo)));
        return txtSmsTaskMapper.selectByExample(example);
    }
}