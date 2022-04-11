package com.tplink.iot.databinding;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;

public abstract class ActivityTapoDebugBinding
  extends ViewDataBinding
{
  @NonNull
  public final TextView H3;
  @NonNull
  public final TextView I3;
  @NonNull
  public final TextView J3;
  @NonNull
  public final TextView K3;
  @NonNull
  public final TextView L3;
  @NonNull
  public final TextView M3;
  @NonNull
  public final TextView N3;
  @Bindable
  protected View.OnClickListener O3;
  @Bindable
  protected View.OnLongClickListener P3;
  @NonNull
  public final Button c;
  @NonNull
  public final Button d;
  @NonNull
  public final Button f;
  @NonNull
  public final LinearLayout p0;
  @NonNull
  public final LinearLayout p1;
  @NonNull
  public final LinearLayout p2;
  @NonNull
  public final LinearLayout p3;
  @NonNull
  public final Button q;
  @NonNull
  public final Button x;
  @NonNull
  public final Button y;
  @NonNull
  public final Group z;
  
  protected ActivityTapoDebugBinding(Object paramObject, View paramView, int paramInt, Button paramButton1, Button paramButton2, Button paramButton3, Button paramButton4, Button paramButton5, Button paramButton6, Group paramGroup, LinearLayout paramLinearLayout1, LinearLayout paramLinearLayout2, LinearLayout paramLinearLayout3, LinearLayout paramLinearLayout4, TextView paramTextView1, TextView paramTextView2, TextView paramTextView3, TextView paramTextView4, TextView paramTextView5, TextView paramTextView6, TextView paramTextView7)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramButton1;
    this.d = paramButton2;
    this.f = paramButton3;
    this.q = paramButton4;
    this.x = paramButton5;
    this.y = paramButton6;
    this.z = paramGroup;
    this.p0 = paramLinearLayout1;
    this.p1 = paramLinearLayout2;
    this.p2 = paramLinearLayout3;
    this.p3 = paramLinearLayout4;
    this.H3 = paramTextView1;
    this.I3 = paramTextView2;
    this.J3 = paramTextView3;
    this.K3 = paramTextView4;
    this.L3 = paramTextView5;
    this.M3 = paramTextView6;
    this.N3 = paramTextView7;
  }
  
  public abstract void h(@Nullable View.OnClickListener paramOnClickListener);
  
  public abstract void i(@Nullable View.OnLongClickListener paramOnLongClickListener);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityTapoDebugBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */