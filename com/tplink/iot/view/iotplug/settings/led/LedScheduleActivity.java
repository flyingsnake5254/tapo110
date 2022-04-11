package com.tplink.iot.view.iotplug.settings.led;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.Utils.n0;
import com.tplink.iot.Utils.o0;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.w;
import com.tplink.iot.Utils.w0.a;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.base.BaseLocationActivity;
import com.tplink.iot.viewmodel.iotplug.LedStatusViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.widget.ItemSunriseSunsetSetting;
import com.tplink.iot.widget.ItemSunriseSunsetSetting.b;
import com.tplink.iot.widget.TimeScrollPickerDialog;
import com.tplink.iot.widget.TimeScrollPickerDialog.a;
import com.tplink.libtpnetwork.IoTNetwork.bean.plug.result.LedInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.plug.result.LedNightModeBean;

public class LedScheduleActivity
  extends BaseLocationActivity
  implements View.OnClickListener, TimeScrollPickerDialog.a, ItemSunriseSunsetSetting.b
{
  private ItemSunriseSunsetSetting H3;
  private TextView I3;
  private TextView J3;
  private TextView K3;
  private int L3 = 1200;
  private int M3 = 420;
  private int N3 = 0;
  private int O3 = 0;
  private String P3;
  private LedStatusViewModel Q3;
  private LedNightModeBean R3;
  private String p0 = "tag_end_time";
  private MenuItem p1;
  private View p2;
  private ItemSunriseSunsetSetting p3;
  private String z = "tag_start_time";
  
  private LedInfoBean n1()
  {
    LedInfoBean localLedInfoBean = new LedInfoBean();
    localLedInfoBean.setLedRule("night_mode");
    LedNightModeBean localLedNightModeBean = new LedNightModeBean();
    if (this.p3.b())
    {
      localLedNightModeBean.setNightModeType("sunrise_sunset");
      localLedNightModeBean.setSunriseOffset(Integer.valueOf(this.O3));
      localLedNightModeBean.setSunsetOffset(Integer.valueOf(this.N3));
    }
    else
    {
      localLedNightModeBean.setNightModeType("custom");
      localLedNightModeBean.setStartTime(Integer.valueOf(this.Q3.i(this.L3)));
      localLedNightModeBean.setEndTime(Integer.valueOf(this.Q3.i(this.M3)));
    }
    localLedInfoBean.setNightMode(localLedNightModeBean);
    return localLedInfoBean;
  }
  
  private boolean o1()
  {
    LedNightModeBean localLedNightModeBean = this.R3;
    boolean bool1 = true;
    boolean bool2 = true;
    if (localLedNightModeBean == null) {
      return true;
    }
    if (TextUtils.equals(localLedNightModeBean.getNightModeType(), "sunrise_sunset"))
    {
      if (this.H3.b()) {
        return true;
      }
      bool3 = bool2;
      if (this.R3.getSunsetOffset() == this.N3) {
        if (this.R3.getSunriseOffset() != this.O3) {
          bool3 = bool2;
        } else {
          bool3 = false;
        }
      }
      return bool3;
    }
    boolean bool3 = bool1;
    if (TextUtils.equals(this.R3.getNightModeType(), "custom"))
    {
      if (this.p3.b()) {
        return true;
      }
      bool3 = bool1;
      if (this.R3.getStartTime() != null)
      {
        bool3 = bool1;
        if (this.R3.getEndTime() != null)
        {
          bool3 = bool1;
          if (this.Q3.j(this.R3.getStartTime().intValue()) == this.L3) {
            if (this.Q3.j(this.R3.getEndTime().intValue()) != this.M3) {
              bool3 = bool1;
            } else {
              bool3 = false;
            }
          }
        }
      }
    }
    return bool3;
  }
  
  public static void p1(Activity paramActivity, String paramString, LedNightModeBean paramLedNightModeBean)
  {
    Intent localIntent = new Intent(paramActivity, LedScheduleActivity.class);
    localIntent.putExtra("device_id_md5", paramString);
    localIntent.putExtra("night_mode_info", paramLedNightModeBean);
    paramActivity.startActivity(localIntent);
  }
  
  private void q1(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.p3.setChecked(true);
      this.H3.setChecked(false);
      this.p2.setVisibility(8);
    }
    else
    {
      this.p3.setChecked(false);
      this.H3.setChecked(true);
      this.p2.setVisibility(0);
    }
    MenuItem localMenuItem = this.p1;
    if (localMenuItem != null) {
      localMenuItem.setEnabled(o1());
    }
  }
  
  private void r1()
  {
    this.Q3.l().observe(this, new a());
  }
  
  public void h1()
  {
    if (k1(this.P3)) {
      q1(true);
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 101) && (paramIntent != null))
    {
      this.N3 = paramIntent.getIntExtra("tag_sunset_offset", 0);
      int i = paramIntent.getIntExtra("tag_sunrise_offset", 0);
      this.O3 = i;
      ItemSunriseSunsetSetting localItemSunriseSunsetSetting = this.p3;
      if ((this.N3 == 0) && (i == 0)) {
        i = 2131953209;
      } else {
        i = 2131953267;
      }
      localItemSunriseSunsetSetting.setOffset(getString(i));
      this.p1.setEnabled(o1());
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131364645: 
      n0.b(getSupportFragmentManager(), this.L3, true, false, this.M3, this, this.z);
      break;
    case 2131364450: 
    case 2131364539: 
      n0.b(getSupportFragmentManager(), this.M3, true, true, this.L3, this, this.p0);
      break;
    case 2131362971: 
      f1(this.P3);
      break;
    case 2131362899: 
      q1(false);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558554);
    paramBundle = getIntent().getStringExtra("device_id_md5");
    this.P3 = paramBundle;
    this.Q3 = ((LedStatusViewModel)ViewModelProviders.of(this, new IoTViewModelFactory(this, paramBundle)).get(LedStatusViewModel.class));
    this.R3 = ((LedNightModeBean)getIntent().getSerializableExtra("night_mode_info"));
    c1(getString(2131952896));
    this.p3 = ((ItemSunriseSunsetSetting)findViewById(2131362971));
    this.H3 = ((ItemSunriseSunsetSetting)findViewById(2131362899));
    this.p2 = findViewById(2131363297);
    this.I3 = ((TextView)findViewById(2131364645));
    this.J3 = ((TextView)findViewById(2131364450));
    this.K3 = ((TextView)findViewById(2131364539));
    this.p3.setOnClickListener(this);
    this.H3.setOnClickListener(this);
    this.p3.setOnOffsetSettingClickListener(this);
    this.I3.setOnClickListener(this);
    this.J3.setOnClickListener(this);
    this.K3.setOnClickListener(this);
    paramBundle = this.R3;
    int i = 0;
    int j;
    if (paramBundle != null) {
      if (TextUtils.equals("custom", paramBundle.getNightModeType()))
      {
        if (this.R3.getStartTime() == null) {
          j = 1200;
        } else {
          j = this.Q3.j(this.R3.getStartTime().intValue());
        }
        this.L3 = j;
        if (this.R3.getEndTime() == null) {
          j = 420;
        } else {
          j = this.Q3.j(this.R3.getEndTime().intValue());
        }
        this.M3 = j;
        q1(false);
      }
      else
      {
        this.O3 = this.R3.getSunriseOffset();
        this.N3 = this.R3.getSunsetOffset();
        q1(true);
      }
    }
    if (!k1(this.P3)) {
      q1(false);
    }
    paramBundle = this.p3;
    if ((this.N3 == 0) && (this.O3 == 0)) {
      j = 2131953209;
    } else {
      j = 2131953267;
    }
    paramBundle.setOffset(getString(j));
    this.I3.setText(o0.a(this, this.L3));
    this.J3.setText(o0.a(this, this.M3));
    paramBundle = this.K3;
    if (this.L3 > this.M3) {
      j = i;
    } else {
      j = 4;
    }
    paramBundle.setVisibility(j);
    if (!a.k(this.P3)) {
      findViewById(2131362971).setVisibility(8);
    }
    r1();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131623941, paramMenu);
    MenuItem localMenuItem = paramMenu.findItem(2131362300);
    this.p1 = localMenuItem;
    boolean bool;
    if (this.R3 == null) {
      bool = true;
    } else {
      bool = false;
    }
    localMenuItem.setEnabled(bool);
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  public void onOffsetSettingClick(View paramView)
  {
    if (paramView.getId() == 2131362971) {
      LedOffsetSettingActivity.e1(this, this.N3, this.O3);
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 2131362300)
    {
      this.Q3.m(n1());
      s0.l(this);
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  protected void onResume()
  {
    super.onResume();
    this.I3.setText(o0.a(this, this.L3));
    this.J3.setText(o0.a(this, this.M3));
  }
  
  public void z0(TimeScrollPickerDialog paramTimeScrollPickerDialog, int paramInt)
  {
    if (this.z.equals(paramTimeScrollPickerDialog.getTag()))
    {
      this.L3 = paramInt;
      this.I3.setText(o0.a(this, paramInt));
    }
    else if (this.p0.equals(paramTimeScrollPickerDialog.getTag()))
    {
      this.M3 = paramInt;
      this.J3.setText(o0.a(this, paramInt));
    }
    paramTimeScrollPickerDialog = this.K3;
    if (this.L3 > this.M3) {
      paramInt = 0;
    } else {
      paramInt = 4;
    }
    paramTimeScrollPickerDialog.setVisibility(paramInt);
    this.p1.setEnabled(o1());
  }
  
  class a
    implements Observer<Integer>
  {
    a() {}
    
    public void a(@Nullable Integer paramInteger)
    {
      
      if ((paramInteger != null) && (paramInteger.intValue() == 0))
      {
        LedScheduleActivity.this.finish();
      }
      else if ((paramInteger != null) && (paramInteger.intValue() == 64524))
      {
        w.f();
      }
      else
      {
        paramInteger = LedScheduleActivity.this;
        s0.p(paramInteger, paramInteger.getString(2131952444));
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\iotplug\settings\led\LedScheduleActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */