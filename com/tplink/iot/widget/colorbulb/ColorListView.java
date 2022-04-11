package com.tplink.iot.widget.colorbulb;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import net.lucode.hackware.magicindicator.g.b;

public class ColorListView
  extends LinearLayout
  implements View.OnClickListener
{
  private List<Integer> c;
  private List<ColorPointView> d;
  private a f;
  private LinearLayout.LayoutParams q;
  
  public ColorListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ColorListView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ColorListView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.d = new ArrayList();
    this.c = new ArrayList();
    this.q = new LinearLayout.LayoutParams(-2, -2);
  }
  
  public void onClick(View paramView)
  {
    if ((paramView instanceof ColorPointView))
    {
      int i = ((Integer)paramView.getTag()).intValue();
      paramView = (ColorPointView)paramView;
      if ((i >= 0) && (i < this.d.size()) && (this.f != null) && (i < this.c.size())) {
        this.f.a(i, ((Integer)this.c.get(i)).intValue());
      }
    }
  }
  
  public void setColorPresets(List<Integer> paramList)
  {
    removeAllViews();
    this.c.clear();
    this.d.clear();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.c.addAll(paramList);
      for (int i = 0; i < paramList.size(); i++)
      {
        int j = ((Integer)paramList.get(i)).intValue();
        ColorPointView localColorPointView = new ColorPointView(getContext(), b.a(getContext(), 48.0D), getResources().getColor(2131099808), j);
        localColorPointView.setOnClickListener(this);
        localColorPointView.setTag(Integer.valueOf(i));
        LinearLayout.LayoutParams localLayoutParams = this.q;
        if (i == 0) {
          j = 0;
        } else {
          j = b.a(getContext(), 10.0D);
        }
        localLayoutParams.rightMargin = j;
        this.d.add(localColorPointView);
        addView(localColorPointView, this.q);
      }
    }
  }
  
  public void setOnColorListCheckedListener(a parama)
  {
    this.f = parama;
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\colorbulb\ColorListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */