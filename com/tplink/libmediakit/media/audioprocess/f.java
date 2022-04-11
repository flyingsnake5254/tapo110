package com.tplink.libmediakit.media.audioprocess;

import java.nio.ByteBuffer;
import java.util.Queue;

public abstract class f<T extends d>
{
  protected final String a = getClass().getSimpleName();
  protected final c b;
  protected int c;
  protected int d;
  protected long e;
  protected long f;
  protected Queue<T> g;
  protected Queue<T> h;
  protected T i;
  protected boolean j;
  protected b.b k;
  
  protected f(c paramc, int paramInt)
  {
    this.b = paramc;
    this.c = paramInt;
  }
  
  public void a()
  {
    this.i = null;
    Queue localQueue = this.g;
    if (localQueue != null) {
      localQueue.clear();
    }
    localQueue = this.h;
    if (localQueue != null) {
      localQueue.clear();
    }
  }
  
  protected void b(Queue<T> paramQueue, ByteBuffer paramByteBuffer)
  {
    d locald = (d)paramQueue.peek();
    if (locald == null) {
      return;
    }
    for (ByteBuffer localByteBuffer = locald.f(); paramByteBuffer.remaining() >= localByteBuffer.remaining(); localByteBuffer = locald.f())
    {
      paramByteBuffer.put(localByteBuffer.array(), localByteBuffer.position(), localByteBuffer.remaining());
      paramQueue.remove();
      locald = (d)paramQueue.peek();
      if (locald == null) {
        break;
      }
    }
    if ((paramByteBuffer.hasRemaining()) && (locald != null) && (paramByteBuffer.remaining() <= localByteBuffer.remaining()))
    {
      localByteBuffer.get(paramByteBuffer.array(), paramByteBuffer.position(), paramByteBuffer.remaining());
      paramByteBuffer.position(paramByteBuffer.limit());
      if (!localByteBuffer.hasRemaining()) {
        paramQueue.remove();
      }
    }
  }
  
  public Queue<T> c()
  {
    return this.h;
  }
  
  protected long d(d paramd)
  {
    return paramd.e() + paramd.f().position() * 1000 / (paramd.c() / 8) / (paramd.d() / 1000);
  }
  
  protected long e(d paramd)
  {
    return paramd.j() + paramd.f().position() / (paramd.c() / 8) / (paramd.d() / 1000);
  }
  
  public boolean f()
  {
    return this.j;
  }
  
  protected void g(String paramString)
  {
    e.a(this.a, paramString);
  }
  
  protected void h(String paramString1, String paramString2)
  {
    e.b(this.a, paramString1, paramString2);
  }
  
  protected void i(int paramInt, T paramT1, T paramT2) {}
  
  protected boolean j()
  {
    return true;
  }
  
  public void k()
  {
    if (j())
    {
      if (p())
      {
        this.j = true;
        return;
      }
      h("status", "proceed()");
      d locald = (d)this.g.peek();
      if (locald == null)
      {
        this.j = true;
        return;
      }
      Object localObject;
      if (this.i == null)
      {
        this.i = locald.i();
        localObject = new byte[this.d * locald.c() / 8];
        this.i.g(ByteBuffer.wrap((byte[])localObject));
        this.i.h(e(locald));
        long l = d(locald);
        this.f = l;
        this.i.b(l);
      }
      b(this.g, this.i.f());
      if (!this.i.f().hasRemaining())
      {
        this.e = this.i.j();
        this.i.f().flip();
        localObject = this.i.i();
        ((d)localObject).g(ByteBuffer.wrap(new byte[this.i.f().capacity()]));
        int m = l(this.i.f().array(), ((d)localObject).f().array());
        this.h.add(localObject);
        i(m, this.i, (d)localObject);
        this.i = null;
        this.j = false;
      }
      else
      {
        this.j = true;
      }
    }
    else
    {
      h("status", "proceed() skip due to preProcess() failed");
    }
  }
  
  protected abstract int l(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  public void m(Queue<T> paramQueue)
  {
    this.g = paramQueue;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setInputQueue:");
    localStringBuilder.append(paramQueue);
    g(localStringBuilder.toString());
  }
  
  public void n(Queue<T> paramQueue)
  {
    this.h = paramQueue;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setOutputQueue:");
    localStringBuilder.append(paramQueue);
    g(localStringBuilder.toString());
  }
  
  public void o(b.b paramb)
  {
    this.k = paramb;
  }
  
  protected abstract boolean p();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libmediakit\media\audioprocess\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */