package e.a.b.b;

import java.math.BigInteger;

class d
  implements f
{
  protected final a a;
  protected final e b;
  
  d(a parama, e parame)
  {
    this.a = parama;
    this.b = parame;
  }
  
  public int a()
  {
    return this.a.a() * this.b.b();
  }
  
  public BigInteger b()
  {
    return this.a.b();
  }
  
  public e c()
  {
    return this.b;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof d)) {
      return false;
    }
    paramObject = (d)paramObject;
    if ((!this.a.equals(((d)paramObject).a)) || (!this.b.equals(((d)paramObject).b))) {
      bool = false;
    }
    return bool;
  }
  
  public int hashCode()
  {
    return this.a.hashCode() ^ org.bouncycastle.util.d.a(this.b.hashCode(), 16);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */