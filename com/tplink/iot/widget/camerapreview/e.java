package com.tplink.iot.widget.camerapreview;

import kotlin.jvm.internal.j;

public final class e
{
  public static final a a = new a(null);
  private String b;
  private final String c;
  private final Boolean d;
  private final Boolean e;
  private final String f;
  private final Boolean g;
  private final Boolean h;
  private final Boolean i;
  private final Boolean j;
  private final Throwable k;
  private final Boolean l;
  private final Boolean m;
  private final Boolean n;
  private final String o;
  
  public e()
  {
    this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null);
  }
  
  public e(String paramString1, String paramString2, Boolean paramBoolean1, Boolean paramBoolean2, String paramString3, Boolean paramBoolean3, Boolean paramBoolean4, Boolean paramBoolean5, Boolean paramBoolean6, Throwable paramThrowable, Boolean paramBoolean7, Boolean paramBoolean8, Boolean paramBoolean9, String paramString4)
  {
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramBoolean1;
    this.e = paramBoolean2;
    this.f = paramString3;
    this.g = paramBoolean3;
    this.h = paramBoolean4;
    this.i = paramBoolean5;
    this.j = paramBoolean6;
    this.k = paramThrowable;
    this.l = paramBoolean7;
    this.m = paramBoolean8;
    this.n = paramBoolean9;
    this.o = paramString4;
  }
  
  public final e A(e parame)
  {
    j.e(parame, "preState");
    String str1;
    if (a() == null) {
      str1 = parame.a();
    } else {
      str1 = a();
    }
    String str2;
    if (g() == null) {
      str2 = parame.g();
    } else {
      str2 = g();
    }
    Boolean localBoolean1;
    if (h() == null) {
      localBoolean1 = parame.h();
    } else {
      localBoolean1 = h();
    }
    Boolean localBoolean2;
    if (i() == null) {
      localBoolean2 = parame.i();
    } else {
      localBoolean2 = i();
    }
    String str3;
    if (j() == null) {
      str3 = parame.j();
    } else {
      str3 = j();
    }
    Boolean localBoolean3;
    if (k() == null) {
      localBoolean3 = parame.k();
    } else {
      localBoolean3 = k();
    }
    Boolean localBoolean4;
    if (l() == null) {
      localBoolean4 = parame.l();
    } else {
      localBoolean4 = l();
    }
    Boolean localBoolean5;
    if (m() == null) {
      localBoolean5 = parame.m();
    } else {
      localBoolean5 = m();
    }
    Boolean localBoolean6;
    if (n() == null) {
      localBoolean6 = parame.n();
    } else {
      localBoolean6 = n();
    }
    Throwable localThrowable;
    if (b() == null) {
      localThrowable = parame.b();
    } else {
      localThrowable = b();
    }
    Boolean localBoolean7;
    if (c() == null) {
      localBoolean7 = parame.c();
    } else {
      localBoolean7 = c();
    }
    Boolean localBoolean8;
    if (d() == null) {
      localBoolean8 = parame.d();
    } else {
      localBoolean8 = d();
    }
    Boolean localBoolean9;
    if (e() == null) {
      localBoolean9 = parame.e();
    } else {
      localBoolean9 = e();
    }
    if (f() == null) {
      parame = parame.f();
    } else {
      parame = f();
    }
    return new e(str1, str2, localBoolean1, localBoolean2, str3, localBoolean3, localBoolean4, localBoolean5, localBoolean6, localThrowable, localBoolean7, localBoolean8, localBoolean9, parame);
  }
  
  public final e B(String paramString)
  {
    j.e(paramString, "tag");
    this.b = paramString;
    return this;
  }
  
  public final String a()
  {
    return this.b;
  }
  
  public final Throwable b()
  {
    return this.k;
  }
  
  public final Boolean c()
  {
    return this.l;
  }
  
  public final Boolean d()
  {
    return this.m;
  }
  
  public final Boolean e()
  {
    return this.n;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof e))
      {
        paramObject = (e)paramObject;
        if ((j.a(this.b, ((e)paramObject).b)) && (j.a(this.c, ((e)paramObject).c)) && (j.a(this.d, ((e)paramObject).d)) && (j.a(this.e, ((e)paramObject).e)) && (j.a(this.f, ((e)paramObject).f)) && (j.a(this.g, ((e)paramObject).g)) && (j.a(this.h, ((e)paramObject).h)) && (j.a(this.i, ((e)paramObject).i)) && (j.a(this.j, ((e)paramObject).j)) && (j.a(this.k, ((e)paramObject).k)) && (j.a(this.l, ((e)paramObject).l)) && (j.a(this.m, ((e)paramObject).m)) && (j.a(this.n, ((e)paramObject).n)) && (j.a(this.o, ((e)paramObject).o))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final String f()
  {
    return this.o;
  }
  
  public final String g()
  {
    return this.c;
  }
  
  public final Boolean h()
  {
    return this.d;
  }
  
  public int hashCode()
  {
    Object localObject = this.b;
    int i1 = 0;
    int i2;
    if (localObject != null) {
      i2 = localObject.hashCode();
    } else {
      i2 = 0;
    }
    localObject = this.c;
    int i3;
    if (localObject != null) {
      i3 = localObject.hashCode();
    } else {
      i3 = 0;
    }
    localObject = this.d;
    int i4;
    if (localObject != null) {
      i4 = localObject.hashCode();
    } else {
      i4 = 0;
    }
    localObject = this.e;
    int i5;
    if (localObject != null) {
      i5 = localObject.hashCode();
    } else {
      i5 = 0;
    }
    localObject = this.f;
    int i6;
    if (localObject != null) {
      i6 = localObject.hashCode();
    } else {
      i6 = 0;
    }
    localObject = this.g;
    int i7;
    if (localObject != null) {
      i7 = localObject.hashCode();
    } else {
      i7 = 0;
    }
    localObject = this.h;
    int i8;
    if (localObject != null) {
      i8 = localObject.hashCode();
    } else {
      i8 = 0;
    }
    localObject = this.i;
    int i9;
    if (localObject != null) {
      i9 = localObject.hashCode();
    } else {
      i9 = 0;
    }
    localObject = this.j;
    int i10;
    if (localObject != null) {
      i10 = localObject.hashCode();
    } else {
      i10 = 0;
    }
    localObject = this.k;
    int i11;
    if (localObject != null) {
      i11 = localObject.hashCode();
    } else {
      i11 = 0;
    }
    localObject = this.l;
    int i12;
    if (localObject != null) {
      i12 = localObject.hashCode();
    } else {
      i12 = 0;
    }
    localObject = this.m;
    int i13;
    if (localObject != null) {
      i13 = localObject.hashCode();
    } else {
      i13 = 0;
    }
    localObject = this.n;
    int i14;
    if (localObject != null) {
      i14 = localObject.hashCode();
    } else {
      i14 = 0;
    }
    localObject = this.o;
    if (localObject != null) {
      i1 = localObject.hashCode();
    }
    return ((((((((((((i2 * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + i7) * 31 + i8) * 31 + i9) * 31 + i10) * 31 + i11) * 31 + i12) * 31 + i13) * 31 + i14) * 31 + i1;
  }
  
  public final Boolean i()
  {
    return this.e;
  }
  
  public final String j()
  {
    return this.f;
  }
  
  public final Boolean k()
  {
    return this.g;
  }
  
  public final Boolean l()
  {
    return this.h;
  }
  
  public final Boolean m()
  {
    return this.i;
  }
  
  public final Boolean n()
  {
    return this.j;
  }
  
  public final String o()
  {
    return this.f;
  }
  
  public final String p()
  {
    return this.c;
  }
  
  public final Boolean q()
  {
    return this.j;
  }
  
  public final Throwable r()
  {
    return this.k;
  }
  
  public final Boolean s()
  {
    return this.l;
  }
  
  public final Boolean t()
  {
    return this.d;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DisplayViewState(tag=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", deviceName=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", initialing=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", online=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", deviceInfo=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", playing=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", pause=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", loading=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", error=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", errorReason=");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", funcBtnVisible=");
    localStringBuilder.append(this.l);
    localStringBuilder.append(", updating=");
    localStringBuilder.append(this.m);
    localStringBuilder.append(", needForceUpdate=");
    localStringBuilder.append(this.n);
    localStringBuilder.append(", speed=");
    localStringBuilder.append(this.o);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public final Boolean u()
  {
    return this.i;
  }
  
  public final Boolean v()
  {
    return this.n;
  }
  
  public final Boolean w()
  {
    return this.e;
  }
  
  public final Boolean x()
  {
    return this.g;
  }
  
  public final String y()
  {
    return this.o;
  }
  
  public final Boolean z()
  {
    return this.m;
  }
  
  public static final class a
  {
    public final e a()
    {
      Boolean localBoolean = Boolean.FALSE;
      return new e(null, null, null, null, null, localBoolean, localBoolean, localBoolean, localBoolean, null, Boolean.TRUE, null, null, null, 14367, null);
    }
    
    public final e b(Throwable paramThrowable)
    {
      j.e(paramThrowable, "errorReason");
      Boolean localBoolean1 = Boolean.FALSE;
      Boolean localBoolean2 = Boolean.TRUE;
      return new e(null, null, null, null, null, localBoolean1, localBoolean1, localBoolean1, localBoolean2, paramThrowable, localBoolean2, null, null, null, 14367, null);
    }
    
    public final e c()
    {
      Boolean localBoolean1 = Boolean.FALSE;
      Boolean localBoolean2 = Boolean.TRUE;
      return new e(null, null, null, null, null, null, null, localBoolean1, null, null, localBoolean2, localBoolean1, localBoolean2, null, 9087, null);
    }
    
    public final e d()
    {
      return new e(null, null, null, null, null, null, null, null, null, null, Boolean.FALSE, null, null, null, 15359, null);
    }
    
    public final e e()
    {
      return new e(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null);
    }
    
    public final e f()
    {
      Boolean localBoolean = Boolean.FALSE;
      return new e(null, null, null, null, null, localBoolean, localBoolean, Boolean.TRUE, localBoolean, null, localBoolean, null, null, null, 14367, null);
    }
    
    public final e g()
    {
      Boolean localBoolean = Boolean.FALSE;
      return new e(null, null, null, null, null, null, null, localBoolean, null, null, Boolean.TRUE, localBoolean, localBoolean, null, 9087, null);
    }
    
    public final e h()
    {
      Boolean localBoolean1 = Boolean.FALSE;
      Boolean localBoolean2 = Boolean.TRUE;
      return new e(null, null, null, null, null, localBoolean1, localBoolean2, localBoolean1, localBoolean1, null, localBoolean2, null, null, null, 14367, null);
    }
    
    public final e i()
    {
      Boolean localBoolean1 = Boolean.TRUE;
      Boolean localBoolean2 = Boolean.FALSE;
      return new e(null, null, null, null, null, localBoolean1, localBoolean2, localBoolean2, localBoolean2, null, null, null, null, null, 14367, null);
    }
    
    public final e j(String paramString1, String paramString2, Boolean paramBoolean)
    {
      j.e(paramString1, "name");
      j.e(paramString2, "info");
      Boolean localBoolean = Boolean.FALSE;
      return new e(null, paramString1, paramBoolean, localBoolean, paramString2, localBoolean, localBoolean, localBoolean, localBoolean, null, localBoolean, localBoolean, localBoolean, null, 8705, null);
    }
    
    public final e k(String paramString1, String paramString2, Boolean paramBoolean)
    {
      j.e(paramString1, "name");
      j.e(paramString2, "info");
      return new e(null, paramString1, paramBoolean, Boolean.TRUE, paramString2, null, null, null, null, null, null, null, null, null, 16353, null);
    }
    
    public final e l()
    {
      return new e(null, null, null, null, null, null, null, null, null, null, Boolean.TRUE, null, null, null, 15359, null);
    }
    
    public final e m(String paramString)
    {
      return new e(null, null, null, null, null, null, null, null, null, null, null, null, null, paramString, 8191, null);
    }
    
    public final e n()
    {
      Boolean localBoolean1 = Boolean.TRUE;
      Boolean localBoolean2 = Boolean.FALSE;
      return new e(null, null, null, localBoolean1, null, null, null, localBoolean1, null, null, localBoolean2, localBoolean1, localBoolean2, null, 9079, null);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\camerapreview\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */