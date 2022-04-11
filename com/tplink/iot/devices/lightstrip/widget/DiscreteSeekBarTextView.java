package com.tplink.iot.devices.lightstrip.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import androidx.annotation.ColorInt;
import com.tplink.iot.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.e;
import kotlin.jvm.internal.j;
import kotlin.p;
import kotlin.v.d;

public final class DiscreteSeekBarTextView
  extends View
  implements SeekBar.OnSeekBarChangeListener
{
  private SeekBar.OnSeekBarChangeListener H3;
  private int c = -12303292;
  private int d = -16777216;
  private float f = d(16);
  private float p0;
  private int p1;
  private float p2;
  private a p3;
  private final List<Integer> q;
  private Float[] x;
  private List<String> y;
  private final Paint z;
  
  public DiscreteSeekBarTextView(Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  public DiscreteSeekBarTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  public DiscreteSeekBarTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Object localObject1 = kotlin.collections.l.h(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) });
    this.q = ((List)localObject1);
    int i = ((List)localObject1).size();
    localObject1 = new Float[i];
    for (paramInt = 0; paramInt < i; paramInt++) {
      localObject1[paramInt] = Float.valueOf(0.0F);
    }
    this.x = ((Float[])localObject1);
    Object localObject2 = this.q;
    localObject1 = new ArrayList(kotlin.collections.l.l((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(c(((Number)((Iterator)localObject2).next()).intValue()));
    }
    this.y = ((List)localObject1);
    localObject1 = new Paint(1);
    ((Paint)localObject1).setFakeBoldText(true);
    localObject2 = p.a;
    this.z = ((Paint)localObject1);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, b.DiscreteSeekBarTextView);
    this.c = paramContext.getColor(1, this.c);
    this.d = paramContext.getColor(0, this.d);
    this.f = paramContext.getDimension(2, this.f);
    paramContext.recycle();
    ((Paint)localObject1).setColor(this.c);
    b();
  }
  
  private final void b()
  {
    this.z.setTextSize(this.f);
    Paint.FontMetrics localFontMetrics = this.z.getFontMetrics();
    this.p0 = (-(localFontMetrics.ascent + localFontMetrics.descent) / 2.0F);
  }
  
  private final String c(int paramInt)
  {
    Object localObject = this.p3;
    if (localObject != null)
    {
      localObject = ((a)localObject).format(paramInt);
      if (localObject != null) {}
    }
    else
    {
      localObject = String.valueOf(paramInt);
    }
    return (String)localObject;
  }
  
  private final float d(int paramInt)
  {
    float f1 = paramInt;
    Object localObject = getContext();
    j.d(localObject, "context");
    localObject = ((Context)localObject).getResources();
    j.d(localObject, "context.resources");
    return TypedValue.applyDimension(2, f1, ((Resources)localObject).getDisplayMetrics());
  }
  
  public final void e(final SeekBar paramSeekBar, boolean paramBoolean)
  {
    j.e(paramSeekBar, "seekBar");
    this.q.clear();
    Object localObject = this.q;
    int i = paramSeekBar.getMax();
    int j = 0;
    kotlin.collections.l.p((Collection)localObject, new d(0, i));
    i = this.q.size();
    localObject = new Float[i];
    while (j < i)
    {
      localObject[j] = Float.valueOf(0.0F);
      j++;
    }
    this.x = ((Float[])localObject);
    paramSeekBar.setOnSeekBarChangeListener(this);
    if ((this.q.size() >= 2) && (paramBoolean))
    {
      float f1 = this.z.measureText(c(((Number)kotlin.collections.l.x(this.q)).intValue()));
      float f2 = this.z.measureText(c(((Number)kotlin.collections.l.F(this.q)).intValue()));
      setPadding((int)(paramSeekBar.getPaddingLeft() - f1 / 2.0F), getPaddingTop(), (int)(paramSeekBar.getPaddingRight() - f2 / 2.0F), getPaddingBottom());
    }
    else
    {
      setPadding(paramSeekBar.getPaddingLeft() + getPaddingLeft() - 8, getPaddingTop(), paramSeekBar.getPaddingRight() + getPaddingRight() - 8, getPaddingBottom());
    }
    invalidate();
    paramSeekBar.post(new c(this, paramSeekBar));
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    j.e(paramCanvas, "canvas");
    float f1 = (getPaddingTop() + getHeight() - getPaddingBottom()) / 2.0F;
    float f2 = getPaddingLeft();
    int i = this.q.size();
    for (int j = 0; j < i; j++)
    {
      Paint localPaint = this.z;
      int k;
      if (j == this.p1) {
        k = this.d;
      } else {
        k = this.c;
      }
      localPaint.setColor(k);
      paramCanvas.drawText((String)this.y.get(j), f2, this.p0 + f1, this.z);
      f2 += this.x[j].floatValue() + this.p2;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    Object localObject = this.q;
    ArrayList localArrayList = new ArrayList(kotlin.collections.l.l((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(c(((Number)((Iterator)localObject).next()).intValue()));
    }
    this.y = localArrayList;
    paramInt1 = 0;
    paramInt2 = this.q.size();
    while (paramInt1 < paramInt2)
    {
      this.x[paramInt1] = Float.valueOf(this.z.measureText((String)this.y.get(paramInt1)));
      paramInt1++;
    }
    this.p2 = ((getWidth() - getPaddingLeft() - getPaddingRight() - e.w(this.x)) / Math.max(this.q.size() - 1, 1));
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    Paint.FontMetrics localFontMetrics = this.z.getFontMetrics();
    float f1 = -localFontMetrics.top;
    float f2 = localFontMetrics.bottom;
    setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), View.resolveSize((int)(f1 + f2 + 16.0F) + getPaddingTop() + getPaddingBottom(), paramInt2));
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    this.p1 = paramInt;
    invalidate();
    SeekBar.OnSeekBarChangeListener localOnSeekBarChangeListener = this.H3;
    if (localOnSeekBarChangeListener != null) {
      localOnSeekBarChangeListener.onProgressChanged(paramSeekBar, paramInt, paramBoolean);
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    SeekBar.OnSeekBarChangeListener localOnSeekBarChangeListener = this.H3;
    if (localOnSeekBarChangeListener != null) {
      localOnSeekBarChangeListener.onStartTrackingTouch(paramSeekBar);
    }
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    SeekBar.OnSeekBarChangeListener localOnSeekBarChangeListener = this.H3;
    if (localOnSeekBarChangeListener != null) {
      localOnSeekBarChangeListener.onStopTrackingTouch(paramSeekBar);
    }
  }
  
  public final void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener paramOnSeekBarChangeListener)
  {
    j.e(paramOnSeekBarChangeListener, "listener");
    this.H3 = paramOnSeekBarChangeListener;
  }
  
  public final void setTextColor(@ColorInt int paramInt)
  {
    this.z.setColor(paramInt);
    invalidate();
  }
  
  public final void setTextSize(float paramFloat)
  {
    this.f = paramFloat;
    b();
    requestLayout();
  }
  
  public final void setValueFormatter(a parama)
  {
    j.e(parama, "formatter");
    this.p3 = parama;
    invalidate();
  }
  
  public final void setValueFormatter(kotlin.jvm.b.l<? super Integer, String> paraml)
  {
    j.e(paraml, "formatter");
    this.p3 = new b(paraml);
    invalidate();
  }
  
  public final void setupWithSeekBar(SeekBar paramSeekBar)
  {
    f(this, paramSeekBar, false, 2, null);
  }
  
  public static abstract interface a
  {
    public abstract String format(int paramInt);
  }
  
  public static final class b
    implements DiscreteSeekBarTextView.a
  {
    b(kotlin.jvm.b.l paraml) {}
    
    public String format(int paramInt)
    {
      return (String)this.a.invoke(Integer.valueOf(paramInt));
    }
  }
  
  static final class c
    implements Runnable
  {
    c(DiscreteSeekBarTextView paramDiscreteSeekBarTextView, SeekBar paramSeekBar) {}
    
    public final void run()
    {
      DiscreteSeekBarTextView.a(this.c, paramSeekBar.getProgress());
      this.c.invalidate();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\widget\DiscreteSeekBarTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */