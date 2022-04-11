package io.netty.handler.codec.http.multipart;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelException;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.ObjectUtil;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class DiskFileUpload
  extends AbstractDiskHttpData
  implements FileUpload
{
  public static String baseDirectory;
  public static boolean deleteOnExitTemporaryFile = true;
  public static final String postfix = ".tmp";
  public static final String prefix = "FUp_";
  private final String baseDir;
  private String contentTransferEncoding;
  private String contentType;
  private final boolean deleteOnExit;
  private String filename;
  
  public DiskFileUpload(String paramString1, String paramString2, String paramString3, String paramString4, Charset paramCharset, long paramLong)
  {
    this(paramString1, paramString2, paramString3, paramString4, paramCharset, paramLong, baseDirectory, deleteOnExitTemporaryFile);
  }
  
  public DiskFileUpload(String paramString1, String paramString2, String paramString3, String paramString4, Charset paramCharset, long paramLong, String paramString5, boolean paramBoolean)
  {
    super(paramString1, paramCharset, paramLong);
    setFilename(paramString2);
    setContentType(paramString3);
    setContentTransferEncoding(paramString4);
    paramString1 = paramString5;
    if (paramString5 == null) {
      paramString1 = baseDirectory;
    }
    this.baseDir = paramString1;
    this.deleteOnExit = paramBoolean;
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
    ByteBuf localByteBuf = content();
    if (localByteBuf != null) {
      localByteBuf = localByteBuf.copy();
    } else {
      localByteBuf = null;
    }
    return replace(localByteBuf);
  }
  
  protected boolean deleteOnExit()
  {
    return this.deleteOnExit;
  }
  
  public FileUpload duplicate()
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
    boolean bool;
    if (((paramObject instanceof FileUpload)) && (FileUploadUtil.equals(this, (FileUpload)paramObject))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  protected String getBaseDirectory()
  {
    return this.baseDir;
  }
  
  public String getContentTransferEncoding()
  {
    return this.contentTransferEncoding;
  }
  
  public String getContentType()
  {
    return this.contentType;
  }
  
  protected String getDiskFilename()
  {
    return "upload";
  }
  
  public String getFilename()
  {
    return this.filename;
  }
  
  public InterfaceHttpData.HttpDataType getHttpDataType()
  {
    return InterfaceHttpData.HttpDataType.FileUpload;
  }
  
  protected String getPostfix()
  {
    return ".tmp";
  }
  
  protected String getPrefix()
  {
    return "FUp_";
  }
  
  public int hashCode()
  {
    return FileUploadUtil.hashCode(this);
  }
  
  public FileUpload replace(ByteBuf paramByteBuf)
  {
    DiskFileUpload localDiskFileUpload = new DiskFileUpload(getName(), getFilename(), getContentType(), getContentTransferEncoding(), getCharset(), this.size, this.baseDir, this.deleteOnExit);
    if (paramByteBuf != null) {
      try
      {
        localDiskFileUpload.setContent(paramByteBuf);
      }
      catch (IOException paramByteBuf)
      {
        throw new ChannelException(paramByteBuf);
      }
    }
    return localDiskFileUpload;
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
    String str;
    try
    {
      File localFile = getFile();
    }
    catch (IOException localIOException)
    {
      str = null;
    }
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
    localStringBuilder.append("\r\nRealFile: ");
    if (str != null) {
      str = str.getAbsolutePath();
    } else {
      str = "null";
    }
    localStringBuilder.append(str);
    localStringBuilder.append(" DefaultDeleteAfter: ");
    localStringBuilder.append(deleteOnExitTemporaryFile);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\multipart\DiskFileUpload.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */