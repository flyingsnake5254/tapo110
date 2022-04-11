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
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AlertDialog.Builder;
import androidx.appcompat.app.AppCompatDialog;
import androidx.cardview.widget.CardView;
import com.andexert.library.RippleView;
import com.andexert.library.RippleView.b;

public class TPMaterialDialog
  extends AlertDialog
{
  private int H3 = 2131099831;
  private String I3 = "";
  private ColorStateList J3;
  private float K3 = -1.0F;
  private d L3 = null;
  private String M3 = "";
  private ColorStateList N3;
  private float O3 = -1.0F;
  private d P3 = null;
  private View Q3 = null;
  private c R3 = null;
  private View S3 = null;
  private c T3 = null;
  private boolean U3 = true;
  private boolean V3 = true;
  private int W3 = 200;
  private int X3 = 200;
  private CardView c;
  private TextView d;
  private TextView f;
  private RippleView p0;
  private String p1 = "";
  private int p2 = 2131099831;
  private String p3 = "";
  private Button q;
  private Button x;
  private FrameLayout y;
  private RippleView z;
  
  protected TPMaterialDialog(Context paramContext)
  {
    super(paramContext, 2132017570);
  }
  
  private void o(TPMaterialDialog paramTPMaterialDialog)
  {
    Object localObject;
    if (paramTPMaterialDialog.S3 != null)
    {
      paramTPMaterialDialog.c.removeAllViews();
      paramTPMaterialDialog.c.addView(paramTPMaterialDialog.S3);
      localObject = paramTPMaterialDialog.T3;
      if (localObject != null) {
        ((c)localObject).a(paramTPMaterialDialog, paramTPMaterialDialog.S3);
      }
      return;
    }
    if (TextUtils.isEmpty(paramTPMaterialDialog.p1))
    {
      paramTPMaterialDialog.d.setVisibility(8);
    }
    else
    {
      paramTPMaterialDialog.d.setVisibility(0);
      paramTPMaterialDialog.d.setText(paramTPMaterialDialog.p1);
      paramTPMaterialDialog.d.setTextColor(getContext().getResources().getColor(paramTPMaterialDialog.p2));
    }
    if (TextUtils.isEmpty(paramTPMaterialDialog.p3))
    {
      paramTPMaterialDialog.f.setVisibility(8);
    }
    else
    {
      paramTPMaterialDialog.f.setVisibility(0);
      paramTPMaterialDialog.f.setText(paramTPMaterialDialog.p3);
      paramTPMaterialDialog.f.setTextColor(getContext().getResources().getColor(paramTPMaterialDialog.H3));
    }
    if (this.Q3 != null)
    {
      paramTPMaterialDialog.f.setVisibility(8);
      paramTPMaterialDialog.y.setVisibility(0);
      paramTPMaterialDialog.y.removeAllViews();
      paramTPMaterialDialog.y.addView(paramTPMaterialDialog.Q3);
      localObject = (RelativeLayout.LayoutParams)paramTPMaterialDialog.z.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).addRule(3, paramTPMaterialDialog.y.getId());
      paramTPMaterialDialog.z.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (RelativeLayout.LayoutParams)paramTPMaterialDialog.p0.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).addRule(3, paramTPMaterialDialog.y.getId());
      paramTPMaterialDialog.p0.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = this.R3;
      if (localObject != null) {
        ((c)localObject).a(this, paramTPMaterialDialog.y);
      }
    }
    else
    {
      paramTPMaterialDialog.y.setVisibility(8);
    }
    float f1;
    if (TextUtils.isEmpty(paramTPMaterialDialog.I3))
    {
      paramTPMaterialDialog.q.setVisibility(8);
    }
    else
    {
      paramTPMaterialDialog.q.setVisibility(0);
      paramTPMaterialDialog.q.setText(paramTPMaterialDialog.I3);
      paramTPMaterialDialog.q.setTextColor(paramTPMaterialDialog.J3);
      f1 = this.K3;
      if (f1 != -1.0F) {
        paramTPMaterialDialog.q.setTextSize(f1);
      }
    }
    if (TextUtils.isEmpty(paramTPMaterialDialog.M3))
    {
      paramTPMaterialDialog.x.setVisibility(8);
    }
    else
    {
      paramTPMaterialDialog.x.setVisibility(0);
      paramTPMaterialDialog.x.setText(paramTPMaterialDialog.M3);
      paramTPMaterialDialog.x.setTextColor(paramTPMaterialDialog.N3);
      f1 = this.O3;
      if (f1 != -1.0F) {
        paramTPMaterialDialog.x.setTextSize(f1);
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131559386);
    this.c = ((CardView)findViewById(2131362430));
    this.d = ((TextView)findViewById(2131364252));
    this.f = ((TextView)findViewById(2131363452));
    this.y = ((FrameLayout)findViewById(2131362432));
    this.q = ((Button)findViewById(2131362090));
    this.x = ((Button)findViewById(2131362081));
    this.z = ((RippleView)findViewById(2131362092));
    this.p0 = ((RippleView)findViewById(2131362082));
    this.W3 = this.z.getRippleDuration();
    this.X3 = this.p0.getRippleDuration();
    paramBundle = this.z;
    boolean bool = this.U3;
    int i = 0;
    if (bool) {
      j = this.W3;
    } else {
      j = 0;
    }
    paramBundle.setRippleDuration(j);
    paramBundle = this.p0;
    int j = i;
    if (this.V3) {
      j = this.X3;
    }
    paramBundle.setRippleDuration(j);
    this.q.setEnabled(this.U3);
    this.x.setEnabled(this.V3);
    this.z.setOnRippleCompleteListener(new a());
    this.p0.setOnRippleCompleteListener(new b());
  }
  
  public void show()
  {
    super.show();
    o(this);
  }
  
  public static class Builder
    extends AlertDialog.Builder
  {
    private TPMaterialDialog a;
    
    public Builder(Context paramContext)
    {
      super();
      this.a = new TPMaterialDialog(paramContext);
    }
    
    public TPMaterialDialog a()
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
    
    public Builder d(View paramView)
    {
      TPMaterialDialog.f(this.a, paramView);
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
      TPMaterialDialog.k(this.a, paramString);
      if (paramInt > 0) {
        TPMaterialDialog.l(this.a, paramInt);
      }
      return this;
    }
    
    public Builder i(int paramInt1, int paramInt2, TPMaterialDialog.d paramd)
    {
      String str;
      if (paramInt1 > 0) {
        str = getContext().getResources().getString(paramInt1);
      } else {
        str = "";
      }
      return j(str, paramInt2, paramd);
    }
    
    public Builder j(String paramString, int paramInt, TPMaterialDialog.d paramd)
    {
      ColorStateList localColorStateList;
      if (paramInt > 0) {
        localColorStateList = getContext().getResources().getColorStateList(paramInt);
      } else {
        localColorStateList = getContext().getResources().getColorStateList(2131099839);
      }
      TPMaterialDialog.m(this.a, paramString);
      TPMaterialDialog.n(this.a, localColorStateList);
      TPMaterialDialog.c(this.a, paramd);
      return this;
    }
    
    public Builder k(int paramInt)
    {
      return l(paramInt, 0);
    }
    
    public Builder l(int paramInt1, int paramInt2)
    {
      String str;
      if (paramInt1 > 0) {
        str = getContext().getResources().getString(paramInt1);
      } else {
        str = "";
      }
      return n(str, paramInt2);
    }
    
    public Builder m(String paramString)
    {
      return n(paramString, 0);
    }
    
    public Builder n(String paramString, int paramInt)
    {
      TPMaterialDialog.i(this.a, paramString);
      if (paramInt > 0) {
        TPMaterialDialog.j(this.a, paramInt);
      }
      return this;
    }
    
    public Builder o(int paramInt)
    {
      View localView;
      if (paramInt > 0) {
        localView = LayoutInflater.from(getContext()).inflate(paramInt, TPMaterialDialog.d(this.a), false);
      } else {
        localView = null;
      }
      return p(localView);
    }
    
    public Builder p(View paramView)
    {
      TPMaterialDialog.e(this.a, paramView);
      return this;
    }
    
    public TPMaterialDialog q()
    {
      TPMaterialDialog localTPMaterialDialog = a();
      localTPMaterialDialog.show();
      return localTPMaterialDialog;
    }
  }
  
  class a
    implements RippleView.b
  {
    a() {}
    
    public void j0(RippleView paramRippleView)
    {
      if (TPMaterialDialog.a(TPMaterialDialog.this))
      {
        TPMaterialDialog.this.dismiss();
        if (TPMaterialDialog.b(TPMaterialDialog.this) != null) {
          TPMaterialDialog.b(TPMaterialDialog.this).onClick(paramRippleView);
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
      if (TPMaterialDialog.g(TPMaterialDialog.this))
      {
        TPMaterialDialog.this.dismiss();
        if (TPMaterialDialog.h(TPMaterialDialog.this) != null) {
          TPMaterialDialog.h(TPMaterialDialog.this).onClick(paramRippleView);
        }
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(TPMaterialDialog paramTPMaterialDialog, View paramView);
  }
  
  public static abstract interface d
  {
    public abstract void onClick(View paramView);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\TPMaterialDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */