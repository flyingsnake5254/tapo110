package com.tplink.iot.view.ipcamera.setting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityAutoRebootBinding;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.setting.AutoRebootSettingViewModel;
import com.tplink.iot.widget.NumberPickerView;
import com.tplink.iot.widget.h;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import com.tplink.libtpnetwork.cameranetwork.model.OptionSwitch;
import com.tplink.libtpnetwork.cameranetwork.model.RebootInfoCache;

public class AutoRebootActivity
  extends BaseActivity
{
  private ActivityAutoRebootBinding p0;
  private MenuItem p1;
  private int p2 = 180;
  private final String[] y = h.g();
  private AutoRebootSettingViewModel z;
  
  private int k1(int paramInt)
  {
    return paramInt / 30 % 48;
  }
  
  private void l1()
  {
    b1(2131953806);
    this.p0.y.S(this.y);
    this.p0.y.setValue(k1(this.p2));
    this.p0.x.setText(this.y[k1(this.p2)]);
    this.p0.y.setOnValueChangedListener(new u(this));
    this.p0.c.setOnCheckedChangeListener(new t(this));
    this.p0.d.setOnClickListener(new s(this));
  }
  
  private boolean m1()
  {
    AutoRebootSettingViewModel localAutoRebootSettingViewModel = this.z;
    RebootInfoCache localRebootInfoCache = localAutoRebootSettingViewModel.f;
    boolean bool1 = true;
    boolean bool2 = bool1;
    if (localRebootInfoCache != null)
    {
      int i = localAutoRebootSettingViewModel.h(localRebootInfoCache.getTime()) / 30;
      boolean bool3 = this.p0.c.isChecked();
      boolean bool4;
      if (this.z.f.getEnable() == OptionSwitch.ON) {
        bool4 = true;
      } else {
        bool4 = false;
      }
      bool2 = bool1;
      if (bool3 == bool4) {
        if (this.p2 != i * 30) {
          bool2 = bool1;
        } else {
          bool2 = false;
        }
      }
    }
    return bool2;
  }
  
  public static void t1(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent(paramActivity, AutoRebootActivity.class);
    localIntent.putExtra("device_id_md5", paramString);
    paramActivity.startActivity(localIntent);
  }
  
  private void u1()
  {
    this.z.f().observe(this, new a());
    this.z.g().observe(this, new b());
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.p0 = ((ActivityAutoRebootBinding)DataBindingUtil.setContentView(this, 2131558448));
    paramBundle = (AutoRebootSettingViewModel)ViewModelProviders.of(this, new CameraViewModelFactory(this, getIntent().getStringExtra("device_id_md5"))).get(AutoRebootSettingViewModel.class);
    this.z = paramBundle;
    this.p0.h(paramBundle);
    l1();
    this.z.u();
    u1();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131623941, paramMenu);
    MenuItem localMenuItem = paramMenu.findItem(2131362300);
    this.p1 = localMenuItem;
    localMenuItem.setEnabled(false);
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 2131362300) {
      this.z.w(this.p0.c.isChecked(), this.p2);
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  class a
    implements Observer<RebootInfoCache>
  {
    a() {}
    
    public void a(RebootInfoCache paramRebootInfoCache)
    {
      if (paramRebootInfoCache != null)
      {
        Object localObject = AutoRebootActivity.this;
        AutoRebootActivity.f1((AutoRebootActivity)localObject, AutoRebootActivity.g1((AutoRebootActivity)localObject).h(paramRebootInfoCache.getTime()) / 30 * 30);
        localObject = paramRebootInfoCache.getEnable();
        paramRebootInfoCache = OptionSwitch.ON;
        int i = 0;
        boolean bool;
        if (localObject == paramRebootInfoCache) {
          bool = true;
        } else {
          bool = false;
        }
        AutoRebootActivity.h1(AutoRebootActivity.this).c.setChecked(bool);
        localObject = AutoRebootActivity.h1(AutoRebootActivity.this).y;
        paramRebootInfoCache = AutoRebootActivity.this;
        ((NumberPickerView)localObject).setValue(AutoRebootActivity.i1(paramRebootInfoCache, AutoRebootActivity.e1(paramRebootInfoCache)));
        localObject = AutoRebootActivity.h1(AutoRebootActivity.this).x;
        String[] arrayOfString = AutoRebootActivity.j1(AutoRebootActivity.this);
        paramRebootInfoCache = AutoRebootActivity.this;
        ((TextView)localObject).setText(arrayOfString[AutoRebootActivity.i1(paramRebootInfoCache, AutoRebootActivity.e1(paramRebootInfoCache))]);
        paramRebootInfoCache = AutoRebootActivity.h1(AutoRebootActivity.this).f;
        if (!bool) {
          i = 8;
        }
        paramRebootInfoCache.setVisibility(i);
      }
    }
  }
  
  class b
    implements Observer<Integer>
  {
    b() {}
    
    public void a(Integer paramInteger)
    {
      if (paramInteger != null) {
        if (paramInteger.intValue() == 0)
        {
          AutoRebootActivity.this.finish();
        }
        else if (paramInteger.intValue() == -1)
        {
          paramInteger = AutoRebootActivity.this;
          s0.p(paramInteger, paramInteger.getString(2131952444));
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\setting\AutoRebootActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */