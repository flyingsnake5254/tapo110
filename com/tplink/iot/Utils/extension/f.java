package com.tplink.iot.Utils.extension;

import android.view.View;
import androidx.annotation.ColorRes;
import androidx.annotation.StringRes;
import com.tplink.iot.Utils.TPMaterialDialogV3.Builder;
import com.tplink.iot.Utils.TPMaterialDialogV3.d;
import kotlin.jvm.b.a;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class f
{
  private final int a;
  private final int b;
  private final int c;
  private String d;
  @StringRes
  private int e;
  private String f;
  private final TPMaterialDialogV3.Builder g;
  
  public f(TPMaterialDialogV3.Builder paramBuilder)
  {
    this.g = paramBuilder;
    this.a = 2131099804;
    this.b = 2131099812;
    this.c = 2131099808;
    this.d = "";
    this.f = "";
  }
  
  public final int a()
  {
    return this.a;
  }
  
  public final int b()
  {
    return this.c;
  }
  
  public final int c()
  {
    return this.b;
  }
  
  public final void d(@StringRes int paramInt1, @ColorRes int paramInt2, a<p> parama)
  {
    this.g.h(paramInt1, paramInt2, new a(parama));
  }
  
  public final void f(@StringRes int paramInt1, @ColorRes int paramInt2, a<p> parama)
  {
    this.g.j(paramInt1, paramInt2, new b(parama));
  }
  
  public final void h(int paramInt)
  {
    this.e = paramInt;
    if (paramInt > 0) {
      this.g.d(paramInt);
    } else {
      this.g.f("");
    }
  }
  
  public final void i(String paramString)
  {
    j.e(paramString, "value");
    this.f = paramString;
    this.g.p(paramString);
  }
  
  public final void j(String paramString)
  {
    j.e(paramString, "value");
    this.d = paramString;
    this.g.p(paramString);
  }
  
  public final void k()
  {
    this.g.t();
  }
  
  static final class a
    implements TPMaterialDialogV3.d
  {
    a(a parama) {}
    
    public final void onClick(View paramView)
    {
      paramView = this.a;
      if (paramView != null) {
        paramView = (p)paramView.invoke();
      }
    }
  }
  
  static final class b
    implements TPMaterialDialogV3.d
  {
    b(a parama) {}
    
    public final void onClick(View paramView)
    {
      paramView = this.a;
      if (paramView != null) {
        paramView = (p)paramView.invoke();
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\extension\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */