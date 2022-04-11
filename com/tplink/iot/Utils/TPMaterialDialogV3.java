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

public class TPMaterialDialogV3
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
  
  protected TPMaterialDialogV3(Context paramContext)
  {
    super(paramContext, 2132017570);
  }
  
  private void r(TPMaterialDialogV3 paramTPMaterialDialogV3)
  {
    Object localObject;
    if (paramTPMaterialDialogV3.S3 != null)
    {
      paramTPMaterialDialogV3.c.removeAllViews();
      paramTPMaterialDialogV3.c.addView(paramTPMaterialDialogV3.S3);
      localObject = paramTPMaterialDialogV3.T3;
      if (localObject != null) {
        ((c)localObject).a(paramTPMaterialDialogV3, paramTPMaterialDialogV3.S3);
      }
      return;
    }
    if (TextUtils.isEmpty(paramTPMaterialDialogV3.p1))
    {
      paramTPMaterialDialogV3.d.setVisibility(8);
    }
    else
    {
      paramTPMaterialDialogV3.d.setVisibility(0);
      paramTPMaterialDialogV3.d.setText(paramTPMaterialDialogV3.p1);
      paramTPMaterialDialogV3.d.setTextColor(getContext().getResources().getColor(paramTPMaterialDialogV3.p2));
    }
    if (TextUtils.isEmpty(paramTPMaterialDialogV3.p3))
    {
      paramTPMaterialDialogV3.f.setVisibility(8);
    }
    else
    {
      paramTPMaterialDialogV3.f.setVisibility(0);
      paramTPMaterialDialogV3.f.setText(paramTPMaterialDialogV3.p3);
      paramTPMaterialDialogV3.f.setTextColor(getContext().getResources().getColor(paramTPMaterialDialogV3.H3));
    }
    if (this.Q3 != null)
    {
      paramTPMaterialDialogV3.f.setVisibility(8);
      paramTPMaterialDialogV3.y.setVisibility(0);
      paramTPMaterialDialogV3.y.removeAllViews();
      paramTPMaterialDialogV3.y.addView(paramTPMaterialDialogV3.Q3);
      localObject = (RelativeLayout.LayoutParams)paramTPMaterialDialogV3.z.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).addRule(3, paramTPMaterialDialogV3.y.getId());
      paramTPMaterialDialogV3.z.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (RelativeLayout.LayoutParams)paramTPMaterialDialogV3.p0.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).addRule(3, paramTPMaterialDialogV3.y.getId());
      paramTPMaterialDialogV3.p0.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = this.R3;
      if (localObject != null) {
        ((c)localObject).a(this, paramTPMaterialDialogV3.y);
      }
    }
    else
    {
      paramTPMaterialDialogV3.y.setVisibility(8);
    }
    float f1;
    if (TextUtils.isEmpty(paramTPMaterialDialogV3.I3))
    {
      paramTPMaterialDialogV3.q.setVisibility(8);
    }
    else
    {
      paramTPMaterialDialogV3.q.setVisibility(0);
      paramTPMaterialDialogV3.q.setText(paramTPMaterialDialogV3.I3);
      paramTPMaterialDialogV3.q.setTextColor(paramTPMaterialDialogV3.J3);
      f1 = this.K3;
      if (f1 != -1.0F) {
        paramTPMaterialDialogV3.q.setTextSize(f1);
      }
    }
    if (TextUtils.isEmpty(paramTPMaterialDialogV3.M3))
    {
      paramTPMaterialDialogV3.x.setVisibility(8);
    }
    else
    {
      paramTPMaterialDialogV3.x.setVisibility(0);
      paramTPMaterialDialogV3.x.setText(paramTPMaterialDialogV3.M3);
      paramTPMaterialDialogV3.x.setTextColor(paramTPMaterialDialogV3.N3);
      f1 = this.O3;
      if (f1 != -1.0F) {
        paramTPMaterialDialogV3.x.setTextSize(f1);
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131559388);
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
  
  public void q(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    int i = 0;
    int j = 0;
    Object localObject;
    if (paramInt1 != -2)
    {
      if (paramInt1 == -1)
      {
        this.U3 = paramBoolean;
        if (paramInt2 > 0) {
          localObject = getContext().getResources().getColorStateList(paramInt2);
        } else {
          localObject = getContext().getResources().getColorStateList(2131099808);
        }
        Button localButton = this.q;
        if (localButton != null)
        {
          localButton.setEnabled(paramBoolean);
          this.q.setTextColor((ColorStateList)localObject);
        }
        localObject = this.z;
        if (localObject != null)
        {
          paramInt1 = j;
          if (paramBoolean) {
            paramInt1 = this.W3;
          }
          ((RippleView)localObject).setRippleDuration(paramInt1);
        }
      }
    }
    else
    {
      this.V3 = paramBoolean;
      localObject = this.x;
      if (localObject != null) {
        ((Button)localObject).setEnabled(paramBoolean);
      }
      localObject = this.p0;
      if (localObject != null)
      {
        paramInt1 = i;
        if (paramBoolean) {
          paramInt1 = this.X3;
        }
        ((RippleView)localObject).setRippleDuration(paramInt1);
      }
    }
  }
  
  public void show()
  {
    super.show();
    r(this);
  }
  
  public static class Builder
    extends AlertDialog.Builder
  {
    private TPMaterialDialogV3 a;
    
    public Builder(Context paramContext)
    {
      super();
      this.a = new TPMaterialDialogV3(paramContext);
    }
    
    public TPMaterialDialogV3 a()
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
      return e(paramInt, 0);
    }
    
    public Builder e(int paramInt1, int paramInt2)
    {
      String str;
      if (paramInt1 > 0) {
        str = getContext().getResources().getString(paramInt1);
      } else {
        str = "";
      }
      return g(str, paramInt2);
    }
    
    public Builder f(String paramString)
    {
      return g(paramString, 0);
    }
    
    public Builder g(String paramString, int paramInt)
    {
      TPMaterialDialogV3.m(this.a, paramString);
      if (paramInt > 0) {
        TPMaterialDialogV3.n(this.a, paramInt);
      }
      return this;
    }
    
    public Builder h(int paramInt1, int paramInt2, TPMaterialDialogV3.d paramd)
    {
      String str;
      if (paramInt1 > 0) {
        str = getContext().getResources().getString(paramInt1);
      } else {
        str = "";
      }
      return i(str, paramInt2, paramd);
    }
    
    public Builder i(String paramString, int paramInt, TPMaterialDialogV3.d paramd)
    {
      ColorStateList localColorStateList;
      if (paramInt > 0) {
        localColorStateList = getContext().getResources().getColorStateList(paramInt);
      } else {
        localColorStateList = getContext().getResources().getColorStateList(2131099839);
      }
      TPMaterialDialogV3.d(this.a, paramString);
      TPMaterialDialogV3.e(this.a, localColorStateList);
      TPMaterialDialogV3.j(this.a, paramd);
      return this;
    }
    
    public Builder j(int paramInt1, int paramInt2, TPMaterialDialogV3.d paramd)
    {
      String str;
      if (paramInt1 > 0) {
        str = getContext().getResources().getString(paramInt1);
      } else {
        str = "";
      }
      return l(str, paramInt2, paramd);
    }
    
    public Builder k(int paramInt, TPMaterialDialogV3.d paramd)
    {
      return j(paramInt, 0, paramd);
    }
    
    public Builder l(String paramString, int paramInt, TPMaterialDialogV3.d paramd)
    {
      ColorStateList localColorStateList;
      if (paramInt > 0) {
        localColorStateList = getContext().getResources().getColorStateList(paramInt);
      } else {
        localColorStateList = getContext().getResources().getColorStateList(2131099766);
      }
      TPMaterialDialogV3.o(this.a, paramString);
      TPMaterialDialogV3.p(this.a, localColorStateList);
      TPMaterialDialogV3.c(this.a, paramd);
      return this;
    }
    
    public Builder m(String paramString, TPMaterialDialogV3.d paramd)
    {
      return l(paramString, 0, paramd);
    }
    
    public Builder n(int paramInt)
    {
      return o(paramInt, 0);
    }
    
    public Builder o(int paramInt1, int paramInt2)
    {
      String str;
      if (paramInt1 > 0) {
        str = getContext().getResources().getString(paramInt1);
      } else {
        str = "";
      }
      return q(str, paramInt2);
    }
    
    public Builder p(String paramString)
    {
      return q(paramString, 0);
    }
    
    public Builder q(String paramString, int paramInt)
    {
      TPMaterialDialogV3.k(this.a, paramString);
      if (paramInt > 0) {
        TPMaterialDialogV3.l(this.a, paramInt);
      }
      return this;
    }
    
    public Builder r(int paramInt)
    {
      View localView;
      if (paramInt > 0) {
        localView = LayoutInflater.from(getContext()).inflate(paramInt, TPMaterialDialogV3.f(this.a), false);
      } else {
        localView = null;
      }
      return s(localView);
    }
    
    public Builder s(View paramView)
    {
      TPMaterialDialogV3.g(this.a, paramView);
      return this;
    }
    
    public TPMaterialDialogV3 t()
    {
      TPMaterialDialogV3 localTPMaterialDialogV3 = a();
      localTPMaterialDialogV3.show();
      return localTPMaterialDialogV3;
    }
  }
  
  class a
    implements RippleView.b
  {
    a() {}
    
    public void j0(RippleView paramRippleView)
    {
      if (TPMaterialDialogV3.a(TPMaterialDialogV3.this))
      {
        TPMaterialDialogV3.this.dismiss();
        if (TPMaterialDialogV3.b(TPMaterialDialogV3.this) != null) {
          TPMaterialDialogV3.b(TPMaterialDialogV3.this).onClick(paramRippleView);
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
      if (TPMaterialDialogV3.h(TPMaterialDialogV3.this))
      {
        TPMaterialDialogV3.this.dismiss();
        if (TPMaterialDialogV3.i(TPMaterialDialogV3.this) != null) {
          TPMaterialDialogV3.i(TPMaterialDialogV3.this).onClick(paramRippleView);
        }
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(TPMaterialDialogV3 paramTPMaterialDialogV3, View paramView);
  }
  
  public static abstract interface d
  {
    public abstract void onClick(View paramView);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\TPMaterialDialogV3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */