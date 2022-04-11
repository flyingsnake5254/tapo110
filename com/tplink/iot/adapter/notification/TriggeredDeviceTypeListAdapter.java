package com.tplink.iot.adapter.notification;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.enumerate.EnumIoTCategory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class TriggeredDeviceTypeListAdapter
  extends RecyclerView.Adapter
{
  private Context a;
  private c b;
  private List<a> c = new ArrayList();
  
  public TriggeredDeviceTypeListAdapter(Context paramContext)
  {
    this.a = paramContext;
  }
  
  private List<a> m(List<BaseALIoTDevice> paramList)
  {
    Object localObject1 = new ArrayList();
    Object localObject2;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      localObject2 = paramList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        paramList = (BaseALIoTDevice)((Iterator)localObject2).next();
        if ((paramList.isCamera()) && (!((List)localObject1).contains(Integer.valueOf(1)))) {
          ((List)localObject1).add(Integer.valueOf(1));
        }
        if ((paramList.isPlug()) && ((paramList instanceof ALIoTDevice)) && (((ALIoTDevice)paramList).isPlugP105OfJP())) {
          ((List)localObject1).add(Integer.valueOf(2));
        }
        if ((paramList.isSwitch()) && (!((List)localObject1).contains(Integer.valueOf(3)))) {
          ((List)localObject1).add(Integer.valueOf(3));
        }
        if ((paramList.isHub()) && (!((List)localObject1).contains(Integer.valueOf(4)))) {
          ((List)localObject1).add(Integer.valueOf(4));
        }
        if ((paramList.isSensor()) && (!((List)localObject1).contains(Integer.valueOf(5))) && (!EnumIoTCategory.SUBG_TRIGGER_BUTTON.value().equals(paramList.getCategory()))) {
          ((List)localObject1).add(Integer.valueOf(5));
        }
        if ((paramList.isEnergy()) && (!((List)localObject1).contains(Integer.valueOf(6)))) {
          ((List)localObject1).add(Integer.valueOf(6));
        }
      }
    }
    n((List)localObject1);
    Collections.sort((List)localObject1);
    paramList = new ArrayList();
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Integer)((Iterator)localObject1).next();
      paramList.add(new a(((Integer)localObject2).intValue(), o(((Integer)localObject2).intValue()), p(((Integer)localObject2).intValue())));
    }
    return paramList;
  }
  
  private void n(List<Integer> paramList)
  {
    paramList.remove(Integer.valueOf(3));
  }
  
  private static int o(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 3)
      {
        if (paramInt != 4)
        {
          if (paramInt != 5)
          {
            if (paramInt != 6) {
              return 2131689670;
            }
            return 2131690097;
          }
          return 2131690049;
        }
        return 2131690022;
      }
      return 2131690062;
    }
    return 2131689544;
  }
  
  private String p(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return this.a.getString(2131952881);
    case 6: 
      return this.a.getString(2131952884);
    case 5: 
      return this.a.getString(2131952882);
    case 4: 
      return this.a.getString(2131952874);
    case 3: 
      return this.a.getString(2131952883);
    case 2: 
      return this.a.getString(2131952881);
    }
    return this.a.getString(2131952870);
  }
  
  public int getItemCount()
  {
    List localList = this.c;
    int i;
    if (localList == null) {
      i = 0;
    } else {
      i = localList.size();
    }
    return i;
  }
  
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    b localb = (b)paramViewHolder;
    paramViewHolder = (a)this.c.get(paramInt);
    localb.a.setImageResource(paramViewHolder.b);
    localb.b.setText(paramViewHolder.c);
    localb.itemView.setOnClickListener(new a(this, paramViewHolder));
  }
  
  @NonNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new b(LayoutInflater.from(this.a).inflate(2131559027, paramViewGroup, false));
  }
  
  public void s(List<BaseALIoTDevice> paramList)
  {
    paramList = m(paramList);
    this.c.clear();
    if (!paramList.isEmpty()) {
      this.c.addAll(paramList);
    }
    notifyDataSetChanged();
  }
  
  public void t(c paramc)
  {
    this.b = paramc;
  }
  
  private static class a
  {
    int a;
    int b;
    String c;
    
    public a(int paramInt1, int paramInt2, String paramString)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramString;
    }
  }
  
  class b
    extends RecyclerView.ViewHolder
  {
    ImageView a;
    TextView b;
    
    public b(View paramView)
    {
      super();
      this.a = ((ImageView)paramView.findViewById(2131363034));
      this.b = ((TextView)paramView.findViewById(2131364416));
    }
  }
  
  public static abstract interface c
  {
    public abstract void C0(int paramInt, String paramString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\notification\TriggeredDeviceTypeListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */