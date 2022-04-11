package com.google.android.exoplayer2.text.s;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableStringBuilder;
import android.util.Base64;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.text.c;
import com.google.android.exoplayer2.text.c.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

final class d
{
  @Nullable
  public final String a;
  @Nullable
  public final String b;
  public final boolean c;
  public final long d;
  public final long e;
  @Nullable
  public final g f;
  @Nullable
  private final String[] g;
  public final String h;
  @Nullable
  public final String i;
  @Nullable
  public final d j;
  private final HashMap<String, Integer> k;
  private final HashMap<String, Integer> l;
  private List<d> m;
  
  private d(@Nullable String paramString1, @Nullable String paramString2, long paramLong1, long paramLong2, @Nullable g paramg, @Nullable String[] paramArrayOfString, String paramString3, @Nullable String paramString4, @Nullable d paramd)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.i = paramString4;
    this.f = paramg;
    this.g = paramArrayOfString;
    boolean bool;
    if (paramString2 != null) {
      bool = true;
    } else {
      bool = false;
    }
    this.c = bool;
    this.d = paramLong1;
    this.e = paramLong2;
    this.h = ((String)com.google.android.exoplayer2.util.g.e(paramString3));
    this.j = paramd;
    this.k = new HashMap();
    this.l = new HashMap();
  }
  
  private void b(Map<String, g> paramMap, c.b paramb, int paramInt1, int paramInt2, int paramInt3)
  {
    g localg = f.f(this.f, this.g, paramMap);
    SpannableStringBuilder localSpannableStringBuilder1 = (SpannableStringBuilder)paramb.e();
    SpannableStringBuilder localSpannableStringBuilder2 = localSpannableStringBuilder1;
    if (localSpannableStringBuilder1 == null)
    {
      localSpannableStringBuilder2 = new SpannableStringBuilder();
      paramb.o(localSpannableStringBuilder2);
    }
    if (localg != null)
    {
      f.a(localSpannableStringBuilder2, paramInt1, paramInt2, localg, this.j, paramMap, paramInt3);
      if ("p".equals(this.a))
      {
        if (localg.k() != Float.MAX_VALUE) {
          paramb.m(localg.k() * -90.0F / 100.0F);
        }
        if (localg.m() != null) {
          paramb.p(localg.m());
        }
        if (localg.h() != null) {
          paramb.j(localg.h());
        }
      }
    }
  }
  
  public static d c(@Nullable String paramString1, long paramLong1, long paramLong2, @Nullable g paramg, @Nullable String[] paramArrayOfString, String paramString2, @Nullable String paramString3, @Nullable d paramd)
  {
    return new d(paramString1, null, paramLong1, paramLong2, paramg, paramArrayOfString, paramString2, paramString3, paramd);
  }
  
  public static d d(String paramString)
  {
    return new d(null, f.b(paramString), -9223372036854775807L, -9223372036854775807L, null, null, "", null, null);
  }
  
  private static void e(SpannableStringBuilder paramSpannableStringBuilder)
  {
    int n = paramSpannableStringBuilder.length();
    int i1 = 0;
    for (a locala : (a[])paramSpannableStringBuilder.getSpans(0, n, a.class)) {
      paramSpannableStringBuilder.replace(paramSpannableStringBuilder.getSpanStart(locala), paramSpannableStringBuilder.getSpanEnd(locala), "");
    }
    for (n = 0; n < paramSpannableStringBuilder.length(); n++) {
      if (paramSpannableStringBuilder.charAt(n) == ' ')
      {
        int i3 = n + 1;
        for (??? = i3; (??? < paramSpannableStringBuilder.length()) && (paramSpannableStringBuilder.charAt(???) == ' '); ???++) {}
        ??? -= i3;
        if (??? > 0) {
          paramSpannableStringBuilder.delete(n, ??? + n);
        }
      }
    }
    if ((paramSpannableStringBuilder.length() > 0) && (paramSpannableStringBuilder.charAt(0) == ' ')) {
      paramSpannableStringBuilder.delete(0, 1);
    }
    for (n = 0; n < paramSpannableStringBuilder.length() - 1; n++) {
      if (paramSpannableStringBuilder.charAt(n) == '\n')
      {
        ??? = n + 1;
        if (paramSpannableStringBuilder.charAt(???) == ' ') {
          paramSpannableStringBuilder.delete(???, n + 2);
        }
      }
    }
    n = i1;
    if (paramSpannableStringBuilder.length() > 0)
    {
      n = i1;
      if (paramSpannableStringBuilder.charAt(paramSpannableStringBuilder.length() - 1) == ' ') {
        paramSpannableStringBuilder.delete(paramSpannableStringBuilder.length() - 1, paramSpannableStringBuilder.length());
      }
    }
    for (n = i1; n < paramSpannableStringBuilder.length() - 1; n++) {
      if (paramSpannableStringBuilder.charAt(n) == ' ')
      {
        ??? = n + 1;
        if (paramSpannableStringBuilder.charAt(???) == '\n') {
          paramSpannableStringBuilder.delete(n, ???);
        }
      }
    }
    if ((paramSpannableStringBuilder.length() > 0) && (paramSpannableStringBuilder.charAt(paramSpannableStringBuilder.length() - 1) == '\n')) {
      paramSpannableStringBuilder.delete(paramSpannableStringBuilder.length() - 1, paramSpannableStringBuilder.length());
    }
  }
  
  private void i(TreeSet<Long> paramTreeSet, boolean paramBoolean)
  {
    boolean bool1 = "p".equals(this.a);
    boolean bool2 = "div".equals(this.a);
    if ((paramBoolean) || (bool1) || ((bool2) && (this.i != null)))
    {
      long l1 = this.d;
      if (l1 != -9223372036854775807L) {
        paramTreeSet.add(Long.valueOf(l1));
      }
      l1 = this.e;
      if (l1 != -9223372036854775807L) {
        paramTreeSet.add(Long.valueOf(l1));
      }
    }
    if (this.m == null) {
      return;
    }
    for (int n = 0; n < this.m.size(); n++)
    {
      d locald = (d)this.m.get(n);
      if ((!paramBoolean) && (!bool1)) {
        bool2 = false;
      } else {
        bool2 = true;
      }
      locald.i(paramTreeSet, bool2);
    }
  }
  
  private static SpannableStringBuilder k(String paramString, Map<String, c.b> paramMap)
  {
    if (!paramMap.containsKey(paramString))
    {
      c.b localb = new c.b();
      localb.o(new SpannableStringBuilder());
      paramMap.put(paramString, localb);
    }
    return (SpannableStringBuilder)com.google.android.exoplayer2.util.g.e(((c.b)paramMap.get(paramString)).e());
  }
  
  private void n(long paramLong, String paramString, List<Pair<String, String>> paramList)
  {
    if (!"".equals(this.h)) {
      paramString = this.h;
    }
    if ((m(paramLong)) && ("div".equals(this.a)) && (this.i != null))
    {
      paramList.add(new Pair(paramString, this.i));
      return;
    }
    for (int n = 0; n < g(); n++) {
      f(n).n(paramLong, paramString, paramList);
    }
  }
  
  private void o(long paramLong, Map<String, g> paramMap, Map<String, e> paramMap1, String paramString, Map<String, c.b> paramMap2)
  {
    if (!m(paramLong)) {
      return;
    }
    if (!"".equals(this.h)) {
      paramString = this.h;
    }
    Iterator localIterator = this.l.entrySet().iterator();
    int n;
    for (;;)
    {
      boolean bool = localIterator.hasNext();
      n = 0;
      if (!bool) {
        break;
      }
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str = (String)localEntry.getKey();
      if (this.k.containsKey(str)) {
        n = ((Integer)this.k.get(str)).intValue();
      } else {
        n = 0;
      }
      int i1 = ((Integer)localEntry.getValue()).intValue();
      if (n != i1) {
        b(paramMap, (c.b)com.google.android.exoplayer2.util.g.e((c.b)paramMap2.get(str)), n, i1, ((e)com.google.android.exoplayer2.util.g.e((e)paramMap1.get(paramString))).j);
      }
    }
    while (n < g())
    {
      f(n).o(paramLong, paramMap, paramMap1, paramString, paramMap2);
      n++;
    }
  }
  
  private void p(long paramLong, boolean paramBoolean, String paramString, Map<String, c.b> paramMap)
  {
    this.k.clear();
    this.l.clear();
    if ("metadata".equals(this.a)) {
      return;
    }
    if (!"".equals(this.h)) {
      paramString = this.h;
    }
    if ((this.c) && (paramBoolean))
    {
      k(paramString, paramMap).append((CharSequence)com.google.android.exoplayer2.util.g.e(this.b));
    }
    else if (("br".equals(this.a)) && (paramBoolean))
    {
      k(paramString, paramMap).append('\n');
    }
    else if (m(paramLong))
    {
      Iterator localIterator = paramMap.entrySet().iterator();
      Object localObject;
      while (localIterator.hasNext())
      {
        localObject = (Map.Entry)localIterator.next();
        this.k.put((String)((Map.Entry)localObject).getKey(), Integer.valueOf(((CharSequence)com.google.android.exoplayer2.util.g.e(((c.b)((Map.Entry)localObject).getValue()).e())).length()));
      }
      boolean bool1 = "p".equals(this.a);
      for (int n = 0; n < g(); n++)
      {
        localObject = f(n);
        boolean bool2;
        if ((!paramBoolean) && (!bool1)) {
          bool2 = false;
        } else {
          bool2 = true;
        }
        ((d)localObject).p(paramLong, bool2, paramString, paramMap);
      }
      if (bool1) {
        f.c(k(paramString, paramMap));
      }
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        paramString = (Map.Entry)paramMap.next();
        this.l.put((String)paramString.getKey(), Integer.valueOf(((CharSequence)com.google.android.exoplayer2.util.g.e(((c.b)paramString.getValue()).e())).length()));
      }
    }
  }
  
  public void a(d paramd)
  {
    if (this.m == null) {
      this.m = new ArrayList();
    }
    this.m.add(paramd);
  }
  
  public d f(int paramInt)
  {
    List localList = this.m;
    if (localList != null) {
      return (d)localList.get(paramInt);
    }
    throw new IndexOutOfBoundsException();
  }
  
  public int g()
  {
    List localList = this.m;
    int n;
    if (localList == null) {
      n = 0;
    } else {
      n = localList.size();
    }
    return n;
  }
  
  public List<c> h(long paramLong, Map<String, g> paramMap, Map<String, e> paramMap1, Map<String, String> paramMap2)
  {
    Object localObject1 = new ArrayList();
    n(paramLong, this.h, (List)localObject1);
    Object localObject2 = new TreeMap();
    p(paramLong, false, this.h, (Map)localObject2);
    o(paramLong, paramMap, paramMap1, this.h, (Map)localObject2);
    paramMap = new ArrayList();
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject3 = (Pair)((Iterator)localObject1).next();
      Object localObject4 = (String)paramMap2.get(((Pair)localObject3).second);
      if (localObject4 != null)
      {
        localObject4 = Base64.decode((String)localObject4, 0);
        localObject4 = BitmapFactory.decodeByteArray((byte[])localObject4, 0, localObject4.length);
        localObject3 = (e)com.google.android.exoplayer2.util.g.e((e)paramMap1.get(((Pair)localObject3).first));
        paramMap.add(new c.b().f((Bitmap)localObject4).k(((e)localObject3).b).l(0).h(((e)localObject3).c, 0).i(((e)localObject3).e).n(((e)localObject3).f).g(((e)localObject3).g).r(((e)localObject3).j).a());
      }
    }
    paramMap2 = ((TreeMap)localObject2).entrySet().iterator();
    while (paramMap2.hasNext())
    {
      localObject1 = (Map.Entry)paramMap2.next();
      localObject2 = (e)com.google.android.exoplayer2.util.g.e((e)paramMap1.get(((Map.Entry)localObject1).getKey()));
      localObject1 = (c.b)((Map.Entry)localObject1).getValue();
      e((SpannableStringBuilder)com.google.android.exoplayer2.util.g.e(((c.b)localObject1).e()));
      ((c.b)localObject1).h(((e)localObject2).c, ((e)localObject2).d);
      ((c.b)localObject1).i(((e)localObject2).e);
      ((c.b)localObject1).k(((e)localObject2).b);
      ((c.b)localObject1).n(((e)localObject2).f);
      ((c.b)localObject1).q(((e)localObject2).i, ((e)localObject2).h);
      ((c.b)localObject1).r(((e)localObject2).j);
      paramMap.add(((c.b)localObject1).a());
    }
    return paramMap;
  }
  
  public long[] j()
  {
    Object localObject = new TreeSet();
    int n = 0;
    i((TreeSet)localObject, false);
    long[] arrayOfLong = new long[((TreeSet)localObject).size()];
    localObject = ((TreeSet)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      arrayOfLong[n] = ((Long)((Iterator)localObject).next()).longValue();
      n++;
    }
    return arrayOfLong;
  }
  
  @Nullable
  public String[] l()
  {
    return this.g;
  }
  
  public boolean m(long paramLong)
  {
    long l1 = this.d;
    boolean bool;
    if (((l1 == -9223372036854775807L) && (this.e == -9223372036854775807L)) || ((l1 <= paramLong) && (this.e == -9223372036854775807L)) || ((l1 == -9223372036854775807L) && (paramLong < this.e)) || ((l1 <= paramLong) && (paramLong < this.e))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\text\s\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */