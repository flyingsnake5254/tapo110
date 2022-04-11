package kotlin.collections;

import kotlin.jvm.internal.j;

public final class y<T>
{
  private final int a;
  private final T b;
  
  public y(int paramInt, T paramT)
  {
    this.a = paramInt;
    this.b = paramT;
  }
  
  public final int a()
  {
    return this.a;
  }
  
  public final T b()
  {
    return (T)this.b;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof y))
      {
        paramObject = (y)paramObject;
        if ((this.a == ((y)paramObject).a) && (j.a(this.b, ((y)paramObject).b))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int i = this.a;
    Object localObject = this.b;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    return i * 31 + j;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("IndexedValue(index=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", value=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\collections\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */