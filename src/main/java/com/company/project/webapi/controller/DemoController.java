package com.company.project.webapi.controller;

import com.company.project.webapi.support.RequestContext;
import com.company.project.webapi.support.annotation.Api;
import com.company.project.webapi.support.controller.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

import java.util.Map;

@Api("/demo")
public class DemoController extends BaseController<Map> {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoController.class);

    @Value("${params.name}")
    private String name;

    @Autowired
    private Environment env;

    @Override
    public Map<String, Object> processBusiness(Map param, RequestContext ctx) {
        LOGGER.info("name={}", name);
        LOGGER.info("name2={}", env.getProperty("params.name"));
        return null;
    }
}
