package com.google.android.exoplayer2;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public final class l1
{
  public static final l1 a = new c().a();
  public static final v0<l1> b = e0.a;
  public final String c;
  @Nullable
  public final g d;
  public final f e;
  public final m1 f;
  public final d g;
  
  private l1(String paramString, d paramd, @Nullable g paramg, f paramf, m1 paramm1)
  {
    this.c = paramString;
    this.d = paramg;
    this.e = paramf;
    this.f = paramm1;
    this.g = paramd;
  }
  
  public c a()
  {
    return new c(this, null);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof l1)) {
      return false;
    }
    paramObject = (l1)paramObject;
    if ((!o0.b(this.c, ((l1)paramObject).c)) || (!this.g.equals(((l1)paramObject).g)) || (!o0.b(this.d, ((l1)paramObject).d)) || (!o0.b(this.e, ((l1)paramObject).e)) || (!o0.b(this.f, ((l1)paramObject).f))) {
      bool = false;
    }
    return bool;
  }
  
  public int hashCode()
  {
    int i = this.c.hashCode();
    g localg = this.d;
    int j;
    if (localg != null) {
      j = localg.hashCode();
    } else {
      j = 0;
    }
    return (((i * 31 + j) * 31 + this.e.hashCode()) * 31 + this.g.hashCode()) * 31 + this.f.hashCode();
  }
  
  public static final class b
  {
    public final Uri a;
    @Nullable
    public final Object b;
    
    private b(Uri paramUri, @Nullable Object paramObject)
    {
      this.a = paramUri;
      this.b = paramObject;
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      boolean bool = true;
      if (this == paramObject) {
        return true;
      }
      if (!(paramObject instanceof b)) {
        return false;
      }
      paramObject = (b)paramObject;
      if ((!this.a.equals(((b)paramObject).a)) || (!o0.b(this.b, ((b)paramObject).b))) {
        bool = false;
      }
      return bool;
    }
    
    public int hashCode()
    {
      int i = this.a.hashCode();
      Object localObject = this.b;
      int j;
      if (localObject != null) {
        j = localObject.hashCode();
      } else {
        j = 0;
      }
      return i * 31 + j;
    }
  }
  
  public static final class c
  {
    private float A = -3.4028235E38F;
    private float B = -3.4028235E38F;
    @Nullable
    private String a;
    @Nullable
    private Uri b;
    @Nullable
    private String c;
    private long d;
    private long e = Long.MIN_VALUE;
    private boolean f;
    private boolean g;
    private boolean h;
    @Nullable
    private Uri i;
    private Map<String, String> j = Collections.emptyMap();
    @Nullable
    private UUID k;
    private boolean l;
    private boolean m;
    private boolean n;
    private List<Integer> o = Collections.emptyList();
    @Nullable
    private byte[] p;
    private List<StreamKey> q = Collections.emptyList();
    @Nullable
    private String r;
    private List<l1.h> s = Collections.emptyList();
    @Nullable
    private Uri t;
    @Nullable
    private Object u;
    @Nullable
    private Object v;
    @Nullable
    private m1 w;
    private long x = -9223372036854775807L;
    private long y = -9223372036854775807L;
    private long z = -9223372036854775807L;
    
    public c() {}
    
    private c(l1 paraml1)
    {
      this();
      Object localObject = paraml1.g;
      this.f = ((l1.d)localObject).d;
      this.g = ((l1.d)localObject).e;
      this.d = ((l1.d)localObject).b;
      this.h = ((l1.d)localObject).f;
      this.a = paraml1.c;
      this.w = paraml1.f;
      localObject = paraml1.e;
      this.x = ((l1.f)localObject).c;
      this.y = ((l1.f)localObject).d;
      this.z = ((l1.f)localObject).e;
      this.A = ((l1.f)localObject).f;
      this.B = ((l1.f)localObject).g;
      localObject = paraml1.d;
      if (localObject != null)
      {
        this.r = ((l1.g)localObject).f;
        this.c = ((l1.g)localObject).b;
        this.b = ((l1.g)localObject).a;
        this.q = ((l1.g)localObject).e;
        this.s = ((l1.g)localObject).g;
        this.v = ((l1.g)localObject).h;
        paraml1 = ((l1.g)localObject).c;
        if (paraml1 != null)
        {
          this.i = paraml1.b;
          this.j = paraml1.c;
          this.l = paraml1.d;
          this.n = paraml1.f;
          this.m = paraml1.e;
          this.o = paraml1.g;
          this.k = paraml1.a;
          this.p = paraml1.a();
        }
        paraml1 = ((l1.g)localObject).d;
        if (paraml1 != null)
        {
          this.t = paraml1.a;
          this.u = paraml1.b;
        }
      }
    }
    
    public l1 a()
    {
      boolean bool;
      if ((this.i != null) && (this.k == null)) {
        bool = false;
      } else {
        bool = true;
      }
      g.g(bool);
      Object localObject1 = this.b;
      Object localObject3;
      if (localObject1 != null)
      {
        localObject2 = this.c;
        localObject3 = this.k;
        if (localObject3 != null) {
          localObject3 = new l1.e((UUID)localObject3, this.i, this.j, this.l, this.n, this.m, this.o, this.p, null);
        } else {
          localObject3 = null;
        }
        localObject4 = this.t;
        if (localObject4 != null) {
          localObject4 = new l1.b((Uri)localObject4, this.u, null);
        } else {
          localObject4 = null;
        }
        localObject3 = new l1.g((Uri)localObject1, (String)localObject2, (l1.e)localObject3, (l1.b)localObject4, this.q, this.r, this.s, this.v, null);
      }
      else
      {
        localObject3 = null;
      }
      Object localObject4 = this.a;
      if (localObject4 == null) {
        localObject4 = "";
      }
      Object localObject2 = new l1.d(this.d, this.e, this.f, this.g, this.h, null);
      l1.f localf = new l1.f(this.x, this.y, this.z, this.A, this.B);
      localObject1 = this.w;
      if (localObject1 == null) {
        localObject1 = m1.a;
      }
      return new l1((String)localObject4, (l1.d)localObject2, (l1.g)localObject3, localf, (m1)localObject1, null);
    }
    
    public c b(@Nullable String paramString)
    {
      this.r = paramString;
      return this;
    }
    
    public c c(boolean paramBoolean)
    {
      this.n = paramBoolean;
      return this;
    }
    
    public c d(@Nullable byte[] paramArrayOfByte)
    {
      if (paramArrayOfByte != null) {
        paramArrayOfByte = Arrays.copyOf(paramArrayOfByte, paramArrayOfByte.length);
      } else {
        paramArrayOfByte = null;
      }
      this.p = paramArrayOfByte;
      return this;
    }
    
    public c e(@Nullable Map<String, String> paramMap)
    {
      if ((paramMap != null) && (!paramMap.isEmpty())) {
        paramMap = Collections.unmodifiableMap(new HashMap(paramMap));
      } else {
        paramMap = Collections.emptyMap();
      }
      this.j = paramMap;
      return this;
    }
    
    public c f(@Nullable Uri paramUri)
    {
      this.i = paramUri;
      return this;
    }
    
    public c g(boolean paramBoolean)
    {
      this.l = paramBoolean;
      return this;
    }
    
    public c h(boolean paramBoolean)
    {
      this.m = paramBoolean;
      return this;
    }
    
    public c i(@Nullable List<Integer> paramList)
    {
      if ((paramList != null) && (!paramList.isEmpty())) {
        paramList = Collections.unmodifiableList(new ArrayList(paramList));
      } else {
        paramList = Collections.emptyList();
      }
      this.o = paramList;
      return this;
    }
    
    public c j(@Nullable UUID paramUUID)
    {
      this.k = paramUUID;
      return this;
    }
    
    public c k(long paramLong)
    {
      this.z = paramLong;
      return this;
    }
    
    public c l(float paramFloat)
    {
      this.B = paramFloat;
      return this;
    }
    
    public c m(long paramLong)
    {
      this.y = paramLong;
      return this;
    }
    
    public c n(float paramFloat)
    {
      this.A = paramFloat;
      return this;
    }
    
    public c o(long paramLong)
    {
      this.x = paramLong;
      return this;
    }
    
    public c p(String paramString)
    {
      this.a = ((String)g.e(paramString));
      return this;
    }
    
    public c q(@Nullable String paramString)
    {
      this.c = paramString;
      return this;
    }
    
    public c r(@Nullable List<StreamKey> paramList)
    {
      if ((paramList != null) && (!paramList.isEmpty())) {
        paramList = Collections.unmodifiableList(new ArrayList(paramList));
      } else {
        paramList = Collections.emptyList();
      }
      this.q = paramList;
      return this;
    }
    
    public c s(@Nullable List<l1.h> paramList)
    {
      if ((paramList != null) && (!paramList.isEmpty())) {
        paramList = Collections.unmodifiableList(new ArrayList(paramList));
      } else {
        paramList = Collections.emptyList();
      }
      this.s = paramList;
      return this;
    }
    
    public c t(@Nullable Object paramObject)
    {
      this.v = paramObject;
      return this;
    }
    
    public c u(@Nullable Uri paramUri)
    {
      this.b = paramUri;
      return this;
    }
  }
  
  public static final class d
  {
    public static final v0<d> a = c0.a;
    public final long b;
    public final long c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    
    private d(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      this.b = paramLong1;
      this.c = paramLong2;
      this.d = paramBoolean1;
      this.e = paramBoolean2;
      this.f = paramBoolean3;
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      boolean bool = true;
      if (this == paramObject) {
        return true;
      }
      if (!(paramObject instanceof d)) {
        return false;
      }
      paramObject = (d)paramObject;
      if ((this.b != ((d)paramObject).b) || (this.c != ((d)paramObject).c) || (this.d != ((d)paramObject).d) || (this.e != ((d)paramObject).e) || (this.f != ((d)paramObject).f)) {
        bool = false;
      }
      return bool;
    }
    
    public int hashCode()
    {
      long l = this.b;
      int i = (int)(l ^ l >>> 32);
      l = this.c;
      return (((i * 31 + (int)(l ^ l >>> 32)) * 31 + this.d) * 31 + this.e) * 31 + this.f;
    }
  }
  
  public static final class e
  {
    public final UUID a;
    @Nullable
    public final Uri b;
    public final Map<String, String> c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    public final List<Integer> g;
    @Nullable
    private final byte[] h;
    
    private e(UUID paramUUID, @Nullable Uri paramUri, Map<String, String> paramMap, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, List<Integer> paramList, @Nullable byte[] paramArrayOfByte)
    {
      boolean bool;
      if ((paramBoolean2) && (paramUri == null)) {
        bool = false;
      } else {
        bool = true;
      }
      g.a(bool);
      this.a = paramUUID;
      this.b = paramUri;
      this.c = paramMap;
      this.d = paramBoolean1;
      this.f = paramBoolean2;
      this.e = paramBoolean3;
      this.g = paramList;
      if (paramArrayOfByte != null) {
        paramUUID = Arrays.copyOf(paramArrayOfByte, paramArrayOfByte.length);
      } else {
        paramUUID = null;
      }
      this.h = paramUUID;
    }
    
    @Nullable
    public byte[] a()
    {
      byte[] arrayOfByte = this.h;
      if (arrayOfByte != null) {
        arrayOfByte = Arrays.copyOf(arrayOfByte, arrayOfByte.length);
      } else {
        arrayOfByte = null;
      }
      return arrayOfByte;
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      boolean bool = true;
      if (this == paramObject) {
        return true;
      }
      if (!(paramObject instanceof e)) {
        return false;
      }
      paramObject = (e)paramObject;
      if ((!this.a.equals(((e)paramObject).a)) || (!o0.b(this.b, ((e)paramObject).b)) || (!o0.b(this.c, ((e)paramObject).c)) || (this.d != ((e)paramObject).d) || (this.f != ((e)paramObject).f) || (this.e != ((e)paramObject).e) || (!this.g.equals(((e)paramObject).g)) || (!Arrays.equals(this.h, ((e)paramObject).h))) {
        bool = false;
      }
      return bool;
    }
    
    public int hashCode()
    {
      int i = this.a.hashCode();
      Uri localUri = this.b;
      int j;
      if (localUri != null) {
        j = localUri.hashCode();
      } else {
        j = 0;
      }
      return ((((((i * 31 + j) * 31 + this.c.hashCode()) * 31 + this.d) * 31 + this.f) * 31 + this.e) * 31 + this.g.hashCode()) * 31 + Arrays.hashCode(this.h);
    }
  }
  
  public static final class f
  {
    public static final f a = new f(-9223372036854775807L, -9223372036854775807L, -9223372036854775807L, -3.4028235E38F, -3.4028235E38F);
    public static final v0<f> b = d0.a;
    public final long c;
    public final long d;
    public final long e;
    public final float f;
    public final float g;
    
    public f(long paramLong1, long paramLong2, long paramLong3, float paramFloat1, float paramFloat2)
    {
      this.c = paramLong1;
      this.d = paramLong2;
      this.e = paramLong3;
      this.f = paramFloat1;
      this.g = paramFloat2;
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      boolean bool = true;
      if (this == paramObject) {
        return true;
      }
      if (!(paramObject instanceof f)) {
        return false;
      }
      paramObject = (f)paramObject;
      if ((this.c != ((f)paramObject).c) || (this.d != ((f)paramObject).d) || (this.e != ((f)paramObject).e) || (this.f != ((f)paramObject).f) || (this.g != ((f)paramObject).g)) {
        bool = false;
      }
      return bool;
    }
    
    public int hashCode()
    {
      long l = this.c;
      int i = (int)(l ^ l >>> 32);
      l = this.d;
      int j = (int)(l ^ l >>> 32);
      l = this.e;
      int k = (int)(l ^ l >>> 32);
      float f1 = this.f;
      int m = 0;
      int n;
      if (f1 != 0.0F) {
        n = Float.floatToIntBits(f1);
      } else {
        n = 0;
      }
      f1 = this.g;
      if (f1 != 0.0F) {
        m = Float.floatToIntBits(f1);
      }
      return (((i * 31 + j) * 31 + k) * 31 + n) * 31 + m;
    }
  }
  
  public static final class g
  {
    public final Uri a;
    @Nullable
    public final String b;
    @Nullable
    public final l1.e c;
    @Nullable
    public final l1.b d;
    public final List<StreamKey> e;
    @Nullable
    public final String f;
    public final List<l1.h> g;
    @Nullable
    public final Object h;
    
    private g(Uri paramUri, @Nullable String paramString1, @Nullable l1.e parame, @Nullable l1.b paramb, List<StreamKey> paramList, @Nullable String paramString2, List<l1.h> paramList1, @Nullable Object paramObject)
    {
      this.a = paramUri;
      this.b = paramString1;
      this.c = parame;
      this.d = paramb;
      this.e = paramList;
      this.f = paramString2;
      this.g = paramList1;
      this.h = paramObject;
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      boolean bool = true;
      if (this == paramObject) {
        return true;
      }
      if (!(paramObject instanceof g)) {
        return false;
      }
      paramObject = (g)paramObject;
      if ((!this.a.equals(((g)paramObject).a)) || (!o0.b(this.b, ((g)paramObject).b)) || (!o0.b(this.c, ((g)paramObject).c)) || (!o0.b(this.d, ((g)paramObject).d)) || (!this.e.equals(((g)paramObject).e)) || (!o0.b(this.f, ((g)paramObject).f)) || (!this.g.equals(((g)paramObject).g)) || (!o0.b(this.h, ((g)paramObject).h))) {
        bool = false;
      }
      return bool;
    }
    
    public int hashCode()
    {
      int i = this.a.hashCode();
      Object localObject = this.b;
      int j = 0;
      int k;
      if (localObject == null) {
        k = 0;
      } else {
        k = ((String)localObject).hashCode();
      }
      localObject = this.c;
      int m;
      if (localObject == null) {
        m = 0;
      } else {
        m = ((l1.e)localObject).hashCode();
      }
      localObject = this.d;
      int n;
      if (localObject == null) {
        n = 0;
      } else {
        n = ((l1.b)localObject).hashCode();
      }
      int i1 = this.e.hashCode();
      localObject = this.f;
      int i2;
      if (localObject == null) {
        i2 = 0;
      } else {
        i2 = ((String)localObject).hashCode();
      }
      int i3 = this.g.hashCode();
      localObject = this.h;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      return ((((((i * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + j;
    }
  }
  
  public static final class h
  {
    public final Uri a;
    public final String b;
    @Nullable
    public final String c;
    public final int d;
    public final int e;
    @Nullable
    public final String f;
    
    public boolean equals(@Nullable Object paramObject)
    {
      boolean bool = true;
      if (this == paramObject) {
        return true;
      }
      if (!(paramObject instanceof h)) {
        return false;
      }
      paramObject = (h)paramObject;
      if ((!this.a.equals(((h)paramObject).a)) || (!this.b.equals(((h)paramObject).b)) || (!o0.b(this.c, ((h)paramObject).c)) || (this.d != ((h)paramObject).d) || (this.e != ((h)paramObject).e) || (!o0.b(this.f, ((h)paramObject).f))) {
        bool = false;
      }
      return bool;
    }
    
    public int hashCode()
    {
      int i = this.a.hashCode();
      int j = this.b.hashCode();
      String str = this.c;
      int k = 0;
      int m;
      if (str == null) {
        m = 0;
      } else {
        m = str.hashCode();
      }
      int n = this.d;
      int i1 = this.e;
      str = this.f;
      if (str != null) {
        k = str.hashCode();
      }
      return ((((i * 31 + j) * 31 + m) * 31 + n) * 31 + i1) * 31 + k;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\l1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */