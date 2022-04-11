package com.google.android.exoplayer2.ui;

import android.text.Html;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.text.p.a;
import com.google.android.exoplayer2.text.p.c;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import com.google.common.collect.ImmutableMap;
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

final class u0
{
  private static final Pattern a = Pattern.compile("(&#13;)?&#10;");
  
  public static b a(@Nullable CharSequence paramCharSequence, float paramFloat)
  {
    if (paramCharSequence == null) {
      return new b("", ImmutableMap.of(), null);
    }
    if (!(paramCharSequence instanceof Spanned)) {
      return new b(b(paramCharSequence), ImmutableMap.of(), null);
    }
    paramCharSequence = (Spanned)paramCharSequence;
    Object localObject1 = new HashSet();
    int i = paramCharSequence.length();
    int j = 0;
    Object localObject2 = (BackgroundColorSpan[])paramCharSequence.getSpans(0, i, BackgroundColorSpan.class);
    int k = localObject2.length;
    for (i = 0; i < k; i++) {
      ((Set)localObject1).add(Integer.valueOf(localObject2[i].getBackgroundColor()));
    }
    localObject2 = new HashMap();
    Object localObject3 = ((Set)localObject1).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      i = ((Integer)((Iterator)localObject3).next()).intValue();
      localObject1 = new StringBuilder(14);
      ((StringBuilder)localObject1).append("bg_");
      ((StringBuilder)localObject1).append(i);
      ((HashMap)localObject2).put(h0.a(((StringBuilder)localObject1).toString()), o0.A("background-color:%s;", new Object[] { h0.b(i) }));
    }
    localObject3 = c(paramCharSequence, paramFloat);
    localObject1 = new StringBuilder(paramCharSequence.length());
    for (i = 0; j < ((SparseArray)localObject3).size(); i = k)
    {
      k = ((SparseArray)localObject3).keyAt(j);
      ((StringBuilder)localObject1).append(b(paramCharSequence.subSequence(i, k)));
      d locald = (d)((SparseArray)localObject3).get(k);
      Collections.sort(d.a(locald), c.a());
      Iterator localIterator = d.a(locald).iterator();
      while (localIterator.hasNext()) {
        ((StringBuilder)localObject1).append(((c)localIterator.next()).f);
      }
      Collections.sort(d.b(locald), c.b());
      localIterator = d.b(locald).iterator();
      while (localIterator.hasNext()) {
        ((StringBuilder)localObject1).append(((c)localIterator.next()).e);
      }
      j++;
    }
    ((StringBuilder)localObject1).append(b(paramCharSequence.subSequence(i, paramCharSequence.length())));
    return new b(((StringBuilder)localObject1).toString(), (Map)localObject2, null);
  }
  
  private static String b(CharSequence paramCharSequence)
  {
    paramCharSequence = Html.escapeHtml(paramCharSequence);
    return a.matcher(paramCharSequence).replaceAll("<br>");
  }
  
  private static SparseArray<d> c(Spanned paramSpanned, float paramFloat)
  {
    SparseArray localSparseArray = new SparseArray();
    int i = paramSpanned.length();
    int j = 0;
    Object[] arrayOfObject = paramSpanned.getSpans(0, i, Object.class);
    i = arrayOfObject.length;
    while (j < i)
    {
      Object localObject1 = arrayOfObject[j];
      Object localObject2 = e(localObject1, paramFloat);
      String str = d(localObject1);
      int k = paramSpanned.getSpanStart(localObject1);
      int m = paramSpanned.getSpanEnd(localObject1);
      if (localObject2 != null)
      {
        g.e(str);
        localObject2 = new c(k, m, (String)localObject2, str, null);
        d.b(f(localSparseArray, k)).add(localObject2);
        d.a(f(localSparseArray, m)).add(localObject2);
      }
      j++;
    }
    return localSparseArray;
  }
  
  @Nullable
  private static String d(Object paramObject)
  {
    boolean bool = paramObject instanceof StrikethroughSpan;
    Object localObject = "</span>";
    if ((!bool) && (!(paramObject instanceof ForegroundColorSpan)) && (!(paramObject instanceof BackgroundColorSpan)) && (!(paramObject instanceof a)) && (!(paramObject instanceof AbsoluteSizeSpan)) && (!(paramObject instanceof RelativeSizeSpan)) && (!(paramObject instanceof com.google.android.exoplayer2.text.p.e)))
    {
      if ((paramObject instanceof TypefaceSpan))
      {
        if (((TypefaceSpan)paramObject).getFamily() != null) {
          paramObject = localObject;
        } else {
          paramObject = null;
        }
        return (String)paramObject;
      }
      if ((paramObject instanceof StyleSpan))
      {
        int i = ((StyleSpan)paramObject).getStyle();
        if (i != 1)
        {
          if (i != 2)
          {
            if (i == 3) {
              return "</i></b>";
            }
          }
          else {
            return "</i>";
          }
        }
        else {
          return "</b>";
        }
      }
      else
      {
        if ((paramObject instanceof c))
        {
          paramObject = b(((c)paramObject).a);
          localObject = new StringBuilder(String.valueOf(paramObject).length() + 16);
          ((StringBuilder)localObject).append("<rt>");
          ((StringBuilder)localObject).append((String)paramObject);
          ((StringBuilder)localObject).append("</rt></ruby>");
          return ((StringBuilder)localObject).toString();
        }
        if ((paramObject instanceof UnderlineSpan)) {
          return "</u>";
        }
      }
      return null;
    }
    return "</span>";
  }
  
  @Nullable
  private static String e(Object paramObject, float paramFloat)
  {
    if ((paramObject instanceof StrikethroughSpan)) {
      return "<span style='text-decoration:line-through;'>";
    }
    if ((paramObject instanceof ForegroundColorSpan)) {
      return o0.A("<span style='color:%s;'>", new Object[] { h0.b(((ForegroundColorSpan)paramObject).getForegroundColor()) });
    }
    if ((paramObject instanceof BackgroundColorSpan)) {
      return o0.A("<span class='bg_%s'>", new Object[] { Integer.valueOf(((BackgroundColorSpan)paramObject).getBackgroundColor()) });
    }
    if ((paramObject instanceof a)) {
      return "<span style='text-combine-upright:all;'>";
    }
    if ((paramObject instanceof AbsoluteSizeSpan))
    {
      paramObject = (AbsoluteSizeSpan)paramObject;
      if (((AbsoluteSizeSpan)paramObject).getDip()) {
        paramFloat = ((AbsoluteSizeSpan)paramObject).getSize();
      } else {
        paramFloat = ((AbsoluteSizeSpan)paramObject).getSize() / paramFloat;
      }
      return o0.A("<span style='font-size:%.2fpx;'>", new Object[] { Float.valueOf(paramFloat) });
    }
    if ((paramObject instanceof RelativeSizeSpan)) {
      return o0.A("<span style='font-size:%.2f%%;'>", new Object[] { Float.valueOf(((RelativeSizeSpan)paramObject).getSizeChange() * 100.0F) });
    }
    boolean bool = paramObject instanceof TypefaceSpan;
    Object localObject = null;
    if (bool)
    {
      String str = ((TypefaceSpan)paramObject).getFamily();
      paramObject = localObject;
      if (str != null) {
        paramObject = o0.A("<span style='font-family:\"%s\";'>", new Object[] { str });
      }
      return (String)paramObject;
    }
    int i;
    if ((paramObject instanceof StyleSpan))
    {
      i = ((StyleSpan)paramObject).getStyle();
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return null;
          }
          return "<b><i>";
        }
        return "<i>";
      }
      return "<b>";
    }
    if ((paramObject instanceof c))
    {
      i = ((c)paramObject).b;
      if (i != -1)
      {
        if (i != 1)
        {
          if (i != 2) {
            return null;
          }
          return "<ruby style='ruby-position:under;'>";
        }
        return "<ruby style='ruby-position:over;'>";
      }
      return "<ruby style='ruby-position:unset;'>";
    }
    if ((paramObject instanceof UnderlineSpan)) {
      return "<u>";
    }
    if ((paramObject instanceof com.google.android.exoplayer2.text.p.e))
    {
      paramObject = (com.google.android.exoplayer2.text.p.e)paramObject;
      return o0.A("<span style='-webkit-text-emphasis-style:%1$s;text-emphasis-style:%1$s;-webkit-text-emphasis-position:%2$s;text-emphasis-position:%2$s;display:inline-block;'>", new Object[] { h(((com.google.android.exoplayer2.text.p.e)paramObject).a, ((com.google.android.exoplayer2.text.p.e)paramObject).b), g(((com.google.android.exoplayer2.text.p.e)paramObject).c) });
    }
    return null;
  }
  
  private static d f(SparseArray<d> paramSparseArray, int paramInt)
  {
    d locald1 = (d)paramSparseArray.get(paramInt);
    d locald2 = locald1;
    if (locald1 == null)
    {
      locald2 = new d();
      paramSparseArray.put(paramInt, locald2);
    }
    return locald2;
  }
  
  private static String g(int paramInt)
  {
    if (paramInt != 2) {
      return "over right";
    }
    return "under left";
  }
  
  private static String h(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramInt2 != 1)
    {
      if (paramInt2 == 2) {
        localStringBuilder.append("open ");
      }
    }
    else {
      localStringBuilder.append("filled ");
    }
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 != 2)
        {
          if (paramInt1 != 3) {
            localStringBuilder.append("unset");
          } else {
            localStringBuilder.append("sesame");
          }
        }
        else {
          localStringBuilder.append("dot");
        }
      }
      else {
        localStringBuilder.append("circle");
      }
    }
    else {
      localStringBuilder.append("none");
    }
    return localStringBuilder.toString();
  }
  
  public static class b
  {
    public final String a;
    public final Map<String, String> b;
    
    private b(String paramString, Map<String, String> paramMap)
    {
      this.a = paramString;
      this.b = paramMap;
    }
  }
  
  private static final class c
  {
    private static final Comparator<c> a = e.c;
    private static final Comparator<c> b = f.c;
    public final int c;
    public final int d;
    public final String e;
    public final String f;
    
    private c(int paramInt1, int paramInt2, String paramString1, String paramString2)
    {
      this.c = paramInt1;
      this.d = paramInt2;
      this.e = paramString1;
      this.f = paramString2;
    }
  }
  
  private static final class d
  {
    private final List<u0.c> a = new ArrayList();
    private final List<u0.c> b = new ArrayList();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\ui\u0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */