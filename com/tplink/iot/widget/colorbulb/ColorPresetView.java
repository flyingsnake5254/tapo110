package com.tplink.iot.widget.colorbulb;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import androidx.annotation.Nullable;
import com.tplink.iot.Utils.z0.i;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;
import java.util.ArrayList;
import java.util.List;
import net.lucode.hackware.magicindicator.g.b;

public class ColorPresetView
  extends LinearLayout
  implements View.OnClickListener
{
  private List<LightStateBean> c;
  private ColorPointView d;
  private List<ColorPointView> f;
  private a q;
  private LinearLayout.LayoutParams x;
  private int y = Integer.MAX_VALUE;
  
  public ColorPresetView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ColorPresetView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ColorPresetView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c(paramContext);
  }
  
  private void c(Context paramContext)
  {
    this.f = new ArrayList();
    this.c = new ArrayList();
    this.x = new LinearLayout.LayoutParams(-2, -2);
  }
  
  public void a()
  {
    ColorPointView localColorPointView = this.d;
    if (localColorPointView != null) {
      localColorPointView.setSelectedStatus(false);
    }
    for (int i = 0; i < this.f.size(); i++) {
      ((ColorPointView)this.f.get(i)).setSelectedStatus(false);
    }
  }
  
  public void b()
  {
    if (getChildCount() > 2)
    {
      View localView = getChildAt(2);
      if ((localView instanceof ColorPointView)) {
        localView.callOnClick();
      }
    }
  }
  
  public void d()
  {
    a();
    this.d.setSelectedStatus(true);
    this.y = -1;
  }
  
  public void onClick(View paramView)
  {
    if ((paramView instanceof ColorPointView))
    {
      int i = ((Integer)paramView.getTag()).intValue();
      ColorPointView localColorPointView = (ColorPointView)paramView;
      boolean bool = localColorPointView.b();
      if (i == -1)
      {
        paramView = this.q;
        if (paramView != null) {
          if (bool) {
            paramView.b();
          } else {
            paramView.d();
          }
        }
      }
      else if ((i >= 0) && (i < this.f.size()))
      {
        a();
        localColorPointView.setSelectedStatus(true);
        this.y = i;
        paramView = this.q;
        if (paramView != null) {
          if (bool) {
            paramView.c(i, localColorPointView.getInnerCircleColor(), (LightStateBean)this.c.get(i));
          } else {
            paramView.a(i, (LightStateBean)this.c.get(i));
          }
        }
      }
    }
  }
  
  public void setColorPresets(List<LightStateBean> paramList)
  {
    try
    {
      removeAllViews();
      this.c.clear();
      Object localObject = new com/tplink/iot/widget/colorbulb/ColorPointView;
      ((ColorPointView)localObject).<init>(getContext(), b.a(getContext(), 44.0D), getResources().getColor(2131100206), getResources().getColor(2131100206));
      this.d = ((ColorPointView)localObject);
      ((ColorPointView)localObject).setType(1);
      this.d.setOnClickListener(this);
      this.d.setTag(Integer.valueOf(-1));
      addView(this.d);
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        this.c.addAll(paramList);
        for (int i = 0; i < paramList.size(); i++)
        {
          localObject = (LightStateBean)paramList.get(i);
          if (((LightStateBean)localObject).getColorTemp() == 0)
          {
            int j = i.d((LightStateBean)localObject);
            localObject = new com/tplink/iot/widget/colorbulb/ColorPointView;
            ((ColorPointView)localObject).<init>(getContext(), b.a(getContext(), 44.0D), getResources().getColor(2131100206), getResources().getColor(2131100206), j);
          }
          else
          {
            localObject = new ColorPointView(getContext(), b.a(getContext(), 44.0D), getResources().getColor(2131100206), -1);
          }
          ((ColorPointView)localObject).setType(2);
          ((View)localObject).setOnClickListener(this);
          ((View)localObject).setTag(Integer.valueOf(i));
          this.x.leftMargin = b.a(getContext(), 10.0D);
          this.f.add(localObject);
          addView((View)localObject, this.x);
        }
        i = this.y;
        if (i != Integer.MAX_VALUE)
        {
          i++;
          if ((i >= 0) && (i < getChildCount()))
          {
            paramList = getChildAt(i);
            if ((paramList instanceof ColorPointView)) {
              ((ColorPointView)paramList).setSelectedStatus(true);
            }
          }
        }
        return;
      }
      return;
    }
    finally {}
  }
  
  public void setOnColorPresetCheckedListener(a parama)
  {
    this.q = parama;
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt, LightStateBean paramLightStateBean);
    
    public abstract void b();
    
    public abstract void c(int paramInt1, int paramInt2, LightStateBean paramLightStateBean);
    
    public abstract void d();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\colorbulb\ColorPresetView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */