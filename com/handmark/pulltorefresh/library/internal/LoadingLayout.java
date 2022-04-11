package com.handmark.pulltorefresh.library.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Orientation;
import com.handmark.pulltorefresh.library.d;
import com.handmark.pulltorefresh.library.extras.TPPullToRefreshWheel;
import com.tplink.libtpcontrols.s0;
import com.tplink.libtpcontrols.t0;
import com.tplink.libtpcontrols.v0;
import com.tplink.libtpcontrols.x0;

@SuppressLint({"ViewConstructor"})
public abstract class LoadingLayout
  extends FrameLayout
  implements d
{
  static final Interpolator c = new LinearInterpolator();
  private CharSequence H3;
  private CharSequence I3;
  private FrameLayout d;
  protected final ImageView f;
  private final TextView p0;
  protected final PullToRefreshBase.Mode p1;
  protected final PullToRefreshBase.Orientation p2;
  private CharSequence p3;
  protected final ProgressBar q;
  private TPPullToRefreshWheel x;
  private boolean y;
  private final TextView z;
  
  public LoadingLayout(Context paramContext, PullToRefreshBase.Mode paramMode, PullToRefreshBase.Orientation paramOrientation, TypedArray paramTypedArray)
  {
    super(paramContext);
    this.p1 = paramMode;
    this.p2 = paramOrientation;
    if (a.a[paramOrientation.ordinal()] != 1) {
      LayoutInflater.from(paramContext).inflate(t0.pull_to_refresh_header_vertical, this);
    } else {
      LayoutInflater.from(paramContext).inflate(t0.pull_to_refresh_header_horizontal, this);
    }
    Object localObject = (FrameLayout)findViewById(s0.fl_inner);
    this.d = ((FrameLayout)localObject);
    this.z = ((TextView)((FrameLayout)localObject).findViewById(s0.pull_to_refresh_text));
    this.q = ((ProgressBar)this.d.findViewById(s0.pull_to_refresh_progress));
    this.p0 = ((TextView)this.d.findViewById(s0.pull_to_refresh_sub_text));
    this.f = ((ImageView)this.d.findViewById(s0.pull_to_refresh_image));
    this.x = ((TPPullToRefreshWheel)this.d.findViewById(s0.pull_to_refresh_wheel));
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.d.getLayoutParams();
    localObject = a.b;
    if (localObject[paramMode.ordinal()] != 1)
    {
      if (paramOrientation == PullToRefreshBase.Orientation.VERTICAL) {
        i = 80;
      } else {
        i = 5;
      }
      localLayoutParams.gravity = i;
      this.p3 = paramContext.getString(v0.pull_to_refresh_pull_label);
      this.H3 = paramContext.getString(v0.pull_to_refresh_refreshing_label);
      this.I3 = paramContext.getString(v0.pull_to_refresh_release_label);
    }
    else
    {
      if (paramOrientation == PullToRefreshBase.Orientation.VERTICAL) {
        i = 48;
      } else {
        i = 3;
      }
      localLayoutParams.gravity = i;
      this.p3 = paramContext.getString(v0.pull_to_refresh_from_bottom_pull_label);
      this.H3 = paramContext.getString(v0.pull_to_refresh_from_bottom_refreshing_label);
      this.I3 = paramContext.getString(v0.pull_to_refresh_from_bottom_release_label);
    }
    int i = x0.PullToRefresh_ptrHeaderBackground;
    if (paramTypedArray.hasValue(i))
    {
      paramOrientation = paramTypedArray.getDrawable(i);
      if (paramOrientation != null) {
        c.b(this, paramOrientation);
      }
    }
    i = x0.PullToRefresh_ptrHeaderTextAppearance;
    if (paramTypedArray.hasValue(i))
    {
      paramOrientation = new TypedValue();
      paramTypedArray.getValue(i, paramOrientation);
      setTextAppearance(paramOrientation.data);
    }
    i = x0.PullToRefresh_ptrSubHeaderTextAppearance;
    if (paramTypedArray.hasValue(i))
    {
      paramOrientation = new TypedValue();
      paramTypedArray.getValue(i, paramOrientation);
      setSubTextAppearance(paramOrientation.data);
    }
    i = x0.PullToRefresh_ptrHeaderTextColor;
    if (paramTypedArray.hasValue(i))
    {
      paramOrientation = paramTypedArray.getColorStateList(i);
      if (paramOrientation != null) {
        setTextColor(paramOrientation);
      }
    }
    i = x0.PullToRefresh_ptrHeaderSubTextColor;
    if (paramTypedArray.hasValue(i))
    {
      paramOrientation = paramTypedArray.getColorStateList(i);
      if (paramOrientation != null) {
        setSubTextColor(paramOrientation);
      }
    }
    paramOrientation = null;
    i = x0.PullToRefresh_ptrDrawable;
    if (paramTypedArray.hasValue(i)) {
      paramOrientation = paramTypedArray.getDrawable(i);
    }
    if (localObject[paramMode.ordinal()] != 1)
    {
      i = x0.PullToRefresh_ptrDrawableStart;
      if (paramTypedArray.hasValue(i))
      {
        paramMode = paramTypedArray.getDrawable(i);
      }
      else
      {
        i = x0.PullToRefresh_ptrDrawableTop;
        paramMode = paramOrientation;
        if (paramTypedArray.hasValue(i))
        {
          b.a("ptrDrawableTop", "ptrDrawableStart");
          paramMode = paramTypedArray.getDrawable(i);
        }
      }
    }
    else
    {
      i = x0.PullToRefresh_ptrDrawableEnd;
      if (paramTypedArray.hasValue(i))
      {
        paramMode = paramTypedArray.getDrawable(i);
      }
      else
      {
        i = x0.PullToRefresh_ptrDrawableBottom;
        paramMode = paramOrientation;
        if (paramTypedArray.hasValue(i))
        {
          b.a("ptrDrawableBottom", "ptrDrawableEnd");
          paramMode = paramTypedArray.getDrawable(i);
        }
      }
    }
    paramOrientation = paramMode;
    if (paramMode == null) {
      paramOrientation = paramContext.getResources().getDrawable(getDefaultDrawableResId());
    }
    setLoadingDrawable(paramOrientation);
    k();
  }
  
  private void setSubHeaderText(CharSequence paramCharSequence)
  {
    if (this.p0 != null) {
      if (TextUtils.isEmpty(paramCharSequence))
      {
        this.p0.setVisibility(8);
      }
      else
      {
        this.p0.setText(paramCharSequence);
        if (8 == this.p0.getVisibility()) {
          this.p0.setVisibility(0);
        }
      }
    }
  }
  
  private void setSubTextAppearance(int paramInt)
  {
    TextView localTextView = this.p0;
    if (localTextView != null) {
      localTextView.setTextAppearance(getContext(), paramInt);
    }
  }
  
  private void setSubTextColor(ColorStateList paramColorStateList)
  {
    TextView localTextView = this.p0;
    if (localTextView != null) {
      localTextView.setTextColor(paramColorStateList);
    }
  }
  
  private void setTextAppearance(int paramInt)
  {
    TextView localTextView = this.z;
    if (localTextView != null) {
      localTextView.setTextAppearance(getContext(), paramInt);
    }
    localTextView = this.p0;
    if (localTextView != null) {
      localTextView.setTextAppearance(getContext(), paramInt);
    }
  }
  
  private void setTextColor(ColorStateList paramColorStateList)
  {
    TextView localTextView = this.z;
    if (localTextView != null) {
      localTextView.setTextColor(paramColorStateList);
    }
    localTextView = this.p0;
    if (localTextView != null) {
      localTextView.setTextColor(paramColorStateList);
    }
  }
  
  public final void a()
  {
    if (this.z.getVisibility() == 0) {
      this.z.setVisibility(4);
    }
    if (this.q.getVisibility() == 0) {
      this.q.setVisibility(4);
    }
    if (this.f.getVisibility() == 0) {
      this.f.setVisibility(4);
    }
    if (this.p0.getVisibility() == 0) {
      this.p0.setVisibility(4);
    }
  }
  
  protected abstract void b(Drawable paramDrawable);
  
  public final void c(float paramFloat)
  {
    if (!this.y) {
      d(paramFloat);
    }
    float f1 = (paramFloat - 0.6F) / 0.39999998F;
    TPPullToRefreshWheel localTPPullToRefreshWheel = this.x;
    if (localTPPullToRefreshWheel != null) {
      if (paramFloat < 0.6F) {
        localTPPullToRefreshWheel.setInstantProgress(0.0F);
      } else if (paramFloat > 1.0F) {
        localTPPullToRefreshWheel.setInstantProgress(1.0F);
      } else {
        localTPPullToRefreshWheel.setInstantProgress(f1);
      }
    }
  }
  
  protected abstract void d(float paramFloat);
  
  public final void e()
  {
    TextView localTextView = this.z;
    if (localTextView != null) {
      localTextView.setText(this.p3);
    }
    f();
  }
  
  protected abstract void f();
  
  public final void g()
  {
    Object localObject = this.z;
    if (localObject != null) {
      ((TextView)localObject).setText(this.H3);
    }
    if (this.y) {
      ((AnimationDrawable)this.f.getDrawable()).start();
    } else {
      h();
    }
    localObject = this.p0;
    if (localObject != null) {
      if (TextUtils.isEmpty(((TextView)localObject).getText())) {
        this.p0.setVisibility(8);
      } else {
        this.p0.setVisibility(0);
      }
    }
    localObject = this.x;
    if (localObject != null) {
      ((TPPullToRefreshWheel)localObject).i();
    }
  }
  
  public final int getContentSize()
  {
    if (a.a[this.p2.ordinal()] != 1) {
      return this.d.getHeight();
    }
    return this.d.getWidth();
  }
  
  protected abstract int getDefaultDrawableResId();
  
  protected abstract void h();
  
  public final void i()
  {
    TextView localTextView = this.z;
    if (localTextView != null) {
      localTextView.setText(this.I3);
    }
    j();
  }
  
  protected abstract void j();
  
  public final void k()
  {
    Object localObject = this.z;
    if (localObject != null) {
      ((TextView)localObject).setText(this.p3);
    }
    this.f.setVisibility(0);
    if (this.y) {
      ((AnimationDrawable)this.f.getDrawable()).stop();
    } else {
      l();
    }
    localObject = this.p0;
    if (localObject != null) {
      if (TextUtils.isEmpty(((TextView)localObject).getText())) {
        this.p0.setVisibility(8);
      } else {
        this.p0.setVisibility(0);
      }
    }
    localObject = this.x;
    if (localObject != null) {
      ((TPPullToRefreshWheel)localObject).j();
    }
  }
  
  protected abstract void l();
  
  public final void m()
  {
    if (4 == this.z.getVisibility()) {
      this.z.setVisibility(0);
    }
    if (4 == this.q.getVisibility()) {
      this.q.setVisibility(0);
    }
    if (4 == this.f.getVisibility()) {
      this.f.setVisibility(0);
    }
    if (4 == this.p0.getVisibility()) {
      this.p0.setVisibility(0);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("loadinglayout onLayout innerLayout height = ");
    localStringBuilder.append(this.d.getHeight());
    Log.d("LoadingLayout", localStringBuilder.toString());
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("loadinglayout onMeasure innerLayout height = ");
    localStringBuilder.append(this.d.getHeight());
    Log.d("LoadingLayout", localStringBuilder.toString());
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("loadinglayout onSizeChanged innerLayout height = ");
    localStringBuilder.append(this.d.getHeight());
    Log.d("LoadingLayout", localStringBuilder.toString());
  }
  
  public final void setHeaderWheelBarColor(int paramInt)
  {
    TPPullToRefreshWheel localTPPullToRefreshWheel = this.x;
    if (localTPPullToRefreshWheel != null) {
      localTPPullToRefreshWheel.setBarColor(paramInt);
    }
  }
  
  public final void setHeight(int paramInt)
  {
    getLayoutParams().height = paramInt;
    requestLayout();
  }
  
  public void setLastUpdatedLabel(CharSequence paramCharSequence)
  {
    setSubHeaderText(paramCharSequence);
  }
  
  public final void setLoadingDrawable(Drawable paramDrawable)
  {
    this.f.setImageDrawable(paramDrawable);
    this.y = (paramDrawable instanceof AnimationDrawable);
    b(paramDrawable);
  }
  
  public void setPullLabel(CharSequence paramCharSequence)
  {
    this.p3 = paramCharSequence;
  }
  
  public void setRefreshingLabel(CharSequence paramCharSequence)
  {
    this.H3 = paramCharSequence;
  }
  
  public void setReleaseLabel(CharSequence paramCharSequence)
  {
    this.I3 = paramCharSequence;
  }
  
  public void setTextTypeface(Typeface paramTypeface)
  {
    this.z.setTypeface(paramTypeface);
  }
  
  public final void setWidth(int paramInt)
  {
    getLayoutParams().width = paramInt;
    requestLayout();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\handmark\pulltorefresh\library\internal\LoadingLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */