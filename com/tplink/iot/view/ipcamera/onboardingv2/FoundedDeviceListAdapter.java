package com.tplink.iot.view.ipcamera.onboardingv2;

import android.app.Application;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tplink.iot.databinding.ViewFoundedDeviceItemBinding;
import com.tplink.iot.view.ipcamera.base.c;
import com.tplink.libtpnetwork.TDPNetwork.bean.TDPCameraDevice;
import com.tplink.libtpnetwork.TDPNetwork.bean.TDPIoTDevice;
import com.tplink.libtpnetwork.cameranetwork.bean.DeviceModel;
import com.tplink.tdp.bean.BaseTDPDevice;
import java.util.List;

public class FoundedDeviceListAdapter
  extends RecyclerView.Adapter
{
  private List<TDPCameraDevice> a;
  private int b;
  private Application c;
  @NonNull
  private final b d;
  
  public int getItemCount()
  {
    return this.a.size();
  }
  
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    a locala = (a)paramViewHolder;
    paramViewHolder = (TDPCameraDevice)this.a.get(paramInt);
    a.c(locala).h(new x1(this, paramViewHolder, paramInt));
    if (this.b == paramInt) {
      a.c(locala).c.setChecked(true);
    } else {
      a.c(locala).c.setChecked(false);
    }
    a.c(locala).f.setText(String.format("%s%s", new Object[] { this.c.getText(2131953312), paramViewHolder.getMac() }));
    a.c(locala).q.setText(paramViewHolder.getDeviceName());
    a.c(locala).d.setImageResource(c.f(DeviceModel.fromValue(paramViewHolder.getDeviceModel())));
  }
  
  @NonNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = (ViewFoundedDeviceItemBinding)DataBindingUtil.inflate(LayoutInflater.from(paramViewGroup.getContext()), 2131559420, paramViewGroup, false);
    a locala = new a(paramViewGroup.getRoot());
    locala.d(paramViewGroup);
    return locala;
  }
  
  static class a
    extends RecyclerView.ViewHolder
  {
    private ViewFoundedDeviceItemBinding a;
    
    public a(View paramView)
    {
      super();
    }
    
    void d(ViewFoundedDeviceItemBinding paramViewFoundedDeviceItemBinding)
    {
      this.a = paramViewFoundedDeviceItemBinding;
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(TDPCameraDevice paramTDPCameraDevice, int paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\onboardingv2\FoundedDeviceListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */