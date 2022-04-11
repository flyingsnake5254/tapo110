package com.tplink.iot.dailysummary.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tplink.iot.dailysummary.model.b;
import com.tplink.iot.dailysummary.view.SummaryHistoryActivity;
import com.tplink.iot.dailysummary.view.SummaryPlayActivity;
import com.tplink.iot.dailysummary.view.SummaryPlayActivity.a;
import com.tplink.iot.dailysummary.view.viewhodlder.SummaryHistoryViewHolder;
import com.tplink.iot.dailysummary.viewmodel.BaseSummaryListViewModel;
import com.tplink.iot.dailysummary.viewmodel.SummaryHistoryViewModel;
import com.tplink.iot.databinding.ItemSummaryHistoryBinding;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.j;

public final class SummaryHistoryAdapter
  extends RecyclerView.Adapter<SummaryHistoryViewHolder>
{
  private final SummaryHistoryActivity a;
  private final SummaryHistoryViewModel b;
  private ArrayList<b> c;
  private boolean d;
  
  public SummaryHistoryAdapter(Context paramContext, SummaryHistoryViewModel paramSummaryHistoryViewModel)
  {
    paramContext = (SummaryHistoryActivity)paramContext;
    this.a = paramContext;
    this.b = paramSummaryHistoryViewModel;
    this.c = new ArrayList();
    paramSummaryHistoryViewModel.C().observe(paramContext, new a(paramSummaryHistoryViewModel, this));
    paramSummaryHistoryViewModel.P().observe(paramContext, new b(this));
    paramSummaryHistoryViewModel.U().observe(paramContext, new c(this));
  }
  
  public int getItemCount()
  {
    return this.c.size();
  }
  
  public void r(SummaryHistoryViewHolder paramSummaryHistoryViewHolder, int paramInt)
  {
    j.e(paramSummaryHistoryViewHolder, "holder");
    Object localObject = this.c.get(paramInt);
    j.d(localObject, "mSummaryList[position]");
    paramSummaryHistoryViewHolder.c((b)localObject, this.b);
  }
  
  public SummaryHistoryViewHolder s(ViewGroup paramViewGroup, int paramInt)
  {
    j.e(paramViewGroup, "parent");
    paramViewGroup = (ItemSummaryHistoryBinding)DataBindingUtil.inflate(LayoutInflater.from(this.a), 2131559090, paramViewGroup, false);
    j.d(paramViewGroup, "binding");
    final SummaryHistoryViewHolder localSummaryHistoryViewHolder = new SummaryHistoryViewHolder(paramViewGroup);
    paramViewGroup.setLifecycleOwner(this.a);
    paramViewGroup.z.setOnClickListener(new d(this, localSummaryHistoryViewHolder));
    paramViewGroup.z.setOnLongClickListener(new e(this, localSummaryHistoryViewHolder));
    paramViewGroup.d.setOnClickListener(new f(this, localSummaryHistoryViewHolder));
    paramViewGroup.c.setOnClickListener(new g(this, localSummaryHistoryViewHolder));
    paramViewGroup.f.setOnClickListener(new h(this, localSummaryHistoryViewHolder));
    return localSummaryHistoryViewHolder;
  }
  
  public final void t(boolean paramBoolean)
  {
    this.d = paramBoolean;
    b localb;
    if (paramBoolean)
    {
      localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        localb = (b)localIterator.next();
        localb.q(true);
        localb.p(false);
      }
    }
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      localb = (b)localIterator.next();
      localb.q(false);
      localb.p(false);
    }
    notifyDataSetChanged();
  }
  
  static final class a<T>
    implements Observer<ArrayList<b>>
  {
    a(SummaryHistoryViewModel paramSummaryHistoryViewModel, SummaryHistoryAdapter paramSummaryHistoryAdapter) {}
    
    public final void a(ArrayList<b> paramArrayList)
    {
      if (j.a((Boolean)this.a.P().getValue(), Boolean.FALSE))
      {
        SummaryHistoryAdapter localSummaryHistoryAdapter = jdField_this;
        j.d(paramArrayList, "it");
        SummaryHistoryAdapter.q(localSummaryHistoryAdapter, paramArrayList);
        jdField_this.notifyDataSetChanged();
      }
    }
  }
  
  static final class b<T>
    implements Observer<Boolean>
  {
    b(SummaryHistoryAdapter paramSummaryHistoryAdapter) {}
    
    public final void a(Boolean paramBoolean)
    {
      SummaryHistoryAdapter localSummaryHistoryAdapter = this.a;
      j.d(paramBoolean, "it");
      localSummaryHistoryAdapter.t(paramBoolean.booleanValue());
    }
  }
  
  static final class c<T>
    implements Observer<Boolean>
  {
    c(SummaryHistoryAdapter paramSummaryHistoryAdapter) {}
    
    public final void a(Boolean paramBoolean)
    {
      this.a.notifyDataSetChanged();
    }
  }
  
  static final class d
    implements View.OnClickListener
  {
    d(SummaryHistoryAdapter paramSummaryHistoryAdapter, SummaryHistoryViewHolder paramSummaryHistoryViewHolder) {}
    
    public final void onClick(View paramView)
    {
      int i = localSummaryHistoryViewHolder.getBindingAdapterPosition();
      if (SummaryHistoryAdapter.n(this.c))
      {
        j.d(paramView, "it");
        paramView.setClickable(false);
        SummaryHistoryAdapter.p(this.c).L(i);
        this.c.notifyItemChanged(i);
        paramView.setClickable(true);
      }
    }
  }
  
  static final class e
    implements View.OnLongClickListener
  {
    e(SummaryHistoryAdapter paramSummaryHistoryAdapter, SummaryHistoryViewHolder paramSummaryHistoryViewHolder) {}
    
    public final boolean onLongClick(View paramView)
    {
      int i = localSummaryHistoryViewHolder.getBindingAdapterPosition();
      if (!SummaryHistoryAdapter.n(this.c)) {
        SummaryHistoryAdapter.m(this.c).p1(true);
      }
      SummaryHistoryAdapter.p(this.c).L(i);
      this.c.notifyItemChanged(i);
      return true;
    }
  }
  
  static final class f
    implements View.OnClickListener
  {
    f(SummaryHistoryAdapter paramSummaryHistoryAdapter, SummaryHistoryViewHolder paramSummaryHistoryViewHolder) {}
    
    public final void onClick(View paramView)
    {
      int i = localSummaryHistoryViewHolder.getBindingAdapterPosition();
      SummaryHistoryAdapter.p(this.c).k(i, 1);
      this.c.notifyItemChanged(i);
    }
  }
  
  static final class g
    implements View.OnClickListener
  {
    g(SummaryHistoryAdapter paramSummaryHistoryAdapter, SummaryHistoryViewHolder paramSummaryHistoryViewHolder) {}
    
    public final void onClick(View paramView)
    {
      int i = localSummaryHistoryViewHolder.getBindingAdapterPosition();
      SummaryHistoryAdapter.p(this.c).k(i, 0);
      this.c.notifyItemChanged(i);
    }
  }
  
  static final class h
    implements View.OnClickListener
  {
    h(SummaryHistoryAdapter paramSummaryHistoryAdapter, SummaryHistoryViewHolder paramSummaryHistoryViewHolder) {}
    
    public final void onClick(View paramView)
    {
      int i = localSummaryHistoryViewHolder.getBindingAdapterPosition();
      SummaryPlayActivity.y.a(SummaryHistoryAdapter.m(this.c), ((b)SummaryHistoryAdapter.o(this.c).get(i)).c());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\dailysummary\view\adapter\SummaryHistoryAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */