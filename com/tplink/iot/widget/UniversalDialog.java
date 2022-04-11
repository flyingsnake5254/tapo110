package com.tplink.iot.widget;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import b.d.w.c.a;

public class UniversalDialog
  extends DialogFragment
{
  @Nullable
  private TextView c;
  @Nullable
  private TextView d;
  @Nullable
  private TextView f;
  @Nullable
  private TextView q;
  private a x;
  
  private void I0(a parama)
  {
    this.x = parama;
  }
  
  public void J0(String paramString)
  {
    TextView localTextView = this.d;
    if (localTextView != null) {
      localTextView.setText(paramString);
    }
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramBundle = this.x;
    int i;
    if ((paramBundle != null) && (a.a(paramBundle) != null)) {
      i = a.a(this.x).intValue();
    } else {
      i = 2131558829;
    }
    paramBundle = paramLayoutInflater.inflate(i, paramViewGroup);
    paramLayoutInflater = getDialog();
    if (paramLayoutInflater != null)
    {
      paramLayoutInflater.requestWindowFeature(1);
      paramViewGroup = this.x;
      if ((paramViewGroup != null) && (!a.b(paramViewGroup))) {
        paramLayoutInflater.setCanceledOnTouchOutside(false);
      }
    }
    this.c = ((TextView)paramBundle.findViewById(2131362446));
    this.d = ((TextView)paramBundle.findViewById(2131362439));
    this.f = ((TextView)paramBundle.findViewById(2131362443));
    this.q = ((TextView)paramBundle.findViewById(2131362441));
    Object localObject = this.c;
    paramViewGroup = "";
    if (localObject != null)
    {
      paramLayoutInflater = this.x;
      if ((paramLayoutInflater != null) && (a.e(paramLayoutInflater) != null)) {
        paramLayoutInflater = a.e(this.x);
      } else {
        paramLayoutInflater = "";
      }
      ((TextView)localObject).setText(paramLayoutInflater);
      paramLayoutInflater = this.c;
      localObject = this.x;
      if ((localObject != null) && (a.e((a)localObject) != null)) {
        i = 0;
      } else {
        i = 8;
      }
      paramLayoutInflater.setVisibility(i);
    }
    localObject = this.d;
    if (localObject != null)
    {
      paramLayoutInflater = this.x;
      if (paramLayoutInflater == null) {
        paramLayoutInflater = paramViewGroup;
      } else {
        paramLayoutInflater = a.f(paramLayoutInflater);
      }
      ((TextView)localObject).setText(paramLayoutInflater);
    }
    paramViewGroup = this.f;
    if (paramViewGroup != null)
    {
      paramLayoutInflater = this.x;
      if (paramLayoutInflater == null) {
        paramViewGroup.setAllCaps(false);
      } else {
        paramViewGroup.setAllCaps(a.g(paramLayoutInflater));
      }
      paramLayoutInflater = this.x;
      if ((paramLayoutInflater != null) && (a.h(paramLayoutInflater) != null))
      {
        this.f.setText(a.h(this.x));
        this.f.setOnClickListener(new f(this));
      }
      else
      {
        this.f.setVisibility(8);
      }
      paramLayoutInflater = this.x;
      if ((paramLayoutInflater != null) && (a.i(paramLayoutInflater) != -1)) {
        this.f.setTextColor(a.i(this.x));
      } else {
        this.f.setTextColor(-14955521);
      }
    }
    paramLayoutInflater = this.q;
    if (paramLayoutInflater != null)
    {
      paramViewGroup = this.x;
      if (paramViewGroup == null) {
        paramLayoutInflater.setAllCaps(false);
      } else {
        paramLayoutInflater.setAllCaps(a.g(paramViewGroup));
      }
      paramLayoutInflater = this.x;
      if ((paramLayoutInflater != null) && (a.j(paramLayoutInflater) != null))
      {
        this.q.setText(a.j(this.x));
        this.q.setOnClickListener(new e(this));
      }
      else
      {
        this.q.setVisibility(8);
      }
    }
    paramLayoutInflater = this.x;
    if ((paramLayoutInflater != null) && (a.k(paramLayoutInflater) != null)) {
      a.k(this.x).a(paramBundle);
    }
    return paramBundle;
  }
  
  public void show(FragmentManager paramFragmentManager, String paramString)
  {
    try
    {
      super.show(paramFragmentManager, paramString);
    }
    catch (Exception paramFragmentManager)
    {
      a.d("dialog show Exception");
    }
  }
  
  public static class a
  {
    private String a;
    private String b;
    private String c;
    private String d;
    private int e = -1;
    private UniversalDialog.c f;
    private UniversalDialog.b g;
    private Integer h;
    private UniversalDialog.d i;
    private boolean j = false;
    private boolean k = true;
    
    public UniversalDialog l()
    {
      UniversalDialog localUniversalDialog = new UniversalDialog();
      UniversalDialog.A0(localUniversalDialog, this);
      return localUniversalDialog;
    }
    
    public a m(boolean paramBoolean)
    {
      this.j = paramBoolean;
      return this;
    }
    
    public a n(boolean paramBoolean)
    {
      this.k = paramBoolean;
      return this;
    }
    
    public a o(@LayoutRes int paramInt)
    {
      this.h = Integer.valueOf(paramInt);
      return this;
    }
    
    public a p(@LayoutRes int paramInt, UniversalDialog.d paramd)
    {
      this.h = Integer.valueOf(paramInt);
      this.i = paramd;
      return this;
    }
    
    public a q(String paramString)
    {
      this.b = paramString;
      return this;
    }
    
    public a r(UniversalDialog.b paramb)
    {
      this.g = paramb;
      return this;
    }
    
    public a s(String paramString)
    {
      this.c = paramString;
      return this;
    }
    
    public a t(UniversalDialog.c paramc)
    {
      this.f = paramc;
      return this;
    }
    
    public a u(String paramString)
    {
      this.d = paramString;
      return this;
    }
    
    public a v(@ColorInt int paramInt)
    {
      this.e = paramInt;
      return this;
    }
    
    public a w(String paramString)
    {
      this.a = paramString;
      return this;
    }
  }
  
  public static abstract interface b
  {
    public abstract void a();
  }
  
  public static abstract interface c
  {
    public abstract void a();
  }
  
  public static abstract interface d
  {
    public abstract void a(View paramView);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\UniversalDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */