package b.d.r.a;

import androidx.annotation.NonNull;
import com.tplink.libtpappcommonmedia.bean.stream.MediaDataFormat;
import com.tplink.libtpappcommonmedia.bean.stream.StreamMediaData;
import java.util.ArrayList;
import java.util.List;

public class b
{
  private boolean a = false;
  private boolean b = false;
  private long c = 0L;
  private long d = 0L;
  private long e = 0L;
  private long f = 0L;
  private boolean g = false;
  private long h = 0L;
  private long i = 0L;
  private long j = 0L;
  private long k = 0L;
  private int l;
  private final List<StreamMediaData> m = new ArrayList();
  private final Object n = new Object();
  
  public b()
  {
    this.l = 10;
  }
  
  public b(int paramInt)
  {
    this.l = paramInt;
  }
  
  private void b(StreamMediaData paramStreamMediaData)
  {
    int i1 = 0;
    int i3;
    for (int i2 = 0;; i2++)
    {
      i3 = i1;
      if (i2 >= this.m.size()) {
        break;
      }
      StreamMediaData localStreamMediaData = (StreamMediaData)this.m.get(i2);
      if (Math.abs(paramStreamMediaData.ptsUs - localStreamMediaData.ptsUs) > 5965232355L)
      {
        if (paramStreamMediaData.ptsUs <= localStreamMediaData.ptsUs) {
          continue;
        }
        this.m.add(i2, paramStreamMediaData);
      }
      else
      {
        if (paramStreamMediaData.ptsUs >= localStreamMediaData.ptsUs) {
          continue;
        }
        this.m.add(i2, paramStreamMediaData);
      }
      i3 = 1;
      break;
    }
    if (i3 == 0) {
      this.m.add(paramStreamMediaData);
    }
    if (this.m.size() > this.l) {
      this.a = true;
    }
  }
  
  private void d()
  {
    this.m.clear();
    this.a = false;
    this.b = false;
    this.c = 0L;
    this.d = 0L;
    this.e = 0L;
    this.f = 0L;
    this.g = false;
    this.h = 0L;
    this.i = 0L;
    this.j = 0L;
    this.k = 0L;
  }
  
  public void a()
  {
    synchronized (this.n)
    {
      d();
      return;
    }
  }
  
  public void c(@NonNull StreamMediaData paramStreamMediaData)
  {
    synchronized (this.n)
    {
      MediaDataFormat localMediaDataFormat = paramStreamMediaData.format;
      long l1;
      long l2;
      long l3;
      if (localMediaDataFormat == MediaDataFormat.VIDEO_MP2T)
      {
        l1 = Math.abs(paramStreamMediaData.ptsUs - this.f);
        if ((this.f > 0L) && (l1 > 1000000L) && (l1 < 5965232355L)) {
          this.b = true;
        }
        if ((!this.a) && (this.b))
        {
          d();
          return;
        }
        if (this.b)
        {
          this.b = false;
          this.c = (paramStreamMediaData.ptsUs - this.e);
        }
        l1 = paramStreamMediaData.ptsUs;
        this.f = l1;
        l2 = l1 - this.c - this.d;
        paramStreamMediaData.ptsUs = l2;
        l3 = this.e;
        if ((l3 > 0L) && (Math.abs(l2 - l3) > 5965232355L))
        {
          l2 = l1 - this.e;
          this.d = l2;
          paramStreamMediaData.ptsUs = (l1 - this.c - l2);
        }
        this.e = paramStreamMediaData.ptsUs;
        b(paramStreamMediaData);
      }
      else if (localMediaDataFormat == MediaDataFormat.AUDIO_MP2T)
      {
        l1 = Math.abs(paramStreamMediaData.ptsUs - this.k);
        if ((this.k > 0L) && (l1 > 1000000L) && (l1 < 5965232355L)) {
          this.g = true;
        }
        if ((!this.a) && (this.g))
        {
          d();
          return;
        }
        if (this.g)
        {
          this.g = false;
          this.h = (paramStreamMediaData.ptsUs - this.j);
        }
        l1 = paramStreamMediaData.ptsUs;
        this.k = l1;
        l2 = l1 - this.h - this.i;
        paramStreamMediaData.ptsUs = l2;
        l3 = this.j;
        if ((l3 > 0L) && (Math.abs(l2 - l3) > 5965232355L))
        {
          l2 = l1 - this.j;
          this.i = l2;
          paramStreamMediaData.ptsUs = (l1 - this.h - l2);
        }
        this.j = paramStreamMediaData.ptsUs;
        b(paramStreamMediaData);
      }
      return;
    }
  }
  
  public void e(int paramInt)
  {
    synchronized (this.n)
    {
      this.l = (10 / paramInt);
      return;
    }
  }
  
  public int f()
  {
    return this.m.size();
  }
  
  public StreamMediaData g()
  {
    synchronized (this.n)
    {
      int i1;
      if (this.a) {
        i1 = 0;
      } else {
        i1 = this.l;
      }
      if (this.m.size() > i1)
      {
        StreamMediaData localStreamMediaData = (StreamMediaData)this.m.remove(0);
        return localStreamMediaData;
      }
      return null;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\r\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */