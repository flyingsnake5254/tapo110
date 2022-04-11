package kotlin.v;

public final class d
  extends b
  implements a<Integer>
{
  private static final d x = new d(1, 0);
  public static final a y = new a(null);
  
  public d(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2, 1);
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof d)) {
      if ((!isEmpty()) || (!((d)paramObject).isEmpty()))
      {
        int i = a();
        paramObject = (d)paramObject;
        if ((i != ((b)paramObject).a()) || (b() != ((b)paramObject).b())) {}
      }
      else
      {
        return true;
      }
    }
    boolean bool = false;
    return bool;
  }
  
  public boolean f(int paramInt)
  {
    boolean bool;
    if ((a() <= paramInt) && (paramInt <= b())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public Integer g()
  {
    return Integer.valueOf(b());
  }
  
  public Integer h()
  {
    return Integer.valueOf(a());
  }
  
  public int hashCode()
  {
    int i;
    if (isEmpty()) {
      i = -1;
    } else {
      i = a() * 31 + b();
    }
    return i;
  }
  
  public boolean isEmpty()
  {
    boolean bool;
    if (a() > b()) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a());
    localStringBuilder.append("..");
    localStringBuilder.append(b());
    return localStringBuilder.toString();
  }
  
  public static final class a
  {
    public final d a()
    {
      return d.e();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\v\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */