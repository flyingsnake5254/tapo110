package com.google.android.exoplayer2.text.s;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.text.p.c;
import com.google.android.exoplayer2.text.p.e;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.u;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

final class f
{
  public static void a(Spannable paramSpannable, int paramInt1, int paramInt2, g paramg, @Nullable d paramd, Map<String, g> paramMap, int paramInt3)
  {
    if (paramg.l() != -1) {
      paramSpannable.setSpan(new StyleSpan(paramg.l()), paramInt1, paramInt2, 33);
    }
    if (paramg.s()) {
      paramSpannable.setSpan(new StrikethroughSpan(), paramInt1, paramInt2, 33);
    }
    if (paramg.t()) {
      paramSpannable.setSpan(new UnderlineSpan(), paramInt1, paramInt2, 33);
    }
    if (paramg.q()) {
      com.google.android.exoplayer2.text.p.d.a(paramSpannable, new ForegroundColorSpan(paramg.c()), paramInt1, paramInt2, 33);
    }
    if (paramg.p()) {
      com.google.android.exoplayer2.text.p.d.a(paramSpannable, new BackgroundColorSpan(paramg.b()), paramInt1, paramInt2, 33);
    }
    if (paramg.d() != null) {
      com.google.android.exoplayer2.text.p.d.a(paramSpannable, new TypefaceSpan(paramg.d()), paramInt1, paramInt2, 33);
    }
    Object localObject1;
    int j;
    if (paramg.o() != null)
    {
      localObject1 = (b)com.google.android.exoplayer2.util.g.e(paramg.o());
      int i = ((b)localObject1).f;
      if (i == -1)
      {
        if ((paramInt3 != 2) && (paramInt3 != 1)) {
          paramInt3 = 1;
        } else {
          paramInt3 = 3;
        }
        j = 1;
      }
      else
      {
        j = ((b)localObject1).g;
        paramInt3 = i;
      }
      int k = ((b)localObject1).h;
      i = k;
      if (k == -2) {
        i = 1;
      }
      com.google.android.exoplayer2.text.p.d.a(paramSpannable, new e(paramInt3, j, i), paramInt1, paramInt2, 33);
    }
    paramInt3 = paramg.j();
    if (paramInt3 != 2)
    {
      if ((paramInt3 == 3) || (paramInt3 == 4)) {
        paramSpannable.setSpan(new a(), paramInt1, paramInt2, 33);
      }
    }
    else
    {
      localObject1 = d(paramd, paramMap);
      if (localObject1 != null)
      {
        Object localObject2 = e((d)localObject1, paramMap);
        if (localObject2 != null) {
          if ((((d)localObject2).g() == 1) && (((d)localObject2).f(0).b != null))
          {
            paramd = (String)o0.i(((d)localObject2).f(0).b);
            localObject2 = f(((d)localObject2).f, ((d)localObject2).l(), paramMap);
            if (localObject2 != null) {
              paramInt3 = ((g)localObject2).i();
            } else {
              paramInt3 = -1;
            }
            j = paramInt3;
            if (paramInt3 == -1)
            {
              paramMap = f(((d)localObject1).f, ((d)localObject1).l(), paramMap);
              j = paramInt3;
              if (paramMap != null) {
                j = paramMap.i();
              }
            }
            paramSpannable.setSpan(new c(paramd, j), paramInt1, paramInt2, 33);
          }
          else
          {
            u.f("TtmlRenderUtil", "Skipping rubyText node without exactly one text child.");
          }
        }
      }
    }
    if (paramg.n()) {
      com.google.android.exoplayer2.text.p.d.a(paramSpannable, new com.google.android.exoplayer2.text.p.a(), paramInt1, paramInt2, 33);
    }
    paramInt3 = paramg.f();
    if (paramInt3 != 1)
    {
      if (paramInt3 != 2)
      {
        if (paramInt3 == 3) {
          com.google.android.exoplayer2.text.p.d.a(paramSpannable, new RelativeSizeSpan(paramg.e() / 100.0F), paramInt1, paramInt2, 33);
        }
      }
      else {
        com.google.android.exoplayer2.text.p.d.a(paramSpannable, new RelativeSizeSpan(paramg.e()), paramInt1, paramInt2, 33);
      }
    }
    else {
      com.google.android.exoplayer2.text.p.d.a(paramSpannable, new AbsoluteSizeSpan((int)paramg.e(), true), paramInt1, paramInt2, 33);
    }
  }
  
  static String b(String paramString)
  {
    return paramString.replaceAll("\r\n", "\n").replaceAll(" *\n *", "\n").replaceAll("\n", " ").replaceAll("[ \t\\x0B\f\r]+", " ");
  }
  
  static void c(SpannableStringBuilder paramSpannableStringBuilder)
  {
    for (int i = paramSpannableStringBuilder.length() - 1; (i >= 0) && (paramSpannableStringBuilder.charAt(i) == ' '); i--) {}
    if ((i >= 0) && (paramSpannableStringBuilder.charAt(i) != '\n')) {
      paramSpannableStringBuilder.append('\n');
    }
  }
  
  @Nullable
  private static d d(@Nullable d paramd, Map<String, g> paramMap)
  {
    while (paramd != null)
    {
      g localg = f(paramd.f, paramd.l(), paramMap);
      if ((localg != null) && (localg.j() == 1)) {
        return paramd;
      }
      paramd = paramd.j;
    }
    return null;
  }
  
  @Nullable
  private static d e(d paramd, Map<String, g> paramMap)
  {
    ArrayDeque localArrayDeque = new ArrayDeque();
    localArrayDeque.push(paramd);
    while (!localArrayDeque.isEmpty())
    {
      d locald = (d)localArrayDeque.pop();
      paramd = f(locald.f, locald.l(), paramMap);
      if ((paramd != null) && (paramd.j() == 3)) {
        return locald;
      }
      for (int i = locald.g() - 1; i >= 0; i--) {
        localArrayDeque.push(locald.f(i));
      }
    }
    return null;
  }
  
  @Nullable
  public static g f(@Nullable g paramg, @Nullable String[] paramArrayOfString, Map<String, g> paramMap)
  {
    int i = 0;
    int j = 0;
    if (paramg == null)
    {
      if (paramArrayOfString == null) {
        return null;
      }
      if (paramArrayOfString.length == 1) {
        return (g)paramMap.get(paramArrayOfString[0]);
      }
      if (paramArrayOfString.length > 1)
      {
        paramg = new g();
        i = paramArrayOfString.length;
        while (j < i)
        {
          paramg.a((g)paramMap.get(paramArrayOfString[j]));
          j++;
        }
        return paramg;
      }
    }
    else
    {
      if ((paramArrayOfString != null) && (paramArrayOfString.length == 1)) {
        return paramg.a((g)paramMap.get(paramArrayOfString[0]));
      }
      if ((paramArrayOfString != null) && (paramArrayOfString.length > 1))
      {
        int k = paramArrayOfString.length;
        for (j = i; j < k; j++) {
          paramg.a((g)paramMap.get(paramArrayOfString[j]));
        }
      }
    }
    return paramg;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\text\s\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */