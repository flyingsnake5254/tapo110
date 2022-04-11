package io.netty.handler.codec.http.multipart;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.AbstractReferenceCounted;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.ObjectUtil;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class InternalAttribute
  extends AbstractReferenceCounted
  implements InterfaceHttpData
{
  private final Charset charset;
  private int size;
  private final List<ByteBuf> value = new ArrayList();
  
  InternalAttribute(Charset paramCharset)
  {
    this.charset = paramCharset;
  }
  
  public void addValue(String paramString)
  {
    ObjectUtil.checkNotNull(paramString, "value");
    paramString = Unpooled.copiedBuffer(paramString, this.charset);
    this.value.add(paramString);
    this.size += paramString.readableBytes();
  }
  
  public void addValue(String paramString, int paramInt)
  {
    ObjectUtil.checkNotNull(paramString, "value");
    paramString = Unpooled.copiedBuffer(paramString, this.charset);
    this.value.add(paramInt, paramString);
    this.size += paramString.readableBytes();
  }
  
  public int compareTo(InterfaceHttpData paramInterfaceHttpData)
  {
    if ((paramInterfaceHttpData instanceof InternalAttribute)) {
      return compareTo((InternalAttribute)paramInterfaceHttpData);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Cannot compare ");
    localStringBuilder.append(getHttpDataType());
    localStringBuilder.append(" with ");
    localStringBuilder.append(paramInterfaceHttpData.getHttpDataType());
    throw new ClassCastException(localStringBuilder.toString());
  }
  
  public int compareTo(InternalAttribute paramInternalAttribute)
  {
    return getName().compareToIgnoreCase(paramInternalAttribute.getName());
  }
  
  protected void deallocate() {}
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof InternalAttribute)) {
      return false;
    }
    paramObject = (InternalAttribute)paramObject;
    return getName().equalsIgnoreCase(((InternalAttribute)paramObject).getName());
  }
  
  public InterfaceHttpData.HttpDataType getHttpDataType()
  {
    return InterfaceHttpData.HttpDataType.InternalAttribute;
  }
  
  public String getName()
  {
    return "InternalAttribute";
  }
  
  public int hashCode()
  {
    return getName().hashCode();
  }
  
  public InterfaceHttpData retain()
  {
    Iterator localIterator = this.value.iterator();
    while (localIterator.hasNext()) {
      ((ByteBuf)localIterator.next()).retain();
    }
    return this;
  }
  
  public InterfaceHttpData retain(int paramInt)
  {
    Iterator localIterator = this.value.iterator();
    while (localIterator.hasNext()) {
      ((ByteBuf)localIterator.next()).retain(paramInt);
    }
    return this;
  }
  
  public void setValue(String paramString, int paramInt)
  {
    ObjectUtil.checkNotNull(paramString, "value");
    paramString = Unpooled.copiedBuffer(paramString, this.charset);
    ByteBuf localByteBuf = (ByteBuf)this.value.set(paramInt, paramString);
    if (localByteBuf != null)
    {
      this.size -= localByteBuf.readableBytes();
      localByteBuf.release();
    }
    this.size += paramString.readableBytes();
  }
  
  public int size()
  {
    return this.size;
  }
  
  public ByteBuf toByteBuf()
  {
    return Unpooled.compositeBuffer().addComponents(this.value).writerIndex(size()).readerIndex(0);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.value.iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append(((ByteBuf)localIterator.next()).toString(this.charset));
    }
    return localStringBuilder.toString();
  }
  
  public InterfaceHttpData touch()
  {
    Iterator localIterator = this.value.iterator();
    while (localIterator.hasNext()) {
      ((ByteBuf)localIterator.next()).touch();
    }
    return this;
  }
  
  public InterfaceHttpData touch(Object paramObject)
  {
    Iterator localIterator = this.value.iterator();
    while (localIterator.hasNext()) {
      ((ByteBuf)localIterator.next()).touch(paramObject);
    }
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\multipart\InternalAttribute.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */