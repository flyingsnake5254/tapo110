package com.tplink.iot.view.colorbulb.settings;

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
import com.tplink.iot.widget.colorbulb.ColorPresetEditWrapView;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.DefaultStatesBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.IoTBulbDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;

public class ColorBulbDefaultStateActivity
  extends BaseActivity
{
  private ColorPresetEditWrapView p0;
  private BulbSettingViewModel p1;
  private boolean p2 = false;
  private String y;
  private RadioGroup z;
  
  private DefaultStatesBean i1()
  {
    DefaultStatesBean localDefaultStatesBean = new DefaultStatesBean();
    if (this.z.getCheckedRadioButtonId() == 2131363771)
    {
      localDefaultStatesBean.setType("last_states");
      localDefaultStatesBean.setLightState(null);
    }
    else
    {
      localDefaultStatesBean.setType("custom");
      localDefaultStatesBean.setLightState(this.p0.getLightState());
    }
    return localDefaultStatesBean;
  }
  
  private void j1()
  {
    b1(2131951846);
    this.z = ((RadioGroup)findViewById(2131363856));
    this.p0 = ((ColorPresetEditWrapView)findViewById(2131362282));
    this.z.setOnCheckedChangeListener(new b());
  }
  
  private void k1()
  {
    this.p1.r().observe(this, new a());
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558483);
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
      if ((paramIoTBulbDevice != null) && (paramIoTBulbDevice.getDefaultStates() != null) && (paramIoTBulbDevice.getDefaultStates().getType() != null))
      {
        String str = paramIoTBulbDevice.getDefaultStates().getType();
        if (!ColorBulbDefaultStateActivity.e1(ColorBulbDefaultStateActivity.this))
        {
          ColorBulbDefaultStateActivity.f1(ColorBulbDefaultStateActivity.this, true);
          if (TextUtils.equals(str, "custom")) {
            ColorBulbDefaultStateActivity.g1(ColorBulbDefaultStateActivity.this).check(2131363770);
          } else {
            ColorBulbDefaultStateActivity.g1(ColorBulbDefaultStateActivity.this).check(2131363771);
          }
          paramIoTBulbDevice = paramIoTBulbDevice.getDefaultStates().getLightState();
          ColorBulbDefaultStateActivity.h1(ColorBulbDefaultStateActivity.this).setLightStates(paramIoTBulbDevice);
        }
      }
    }
  }
  
  class b
    implements RadioGroup.OnCheckedChangeListener
  {
    b() {}
    
    public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
    {
      paramRadioGroup = ColorBulbDefaultStateActivity.h1(ColorBulbDefaultStateActivity.this);
      if (paramInt == 2131363770) {
        paramInt = 0;
      } else {
        paramInt = 8;
      }
      paramRadioGroup.setVisibility(paramInt);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\colorbulb\settings\ColorBulbDefaultStateActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */