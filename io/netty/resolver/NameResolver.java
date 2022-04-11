package io.netty.resolver;

import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.Promise;
import java.io.Closeable;
import java.util.List;

public abstract interface NameResolver<T>
  extends Closeable
{
  public abstract void close();
  
  public abstract Future<T> resolve(String paramString);
  
  public abstract Future<T> resolve(String paramString, Promise<T> paramPromise);
  
  public abstract Future<List<T>> resolveAll(String paramString);
  
  public abstract Future<List<T>> resolveAll(String paramString, Promise<List<T>> paramPromise);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\resolver\NameResolver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */