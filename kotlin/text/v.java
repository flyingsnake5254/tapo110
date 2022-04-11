package kotlin.text;

import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.z;
import kotlin.jvm.internal.j;
import kotlin.v.e;

class v
  extends u
{
  public static final boolean o(String paramString1, String paramString2, boolean paramBoolean)
  {
    j.e(paramString1, "$this$endsWith");
    j.e(paramString2, "suffix");
    if (!paramBoolean) {
      return paramString1.endsWith(paramString2);
    }
    return s(paramString1, paramString1.length() - paramString2.length(), paramString2, 0, paramString2.length(), true);
  }
  
  public static boolean q(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramString1 == null)
    {
      if (paramString2 == null) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      return paramBoolean;
    }
    if (!paramBoolean) {
      paramBoolean = paramString1.equals(paramString2);
    } else {
      paramBoolean = paramString1.equalsIgnoreCase(paramString2);
    }
    return paramBoolean;
  }
  
  public static boolean r(CharSequence paramCharSequence)
  {
    j.e(paramCharSequence, "$this$isBlank");
    int i = paramCharSequence.length();
    boolean bool = false;
    if (i != 0)
    {
      Object localObject = w.F(paramCharSequence);
      if (((localObject instanceof Collection)) && (((Collection)localObject).isEmpty())) {}
      do
      {
        while (!((Iterator)localObject).hasNext())
        {
          i = 1;
          break;
          localObject = ((Iterable)localObject).iterator();
        }
      } while (b.c(paramCharSequence.charAt(((z)localObject).nextInt())));
      i = 0;
      if (i == 0) {}
    }
    else
    {
      bool = true;
    }
    return bool;
  }
  
  public static final boolean s(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    j.e(paramString1, "$this$regionMatches");
    j.e(paramString2, "other");
    if (!paramBoolean) {
      paramBoolean = paramString1.regionMatches(paramInt1, paramString2, paramInt2, paramInt3);
    } else {
      paramBoolean = paramString1.regionMatches(paramBoolean, paramInt1, paramString2, paramInt2, paramInt3);
    }
    return paramBoolean;
  }
  
  public static final String t(String paramString, char paramChar1, char paramChar2, boolean paramBoolean)
  {
    j.e(paramString, "$this$replace");
    if (!paramBoolean)
    {
      paramString = paramString.replace(paramChar1, paramChar2);
      j.d(paramString, "(this as java.lang.Strin…replace(oldChar, newChar)");
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder(paramString.length());
    for (int i = 0; i < paramString.length(); i++)
    {
      char c1 = paramString.charAt(i);
      char c2 = c1;
      if (c.d(c1, paramChar1, paramBoolean))
      {
        char c3 = paramChar2;
        c2 = c3;
      }
      localStringBuilder.append(c2);
    }
    paramString = localStringBuilder.toString();
    j.d(paramString, "StringBuilder(capacity).…builderAction).toString()");
    return paramString;
  }
  
  public static final String u(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    j.e(paramString1, "$this$replace");
    j.e(paramString2, "oldValue");
    j.e(paramString3, "newValue");
    int i = 0;
    int j = w.I(paramString1, paramString2, 0, paramBoolean);
    if (j < 0) {
      return paramString1;
    }
    int k = paramString2.length();
    int m = e.b(k, 1);
    int n = paramString1.length() - k + paramString3.length();
    if (n >= 0)
    {
      StringBuilder localStringBuilder = new StringBuilder(n);
      int i1;
      do
      {
        localStringBuilder.append(paramString1, i, j);
        localStringBuilder.append(paramString3);
        i1 = j + k;
        if (j >= paramString1.length()) {
          break;
        }
        n = w.I(paramString1, paramString2, j + m, paramBoolean);
        i = i1;
        j = n;
      } while (n > 0);
      localStringBuilder.append(paramString1, i1, paramString1.length());
      paramString1 = localStringBuilder.toString();
      j.d(paramString1, "stringBuilder.append(this, i, length).toString()");
      return paramString1;
    }
    throw new OutOfMemoryError();
  }
  
  public static final boolean x(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    j.e(paramString1, "$this$startsWith");
    j.e(paramString2, "prefix");
    if (!paramBoolean) {
      return paramString1.startsWith(paramString2, paramInt);
    }
    return s(paramString1, paramInt, paramString2, 0, paramString2.length(), paramBoolean);
  }
  
  public static final boolean y(String paramString1, String paramString2, boolean paramBoolean)
  {
    j.e(paramString1, "$this$startsWith");
    j.e(paramString2, "prefix");
    if (!paramBoolean) {
      return paramString1.startsWith(paramString2);
    }
    return s(paramString1, 0, paramString2, 0, paramString2.length(), paramBoolean);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\text\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */