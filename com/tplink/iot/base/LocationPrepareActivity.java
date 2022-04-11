package com.tplink.iot.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialog;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.core.o;
import com.tplink.iot.view.quicksetup.base.ble.b;

public class LocationPrepareActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private ViewGroup p0;
  private TextView p1;
  private TPMaterialDialogV2 p2;
  private ImageView y;
  private ImageView z;
  
  private void i1()
  {
    if (com.tplink.iot.view.quicksetup.base.f.a.a(this)) {
      finish();
    }
  }
  
  private void j1()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("package:");
    localStringBuilder.append(getPackageName());
    startActivity(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse(localStringBuilder.toString())));
  }
  
  private void k1()
  {
    ((ImageView)findViewById(2131362826)).setOnClickListener(this);
    this.y = ((ImageView)findViewById(2131362841));
    this.z = ((ImageView)findViewById(2131362845));
    this.p0 = ((ViewGroup)findViewById(2131363377));
    this.p1 = ((TextView)findViewById(2131364571));
    this.y.setOnClickListener(this);
    this.p0.setOnClickListener(this);
  }
  
  private void l1()
  {
    m1();
    n1();
  }
  
  private void m1()
  {
    if (com.tplink.iot.view.quicksetup.base.f.a.b(this))
    {
      this.y.setEnabled(false);
      this.y.setImageResource(2131690248);
    }
    else
    {
      this.y.setEnabled(true);
      this.y.setImageResource(2131690425);
    }
  }
  
  private void n1()
  {
    if (com.tplink.iot.view.quicksetup.base.f.a.c(this))
    {
      this.p0.setEnabled(false);
      this.p1.setVisibility(8);
      this.z.setVisibility(0);
    }
    else
    {
      this.p0.setEnabled(true);
      this.p1.setVisibility(0);
      this.z.setVisibility(8);
    }
  }
  
  void o1()
  {
    Object localObject = this.p2;
    if ((localObject != null) && (((Dialog)localObject).isShowing())) {
      return;
    }
    localObject = LayoutInflater.from(this).inflate(2131559179, null, false);
    ((View)localObject).findViewById(2131364572).setOnClickListener(new a());
    ((View)localObject).findViewById(2131364571).setOnClickListener(new b());
    TPMaterialDialogV2.Builder localBuilder = new TPMaterialDialogV2.Builder(this);
    localBuilder.e((View)localObject);
    localBuilder.c(false);
    localBuilder.b(false);
    localBuilder.g(8, 8);
    localObject = localBuilder.a();
    this.p2 = ((TPMaterialDialogV2)localObject);
    ((TPMaterialDialogV2)localObject).show();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131362826)
    {
      if (i != 2131362841)
      {
        if (i == 2131363377) {
          b.c(this);
        }
      }
      else {
        startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
      }
    }
    else {
      finish();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (o.a() == 0) {
      return;
    }
    setContentView(2131558575);
    k1();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    TPMaterialDialogV2 localTPMaterialDialogV2 = this.p2;
    if (localTPMaterialDialogV2 != null)
    {
      localTPMaterialDialogV2.dismiss();
      this.p2 = null;
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt)
  {
    b.a(paramInt, paramArrayOfString, paramArrayOfInt, new c());
  }
  
  protected void onResume()
  {
    super.onResume();
    l1();
    i1();
  }
  
  class a
    implements View.OnClickListener
  {
    a() {}
    
    public void onClick(View paramView)
    {
      if (LocationPrepareActivity.e1(LocationPrepareActivity.this) != null) {
        LocationPrepareActivity.e1(LocationPrepareActivity.this).dismiss();
      }
    }
  }
  
  class b
    implements View.OnClickListener
  {
    b() {}
    
    public void onClick(View paramView)
    {
      if (LocationPrepareActivity.e1(LocationPrepareActivity.this) != null) {
        LocationPrepareActivity.e1(LocationPrepareActivity.this).dismiss();
      }
      LocationPrepareActivity.f1(LocationPrepareActivity.this);
    }
  }
  
  class c
    implements com.tplink.iot.view.quicksetup.base.ble.a
  {
    c() {}
    
    public void a()
    {
      if ((!ActivityCompat.shouldShowRequestPermissionRationale(LocationPrepareActivity.this, "android.permission.ACCESS_COARSE_LOCATION")) || (!ActivityCompat.shouldShowRequestPermissionRationale(LocationPrepareActivity.this, "android.permission.ACCESS_FINE_LOCATION"))) {
        LocationPrepareActivity.this.o1();
      }
    }
    
    public void b()
    {
      LocationPrepareActivity.g1(LocationPrepareActivity.this);
      LocationPrepareActivity.h1(LocationPrepareActivity.this);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\base\LocationPrepareActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */