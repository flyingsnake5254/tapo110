package b.d.d0.h2.a;

import com.tplink.tmp.enumerate.EnumTMPTransportType;

public class b
  extends c
{
  private String f;
  private String g;
  private String h;
  private String i;
  private int j;
  
  public b(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    this(paramString1, paramString2, paramString3, paramString4, paramInt, -1);
  }
  
  public b(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2)
  {
    this.f = paramString1;
    this.g = paramString2;
    this.h = paramString3;
    this.i = paramString4;
    this.j = paramInt1;
    k(EnumTMPTransportType.TRANSPORT_TYPE_BLE);
    h(paramInt2);
  }
  
  public b.d.d0.i2.b f()
  {
    if ((this.f != null) && (this.g != null) && (this.h != null) && (this.i != null) && (this.j >= 20)) {
      return new b.d.d0.i2.b();
    }
    return new b.d.d0.i2.b(64524);
  }
  
  public String l()
  {
    return this.f;
  }
  
  public int m()
  {
    return this.j;
  }
  
  public String n()
  {
    return this.h;
  }
  
  public String o()
  {
    return this.g;
  }
  
  public String p()
  {
    return this.i;
  }
  
  public void q(String paramString)
  {
    this.f = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\d0\h2\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */