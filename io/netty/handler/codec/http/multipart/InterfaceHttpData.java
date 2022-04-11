package io.netty.handler.codec.http.multipart;

import io.netty.util.ReferenceCounted;

public abstract interface InterfaceHttpData
  extends Comparable<InterfaceHttpData>, ReferenceCounted
{
  public abstract HttpDataType getHttpDataType();
  
  public abstract String getName();
  
  public abstract InterfaceHttpData retain();
  
  public abstract InterfaceHttpData retain(int paramInt);
  
  public abstract InterfaceHttpData touch();
  
  public abstract InterfaceHttpData touch(Object paramObject);
  
  public static enum HttpDataType
  {
    static
    {
      HttpDataType localHttpDataType1 = new HttpDataType("Attribute", 0);
      Attribute = localHttpDataType1;
      HttpDataType localHttpDataType2 = new HttpDataType("FileUpload", 1);
      FileUpload = localHttpDataType2;
      HttpDataType localHttpDataType3 = new HttpDataType("InternalAttribute", 2);
      InternalAttribute = localHttpDataType3;
      $VALUES = new HttpDataType[] { localHttpDataType1, localHttpDataType2, localHttpDataType3 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\multipart\InterfaceHttpData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */