package org.bouncycastle.crypto.w;

public class d
  extends b
{
  private e d;
  
  protected d(boolean paramBoolean, e parame)
  {
    super(paramBoolean);
    this.d = parame;
  }
  
  public e b()
  {
    return this.d;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof d;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    Object localObject = (d)paramObject;
    paramObject = this.d;
    localObject = ((d)localObject).b();
    if (paramObject == null)
    {
      if (localObject == null) {
        bool2 = true;
      }
      return bool2;
    }
    return ((e)paramObject).equals(localObject);
  }
  
  public int hashCode()
  {
    int i = a() ^ true;
    e locale = this.d;
    int j = i;
    int k;
    if (locale != null) {
      k = i ^ locale.hashCode();
    }
    return k;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\w\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */