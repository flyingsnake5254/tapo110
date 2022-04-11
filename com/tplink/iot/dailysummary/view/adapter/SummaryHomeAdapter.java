package com.tplink.iot.dailysummary.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tplink.iot.dailysummary.model.b;
import com.tplink.iot.dailysummary.view.DailySummaryActivity;
import com.tplink.iot.dailysummary.view.SummaryPlayActivity;
import com.tplink.iot.dailysummary.view.SummaryPlayActivity.a;
import com.tplink.iot.dailysummary.view.viewhodlder.SummaryHomeViewHolder;
import com.tplink.iot.dailysummary.viewmodel.BaseSummaryListViewModel;
import com.tplink.iot.dailysummary.viewmodel.DailySummaryViewModel;
import com.tplink.iot.databinding.ItemSummaryHomeBinding;
import java.util.ArrayList;
import java.util.Objects;
import kotlin.jvm.internal.j;

public final class SummaryHomeAdapter
  extends RecyclerView.Adapter<SummaryHomeViewHolder>
{
  private final DailySummaryActivity a;
  private final DailySummaryViewModel b;
  private ArrayList<b> c;
  private int d;
  
  public SummaryHomeAdapter(Context paramContext, DailySummaryViewModel paramDailySummaryViewModel)
  {
    paramContext = (DailySummaryActivity)paramContext;
    this.a = paramContext;
    this.b = paramDailySummaryViewModel;
    this.c = new ArrayList();
    this.d = 1;
    paramDailySummaryViewModel.c0().observe(paramContext, new a(this));
  }
  
  public int getItemCount()
  {
    return this.c.size();
  }
  
  public void r(SummaryHomeViewHolder paramSummaryHomeViewHolder, int paramInt)
  {
    j.e(paramSummaryHomeViewHolder, "holder");
    Object localObject = this.c.get(paramInt);
    j.d(localObject, "mAdapterList[position]");
    paramSummaryHomeViewHolder.c((b)localObject, this.b);
  }
  
  public SummaryHomeViewHolder s(final ViewGroup paramViewGroup, int paramInt)
  {
    j.e(paramViewGroup, "parent");
    ItemSummaryHomeBinding localItemSummaryHomeBinding = (ItemSummaryHomeBinding)DataBindingUtil.inflate(LayoutInflater.from(this.a), 2131559091, paramViewGroup, false);
    j.d(localItemSummaryHomeBinding, "binding");
    paramViewGroup = new SummaryHomeViewHolder(localItemSummaryHomeBinding);
    DailySummaryActivity localDailySummaryActivity = this.a;
    Objects.requireNonNull(localDailySummaryActivity, "null cannot be cast to non-null type com.tplink.iot.dailysummary.view.DailySummaryActivity");
    localItemSummaryHomeBinding.setLifecycleOwner(localDailySummaryActivity);
    localItemSummaryHomeBinding.d.setOnClickListener(new b(this, paramViewGroup));
    localItemSummaryHomeBinding.c.setOnClickListener(new c(this, paramViewGroup));
    localItemSummaryHomeBinding.f.setOnClickListener(new d(this, paramViewGroup));
    return paramViewGroup;
  }
  
  static final class a<T>
    implements Observer<ArrayList<b>>
  {
    a(SummaryHomeAdapter paramSummaryHomeAdapter) {}
    
    public final void a(ArrayList<b> paramArrayList)
    {
      SummaryHomeAdapter localSummaryHomeAdapter = this.a;
      j.d(paramArrayList, "it");
      SummaryHomeAdapter.q(localSummaryHomeAdapter, paramArrayList);
      this.a.notifyDataSetChanged();
    }
  }
  
  static final class b
    implements View.OnClickListener
  {
    b(SummaryHomeAdapter paramSummaryHomeAdapter, SummaryHomeViewHolder paramSummaryHomeViewHolder) {}
    
    public final void onClick(View paramView)
    {
      int i = paramViewGroup.getAdapterPosition();
      int j = SummaryHomeAdapter.o(this.c);
      SummaryHomeAdapter.p(this.c).k(i + j, 1);
    }
  }
  
  static final class c
    implements View.OnClickListener
  {
    c(SummaryHomeAdapter paramSummaryHomeAdapter, SummaryHomeViewHolder paramSummaryHomeViewHolder) {}
    
    public final void onClick(View paramView)
    {
      int i = paramViewGroup.getAdapterPosition();
      int j = SummaryHomeAdapter.o(this.c);
      SummaryHomeAdapter.p(this.c).k(i + j, 0);
    }
  }
  
  static final class d
    implements View.OnClickListener
  {
    d(SummaryHomeAdapter paramSummaryHomeAdapter, SummaryHomeViewHolder paramSummaryHomeViewHolder) {}
    
    public final void onClick(View paramView)
    {
      int i = paramViewGroup.getAdapterPosition();
      SummaryPlayActivity.y.a(SummaryHomeAdapter.n(this.c), ((b)SummaryHomeAdapter.m(this.c).get(i)).c());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\dailysummary\view\adapter\SummaryHomeAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */