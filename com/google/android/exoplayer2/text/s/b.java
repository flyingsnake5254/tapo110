package com.google.android.exoplayer2.text.s;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.common.base.c;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.j1;
import com.google.common.collect.u2;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Pattern;

final class b
{
  private static final Pattern a = Pattern.compile("\\s+");
  private static final ImmutableSet<String> b = ImmutableSet.of("auto", "none");
  private static final ImmutableSet<String> c = ImmutableSet.of("dot", "sesame", "circle");
  private static final ImmutableSet<String> d = ImmutableSet.of("filled", "open");
  private static final ImmutableSet<String> e = ImmutableSet.of("after", "before", "outside");
  public final int f;
  public final int g;
  public final int h;
  
  private b(int paramInt1, int paramInt2, int paramInt3)
  {
    this.f = paramInt1;
    this.g = paramInt2;
    this.h = paramInt3;
  }
  
  @Nullable
  public static b a(@Nullable String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramString = c.e(paramString.trim());
    if (paramString.isEmpty()) {
      return null;
    }
    return b(ImmutableSet.copyOf(TextUtils.split(paramString, a)));
  }
  
  private static b b(ImmutableSet<String> paramImmutableSet)
  {
    Object localObject = (String)j1.e(u2.c(e, paramImmutableSet), "outside");
    int i = ((String)localObject).hashCode();
    int j = 2;
    int k = -1;
    int m = 1;
    if (i != -1392885889)
    {
      if (i != -1106037339)
      {
        if ((i == 92734940) && (((String)localObject).equals("after")))
        {
          i = 0;
          break label94;
        }
      }
      else if (((String)localObject).equals("outside"))
      {
        i = 1;
        break label94;
      }
    }
    else if (((String)localObject).equals("before"))
    {
      i = 2;
      break label94;
    }
    i = -1;
    label94:
    int n;
    if (i != 0)
    {
      if (i != 1) {
        n = 1;
      } else {
        n = -2;
      }
    }
    else {
      n = 2;
    }
    localObject = u2.c(b, paramImmutableSet);
    if (!((Set)localObject).isEmpty())
    {
      paramImmutableSet = (String)((Set)localObject).iterator().next();
      i = paramImmutableSet.hashCode();
      if (i != 3005871)
      {
        if ((i == 3387192) && (paramImmutableSet.equals("none")))
        {
          i = 0;
          break label202;
        }
      }
      else if (paramImmutableSet.equals("auto"))
      {
        i = m;
        break label202;
      }
      i = -1;
      label202:
      if (i == 0) {
        k = 0;
      }
      return new b(k, 0, n);
    }
    localObject = u2.c(d, paramImmutableSet);
    paramImmutableSet = u2.c(c, paramImmutableSet);
    if ((((Set)localObject).isEmpty()) && (paramImmutableSet.isEmpty())) {
      return new b(-1, 0, n);
    }
    localObject = (String)j1.e((Iterable)localObject, "filled");
    i = ((String)localObject).hashCode();
    if (i != -1274499742)
    {
      if ((i == 3417674) && (((String)localObject).equals("open")))
      {
        i = 0;
        break label331;
      }
    }
    else if (((String)localObject).equals("filled"))
    {
      i = 1;
      break label331;
    }
    i = -1;
    label331:
    if (i != 0) {
      m = 1;
    } else {
      m = 2;
    }
    paramImmutableSet = (String)j1.e(paramImmutableSet, "circle");
    i = paramImmutableSet.hashCode();
    if (i != -1360216880)
    {
      if (i != -905816648)
      {
        if (i != 99657)
        {
          i = k;
        }
        else
        {
          i = k;
          if (paramImmutableSet.equals("dot")) {
            i = 0;
          }
        }
      }
      else
      {
        i = k;
        if (paramImmutableSet.equals("sesame")) {
          i = 1;
        }
      }
    }
    else
    {
      i = k;
      if (paramImmutableSet.equals("circle")) {
        i = 2;
      }
    }
    k = j;
    if (i != 0) {
      if (i != 1) {
        k = 1;
      } else {
        k = 3;
      }
    }
    return new b(k, m, n);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\text\s\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */