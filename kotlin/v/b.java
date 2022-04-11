package kotlin.v;

import kotlin.collections.z;
import kotlin.jvm.internal.r.a;

public class b
  implements Iterable<Integer>, a
{
  public static final a c = new a(null);
  private final int d;
  private final int f;
  private final int q;
  
  public b(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 != 0)
    {
      if (paramInt3 != Integer.MIN_VALUE)
      {
        this.d = paramInt1;
        this.f = kotlin.internal.c.b(paramInt1, paramInt2, paramInt3);
        this.q = paramInt3;
        return;
      }
      throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
    }
    throw new IllegalArgumentException("Step must be non-zero.");
  }
  
  public final int a()
  {
    return this.d;
  }
  
  public final int b()
  {
    return this.f;
  }
  
  public final int c()
  {
    return this.q;
  }
  
  public z d()
  {
    return new c(this.d, this.f, this.q);
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof b)) {
      if ((!isEmpty()) || (!((b)paramObject).isEmpty()))
      {
        int i = this.d;
        paramObject = (b)paramObject;
        if ((i != ((b)paramObject).d) || (this.f != ((b)paramObject).f) || (this.q != ((b)paramObject).q)) {}
      }
      else
      {
        return true;
      }
    }
    boolean bool = false;
    return bool;
  }
  
  public int hashCode()
  {
    int i;
    if (isEmpty()) {
      i = -1;
    } else {
      i = (this.d * 31 + this.f) * 31 + this.q;
    }
    return i;
  }
  
  public boolean isEmpty()
  {
    int i = this.q;
    boolean bool = true;
    if (i > 0 ? this.d <= this.f : this.d >= this.f) {
      bool = false;
    }
    return bool;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder;
    int i;
    if (this.q > 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.d);
      localStringBuilder.append("..");
      localStringBuilder.append(this.f);
      localStringBuilder.append(" step ");
      i = this.q;
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.d);
      localStringBuilder.append(" downTo ");
      localStringBuilder.append(this.f);
      localStringBuilder.append(" step ");
      i = -this.q;
    }
    localStringBuilder.append(i);
    return localStringBuilder.toString();
  }
  
  public static final class a
  {
    public final b a(int paramInt1, int paramInt2, int paramInt3)
    {
      return new b(paramInt1, paramInt2, paramInt3);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\v\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */