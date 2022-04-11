package io.netty.handler.codec.http.multipart;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelException;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.util.AbstractReferenceCounted;
import io.netty.util.internal.ObjectUtil;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractHttpData
  extends AbstractReferenceCounted
  implements HttpData
{
  private static final Pattern REPLACE_PATTERN = Pattern.compile("[\\r\\t]");
  private static final Pattern STRIP_PATTERN = Pattern.compile("(?:^\\s+|\\s+$|\\n)");
  private Charset charset = HttpConstants.DEFAULT_CHARSET;
  private boolean completed;
  protected long definedSize;
  private long maxSize = -1L;
  private final String name;
  protected long size;
  
  protected AbstractHttpData(String paramString, Charset paramCharset, long paramLong)
  {
    ObjectUtil.checkNotNull(paramString, "name");
    paramString = REPLACE_PATTERN.matcher(paramString).replaceAll(" ");
    paramString = STRIP_PATTERN.matcher(paramString).replaceAll("");
    if (!paramString.isEmpty())
    {
      this.name = paramString;
      if (paramCharset != null) {
        setCharset(paramCharset);
      }
      this.definedSize = paramLong;
      return;
    }
    throw new IllegalArgumentException("empty name");
  }
  
  public void checkSize(long paramLong)
    throws IOException
  {
    long l = this.maxSize;
    if ((l >= 0L) && (paramLong > l)) {
      throw new IOException("Size exceed allowed maximum capacity");
    }
  }
  
  public ByteBuf content()
  {
    try
    {
      ByteBuf localByteBuf = getByteBuf();
      return localByteBuf;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException(localIOException);
    }
  }
  
  protected void deallocate()
  {
    delete();
  }
  
  public long definedLength()
  {
    return this.definedSize;
  }
  
  public Charset getCharset()
  {
    return this.charset;
  }
  
  public long getMaxSize()
  {
    return this.maxSize;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public boolean isCompleted()
  {
    return this.completed;
  }
  
  public long length()
  {
    return this.size;
  }
  
  public HttpData retain()
  {
    super.retain();
    return this;
  }
  
  public HttpData retain(int paramInt)
  {
    super.retain(paramInt);
    return this;
  }
  
  public void setCharset(Charset paramCharset)
  {
    this.charset = ((Charset)ObjectUtil.checkNotNull(paramCharset, "charset"));
  }
  
  protected void setCompleted()
  {
    this.completed = true;
  }
  
  public void setMaxSize(long paramLong)
  {
    this.maxSize = paramLong;
  }
  
  public abstract HttpData touch();
  
  public abstract HttpData touch(Object paramObject);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\multipart\AbstractHttpData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */