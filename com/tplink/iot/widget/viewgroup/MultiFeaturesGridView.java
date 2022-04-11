package com.tplink.iot.widget.viewgroup;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tplink.iot.Utils.extension.i;
import com.tplink.iot.databinding.ItemFeatureGridBinding;
import com.tplink.iot.databinding.ViewMultiFeaturesGridBinding;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.j;

public final class MultiFeaturesGridView
  extends FrameLayout
{
  public static final a c = new a(null);
  private final LayoutInflater d;
  private final ViewMultiFeaturesGridBinding f;
  private e q;
  private final b x;
  
  public MultiFeaturesGridView(Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  public MultiFeaturesGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  public MultiFeaturesGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = LayoutInflater.from(paramContext);
    this.d = paramAttributeSet;
    paramAttributeSet = DataBindingUtil.inflate(paramAttributeSet, 2131559432, this, true);
    j.d(paramAttributeSet, "DataBindingUtil.inflate(…eatures_grid, this, true)");
    Object localObject = (ViewMultiFeaturesGridBinding)paramAttributeSet;
    this.f = ((ViewMultiFeaturesGridBinding)localObject);
    paramAttributeSet = new b();
    this.x = paramAttributeSet;
    localObject = ((ViewMultiFeaturesGridBinding)localObject).c;
    ((RecyclerView)localObject).setLayoutManager(new GridLayoutManager(paramContext, 3));
    ((RecyclerView)localObject).setAdapter(paramAttributeSet);
    i.g((RecyclerView)localObject);
  }
  
  public final void c(int paramInt, float paramFloat)
  {
    Object localObject = this.x.m().iterator();
    for (int i = 0; ((Iterator)localObject).hasNext(); i++)
    {
      int j;
      if (((c)((Iterator)localObject).next()).b() == paramInt) {
        j = 1;
      } else {
        j = 0;
      }
      if (j != 0) {
        break label67;
      }
    }
    i = -1;
    label67:
    if (i == -1) {
      return;
    }
    RecyclerView.ViewHolder localViewHolder = this.f.c.findViewHolderForAdapterPosition(0);
    localObject = localViewHolder;
    if (!(localViewHolder instanceof d)) {
      localObject = null;
    }
    localObject = (d)localObject;
    if (localObject != null) {
      ((d)localObject).e(paramFloat);
    }
  }
  
  public final void d(int paramInt)
  {
    if (paramInt <= 0) {
      return;
    }
    RecyclerView localRecyclerView = this.f.c;
    j.d(localRecyclerView, "mBinding.rvFeatures");
    localRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), paramInt));
  }
  
  public final List<c> getFeatureData()
  {
    return this.x.m();
  }
  
  public final int getFirstRowHeight()
  {
    Object localObject1 = this.f.c.findViewHolderForAdapterPosition(0);
    boolean bool = localObject1 instanceof d;
    Object localObject2 = null;
    if (!bool) {
      localObject1 = null;
    }
    d locald = (d)localObject1;
    localObject1 = localObject2;
    if (locald != null) {
      localObject1 = Integer.valueOf(locald.d());
    }
    int i;
    if ((localObject1 != null) && (((Integer)localObject1).intValue() != 0)) {
      i = ((Integer)localObject1).intValue();
    } else {
      i = getMeasuredHeight();
    }
    return i;
  }
  
  public final void setFeatureData(List<c> paramList)
  {
    j.e(paramList, "data");
    this.x.p(paramList);
  }
  
  public final void setOnFeatureItemClickListener(e parame)
  {
    j.e(parame, "listener");
    this.q = parame;
  }
  
  public static final class a {}
  
  private final class b
    extends RecyclerView.Adapter<MultiFeaturesGridView.d>
  {
    private final List<MultiFeaturesGridView.c> a = new ArrayList();
    
    public b() {}
    
    public int getItemCount()
    {
      return this.a.size();
    }
    
    public final List<MultiFeaturesGridView.c> m()
    {
      return this.a;
    }
    
    public void n(MultiFeaturesGridView.d paramd, int paramInt)
    {
      j.e(paramd, "holder");
      paramd.c((MultiFeaturesGridView.c)this.a.get(paramInt));
    }
    
    public MultiFeaturesGridView.d o(ViewGroup paramViewGroup, int paramInt)
    {
      j.e(paramViewGroup, "parent");
      MultiFeaturesGridView localMultiFeaturesGridView = MultiFeaturesGridView.this;
      paramViewGroup = ItemFeatureGridBinding.h(MultiFeaturesGridView.b(localMultiFeaturesGridView), paramViewGroup, false);
      j.d(paramViewGroup, "ItemFeatureGridBinding.i…tInflater, parent, false)");
      return new MultiFeaturesGridView.d(localMultiFeaturesGridView, paramViewGroup);
    }
    
    public final void p(List<MultiFeaturesGridView.c> paramList)
    {
      j.e(paramList, "data");
      this.a.clear();
      this.a.addAll(paramList);
      notifyDataSetChanged();
    }
  }
  
  public static final class c
  {
    private final int a;
    private final int b;
    private final int c;
    
    public c(@DrawableRes int paramInt1, @StringRes int paramInt2, int paramInt3)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramInt3;
    }
    
    public final int a()
    {
      return this.a;
    }
    
    public final int b()
    {
      return this.c;
    }
    
    public final int c()
    {
      return this.b;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this != paramObject) {
        if ((paramObject instanceof c))
        {
          paramObject = (c)paramObject;
          if ((this.a == ((c)paramObject).a) && (this.b == ((c)paramObject).b) && (this.c == ((c)paramObject).c)) {}
        }
        else
        {
          return false;
        }
      }
      return true;
    }
    
    public int hashCode()
    {
      return (this.a * 31 + this.b) * 31 + this.c;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("FeatureData(iconRes=");
      localStringBuilder.append(this.a);
      localStringBuilder.append(", nameRes=");
      localStringBuilder.append(this.b);
      localStringBuilder.append(", identifier=");
      localStringBuilder.append(this.c);
      localStringBuilder.append(")");
      return localStringBuilder.toString();
    }
  }
  
  private final class d
    extends RecyclerView.ViewHolder
  {
    private final ItemFeatureGridBinding a;
    
    public d()
    {
      super();
      this.a = ((ItemFeatureGridBinding)localObject);
    }
    
    public final void c(final MultiFeaturesGridView.c paramc)
    {
      j.e(paramc, "data");
      this.a.c.setImageResource(paramc.a());
      this.a.f.setText(paramc.c());
      this.a.d.setOnClickListener(new a(this, paramc));
    }
    
    public final int d()
    {
      LinearLayout localLinearLayout = this.a.d;
      j.d(localLinearLayout, "binding.llFeature");
      return localLinearLayout.getMeasuredHeight();
    }
    
    public final void e(float paramFloat)
    {
      ImageView localImageView = this.a.c;
      j.d(localImageView, "binding.ivFeatureIcon");
      localImageView.setAlpha(paramFloat);
    }
    
    static final class a
      implements View.OnClickListener
    {
      a(MultiFeaturesGridView.d paramd, MultiFeaturesGridView.c paramc) {}
      
      public final void onClick(View paramView)
      {
        paramView = MultiFeaturesGridView.a(this.c.b);
        if (paramView != null) {
          paramView.o0(paramc.b());
        }
      }
    }
  }
  
  public static abstract interface e
  {
    public abstract void o0(int paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\viewgroup\MultiFeaturesGridView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */