package com.tplink.iot.adapter.deviceshare;

import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tplink.iot.Utils.l0;
import com.tplink.iot.Utils.l0.d;
import com.tplink.iot.Utils.z0.l;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.device.DeviceManagerInfoBean;
import java.util.ArrayList;
import java.util.List;

public class DeviceShareOwnerSharedAdapter
  extends RecyclerView.Adapter
{
  private Activity a;
  private List<BaseALIoTDevice> b;
  private d c;
  
  public DeviceShareOwnerSharedAdapter(Activity paramActivity, List<BaseALIoTDevice> paramList)
  {
    this.a = paramActivity;
    this.b = paramList;
  }
  
  private void p(View paramView, final int paramInt)
  {
    Object localObject = new ArrayList();
    ((List)localObject).add(this.a.getString(2131953919).toUpperCase());
    localObject = new l0(this.a, (List)localObject);
    ((PopupWindow)localObject).setAnimationStyle(2132018155);
    ((l0)localObject).g(this.a.getResources().getColor(2131099744));
    ((l0)localObject).f(new c(paramInt));
    ((l0)localObject).i(paramView);
  }
  
  public int getItemCount()
  {
    List localList = this.b;
    int i;
    if (localList == null) {
      i = 0;
    } else {
      i = localList.size();
    }
    return i;
  }
  
  public void o(d paramd)
  {
    this.c = paramd;
  }
  
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder, final int paramInt)
  {
    e locale = (e)paramViewHolder;
    Object localObject = (BaseALIoTDevice)this.b.get(paramInt);
    locale.a.setText(l.e(this.a, ((BaseALIoTDevice)localObject).getDeviceType(), ((BaseALIoTDevice)localObject).getDeviceName(), ((BaseALIoTDevice)localObject).getDeviceModel()));
    l.p(this.a, (BaseALIoTDevice)localObject, locale.d);
    locale.b.setText(l.b(this.a, (BaseALIoTDevice)localObject));
    boolean bool = ((BaseALIoTDevice)localObject).isHasThingOrCloudDevice();
    paramViewHolder = "";
    if (bool)
    {
      int i = 0;
      int j = i;
      if (((BaseALIoTDevice)localObject).getDeviceManagerInfo() != null)
      {
        j = i;
        if (((BaseALIoTDevice)localObject).getDeviceManagerInfo().getUserInfo() != null) {
          j = ((BaseALIoTDevice)localObject).getDeviceManagerInfo().getUserInfo().size() - 1;
        }
      }
      localObject = locale.c;
      if (j > 0)
      {
        paramViewHolder = new StringBuilder();
        paramViewHolder.append(j);
        paramViewHolder.append("");
        paramViewHolder = paramViewHolder.toString();
      }
      ((TextView)localObject).setText(paramViewHolder);
    }
    else
    {
      locale.c.setText("");
    }
    locale.itemView.setOnLongClickListener(new a(paramInt));
    locale.itemView.setOnClickListener(new b(paramInt));
  }
  
  @NonNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new e(LayoutInflater.from(this.a).inflate(2131559137, paramViewGroup, false));
  }
  
  class a
    implements View.OnLongClickListener
  {
    a(int paramInt) {}
    
    public boolean onLongClick(View paramView)
    {
      DeviceShareOwnerSharedAdapter.m(DeviceShareOwnerSharedAdapter.this, paramView, paramInt);
      return true;
    }
  }
  
  class b
    implements View.OnClickListener
  {
    b(int paramInt) {}
    
    public void onClick(View paramView)
    {
      if (DeviceShareOwnerSharedAdapter.n(DeviceShareOwnerSharedAdapter.this) != null) {
        DeviceShareOwnerSharedAdapter.n(DeviceShareOwnerSharedAdapter.this).a(paramView, paramInt);
      }
    }
  }
  
  class c
    implements l0.d
  {
    c(int paramInt) {}
    
    public void a(View paramView, int paramInt)
    {
      if (DeviceShareOwnerSharedAdapter.n(DeviceShareOwnerSharedAdapter.this) != null) {
        DeviceShareOwnerSharedAdapter.n(DeviceShareOwnerSharedAdapter.this).b(paramView, paramInt);
      }
    }
  }
  
  public static abstract interface d
  {
    public abstract void a(View paramView, int paramInt);
    
    public abstract void b(View paramView, int paramInt);
  }
  
  private class e
    extends RecyclerView.ViewHolder
  {
    TextView a;
    TextView b;
    TextView c;
    ImageView d;
    
    e(View paramView)
    {
      super();
      this.a = ((TextView)paramView.findViewById(2131364536));
      this.b = ((TextView)paramView.findViewById(2131364515));
      this.c = ((TextView)paramView.findViewById(2131364573));
      this.d = ((ImageView)paramView.findViewById(2131362837));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\deviceshare\DeviceShareOwnerSharedAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */