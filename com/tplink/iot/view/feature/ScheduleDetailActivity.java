package com.tplink.iot.view.feature;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.Utils.StatusBarUtils;
import com.tplink.iot.Utils.n0;
import com.tplink.iot.Utils.o0;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.s0.h;
import com.tplink.iot.Utils.w;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.base.BaseLocationActivity;
import com.tplink.iot.cloud.enumerate.RuleTimeType;
import com.tplink.iot.devices.lightstrip.widget.LightingEffectPresetStatusView;
import com.tplink.iot.devices.lightstrip.widget.LightingEffectPresetStatusView.d;
import com.tplink.iot.viewmodel.iotcommon.feature.ScheduleViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.widget.BulbBrightnessView;
import com.tplink.iot.widget.BulbBrightnessView.c;
import com.tplink.iot.widget.InnerTimePicker;
import com.tplink.iot.widget.InnerTimePicker.a;
import com.tplink.iot.widget.ItemSunriseSunsetSetting;
import com.tplink.iot.widget.ItemSunriseSunsetSetting.b;
import com.tplink.iot.widget.TimeOffsetPickerDialog;
import com.tplink.iot.widget.TimeOffsetPickerDialog.a;
import com.tplink.iot.widget.WeekdayPickerView;
import com.tplink.iot.widget.WeekdayPickerView.a;
import com.tplink.iot.widget.colorbulb.ColorBulbPresetStatusView;
import com.tplink.iot.widget.colorbulb.ColorBulbPresetStatusView.a;
import com.tplink.iot.widget.trv.TemperatureSeekBarLayout;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.DesiredStatesBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.ScheduleRuleBean;
import com.tplink.libtpnetwork.enumerate.EnumTemperatureUnit;
import java.util.List;

public class ScheduleDetailActivity
  extends BaseLocationActivity
  implements View.OnClickListener, RadioGroup.OnCheckedChangeListener, InnerTimePicker.a, TimeOffsetPickerDialog.a, ItemSunriseSunsetSetting.b
{
  private ItemSunriseSunsetSetting H3;
  private ItemSunriseSunsetSetting I3;
  private ItemSunriseSunsetSetting J3;
  private View K3;
  private WeekdayPickerView L3;
  private InnerTimePicker M3;
  private ImageView N3;
  private Animation O3;
  private Button P3;
  private View Q3;
  private View R3;
  private int S3 = -1;
  private BulbBrightnessView T3;
  private ColorBulbPresetStatusView U3;
  private LightingEffectPresetStatusView V3;
  private TemperatureSeekBarLayout W3;
  public ScheduleViewModel X3;
  protected ScheduleRuleBean Y3 = new ScheduleRuleBean();
  protected ScheduleRuleBean Z3 = new ScheduleRuleBean();
  private String a4;
  private String b4 = "on";
  private RuleTimeType c4 = RuleTimeType.NORMAL;
  private int d4 = 1;
  private int e4;
  private int f4 = 0;
  private int g4 = 0;
  private int h4;
  private boolean i4;
  private boolean j4;
  private MenuItem p0;
  private RadioGroup p1;
  private RadioButton p2;
  private RadioButton p3;
  private final Activity z = this;
  
  private void A1()
  {
    ScheduleViewModel localScheduleViewModel = this.X3;
    if (localScheduleViewModel.o) {
      this.V3.setVisibility(0);
    } else if (this.i4) {
      this.U3.setVisibility(0);
    } else if (localScheduleViewModel.l) {
      this.T3.setVisibility(0);
    } else if (this.j4) {
      this.W3.setVisibility(0);
    }
  }
  
  private void B1()
  {
    InnerTimePicker localInnerTimePicker = this.M3;
    int i;
    if (this.c4 == RuleTimeType.NORMAL) {
      i = 0;
    } else {
      i = 8;
    }
    localInnerTimePicker.setVisibility(i);
    y1(this.c4);
    L1(this.c4);
  }
  
  private void C1()
  {
    int i = this.d4;
    boolean bool1 = true;
    if (i == 1) {
      i = 2131953371;
    } else {
      i = 2131953373;
    }
    c1(getString(i));
    StatusBarUtils.n(this, ContextCompat.getColor(this, 2131099771));
    this.N3 = ((ImageView)findViewById(2131363026));
    this.Q3 = findViewById(2131364793);
    this.O3 = AnimationUtils.loadAnimation(this, 2130771982);
    this.R3 = findViewById(2131362483);
    Object localObject = (WeekdayPickerView)findViewById(2131364834);
    this.L3 = ((WeekdayPickerView)localObject);
    ((WeekdayPickerView)localObject).setDescriptionVisibility(true);
    this.L3.setWeekDay(127);
    this.L3.setOnWeekPickClick(new g());
    this.K3 = findViewById(2131362661);
    this.S3 = ContextCompat.getColor(this, 2131100206);
    localObject = (BulbBrightnessView)findViewById(2131362029);
    this.T3 = ((BulbBrightnessView)localObject);
    ((BulbBrightnessView)localObject).setOnProgressBarChangeListener(new h());
    localObject = (ColorBulbPresetStatusView)findViewById(2131363688);
    this.U3 = ((ColorBulbPresetStatusView)localObject);
    ((ColorBulbPresetStatusView)localObject).setFragmentManager(getSupportFragmentManager());
    if (this.d4 == 1) {
      this.U3.setDesiredStates(null);
    }
    this.U3.setOnPresetStatusListener(new i());
    this.U3.k(this.X3.o());
    this.U3.getHeaderTextView().setBackgroundColor(this.S3);
    localObject = (LightingEffectPresetStatusView)findViewById(2131363237);
    this.V3 = ((LightingEffectPresetStatusView)localObject);
    ((LightingEffectPresetStatusView)localObject).setFragmentManager(getSupportFragmentManager());
    this.V3.setDeviceIdMD5(this.a4);
    this.V3.setOnPresetStatusChangedListener(new j());
    this.V3.setAutoLightViewVisible(this.X3.n);
    this.V3.setAutoLightMode(this.X3.o());
    if (this.d4 == 1) {
      this.V3.setDesiredStates(null);
    }
    this.V3.getHeaderTextView().setBackgroundColor(this.S3);
    localObject = (TemperatureSeekBarLayout)findViewById(2131364168);
    this.W3 = ((TemperatureSeekBarLayout)localObject);
    ((TemperatureSeekBarLayout)localObject).setOnProgressBarChangeListener(new c(this));
    this.W3.setHeaderTextViewVisible(false);
    localObject = (RadioGroup)findViewById(2131363858);
    this.p1 = ((RadioGroup)localObject);
    ((RadioGroup)localObject).setOnCheckedChangeListener(this);
    this.p2 = ((RadioButton)findViewById(2131364315));
    this.p3 = ((RadioButton)findViewById(2131364314));
    localObject = (InnerTimePicker)findViewById(2131362862);
    this.M3 = ((InnerTimePicker)localObject);
    ((InnerTimePicker)localObject).setOnTimePickerChangeListener(this);
    localObject = (Button)findViewById(2131362046);
    this.P3 = ((Button)localObject);
    if (this.d4 == 1)
    {
      ((Button)localObject).setVisibility(8);
      i = com.tplink.iot.view.iotplug.c.a.a() + 2;
      this.e4 = i;
      this.M3.setMinuteOfDay(i);
    }
    else
    {
      ((Button)localObject).setVisibility(0);
      this.P3.setOnClickListener(this);
    }
    this.H3 = ((ItemSunriseSunsetSetting)findViewById(2131362969));
    this.I3 = ((ItemSunriseSunsetSetting)findViewById(2131362972));
    this.J3 = ((ItemSunriseSunsetSetting)findViewById(2131362899));
    this.H3.setOnClickListener(this);
    this.I3.setOnClickListener(this);
    this.J3.setOnClickListener(this);
    this.H3.setOnOffsetSettingClickListener(this);
    this.I3.setOnOffsetSettingClickListener(this);
    this.J3.setOnOffsetSettingClickListener(this);
    if (!com.tplink.iot.Utils.w0.a.k(this.a4))
    {
      this.H3.setVisibility(8);
      this.I3.setVisibility(8);
    }
    localObject = this.X3;
    this.i4 = ((ScheduleViewModel)localObject).m;
    boolean bool2;
    if ((((ScheduleViewModel)localObject).p) && (((ScheduleViewModel)localObject).q)) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    this.j4 = bool2;
    A1();
    D1();
    if (this.p1.getCheckedRadioButtonId() == 2131364315) {
      bool2 = bool1;
    } else {
      bool2 = false;
    }
    O1(bool2);
  }
  
  private void D1()
  {
    if (this.j4)
    {
      this.p2.setText(2131953997);
      this.p3.setText(2131953962);
    }
  }
  
  public static void J1(Context paramContext, ScheduleRuleBean paramScheduleRuleBean, String paramString)
  {
    Intent localIntent = new Intent(paramContext, ScheduleDetailActivity.class);
    localIntent.putExtra("device_id_md5", paramString);
    if (paramScheduleRuleBean != null)
    {
      localIntent.putExtra("SCHEDULE_ITEM", paramScheduleRuleBean);
      localIntent.putExtra("plug_page_mode", 2);
    }
    else
    {
      localIntent.putExtra("plug_page_mode", 1);
    }
    paramContext.startActivity(localIntent);
  }
  
  private void K1(ScheduleRuleBean paramScheduleRuleBean)
  {
    if (paramScheduleRuleBean == null) {
      return;
    }
    this.Y3.cloneOther(paramScheduleRuleBean);
    M1(this.Y3.getDesiredStates());
    Object localObject = paramScheduleRuleBean.getStartTimeType();
    this.c4 = ((RuleTimeType)localObject);
    if (localObject == RuleTimeType.SUNRISE) {
      this.f4 = paramScheduleRuleBean.getTimeOffset();
    } else if (localObject == RuleTimeType.SUNSET) {
      this.g4 = paramScheduleRuleBean.getTimeOffset();
    }
    this.L3.setWeekDay(paramScheduleRuleBean.getWeekOfDays());
    this.L3.setOnWeekPickClick(new b());
    int i = this.X3.u(paramScheduleRuleBean.getStartTimeMin());
    this.e4 = i;
    if (this.c4 == RuleTimeType.NORMAL) {
      this.M3.setMinuteOfDay(i);
    } else {
      this.M3.setMinuteOfDay(com.tplink.iot.view.iotplug.c.a.a() + 2);
    }
    localObject = paramScheduleRuleBean.getDesiredStates();
    boolean bool2;
    if (localObject != null)
    {
      if (this.j4)
      {
        boolean bool1 = ((DesiredStatesBean)localObject).isFrostProtectionOn() ^ true;
        bool2 = bool1;
        if (bool1)
        {
          this.W3.setTemperature(((DesiredStatesBean)localObject).getTargetTemp());
          this.W3.setTemperatureUnit(EnumTemperatureUnit.fromString(((DesiredStatesBean)localObject).getTempUnit()));
          bool2 = bool1;
        }
      }
      else
      {
        bool2 = ((DesiredStatesBean)localObject).isOn();
        if (bool2)
        {
          this.T3.setBrightness(((DesiredStatesBean)localObject).getBrightness());
          this.U3.setDesiredStates((DesiredStatesBean)localObject);
          this.V3.setDesiredStates((DesiredStatesBean)localObject);
        }
        else
        {
          this.T3.setBrightness(50);
          this.U3.setDesiredStates(null);
          this.V3.setDesiredStates(null);
        }
      }
    }
    else {
      bool2 = paramScheduleRuleBean.isActionOn();
    }
    if (bool2) {
      paramScheduleRuleBean = "on";
    } else {
      paramScheduleRuleBean = "off";
    }
    this.b4 = paramScheduleRuleBean;
    O1(bool2);
    paramScheduleRuleBean = this.p1;
    if (bool2) {
      i = 2131364315;
    } else {
      i = 2131364314;
    }
    paramScheduleRuleBean.check(i);
    B1();
  }
  
  private void L1(RuleTimeType paramRuleTimeType)
  {
    if (paramRuleTimeType == RuleTimeType.SUNSET) {
      this.I3.setOffset(o0.n(this.z, this.g4));
    } else if (paramRuleTimeType == RuleTimeType.SUNRISE) {
      this.H3.setOffset(o0.n(this.z, this.f4));
    }
  }
  
  private void M1(DesiredStatesBean paramDesiredStatesBean)
  {
    if (paramDesiredStatesBean == null) {
      return;
    }
    paramDesiredStatesBean.isTRV = this.j4;
  }
  
  private void N1()
  {
    if (this.d4 == 1)
    {
      this.X3.x().observe(this, new a());
    }
    else
    {
      this.X3.y().observe(this, new c());
      this.X3.A().observe(this, new d());
    }
    this.X3.p().observe(this, new e());
    this.X3.r().observe(this, new f());
    this.X3.w().observe(this, new b(this));
    this.X3.C().observe(this, new a(this));
  }
  
  private void O1(boolean paramBoolean)
  {
    boolean bool = this.X3.l;
    int i = 1;
    int j = 0;
    int k;
    if ((!bool) && (!this.j4)) {
      k = 0;
    } else {
      k = 1;
    }
    if ((paramBoolean) && (k != 0)) {
      k = i;
    } else {
      k = 0;
    }
    if (k != 0) {
      i = 0;
    } else {
      i = 8;
    }
    this.K3.setVisibility(i);
    View localView = this.R3;
    i = j;
    if (k != 0) {
      i = 8;
    }
    localView.setVisibility(i);
    if (k != 0)
    {
      this.p2.setBackground(ContextCompat.getDrawable(this, 2131230897));
      this.p3.setBackground(ContextCompat.getDrawable(this, 2131230899));
    }
    else
    {
      this.p2.setBackgroundColor(this.S3);
      this.p3.setBackgroundColor(this.S3);
    }
  }
  
  private void x1(boolean paramBoolean)
  {
    MenuItem localMenuItem = this.p0;
    if (localMenuItem != null) {
      localMenuItem.setEnabled(paramBoolean);
    }
  }
  
  private void y1(RuleTimeType paramRuleTimeType)
  {
    if (paramRuleTimeType == RuleTimeType.SUNSET)
    {
      this.I3.setChecked(true);
      this.H3.setChecked(false);
      this.J3.setChecked(false);
    }
    else if (paramRuleTimeType == RuleTimeType.SUNRISE)
    {
      this.I3.setChecked(false);
      this.H3.setChecked(true);
      this.J3.setChecked(false);
    }
    else
    {
      this.I3.setChecked(false);
      this.H3.setChecked(false);
      this.J3.setChecked(true);
    }
  }
  
  private void z1()
  {
    if (this.d4 == 1) {
      return;
    }
    w1();
    if ((this.Y3 != null) && (this.Z3 != null))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mOriScheduleRuleBean=");
      ((StringBuilder)localObject).append(com.tplink.libtpnetwork.Utils.i.j(this.Y3));
      b.d.w.c.a.e("test", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mScheduleRuleBean=");
      ((StringBuilder)localObject).append(com.tplink.libtpnetwork.Utils.i.j(this.Z3));
      b.d.w.c.a.e("test", ((StringBuilder)localObject).toString());
      localObject = this.Y3.getDesiredStates();
      int i = 0;
      boolean bool;
      if (localObject == null)
      {
        if (this.Z3.getDesiredStates() != null) {
          bool = false;
        } else {
          bool = true;
        }
      }
      else
      {
        bool = this.Y3.getDesiredStates().equals(this.Z3.getDesiredStates());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("isDesiredStatesSame=");
        ((StringBuilder)localObject).append(bool);
        b.d.w.c.a.e("test", ((StringBuilder)localObject).toString());
      }
      if ((bool) && (this.Y3.getWeekOfDays() == this.Z3.getWeekOfDays()) && (this.Y3.getStartTimeType() == this.Z3.getStartTimeType()))
      {
        localObject = this.Y3.getStartTimeType();
        RuleTimeType localRuleTimeType = RuleTimeType.NORMAL;
        int j;
        if ((localObject != localRuleTimeType) || (this.Z3.getStartTimeMin() != this.Y3.getStartTimeMin()))
        {
          j = i;
          if (this.Y3.getStartTimeType() != localRuleTimeType)
          {
            j = i;
            if (this.Z3.getTimeOffset() != this.Y3.getTimeOffset()) {}
          }
        }
        else
        {
          j = 1;
        }
        x1(j ^ 0x1);
      }
      else
      {
        x1(true);
      }
    }
  }
  
  public void F0(TimeOffsetPickerDialog paramTimeOffsetPickerDialog, int paramInt)
  {
    if (TextUtils.equals(paramTimeOffsetPickerDialog.getTag(), "tag_sunrise_offset"))
    {
      this.f4 = paramInt;
      this.c4 = RuleTimeType.SUNRISE;
      this.H3.setOffset(o0.n(this.z, paramInt));
    }
    else if (TextUtils.equals(paramTimeOffsetPickerDialog.getTag(), "tag_sunset_offset"))
    {
      this.g4 = paramInt;
      this.c4 = RuleTimeType.SUNSET;
      this.I3.setOffset(o0.n(this.z, paramInt));
    }
    z1();
  }
  
  public void h1()
  {
    if (k1(this.a4))
    {
      int i = this.h4;
      if (i == 2131362886)
      {
        this.U3.f();
        this.V3.g();
      }
      else
      {
        ItemSunriseSunsetSetting localItemSunriseSunsetSetting;
        if (i == 2131362969) {
          localItemSunriseSunsetSetting = this.H3;
        } else if (i == 2131362972) {
          localItemSunriseSunsetSetting = this.I3;
        } else {
          localItemSunriseSunsetSetting = this.J3;
        }
        onClick(localItemSunriseSunsetSetting);
      }
    }
  }
  
  public void m()
  {
    this.e4 = this.M3.getMinutesOfDay();
    z1();
  }
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    View localView = paramRadioGroup.findViewById(paramInt);
    if ((localView != null) && (localView.isPressed()))
    {
      if (paramRadioGroup.getId() == 2131363858)
      {
        boolean bool;
        if (paramInt == 2131364315) {
          bool = true;
        } else {
          bool = false;
        }
        O1(bool);
        if (bool) {
          paramRadioGroup = "on";
        } else {
          paramRadioGroup = "off";
        }
        this.b4 = paramRadioGroup;
      }
      z1();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131362972: 
      if (k1(this.a4))
      {
        this.c4 = RuleTimeType.SUNSET;
      }
      else
      {
        this.c4 = RuleTimeType.NORMAL;
        this.h4 = 2131362972;
        f1(this.a4);
      }
      B1();
      z1();
      break;
    case 2131362969: 
      if (k1(this.a4))
      {
        this.c4 = RuleTimeType.SUNRISE;
      }
      else
      {
        this.c4 = RuleTimeType.NORMAL;
        this.h4 = 2131362969;
        f1(this.a4);
      }
      B1();
      z1();
      break;
    case 2131362899: 
      this.c4 = RuleTimeType.NORMAL;
      B1();
      z1();
      break;
    case 2131362046: 
      this.N3.setVisibility(0);
      this.P3.setText("");
      this.P3.setClickable(false);
      this.Q3.setVisibility(0);
      this.N3.startAnimation(this.O3);
      this.X3.H(this.Z3);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558639);
    if (getIntent() != null)
    {
      this.d4 = getIntent().getIntExtra("plug_page_mode", 1);
      this.a4 = getIntent().getStringExtra("device_id_md5");
    }
    this.X3 = ((ScheduleViewModel)ViewModelProviders.of(this, new IoTViewModelFactory(this, this.a4)).get(ScheduleViewModel.class));
    C1();
    B1();
    N1();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131623961, paramMenu);
    this.p0 = paramMenu.findItem(2131363676);
    if (this.d4 != 1)
    {
      x1(false);
      ScheduleRuleBean localScheduleRuleBean = (ScheduleRuleBean)getIntent().getSerializableExtra("SCHEDULE_ITEM");
      this.Z3 = localScheduleRuleBean;
      K1(localScheduleRuleBean);
    }
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  public void onOffsetSettingClick(View paramView)
  {
    if (paramView.getId() == 2131362969) {
      n0.c(getSupportFragmentManager(), this.f4, this, "tag_sunrise_offset");
    } else if (paramView.getId() == 2131362972) {
      n0.c(getSupportFragmentManager(), this.g4, this, "tag_sunset_offset");
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 2131363676)
    {
      if (this.d4 == 1)
      {
        s0.l(this);
        paramMenuItem = w1();
        this.X3.k(paramMenuItem);
        this.X3.F(this.a4, paramMenuItem);
      }
      else
      {
        s0.l(this);
        paramMenuItem = w1();
        this.X3.l(paramMenuItem);
        this.X3.F(this.a4, paramMenuItem);
      }
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  public ScheduleRuleBean w1()
  {
    Object localObject1 = this.Z3;
    boolean bool = true;
    ((ScheduleRuleBean)localObject1).setEnable(true);
    localObject1 = this.c4;
    if ((localObject1 == null) || (localObject1 == RuleTimeType.NONE)) {
      this.c4 = RuleTimeType.NORMAL;
    }
    this.Z3.setStartTimeType(this.c4);
    localObject1 = this.c4;
    if (localObject1 == RuleTimeType.SUNRISE) {
      this.Z3.setTimeOffset(this.f4);
    } else if (localObject1 == RuleTimeType.SUNSET) {
      this.Z3.setTimeOffset(this.g4);
    } else {
      this.Z3.setStartTimeMin(this.X3.s(this.M3.getMinutesOfDay()));
    }
    this.Z3.setWeekOfDays((byte)this.L3.getWeekDay());
    localObject1 = this.Z3;
    if (this.L3.getWeekDay() == 0) {
      bool = false;
    }
    ((ScheduleRuleBean)localObject1).setRepeat(bool);
    if (this.X3.D())
    {
      localObject1 = new DesiredStatesBean();
      M1((DesiredStatesBean)localObject1);
      bool = "on".equals(this.b4);
      if (this.j4)
      {
        ((DesiredStatesBean)localObject1).setFrostProtectionOn(bool ^ true);
        if (bool)
        {
          ((DesiredStatesBean)localObject1).setTargetTemp(this.W3.getTemperature());
          ((DesiredStatesBean)localObject1).setTempUnit(this.W3.getTemperatureUnit().getValue());
        }
      }
      else
      {
        ((DesiredStatesBean)localObject1).setOn(bool);
        if (bool)
        {
          Object localObject2 = this.X3;
          if (((ScheduleViewModel)localObject2).o)
          {
            localObject2 = this.V3.getDesiredStates();
            ((DesiredStatesBean)localObject1).setLightingEffectData(((DesiredStatesBean)localObject2).getLightingEffectData());
            ((DesiredStatesBean)localObject1).setHue(((DesiredStatesBean)localObject2).getHue());
            ((DesiredStatesBean)localObject1).setSaturation(((DesiredStatesBean)localObject2).getSaturation());
            ((DesiredStatesBean)localObject1).setBrightness(((DesiredStatesBean)localObject2).getBrightness());
            ((DesiredStatesBean)localObject1).setColorTemp(((DesiredStatesBean)localObject2).getColorTemp());
            ((DesiredStatesBean)localObject1).setAuto(((DesiredStatesBean)localObject2).isAuto());
            ((DesiredStatesBean)localObject1).setAutoMode(((DesiredStatesBean)localObject2).getAutoMode());
          }
          else if (this.i4)
          {
            localObject2 = this.U3.getDesireStates();
            if (localObject2 != null)
            {
              ((DesiredStatesBean)localObject1).setBrightness(((DesiredStatesBean)localObject2).getBrightness());
              ((DesiredStatesBean)localObject1).setColorTemp(((DesiredStatesBean)localObject2).getColorTemp());
              ((DesiredStatesBean)localObject1).setSaturation(((DesiredStatesBean)localObject2).getSaturation());
              ((DesiredStatesBean)localObject1).setHue(((DesiredStatesBean)localObject2).getHue());
              ((DesiredStatesBean)localObject1).setAuto(((DesiredStatesBean)localObject2).isAuto());
              ((DesiredStatesBean)localObject1).setAutoMode(((DesiredStatesBean)localObject2).getAutoMode());
            }
          }
          else if (((ScheduleViewModel)localObject2).l)
          {
            ((DesiredStatesBean)localObject1).setBrightness(this.T3.getBrightness());
          }
        }
      }
      this.Z3.setDesiredStates((DesiredStatesBean)localObject1);
    }
    else
    {
      this.Z3.setStartAction(this.b4);
    }
    return this.Z3;
  }
  
  class a
    implements Observer<Integer>
  {
    a() {}
    
    public void a(@Nullable Integer paramInteger)
    {
      
      if ((paramInteger != null) && (paramInteger.intValue() == 0)) {
        ScheduleDetailActivity.this.finish();
      } else if ((paramInteger != null) && (paramInteger.intValue() == 10000)) {
        s0.t(ScheduleDetailActivity.this, 2131953727, new a());
      } else if ((paramInteger != null) && (paramInteger.intValue() == 63734)) {
        s0.p(ScheduleDetailActivity.n1(ScheduleDetailActivity.this), ScheduleDetailActivity.this.getResources().getString(2131953943, new Object[] { Integer.valueOf(ScheduleDetailActivity.this.X3.z()) }));
      } else if ((paramInteger != null) && (paramInteger.intValue() == 63733)) {
        s0.p(ScheduleDetailActivity.n1(ScheduleDetailActivity.this), ScheduleDetailActivity.this.getResources().getString(2131953727));
      } else {
        s0.n(ScheduleDetailActivity.n1(ScheduleDetailActivity.this), 2131953328);
      }
    }
    
    class a
      implements s0.h
    {
      a() {}
      
      public void onDismiss()
      {
        ScheduleDetailActivity.this.finish();
      }
    }
  }
  
  class b
    implements WeekdayPickerView.a
  {
    b() {}
    
    public void a(int paramInt)
    {
      ScheduleDetailActivity.t1(ScheduleDetailActivity.this);
    }
  }
  
  class c
    implements Observer<Integer>
  {
    c() {}
    
    public void a(Integer paramInteger)
    {
      
      if (paramInteger != null) {
        if (paramInteger.intValue() == 0)
        {
          ScheduleDetailActivity.this.finish();
        }
        else if (paramInteger.intValue() == 10000)
        {
          s0.t(ScheduleDetailActivity.this, 2131953727, new a());
        }
        else if (paramInteger.intValue() == 64524)
        {
          w.f();
        }
        else if (paramInteger.intValue() == 63733)
        {
          paramInteger = ScheduleDetailActivity.this;
          s0.p(paramInteger, paramInteger.getResources().getString(2131953727));
        }
        else
        {
          s0.n(ScheduleDetailActivity.this, 2131953328);
        }
      }
    }
    
    class a
      implements s0.h
    {
      a() {}
      
      public void onDismiss()
      {
        ScheduleDetailActivity.this.finish();
      }
    }
  }
  
  class d
    implements Observer<com.tplink.iot.viewmodel.quicksetup.i<ScheduleRuleBean>>
  {
    d() {}
    
    public void a(com.tplink.iot.viewmodel.quicksetup.i<ScheduleRuleBean> parami)
    {
      ScheduleDetailActivity.o1(ScheduleDetailActivity.this).clearAnimation();
      if ((parami != null) && (parami.b() == 0))
      {
        ScheduleDetailActivity.this.finish();
      }
      else
      {
        ScheduleDetailActivity.o1(ScheduleDetailActivity.this).setVisibility(8);
        ScheduleDetailActivity.p1(ScheduleDetailActivity.this).setVisibility(8);
        ScheduleDetailActivity.q1(ScheduleDetailActivity.this).setText(ScheduleDetailActivity.n1(ScheduleDetailActivity.this).getResources().getString(2131952517));
        ScheduleDetailActivity.q1(ScheduleDetailActivity.this).setClickable(true);
        if ((parami != null) && (parami.b() == 64524)) {
          w.f();
        } else {
          s0.n(ScheduleDetailActivity.this, 2131953328);
        }
      }
    }
  }
  
  class e
    implements Observer<List<Integer>>
  {
    e() {}
    
    public void a(@Nullable List<Integer> paramList)
    {
      ScheduleDetailActivity.r1(ScheduleDetailActivity.this).setPresets(paramList);
    }
  }
  
  class f
    implements Observer<List<LightStateBean>>
  {
    f() {}
    
    public void a(@Nullable List<LightStateBean> paramList)
    {
      ScheduleDetailActivity.s1(ScheduleDetailActivity.this).setPresetList(paramList);
    }
  }
  
  class g
    implements WeekdayPickerView.a
  {
    g() {}
    
    public void a(int paramInt)
    {
      ScheduleDetailActivity.t1(ScheduleDetailActivity.this);
    }
  }
  
  class h
    implements BulbBrightnessView.c
  {
    h() {}
    
    public void onChange()
    {
      ScheduleDetailActivity.t1(ScheduleDetailActivity.this);
    }
  }
  
  class i
    implements ColorBulbPresetStatusView.a
  {
    i() {}
    
    public void d()
    {
      ScheduleDetailActivity.u1(ScheduleDetailActivity.this, 2131362886);
      ScheduleDetailActivity localScheduleDetailActivity = ScheduleDetailActivity.this;
      localScheduleDetailActivity.f1(ScheduleDetailActivity.v1(localScheduleDetailActivity));
    }
    
    public void p()
    {
      ScheduleDetailActivity.t1(ScheduleDetailActivity.this);
    }
  }
  
  class j
    implements LightingEffectPresetStatusView.d
  {
    j() {}
    
    public void a()
    {
      ScheduleDetailActivity.t1(ScheduleDetailActivity.this);
    }
    
    public void q()
    {
      ScheduleDetailActivity.u1(ScheduleDetailActivity.this, 2131362886);
      ScheduleDetailActivity localScheduleDetailActivity = ScheduleDetailActivity.this;
      localScheduleDetailActivity.f1(ScheduleDetailActivity.v1(localScheduleDetailActivity));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\feature\ScheduleDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */