package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.u;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class q
  implements l
{
  private final Context b;
  private final List<a0> c;
  private final l d;
  @Nullable
  private l e;
  @Nullable
  private l f;
  @Nullable
  private l g;
  @Nullable
  private l h;
  @Nullable
  private l i;
  @Nullable
  private l j;
  @Nullable
  private l k;
  @Nullable
  private l l;
  
  public q(Context paramContext, l paraml)
  {
    this.b = paramContext.getApplicationContext();
    this.d = ((l)g.e(paraml));
    this.c = new ArrayList();
  }
  
  private void o(l paraml)
  {
    for (int m = 0; m < this.c.size(); m++) {
      paraml.b((a0)this.c.get(m));
    }
  }
  
  private l p()
  {
    if (this.f == null)
    {
      AssetDataSource localAssetDataSource = new AssetDataSource(this.b);
      this.f = localAssetDataSource;
      o(localAssetDataSource);
    }
    return this.f;
  }
  
  private l q()
  {
    if (this.g == null)
    {
      ContentDataSource localContentDataSource = new ContentDataSource(this.b);
      this.g = localContentDataSource;
      o(localContentDataSource);
    }
    return this.g;
  }
  
  private l r()
  {
    if (this.j == null)
    {
      j localj = new j();
      this.j = localj;
      o(localj);
    }
    return this.j;
  }
  
  private l s()
  {
    if (this.e == null)
    {
      FileDataSource localFileDataSource = new FileDataSource();
      this.e = localFileDataSource;
      o(localFileDataSource);
    }
    return this.e;
  }
  
  private l t()
  {
    if (this.k == null)
    {
      RawResourceDataSource localRawResourceDataSource = new RawResourceDataSource(this.b);
      this.k = localRawResourceDataSource;
      o(localRawResourceDataSource);
    }
    return this.k;
  }
  
  private l u()
  {
    if (this.h == null)
    {
      try
      {
        l locall = (l)Class.forName("com.google.android.exoplayer2.ext.rtmp.RtmpDataSource").getConstructor(new Class[0]).newInstance(new Object[0]);
        this.h = locall;
        o(locall);
      }
      catch (Exception localException)
      {
        throw new RuntimeException("Error instantiating RTMP extension", localException);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        u.h("DefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
      }
      if (this.h == null) {
        this.h = this.d;
      }
    }
    return this.h;
  }
  
  private l v()
  {
    if (this.i == null)
    {
      UdpDataSource localUdpDataSource = new UdpDataSource();
      this.i = localUdpDataSource;
      o(localUdpDataSource);
    }
    return this.i;
  }
  
  private void w(@Nullable l paraml, a0 parama0)
  {
    if (paraml != null) {
      paraml.b(parama0);
    }
  }
  
  public void b(a0 parama0)
  {
    g.e(parama0);
    this.d.b(parama0);
    this.c.add(parama0);
    w(this.e, parama0);
    w(this.f, parama0);
    w(this.g, parama0);
    w(this.h, parama0);
    w(this.i, parama0);
    w(this.j, parama0);
    w(this.k, parama0);
  }
  
  /* Error */
  public void close()
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 161	com/google/android/exoplayer2/upstream/q:l	Lcom/google/android/exoplayer2/upstream/l;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnull +25 -> 31
    //   9: aload_1
    //   10: invokeinterface 163 1 0
    //   15: aload_0
    //   16: aconst_null
    //   17: putfield 161	com/google/android/exoplayer2/upstream/q:l	Lcom/google/android/exoplayer2/upstream/l;
    //   20: goto +11 -> 31
    //   23: astore_1
    //   24: aload_0
    //   25: aconst_null
    //   26: putfield 161	com/google/android/exoplayer2/upstream/q:l	Lcom/google/android/exoplayer2/upstream/l;
    //   29: aload_1
    //   30: athrow
    //   31: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	this	q
    //   4	6	1	locall	l
    //   23	7	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	15	23	finally
  }
  
  public Map<String, List<String>> d()
  {
    Object localObject = this.l;
    if (localObject == null) {
      localObject = Collections.emptyMap();
    } else {
      localObject = ((l)localObject).d();
    }
    return (Map<String, List<String>>)localObject;
  }
  
  @Nullable
  public Uri getUri()
  {
    Object localObject = this.l;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((l)localObject).getUri();
    }
    return (Uri)localObject;
  }
  
  public long j(n paramn)
    throws IOException
  {
    boolean bool;
    if (this.l == null) {
      bool = true;
    } else {
      bool = false;
    }
    g.g(bool);
    String str = paramn.a.getScheme();
    if (o0.m0(paramn.a))
    {
      str = paramn.a.getPath();
      if ((str != null) && (str.startsWith("/android_asset/"))) {
        this.l = p();
      } else {
        this.l = s();
      }
    }
    else if ("asset".equals(str))
    {
      this.l = p();
    }
    else if ("content".equals(str))
    {
      this.l = q();
    }
    else if ("rtmp".equals(str))
    {
      this.l = u();
    }
    else if ("udp".equals(str))
    {
      this.l = v();
    }
    else if ("data".equals(str))
    {
      this.l = r();
    }
    else if ((!"rawresource".equals(str)) && (!"android.resource".equals(str)))
    {
      this.l = this.d;
    }
    else
    {
      this.l = t();
    }
    return this.l.j(paramn);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    return ((l)g.e(this.l)).read(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\upstream\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */