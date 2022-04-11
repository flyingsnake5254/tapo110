package com.tplink.iot.view.quicksetup.ble;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialog;
import androidx.fragment.app.FragmentActivity;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.Utils.TPMaterialDialogV2.d;
import com.tplink.iot.Utils.x0.r;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;

public class BleNoFindActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private TPMaterialDialogV2 y;
  private String z;
  
  private void h1()
  {
    if (!com.tplink.iot.view.quicksetup.base.ble.d.d(this))
    {
      o1();
      return;
    }
    if (com.tplink.iot.view.quicksetup.base.ble.d.b(this)) {
      j1();
    } else {
      startActivityForResult(new Intent(this, LocationAllowActivity.class), 500);
    }
  }
  
  private void i1()
  {
    Object localObject = getIntent();
    if (localObject != null)
    {
      localObject = ((Intent)localObject).getExtras();
      if (localObject != null) {
        this.z = ((Bundle)localObject).getString("device_model");
      }
    }
  }
  
  private void j1()
  {
    setResult(-1);
    finish();
  }
  
  private void k1()
  {
    com.tplink.iot.view.quicksetup.base.d.c0(this, (TextView)findViewById(2131364385), this.z);
    Button localButton = (Button)findViewById(2131362037);
    localButton.setText(getString(2131954363));
    localButton.setOnClickListener(this);
    ((ImageView)findViewById(2131362831)).setOnClickListener(this);
  }
  
  public static void l1(Activity paramActivity, String paramString, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, BleNoFindActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putString("device_model", paramString);
    localIntent.putExtras(localBundle);
    paramActivity.startActivityForResult(localIntent, paramInt);
  }
  
  private void m1()
  {
    com.tplink.iot.view.quicksetup.base.ble.d.g(this);
  }
  
  private void n1()
  {
    com.tplink.iot.view.quicksetup.base.d.e0(this, new a());
  }
  
  void o1()
  {
    Object localObject = this.y;
    if ((localObject != null) && (((Dialog)localObject).isShowing())) {
      return;
    }
    localObject = LayoutInflater.from(this).inflate(2131559102, null, false);
    ((View)localObject).findViewById(2131364572).setOnClickListener(new b());
    ((View)localObject).findViewById(2131364571).setOnClickListener(new c());
    TPMaterialDialogV2.Builder localBuilder = new TPMaterialDialogV2.Builder(this);
    localBuilder.e((View)localObject);
    localBuilder.c(false);
    localBuilder.b(false);
    localBuilder.g(8, 8);
    localObject = localBuilder.a();
    this.y = ((TPMaterialDialogV2)localObject);
    ((TPMaterialDialogV2)localObject).show();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 500) && (paramInt2 == -1))
    {
      j1();
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    n1();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131362037)
    {
      if (i == 2131362831) {
        n1();
      }
    }
    else {
      h1();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (o.a() == 0) {
      return;
    }
    setContentView(2131558458);
    i1();
    k1();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    TPMaterialDialogV2 localTPMaterialDialogV2 = this.y;
    if ((localTPMaterialDialogV2 != null) && (localTPMaterialDialogV2.isShowing())) {
      this.y.dismiss();
    }
  }
  
  class a
    implements TPMaterialDialogV2.d
  {
    a() {}
    
    public void onClick(View paramView)
    {
      r.g(EnumDeviceType.PLUG.getDeviceType(), BleNoFindActivity.e1(BleNoFindActivity.this), "NotFindDevicePage");
    }
  }
  
  class b
    implements View.OnClickListener
  {
    b() {}
    
    public void onClick(View paramView)
    {
      if (BleNoFindActivity.f1(BleNoFindActivity.this) != null) {
        BleNoFindActivity.f1(BleNoFindActivity.this).dismiss();
      }
    }
  }
  
  class c
    implements View.OnClickListener
  {
    c() {}
    
    public void onClick(View paramView)
    {
      if (BleNoFindActivity.f1(BleNoFindActivity.this) != null) {
        BleNoFindActivity.f1(BleNoFindActivity.this).dismiss();
      }
      BleNoFindActivity.g1(BleNoFindActivity.this);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\ble\BleNoFindActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */