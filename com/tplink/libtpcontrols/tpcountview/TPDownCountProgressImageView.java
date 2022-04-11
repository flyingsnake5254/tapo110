package com.tplink.libtpcontrols.tpcountview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tplink.libtpcontrols.s0;
import com.tplink.libtpcontrols.t0;
import com.tplink.libtpcontrols.x0;
import io.reactivex.e0.c;
import java.util.concurrent.TimeUnit;

public class TPDownCountProgressImageView
  extends FrameLayout
{
  private int c = 120;
  private int d = 120;
  private boolean f = false;
  private TPCircleProgressImageView p0;
  private TextView p1;
  private View p2;
  private a p3;
  private long q = 1000L;
  private TimeUnit x = TimeUnit.MILLISECONDS;
  private boolean y = false;
  private c z;
  
  public TPDownCountProgressImageView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public TPDownCountProgressImageView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public TPDownCountProgressImageView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    LayoutInflater.from(paramContext).inflate(t0.layout_down_count_progress, this, true);
    this.p2 = this;
    TPCircleProgressImageView localTPCircleProgressImageView = (TPCircleProgressImageView)findViewById(s0.image_view);
    this.p0 = localTPCircleProgressImageView;
    localTPCircleProgressImageView.setOnAnimCompleteListener(new a(this));
    this.p1 = ((TextView)findViewById(s0.text));
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, x0.TPDownCountProgressImageView);
    int i = paramAttributeSet.getDimensionPixelOffset(x0.TPDownCountProgressImageView_cpi_center_size, -1);
    if (i != -1) {
      this.p0.setIconCenterSize(i);
    }
    i = paramAttributeSet.getResourceId(x0.TPDownCountProgressImageView_cpi_center_image, -1);
    if (i != -1) {
      this.p0.setCenterImageResource(i);
    }
    i = paramAttributeSet.getColor(x0.TPDownCountProgressImageView_bur_center_color, -1);
    if (i != -1) {
      this.p0.setBurCenterColor(i);
    }
    i = paramAttributeSet.getColor(x0.TPDownCountProgressImageView_hook_color, -1);
    if (i != -1) {
      this.p0.setHookColor(i);
    }
    i = paramAttributeSet.getColor(x0.TPDownCountProgressImageView_arc_color, -1);
    if (i != -1) {
      this.p0.setArcColor(i);
    }
    i = paramAttributeSet.getColor(x0.TPDownCountProgressImageView_circle_color, -1);
    if (i != -1) {
      this.p0.setCircleColor(i);
    }
    float f1 = paramAttributeSet.getDimensionPixelOffset(x0.TPDownCountProgressImageView_hook_width, -1);
    if (f1 != -1.0F) {
      this.p0.setHookWidth(f1);
    }
    f1 = paramAttributeSet.getDimensionPixelOffset(x0.TPDownCountProgressImageView_arc_width, -1);
    if (f1 != -1.0F) {
      this.p0.setArcWidth(f1);
    }
    f1 = paramAttributeSet.getDimensionPixelOffset(x0.TPDownCountProgressImageView_circle_padding, -1);
    boolean bool = f1 < -1.0F;
    if (bool) {
      this.p0.setCirclePadding(f1);
    }
    f1 = paramAttributeSet.getDimensionPixelOffset(x0.TPDownCountProgressImageView_hook_padding, -1);
    if (bool) {
      this.p0.setHookPadding(f1);
    }
    int j = x0.TPDownCountProgressImageView_inner_arc;
    if (paramAttributeSet.hasValue(j)) {
      this.p0.setInnerArc(paramAttributeSet.getBoolean(j, false));
    }
    j = paramAttributeSet.getResourceId(x0.TPDownCountProgressImageView_android_textAppearance, -1);
    if (j != -1) {
      this.p1.setTextAppearance(paramContext, j);
    }
    j = paramAttributeSet.getInt(x0.TPDownCountProgressImageView_cpi_max_down_count, 120);
    this.c = j;
    this.d = j;
    paramAttributeSet.recycle();
  }
  
  private void d()
  {
    c localc = this.z;
    if ((localc != null) && (!localc.isDisposed())) {
      this.z.dispose();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    c localc = this.z;
    if ((localc != null) && (!localc.isDisposed())) {
      this.z.dispose();
    }
  }
  
  public void setEnable(boolean paramBoolean)
  {
    this.f = paramBoolean;
    setClickable(paramBoolean);
    TPCircleProgressImageView localTPCircleProgressImageView = this.p0;
    if (localTPCircleProgressImageView != null) {
      localTPCircleProgressImageView.setDisableView(paramBoolean ^ true);
    }
    if (!paramBoolean)
    {
      localTPCircleProgressImageView = this.p0;
      if (localTPCircleProgressImageView != null) {
        localTPCircleProgressImageView.o();
      }
      d();
      this.p1.setText("");
      this.d = this.c;
    }
  }
  
  public void setMaxProgressNumber(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setNormalProgressNumber(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setOnProgressCompleteListener(a parama)
  {
    this.p3 = parama;
  }
  
  public static abstract interface a
  {
    public abstract void a(View paramView, boolean paramBoolean);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\tpcountview\TPDownCountProgressImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */