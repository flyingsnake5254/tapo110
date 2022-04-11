package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Objects;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;

public abstract class ResponseBody
  implements Closeable
{
  @Nullable
  private Reader reader;
  
  private Charset charset()
  {
    Object localObject = contentType();
    if (localObject != null) {
      localObject = ((MediaType)localObject).charset(Util.UTF_8);
    } else {
      localObject = Util.UTF_8;
    }
    return (Charset)localObject;
  }
  
  public static ResponseBody create(@Nullable MediaType paramMediaType, final long paramLong, BufferedSource paramBufferedSource)
  {
    Objects.requireNonNull(paramBufferedSource, "source == null");
    new ResponseBody()
    {
      public long contentLength()
      {
        return paramLong;
      }
      
      @Nullable
      public MediaType contentType()
      {
        return ResponseBody.this;
      }
      
      public BufferedSource source()
      {
        return this.val$content;
      }
    };
  }
  
  public static ResponseBody create(@Nullable MediaType paramMediaType, String paramString)
  {
    Charset localCharset1 = Util.UTF_8;
    Charset localCharset2 = localCharset1;
    Object localObject = paramMediaType;
    if (paramMediaType != null)
    {
      localCharset2 = paramMediaType.charset();
      if (localCharset2 == null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramMediaType);
        ((StringBuilder)localObject).append("; charset=utf-8");
        localObject = MediaType.parse(((StringBuilder)localObject).toString());
        localCharset2 = localCharset1;
      }
      else
      {
        localObject = paramMediaType;
      }
    }
    paramMediaType = new Buffer().writeString(paramString, localCharset2);
    return create((MediaType)localObject, paramMediaType.size(), paramMediaType);
  }
  
  public static ResponseBody create(@Nullable MediaType paramMediaType, ByteString paramByteString)
  {
    Buffer localBuffer = new Buffer().write(paramByteString);
    return create(paramMediaType, paramByteString.size(), localBuffer);
  }
  
  public static ResponseBody create(@Nullable MediaType paramMediaType, byte[] paramArrayOfByte)
  {
    Buffer localBuffer = new Buffer().write(paramArrayOfByte);
    return create(paramMediaType, paramArrayOfByte.length, localBuffer);
  }
  
  public final InputStream byteStream()
  {
    return source().inputStream();
  }
  
  public final byte[] bytes()
    throws IOException
  {
    long l = contentLength();
    if (l <= 2147483647L)
    {
      Object localObject1 = source();
      try
      {
        byte[] arrayOfByte = ((BufferedSource)localObject1).readByteArray();
        Util.closeQuietly((Closeable)localObject1);
        if ((l != -1L) && (l != arrayOfByte.length))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("Content-Length (");
          ((StringBuilder)localObject1).append(l);
          ((StringBuilder)localObject1).append(") and stream length (");
          ((StringBuilder)localObject1).append(arrayOfByte.length);
          ((StringBuilder)localObject1).append(") disagree");
          throw new IOException(((StringBuilder)localObject1).toString());
        }
        return arrayOfByte;
      }
      finally
      {
        Util.closeQuietly((Closeable)localObject1);
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Cannot buffer entire body for content length: ");
    localStringBuilder.append(l);
    throw new IOException(localStringBuilder.toString());
  }
  
  public final Reader charStream()
  {
    Object localObject = this.reader;
    if (localObject == null)
    {
      localObject = new BomAwareReader(source(), charset());
      this.reader = ((Reader)localObject);
    }
    return (Reader)localObject;
  }
  
  public void close()
  {
    Util.closeQuietly(source());
  }
  
  public abstract long contentLength();
  
  @Nullable
  public abstract MediaType contentType();
  
  public abstract BufferedSource source();
  
  public final String string()
    throws IOException
  {
    BufferedSource localBufferedSource = source();
    try
    {
      String str = localBufferedSource.readString(Util.bomAwareCharset(localBufferedSource, charset()));
      return str;
    }
    finally
    {
      Util.closeQuietly(localBufferedSource);
    }
  }
  
  static final class BomAwareReader
    extends Reader
  {
    private final Charset charset;
    private boolean closed;
    @Nullable
    private Reader delegate;
    private final BufferedSource source;
    
    BomAwareReader(BufferedSource paramBufferedSource, Charset paramCharset)
    {
      this.source = paramBufferedSource;
      this.charset = paramCharset;
    }
    
    public void close()
      throws IOException
    {
      this.closed = true;
      Reader localReader = this.delegate;
      if (localReader != null) {
        localReader.close();
      } else {
        this.source.close();
      }
    }
    
    public int read(char[] paramArrayOfChar, int paramInt1, int paramInt2)
      throws IOException
    {
      if (!this.closed)
      {
        Reader localReader = this.delegate;
        Object localObject = localReader;
        if (localReader == null)
        {
          localObject = Util.bomAwareCharset(this.source, this.charset);
          localObject = new InputStreamReader(this.source.inputStream(), (Charset)localObject);
          this.delegate = ((Reader)localObject);
        }
        return ((Reader)localObject).read(paramArrayOfChar, paramInt1, paramInt2);
      }
      throw new IOException("Stream closed");
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okhttp3\ResponseBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */