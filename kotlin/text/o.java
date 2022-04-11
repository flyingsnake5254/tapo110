package kotlin.text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

class o
  extends n
{
  private static final kotlin.jvm.b.l<String, String> b(String paramString)
  {
    int i;
    if (paramString.length() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      paramString = a.c;
    } else {
      paramString = new b(paramString);
    }
    return paramString;
  }
  
  private static final int c(String paramString)
  {
    int i = paramString.length();
    for (int j = 0; j < i; j++) {
      if ((b.c(paramString.charAt(j)) ^ true)) {
        break label40;
      }
    }
    j = -1;
    label40:
    i = j;
    if (j == -1) {
      i = paramString.length();
    }
    return i;
  }
  
  public static final String d(String paramString1, String paramString2)
  {
    j.e(paramString1, "$this$replaceIndent");
    j.e(paramString2, "newIndent");
    Object localObject1 = w.U(paramString1);
    Object localObject2 = new ArrayList();
    Object localObject3 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = ((Iterator)localObject3).next();
      if ((m.r((String)localObject4) ^ true)) {
        ((Collection)localObject2).add(localObject4);
      }
    }
    localObject3 = new ArrayList(kotlin.collections.l.l((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject3).add(Integer.valueOf(c((String)((Iterator)localObject2).next())));
    }
    localObject2 = (Integer)kotlin.collections.l.I((Iterable)localObject3);
    int i = 0;
    int j;
    if (localObject2 != null) {
      j = ((Integer)localObject2).intValue();
    } else {
      j = 0;
    }
    int k = paramString1.length();
    int m = paramString2.length();
    int n = ((List)localObject1).size();
    localObject3 = b(paramString2);
    int i1 = kotlin.collections.l.f((List)localObject1);
    localObject2 = new ArrayList();
    Object localObject4 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject4).hasNext())
    {
      paramString1 = ((Iterator)localObject4).next();
      if (i < 0) {
        kotlin.collections.l.k();
      }
      paramString2 = (String)paramString1;
      if (((i == 0) || (i == i1)) && (m.r(paramString2)))
      {
        paramString1 = null;
      }
      else
      {
        localObject1 = y.u0(paramString2, j);
        paramString1 = paramString2;
        if (localObject1 != null)
        {
          localObject1 = (String)((kotlin.jvm.b.l)localObject3).invoke(localObject1);
          paramString1 = paramString2;
          if (localObject1 != null) {
            paramString1 = (String)localObject1;
          }
        }
      }
      if (paramString1 != null) {
        ((Collection)localObject2).add(paramString1);
      }
      i++;
    }
    paramString1 = ((StringBuilder)kotlin.collections.l.C((Iterable)localObject2, new StringBuilder(k + m * n), "\n", null, null, 0, null, null, 124, null)).toString();
    j.d(paramString1, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
    return paramString1;
  }
  
  public static final String e(String paramString1, String paramString2, String paramString3)
  {
    j.e(paramString1, "$this$replaceIndentByMargin");
    j.e(paramString2, "newIndent");
    j.e(paramString3, "marginPrefix");
    if ((m.r(paramString3) ^ true))
    {
      Object localObject = w.U(paramString1);
      int i = paramString1.length();
      int j = paramString2.length();
      int k = ((List)localObject).size();
      kotlin.jvm.b.l locall = b(paramString2);
      int m = kotlin.collections.l.f((List)localObject);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = ((Iterable)localObject).iterator();
      for (int n = 0; localIterator.hasNext(); n++)
      {
        paramString1 = localIterator.next();
        if (n < 0) {
          kotlin.collections.l.k();
        }
        localObject = (String)paramString1;
        paramString1 = null;
        paramString2 = null;
        if (((n != 0) && (n != m)) || (!m.r((CharSequence)localObject)))
        {
          int i1 = ((CharSequence)localObject).length();
          for (int i2 = 0; i2 < i1; i2++) {
            if ((b.c(((CharSequence)localObject).charAt(i2)) ^ true)) {
              break label187;
            }
          }
          i2 = -1;
          label187:
          if ((i2 != -1) && (v.z((String)localObject, paramString3, i2, false, 4, null)))
          {
            i1 = paramString3.length();
            Objects.requireNonNull(localObject, "null cannot be cast to non-null type java.lang.String");
            paramString2 = ((String)localObject).substring(i2 + i1);
            j.d(paramString2, "(this as java.lang.String).substring(startIndex)");
          }
          paramString1 = (String)localObject;
          if (paramString2 != null)
          {
            paramString2 = (String)locall.invoke(paramString2);
            paramString1 = (String)localObject;
            if (paramString2 != null) {
              paramString1 = paramString2;
            }
          }
        }
        if (paramString1 != null) {
          localArrayList.add(paramString1);
        }
      }
      paramString1 = ((StringBuilder)kotlin.collections.l.C(localArrayList, new StringBuilder(i + j * k), "\n", null, null, 0, null, null, 124, null)).toString();
      j.d(paramString1, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
      return paramString1;
    }
    throw new IllegalArgumentException("marginPrefix must be non-blank string.".toString());
  }
  
  public static String f(String paramString)
  {
    j.e(paramString, "$this$trimIndent");
    return d(paramString, "");
  }
  
  public static final String g(String paramString1, String paramString2)
  {
    j.e(paramString1, "$this$trimMargin");
    j.e(paramString2, "marginPrefix");
    return e(paramString1, "", paramString2);
  }
  
  static final class a
    extends Lambda
    implements kotlin.jvm.b.l<String, String>
  {
    public static final a c = new a();
    
    a()
    {
      super();
    }
    
    public final String a(String paramString)
    {
      j.e(paramString, "line");
      return paramString;
    }
  }
  
  static final class b
    extends Lambda
    implements kotlin.jvm.b.l<String, String>
  {
    b(String paramString)
    {
      super();
    }
    
    public final String a(String paramString)
    {
      j.e(paramString, "line");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.c);
      localStringBuilder.append(paramString);
      return localStringBuilder.toString();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\text\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */