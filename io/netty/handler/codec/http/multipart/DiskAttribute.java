package io.netty.handler.codec.http.multipart;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelException;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.ObjectUtil;
import java.io.IOException;
import java.nio.charset.Charset;

public class DiskAttribute
  extends AbstractDiskHttpData
  implements Attribute
{
  public static String baseDirectory;
  public static boolean deleteOnExitTemporaryFile = true;
  public static final String postfix = ".att";
  public static final String prefix = "Attr_";
  private String baseDir;
  private boolean deleteOnExit;
  
  public DiskAttribute(String paramString)
  {
    this(paramString, HttpConstants.DEFAULT_CHARSET);
  }
  
  public DiskAttribute(String paramString, long paramLong)
  {
    this(paramString, paramLong, HttpConstants.DEFAULT_CHARSET, baseDirectory, deleteOnExitTemporaryFile);
  }
  
  public DiskAttribute(String paramString1, long paramLong, String paramString2, boolean paramBoolean)
  {
    this(paramString1, paramLong, HttpConstants.DEFAULT_CHARSET);
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = baseDirectory;
    }
    this.baseDir = paramString1;
    this.deleteOnExit = paramBoolean;
  }
  
  public DiskAttribute(String paramString, long paramLong, Charset paramCharset)
  {
    this(paramString, paramLong, paramCharset, baseDirectory, deleteOnExitTemporaryFile);
  }
  
  public DiskAttribute(String paramString1, long paramLong, Charset paramCharset, String paramString2, boolean paramBoolean)
  {
    super(paramString1, paramCharset, paramLong);
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = baseDirectory;
    }
    this.baseDir = paramString1;
    this.deleteOnExit = paramBoolean;
  }
  
  public DiskAttribute(String paramString1, String paramString2)
    throws IOException
  {
    this(paramString1, paramString2, HttpConstants.DEFAULT_CHARSET);
  }
  
  public DiskAttribute(String paramString1, String paramString2, Charset paramCharset)
    throws IOException
  {
    this(paramString1, paramString2, paramCharset, baseDirectory, deleteOnExitTemporaryFile);
  }
  
  public DiskAttribute(String paramString1, String paramString2, Charset paramCharset, String paramString3, boolean paramBoolean)
    throws IOException
  {
    super(paramString1, paramCharset, 0L);
    setValue(paramString2);
    paramString1 = paramString3;
    if (paramString3 == null) {
      paramString1 = baseDirectory;
    }
    this.baseDir = paramString1;
    this.deleteOnExit = paramBoolean;
  }
  
  public DiskAttribute(String paramString1, String paramString2, boolean paramBoolean)
  {
    this(paramString1, HttpConstants.DEFAULT_CHARSET);
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = baseDirectory;
    }
    this.baseDir = paramString1;
    this.deleteOnExit = paramBoolean;
  }
  
  public DiskAttribute(String paramString, Charset paramCharset)
  {
    this(paramString, paramCharset, baseDirectory, deleteOnExitTemporaryFile);
  }
  
  public DiskAttribute(String paramString1, Charset paramCharset, String paramString2, boolean paramBoolean)
  {
    super(paramString1, paramCharset, 0L);
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = baseDirectory;
    }
    this.baseDir = paramString1;
    this.deleteOnExit = paramBoolean;
  }
  
  public void addContent(ByteBuf paramByteBuf, boolean paramBoolean)
    throws IOException
  {
    long l1 = this.size + paramByteBuf.readableBytes();
    checkSize(l1);
    long l2 = this.definedSize;
    if ((l2 > 0L) && (l2 < l1)) {
      this.definedSize = l1;
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
  
  protected boolean deleteOnExit()
  {
    return this.deleteOnExit;
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
  
  protected String getBaseDirectory()
  {
    return this.baseDir;
  }
  
  protected String getDiskFilename()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getName());
    localStringBuilder.append(".att");
    return localStringBuilder.toString();
  }
  
  public InterfaceHttpData.HttpDataType getHttpDataType()
  {
    return InterfaceHttpData.HttpDataType.Attribute;
  }
  
  protected String getPostfix()
  {
    return ".att";
  }
  
  protected String getPrefix()
  {
    return "Attr_";
  }
  
  public String getValue()
    throws IOException
  {
    return new String(get(), getCharset());
  }
  
  public int hashCode()
  {
    return getName().hashCode();
  }
  
  public Attribute replace(ByteBuf paramByteBuf)
  {
    DiskAttribute localDiskAttribute = new DiskAttribute(getName(), this.baseDir, this.deleteOnExit);
    localDiskAttribute.setCharset(getCharset());
    if (paramByteBuf != null) {
      try
      {
        localDiskAttribute.setContent(paramByteBuf);
      }
      catch (IOException paramByteBuf)
      {
        throw new ChannelException(paramByteBuf);
      }
    }
    return localDiskAttribute;
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
    Object localObject;
    try
    {
      localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>();
      ((StringBuilder)localObject).append(getName());
      ((StringBuilder)localObject).append('=');
      ((StringBuilder)localObject).append(getValue());
      localObject = ((StringBuilder)localObject).toString();
      return (String)localObject;
    }
    catch (IOException localIOException)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(getName());
      ((StringBuilder)localObject).append('=');
      ((StringBuilder)localObject).append(localIOException);
    }
    return ((StringBuilder)localObject).toString();
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\multipart\DiskAttribute.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */