package com.tplink.iot.adapter.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.DiffUtil.DiffResult;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.AdapterDataObserver;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.collections.l;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.q;

public class DataBindingListAdapter
  extends RecyclerView.Adapter<ViewHolder>
{
  private static int a = a.f;
  private static int b = a.a;
  public static final a c = new a(null);
  private final int d;
  private final int e;
  private View f;
  private View g;
  private final MutableLiveData<Integer> h;
  private ArrayList<Object> i;
  private ArrayList<?> j;
  private int k;
  private int[] l;
  private LifecycleOwner m;
  private final int n;
  private final int[] o;
  private final int[] p;
  private final Object[] q;
  
  public DataBindingListAdapter(int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2, Object... paramVarArgs)
  {
    this.n = paramInt;
    this.o = paramArrayOfInt1;
    this.p = paramArrayOfInt2;
    this.q = paramVarArgs;
    this.d = 2147483645;
    this.e = 2147483644;
    this.h = new MutableLiveData();
    this.i = new ArrayList();
    paramVarArgs = l.c(Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    this.j = paramVarArgs;
    j.c(paramVarArgs);
    g.f(paramVarArgs, this.i);
    paramInt = paramArrayOfInt2.length;
    int i1 = 0;
    if (paramInt == 0) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    int i2;
    if (paramInt != 0)
    {
      i2 = paramArrayOfInt1.length;
      paramArrayOfInt1 = new int[i2];
      for (paramInt = i1; paramInt < i2; paramInt++) {
        paramArrayOfInt1[paramInt] = paramInt;
      }
      this.l = paramArrayOfInt1;
    }
    else
    {
      this.l = new int[paramArrayOfInt2.length];
      int i3 = paramArrayOfInt2.length;
      for (i1 = 0; i1 < i3; i1++)
      {
        paramArrayOfInt1 = this.l;
        paramArrayOfInt2 = this.o;
        int i4 = paramArrayOfInt2.length;
        for (paramInt = 0; paramInt < i4; paramInt++)
        {
          if (paramArrayOfInt2[paramInt] == this.p[i1]) {
            i2 = 1;
          } else {
            i2 = 0;
          }
          if (i2 != 0) {
            break label250;
          }
        }
        paramInt = -1;
        label250:
        paramArrayOfInt1[i1] = paramInt;
      }
    }
    registerAdapterDataObserver(new RecyclerView.AdapterDataObserver()
    {
      public void onChanged()
      {
        super.onChanged();
        this.a.n();
      }
      
      public void onItemRangeChanged(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        super.onItemRangeChanged(paramAnonymousInt1, paramAnonymousInt2);
        this.a.n();
      }
      
      public void onItemRangeChanged(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        super.onItemRangeChanged(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousObject);
        this.a.n();
      }
      
      public void onItemRangeInserted(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        super.onItemRangeInserted(paramAnonymousInt1, paramAnonymousInt2);
        this.a.n();
      }
      
      public void onItemRangeMoved(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        super.onItemRangeMoved(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        this.a.n();
      }
      
      public void onItemRangeRemoved(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        super.onItemRangeRemoved(paramAnonymousInt1, paramAnonymousInt2);
        this.a.n();
      }
    });
    t();
  }
  
  private final boolean o()
  {
    boolean bool;
    if (this.f != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private final boolean p()
  {
    boolean bool;
    if (this.g != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private final boolean q(int paramInt)
  {
    boolean bool1 = o();
    boolean bool2 = true;
    if ((!bool1) || (paramInt != getItemCount() - 1)) {
      bool2 = false;
    }
    return bool2;
  }
  
  private final boolean r(int paramInt)
  {
    boolean bool;
    if ((p()) && (paramInt == 0)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private final void t()
  {
    int i1 = 0;
    this.k = 0;
    int[] arrayOfInt = this.l;
    int i2 = arrayOfInt.length;
    while (i1 < i2)
    {
      int i3 = arrayOfInt[i1];
      i3 = g.d(this.i.get(i3));
      if (i3 > this.k) {
        this.k = i3;
      }
      i1++;
    }
  }
  
  private final void z(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder = paramViewHolder.itemView;
    j.d(paramViewHolder, "holder.itemView");
    paramViewHolder = paramViewHolder.getLayoutParams();
    if ((paramViewHolder instanceof StaggeredGridLayoutManager.LayoutParams)) {
      ((StaggeredGridLayoutManager.LayoutParams)paramViewHolder).setFullSpan(true);
    }
  }
  
  public final void A(View paramView)
  {
    View localView = this.g;
    int i1;
    if ((localView == null) && (paramView != null))
    {
      i1 = 1;
    }
    else if ((localView != null) && (paramView == null))
    {
      i1 = -1;
    }
    else
    {
      if ((localView == null) && (paramView == null)) {
        return;
      }
      i1 = 0;
    }
    this.g = paramView;
    if (i1 == 1) {
      notifyItemInserted(0);
    } else if (i1 == -1) {
      notifyItemRemoved(0);
    } else {
      notifyItemChanged(0);
    }
    if (i1 == 1) {
      this.h.setValue(Integer.valueOf(1));
    } else if (i1 == -1) {
      this.h.setValue(Integer.valueOf(0));
    }
  }
  
  public final void B(LifecycleOwner paramLifecycleOwner)
  {
    j.e(paramLifecycleOwner, "lifecycleOwner");
    this.m = paramLifecycleOwner;
  }
  
  public int getItemCount()
  {
    return p() + this.k + o();
  }
  
  public int getItemViewType(int paramInt)
  {
    if (r(paramInt)) {
      paramInt = this.e;
    } else if (q(paramInt)) {
      paramInt = this.d;
    } else {
      paramInt = super.getItemViewType(paramInt);
    }
    return paramInt;
  }
  
  public final void n()
  {
    int i1 = this.i.hashCode();
    ArrayList localArrayList = this.j;
    int i2;
    if (localArrayList != null) {
      i2 = localArrayList.hashCode();
    } else {
      i2 = 0;
    }
    if (i1 != i2)
    {
      localArrayList = this.j;
      j.c(localArrayList);
      g.f(localArrayList, this.i);
      t();
    }
  }
  
  public final void registerAdapterDataObserver(RecyclerView.AdapterDataObserver paramAdapterDataObserver)
  {
    j.e(paramAdapterDataObserver, "observer");
    super.registerAdapterDataObserver(new DislocationNotifyObserver(paramAdapterDataObserver, this.h));
  }
  
  public final void s()
  {
    Object localObject = this.i;
    ArrayList localArrayList = this.j;
    j.c(localArrayList);
    localObject = DiffUtil.calculateDiff(new DiffCallBack((ArrayList)localObject, localArrayList, this.l), true);
    j.d(localObject, "DiffUtil.calculateDiff(\n…           true\n        )");
    n();
    ((DiffUtil.DiffResult)localObject).dispatchUpdatesTo(this);
  }
  
  public void u(ViewHolder paramViewHolder, int paramInt)
  {
    j.e(paramViewHolder, "holder");
    if (r(paramInt)) {
      return;
    }
    if (q(paramInt)) {
      return;
    }
    int i1 = paramInt - p();
    if (b != -1) {
      paramViewHolder.c().setVariable(b, Integer.valueOf(i1));
    }
    paramInt = 0;
    int i2 = this.o.length;
    while (paramInt < i2)
    {
      Object localObject = this.i.get(paramInt);
      paramViewHolder.c().setVariable(this.o[paramInt], g.c(localObject, i1));
      paramInt++;
    }
    paramViewHolder.c().executePendingBindings();
  }
  
  public void v(ViewHolder paramViewHolder, int paramInt, List<Object> paramList)
  {
    j.e(paramViewHolder, "holder");
    j.e(paramList, "payloads");
    if (paramList.isEmpty())
    {
      u(paramViewHolder, paramInt);
    }
    else
    {
      int i1 = paramInt - p();
      paramInt = 0;
      paramList = paramList.get(0);
      Objects.requireNonNull(paramList, "null cannot be cast to non-null type kotlin.collections.MutableMap<*, *>");
      Map localMap = q.a(paramList);
      int i2 = this.o.length;
      while (paramInt < i2)
      {
        if (j.a(localMap.get(Integer.valueOf(paramInt)), Boolean.TRUE))
        {
          paramList = this.i.get(paramInt);
          paramViewHolder.c().setVariable(this.o[paramInt], g.c(paramList, i1));
        }
        paramInt++;
      }
      paramInt = b;
      if ((paramInt != -1) && (j.a(localMap.get(Integer.valueOf(paramInt)), Boolean.TRUE))) {
        paramViewHolder.c().setVariable(b, Integer.valueOf(i1));
      }
    }
  }
  
  public ViewHolder w(ViewGroup paramViewGroup, int paramInt)
  {
    j.e(paramViewGroup, "parent");
    if (paramInt == this.e)
    {
      if (this.g != null)
      {
        paramViewGroup = this.g;
        j.c(paramViewGroup);
        paramViewGroup = DataBindingUtil.bind(paramViewGroup);
        j.c(paramViewGroup);
        paramViewGroup = new ViewHolder(paramViewGroup);
      }
      else
      {
        throw new RuntimeException("HeaderView is Null!!");
      }
    }
    else if (paramInt == this.d)
    {
      if (this.f != null)
      {
        paramViewGroup = this.f;
        j.c(paramViewGroup);
        paramViewGroup = DataBindingUtil.bind(paramViewGroup);
        j.c(paramViewGroup);
        paramViewGroup = new ViewHolder(paramViewGroup);
      }
      else
      {
        throw new RuntimeException("FooterView is Null!!");
      }
    }
    else
    {
      paramViewGroup = DataBindingUtil.inflate(LayoutInflater.from(paramViewGroup.getContext()), this.n, paramViewGroup, false);
      j.d(paramViewGroup, "DataBindingUtil.inflate(…lse\n                    )");
      LifecycleOwner localLifecycleOwner = this.m;
      if (localLifecycleOwner != null) {
        paramViewGroup.setLifecycleOwner(localLifecycleOwner);
      }
      paramViewGroup = new ViewHolder(paramViewGroup);
    }
    if (a != -1) {
      paramViewGroup.c().setVariable(a, paramViewGroup);
    }
    return paramViewGroup;
  }
  
  public void x(ViewHolder paramViewHolder)
  {
    j.e(paramViewHolder, "holder");
    super.onViewAttachedToWindow(paramViewHolder);
    if (q(paramViewHolder.getLayoutPosition())) {
      z(paramViewHolder);
    }
  }
  
  public final void y(View paramView)
  {
    View localView = this.f;
    int i1;
    if ((localView == null) && (paramView != null)) {
      i1 = 1;
    } else if ((localView != null) && (paramView == null)) {
      i1 = -1;
    } else {
      i1 = 0;
    }
    this.f = paramView;
    if (i1 == 1) {
      notifyItemInserted(getItemCount() - 1);
    } else if (i1 == -1) {
      notifyItemRemoved(getItemCount() - 1);
    } else {
      notifyItemChanged(getItemCount() - 1);
    }
  }
  
  public static final class ViewHolder
    extends RecyclerView.ViewHolder
  {
    private final ViewDataBinding a;
    
    public ViewHolder(ViewDataBinding paramViewDataBinding)
    {
      super();
      this.a = paramViewDataBinding;
    }
    
    public final ViewDataBinding c()
    {
      return this.a;
    }
  }
  
  public static final class a
  {
    public final int a()
    {
      return DataBindingListAdapter.m();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\databinding\DataBindingListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */