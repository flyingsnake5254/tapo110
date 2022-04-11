package b.d.e;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import java.io.IOException;
import java.nio.ByteBuffer;

public class d
{
  private MediaCodec a;
  private final MediaCodec.BufferInfo b = new MediaCodec.BufferInfo();
  private String c = "audio/mpeg";
  private int d;
  boolean e;
  
  public d()
  {
    this.e = false;
    this.d = 4096;
  }
  
  public d(int paramInt)
  {
    this.d = paramInt;
  }
  
  private boolean c(int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      MediaFormat localMediaFormat = MediaFormat.createAudioFormat(this.c, paramInt1, paramInt3);
      localMediaFormat.setInteger("bitrate", paramInt2);
      localMediaFormat.setInteger("max-input-size", this.d);
      MediaCodec localMediaCodec = MediaCodec.createDecoderByType(this.c);
      this.a = localMediaCodec;
      localMediaCodec.configure(localMediaFormat, null, null, 0);
      this.a.start();
      return true;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    return false;
  }
  
  private void d()
  {
    MediaCodec localMediaCodec = this.a;
    if (localMediaCodec != null) {
      try
      {
        localMediaCodec.stop();
        this.a.release();
        this.a = null;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public byte[] a(byte[] paramArrayOfByte)
  {
    Object localObject1 = null;
    if (paramArrayOfByte == null) {
      return null;
    }
    int i = this.a.dequeueInputBuffer(0L);
    Object localObject2;
    if (i >= 0)
    {
      if (Build.VERSION.SDK_INT >= 21) {
        localObject2 = this.a.getInputBuffer(i);
      } else {
        localObject2 = this.a.getInputBuffers()[i];
      }
      if (localObject2 != null)
      {
        ((ByteBuffer)localObject2).clear();
        ((ByteBuffer)localObject2).put(paramArrayOfByte);
      }
      this.a.queueInputBuffer(i, 0, paramArrayOfByte.length, System.nanoTime(), 0);
    }
    i = this.a.dequeueOutputBuffer(this.b, 50L);
    paramArrayOfByte = (byte[])localObject1;
    if (i > 0)
    {
      if (Build.VERSION.SDK_INT >= 21) {
        paramArrayOfByte = this.a.getOutputBuffer(i);
      } else {
        paramArrayOfByte = this.a.getOutputBuffers()[i];
      }
      paramArrayOfByte.position(this.b.offset);
      localObject2 = this.b;
      paramArrayOfByte.limit(((MediaCodec.BufferInfo)localObject2).offset + ((MediaCodec.BufferInfo)localObject2).size);
      int j = this.b.size;
      localObject2 = new byte[j];
      paramArrayOfByte.get((byte[])localObject2, 0, j);
      this.a.releaseOutputBuffer(i, false);
      paramArrayOfByte = (byte[])localObject2;
    }
    return paramArrayOfByte;
  }
  
  public boolean b()
  {
    return this.e;
  }
  
  public boolean e(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = c(paramInt1, paramInt2, paramInt3);
    this.e = bool;
    return bool;
  }
  
  public void f()
  {
    d();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\e\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */