package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.adapter.databinding.d;
import com.tplink.iot.view.ipcamera.preview.CameraPreviewInfo;

public abstract class ItemModeAddCameraBinding
  extends ViewDataBinding
{
  @Bindable
  protected Integer H3;
  @NonNull
  public final View c;
  @NonNull
  public final ImageView d;
  @NonNull
  public final ImageView f;
  @Bindable
  protected String p0;
  @Bindable
  protected Integer p1;
  @Bindable
  protected d p2;
  @Bindable
  protected Boolean p3;
  @NonNull
  public final ImageView q;
  @NonNull
  public final TextView x;
  @NonNull
  public final TextView y;
  @Bindable
  protected CameraPreviewInfo z;
  
  protected ItemModeAddCameraBinding(Object paramObject, View paramView1, int paramInt, View paramView2, ImageView paramImageView1, ImageView paramImageView2, ImageView paramImageView3, TextView paramTextView1, TextView paramTextView2)
  {
    super(paramObject, paramView1, paramInt);
    this.c = paramView2;
    this.d = paramImageView1;
    this.f = paramImageView2;
    this.q = paramImageView3;
    this.x = paramTextView1;
    this.y = paramTextView2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ItemModeAddCameraBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */