package kotlin.jvm.internal;

public final class l
  implements c
{
  private final Class<?> c;
  private final String d;
  
  public l(Class<?> paramClass, String paramString)
  {
    this.c = paramClass;
    this.d = paramString;
  }
  
  public Class<?> a()
  {
    return this.c;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool;
    if (((paramObject instanceof l)) && (j.a(a(), ((l)paramObject).a()))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public int hashCode()
  {
    return a().hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a().toString());
    localStringBuilder.append(" (Kotlin reflection is not available)");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\jvm\internal\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */