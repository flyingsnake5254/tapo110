package b.d.x;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import androidx.annotation.NonNull;
import b.d.p.d;
import com.tplink.libmediakit.jniinterface.DecoderProperty;
import com.tplink.libmediakit.jniinterface.DecoderProperty.a;
import com.tplink.libmediakit.media.display.renderer.YUVBuffer;
import com.tplink.libtpappcommonmedia.bean.stream.StreamMediaData;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

public class c
  implements b, Runnable
{
  private final LinkedBlockingQueue<YUVBuffer> H3 = new LinkedBlockingQueue();
  private final YUVBuffer[] I3 = new YUVBuffer[15];
  private int J3;
  private int K3;
  private int L3;
  private int M3;
  private int N3;
  private int O3;
  private int P3;
  private boolean Q3;
  private a R3;
  private final Map<Long, Long> S3 = new ConcurrentHashMap();
  private final List<Long> T3 = new ArrayList();
  private long U3 = 0L;
  private final DecoderProperty V3 = new DecoderProperty();
  private final String c = c.class.getSimpleName();
  private volatile boolean d = true;
  private volatile boolean f;
  private int p0;
  private MediaCodec p1;
  private final MediaCodec.BufferInfo p2 = new MediaCodec.BufferInfo();
  private final Object p3 = new Object();
  private volatile boolean q;
  private final Object x = new Object();
  private final boolean y;
  private int z;
  
  public c(boolean paramBoolean)
  {
    int i = 0;
    this.f = false;
    this.q = false;
    this.Q3 = true;
    this.y = paramBoolean;
    this.z = 0;
    this.p0 = 0;
    while (i < 15)
    {
      this.I3[i] = new YUVBuffer(i);
      this.H3.offer(this.I3[i]);
      i++;
    }
    new Thread(this, "VideoRenderer").start();
  }
  
  private boolean d(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte[0] == 0) && (paramArrayOfByte[1] == 0) && (paramArrayOfByte[2] == 0) && (paramArrayOfByte[3] == 1) && ((paramArrayOfByte[4] & 0x1F) == 7))
    {
      for (int i = 5; i < paramArrayOfByte.length - 4; i++) {
        if ((paramArrayOfByte[i] == 0) && (paramArrayOfByte[(i + 1)] == 0) && (paramArrayOfByte[(i + 2)] == 0) && (paramArrayOfByte[(i + 3)] == 1) && ((paramArrayOfByte[(i + 4)] & 0x1F) == 8))
        {
          j = i;
          break label105;
        }
      }
      int j = 0;
      i = -1;
      label105:
      if (i == -1)
      {
        d.a(this.c, "ppsStartIndex = -1");
        return false;
      }
      Object localObject1 = new byte[j];
      System.arraycopy(paramArrayOfByte, 0, localObject1, 0, j);
      Object localObject2 = new byte[8];
      System.arraycopy(paramArrayOfByte, i, localObject2, 0, 8);
      if ((this.z <= 0) || (this.p0 <= 0))
      {
        paramArrayOfByte = new DecoderProperty.a();
        this.V3.a((byte[])localObject1, paramArrayOfByte);
        this.z = paramArrayOfByte.b();
        this.p0 = paramArrayOfByte.a();
      }
      paramArrayOfByte = new MediaFormat();
      paramArrayOfByte.setString("mime", "video/avc");
      paramArrayOfByte.setInteger("width", this.z);
      paramArrayOfByte.setInteger("height", this.p0);
      paramArrayOfByte.setByteBuffer("csd-0", ByteBuffer.wrap((byte[])localObject1));
      paramArrayOfByte.setByteBuffer("csd-1", ByteBuffer.wrap((byte[])localObject2));
      if ((!this.Q3) && ((this.z > 1920) || (this.p0 > 1080)))
      {
        paramArrayOfByte.setInteger("width", 1920);
        paramArrayOfByte.setInteger("height", 1080);
        paramArrayOfByte.setByteBuffer("csd-0", ByteBuffer.wrap(DecoderProperty.a));
        paramArrayOfByte.setByteBuffer("csd-1", ByteBuffer.wrap(DecoderProperty.b));
      }
      try
      {
        if (this.Q3)
        {
          this.p1 = MediaCodec.createDecoderByType("video/avc");
        }
        else
        {
          localObject2 = j("video/avc");
          if (localObject2 == null) {
            break label437;
          }
          String str = this.c;
          localObject1 = new java/lang/StringBuilder;
          ((StringBuilder)localObject1).<init>();
          ((StringBuilder)localObject1).append("software decoder ");
          ((StringBuilder)localObject1).append((String)localObject2);
          d.a(str, ((StringBuilder)localObject1).toString());
          this.p1 = MediaCodec.createByCodecName((String)localObject2);
        }
        this.p1.configure(paramArrayOfByte, null, null, 0);
        this.p1.start();
        g(this.Q3);
        return true;
        label437:
        return false;
      }
      catch (Exception localException)
      {
        paramArrayOfByte = this.c;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("decoder config error:");
        ((StringBuilder)localObject2).append(localException.toString());
        d.c(paramArrayOfByte, ((StringBuilder)localObject2).toString());
        this.Q3 ^= true;
      }
    }
    return false;
  }
  
  private void e(StreamMediaData paramStreamMediaData)
  {
    if (paramStreamMediaData == null) {
      return;
    }
    byte[] arrayOfByte = paramStreamMediaData.rawData;
    if ((arrayOfByte != null) && (arrayOfByte.length != 0) && (this.d))
    {
      if (this.q) {
        try
        {
          synchronized (this.x)
          {
            this.x.wait();
          }
          StringBuilder localStringBuilder;
          if (this.f) {
            break label126;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          ??? = this.c;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("reConfigured start ");
          localStringBuilder.append(this.q);
          d.a((String)???, localStringBuilder.toString());
        }
      } else {
        this.f = d(arrayOfByte);
      }
      label126:
      if (this.f) {
        f(paramStreamMediaData);
      }
    }
  }
  
  private void f(StreamMediaData arg1)
  {
    byte[] arrayOfByte = ???.rawData;
    long l1 = ???.ptsUs;
    long l2 = ???.playTimeMs;
    try
    {
      boolean bool;
      do
      {
        int i = this.p1.dequeueInputBuffer(8000L);
        if (i >= 0)
        {
          ??? = h(i);
          ???.clear();
          ???.put(arrayOfByte);
          this.p1.queueInputBuffer(i, 0, arrayOfByte.length, l1, 0);
          i = 1;
        }
        else
        {
          if (i == -1) {
            synchronized (this.p3)
            {
              this.p3.wait(200L);
            }
          }
          i = 0;
        }
        if ((i != 0) && (this.d))
        {
          if ((this.S3.size() > 64) && (this.T3.size() > 64))
          {
            ??? = (Long)this.T3.remove(0);
            if (??? != null) {
              this.S3.remove(???);
            }
          }
          this.S3.put(Long.valueOf(l1), Long.valueOf(l2));
          this.T3.add(Long.valueOf(l1));
          break;
        }
        bool = this.d;
      } while (bool);
    }
    catch (Exception localException)
    {
      String str = this.c;
      ??? = new StringBuilder();
      ???.append("input 视频解码出现异常");
      ???.append(localException.toString());
      d.a(str, ???.toString());
      this.f = false;
      this.q = true;
    }
  }
  
  private void g(boolean paramBoolean)
  {
    String str1;
    if (paramBoolean) {
      str1 = "HWDecoder";
    } else {
      str1 = "SWDecoder";
    }
    String str2 = this.c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("decoderType ");
    localStringBuilder.append(str1);
    d.c(str2, localStringBuilder.toString());
  }
  
  private ByteBuffer h(int paramInt)
  {
    return this.p1.getInputBuffer(paramInt);
  }
  
  private ByteBuffer i(int paramInt)
  {
    return this.p1.getOutputBuffer(paramInt);
  }
  
  private String j(String paramString)
  {
    int i = MediaCodecList.getCodecCount();
    for (int j = 0; j < i; j++)
    {
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(j);
      if (!localMediaCodecInfo.isEncoder())
      {
        String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
        int k = arrayOfString.length;
        for (int m = 0; m < k; m++) {
          if (arrayOfString[m].equals(paramString))
          {
            m = 1;
            break label77;
          }
        }
        m = 0;
        label77:
        if ((m != 0) && (localMediaCodecInfo.getName().startsWith("OMX.google"))) {
          return localMediaCodecInfo.getName();
        }
      }
    }
    return null;
  }
  
  private void k()
  {
    MediaCodec localMediaCodec = this.p1;
    if (localMediaCodec != null) {
      try
      {
        localMediaCodec.stop();
        this.p1.release();
        this.p1 = null;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    this.f = false;
    this.U3 = 0L;
    this.S3.clear();
    this.T3.clear();
  }
  
  private int l(MediaFormat paramMediaFormat, String paramString)
  {
    int i;
    try
    {
      i = paramMediaFormat.getInteger(paramString);
    }
    catch (Exception paramMediaFormat)
    {
      i = -1;
    }
    return i;
  }
  
  private void m(MediaFormat paramMediaFormat)
  {
    this.J3 = l(paramMediaFormat, "color-format");
    this.K3 = l(paramMediaFormat, "width");
    this.L3 = l(paramMediaFormat, "height");
    this.M3 = l(paramMediaFormat, "stride");
    this.N3 = l(paramMediaFormat, "crop-top");
    int i = l(paramMediaFormat, "crop-bottom");
    this.P3 = -1;
    int j = this.N3;
    if ((j != -1) && (i != -1)) {
      this.P3 = (i - j + 1);
    }
    i = l(paramMediaFormat, "crop-left");
    j = l(paramMediaFormat, "crop-right");
    if ((i >= 0) && (j != -1)) {
      this.O3 = (j + 1);
    }
    if (this.M3 <= 0) {
      this.M3 = this.K3;
    }
    if (this.O3 <= 0) {
      this.O3 = this.K3;
    }
    if (this.P3 <= 0) {
      this.P3 = this.L3;
    }
  }
  
  private void n(YUVBuffer paramYUVBuffer)
  {
    this.T3.remove(Long.valueOf(this.p2.presentationTimeUs));
    Object localObject = (Long)this.S3.remove(Long.valueOf(this.p2.presentationTimeUs));
    if (localObject != null) {
      this.U3 = ((Long)localObject).longValue();
    }
    paramYUVBuffer.timestamp = this.U3;
    localObject = this.R3;
    if (localObject != null) {
      ((a)localObject).i(paramYUVBuffer, this.y);
    }
  }
  
  public void a(StreamMediaData paramStreamMediaData)
  {
    e(paramStreamMediaData);
  }
  
  public void b(a parama)
  {
    this.R3 = parama;
  }
  
  public void c(@NonNull YUVBuffer paramYUVBuffer)
  {
    this.H3.offer(paramYUVBuffer);
  }
  
  public void destroy()
  {
    this.d = false;
    this.H3.offer(new YUVBuffer(-1));
    synchronized (this.p3)
    {
      this.p3.notifyAll();
      this.U3 = 0L;
      this.S3.clear();
      this.T3.clear();
      this.R3 = null;
      return;
    }
  }
  
  public void run()
  {
    int i;
    for (;;)
    {
      boolean bool = this.d;
      i = 0;
      if (bool)
      {
        if (this.f) {
          try
          {
            j = this.p1.dequeueOutputBuffer(this.p2, 8000L);
            if (j >= 0)
            {
              if (this.p2.flags == 4)
              {
                this.d = false;
                break;
              }
              ??? = i(j);
              if (??? != null)
              {
                YUVBuffer localYUVBuffer = (YUVBuffer)this.H3.take();
                if (localYUVBuffer.outputIndex < 0) {
                  continue;
                }
                if (localYUVBuffer.initParams(this.J3, this.M3, this.K3, this.L3, this.N3, this.O3, this.P3, this.p2.presentationTimeUs, (ByteBuffer)???)) {
                  n(localYUVBuffer);
                }
              }
              this.p1.releaseOutputBuffer(j, false);
              synchronized (this.p3)
              {
                this.p3.notifyAll();
              }
            }
            if (j == -2)
            {
              localObject4 = this.p1.getOutputFormat();
              m((MediaFormat)localObject4);
              ??? = this.c;
              StringBuilder localStringBuilder = new java/lang/StringBuilder;
              localStringBuilder.<init>();
              localStringBuilder.append("outputFormat ");
              localStringBuilder.append(localObject4);
              d.a((String)???, localStringBuilder.toString());
            }
          }
          catch (Exception localException)
          {
            Object localObject4 = this.c;
            ??? = new StringBuilder();
            ((StringBuilder)???).append("output 视频解码出现异常");
            ((StringBuilder)???).append(localException.toString());
            d.a((String)localObject4, ((StringBuilder)???).toString());
            k();
            this.Q3 = false;
          }
        }
        if (!this.q) {
          continue;
        }
        d.a(this.c, "视频解码出现异常 删除解码器并重新配置");
        k();
        this.Q3 = false;
        synchronized (this.x)
        {
          this.x.notifyAll();
          this.q = false;
        }
      }
    }
    this.H3.clear();
    ??? = this.I3;
    int j = ???.length;
    while (i < j)
    {
      ???[i].release();
      i++;
    }
    k();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\x\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */