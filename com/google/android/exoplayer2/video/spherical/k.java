package com.google.android.exoplayer2.video.spherical;

import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.opengl.Matrix;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.k0;
import com.google.android.exoplayer2.util.q;
import com.google.android.exoplayer2.video.t;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

final class k
  implements t, d
{
  private int H3 = -1;
  @Nullable
  private byte[] I3;
  private final AtomicBoolean c = new AtomicBoolean();
  private final AtomicBoolean d = new AtomicBoolean(true);
  private final j f = new j();
  private final float[] p0 = new float[16];
  private int p1;
  private SurfaceTexture p2;
  private volatile int p3 = 0;
  private final f q = new f();
  private final k0<Long> x = new k0();
  private final k0<h> y = new k0();
  private final float[] z = new float[16];
  
  private void i(@Nullable byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    byte[] arrayOfByte = this.I3;
    int i = this.H3;
    this.I3 = paramArrayOfByte;
    int j = paramInt;
    if (paramInt == -1) {
      j = this.p3;
    }
    this.H3 = j;
    if ((i == j) && (Arrays.equals(arrayOfByte, this.I3))) {
      return;
    }
    paramArrayOfByte = null;
    arrayOfByte = this.I3;
    if (arrayOfByte != null) {
      paramArrayOfByte = i.a(arrayOfByte, this.H3);
    }
    if ((paramArrayOfByte == null) || (!j.c(paramArrayOfByte))) {
      paramArrayOfByte = h.b(this.H3);
    }
    this.y.a(paramLong, paramArrayOfByte);
  }
  
  public void a(long paramLong1, long paramLong2, Format paramFormat, @Nullable MediaFormat paramMediaFormat)
  {
    this.x.a(paramLong2, Long.valueOf(paramLong1));
    i(paramFormat.R3, paramFormat.S3, paramLong2);
  }
  
  public void b(float[] paramArrayOfFloat, boolean paramBoolean)
  {
    GLES20.glClear(16384);
    q.b();
    if (this.c.compareAndSet(true, false))
    {
      ((SurfaceTexture)g.e(this.p2)).updateTexImage();
      q.b();
      if (this.d.compareAndSet(true, false)) {
        Matrix.setIdentityM(this.z, 0);
      }
      long l = this.p2.getTimestamp();
      Object localObject = (Long)this.x.g(l);
      if (localObject != null) {
        this.q.c(this.z, ((Long)localObject).longValue());
      }
      localObject = (h)this.y.j(l);
      if (localObject != null) {
        this.f.d((h)localObject);
      }
    }
    Matrix.multiplyMM(this.p0, 0, paramArrayOfFloat, 0, this.z, 0);
    this.f.a(this.p1, this.p0, paramBoolean);
  }
  
  public void c(long paramLong, float[] paramArrayOfFloat)
  {
    this.q.e(paramLong, paramArrayOfFloat);
  }
  
  public SurfaceTexture d()
  {
    GLES20.glClearColor(0.5F, 0.5F, 0.5F, 1.0F);
    q.b();
    this.f.b();
    q.b();
    this.p1 = q.g();
    SurfaceTexture localSurfaceTexture = new SurfaceTexture(this.p1);
    this.p2 = localSurfaceTexture;
    localSurfaceTexture.setOnFrameAvailableListener(new a(this));
    return this.p2;
  }
  
  public void e()
  {
    this.x.c();
    this.q.d();
    this.d.set(true);
  }
  
  public void h(int paramInt)
  {
    this.p3 = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\video\spherical\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */