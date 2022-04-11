package io.netty.resolver;

import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.Promise;
import java.io.Closeable;
import java.net.SocketAddress;
import java.util.List;

public abstract interface AddressResolver<T extends SocketAddress>
  extends Closeable
{
  public abstract void close();
  
  public abstract boolean isResolved(SocketAddress paramSocketAddress);
  
  public abstract boolean isSupported(SocketAddress paramSocketAddress);
  
  public abstract Future<T> resolve(SocketAddress paramSocketAddress);
  
  public abstract Future<T> resolve(SocketAddress paramSocketAddress, Promise<T> paramPromise);
  
  public abstract Future<List<T>> resolveAll(SocketAddress paramSocketAddress);
  
  public abstract Future<List<T>> resolveAll(SocketAddress paramSocketAddress, Promise<List<T>> paramPromise);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\resolver\AddressResolver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */