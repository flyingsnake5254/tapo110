package com.google.android.exoplayer2.video.spherical;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c2;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.a;
import com.google.android.exoplayer2.u0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.o0;
import java.nio.ByteBuffer;

public final class e
  extends u0
{
  private final DecoderInputBuffer I3 = new DecoderInputBuffer(1);
  private final d0 J3 = new d0();
  private long K3;
  @Nullable
  private d L3;
  private long M3;
  
  public e()
  {
    super(6);
  }
  
  @Nullable
  private float[] N(ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer.remaining() != 16) {
      return null;
    }
    this.J3.N(paramByteBuffer.array(), paramByteBuffer.limit());
    this.J3.P(paramByteBuffer.arrayOffset() + 4);
    paramByteBuffer = new float[3];
    for (int i = 0; i < 3; i++) {
      paramByteBuffer[i] = Float.intBitsToFloat(this.J3.q());
    }
    return paramByteBuffer;
  }
  
  private void O()
  {
    d locald = this.L3;
    if (locald != null) {
      locald.e();
    }
  }
  
  protected void E()
  {
    O();
  }
  
  protected void G(long paramLong, boolean paramBoolean)
  {
    this.M3 = Long.MIN_VALUE;
    O();
  }
  
  protected void K(Format[] paramArrayOfFormat, long paramLong1, long paramLong2)
  {
    this.K3 = paramLong2;
  }
  
  public int a(Format paramFormat)
  {
    int i;
    if ("application/x-camera-motion".equals(paramFormat.H3)) {
      i = c2.a(4);
    } else {
      i = c2.a(0);
    }
    return i;
  }
  
  public boolean d()
  {
    return i();
  }
  
  public boolean g()
  {
    return true;
  }
  
  public String getName()
  {
    return "CameraMotionRenderer";
  }
  
  public void k(int paramInt, @Nullable Object paramObject)
    throws ExoPlaybackException
  {
    if (paramInt == 7) {
      this.L3 = ((d)paramObject);
    } else {
      super.k(paramInt, paramObject);
    }
  }
  
  public void t(long paramLong1, long paramLong2)
  {
    while ((!i()) && (this.M3 < 100000L + paramLong1))
    {
      this.I3.f();
      if ((L(A(), this.I3, 0) != -4) || (this.I3.k())) {
        break;
      }
      Object localObject = this.I3;
      this.M3 = ((DecoderInputBuffer)localObject).x;
      if ((this.L3 != null) && (!((a)localObject).j()))
      {
        this.I3.p();
        localObject = N((ByteBuffer)o0.i(this.I3.f));
        if (localObject != null) {
          ((d)o0.i(this.L3)).c(this.M3 - this.K3, (float[])localObject);
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\video\spherical\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */