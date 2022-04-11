package com.tplink.libtpcontrols.colorpicker;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.tplink.libtpcontrols.s0;
import com.tplink.libtpcontrols.t0;
import com.tplink.libtpcontrols.x0;
import com.tplink.libtpcontrols.z0.e;

public class TPArcColorLayout
  extends LinearLayout
{
  private TPArcColorView c;
  private ImageView d;
  int f;
  private b p0 = null;
  private e p1;
  int q;
  int x;
  int y;
  private a z = null;
  
  public TPArcColorLayout(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }
  
  public TPArcColorLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public TPArcColorLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet == null)
    {
      this.f = ContextCompat.getColor(paramContext, 17170456);
      this.q = ContextCompat.getColor(paramContext, 17170443);
      this.x = ContextCompat.getColor(paramContext, 17170450);
      this.y = ContextCompat.getColor(paramContext, 17170445);
    }
    else
    {
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, x0.TPArcColorLayout);
      this.f = paramAttributeSet.getColor(x0.TPArcColorLayout_tpc_start_color, ContextCompat.getColor(paramContext, 17170456));
      this.q = paramAttributeSet.getColor(x0.TPArcColorLayout_tpc_middle_color, ContextCompat.getColor(paramContext, 17170443));
      this.x = paramAttributeSet.getColor(x0.TPArcColorLayout_tpc_end_color, ContextCompat.getColor(paramContext, 17170450));
      this.y = paramAttributeSet.getColor(x0.TPArcColorLayout_tpc_default_color, ContextCompat.getColor(paramContext, 17170445));
      paramAttributeSet.recycle();
    }
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(t0.layout_automation_common_arc_color_picker, this);
    this.d = ((ImageView)findViewById(s0.img_center));
    paramContext = (TPArcColorView)findViewById(s0.arc_view);
    this.c = paramContext;
    paramContext.setStartColor(this.f);
    this.c.setMiddleColor(this.q);
    this.c.setEndColor(this.x);
    this.c.setDefaultColor(this.y);
    this.d.setColorFilter(this.q, PorterDuff.Mode.SRC_ATOP);
    this.c.setOnColorChangedListener(new a(this));
    this.c.setOnProgressListener(new c(this));
    this.c.setOnTouchListener(new d(this));
  }
  
  public float getProgress()
  {
    TPArcColorView localTPArcColorView = this.c;
    if (localTPArcColorView != null) {
      return localTPArcColorView.getProgress();
    }
    return 0.0F;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1) {
      requestDisallowInterceptTouchEvent(false);
    } else {
      requestDisallowInterceptTouchEvent(true);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setOnColorChangedListener(a parama)
  {
    this.z = parama;
  }
  
  public void setOnProgressListener(b paramb)
  {
    this.p0 = paramb;
  }
  
  public void setOnTouchCancelListener(e parame)
  {
    this.p1 = parame;
  }
  
  public void setProgress(float paramFloat)
  {
    TPArcColorView localTPArcColorView = this.c;
    if (localTPArcColorView != null) {
      localTPArcColorView.postDelayed(new b(this, paramFloat), 300L);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt, boolean paramBoolean);
  }
  
  public static abstract interface b
  {
    public abstract void a(float paramFloat, boolean paramBoolean);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\colorpicker\TPArcColorLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */