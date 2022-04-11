package okhttp3;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okio.BufferedSink;
import okio.ByteString;
import okio.Okio;
import okio.Source;

public abstract class RequestBody
{
  public static RequestBody create(@Nullable MediaType paramMediaType, final File paramFile)
  {
    Objects.requireNonNull(paramFile, "file == null");
    new RequestBody()
    {
      public long contentLength()
      {
        return paramFile.length();
      }
      
      @Nullable
      public MediaType contentType()
      {
        return RequestBody.this;
      }
      
      public void writeTo(BufferedSink paramAnonymousBufferedSink)
        throws IOException
      {
        Object localObject = null;
        try
        {
          Source localSource = Okio.source(paramFile);
          localObject = localSource;
          paramAnonymousBufferedSink.writeAll(localSource);
          Util.closeQuietly(localSource);
          return;
        }
        finally
        {
          Util.closeQuietly((Closeable)localObject);
        }
      }
    };
  }
  
  public static RequestBody create(@Nullable MediaType paramMediaType, String paramString)
  {
    Charset localCharset = Util.UTF_8;
    Object localObject = localCharset;
    MediaType localMediaType = paramMediaType;
    if (paramMediaType != null)
    {
      localObject = paramMediaType.charset();
      if (localObject == null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramMediaType);
        ((StringBuilder)localObject).append("; charset=utf-8");
        localMediaType = MediaType.parse(((StringBuilder)localObject).toString());
        localObject = localCharset;
      }
      else
      {
        localMediaType = paramMediaType;
      }
    }
    return create(localMediaType, paramString.getBytes((Charset)localObject));
  }
  
  public static RequestBody create(@Nullable MediaType paramMediaType, final ByteString paramByteString)
  {
    new RequestBody()
    {
      public long contentLength()
        throws IOException
      {
        return paramByteString.size();
      }
      
      @Nullable
      public MediaType contentType()
      {
        return RequestBody.this;
      }
      
      public void writeTo(BufferedSink paramAnonymousBufferedSink)
        throws IOException
      {
        paramAnonymousBufferedSink.write(paramByteString);
      }
    };
  }
  
  public static RequestBody create(@Nullable MediaType paramMediaType, byte[] paramArrayOfByte)
  {
    return create(paramMediaType, paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static RequestBody create(@Nullable MediaType paramMediaType, final byte[] paramArrayOfByte, final int paramInt1, final int paramInt2)
  {
    Objects.requireNonNull(paramArrayOfByte, "content == null");
    Util.checkOffsetAndCount(paramArrayOfByte.length, paramInt1, paramInt2);
    new RequestBody()
    {
      public long contentLength()
      {
        return paramInt2;
      }
      
      @Nullable
      public MediaType contentType()
      {
        return RequestBody.this;
      }
      
      public void writeTo(BufferedSink paramAnonymousBufferedSink)
        throws IOException
      {
        paramAnonymousBufferedSink.write(paramArrayOfByte, paramInt1, paramInt2);
      }
    };
  }
  
  public long contentLength()
    throws IOException
  {
    return -1L;
  }
  
  @Nullable
  public abstract MediaType contentType();
  
  public abstract void writeTo(BufferedSink paramBufferedSink)
    throws IOException;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okhttp3\RequestBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */