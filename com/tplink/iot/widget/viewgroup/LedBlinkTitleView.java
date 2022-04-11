package com.tplink.iot.widget.viewgroup;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.StringRes;
import com.tplink.iot.b;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class LedBlinkTitleView
  extends FrameLayout
{
  private final TextView c;
  private final View d;
  private final View f;
  private int p0;
  private ObjectAnimator p1;
  private ObjectAnimator p2;
  private boolean p3;
  private final FrameLayout q;
  private String x;
  @ColorInt
  private int y;
  @ColorInt
  private Integer z;
  
  public LedBlinkTitleView(Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  public LedBlinkTitleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  public LedBlinkTitleView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    View localView1 = LayoutInflater.from(paramContext).inflate(2131559427, this, true);
    View localView2 = localView1.findViewById(2131364667);
    j.d(localView2, "findViewById(R.id.tv_text)");
    this.c = ((TextView)localView2);
    localView2 = localView1.findViewById(2131364801);
    j.d(localView2, "findViewById(R.id.view_led_bg)");
    this.d = localView2;
    localView2 = localView1.findViewById(2131364803);
    j.d(localView2, "findViewById(R.id.view_led_color)");
    this.f = localView2;
    localView1 = localView1.findViewById(2131362670);
    j.d(localView1, "findViewById(R.id.fl_led_second)");
    this.q = ((FrameLayout)localView1);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, b.LedBlinkTitleView);
    j.d(paramAttributeSet, "context.obtainStyledAttr…leable.LedBlinkTitleView)");
    this.x = paramAttributeSet.getString(3);
    this.y = paramAttributeSet.getColor(2, paramContext.getResources().getColor(2131099957));
    if (paramAttributeSet.hasValue(0)) {
      this.z = Integer.valueOf(paramAttributeSet.getColor(0, paramContext.getResources().getColor(2131099958)));
    }
    this.p0 = paramAttributeSet.getInteger(1, 1000);
    paramAttributeSet.recycle();
    setTitleText(this.x);
    f();
  }
  
  private final ShapeDrawable a(@ColorInt int paramInt)
  {
    ShapeDrawable localShapeDrawable = new ShapeDrawable(new OvalShape());
    Paint localPaint = localShapeDrawable.getPaint();
    j.d(localPaint, "this.paint");
    localPaint.setColor(paramInt);
    return localShapeDrawable;
  }
  
  private final void b(View paramView, int paramInt)
  {
    if (this.p2 == null)
    {
      paramView = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 0.0F, 1.0F });
      paramView.setRepeatCount(-1);
      paramView.setRepeatMode(2);
      j.d(paramView, "this");
      paramView.setDuration(paramInt / 2);
      paramView.start();
      p localp = p.a;
      this.p2 = paramView;
    }
  }
  
  private final void d()
  {
    if (!this.p3)
    {
      this.p3 = true;
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.f, "alpha", new float[] { 0.0F, 1.0F });
      localObjectAnimator.setRepeatCount(-1);
      localObjectAnimator.setRepeatMode(2);
      localObjectAnimator.setDuration(this.p0 / 2);
      p localp = p.a;
      this.p1 = localObjectAnimator;
    }
  }
  
  private final void f()
  {
    Integer localInteger = this.z;
    if (localInteger == null)
    {
      setStaticLedColor(this.y);
    }
    else
    {
      setDynamicLedColor(localInteger.intValue());
      d();
    }
  }
  
  public final void c(@ColorInt Integer paramInteger1, @ColorInt Integer paramInteger2, int paramInt)
  {
    this.q.setVisibility(0);
    View localView1 = this.q.findViewById(2131364802);
    View localView2 = this.q.findViewById(2131364804);
    if ((paramInteger2 == null) && (paramInteger1 != null))
    {
      j.d(localView2, "dynamicLedView");
      localView2.setVisibility(8);
      j.d(localView1, "staticLedView");
      localView1.setBackground(a(paramInteger1.intValue()));
    }
    else if (paramInteger2 != null)
    {
      j.d(localView2, "dynamicLedView");
      localView2.setVisibility(0);
      j.d(localView1, "staticLedView");
      paramInteger1 = getContext();
      j.d(paramInteger1, "context");
      localView1.setBackground(a(paramInteger1.getResources().getColor(2131099957)));
      localView2.setBackground(a(paramInteger2.intValue()));
      b(localView2, paramInt);
    }
  }
  
  public final void e()
  {
    ObjectAnimator localObjectAnimator = this.p1;
    if ((localObjectAnimator != null) && (!localObjectAnimator.isRunning()))
    {
      localObjectAnimator = this.p1;
      if (localObjectAnimator != null) {
        localObjectAnimator.start();
      }
    }
  }
  
  public final void g()
  {
    ObjectAnimator localObjectAnimator = this.p1;
    if ((localObjectAnimator != null) && (localObjectAnimator.isRunning() == true))
    {
      localObjectAnimator = this.p1;
      if (localObjectAnimator != null) {
        localObjectAnimator.cancel();
      }
    }
    localObjectAnimator = this.p2;
    if ((localObjectAnimator != null) && (localObjectAnimator.isRunning() == true))
    {
      localObjectAnimator = this.p2;
      if (localObjectAnimator != null) {
        localObjectAnimator.cancel();
      }
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    e();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    g();
  }
  
  public final void setAnimDuration(int paramInt)
  {
    this.p0 = paramInt;
    ObjectAnimator localObjectAnimator = this.p1;
    if (localObjectAnimator != null) {
      localObjectAnimator.setDuration(paramInt / 2);
    }
  }
  
  public final void setDynamicLedColor(@ColorInt int paramInt)
  {
    this.z = Integer.valueOf(paramInt);
    this.f.setVisibility(0);
    View localView = this.d;
    Context localContext = getContext();
    j.d(localContext, "context");
    localView.setBackground(a(localContext.getResources().getColor(2131099957)));
    this.f.setBackground(a(paramInt));
  }
  
  public final void setStaticLedColor(@ColorInt int paramInt)
  {
    this.y = paramInt;
    this.f.setVisibility(8);
    this.d.setBackground(a(paramInt));
  }
  
  public final void setTitleText(@StringRes int paramInt)
  {
    this.c.setText(paramInt);
    Object localObject = this.c.getText();
    if (localObject != null) {
      localObject = localObject.toString();
    } else {
      localObject = null;
    }
    this.x = ((String)localObject);
  }
  
  public final void setTitleText(String paramString)
  {
    this.x = paramString;
    TextView localTextView = this.c;
    int i;
    if ((paramString != null) && (paramString.length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      paramString = "";
    }
    localTextView.setText(paramString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\viewgroup\LedBlinkTitleView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */