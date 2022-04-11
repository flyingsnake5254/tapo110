package com.samskivert.mustache;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.j;
import kotlin.text.Regex;
import kotlin.text.m;

public final class e
{
  private static final Regex a = new Regex(",(?![^()]*\\))");
  public static final a b = new a(null);
  
  private final String d(String paramString, int paramInt)
  {
    Objects.requireNonNull(paramString, "null cannot be cast to non-null type java.lang.String");
    paramString = paramString.substring(0, paramInt);
    j.d(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    return paramString;
  }
  
  private final List<String> e(String paramString)
  {
    Object localObject = a.split(paramString, 0);
    paramString = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      Objects.requireNonNull(str, "null cannot be cast to non-null type kotlin.CharSequence");
      paramString.add(m.t0(str).toString());
    }
    return paramString;
  }
  
  public final boolean a(String paramString)
  {
    j.e(paramString, "expressionStr");
    boolean bool1 = b(paramString);
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    int i = m.Q(paramString, ')', 0, false, 6, null);
    if (i == paramString.length() - 1) {
      return false;
    }
    if ('.' == paramString.charAt(i + 1)) {
      bool2 = true;
    }
    return bool2;
  }
  
  public final boolean b(String paramString)
  {
    j.e(paramString, "expressionStr");
    int i = m.L(paramString, '(', 0, false, 6, null);
    int j = m.Q(paramString, ')', 0, false, 6, null);
    return (i != -1) && (j != -1);
  }
  
  public final d c(String paramString)
  {
    j.e(paramString, "expressionStr");
    if (!b(paramString)) {
      return null;
    }
    int i = m.L(paramString, '(', 0, false, 6, null);
    int j = m.Q(paramString, ')', 0, false, 6, null);
    String str = d(paramString, i);
    Object localObject1 = paramString.substring(i + 1, j);
    j.d(localObject1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    paramString = new ArrayList();
    localObject1 = e((String)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (String)((Iterator)localObject1).next();
      if (b((String)localObject2))
      {
        localObject2 = c((String)localObject2);
        if (localObject2 != null) {
          paramString.add(localObject2);
        }
      }
      else
      {
        paramString.add(localObject2);
      }
    }
    return new d(str, paramString);
  }
  
  public static final class a {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\samskivert\mustache\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */