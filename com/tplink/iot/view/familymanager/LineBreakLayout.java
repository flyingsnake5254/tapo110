package com.tplink.iot.view.familymanager;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import b.d.w.c.a;
import com.tplink.iot.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LineBreakLayout
  extends ViewGroup
{
  private List<String> c;
  private List<String> d = new ArrayList();
  private int f;
  private int q;
  private b x;
  
  public LineBreakLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public LineBreakLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public LineBreakLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, b.LineBreakLayout);
    this.f = paramContext.getDimensionPixelSize(1, 10);
    this.q = paramContext.getDimensionPixelSize(0, 14);
    paramContext.recycle();
  }
  
  private void e()
  {
    int i = getChildCount();
    if (i > 0) {
      for (int j = 0; j < i; j++)
      {
        TextView localTextView = (TextView)getChildAt(j);
        if (!this.d.contains(localTextView.getText()))
        {
          localTextView.setSelected(false);
          localTextView.setTextColor(getResources().getColor(2131099804));
        }
      }
    }
  }
  
  public void d()
  {
    this.d.clear();
    e();
  }
  
  public List<String> getSelectedLables()
  {
    return this.d;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 = 0;
    int i = 0;
    for (paramInt4 = 0; paramInt1 < getChildCount(); paramInt4 = paramInt2)
    {
      View localView = getChildAt(paramInt1);
      int j = localView.getMeasuredWidth();
      int k = localView.getMeasuredHeight();
      int m = i + j;
      int n = this.q;
      int i1 = (k + n) * paramInt4 + k;
      i = m;
      paramInt2 = paramInt4;
      if (m > paramInt3 - this.f)
      {
        paramInt2 = paramInt4 + 1;
        i1 = (n + k) * paramInt2 + k;
        i = j;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("left = ");
      paramInt4 = i - j;
      localStringBuilder.append(paramInt4);
      localStringBuilder.append(" top = ");
      j = i1 - k;
      localStringBuilder.append(j);
      localStringBuilder.append(" right = ");
      localStringBuilder.append(i);
      localStringBuilder.append(" botom = ");
      localStringBuilder.append(i1);
      a.c("LineBreakLayout", localStringBuilder.toString());
      localView.layout(paramInt4, j, i, i1);
      i += this.f;
      paramInt1++;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    measureChildren(paramInt1, paramInt2);
    int i = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    int j = View.MeasureSpec.getSize(paramInt1);
    if (i == 1073741824)
    {
      paramInt1 = paramInt2;
    }
    else
    {
      int k = getChildCount();
      if (k <= 0)
      {
        paramInt1 = 0;
      }
      else
      {
        paramInt2 = 1;
        i = j;
        for (paramInt1 = 0; paramInt1 < k; paramInt1++)
        {
          int m = getChildAt(paramInt1).getMeasuredWidth();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("标签宽度:");
          localStringBuilder.append(m);
          localStringBuilder.append(" 行数：");
          localStringBuilder.append(paramInt2);
          localStringBuilder.append("  剩余宽度：");
          localStringBuilder.append(i);
          a.l("LineBreakLayout", localStringBuilder.toString());
          if (i >= m)
          {
            i -= m;
          }
          else
          {
            paramInt2++;
            i = j - m;
          }
          i -= this.f;
        }
        i = getChildAt(0).getMeasuredHeight();
        paramInt1 = i * paramInt2 + this.q * (paramInt2 - 1);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("总高度:");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(" 行数：");
        localStringBuilder.append(paramInt2);
        localStringBuilder.append("  标签高度：");
        localStringBuilder.append(i);
        a.l("LineBreakLayout", localStringBuilder.toString());
      }
    }
    setMeasuredDimension(j, paramInt1);
  }
  
  public void setListener(b paramb)
  {
    this.x = paramb;
  }
  
  public void setSingleSelectionLables(List<String> paramList)
  {
    if (this.c == null) {
      this.c = new ArrayList();
    }
    this.c.clear();
    this.c.addAll(paramList);
    if ((paramList != null) && (paramList.size() > 0))
    {
      LayoutInflater localLayoutInflater = LayoutInflater.from(getContext());
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        final String str = (String)paramList.next();
        final TextView localTextView = (TextView)localLayoutInflater.inflate(2131559046, null);
        localTextView.setText(str);
        if (this.d.contains(str))
        {
          localTextView.setSelected(true);
          localTextView.setTextColor(getResources().getColor(2131099808));
        }
        else
        {
          localTextView.setSelected(false);
          localTextView.setTextColor(getResources().getColor(2131099804));
        }
        localTextView.setOnClickListener(new a(localTextView, str));
        addView(localTextView);
      }
    }
  }
  
  class a
    implements View.OnClickListener
  {
    a(TextView paramTextView, String paramString) {}
    
    public void onClick(View paramView)
    {
      paramView = localTextView;
      paramView.setSelected(paramView.isSelected() ^ true);
      LineBreakLayout.a(LineBreakLayout.this).clear();
      if (localTextView.isSelected())
      {
        localTextView.setTextColor(LineBreakLayout.this.getResources().getColor(2131099808));
        LineBreakLayout.a(LineBreakLayout.this).add(str);
      }
      else
      {
        localTextView.setTextColor(LineBreakLayout.this.getResources().getColor(2131099804));
      }
      LineBreakLayout.b(LineBreakLayout.this);
      if (LineBreakLayout.c(LineBreakLayout.this) != null) {
        LineBreakLayout.c(LineBreakLayout.this).M();
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void M();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\familymanager\LineBreakLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */