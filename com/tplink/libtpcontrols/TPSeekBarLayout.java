package com.tplink.libtpcontrols;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.DrawableRes;
import com.tplink.libtpcontrols.materialnormalcompat.seekbar.DiscreteSeekBar;
import com.tplink.libtpcontrols.materialnormalcompat.seekbar.DiscreteSeekBar.d;
import com.tplink.libtpcontrols.z0.e;

public class TPSeekBarLayout
  extends LinearLayout
{
  private b H3;
  private e I3;
  private View c;
  private DiscreteSeekBar d;
  private ImageView f;
  private int p0;
  private boolean p1;
  private Bitmap[] p2;
  private Bitmap[] p3;
  private ImageView q;
  private int x;
  private int y;
  private boolean z;
  
  public TPSeekBarLayout(Context paramContext)
  {
    super(paramContext);
    g(paramContext, null);
  }
  
  public TPSeekBarLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    g(paramContext, paramAttributeSet);
  }
  
  public TPSeekBarLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    g(paramContext, paramAttributeSet);
  }
  
  private Bitmap[] e(@DrawableRes int paramInt)
  {
    if (paramInt == -1) {
      return null;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeResource(getResources(), paramInt, localOptions);
    localOptions.inSampleSize = 1;
    localOptions.inJustDecodeBounds = false;
    return f(BitmapFactory.decodeResource(getResources(), paramInt, localOptions));
  }
  
  private Bitmap[] f(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    Bitmap[] arrayOfBitmap = new Bitmap[2];
    arrayOfBitmap[0] = paramBitmap.copy(Bitmap.Config.ARGB_8888, true);
    arrayOfBitmap[1] = paramBitmap.copy(Bitmap.Config.ARGB_8888, true);
    new Canvas(arrayOfBitmap[1]).drawColor(this.x, PorterDuff.Mode.SRC_IN);
    if (!paramBitmap.isRecycled()) {
      paramBitmap.recycle();
    }
    return arrayOfBitmap;
  }
  
  private void g(Context paramContext, AttributeSet paramAttributeSet)
  {
    View localView = LayoutInflater.from(paramContext).inflate(t0.layout_float_seekbar, this);
    this.c = localView;
    this.d = ((DiscreteSeekBar)localView.findViewById(s0.discrete));
    this.f = ((ImageView)this.c.findViewById(s0.img_brightness_left));
    this.q = ((ImageView)this.c.findViewById(s0.img_brightness_right));
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, x0.TPSeekBarLayout);
    this.x = paramContext.getColor(x0.TPSeekBarLayout_tp_seekbar_primmary_color, getResources().getColor(p0.common_tplink_yellow));
    this.y = paramContext.getColor(x0.TPSeekBarLayout_tp_seekbar_secondary_color, getResources().getColor(p0.seekbar_bg));
    this.z = paramContext.getBoolean(x0.TPSeekBarLayout_tp_seekbar_icon_colorable, false);
    this.p0 = paramContext.getDimensionPixelSize(x0.TPSeekBarLayout_tp_seekbar_left_icon_padding, -1);
    boolean bool = paramContext.getBoolean(x0.TPSeekBarLayout_tp_seekbar_enable, true);
    this.p1 = bool;
    this.d.setEnabled(bool);
    int i = paramContext.getResourceId(x0.TPSeekBarLayout_tp_seekbar_left, u0.brightness_low);
    int j = paramContext.getResourceId(x0.TPSeekBarLayout_tp_seekbar_right, u0.brightness);
    this.p2 = e(i);
    this.p3 = e(j);
    paramContext.recycle();
    j = this.p0;
    if (j > 0) {
      this.f.setPadding(j, j, j, j);
    }
    paramContext = this.d;
    j = this.x;
    paramContext.r(j, j);
    this.d.setScrubberColor(this.x);
    this.d.setTrackColor(this.y);
    this.d.setOnProgressChangeListener(new a());
  }
  
  private void setBrightness(boolean paramBoolean)
  {
    ImageView localImageView = this.f;
    Object localObject = this.p2;
    if (paramBoolean) {
      localObject = localObject[1];
    } else {
      localObject = localObject[0];
    }
    localImageView.setImageBitmap((Bitmap)localObject);
    localImageView = this.q;
    if (paramBoolean) {
      localObject = this.p3[1];
    } else {
      localObject = this.p3[0];
    }
    localImageView.setImageBitmap((Bitmap)localObject);
  }
  
  public int getProgress()
  {
    return this.d.getProgress();
  }
  
  public boolean isEnabled()
  {
    return this.p1;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    this.p1 = paramBoolean;
    this.d.setEnabled(paramBoolean);
  }
  
  public void setOnPositionChangeListener(b paramb)
  {
    this.H3 = paramb;
  }
  
  public void setOnTouchCancelListener(e parame)
  {
    this.I3 = parame;
    parame = this.d;
    if (parame != null) {
      parame.setOnTouchCancelListener(new e0(this));
    }
  }
  
  public void setProgress(int paramInt)
  {
    this.d.setProgress(paramInt);
  }
  
  class a
    implements DiscreteSeekBar.d
  {
    a() {}
    
    public void a(DiscreteSeekBar paramDiscreteSeekBar)
    {
      if (TPSeekBarLayout.c(TPSeekBarLayout.this)) {
        TPSeekBarLayout.d(TPSeekBarLayout.this, true);
      }
    }
    
    public void b(DiscreteSeekBar paramDiscreteSeekBar, int paramInt, boolean paramBoolean)
    {
      if (TPSeekBarLayout.a(TPSeekBarLayout.this) != null) {
        TPSeekBarLayout.a(TPSeekBarLayout.this).a(TPSeekBarLayout.b(TPSeekBarLayout.this), paramInt, paramBoolean);
      }
    }
    
    public void c(DiscreteSeekBar paramDiscreteSeekBar)
    {
      if (TPSeekBarLayout.c(TPSeekBarLayout.this)) {
        TPSeekBarLayout.d(TPSeekBarLayout.this, false);
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(View paramView, int paramInt, boolean paramBoolean);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\TPSeekBarLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */