package com.tplink.iot.view.quicksetup.ble;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tplink.iot.Utils.TPMaterialDialogV2.d;
import com.tplink.iot.Utils.d0;
import com.tplink.iot.Utils.d0.g;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.view.quicksetup.base.QuickSetupInfoBean;
import com.tplink.iot.view.quicksetup.base.d;

public class BlePlugConnectApFailedActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private boolean p0;
  private QuickSetupInfoBean y;
  private int z;
  
  private void h1()
  {
    setResult(123);
    finish();
  }
  
  private void i1()
  {
    Object localObject = getIntent();
    if (localObject != null)
    {
      localObject = ((Intent)localObject).getExtras();
      if (localObject != null)
      {
        this.y = ((QuickSetupInfoBean)((Bundle)localObject).getSerializable("device_info_bean"));
        this.z = ((Bundle)localObject).getInt("wifi_error_code");
      }
    }
  }
  
  private void j1()
  {
    boolean bool = d.L(this.y);
    d.c0(this, (TextView)findViewById(2131364385), d.q(this.y));
    Object localObject = findViewById(2131364796);
    int i;
    if (bool) {
      i = 8;
    } else {
      i = 0;
    }
    ((View)localObject).setVisibility(i);
    localObject = findViewById(2131364820);
    if (bool) {
      i = 8;
    } else {
      i = 0;
    }
    ((View)localObject).setVisibility(i);
    ((ImageView)findViewById(2131362831)).setOnClickListener(this);
    d0.d(this, (TextView)findViewById(2131362619), 2131953530, getString(2131953533), new a());
    localObject = (Button)findViewById(2131362037);
    ((Button)localObject).setText(getString(2131954363));
    ((Button)localObject).setOnClickListener(this);
    localObject = (TextView)findViewById(2131364453);
    if (this.z == 1)
    {
      ((TextView)localObject).setVisibility(8);
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.z);
      localStringBuilder.append("");
      ((TextView)localObject).setText(getString(2131952086, new Object[] { localStringBuilder.toString() }));
      ((TextView)localObject).setVisibility(0);
    }
  }
  
  public void k1()
  {
    d.e0(this, new b());
  }
  
  public void onBackPressed()
  {
    k1();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131362037)
    {
      if (i == 2131362831) {
        k1();
      }
    }
    else
    {
      setResult(-1);
      finish();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (o.a() == 0) {
      return;
    }
    setContentView(2131558614);
    i1();
    j1();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.p0) {
      d.h(this.y);
    }
  }
  
  class a
    implements d0.g
  {
    a() {}
    
    public void a()
    {
      BlePlugConnectApFailedActivity.e1(BlePlugConnectApFailedActivity.this);
    }
  }
  
  class b
    implements TPMaterialDialogV2.d
  {
    b() {}
    
    public void onClick(View paramView)
    {
      BlePlugConnectApFailedActivity.f1(BlePlugConnectApFailedActivity.this, true);
      d.Z(BlePlugConnectApFailedActivity.g1(BlePlugConnectApFailedActivity.this), "PairingFailedPage");
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\ble\BlePlugConnectApFailedActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */