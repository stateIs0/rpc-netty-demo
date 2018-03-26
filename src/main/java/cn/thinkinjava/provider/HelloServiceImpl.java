package cn.thinkinjava.provider;

import cn.thinkinjava.publicInterface.HelloService;

/**
 * 实现类
 */
public class HelloServiceImpl implements HelloService {

  @Override
  public String hello(String msg) {
    return msg != null ? msg + " -----> I am fine." : "I am fine.";
  }
}
