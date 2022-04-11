package com.tplink.iot.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class ErrorBar
  extends FrameLayout
{
  private TextView c;
  private ImageView d;
  private Animation f;
  private boolean q = false;
  private b x = b.d;
  
  public ErrorBar(Context paramContext)
  {
    super(paramContext);
    g(paramContext);
  }
  
  public ErrorBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    g(paramContext);
  }
  
  private void e()
  {
    this.x = b.d;
    if (this.f == null)
    {
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, -1.0F);
      this.f = localTranslateAnimation;
      localTranslateAnimation.setFillAfter(false);
      this.f.setDuration(300L);
    }
    startAnimation(this.f);
    setVisibility(8);
  }
  
  private void f()
  {
    this.x = b.d;
    if (this.f == null)
    {
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.0F);
      this.f = localTranslateAnimation;
      localTranslateAnimation.setFillAfter(false);
      this.f.setDuration(300L);
    }
    startAnimation(this.f);
    setVisibility(8);
  }
  
  private void g(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131559454, this, true);
    this.c = ((TextView)paramContext.findViewById(2131362548));
    paramContext = (ImageView)paramContext.findViewById(2131362547);
    this.d = paramContext;
    paramContext.setOnClickListener(new a());
  }
  
  public void d()
  {
    if (!b.d.equals(this.x)) {
      e();
    }
  }
  
  class a
    implements View.OnClickListener
  {
    a() {}
    
    public void onClick(View paramView)
    {
      if (ErrorBar.a(ErrorBar.this)) {
        ErrorBar.b(ErrorBar.this);
      } else {
        ErrorBar.c(ErrorBar.this);
      }
    }
  }
  
  private static enum b
  {
    static
    {
      b localb1 = new b("SHOWN", 0);
      c = localb1;
      b localb2 = new b("HIDDEN", 1);
      d = localb2;
      f = new b[] { localb1, localb2 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\ErrorBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */