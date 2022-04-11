package com.tplink.iot.databinding;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;

public abstract class FragmentRecordTypeDialogBinding
  extends ViewDataBinding
{
  @NonNull
  public final Button c;
  @NonNull
  public final View d;
  @NonNull
  public final AppCompatRadioButton f;
  @Bindable
  protected View.OnClickListener p0;
  @Bindable
  protected RadioGroup.OnCheckedChangeListener p1;
  @NonNull
  public final AppCompatRadioButton q;
  @NonNull
  public final Button x;
  @NonNull
  public final TextView y;
  @NonNull
  public final RadioGroup z;
  
  protected FragmentRecordTypeDialogBinding(Object paramObject, View paramView1, int paramInt, Button paramButton1, View paramView2, AppCompatRadioButton paramAppCompatRadioButton1, AppCompatRadioButton paramAppCompatRadioButton2, Button paramButton2, TextView paramTextView, RadioGroup paramRadioGroup)
  {
    super(paramObject, paramView1, paramInt);
    this.c = paramButton1;
    this.d = paramView2;
    this.f = paramAppCompatRadioButton1;
    this.q = paramAppCompatRadioButton2;
    this.x = paramButton2;
    this.y = paramTextView;
    this.z = paramRadioGroup;
  }
  
  public abstract void h(@Nullable RadioGroup.OnCheckedChangeListener paramOnCheckedChangeListener);
  
  public abstract void i(@Nullable View.OnClickListener paramOnClickListener);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentRecordTypeDialogBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */