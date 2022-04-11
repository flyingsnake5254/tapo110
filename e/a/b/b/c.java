package e.a.b.b;

import org.bouncycastle.util.a;

class c
  implements e
{
  protected final int[] a;
  
  c(int[] paramArrayOfInt)
  {
    this.a = a.i(paramArrayOfInt);
  }
  
  public int[] a()
  {
    return a.i(this.a);
  }
  
  public int b()
  {
    int[] arrayOfInt = this.a;
    return arrayOfInt[(arrayOfInt.length - 1)];
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof c)) {
      return false;
    }
    paramObject = (c)paramObject;
    return a.e(this.a, ((c)paramObject).a);
  }
  
  public int hashCode()
  {
    return a.y(this.a);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\b\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */