package com.tplink.iot.adapter.deviceshare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tplink.iot.Utils.z0.l;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import java.util.List;

public class DeviceShareTroubleDeviceAdapter
  extends RecyclerView.Adapter<a>
{
  private Context a;
  private List<BaseALIoTDevice> b;
  
  public DeviceShareTroubleDeviceAdapter(Context paramContext, List<BaseALIoTDevice> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
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
  
  public void m(@NonNull a parama, int paramInt)
  {
    BaseALIoTDevice localBaseALIoTDevice = (BaseALIoTDevice)this.b.get(paramInt);
    parama.a.setText(l.e(this.a, localBaseALIoTDevice.getDeviceType(), localBaseALIoTDevice.getDeviceName(), localBaseALIoTDevice.getDeviceModel()));
  }
  
  @NonNull
  public a n(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new a(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559069, paramViewGroup, false));
  }
  
  class a
    extends RecyclerView.ViewHolder
  {
    TextView a;
    
    public a(View paramView)
    {
      super();
      this.a = ((TextView)paramView.findViewById(2131362898));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\deviceshare\DeviceShareTroubleDeviceAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */