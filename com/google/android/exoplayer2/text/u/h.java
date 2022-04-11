package com.google.android.exoplayer2.text.u;

import android.graphics.Color;
import android.text.Layout.Alignment;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.text.c.b;
import com.google.android.exoplayer2.text.p.d;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.u;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class h
{
  public static final Pattern a = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");
  private static final Pattern b = Pattern.compile("(\\S+?):(\\S+)");
  private static final Map<String, Integer> c;
  private static final Map<String, Integer> d;
  
  static
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("white", Integer.valueOf(Color.rgb(255, 255, 255)));
    localHashMap.put("lime", Integer.valueOf(Color.rgb(0, 255, 0)));
    localHashMap.put("cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
    localHashMap.put("red", Integer.valueOf(Color.rgb(255, 0, 0)));
    localHashMap.put("yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
    localHashMap.put("magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
    localHashMap.put("blue", Integer.valueOf(Color.rgb(0, 0, 255)));
    localHashMap.put("black", Integer.valueOf(Color.rgb(0, 0, 0)));
    c = Collections.unmodifiableMap(localHashMap);
    localHashMap = new HashMap();
    localHashMap.put("bg_white", Integer.valueOf(Color.rgb(255, 255, 255)));
    localHashMap.put("bg_lime", Integer.valueOf(Color.rgb(0, 255, 0)));
    localHashMap.put("bg_cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
    localHashMap.put("bg_red", Integer.valueOf(Color.rgb(255, 0, 0)));
    localHashMap.put("bg_yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
    localHashMap.put("bg_magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
    localHashMap.put("bg_blue", Integer.valueOf(Color.rgb(0, 0, 255)));
    localHashMap.put("bg_black", Integer.valueOf(Color.rgb(0, 0, 0)));
    d = Collections.unmodifiableMap(localHashMap);
  }
  
  private static void a(SpannableStringBuilder paramSpannableStringBuilder, Set<String> paramSet, int paramInt1, int paramInt2)
  {
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      String str = (String)paramSet.next();
      Map localMap = c;
      if (localMap.containsKey(str))
      {
        paramSpannableStringBuilder.setSpan(new ForegroundColorSpan(((Integer)localMap.get(str)).intValue()), paramInt1, paramInt2, 33);
      }
      else
      {
        localMap = d;
        if (localMap.containsKey(str)) {
          paramSpannableStringBuilder.setSpan(new BackgroundColorSpan(((Integer)localMap.get(str)).intValue()), paramInt1, paramInt2, 33);
        }
      }
    }
  }
  
  private static void b(String paramString, SpannableStringBuilder paramSpannableStringBuilder)
  {
    paramString.hashCode();
    int i = paramString.hashCode();
    int j = -1;
    switch (i)
    {
    default: 
      break;
    case 3374865: 
      if (paramString.equals("nbsp")) {
        j = 3;
      }
      break;
    case 96708: 
      if (paramString.equals("amp")) {
        j = 2;
      }
      break;
    case 3464: 
      if (paramString.equals("lt")) {
        j = 1;
      }
      break;
    case 3309: 
      if (paramString.equals("gt")) {
        j = 0;
      }
      break;
    }
    switch (j)
    {
    default: 
      paramSpannableStringBuilder = new StringBuilder(paramString.length() + 33);
      paramSpannableStringBuilder.append("ignoring unsupported entity: '&");
      paramSpannableStringBuilder.append(paramString);
      paramSpannableStringBuilder.append(";'");
      u.h("WebvttCueParser", paramSpannableStringBuilder.toString());
      break;
    case 3: 
      paramSpannableStringBuilder.append(' ');
      break;
    case 2: 
      paramSpannableStringBuilder.append('&');
      break;
    case 1: 
      paramSpannableStringBuilder.append('<');
      break;
    case 0: 
      paramSpannableStringBuilder.append('>');
    }
  }
  
  private static void c(SpannableStringBuilder paramSpannableStringBuilder, @Nullable String paramString, c paramc, List<b> paramList, List<f> paramList1)
  {
    int i = i(paramList1, paramString, paramc);
    ArrayList localArrayList = new ArrayList(paramList.size());
    localArrayList.addAll(paramList);
    Collections.sort(localArrayList, b.a());
    int j = paramc.b;
    int k = 0;
    int m = 0;
    while (k < localArrayList.size())
    {
      if ("rt".equals(b.b((b)localArrayList.get(k)).a))
      {
        paramc = (b)localArrayList.get(k);
        int n = g(i(paramList1, paramString, b.b(paramc)), i, 1);
        int i1 = b.b(paramc).b - m;
        int i2 = b.c(paramc) - m;
        paramc = paramSpannableStringBuilder.subSequence(i1, i2);
        paramSpannableStringBuilder.delete(i1, i2);
        paramSpannableStringBuilder.setSpan(new com.google.android.exoplayer2.text.p.c(paramc.toString(), n), j, i1, 33);
        m += paramc.length();
        j = i1;
      }
      k++;
    }
  }
  
  private static void d(@Nullable String paramString, c paramc, List<b> paramList, SpannableStringBuilder paramSpannableStringBuilder, List<f> paramList1)
  {
    int i = paramc.b;
    int j = paramSpannableStringBuilder.length();
    String str = paramc.a;
    str.hashCode();
    int k = str.hashCode();
    int m = 0;
    int n = -1;
    switch (k)
    {
    default: 
      break;
    case 3511770: 
      if (str.equals("ruby")) {
        n = 7;
      }
      break;
    case 3314158: 
      if (str.equals("lang")) {
        n = 6;
      }
      break;
    case 118: 
      if (str.equals("v")) {
        n = 5;
      }
      break;
    case 117: 
      if (str.equals("u")) {
        n = 4;
      }
      break;
    case 105: 
      if (str.equals("i")) {
        n = 3;
      }
      break;
    case 99: 
      if (str.equals("c")) {
        n = 2;
      }
      break;
    case 98: 
      if (str.equals("b")) {
        n = 1;
      }
      break;
    case 0: 
      if (str.equals("")) {
        n = 0;
      }
      break;
    }
    switch (n)
    {
    default: 
      return;
    case 7: 
      c(paramSpannableStringBuilder, paramString, paramc, paramList, paramList1);
      break;
    case 4: 
      paramSpannableStringBuilder.setSpan(new UnderlineSpan(), i, j, 33);
      break;
    case 3: 
      paramSpannableStringBuilder.setSpan(new StyleSpan(2), i, j, 33);
      break;
    case 2: 
      a(paramSpannableStringBuilder, paramc.d, i, j);
      break;
    case 1: 
      paramSpannableStringBuilder.setSpan(new StyleSpan(1), i, j, 33);
    }
    paramString = h(paramList1, paramString, paramc);
    for (n = m; n < paramString.size(); n++) {
      e(paramSpannableStringBuilder, ((d)paramString.get(n)).d, i, j);
    }
  }
  
  private static void e(SpannableStringBuilder paramSpannableStringBuilder, f paramf, int paramInt1, int paramInt2)
  {
    if (paramf == null) {
      return;
    }
    if (paramf.i() != -1) {
      d.a(paramSpannableStringBuilder, new StyleSpan(paramf.i()), paramInt1, paramInt2, 33);
    }
    if (paramf.l()) {
      paramSpannableStringBuilder.setSpan(new StrikethroughSpan(), paramInt1, paramInt2, 33);
    }
    if (paramf.m()) {
      paramSpannableStringBuilder.setSpan(new UnderlineSpan(), paramInt1, paramInt2, 33);
    }
    if (paramf.k()) {
      d.a(paramSpannableStringBuilder, new ForegroundColorSpan(paramf.c()), paramInt1, paramInt2, 33);
    }
    if (paramf.j()) {
      d.a(paramSpannableStringBuilder, new BackgroundColorSpan(paramf.a()), paramInt1, paramInt2, 33);
    }
    if (paramf.d() != null) {
      d.a(paramSpannableStringBuilder, new TypefaceSpan(paramf.d()), paramInt1, paramInt2, 33);
    }
    int i = paramf.f();
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3) {
          d.a(paramSpannableStringBuilder, new RelativeSizeSpan(paramf.e() / 100.0F), paramInt1, paramInt2, 33);
        }
      }
      else {
        d.a(paramSpannableStringBuilder, new RelativeSizeSpan(paramf.e()), paramInt1, paramInt2, 33);
      }
    }
    else {
      d.a(paramSpannableStringBuilder, new AbsoluteSizeSpan((int)paramf.e(), true), paramInt1, paramInt2, 33);
    }
    if (paramf.b()) {
      paramSpannableStringBuilder.setSpan(new com.google.android.exoplayer2.text.p.a(), paramInt1, paramInt2, 33);
    }
  }
  
  private static int f(String paramString, int paramInt)
  {
    paramInt = paramString.indexOf('>', paramInt);
    if (paramInt == -1) {
      paramInt = paramString.length();
    } else {
      paramInt++;
    }
    return paramInt;
  }
  
  private static int g(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 != -1) {
      return paramInt1;
    }
    if (paramInt2 != -1) {
      return paramInt2;
    }
    if (paramInt3 != -1) {
      return paramInt3;
    }
    throw new IllegalArgumentException();
  }
  
  private static List<d> h(List<f> paramList, @Nullable String paramString, c paramc)
  {
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; i < paramList.size(); i++)
    {
      f localf = (f)paramList.get(i);
      int j = localf.h(paramString, paramc.a, paramc.d, paramc.c);
      if (j > 0) {
        localArrayList.add(new d(j, localf));
      }
    }
    Collections.sort(localArrayList);
    return localArrayList;
  }
  
  private static int i(List<f> paramList, @Nullable String paramString, c paramc)
  {
    paramString = h(paramList, paramString, paramc);
    for (int i = 0; i < paramString.size(); i++)
    {
      paramList = ((d)paramString.get(i)).d;
      if (paramList.g() != -1) {
        return paramList.g();
      }
    }
    return -1;
  }
  
  private static String j(String paramString)
  {
    paramString = paramString.trim();
    com.google.android.exoplayer2.util.g.a(paramString.isEmpty() ^ true);
    return o0.F0(paramString, "[ \\.]")[0];
  }
  
  private static boolean k(String paramString)
  {
    paramString.hashCode();
    int i = paramString.hashCode();
    int j = -1;
    switch (i)
    {
    default: 
      break;
    case 3511770: 
      if (paramString.equals("ruby")) {
        j = 7;
      }
      break;
    case 3314158: 
      if (paramString.equals("lang")) {
        j = 6;
      }
      break;
    case 3650: 
      if (paramString.equals("rt")) {
        j = 5;
      }
      break;
    case 118: 
      if (paramString.equals("v")) {
        j = 4;
      }
      break;
    case 117: 
      if (paramString.equals("u")) {
        j = 3;
      }
      break;
    case 105: 
      if (paramString.equals("i")) {
        j = 2;
      }
      break;
    case 99: 
      if (paramString.equals("c")) {
        j = 1;
      }
      break;
    case 98: 
      if (paramString.equals("b")) {
        j = 0;
      }
      break;
    }
    switch (j)
    {
    default: 
      return false;
    }
    return true;
  }
  
  static com.google.android.exoplayer2.text.c l(CharSequence paramCharSequence)
  {
    e locale = new e();
    locale.c = paramCharSequence;
    return locale.g().a();
  }
  
  @Nullable
  public static g m(d0 paramd0, List<f> paramList)
  {
    String str = paramd0.p();
    if (str == null) {
      return null;
    }
    Object localObject1 = a;
    Object localObject2 = ((Pattern)localObject1).matcher(str);
    if (((Matcher)localObject2).matches()) {
      return n(null, (Matcher)localObject2, paramd0, paramList);
    }
    localObject2 = paramd0.p();
    if (localObject2 == null) {
      return null;
    }
    localObject1 = ((Pattern)localObject1).matcher((CharSequence)localObject2);
    if (((Matcher)localObject1).matches()) {
      return n(str.trim(), (Matcher)localObject1, paramd0, paramList);
    }
    return null;
  }
  
  @Nullable
  private static g n(@Nullable String paramString, Matcher paramMatcher, d0 paramd0, List<f> paramList)
  {
    e locale = new e();
    try
    {
      locale.a = j.d((String)com.google.android.exoplayer2.util.g.e(paramMatcher.group(1)));
      locale.b = j.d((String)com.google.android.exoplayer2.util.g.e(paramMatcher.group(2)));
      p((String)com.google.android.exoplayer2.util.g.e(paramMatcher.group(3)), locale);
      StringBuilder localStringBuilder = new StringBuilder();
      for (paramMatcher = paramd0.p(); !TextUtils.isEmpty(paramMatcher); paramMatcher = paramd0.p())
      {
        if (localStringBuilder.length() > 0) {
          localStringBuilder.append("\n");
        }
        localStringBuilder.append(paramMatcher.trim());
      }
      locale.c = q(paramString, localStringBuilder.toString(), paramList);
      return locale.a();
    }
    catch (NumberFormatException paramString)
    {
      paramString = String.valueOf(paramMatcher.group());
      if (paramString.length() != 0) {
        paramString = "Skipping cue with bad header: ".concat(paramString);
      } else {
        paramString = new String("Skipping cue with bad header: ");
      }
      u.h("WebvttCueParser", paramString);
    }
    return null;
  }
  
  static c.b o(String paramString)
  {
    e locale = new e();
    p(paramString, locale);
    return locale.g();
  }
  
  private static void p(String paramString, e parame)
  {
    Matcher localMatcher = b.matcher(paramString);
    while (localMatcher.find())
    {
      String str1 = (String)com.google.android.exoplayer2.util.g.e(localMatcher.group(1));
      String str2 = (String)com.google.android.exoplayer2.util.g.e(localMatcher.group(2));
      try
      {
        if ("line".equals(str1))
        {
          s(str2, parame);
        }
        else if ("align".equals(str1))
        {
          parame.d = v(str2);
        }
        else if ("position".equals(str1))
        {
          u(str2, parame);
        }
        else if ("size".equals(str1))
        {
          parame.j = j.c(str2);
        }
        else if ("vertical".equals(str1))
        {
          parame.k = w(str2);
        }
        else
        {
          int i = String.valueOf(str1).length();
          int j = String.valueOf(str2).length();
          paramString = new java/lang/StringBuilder;
          paramString.<init>(i + 21 + j);
          paramString.append("Unknown cue setting ");
          paramString.append(str1);
          paramString.append(":");
          paramString.append(str2);
          u.h("WebvttCueParser", paramString.toString());
        }
      }
      catch (NumberFormatException paramString)
      {
        paramString = String.valueOf(localMatcher.group());
        if (paramString.length() != 0) {
          paramString = "Skipping bad cue setting: ".concat(paramString);
        } else {
          paramString = new String("Skipping bad cue setting: ");
        }
        u.h("WebvttCueParser", paramString);
      }
    }
  }
  
  static SpannedString q(@Nullable String paramString1, String paramString2, List<f> paramList)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    ArrayDeque localArrayDeque = new ArrayDeque();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramString2.length())
    {
      char c1 = paramString2.charAt(i);
      int j;
      int k;
      if (c1 != '&')
      {
        if (c1 != '<')
        {
          localSpannableStringBuilder.append(c1);
          i++;
        }
        else
        {
          j = i + 1;
          int n;
          Object localObject;
          String str;
          if (j >= paramString2.length())
          {
            i = j;
          }
          else
          {
            k = paramString2.charAt(j);
            int m = 1;
            if (k == 47) {
              k = 1;
            } else {
              k = 0;
            }
            n = f(paramString2, j);
            int i1 = n - 2;
            if (paramString2.charAt(i1) == '/') {
              j = 1;
            } else {
              j = 0;
            }
            if (k != 0) {
              m = 2;
            }
            if (j == 0) {
              i1 = n - 1;
            }
            localObject = paramString2.substring(i + m, i1);
            if (((String)localObject).trim().isEmpty())
            {
              i = n;
            }
            else
            {
              str = j((String)localObject);
              if (k(str)) {
                break label231;
              }
              i = n;
            }
          }
          for (;;)
          {
            break;
            label231:
            if (k != 0)
            {
              do
              {
                if (localArrayDeque.isEmpty())
                {
                  i = n;
                  break;
                }
                localObject = (c)localArrayDeque.pop();
                d(paramString1, (c)localObject, localArrayList, localSpannableStringBuilder, paramList);
                if (!localArrayDeque.isEmpty()) {
                  localArrayList.add(new b((c)localObject, localSpannableStringBuilder.length(), null));
                } else {
                  localArrayList.clear();
                }
              } while (!((c)localObject).a.equals(str));
              i = n;
            }
            else
            {
              i = n;
              if (j == 0)
              {
                localArrayDeque.push(c.a((String)localObject, localSpannableStringBuilder.length()));
                i = n;
              }
            }
          }
        }
      }
      else
      {
        j = i + 1;
        i = paramString2.indexOf(';', j);
        k = paramString2.indexOf(' ', j);
        if (i == -1) {
          i = k;
        } else if (k != -1) {
          i = Math.min(i, k);
        }
        if (i != -1)
        {
          b(paramString2.substring(j, i), localSpannableStringBuilder);
          if (i == k) {
            localSpannableStringBuilder.append(" ");
          }
          i++;
        }
        else
        {
          localSpannableStringBuilder.append(c1);
          i = j;
        }
      }
    }
    while (!localArrayDeque.isEmpty()) {
      d(paramString1, (c)localArrayDeque.pop(), localArrayList, localSpannableStringBuilder, paramList);
    }
    d(paramString1, c.b(), Collections.emptyList(), localSpannableStringBuilder, paramList);
    return SpannedString.valueOf(localSpannableStringBuilder);
  }
  
  private static int r(String paramString)
  {
    paramString.hashCode();
    int i = paramString.hashCode();
    int j = -1;
    switch (i)
    {
    default: 
      break;
    case 109757538: 
      if (paramString.equals("start")) {
        j = 3;
      }
      break;
    case 100571: 
      if (paramString.equals("end")) {
        j = 2;
      }
      break;
    case -1074341483: 
      if (paramString.equals("middle")) {
        j = 1;
      }
      break;
    case -1364013995: 
      if (paramString.equals("center")) {
        j = 0;
      }
      break;
    }
    switch (j)
    {
    default: 
      if (paramString.length() != 0) {
        paramString = "Invalid anchor value: ".concat(paramString);
      } else {
        paramString = new String("Invalid anchor value: ");
      }
      u.h("WebvttCueParser", paramString);
      return Integer.MIN_VALUE;
    case 3: 
      return 0;
    case 2: 
      return 2;
    }
    return 1;
  }
  
  private static void s(String paramString, e parame)
  {
    int i = paramString.indexOf(',');
    String str = paramString;
    if (i != -1)
    {
      parame.g = r(paramString.substring(i + 1));
      str = paramString.substring(0, i);
    }
    if (str.endsWith("%"))
    {
      parame.e = j.c(str);
      parame.f = 0;
    }
    else
    {
      parame.e = Integer.parseInt(str);
      parame.f = 1;
    }
  }
  
  private static int t(String paramString)
  {
    paramString.hashCode();
    int i = paramString.hashCode();
    int j = -1;
    switch (i)
    {
    default: 
      break;
    case 109757538: 
      if (paramString.equals("start")) {
        j = 5;
      }
      break;
    case 100571: 
      if (paramString.equals("end")) {
        j = 4;
      }
      break;
    case -1074341483: 
      if (paramString.equals("middle")) {
        j = 3;
      }
      break;
    case -1276788989: 
      if (paramString.equals("line-right")) {
        j = 2;
      }
      break;
    case -1364013995: 
      if (paramString.equals("center")) {
        j = 1;
      }
      break;
    case -1842484672: 
      if (paramString.equals("line-left")) {
        j = 0;
      }
      break;
    }
    switch (j)
    {
    default: 
      if (paramString.length() != 0) {
        paramString = "Invalid anchor value: ".concat(paramString);
      } else {
        paramString = new String("Invalid anchor value: ");
      }
      u.h("WebvttCueParser", paramString);
      return Integer.MIN_VALUE;
    case 2: 
    case 4: 
      return 2;
    case 1: 
    case 3: 
      return 1;
    }
    return 0;
  }
  
  private static void u(String paramString, e parame)
  {
    int i = paramString.indexOf(',');
    String str = paramString;
    if (i != -1)
    {
      parame.i = t(paramString.substring(i + 1));
      str = paramString.substring(0, i);
    }
    parame.h = j.c(str);
  }
  
  private static int v(String paramString)
  {
    paramString.hashCode();
    int i = paramString.hashCode();
    int j = -1;
    switch (i)
    {
    default: 
      break;
    case 109757538: 
      if (paramString.equals("start")) {
        j = 5;
      }
      break;
    case 108511772: 
      if (paramString.equals("right")) {
        j = 4;
      }
      break;
    case 3317767: 
      if (paramString.equals("left")) {
        j = 3;
      }
      break;
    case 100571: 
      if (paramString.equals("end")) {
        j = 2;
      }
      break;
    case -1074341483: 
      if (paramString.equals("middle")) {
        j = 1;
      }
      break;
    case -1364013995: 
      if (paramString.equals("center")) {
        j = 0;
      }
      break;
    }
    switch (j)
    {
    default: 
      if (paramString.length() != 0) {
        paramString = "Invalid alignment value: ".concat(paramString);
      } else {
        paramString = new String("Invalid alignment value: ");
      }
      u.h("WebvttCueParser", paramString);
      return 2;
    case 5: 
      return 1;
    case 4: 
      return 5;
    case 3: 
      return 4;
    case 2: 
      return 3;
    }
    return 2;
  }
  
  private static int w(String paramString)
  {
    paramString.hashCode();
    if (!paramString.equals("lr"))
    {
      if (!paramString.equals("rl"))
      {
        if (paramString.length() != 0) {
          paramString = "Invalid 'vertical' value: ".concat(paramString);
        } else {
          paramString = new String("Invalid 'vertical' value: ");
        }
        u.h("WebvttCueParser", paramString);
        return Integer.MIN_VALUE;
      }
      return 1;
    }
    return 2;
  }
  
  private static class b
  {
    private static final Comparator<b> a = a.c;
    private final h.c b;
    private final int c;
    
    private b(h.c paramc, int paramInt)
    {
      this.b = paramc;
      this.c = paramInt;
    }
  }
  
  private static final class c
  {
    public final String a;
    public final int b;
    public final String c;
    public final Set<String> d;
    
    private c(String paramString1, int paramInt, String paramString2, Set<String> paramSet)
    {
      this.b = paramInt;
      this.a = paramString1;
      this.c = paramString2;
      this.d = paramSet;
    }
    
    public static c a(String paramString, int paramInt)
    {
      Object localObject = paramString.trim();
      boolean bool = ((String)localObject).isEmpty();
      int i = 1;
      com.google.android.exoplayer2.util.g.a(bool ^ true);
      int j = ((String)localObject).indexOf(" ");
      if (j == -1)
      {
        paramString = "";
      }
      else
      {
        paramString = ((String)localObject).substring(j).trim();
        localObject = ((String)localObject).substring(0, j);
      }
      localObject = o0.E0((String)localObject, "\\.");
      String str = localObject[0];
      HashSet localHashSet = new HashSet();
      while (i < localObject.length)
      {
        localHashSet.add(localObject[i]);
        i++;
      }
      return new c(str, paramInt, paramString, localHashSet);
    }
    
    public static c b()
    {
      return new c("", 0, "", Collections.emptySet());
    }
  }
  
  private static final class d
    implements Comparable<d>
  {
    public final int c;
    public final f d;
    
    public d(int paramInt, f paramf)
    {
      this.c = paramInt;
      this.d = paramf;
    }
    
    public int a(d paramd)
    {
      return Integer.compare(this.c, paramd.c);
    }
  }
  
  private static final class e
  {
    public long a = 0L;
    public long b = 0L;
    public CharSequence c;
    public int d = 2;
    public float e = -3.4028235E38F;
    public int f = 1;
    public int g = 0;
    public float h = -3.4028235E38F;
    public int i = Integer.MIN_VALUE;
    public float j = 1.0F;
    public int k = Integer.MIN_VALUE;
    
    private static float b(float paramFloat, int paramInt)
    {
      boolean bool = paramFloat < -3.4028235E38F;
      if ((bool) && (paramInt == 0) && ((paramFloat < 0.0F) || (paramFloat > 1.0F))) {
        return 1.0F;
      }
      if (bool) {
        return paramFloat;
      }
      if (paramInt == 0) {
        return 1.0F;
      }
      return -3.4028235E38F;
    }
    
    @Nullable
    private static Layout.Alignment c(int paramInt)
    {
      if (paramInt != 1) {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt == 4) {
              break label67;
            }
            if (paramInt != 5)
            {
              StringBuilder localStringBuilder = new StringBuilder(34);
              localStringBuilder.append("Unknown textAlignment: ");
              localStringBuilder.append(paramInt);
              u.h("WebvttCueParser", localStringBuilder.toString());
              return null;
            }
          }
          return Layout.Alignment.ALIGN_OPPOSITE;
        }
        else
        {
          return Layout.Alignment.ALIGN_CENTER;
        }
      }
      label67:
      return Layout.Alignment.ALIGN_NORMAL;
    }
    
    private static float d(int paramInt, float paramFloat)
    {
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt == 2) {
            return paramFloat;
          }
          throw new IllegalStateException(String.valueOf(paramInt));
        }
        if (paramFloat <= 0.5F) {
          return paramFloat * 2.0F;
        }
        return (1.0F - paramFloat) * 2.0F;
      }
      return 1.0F - paramFloat;
    }
    
    private static float e(int paramInt)
    {
      if (paramInt != 4)
      {
        if (paramInt != 5) {
          return 0.5F;
        }
        return 1.0F;
      }
      return 0.0F;
    }
    
    private static int f(int paramInt)
    {
      if (paramInt != 1)
      {
        if (paramInt != 3)
        {
          if (paramInt == 4) {
            break label24;
          }
          if (paramInt != 5) {
            return 1;
          }
        }
        return 2;
      }
      label24:
      return 0;
    }
    
    public g a()
    {
      return new g(g().a(), this.a, this.b);
    }
    
    public c.b g()
    {
      float f1 = this.h;
      if (f1 == -3.4028235E38F) {
        f1 = e(this.d);
      }
      int m = this.i;
      if (m == Integer.MIN_VALUE) {
        m = f(this.d);
      }
      c.b localb = new c.b().p(c(this.d)).h(b(this.e, this.f), this.f).i(this.g).k(f1).l(m).n(Math.min(this.j, d(m, f1))).r(this.k);
      CharSequence localCharSequence = this.c;
      if (localCharSequence != null) {
        localb.o(localCharSequence);
      }
      return localb;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\text\u\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */