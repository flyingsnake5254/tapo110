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

public class TPLongThreeMaterialDialog
  extends AlertDialog
{
  private int H3 = 2131099799;
  private String I3 = "";
  private int J3 = 2131099791;
  private String K3 = "";
  private String L3 = "";
  private ColorStateList M3;
  private ColorStateList N3;
  private e O3 = null;
  private e P3 = null;
  private String Q3 = "";
  private ColorStateList R3;
  private e S3 = null;
  private View T3 = null;
  private d U3 = null;
  private View V3 = null;
  private d W3 = null;
  private View X3 = null;
  private View Y3 = null;
  private int Z3 = -1;
  private int a4 = 0;
  private int b4 = 0;
  private CardView c;
  private boolean c4 = true;
  private TextView d;
  private boolean d4 = true;
  private boolean e4 = true;
  private TextView f;
  private int f4 = 200;
  private int g4 = 200;
  private int h4 = 200;
  private boolean i4 = true;
  private boolean j4 = true;
  private boolean k4 = true;
  private RippleView p0;
  private RippleView p1;
  private RippleView p2;
  private String p3 = "";
  private Button q;
  private Button x;
  private Button y;
  private FrameLayout z;
  
  protected TPLongThreeMaterialDialog(Context paramContext)
  {
    super(paramContext, 2132017570);
  }
  
  private void A(TPLongThreeMaterialDialog paramTPLongThreeMaterialDialog)
  {
    int i = paramTPLongThreeMaterialDialog.Z3;
    if (i != -1) {
      paramTPLongThreeMaterialDialog.c.setRadius(i);
    }
    Object localObject;
    if (paramTPLongThreeMaterialDialog.V3 != null)
    {
      paramTPLongThreeMaterialDialog.c.removeAllViews();
      paramTPLongThreeMaterialDialog.c.addView(paramTPLongThreeMaterialDialog.V3);
      localObject = paramTPLongThreeMaterialDialog.W3;
      if (localObject != null) {
        ((d)localObject).a(paramTPLongThreeMaterialDialog, paramTPLongThreeMaterialDialog.V3);
      }
      return;
    }
    if (TextUtils.isEmpty(paramTPLongThreeMaterialDialog.p3))
    {
      paramTPLongThreeMaterialDialog.d.setVisibility(8);
    }
    else
    {
      paramTPLongThreeMaterialDialog.d.setVisibility(0);
      paramTPLongThreeMaterialDialog.d.setText(paramTPLongThreeMaterialDialog.p3);
      paramTPLongThreeMaterialDialog.d.setTextColor(getContext().getResources().getColor(paramTPLongThreeMaterialDialog.H3));
    }
    if (TextUtils.isEmpty(paramTPLongThreeMaterialDialog.I3))
    {
      paramTPLongThreeMaterialDialog.f.setVisibility(8);
    }
    else
    {
      paramTPLongThreeMaterialDialog.f.setVisibility(0);
      paramTPLongThreeMaterialDialog.f.setText(paramTPLongThreeMaterialDialog.I3);
      paramTPLongThreeMaterialDialog.f.setTextColor(getContext().getResources().getColor(paramTPLongThreeMaterialDialog.J3));
      localObject = (RelativeLayout.LayoutParams)paramTPLongThreeMaterialDialog.f.getLayoutParams();
      if (TextUtils.isEmpty(paramTPLongThreeMaterialDialog.p3)) {
        ((RelativeLayout.LayoutParams)localObject).topMargin = a.a(getContext(), 20.0F);
      } else {
        ((RelativeLayout.LayoutParams)localObject).topMargin = a.a(getContext(), 15.0F);
      }
      paramTPLongThreeMaterialDialog.f.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if (this.T3 != null)
    {
      paramTPLongThreeMaterialDialog.z.setVisibility(0);
      paramTPLongThreeMaterialDialog.z.removeAllViews();
      paramTPLongThreeMaterialDialog.z.addView(paramTPLongThreeMaterialDialog.T3);
      localObject = this.U3;
      if (localObject != null) {
        ((d)localObject).a(this, paramTPLongThreeMaterialDialog.z);
      }
    }
    else
    {
      paramTPLongThreeMaterialDialog.z.setVisibility(8);
    }
    this.X3.setVisibility(this.a4);
    this.Y3.setVisibility(this.b4);
    if (TextUtils.isEmpty(paramTPLongThreeMaterialDialog.K3))
    {
      paramTPLongThreeMaterialDialog.q.setVisibility(8);
    }
    else
    {
      paramTPLongThreeMaterialDialog.q.setVisibility(0);
      paramTPLongThreeMaterialDialog.q.setText(paramTPLongThreeMaterialDialog.K3);
      paramTPLongThreeMaterialDialog.q.setTextColor(paramTPLongThreeMaterialDialog.M3);
    }
    if (TextUtils.isEmpty(paramTPLongThreeMaterialDialog.L3))
    {
      paramTPLongThreeMaterialDialog.x.setVisibility(8);
    }
    else
    {
      paramTPLongThreeMaterialDialog.x.setVisibility(0);
      paramTPLongThreeMaterialDialog.x.setText(paramTPLongThreeMaterialDialog.L3);
      paramTPLongThreeMaterialDialog.x.setTextColor(paramTPLongThreeMaterialDialog.N3);
    }
    if (TextUtils.isEmpty(paramTPLongThreeMaterialDialog.Q3))
    {
      paramTPLongThreeMaterialDialog.y.setVisibility(8);
    }
    else
    {
      paramTPLongThreeMaterialDialog.y.setVisibility(0);
      paramTPLongThreeMaterialDialog.y.setText(paramTPLongThreeMaterialDialog.Q3);
      paramTPLongThreeMaterialDialog.y.setTextColor(paramTPLongThreeMaterialDialog.R3);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131559385);
    this.c = ((CardView)findViewById(2131362430));
    this.d = ((TextView)findViewById(2131364252));
    this.f = ((TextView)findViewById(2131363452));
    this.z = ((FrameLayout)findViewById(2131362432));
    this.q = ((Button)findViewById(2131362091));
    this.x = ((Button)findViewById(2131362095));
    this.y = ((Button)findViewById(2131362081));
    this.p0 = ((RippleView)findViewById(2131362093));
    this.p1 = ((RippleView)findViewById(2131362094));
    this.p2 = ((RippleView)findViewById(2131362082));
    this.f4 = this.p0.getRippleDuration();
    this.g4 = this.p1.getRippleDuration();
    this.h4 = this.p2.getRippleDuration();
    paramBundle = this.p0;
    boolean bool = this.c4;
    int i = 0;
    if (bool) {
      j = this.f4;
    } else {
      j = 0;
    }
    paramBundle.setRippleDuration(j);
    paramBundle = this.p1;
    if (this.d4) {
      j = this.g4;
    } else {
      j = 0;
    }
    paramBundle.setRippleDuration(j);
    paramBundle = this.p2;
    int j = i;
    if (this.e4) {
      j = this.h4;
    }
    paramBundle.setRippleDuration(j);
    this.q.setEnabled(this.c4);
    this.x.setEnabled(this.d4);
    this.y.setEnabled(this.e4);
    this.X3 = findViewById(2131364293);
    this.Y3 = findViewById(2131362020);
    this.p0.setOnRippleCompleteListener(new a());
    this.p1.setOnRippleCompleteListener(new b());
    this.p2.setOnRippleCompleteListener(new c());
  }
  
  public void show()
  {
    super.show();
    A(this);
  }
  
  public static class Builder
    extends AlertDialog.Builder
  {
    private TPLongThreeMaterialDialog a;
    
    public Builder(Context paramContext)
    {
      super();
      this.a = new TPLongThreeMaterialDialog(paramContext);
    }
    
    public TPLongThreeMaterialDialog a()
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
      TPLongThreeMaterialDialog.d(this.a, paramInt1);
      TPLongThreeMaterialDialog.e(this.a, paramInt2);
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
      return g(str, paramInt2);
    }
    
    public Builder g(String paramString, int paramInt)
    {
      TPLongThreeMaterialDialog.f(this.a, paramString);
      if (paramInt > 0) {
        TPLongThreeMaterialDialog.g(this.a, paramInt);
      }
      return this;
    }
    
    public Builder h(int paramInt1, int paramInt2, TPLongThreeMaterialDialog.e parame)
    {
      String str;
      if (paramInt1 > 0) {
        str = getContext().getResources().getString(paramInt1);
      } else {
        str = "";
      }
      return j(str, paramInt2, parame);
    }
    
    public Builder i(int paramInt, TPLongThreeMaterialDialog.e parame)
    {
      return h(paramInt, 0, parame);
    }
    
    public Builder j(String paramString, int paramInt, TPLongThreeMaterialDialog.e parame)
    {
      ColorStateList localColorStateList;
      if (paramInt > 0) {
        localColorStateList = getContext().getResources().getColorStateList(paramInt);
      } else {
        localColorStateList = getContext().getResources().getColorStateList(2131099802);
      }
      TPLongThreeMaterialDialog.l(this.a, paramString);
      TPLongThreeMaterialDialog.n(this.a, localColorStateList);
      TPLongThreeMaterialDialog.y(this.a, parame);
      return this;
    }
    
    public Builder k(int paramInt1, int paramInt2, TPLongThreeMaterialDialog.e parame)
    {
      String str;
      if (paramInt1 > 0) {
        str = getContext().getResources().getString(paramInt1);
      } else {
        str = "";
      }
      return l(str, paramInt2, parame);
    }
    
    public Builder l(String paramString, int paramInt, TPLongThreeMaterialDialog.e parame)
    {
      ColorStateList localColorStateList;
      if (paramInt > 0) {
        localColorStateList = getContext().getResources().getColorStateList(paramInt);
      } else {
        localColorStateList = getContext().getResources().getColorStateList(2131099798);
      }
      TPLongThreeMaterialDialog.h(this.a, paramString);
      TPLongThreeMaterialDialog.i(this.a, localColorStateList);
      TPLongThreeMaterialDialog.o(this.a, parame);
      return this;
    }
    
    public Builder m(int paramInt1, int paramInt2, TPLongThreeMaterialDialog.e parame)
    {
      String str;
      if (paramInt1 > 0) {
        str = getContext().getResources().getString(paramInt1);
      } else {
        str = "";
      }
      return n(str, paramInt2, parame);
    }
    
    public Builder n(String paramString, int paramInt, TPLongThreeMaterialDialog.e parame)
    {
      ColorStateList localColorStateList;
      if (paramInt > 0) {
        localColorStateList = getContext().getResources().getColorStateList(paramInt);
      } else {
        localColorStateList = getContext().getResources().getColorStateList(2131099798);
      }
      TPLongThreeMaterialDialog.j(this.a, paramString);
      TPLongThreeMaterialDialog.k(this.a, localColorStateList);
      TPLongThreeMaterialDialog.u(this.a, parame);
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
      TPLongThreeMaterialDialog.z(this.a, paramString);
      if (paramInt > 0) {
        TPLongThreeMaterialDialog.c(this.a, paramInt);
      }
      return this;
    }
    
    public Builder r(int paramInt)
    {
      View localView;
      if (paramInt > 0) {
        localView = LayoutInflater.from(getContext()).inflate(paramInt, TPLongThreeMaterialDialog.p(this.a), false);
      } else {
        localView = null;
      }
      return s(localView);
    }
    
    public Builder s(View paramView)
    {
      TPLongThreeMaterialDialog.q(this.a, paramView);
      return this;
    }
    
    public TPLongThreeMaterialDialog t()
    {
      TPLongThreeMaterialDialog localTPLongThreeMaterialDialog = a();
      localTPLongThreeMaterialDialog.show();
      return localTPLongThreeMaterialDialog;
    }
  }
  
  class a
    implements RippleView.b
  {
    a() {}
    
    public void j0(RippleView paramRippleView)
    {
      if (TPLongThreeMaterialDialog.a(TPLongThreeMaterialDialog.this))
      {
        if (TPLongThreeMaterialDialog.b(TPLongThreeMaterialDialog.this)) {
          TPLongThreeMaterialDialog.this.dismiss();
        }
        if (TPLongThreeMaterialDialog.m(TPLongThreeMaterialDialog.this) != null) {
          TPLongThreeMaterialDialog.m(TPLongThreeMaterialDialog.this).onClick(paramRippleView);
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
      if (TPLongThreeMaterialDialog.r(TPLongThreeMaterialDialog.this))
      {
        if (TPLongThreeMaterialDialog.s(TPLongThreeMaterialDialog.this)) {
          TPLongThreeMaterialDialog.this.dismiss();
        }
        if (TPLongThreeMaterialDialog.t(TPLongThreeMaterialDialog.this) != null) {
          TPLongThreeMaterialDialog.t(TPLongThreeMaterialDialog.this).onClick(paramRippleView);
        }
      }
    }
  }
  
  class c
    implements RippleView.b
  {
    c() {}
    
    public void j0(RippleView paramRippleView)
    {
      if (TPLongThreeMaterialDialog.v(TPLongThreeMaterialDialog.this))
      {
        if (TPLongThreeMaterialDialog.w(TPLongThreeMaterialDialog.this)) {
          TPLongThreeMaterialDialog.this.dismiss();
        }
        if (TPLongThreeMaterialDialog.x(TPLongThreeMaterialDialog.this) != null) {
          TPLongThreeMaterialDialog.x(TPLongThreeMaterialDialog.this).onClick(paramRippleView);
        }
      }
    }
  }
  
  public static abstract interface d
  {
    public abstract void a(TPLongThreeMaterialDialog paramTPLongThreeMaterialDialog, View paramView);
  }
  
  public static abstract interface e
  {
    public abstract void onClick(View paramView);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\TPLongThreeMaterialDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */