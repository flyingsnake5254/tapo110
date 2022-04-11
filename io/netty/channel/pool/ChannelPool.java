package io.netty.channel.pool;

import io.netty.channel.Channel;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.Promise;
import java.io.Closeable;

public abstract interface ChannelPool
  extends Closeable
{
  public abstract Future<Channel> acquire();
  
  public abstract Future<Channel> acquire(Promise<Channel> paramPromise);
  
  public abstract void close();
  
  public abstract Future<Void> release(Channel paramChannel);
  
  public abstract Future<Void> release(Channel paramChannel, Promise<Void> paramPromise);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\pool\ChannelPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */