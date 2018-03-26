package cn.thinkinjava.provider;

import cn.thinkinjava.netty.NettyServer;

public class ServerBootstrap {

  public static void main(String[] args) {
    NettyServer.startServer("localhost", 8088);

  }

}
