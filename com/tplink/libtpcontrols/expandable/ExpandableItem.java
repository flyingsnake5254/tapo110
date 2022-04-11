package com.tplink.libtpcontrols.expandable;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.tplink.libtpcontrols.s0;
import com.tplink.libtpcontrols.t0;
import com.tplink.libtpcontrols.x0;

public class ExpandableItem
  extends RelativeLayout
{
  private int c;
  private View d;
  private RecyclerView f;
  private ExpandableSubItemsAdapter q;
  
  public ExpandableItem(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public ExpandableItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ExpandableItem(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, x0.ExpandableItem);
    int i = paramAttributeSet.getResourceId(x0.ExpandableItem_ei_headerLayout, -1);
    int j = paramAttributeSet.getResourceId(x0.ExpandableItem_ei_contentLayout, -1);
    if ((i != -1) && (j != -1))
    {
      if (isInEditMode()) {
        return;
      }
      this.c = paramAttributeSet.getInt(x0.ExpandableItem_ei_duration, 3000);
      paramAttributeSet.recycle();
      Object localObject = LayoutInflater.from(paramContext).inflate(t0.expandable_item, this);
      paramAttributeSet = (ViewGroup)((View)localObject).findViewById(s0.expandable_item_header);
      localObject = (ViewGroup)((View)localObject).findViewById(s0.expandable_item_content);
      View localView = View.inflate(paramContext, i, null);
      this.d = localView;
      localView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
      paramAttributeSet.addView(this.d);
      paramAttributeSet = (RecyclerView)View.inflate(paramContext, j, null);
      this.f = paramAttributeSet;
      paramAttributeSet.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
      ((ViewGroup)localObject).addView(this.f);
      this.f.setLayoutManager(new LinearLayoutManager(paramContext));
      this.f.setItemAnimator(new DefaultItemAnimator());
      return;
    }
    throw new IllegalArgumentException("HeaderLayout and ContentLayout cannot be null!");
  }
  
  public RecyclerView getContentView()
  {
    return this.f;
  }
  
  public View getHeader()
  {
    return this.d;
  }
  
  public void setContentViewAdapter(RecyclerView.Adapter paramAdapter)
  {
    paramAdapter = new ExpandableSubItemsAdapter(paramAdapter);
    this.q = paramAdapter;
    this.f.setAdapter(paramAdapter);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\expandable\ExpandableItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */