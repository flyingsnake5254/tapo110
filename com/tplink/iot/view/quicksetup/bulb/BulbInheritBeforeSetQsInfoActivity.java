package com.tplink.iot.view.quicksetup.bulb;

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
import com.tplink.iot.Utils.x0.r;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.view.quicksetup.base.e;
import com.tplink.iot.view.quicksetup.bulb.utils.QuickSetupInfoBundle;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.WirelessInfoParams;

public class BulbInheritBeforeSetQsInfoActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private e p0;
  private QuickSetupInfoBundle y;
  private WirelessInfoParams z;
  
  private void f1()
  {
    Object localObject = getIntent();
    if (localObject != null)
    {
      localObject = ((Intent)localObject).getExtras();
      if (localObject != null)
      {
        this.y = ((QuickSetupInfoBundle)((Bundle)localObject).getSerializable("quick_setup_bundle"));
        this.z = ((WirelessInfoParams)((Bundle)localObject).getSerializable("ap_ssid"));
      }
    }
  }
  
  private void g1()
  {
    this.p0 = new e(this);
    ((ImageView)findViewById(2131362826)).setOnClickListener(this);
    ((Button)findViewById(2131362063)).setOnClickListener(new a());
    ((TextView)findViewById(2131364631)).setOnClickListener(new b());
  }
  
  public static void h1(Context paramContext, QuickSetupInfoBundle paramQuickSetupInfoBundle, WirelessInfoParams paramWirelessInfoParams)
  {
    Intent localIntent = new Intent(paramContext, BulbInheritBeforeSetQsInfoActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("quick_setup_bundle", paramQuickSetupInfoBundle);
    if (paramWirelessInfoParams != null) {
      localBundle.putSerializable("ap_ssid", paramWirelessInfoParams);
    }
    localIntent.putExtras(localBundle);
    paramContext.startActivity(localIntent);
  }
  
  private void i1(boolean paramBoolean)
  {
    this.y.setSelectFollowInherit(paramBoolean);
    SoftAPBulbConnectAPActivity.y1(this, this.y, this.z);
    r.t(this.y.getDeviceType(), this.y.getDeviceModel(), this.y.getDeviceIdMD5());
    finish();
  }
  
  private void j1(boolean paramBoolean)
  {
    if (com.tplink.iot.view.quicksetup.bulb.utils.a.f(this, this.y)) {
      i1(paramBoolean);
    } else {
      this.p0.d(this.y.getBulbSSID());
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131362826) {
      finish();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (o.a() == 0) {
      return;
    }
    setContentView(2131558466);
    f1();
    g1();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    e locale = this.p0;
    if (locale != null) {
      locale.b();
    }
  }
  
  class a
    extends com.tplink.iot.view.quicksetup.base.a
  {
    a() {}
    
    public void a(View paramView)
    {
      BulbInheritBeforeSetQsInfoActivity.e1(BulbInheritBeforeSetQsInfoActivity.this, true);
    }
  }
  
  class b
    extends com.tplink.iot.view.quicksetup.base.a
  {
    b() {}
    
    public void a(View paramView)
    {
      BulbInheritBeforeSetQsInfoActivity.e1(BulbInheritBeforeSetQsInfoActivity.this, false);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\bulb\BulbInheritBeforeSetQsInfoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */