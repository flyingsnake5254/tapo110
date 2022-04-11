package com.tplink.iot.devices.lightstrip.lightingeffect.common;

import java.util.List;

public class a
{
  private Integer a;
  private Integer b;
  private Integer c;
  private String d;
  private List<KasaLightState> e;
  
  public a() {}
  
  private a(b paramb)
  {
    d(b.a(paramb));
    h(b.b(paramb));
    g(b.c(paramb));
    f(b.d(paramb));
    e(b.e(paramb));
  }
  
  public static b a()
  {
    return new b(null);
  }
  
  public List<KasaLightState> b()
  {
    return this.e;
  }
  
  public Integer c()
  {
    return this.c;
  }
  
  public void d(Integer paramInteger)
  {
    this.a = paramInteger;
  }
  
  public void e(List<KasaLightState> paramList)
  {
    this.e = paramList;
  }
  
  public void f(String paramString)
  {
    this.d = paramString;
  }
  
  public void g(Integer paramInteger)
  {
    this.c = paramInteger;
  }
  
  public void h(Integer paramInteger)
  {
    this.b = paramInteger;
  }
  
  public static final class b
  {
    private Integer a;
    private Integer b;
    private Integer c;
    private String d;
    private List<KasaLightState> e;
    
    public a f()
    {
      return new a(this, null);
    }
    
    public b g(List<KasaLightState> paramList)
    {
      this.e = paramList;
      return this;
    }
    
    public b h(Integer paramInteger)
    {
      this.c = paramInteger;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\lightingeffect\common\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */