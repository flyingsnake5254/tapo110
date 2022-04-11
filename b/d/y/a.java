package b.d.y;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.util.Log;
import b.d.r.a.d.a;
import b.d.r.a.f;
import com.tplink.libtpappcommonmedia.bean.stream.MediaDataFormat;
import com.tplink.libtpdemux.tsdemux.common.b;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

public final class a
  implements b.d.j.a.a.a, d.a, b.d.f.a.a
{
  private MediaFormat H3;
  private MediaFormat I3;
  private long J3;
  private int K3 = -1;
  private int L3 = -1;
  private int M3 = -1;
  private final String c = a.class.getSimpleName();
  private final int d = 188;
  private final ArrayList<a> f = new ArrayList();
  private final b.d.r.a.d p0 = new b.d.r.a.d(this);
  private b.d.f.a p1;
  private f p2;
  private boolean p3;
  private b.d.e.d q;
  private b.d.d.m.e x = new b.d.d.m.e();
  private final MediaCodec.BufferInfo y = new MediaCodec.BufferInfo();
  private final b.d.r.a.c z = new b.d.r.a.c();
  
  private final void f(MediaCodec.BufferInfo paramBufferInfo, ByteBuffer paramByteBuffer, long paramLong)
  {
    f localf = this.p2;
    if (localf == null) {
      return;
    }
    paramBufferInfo.presentationTimeUs = (paramLong - this.J3);
    if (localf != null) {
      localf.e(paramByteBuffer, paramBufferInfo);
    }
  }
  
  private final void g(byte[] paramArrayOfByte, long paramLong)
  {
    if (this.p2 == null) {
      return;
    }
    Object localObject = this.y;
    ((MediaCodec.BufferInfo)localObject).offset = 0;
    int i = paramArrayOfByte.length;
    ((MediaCodec.BufferInfo)localObject).size = i;
    if ((byte)(paramArrayOfByte[4] & 0x1F) == 5) {
      ((MediaCodec.BufferInfo)localObject).flags = 1;
    } else if (((byte)(paramArrayOfByte[4] & 0x1F) != 7) && ((byte)(paramArrayOfByte[4] & 0x1F) != 8)) {
      ((MediaCodec.BufferInfo)localObject).flags = 0;
    } else {
      ((MediaCodec.BufferInfo)localObject).flags = 2;
    }
    ByteBuffer localByteBuffer = ByteBuffer.wrap(paramArrayOfByte, 0, i);
    paramArrayOfByte = this.y;
    paramArrayOfByte.presentationTimeUs = (paramLong - this.J3);
    localObject = this.p2;
    if (localObject != null) {
      ((f)localObject).g(localByteBuffer, paramArrayOfByte);
    }
  }
  
  private final int i(File paramFile, kotlin.jvm.b.a<kotlin.p> parama, kotlin.jvm.b.l<? super IOException, kotlin.p> paraml)
  {
    if (paramFile.exists())
    {
      parama.invoke();
      return 0;
    }
    if (this.p2 == null)
    {
      if (!paramFile.getParentFile().exists()) {
        paramFile.getParentFile().mkdir();
      }
      this.p2 = new f(paramFile.getAbsolutePath());
    }
    if (this.p1 == null)
    {
      paramFile = new b.d.f.a(this);
      this.p1 = paramFile;
      if (paramFile != null) {
        paramFile.g(this.L3, 32000, this.K3);
      }
    }
    if ((this.H3 != null) && (this.I3 != null)) {
      k();
    }
    kotlin.collections.l.o(this.f, new g());
    int j;
    if (!this.f.isEmpty())
    {
      this.J3 = ((a)this.f.get(0)).b();
      int i = this.f.size();
      for (j = 0; j < i; j++)
      {
        paramFile = this.f.get(j);
        j.d(paramFile, "muxDataList[i]");
        a locala = (a)paramFile;
        if (locala.a() == MediaDataFormat.AUDIO_WAV)
        {
          paramFile = this.p1;
          if (paramFile != null) {
            paramFile.a(locala.c(), locala.b());
          }
        }
        else
        {
          this.p0.a(locala.c(), locala.b());
        }
      }
      j = 0;
    }
    else
    {
      j = -3200001;
    }
    paramFile = this.p2;
    if (paramFile != null)
    {
      if (paramFile != null) {
        paramFile.d();
      }
      this.p3 = false;
    }
    paramFile = this.p1;
    if (paramFile != null) {
      paramFile.h();
    }
    if (j == 0) {
      parama.invoke();
    } else {
      paraml.invoke(new IOException("file is empty"));
    }
    return j;
  }
  
  private final void j(File paramFile, int paramInt, kotlin.jvm.b.a<kotlin.p> parama1, kotlin.jvm.b.p<? super byte[], ? super Integer, kotlin.p> paramp, kotlin.jvm.b.a<kotlin.p> parama2)
  {
    byte[] arrayOfByte = new byte[paramInt];
    try
    {
      paramFile = new FileInputStream(paramFile);
      for (int i = paramFile.read(arrayOfByte, 0, paramInt); i != -1; i = paramFile.read(arrayOfByte, 0, paramInt)) {
        paramp.invoke(arrayOfByte, Integer.valueOf(i));
      }
      parama2.invoke();
      return;
    }
    catch (FileNotFoundException paramFile)
    {
      b.d.p.d.c(this.c, Log.getStackTraceString(paramFile));
      parama1.invoke();
    }
  }
  
  private final void k()
  {
    if (this.p3) {
      return;
    }
    MediaFormat localMediaFormat = this.H3;
    if ((localMediaFormat != null) && (this.I3 != null))
    {
      f localf = this.p2;
      if (localf != null) {
        localf.b(localMediaFormat);
      }
      localf = this.p2;
      if (localf != null) {
        localf.a(this.I3);
      }
      localf = this.p2;
      if (localf != null) {
        localf.c();
      }
      this.p3 = true;
    }
  }
  
  public void a(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo, long paramLong)
  {
    j.e(paramByteBuffer, "byteBuffer");
    j.e(paramBufferInfo, "bufferInfo");
    if (this.p3) {
      f(paramBufferInfo, paramByteBuffer, paramLong);
    }
  }
  
  public void b(MediaFormat paramMediaFormat)
  {
    j.e(paramMediaFormat, "format");
    if (this.I3 == null) {
      this.I3 = paramMediaFormat;
    }
    k();
  }
  
  public void c(byte[] paramArrayOfByte, long paramLong)
  {
    j.e(paramArrayOfByte, "datas");
    k();
    g(paramArrayOfByte, paramLong);
  }
  
  public void e(byte[] paramArrayOfByte, int paramInt, b paramb)
  {
    if (paramArrayOfByte != null)
    {
      int i = paramArrayOfByte.length;
      int j = 1;
      int k = 0;
      if (i == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0)
      {
        Object localObject;
        if (paramb != null) {
          localObject = paramb.b();
        } else {
          localObject = null;
        }
        if (localObject != null)
        {
          i = b.a[localObject.ordinal()];
          label156:
          long l;
          if (i != 1)
          {
            if (i == 2)
            {
              if (this.H3 == null)
              {
                localObject = this.p0.b(paramArrayOfByte);
                i = ((List)localObject).size();
                for (paramInt = 0; paramInt < i; paramInt++) {
                  if ((byte)(((byte[])localObject.get(paramInt))[4] & 0x1F) == 7)
                  {
                    paramInt = j;
                    break label156;
                  }
                }
                paramInt = 0;
                if (paramInt != 0)
                {
                  this.z.a((List)localObject);
                  this.H3 = this.z.f();
                }
              }
              paramb = paramb.c();
              j.d(paramb, "esParam.video_param");
              l = paramb.b() * 1000000L / 90000;
              this.f.add(new a(MediaDataFormat.VIDEO_H264, l, paramArrayOfByte));
            }
          }
          else
          {
            if (this.K3 == -1)
            {
              localObject = paramb.a();
              j.d(localObject, "esParam.audio_param");
              this.K3 = ((com.tplink.libtpdemux.tsdemux.common.a)localObject).c();
            }
            if (this.L3 == -1)
            {
              localObject = paramb.a();
              j.d(localObject, "esParam.audio_param");
              this.L3 = ((com.tplink.libtpdemux.tsdemux.common.a)localObject).e();
            }
            if (this.M3 == -1)
            {
              localObject = paramb.a();
              j.d(localObject, "esParam.audio_param");
              this.M3 = ((com.tplink.libtpdemux.tsdemux.common.a)localObject).b();
            }
            if (this.q == null)
            {
              localObject = new b.d.e.d();
              this.q = ((b.d.e.d)localObject);
              ((b.d.e.d)localObject).e(this.L3, this.M3, this.K3);
            }
            l = 0L;
            for (i = k; i < paramInt; i = j)
            {
              j = this.x.h(paramArrayOfByte, i) + i;
              if (j >= paramInt) {
                break;
              }
              localObject = this.q;
              if (localObject != null) {
                localObject = ((b.d.e.d)localObject).a(kotlin.collections.e.e(paramArrayOfByte, i, j));
              } else {
                localObject = null;
              }
              if (localObject != null)
              {
                if (l == 0L)
                {
                  com.tplink.libtpdemux.tsdemux.common.a locala = paramb.a();
                  j.d(locala, "esParam.audio_param");
                  l = locala.d() * 1000000L / 90000;
                }
                else
                {
                  l += localObject.length * 1000000L / (this.L3 * 2);
                }
                this.f.add(new a(MediaDataFormat.AUDIO_WAV, l, (byte[])localObject));
              }
            }
          }
        }
      }
    }
  }
  
  public final void h(File paramFile1, final File paramFile2, int paramInt, kotlin.jvm.b.a<kotlin.p> parama1, final kotlin.jvm.b.a<kotlin.p> parama2, final kotlin.jvm.b.l<? super IOException, kotlin.p> paraml, final kotlin.jvm.b.a<kotlin.p> parama3)
  {
    j.e(paramFile1, "tsFile");
    j.e(paramFile2, "mp4File");
    j.e(parama1, "fileNotFoundCallback");
    j.e(parama2, "successCallBack");
    j.e(paraml, "failCallBack");
    j.e(parama3, "finalCallBack");
    parama1 = new e(parama1, parama3);
    parama2 = new f(parama2, parama3);
    paraml = new d(paraml, parama3);
    parama3 = new b.d.j.a.a();
    parama3.r(this);
    j(paramFile1, this.d * paramInt, parama1, new b(parama3), new c(this, paramFile2, parama2, paraml, parama3));
  }
  
  public static final class a
  {
    private MediaDataFormat a;
    private long b;
    private byte[] c;
    
    public a(MediaDataFormat paramMediaDataFormat, long paramLong, byte[] paramArrayOfByte)
    {
      this.a = paramMediaDataFormat;
      this.b = paramLong;
      this.c = paramArrayOfByte;
    }
    
    public final MediaDataFormat a()
    {
      return this.a;
    }
    
    public final long b()
    {
      return this.b;
    }
    
    public final byte[] c()
    {
      return this.c;
    }
  }
  
  static final class b
    extends Lambda
    implements kotlin.jvm.b.p<byte[], Integer, kotlin.p>
  {
    b(b.d.j.a.a parama)
    {
      super();
    }
    
    public final void a(byte[] paramArrayOfByte, int paramInt)
    {
      j.e(paramArrayOfByte, "fileData");
      this.c.o(paramArrayOfByte, paramInt);
    }
  }
  
  static final class c
    extends Lambda
    implements kotlin.jvm.b.a<kotlin.p>
  {
    c(a parama, File paramFile, kotlin.jvm.b.a parama1, kotlin.jvm.b.l paraml, b.d.j.a.a parama2)
    {
      super();
    }
    
    public final void a()
    {
      if (a.d(this.c, paramFile2, parama2, paraml) != 0)
      {
        paramFile2.delete();
        paraml.invoke(new IOException("generateMP4 failed"));
      }
      parama3.q();
    }
  }
  
  static final class d
    extends Lambda
    implements kotlin.jvm.b.l<IOException, kotlin.p>
  {
    d(kotlin.jvm.b.l paraml, kotlin.jvm.b.a parama)
    {
      super();
    }
    
    public final void a(IOException paramIOException)
    {
      j.e(paramIOException, "it");
      this.c.invoke(paramIOException);
      parama3.invoke();
    }
  }
  
  static final class e
    extends Lambda
    implements kotlin.jvm.b.a<kotlin.p>
  {
    e(kotlin.jvm.b.a parama1, kotlin.jvm.b.a parama2)
    {
      super();
    }
    
    public final void a()
    {
      this.c.invoke();
      parama3.invoke();
    }
  }
  
  static final class f
    extends Lambda
    implements kotlin.jvm.b.a<kotlin.p>
  {
    f(kotlin.jvm.b.a parama1, kotlin.jvm.b.a parama2)
    {
      super();
    }
    
    public final void a()
    {
      this.c.invoke();
      parama3.invoke();
    }
  }
  
  public static final class g<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      return kotlin.q.a.a(Long.valueOf(((a.a)paramT1).b()), Long.valueOf(((a.a)paramT2).b()));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\y\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */