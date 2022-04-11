package org.bouncycastle.crypto.w;

public class t
  extends b
{
  private u d;
  
  protected t(boolean paramBoolean, u paramu)
  {
    super(paramBoolean);
    this.d = paramu;
  }
  
  public u b()
  {
    return this.d;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof t;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    Object localObject = (t)paramObject;
    paramObject = this.d;
    localObject = ((t)localObject).b();
    if (paramObject == null)
    {
      if (localObject == null) {
        bool2 = true;
      }
      return bool2;
    }
    return ((u)paramObject).equals(localObject);
  }
  
  public int hashCode()
  {
    u localu = this.d;
    int i;
    if (localu != null) {
      i = localu.hashCode();
    } else {
      i = 0;
    }
    return i;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\w\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */