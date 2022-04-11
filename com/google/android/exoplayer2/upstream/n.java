package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.g;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class n
{
  public final Uri a;
  public final long b;
  public final int c;
  @Nullable
  public final byte[] d;
  public final Map<String, String> e;
  @Deprecated
  public final long f;
  public final long g;
  public final long h;
  @Nullable
  public final String i;
  public final int j;
  @Nullable
  public final Object k;
  
  public n(Uri paramUri)
  {
    this(paramUri, 0L, -1L);
  }
  
  private n(Uri paramUri, long paramLong1, int paramInt1, @Nullable byte[] paramArrayOfByte, Map<String, String> paramMap, long paramLong2, long paramLong3, @Nullable String paramString, int paramInt2, @Nullable Object paramObject)
  {
    long l = paramLong1 + paramLong2;
    boolean bool1 = true;
    if (l >= 0L) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    g.a(bool2);
    if (paramLong2 >= 0L) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    g.a(bool2);
    boolean bool2 = bool1;
    if (paramLong3 <= 0L) {
      if (paramLong3 == -1L) {
        bool2 = bool1;
      } else {
        bool2 = false;
      }
    }
    g.a(bool2);
    this.a = paramUri;
    this.b = paramLong1;
    this.c = paramInt1;
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      paramArrayOfByte = null;
    }
    this.d = paramArrayOfByte;
    this.e = Collections.unmodifiableMap(new HashMap(paramMap));
    this.g = paramLong2;
    this.f = l;
    this.h = paramLong3;
    this.i = paramString;
    this.j = paramInt2;
    this.k = paramObject;
  }
  
  public n(Uri paramUri, long paramLong1, long paramLong2)
  {
    this(paramUri, 0L, 1, null, Collections.emptyMap(), paramLong1, paramLong2, null, 0, null);
  }
  
  public static String c(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt == 3) {
          return "HEAD";
        }
        throw new IllegalStateException();
      }
      return "POST";
    }
    return "GET";
  }
  
  public b a()
  {
    return new b(this, null);
  }
  
  public final String b()
  {
    return c(this.c);
  }
  
  public boolean d(int paramInt)
  {
    boolean bool;
    if ((this.j & paramInt) == paramInt) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public n e(long paramLong)
  {
    long l1 = this.h;
    long l2 = -1L;
    if (l1 != -1L) {
      l2 = l1 - paramLong;
    }
    return f(paramLong, l2);
  }
  
  public n f(long paramLong1, long paramLong2)
  {
    if ((paramLong1 == 0L) && (this.h == paramLong2)) {
      return this;
    }
    return new n(this.a, this.b, this.c, this.d, this.e, this.g + paramLong1, paramLong2, this.i, this.j, this.k);
  }
  
  public String toString()
  {
    String str1 = b();
    String str2 = String.valueOf(this.a);
    long l1 = this.g;
    long l2 = this.h;
    String str3 = this.i;
    int m = this.j;
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str1).length() + 70 + str2.length() + String.valueOf(str3).length());
    localStringBuilder.append("DataSpec[");
    localStringBuilder.append(str1);
    localStringBuilder.append(" ");
    localStringBuilder.append(str2);
    localStringBuilder.append(", ");
    localStringBuilder.append(l1);
    localStringBuilder.append(", ");
    localStringBuilder.append(l2);
    localStringBuilder.append(", ");
    localStringBuilder.append(str3);
    localStringBuilder.append(", ");
    localStringBuilder.append(m);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public static final class b
  {
    @Nullable
    private Uri a;
    private long b;
    private int c;
    @Nullable
    private byte[] d;
    private Map<String, String> e;
    private long f;
    private long g;
    @Nullable
    private String h;
    private int i;
    @Nullable
    private Object j;
    
    public b()
    {
      this.c = 1;
      this.e = Collections.emptyMap();
      this.g = -1L;
    }
    
    private b(n paramn)
    {
      this.a = paramn.a;
      this.b = paramn.b;
      this.c = paramn.c;
      this.d = paramn.d;
      this.e = paramn.e;
      this.f = paramn.g;
      this.g = paramn.h;
      this.h = paramn.i;
      this.i = paramn.j;
      this.j = paramn.k;
    }
    
    public n a()
    {
      g.j(this.a, "The uri must be set.");
      return new n(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, null);
    }
    
    public b b(int paramInt)
    {
      this.i = paramInt;
      return this;
    }
    
    public b c(@Nullable byte[] paramArrayOfByte)
    {
      this.d = paramArrayOfByte;
      return this;
    }
    
    public b d(int paramInt)
    {
      this.c = paramInt;
      return this;
    }
    
    public b e(Map<String, String> paramMap)
    {
      this.e = paramMap;
      return this;
    }
    
    public b f(@Nullable String paramString)
    {
      this.h = paramString;
      return this;
    }
    
    public b g(long paramLong)
    {
      this.g = paramLong;
      return this;
    }
    
    public b h(long paramLong)
    {
      this.f = paramLong;
      return this;
    }
    
    public b i(Uri paramUri)
    {
      this.a = paramUri;
      return this;
    }
    
    public b j(String paramString)
    {
      this.a = Uri.parse(paramString);
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\upstream\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */