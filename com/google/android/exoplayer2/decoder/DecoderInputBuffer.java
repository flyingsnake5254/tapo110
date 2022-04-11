package com.google.android.exoplayer2.decoder;

import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

public class DecoderInputBuffer
  extends a
{
  public final b d = new b();
  @Nullable
  public ByteBuffer f;
  private final int p0;
  public boolean q;
  public long x;
  @Nullable
  public ByteBuffer y;
  private final int z;
  
  public DecoderInputBuffer(int paramInt)
  {
    this(paramInt, 0);
  }
  
  public DecoderInputBuffer(int paramInt1, int paramInt2)
  {
    this.z = paramInt1;
    this.p0 = paramInt2;
  }
  
  private ByteBuffer n(int paramInt)
  {
    int i = this.z;
    if (i == 1) {
      return ByteBuffer.allocate(paramInt);
    }
    if (i == 2) {
      return ByteBuffer.allocateDirect(paramInt);
    }
    ByteBuffer localByteBuffer = this.f;
    if (localByteBuffer == null) {
      i = 0;
    } else {
      i = localByteBuffer.capacity();
    }
    throw new InsufficientCapacityException(i, paramInt);
  }
  
  public static DecoderInputBuffer r()
  {
    return new DecoderInputBuffer(0);
  }
  
  public void f()
  {
    super.f();
    ByteBuffer localByteBuffer = this.f;
    if (localByteBuffer != null) {
      localByteBuffer.clear();
    }
    localByteBuffer = this.y;
    if (localByteBuffer != null) {
      localByteBuffer.clear();
    }
    this.q = false;
  }
  
  @EnsuresNonNull({"data"})
  public void o(int paramInt)
  {
    int i = paramInt + this.p0;
    ByteBuffer localByteBuffer1 = this.f;
    if (localByteBuffer1 == null)
    {
      this.f = n(i);
      return;
    }
    paramInt = localByteBuffer1.capacity();
    int j = localByteBuffer1.position();
    i += j;
    if (paramInt >= i)
    {
      this.f = localByteBuffer1;
      return;
    }
    ByteBuffer localByteBuffer2 = n(i);
    localByteBuffer2.order(localByteBuffer1.order());
    if (j > 0)
    {
      localByteBuffer1.flip();
      localByteBuffer2.put(localByteBuffer1);
    }
    this.f = localByteBuffer2;
  }
  
  public final void p()
  {
    ByteBuffer localByteBuffer = this.f;
    if (localByteBuffer != null) {
      localByteBuffer.flip();
    }
    localByteBuffer = this.y;
    if (localByteBuffer != null) {
      localByteBuffer.flip();
    }
  }
  
  public final boolean q()
  {
    return h(1073741824);
  }
  
  @EnsuresNonNull({"supplementalData"})
  public void s(int paramInt)
  {
    ByteBuffer localByteBuffer = this.y;
    if ((localByteBuffer != null) && (localByteBuffer.capacity() >= paramInt)) {
      this.y.clear();
    } else {
      this.y = ByteBuffer.allocate(paramInt);
    }
  }
  
  public static final class InsufficientCapacityException
    extends IllegalStateException
  {
    public final int currentCapacity;
    public final int requiredCapacity;
    
    public InsufficientCapacityException(int paramInt1, int paramInt2)
    {
      super();
      this.currentCapacity = paramInt1;
      this.requiredCapacity = paramInt2;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\decoder\DecoderInputBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */