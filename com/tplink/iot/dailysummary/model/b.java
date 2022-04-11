package com.tplink.iot.dailysummary.model;

import com.tplink.iot.dailysummary.network.bean.common.SummaryImage;
import com.tplink.iot.e.a.a;
import java.util.ArrayList;
import kotlin.jvm.internal.j;

public final class b
{
  public static final a a = new a(null);
  private String b;
  private int c;
  private String d;
  private SummaryImage e;
  private int f;
  private boolean g;
  private boolean h;
  
  public b(String paramString1, int paramInt1, String paramString2, SummaryImage paramSummaryImage, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.b = paramString1;
    this.c = paramInt1;
    this.d = paramString2;
    this.e = paramSummaryImage;
    this.f = paramInt2;
    this.g = paramBoolean1;
    this.h = paramBoolean2;
  }
  
  public final int a()
  {
    int i;
    if ((this.c == 1) && (!this.g)) {
      i = 0;
    } else {
      i = 8;
    }
    return i;
  }
  
  public final boolean b()
  {
    boolean bool;
    if ((this.c == 0) && (!this.g)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final String c()
  {
    return this.b;
  }
  
  public final String d()
  {
    if (this.b.length() == 10)
    {
      int i = 0;
      int j = 0;
      int k = 0;
      while (j <= 3)
      {
        k = k * 10 + (this.b.charAt(j) - '0');
        j++;
      }
      int m = 5;
      j = 0;
      while (m <= 6)
      {
        j = j * 10 + (this.b.charAt(m) - '0');
        m++;
      }
      for (m = 8; m <= 9; m++) {
        i = i * 10 + (this.b.charAt(m) - '0');
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append((String)a.b().get(j));
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(k);
      localObject = ((StringBuilder)localObject).toString();
      j.d(localObject, "StringBuilder().append(M…).append(year).toString()");
      return (String)localObject;
    }
    return "";
  }
  
  public final int e()
  {
    return this.f;
  }
  
  public final int f()
  {
    if (this.c == 2) {
      return 0;
    }
    return 8;
  }
  
  public final int g()
  {
    int i = this.c;
    if (i != -3)
    {
      if (i != -2) {
        return 2131952503;
      }
      return 2131952499;
    }
    return 2131952502;
  }
  
  public final int h()
  {
    int i = this.c;
    if ((i != 2) && (i != 100)) {
      i = 0;
    } else {
      i = 8;
    }
    return i;
  }
  
  public final int i()
  {
    int i = this.c;
    if (i != 0)
    {
      if (i != 1) {
        return g();
      }
      return 2131952501;
    }
    return 2131952500;
  }
  
  public final int j()
  {
    return this.c;
  }
  
  public final SummaryImage k()
  {
    return this.e;
  }
  
  public final String l()
  {
    return this.d;
  }
  
  public final int m()
  {
    int i;
    if ((this.c == 2) && (!this.g)) {
      i = 0;
    } else {
      i = 8;
    }
    return i;
  }
  
  public final boolean n()
  {
    return this.h;
  }
  
  public final boolean o()
  {
    return this.g;
  }
  
  public final void p(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public final void q(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public final void r(int paramInt)
  {
    this.c = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SummaryItem(date='");
    localStringBuilder.append(this.b);
    localStringBuilder.append("', status=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", thumbnail=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", momentsNum=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", editable=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", choosed=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
  
  public static final class a {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\dailysummary\model\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */