package com.tplink.iot.view.quicksetup.bulb;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback;
import androidx.fragment.app.FragmentActivity;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.view.quicksetup.base.wifi.b;
import com.tplink.iot.view.quicksetup.base.wifi.d;
import com.tplink.iot.view.quicksetup.bulb.utils.QuickSetupInfoBundle;

public class WifiLocationAllowActivity
  extends BaseActivity
  implements View.OnClickListener, ActivityCompat.OnRequestPermissionsResultCallback
{
  private TPMaterialDialogV2 p0;
  private TPMaterialDialogV2 p1;
  private QuickSetupInfoBundle y;
  private TPMaterialDialogV2 z;
  
  private void j1()
  {
    if (d.a(this)) {
      n1();
    }
  }
  
  private void k1()
  {
    if (!d.c(this))
    {
      b.c(this);
      return;
    }
    if (!d.d(this))
    {
      s1();
      return;
    }
    if (!d.e(this))
    {
      t1();
      return;
    }
    n1();
  }
  
  private void l1()
  {
    r1();
    SoftAPBulbSSIDEmptyActivity.n1(this, this.y);
    finish();
  }
  
  private void m1()
  {
    Object localObject = getIntent();
    if (localObject != null)
    {
      localObject = ((Intent)localObject).getExtras();
      if (localObject != null) {
        this.y = ((QuickSetupInfoBundle)((Bundle)localObject).getSerializable("quick_setup_bundle"));
      }
    }
  }
  
  private void n1()
  {
    setResult(-1);
    finish();
  }
  
  private void o1()
  {
    ((ImageView)findViewById(2131362826)).setOnClickListener(this);
    ((Button)findViewById(2131362037)).setOnClickListener(new a());
    ((TextView)findViewById(2131364631)).setOnClickListener(new b());
  }
  
  public static void p1(Context paramContext, QuickSetupInfoBundle paramQuickSetupInfoBundle)
  {
    Intent localIntent = new Intent(paramContext, WifiLocationAllowActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("quick_setup_bundle", paramQuickSetupInfoBundle);
    localIntent.putExtras(localBundle);
    paramContext.startActivity(localIntent);
  }
  
  private void q1()
  {
    d.f(this);
  }
  
  private void r1()
  {
    com.tplink.libtpnetwork.Utils.o.h0().h("has_refused_location_permission", true);
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
    if (com.tplink.iot.core.o.a() == 0) {
      return;
    }
    setContentView(2131558574);
    m1();
    o1();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (com.tplink.iot.core.o.a() == 0) {
      return;
    }
    TPMaterialDialogV2 localTPMaterialDialogV2 = this.z;
    if (localTPMaterialDialogV2 != null)
    {
      localTPMaterialDialogV2.dismiss();
      this.z = null;
    }
    localTPMaterialDialogV2 = this.p0;
    if (localTPMaterialDialogV2 != null)
    {
      localTPMaterialDialogV2.dismiss();
      this.p0 = null;
    }
    localTPMaterialDialogV2 = this.p1;
    if (localTPMaterialDialogV2 != null)
    {
      localTPMaterialDialogV2.dismiss();
      this.p1 = null;
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt)
  {
    b.a(paramInt, paramArrayOfString, paramArrayOfInt, new e());
  }
  
  protected void onResume()
  {
    super.onResume();
    j1();
  }
  
  protected void onSaveInstanceState(Bundle paramBundle) {}
  
  void s1()
  {
    Object localObject = this.p1;
    if ((localObject != null) && (((Dialog)localObject).isShowing())) {
      return;
    }
    localObject = LayoutInflater.from(this).inflate(2131559100, null, false);
    ((View)localObject).findViewById(2131364572).setOnClickListener(new f());
    ((View)localObject).findViewById(2131364571).setOnClickListener(new g());
    TPMaterialDialogV2.Builder localBuilder = new TPMaterialDialogV2.Builder(this);
    localBuilder.e((View)localObject);
    localBuilder.c(false);
    localBuilder.b(false);
    localBuilder.g(8, 8);
    localObject = localBuilder.a();
    this.p1 = ((TPMaterialDialogV2)localObject);
    ((TPMaterialDialogV2)localObject).show();
  }
  
  void t1()
  {
    Object localObject = this.z;
    if ((localObject != null) && (((Dialog)localObject).isShowing())) {
      return;
    }
    View localView = LayoutInflater.from(this).inflate(2131559248, null, false);
    localView.findViewById(2131364572).setOnClickListener(new c());
    localView.findViewById(2131364571).setOnClickListener(new d());
    localObject = new TPMaterialDialogV2.Builder(this);
    ((TPMaterialDialogV2.Builder)localObject).e(localView);
    ((TPMaterialDialogV2.Builder)localObject).c(false);
    ((TPMaterialDialogV2.Builder)localObject).b(false);
    ((TPMaterialDialogV2.Builder)localObject).g(8, 8);
    localObject = ((TPMaterialDialogV2.Builder)localObject).a();
    this.z = ((TPMaterialDialogV2)localObject);
    ((TPMaterialDialogV2)localObject).show();
  }
  
  class a
    extends com.tplink.iot.view.quicksetup.base.a
  {
    a() {}
    
    public void a(View paramView)
    {
      WifiLocationAllowActivity.e1(WifiLocationAllowActivity.this);
    }
  }
  
  class b
    extends com.tplink.iot.view.quicksetup.base.a
  {
    b() {}
    
    public void a(View paramView)
    {
      WifiLocationAllowActivity.f1(WifiLocationAllowActivity.this);
    }
  }
  
  class c
    implements View.OnClickListener
  {
    c() {}
    
    public void onClick(View paramView)
    {
      if (WifiLocationAllowActivity.g1(WifiLocationAllowActivity.this) != null) {
        WifiLocationAllowActivity.g1(WifiLocationAllowActivity.this).dismiss();
      }
      WifiLocationAllowActivity.f1(WifiLocationAllowActivity.this);
    }
  }
  
  class d
    implements View.OnClickListener
  {
    d() {}
    
    public void onClick(View paramView)
    {
      if (WifiLocationAllowActivity.g1(WifiLocationAllowActivity.this) != null) {
        WifiLocationAllowActivity.g1(WifiLocationAllowActivity.this).dismiss();
      }
      WifiLocationAllowActivity.h1(WifiLocationAllowActivity.this);
    }
  }
  
  class e
    implements com.tplink.iot.view.quicksetup.base.wifi.a
  {
    e() {}
    
    public void a()
    {
      if ((!ActivityCompat.shouldShowRequestPermissionRationale(WifiLocationAllowActivity.this, "android.permission.ACCESS_COARSE_LOCATION")) || (!ActivityCompat.shouldShowRequestPermissionRationale(WifiLocationAllowActivity.this, "android.permission.ACCESS_FINE_LOCATION"))) {
        WifiLocationAllowActivity.f1(WifiLocationAllowActivity.this);
      }
    }
    
    public void b()
    {
      WifiLocationAllowActivity.e1(WifiLocationAllowActivity.this);
    }
  }
  
  class f
    implements View.OnClickListener
  {
    f() {}
    
    public void onClick(View paramView)
    {
      if (WifiLocationAllowActivity.i1(WifiLocationAllowActivity.this) != null) {
        WifiLocationAllowActivity.i1(WifiLocationAllowActivity.this).dismiss();
      }
      WifiLocationAllowActivity.f1(WifiLocationAllowActivity.this);
    }
  }
  
  class g
    implements View.OnClickListener
  {
    g() {}
    
    public void onClick(View paramView)
    {
      if (WifiLocationAllowActivity.i1(WifiLocationAllowActivity.this) != null) {
        WifiLocationAllowActivity.i1(WifiLocationAllowActivity.this).dismiss();
      }
      WifiLocationAllowActivity.this.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\bulb\WifiLocationAllowActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */