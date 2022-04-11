package b.c.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class g
{
  @NonNull
  private static j a = new h();
  
  public static void a(@NonNull d paramd)
  {
    a.g((d)k.a(paramd));
  }
  
  public static void b(@Nullable Object paramObject)
  {
    a.c(paramObject);
  }
  
  public static void c(@NonNull String paramString, @Nullable Object... paramVarArgs)
  {
    a.i(null, paramString, paramVarArgs);
  }
  
  public static void d(@Nullable Throwable paramThrowable, @NonNull String paramString, @Nullable Object... paramVarArgs)
  {
    a.i(paramThrowable, paramString, paramVarArgs);
  }
  
  public static void e(@NonNull String paramString, @Nullable Object... paramVarArgs)
  {
    a.b(paramString, paramVarArgs);
  }
  
  public static j f(@Nullable String paramString)
  {
    return a.d(paramString);
  }
  
  public static void g(@NonNull String paramString, @Nullable Object... paramVarArgs)
  {
    a.h(paramString, paramVarArgs);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\c\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */