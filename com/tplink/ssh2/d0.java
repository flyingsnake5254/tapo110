package com.tplink.ssh2;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SocketFactory;

class d0
{
  private Session a;
  private int b;
  private String c = "";
  private int d = 0;
  private String e = "";
  private String f = "";
  private SocketFactory g;
  private boolean h = false;
  private int i = -1;
  
  d0(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, SocketFactory paramSocketFactory)
  {
    this.c = paramString1;
    this.d = paramInt1;
    this.e = paramString2;
    this.f = paramString3;
    this.g = paramSocketFactory;
    this.i = paramInt2;
  }
  
  private io.reactivex.t<a0> a(Session paramSession)
  {
    return io.reactivex.q.f0(paramSession).N(new r(this)).v0(1L, new q(this)).p0(n.c);
  }
  
  private io.reactivex.q<Session> b(JSch paramJSch)
  {
    return io.reactivex.q.f0(paramJSch).g0(new k(this));
  }
  
  private io.reactivex.t<a0> x(int paramInt1, String paramString, int paramInt2)
  {
    return io.reactivex.q.X(new t(this, paramInt1, paramString, paramInt2)).p0(m.c);
  }
  
  io.reactivex.q<a0> c()
  {
    return io.reactivex.q.X(new l(this)).p0(o.c).E(new p(this));
  }
  
  int d()
  {
    return this.b;
  }
  
  io.reactivex.t<a0> w(JSch paramJSch)
  {
    return b(paramJSch).N(new u(this)).N(new s(this));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\ssh2\d0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */