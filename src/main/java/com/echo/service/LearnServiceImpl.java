package com.echo.service;

import com.echo.dao.LearnMapper;
import com.echo.entity.LearnResource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * Created by echo on 2017/8/2.
 */
public class LearnServiceImpl implements LearnService {

    @Autowired
    LearnMapper learnMapper;

    @Override
    public int add(LearnResource learnResource) {
        return this.learnMapper.add(learnResource);
    }

    @Override
    public int update(LearnResource learnResource) {
        return this.learnMapper.update(learnResource);
    }

    @Override
    public int deleteByIds(String[] ids) {
        return this.deleteByIds(ids);
    }

    @Override
    public LearnResource queryLearnResourceById(Long id) {
        return this.learnMapper.queryLearnResourceById(id);
    }

    @Override
    public List<LearnResource> queryLearnResourceList(Map<String, Object> params) {
        return this.learnMapper.queryLearnResourceList(params);
    }
}
