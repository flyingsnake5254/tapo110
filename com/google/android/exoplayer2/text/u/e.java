package com.google.android.exoplayer2.text.u;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.j;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.u;
import com.google.common.base.c;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class e
{
  private static final Pattern a = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");
  private static final Pattern b = Pattern.compile("^((?:[0-9]*\\.)?[0-9]+)(px|em|%)$");
  private final d0 c = new d0();
  private final StringBuilder d = new StringBuilder();
  
  private void a(f paramf, String paramString)
  {
    if ("".equals(paramString)) {
      return;
    }
    int i = paramString.indexOf('[');
    Object localObject = paramString;
    if (i != -1)
    {
      localObject = a.matcher(paramString.substring(i));
      if (((Matcher)localObject).matches()) {
        paramf.z((String)g.e(((Matcher)localObject).group(1)));
      }
      localObject = paramString.substring(0, i);
    }
    localObject = o0.E0((String)localObject, "\\.");
    paramString = localObject[0];
    i = paramString.indexOf('#');
    if (i != -1)
    {
      paramf.y(paramString.substring(0, i));
      paramf.x(paramString.substring(i + 1));
    }
    else
    {
      paramf.y(paramString);
    }
    if (localObject.length > 1) {
      paramf.w((String[])o0.x0((Object[])localObject, 1, localObject.length));
    }
  }
  
  private static boolean b(d0 paramd0)
  {
    int i = paramd0.e();
    int j = paramd0.f();
    byte[] arrayOfByte = paramd0.d();
    if (i + 2 <= j)
    {
      int k = i + 1;
      if (arrayOfByte[i] == 47)
      {
        i = k + 1;
        if (arrayOfByte[k] == 42)
        {
          for (;;)
          {
            k = i + 1;
            if (k >= j) {
              break;
            }
            if (((char)arrayOfByte[i] == '*') && ((char)arrayOfByte[k] == '/'))
            {
              i = k + 1;
              j = i;
            }
            else
            {
              i = k;
            }
          }
          paramd0.Q(j - paramd0.e());
          return true;
        }
      }
    }
    return false;
  }
  
  private static boolean c(d0 paramd0)
  {
    int i = k(paramd0, paramd0.e());
    if ((i != 9) && (i != 10) && (i != 12) && (i != 13) && (i != 32)) {
      return false;
    }
    paramd0.Q(1);
    return true;
  }
  
  private static void e(String paramString, f paramf)
  {
    Matcher localMatcher = b.matcher(c.e(paramString));
    if (!localMatcher.matches())
    {
      paramf = new StringBuilder(String.valueOf(paramString).length() + 22);
      paramf.append("Invalid font-size: '");
      paramf.append(paramString);
      paramf.append("'.");
      u.h("WebvttCssParser", paramf.toString());
      return;
    }
    paramString = (String)g.e(localMatcher.group(2));
    paramString.hashCode();
    int i = -1;
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 3592: 
      if (paramString.equals("px")) {
        i = 2;
      }
      break;
    case 3240: 
      if (paramString.equals("em")) {
        i = 1;
      }
      break;
    case 37: 
      if (paramString.equals("%")) {
        i = 0;
      }
      break;
    }
    switch (i)
    {
    default: 
      throw new IllegalStateException();
    case 2: 
      paramf.t(1);
      break;
    case 1: 
      paramf.t(2);
      break;
    case 0: 
      paramf.t(3);
    }
    paramf.s(Float.parseFloat((String)g.e(localMatcher.group(1))));
  }
  
  private static String f(d0 paramd0, StringBuilder paramStringBuilder)
  {
    int i = 0;
    paramStringBuilder.setLength(0);
    int j = paramd0.e();
    int k = paramd0.f();
    while ((j < k) && (i == 0))
    {
      char c1 = (char)paramd0.d()[j];
      if (((c1 < 'A') || (c1 > 'Z')) && ((c1 < 'a') || (c1 > 'z')) && ((c1 < '0') || (c1 > '9')) && (c1 != '#') && (c1 != '-') && (c1 != '.') && (c1 != '_'))
      {
        i = 1;
      }
      else
      {
        j++;
        paramStringBuilder.append(c1);
      }
    }
    paramd0.Q(j - paramd0.e());
    return paramStringBuilder.toString();
  }
  
  @Nullable
  static String g(d0 paramd0, StringBuilder paramStringBuilder)
  {
    n(paramd0);
    if (paramd0.a() == 0) {
      return null;
    }
    paramStringBuilder = f(paramd0, paramStringBuilder);
    if (!"".equals(paramStringBuilder)) {
      return paramStringBuilder;
    }
    char c1 = (char)paramd0.D();
    paramd0 = new StringBuilder(1);
    paramd0.append(c1);
    return paramd0.toString();
  }
  
  @Nullable
  private static String h(d0 paramd0, StringBuilder paramStringBuilder)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i == 0)
    {
      int j = paramd0.e();
      String str = g(paramd0, paramStringBuilder);
      if (str == null) {
        return null;
      }
      if ((!"}".equals(str)) && (!";".equals(str)))
      {
        localStringBuilder.append(str);
      }
      else
      {
        paramd0.P(j);
        i = 1;
      }
    }
    return localStringBuilder.toString();
  }
  
  @Nullable
  private static String i(d0 paramd0, StringBuilder paramStringBuilder)
  {
    n(paramd0);
    if (paramd0.a() < 5) {
      return null;
    }
    if (!"::cue".equals(paramd0.A(5))) {
      return null;
    }
    int i = paramd0.e();
    String str = g(paramd0, paramStringBuilder);
    if (str == null) {
      return null;
    }
    if ("{".equals(str))
    {
      paramd0.P(i);
      return "";
    }
    if ("(".equals(str)) {
      str = l(paramd0);
    } else {
      str = null;
    }
    if (!")".equals(g(paramd0, paramStringBuilder))) {
      return null;
    }
    return str;
  }
  
  private static void j(d0 paramd0, f paramf, StringBuilder paramStringBuilder)
  {
    n(paramd0);
    String str1 = f(paramd0, paramStringBuilder);
    if ("".equals(str1)) {
      return;
    }
    if (!":".equals(g(paramd0, paramStringBuilder))) {
      return;
    }
    n(paramd0);
    String str2 = h(paramd0, paramStringBuilder);
    if ((str2 != null) && (!"".equals(str2)))
    {
      int i = paramd0.e();
      paramStringBuilder = g(paramd0, paramStringBuilder);
      if (!";".equals(paramStringBuilder))
      {
        if ("}".equals(paramStringBuilder)) {
          paramd0.P(i);
        }
      }
      else if ("color".equals(str1))
      {
        paramf.q(j.b(str2));
      }
      else if ("background-color".equals(str1))
      {
        paramf.n(j.b(str2));
      }
      else
      {
        boolean bool1 = "ruby-position".equals(str1);
        boolean bool2 = true;
        if (bool1)
        {
          if ("over".equals(str2)) {
            paramf.v(1);
          } else if ("under".equals(str2)) {
            paramf.v(2);
          }
        }
        else if ("text-combine-upright".equals(str1))
        {
          bool1 = bool2;
          if (!"all".equals(str2)) {
            if (str2.startsWith("digits")) {
              bool1 = bool2;
            } else {
              bool1 = false;
            }
          }
          paramf.p(bool1);
        }
        else if ("text-decoration".equals(str1))
        {
          if ("underline".equals(str2)) {
            paramf.A(true);
          }
        }
        else if ("font-family".equals(str1))
        {
          paramf.r(str2);
        }
        else if ("font-weight".equals(str1))
        {
          if ("bold".equals(str2)) {
            paramf.o(true);
          }
        }
        else if ("font-style".equals(str1))
        {
          if ("italic".equals(str2)) {
            paramf.u(true);
          }
        }
        else if ("font-size".equals(str1))
        {
          e(str2, paramf);
        }
      }
    }
  }
  
  private static char k(d0 paramd0, int paramInt)
  {
    return (char)paramd0.d()[paramInt];
  }
  
  private static String l(d0 paramd0)
  {
    int i = paramd0.e();
    int j = paramd0.f();
    int k = 0;
    while ((i < j) && (k == 0))
    {
      if ((char)paramd0.d()[i] == ')') {
        k = 1;
      } else {
        k = 0;
      }
      i++;
    }
    return paramd0.A(i - 1 - paramd0.e()).trim();
  }
  
  static void m(d0 paramd0)
  {
    while (!TextUtils.isEmpty(paramd0.p())) {}
  }
  
  static void n(d0 paramd0)
  {
    for (int i = 1;; i = 0)
    {
      if ((paramd0.a() <= 0) || (i == 0)) {
        return;
      }
      if ((c(paramd0)) || (b(paramd0))) {
        break;
      }
    }
  }
  
  public List<f> d(d0 paramd0)
  {
    this.d.setLength(0);
    int i = paramd0.e();
    m(paramd0);
    this.c.N(paramd0.d(), paramd0.e());
    this.c.P(i);
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      paramd0 = i(this.c, this.d);
      if (paramd0 == null) {
        break;
      }
      if (!"{".equals(g(this.c, this.d))) {
        return localArrayList;
      }
      f localf = new f();
      a(localf, paramd0);
      paramd0 = null;
      i = 0;
      while (i == 0)
      {
        int j = this.c.e();
        paramd0 = g(this.c, this.d);
        if ((paramd0 != null) && (!"}".equals(paramd0))) {
          i = 0;
        } else {
          i = 1;
        }
        if (i == 0)
        {
          this.c.P(j);
          j(this.c, localf, this.d);
        }
      }
      if ("}".equals(paramd0)) {
        localArrayList.add(localf);
      }
    }
    return localArrayList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\text\u\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */