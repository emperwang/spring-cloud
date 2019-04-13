package com.cloud.parent.microservicediscovereurekaserver;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class MyZuulFilter extends ZuulFilter {
    private static final Logger logger = LoggerFactory.getLogger(MyZuulFilter.class);
    /**
     * 是否使用该过滤器，false表示不适用，true表示使用
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 具体的业务逻辑的实现
     * @return
     */
    @Override
    public Object run() {
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        String host = request.getRemoteHost();
        logger.info("请求的host:{}",host);
        return null;
    }

    /**
     * 什么类型的过滤器pre，post等
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 类似与优先级，数字越大，越是后面调用
     * @return
     */
    @Override
    public int filterOrder() {
        return 1;
    }
}
