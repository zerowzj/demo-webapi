package com.company.project.webapi.support.controller;

import com.company.project.webapi.support.RequestContext;

import java.util.Map;

public interface Controller<P> {

    default void checkInput(P param, RequestContext ctx) {
    }

    Map<String, Object> processBusiness(P param, RequestContext ctx);
}
