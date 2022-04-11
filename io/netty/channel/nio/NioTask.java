package io.netty.channel.nio;

import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;

public abstract interface NioTask<C extends SelectableChannel>
{
  public abstract void channelReady(C paramC, SelectionKey paramSelectionKey)
    throws Exception;
  
  public abstract void channelUnregistered(C paramC, Throwable paramThrowable)
    throws Exception;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\nio\NioTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */