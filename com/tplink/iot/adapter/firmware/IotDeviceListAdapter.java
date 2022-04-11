package com.tplink.iot.adapter.firmware;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.model.firmware.t;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import java.util.List;

public class IotDeviceListAdapter
  extends RecyclerView.Adapter<a>
{
  private Context a;
  private List<t> b;
  
  public IotDeviceListAdapter(Context paramContext, List<t> paramList)
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
    t localt = (t)this.b.get(paramInt);
    BaseALIoTDevice localBaseALIoTDevice = localt.d();
    if (localBaseALIoTDevice != null)
    {
      parama.b.setText(l.e(this.a, localBaseALIoTDevice.getDeviceType(), localt.e(), localBaseALIoTDevice.getDeviceModel()));
      l.o(this.a, localBaseALIoTDevice, parama.a);
      parama.c.setText(l.b(this.a, localBaseALIoTDevice));
    }
  }
  
  @NonNull
  public a n(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new a(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559033, paramViewGroup, false));
  }
  
  public void o(List<t> paramList)
  {
    this.b = paramList;
    notifyDataSetChanged();
  }
  
  class a
    extends RecyclerView.ViewHolder
  {
    ImageView a;
    TextView b;
    TextView c;
    
    public a(View paramView)
    {
      super();
      this.a = ((ImageView)paramView.findViewById(2131362877));
      this.b = ((TextView)paramView.findViewById(2131362879));
      this.c = ((TextView)paramView.findViewById(2131362878));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\firmware\IotDeviceListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */