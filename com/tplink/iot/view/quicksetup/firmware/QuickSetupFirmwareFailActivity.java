package com.tplink.iot.view.quicksetup.firmware;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.devices.lightstrip.view.LightStripPlacementGuideActivity;
import com.tplink.iot.devices.lightstrip.view.LightStripPlacementGuideActivity.a;
import com.tplink.iot.view.quicksetup.base.d;
import com.tplink.iot.view.quicksetup.common.CommonQuickSetupBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result.QuickSetupComponentExtraInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result.QuickSetupComponentResult;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;

public class QuickSetupFirmwareFailActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private CommonQuickSetupBean y;
  
  private void e1()
  {
    if ((f1() >= 2) && (!j1())) {
      g1();
    } else {
      h1();
    }
  }
  
  private int f1()
  {
    CommonQuickSetupBean localCommonQuickSetupBean = this.y;
    if (localCommonQuickSetupBean != null) {
      return d.u(localCommonQuickSetupBean.getComponentResult());
    }
    return 0;
  }
  
  private void g1()
  {
    AutoUpdateHintActivity.y.a(this, this.y);
    finish();
  }
  
  private void h1()
  {
    String str = this.y.getComponentResult().getExtraInfo().getDeviceModel();
    if (com.tplink.iot.g.b.c.c.i(str)) {
      LightStripPlacementGuideActivity.y.b(this, str, true, this.y.isFromQuickDiscovery());
    } else {
      Y0();
    }
    finish();
  }
  
  private void i1()
  {
    Object localObject1 = getIntent();
    Object localObject2 = null;
    if (localObject1 != null)
    {
      localObject1 = ((Intent)localObject1).getExtras();
      if (localObject1 != null)
      {
        localObject2 = (CommonQuickSetupBean)((Bundle)localObject1).getSerializable("common_quick_setup_bean");
        this.y = ((CommonQuickSetupBean)localObject2);
        localObject1 = d.s((CommonQuickSetupBean)localObject2);
        localObject2 = d.r(this.y);
        break label53;
      }
    }
    localObject1 = null;
    label53:
    Object localObject3 = (Button)findViewById(2131362055);
    ((Button)localObject3).setOnClickListener(this);
    if (com.tplink.iot.g.b.c.c.i((String)localObject2))
    {
      ((Button)localObject3).setText(2131953410);
      localObject3 = (TextView)findViewById(2131364631);
      ((TextView)localObject3).setVisibility(0);
      ((TextView)localObject3).setOnClickListener(this);
    }
    ((ImageView)findViewById(2131362818)).setImageResource(com.tplink.iot.view.quicksetup.base.c.W((EnumDeviceType)localObject1, (String)localObject2));
  }
  
  private boolean j1()
  {
    CommonQuickSetupBean localCommonQuickSetupBean = this.y;
    boolean bool;
    if ((localCommonQuickSetupBean != null) && (localCommonQuickSetupBean.isKeepInherit())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static void k1(Context paramContext, CommonQuickSetupBean paramCommonQuickSetupBean)
  {
    Intent localIntent = new Intent(paramContext, QuickSetupFirmwareFailActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("common_quick_setup_bean", paramCommonQuickSetupBean);
    localIntent.putExtras(localBundle);
    paramContext.startActivity(localIntent);
  }
  
  public void onBackPressed() {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131362055)
    {
      if (i == 2131364631)
      {
        Y0();
        finish();
      }
    }
    else {
      e1();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (o.a() == 0) {
      return;
    }
    setContentView(2131558623);
    i1();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\firmware\QuickSetupFirmwareFailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */