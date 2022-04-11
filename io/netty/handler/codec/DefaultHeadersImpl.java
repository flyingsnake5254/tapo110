package io.netty.handler.codec;

import io.netty.util.HashingStrategy;

public final class DefaultHeadersImpl<K, V>
  extends DefaultHeaders<K, V, DefaultHeadersImpl<K, V>>
{
  public DefaultHeadersImpl(HashingStrategy<K> paramHashingStrategy, ValueConverter<V> paramValueConverter, DefaultHeaders.NameValidator<K> paramNameValidator)
  {
    super(paramHashingStrategy, paramValueConverter, paramNameValidator);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\DefaultHeadersImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */