package com.kenba.filter;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;

import org.springframework.stereotype.Component;

import com.kenba.utils.LogUtils;

@Component
public class ResponseFilter implements Filter{
  @Override
  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
	  LogUtils.d("filter", "doFilter");
	  chain.doFilter(req, res);
  }

  @Override
  public void destroy() {}

  @Override
  public void init(FilterConfig arg0) throws ServletException {
	  LogUtils.d("filter", "initFilter");
  }

}