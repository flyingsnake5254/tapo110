package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;

public abstract class ActivityGuardModeBinding
  extends ViewDataBinding
{
  @NonNull
  public final ImageView c;
  @NonNull
  public final ImageView d;
  @NonNull
  public final ImageView f;
  @NonNull
  public final RelativeLayout q;
  @NonNull
  public final RelativeLayout x;
  @NonNull
  public final RelativeLayout y;
  
  protected ActivityGuardModeBinding(Object paramObject, View paramView, int paramInt, ImageView paramImageView1, ImageView paramImageView2, ImageView paramImageView3, RelativeLayout paramRelativeLayout1, RelativeLayout paramRelativeLayout2, RelativeLayout paramRelativeLayout3)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramImageView1;
    this.d = paramImageView2;
    this.f = paramImageView3;
    this.q = paramRelativeLayout1;
    this.x = paramRelativeLayout2;
    this.y = paramRelativeLayout3;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityGuardModeBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */