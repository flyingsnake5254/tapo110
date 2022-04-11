package com.tplink.iot.adapter.quicksetup;

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
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.TDPNetwork.bean.TDPCameraDevice;
import com.tplink.libtpnetwork.TDPNetwork.bean.TDPIoTDevice;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import com.tplink.tdp.bean.BaseTDPDevice;
import java.util.ArrayList;
import java.util.List;

public class DiscoveryDevicesAdapter
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private List<d> a = new ArrayList();
  private b b;
  
  public int getItemCount()
  {
    return this.a.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    return ((d)this.a.get(paramInt)).c();
  }
  
  public void n(b paramb)
  {
    this.b = paramb;
  }
  
  public void o(@NonNull List<d> paramList)
  {
    this.a.clear();
    this.a.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder instanceof c)) {
      ((c)paramViewHolder).c((d)this.a.get(paramInt));
    } else if ((paramViewHolder instanceof a)) {
      ((a)paramViewHolder).c((d)this.a.get(paramInt));
    }
  }
  
  @NonNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 1) {
      return new a(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559028, paramViewGroup, false));
    }
    return new c(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559052, paramViewGroup, false));
  }
  
  class a
    extends RecyclerView.ViewHolder
  {
    private final ImageView a;
    private final TextView b;
    private final TextView c;
    private final ImageView d;
    
    public a(View paramView)
    {
      super();
      this.a = ((ImageView)paramView.findViewById(2131363028));
      this.b = ((TextView)paramView.findViewById(2131364407));
      this.c = ((TextView)paramView.findViewById(2131364412));
      this.d = ((ImageView)paramView.findViewById(2131363030));
    }
    
    public void c(d paramd)
    {
      Object localObject;
      if ((paramd.a() instanceof TDPCameraDevice)) {
        localObject = new ALCameraDevice((TDPCameraDevice)paramd.a());
      } else {
        localObject = new ALIoTDevice(paramd.a());
      }
      l.o(this.a.getContext(), (BaseALIoTDevice)localObject, this.a);
      if (paramd.a() != null)
      {
        this.b.setText(paramd.a().getDeviceModel());
        this.c.setText(String.format("%s%s", new Object[] { this.b.getContext().getString(2131953312), paramd.a().getMac() }));
      }
      else
      {
        this.b.setText("");
        this.c.setText("");
      }
      if (paramd.a() != null) {
        this.d.setOnClickListener(new a(this, paramd));
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void I0(@NonNull TDPIoTDevice paramTDPIoTDevice);
  }
  
  class c
    extends RecyclerView.ViewHolder
  {
    private final TextView a;
    
    public c(View paramView)
    {
      super();
      this.a = ((TextView)paramView.findViewById(2131364688));
    }
    
    public void c(d paramd)
    {
      this.a.setText(paramd.b());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\quicksetup\DiscoveryDevicesAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */