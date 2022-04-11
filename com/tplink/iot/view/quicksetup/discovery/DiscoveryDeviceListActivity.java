package com.tplink.iot.view.quicksetup.discovery;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.adapter.quicksetup.DiscoveryDevicesAdapter;
import com.tplink.iot.adapter.quicksetup.DiscoveryDevicesAdapter.b;
import com.tplink.iot.adapter.quicksetup.d;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityDiscoveredDevicesBinding;
import com.tplink.iot.view.quicksetup.bulb.utils.QuickSetupInfoBundle;
import com.tplink.iot.viewmodel.quicksetup.QuickDiscoveryViewModel;
import com.tplink.libtpnetwork.TDPNetwork.bean.TDPIoTDevice;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DiscoveryDeviceListActivity
  extends BaseActivity
  implements DiscoveryDevicesAdapter.b
{
  private Integer H3;
  private QuickDiscoveryViewModel p0;
  private final QuickSetupInfoBundle p1 = new QuickSetupInfoBundle();
  private io.reactivex.e0.c p2 = null;
  private Integer p3;
  private ActivityDiscoveredDevicesBinding y;
  private DiscoveryDevicesAdapter z;
  
  private void e1(@NonNull TDPIoTDevice paramTDPIoTDevice)
  {
    this.p1.setLongitude(this.p3);
    this.p1.setLatitude(this.H3);
    this.p1.setDeviceIdMD5(paramTDPIoTDevice.getDeviceIdMd5());
    this.p1.setDeviceModel(f1(paramTDPIoTDevice.getDeviceModel()));
    this.p1.setOnboardingStartTime(System.currentTimeMillis());
    this.p1.setFromQuickDiscovery(true);
    this.p0.h(paramTDPIoTDevice);
    DiscoveryDeviceConnectActivity.w1(this, this.p1);
  }
  
  private String f1(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    String str;
    if (paramString.contains("-"))
    {
      str = paramString.substring(0, paramString.indexOf("-"));
    }
    else if (paramString.matches(".*\\(.*\\)$"))
    {
      str = paramString.substring(0, paramString.indexOf("("));
    }
    else
    {
      str = paramString;
      if (paramString.contains(" ")) {
        str = paramString.substring(0, paramString.indexOf(" "));
      }
    }
    return str;
  }
  
  private void g1(@Nullable List<TDPIoTDevice> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localArrayList.add(new d((TDPIoTDevice)paramList.next()));
      }
      this.z.o(localArrayList);
    }
    else
    {
      this.z.o(new ArrayList());
    }
  }
  
  private void h1()
  {
    this.p2 = com.tplink.iot.view.quicksetup.base.f.c.h().g(5000L).E(new a(this)).F0();
  }
  
  private void i1()
  {
    DiscoveryDevicesAdapter localDiscoveryDevicesAdapter = new DiscoveryDevicesAdapter();
    this.z = localDiscoveryDevicesAdapter;
    localDiscoveryDevicesAdapter.n(this);
    this.y.c.setAdapter(this.z);
  }
  
  private void m1()
  {
    this.p0.g().observe(this, new b(this));
  }
  
  public void I0(@NonNull TDPIoTDevice paramTDPIoTDevice)
  {
    e1(paramTDPIoTDevice);
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.y = ((ActivityDiscoveredDevicesBinding)DataBindingUtil.setContentView(this, 2131558511));
    this.p0 = ((QuickDiscoveryViewModel)new ViewModelProvider(this).get(QuickDiscoveryViewModel.class));
    i1();
    m1();
  }
  
  protected void onDestroy()
  {
    io.reactivex.e0.c localc = this.p2;
    if (localc != null) {
      localc.dispose();
    }
    super.onDestroy();
  }
  
  protected void onResume()
  {
    super.onResume();
    if ((this.p3 == null) || (this.H3 == null)) {
      h1();
    }
  }
  
  protected void onStop()
  {
    io.reactivex.e0.c localc = this.p2;
    if (localc != null) {
      localc.dispose();
    }
    super.onStop();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\discovery\DiscoveryDeviceListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */