package com.tplink.iot.adapter.group;

import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.widget.RippleCardView;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import java.util.ArrayList;
import java.util.List;

public class DeviceAdapter
  extends RecyclerView.Adapter
{
  private Activity a;
  private List<BaseALIoTDevice> b = new ArrayList();
  
  public DeviceAdapter(Activity paramActivity)
  {
    this.a = paramActivity;
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
  
  public void n(List<BaseALIoTDevice> paramList)
  {
    this.b.clear();
    if (paramList != null) {
      this.b.addAll(paramList);
    }
    notifyDataSetChanged();
  }
  
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    ((a)paramViewHolder).c((BaseALIoTDevice)this.b.get(paramInt), paramInt);
  }
  
  @NonNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new a(LayoutInflater.from(this.a).inflate(2131559020, paramViewGroup, false));
  }
  
  private class a
    extends RecyclerView.ViewHolder
  {
    RippleCardView a;
    TextView b;
    TextView c;
    ImageView d;
    ImageView e;
    
    a(View paramView)
    {
      super();
      this.a = ((RippleCardView)paramView.findViewById(2131362351));
      this.b = ((TextView)paramView.findViewById(2131364409));
      this.c = ((TextView)paramView.findViewById(2131364484));
      this.d = ((ImageView)paramView.findViewById(2131363066));
      this.e = ((ImageView)paramView.findViewById(2131363031));
    }
    
    public void c(BaseALIoTDevice paramBaseALIoTDevice, int paramInt)
    {
      this.b.setText(l.e(DeviceAdapter.m(DeviceAdapter.this), paramBaseALIoTDevice.getDeviceType(), paramBaseALIoTDevice.getDeviceName(), paramBaseALIoTDevice.getDeviceModel()));
      l.o(DeviceAdapter.m(DeviceAdapter.this), paramBaseALIoTDevice, this.d);
      this.c.setText(l.b(DeviceAdapter.m(DeviceAdapter.this), paramBaseALIoTDevice));
      this.e.setImageResource(2131689712);
      ImageView localImageView = this.e;
      if (paramBaseALIoTDevice.isUserRoleTypeDevice()) {
        paramInt = 0;
      } else {
        paramInt = 4;
      }
      localImageView.setVisibility(paramInt);
      this.a.setCardElevation(0.0F);
      this.a.setCardBackgroundColor(DeviceAdapter.m(DeviceAdapter.this).getResources().getColor(2131099743));
      this.b.setTextColor(DeviceAdapter.m(DeviceAdapter.this).getResources().getColor(2131099756));
      this.c.setTextColor(DeviceAdapter.m(DeviceAdapter.this).getResources().getColor(2131099756));
      this.b.setCompoundDrawablesWithIntrinsicBounds(null, null, DeviceAdapter.m(DeviceAdapter.this).getResources().getDrawable(2131689680), null);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\group\DeviceAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */