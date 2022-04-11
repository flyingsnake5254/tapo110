package com.tplink.iot.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tplink.iot.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FlowTagLayout
  extends ViewGroup
{
  private int c = b(10.0F);
  private int d = b(10.0F);
  private List<b> f = new ArrayList();
  private List<TextView> q = new ArrayList();
  
  public FlowTagLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FlowTagLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FlowTagLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, b.FlowTagLayout, paramInt, 0);
    this.c = paramContext.getDimensionPixelSize(0, this.c);
    this.d = paramContext.getDimensionPixelSize(1, this.d);
    paramContext.recycle();
  }
  
  private int b(float paramFloat)
  {
    return (int)(getContext().getResources().getDisplayMetrics().density * paramFloat + 0.5D);
  }
  
  public void c(List<String> paramList, final c paramc)
  {
    removeAllViews();
    this.q.clear();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        paramList = (String)localIterator.next();
        TextView localTextView = (TextView)LayoutInflater.from(getContext()).inflate(2131559168, null);
        localTextView.setText(paramList);
        localTextView.setTag(paramList);
        this.q.add(localTextView);
        addView(localTextView, new LinearLayout.LayoutParams(-2, -2));
      }
      paramList = this.q.iterator();
      while (paramList.hasNext()) {
        ((TextView)paramList.next()).setOnClickListener(new a(paramc));
      }
    }
  }
  
  public void d()
  {
    Iterator localIterator = this.q.iterator();
    while (localIterator.hasNext()) {
      ((TextView)localIterator.next()).setTextColor(getContext().getResources().getColor(2131099736));
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt3 = getPaddingLeft();
    paramInt2 = getPaddingTop();
    for (paramInt1 = 0; paramInt1 < this.f.size(); paramInt1++)
    {
      b localb = (b)this.f.get(paramInt1);
      b.c(localb, paramInt3, paramInt2);
      paramInt2 += b.b(localb) + this.d;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i = View.MeasureSpec.getSize(paramInt1) - getPaddingLeft() - getPaddingRight();
    int j = View.MeasureSpec.getSize(paramInt2);
    int k = getPaddingTop();
    int m = getPaddingBottom();
    int n = View.MeasureSpec.getMode(paramInt1);
    int i1 = View.MeasureSpec.getMode(paramInt2);
    this.f.clear();
    b localb = new b(null);
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    while (i3 < getChildCount())
    {
      View localView = getChildAt(i3);
      int i5 = Integer.MIN_VALUE;
      if (n == 1073741824) {
        i6 = Integer.MIN_VALUE;
      } else {
        i6 = n;
      }
      int i7 = View.MeasureSpec.makeMeasureSpec(i, i6);
      if (i1 == 1073741824) {
        i6 = i5;
      } else {
        i6 = i1;
      }
      localView.measure(i7, View.MeasureSpec.makeMeasureSpec(j - k - m, i6));
      i4 += localView.getMeasuredWidth();
      if (i4 < i)
      {
        b.a(localb, localView);
        i4 += this.c;
      }
      else
      {
        this.f.add(localb);
        localb = new b(null);
        b.a(localb, localView);
        i4 = localView.getMeasuredWidth() + this.c + 0;
      }
      i3++;
    }
    if (!this.f.contains(localb)) {
      this.f.add(localb);
    }
    i4 = 0;
    for (i3 = i2; i3 < this.f.size(); i3++) {
      i4 += b.b((b)this.f.get(i3));
    }
    i1 = this.d;
    int i6 = this.f.size();
    i2 = getPaddingBottom();
    i3 = getPaddingTop();
    setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), ViewGroup.resolveSize(i4 + i1 * (i6 - 1) + (i2 + i3), paramInt2));
  }
  
  class a
    implements View.OnClickListener
  {
    a(FlowTagLayout.c paramc) {}
    
    public void onClick(View paramView)
    {
      if (!paramView.isSelected())
      {
        FlowTagLayout.this.d();
        ((TextView)paramView).setTextColor(FlowTagLayout.this.getContext().getResources().getColor(2131099808));
      }
      FlowTagLayout.c localc = paramc;
      if (localc != null) {
        localc.G((String)paramView.getTag());
      }
    }
  }
  
  private class b
  {
    private List<View> a = new ArrayList();
    int b;
    
    private b() {}
    
    private void d(View paramView)
    {
      this.a.add(paramView);
      if (this.b < paramView.getMeasuredHeight()) {
        this.b = paramView.getMeasuredHeight();
      }
    }
    
    private int e()
    {
      return this.b;
    }
    
    private void f(int paramInt1, int paramInt2)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        View localView = (View)localIterator.next();
        localView.layout(paramInt1, paramInt2, localView.getMeasuredWidth() + paramInt1, localView.getMeasuredHeight() + paramInt2);
        paramInt1 += localView.getMeasuredWidth() + FlowTagLayout.a(FlowTagLayout.this);
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void G(String paramString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\FlowTagLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */