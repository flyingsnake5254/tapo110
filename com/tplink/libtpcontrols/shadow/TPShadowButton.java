package com.tplink.libtpcontrols.shadow;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;
import com.tplink.libtpcontrols.p0;
import com.tplink.libtpcontrols.s0;
import com.tplink.libtpcontrols.t0;
import com.tplink.libtpcontrols.x0;

public class TPShadowButton
  extends FrameLayout
{
  private int H3 = 15;
  private int I3 = -1;
  private View J3;
  private boolean K3 = false;
  private final float c = getResources().getDisplayMetrics().density * 6.0F;
  private final float d = getResources().getDisplayMetrics().density * 18.0F;
  private final int f = (int)(getResources().getDisplayMetrics().density * 18.0F);
  private float p0;
  private float p1;
  private View p2;
  private String p3;
  private AppCompatButton q;
  private TPShadowLayout x;
  private int y = -1;
  private int z = -1;
  
  public TPShadowButton(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public TPShadowButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TPShadowButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    Object localObject = LayoutInflater.from(paramContext).inflate(t0.shadow_button_main, this, true);
    this.p2 = ((View)localObject);
    this.q = ((AppCompatButton)((View)localObject).findViewById(s0.sb_button));
    this.x = ((TPShadowLayout)this.p2.findViewById(s0.sb_shadow));
    this.J3 = this.p2.findViewById(s0.button_background_cover);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, x0.TPShadowButton);
    localObject = paramAttributeSet.getDrawable(x0.TPShadowButton_sb_background);
    this.q.setBackground((Drawable)localObject);
    this.p0 = paramAttributeSet.getDimension(x0.TPShadowButton_sb_shadow_radius, this.c);
    this.p1 = paramAttributeSet.getDimension(x0.TPShadowButton_sb_shadow_corner_radius, this.d);
    this.y = paramAttributeSet.getColor(x0.TPShadowButton_sb_shadow_color_normal, ContextCompat.getColor(paramContext, p0.common_tplink_teal));
    this.z = paramAttributeSet.getColor(x0.TPShadowButton_sb_shadow_color_pressed, ContextCompat.getColor(paramContext, p0.common_tplink_teal_pressed));
    localObject = paramAttributeSet.getString(x0.TPShadowButton_android_text);
    this.p3 = ((String)localObject);
    this.q.setText((CharSequence)localObject);
    int i = paramAttributeSet.getDimensionPixelSize(x0.TPShadowButton_android_textSize, this.f);
    this.H3 = i;
    this.q.setTextSize(0, i);
    i = paramAttributeSet.getColor(x0.TPShadowButton_android_textColor, ContextCompat.getColor(paramContext, p0.white));
    this.I3 = i;
    this.q.setTextColor(i);
    post(new a(this));
    this.q.setEnabled(isEnabled());
    paramAttributeSet.recycle();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if ((i == 1) || (i == 3))
      {
        this.K3 = true;
        this.x.setShadowColor(this.y);
        performClick();
      }
    }
    else
    {
      this.K3 = false;
      postDelayed(new b(this), 200L);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    this.q.setEnabled(paramBoolean);
  }
  
  public void setText(int paramInt)
  {
    this.q.setText(paramInt);
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    this.q.setText(paramCharSequence);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\shadow\TPShadowButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */