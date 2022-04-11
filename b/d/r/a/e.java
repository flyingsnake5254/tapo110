package b.d.r.a;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.util.Log;
import androidx.annotation.NonNull;
import b.d.f.a.a;
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

public class e
  extends b.d.r.a.g.a
  implements a.a, d.a
{
  private static final String d = "e";
  private final MediaCodec.BufferInfo H3 = new MediaCodec.BufferInfo();
  private ByteBuffer I3;
  private MediaFormat J3;
  private MediaFormat K3;
  private boolean L3;
  private long M3;
  private final ExecutorService f;
  private final b.d.f.a p0;
  private final d p1;
  private final c p2;
  private f p3;
  private final LinkedBlockingQueue<StreamMediaData> q;
  private final b x;
  private boolean y = true;
  private b.d.r.a.g.b z;
  
  public e()
  {
    this.c.set(false);
    this.M3 = 0L;
    this.L3 = false;
    this.I3 = ByteBuffer.allocateDirect(524288);
    this.q = new LinkedBlockingQueue();
    this.x = new b(15);
    this.p0 = new b.d.f.a(this);
    this.p1 = new d(this);
    this.p2 = new c();
    this.f = Executors.newSingleThreadExecutor(new a());
  }
  
  private void A(byte[] paramArrayOfByte, long paramLong)
  {
    StreamMediaData localStreamMediaData = new StreamMediaData();
    localStreamMediaData.format = MediaDataFormat.VIDEO_MP2T;
    localStreamMediaData.offset = 0;
    localStreamMediaData.size = paramArrayOfByte.length;
    if ((paramArrayOfByte[4] & 0x1F) == 5) {
      localStreamMediaData.flags = 1;
    } else if (((paramArrayOfByte[4] & 0x1F) != 7) && ((paramArrayOfByte[4] & 0x1F) != 8)) {
      localStreamMediaData.flags = 0;
    } else {
      localStreamMediaData.flags = 2;
    }
    localStreamMediaData.rawData = paramArrayOfByte;
    localStreamMediaData.ptsUs = paramLong;
    this.x.c(localStreamMediaData);
  }
  
  private boolean B(StreamMediaData paramStreamMediaData)
  {
    if ((paramStreamMediaData != null) && (paramStreamMediaData.rawData != null))
    {
      if ((MediaDataFormat.VIDEO_MP2T == paramStreamMediaData.format) && (paramStreamMediaData.isKeyFrame))
      {
        if (!this.p2.g()) {
          this.p2.b(paramStreamMediaData.rawData);
        }
        if ((this.p2.g()) && (this.J3 == null)) {
          this.J3 = this.p2.f();
        }
      }
      return true;
    }
    return false;
  }
  
  private void C(StreamMediaData paramStreamMediaData)
  {
    if ((this.y) && (paramStreamMediaData != null) && (paramStreamMediaData.rawData != null))
    {
      if (!B(paramStreamMediaData)) {
        return;
      }
      if ((!this.c.get()) && (paramStreamMediaData.isKeyFrame)) {
        this.q.clear();
      }
      this.q.offer(paramStreamMediaData);
    }
  }
  
  private void D(boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    label175:
    do
    {
      StreamMediaData localStreamMediaData = this.x.g();
      if (localStreamMediaData != null)
      {
        byte[] arrayOfByte = localStreamMediaData.rawData;
        if (arrayOfByte != null)
        {
          Object localObject = this.H3;
          ((MediaCodec.BufferInfo)localObject).size = localStreamMediaData.size;
          ((MediaCodec.BufferInfo)localObject).flags = localStreamMediaData.flags;
          ((MediaCodec.BufferInfo)localObject).offset = localStreamMediaData.offset;
          ((MediaCodec.BufferInfo)localObject).presentationTimeUs = localStreamMediaData.ptsUs;
          localObject = this.I3;
          if ((localObject == null) || (arrayOfByte.length > ((ByteBuffer)localObject).capacity())) {
            this.I3 = ByteBuffer.allocateDirect(localStreamMediaData.rawData.length);
          }
          this.I3.clear();
          this.I3.put(localStreamMediaData.rawData);
          if (localStreamMediaData.format == MediaDataFormat.VIDEO_MP2T)
          {
            G(this.H3, this.I3, localStreamMediaData.ptsUs);
            paramBoolean = bool;
            break label175;
          }
          F(this.H3, this.I3, localStreamMediaData.ptsUs);
          paramBoolean = bool;
          break label175;
        }
      }
      paramBoolean = false;
      bool = paramBoolean;
    } while (paramBoolean);
  }
  
  private void E()
  {
    if (this.L3) {
      return;
    }
    MediaFormat localMediaFormat = this.J3;
    if ((localMediaFormat != null) && (this.K3 != null))
    {
      this.p3.b(localMediaFormat);
      this.p3.a(this.K3);
      this.p3.c();
      this.L3 = true;
    }
  }
  
  private void F(MediaCodec.BufferInfo paramBufferInfo, ByteBuffer paramByteBuffer, long paramLong)
  {
    f localf = this.p3;
    if ((localf != null) && (this.L3))
    {
      if (this.M3 <= 0L) {
        this.M3 = paramLong;
      }
      paramLong -= this.M3;
      paramBufferInfo.presentationTimeUs = paramLong;
      if (paramLong < 0L) {
        return;
      }
      localf.e(paramByteBuffer, paramBufferInfo);
    }
  }
  
  private void G(MediaCodec.BufferInfo paramBufferInfo, ByteBuffer paramByteBuffer, long paramLong)
  {
    if ((this.p3 != null) && (this.L3))
    {
      if (this.M3 <= 0L) {
        this.M3 = paramLong;
      }
      paramLong -= this.M3;
      paramBufferInfo.presentationTimeUs = paramLong;
      if (paramLong < 0L) {
        return;
      }
      b.d.r.a.g.b localb = this.z;
      if (localb != null) {
        localb.recordProgress(paramLong / 1000L);
      }
      this.p3.g(paramByteBuffer, paramBufferInfo);
    }
  }
  
  private void z(MediaCodec.BufferInfo paramBufferInfo, ByteBuffer paramByteBuffer, long paramLong)
  {
    if ((paramBufferInfo.flags & 0x2) != 0) {
      return;
    }
    StreamMediaData localStreamMediaData = new StreamMediaData();
    localStreamMediaData.format = MediaDataFormat.AUDIO_MP2T;
    localStreamMediaData.offset = 0;
    int i = paramBufferInfo.size;
    localStreamMediaData.size = i;
    localStreamMediaData.flags = paramBufferInfo.flags;
    paramBufferInfo = new byte[i];
    localStreamMediaData.rawData = paramBufferInfo;
    paramByteBuffer.get(paramBufferInfo);
    localStreamMediaData.ptsUs = paramLong;
    this.x.c(localStreamMediaData);
  }
  
  public void a(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo, long paramLong)
  {
    E();
    z(paramBufferInfo, paramByteBuffer, paramLong);
  }
  
  public void b(MediaFormat paramMediaFormat)
  {
    if (this.K3 == null) {
      this.K3 = paramMediaFormat;
    }
    E();
  }
  
  public void c(byte[] paramArrayOfByte, long paramLong)
  {
    E();
    A(paramArrayOfByte, paramLong);
  }
  
  public void d()
  {
    this.y = false;
    this.q.clear();
    this.x.a();
    this.I3 = null;
  }
  
  public void e(StreamMediaData paramStreamMediaData)
  {
    C(paramStreamMediaData);
  }
  
  public void f(b.d.r.a.g.b paramb)
  {
    this.z = paramb;
  }
  
  public void g()
  {
    this.c.set(true);
    this.f.submit(new b(null));
  }
  
  public void h()
  {
    this.c.set(false);
    this.q.offer(new StreamMediaData());
    this.p2.c();
  }
  
  class a
    implements ThreadFactory
  {
    private final AtomicInteger c = new AtomicInteger(0);
    
    a() {}
    
    public Thread newThread(@NonNull Runnable paramRunnable)
    {
      Thread localThread = new Thread(paramRunnable);
      paramRunnable = new StringBuilder();
      paramRunnable.append("pool-MP4Encoder.encoderService-");
      paramRunnable.append(this.c.incrementAndGet());
      localThread.setName(paramRunnable.toString());
      return localThread;
    }
  }
  
  private class b
    implements Runnable
  {
    private b() {}
    
    public void run()
    {
      if (!e.i(e.this).d()) {
        e.i(e.this).g(8000, 32000, 1);
      }
      if (!e.i(e.this).d())
      {
        if (e.q(e.this) != null) {
          e.q(e.this).c(-1, null, null);
        }
        e.this.h();
        return;
      }
      e.r(e.this).a();
      if (e.q(e.this) != null) {
        e.q(e.this).recordProgress(0L);
      }
      long l1 = b.d.d.f.a.g();
      if (l1 < 0L)
      {
        if (e.q(e.this) != null) {
          e.q(e.this).c(-3200002, null, null);
        }
        e.this.h();
        return;
      }
      String str1 = String.valueOf(System.currentTimeMillis());
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(b.d.d.f.a.c());
      ((StringBuilder)localObject1).append(File.separator);
      ((StringBuilder)localObject1).append(str1);
      ((StringBuilder)localObject1).append(".mp4");
      String str2 = ((StringBuilder)localObject1).toString();
      e.t(e.this, new f(str2));
      e.u(e.this, 0L);
      e.v(e.this, false);
      int i = 0;
      label663:
      while (e.w(e.this).get())
      {
        StringBuilder localStringBuilder;
        try
        {
          localObject1 = (StreamMediaData)e.x(e.this).take();
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
          localStringBuilder = null;
        }
        long l2;
        int j;
        if (localStringBuilder == null)
        {
          l2 = l1;
          j = i;
        }
        else
        {
          byte[] arrayOfByte = localStringBuilder.rawData;
          long l3 = localStringBuilder.ptsUs;
          l2 = l1;
          j = i;
          if (arrayOfByte != null) {
            if (arrayOfByte.length == 0)
            {
              l2 = l1;
              j = i;
            }
            else
            {
              Object localObject2 = localStringBuilder.format;
              boolean bool = localStringBuilder.isKeyFrame;
              j = i;
              if (i == 0)
              {
                j = i;
                if (bool) {
                  j = 1;
                }
              }
              if (j == 0)
              {
                i = j;
                break label663;
              }
              if (MediaDataFormat.VIDEO_MP2T == localObject2)
              {
                if ((bool) && (!e.y(e.this).g())) {
                  e.y(e.this).b(arrayOfByte);
                }
                if ((e.y(e.this).g()) && (e.j(e.this) == null))
                {
                  localObject2 = e.this;
                  e.k((e)localObject2, e.y((e)localObject2).f());
                }
                e.l(e.this);
                e.m(e.this).a(arrayOfByte, l3);
                l2 = localStringBuilder.duration;
                if (l2 > 500L) {
                  localStringBuilder.duration = 70L;
                } else if (l2 < 0L) {
                  localStringBuilder.duration = 0L;
                }
              }
              else if (MediaDataFormat.AUDIO_MP2T == localObject2)
              {
                try
                {
                  e.i(e.this).a(arrayOfByte, l3);
                }
                catch (Exception localException)
                {
                  localException.printStackTrace();
                  String str3 = e.n();
                  localStringBuilder = new StringBuilder();
                  localStringBuilder.append("e ");
                  localStringBuilder.append(localException.toString());
                  Log.e(str3, localStringBuilder.toString());
                }
              }
              l1 -= arrayOfByte.length;
              e.o(e.this, false);
              l2 = l1;
              if (l1 < 0L)
              {
                e.p(e.this).set(false);
                i = -3200003;
                break label669;
              }
            }
          }
        }
        i = j;
        l1 = l2;
      }
      i = 0;
      label669:
      e.o(e.this, true);
      if (e.s(e.this) != null)
      {
        e.s(e.this).d();
        e.v(e.this, false);
      }
      else
      {
        i = -1;
      }
      e.i(e.this).h();
      if (i == -3200003)
      {
        if (e.q(e.this) != null) {
          e.q(e.this).c(i, str1, str2);
        }
        return;
      }
      if (i == 0)
      {
        if (e.q(e.this) != null) {
          e.q(e.this).a(str1, str2);
        }
      }
      else
      {
        b.d.d.f.a.d(str2);
        if (e.q(e.this) != null) {
          e.q(e.this).c(-1, null, null);
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\r\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */