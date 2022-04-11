package com.tplink.iot.adapter.notification;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.model.notification.DeviceNotificationBean;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import java.util.ArrayList;
import java.util.List;

public class MotionDetectionAdapter
  extends RecyclerView.Adapter
{
  private Context a;
  private b b;
  private List<DeviceNotificationBean> c = new ArrayList();
  
  public MotionDetectionAdapter(Context paramContext)
  {
    this.a = paramContext;
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
  
  public void n(List<DeviceNotificationBean> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.c.clear();
    this.c.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public void o(b paramb)
  {
    this.b = paramb;
  }
  
  public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    MotionDeviceViewHolder localMotionDeviceViewHolder = (MotionDeviceViewHolder)paramViewHolder;
    paramViewHolder = (DeviceNotificationBean)this.c.get(paramInt);
    localMotionDeviceViewHolder.mMotionDeviceNameTv.setText(l.c(this.a, paramViewHolder.getAlIoTDevice()));
    localMotionDeviceViewHolder.mDeviceLocationTv.setText(l.b(this.a, paramViewHolder.getAlIoTDevice()));
    localMotionDeviceViewHolder.mMotionSwitch.setChecked(paramViewHolder.isSubscribe());
    localMotionDeviceViewHolder.mMotionSwitch.setOnCheckedChangeListener(new a(paramViewHolder));
  }
  
  @NonNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new MotionDeviceViewHolder(LayoutInflater.from(this.a).inflate(2131559058, paramViewGroup, false));
  }
  
  class MotionDeviceViewHolder
    extends RecyclerView.ViewHolder
  {
    @BindView
    TextView mDeviceLocationTv;
    @BindView
    TextView mMotionDeviceNameTv;
    @BindView
    SwitchCompat mMotionSwitch;
    
    public MotionDeviceViewHolder(View paramView)
    {
      super();
      ButterKnife.b(this, paramView);
    }
  }
  
  class a
    implements CompoundButton.OnCheckedChangeListener
  {
    a(DeviceNotificationBean paramDeviceNotificationBean) {}
    
    public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      if (!paramCompoundButton.isPressed()) {
        return;
      }
      if ((MotionDetectionAdapter.m(MotionDetectionAdapter.this) != null) && (paramViewHolder.getAlIoTDevice() != null))
      {
        boolean bool;
        if ((paramViewHolder.getAlIoTDevice() != null) && (paramViewHolder.getAlIoTDevice().isCamera())) {
          bool = true;
        } else {
          bool = false;
        }
        MotionDetectionAdapter.m(MotionDetectionAdapter.this).u(paramCompoundButton, paramViewHolder.getAlIoTDevice().getDeviceId(), paramBoolean, bool);
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void u(CompoundButton paramCompoundButton, String paramString, boolean paramBoolean1, boolean paramBoolean2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\notification\MotionDetectionAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */