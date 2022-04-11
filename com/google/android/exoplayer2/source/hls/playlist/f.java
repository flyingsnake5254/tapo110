package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format.b;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.offline.StreamKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class f
  extends h
{
  public static final f d = new f("", Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), null, Collections.emptyList(), false, Collections.emptyMap(), Collections.emptyList());
  public final List<Uri> e;
  public final List<b> f;
  public final List<a> g;
  public final List<a> h;
  public final List<a> i;
  public final List<a> j;
  @Nullable
  public final Format k;
  @Nullable
  public final List<Format> l;
  public final Map<String, String> m;
  public final List<DrmInitData> n;
  
  public f(String paramString, List<String> paramList, List<b> paramList1, List<a> paramList2, List<a> paramList3, List<a> paramList4, List<a> paramList5, @Nullable Format paramFormat, @Nullable List<Format> paramList6, boolean paramBoolean, Map<String, String> paramMap, List<DrmInitData> paramList7)
  {
    super(paramString, paramList, paramBoolean);
    this.e = Collections.unmodifiableList(f(paramList1, paramList2, paramList3, paramList4, paramList5));
    this.f = Collections.unmodifiableList(paramList1);
    this.g = Collections.unmodifiableList(paramList2);
    this.h = Collections.unmodifiableList(paramList3);
    this.i = Collections.unmodifiableList(paramList4);
    this.j = Collections.unmodifiableList(paramList5);
    this.k = paramFormat;
    if (paramList6 != null) {
      paramString = Collections.unmodifiableList(paramList6);
    } else {
      paramString = null;
    }
    this.l = paramString;
    this.m = Collections.unmodifiableMap(paramMap);
    this.n = Collections.unmodifiableList(paramList7);
  }
  
  private static void b(List<a> paramList, List<Uri> paramList1)
  {
    for (int i1 = 0; i1 < paramList.size(); i1++)
    {
      Uri localUri = ((a)paramList.get(i1)).a;
      if ((localUri != null) && (!paramList1.contains(localUri))) {
        paramList1.add(localUri);
      }
    }
  }
  
  private static <T> List<T> d(List<T> paramList, int paramInt, List<StreamKey> paramList1)
  {
    ArrayList localArrayList = new ArrayList(paramList1.size());
    for (int i1 = 0; i1 < paramList.size(); i1++)
    {
      Object localObject = paramList.get(i1);
      for (int i2 = 0; i2 < paramList1.size(); i2++)
      {
        StreamKey localStreamKey = (StreamKey)paramList1.get(i2);
        if ((localStreamKey.d == paramInt) && (localStreamKey.f == i1))
        {
          localArrayList.add(localObject);
          break;
        }
      }
    }
    return localArrayList;
  }
  
  public static f e(String paramString)
  {
    paramString = Collections.singletonList(b.b(Uri.parse(paramString)));
    return new f("", Collections.emptyList(), paramString, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), null, null, false, Collections.emptyMap(), Collections.emptyList());
  }
  
  private static List<Uri> f(List<b> paramList, List<a> paramList1, List<a> paramList2, List<a> paramList3, List<a> paramList4)
  {
    ArrayList localArrayList = new ArrayList();
    for (int i1 = 0; i1 < paramList.size(); i1++)
    {
      Uri localUri = ((b)paramList.get(i1)).a;
      if (!localArrayList.contains(localUri)) {
        localArrayList.add(localUri);
      }
    }
    b(paramList1, localArrayList);
    b(paramList2, localArrayList);
    b(paramList3, localArrayList);
    b(paramList4, localArrayList);
    return localArrayList;
  }
  
  public f c(List<StreamKey> paramList)
  {
    return new f(this.a, this.b, d(this.f, 0, paramList), Collections.emptyList(), d(this.h, 1, paramList), d(this.i, 2, paramList), Collections.emptyList(), this.k, this.l, this.c, this.m, this.n);
  }
  
  public static final class a
  {
    @Nullable
    public final Uri a;
    public final Format b;
    public final String c;
    public final String d;
    
    public a(@Nullable Uri paramUri, Format paramFormat, String paramString1, String paramString2)
    {
      this.a = paramUri;
      this.b = paramFormat;
      this.c = paramString1;
      this.d = paramString2;
    }
  }
  
  public static final class b
  {
    public final Uri a;
    public final Format b;
    @Nullable
    public final String c;
    @Nullable
    public final String d;
    @Nullable
    public final String e;
    @Nullable
    public final String f;
    
    public b(Uri paramUri, Format paramFormat, @Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @Nullable String paramString4)
    {
      this.a = paramUri;
      this.b = paramFormat;
      this.c = paramString1;
      this.d = paramString2;
      this.e = paramString3;
      this.f = paramString4;
    }
    
    public static b b(Uri paramUri)
    {
      return new b(paramUri, new Format.b().S("0").K("application/x-mpegURL").E(), null, null, null, null);
    }
    
    public b a(Format paramFormat)
    {
      return new b(this.a, paramFormat, this.c, this.d, this.e, this.f);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\source\hls\playlist\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */