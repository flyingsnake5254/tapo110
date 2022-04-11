package kotlin.internal;

import kotlin.jvm.internal.j;
import kotlin.text.m;

public final class b
{
  public static final a a;
  
  static
  {
    int i = a();
    Object localObject1;
    label53:
    Object localObject6;
    Object localObject7;
    Object localObject8;
    if (i >= 65544)
    {
      try
      {
        localObject1 = Class.forName("kotlin.internal.e.a").newInstance();
        j.d(localObject1, "Class.forName(\"kotlin.in…entations\").newInstance()");
        if (localObject1 != null)
        {
          try
          {
            a locala1 = (a)localObject1;
          }
          catch (ClassCastException localClassCastException1)
          {
            break label53;
          }
        }
        else
        {
          localObject2 = new java/lang/NullPointerException;
          ((NullPointerException)localObject2).<init>("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
          throw ((Throwable)localObject2);
        }
      }
      catch (ClassNotFoundException localClassNotFoundException1)
      {
        try
        {
          Object localObject2;
          localObject1 = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
          j.d(localObject1, "Class.forName(\"kotlin.in…entations\").newInstance()");
          if (localObject1 != null)
          {
            try
            {
              a locala2 = (a)localObject1;
            }
            catch (ClassCastException localClassCastException2)
            {
              break label181;
            }
          }
          else
          {
            localObject3 = new java/lang/NullPointerException;
            ((NullPointerException)localObject3).<init>("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
            throw ((Throwable)localObject3);
          }
        }
        catch (ClassNotFoundException localClassNotFoundException2) {}
        localObject6 = localObject1.getClass().getClassLoader();
        localObject8 = a.class.getClassLoader();
        localObject7 = new java/lang/ClassCastException;
        localObject1 = new java/lang/StringBuilder;
        ((StringBuilder)localObject1).<init>();
        ((StringBuilder)localObject1).append("Instance classloader: ");
        ((StringBuilder)localObject1).append(localObject6);
        ((StringBuilder)localObject1).append(", base type classloader: ");
        ((StringBuilder)localObject1).append(localObject8);
        ((ClassCastException)localObject7).<init>(((StringBuilder)localObject1).toString());
        Object localObject3 = ((ClassCastException)localObject7).initCause((Throwable)localObject3);
        j.d(localObject3, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
        throw ((Throwable)localObject3);
      }
      localObject1 = localObject1.getClass().getClassLoader();
      localObject6 = a.class.getClassLoader();
      localObject7 = new java/lang/ClassCastException;
      localObject8 = new java/lang/StringBuilder;
      ((StringBuilder)localObject8).<init>();
      ((StringBuilder)localObject8).append("Instance classloader: ");
      ((StringBuilder)localObject8).append(localObject1);
      ((StringBuilder)localObject8).append(", base type classloader: ");
      ((StringBuilder)localObject8).append(localObject6);
      ((ClassCastException)localObject7).<init>(((StringBuilder)localObject8).toString());
      localObject2 = ((ClassCastException)localObject7).initCause((Throwable)localObject2);
      j.d(localObject2, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
      throw ((Throwable)localObject2);
    }
    label181:
    if (i >= 65543)
    {
      try
      {
        localObject1 = Class.forName("kotlin.internal.d.a").newInstance();
        j.d(localObject1, "Class.forName(\"kotlin.in…entations\").newInstance()");
        if (localObject1 != null)
        {
          try
          {
            a locala3 = (a)localObject1;
          }
          catch (ClassCastException localClassCastException3)
          {
            break label310;
          }
        }
        else
        {
          localObject4 = new java/lang/NullPointerException;
          ((NullPointerException)localObject4).<init>("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
          throw ((Throwable)localObject4);
        }
      }
      catch (ClassNotFoundException localClassNotFoundException3)
      {
        try
        {
          Object localObject4;
          label310:
          localObject1 = Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();
          j.d(localObject1, "Class.forName(\"kotlin.in…entations\").newInstance()");
          if (localObject1 != null)
          {
            try
            {
              a locala4 = (a)localObject1;
            }
            catch (ClassCastException localClassCastException4)
            {
              break label433;
            }
          }
          else
          {
            localObject5 = new java/lang/NullPointerException;
            ((NullPointerException)localObject5).<init>("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
            throw ((Throwable)localObject5);
          }
        }
        catch (ClassNotFoundException localClassNotFoundException4)
        {
          Object localObject5;
          for (;;) {}
        }
        localObject8 = localObject1.getClass().getClassLoader();
        localObject7 = a.class.getClassLoader();
        localObject6 = new java/lang/ClassCastException;
        localObject1 = new java/lang/StringBuilder;
        ((StringBuilder)localObject1).<init>();
        ((StringBuilder)localObject1).append("Instance classloader: ");
        ((StringBuilder)localObject1).append(localObject8);
        ((StringBuilder)localObject1).append(", base type classloader: ");
        ((StringBuilder)localObject1).append(localObject7);
        ((ClassCastException)localObject6).<init>(((StringBuilder)localObject1).toString());
        localObject5 = ((ClassCastException)localObject6).initCause((Throwable)localObject5);
        j.d(localObject5, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
        throw ((Throwable)localObject5);
      }
      localObject1 = localObject1.getClass().getClassLoader();
      localObject8 = a.class.getClassLoader();
      localObject7 = new java/lang/ClassCastException;
      localObject6 = new java/lang/StringBuilder;
      ((StringBuilder)localObject6).<init>();
      ((StringBuilder)localObject6).append("Instance classloader: ");
      ((StringBuilder)localObject6).append(localObject1);
      ((StringBuilder)localObject6).append(", base type classloader: ");
      ((StringBuilder)localObject6).append(localObject8);
      ((ClassCastException)localObject7).<init>(((StringBuilder)localObject6).toString());
      localObject4 = ((ClassCastException)localObject7).initCause((Throwable)localObject4);
      j.d(localObject4, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
      throw ((Throwable)localObject4);
    }
    label433:
    localObject5 = new a();
    a = (a)localObject5;
  }
  
  private static final int a()
  {
    String str1 = System.getProperty("java.specification.version");
    i = 65542;
    j = i;
    int k;
    if (str1 != null)
    {
      k = m.L(str1, '.', 0, false, 6, null);
      if (k >= 0) {}
    }
    try
    {
      j = Integer.parseInt(str1);
      i = j * 65536;
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      int m;
      int n;
      String str2;
      for (;;) {}
    }
    return i;
    m = k + 1;
    n = m.L(str1, '.', m, false, 4, null);
    j = n;
    if (n < 0) {
      j = str1.length();
    }
    str2 = str1.substring(0, k);
    j.d(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    str1 = str1.substring(m, j);
    j.d(str1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    try
    {
      j = Integer.parseInt(str2);
      n = Integer.parseInt(str1);
      j = j * 65536 + n;
    }
    catch (NumberFormatException localNumberFormatException2)
    {
      for (;;)
      {
        j = i;
      }
    }
    return j;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\internal\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */