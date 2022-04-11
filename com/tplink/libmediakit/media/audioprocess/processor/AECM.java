package com.tplink.libmediakit.media.audioprocess.processor;

import com.tplink.libmediakit.media.audioprocess.NativeAudioProcessor;
import com.tplink.libmediakit.media.audioprocess.c;
import com.tplink.libmediakit.media.audioprocess.d;
import com.tplink.libmediakit.media.audioprocess.f;
import java.nio.ByteBuffer;
import java.util.Queue;

public class AECM<T extends d>
  extends NativeAudioProcessor<T>
{
  protected Queue<T> n;
  long o;
  T p;
  
  public AECM(c paramc)
  {
    super(paramc, 0);
    this.d = (paramc.a / 1000 * 10);
    paramc = new StringBuilder();
    paramc.append("sampleNumPerProcess:");
    paramc.append(this.d);
    g(paramc.toString());
    this.e = -10L;
  }
  
  private native void nativeStuffFarEndSignal(byte[] paramArrayOfByte, int paramInt, long paramLong);
  
  public void a()
  {
    super.a();
    this.p = null;
    Queue localQueue = this.n;
    if (localQueue != null) {
      localQueue.clear();
    }
  }
  
  protected boolean j()
  {
    long l1 = this.e + 10L;
    while (this.o <= this.b.b + l1)
    {
      d locald = (d)this.n.peek();
      if (locald == null) {
        break;
      }
      if (this.p == null)
      {
        Object localObject = locald.i();
        this.p = ((d)localObject);
        if (((d)localObject).f() == null)
        {
          localObject = new byte[this.d * 2];
          this.p.g(ByteBuffer.wrap((byte[])localObject));
        }
        long l2 = e(locald);
        this.o = l2;
        this.p.h(l2);
        this.p.b(d(locald));
      }
      b(this.n, this.p.f());
      if (this.p.f().remaining() == 0)
      {
        if (Math.abs(l1 - this.o) <= this.b.b) {
          nativeStuffFarEndSignal(this.p.f().array(), this.d, q());
        }
        this.p = null;
      }
    }
    return true;
  }
  
  protected native long nativeConstruct();
  
  public void t(Queue<T> paramQueue)
  {
    this.n = paramQueue;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libmediakit\media\audioprocess\processor\AECM.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */