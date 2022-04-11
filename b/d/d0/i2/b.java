package b.d.d0.i2;

import b.d.d0.f2.c;
import com.google.gson.i;
import com.google.gson.k;
import java.util.Map;

public class b
{
  private int a;
  private String b;
  
  public b()
  {
    this.a = 0;
    this.b = ((String)c.g.get(Integer.valueOf(0)));
  }
  
  public b(int paramInt)
  {
    this.a = paramInt;
    this.b = ((String)c.g.get(Integer.valueOf(paramInt)));
  }
  
  public b(int paramInt, String paramString)
  {
    this.a = paramInt;
    this.b = paramString;
  }
  
  public int a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public void c(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void d(String paramString)
  {
    this.b = paramString;
  }
  
  public String toString()
  {
    k localk = new k();
    localk.l("errCode", Integer.valueOf(this.a));
    localk.m("errMsg", this.b);
    return localk.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\d0\i2\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */