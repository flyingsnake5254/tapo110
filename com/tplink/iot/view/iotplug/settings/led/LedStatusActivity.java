package com.tplink.iot.view.iotplug.settings.led;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.Utils.o0;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.w;
import com.tplink.iot.Utils.w0.a;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.viewmodel.iotplug.LedStatusViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.widget.ItemSettingLayout;
import com.tplink.libtpcontrols.materialnormalcompat.radio.TPRadioButton;
import com.tplink.libtpcontrols.materialnormalcompat.radio.TPRadioButton.a;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.plug.result.LedInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.plug.result.LedNightModeBean;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.AbstractThingRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.PlugRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;

public class LedStatusActivity
  extends BaseActivity
  implements View.OnClickListener, TPRadioButton.a
{
  private LedStatusViewModel H3;
  boolean I3 = false;
  private boolean J3;
  private String K3;
  private ItemSettingLayout p0;
  private TPRadioButton p1;
  private String p2;
  private LedNightModeBean p3 = new LedNightModeBean();
  private RadioGroup y;
  private View z;
  
  private void f1()
  {
    LedNightModeBean localLedNightModeBean = this.p3;
    if ((localLedNightModeBean == null) || (TextUtils.isEmpty(localLedNightModeBean.getNightModeType())) || ((!"sunrise_sunset".equals(this.p3.getNightModeType())) && (!"custom".equals(this.p3.getNightModeType()))))
    {
      this.p3 = new LedNightModeBean();
      if ((this.I3) && (a.k(this.p2)))
      {
        this.p3.setNightModeType("sunrise_sunset");
        this.p3.setSunsetOffset(Integer.valueOf(0));
        this.p3.setSunriseOffset(Integer.valueOf(0));
      }
      else
      {
        this.p3.setNightModeType("custom");
        this.p3.setStartTime(Integer.valueOf(this.H3.i(1200)));
        this.p3.setEndTime(Integer.valueOf(this.H3.i(420)));
      }
    }
  }
  
  private LedInfoBean g1()
  {
    LedInfoBean localLedInfoBean = new LedInfoBean();
    localLedInfoBean.setLedRule(this.K3);
    if (TextUtils.equals(this.K3, "night_mode"))
    {
      f1();
      if (TextUtils.equals(this.p3.getNightModeType(), "custom"))
      {
        this.p3.setSunriseOffset(null);
        this.p3.setSunsetOffset(null);
      }
      else
      {
        this.p3.setStartTime(null);
        this.p3.setEndTime(null);
      }
      localLedInfoBean.setNightMode(this.p3);
    }
    return localLedInfoBean;
  }
  
  private SpannableString h1(String paramString1, String paramString2)
  {
    String str = String.format(getString(2131952897), new Object[] { paramString1, paramString2 });
    SpannableString localSpannableString = new SpannableString(str);
    int i = str.indexOf(paramString1);
    int j = str.indexOf(paramString2);
    localSpannableString.setSpan(new ForegroundColorSpan(getResources().getColor(2131099769)), i, paramString1.length() + i, 17);
    localSpannableString.setSpan(new ForegroundColorSpan(getResources().getColor(2131099769)), j, paramString2.length() + j, 17);
    return localSpannableString;
  }
  
  private int i1(String paramString)
  {
    if (TextUtils.equals(paramString, "never")) {
      return 2131364314;
    }
    if (TextUtils.equals(paramString, "night_mode")) {
      return 2131363764;
    }
    return 2131364315;
  }
  
  private void j1()
  {
    this.z.setVisibility(8);
    f1();
    if (TextUtils.equals("custom", this.p3.getNightModeType()))
    {
      int i = this.H3.j(this.p3.getStartTime().intValue());
      int j = this.H3.j(this.p3.getEndTime().intValue());
      this.p0.setItemInfo(h1(o0.a(this, i), o0.a(this, j)));
    }
    else
    {
      this.p0.setItemInfo(h1(getString(2131954171), getString(2131954168)));
    }
  }
  
  private void k1()
  {
    LocalIoTBaseDevice localLocalIoTBaseDevice = (LocalIoTBaseDevice)((PlugRepository)e.d(this.p2, PlugRepository.class)).j1().getValue();
    if (localLocalIoTBaseDevice != null) {
      this.I3 = localLocalIoTBaseDevice.isHasSetLocationInfo();
    }
  }
  
  private void l1()
  {
    c1(getString(2131952899));
    this.y = ((RadioGroup)findViewById(2131363854));
    this.z = findViewById(2131363332);
    Object localObject = (ItemSettingLayout)findViewById(2131362937);
    this.p0 = ((ItemSettingLayout)localObject);
    ((RelativeLayout)localObject).setOnClickListener(this);
    this.p1 = ((TPRadioButton)findViewById(2131364315));
    localObject = (TPRadioButton)findViewById(2131364314);
    TPRadioButton localTPRadioButton = (TPRadioButton)findViewById(2131363764);
    this.p1.setOnCheckedChangeListener(this);
    ((TPRadioButton)localObject).setOnCheckedChangeListener(this);
    localTPRadioButton.setOnCheckedChangeListener(this);
    m1();
  }
  
  private void m1()
  {
    BaseALIoTDevice localBaseALIoTDevice = this.H3.h();
    if (localBaseALIoTDevice == null) {
      return;
    }
    if (localBaseALIoTDevice.isHub()) {
      this.p1.setText(2131952442);
    }
  }
  
  public static void n1(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent(paramActivity, LedStatusActivity.class);
    localIntent.putExtra("device_id_md5", paramString);
    paramActivity.startActivity(localIntent);
  }
  
  private void o1()
  {
    this.H3.k().observe(this, new a());
    this.H3.l().observe(this, new b());
  }
  
  private void p1(LedInfoBean paramLedInfoBean)
  {
    if (paramLedInfoBean != null)
    {
      this.y.check(i1(paramLedInfoBean.getLedRule()));
      View localView = this.z;
      int i;
      if (i1(paramLedInfoBean.getLedRule()) == 2131363764) {
        i = 0;
      } else {
        i = 8;
      }
      localView.setVisibility(i);
      if ((paramLedInfoBean.getNightMode() != null) && (!TextUtils.isEmpty(paramLedInfoBean.getNightMode().getNightModeType())))
      {
        paramLedInfoBean = paramLedInfoBean.getNightMode();
        this.p3 = paramLedInfoBean;
        if (TextUtils.equals("custom", paramLedInfoBean.getNightModeType()))
        {
          i = this.H3.j(this.p3.getStartTime().intValue());
          int j = this.H3.j(this.p3.getEndTime().intValue());
          this.p0.setItemInfo(h1(o0.a(this, i), o0.a(this, j)));
        }
        else
        {
          this.p0.setItemInfo(h1(getString(2131954171), getString(2131954168)));
        }
      }
    }
  }
  
  public void c(CompoundButton paramCompoundButton, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      switch (paramCompoundButton.getId())
      {
      default: 
        break;
      case 2131364315: 
        this.K3 = "always";
        this.z.setVisibility(8);
        break;
      case 2131364314: 
        this.K3 = "never";
        this.z.setVisibility(8);
        break;
      case 2131363764: 
        this.K3 = "night_mode";
        this.z.setVisibility(0);
      }
      this.H3.m(g1());
      s0.l(this);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131362937) {
      LedScheduleActivity.p1(this, this.p2, this.p3);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558555);
    this.J3 = o0.p(this);
    paramBundle = getIntent().getStringExtra("device_id_md5");
    this.p2 = paramBundle;
    this.H3 = ((LedStatusViewModel)ViewModelProviders.of(this, new IoTViewModelFactory(this, paramBundle)).get(LedStatusViewModel.class));
    k1();
    l1();
    j1();
    o1();
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.J3 != o0.p(this))
    {
      LedNightModeBean localLedNightModeBean = this.p3;
      if ((localLedNightModeBean != null) && (TextUtils.equals(localLedNightModeBean.getNightModeType(), "custom")))
      {
        int i = this.H3.j(this.p3.getStartTime().intValue());
        int j = this.H3.j(this.p3.getEndTime().intValue());
        this.p0.setItemInfo(h1(o0.a(this, i), o0.a(this, j)));
      }
    }
  }
  
  class a
    implements Observer<LedInfoBean>
  {
    a() {}
    
    public void a(@Nullable LedInfoBean paramLedInfoBean)
    {
      LedStatusActivity.e1(LedStatusActivity.this, paramLedInfoBean);
    }
  }
  
  class b
    implements Observer<Integer>
  {
    b() {}
    
    public void a(@Nullable Integer paramInteger)
    {
      
      if ((paramInteger != null) && (paramInteger.intValue() == 64524))
      {
        w.f();
      }
      else if ((paramInteger != null) && (paramInteger.intValue() == -1))
      {
        paramInteger = LedStatusActivity.this;
        s0.p(paramInteger, paramInteger.getString(2131952444));
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\iotplug\settings\led\LedStatusActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */