package com.tplink.libtpcontrols.treerecyclerview;

public class a<T>
{
  private String a;
  private T b;
  private int c;
  private boolean d;
  
  public String a()
  {
    return this.a;
  }
  
  public int b()
  {
    return this.c;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (a.class == paramObject.getClass()))
    {
      paramObject = (a)paramObject;
      if (this.c != ((a)paramObject).c) {
        return false;
      }
      if (this.d != ((a)paramObject).d) {
        return false;
      }
      String str = this.a;
      if (str != null ? !str.equals(((a)paramObject).a) : ((a)paramObject).a != null) {
        return false;
      }
      return this.b.equals(((a)paramObject).b);
    }
    return false;
  }
  
  public int hashCode()
  {
    String str = this.a;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    return ((i * 31 + this.b.hashCode()) * 31 + this.c) * 31 + this.d;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\treerecyclerview\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */