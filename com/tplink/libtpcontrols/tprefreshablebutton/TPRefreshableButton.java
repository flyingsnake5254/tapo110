package com.tplink.libtpcontrols.tprefreshablebutton;

import android.animation.AnimatorInflater;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.tplink.libtpcontrols.p0;
import com.tplink.libtpcontrols.s0;
import com.tplink.libtpcontrols.t0;
import com.tplink.libtpcontrols.tppulltorefresh.TPCircleProgressBar;
import com.tplink.libtpcontrols.x0;

public class TPRefreshableButton
  extends FrameLayout
{
  private int H3 = 0;
  private int I3 = 0;
  private LayoutInflater c = null;
  private Context d = null;
  private Button f = null;
  private int p0 = 15;
  private int p1 = -1;
  private int p2 = 8388659;
  private Drawable p3 = null;
  private TPCircleProgressBar q = null;
  private View.OnClickListener x = null;
  private CharSequence y = "";
  private final int z = (int)(getResources().getDisplayMetrics().density * 18.0F);
  
  public TPRefreshableButton(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TPRefreshableButton(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public TPRefreshableButton(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this.d = paramContext;
    Object localObject = LayoutInflater.from(paramContext);
    this.c = ((LayoutInflater)localObject);
    ((LayoutInflater)localObject).inflate(t0.refreshable_button, this);
    this.f = ((Button)findViewById(s0.refreshablebutton_Button));
    localObject = (TPCircleProgressBar)findViewById(s0.refreshablebutton_TPCircleProgressBar);
    this.q = ((TPCircleProgressBar)localObject);
    ((View)localObject).setVisibility(8);
    localObject = this.q;
    Context localContext = this.d;
    int i = p0.white;
    ((TPCircleProgressBar)localObject).setProgressBarColor(ContextCompat.getColor(localContext, i));
    this.f.setOnClickListener(new a(this));
    setClickable(false);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, x0.TPRefreshableButton);
    localObject = paramAttributeSet.getString(x0.TPRefreshableButton_android_text);
    this.y = ((CharSequence)localObject);
    this.f.setText((CharSequence)localObject);
    int j = paramAttributeSet.getDimensionPixelSize(x0.TPRefreshableButton_android_textSize, this.z);
    this.p0 = j;
    this.f.setTextSize(0, j);
    j = paramAttributeSet.getColor(x0.TPRefreshableButton_android_textColor, ContextCompat.getColor(paramContext, i));
    this.p1 = j;
    this.f.setTextColor(j);
    j = paramAttributeSet.getInt(x0.TPRefreshableButton_android_gravity, this.p2);
    this.p2 = j;
    this.f.setGravity(j);
    this.p3 = paramAttributeSet.getDrawable(x0.TPRefreshableButton_button_background);
    if (Build.VERSION.SDK_INT >= 21)
    {
      j = paramAttributeSet.getResourceId(x0.TPRefreshableButton_android_stateListAnimator, 0);
      if (j == 0) {
        this.f.setStateListAnimator(new StateListAnimator());
      } else {
        this.f.setStateListAnimator(AnimatorInflater.loadStateListAnimator(paramContext, j));
      }
    }
    paramContext = this.p3;
    if (paramContext != null) {
      this.f.setBackground(paramContext);
    }
    j = x0.TPRefreshableButton_android_textAllCaps;
    if (paramAttributeSet.hasValue(j))
    {
      boolean bool = paramAttributeSet.getBoolean(j, false);
      this.f.setAllCaps(bool);
    }
    this.H3 = paramAttributeSet.getLayoutDimension(x0.TPRefreshableButton_button_width, -2);
    this.I3 = paramAttributeSet.getLayoutDimension(x0.TPRefreshableButton_button_height, -2);
    paramAttributeSet.recycle();
    post(new b(this));
  }
  
  public boolean b()
  {
    return this.q.e();
  }
  
  public void g()
  {
    this.f.setText("");
    this.f.setClickable(false);
    this.q.setVisibility(0);
    this.q.h();
    setClickable(false);
  }
  
  public Button getButton()
  {
    return this.f;
  }
  
  public void h()
  {
    this.q.setVisibility(8);
    this.q.i();
    this.f.setText(this.y);
    this.f.setClickable(true);
    setClickable(true);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    this.f.setEnabled(paramBoolean);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.x = paramOnClickListener;
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    this.y = paramCharSequence;
    this.f.setText(paramCharSequence);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\tprefreshablebutton\TPRefreshableButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */