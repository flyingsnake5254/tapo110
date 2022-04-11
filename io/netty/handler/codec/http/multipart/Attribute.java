package io.netty.handler.codec.http.multipart;

import io.netty.buffer.ByteBuf;
import java.io.IOException;

public abstract interface Attribute
  extends HttpData
{
  public abstract Attribute copy();
  
  public abstract Attribute duplicate();
  
  public abstract String getValue()
    throws IOException;
  
  public abstract Attribute replace(ByteBuf paramByteBuf);
  
  public abstract Attribute retain();
  
  public abstract Attribute retain(int paramInt);
  
  public abstract Attribute retainedDuplicate();
  
  public abstract void setValue(String paramString)
    throws IOException;
  
  public abstract Attribute touch();
  
  public abstract Attribute touch(Object paramObject);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\multipart\Attribute.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */