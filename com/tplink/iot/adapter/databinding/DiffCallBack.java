package com.tplink.iot.adapter.databinding;

import androidx.collection.ArrayMap;
import androidx.recyclerview.widget.DiffUtil.Callback;
import b.d.w.c.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.collections.e;
import kotlin.jvm.internal.j;

public final class DiffCallBack
  extends DiffUtil.Callback
{
  private final String a;
  private int b;
  private int c;
  private final ArrayList<?> d;
  private final ArrayList<?> e;
  private final int[] f;
  private final ArrayList<?> g;
  private final int[] h;
  
  public DiffCallBack(ArrayList<?> paramArrayList1, ArrayList<?> paramArrayList2, int[] paramArrayOfInt)
  {
    this.g = paramArrayList2;
    this.h = paramArrayOfInt;
    this.a = DiffCallBack.class.getSimpleName();
    paramArrayOfInt = new ArrayList();
    this.d = paramArrayOfInt;
    g.f(paramArrayList1, paramArrayOfInt);
    paramArrayList1 = new ArrayList();
    this.e = paramArrayList1;
    g.f(paramArrayList2, paramArrayList1);
    paramArrayList1 = paramArrayOfInt.iterator();
    while (paramArrayList1.hasNext())
    {
      i = g.d(paramArrayList1.next());
      if (i > this.b) {
        this.b = i;
      }
    }
    paramArrayList1 = this.e.iterator();
    while (paramArrayList1.hasNext())
    {
      i = g.d(paramArrayList1.next());
      if (i > this.c) {
        this.c = i;
      }
    }
    paramArrayList1 = new int[this.e.size() - this.h.length];
    this.f = paramArrayList1;
    int i = paramArrayList1.length;
    int j = 0;
    if (i == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i ^ 0x1) != 0)
    {
      int k = this.e.size();
      int m = 0;
      i = j;
      while (i < k)
      {
        j = m;
        if (!e.i(this.h, i))
        {
          this.f[m] = i;
          j = m + 1;
        }
        i++;
        m = j;
      }
    }
  }
  
  public boolean areContentsTheSame(int paramInt1, int paramInt2)
  {
    if (paramInt1 != paramInt2) {
      return false;
    }
    for (int k : this.f)
    {
      Object localObject2 = this.d.get(k);
      localObject3 = this.e.get(k);
      localObject2 = g.c(localObject2, paramInt1);
      if ((true ^ j.a(g.c(localObject3, paramInt2), localObject2)))
      {
        localObject3 = this.a;
        ??? = new StringBuilder();
        ((StringBuilder)???).append("areContentsTheSame(");
        ((StringBuilder)???).append(paramInt1);
        ((StringBuilder)???).append(", ");
        ((StringBuilder)???).append(paramInt2);
        ((StringBuilder)???).append("):false");
        a.c((String)localObject3, ((StringBuilder)???).toString());
        return false;
      }
    }
    ??? = this.a;
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("areContentsTheSame(");
    ((StringBuilder)localObject3).append(paramInt1);
    ((StringBuilder)localObject3).append(", ");
    ((StringBuilder)localObject3).append(paramInt2);
    ((StringBuilder)localObject3).append("):true");
    a.c((String)???, ((StringBuilder)localObject3).toString());
    return true;
  }
  
  public boolean areItemsTheSame(int paramInt1, int paramInt2)
  {
    for (int k : this.h)
    {
      Object localObject2 = this.d.get(k);
      localObject3 = this.e.get(k);
      localObject2 = g.c(localObject2, paramInt1);
      if ((true ^ j.a(g.c(localObject3, paramInt2), localObject2)))
      {
        ??? = this.a;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("areItemsTheSame(");
        ((StringBuilder)localObject3).append(paramInt1);
        ((StringBuilder)localObject3).append(", ");
        ((StringBuilder)localObject3).append(paramInt2);
        ((StringBuilder)localObject3).append("):false");
        a.c((String)???, ((StringBuilder)localObject3).toString());
        return false;
      }
    }
    Object localObject3 = this.a;
    ??? = new StringBuilder();
    ((StringBuilder)???).append("areItemsTheSame(");
    ((StringBuilder)???).append(paramInt1);
    ((StringBuilder)???).append(", ");
    ((StringBuilder)???).append(paramInt2);
    ((StringBuilder)???).append("):true");
    a.c((String)localObject3, ((StringBuilder)???).toString());
    return true;
  }
  
  public Object getChangePayload(int paramInt1, int paramInt2)
  {
    ArrayMap localArrayMap = new ArrayMap();
    Object localObject1 = DataBindingListAdapter.c;
    if ((((DataBindingListAdapter.a)localObject1).a() != -1) && (paramInt1 != paramInt2)) {
      localArrayMap.put(Integer.valueOf(((DataBindingListAdapter.a)localObject1).a()), Boolean.TRUE);
    }
    for (int k : this.f)
    {
      Object localObject2 = this.d.get(k);
      Object localObject3 = this.e.get(k);
      localObject2 = g.c(localObject2, paramInt1);
      if ((j.a(g.c(localObject3, paramInt2), localObject2) ^ true)) {
        localArrayMap.put(Integer.valueOf(k), Boolean.TRUE);
      }
    }
    return localArrayMap;
  }
  
  public int getNewListSize()
  {
    return this.c;
  }
  
  public int getOldListSize()
  {
    return this.b;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\databinding\DiffCallBack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */