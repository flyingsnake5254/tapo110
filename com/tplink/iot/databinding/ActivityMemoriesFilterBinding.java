package com.tplink.iot.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.memories.MemoriesFilterViewModel;

public abstract class ActivityMemoriesFilterBinding
  extends ViewDataBinding
{
  @NonNull
  public final View H3;
  @NonNull
  public final TextView I3;
  @NonNull
  public final TextView J3;
  @NonNull
  public final RadioButton K3;
  @NonNull
  public final RelativeLayout L3;
  @NonNull
  public final TextView M3;
  @NonNull
  public final CheckBox N3;
  @NonNull
  public final RelativeLayout O3;
  @Bindable
  protected g P3;
  @Bindable
  protected MemoriesFilterViewModel Q3;
  @NonNull
  public final Button c;
  @NonNull
  public final CheckBox d;
  @NonNull
  public final RelativeLayout f;
  @NonNull
  public final RecyclerView p0;
  @NonNull
  public final TextView p1;
  @NonNull
  public final CheckBox p2;
  @NonNull
  public final RelativeLayout p3;
  @NonNull
  public final TextView q;
  @NonNull
  public final RadioButton x;
  @NonNull
  public final RelativeLayout y;
  @NonNull
  public final TextView z;
  
  protected ActivityMemoriesFilterBinding(Object paramObject, View paramView1, int paramInt, Button paramButton, CheckBox paramCheckBox1, RelativeLayout paramRelativeLayout1, TextView paramTextView1, RadioButton paramRadioButton1, RelativeLayout paramRelativeLayout2, TextView paramTextView2, RecyclerView paramRecyclerView, TextView paramTextView3, CheckBox paramCheckBox2, RelativeLayout paramRelativeLayout3, View paramView2, TextView paramTextView4, TextView paramTextView5, RadioButton paramRadioButton2, RelativeLayout paramRelativeLayout4, TextView paramTextView6, CheckBox paramCheckBox3, RelativeLayout paramRelativeLayout5)
  {
    super(paramObject, paramView1, paramInt);
    this.c = paramButton;
    this.d = paramCheckBox1;
    this.f = paramRelativeLayout1;
    this.q = paramTextView1;
    this.x = paramRadioButton1;
    this.y = paramRelativeLayout2;
    this.z = paramTextView2;
    this.p0 = paramRecyclerView;
    this.p1 = paramTextView3;
    this.p2 = paramCheckBox2;
    this.p3 = paramRelativeLayout3;
    this.H3 = paramView2;
    this.I3 = paramTextView4;
    this.J3 = paramTextView5;
    this.K3 = paramRadioButton2;
    this.L3 = paramRelativeLayout4;
    this.M3 = paramTextView6;
    this.N3 = paramCheckBox3;
    this.O3 = paramRelativeLayout5;
  }
  
  public abstract void h(@Nullable MemoriesFilterViewModel paramMemoriesFilterViewModel);
  
  public abstract void i(@Nullable g paramg);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityMemoriesFilterBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */