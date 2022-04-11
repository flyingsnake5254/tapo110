package io.netty.util;

import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.Promise;

public abstract interface AsyncMapping<IN, OUT>
{
  public abstract Future<OUT> map(IN paramIN, Promise<OUT> paramPromise);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\AsyncMapping.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */