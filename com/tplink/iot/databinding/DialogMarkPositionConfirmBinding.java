package com.tplink.iot.databinding;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.view.ipcamera.widget.multiOperationEditText.MultiOperationInputLayout;

public abstract class DialogMarkPositionConfirmBinding
  extends ViewDataBinding
{
  @NonNull
  public final TextView c;
  @NonNull
  public final EditText d;
  @NonNull
  public final ImageView f;
  @NonNull
  public final View p0;
  @Bindable
  protected MutableLiveData<String> p1;
  @NonNull
  public final MultiOperationInputLayout q;
  @NonNull
  public final ImageView x;
  @NonNull
  public final TextView y;
  @NonNull
  public final TextView z;
  
  protected DialogMarkPositionConfirmBinding(Object paramObject, View paramView1, int paramInt, TextView paramTextView1, EditText paramEditText, ImageView paramImageView1, MultiOperationInputLayout paramMultiOperationInputLayout, ImageView paramImageView2, TextView paramTextView2, TextView paramTextView3, View paramView2)
  {
    super(paramObject, paramView1, paramInt);
    this.c = paramTextView1;
    this.d = paramEditText;
    this.f = paramImageView1;
    this.q = paramMultiOperationInputLayout;
    this.x = paramImageView2;
    this.y = paramTextView2;
    this.z = paramTextView3;
    this.p0 = paramView2;
  }
  
  public abstract void h(@Nullable MutableLiveData<String> paramMutableLiveData);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\DialogMarkPositionConfirmBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */