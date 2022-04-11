package b.d.u;

import b.d.v.b.c;
import com.tplink.libtpmux.tsmux.e;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

public class m
  implements c
{
  protected int a;
  protected int b;
  protected int c;
  protected int d;
  protected int e;
  protected int f;
  protected int g;
  protected int h;
  protected int i;
  protected int j;
  protected String k;
  protected c l;
  protected AtomicBoolean m = new AtomicBoolean(false);
  protected ExecutorService n;
  protected AtomicBoolean o = new AtomicBoolean(false);
  protected n p;
  protected String q;
  protected AtomicBoolean r;
  protected AtomicBoolean s;
  protected e t;
  protected long u = 0L;
  
  m(String paramString1, String paramString2)
  {
    this.k = paramString1;
    this.q = paramString2;
    this.d = 1;
    this.a = 8000;
    this.b = 16;
    this.c = 2;
    this.j = 10;
    this.e = 1;
    this.f = 16;
    this.r = new AtomicBoolean(false);
    this.s = new AtomicBoolean(false);
    paramString1 = new e();
    this.t = paramString1;
    paramString1.p(true);
  }
  
  public void a() {}
  
  public void b(long paramLong, byte[] paramArrayOfByte) {}
  
  public void c() {}
  
  public void d()
  {
    this.r.set(false);
    com.tplink.libtpstreamclientmanager.m.V().J0(this.k);
  }
  
  public void e(boolean paramBoolean)
  {
    this.s.set(paramBoolean);
    if (paramBoolean) {
      com.tplink.libtpstreamclientmanager.m.V().J0(this.k);
    } else {
      com.tplink.libtpstreamclientmanager.m.V().H0(this.k);
    }
  }
  
  public void f(c paramc)
  {
    this.l = paramc;
  }
  
  public void g(int paramInt) {}
  
  public void h(n paramn)
  {
    this.p = paramn;
  }
  
  public void i(int paramInt) {}
  
  public void j()
  {
    this.r.set(true);
    com.tplink.libtpstreamclientmanager.m.V().H0(this.k);
  }
  
  public void onDoubleTalkClose(String paramString) {}
  
  public void onDoubleTalkCreateFailure(String paramString, int paramInt) {}
  
  public void onDoubleTalkCreateSuccess(String paramString) {}
  
  public void onDoubleTalkSendDataFailure(String paramString, int paramInt, Exception paramException) {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\u\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */