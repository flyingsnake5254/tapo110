package io.netty.handler.codec.http.multipart;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.util.ReferenceCounted;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public class MixedAttribute
  implements Attribute
{
  private Attribute attribute;
  private String baseDir;
  private boolean deleteOnExit;
  private final long limitSize;
  private long maxSize = -1L;
  
  public MixedAttribute(String paramString, long paramLong)
  {
    this(paramString, paramLong, HttpConstants.DEFAULT_CHARSET);
  }
  
  public MixedAttribute(String paramString, long paramLong1, long paramLong2)
  {
    this(paramString, paramLong1, paramLong2, HttpConstants.DEFAULT_CHARSET);
  }
  
  public MixedAttribute(String paramString, long paramLong1, long paramLong2, Charset paramCharset)
  {
    this(paramString, paramLong1, paramLong2, paramCharset, DiskAttribute.baseDirectory, DiskAttribute.deleteOnExitTemporaryFile);
  }
  
  public MixedAttribute(String paramString1, long paramLong1, long paramLong2, Charset paramCharset, String paramString2, boolean paramBoolean)
  {
    this.limitSize = paramLong2;
    this.attribute = new MemoryAttribute(paramString1, paramLong1, paramCharset);
    this.baseDir = paramString2;
    this.deleteOnExit = paramBoolean;
  }
  
  public MixedAttribute(String paramString, long paramLong, Charset paramCharset)
  {
    this(paramString, paramLong, paramCharset, DiskAttribute.baseDirectory, DiskAttribute.deleteOnExitTemporaryFile);
  }
  
  public MixedAttribute(String paramString1, long paramLong, Charset paramCharset, String paramString2, boolean paramBoolean)
  {
    this.limitSize = paramLong;
    this.attribute = new MemoryAttribute(paramString1, paramCharset);
    this.baseDir = paramString2;
    this.deleteOnExit = paramBoolean;
  }
  
  public MixedAttribute(String paramString1, String paramString2, long paramLong)
  {
    this(paramString1, paramString2, paramLong, HttpConstants.DEFAULT_CHARSET, DiskAttribute.baseDirectory, DiskFileUpload.deleteOnExitTemporaryFile);
  }
  
  public MixedAttribute(String paramString1, String paramString2, long paramLong, Charset paramCharset)
  {
    this(paramString1, paramString2, paramLong, paramCharset, DiskAttribute.baseDirectory, DiskFileUpload.deleteOnExitTemporaryFile);
  }
  
  public MixedAttribute(String paramString1, String paramString2, long paramLong, Charset paramCharset, String paramString3, boolean paramBoolean)
  {
    this.limitSize = paramLong;
    if (paramString2.length() > paramLong) {
      try
      {
        DiskAttribute localDiskAttribute = new io/netty/handler/codec/http/multipart/DiskAttribute;
        localDiskAttribute.<init>(paramString1, paramString2, paramCharset, paramString3, paramBoolean);
        this.attribute = localDiskAttribute;
      }
      catch (IOException localIOException)
      {
        try
        {
          MemoryAttribute localMemoryAttribute2 = new io/netty/handler/codec/http/multipart/MemoryAttribute;
          localMemoryAttribute2.<init>(paramString1, paramString2, paramCharset);
          this.attribute = localMemoryAttribute2;
        }
        catch (IOException paramString1)
        {
          throw new IllegalArgumentException(localIOException);
        }
      }
    }
    try
    {
      MemoryAttribute localMemoryAttribute1 = new io/netty/handler/codec/http/multipart/MemoryAttribute;
      localMemoryAttribute1.<init>(paramString1, paramString2, paramCharset);
      this.attribute = localMemoryAttribute1;
      this.baseDir = paramString3;
      this.deleteOnExit = paramBoolean;
      return;
    }
    catch (IOException paramString1)
    {
      throw new IllegalArgumentException(paramString1);
    }
  }
  
  public void addContent(ByteBuf paramByteBuf, boolean paramBoolean)
    throws IOException
  {
    Object localObject = this.attribute;
    if ((localObject instanceof MemoryAttribute))
    {
      checkSize(((HttpData)localObject).length() + paramByteBuf.readableBytes());
      if (this.attribute.length() + paramByteBuf.readableBytes() > this.limitSize)
      {
        localObject = new DiskAttribute(this.attribute.getName(), this.attribute.definedLength(), this.baseDir, this.deleteOnExit);
        ((AbstractHttpData)localObject).setMaxSize(this.maxSize);
        if (((MemoryAttribute)this.attribute).getByteBuf() != null) {
          ((DiskAttribute)localObject).addContent(((MemoryAttribute)this.attribute).getByteBuf(), false);
        }
        this.attribute = ((Attribute)localObject);
      }
    }
    this.attribute.addContent(paramByteBuf, paramBoolean);
  }
  
  public void checkSize(long paramLong)
    throws IOException
  {
    long l = this.maxSize;
    if ((l >= 0L) && (paramLong > l)) {
      throw new IOException("Size exceed allowed maximum capacity");
    }
  }
  
  public int compareTo(InterfaceHttpData paramInterfaceHttpData)
  {
    return this.attribute.compareTo(paramInterfaceHttpData);
  }
  
  public ByteBuf content()
  {
    return this.attribute.content();
  }
  
  public Attribute copy()
  {
    return this.attribute.copy();
  }
  
  public long definedLength()
  {
    return this.attribute.definedLength();
  }
  
  public void delete()
  {
    this.attribute.delete();
  }
  
  public Attribute duplicate()
  {
    return this.attribute.duplicate();
  }
  
  public boolean equals(Object paramObject)
  {
    return this.attribute.equals(paramObject);
  }
  
  public byte[] get()
    throws IOException
  {
    return this.attribute.get();
  }
  
  public ByteBuf getByteBuf()
    throws IOException
  {
    return this.attribute.getByteBuf();
  }
  
  public Charset getCharset()
  {
    return this.attribute.getCharset();
  }
  
  public ByteBuf getChunk(int paramInt)
    throws IOException
  {
    return this.attribute.getChunk(paramInt);
  }
  
  public File getFile()
    throws IOException
  {
    return this.attribute.getFile();
  }
  
  public InterfaceHttpData.HttpDataType getHttpDataType()
  {
    return this.attribute.getHttpDataType();
  }
  
  public long getMaxSize()
  {
    return this.maxSize;
  }
  
  public String getName()
  {
    return this.attribute.getName();
  }
  
  public String getString()
    throws IOException
  {
    return this.attribute.getString();
  }
  
  public String getString(Charset paramCharset)
    throws IOException
  {
    return this.attribute.getString(paramCharset);
  }
  
  public String getValue()
    throws IOException
  {
    return this.attribute.getValue();
  }
  
  public int hashCode()
  {
    return this.attribute.hashCode();
  }
  
  public boolean isCompleted()
  {
    return this.attribute.isCompleted();
  }
  
  public boolean isInMemory()
  {
    return this.attribute.isInMemory();
  }
  
  public long length()
  {
    return this.attribute.length();
  }
  
  public int refCnt()
  {
    return this.attribute.refCnt();
  }
  
  public boolean release()
  {
    return this.attribute.release();
  }
  
  public boolean release(int paramInt)
  {
    return this.attribute.release(paramInt);
  }
  
  public boolean renameTo(File paramFile)
    throws IOException
  {
    return this.attribute.renameTo(paramFile);
  }
  
  public Attribute replace(ByteBuf paramByteBuf)
  {
    return this.attribute.replace(paramByteBuf);
  }
  
  public Attribute retain()
  {
    this.attribute.retain();
    return this;
  }
  
  public Attribute retain(int paramInt)
  {
    this.attribute.retain(paramInt);
    return this;
  }
  
  public Attribute retainedDuplicate()
  {
    return this.attribute.retainedDuplicate();
  }
  
  public void setCharset(Charset paramCharset)
  {
    this.attribute.setCharset(paramCharset);
  }
  
  public void setContent(ByteBuf paramByteBuf)
    throws IOException
  {
    checkSize(paramByteBuf.readableBytes());
    if ((paramByteBuf.readableBytes() > this.limitSize) && ((this.attribute instanceof MemoryAttribute)))
    {
      DiskAttribute localDiskAttribute = new DiskAttribute(this.attribute.getName(), this.attribute.definedLength(), this.baseDir, this.deleteOnExit);
      this.attribute = localDiskAttribute;
      localDiskAttribute.setMaxSize(this.maxSize);
    }
    this.attribute.setContent(paramByteBuf);
  }
  
  public void setContent(File paramFile)
    throws IOException
  {
    checkSize(paramFile.length());
    if ((paramFile.length() > this.limitSize) && ((this.attribute instanceof MemoryAttribute)))
    {
      DiskAttribute localDiskAttribute = new DiskAttribute(this.attribute.getName(), this.attribute.definedLength(), this.baseDir, this.deleteOnExit);
      this.attribute = localDiskAttribute;
      localDiskAttribute.setMaxSize(this.maxSize);
    }
    this.attribute.setContent(paramFile);
  }
  
  public void setContent(InputStream paramInputStream)
    throws IOException
  {
    if ((this.attribute instanceof MemoryAttribute))
    {
      DiskAttribute localDiskAttribute = new DiskAttribute(this.attribute.getName(), this.attribute.definedLength(), this.baseDir, this.deleteOnExit);
      this.attribute = localDiskAttribute;
      localDiskAttribute.setMaxSize(this.maxSize);
    }
    this.attribute.setContent(paramInputStream);
  }
  
  public void setMaxSize(long paramLong)
  {
    this.maxSize = paramLong;
    this.attribute.setMaxSize(paramLong);
  }
  
  public void setValue(String paramString)
    throws IOException
  {
    if (paramString != null) {
      checkSize(paramString.getBytes().length);
    }
    this.attribute.setValue(paramString);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Mixed: ");
    localStringBuilder.append(this.attribute);
    return localStringBuilder.toString();
  }
  
  public Attribute touch()
  {
    this.attribute.touch();
    return this;
  }
  
  public Attribute touch(Object paramObject)
  {
    this.attribute.touch(paramObject);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\multipart\MixedAttribute.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */