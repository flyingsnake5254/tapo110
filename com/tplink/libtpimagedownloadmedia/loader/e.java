package com.tplink.libtpimagedownloadmedia.loader;

import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.data.d.a;
import io.reactivex.e0.c;
import io.reactivex.q;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class e
  implements d<InputStream>, f
{
  private final g c;
  private InputStream d;
  private d.a<? super InputStream> f;
  private volatile boolean q;
  private final ExecutorService x;
  private c y;
  
  public e(g paramg)
  {
    this.c = paramg;
    this.q = false;
    this.x = Executors.newSingleThreadExecutor();
  }
  
  @NonNull
  public Class<InputStream> a()
  {
    return InputStream.class;
  }
  
  public void b()
  {
    try
    {
      InputStream localInputStream = this.d;
      if (localInputStream != null) {
        localInputStream.close();
      }
    }
    catch (IOException localIOException) {}
    Object localObject = this.y;
    if (localObject != null) {
      ((c)localObject).dispose();
    }
    localObject = this.x;
    if (localObject != null) {
      ((ExecutorService)localObject).shutdownNow();
    }
  }
  
  public void c(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      c localc = this.y;
      if (localc != null) {
        localc.dispose();
      }
      this.y = q.f0(paramArrayOfByte).l0(io.reactivex.l0.a.b(this.x)).G0(new a(this));
    }
  }
  
  public void cancel()
  {
    this.q = true;
    b.d.l.a.b().a(this.c);
  }
  
  @NonNull
  public DataSource d()
  {
    return DataSource.REMOTE;
  }
  
  public void e(@NonNull Priority paramPriority, @NonNull d.a<? super InputStream> parama)
  {
    this.f = parama;
    if (this.q) {
      parama.f(null);
    } else {
      b.d.l.a.b().d(this.c, this);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpimagedownloadmedia\loader\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */