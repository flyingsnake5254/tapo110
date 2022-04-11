package com.google.android.datatransport.cct.internal;

import androidx.annotation.Nullable;

final class c
  extends a
{
  private final Integer a;
  private final String b;
  private final String c;
  private final String d;
  private final String e;
  private final String f;
  private final String g;
  private final String h;
  private final String i;
  private final String j;
  private final String k;
  private final String l;
  
  private c(@Nullable Integer paramInteger, @Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @Nullable String paramString4, @Nullable String paramString5, @Nullable String paramString6, @Nullable String paramString7, @Nullable String paramString8, @Nullable String paramString9, @Nullable String paramString10, @Nullable String paramString11)
  {
    this.a = paramInteger;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
    this.e = paramString4;
    this.f = paramString5;
    this.g = paramString6;
    this.h = paramString7;
    this.i = paramString8;
    this.j = paramString9;
    this.k = paramString10;
    this.l = paramString11;
  }
  
  @Nullable
  public String b()
  {
    return this.l;
  }
  
  @Nullable
  public String c()
  {
    return this.j;
  }
  
  @Nullable
  public String d()
  {
    return this.d;
  }
  
  @Nullable
  public String e()
  {
    return this.h;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof a))
    {
      paramObject = (a)paramObject;
      Object localObject = this.a;
      if (localObject == null ? ((a)paramObject).m() == null : ((Integer)localObject).equals(((a)paramObject).m()))
      {
        localObject = this.b;
        if (localObject == null ? ((a)paramObject).j() == null : ((String)localObject).equals(((a)paramObject).j()))
        {
          localObject = this.c;
          if (localObject == null ? ((a)paramObject).f() == null : ((String)localObject).equals(((a)paramObject).f()))
          {
            localObject = this.d;
            if (localObject == null ? ((a)paramObject).d() == null : ((String)localObject).equals(((a)paramObject).d()))
            {
              localObject = this.e;
              if (localObject == null ? ((a)paramObject).l() == null : ((String)localObject).equals(((a)paramObject).l()))
              {
                localObject = this.f;
                if (localObject == null ? ((a)paramObject).k() == null : ((String)localObject).equals(((a)paramObject).k()))
                {
                  localObject = this.g;
                  if (localObject == null ? ((a)paramObject).h() == null : ((String)localObject).equals(((a)paramObject).h()))
                  {
                    localObject = this.h;
                    if (localObject == null ? ((a)paramObject).e() == null : ((String)localObject).equals(((a)paramObject).e()))
                    {
                      localObject = this.i;
                      if (localObject == null ? ((a)paramObject).g() == null : ((String)localObject).equals(((a)paramObject).g()))
                      {
                        localObject = this.j;
                        if (localObject == null ? ((a)paramObject).c() == null : ((String)localObject).equals(((a)paramObject).c()))
                        {
                          localObject = this.k;
                          if (localObject == null ? ((a)paramObject).i() == null : ((String)localObject).equals(((a)paramObject).i()))
                          {
                            localObject = this.l;
                            if (localObject == null ? ((a)paramObject).b() == null : ((String)localObject).equals(((a)paramObject).b())) {
                              break label386;
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      bool = false;
      label386:
      return bool;
    }
    return false;
  }
  
  @Nullable
  public String f()
  {
    return this.c;
  }
  
  @Nullable
  public String g()
  {
    return this.i;
  }
  
  @Nullable
  public String h()
  {
    return this.g;
  }
  
  public int hashCode()
  {
    Object localObject = this.a;
    int m = 0;
    int n;
    if (localObject == null) {
      n = 0;
    } else {
      n = ((Integer)localObject).hashCode();
    }
    localObject = this.b;
    int i1;
    if (localObject == null) {
      i1 = 0;
    } else {
      i1 = ((String)localObject).hashCode();
    }
    localObject = this.c;
    int i2;
    if (localObject == null) {
      i2 = 0;
    } else {
      i2 = ((String)localObject).hashCode();
    }
    localObject = this.d;
    int i3;
    if (localObject == null) {
      i3 = 0;
    } else {
      i3 = ((String)localObject).hashCode();
    }
    localObject = this.e;
    int i4;
    if (localObject == null) {
      i4 = 0;
    } else {
      i4 = ((String)localObject).hashCode();
    }
    localObject = this.f;
    int i5;
    if (localObject == null) {
      i5 = 0;
    } else {
      i5 = ((String)localObject).hashCode();
    }
    localObject = this.g;
    int i6;
    if (localObject == null) {
      i6 = 0;
    } else {
      i6 = ((String)localObject).hashCode();
    }
    localObject = this.h;
    int i7;
    if (localObject == null) {
      i7 = 0;
    } else {
      i7 = ((String)localObject).hashCode();
    }
    localObject = this.i;
    int i8;
    if (localObject == null) {
      i8 = 0;
    } else {
      i8 = ((String)localObject).hashCode();
    }
    localObject = this.j;
    int i9;
    if (localObject == null) {
      i9 = 0;
    } else {
      i9 = ((String)localObject).hashCode();
    }
    localObject = this.k;
    int i10;
    if (localObject == null) {
      i10 = 0;
    } else {
      i10 = ((String)localObject).hashCode();
    }
    localObject = this.l;
    if (localObject != null) {
      m = ((String)localObject).hashCode();
    }
    return (((((((((((n ^ 0xF4243) * 1000003 ^ i1) * 1000003 ^ i2) * 1000003 ^ i3) * 1000003 ^ i4) * 1000003 ^ i5) * 1000003 ^ i6) * 1000003 ^ i7) * 1000003 ^ i8) * 1000003 ^ i9) * 1000003 ^ i10) * 1000003 ^ m;
  }
  
  @Nullable
  public String i()
  {
    return this.k;
  }
  
  @Nullable
  public String j()
  {
    return this.b;
  }
  
  @Nullable
  public String k()
  {
    return this.f;
  }
  
  @Nullable
  public String l()
  {
    return this.e;
  }
  
  @Nullable
  public Integer m()
  {
    return this.a;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AndroidClientInfo{sdkVersion=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", model=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", hardware=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", device=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", product=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", osBuild=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", manufacturer=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", fingerprint=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", locale=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", country=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", mccMnc=");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", applicationBuild=");
    localStringBuilder.append(this.l);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  static final class b
    extends a.a
  {
    private Integer a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    
    public a a()
    {
      return new c(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, null);
    }
    
    public a.a b(@Nullable String paramString)
    {
      this.l = paramString;
      return this;
    }
    
    public a.a c(@Nullable String paramString)
    {
      this.j = paramString;
      return this;
    }
    
    public a.a d(@Nullable String paramString)
    {
      this.d = paramString;
      return this;
    }
    
    public a.a e(@Nullable String paramString)
    {
      this.h = paramString;
      return this;
    }
    
    public a.a f(@Nullable String paramString)
    {
      this.c = paramString;
      return this;
    }
    
    public a.a g(@Nullable String paramString)
    {
      this.i = paramString;
      return this;
    }
    
    public a.a h(@Nullable String paramString)
    {
      this.g = paramString;
      return this;
    }
    
    public a.a i(@Nullable String paramString)
    {
      this.k = paramString;
      return this;
    }
    
    public a.a j(@Nullable String paramString)
    {
      this.b = paramString;
      return this;
    }
    
    public a.a k(@Nullable String paramString)
    {
      this.f = paramString;
      return this;
    }
    
    public a.a l(@Nullable String paramString)
    {
      this.e = paramString;
      return this;
    }
    
    public a.a m(@Nullable Integer paramInteger)
    {
      this.a = paramInteger;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\cct\internal\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */