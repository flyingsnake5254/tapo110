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

public class TPLongMaterialDialogV2
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
  
  protected TPLongMaterialDialogV2(Context paramContext)
  {
    super(paramContext, 2132017570);
  }
  
  private void u(TPLongMaterialDialogV2 paramTPLongMaterialDialogV2)
  {
    int i = paramTPLongMaterialDialogV2.U3;
    if (i != -1) {
      paramTPLongMaterialDialogV2.c.setRadius(i);
    }
    Object localObject;
    if (paramTPLongMaterialDialogV2.Q3 != null)
    {
      paramTPLongMaterialDialogV2.c.removeAllViews();
      paramTPLongMaterialDialogV2.c.addView(paramTPLongMaterialDialogV2.Q3);
      localObject = paramTPLongMaterialDialogV2.R3;
      if (localObject != null) {
        ((c)localObject).a(paramTPLongMaterialDialogV2, paramTPLongMaterialDialogV2.Q3);
      }
      return;
    }
    if (TextUtils.isEmpty(paramTPLongMaterialDialogV2.p1))
    {
      paramTPLongMaterialDialogV2.d.setVisibility(8);
    }
    else
    {
      paramTPLongMaterialDialogV2.d.setVisibility(0);
      paramTPLongMaterialDialogV2.d.setText(paramTPLongMaterialDialogV2.p1);
      paramTPLongMaterialDialogV2.d.setTextColor(getContext().getResources().getColor(paramTPLongMaterialDialogV2.p2));
    }
    if (TextUtils.isEmpty(paramTPLongMaterialDialogV2.p3))
    {
      paramTPLongMaterialDialogV2.f.setVisibility(8);
    }
    else
    {
      paramTPLongMaterialDialogV2.f.setVisibility(0);
      paramTPLongMaterialDialogV2.f.setText(paramTPLongMaterialDialogV2.p3);
      paramTPLongMaterialDialogV2.f.setTextColor(getContext().getResources().getColor(paramTPLongMaterialDialogV2.H3));
      localObject = (RelativeLayout.LayoutParams)paramTPLongMaterialDialogV2.f.getLayoutParams();
      if (TextUtils.isEmpty(paramTPLongMaterialDialogV2.p1)) {
        ((RelativeLayout.LayoutParams)localObject).topMargin = a.a(getContext(), 20.0F);
      } else {
        ((RelativeLayout.LayoutParams)localObject).topMargin = a.a(getContext(), 15.0F);
      }
      paramTPLongMaterialDialogV2.f.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if (this.O3 != null)
    {
      paramTPLongMaterialDialogV2.y.setVisibility(0);
      paramTPLongMaterialDialogV2.y.removeAllViews();
      paramTPLongMaterialDialogV2.y.addView(paramTPLongMaterialDialogV2.O3);
      localObject = this.P3;
      if (localObject != null) {
        ((c)localObject).a(this, paramTPLongMaterialDialogV2.y);
      }
    }
    else
    {
      paramTPLongMaterialDialogV2.y.setVisibility(8);
    }
    this.S3.setVisibility(this.V3);
    this.T3.setVisibility(this.W3);
    if (TextUtils.isEmpty(paramTPLongMaterialDialogV2.I3))
    {
      paramTPLongMaterialDialogV2.q.setVisibility(8);
    }
    else
    {
      paramTPLongMaterialDialogV2.q.setVisibility(0);
      paramTPLongMaterialDialogV2.q.setText(paramTPLongMaterialDialogV2.I3);
      paramTPLongMaterialDialogV2.q.setTextColor(paramTPLongMaterialDialogV2.J3);
    }
    if (TextUtils.isEmpty(paramTPLongMaterialDialogV2.L3))
    {
      paramTPLongMaterialDialogV2.x.setVisibility(8);
    }
    else
    {
      paramTPLongMaterialDialogV2.x.setVisibility(0);
      paramTPLongMaterialDialogV2.x.setText(paramTPLongMaterialDialogV2.L3);
      paramTPLongMaterialDialogV2.x.setTextColor(paramTPLongMaterialDialogV2.M3);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131559384);
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
    u(this);
  }
  
  public static class Builder
    extends AlertDialog.Builder
  {
    private TPLongMaterialDialogV2 a;
    
    public Builder(Context paramContext)
    {
      super();
      this.a = new TPLongMaterialDialogV2(paramContext);
    }
    
    public TPLongMaterialDialogV2 a()
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
    
    public Builder d(int paramInt1, int paramInt2)
    {
      TPLongMaterialDialogV2.s(this.a, paramInt1);
      TPLongMaterialDialogV2.t(this.a, paramInt2);
      return this;
    }
    
    public Builder e(int paramInt)
    {
      return f(paramInt, 0);
    }
    
    public Builder f(int paramInt1, int paramInt2)
    {
      String str;
      if (paramInt1 > 0) {
        str = getContext().getResources().getString(paramInt1);
      } else {
        str = "";
      }
      return h(str, paramInt2);
    }
    
    public Builder g(String paramString)
    {
      return h(paramString, 0);
    }
    
    public Builder h(String paramString, int paramInt)
    {
      TPLongMaterialDialogV2.c(this.a, paramString);
      if (paramInt > 0) {
        TPLongMaterialDialogV2.d(this.a, paramInt);
      }
      return this;
    }
    
    public Builder i(int paramInt1, int paramInt2, TPLongMaterialDialogV2.d paramd)
    {
      String str;
      if (paramInt1 > 0) {
        str = getContext().getResources().getString(paramInt1);
      } else {
        str = "";
      }
      return k(str, paramInt2, paramd);
    }
    
    public Builder j(int paramInt, TPLongMaterialDialogV2.d paramd)
    {
      return i(paramInt, 0, paramd);
    }
    
    public Builder k(String paramString, int paramInt, TPLongMaterialDialogV2.d paramd)
    {
      ColorStateList localColorStateList;
      if (paramInt > 0) {
        localColorStateList = getContext().getResources().getColorStateList(paramInt);
      } else {
        localColorStateList = getContext().getResources().getColorStateList(2131099802);
      }
      TPLongMaterialDialogV2.g(this.a, paramString);
      TPLongMaterialDialogV2.h(this.a, localColorStateList);
      TPLongMaterialDialogV2.p(this.a, paramd);
      return this;
    }
    
    public Builder l(int paramInt1, int paramInt2, TPLongMaterialDialogV2.d paramd)
    {
      String str;
      if (paramInt1 > 0) {
        str = getContext().getResources().getString(paramInt1);
      } else {
        str = "";
      }
      return n(str, paramInt2, paramd);
    }
    
    public Builder m(int paramInt, TPLongMaterialDialogV2.d paramd)
    {
      return l(paramInt, 0, paramd);
    }
    
    public Builder n(String paramString, int paramInt, TPLongMaterialDialogV2.d paramd)
    {
      ColorStateList localColorStateList;
      if (paramInt > 0) {
        localColorStateList = getContext().getResources().getColorStateList(paramInt);
      } else {
        localColorStateList = getContext().getResources().getColorStateList(2131099798);
      }
      TPLongMaterialDialogV2.e(this.a, paramString);
      TPLongMaterialDialogV2.f(this.a, localColorStateList);
      TPLongMaterialDialogV2.l(this.a, paramd);
      return this;
    }
    
    public Builder o(int paramInt)
    {
      return p(paramInt, 0);
    }
    
    public Builder p(int paramInt1, int paramInt2)
    {
      String str;
      if (paramInt1 > 0) {
        str = getContext().getResources().getString(paramInt1);
      } else {
        str = "";
      }
      return q(str, paramInt2);
    }
    
    public Builder q(String paramString, int paramInt)
    {
      TPLongMaterialDialogV2.q(this.a, paramString);
      if (paramInt > 0) {
        TPLongMaterialDialogV2.r(this.a, paramInt);
      }
      return this;
    }
    
    public Builder r(int paramInt)
    {
      View localView;
      if (paramInt > 0) {
        localView = LayoutInflater.from(getContext()).inflate(paramInt, TPLongMaterialDialogV2.i(this.a), false);
      } else {
        localView = null;
      }
      return s(localView);
    }
    
    public Builder s(View paramView)
    {
      TPLongMaterialDialogV2.j(this.a, paramView);
      return this;
    }
    
    public TPLongMaterialDialogV2 t()
    {
      TPLongMaterialDialogV2 localTPLongMaterialDialogV2 = a();
      localTPLongMaterialDialogV2.show();
      return localTPLongMaterialDialogV2;
    }
  }
  
  class a
    implements RippleView.b
  {
    a() {}
    
    public void j0(RippleView paramRippleView)
    {
      if (TPLongMaterialDialogV2.a(TPLongMaterialDialogV2.this))
      {
        if (TPLongMaterialDialogV2.b(TPLongMaterialDialogV2.this)) {
          TPLongMaterialDialogV2.this.dismiss();
        }
        if (TPLongMaterialDialogV2.k(TPLongMaterialDialogV2.this) != null) {
          TPLongMaterialDialogV2.k(TPLongMaterialDialogV2.this).onClick(paramRippleView);
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
      if (TPLongMaterialDialogV2.m(TPLongMaterialDialogV2.this))
      {
        if (TPLongMaterialDialogV2.n(TPLongMaterialDialogV2.this)) {
          TPLongMaterialDialogV2.this.dismiss();
        }
        if (TPLongMaterialDialogV2.o(TPLongMaterialDialogV2.this) != null) {
          TPLongMaterialDialogV2.o(TPLongMaterialDialogV2.this).onClick(paramRippleView);
        }
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(TPLongMaterialDialogV2 paramTPLongMaterialDialogV2, View paramView);
  }
  
  public static abstract interface d
  {
    public abstract void onClick(View paramView);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\TPLongMaterialDialogV2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */