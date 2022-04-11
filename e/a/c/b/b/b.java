package e.a.c.b.b;

import e.a.c.d.a.c;
import e.a.c.d.a.h;
import e.a.c.d.a.i;
import e.a.c.d.a.k;

public class b
  extends a
{
  private int f;
  private e.a.c.d.a.a p0;
  private i[] p1;
  private int q;
  private e.a.c.d.a.b x;
  private i y;
  private h z;
  
  public b(int paramInt1, int paramInt2, e.a.c.d.a.b paramb, i parami, e.a.c.d.a.a parama, h paramh, String paramString)
  {
    super(true, paramString);
    this.f = paramInt1;
    this.q = paramInt2;
    this.x = paramb;
    this.y = parami;
    this.p0 = parama;
    this.z = paramh;
    this.p1 = new k(paramb, parami).c();
  }
  
  public b(int paramInt1, int paramInt2, e.a.c.d.a.b paramb, i parami, h paramh, String paramString)
  {
    this(paramInt1, paramInt2, paramb, parami, c.a(paramb, parami), paramh, paramString);
  }
  
  public e.a.c.d.a.b c()
  {
    return this.x;
  }
  
  public i d()
  {
    return this.y;
  }
  
  public e.a.c.d.a.a e()
  {
    return this.p0;
  }
  
  public int f()
  {
    return this.q;
  }
  
  public int g()
  {
    return this.f;
  }
  
  public h h()
  {
    return this.z;
  }
  
  public i[] i()
  {
    return this.p1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\c\b\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */