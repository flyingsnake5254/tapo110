package com.tplink.iot.widget.viewgroup;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tplink.iot.b;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class StepNumberView
  extends FrameLayout
{
  private final TextView c;
  private int d = 1;
  
  public StepNumberView(Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  public StepNumberView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  public StepNumberView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    View localView = LayoutInflater.from(paramContext).inflate(2131559231, this, true).findViewById(2131364560);
    j.d(localView, "layout.findViewById(R.id.tv_number)");
    this.c = ((TextView)localView);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, b.StepNumberView);
    j.d(paramContext, "context.obtainStyledAttr…styleable.StepNumberView)");
    this.d = paramContext.getInteger(0, this.d);
    paramContext.recycle();
    setNumber(this.d);
  }
  
  public final int getNumber()
  {
    return this.d;
  }
  
  public final void setNumber(int paramInt)
  {
    TextView localTextView = this.c;
    this.d = paramInt;
    p localp = p.a;
    localTextView.setText(String.valueOf(paramInt));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\viewgroup\StepNumberView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */