package com.tplink.iot.view.quicksetup.ble;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback;
import androidx.fragment.app.FragmentActivity;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.view.quicksetup.base.ble.b;
import com.tplink.iot.view.quicksetup.base.ble.d;

public class LocationAllowActivity
  extends BaseActivity
  implements View.OnClickListener, ActivityCompat.OnRequestPermissionsResultCallback
{
  private TPMaterialDialogV2 p0;
  private TPMaterialDialogV2 p1;
  private String y;
  private TPMaterialDialogV2 z;
  
  private void k1()
  {
    if (d.b(this)) {
      n1();
    }
  }
  
  private void l1()
  {
    if (!d.d(this))
    {
      r1();
      return;
    }
    if (!d.f(this))
    {
      b.c(this);
      return;
    }
    if (!d.c(this))
    {
      s1();
      return;
    }
    n1();
  }
  
  private void m1()
  {
    Object localObject = getIntent();
    if (localObject != null)
    {
      localObject = ((Intent)localObject).getExtras();
      if (localObject != null) {
        this.y = ((Bundle)localObject).getString("device");
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("package:");
    localStringBuilder.append(getPackageName());
    startActivity(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse(localStringBuilder.toString())));
  }
  
  private void p1()
  {
    ((ImageView)findViewById(2131362826)).setOnClickListener(this);
    ((Button)findViewById(2131362037)).setOnClickListener(new a());
  }
  
  private void q1()
  {
    d.g(this);
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
    setContentView(2131558573);
    m1();
    p1();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (o.a() == 0) {
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
    b.a(paramInt, paramArrayOfString, paramArrayOfInt, new d());
  }
  
  protected void onResume()
  {
    super.onResume();
    k1();
  }
  
  protected void onSaveInstanceState(Bundle paramBundle) {}
  
  void r1()
  {
    Object localObject = this.z;
    if ((localObject != null) && (((Dialog)localObject).isShowing())) {
      return;
    }
    View localView = LayoutInflater.from(this).inflate(2131559102, null, false);
    localView.findViewById(2131364572).setOnClickListener(new b());
    localView.findViewById(2131364571).setOnClickListener(new c());
    localObject = new TPMaterialDialogV2.Builder(this);
    ((TPMaterialDialogV2.Builder)localObject).e(localView);
    ((TPMaterialDialogV2.Builder)localObject).c(false);
    ((TPMaterialDialogV2.Builder)localObject).b(false);
    ((TPMaterialDialogV2.Builder)localObject).g(8, 8);
    localObject = ((TPMaterialDialogV2.Builder)localObject).a();
    this.z = ((TPMaterialDialogV2)localObject);
    ((TPMaterialDialogV2)localObject).show();
  }
  
  void s1()
  {
    Object localObject = this.p1;
    if ((localObject != null) && (((Dialog)localObject).isShowing())) {
      return;
    }
    View localView = LayoutInflater.from(this).inflate(2131559100, null, false);
    localView.findViewById(2131364572).setOnClickListener(new g());
    localView.findViewById(2131364571).setOnClickListener(new h());
    localObject = new TPMaterialDialogV2.Builder(this);
    ((TPMaterialDialogV2.Builder)localObject).e(localView);
    ((TPMaterialDialogV2.Builder)localObject).c(false);
    ((TPMaterialDialogV2.Builder)localObject).b(false);
    ((TPMaterialDialogV2.Builder)localObject).g(8, 8);
    localObject = ((TPMaterialDialogV2.Builder)localObject).a();
    this.p1 = ((TPMaterialDialogV2)localObject);
    ((TPMaterialDialogV2)localObject).show();
  }
  
  void t1()
  {
    Object localObject = this.p0;
    if ((localObject != null) && (((Dialog)localObject).isShowing())) {
      return;
    }
    localObject = LayoutInflater.from(this).inflate(2131559101, null, false);
    ((View)localObject).findViewById(2131364572).setOnClickListener(new e());
    ((View)localObject).findViewById(2131364571).setOnClickListener(new f());
    TPMaterialDialogV2.Builder localBuilder = new TPMaterialDialogV2.Builder(this);
    localBuilder.e((View)localObject);
    localBuilder.c(false);
    localBuilder.b(false);
    localBuilder.g(8, 8);
    localObject = localBuilder.a();
    this.p0 = ((TPMaterialDialogV2)localObject);
    ((TPMaterialDialogV2)localObject).show();
  }
  
  class a
    extends com.tplink.iot.view.quicksetup.base.a
  {
    a() {}
    
    public void a(View paramView)
    {
      LocationAllowActivity.e1(LocationAllowActivity.this);
    }
  }
  
  class b
    implements View.OnClickListener
  {
    b() {}
    
    public void onClick(View paramView)
    {
      if (LocationAllowActivity.f1(LocationAllowActivity.this) != null) {
        LocationAllowActivity.f1(LocationAllowActivity.this).dismiss();
      }
    }
  }
  
  class c
    implements View.OnClickListener
  {
    c() {}
    
    public void onClick(View paramView)
    {
      if (LocationAllowActivity.f1(LocationAllowActivity.this) != null) {
        LocationAllowActivity.f1(LocationAllowActivity.this).dismiss();
      }
      LocationAllowActivity.g1(LocationAllowActivity.this);
    }
  }
  
  class d
    implements com.tplink.iot.view.quicksetup.base.ble.a
  {
    d() {}
    
    public void a()
    {
      if ((!ActivityCompat.shouldShowRequestPermissionRationale(LocationAllowActivity.this, "android.permission.ACCESS_COARSE_LOCATION")) || (!ActivityCompat.shouldShowRequestPermissionRationale(LocationAllowActivity.this, "android.permission.ACCESS_FINE_LOCATION"))) {
        LocationAllowActivity.this.t1();
      }
    }
    
    public void b()
    {
      LocationAllowActivity.e1(LocationAllowActivity.this);
    }
  }
  
  class e
    implements View.OnClickListener
  {
    e() {}
    
    public void onClick(View paramView)
    {
      if (LocationAllowActivity.h1(LocationAllowActivity.this) != null) {
        LocationAllowActivity.h1(LocationAllowActivity.this).dismiss();
      }
    }
  }
  
  class f
    implements View.OnClickListener
  {
    f() {}
    
    public void onClick(View paramView)
    {
      if (LocationAllowActivity.h1(LocationAllowActivity.this) != null) {
        LocationAllowActivity.h1(LocationAllowActivity.this).dismiss();
      }
      LocationAllowActivity.i1(LocationAllowActivity.this);
    }
  }
  
  class g
    implements View.OnClickListener
  {
    g() {}
    
    public void onClick(View paramView)
    {
      if (LocationAllowActivity.j1(LocationAllowActivity.this) != null) {
        LocationAllowActivity.j1(LocationAllowActivity.this).dismiss();
      }
    }
  }
  
  class h
    implements View.OnClickListener
  {
    h() {}
    
    public void onClick(View paramView)
    {
      if (LocationAllowActivity.j1(LocationAllowActivity.this) != null) {
        LocationAllowActivity.j1(LocationAllowActivity.this).dismiss();
      }
      LocationAllowActivity.this.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\ble\LocationAllowActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */