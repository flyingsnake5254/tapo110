package kotlin;

import kotlin.jvm.internal.j;

public final class d
  implements Comparable<d>
{
  public static final d c = e.a();
  public static final a d = new a(null);
  private final int f;
  private final int q;
  private final int x;
  private final int y;
  
  public d(int paramInt1, int paramInt2, int paramInt3)
  {
    this.q = paramInt1;
    this.x = paramInt2;
    this.y = paramInt3;
    this.f = b(paramInt1, paramInt2, paramInt3);
  }
  
  private final int b(int paramInt1, int paramInt2, int paramInt3)
  {
    int i;
    if ((paramInt1 >= 0) && (255 >= paramInt1) && (paramInt2 >= 0) && (255 >= paramInt2) && (paramInt3 >= 0) && (255 >= paramInt3)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return (paramInt1 << 16) + (paramInt2 << 8) + paramInt3;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Version components are out of range: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append('.');
    localStringBuilder.append(paramInt2);
    localStringBuilder.append('.');
    localStringBuilder.append(paramInt3);
    throw new IllegalArgumentException(localStringBuilder.toString().toString());
  }
  
  public int a(d paramd)
  {
    j.e(paramd, "other");
    return this.f - paramd.f;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    Object localObject = paramObject;
    if (!(paramObject instanceof d)) {
      localObject = null;
    }
    paramObject = (d)localObject;
    if (paramObject != null)
    {
      if (this.f != ((d)paramObject).f) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.f;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.q);
    localStringBuilder.append('.');
    localStringBuilder.append(this.x);
    localStringBuilder.append('.');
    localStringBuilder.append(this.y);
    return localStringBuilder.toString();
  }
  
  public static final class a {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */