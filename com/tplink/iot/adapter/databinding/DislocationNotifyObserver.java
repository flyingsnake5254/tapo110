package com.tplink.iot.adapter.databinding;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView.AdapterDataObserver;
import kotlin.jvm.internal.j;

public final class DislocationNotifyObserver
  extends RecyclerView.AdapterDataObserver
{
  private final RecyclerView.AdapterDataObserver a;
  private final MutableLiveData<Integer> b;
  
  public DislocationNotifyObserver(RecyclerView.AdapterDataObserver paramAdapterDataObserver, MutableLiveData<Integer> paramMutableLiveData)
  {
    this.a = paramAdapterDataObserver;
    this.b = paramMutableLiveData;
  }
  
  public void onChanged()
  {
    this.a.onChanged();
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2)
  {
    RecyclerView.AdapterDataObserver localAdapterDataObserver = this.a;
    Integer localInteger = (Integer)this.b.getValue();
    if (localInteger == null) {
      localInteger = Integer.valueOf(0);
    }
    j.d(localInteger, "headerItemSize.value ?: 0");
    localAdapterDataObserver.onItemRangeChanged(paramInt1 + localInteger.intValue(), paramInt2);
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
  {
    RecyclerView.AdapterDataObserver localAdapterDataObserver = this.a;
    Integer localInteger = (Integer)this.b.getValue();
    if (localInteger == null) {
      localInteger = Integer.valueOf(0);
    }
    j.d(localInteger, "headerItemSize.value\n                ?: 0");
    localAdapterDataObserver.onItemRangeChanged(paramInt1 + localInteger.intValue(), paramInt2, paramObject);
  }
  
  public void onItemRangeInserted(int paramInt1, int paramInt2)
  {
    RecyclerView.AdapterDataObserver localAdapterDataObserver = this.a;
    Integer localInteger = (Integer)this.b.getValue();
    if (localInteger == null) {
      localInteger = Integer.valueOf(0);
    }
    j.d(localInteger, "headerItemSize.value ?: 0");
    localAdapterDataObserver.onItemRangeInserted(paramInt1 + localInteger.intValue(), paramInt2);
  }
  
  public void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
  {
    RecyclerView.AdapterDataObserver localAdapterDataObserver = this.a;
    Object localObject1 = (Integer)this.b.getValue();
    Object localObject2 = Integer.valueOf(0);
    if (localObject1 == null) {
      localObject1 = localObject2;
    }
    j.d(localObject1, "headerItemSize.value\n                ?: 0");
    int i = ((Integer)localObject1).intValue();
    localObject1 = (Integer)this.b.getValue();
    if (localObject1 != null) {
      localObject2 = localObject1;
    }
    j.d(localObject2, "headerItemSize.value ?: 0");
    localAdapterDataObserver.onItemRangeMoved(paramInt1 + i, paramInt2 + ((Integer)localObject2).intValue(), paramInt3);
  }
  
  public void onItemRangeRemoved(int paramInt1, int paramInt2)
  {
    RecyclerView.AdapterDataObserver localAdapterDataObserver = this.a;
    Integer localInteger = (Integer)this.b.getValue();
    if (localInteger == null) {
      localInteger = Integer.valueOf(0);
    }
    j.d(localInteger, "headerItemSize.value ?: 0");
    localAdapterDataObserver.onItemRangeRemoved(paramInt1 + localInteger.intValue(), paramInt2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\databinding\DislocationNotifyObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */