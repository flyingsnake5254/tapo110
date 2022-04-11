package b.d.d0.h2.b;

import javax.net.SocketFactory;

public class c
  extends d
{
  private String b;
  private int c = 22;
  private SocketFactory d;
  private String e;
  private String f;
  private String g = "127.0.0.1";
  private int h = 20002;
  private int i = -1;
  
  public c(b.d.d0.h2.a.d paramd)
  {
    this.b = paramd.o();
    this.e = paramd.s();
    this.f = paramd.l();
    if (paramd.p() != -1) {
      this.c = paramd.p();
    }
    if (paramd.q() != null) {
      this.g = paramd.q();
    }
    if (paramd.r() != -1) {
      this.h = paramd.r();
    }
    this.d = paramd.m();
    this.i = paramd.n();
  }
  
  public String c()
  {
    return this.f;
  }
  
  public SocketFactory d()
  {
    return this.d;
  }
  
  public int e()
  {
    return this.i;
  }
  
  public String f()
  {
    return this.b;
  }
  
  public int g()
  {
    return this.c;
  }
  
  public String h()
  {
    return this.e;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\d0\h2\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */