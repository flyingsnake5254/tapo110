package com.tplink.libtpcontrols.smallchart;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.tplink.libtpcontrols.s0;
import com.tplink.libtpcontrols.t0;
import java.util.ArrayList;
import java.util.List;

public class ScrollChartView
  extends FrameLayout
{
  private Context c;
  private CurveLineView d = null;
  private List<Integer> f = new ArrayList();
  private List<String> q = new ArrayList();
  
  public ScrollChartView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ScrollChartView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    d(paramContext);
  }
  
  private void a(List<Integer> paramList, String paramString)
  {
    if (paramString == null) {
      b(paramList);
    } else {
      c(paramList, paramString);
    }
  }
  
  private void b(List<Integer> paramList)
  {
    this.q.clear();
    this.q.add("");
    for (int i = 1; i <= paramList.size(); i++)
    {
      int j = i % 10;
      Object localObject;
      if ((j == 1) && (i != 11))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append("st");
        localObject = ((StringBuilder)localObject).toString();
      }
      else if ((j == 2) && (i != 12))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append("nd");
        localObject = ((StringBuilder)localObject).toString();
      }
      else if ((j == 3) && (i != 13))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append("rd");
        localObject = ((StringBuilder)localObject).toString();
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append("th");
        localObject = ((StringBuilder)localObject).toString();
      }
      this.q.add(localObject);
    }
  }
  
  private void c(List<Integer> paramList, String paramString)
  {
    this.q.clear();
    this.q.add("");
    for (int i = 1; i <= paramList.size(); i++)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(i);
      localObject = ((StringBuilder)localObject).toString();
      this.q.add(localObject);
    }
  }
  
  private void d(Context paramContext)
  {
    this.c = paramContext;
    LayoutInflater.from(paramContext).inflate(t0.scroll_chart_layout, this, true);
    this.d = ((CurveLineView)findViewById(s0.line_view));
  }
  
  private void e(List<String> paramList)
  {
    this.d.setDrawDotLine(Boolean.TRUE);
    this.d.setShowPopup(1);
    this.d.setBottomTextList((ArrayList)this.q);
    if ((paramList != null) && (!paramList.isEmpty())) {
      this.d.r((ArrayList)paramList, (ArrayList)this.f);
    } else {
      this.d.r(null, (ArrayList)this.f);
    }
  }
  
  @TargetApi(17)
  private boolean f(Context paramContext)
  {
    int i = Build.VERSION.SDK_INT;
    boolean bool = false;
    if (i < 17) {
      return false;
    }
    if (paramContext.getResources().getConfiguration().getLayoutDirection() == 1) {
      bool = true;
    }
    return bool;
  }
  
  public void setChartDataList(List<Integer> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.f.clear();
      this.f.add(paramList.get(0));
      this.f.addAll(paramList);
      a(paramList, null);
      if (f(this.c))
      {
        paramList = new ArrayList();
        ArrayList localArrayList = new ArrayList();
        for (int i = this.f.size() - 1; i >= 0; i--) {
          paramList.add(this.f.get(i));
        }
        for (i = this.q.size() - 1; i >= 0; i--) {
          localArrayList.add(this.q.get(i));
        }
        this.f = paramList;
        this.q = localArrayList;
      }
      e(null);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\smallchart\ScrollChartView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */