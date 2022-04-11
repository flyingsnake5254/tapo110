package com.tplink.iot.adapter.smart;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.Utils.z0.n;
import com.tplink.iot.cloud.bean.thing.common.ThingInfo;
import com.tplink.iot.model.smart.h;
import com.tplink.iot.view.smart.a.a;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.enumerate.EnumIoTCategory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SmartDeviceTriggerAdapter
  extends RecyclerView.Adapter
{
  private List<h> a = new ArrayList();
  private Context b;
  private b c;
  
  public SmartDeviceTriggerAdapter(Context paramContext)
  {
    this.b = paramContext;
  }
  
  public int getItemCount()
  {
    List localList = this.a;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    return ((h)this.a.get(paramInt)).c();
  }
  
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    ((a)paramViewHolder).c(paramInt);
  }
  
  @NonNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 0) {
      paramViewGroup = new c(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559425, paramViewGroup, false));
    } else {
      paramViewGroup = new d(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559217, paramViewGroup, false));
    }
    return paramViewGroup;
  }
  
  public void p(List<BaseALIoTDevice> paramList)
  {
    this.a.clear();
    HashMap localHashMap = new HashMap();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        BaseALIoTDevice localBaseALIoTDevice = (BaseALIoTDevice)localIterator.next();
        String str = localBaseALIoTDevice.getCategory();
        EnumIoTCategory localEnumIoTCategory = EnumIoTCategory.fromString(str);
        if ((str != null) && (localEnumIoTCategory != null))
        {
          localObject = (List)localHashMap.get(str);
          paramList = (List<BaseALIoTDevice>)localObject;
          if (localObject == null)
          {
            paramList = new ArrayList();
            paramList.add(new h(n.d(localEnumIoTCategory), 1));
            localHashMap.put(str, paramList);
          }
          paramList.add(new h(localBaseALIoTDevice, 0));
        }
      }
      Object localObject = a.b.iterator();
      while (((Iterator)localObject).hasNext())
      {
        paramList = (List)localHashMap.get((String)((Iterator)localObject).next());
        if (paramList != null) {
          this.a.addAll(paramList);
        }
      }
    }
    notifyDataSetChanged();
  }
  
  public void q(b paramb)
  {
    this.c = paramb;
  }
  
  private abstract class a
    extends RecyclerView.ViewHolder
  {
    a(View paramView)
    {
      super();
    }
    
    public abstract void c(int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract void l0(ThingInfo paramThingInfo);
  }
  
  private class c
    extends SmartDeviceTriggerAdapter.a
  {
    private RelativeLayout b;
    private ImageView c;
    private TextView d;
    private TextView e;
    private View f;
    
    c(View paramView)
    {
      super(paramView);
      this.b = ((RelativeLayout)paramView.findViewById(2131363905));
      this.c = ((ImageView)paramView.findViewById(2131363073));
      this.d = ((TextView)paramView.findViewById(2131362988));
      this.e = ((TextView)paramView.findViewById(2131362926));
      this.f = paramView.findViewById(2131362020);
    }
    
    private void f(String paramString)
    {
      if (!TextUtils.isEmpty(paramString))
      {
        this.e.setText(paramString);
        this.e.setVisibility(0);
      }
      else
      {
        this.e.setText("");
        this.e.setVisibility(8);
      }
    }
    
    public void c(int paramInt)
    {
      BaseALIoTDevice localBaseALIoTDevice = ((h)SmartDeviceTriggerAdapter.m(SmartDeviceTriggerAdapter.this).get(paramInt)).a();
      if (localBaseALIoTDevice != null)
      {
        this.d.setText(l.e(SmartDeviceTriggerAdapter.n(SmartDeviceTriggerAdapter.this), localBaseALIoTDevice.getDeviceType(), localBaseALIoTDevice.getDeviceName(), localBaseALIoTDevice.getDeviceModel()));
        l.o(SmartDeviceTriggerAdapter.n(SmartDeviceTriggerAdapter.this), localBaseALIoTDevice, this.c);
        f(l.b(SmartDeviceTriggerAdapter.n(SmartDeviceTriggerAdapter.this), localBaseALIoTDevice));
      }
      View localView = this.f;
      paramInt++;
      if ((paramInt < SmartDeviceTriggerAdapter.m(SmartDeviceTriggerAdapter.this).size()) && (((h)SmartDeviceTriggerAdapter.m(SmartDeviceTriggerAdapter.this).get(paramInt)).c() == 1)) {
        paramInt = 8;
      } else {
        paramInt = 0;
      }
      localView.setVisibility(paramInt);
      this.b.setOnClickListener(new j(this, localBaseALIoTDevice));
    }
  }
  
  private class d
    extends SmartDeviceTriggerAdapter.a
  {
    private TextView b;
    
    d(View paramView)
    {
      super(paramView);
      this.b = ((TextView)paramView.findViewById(2131364636));
    }
    
    public void c(int paramInt)
    {
      this.b.setText(((h)SmartDeviceTriggerAdapter.m(SmartDeviceTriggerAdapter.this).get(paramInt)).b());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\smart\SmartDeviceTriggerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */