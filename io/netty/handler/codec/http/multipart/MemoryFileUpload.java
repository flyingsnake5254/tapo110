package io.netty.handler.codec.http.multipart;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelException;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.ObjectUtil;
import java.io.IOException;
import java.nio.charset.Charset;

public class MemoryFileUpload
  extends AbstractMemoryHttpData
  implements FileUpload
{
  private String contentTransferEncoding;
  private String contentType;
  private String filename;
  
  public MemoryFileUpload(String paramString1, String paramString2, String paramString3, String paramString4, Charset paramCharset, long paramLong)
  {
    super(paramString1, paramCharset, paramLong);
    setFilename(paramString2);
    setContentType(paramString3);
    setContentTransferEncoding(paramString4);
  }
  
  public int compareTo(FileUpload paramFileUpload)
  {
    return FileUploadUtil.compareTo(this, paramFileUpload);
  }
  
  public int compareTo(InterfaceHttpData paramInterfaceHttpData)
  {
    if ((paramInterfaceHttpData instanceof FileUpload)) {
      return compareTo((FileUpload)paramInterfaceHttpData);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Cannot compare ");
    localStringBuilder.append(getHttpDataType());
    localStringBuilder.append(" with ");
    localStringBuilder.append(paramInterfaceHttpData.getHttpDataType());
    throw new ClassCastException(localStringBuilder.toString());
  }
  
  public FileUpload copy()
  {
    ByteBuf localByteBuf1 = content();
    ByteBuf localByteBuf2 = localByteBuf1;
    if (localByteBuf1 != null) {
      localByteBuf2 = localByteBuf1.copy();
    }
    return replace(localByteBuf2);
  }
  
  public FileUpload duplicate()
  {
    ByteBuf localByteBuf1 = content();
    ByteBuf localByteBuf2 = localByteBuf1;
    if (localByteBuf1 != null) {
      localByteBuf2 = localByteBuf1.duplicate();
    }
    return replace(localByteBuf2);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool;
    if (((paramObject instanceof FileUpload)) && (FileUploadUtil.equals(this, (FileUpload)paramObject))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public String getContentTransferEncoding()
  {
    return this.contentTransferEncoding;
  }
  
  public String getContentType()
  {
    return this.contentType;
  }
  
  public String getFilename()
  {
    return this.filename;
  }
  
  public InterfaceHttpData.HttpDataType getHttpDataType()
  {
    return InterfaceHttpData.HttpDataType.FileUpload;
  }
  
  public int hashCode()
  {
    return FileUploadUtil.hashCode(this);
  }
  
  public FileUpload replace(ByteBuf paramByteBuf)
  {
    MemoryFileUpload localMemoryFileUpload = new MemoryFileUpload(getName(), getFilename(), getContentType(), getContentTransferEncoding(), getCharset(), this.size);
    if (paramByteBuf != null) {
      try
      {
        localMemoryFileUpload.setContent(paramByteBuf);
        return localMemoryFileUpload;
      }
      catch (IOException paramByteBuf)
      {
        throw new ChannelException(paramByteBuf);
      }
    }
    return localMemoryFileUpload;
  }
  
  public FileUpload retain()
  {
    super.retain();
    return this;
  }
  
  public FileUpload retain(int paramInt)
  {
    super.retain(paramInt);
    return this;
  }
  
  public FileUpload retainedDuplicate()
  {
    ByteBuf localByteBuf = content();
    if (localByteBuf != null)
    {
      localByteBuf = localByteBuf.retainedDuplicate();
      try
      {
        FileUpload localFileUpload = replace(localByteBuf);
        return localFileUpload;
      }
      finally
      {
        localByteBuf.release();
      }
    }
    return replace(null);
  }
  
  public void setContentTransferEncoding(String paramString)
  {
    this.contentTransferEncoding = paramString;
  }
  
  public void setContentType(String paramString)
  {
    this.contentType = ((String)ObjectUtil.checkNotNull(paramString, "contentType"));
  }
  
  public void setFilename(String paramString)
  {
    this.filename = ((String)ObjectUtil.checkNotNull(paramString, "filename"));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HttpHeaderNames.CONTENT_DISPOSITION);
    localStringBuilder.append(": ");
    localStringBuilder.append(HttpHeaderValues.FORM_DATA);
    localStringBuilder.append("; ");
    localStringBuilder.append(HttpHeaderValues.NAME);
    localStringBuilder.append("=\"");
    localStringBuilder.append(getName());
    localStringBuilder.append("\"; ");
    localStringBuilder.append(HttpHeaderValues.FILENAME);
    localStringBuilder.append("=\"");
    localStringBuilder.append(this.filename);
    localStringBuilder.append("\"\r\n");
    localStringBuilder.append(HttpHeaderNames.CONTENT_TYPE);
    localStringBuilder.append(": ");
    localStringBuilder.append(this.contentType);
    Charset localCharset = getCharset();
    Object localObject = "\r\n";
    if (localCharset != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("; ");
      ((StringBuilder)localObject).append(HttpHeaderValues.CHARSET);
      ((StringBuilder)localObject).append('=');
      ((StringBuilder)localObject).append(getCharset().name());
      ((StringBuilder)localObject).append("\r\n");
      localObject = ((StringBuilder)localObject).toString();
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(HttpHeaderNames.CONTENT_LENGTH);
    localStringBuilder.append(": ");
    localStringBuilder.append(length());
    localStringBuilder.append("\r\nCompleted: ");
    localStringBuilder.append(isCompleted());
    localStringBuilder.append("\r\nIsInMemory: ");
    localStringBuilder.append(isInMemory());
    return localStringBuilder.toString();
  }
  
  public FileUpload touch()
  {
    super.touch();
    return this;
  }
  
  public FileUpload touch(Object paramObject)
  {
    super.touch(paramObject);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\multipart\MemoryFileUpload.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */