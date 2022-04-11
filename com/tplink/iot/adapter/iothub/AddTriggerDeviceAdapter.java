package com.tplink.iot.adapter.iothub;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.j;

public final class AddTriggerDeviceAdapter
  extends RecyclerView.Adapter<ATDViewHolder>
{
  private final LayoutInflater a;
  private final List<BaseALIoTDevice<?>> b;
  private final List<BaseALIoTDevice<?>> c;
  private final Context d;
  
  public AddTriggerDeviceAdapter(Context paramContext)
  {
    this(paramContext, kotlin.collections.l.d(), kotlin.collections.l.d());
  }
  
  public AddTriggerDeviceAdapter(Context paramContext, List<? extends BaseALIoTDevice<?>> paramList1, List<? extends BaseALIoTDevice<?>> paramList2)
  {
    this.d = paramContext;
    this.a = LayoutInflater.from(paramContext);
    paramContext = new ArrayList();
    this.b = paramContext;
    ArrayList localArrayList = new ArrayList();
    this.c = localArrayList;
    paramContext.addAll(paramList1);
    localArrayList.addAll(paramList2);
    u();
  }
  
  private final int o(BaseALIoTDevice<?> paramBaseALIoTDevice)
  {
    return com.tplink.iot.Utils.z0.l.k(paramBaseALIoTDevice);
  }
  
  private final String p(BaseALIoTDevice<?> paramBaseALIoTDevice)
  {
    paramBaseALIoTDevice = com.tplink.iot.Utils.z0.l.e(this.d, paramBaseALIoTDevice.getDeviceType(), paramBaseALIoTDevice.getDeviceName(), paramBaseALIoTDevice.getDeviceModel());
    j.d(paramBaseALIoTDevice, "DeviceCommonUtils.getDev… deviceName, deviceModel)");
    return paramBaseALIoTDevice;
  }
  
  private final void u()
  {
    List localList = kotlin.collections.l.O(this.c, new b(this));
    Object localObject1 = this.b;
    Object localObject2 = new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject3 = ((Iterator)localObject1).next();
      BaseALIoTDevice localBaseALIoTDevice = (BaseALIoTDevice)localObject3;
      if ((this.c.contains(localBaseALIoTDevice) ^ true)) {
        ((Collection)localObject2).add(localObject3);
      }
    }
    localObject1 = kotlin.collections.l.O((Iterable)localObject2, new c(this));
    localObject2 = this.b;
    ((List)localObject2).clear();
    ((List)localObject2).addAll(localList);
    ((List)localObject2).addAll((Collection)localObject1);
  }
  
  public int getItemCount()
  {
    return this.b.size();
  }
  
  public final List<String> q()
  {
    Object localObject = this.c;
    ArrayList localArrayList = new ArrayList(kotlin.collections.l.l((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(((BaseALIoTDevice)((Iterator)localObject).next()).getDeviceId());
    }
    return localArrayList;
  }
  
  public void r(ATDViewHolder paramATDViewHolder, final int paramInt)
  {
    j.e(paramATDViewHolder, "holder");
    final BaseALIoTDevice localBaseALIoTDevice = (BaseALIoTDevice)this.b.get(paramInt);
    paramATDViewHolder = paramATDViewHolder.itemView;
    ((ImageView)paramATDViewHolder.findViewById(com.tplink.iot.a.iv_device_image)).setImageResource(o(localBaseALIoTDevice));
    Object localObject = (TextView)paramATDViewHolder.findViewById(com.tplink.iot.a.tv_device_category);
    j.d(localObject, "tv_device_category");
    ((TextView)localObject).setText(p(localBaseALIoTDevice));
    localObject = (TextView)paramATDViewHolder.findViewById(com.tplink.iot.a.tv_device_of_room);
    j.d(localObject, "tv_device_of_room");
    ((TextView)localObject).setText(com.tplink.iot.Utils.z0.l.a(localBaseALIoTDevice.getDeviceMac()));
    localObject = (ImageView)paramATDViewHolder.findViewById(com.tplink.iot.a.iv_device_select);
    int i;
    if (this.c.contains(localBaseALIoTDevice)) {
      i = 2131690317;
    } else {
      i = 2131690316;
    }
    ((ImageView)localObject).setImageResource(i);
    paramATDViewHolder.setOnClickListener(new a(this, localBaseALIoTDevice, paramInt));
  }
  
  public ATDViewHolder s(ViewGroup paramViewGroup, int paramInt)
  {
    j.e(paramViewGroup, "parent");
    paramViewGroup = this.a.inflate(2131559016, paramViewGroup, false);
    j.d(paramViewGroup, "mLayoutInflater.inflate(…em_device, parent, false)");
    return new ATDViewHolder(paramViewGroup);
  }
  
  public final void t(List<? extends BaseALIoTDevice<?>> paramList1, List<? extends BaseALIoTDevice<?>> paramList2)
  {
    j.e(paramList1, "list");
    j.e(paramList2, "originSelectedDeviceList");
    List localList = this.c;
    localList.clear();
    localList.addAll(paramList2);
    paramList2 = this.b;
    paramList2.clear();
    paramList2.addAll(paramList1);
    u();
    notifyDataSetChanged();
  }
  
  public static final class ATDViewHolder
    extends RecyclerView.ViewHolder
  {
    public ATDViewHolder(View paramView)
    {
      super();
    }
  }
  
  static final class a
    implements View.OnClickListener
  {
    a(AddTriggerDeviceAdapter paramAddTriggerDeviceAdapter, BaseALIoTDevice paramBaseALIoTDevice, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      if (AddTriggerDeviceAdapter.m(this.c).contains(localBaseALIoTDevice)) {
        AddTriggerDeviceAdapter.m(this.c).remove(localBaseALIoTDevice);
      } else {
        AddTriggerDeviceAdapter.m(this.c).add(localBaseALIoTDevice);
      }
      this.c.notifyItemChanged(paramInt);
    }
  }
  
  public static final class b<T>
    implements Comparator<T>
  {
    public b(AddTriggerDeviceAdapter paramAddTriggerDeviceAdapter) {}
    
    public final int compare(T paramT1, T paramT2)
    {
      paramT1 = (BaseALIoTDevice)paramT1;
      paramT1 = AddTriggerDeviceAdapter.n(this.c, paramT1);
      paramT2 = (BaseALIoTDevice)paramT2;
      return kotlin.q.a.a(paramT1, AddTriggerDeviceAdapter.n(this.c, paramT2));
    }
  }
  
  public static final class c<T>
    implements Comparator<T>
  {
    public c(AddTriggerDeviceAdapter paramAddTriggerDeviceAdapter) {}
    
    public final int compare(T paramT1, T paramT2)
    {
      paramT1 = (BaseALIoTDevice)paramT1;
      paramT1 = AddTriggerDeviceAdapter.n(this.c, paramT1);
      paramT2 = (BaseALIoTDevice)paramT2;
      return kotlin.q.a.a(paramT1, AddTriggerDeviceAdapter.n(this.c, paramT2));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\iothub\AddTriggerDeviceAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */