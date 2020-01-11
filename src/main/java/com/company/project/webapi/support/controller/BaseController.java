package com.company.project.webapi.support.controller;

import com.company.project.webapi.support.RequestContext;
import com.company.project.webapi.support.Results;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public abstract class BaseController<P> implements Controller<P> {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

    @RequestMapping
    public Map<String, Object> doProcess(@RequestBody P param,
                                         HttpServletRequest request,
                                         HttpServletResponse response) {
        Map<String, Object> data;
        try {
            RequestContext ctx = new RequestContext(request, response);
            //
            checkInput(param, ctx);
            //
            data = processBusiness(param, ctx);
        } catch (Exception ex) {
            throw ex;
        }
        return Results.ok(data);
    }
}
