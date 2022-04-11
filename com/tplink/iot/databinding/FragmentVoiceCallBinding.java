package com.tplink.iot.databinding;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.viewmodel.ipcamera.play.TalkViewModel;

public abstract class FragmentVoiceCallBinding
  extends ViewDataBinding
{
  @NonNull
  public final ImageView c;
  @NonNull
  public final ImageView d;
  @NonNull
  public final TextView f;
  @NonNull
  public final TextView p0;
  @Bindable
  protected TalkViewModel p1;
  @Bindable
  protected View.OnClickListener p2;
  @NonNull
  public final TextView q;
  @NonNull
  public final ImageView x;
  @NonNull
  public final TextView y;
  @NonNull
  public final ImageView z;
  
  protected FragmentVoiceCallBinding(Object paramObject, View paramView, int paramInt, ImageView paramImageView1, ImageView paramImageView2, TextView paramTextView1, TextView paramTextView2, ImageView paramImageView3, TextView paramTextView3, ImageView paramImageView4, TextView paramTextView4)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramImageView1;
    this.d = paramImageView2;
    this.f = paramTextView1;
    this.q = paramTextView2;
    this.x = paramImageView3;
    this.y = paramTextView3;
    this.z = paramImageView4;
    this.p0 = paramTextView4;
  }
  
  public abstract void h(@Nullable View.OnClickListener paramOnClickListener);
  
  public abstract void i(@Nullable TalkViewModel paramTalkViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentVoiceCallBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */