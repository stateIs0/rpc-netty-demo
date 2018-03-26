package cn.thinkinjava.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import java.util.concurrent.Callable;

public class ClientHandler extends ChannelInboundHandlerAdapter implements Callable {

  private ChannelHandlerContext context;

  private String result;

  private String para;

  /**
   * 与服务器的连接已经及建立之后将被调用
   * @param ctx
   */
  @Override
  public void channelActive(ChannelHandlerContext ctx) {
    context = ctx;
  }

  /**
   * 收到服务端数据，唤醒等待线程
   */
  @Override
  public synchronized void channelRead(ChannelHandlerContext ctx, Object msg) {
    result = msg.toString();
    notify();
  }

  /**
   * 写出数据，开始等待唤醒
   */
  @Override
  public synchronized Object call() throws InterruptedException {
    context.writeAndFlush(para);
    wait();
    return result;
  }

  void setPara(String para) {
    this.para = para;
  }
}
