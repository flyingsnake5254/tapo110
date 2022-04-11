package b.d.f;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.text.TextUtils;
import b.d.p.b;
import java.io.IOException;
import java.nio.ByteBuffer;

public class a
{
  private final String a = "audio/mp4a-latm";
  private final int b = 1;
  private final int c = 8000;
  private final int d = 16000;
  private final int e = 2;
  private final int f = 8192;
  private final int g = 2;
  private MediaCodec h;
  private boolean i = false;
  private int j = 8000;
  private int k = 16000;
  private int l = 1;
  private a m;
  private long n = 0L;
  
  public a(a parama)
  {
    this.m = parama;
  }
  
  private void b()
  {
    Object localObject = this.h;
    if (localObject == null) {
      return;
    }
    int i1 = ((MediaCodec)localObject).dequeueInputBuffer(100L);
    if (i1 >= 0)
    {
      if (b.a()) {
        localObject = this.h.getInputBuffer(i1);
      } else {
        localObject = this.h.getInputBuffers()[i1];
      }
      ((ByteBuffer)localObject).clear();
      this.h.queueInputBuffer(i1, 0, 0, 0L, 4);
    }
    localObject = new MediaCodec.BufferInfo();
    for (int i2 = this.h.dequeueOutputBuffer((MediaCodec.BufferInfo)localObject, 8000L); i2 >= 0; i2 = this.h.dequeueOutputBuffer((MediaCodec.BufferInfo)localObject, 8000L))
    {
      if (b.b()) {
        this.h.getOutputBuffer(i2);
      } else {
        ByteBuffer localByteBuffer = this.h.getInputBuffers()[i1];
      }
      this.h.releaseOutputBuffer(i2, false);
    }
  }
  
  private String c(int paramInt1, int paramInt2)
  {
    if (b.b()) {
      return new MediaCodecList(0).findEncoderForFormat(MediaFormat.createAudioFormat("audio/mp4a-latm", paramInt1, paramInt2));
    }
    Object localObject1 = null;
    paramInt1 = 0;
    Object localObject2;
    for (;;)
    {
      localObject2 = localObject1;
      if (paramInt1 >= MediaCodecList.getCodecCount()) {
        break;
      }
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(paramInt1);
      String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
      int i1 = arrayOfString.length;
      for (paramInt2 = 0;; paramInt2++)
      {
        localObject2 = localObject1;
        if (paramInt2 >= i1) {
          break;
        }
        if ((TextUtils.equals(arrayOfString[paramInt2], "audio/mp4a-latm")) && (localMediaCodecInfo.isEncoder()))
        {
          localObject2 = localMediaCodecInfo.getName();
          break;
        }
      }
      if (localObject2 != null) {
        break;
      }
      paramInt1++;
      localObject1 = localObject2;
    }
    return (String)localObject2;
  }
  
  @TargetApi(16)
  private boolean e(int paramInt1, int paramInt2, int paramInt3)
  {
    this.j = paramInt1;
    this.k = paramInt2;
    this.l = paramInt3;
    Object localObject = c(paramInt1, paramInt3);
    try
    {
      this.h = MediaCodec.createByCodecName((String)localObject);
      localObject = MediaFormat.createAudioFormat("audio/mp4a-latm", this.j, this.l);
      ((MediaFormat)localObject).setString("mime", "audio/mp4a-latm");
      ((MediaFormat)localObject).setInteger("bitrate", this.k);
      ((MediaFormat)localObject).setInteger("aac-profile", 2);
      ((MediaFormat)localObject).setInteger("max-input-size", 8192);
      ((MediaFormat)localObject).setInteger("pcm-encoding", 2);
      this.h.configure((MediaFormat)localObject, null, null, 1);
      this.h.start();
      return true;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    return false;
  }
  
  private void f()
  {
    MediaCodec localMediaCodec = this.h;
    if (localMediaCodec != null) {
      try
      {
        localMediaCodec.stop();
        this.h.release();
        this.h = null;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void a(byte[] paramArrayOfByte, long paramLong)
  {
    if (this.i)
    {
      Object localObject = this.h;
      if (localObject != null)
      {
        if (this.n == 0L) {
          this.n = paramLong;
        }
        int i1 = ((MediaCodec)localObject).dequeueInputBuffer(8000L);
        if (i1 >= 0)
        {
          if (b.a()) {
            localObject = this.h.getInputBuffer(i1);
          } else {
            localObject = this.h.getInputBuffers()[i1];
          }
          ((ByteBuffer)localObject).clear();
          ((ByteBuffer)localObject).put(paramArrayOfByte);
          this.h.queueInputBuffer(i1, 0, paramArrayOfByte.length, paramLong - this.n, 0);
        }
        localObject = new MediaCodec.BufferInfo();
        for (int i2 = this.h.dequeueOutputBuffer((MediaCodec.BufferInfo)localObject, 8000L); i2 >= 0; i2 = this.h.dequeueOutputBuffer((MediaCodec.BufferInfo)localObject, 8000L))
        {
          if (b.a()) {
            paramArrayOfByte = this.h.getOutputBuffer(i2);
          } else {
            paramArrayOfByte = this.h.getInputBuffers()[i1];
          }
          a locala = this.m;
          if (locala != null) {
            locala.a(paramArrayOfByte, (MediaCodec.BufferInfo)localObject, this.n + ((MediaCodec.BufferInfo)localObject).presentationTimeUs);
          }
          this.h.releaseOutputBuffer(i2, false);
        }
        if (i2 == -2)
        {
          paramArrayOfByte = this.m;
          if (paramArrayOfByte != null) {
            paramArrayOfByte.b(this.h.getOutputFormat());
          }
        }
      }
    }
  }
  
  public boolean d()
  {
    return this.i;
  }
  
  public boolean g(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = e(paramInt1, paramInt2, paramInt3);
    this.i = bool;
    return bool;
  }
  
  public void h()
  {
    this.i = false;
    this.n = 0L;
    b();
    f();
  }
  
  public static abstract interface a
  {
    public abstract void a(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo, long paramLong);
    
    public abstract void b(MediaFormat paramMediaFormat);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\f\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */