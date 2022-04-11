package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.u;
import com.google.common.base.o;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.zip.GZIPInputStream;

public class s
  extends h
  implements HttpDataSource
{
  private final boolean f;
  private final int g;
  private final int h;
  @Nullable
  private final String i;
  @Nullable
  private final HttpDataSource.b j;
  private final HttpDataSource.b k;
  private final boolean l;
  @Nullable
  private o<String> m;
  @Nullable
  private n n;
  @Nullable
  private HttpURLConnection o;
  @Nullable
  private InputStream p;
  private boolean q;
  private int r;
  private long s;
  private long t;
  
  private s(@Nullable String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, @Nullable HttpDataSource.b paramb, @Nullable o<String> paramo, boolean paramBoolean2)
  {
    super(true);
    this.i = paramString;
    this.g = paramInt1;
    this.h = paramInt2;
    this.f = paramBoolean1;
    this.j = paramb;
    this.m = paramo;
    this.k = new HttpDataSource.b();
    this.l = paramBoolean2;
  }
  
  private void A(long paramLong, n paramn)
    throws IOException
  {
    if (paramLong == 0L) {
      return;
    }
    byte[] arrayOfByte = new byte['က'];
    while (paramLong > 0L)
    {
      int i1 = (int)Math.min(paramLong, 'က');
      i1 = ((InputStream)o0.i(this.p)).read(arrayOfByte, 0, i1);
      if (!Thread.currentThread().isInterrupted())
      {
        if (i1 != -1)
        {
          paramLong -= i1;
          o(i1);
        }
        else
        {
          throw new HttpDataSource.HttpDataSourceException(paramn, 2008, 1);
        }
      }
      else {
        throw new HttpDataSource.HttpDataSourceException(new InterruptedIOException(), paramn, 2000, 1);
      }
    }
  }
  
  private void s()
  {
    HttpURLConnection localHttpURLConnection = this.o;
    if (localHttpURLConnection != null)
    {
      try
      {
        localHttpURLConnection.disconnect();
      }
      catch (Exception localException)
      {
        u.d("DefaultHttpDataSource", "Unexpected error while disconnecting", localException);
      }
      this.o = null;
    }
  }
  
  private URL t(URL paramURL, @Nullable String paramString, n paramn)
    throws HttpDataSource.HttpDataSourceException
  {
    if (paramString != null) {
      try
      {
        Object localObject = new URL(paramURL, paramString);
        paramString = ((URL)localObject).getProtocol();
        if ((!"https".equals(paramString)) && (!"http".equals(paramString)))
        {
          paramURL = String.valueOf(paramString);
          if (paramURL.length() != 0) {
            paramURL = "Unsupported protocol redirect: ".concat(paramURL);
          } else {
            paramURL = new String("Unsupported protocol redirect: ");
          }
          throw new HttpDataSource.HttpDataSourceException(paramURL, paramn, 2001, 1);
        }
        if ((!this.f) && (!paramString.equals(paramURL.getProtocol())))
        {
          localObject = paramURL.getProtocol();
          paramURL = new StringBuilder(String.valueOf(localObject).length() + 41 + paramString.length());
          paramURL.append("Disallowed cross-protocol redirect (");
          paramURL.append((String)localObject);
          paramURL.append(" to ");
          paramURL.append(paramString);
          paramURL.append(")");
          throw new HttpDataSource.HttpDataSourceException(paramURL.toString(), paramn, 2001, 1);
        }
        return (URL)localObject;
      }
      catch (MalformedURLException paramURL)
      {
        throw new HttpDataSource.HttpDataSourceException(paramURL, paramn, 2001, 1);
      }
    }
    throw new HttpDataSource.HttpDataSourceException("Null location redirect", paramn, 2001, 1);
  }
  
  private static boolean u(HttpURLConnection paramHttpURLConnection)
  {
    return "gzip".equalsIgnoreCase(paramHttpURLConnection.getHeaderField("Content-Encoding"));
  }
  
  private HttpURLConnection v(n paramn)
    throws IOException
  {
    URL localURL = new URL(paramn.a.toString());
    int i1 = paramn.c;
    Object localObject = paramn.d;
    long l1 = paramn.g;
    long l2 = paramn.h;
    boolean bool = paramn.d(1);
    if ((!this.f) && (!this.l)) {
      return w(localURL, i1, (byte[])localObject, l1, l2, bool, true, paramn.e);
    }
    int i3;
    for (int i2 = 0;; i2 = i3)
    {
      i3 = i2 + 1;
      if (i2 > 20) {
        break;
      }
      HttpURLConnection localHttpURLConnection = w(localURL, i1, (byte[])localObject, l1, l2, bool, false, paramn.e);
      i2 = localHttpURLConnection.getResponseCode();
      String str = localHttpURLConnection.getHeaderField("Location");
      if (((i1 != 1) && (i1 != 3)) || ((i2 != 300) && (i2 != 301) && (i2 != 302) && (i2 != 303) && (i2 != 307) && (i2 != 308)))
      {
        if ((i1 == 2) && ((i2 == 300) || (i2 == 301) || (i2 == 302) || (i2 == 303)))
        {
          localHttpURLConnection.disconnect();
          if ((this.l) && (i2 == 302)) {
            i2 = 1;
          } else {
            i2 = 0;
          }
          if (i2 == 0)
          {
            localObject = null;
            i1 = 1;
          }
          localURL = t(localURL, str, paramn);
        }
        else
        {
          return localHttpURLConnection;
        }
      }
      else
      {
        localHttpURLConnection.disconnect();
        localURL = t(localURL, str, paramn);
      }
    }
    localObject = new StringBuilder(31);
    ((StringBuilder)localObject).append("Too many redirects: ");
    ((StringBuilder)localObject).append(i3);
    throw new HttpDataSource.HttpDataSourceException(new NoRouteToHostException(((StringBuilder)localObject).toString()), paramn, 2001, 1);
  }
  
  private HttpURLConnection w(URL paramURL, int paramInt, @Nullable byte[] paramArrayOfByte, long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2, Map<String, String> paramMap)
    throws IOException
  {
    HttpURLConnection localHttpURLConnection = y(paramURL);
    localHttpURLConnection.setConnectTimeout(this.g);
    localHttpURLConnection.setReadTimeout(this.h);
    paramURL = new HashMap();
    HttpDataSource.b localb = this.j;
    if (localb != null) {
      paramURL.putAll(localb.a());
    }
    paramURL.putAll(this.k.a());
    paramURL.putAll(paramMap);
    paramMap = paramURL.entrySet().iterator();
    while (paramMap.hasNext())
    {
      paramURL = (Map.Entry)paramMap.next();
      localHttpURLConnection.setRequestProperty((String)paramURL.getKey(), (String)paramURL.getValue());
    }
    paramURL = v.a(paramLong1, paramLong2);
    if (paramURL != null) {
      localHttpURLConnection.setRequestProperty("Range", paramURL);
    }
    paramURL = this.i;
    if (paramURL != null) {
      localHttpURLConnection.setRequestProperty("User-Agent", paramURL);
    }
    if (paramBoolean1) {
      paramURL = "gzip";
    } else {
      paramURL = "identity";
    }
    localHttpURLConnection.setRequestProperty("Accept-Encoding", paramURL);
    localHttpURLConnection.setInstanceFollowRedirects(paramBoolean2);
    if (paramArrayOfByte != null) {
      paramBoolean1 = true;
    } else {
      paramBoolean1 = false;
    }
    localHttpURLConnection.setDoOutput(paramBoolean1);
    localHttpURLConnection.setRequestMethod(n.c(paramInt));
    if (paramArrayOfByte != null)
    {
      localHttpURLConnection.setFixedLengthStreamingMode(paramArrayOfByte.length);
      localHttpURLConnection.connect();
      paramURL = localHttpURLConnection.getOutputStream();
      paramURL.write(paramArrayOfByte);
      paramURL.close();
    }
    else
    {
      localHttpURLConnection.connect();
    }
    return localHttpURLConnection;
  }
  
  private static void x(@Nullable HttpURLConnection paramHttpURLConnection, long paramLong)
  {
    if (paramHttpURLConnection != null)
    {
      int i1 = o0.a;
      if ((i1 < 19) || (i1 > 20)) {}
    }
    try
    {
      paramHttpURLConnection = paramHttpURLConnection.getInputStream();
      if (paramLong == -1L)
      {
        if (paramHttpURLConnection.read() != -1) {}
      }
      else if (paramLong <= 2048L) {
        return;
      }
      Object localObject = paramHttpURLConnection.getClass().getName();
      if (("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream".equals(localObject)) || ("com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream".equals(localObject)))
      {
        localObject = ((Class)g.e(paramHttpURLConnection.getClass().getSuperclass())).getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
        ((Method)localObject).setAccessible(true);
        ((Method)localObject).invoke(paramHttpURLConnection, new Object[0]);
      }
      return;
    }
    catch (Exception paramHttpURLConnection)
    {
      for (;;) {}
    }
  }
  
  private int z(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (paramInt2 == 0) {
      return 0;
    }
    long l1 = this.s;
    int i1 = paramInt2;
    if (l1 != -1L)
    {
      l1 -= this.t;
      if (l1 == 0L) {
        return -1;
      }
      i1 = (int)Math.min(paramInt2, l1);
    }
    paramInt1 = ((InputStream)o0.i(this.p)).read(paramArrayOfByte, paramInt1, i1);
    if (paramInt1 == -1) {
      return -1;
    }
    this.t += paramInt1;
    o(paramInt1);
    return paramInt1;
  }
  
  public void close()
    throws HttpDataSource.HttpDataSourceException
  {
    try
    {
      Object localObject1 = this.p;
      if (localObject1 != null)
      {
        long l1 = this.s;
        long l2 = -1L;
        if (l1 != -1L) {
          l2 = l1 - this.t;
        }
        x(this.o, l2);
        try
        {
          ((InputStream)localObject1).close();
        }
        catch (IOException localIOException)
        {
          localObject1 = new com/google/android/exoplayer2/upstream/HttpDataSource$HttpDataSourceException;
          ((HttpDataSource.HttpDataSourceException)localObject1).<init>(localIOException, (n)o0.i(this.n), 2000, 3);
          throw ((Throwable)localObject1);
        }
      }
      return;
    }
    finally
    {
      this.p = null;
      s();
      if (this.q)
      {
        this.q = false;
        p();
      }
    }
  }
  
  public Map<String, List<String>> d()
  {
    Object localObject = this.o;
    if (localObject == null) {
      localObject = Collections.emptyMap();
    } else {
      localObject = ((HttpURLConnection)localObject).getHeaderFields();
    }
    return (Map<String, List<String>>)localObject;
  }
  
  @Nullable
  public Uri getUri()
  {
    Object localObject = this.o;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = Uri.parse(((HttpURLConnection)localObject).getURL().toString());
    }
    return (Uri)localObject;
  }
  
  public long j(n paramn)
    throws HttpDataSource.HttpDataSourceException
  {
    this.n = paramn;
    long l1 = 0L;
    this.t = 0L;
    this.s = 0L;
    q(paramn);
    try
    {
      Object localObject1 = v(paramn);
      this.o = ((HttpURLConnection)localObject1);
      this.r = ((HttpURLConnection)localObject1).getResponseCode();
      String str = ((HttpURLConnection)localObject1).getResponseMessage();
      int i1 = this.r;
      long l2 = -1L;
      Object localObject3;
      long l3;
      if ((i1 >= 200) && (i1 <= 299))
      {
        str = ((HttpURLConnection)localObject1).getContentType();
        localObject3 = this.m;
        if ((localObject3 != null) && (!((o)localObject3).apply(str)))
        {
          s();
          throw new HttpDataSource.InvalidContentTypeException(str, paramn);
        }
        l3 = l1;
        long l4;
        if (this.r == 200)
        {
          l4 = paramn.g;
          l3 = l1;
          if (l4 != 0L) {
            l3 = l4;
          }
        }
        boolean bool = u((HttpURLConnection)localObject1);
        if (!bool)
        {
          l1 = paramn.h;
          if (l1 != -1L)
          {
            this.s = l1;
          }
          else
          {
            l4 = v.b(((HttpURLConnection)localObject1).getHeaderField("Content-Length"), ((HttpURLConnection)localObject1).getHeaderField("Content-Range"));
            l1 = l2;
            if (l4 != -1L) {
              l1 = l4 - l3;
            }
            this.s = l1;
          }
        }
        else
        {
          this.s = paramn.h;
        }
        try
        {
          this.p = ((HttpURLConnection)localObject1).getInputStream();
          if (bool)
          {
            localObject1 = new java/util/zip/GZIPInputStream;
            ((GZIPInputStream)localObject1).<init>(this.p);
            this.p = ((InputStream)localObject1);
          }
          this.q = true;
          r(paramn);
          try
          {
            A(l3, paramn);
            return this.s;
          }
          catch (IOException localIOException1)
          {
            s();
            if ((localIOException1 instanceof HttpDataSource.HttpDataSourceException)) {
              throw ((HttpDataSource.HttpDataSourceException)localIOException1);
            }
            throw new HttpDataSource.HttpDataSourceException(localIOException1, paramn, 2000, 1);
          }
          localMap = localIOException2.getHeaderFields();
        }
        catch (IOException localIOException2)
        {
          s();
          throw new HttpDataSource.HttpDataSourceException(localIOException2, paramn, 2000, 1);
        }
      }
      Map localMap;
      if (this.r == 416)
      {
        l3 = v.c(localIOException2.getHeaderField("Content-Range"));
        if (paramn.g == l3)
        {
          this.q = true;
          r(paramn);
          l3 = paramn.h;
          if (l3 != -1L) {
            l1 = l3;
          }
          return l1;
        }
      }
      Object localObject2 = localIOException2.getErrorStream();
      if (localObject2 != null) {}
      try
      {
        localObject2 = o0.J0((InputStream)localObject2);
      }
      catch (IOException localIOException3)
      {
        for (;;)
        {
          arrayOfByte = o0.f;
        }
      }
      localObject2 = o0.f;
      byte[] arrayOfByte;
      s();
      if (this.r == 416) {
        localObject3 = new DataSourceException(2008);
      } else {
        localObject3 = null;
      }
      throw new HttpDataSource.InvalidResponseCodeException(this.r, str, (IOException)localObject3, localMap, paramn, arrayOfByte);
    }
    catch (IOException localIOException4)
    {
      s();
      throw HttpDataSource.HttpDataSourceException.createForIOException(localIOException4, paramn, 1);
    }
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws HttpDataSource.HttpDataSourceException
  {
    try
    {
      paramInt1 = z(paramArrayOfByte, paramInt1, paramInt2);
      return paramInt1;
    }
    catch (IOException paramArrayOfByte)
    {
      throw HttpDataSource.HttpDataSourceException.createForIOException(paramArrayOfByte, (n)o0.i(this.n), 2);
    }
  }
  
  @VisibleForTesting
  HttpURLConnection y(URL paramURL)
    throws IOException
  {
    return (HttpURLConnection)paramURL.openConnection();
  }
  
  public static final class b
    implements HttpDataSource.a
  {
    private final HttpDataSource.b a = new HttpDataSource.b();
    @Nullable
    private a0 b;
    @Nullable
    private o<String> c;
    @Nullable
    private String d;
    private int e = 8000;
    private int f = 8000;
    private boolean g;
    private boolean h;
    
    public s b()
    {
      s locals = new s(this.d, this.e, this.f, this.g, this.a, this.c, this.h, null);
      a0 locala0 = this.b;
      if (locala0 != null) {
        locals.b(locala0);
      }
      return locals;
    }
    
    public b c(@Nullable String paramString)
    {
      this.d = paramString;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\upstream\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */