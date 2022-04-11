package com.tplink.iot.view.quicksetup.firmware;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.devices.lightstrip.view.LightStripPlacementGuideActivity;
import com.tplink.iot.devices.lightstrip.view.LightStripPlacementGuideActivity.a;
import com.tplink.iot.g.b.c.c;
import com.tplink.iot.view.ipcamera.setting.firmware.AutoUpdateTimePickerDialog;
import com.tplink.iot.view.ipcamera.setting.firmware.AutoUpdateTimePickerDialog.a;
import com.tplink.iot.view.quicksetup.common.CommonQuickSetupBean;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.viewmodel.quicksetup.QsFirmwareViewModel;
import com.tplink.iot.widget.h;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result.QuickSetupComponentExtraInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result.QuickSetupComponentResult;
import java.util.HashMap;
import kotlin.jvm.internal.j;

public final class AutoUpdateHintActivity
  extends BaseActivity
  implements View.OnClickListener, AutoUpdateTimePickerDialog.a
{
  public static final a y = new a(null);
  private HashMap H3;
  private QsFirmwareViewModel p0;
  private final String[] p1 = h.d();
  private AutoUpdateTimePickerDialog p2;
  private int p3 = 180;
  private CommonQuickSetupBean z;
  
  private final void f1()
  {
    Object localObject = getIntent();
    if (localObject != null)
    {
      localObject = ((Intent)localObject).getExtras();
      if (localObject != null) {
        this.z = ((CommonQuickSetupBean)((Bundle)localObject).getSerializable("common_quick_setup_bean"));
      }
    }
  }
  
  private final boolean g1()
  {
    CommonQuickSetupBean localCommonQuickSetupBean = this.z;
    boolean bool;
    if (localCommonQuickSetupBean != null) {
      bool = localCommonQuickSetupBean.isFromQuickDiscovery();
    } else {
      bool = false;
    }
    return bool;
  }
  
  private final void h1()
  {
    com.tplink.iot.view.quicksetup.bulb.utils.a.d(this, g1());
  }
  
  private final void i1()
  {
    Object localObject = this.z;
    if (localObject != null)
    {
      localObject = ((CommonQuickSetupBean)localObject).getComponentResult();
      if (localObject != null)
      {
        localObject = ((QuickSetupComponentResult)localObject).getExtraInfo();
        if (localObject != null)
        {
          localObject = ((QuickSetupComponentExtraInfoBean)localObject).getDeviceModel();
          break label37;
        }
      }
    }
    localObject = null;
    label37:
    if (c.i((String)localObject))
    {
      LightStripPlacementGuideActivity.a locala = LightStripPlacementGuideActivity.y;
      if (localObject == null) {
        localObject = "";
      }
      locala.b(this, (String)localObject, true, g1());
    }
    else
    {
      h1();
    }
  }
  
  private final void j1()
  {
    AutoUpdateTimePickerDialog localAutoUpdateTimePickerDialog = this.p2;
    if (localAutoUpdateTimePickerDialog != null)
    {
      j.c(localAutoUpdateTimePickerDialog);
      if (localAutoUpdateTimePickerDialog.isVisible()) {
        return;
      }
    }
    localAutoUpdateTimePickerDialog = AutoUpdateTimePickerDialog.A0(this.p3);
    this.p2 = localAutoUpdateTimePickerDialog;
    if (localAutoUpdateTimePickerDialog != null) {
      localAutoUpdateTimePickerDialog.B0(this);
    }
    localAutoUpdateTimePickerDialog = this.p2;
    if (localAutoUpdateTimePickerDialog != null) {
      localAutoUpdateTimePickerDialog.show(getSupportFragmentManager(), null);
    }
  }
  
  public View e1(int paramInt)
  {
    if (this.H3 == null) {
      this.H3 = new HashMap();
    }
    View localView1 = (View)this.H3.get(Integer.valueOf(paramInt));
    View localView2 = localView1;
    if (localView1 == null)
    {
      localView2 = findViewById(paramInt);
      this.H3.put(Integer.valueOf(paramInt), localView2);
    }
    return localView2;
  }
  
  public void onBackPressed() {}
  
  public void onClick(View paramView)
  {
    if (j.a(paramView, (Button)e1(com.tplink.iot.a.btn_got_it)))
    {
      paramView = this.p0;
      if (paramView == null) {
        j.t("viewModel");
      }
      paramView.x(this.p3);
      i1();
    }
    else if (j.a(paramView, (TextView)e1(com.tplink.iot.a.auto_update_time)))
    {
      j1();
    }
    else if (j.a(paramView, (TextView)e1(com.tplink.iot.a.tv_skip)))
    {
      paramView = this.p0;
      if (paramView == null) {
        j.t("viewModel");
      }
      paramView.x(this.p3);
      h1();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558450);
    f1();
    paramBundle = this.z;
    Object localObject = null;
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getComponentResult();
      if (paramBundle != null)
      {
        paramBundle = paramBundle.getExtraInfo();
        if (paramBundle != null)
        {
          paramBundle = paramBundle.getDeviceModel();
          break label54;
        }
      }
    }
    paramBundle = null;
    label54:
    if (c.i(paramBundle))
    {
      paramBundle = (Button)e1(com.tplink.iot.a.btn_got_it);
      j.d(paramBundle, "btn_got_it");
      paramBundle.setText(getString(2131953410));
      i = com.tplink.iot.a.tv_skip;
      paramBundle = (TextView)e1(i);
      j.d(paramBundle, "tv_skip");
      paramBundle.setVisibility(0);
      ((TextView)e1(i)).setOnClickListener(this);
    }
    CommonQuickSetupBean localCommonQuickSetupBean = this.z;
    if (localCommonQuickSetupBean == null)
    {
      paramBundle = "";
    }
    else
    {
      paramBundle = (Bundle)localObject;
      if (localCommonQuickSetupBean != null) {
        paramBundle = localCommonQuickSetupBean.getDeviceIdMD5();
      }
    }
    paramBundle = ViewModelProviders.of(this, new IoTViewModelFactory(this, paramBundle)).get(QsFirmwareViewModel.class);
    j.d(paramBundle, "ViewModelProviders.of(th…areViewModel::class.java]");
    this.p0 = ((QsFirmwareViewModel)paramBundle);
    int i = com.tplink.iot.a.auto_update_time;
    paramBundle = (TextView)e1(i);
    j.d(paramBundle, "auto_update_time");
    paramBundle.setText(this.p1[3]);
    ((TextView)e1(i)).setOnClickListener(this);
    ((Button)e1(com.tplink.iot.a.btn_got_it)).setOnClickListener(this);
  }
  
  public void v(int paramInt)
  {
    this.p3 = (paramInt * 60);
    TextView localTextView = (TextView)e1(com.tplink.iot.a.auto_update_time);
    j.d(localTextView, "auto_update_time");
    localTextView.setText(this.p1[paramInt]);
  }
  
  public static final class a
  {
    public final void a(Context paramContext, CommonQuickSetupBean paramCommonQuickSetupBean)
    {
      j.e(paramContext, "context");
      j.e(paramCommonQuickSetupBean, "quickSetupInfoBean");
      Intent localIntent = new Intent(paramContext, AutoUpdateHintActivity.class);
      Bundle localBundle = new Bundle();
      localBundle.putSerializable("common_quick_setup_bean", paramCommonQuickSetupBean);
      localIntent.putExtras(localBundle);
      paramContext.startActivity(localIntent);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\firmware\AutoUpdateHintActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */