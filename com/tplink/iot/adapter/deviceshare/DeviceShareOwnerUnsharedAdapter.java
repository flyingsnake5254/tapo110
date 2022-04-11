package com.tplink.iot.adapter.deviceshare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.adapter.quicksetup.f;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import java.util.List;

public class DeviceShareOwnerUnsharedAdapter
  extends RecyclerView.Adapter
{
  private Context a;
  private List<BaseALIoTDevice> b;
  private f c;
  
  public DeviceShareOwnerUnsharedAdapter(Context paramContext, List<BaseALIoTDevice> paramList)
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
  
  public void n(f paramf)
  {
    this.c = paramf;
  }
  
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder, final int paramInt)
  {
    b localb = (b)paramViewHolder;
    paramViewHolder = (BaseALIoTDevice)this.b.get(paramInt);
    localb.a.setText(l.e(this.a, paramViewHolder.getDeviceType(), paramViewHolder.getDeviceName(), paramViewHolder.getDeviceModel()));
    l.p(this.a, paramViewHolder, localb.c);
    localb.b.setText(l.b(this.a, paramViewHolder));
    localb.itemView.setOnClickListener(new a(paramInt));
  }
  
  @NonNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new b(LayoutInflater.from(this.a).inflate(2131559138, paramViewGroup, false));
  }
  
  class a
    implements View.OnClickListener
  {
    a(int paramInt) {}
    
    public void onClick(View paramView)
    {
      if (DeviceShareOwnerUnsharedAdapter.m(DeviceShareOwnerUnsharedAdapter.this) != null) {
        DeviceShareOwnerUnsharedAdapter.m(DeviceShareOwnerUnsharedAdapter.this).a(paramView, paramInt);
      }
    }
  }
  
  private class b
    extends RecyclerView.ViewHolder
  {
    TextView a;
    TextView b;
    ImageView c;
    
    b(View paramView)
    {
      super();
      this.a = ((TextView)paramView.findViewById(2131364536));
      this.b = ((TextView)paramView.findViewById(2131364515));
      this.c = ((ImageView)paramView.findViewById(2131362837));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\deviceshare\DeviceShareOwnerUnsharedAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */