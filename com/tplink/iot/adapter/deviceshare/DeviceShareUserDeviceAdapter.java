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
import com.tplink.libtpnetwork.TPCloudNetwork.device.TCDeviceOwnerInfoBean;
import java.util.ArrayList;
import java.util.List;

public class DeviceShareUserDeviceAdapter
  extends RecyclerView.Adapter
{
  private Activity a;
  private List<BaseALIoTDevice> b;
  private d c;
  
  public DeviceShareUserDeviceAdapter(Activity paramActivity, List<BaseALIoTDevice> paramList)
  {
    this.a = paramActivity;
    this.b = paramList;
  }
  
  private void p(View paramView, final int paramInt)
  {
    Object localObject = new ArrayList();
    ((List)localObject).add(this.a.getString(2131952451).toUpperCase());
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
  
  public int getItemViewType(int paramInt)
  {
    if (((BaseALIoTDevice)this.b.get(paramInt)).isOnline()) {
      return 0;
    }
    return 1;
  }
  
  public void o(d paramd)
  {
    this.c = paramd;
  }
  
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder, final int paramInt)
  {
    e locale = (e)paramViewHolder;
    Object localObject1 = (BaseALIoTDevice)this.b.get(paramInt);
    int i = getItemViewType(paramInt);
    Object localObject2 = "";
    if (i == 0)
    {
      l.p(this.a, (BaseALIoTDevice)localObject1, locale.c);
      locale.a.setText(l.e(this.a, ((BaseALIoTDevice)localObject1).getDeviceType(), ((BaseALIoTDevice)localObject1).getDeviceName(), ((BaseALIoTDevice)localObject1).getDeviceModel()));
      paramViewHolder = (RecyclerView.ViewHolder)localObject2;
      if (((BaseALIoTDevice)localObject1).getDeviceManagerInfo() != null)
      {
        paramViewHolder = (RecyclerView.ViewHolder)localObject2;
        if (((BaseALIoTDevice)localObject1).getDeviceManagerInfo().getOwnerInfo() != null)
        {
          paramViewHolder = (RecyclerView.ViewHolder)localObject2;
          if (((BaseALIoTDevice)localObject1).getDeviceManagerInfo().getOwnerInfo().getNickname() != null) {
            paramViewHolder = ((BaseALIoTDevice)localObject1).getDeviceManagerInfo().getOwnerInfo().getNickname();
          }
        }
      }
      localObject2 = locale.b;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.a.getString(2131953934));
      ((StringBuilder)localObject1).append(" ");
      ((StringBuilder)localObject1).append(paramViewHolder);
      ((TextView)localObject2).setText(((StringBuilder)localObject1).toString());
      locale.itemView.setOnClickListener(new a(paramInt));
    }
    else
    {
      l.p(this.a, (BaseALIoTDevice)localObject1, locale.f);
      locale.d.setText(l.e(this.a, ((BaseALIoTDevice)localObject1).getDeviceType(), ((BaseALIoTDevice)localObject1).getDeviceName(), ((BaseALIoTDevice)localObject1).getDeviceModel()));
      paramViewHolder = (RecyclerView.ViewHolder)localObject2;
      if (((BaseALIoTDevice)localObject1).getDeviceManagerInfo() != null)
      {
        paramViewHolder = (RecyclerView.ViewHolder)localObject2;
        if (((BaseALIoTDevice)localObject1).getDeviceManagerInfo().getOwnerInfo() != null)
        {
          paramViewHolder = (RecyclerView.ViewHolder)localObject2;
          if (((BaseALIoTDevice)localObject1).getDeviceManagerInfo().getOwnerInfo().getNickname() != null) {
            paramViewHolder = ((BaseALIoTDevice)localObject1).getDeviceManagerInfo().getOwnerInfo().getNickname();
          }
        }
      }
      localObject1 = locale.e;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.a.getString(2131953934));
      ((StringBuilder)localObject2).append(" ");
      ((StringBuilder)localObject2).append(paramViewHolder);
      ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
      locale.f.setAlpha(0.6F);
      locale.d.setAlpha(0.6F);
      locale.e.setAlpha(0.6F);
    }
    locale.itemView.setOnLongClickListener(new b(paramInt));
  }
  
  @NonNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 0) {
      paramViewGroup = LayoutInflater.from(this.a).inflate(2131559139, paramViewGroup, false);
    } else {
      paramViewGroup = LayoutInflater.from(this.a).inflate(2131559140, paramViewGroup, false);
    }
    return new e(paramViewGroup);
  }
  
  class a
    implements View.OnClickListener
  {
    a(int paramInt) {}
    
    public void onClick(View paramView)
    {
      if (DeviceShareUserDeviceAdapter.m(DeviceShareUserDeviceAdapter.this) != null) {
        DeviceShareUserDeviceAdapter.m(DeviceShareUserDeviceAdapter.this).a(paramView, paramInt);
      }
    }
  }
  
  class b
    implements View.OnLongClickListener
  {
    b(int paramInt) {}
    
    public boolean onLongClick(View paramView)
    {
      DeviceShareUserDeviceAdapter.n(DeviceShareUserDeviceAdapter.this, paramView, paramInt);
      return true;
    }
  }
  
  class c
    implements l0.d
  {
    c(int paramInt) {}
    
    public void a(View paramView, int paramInt)
    {
      if (DeviceShareUserDeviceAdapter.m(DeviceShareUserDeviceAdapter.this) != null) {
        DeviceShareUserDeviceAdapter.m(DeviceShareUserDeviceAdapter.this).b(paramView, paramInt);
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
    ImageView c;
    TextView d;
    TextView e;
    ImageView f;
    
    e(View paramView)
    {
      super();
      this.a = ((TextView)paramView.findViewById(2131364536));
      this.b = ((TextView)paramView.findViewById(2131364515));
      this.c = ((ImageView)paramView.findViewById(2131362837));
      this.d = ((TextView)paramView.findViewById(2131364537));
      this.e = ((TextView)paramView.findViewById(2131364517));
      this.f = ((ImageView)paramView.findViewById(2131362838));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\deviceshare\DeviceShareUserDeviceAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */