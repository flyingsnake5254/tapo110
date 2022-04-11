package com.tplink.iot.dailysummary.widget;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import java.util.HashMap;
import kotlin.jvm.internal.j;

public final class SummaryDeleteDialogFragment
  extends DialogFragment
  implements View.OnClickListener
{
  public static final a c = new a(null);
  private b d;
  private final int f;
  private HashMap q;
  
  public SummaryDeleteDialogFragment(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void A0()
  {
    HashMap localHashMap = this.q;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public final void B0(b paramb)
  {
    j.e(paramb, "summaryDeleteDialogListener");
    this.d = paramb;
  }
  
  public void onClick(View paramView)
  {
    j.e(paramView, "v");
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131362051: 
      paramView = this.d;
      if (paramView != null) {
        paramView.b();
      }
      break;
    case 2131362050: 
      paramView = this.d;
      if (paramView != null) {
        paramView.a();
      }
      break;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    j.e(paramLayoutInflater, "inflater");
    paramViewGroup = paramLayoutInflater.inflate(2131558822, paramViewGroup, false);
    j.d(paramViewGroup, "inflater.inflate(R.layou…delete, container, false)");
    paramLayoutInflater = paramViewGroup.findViewById(2131364421);
    j.d(paramLayoutInflater, "view.findViewById<TextVi…tv_dialog_summary_delete)");
    paramBundle = (TextView)paramLayoutInflater;
    if (this.f > 1) {
      paramLayoutInflater = getText(2131952483);
    } else {
      paramLayoutInflater = getText(2131952484);
    }
    paramBundle.setText(paramLayoutInflater);
    paramViewGroup.findViewById(2131362051).setOnClickListener(this);
    paramViewGroup.findViewById(2131362050).setOnClickListener(this);
    return paramViewGroup;
  }
  
  public static final class a {}
  
  public static abstract interface b
  {
    public abstract void a();
    
    public abstract void b();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\dailysummary\widget\SummaryDeleteDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */