package com.google.android.exoplayer2.upstream;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.o0;
import com.google.common.base.o;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract interface HttpDataSource
  extends l
{
  public static final o<String> a = c.c;
  
  public static final class CleartextNotPermittedException
    extends HttpDataSource.HttpDataSourceException
  {
    public CleartextNotPermittedException(IOException paramIOException, n paramn)
    {
      super(paramIOException, paramn, 2007, 1);
    }
  }
  
  public static class HttpDataSourceException
    extends DataSourceException
  {
    public static final int TYPE_CLOSE = 3;
    public static final int TYPE_OPEN = 1;
    public static final int TYPE_READ = 2;
    public final n dataSpec;
    public final int type;
    
    @Deprecated
    public HttpDataSourceException(n paramn, int paramInt)
    {
      this(paramn, 2000, paramInt);
    }
    
    public HttpDataSourceException(n paramn, int paramInt1, int paramInt2)
    {
      super();
      this.dataSpec = paramn;
      this.type = paramInt2;
    }
    
    @Deprecated
    public HttpDataSourceException(IOException paramIOException, n paramn, int paramInt)
    {
      this(paramIOException, paramn, 2000, paramInt);
    }
    
    public HttpDataSourceException(IOException paramIOException, n paramn, int paramInt1, int paramInt2)
    {
      super(assignErrorCode(paramInt1, paramInt2));
      this.dataSpec = paramn;
      this.type = paramInt2;
    }
    
    @Deprecated
    public HttpDataSourceException(String paramString, n paramn, int paramInt)
    {
      this(paramString, paramn, 2000, paramInt);
    }
    
    public HttpDataSourceException(String paramString, n paramn, int paramInt1, int paramInt2)
    {
      super(assignErrorCode(paramInt1, paramInt2));
      this.dataSpec = paramn;
      this.type = paramInt2;
    }
    
    @Deprecated
    public HttpDataSourceException(String paramString, IOException paramIOException, n paramn, int paramInt)
    {
      this(paramString, paramIOException, paramn, 2000, paramInt);
    }
    
    public HttpDataSourceException(String paramString, @Nullable IOException paramIOException, n paramn, int paramInt1, int paramInt2)
    {
      super(paramIOException, assignErrorCode(paramInt1, paramInt2));
      this.dataSpec = paramn;
      this.type = paramInt2;
    }
    
    private static int assignErrorCode(int paramInt1, int paramInt2)
    {
      int i = paramInt1;
      if (paramInt1 == 2000)
      {
        i = paramInt1;
        if (paramInt2 == 1) {
          i = 2001;
        }
      }
      return i;
    }
    
    public static HttpDataSourceException createForIOException(IOException paramIOException, n paramn, int paramInt)
    {
      String str = paramIOException.getMessage();
      int i;
      if ((paramIOException instanceof SocketTimeoutException)) {
        i = 2002;
      } else if ((paramIOException instanceof InterruptedIOException)) {
        i = 1004;
      } else if ((str != null) && (com.google.common.base.c.e(str).matches("cleartext.*not permitted.*"))) {
        i = 2007;
      } else {
        i = 2001;
      }
      if (i == 2007) {
        paramIOException = new HttpDataSource.CleartextNotPermittedException(paramIOException, paramn);
      } else {
        paramIOException = new HttpDataSourceException(paramIOException, paramn, i, paramInt);
      }
      return paramIOException;
    }
  }
  
  public static final class InvalidContentTypeException
    extends HttpDataSource.HttpDataSourceException
  {
    public final String contentType;
    
    public InvalidContentTypeException(String paramString, n paramn)
    {
      super(paramn, 2003, 1);
      this.contentType = paramString;
    }
  }
  
  public static final class InvalidResponseCodeException
    extends HttpDataSource.HttpDataSourceException
  {
    public final Map<String, List<String>> headerFields;
    public final byte[] responseBody;
    public final int responseCode;
    @Nullable
    public final String responseMessage;
    
    public InvalidResponseCodeException(int paramInt, @Nullable String paramString, @Nullable IOException paramIOException, Map<String, List<String>> paramMap, n paramn, byte[] paramArrayOfByte)
    {
      super(paramIOException, paramn, 2004, 1);
      this.responseCode = paramInt;
      this.responseMessage = paramString;
      this.headerFields = paramMap;
      this.responseBody = paramArrayOfByte;
    }
    
    @Deprecated
    public InvalidResponseCodeException(int paramInt, @Nullable String paramString, Map<String, List<String>> paramMap, n paramn)
    {
      this(paramInt, paramString, null, paramMap, paramn, o0.f);
    }
    
    @Deprecated
    public InvalidResponseCodeException(int paramInt, Map<String, List<String>> paramMap, n paramn)
    {
      this(paramInt, null, null, paramMap, paramn, o0.f);
    }
  }
  
  public static abstract interface a
    extends l.a
  {
    public abstract HttpDataSource a();
  }
  
  public static final class b
  {
    private final Map<String, String> a = new HashMap();
    @Nullable
    private Map<String, String> b;
    
    public Map<String, String> a()
    {
      try
      {
        if (this.b == null)
        {
          localObject1 = new java/util/HashMap;
          ((HashMap)localObject1).<init>(this.a);
          this.b = Collections.unmodifiableMap((Map)localObject1);
        }
        Object localObject1 = this.b;
        return (Map<String, String>)localObject1;
      }
      finally {}
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\upstream\HttpDataSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */