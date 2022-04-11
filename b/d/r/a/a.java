package b.d.r.a;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import androidx.annotation.NonNull;
import b.d.r.a.g.b;
import com.tplink.libtpappcommonmedia.bean.stream.MediaDataFormat;
import com.tplink.libtpappcommonmedia.bean.stream.StreamMediaData;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class a
  extends b.d.r.a.g.a
  implements d.a
{
  private long H3;
  private final MediaCodec.BufferInfo I3 = new MediaCodec.BufferInfo();
  private final ExecutorService d;
  private final LinkedBlockingQueue<StreamMediaData> f;
  private final c p0;
  private MediaFormat p1;
  private long p2;
  private boolean p3;
  private boolean q = true;
  private b x;
  private final d y;
  private f z;
  
  public a()
  {
    this.c.set(false);
    this.p2 = 0L;
    this.f = new LinkedBlockingQueue();
    this.y = new d(this);
    this.p0 = new c();
    this.d = Executors.newSingleThreadExecutor(new a());
  }
  
  private boolean A(StreamMediaData paramStreamMediaData)
  {
    if ((paramStreamMediaData != null) && (paramStreamMediaData.rawData != null))
    {
      if ((MediaDataFormat.VIDEO_MP2T == paramStreamMediaData.format) && (paramStreamMediaData.isKeyFrame))
      {
        if (!this.p0.g()) {
          this.p0.b(paramStreamMediaData.rawData);
        }
        if ((this.p0.g()) && (this.p1 == null)) {
          this.p1 = this.p0.f();
        }
      }
      return true;
    }
    return false;
  }
  
  private void B(StreamMediaData paramStreamMediaData)
  {
    if ((this.q) && (paramStreamMediaData != null) && (paramStreamMediaData.rawData != null))
    {
      if (!A(paramStreamMediaData)) {
        return;
      }
      if ((!this.c.get()) && (paramStreamMediaData.isKeyFrame)) {
        this.f.clear();
      }
      this.f.offer(paramStreamMediaData);
    }
  }
  
  private void C()
  {
    if (this.p3) {
      return;
    }
    MediaFormat localMediaFormat = this.p1;
    if (localMediaFormat != null)
    {
      this.z.b(localMediaFormat);
      this.z.c();
      this.p3 = true;
    }
  }
  
  private void y(byte[] paramArrayOfByte, long paramLong)
  {
    if (this.z == null) {
      return;
    }
    Object localObject = this.I3;
    ((MediaCodec.BufferInfo)localObject).offset = 0;
    int i = paramArrayOfByte.length;
    ((MediaCodec.BufferInfo)localObject).size = i;
    if ((paramArrayOfByte[4] & 0x1F) == 5) {
      ((MediaCodec.BufferInfo)localObject).flags = 1;
    } else if (((paramArrayOfByte[4] & 0x1F) != 7) && ((paramArrayOfByte[4] & 0x1F) != 8)) {
      ((MediaCodec.BufferInfo)localObject).flags = 0;
    } else {
      ((MediaCodec.BufferInfo)localObject).flags = 2;
    }
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte, 0, i);
    if (this.H3 == 0L) {
      this.H3 = paramLong;
    }
    localObject = this.I3;
    paramLong -= this.H3;
    ((MediaCodec.BufferInfo)localObject).presentationTimeUs = paramLong;
    localObject = this.x;
    if (localObject != null) {
      ((b)localObject).recordProgress(paramLong / 1000L);
    }
    this.z.g(paramArrayOfByte, this.I3);
  }
  
  private void z() {}
  
  public void c(byte[] paramArrayOfByte, long paramLong)
  {
    C();
    if (this.p3) {
      y(paramArrayOfByte, paramLong);
    }
  }
  
  public void d()
  {
    this.q = true;
    LinkedBlockingQueue localLinkedBlockingQueue = this.f;
    if (localLinkedBlockingQueue != null) {
      localLinkedBlockingQueue.clear();
    }
    z();
  }
  
  public void e(StreamMediaData paramStreamMediaData)
  {
    B(paramStreamMediaData);
  }
  
  public void f(b paramb)
  {
    this.x = paramb;
  }
  
  public void g()
  {
    this.c.set(true);
    z();
    this.d.submit(new b(null));
  }
  
  public void h()
  {
    this.c.set(false);
    this.f.offer(new StreamMediaData());
    this.p0.c();
  }
  
  class a
    implements ThreadFactory
  {
    private final AtomicInteger c = new AtomicInteger(0);
    
    a() {}
    
    public Thread newThread(@NonNull Runnable paramRunnable)
    {
      paramRunnable = new Thread(paramRunnable);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pool-MP4Encoder.executorService-");
      localStringBuilder.append(this.c.incrementAndGet());
      paramRunnable.setName(localStringBuilder.toString());
      return paramRunnable;
    }
  }
  
  private class b
    implements Runnable
  {
    private b() {}
    
    public void run()
    {
      if (a.i(a.this) != null) {
        a.i(a.this).recordProgress(0L);
      }
      long l1 = b.d.d.f.a.g();
      if (l1 < 0L)
      {
        if (a.i(a.this) != null) {
          a.i(a.this).c(-3200002, null, null);
        }
        a.this.h();
        return;
      }
      String str1 = String.valueOf(System.currentTimeMillis());
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(b.d.d.f.a.c());
      ((StringBuilder)localObject1).append(File.separator);
      ((StringBuilder)localObject1).append(str1);
      ((StringBuilder)localObject1).append(".mp4");
      String str2 = ((StringBuilder)localObject1).toString();
      a.n(a.this, new f(str2));
      a.o(a.this, 0L);
      a.p(a.this, false);
      a.r(a.this, 0L);
      while (a.t(a.this).get())
      {
        Object localObject2;
        try
        {
          localObject1 = (StreamMediaData)a.u(a.this).take();
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
          localObject2 = null;
        }
        long l2;
        if (localObject2 == null)
        {
          l2 = l1;
        }
        else
        {
          byte[] arrayOfByte = ((StreamMediaData)localObject2).rawData;
          long l3 = ((StreamMediaData)localObject2).duration;
          l2 = l1;
          if (arrayOfByte != null) {
            if (arrayOfByte.length == 0)
            {
              l2 = l1;
            }
            else
            {
              Object localObject3 = ((StreamMediaData)localObject2).format;
              boolean bool = ((StreamMediaData)localObject2).isKeyFrame;
              if (MediaDataFormat.VIDEO_MP2T == localObject3)
              {
                if ((bool) && (!a.v(a.this).g())) {
                  a.v(a.this).b(arrayOfByte);
                }
                if ((a.v(a.this).g()) && (a.w(a.this) == null))
                {
                  localObject3 = a.this;
                  a.x((a)localObject3, a.v((a)localObject3).f());
                }
                if (a.q(a.this) == 0L) {
                  a.r(a.this, l3 * 1000L);
                } else {
                  a.s(a.this, ((StreamMediaData)localObject2).duration * 1000L);
                }
                a.j(a.this);
                a.k(a.this).a(arrayOfByte, a.q(a.this));
                l2 = ((StreamMediaData)localObject2).duration;
                if (l2 > 500L) {
                  ((StreamMediaData)localObject2).duration = 70L;
                } else if (l2 < 0L) {
                  ((StreamMediaData)localObject2).duration = 0L;
                }
              }
              else if (MediaDataFormat.AUDIO_MP2T == localObject3)
              {
                return;
              }
              l1 -= arrayOfByte.length;
              l2 = l1;
              if (l1 < 0L)
              {
                a.l(a.this).set(false);
                i = -3200003;
                break label515;
              }
            }
          }
        }
        l1 = l2;
      }
      int i = 0;
      label515:
      if (a.m(a.this) != null)
      {
        a.m(a.this).d();
        a.p(a.this, false);
      }
      else
      {
        i = -1;
      }
      if (i == -3200003)
      {
        if (a.i(a.this) != null) {
          a.i(a.this).c(i, str1, str2);
        }
        return;
      }
      if (i == 0)
      {
        if (a.i(a.this) != null) {
          a.i(a.this).a(str1, str2);
        }
      }
      else
      {
        b.d.d.f.a.d(str2);
        if (a.i(a.this) != null) {
          a.i(a.this).c(-1, null, null);
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\r\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */