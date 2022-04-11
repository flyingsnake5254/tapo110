package io.netty.handler.codec.http2;

import io.netty.handler.codec.DefaultHeaders;
import io.netty.handler.codec.DefaultHeaders.NameValidator;
import io.netty.handler.codec.UnsupportedValueConverter;
import io.netty.handler.codec.ValueConverter;
import io.netty.util.HashingStrategy;

public final class CharSequenceMap<V>
  extends DefaultHeaders<CharSequence, V, CharSequenceMap<V>>
{
  public CharSequenceMap()
  {
    this(true);
  }
  
  public CharSequenceMap(boolean paramBoolean)
  {
    this(paramBoolean, UnsupportedValueConverter.instance());
  }
  
  public CharSequenceMap(boolean paramBoolean, ValueConverter<V> paramValueConverter)
  {
    super(localHashingStrategy, paramValueConverter);
  }
  
  public CharSequenceMap(boolean paramBoolean, ValueConverter<V> paramValueConverter, int paramInt)
  {
    super(localHashingStrategy, paramValueConverter, DefaultHeaders.NameValidator.NOT_NULL, paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\CharSequenceMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */