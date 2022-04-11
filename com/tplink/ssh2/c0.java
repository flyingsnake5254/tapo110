package com.tplink.ssh2;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.channel.SimpleChannelInboundHandler;

public class c0
  extends SimpleChannelInboundHandler<byte[]>
{
  private w c;
  
  c0(w paramw)
  {
    this.c = paramw;
  }
  
  protected void a(ChannelHandlerContext paramChannelHandlerContext, byte[] paramArrayOfByte)
    throws Exception
  {
    paramChannelHandlerContext = this.c;
    if (paramChannelHandlerContext != null) {
      paramChannelHandlerContext.c(paramArrayOfByte);
    }
  }
  
  public void channelActive(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    paramChannelHandlerContext.fireChannelActive();
  }
  
  public void channelInactive(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    if (this.c != null)
    {
      a0 locala0 = new a0(10);
      this.c.d(locala0, EnumSSH2Status.SSH2_STATUS_DISCONNECTED);
    }
    paramChannelHandlerContext.fireChannelInactive();
  }
  
  public void channelReadComplete(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    paramChannelHandlerContext.fireChannelReadComplete();
  }
  
  public void exceptionCaught(ChannelHandlerContext paramChannelHandlerContext, Throwable paramThrowable)
    throws Exception
  {
    paramChannelHandlerContext.fireExceptionCaught(paramThrowable);
    if (this.c != null)
    {
      a0 locala0 = new a0(9);
      if (paramThrowable != null) {
        locala0.c(paramThrowable.getMessage());
      }
      this.c.d(locala0, EnumSSH2Status.SSH2_STATUS_DISCONNECTED);
    }
    paramChannelHandlerContext.channel().close();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\ssh2\c0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */