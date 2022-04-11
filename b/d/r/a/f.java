package b.d.r.a;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.util.Log;
import java.io.IOException;
import java.nio.ByteBuffer;

public class f
{
  private String a = f.class.getSimpleName();
  private MediaMuxer b;
  private int c = -1;
  private int d = -1;
  
  public f(String paramString)
  {
    try
    {
      MediaMuxer localMediaMuxer = new android/media/MediaMuxer;
      localMediaMuxer.<init>(paramString, 0);
      this.b = localMediaMuxer;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void f(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo, int paramInt)
  {
    if ((paramBufferInfo.flags & 0x2) != 0)
    {
      paramBufferInfo.size = 0;
    }
    else if (paramBufferInfo.size != 0)
    {
      paramByteBuffer.position(paramBufferInfo.offset);
      paramByteBuffer.limit(paramBufferInfo.offset + paramBufferInfo.size);
      this.b.writeSampleData(paramInt, paramByteBuffer, paramBufferInfo);
      String str = this.a;
      paramByteBuffer = new StringBuilder();
      paramByteBuffer.append("send [%d] [");
      paramByteBuffer.append(paramBufferInfo.size);
      paramByteBuffer.append("] with timestamp:[%d] to muxer");
      Log.d(str, String.format(paramByteBuffer.toString(), new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramBufferInfo.presentationTimeUs) }));
      if ((paramBufferInfo.flags & 0x4) != 0) {
        Log.i(this.a, "BUFFER_FLAG_END_OF_STREAM received");
      }
    }
  }
  
  public void a(MediaFormat paramMediaFormat)
  {
    if (this.d == -1)
    {
      this.d = this.b.addTrack(paramMediaFormat);
      return;
    }
    throw new RuntimeException("already add audio tracks");
  }
  
  public void b(MediaFormat paramMediaFormat)
  {
    if (this.c == -1)
    {
      this.c = this.b.addTrack(paramMediaFormat);
      return;
    }
    throw new RuntimeException("already add video tracks");
  }
  
  public void c()
  {
    this.b.start();
  }
  
  public void d()
  {
    try
    {
      if ((this.b != null) && ((this.c != -1) || (this.d != -1)))
      {
        Log.i(this.a, String.format("muxer is started. now it will be stoped.", new Object[0]));
        try
        {
          this.b.stop();
          this.b.release();
        }
        catch (IllegalStateException localIllegalStateException)
        {
          localIllegalStateException.printStackTrace();
        }
      }
      return;
    }
    finally {}
  }
  
  public void e(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    try
    {
      int i = this.d;
      if (i == -1)
      {
        Log.i(this.a, String.format("pumpStream [%s] but muxer is not start.ignore..", new Object[] { "audio" }));
        return;
      }
      f(paramByteBuffer, paramBufferInfo, i);
      return;
    }
    finally {}
  }
  
  public void g(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    try
    {
      int i = this.c;
      if (i == -1)
      {
        Log.i(this.a, String.format("pumpStream [%s] but muxer is not start.ignore..", new Object[] { "video" }));
        return;
      }
      f(paramByteBuffer, paramBufferInfo, i);
      return;
    }
    finally {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\r\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */