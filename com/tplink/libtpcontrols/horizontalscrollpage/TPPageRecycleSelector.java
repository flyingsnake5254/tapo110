package com.tplink.libtpcontrols.horizontalscrollpage;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.tplink.libtpcontrols.r0;
import com.tplink.libtpcontrols.s0;
import com.tplink.libtpcontrols.t0;
import com.tplink.libtpcontrols.x0;
import java.util.ArrayList;
import java.util.List;

public class TPPageRecycleSelector
  extends FrameLayout
  implements PagingScrollHelper.c
{
  private int H3 = -1;
  private int I3 = -1;
  private float J3 = 0.0F;
  private float K3 = 0.0F;
  private List<String> L3 = null;
  private List<?> M3 = null;
  private a N3;
  private Context c = null;
  private View d = null;
  private RecyclerView f = null;
  private float p0 = -1.0F;
  private float p1 = -1.0F;
  private boolean p2 = true;
  private int p3 = 0;
  private PageIndicatorView q = null;
  private PagingScrollHelper x = new PagingScrollHelper(2, 3);
  private RecyclerView.Adapter y = null;
  private HorizontalPageLayoutManager z = null;
  
  public TPPageRecycleSelector(Context paramContext)
  {
    super(paramContext);
  }
  
  public TPPageRecycleSelector(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(paramContext, paramAttributeSet);
  }
  
  private void b(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.c = paramContext;
    this.d = LayoutInflater.from(paramContext).inflate(t0.page_recycle_select_main, this, true);
    this.f = ((RecyclerView)findViewById(s0.recycleview));
    this.q = ((PageIndicatorView)findViewById(s0.indicator));
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, x0.TPPageRecycleSelector);
    this.p0 = paramContext.getDimension(x0.TPPageRecycleSelector_page_selector_width, -1.0F);
    this.p1 = paramContext.getDimension(x0.TPPageRecycleSelector_page_selector_height, -1.0F);
    this.p2 = paramContext.getBoolean(x0.TPPageRecycleSelector_page_indicator_enable, true);
    int i = paramContext.getInt(x0.TPPageRecycleSelector_page_indicator_index, -1);
    this.p3 = i;
    if (i < 0) {
      this.p3 = 0;
    }
    this.H3 = paramContext.getResourceId(x0.TPPageRecycleSelector_page_indicator_invisible, r0.shape_circle_cyan_arc);
    this.I3 = paramContext.getResourceId(x0.TPPageRecycleSelector_page_indicator_online, r0.shape_circle_cyan);
    this.J3 = paramContext.getDimension(x0.TPPageRecycleSelector_page_indicator_size, -1.0F);
    this.K3 = paramContext.getDimension(x0.TPPageRecycleSelector_page_indicator_margin, -1.0F);
    if (this.p1 > 0.0F)
    {
      paramAttributeSet = this.f.getLayoutParams();
      paramAttributeSet.height = ((int)this.p1);
      this.f.setLayoutParams(paramAttributeSet);
    }
    if (this.p0 > 0.0F)
    {
      paramAttributeSet = this.f.getLayoutParams();
      paramAttributeSet.width = ((int)this.p0);
      this.f.setLayoutParams(paramAttributeSet);
    }
    paramAttributeSet = new HorizontalPageLayoutManager(2, 3);
    this.z = paramAttributeSet;
    paramAttributeSet.d(d(getContext()));
    c();
    paramContext.recycle();
  }
  
  private void c()
  {
    if (this.L3 == null)
    {
      this.L3 = new ArrayList();
      for (i = 1; i <= 16; i++)
      {
        List localList = this.L3;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(i);
        localList.add(localStringBuilder.toString());
      }
    }
    if (this.y == null) {
      this.y = new SimpleAdapter(this.c, this.L3);
    }
    this.f.setAdapter(this.y);
    this.x.x(d(this.c));
    this.x.z(this.f);
    this.x.y(this);
    if (this.p2) {
      this.q.setVisibility(0);
    } else {
      this.q.setVisibility(8);
    }
    float f1 = this.J3;
    if (f1 > 0.0F) {
      this.q.setIndicatorSize((int)f1);
    }
    f1 = this.K3;
    if (f1 > 0.0F) {
      this.q.setIndicatorMargin((int)f1);
    }
    int i = this.H3;
    if (i > 0) {
      this.q.setInvisibleResource(i);
    }
    i = this.I3;
    if (i > 0) {
      this.q.setOnlineResource(i);
    }
    i = this.p3;
    if (i >= 0) {
      this.q.setIndexOfIndicator(i);
    }
    this.x.w(this.q);
    this.f.setLayoutManager(this.z);
    this.x.A();
  }
  
  @TargetApi(17)
  private boolean d(Context paramContext)
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
  
  public void a(int paramInt)
  {
    a locala = this.N3;
    if (locala != null) {
      locala.a(paramInt);
    }
  }
  
  public void setCustomHeight(float paramFloat)
  {
    this.p1 = paramFloat;
  }
  
  public void setCustomWidth(float paramFloat)
  {
    this.p0 = paramFloat;
  }
  
  public void setOnPageChangeListener(a parama)
  {
    this.N3 = parama;
  }
  
  public void setPageAdapter(RecyclerView.Adapter paramAdapter)
  {
    this.y = paramAdapter;
  }
  
  public void setPageData(List<?> paramList)
  {
    this.M3 = paramList;
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\horizontalscrollpage\TPPageRecycleSelector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */