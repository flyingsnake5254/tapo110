package com.tplink.iot.view.welcome;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import b.d.n.f.b;
import b.d.n.i.g;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.u;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.model.about.c;
import com.tplink.iot.view.login.LoginActivity;
import com.tplink.iot.view.main.MainActivity;
import com.tplink.iot.viewmodel.welcome.StartupViewModel;

public class StartupActivity
  extends BaseActivity
{
  private String H3;
  private Integer I3 = null;
  private String J3;
  private String K3;
  private String p0;
  private String p1;
  private boolean p2 = false;
  private boolean p3 = false;
  private StartupViewModel y = null;
  private String z;
  
  private void j1(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      this.z = paramIntent.getStringExtra("fcm_device_id");
      this.p0 = paramIntent.getStringExtra("fcm_event_time");
      this.p1 = paramIntent.getStringExtra("notification_msg_type");
      this.H3 = paramIntent.getStringExtra("task_id");
      this.J3 = paramIntent.getStringExtra("deviceId");
      this.K3 = paramIntent.getStringExtra("summaryDate");
    }
  }
  
  private void k1()
  {
    b.l().clear();
    com.tplink.iot.Utils.p.c();
    s0.g();
    W0(LoginActivity.class);
    overridePendingTransition(2130772063, 2130772064);
    finish();
  }
  
  private void l1(boolean paramBoolean)
  {
    this.y.t(paramBoolean);
  }
  
  private void m1(Integer paramInteger)
  {
    if (paramInteger != null)
    {
      int i = paramInteger.intValue();
      if (i != 0)
      {
        if (i != 1) {
          k1();
        } else {
          k1();
        }
      }
      else
      {
        com.tplink.iot.Utils.x0.p.i();
        paramInteger = new Intent(this, MainActivity.class);
        paramInteger.addFlags(67108864);
        if (!TextUtils.isEmpty(this.H3))
        {
          paramInteger.putExtra("task_id", this.H3);
          this.H3 = null;
        }
        String str = this.z;
        if ((str != null) && (this.p0 != null))
        {
          paramInteger.putExtra("fcm_device_id", str);
          paramInteger.putExtra("fcm_event_time", this.p0);
          paramInteger.putExtra("notification_msg_type", this.p1);
          this.z = null;
          this.p0 = null;
          this.p1 = null;
        }
        if (!TextUtils.isEmpty(this.J3)) {
          paramInteger.putExtra("deviceId", this.J3);
        }
        if (!TextUtils.isEmpty(this.K3)) {
          paramInteger.putExtra("summaryDate", this.K3);
        }
        startActivity(paramInteger);
        finish();
      }
    }
  }
  
  private void p1()
  {
    Window localWindow = getWindow();
    localWindow.clearFlags(67108864);
    localWindow.addFlags(Integer.MIN_VALUE);
    localWindow.setStatusBarColor(0);
    int i = localWindow.getDecorView().getSystemUiVisibility();
    localWindow.getDecorView().setSystemUiVisibility(i | 0x400 | 0x200 | 0x100);
  }
  
  private void q1(boolean paramBoolean)
  {
    l1(paramBoolean);
  }
  
  private void r1()
  {
    c.l();
    this.y.n().observe(this, new a());
    this.y.m().observe(this, new b());
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (o.a() == 0) {
      return;
    }
    if ((getIntent().getFlags() & 0x400000) != 0)
    {
      finish();
      return;
    }
    p1();
    setContentView(2131558680);
    this.y = ((StartupViewModel)ViewModelProviders.of(this).get(StartupViewModel.class));
    u.a(this);
    b.l().h(new a(this));
    b.l().d(this);
    this.y.p();
    r1();
    j1(getIntent());
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    j1(paramIntent);
  }
  
  protected void onResume()
  {
    super.onResume();
    if (o.a() == 0) {
      return;
    }
    this.y.v();
  }
  
  class a
    implements Observer<Boolean>
  {
    a() {}
    
    public void a(@Nullable Boolean paramBoolean)
    {
      if ((paramBoolean != null) && (paramBoolean.booleanValue())) {
        StartupActivity.e1(StartupActivity.this, false);
      } else {
        StartupActivity.e1(StartupActivity.this, true);
      }
    }
  }
  
  class b
    implements Observer<Integer>
  {
    b() {}
    
    public void a(@Nullable Integer paramInteger)
    {
      if ((StartupActivity.f1(StartupActivity.this)) || (paramInteger == null)) {
        StartupActivity.g1(StartupActivity.this, paramInteger);
      }
      StartupActivity.h1(StartupActivity.this, true);
      StartupActivity.i1(StartupActivity.this, paramInteger);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\welcome\StartupActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */