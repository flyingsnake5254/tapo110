package b.d.d.b;

import androidx.annotation.NonNull;

public class d
{
  private static final String a;
  private final a b;
  private final f c;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(d.class.getSimpleName());
    localStringBuilder.append(".DefaultKey");
    a = localStringBuilder.toString();
  }
  
  public d(@NonNull a parama, @NonNull f paramf)
  {
    this.b = parama;
    this.c = paramf;
  }
  
  @NonNull
  public <T extends a> T a(@NonNull Class<T> paramClass)
  {
    String str = paramClass.getCanonicalName();
    if (str != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(a);
      localStringBuilder.append(":");
      localStringBuilder.append(str);
      return b(localStringBuilder.toString(), paramClass);
    }
    throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
  }
  
  @NonNull
  public <T extends a> T b(@NonNull String paramString, @NonNull Class<T> paramClass)
  {
    a locala = this.c.a(paramString);
    if (paramClass.isInstance(locala)) {
      return locala;
    }
    paramClass = this.b.create(paramClass);
    this.c.b(paramString, paramClass);
    return paramClass;
  }
  
  public static abstract interface a
  {
    @NonNull
    public abstract <T extends a> T create(@NonNull Class<T> paramClass);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\d\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */