package com.tplink.libtpcontrols.horizontalscrollpage;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.tplink.libtpcontrols.r0;
import com.tplink.libtpcontrols.s0;
import com.tplink.libtpcontrols.t0;
import com.tplink.libtpcontrols.x0;
import java.util.ArrayList;
import java.util.List;

public class TPPageLimitItemView
  extends FrameLayout
{
  private Context c = null;
  private RecyclerView d = null;
  private PageIndicatorView f = null;
  private List<?> p0 = null;
  private int p1 = -1;
  private int p2 = -1;
  private PagingScrollHelper q = new PagingScrollHelper(5, 1);
  private RecyclerView.Adapter x = null;
  private HorizontalPageLayoutManager y = null;
  private List<String> z = null;
  
  public TPPageLimitItemView(Context paramContext)
  {
    super(paramContext);
  }
  
  public TPPageLimitItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.c = paramContext;
    LayoutInflater.from(paramContext).inflate(t0.page_limit_main, this, true);
    this.d = ((RecyclerView)findViewById(s0.recycleview));
    this.f = ((PageIndicatorView)findViewById(s0.indicator));
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, x0.TPPageLimitItemView);
    this.p1 = paramContext.getResourceId(x0.TPPageLimitItemView_page_limit_indicator_invisible, r0.shape_circle_cyan_arc);
    this.p2 = paramContext.getResourceId(x0.TPPageLimitItemView_page_limit_indicator_online, r0.shape_circle_cyan);
    float f1 = paramContext.getDimension(x0.TPPageLimitItemView_page_limit_width, -1.0F);
    float f2 = paramContext.getDimension(x0.TPPageLimitItemView_page_limit_height, -1.0F);
    if (f2 > 0.0F)
    {
      paramAttributeSet = this.d.getLayoutParams();
      paramAttributeSet.height = ((int)f2);
      this.d.setLayoutParams(paramAttributeSet);
    }
    if (f1 > 0.0F)
    {
      paramAttributeSet = this.d.getLayoutParams();
      paramAttributeSet.width = ((int)f1);
      this.d.setLayoutParams(paramAttributeSet);
    }
    paramAttributeSet = new HorizontalPageLayoutManager(5, 1);
    this.y = paramAttributeSet;
    paramAttributeSet.d(c(getContext()));
    paramContext.recycle();
    b();
  }
  
  private void b()
  {
    if (this.z == null)
    {
      this.z = new ArrayList();
      for (i = 1; i <= 16; i++)
      {
        List localList = this.z;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(i);
        localList.add(localStringBuilder.toString());
      }
    }
    if (this.x == null) {
      this.x = new SimpleAdapter(this.c, this.z);
    }
    this.d.setAdapter(this.x);
    this.q.x(c(this.c));
    this.q.z(this.d);
    int i = this.p1;
    if (i > 0) {
      this.f.setInvisibleResource(i);
    }
    i = this.p2;
    if (i > 0) {
      this.f.setOnlineResource(i);
    }
    this.q.w(this.f);
    this.d.setLayoutManager(this.y);
    this.q.A();
  }
  
  @TargetApi(17)
  private boolean c(Context paramContext)
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
  
  public void setPageAdapter(RecyclerView.Adapter paramAdapter)
  {
    this.x = paramAdapter;
  }
  
  public void setPageData(List<?> paramList)
  {
    this.p0 = paramList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\horizontalscrollpage\TPPageLimitItemView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */