package com.echo.service;

import com.echo.entity.LearnResource;

import java.util.List;
import java.util.Map;

/**
 * Created by echo on 2017/8/2.
 */
public interface LearnService {
    int add(LearnResource learnResource);
    int update(LearnResource learnResource);
    int deleteByIds(String[] ids);
    LearnResource queryLearnResourceById(Long id);
    List<LearnResource> queryLearnResourceList(Map<String, Object> params);
}
