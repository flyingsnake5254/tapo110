package com.tplink.iot.view.ipcamera.widget.tipsbar;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.text.method.MovementMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableBoolean;
import com.tplink.iot.databinding.WidgetTipsBarBinding;

public class TipsBar
  extends FrameLayout
{
  private View.OnClickListener H3;
  private a I3 = a.d;
  private View c;
  private TextView d;
  private ImageView f;
  private boolean p0 = false;
  private boolean p1 = false;
  private final ObservableBoolean p2 = new ObservableBoolean(false);
  private int p3 = 2131231136;
  private Animation q;
  private Animation x;
  private boolean y = false;
  private int z;
  
  public TipsBar(Context paramContext)
  {
    super(paramContext);
    e(paramContext, null);
  }
  
  public TipsBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    e(paramContext, paramAttributeSet);
  }
  
  private void c()
  {
    this.I3 = a.d;
    if (this.x == null)
    {
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, -1.0F);
      this.x = localTranslateAnimation;
      localTranslateAnimation.setFillAfter(false);
      this.x.setDuration(300L);
    }
    startAnimation(this.x);
    setVisibility(8);
  }
  
  private void d()
  {
    this.I3 = a.d;
    if (this.x == null)
    {
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.0F);
      this.x = localTranslateAnimation;
      localTranslateAnimation.setFillAfter(false);
      this.x.setDuration(300L);
    }
    startAnimation(this.x);
    setVisibility(8);
  }
  
  private void e(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet != null)
    {
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, com.tplink.iot.b.TipsBar);
      this.z = paramAttributeSet.getColor(0, ContextCompat.getColor(paramContext, 2131099827));
      this.p1 = paramAttributeSet.getBoolean(1, false);
      paramAttributeSet.recycle();
    }
    else
    {
      this.z = ContextCompat.getColor(paramContext, 2131099827);
    }
    paramContext = (WidgetTipsBarBinding)DataBindingUtil.inflate(LayoutInflater.from(paramContext), 2131559457, this, true);
    if (paramContext != null)
    {
      paramContext.h(this.p2);
      paramAttributeSet = paramContext.f;
      this.c = paramAttributeSet;
      paramAttributeSet.setBackground(new ColorDrawable(this.z));
      this.d = paramContext.d;
      paramContext = paramContext.c;
      this.f = paramContext;
      paramContext.setOnClickListener(new b(this));
    }
  }
  
  private void q()
  {
    this.y = false;
    this.I3 = a.c;
    if (this.q == null)
    {
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, -1.0F, 1, 0.0F);
      this.q = localTranslateAnimation;
      localTranslateAnimation.setDuration(300L);
    }
    startAnimation(this.q);
    setVisibility(0);
  }
  
  public void a(boolean paramBoolean)
  {
    this.p2.set(paramBoolean);
  }
  
  public void b()
  {
    if (!a.d.equals(this.I3)) {
      c();
    }
  }
  
  public int getCloseBtnImageResId()
  {
    return this.p3;
  }
  
  public void l()
  {
    this.p0 = false;
  }
  
  public void m(CharSequence paramCharSequence, long paramLong)
  {
    o(paramCharSequence, false, paramLong);
  }
  
  public void n(CharSequence paramCharSequence, MovementMethod paramMovementMethod)
  {
    p(paramCharSequence, true, 0L, paramMovementMethod);
  }
  
  public void o(CharSequence paramCharSequence, boolean paramBoolean, long paramLong)
  {
    if (this.p0) {
      return;
    }
    this.d.setText(paramCharSequence);
    paramCharSequence = this.f;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    paramCharSequence.setVisibility(i);
    if (!a.c.equals(this.I3)) {
      q();
    }
    if ((!paramBoolean) && (paramLong > 0L))
    {
      paramCharSequence = this.c;
      if (paramCharSequence != null) {
        paramCharSequence.postDelayed(new a(this), paramLong);
      }
    }
  }
  
  public void p(CharSequence paramCharSequence, boolean paramBoolean, long paramLong, MovementMethod paramMovementMethod)
  {
    if (this.p0) {
      return;
    }
    a locala = a.c;
    if (locala.equals(this.I3)) {
      return;
    }
    this.d.setText(paramCharSequence);
    this.d.setClickable(true);
    this.d.setMovementMethod(paramMovementMethod);
    paramCharSequence = this.f;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    paramCharSequence.setVisibility(i);
    if (!locala.equals(this.I3)) {
      q();
    }
    if ((!paramBoolean) && (paramLong > 0L))
    {
      paramCharSequence = this.c;
      if (paramCharSequence != null) {
        paramCharSequence.postDelayed(new c(this), paramLong);
      }
    }
  }
  
  public void setBackground(@ColorRes int paramInt)
  {
    this.c.setBackgroundColor(getResources().getColor(paramInt));
  }
  
  public void setCloseBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.H3 = paramOnClickListener;
  }
  
  public void setCloseBtnImageResId(@DrawableRes int paramInt)
  {
    if (this.p3 == paramInt) {
      return;
    }
    this.p3 = paramInt;
    this.f.setImageResource(paramInt);
  }
  
  private static enum a
  {
    static
    {
      a locala1 = new a("SHOWN", 0);
      c = locala1;
      a locala2 = new a("HIDDEN", 1);
      d = locala2;
      f = new a[] { locala1, locala2 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\widget\tipsbar\TipsBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */