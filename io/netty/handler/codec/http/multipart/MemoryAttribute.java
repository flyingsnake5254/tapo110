package io.netty.handler.codec.http.multipart;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelException;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.ObjectUtil;
import java.io.IOException;
import java.nio.charset.Charset;

public class MemoryAttribute
  extends AbstractMemoryHttpData
  implements Attribute
{
  public MemoryAttribute(String paramString)
  {
    this(paramString, HttpConstants.DEFAULT_CHARSET);
  }
  
  public MemoryAttribute(String paramString, long paramLong)
  {
    this(paramString, paramLong, HttpConstants.DEFAULT_CHARSET);
  }
  
  public MemoryAttribute(String paramString, long paramLong, Charset paramCharset)
  {
    super(paramString, paramCharset, paramLong);
  }
  
  public MemoryAttribute(String paramString1, String paramString2)
    throws IOException
  {
    this(paramString1, paramString2, HttpConstants.DEFAULT_CHARSET);
  }
  
  public MemoryAttribute(String paramString1, String paramString2, Charset paramCharset)
    throws IOException
  {
    super(paramString1, paramCharset, 0L);
    setValue(paramString2);
  }
  
  public MemoryAttribute(String paramString, Charset paramCharset)
  {
    super(paramString, paramCharset, 0L);
  }
  
  public void addContent(ByteBuf paramByteBuf, boolean paramBoolean)
    throws IOException
  {
    int i = paramByteBuf.readableBytes();
    long l1 = this.size;
    long l2 = i;
    checkSize(l1 + l2);
    l1 = this.definedSize;
    if (l1 > 0L)
    {
      long l3 = this.size;
      if (l1 < l3 + l2) {
        this.definedSize = (l3 + l2);
      }
    }
    super.addContent(paramByteBuf, paramBoolean);
  }
  
  public int compareTo(Attribute paramAttribute)
  {
    return getName().compareToIgnoreCase(paramAttribute.getName());
  }
  
  public int compareTo(InterfaceHttpData paramInterfaceHttpData)
  {
    if ((paramInterfaceHttpData instanceof Attribute)) {
      return compareTo((Attribute)paramInterfaceHttpData);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Cannot compare ");
    localStringBuilder.append(getHttpDataType());
    localStringBuilder.append(" with ");
    localStringBuilder.append(paramInterfaceHttpData.getHttpDataType());
    throw new ClassCastException(localStringBuilder.toString());
  }
  
  public Attribute copy()
  {
    ByteBuf localByteBuf = content();
    if (localByteBuf != null) {
      localByteBuf = localByteBuf.copy();
    } else {
      localByteBuf = null;
    }
    return replace(localByteBuf);
  }
  
  public Attribute duplicate()
  {
    ByteBuf localByteBuf = content();
    if (localByteBuf != null) {
      localByteBuf = localByteBuf.duplicate();
    } else {
      localByteBuf = null;
    }
    return replace(localByteBuf);
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Attribute)) {
      return false;
    }
    paramObject = (Attribute)paramObject;
    return getName().equalsIgnoreCase(((InterfaceHttpData)paramObject).getName());
  }
  
  public InterfaceHttpData.HttpDataType getHttpDataType()
  {
    return InterfaceHttpData.HttpDataType.Attribute;
  }
  
  public String getValue()
  {
    return getByteBuf().toString(getCharset());
  }
  
  public int hashCode()
  {
    return getName().hashCode();
  }
  
  public Attribute replace(ByteBuf paramByteBuf)
  {
    MemoryAttribute localMemoryAttribute = new MemoryAttribute(getName());
    localMemoryAttribute.setCharset(getCharset());
    if (paramByteBuf != null) {
      try
      {
        localMemoryAttribute.setContent(paramByteBuf);
      }
      catch (IOException paramByteBuf)
      {
        throw new ChannelException(paramByteBuf);
      }
    }
    return localMemoryAttribute;
  }
  
  public Attribute retain()
  {
    super.retain();
    return this;
  }
  
  public Attribute retain(int paramInt)
  {
    super.retain(paramInt);
    return this;
  }
  
  public Attribute retainedDuplicate()
  {
    ByteBuf localByteBuf = content();
    if (localByteBuf != null)
    {
      localByteBuf = localByteBuf.retainedDuplicate();
      try
      {
        Attribute localAttribute = replace(localByteBuf);
        return localAttribute;
      }
      finally
      {
        localByteBuf.release();
      }
    }
    return replace(null);
  }
  
  public void setValue(String paramString)
    throws IOException
  {
    ObjectUtil.checkNotNull(paramString, "value");
    paramString = paramString.getBytes(getCharset());
    checkSize(paramString.length);
    paramString = Unpooled.wrappedBuffer(paramString);
    if (this.definedSize > 0L) {
      this.definedSize = paramString.readableBytes();
    }
    setContent(paramString);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getName());
    localStringBuilder.append('=');
    localStringBuilder.append(getValue());
    return localStringBuilder.toString();
  }
  
  public Attribute touch()
  {
    super.touch();
    return this;
  }
  
  public Attribute touch(Object paramObject)
  {
    super.touch(paramObject);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\multipart\MemoryAttribute.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */