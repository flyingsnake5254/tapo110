package com.tplink.ssh2;

import com.jcraft.jsch.JSch;
import io.reactivex.q;
import io.reactivex.t;
import javax.net.SocketFactory;

public class x
  implements w
{
  private JSch a = new JSch();
  private d0 b;
  private b0 c;
  private w d;
  private String e = "";
  private int f = 0;
  private String g = "";
  private String h = "";
  private int i = -1;
  private e0 j;
  
  public x(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, w paramw, SocketFactory paramSocketFactory)
  {
    this.g = paramString1;
    this.h = paramString2;
    this.e = paramString3;
    this.f = paramInt1;
    this.i = paramInt2;
    this.d = paramw;
    if (paramSocketFactory != null) {
      this.j = new e0(paramSocketFactory);
    }
  }
  
  private t<a0> e(Integer paramInteger)
  {
    paramInteger = new b0("127.0.0.1", paramInteger.intValue(), this);
    this.c = paramInteger;
    return q.f0(paramInteger).N(v.c);
  }
  
  public void a()
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      ((b0)localObject).a().F0();
      this.c = null;
    }
    localObject = this.b;
    if (localObject != null)
    {
      ((d0)localObject).c().F0();
      this.b = null;
    }
  }
  
  public q<a0> b()
  {
    d0 locald0 = new d0(this.e, this.f, this.g, this.h, this.i, this.j);
    this.b = locald0;
    return q.f0(locald0).N(new c(this)).N(new b(this));
  }
  
  public void c(byte[] paramArrayOfByte)
  {
    w localw = this.d;
    if (localw != null) {
      localw.c(paramArrayOfByte);
    }
  }
  
  public void d(a0 parama0, EnumSSH2Status paramEnumSSH2Status)
  {
    if (paramEnumSSH2Status == EnumSSH2Status.SSH2_STATUS_DISCONNECTED) {
      a();
    }
    w localw = this.d;
    if (localw != null) {
      localw.d(parama0, paramEnumSSH2Status);
    }
  }
  
  public q<a0> l(byte[] paramArrayOfByte)
  {
    return q.f0(paramArrayOfByte).N(new a(this));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\ssh2\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */