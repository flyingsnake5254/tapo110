package kotlin.text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlin.n;
import kotlin.sequences.f;
import kotlin.sequences.g;
import kotlin.v.d;

class w
  extends v
{
  public static final boolean C(CharSequence paramCharSequence1, CharSequence paramCharSequence2, boolean paramBoolean)
  {
    j.e(paramCharSequence1, "$this$contains");
    j.e(paramCharSequence2, "other");
    boolean bool1 = paramCharSequence2 instanceof String;
    boolean bool2 = true;
    if (bool1)
    {
      if (M(paramCharSequence1, (String)paramCharSequence2, 0, paramBoolean, 2, null) >= 0) {
        return bool2;
      }
    }
    else if (K(paramCharSequence1, paramCharSequence2, 0, paramCharSequence1.length(), paramBoolean, false, 16, null) >= 0) {
      return bool2;
    }
    paramBoolean = false;
    return paramBoolean;
  }
  
  private static final Pair<Integer, String> E(CharSequence paramCharSequence, Collection<String> paramCollection, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = null;
    if ((!paramBoolean1) && (paramCollection.size() == 1))
    {
      paramCollection = (String)kotlin.collections.l.K(paramCollection);
      if (!paramBoolean2) {
        paramInt = M(paramCharSequence, paramCollection, paramInt, false, 4, null);
      } else {
        paramInt = m.R(paramCharSequence, paramCollection, paramInt, false, 4, null);
      }
      if (paramInt < 0) {
        paramCharSequence = (CharSequence)localObject1;
      } else {
        paramCharSequence = n.a(Integer.valueOf(paramInt), paramCollection);
      }
      return paramCharSequence;
    }
    if (!paramBoolean2) {
      localObject1 = new d(kotlin.v.e.b(paramInt, 0), paramCharSequence.length());
    } else {
      localObject1 = kotlin.v.e.g(kotlin.v.e.d(paramInt, G(paramCharSequence)), 0);
    }
    int i;
    int j;
    Object localObject2;
    Object localObject3;
    if ((paramCharSequence instanceof String))
    {
      paramInt = ((kotlin.v.b)localObject1).a();
      i = ((kotlin.v.b)localObject1).b();
      j = ((kotlin.v.b)localObject1).c();
      if (j >= 0 ? paramInt <= i : paramInt >= i) {
        for (;;)
        {
          localObject2 = paramCollection.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject1 = ((Iterator)localObject2).next();
            localObject3 = (String)localObject1;
            if (v.s((String)localObject3, 0, (String)paramCharSequence, paramInt, ((String)localObject3).length(), paramBoolean1)) {
              break label223;
            }
          }
          localObject1 = null;
          label223:
          localObject1 = (String)localObject1;
          if (localObject1 != null) {
            return n.a(Integer.valueOf(paramInt), localObject1);
          }
          if (paramInt == i) {
            break;
          }
          paramInt += j;
        }
      }
    }
    else
    {
      paramInt = ((kotlin.v.b)localObject1).a();
      j = ((kotlin.v.b)localObject1).b();
      i = ((kotlin.v.b)localObject1).c();
      if (i >= 0 ? paramInt <= j : paramInt >= j) {
        for (;;)
        {
          localObject3 = paramCollection.iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject1 = ((Iterator)localObject3).next();
            localObject2 = (String)localObject1;
            if (Z((CharSequence)localObject2, 0, paramCharSequence, paramInt, ((String)localObject2).length(), paramBoolean1)) {
              break label356;
            }
          }
          localObject1 = null;
          label356:
          localObject1 = (String)localObject1;
          if (localObject1 != null) {
            return n.a(Integer.valueOf(paramInt), localObject1);
          }
          if (paramInt == j) {
            break;
          }
          paramInt += i;
        }
      }
    }
    return null;
  }
  
  public static final d F(CharSequence paramCharSequence)
  {
    j.e(paramCharSequence, "$this$indices");
    return new d(0, paramCharSequence.length() - 1);
  }
  
  public static final int G(CharSequence paramCharSequence)
  {
    j.e(paramCharSequence, "$this$lastIndex");
    return paramCharSequence.length() - 1;
  }
  
  public static final int H(CharSequence paramCharSequence, char paramChar, int paramInt, boolean paramBoolean)
  {
    j.e(paramCharSequence, "$this$indexOf");
    if ((!paramBoolean) && ((paramCharSequence instanceof String))) {
      paramInt = ((String)paramCharSequence).indexOf(paramChar, paramInt);
    } else {
      paramInt = N(paramCharSequence, new char[] { paramChar }, paramInt, paramBoolean);
    }
    return paramInt;
  }
  
  public static final int I(CharSequence paramCharSequence, String paramString, int paramInt, boolean paramBoolean)
  {
    j.e(paramCharSequence, "$this$indexOf");
    j.e(paramString, "string");
    if ((!paramBoolean) && ((paramCharSequence instanceof String))) {
      paramInt = ((String)paramCharSequence).indexOf(paramString, paramInt);
    } else {
      paramInt = K(paramCharSequence, paramString, paramInt, paramCharSequence.length(), paramBoolean, false, 16, null);
    }
    return paramInt;
  }
  
  private static final int J(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject;
    if (!paramBoolean2) {
      localObject = new d(kotlin.v.e.b(paramInt1, 0), kotlin.v.e.d(paramInt2, paramCharSequence1.length()));
    } else {
      localObject = kotlin.v.e.g(kotlin.v.e.d(paramInt1, G(paramCharSequence1)), kotlin.v.e.b(paramInt2, 0));
    }
    int i;
    if (((paramCharSequence1 instanceof String)) && ((paramCharSequence2 instanceof String)))
    {
      paramInt1 = ((kotlin.v.b)localObject).a();
      i = ((kotlin.v.b)localObject).b();
      paramInt2 = ((kotlin.v.b)localObject).c();
      if (paramInt2 >= 0 ? paramInt1 <= i : paramInt1 >= i) {
        for (;;)
        {
          if (v.s((String)paramCharSequence2, 0, (String)paramCharSequence1, paramInt1, paramCharSequence2.length(), paramBoolean1)) {
            return paramInt1;
          }
          if (paramInt1 == i) {
            break;
          }
          paramInt1 += paramInt2;
        }
      }
    }
    else
    {
      paramInt1 = ((kotlin.v.b)localObject).a();
      paramInt2 = ((kotlin.v.b)localObject).b();
      i = ((kotlin.v.b)localObject).c();
      if (i >= 0 ? paramInt1 <= paramInt2 : paramInt1 >= paramInt2) {
        for (;;)
        {
          if (Z(paramCharSequence2, 0, paramCharSequence1, paramInt1, paramCharSequence2.length(), paramBoolean1)) {
            return paramInt1;
          }
          if (paramInt1 == paramInt2) {
            break;
          }
          paramInt1 += i;
        }
      }
    }
    return -1;
  }
  
  public static final int N(CharSequence paramCharSequence, char[] paramArrayOfChar, int paramInt, boolean paramBoolean)
  {
    j.e(paramCharSequence, "$this$indexOfAny");
    j.e(paramArrayOfChar, "chars");
    int i;
    if ((!paramBoolean) && (paramArrayOfChar.length == 1) && ((paramCharSequence instanceof String)))
    {
      i = kotlin.collections.e.r(paramArrayOfChar);
      return ((String)paramCharSequence).indexOf(i, paramInt);
    }
    paramInt = kotlin.v.e.b(paramInt, 0);
    int j = G(paramCharSequence);
    if (paramInt <= j) {
      for (;;)
      {
        char c = paramCharSequence.charAt(paramInt);
        int k = paramArrayOfChar.length;
        for (i = 0; i < k; i++) {
          if (c.d(paramArrayOfChar[i], c, paramBoolean))
          {
            i = 1;
            break label115;
          }
        }
        i = 0;
        label115:
        if (i != 0) {
          return paramInt;
        }
        if (paramInt == j) {
          break;
        }
        paramInt++;
      }
    }
    return -1;
  }
  
  public static final int O(CharSequence paramCharSequence, char paramChar, int paramInt, boolean paramBoolean)
  {
    j.e(paramCharSequence, "$this$lastIndexOf");
    if ((!paramBoolean) && ((paramCharSequence instanceof String))) {
      paramInt = ((String)paramCharSequence).lastIndexOf(paramChar, paramInt);
    } else {
      paramInt = S(paramCharSequence, new char[] { paramChar }, paramInt, paramBoolean);
    }
    return paramInt;
  }
  
  public static final int P(CharSequence paramCharSequence, String paramString, int paramInt, boolean paramBoolean)
  {
    j.e(paramCharSequence, "$this$lastIndexOf");
    j.e(paramString, "string");
    if ((!paramBoolean) && ((paramCharSequence instanceof String))) {
      paramInt = ((String)paramCharSequence).lastIndexOf(paramString, paramInt);
    } else {
      paramInt = J(paramCharSequence, paramString, paramInt, 0, paramBoolean, true);
    }
    return paramInt;
  }
  
  public static final int S(CharSequence paramCharSequence, char[] paramArrayOfChar, int paramInt, boolean paramBoolean)
  {
    j.e(paramCharSequence, "$this$lastIndexOfAny");
    j.e(paramArrayOfChar, "chars");
    int i;
    if ((!paramBoolean) && (paramArrayOfChar.length == 1) && ((paramCharSequence instanceof String)))
    {
      i = kotlin.collections.e.r(paramArrayOfChar);
      return ((String)paramCharSequence).lastIndexOf(i, paramInt);
    }
    for (paramInt = kotlin.v.e.d(paramInt, G(paramCharSequence)); paramInt >= 0; paramInt--)
    {
      char c = paramCharSequence.charAt(paramInt);
      int j = paramArrayOfChar.length;
      int k = 0;
      for (int m = 0;; m++)
      {
        i = k;
        if (m >= j) {
          break;
        }
        if (c.d(paramArrayOfChar[m], c, paramBoolean))
        {
          i = 1;
          break;
        }
      }
      if (i != 0) {
        return paramInt;
      }
    }
    return -1;
  }
  
  public static final f<String> T(CharSequence paramCharSequence)
  {
    j.e(paramCharSequence, "$this$lineSequence");
    return h0(paramCharSequence, new String[] { "\r\n", "\n", "\r" }, false, 0, 6, null);
  }
  
  public static final List<String> U(CharSequence paramCharSequence)
  {
    j.e(paramCharSequence, "$this$lines");
    return g.i(T(paramCharSequence));
  }
  
  private static final f<d> V(CharSequence paramCharSequence, char[] paramArrayOfChar, int paramInt1, final boolean paramBoolean, int paramInt2)
  {
    int i;
    if (paramInt2 >= 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return new e(paramCharSequence, paramInt1, paramInt2, new a(paramArrayOfChar, paramBoolean));
    }
    paramCharSequence = new StringBuilder();
    paramCharSequence.append("Limit must be non-negative, but was ");
    paramCharSequence.append(paramInt2);
    paramCharSequence.append('.');
    throw new IllegalArgumentException(paramCharSequence.toString().toString());
  }
  
  private static final f<d> W(CharSequence paramCharSequence, String[] paramArrayOfString, int paramInt1, final boolean paramBoolean, int paramInt2)
  {
    int i;
    if (paramInt2 >= 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return new e(paramCharSequence, paramInt1, paramInt2, new b(kotlin.collections.e.b(paramArrayOfString), paramBoolean));
    }
    paramCharSequence = new StringBuilder();
    paramCharSequence.append("Limit must be non-negative, but was ");
    paramCharSequence.append(paramInt2);
    paramCharSequence.append('.');
    throw new IllegalArgumentException(paramCharSequence.toString().toString());
  }
  
  public static final boolean Z(CharSequence paramCharSequence1, int paramInt1, CharSequence paramCharSequence2, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    j.e(paramCharSequence1, "$this$regionMatchesImpl");
    j.e(paramCharSequence2, "other");
    if ((paramInt2 >= 0) && (paramInt1 >= 0) && (paramInt1 <= paramCharSequence1.length() - paramInt3) && (paramInt2 <= paramCharSequence2.length() - paramInt3))
    {
      for (int i = 0; i < paramInt3; i++) {
        if (!c.d(paramCharSequence1.charAt(paramInt1 + i), paramCharSequence2.charAt(paramInt2 + i), paramBoolean)) {
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  public static CharSequence a0(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    j.e(paramCharSequence, "$this$removeRange");
    if (paramInt2 >= paramInt1)
    {
      if (paramInt2 == paramInt1) {
        return paramCharSequence.subSequence(0, paramCharSequence.length());
      }
      StringBuilder localStringBuilder = new StringBuilder(paramCharSequence.length() - (paramInt2 - paramInt1));
      localStringBuilder.append(paramCharSequence, 0, paramInt1);
      j.d(localStringBuilder, "this.append(value, startIndex, endIndex)");
      localStringBuilder.append(paramCharSequence, paramInt2, paramCharSequence.length());
      j.d(localStringBuilder, "this.append(value, startIndex, endIndex)");
      return localStringBuilder;
    }
    paramCharSequence = new StringBuilder();
    paramCharSequence.append("End index (");
    paramCharSequence.append(paramInt2);
    paramCharSequence.append(") is less than start index (");
    paramCharSequence.append(paramInt1);
    paramCharSequence.append(").");
    throw new IndexOutOfBoundsException(paramCharSequence.toString());
  }
  
  public static final List<String> b0(CharSequence paramCharSequence, char[] paramArrayOfChar, boolean paramBoolean, int paramInt)
  {
    j.e(paramCharSequence, "$this$split");
    j.e(paramArrayOfChar, "delimiters");
    if (paramArrayOfChar.length == 1) {
      return d0(paramCharSequence, String.valueOf(paramArrayOfChar[0]), paramBoolean, paramInt);
    }
    Object localObject = g.d(X(paramCharSequence, paramArrayOfChar, 0, paramBoolean, paramInt, 2, null));
    paramArrayOfChar = new ArrayList(kotlin.collections.l.l((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramArrayOfChar.add(i0(paramCharSequence, (d)((Iterator)localObject).next()));
    }
    return paramArrayOfChar;
  }
  
  public static final List<String> c0(CharSequence paramCharSequence, String[] paramArrayOfString, boolean paramBoolean, int paramInt)
  {
    j.e(paramCharSequence, "$this$split");
    j.e(paramArrayOfString, "delimiters");
    int i = paramArrayOfString.length;
    int j = 1;
    if (i == 1)
    {
      localObject = paramArrayOfString[0];
      if (((CharSequence)localObject).length() != 0) {
        j = 0;
      }
      if (j == 0) {
        return d0(paramCharSequence, (String)localObject, paramBoolean, paramInt);
      }
    }
    Object localObject = g.d(Y(paramCharSequence, paramArrayOfString, 0, paramBoolean, paramInt, 2, null));
    paramArrayOfString = new ArrayList(kotlin.collections.l.l((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramArrayOfString.add(i0(paramCharSequence, (d)((Iterator)localObject).next()));
    }
    return paramArrayOfString;
  }
  
  private static final List<String> d0(CharSequence paramCharSequence, String paramString, boolean paramBoolean, int paramInt)
  {
    int i = 0;
    int j;
    if (paramInt >= 0) {
      j = 1;
    } else {
      j = 0;
    }
    if (j != 0)
    {
      int k = I(paramCharSequence, paramString, 0, paramBoolean);
      if ((k != -1) && (paramInt != 1))
      {
        if (paramInt > 0) {
          j = 1;
        } else {
          j = 0;
        }
        int m = 10;
        if (j != 0) {
          m = kotlin.v.e.d(paramInt, 10);
        }
        ArrayList localArrayList = new ArrayList(m);
        m = k;
        int n;
        do
        {
          localArrayList.add(paramCharSequence.subSequence(i, m).toString());
          n = paramString.length() + m;
          if ((j != 0) && (localArrayList.size() == paramInt - 1)) {
            break;
          }
          k = I(paramCharSequence, paramString, n, paramBoolean);
          i = n;
          m = k;
        } while (k != -1);
        localArrayList.add(paramCharSequence.subSequence(n, paramCharSequence.length()).toString());
        return localArrayList;
      }
      return kotlin.collections.l.b(paramCharSequence.toString());
    }
    paramCharSequence = new StringBuilder();
    paramCharSequence.append("Limit must be non-negative, but was ");
    paramCharSequence.append(paramInt);
    paramCharSequence.append('.');
    throw new IllegalArgumentException(paramCharSequence.toString().toString());
  }
  
  public static final f<String> g0(CharSequence paramCharSequence, String[] paramArrayOfString, boolean paramBoolean, int paramInt)
  {
    j.e(paramCharSequence, "$this$splitToSequence");
    j.e(paramArrayOfString, "delimiters");
    return g.g(Y(paramCharSequence, paramArrayOfString, 0, paramBoolean, paramInt, 2, null), new c(paramCharSequence));
  }
  
  public static final String i0(CharSequence paramCharSequence, d paramd)
  {
    j.e(paramCharSequence, "$this$substring");
    j.e(paramd, "range");
    return paramCharSequence.subSequence(paramd.h().intValue(), paramd.g().intValue() + 1).toString();
  }
  
  public static final String j0(String paramString1, char paramChar, String paramString2)
  {
    j.e(paramString1, "$this$substringAfter");
    j.e(paramString2, "missingDelimiterValue");
    int i = m.L(paramString1, paramChar, 0, false, 6, null);
    if (i != -1)
    {
      paramString2 = paramString1.substring(i + 1, paramString1.length());
      j.d(paramString2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    }
    return paramString2;
  }
  
  public static final String k0(String paramString1, String paramString2, String paramString3)
  {
    j.e(paramString1, "$this$substringAfter");
    j.e(paramString2, "delimiter");
    j.e(paramString3, "missingDelimiterValue");
    int i = M(paramString1, paramString2, 0, false, 6, null);
    if (i != -1)
    {
      paramString3 = paramString1.substring(i + paramString2.length(), paramString1.length());
      j.d(paramString3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    }
    return paramString3;
  }
  
  public static final String n0(String paramString1, char paramChar, String paramString2)
  {
    j.e(paramString1, "$this$substringAfterLast");
    j.e(paramString2, "missingDelimiterValue");
    int i = m.Q(paramString1, paramChar, 0, false, 6, null);
    if (i != -1)
    {
      paramString2 = paramString1.substring(i + 1, paramString1.length());
      j.d(paramString2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    }
    return paramString2;
  }
  
  public static final String p0(String paramString1, char paramChar, String paramString2)
  {
    j.e(paramString1, "$this$substringBefore");
    j.e(paramString2, "missingDelimiterValue");
    int i = m.L(paramString1, paramChar, 0, false, 6, null);
    if (i != -1)
    {
      paramString2 = paramString1.substring(0, i);
      j.d(paramString2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    }
    return paramString2;
  }
  
  public static final String q0(String paramString1, String paramString2, String paramString3)
  {
    j.e(paramString1, "$this$substringBefore");
    j.e(paramString2, "delimiter");
    j.e(paramString3, "missingDelimiterValue");
    int i = M(paramString1, paramString2, 0, false, 6, null);
    if (i != -1)
    {
      paramString3 = paramString1.substring(0, i);
      j.d(paramString3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    }
    return paramString3;
  }
  
  public static CharSequence t0(CharSequence paramCharSequence)
  {
    j.e(paramCharSequence, "$this$trim");
    int i = paramCharSequence.length() - 1;
    int j = 0;
    int k = 0;
    while (j <= i)
    {
      int m;
      if (k == 0) {
        m = j;
      } else {
        m = i;
      }
      boolean bool = b.c(paramCharSequence.charAt(m));
      if (k == 0)
      {
        if (!bool) {
          k = 1;
        } else {
          j++;
        }
      }
      else
      {
        if (!bool) {
          break;
        }
        i--;
      }
    }
    return paramCharSequence.subSequence(j, i + 1);
  }
  
  static final class a
    extends Lambda
    implements p<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>>
  {
    a(char[] paramArrayOfChar, boolean paramBoolean)
    {
      super();
    }
    
    public final Pair<Integer, Integer> a(CharSequence paramCharSequence, int paramInt)
    {
      j.e(paramCharSequence, "$receiver");
      paramInt = w.N(paramCharSequence, this.c, paramInt, paramBoolean);
      if (paramInt < 0) {
        paramCharSequence = null;
      } else {
        paramCharSequence = n.a(Integer.valueOf(paramInt), Integer.valueOf(1));
      }
      return paramCharSequence;
    }
  }
  
  static final class b
    extends Lambda
    implements p<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>>
  {
    b(List paramList, boolean paramBoolean)
    {
      super();
    }
    
    public final Pair<Integer, Integer> a(CharSequence paramCharSequence, int paramInt)
    {
      j.e(paramCharSequence, "$receiver");
      paramCharSequence = w.B(paramCharSequence, this.c, paramInt, paramBoolean, false);
      if (paramCharSequence != null) {
        paramCharSequence = n.a(paramCharSequence.getFirst(), Integer.valueOf(((String)paramCharSequence.getSecond()).length()));
      } else {
        paramCharSequence = null;
      }
      return paramCharSequence;
    }
  }
  
  static final class c
    extends Lambda
    implements kotlin.jvm.b.l<d, String>
  {
    c(CharSequence paramCharSequence)
    {
      super();
    }
    
    public final String a(d paramd)
    {
      j.e(paramd, "it");
      return w.i0(this.c, paramd);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\text\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */