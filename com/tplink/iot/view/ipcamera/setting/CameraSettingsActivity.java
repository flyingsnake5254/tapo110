package com.tplink.iot.view.ipcamera.setting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import b.d.q.b.l;
import com.tplink.iot.Utils.v0.b.a;
import com.tplink.iot.Utils.v0.e;
import com.tplink.iot.Utils.z0.h;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.cloud.bean.cloudvideo.common.DeviceCloudProduct;
import com.tplink.iot.cloud.bean.cloudvideo.common.OrderInfo;
import com.tplink.iot.databinding.ActivityDeviceSettingNewIpcBinding;
import com.tplink.iot.view.deviceshare.ShareDeviceUserListActivity;
import com.tplink.iot.view.iotcommon.IoTSettingLocationSelectActivity;
import com.tplink.iot.view.ipcamera.setting.detection.DetectionSettingActivity;
import com.tplink.iot.view.tapocare.BillingDialogActivity;
import com.tplink.iot.viewmodel.cloudvideo.CloudVideoViewModel;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.setting.DeviceSettingNewViewModel;
import com.tplink.iot.widget.UniversalDialog;
import com.tplink.iot.widget.UniversalDialog.a;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.device.DeviceManagerInfoBean;
import com.tplink.libtpnetwork.Utils.j;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import com.tplink.libtpnetwork.cameranetwork.model.ComponentType;
import io.reactivex.e0.c;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.List;

public class CameraSettingsActivity
  extends BaseActivity
  implements View.OnClickListener, b.a
{
  private Boolean H3;
  private DeviceSettingNewViewModel p0;
  private CloudVideoViewModel p1;
  private Activity p2;
  private io.reactivex.e0.b p3 = new io.reactivex.e0.b();
  private ActivityDeviceSettingNewIpcBinding y;
  private String z;
  
  public static void j2(Context paramContext, String paramString, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramContext, CameraSettingsActivity.class);
    localIntent.putExtra("device_id_md5", paramString);
    localIntent.putExtra("online", paramBoolean);
    paramContext.startActivity(localIntent);
  }
  
  private void k1()
  {
    this.y.K3.setOnClickListener(new v0(this));
    this.y.c4.setOnClickListener(new i0(this));
    this.y.f4.setOnClickListener(new d0(this));
    this.y.p4.setOnClickListener(new m0(this));
  }
  
  public static void k2(Context paramContext, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    Intent localIntent = new Intent(paramContext, CameraSettingsActivity.class);
    localIntent.putExtra("device_id_md5", paramString);
    localIntent.putExtra("online", paramBoolean2);
    localIntent.putExtra("video_play", paramBoolean1);
    paramContext.startActivity(localIntent);
  }
  
  private int l1(ALCameraDevice paramALCameraDevice)
  {
    int i = 0;
    int j;
    if ((paramALCameraDevice != null) && (paramALCameraDevice.getDeviceManagerInfo() != null) && (paramALCameraDevice.getDeviceManagerInfo().getUserInfo() != null)) {
      j = paramALCameraDevice.getDeviceManagerInfo().getUserInfo().size() - 1;
    } else {
      j = 0;
    }
    if (j == -1) {
      j = i;
    }
    return j;
  }
  
  private void m1()
  {
    this.p0.G.observe(this, new f0(this));
    this.p0.H.observe(this, new j0(this));
    this.p1.N().observe(this, new b());
    j.c(this.p0.E, this, new y(this));
    this.p0.o1(this);
    this.p0.F.observe(this, new c0(this));
  }
  
  private void m2()
  {
    c localc = h.a(this.z, true, ComponentType.BLOCK_ZONE, new k0(this)).H0(new a0(this), new x(this));
    this.p3.b(localc);
  }
  
  private void n2()
  {
    l.e(this.z, new w(this));
  }
  
  private void o2()
  {
    if (this.p0.I.get())
    {
      this.p0.t();
    }
    else
    {
      this.p0.c0.set(false);
      this.p0.v();
    }
  }
  
  private void p2()
  {
    new UniversalDialog.a().q(getString(2131952564)).s(getString(2131952391)).u(getString(2131952563)).m(true).v(getResources().getColor(2131099812)).t(new e0(this)).l().show(getSupportFragmentManager(), "");
  }
  
  private void q2()
  {
    Object localObject = (ALCameraDevice)TPIoTClientManager.K1(this.z).getCameraDevice();
    boolean bool;
    if ((localObject != null) && (!((BaseALIoTDevice)localObject).isUserRoleTypeDevice())) {
      bool = false;
    } else {
      bool = true;
    }
    int i = l1((ALCameraDevice)localObject);
    if (bool) {
      localObject = getString(2131953910);
    } else if (i == 0) {
      localObject = getString(2131953910);
    } else if (i == 1) {
      localObject = getString(2131953923, new Object[] { String.valueOf(i) });
    } else {
      localObject = getString(2131953922, new Object[] { String.valueOf(i) });
    }
    new UniversalDialog.a().q((String)localObject).s(getString(2131952391)).u(getString(2131953855)).m(true).v(getResources().getColor(2131099812)).t(new z(this, bool)).l().show(getSupportFragmentManager(), "");
  }
  
  public void D0()
  {
    c localc = h.o(this.z, false, new p0(this)).H0(new n0(this), h0.c);
    this.p3.b(localc);
  }
  
  public void l2()
  {
    this.p1.N().observe(this, new d());
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1345)
    {
      paramIntent = h.o(this.z, false, new t0(this)).H0(new u0(this), b0.c);
      this.p3.b(paramIntent);
      com.tplink.iot.Utils.v0.b.a().b();
    }
    else if (paramInt1 == 1346)
    {
      paramIntent = h.o(this.z, false, new q0(this)).H0(new l0(this), r0.c);
      this.p3.b(paramIntent);
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if ((this.p0.z.get()) && (i != 2131363399) && (i != 2131364738))
    {
      Toast.makeText(this, 2131952051, 0).show();
      return;
    }
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131364773: 
      com.tplink.iot.view.ipcamera.setting.video.a.a(this, this.z);
      break;
    case 2131364242: 
      if (this.p0.x())
      {
        paramView = new Intent(this, TimezoneActivity.class);
        paramView.putExtra("device_id_md5", this.z);
        startActivity(paramView);
      }
      break;
    case 2131364037: 
      ShareDeviceUserListActivity.v1(this, this.z);
      break;
    case 2131363979: 
      if (!TextUtils.isEmpty((CharSequence)this.p0.x.get()))
      {
        paramView = new Intent(this, StoreManageActivity.class);
        paramView.putExtra("device_id_md5", this.z);
        startActivity(paramView);
      }
      break;
    case 2131363844: 
      p2();
      break;
    case 2131363797: 
      ScheduleSettingActivity.j1(this, this.z);
      break;
    case 2131363696: 
      m2();
      break;
    case 2131363579: 
    case 2131364738: 
      q2();
      break;
    case 2131363568: 
      X0(WhiteLampConfigActivity.class, this.z);
      break;
    case 2131363544: 
      b5.a(this, this.z);
      break;
    case 2131363399: 
      paramView = new Intent(this, DeviceDetailInfoActivity.class);
      paramView.putExtra("device_id_md5", this.z);
      paramView.putExtra("online", this.p0.I.get());
      startActivity(paramView);
      break;
    case 2131363375: 
    case 2131363376: 
      if (this.p0.I.get())
      {
        paramView = this.p0.h0;
        if ((paramView != null) && (paramView.isFirmwareSupportIoTCloud()))
        {
          if (this.p0.c.get()) {
            IoTSettingLocationSelectActivity.o1(this, this.p0.i());
          }
        }
        else {
          LocationSettingActivity.j1(this, this.z, this.p0.b.get());
        }
      }
      break;
    case 2131362401: 
      DetectionSettingActivity.s1(this, this.z);
      break;
    case 2131362257: 
      com.tplink.iot.Utils.x0.w.l(this.z);
      h.i(this.z, true).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).E(new c()).F0();
      break;
    case 2131361988: 
      AutoRebootActivity.t1(this, this.z);
      break;
    case 2131361944: 
      paramView = new Intent(this, AdvancedSettingActivity.class);
      paramView.putExtra("device_id_md5", this.z);
      startActivity(paramView);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.p2 = this;
    this.z = getIntent().getStringExtra("device_id_md5");
    this.y = ((ActivityDeviceSettingNewIpcBinding)DataBindingUtil.setContentView(this, 2131558501));
    this.p0 = ((DeviceSettingNewViewModel)ViewModelProviders.of(this, new CameraViewModelFactory(this, this.z)).get(DeviceSettingNewViewModel.class));
    this.p1 = ((CloudVideoViewModel)ViewModelProviders.of(this).get(CloudVideoViewModel.class));
    this.y.i(this.p0);
    this.y.h(this);
    setSupportActionBar(this.y.o4);
    this.y.o4.setNavigationOnClickListener(new s0(this));
    this.p0.I.set(getIntent().getBooleanExtra("online", false));
    this.p0.e0.set(getIntent().getBooleanExtra("video_play", false));
    this.p0.c0.set(true);
    new Handler().postDelayed(new o0(this), 1000L);
    m1();
    this.p0.w();
    k1();
    com.tplink.iot.Utils.v0.b.a().c(this);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    com.tplink.iot.Utils.v0.b.a().d(this);
    io.reactivex.e0.b localb = this.p3;
    if (localb != null) {
      localb.dispose();
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (16908332 == paramMenuItem.getItemId())
    {
      onBackPressed();
      return false;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  protected void onRestart()
  {
    super.onRestart();
    this.p0.k();
    this.p0.i1();
  }
  
  protected void onResume()
  {
    super.onResume();
  }
  
  protected void onStart()
  {
    super.onStart();
    o2();
  }
  
  protected void onStop()
  {
    super.onStop();
    c localc = this.p0.d0;
    if (localc != null) {
      localc.dispose();
    }
  }
  
  class a
    implements DetectionCloseDialog.a
  {
    a(DetectionCloseDialog paramDetectionCloseDialog) {}
    
    public void a()
    {
      CameraSettingsActivity.j1(CameraSettingsActivity.this).c0.set(true);
      CameraSettingsActivity.j1(CameraSettingsActivity.this).g().G0(new v(this));
      this.a.dismiss();
    }
    
    public void b()
    {
      this.a.dismiss();
      CameraSettingsActivity localCameraSettingsActivity = CameraSettingsActivity.this;
      DetectionSettingActivity.s1(localCameraSettingsActivity, CameraSettingsActivity.h1(localCameraSettingsActivity));
    }
  }
  
  class b
    implements Observer<List<OrderInfo>>
  {
    b() {}
    
    public void a(List<OrderInfo> paramList)
    {
      CameraSettingsActivity localCameraSettingsActivity = CameraSettingsActivity.this;
      CameraSettingsActivity.f1(localCameraSettingsActivity, Boolean.valueOf(CameraSettingsActivity.g1(localCameraSettingsActivity).H(paramList, "")));
    }
  }
  
  class c
    implements g<DeviceCloudProduct>
  {
    c() {}
    
    public void a(DeviceCloudProduct paramDeviceCloudProduct)
      throws Exception
    {
      if (CameraSettingsActivity.g1(CameraSettingsActivity.this).u(paramDeviceCloudProduct))
      {
        paramDeviceCloudProduct = CameraSettingsActivity.this;
        BillingDialogActivity.f1(paramDeviceCloudProduct, e.g(h.k(CameraSettingsActivity.h1(paramDeviceCloudProduct))));
      }
      else if (CameraSettingsActivity.e1(CameraSettingsActivity.this).booleanValue())
      {
        BillingDialogActivity.f1(CameraSettingsActivity.this, e.x());
      }
      else
      {
        paramDeviceCloudProduct = CameraSettingsActivity.this;
        BillingDialogActivity.f1(paramDeviceCloudProduct, e.g(h.k(CameraSettingsActivity.h1(paramDeviceCloudProduct))));
      }
    }
  }
  
  class d
    implements Observer<List<OrderInfo>>
  {
    d() {}
    
    public void a(List<OrderInfo> paramList)
    {
      CameraSettingsActivity.g1(CameraSettingsActivity.this).N().removeObserver(this);
      if (CameraSettingsActivity.g1(CameraSettingsActivity.this).H(paramList, "")) {
        BillingDialogActivity.f1(CameraSettingsActivity.i1(CameraSettingsActivity.this), e.x());
      } else {
        BillingDialogActivity.f1(CameraSettingsActivity.i1(CameraSettingsActivity.this), e.r(CameraSettingsActivity.j1(CameraSettingsActivity.this).i()));
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\setting\CameraSettingsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */