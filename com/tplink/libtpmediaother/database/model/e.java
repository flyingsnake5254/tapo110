package com.tplink.libtpmediaother.database.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.gson.Gson;
import com.tplink.libtpnetwork.cameranetwork.model.LineCrossingDetectionRegion;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.greendao.converter.PropertyConverter;

public class e
{
  private int A = 0;
  private int B = 127;
  private List<c> C = new ArrayList();
  private boolean D = false;
  private boolean E = false;
  private boolean F = false;
  private String G = "low";
  private List<c> H = new ArrayList();
  private a I = new a(true);
  private List<b> J = new ArrayList();
  private a K = new a(true);
  private String a = "";
  private boolean b;
  private boolean c;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  private int i;
  private int j = 80;
  private boolean k;
  private boolean l = true;
  private boolean m = false;
  private boolean n = false;
  private String o = "0";
  private int p = 0;
  private int q = 0;
  private int r = 23;
  private int s = 59;
  private int t = 127;
  private boolean u;
  private boolean v;
  private boolean w;
  private int x = 9;
  private int y = 0;
  private int z = 17;
  
  public e() {}
  
  public e(String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, int paramInt1, int paramInt2, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10, boolean paramBoolean11, String paramString2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, boolean paramBoolean12, boolean paramBoolean13, boolean paramBoolean14, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, List<c> paramList1, boolean paramBoolean15, boolean paramBoolean16, boolean paramBoolean17, String paramString3, List<c> paramList2, a parama1, List<b> paramList, a parama2)
  {
    this.a = paramString1;
    this.b = paramBoolean1;
    this.c = paramBoolean2;
    this.d = paramBoolean3;
    this.e = paramBoolean4;
    this.f = paramBoolean5;
    this.g = paramBoolean6;
    this.h = paramBoolean7;
    this.i = paramInt1;
    this.j = paramInt2;
    this.k = paramBoolean8;
    this.l = paramBoolean9;
    this.m = paramBoolean10;
    this.n = paramBoolean11;
    this.o = paramString2;
    this.p = paramInt3;
    this.q = paramInt4;
    this.r = paramInt5;
    this.s = paramInt6;
    this.t = paramInt7;
    this.u = paramBoolean12;
    this.v = paramBoolean13;
    this.w = paramBoolean14;
    this.x = paramInt8;
    this.y = paramInt9;
    this.z = paramInt10;
    this.A = paramInt11;
    this.B = paramInt12;
    this.C = paramList1;
    this.D = paramBoolean15;
    this.E = paramBoolean16;
    this.F = paramBoolean17;
    this.G = paramString3;
    this.H = paramList2;
    this.I = parama1;
    this.J = paramList;
    this.K = parama2;
  }
  
  public static e a(String paramString, boolean paramBoolean)
  {
    e locale = new e();
    locale.f0(paramString);
    locale.i0(paramBoolean);
    paramBoolean ^= true;
    locale.c = paramBoolean;
    locale.d = paramBoolean;
    locale.k = paramBoolean;
    locale.C.add(new c(0, 0, 10000, 10000));
    locale.u = paramBoolean;
    int i1;
    if (paramBoolean) {
      i1 = 100;
    } else {
      i1 = 50;
    }
    locale.i = i1;
    locale.D = paramBoolean;
    locale.H.add(new c(0, 0, 10000, 10000));
    locale.E = paramBoolean;
    return locale;
  }
  
  public int A()
  {
    return this.A;
  }
  
  public void A0(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public boolean B()
  {
    return this.u;
  }
  
  public boolean C()
  {
    return this.v;
  }
  
  public boolean D()
  {
    return this.w;
  }
  
  public int E()
  {
    return this.x;
  }
  
  public int F()
  {
    return this.y;
  }
  
  public boolean G()
  {
    return this.c;
  }
  
  public List<c> H()
  {
    if ((this.b) && (this.C.isEmpty())) {
      this.C.add(new c(0, 0, 10000, 10000));
    }
    return this.C;
  }
  
  public boolean I()
  {
    return this.n;
  }
  
  public int J()
  {
    return this.j;
  }
  
  public boolean K()
  {
    return this.D;
  }
  
  public String L()
  {
    if (this.G == null) {
      this.G = "low";
    }
    return this.G;
  }
  
  public boolean M()
  {
    return this.h;
  }
  
  public boolean N()
  {
    return this.E;
  }
  
  public boolean O()
  {
    return this.F;
  }
  
  public boolean P()
  {
    return this.D;
  }
  
  public void Q(int paramInt)
  {
    this.t = paramInt;
  }
  
  public void R(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  public void S(int paramInt)
  {
    this.r = paramInt;
  }
  
  public void T(int paramInt)
  {
    this.s = paramInt;
  }
  
  public void U(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public void V(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public void W(String paramString)
  {
    this.o = paramString;
  }
  
  public void X(int paramInt)
  {
    this.p = paramInt;
  }
  
  public void Y(int paramInt)
  {
    this.q = paramInt;
  }
  
  public void Z(a parama)
  {
    this.I = parama;
  }
  
  public void a0(boolean paramBoolean)
  {
    this.E = paramBoolean;
  }
  
  public int b()
  {
    return this.t;
  }
  
  public void b0(List<c> paramList)
  {
    Object localObject = paramList;
    if (paramList == null)
    {
      localObject = new ArrayList();
      ((List)localObject).add(new c(0, 0, 10000, 10000));
    }
    this.H = ((List)localObject);
  }
  
  public boolean c()
  {
    return this.k;
  }
  
  public void c0(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public int d()
  {
    return this.r;
  }
  
  public void d0(int paramInt)
  {
    this.i = paramInt;
  }
  
  public int e()
  {
    return this.s;
  }
  
  public void e0(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public boolean f()
  {
    return this.m;
  }
  
  public void f0(String paramString)
  {
    this.a = paramString;
  }
  
  public boolean g()
  {
    return this.l;
  }
  
  public void g0(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public String h()
  {
    return this.o;
  }
  
  public void h0(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public int i()
  {
    return this.p;
  }
  
  public void i0(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public int j()
  {
    return this.q;
  }
  
  public void j0(a parama)
  {
    this.K = parama;
  }
  
  public a k()
  {
    if (this.I == null) {
      this.I = new a(true);
    }
    return this.I;
  }
  
  public void k0(boolean paramBoolean)
  {
    this.F = paramBoolean;
  }
  
  public boolean l()
  {
    return this.E;
  }
  
  public void l0(List<b> paramList)
  {
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    this.J = ((List)localObject);
  }
  
  public List<c> m()
  {
    if (this.H == null) {
      this.H = new ArrayList();
    }
    if (this.H.isEmpty()) {
      this.H.add(new c(0, 0, 10000, 10000));
    }
    return this.H;
  }
  
  public void m0(int paramInt)
  {
    this.B = paramInt;
  }
  
  public boolean n()
  {
    return this.f;
  }
  
  public void n0(int paramInt)
  {
    this.z = paramInt;
  }
  
  public int o()
  {
    return this.i;
  }
  
  public void o0(int paramInt)
  {
    this.A = paramInt;
  }
  
  public boolean p()
  {
    return this.d;
  }
  
  public void p0(boolean paramBoolean)
  {
    this.u = paramBoolean;
  }
  
  public String q()
  {
    return this.a;
  }
  
  public void q0(boolean paramBoolean)
  {
    this.v = paramBoolean;
  }
  
  public boolean r()
  {
    return this.g;
  }
  
  public void r0(boolean paramBoolean)
  {
    this.w = paramBoolean;
  }
  
  public boolean s()
  {
    return this.e;
  }
  
  public void s0(int paramInt)
  {
    this.x = paramInt;
  }
  
  public boolean t()
  {
    return this.b;
  }
  
  public void t0(int paramInt)
  {
    this.y = paramInt;
  }
  
  public a u()
  {
    if (this.K == null) {
      this.K = new a(true);
    }
    return this.K;
  }
  
  public void u0(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public boolean v()
  {
    return this.F;
  }
  
  public void v0(List<c> paramList)
  {
    if (paramList == null) {
      this.C = new ArrayList();
    } else {
      this.C = paramList;
    }
  }
  
  public List<b> w()
  {
    if (this.J == null) {
      this.J = new ArrayList();
    }
    return this.J;
  }
  
  public void w0(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }
  
  public boolean x()
  {
    return this.d;
  }
  
  public void x0(int paramInt)
  {
    this.j = paramInt;
  }
  
  public int y()
  {
    return this.B;
  }
  
  public void y0(boolean paramBoolean)
  {
    this.D = paramBoolean;
  }
  
  public int z()
  {
    return this.z;
  }
  
  public void z0(String paramString)
  {
    this.G = paramString;
  }
  
  public static class a
    implements PropertyConverter<a, String>
  {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    
    public a() {}
    
    public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
    {
      this.a = paramString1;
      this.b = paramString2;
      this.c = paramString3;
      this.d = paramString4;
      this.e = paramString5;
      this.f = paramString6;
      this.g = paramString7;
    }
    
    public a(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        this.a = "[\"0000-2400\"]";
        this.b = "[\"0000-2400\"]";
        this.c = "[\"0000-2400\"]";
        this.d = "[\"0000-2400\"]";
        this.e = "[\"0000-2400\"]";
        this.f = "[\"0000-2400\"]";
        this.g = "[\"0000-2400\"]";
      }
    }
    
    public String a(a parama)
    {
      if (parama == null) {
        return "";
      }
      return new Gson().u(parama);
    }
    
    public a b(String paramString)
    {
      if (TextUtils.isEmpty(paramString)) {
        return new a();
      }
      return (a)new Gson().l(paramString, a.class);
    }
    
    public String c()
    {
      return this.e;
    }
    
    public String d()
    {
      return this.a;
    }
    
    public String e()
    {
      return this.f;
    }
    
    public String f()
    {
      return this.g;
    }
    
    public String g()
    {
      return this.d;
    }
    
    public String h()
    {
      return this.b;
    }
    
    public String i()
    {
      return this.c;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ArmScheduleInfo{monday='");
      localStringBuilder.append(this.a);
      localStringBuilder.append('\'');
      localStringBuilder.append(", tuesday='");
      localStringBuilder.append(this.b);
      localStringBuilder.append('\'');
      localStringBuilder.append(", wednesday='");
      localStringBuilder.append(this.c);
      localStringBuilder.append('\'');
      localStringBuilder.append(", thursday='");
      localStringBuilder.append(this.d);
      localStringBuilder.append('\'');
      localStringBuilder.append(", friday='");
      localStringBuilder.append(this.e);
      localStringBuilder.append('\'');
      localStringBuilder.append(", saturday='");
      localStringBuilder.append(this.f);
      localStringBuilder.append('\'');
      localStringBuilder.append(", sunday='");
      localStringBuilder.append(this.g);
      localStringBuilder.append('\'');
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
  }
  
  public static class b
    implements PropertyConverter<List<b>, String>
  {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    
    public b() {}
    
    public b(LineCrossingDetectionRegion paramLineCrossingDetectionRegion)
    {
      this.a = paramLineCrossingDetectionRegion.getPoint1X();
      this.b = paramLineCrossingDetectionRegion.getPoint1Y();
      this.c = paramLineCrossingDetectionRegion.getPoint2X();
      this.d = paramLineCrossingDetectionRegion.getPoint2Y();
      this.f = paramLineCrossingDetectionRegion.getDirection();
      this.e = paramLineCrossingDetectionRegion.getSensitivity();
    }
    
    public LineCrossingDetectionRegion a()
    {
      return new LineCrossingDetectionRegion(this.a, this.b, this.c, this.d, this.e, this.f);
    }
    
    public String b(List<b> paramList)
    {
      if (paramList == null) {
        return null;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        paramList = (b)localIterator.next();
        localStringBuilder.append(new Gson().u(paramList));
        localStringBuilder.append(65292);
      }
      if (localStringBuilder.length() > 0) {
        localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
      }
      return localStringBuilder.toString();
    }
    
    public List<b> c(String paramString)
    {
      if (TextUtils.isEmpty(paramString)) {
        return new ArrayList();
      }
      String[] arrayOfString = paramString.split("，");
      paramString = new ArrayList();
      int i = arrayOfString.length;
      for (int j = 0; j < i; j++)
      {
        String str = arrayOfString[j];
        paramString.add(new Gson().l(str, b.class));
      }
      return paramString;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("LineCrossingDetectionRegion{point1X='");
      localStringBuilder.append(this.a);
      localStringBuilder.append('\'');
      localStringBuilder.append(", point1Y='");
      localStringBuilder.append(this.b);
      localStringBuilder.append('\'');
      localStringBuilder.append(", point2X='");
      localStringBuilder.append(this.c);
      localStringBuilder.append('\'');
      localStringBuilder.append(", point2Y='");
      localStringBuilder.append(this.d);
      localStringBuilder.append('\'');
      localStringBuilder.append(", sensitivity='");
      localStringBuilder.append(this.e);
      localStringBuilder.append('\'');
      localStringBuilder.append(", direction='");
      localStringBuilder.append(this.f);
      localStringBuilder.append('\'');
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
  }
  
  public static class c
    implements PropertyConverter<List<c>, String>
  {
    private int a;
    private int b;
    private int c;
    private int d;
    
    public c() {}
    
    public c(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramInt3;
      this.d = paramInt4;
    }
    
    public String a(List<c> paramList)
    {
      if (paramList == null) {
        return null;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        paramList = (c)localIterator.next();
        localStringBuilder.append(new Gson().u(paramList));
        localStringBuilder.append(65292);
      }
      if (localStringBuilder.length() > 0) {
        localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
      }
      return localStringBuilder.toString();
    }
    
    public List<c> b(String paramString)
    {
      if (TextUtils.isEmpty(paramString)) {
        return new ArrayList();
      }
      paramString = paramString.split("，");
      ArrayList localArrayList = new ArrayList();
      int i = paramString.length;
      for (int j = 0; j < i; j++)
      {
        String str = paramString[j];
        localArrayList.add(new Gson().l(str, c.class));
      }
      return localArrayList;
    }
    
    public int c()
    {
      return this.d;
    }
    
    public int d()
    {
      return this.c;
    }
    
    public int e()
    {
      return this.a;
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      boolean bool1 = paramObject instanceof c;
      boolean bool2 = false;
      if (!bool1) {
        return false;
      }
      if (paramObject == this) {
        return true;
      }
      paramObject = (c)paramObject;
      bool1 = bool2;
      if (((c)paramObject).a == this.a)
      {
        bool1 = bool2;
        if (((c)paramObject).b == this.b)
        {
          bool1 = bool2;
          if (((c)paramObject).c == this.c)
          {
            bool1 = bool2;
            if (((c)paramObject).d == this.d) {
              bool1 = true;
            }
          }
        }
      }
      return bool1;
    }
    
    public int f()
    {
      return this.b;
    }
    
    public void g(int paramInt)
    {
      this.d = paramInt;
    }
    
    public void h(int paramInt)
    {
      this.c = paramInt;
    }
    
    public int hashCode()
    {
      return ((this.a * 31 + this.b) * 31 + this.c) * 31 + this.d;
    }
    
    public void i(int paramInt)
    {
      this.a = paramInt;
    }
    
    public void j(int paramInt)
    {
      this.b = paramInt;
    }
    
    @NonNull
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Region(x:");
      localStringBuilder.append(this.a);
      localStringBuilder.append(",y:");
      localStringBuilder.append(this.b);
      localStringBuilder.append(",w:");
      localStringBuilder.append(this.c);
      localStringBuilder.append(",h:");
      localStringBuilder.append(this.d);
      localStringBuilder.append(")");
      return localStringBuilder.toString();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpmediaother\database\model\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */