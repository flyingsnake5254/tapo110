package b.d.w.c;

import android.content.Context;
import b.c.a.g;
import b.c.a.j;
import b.d.w.c.c.e;

public class a
{
  private static boolean a = false;
  private static boolean b = false;
  private static boolean c = false;
  
  public static void a(String paramString)
  {
    g.b(paramString);
  }
  
  public static void b(String paramString, Object paramObject)
  {
    g.f(paramString).c(paramObject);
  }
  
  public static void c(String paramString1, String paramString2)
  {
    g.f(paramString1).c(paramString2);
  }
  
  public static void d(String paramString)
  {
    g.c(paramString, new Object[0]);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    g.f(paramString1).f(paramString2, new Object[0]);
  }
  
  public static void f(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    g.f(paramString1).i(paramThrowable, paramString2, paramVarArgs);
  }
  
  public static void g(Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    g.d(paramThrowable, paramString, paramVarArgs);
  }
  
  public static void h(String paramString)
  {
    g.e(paramString, new Object[0]);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    g.f(paramString1).b(paramString2, new Object[0]);
  }
  
  public static void j(Context paramContext, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    a = paramBoolean1;
    b = paramBoolean2;
    c = paramBoolean3;
    if (paramBoolean1) {
      g.a(new b.c.a.a());
    }
    if (paramBoolean2) {
      g.a(b.d.w.c.b.a.e(paramContext, paramString, 0L));
    }
    if (paramBoolean3) {
      g.a(e.d(paramContext));
    }
  }
  
  public static void k(String paramString1, String paramString2)
  {
    g.f(paramString1).a(paramString2);
  }
  
  public static void l(String paramString1, String paramString2)
  {
    g.f(paramString1).e(paramString2, new Object[0]);
  }
  
  public static void m(String paramString)
  {
    g.g(paramString, new Object[0]);
  }
  
  public static void n(String paramString1, String paramString2)
  {
    g.f(paramString1).h(paramString2, new Object[0]);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\w\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */