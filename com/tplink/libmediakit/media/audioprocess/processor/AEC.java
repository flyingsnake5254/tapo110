package com.tplink.libmediakit.media.audioprocess.processor;

import com.tplink.libmediakit.media.audioprocess.NativeAudioProcessor;
import com.tplink.libmediakit.media.audioprocess.b.b;
import com.tplink.libmediakit.media.audioprocess.c;
import com.tplink.libmediakit.media.audioprocess.d;
import com.tplink.libmediakit.media.audioprocess.f;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Queue;

public class AEC<T extends d>
  extends NativeAudioProcessor<T>
{
  protected Queue<T> n;
  long o;
  long p;
  T q;
  
  public AEC(c paramc)
  {
    super(paramc, 1);
    this.d = (paramc.a / 1000 * 10);
    paramc = new StringBuilder();
    paramc.append("sampleNumPerProcess:");
    paramc.append(this.d);
    g(paramc.toString());
    this.e = 0L;
    this.o = 0L;
    this.p = 0L;
  }
  
  private native void nativeSetFarValue(float paramFloat, long paramLong);
  
  private native void nativeStuffFarEndSignal(byte[] paramArrayOfByte, int paramInt, long paramLong);
  
  private void t()
  {
    long l1 = this.o;
    long l2;
    Object localObject;
    if (l1 == 0L)
    {
      l2 = this.e;
      this.o = l2;
      localObject = this.k;
      if (localObject != null) {
        ((b.b)localObject).a(l2);
      }
    }
    else
    {
      int i = this.d;
      l2 = i * 1000L / this.b.a;
      this.o = (l1 + l2);
      this.p += l2;
      localObject = new byte[i * 2];
      Arrays.fill((byte[])localObject, (byte)0);
      nativeStuffFarEndSignal((byte[])localObject, this.d, q());
    }
  }
  
  public void a()
  {
    super.a();
    this.q = null;
    Queue localQueue = this.n;
    if (localQueue != null) {
      localQueue.clear();
    }
    this.e = 0L;
    this.o = 0L;
  }
  
  protected boolean j()
  {
    while (this.o <= this.e + 200L)
    {
      d locald = (d)this.n.peek();
      if (locald == null) {
        break;
      }
      if (this.q == null)
      {
        Object localObject = locald.i();
        this.q = ((d)localObject);
        if (((d)localObject).f() == null)
        {
          localObject = new byte[this.d * 2];
          this.q.g(ByteBuffer.wrap((byte[])localObject));
        }
        this.q.h(e(locald));
        this.q.b(d(locald));
      }
      b(this.n, this.q.f());
      if (this.q.f().remaining() == 0)
      {
        long l = this.q.j() + this.p;
        this.o = l;
        if (Math.abs(this.e - l) <= this.b.b) {
          nativeStuffFarEndSignal(this.q.f().array(), this.d, q());
        }
        this.q = null;
      }
    }
    return true;
  }
  
  protected int l(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return super.l(paramArrayOfByte1, paramArrayOfByte2);
  }
  
  protected native long nativeConstruct();
  
  protected boolean p()
  {
    if (this.e - this.o > this.b.b)
    {
      t();
      return true;
    }
    return false;
  }
  
  public void u(float paramFloat)
  {
    nativeSetFarValue(paramFloat, q());
  }
  
  public void v(Queue<T> paramQueue)
  {
    this.n = paramQueue;
  }
  
  public void w() {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libmediakit\media\audioprocess\processor\AEC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */