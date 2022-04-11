package b.d.i.a.a;

import java.util.concurrent.Callable;

public abstract class f
  implements Callable<Boolean>
{
  protected String c;
  protected String d;
  protected int f;
  protected int p0 = 512;
  protected boolean p1 = false;
  protected int q;
  protected int x;
  protected boolean y = true;
  protected boolean z = false;
  
  public int a()
  {
    return this.x;
  }
  
  public String b()
  {
    return this.c;
  }
  
  public int c()
  {
    return this.q;
  }
  
  public boolean d()
  {
    return this.z;
  }
  
  public boolean e()
  {
    int i = this.x;
    boolean bool;
    if ((i != 0) && (17 != i)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public abstract void f(String paramString);
  
  public void g(int paramInt)
  {
    this.x = paramInt;
  }
  
  public void h(String paramString)
  {
    this.c = paramString;
  }
  
  public void i(String paramString)
  {
    this.d = paramString;
  }
  
  public void j(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void k(int paramInt)
  {
    this.q = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\i\a\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */