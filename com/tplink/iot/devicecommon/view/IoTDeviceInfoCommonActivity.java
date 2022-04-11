package com.tplink.iot.devicecommon.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityBaseIotDeviceInfoBinding;
import com.tplink.iot.devicecommon.viewmodel.IoTDeviceInfoCommonViewModel;
import com.tplink.iot.view.iotcommon.DebugFwUpdateActivity;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.widget.ItemSettingLayout;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.IoTSubDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice<*>;
import kotlin.f;
import kotlin.h;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlin.text.m;

public final class IoTDeviceInfoCommonActivity
  extends BaseActivity
{
  private final f p0 = h.b(new c(this));
  private BaseALIoTDevice<?> p1;
  private final f p2 = h.b(new b(this));
  private boolean p3;
  private ActivityBaseIotDeviceInfoBinding y;
  private String z = "";
  
  private final TextView m1()
  {
    return (TextView)this.p2.getValue();
  }
  
  private final IoTDeviceInfoCommonViewModel n1()
  {
    return (IoTDeviceInfoCommonViewModel)this.p0.getValue();
  }
  
  private final void o1()
  {
    Object localObject = getIntent();
    if (localObject != null)
    {
      localObject = ((Intent)localObject).getStringExtra("device_id_md5");
      if (localObject != null) {}
    }
    else
    {
      localObject = "";
    }
    this.z = ((String)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("IoTDeviceInfo mDeviceIdMD5: ");
    ((StringBuilder)localObject).append(this.z);
    b.d.w.c.a.m(((StringBuilder)localObject).toString());
  }
  
  private final void p1()
  {
    ViewDataBinding localViewDataBinding = DataBindingUtil.setContentView(this, 2131558454);
    j.d(localViewDataBinding, "DataBindingUtil.setConte…ity_base_iot_device_info)");
    this.y = ((ActivityBaseIotDeviceInfoBinding)localViewDataBinding);
  }
  
  private final void q1()
  {
    c1(getString(2131952537));
    m1().setVisibility(0);
    m1().setOnClickListener(new a(this));
  }
  
  private final boolean r1()
  {
    return j.a("playstore", "trial");
  }
  
  private final void s1(ItemSettingLayout paramItemSettingLayout, String paramString)
  {
    int i;
    if ((paramString != null) && (paramString.length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      paramItemSettingLayout.setVisibility(8);
      paramItemSettingLayout.setItemInfo("");
    }
    else
    {
      paramItemSettingLayout.setVisibility(0);
      paramItemSettingLayout.setItemInfo(paramString);
    }
  }
  
  private final void t1(String paramString)
  {
    Object localObject = this.y;
    if (localObject == null) {
      j.t("mBinding");
    }
    ItemSettingLayout localItemSettingLayout = ((ActivityBaseIotDeviceInfoBinding)localObject).y;
    int i;
    if ((paramString != null) && (paramString.length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      localItemSettingLayout.setVisibility(8);
      localItemSettingLayout.setItemInfo("");
    }
    else
    {
      localItemSettingLayout.setVisibility(0);
      if (m.A(paramString, "E100", false, 2, null))
      {
        localItemSettingLayout.setItemInfo(String.valueOf(paramString));
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(getString(2131951830));
        ((StringBuilder)localObject).append(' ');
        ((StringBuilder)localObject).append(paramString);
        localItemSettingLayout.setItemInfo(((StringBuilder)localObject).toString());
      }
    }
  }
  
  private final void u1(LocalIoTBaseDevice paramLocalIoTBaseDevice)
  {
    l.q(this, m1(), paramLocalIoTBaseDevice.getSignalLevel(), paramLocalIoTBaseDevice.getRssi(), this.p3);
  }
  
  private final void v1(LocalIoTBaseDevice paramLocalIoTBaseDevice)
  {
    if ((paramLocalIoTBaseDevice instanceof IoTSubDevice))
    {
      paramLocalIoTBaseDevice = (IoTSubDevice)paramLocalIoTBaseDevice;
      if ((paramLocalIoTBaseDevice.getSlotNumber() > 0) && (paramLocalIoTBaseDevice.getSlotNumber() == 2))
      {
        Object localObject = this.y;
        if (localObject == null) {
          j.t("mBinding");
        }
        localObject = ((ActivityBaseIotDeviceInfoBinding)localObject).z;
        j.d(localObject, "mBinding.itemSwitchButton");
        ((View)localObject).setVisibility(0);
        if (paramLocalIoTBaseDevice.getPosition() == 1)
        {
          paramLocalIoTBaseDevice = this.y;
          if (paramLocalIoTBaseDevice == null) {
            j.t("mBinding");
          }
          paramLocalIoTBaseDevice.z.setImageResource(2131690064);
        }
        else
        {
          paramLocalIoTBaseDevice = this.y;
          if (paramLocalIoTBaseDevice == null) {
            j.t("mBinding");
          }
          paramLocalIoTBaseDevice.z.setImageResource(2131690070);
        }
      }
    }
  }
  
  private final void w1()
  {
    n1().f().observe(this, new d(this));
  }
  
  private final void x1(BaseALIoTDevice<?> paramBaseALIoTDevice)
  {
    Object localObject1 = null;
    if (paramBaseALIoTDevice != null) {
      paramBaseALIoTDevice = paramBaseALIoTDevice.getLocalIoTDevice();
    } else {
      paramBaseALIoTDevice = null;
    }
    Object localObject2 = paramBaseALIoTDevice;
    if (!(paramBaseALIoTDevice instanceof LocalIoTBaseDevice)) {
      localObject2 = null;
    }
    localObject2 = (LocalIoTBaseDevice)localObject2;
    if (localObject2 != null)
    {
      paramBaseALIoTDevice = this.y;
      if (paramBaseALIoTDevice == null) {
        j.t("mBinding");
      }
      ItemSettingLayout localItemSettingLayout = paramBaseALIoTDevice.p0;
      j.d(localItemSettingLayout, "itemTimezone");
      s1(localItemSettingLayout, ((LocalIoTBaseDevice)localObject2).getRegion());
      localItemSettingLayout = paramBaseALIoTDevice.p1;
      j.d(localItemSettingLayout, "itemWifiNetwork");
      s1(localItemSettingLayout, ((LocalIoTBaseDevice)localObject2).getSsid());
      t1(((LocalIoTBaseDevice)localObject2).getModel());
      localItemSettingLayout = paramBaseALIoTDevice.q;
      j.d(localItemSettingLayout, "itemIpAddress");
      s1(localItemSettingLayout, ((LocalIoTBaseDevice)localObject2).getIp());
      localItemSettingLayout = paramBaseALIoTDevice.x;
      j.d(localItemSettingLayout, "itemMacAddress");
      s1(localItemSettingLayout, l.a(((LocalIoTBaseDevice)localObject2).getMac()));
      localItemSettingLayout = paramBaseALIoTDevice.f;
      j.d(localItemSettingLayout, "itemHardware");
      s1(localItemSettingLayout, ((LocalIoTBaseDevice)localObject2).getHwVer());
      localItemSettingLayout = paramBaseALIoTDevice.d;
      j.d(localItemSettingLayout, "itemFwVersion");
      paramBaseALIoTDevice = (BaseALIoTDevice<?>)localObject1;
      if (((LocalIoTBaseDevice)localObject2).isSupportFirmware()) {
        paramBaseALIoTDevice = ((LocalIoTBaseDevice)localObject2).getFwVer();
      }
      s1(localItemSettingLayout, paramBaseALIoTDevice);
      paramBaseALIoTDevice = ((LocalIoTBaseDevice)localObject2).getSsid();
      int i;
      if ((paramBaseALIoTDevice != null) && (paramBaseALIoTDevice.length() != 0)) {
        i = 0;
      } else {
        i = 1;
      }
      if (i == 0) {
        u1((LocalIoTBaseDevice)localObject2);
      }
      v1((LocalIoTBaseDevice)localObject2);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    o1();
    p1();
    q1();
    w1();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    if (r1())
    {
      getMenuInflater().inflate(2131623952, paramMenu);
      return true;
    }
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    j.e(paramMenuItem, "item");
    if ((r1()) && (paramMenuItem.getItemId() == 2131362904))
    {
      X0(DebugFwUpdateActivity.class, this.z);
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  static final class a
    implements View.OnClickListener
  {
    a(IoTDeviceInfoCommonActivity paramIoTDeviceInfoCommonActivity) {}
    
    public final void onClick(View paramView)
    {
      paramView = this.c;
      IoTDeviceInfoCommonActivity.j1(paramView, IoTDeviceInfoCommonActivity.h1(paramView) ^ true);
      paramView = IoTDeviceInfoCommonActivity.e1(this.c);
      Object localObject = null;
      if (paramView != null) {
        paramView = paramView.getLocalIoTDevice();
      } else {
        paramView = null;
      }
      if (!(paramView instanceof LocalIoTBaseDevice)) {
        paramView = (View)localObject;
      }
      paramView = (LocalIoTBaseDevice)paramView;
      if (paramView != null) {
        IoTDeviceInfoCommonActivity.k1(this.c, paramView);
      }
    }
  }
  
  static final class b
    extends Lambda
    implements kotlin.jvm.b.a<TextView>
  {
    b(IoTDeviceInfoCommonActivity paramIoTDeviceInfoCommonActivity)
    {
      super();
    }
    
    public final TextView a()
    {
      ItemSettingLayout localItemSettingLayout = IoTDeviceInfoCommonActivity.f1(this.c).p1;
      j.d(localItemSettingLayout, "mBinding.itemWifiNetwork");
      return localItemSettingLayout.getItemRightTextView();
    }
  }
  
  static final class c
    extends Lambda
    implements kotlin.jvm.b.a<IoTDeviceInfoCommonViewModel>
  {
    c(IoTDeviceInfoCommonActivity paramIoTDeviceInfoCommonActivity)
    {
      super();
    }
    
    public final IoTDeviceInfoCommonViewModel a()
    {
      Object localObject = this.c;
      localObject = new ViewModelProvider((ViewModelStoreOwner)localObject, new IoTViewModelFactory((FragmentActivity)localObject, IoTDeviceInfoCommonActivity.g1((IoTDeviceInfoCommonActivity)localObject))).get(IoTDeviceInfoCommonViewModel.class);
      j.d(localObject, "ViewModelProvider(this, …).get<VM>(VM::class.java)");
      return (IoTDeviceInfoCommonViewModel)localObject;
    }
  }
  
  static final class d<T>
    implements Observer<BaseALIoTDevice<?>>
  {
    d(IoTDeviceInfoCommonActivity paramIoTDeviceInfoCommonActivity) {}
    
    public final void a(BaseALIoTDevice<?> paramBaseALIoTDevice)
    {
      IoTDeviceInfoCommonActivity.i1(this.a, paramBaseALIoTDevice);
      IoTDeviceInfoCommonActivity.l1(this.a, paramBaseALIoTDevice);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devicecommon\view\IoTDeviceInfoCommonActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */