package com.tplink.iot.view.bulb.settings;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.Utils.x0.c;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.viewmodel.iotbulb.BulbSettingViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.widget.BulbBrightnessView;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.DefaultStatesBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.DefaultStatesBean.BrightnessBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.IoTBulbDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import java.util.List;

public class BulbDefaultStateActivity
  extends BaseActivity
{
  private BulbBrightnessView p0;
  private BulbSettingViewModel p1;
  private boolean p2 = false;
  private String y;
  private RadioGroup z;
  
  private DefaultStatesBean i1()
  {
    DefaultStatesBean localDefaultStatesBean = new DefaultStatesBean();
    DefaultStatesBean.BrightnessBean localBrightnessBean = new DefaultStatesBean.BrightnessBean();
    Object localObject;
    if (this.z.getCheckedRadioButtonId() == 2131363771) {
      localObject = "last_states";
    } else {
      localObject = "custom";
    }
    localBrightnessBean.setType((String)localObject);
    if (this.z.getCheckedRadioButtonId() == 2131363771) {
      localObject = null;
    } else {
      localObject = Integer.valueOf(this.p0.getBrightness());
    }
    localBrightnessBean.setValue((Integer)localObject);
    localDefaultStatesBean.setBrightness(localBrightnessBean);
    return localDefaultStatesBean;
  }
  
  private void j1()
  {
    b1(2131951846);
    this.z = ((RadioGroup)findViewById(2131363856));
    this.p0 = ((BulbBrightnessView)findViewById(2131362029));
    this.z.check(2131363771);
    this.p0.setVisibility(8);
    this.z.setOnCheckedChangeListener(new c());
  }
  
  private void k1()
  {
    this.p1.r().observe(this, new a());
    this.p1.p().observe(this, new b());
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558461);
    paramBundle = getIntent().getStringExtra("device_id_md5");
    this.y = paramBundle;
    this.p1 = ((BulbSettingViewModel)ViewModelProviders.of(this, new IoTViewModelFactory(this, paramBundle)).get(BulbSettingViewModel.class));
    j1();
    k1();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131623941, paramMenu);
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 2131362300)
    {
      DefaultStatesBean localDefaultStatesBean = i1();
      this.p1.D(i1());
      c.b(this.y, localDefaultStatesBean);
      finish();
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  class a
    implements Observer<IoTBulbDevice>
  {
    a() {}
    
    public void a(@Nullable IoTBulbDevice paramIoTBulbDevice)
    {
      if ((paramIoTBulbDevice != null) && (paramIoTBulbDevice.getDefaultStates() != null) && (paramIoTBulbDevice.getDefaultStates().getBrightness() != null))
      {
        paramIoTBulbDevice = paramIoTBulbDevice.getDefaultStates().getBrightness();
        if (!BulbDefaultStateActivity.e1(BulbDefaultStateActivity.this))
        {
          BulbDefaultStateActivity.f1(BulbDefaultStateActivity.this, true);
          if (TextUtils.equals(paramIoTBulbDevice.getType(), "custom"))
          {
            BulbDefaultStateActivity.g1(BulbDefaultStateActivity.this).check(2131363770);
            BulbDefaultStateActivity.h1(BulbDefaultStateActivity.this).setBrightness(paramIoTBulbDevice.getValue());
          }
          else
          {
            BulbDefaultStateActivity.g1(BulbDefaultStateActivity.this).check(2131363771);
          }
        }
      }
    }
  }
  
  class b
    implements Observer<List<Integer>>
  {
    b() {}
    
    public void a(@Nullable List<Integer> paramList)
    {
      BulbDefaultStateActivity.h1(BulbDefaultStateActivity.this).setPresets(paramList);
    }
  }
  
  class c
    implements RadioGroup.OnCheckedChangeListener
  {
    c() {}
    
    public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
    {
      if (paramInt == 2131363770) {
        BulbDefaultStateActivity.h1(BulbDefaultStateActivity.this).setVisibility(0);
      } else {
        BulbDefaultStateActivity.h1(BulbDefaultStateActivity.this).setVisibility(8);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\bulb\settings\BulbDefaultStateActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */