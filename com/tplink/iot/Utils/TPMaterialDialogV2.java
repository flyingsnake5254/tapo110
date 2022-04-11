package com.tplink.iot.Utils;

import android.app.Dialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AlertDialog.Builder;
import androidx.appcompat.app.AppCompatDialog;
import androidx.cardview.widget.CardView;
import b.d.w.f.a;
import com.andexert.library.RippleView;
import com.andexert.library.RippleView.b;

public class TPMaterialDialogV2
  extends AlertDialog
{
  private int H3 = 2131099791;
  private String I3 = "";
  private ColorStateList J3;
  private d K3 = null;
  private String L3 = "";
  private ColorStateList M3;
  private d N3 = null;
  private View O3 = null;
  private c P3 = null;
  private View Q3 = null;
  private c R3 = null;
  private View S3 = null;
  private View T3 = null;
  private int U3 = -1;
  private int V3 = 0;
  private int W3 = 0;
  private boolean X3 = true;
  private boolean Y3 = true;
  private int Z3 = 200;
  private int a4 = 200;
  private boolean b4 = true;
  private CardView c;
  private boolean c4 = true;
  private TextView d;
  private TextView f;
  private RippleView p0;
  private String p1 = "";
  private int p2 = 2131099799;
  private String p3 = "";
  private Button q;
  private Button x;
  private FrameLayout y;
  private RippleView z;
  
  protected TPMaterialDialogV2(Context paramContext)
  {
    super(paramContext, 2132017570);
  }
  
  private void y(TPMaterialDialogV2 paramTPMaterialDialogV2)
  {
    int i = paramTPMaterialDialogV2.U3;
    if (i != -1) {
      paramTPMaterialDialogV2.c.setRadius(i);
    }
    Object localObject;
    if (paramTPMaterialDialogV2.Q3 != null)
    {
      paramTPMaterialDialogV2.c.removeAllViews();
      paramTPMaterialDialogV2.c.addView(paramTPMaterialDialogV2.Q3);
      localObject = paramTPMaterialDialogV2.R3;
      if (localObject != null) {
        ((c)localObject).a(paramTPMaterialDialogV2, paramTPMaterialDialogV2.Q3);
      }
      return;
    }
    if (TextUtils.isEmpty(paramTPMaterialDialogV2.p1))
    {
      paramTPMaterialDialogV2.d.setVisibility(8);
    }
    else
    {
      paramTPMaterialDialogV2.d.setVisibility(0);
      paramTPMaterialDialogV2.d.setText(paramTPMaterialDialogV2.p1);
      paramTPMaterialDialogV2.d.setTextColor(getContext().getResources().getColor(paramTPMaterialDialogV2.p2));
    }
    if (TextUtils.isEmpty(paramTPMaterialDialogV2.p3))
    {
      paramTPMaterialDialogV2.f.setVisibility(8);
    }
    else
    {
      paramTPMaterialDialogV2.f.setVisibility(0);
      paramTPMaterialDialogV2.f.setText(paramTPMaterialDialogV2.p3);
      paramTPMaterialDialogV2.f.setTextColor(getContext().getResources().getColor(paramTPMaterialDialogV2.H3));
      localObject = (RelativeLayout.LayoutParams)paramTPMaterialDialogV2.f.getLayoutParams();
      if (TextUtils.isEmpty(paramTPMaterialDialogV2.p1)) {
        ((RelativeLayout.LayoutParams)localObject).topMargin = a.a(getContext(), 20.0F);
      } else {
        ((RelativeLayout.LayoutParams)localObject).topMargin = a.a(getContext(), 15.0F);
      }
      paramTPMaterialDialogV2.f.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if (this.O3 != null)
    {
      paramTPMaterialDialogV2.y.setVisibility(0);
      paramTPMaterialDialogV2.y.removeAllViews();
      paramTPMaterialDialogV2.y.addView(paramTPMaterialDialogV2.O3);
      localObject = this.P3;
      if (localObject != null) {
        ((c)localObject).a(this, paramTPMaterialDialogV2.y);
      }
    }
    else
    {
      paramTPMaterialDialogV2.y.setVisibility(8);
    }
    this.S3.setVisibility(this.V3);
    this.T3.setVisibility(this.W3);
    if (TextUtils.isEmpty(paramTPMaterialDialogV2.I3))
    {
      paramTPMaterialDialogV2.q.setVisibility(8);
    }
    else
    {
      paramTPMaterialDialogV2.q.setVisibility(0);
      paramTPMaterialDialogV2.q.setText(paramTPMaterialDialogV2.I3);
      paramTPMaterialDialogV2.q.setTextColor(paramTPMaterialDialogV2.J3);
    }
    if (TextUtils.isEmpty(paramTPMaterialDialogV2.L3))
    {
      paramTPMaterialDialogV2.x.setVisibility(8);
    }
    else
    {
      paramTPMaterialDialogV2.x.setVisibility(0);
      paramTPMaterialDialogV2.x.setText(paramTPMaterialDialogV2.L3);
      paramTPMaterialDialogV2.x.setTextColor(paramTPMaterialDialogV2.M3);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131559387);
    this.c = ((CardView)findViewById(2131362430));
    this.d = ((TextView)findViewById(2131364252));
    this.f = ((TextView)findViewById(2131363452));
    this.y = ((FrameLayout)findViewById(2131362432));
    this.q = ((Button)findViewById(2131362090));
    this.x = ((Button)findViewById(2131362081));
    this.z = ((RippleView)findViewById(2131362092));
    this.p0 = ((RippleView)findViewById(2131362082));
    this.Z3 = this.z.getRippleDuration();
    this.a4 = this.p0.getRippleDuration();
    paramBundle = this.z;
    boolean bool = this.X3;
    int i = 0;
    if (bool) {
      j = this.Z3;
    } else {
      j = 0;
    }
    paramBundle.setRippleDuration(j);
    paramBundle = this.p0;
    int j = i;
    if (this.Y3) {
      j = this.a4;
    }
    paramBundle.setRippleDuration(j);
    this.q.setEnabled(this.X3);
    this.x.setEnabled(this.Y3);
    this.S3 = findViewById(2131364293);
    this.T3 = findViewById(2131362020);
    this.z.setOnRippleCompleteListener(new a());
    this.p0.setOnRippleCompleteListener(new b());
  }
  
  public void show()
  {
    super.show();
    y(this);
  }
  
  public static class Builder
    extends AlertDialog.Builder
  {
    private TPMaterialDialogV2 a;
    
    public Builder(Context paramContext)
    {
      super();
      this.a = new TPMaterialDialogV2(paramContext);
    }
    
    public TPMaterialDialogV2 a()
    {
      return this.a;
    }
    
    public Builder b(boolean paramBoolean)
    {
      this.a.setCancelable(paramBoolean);
      return this;
    }
    
    public Builder c(boolean paramBoolean)
    {
      this.a.setCanceledOnTouchOutside(paramBoolean);
      return this;
    }
    
    public Builder d(int paramInt)
    {
      View localView;
      if (paramInt > 0) {
        localView = LayoutInflater.from(getContext()).inflate(paramInt, TPMaterialDialogV2.l(this.a), false);
      } else {
        localView = null;
      }
      return e(localView);
    }
    
    public Builder e(View paramView)
    {
      TPMaterialDialogV2.n(this.a, paramView);
      return this;
    }
    
    public Builder f(TPMaterialDialogV2.c paramc)
    {
      TPMaterialDialogV2.p(this.a, paramc);
      return this;
    }
    
    public Builder g(int paramInt1, int paramInt2)
    {
      TPMaterialDialogV2.w(this.a, paramInt1);
      TPMaterialDialogV2.x(this.a, paramInt2);
      return this;
    }
    
    public Builder h(int paramInt)
    {
      return i(paramInt, 0);
    }
    
    public Builder i(int paramInt1, int paramInt2)
    {
      String str;
      if (paramInt1 > 0) {
        str = getContext().getResources().getString(paramInt1);
      } else {
        str = "";
      }
      return k(str, paramInt2);
    }
    
    public Builder j(String paramString)
    {
      return k(paramString, 0);
    }
    
    public Builder k(String paramString, int paramInt)
    {
      TPMaterialDialogV2.c(this.a, paramString);
      if (paramInt > 0) {
        TPMaterialDialogV2.d(this.a, paramInt);
      }
      return this;
    }
    
    public Builder l(int paramInt1, int paramInt2, TPMaterialDialogV2.d paramd)
    {
      String str;
      if (paramInt1 > 0) {
        str = getContext().getResources().getString(paramInt1);
      } else {
        str = "";
      }
      return n(str, paramInt2, paramd);
    }
    
    public Builder m(int paramInt, TPMaterialDialogV2.d paramd)
    {
      return l(paramInt, 0, paramd);
    }
    
    public Builder n(String paramString, int paramInt, TPMaterialDialogV2.d paramd)
    {
      ColorStateList localColorStateList;
      if (paramInt > 0) {
        localColorStateList = getContext().getResources().getColorStateList(paramInt);
      } else {
        localColorStateList = getContext().getResources().getColorStateList(2131099802);
      }
      TPMaterialDialogV2.g(this.a, paramString);
      TPMaterialDialogV2.h(this.a, localColorStateList);
      TPMaterialDialogV2.t(this.a, paramd);
      return this;
    }
    
    public Builder o(int paramInt1, int paramInt2, TPMaterialDialogV2.d paramd)
    {
      String str;
      if (paramInt1 > 0) {
        str = getContext().getResources().getString(paramInt1);
      } else {
        str = "";
      }
      return q(str, paramInt2, paramd);
    }
    
    public Builder p(int paramInt, TPMaterialDialogV2.d paramd)
    {
      return o(paramInt, 0, paramd);
    }
    
    public Builder q(String paramString, int paramInt, TPMaterialDialogV2.d paramd)
    {
      ColorStateList localColorStateList;
      if (paramInt > 0) {
        localColorStateList = getContext().getResources().getColorStateList(paramInt);
      } else {
        localColorStateList = getContext().getResources().getColorStateList(2131099798);
      }
      TPMaterialDialogV2.e(this.a, paramString);
      TPMaterialDialogV2.f(this.a, localColorStateList);
      TPMaterialDialogV2.o(this.a, paramd);
      return this;
    }
    
    public Builder r(int paramInt)
    {
      return s(paramInt, 0);
    }
    
    public Builder s(int paramInt1, int paramInt2)
    {
      String str;
      if (paramInt1 > 0) {
        str = getContext().getResources().getString(paramInt1);
      } else {
        str = "";
      }
      return u(str, paramInt2);
    }
    
    public Builder t(String paramString)
    {
      return u(paramString, 0);
    }
    
    public Builder u(String paramString, int paramInt)
    {
      TPMaterialDialogV2.u(this.a, paramString);
      if (paramInt > 0) {
        TPMaterialDialogV2.v(this.a, paramInt);
      }
      return this;
    }
    
    public Builder v(int paramInt)
    {
      View localView;
      if (paramInt > 0) {
        localView = LayoutInflater.from(getContext()).inflate(paramInt, TPMaterialDialogV2.i(this.a), false);
      } else {
        localView = null;
      }
      return w(localView);
    }
    
    public Builder w(View paramView)
    {
      TPMaterialDialogV2.j(this.a, paramView);
      return this;
    }
    
    public Builder x(TPMaterialDialogV2.c paramc)
    {
      TPMaterialDialogV2.k(this.a, paramc);
      return this;
    }
    
    public TPMaterialDialogV2 y()
    {
      TPMaterialDialogV2 localTPMaterialDialogV2 = a();
      localTPMaterialDialogV2.show();
      return localTPMaterialDialogV2;
    }
  }
  
  class a
    implements RippleView.b
  {
    a() {}
    
    public void j0(RippleView paramRippleView)
    {
      if (TPMaterialDialogV2.a(TPMaterialDialogV2.this))
      {
        if (TPMaterialDialogV2.b(TPMaterialDialogV2.this)) {
          TPMaterialDialogV2.this.dismiss();
        }
        if (TPMaterialDialogV2.m(TPMaterialDialogV2.this) != null) {
          TPMaterialDialogV2.m(TPMaterialDialogV2.this).onClick(paramRippleView);
        }
      }
    }
  }
  
  class b
    implements RippleView.b
  {
    b() {}
    
    public void j0(RippleView paramRippleView)
    {
      if (TPMaterialDialogV2.q(TPMaterialDialogV2.this))
      {
        if (TPMaterialDialogV2.r(TPMaterialDialogV2.this)) {
          TPMaterialDialogV2.this.dismiss();
        }
        if (TPMaterialDialogV2.s(TPMaterialDialogV2.this) != null) {
          TPMaterialDialogV2.s(TPMaterialDialogV2.this).onClick(paramRippleView);
        }
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(TPMaterialDialogV2 paramTPMaterialDialogV2, View paramView);
  }
  
  public static abstract interface d
  {
    public abstract void onClick(View paramView);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\TPMaterialDialogV2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */