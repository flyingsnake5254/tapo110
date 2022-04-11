package com.tplink.libtpcontrols.mapmarks;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tplink.libtpcontrols.r0;
import com.tplink.libtpcontrols.s0;
import com.tplink.libtpcontrols.t0;

public class GoogleMapTargetMarker
  extends RelativeLayout
{
  private boolean H3 = false;
  private int I3 = 1000;
  private int J3 = 10;
  private Context c;
  private CustomCircleView d;
  private View f;
  private int p0 = 0;
  private int p1 = 0;
  private float p2 = 0.0F;
  private float p3 = 0.0F;
  private View q;
  private EditText x;
  private float y = 0.0F;
  private float z = 0.0F;
  
  public GoogleMapTargetMarker(@NonNull Context paramContext)
  {
    super(paramContext);
    this.c = paramContext;
  }
  
  public GoogleMapTargetMarker(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.c = paramContext;
    b(paramContext);
  }
  
  public GoogleMapTargetMarker(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, @AttrRes int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.c = paramContext;
    b(paramContext);
  }
  
  private void a(View paramView, Context paramContext)
  {
    ((InputMethodManager)paramContext.getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
  }
  
  private void b(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(t0.layout_map_target_marker, this, true);
    this.d = ((CustomCircleView)findViewById(s0.home_yard));
    this.f = findViewById(s0.decrease_yard);
    this.q = findViewById(s0.increase_yard);
    this.x = ((EditText)findViewById(s0.edit_yard));
    this.f.setOnClickListener(new b(this));
    this.q.setOnClickListener(new d(this));
    this.x.setOnClickListener(new c(this));
    this.x.setOnEditorActionListener(new a(this));
  }
  
  private void k()
  {
    float f1 = this.p2;
    if (f1 > 0.0F)
    {
      float f2 = this.y;
      if (f2 > 0.0F)
      {
        float f3 = this.z;
        if (f3 > 0.0F)
        {
          float f4;
          if (f2 > f3)
          {
            f4 = this.p1;
          }
          else
          {
            f4 = this.p0;
            f3 = f2;
          }
          f3 = f1 * f4 / f3;
          CustomCircleView localCustomCircleView = this.d;
          if (localCustomCircleView != null) {
            localCustomCircleView.setCircleRadius(f3 / 2.0F);
          }
        }
      }
    }
  }
  
  private void l(View paramView, Context paramContext)
  {
    ((InputMethodManager)paramContext.getSystemService("input_method")).showSoftInput(paramView, 2);
  }
  
  private void setEditYardMode(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.x.setBackgroundResource(r0.shape_round_circle_button);
      this.x.setFocusable(true);
      this.x.setFocusableInTouchMode(true);
      this.x.requestFocus();
      l(this.x, this.c);
    }
    else
    {
      this.x.setBackgroundResource(r0.shape_full_dark_button);
      this.x.setFocusable(false);
      this.x.setFocusableInTouchMode(false);
      a(this.x, this.c);
    }
  }
  
  private void setYard(float paramFloat)
  {
    this.p3 = this.p2;
    int i = this.J3;
    float f1 = paramFloat;
    if (paramFloat < i) {
      f1 = i;
    }
    i = this.I3;
    paramFloat = f1;
    if (f1 > i) {
      paramFloat = i;
    }
    this.x.setText(String.valueOf((int)paramFloat));
    this.p2 = paramFloat;
    if (this.p3 != paramFloat) {
      k();
    }
  }
  
  public float getRangeYard()
  {
    return this.p2;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (!this.H3)
    {
      this.H3 = true;
      k();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    setMeasuredDimension(paramInt1, paramInt2);
    this.p0 = paramInt1;
    this.p1 = paramInt2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\mapmarks\GoogleMapTargetMarker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */