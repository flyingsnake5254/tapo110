package com.tplink.iot.dailysummary.widget;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import java.util.HashMap;
import kotlin.jvm.internal.j;

public final class SummarySettingDialogFragment
  extends DialogFragment
  implements View.OnClickListener
{
  public static final a c = new a(null);
  private b d;
  private HashMap f;
  
  public void A0()
  {
    HashMap localHashMap = this.f;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public final void B0(b paramb)
  {
    j.e(paramb, "summarySettingDialogListener");
    this.d = paramb;
  }
  
  public void onClick(View paramView)
  {
    j.e(paramView, "v");
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131362053: 
      paramView = this.d;
      if (paramView != null) {
        paramView.a();
      }
      break;
    case 2131362052: 
      paramView = this.d;
      if (paramView != null) {
        paramView.b();
      }
      break;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    j.e(paramLayoutInflater, "inflater");
    paramLayoutInflater = paramLayoutInflater.inflate(2131558823, paramViewGroup, false);
    j.d(paramLayoutInflater, "inflater.inflate(R.layou…etting, container, false)");
    paramLayoutInflater.findViewById(2131362053).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131362052).setOnClickListener(this);
    return paramLayoutInflater;
  }
  
  public static final class a {}
  
  public static abstract interface b
  {
    public abstract void a();
    
    public abstract void b();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\dailysummary\widget\SummarySettingDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */