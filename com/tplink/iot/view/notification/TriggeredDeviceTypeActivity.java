package com.tplink.iot.view.notification;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ItemDecoration;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.tplink.iot.Utils.x0.q;
import com.tplink.iot.adapter.home.HomeSpaceItemDecoration;
import com.tplink.iot.adapter.notification.MotionDetectionAdapter;
import com.tplink.iot.adapter.notification.MotionDetectionAdapter.b;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.view.ipcamera.setting.NotificationCloseDialog;
import com.tplink.iot.view.ipcamera.setting.NotificationCloseDialog.a;
import com.tplink.iot.viewmodel.notification.MessagePushViewModel;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.enumerate.EnumMsgSubscribeType;
import java.util.List;

public class TriggeredDeviceTypeActivity
  extends BaseActivity
  implements MotionDetectionAdapter.b
{
  @BindView
  RecyclerView mMotionDetectionDeviceRV;
  @BindView
  TextView mNoMotionDeviceTv;
  @BindView
  TextView mToolbarTitle;
  private int p0;
  private String p1;
  private MotionDetectionAdapter y;
  private MessagePushViewModel z;
  
  private boolean h1()
  {
    return NotificationManagerCompat.from(this).areNotificationsEnabled();
  }
  
  private void i1()
  {
    Intent localIntent = getIntent();
    if (localIntent != null)
    {
      this.p0 = localIntent.getIntExtra("device_type", 0);
      this.p1 = localIntent.getStringExtra("device_type_name");
    }
  }
  
  private void j1()
  {
    Object localObject = this.p1;
    if (localObject != null) {
      this.mToolbarTitle.setText((CharSequence)localObject);
    }
    localObject = new HomeSpaceItemDecoration(this);
    this.mMotionDetectionDeviceRV.addItemDecoration((RecyclerView.ItemDecoration)localObject);
    localObject = new LinearLayoutManager(this);
    ((LinearLayoutManager)localObject).setOrientation(1);
    this.mMotionDetectionDeviceRV.setLayoutManager((RecyclerView.LayoutManager)localObject);
    localObject = new MotionDetectionAdapter(this);
    this.y = ((MotionDetectionAdapter)localObject);
    this.mMotionDetectionDeviceRV.setAdapter((RecyclerView.Adapter)localObject);
    this.y.o(this);
  }
  
  private void k1()
  {
    NotificationCloseDialog localNotificationCloseDialog = new NotificationCloseDialog();
    localNotificationCloseDialog.H0(new b());
    localNotificationCloseDialog.show(getSupportFragmentManager(), "");
  }
  
  private void l1()
  {
    this.z.g().observe(this, new a());
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558692);
    ButterKnife.a(this);
    this.z = ((MessagePushViewModel)ViewModelProviders.of(this).get(MessagePushViewModel.class));
    i1();
    j1();
    l1();
  }
  
  public void u(CompoundButton paramCompoundButton, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramString == null) {
      return;
    }
    if ((paramBoolean1) && (!h1()))
    {
      paramCompoundButton.setChecked(false);
      k1();
      return;
    }
    this.z.w(paramString, EnumMsgSubscribeType.CAMERA_MOTION, paramBoolean1, paramBoolean2);
    q.n(paramBoolean1, "DeviceTriggered");
  }
  
  class a
    implements Observer<List<BaseALIoTDevice>>
  {
    a() {}
    
    public void a(@Nullable List<BaseALIoTDevice> paramList)
    {
      if ((paramList != null) && (paramList.size() != 0))
      {
        paramList = TriggeredDeviceTypeActivity.f1(TriggeredDeviceTypeActivity.this).y(TriggeredDeviceTypeActivity.f1(TriggeredDeviceTypeActivity.this).i(paramList, TriggeredDeviceTypeActivity.e1(TriggeredDeviceTypeActivity.this)));
        if ((paramList != null) && (paramList.size() > 0))
        {
          TriggeredDeviceTypeActivity.this.mNoMotionDeviceTv.setVisibility(8);
          TriggeredDeviceTypeActivity.this.mMotionDetectionDeviceRV.setVisibility(0);
          TriggeredDeviceTypeActivity.g1(TriggeredDeviceTypeActivity.this).n(paramList);
        }
        else
        {
          TriggeredDeviceTypeActivity.this.mMotionDetectionDeviceRV.setVisibility(8);
          TriggeredDeviceTypeActivity.this.mNoMotionDeviceTv.setVisibility(0);
        }
      }
      else
      {
        TriggeredDeviceTypeActivity.this.mMotionDetectionDeviceRV.setVisibility(8);
        TriggeredDeviceTypeActivity.this.mNoMotionDeviceTv.setVisibility(0);
      }
    }
  }
  
  class b
    implements NotificationCloseDialog.a
  {
    b() {}
    
    public void a() {}
    
    public void b()
    {
      try
      {
        Intent localIntent1 = new android/content/Intent;
        localIntent1.<init>();
        localIntent1.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
        localIntent1.putExtra("android.provider.extra.APP_PACKAGE", TriggeredDeviceTypeActivity.this.getPackageName());
        localIntent1.putExtra("android.intent.extra.CHANNEL_ID", TriggeredDeviceTypeActivity.this.getApplicationInfo().uid);
        localIntent1.putExtra("app_package", TriggeredDeviceTypeActivity.this.getPackageName());
        localIntent1.putExtra("app_uid", TriggeredDeviceTypeActivity.this.getApplicationInfo().uid);
        if ("MI 6".equals(Build.MODEL))
        {
          localIntent1.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
          localIntent1.setData(Uri.fromParts("package", TriggeredDeviceTypeActivity.this.getPackageName(), null));
        }
        TriggeredDeviceTypeActivity.this.startActivity(localIntent1);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        Intent localIntent2 = new Intent();
        localIntent2.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        localIntent2.setData(Uri.fromParts("package", TriggeredDeviceTypeActivity.this.getPackageName(), null));
        TriggeredDeviceTypeActivity.this.startActivity(localIntent2);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\notification\TriggeredDeviceTypeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */