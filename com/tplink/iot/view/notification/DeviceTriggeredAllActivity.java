package com.tplink.iot.view.notification;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.tplink.iot.adapter.notification.TriggeredDeviceTypeListAdapter;
import com.tplink.iot.adapter.notification.TriggeredDeviceTypeListAdapter.c;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.viewmodel.notification.MessagePushViewModel;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import java.util.List;

public class DeviceTriggeredAllActivity
  extends BaseActivity
  implements TriggeredDeviceTypeListAdapter.c
{
  private RecyclerView p0;
  private TriggeredDeviceTypeListAdapter p1;
  private MessagePushViewModel y;
  private TextView z;
  
  private void h1()
  {
    b1(2131953223);
    this.z = ((TextView)findViewById(2131364547));
    Object localObject = (RecyclerView)findViewById(2131363820);
    this.p0 = ((RecyclerView)localObject);
    ((RecyclerView)localObject).setLayoutManager(new LinearLayoutManager(this));
    localObject = new TriggeredDeviceTypeListAdapter(this);
    this.p1 = ((TriggeredDeviceTypeListAdapter)localObject);
    this.p0.setAdapter((RecyclerView.Adapter)localObject);
    this.p1.t(this);
  }
  
  private void i1()
  {
    this.y.g().observe(this, new a());
  }
  
  public void C0(int paramInt, String paramString)
  {
    Intent localIntent = new Intent(this, TriggeredDeviceTypeActivity.class);
    localIntent.putExtra("device_type", paramInt);
    localIntent.putExtra("device_type_name", paramString);
    startActivity(localIntent);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558509);
    this.y = ((MessagePushViewModel)ViewModelProviders.of(this).get(MessagePushViewModel.class));
    h1();
    i1();
  }
  
  class a
    implements Observer<List<BaseALIoTDevice>>
  {
    a() {}
    
    public void a(@Nullable List<BaseALIoTDevice> paramList)
    {
      if ((paramList != null) && (paramList.size() != 0))
      {
        DeviceTriggeredAllActivity.f1(DeviceTriggeredAllActivity.this).setVisibility(8);
        DeviceTriggeredAllActivity.e1(DeviceTriggeredAllActivity.this).setVisibility(0);
        DeviceTriggeredAllActivity.g1(DeviceTriggeredAllActivity.this).s(paramList);
      }
      else
      {
        DeviceTriggeredAllActivity.e1(DeviceTriggeredAllActivity.this).setVisibility(8);
        DeviceTriggeredAllActivity.f1(DeviceTriggeredAllActivity.this).setVisibility(0);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\notification\DeviceTriggeredAllActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */