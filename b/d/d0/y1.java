package b.d.d0;

import b.d.d0.h2.b.d;
import b.d.d0.i2.b;
import com.tplink.tmp.enumerate.EnumTMPTransportStatus;
import com.tplink.tmp.enumerate.EnumTMPTransportType;
import io.reactivex.l0.a;
import io.reactivex.q;
import io.reactivex.x;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class y1
{
  private final List<b> a = new ArrayList();
  private EnumTMPTransportType b;
  private d c;
  private EnumTMPTransportStatus d = EnumTMPTransportStatus.TMP_TRANSPORT_STATUS_IDLE;
  private b e = new b(-1);
  private ExecutorService f = Executors.newSingleThreadExecutor();
  private ExecutorService g = Executors.newSingleThreadExecutor();
  private final ByteBuffer h = ByteBuffer.allocate(1048576);
  
  protected y1(EnumTMPTransportType paramEnumTMPTransportType, d paramd)
  {
    this.b = paramEnumTMPTransportType;
    this.c = paramd;
  }
  
  private void o()
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        p((b)localIterator.next());
      }
      return;
    }
  }
  
  private void p(b paramb)
  {
    int i = a.a[this.d.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3) {
          paramb.b(this.e, this);
        }
      }
      else {
        paramb.e(this);
      }
    }
    else {
      paramb.a(this);
    }
  }
  
  public void g()
  {
    synchronized (this.a)
    {
      this.a.clear();
      this.b = null;
      this.c = null;
      this.d = null;
      return;
    }
  }
  
  public abstract q<b> h();
  
  protected int i()
  {
    d locald = this.c;
    int i;
    if (locald == null) {
      i = -1;
    } else {
      i = locald.a();
    }
    return i;
  }
  
  public void n(b paramb)
  {
    synchronized (this.a)
    {
      if (!this.a.contains(paramb)) {
        this.a.add(paramb);
      }
      p(paramb);
      return;
    }
  }
  
  public x<byte[]> q(int paramInt)
  {
    return x.e(new l(this, paramInt)).m(a.b(this.g));
  }
  
  protected void r(byte[] paramArrayOfByte)
  {
    q.f0(paramArrayOfByte).l0(a.b(this.f)).G0(new m(this));
  }
  
  protected void s(EnumTMPTransportStatus paramEnumTMPTransportStatus)
  {
    if (paramEnumTMPTransportStatus.getValue() <= this.d.getValue()) {
      return;
    }
    this.d = paramEnumTMPTransportStatus;
    o();
  }
  
  protected void t(b paramb, EnumTMPTransportStatus paramEnumTMPTransportStatus)
  {
    if ((this.d != null) && (paramEnumTMPTransportStatus.getValue() > this.d.getValue()))
    {
      this.d = paramEnumTMPTransportStatus;
      this.e = paramb;
      o();
    }
  }
  
  public abstract q<b> u(byte[] paramArrayOfByte);
  
  public static abstract interface b
  {
    public abstract void a(y1 paramy1);
    
    public abstract void b(b paramb, y1 paramy1);
    
    public abstract void e(y1 paramy1);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\d0\y1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */