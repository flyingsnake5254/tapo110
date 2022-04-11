package com.tplink.iot.view.feature;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.x0.i;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.base.BaseLocationActivity;
import com.tplink.iot.cloud.bean.thing.common.ThingRuleTimer;
import com.tplink.iot.devices.lightstrip.widget.LightingEffectPresetStatusView;
import com.tplink.iot.devices.lightstrip.widget.LightingEffectPresetStatusView.d;
import com.tplink.iot.g.d.a.b;
import com.tplink.iot.viewmodel.iotcommon.feature.TimerViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.widget.BulbBrightnessView;
import com.tplink.iot.widget.InnerTimeSelectView;
import com.tplink.iot.widget.InnerTimeSelectView.a;
import com.tplink.iot.widget.colorbulb.ColorBulbPresetStatusView;
import com.tplink.iot.widget.colorbulb.ColorBulbPresetStatusView.a;
import com.tplink.iot.widget.trv.TemperatureSeekBarLayout;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.DesiredStatesBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.CountdownRuleBean;
import com.tplink.libtpnetwork.enumerate.EnumTemperatureUnit;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class TimerActivity
  extends BaseLocationActivity
  implements View.OnClickListener, InnerTimeSelectView.a, ColorBulbPresetStatusView.a
{
  private LinearLayout H3;
  private TextView I3;
  private TextView J3;
  private TPRefreshableButton K3;
  private InnerTimeSelectView L3;
  private View M3;
  private View N3;
  private int O3 = -1;
  private View P3;
  private BulbBrightnessView Q3;
  private ColorBulbPresetStatusView R3;
  private LightingEffectPresetStatusView S3;
  private TemperatureSeekBarLayout T3;
  private Button U3;
  private int V3 = 300;
  private String W3 = null;
  private String X3 = "on";
  private CountdownRuleBean Y3;
  private TimerViewModel Z3;
  private boolean a4;
  private boolean b4;
  private long c4 = 0L;
  private int d4;
  private Timer e4;
  private g f4;
  private TextView p0;
  private RadioGroup p1;
  private RadioButton p2;
  private RadioButton p3;
  private View z;
  
  private CountdownRuleBean F1()
  {
    if (this.Y3 == null) {
      this.Y3 = new CountdownRuleBean();
    }
    if (this.Z3.t())
    {
      DesiredStatesBean localDesiredStatesBean = new DesiredStatesBean();
      V1(localDesiredStatesBean);
      if (this.b4)
      {
        boolean bool = "on".equals(this.X3);
        localDesiredStatesBean.setFrostProtectionOn(bool ^ true);
        if (bool)
        {
          localDesiredStatesBean.setTargetTemp(this.T3.getTemperature());
          localDesiredStatesBean.setTempUnit(this.T3.getTemperatureUnit().getValue());
        }
      }
      else
      {
        localDesiredStatesBean.setOn("on".equals(this.X3));
        Object localObject = this.Z3;
        if (((TimerViewModel)localObject).h)
        {
          localObject = this.S3.getDesiredStates();
          localDesiredStatesBean.setLightingEffectData(((DesiredStatesBean)localObject).getLightingEffectData());
          localDesiredStatesBean.setBrightness(((DesiredStatesBean)localObject).getBrightness());
          localDesiredStatesBean.setColorTemp(((DesiredStatesBean)localObject).getColorTemp());
          localDesiredStatesBean.setSaturation(((DesiredStatesBean)localObject).getSaturation());
          localDesiredStatesBean.setHue(((DesiredStatesBean)localObject).getHue());
          localDesiredStatesBean.setAuto(((DesiredStatesBean)localObject).isAuto());
          localDesiredStatesBean.setAutoMode(((DesiredStatesBean)localObject).getAutoMode());
        }
        else if (((TimerViewModel)localObject).f)
        {
          localObject = this.R3.getDesireStates();
          if (localObject != null)
          {
            localDesiredStatesBean.setBrightness(((DesiredStatesBean)localObject).getBrightness());
            localDesiredStatesBean.setColorTemp(((DesiredStatesBean)localObject).getColorTemp());
            localDesiredStatesBean.setSaturation(((DesiredStatesBean)localObject).getSaturation());
            localDesiredStatesBean.setHue(((DesiredStatesBean)localObject).getHue());
            localDesiredStatesBean.setAuto(((DesiredStatesBean)localObject).isAuto());
            localDesiredStatesBean.setAutoMode(((DesiredStatesBean)localObject).getAutoMode());
          }
        }
        else if (((TimerViewModel)localObject).e)
        {
          localDesiredStatesBean.setBrightness(this.Q3.getBrightness());
        }
      }
      this.Y3.setDesiredStates(localDesiredStatesBean.toMap());
      this.Y3.setFormatDesiredStates(localDesiredStatesBean);
    }
    else
    {
      this.Y3.setAction(this.X3);
    }
    this.Y3.setId(null);
    this.Y3.setDelay(this.V3);
    this.Y3.setRemain(this.V3);
    this.Y3.setEnable(true);
    return this.Y3;
  }
  
  private void G1(boolean paramBoolean)
  {
    String str;
    if (paramBoolean) {
      str = "on";
    } else {
      str = "off";
    }
    this.X3 = str;
    Z1(paramBoolean);
  }
  
  private void H1(boolean paramBoolean)
  {
    this.p2.setEnabled(paramBoolean);
    this.p3.setEnabled(paramBoolean);
  }
  
  private String I1(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = paramInt / 3600;
    if (i < 10) {
      localStringBuilder.append("0");
    }
    localStringBuilder.append(i);
    localStringBuilder.append(" : ");
    i = paramInt / 60 % 60;
    if (i < 10) {
      localStringBuilder.append("0");
    }
    localStringBuilder.append(i);
    localStringBuilder.append(" : ");
    paramInt %= 60;
    if (paramInt < 10) {
      localStringBuilder.append("0");
    }
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
  
  private String J1(boolean paramBoolean)
  {
    if (this.b4)
    {
      String str;
      if (paramBoolean) {
        str = this.I3.getText().toString();
      } else {
        str = getString(2131953962);
      }
      return str;
    }
    int i;
    if (paramBoolean) {
      i = 2131954365;
    } else {
      i = 2131954364;
    }
    return getString(i);
  }
  
  private void K1()
  {
    TimerViewModel localTimerViewModel = this.Z3;
    if (localTimerViewModel.h) {
      this.S3.setVisibility(0);
    } else if (localTimerViewModel.f) {
      this.R3.setVisibility(0);
    } else if (localTimerViewModel.e) {
      this.Q3.setVisibility(0);
    } else if (this.b4) {
      this.T3.setVisibility(0);
    }
  }
  
  private void L1(boolean paramBoolean)
  {
    this.p2.setChecked(paramBoolean);
    this.p3.setChecked(paramBoolean ^ true);
    Z1(paramBoolean);
  }
  
  private void M1()
  {
    c1(getString(2131953397));
    this.z = findViewById(2131363214);
    this.p0 = ((TextView)findViewById(2131364594));
    Object localObject = (InnerTimeSelectView)findViewById(2131362862);
    this.L3 = ((InnerTimeSelectView)localObject);
    boolean bool = true;
    ((InnerTimeSelectView)localObject).b(true);
    this.L3.setMinuteOfDay(this.V3 / 60);
    this.L3.setOnTimePickerChangeListener(this);
    localObject = (RadioGroup)findViewById(2131363858);
    this.p1 = ((RadioGroup)localObject);
    ((RadioGroup)localObject).setOnCheckedChangeListener(new e());
    this.p2 = ((RadioButton)findViewById(2131364315));
    this.p3 = ((RadioButton)findViewById(2131364314));
    this.Q3 = ((BulbBrightnessView)findViewById(2131362029));
    this.M3 = findViewById(2131362484);
    this.N3 = findViewById(2131362482);
    this.O3 = ContextCompat.getColor(this, 2131100206);
    localObject = (ColorBulbPresetStatusView)findViewById(2131363688);
    this.R3 = ((ColorBulbPresetStatusView)localObject);
    ((ColorBulbPresetStatusView)localObject).setFragmentManager(getSupportFragmentManager());
    this.R3.setOnPresetStatusListener(this);
    this.R3.k(this.Z3.h());
    this.R3.getHeaderTextView().setBackgroundColor(this.O3);
    this.P3 = findViewById(2131362661);
    localObject = (LightingEffectPresetStatusView)findViewById(2131363237);
    this.S3 = ((LightingEffectPresetStatusView)localObject);
    ((LightingEffectPresetStatusView)localObject).setFragmentManager(getSupportFragmentManager());
    this.S3.setDeviceIdMD5(this.W3);
    this.S3.setAutoLightViewVisible(this.Z3.g);
    this.S3.setAutoLightMode(this.Z3.h());
    this.S3.setOnPresetStatusChangedListener(new f());
    this.S3.getHeaderTextView().setBackgroundColor(this.O3);
    localObject = (TemperatureSeekBarLayout)findViewById(2131364168);
    this.T3 = ((TemperatureSeekBarLayout)localObject);
    ((TemperatureSeekBarLayout)localObject).setHeaderTextViewVisible(false);
    this.H3 = ((LinearLayout)findViewById(2131363859));
    this.I3 = ((TextView)findViewById(2131362420));
    this.J3 = ((TextView)findViewById(2131364155));
    localObject = (TPRefreshableButton)findViewById(2131362109);
    this.K3 = ((TPRefreshableButton)localObject);
    ((TPRefreshableButton)localObject).setOnClickListener(this);
    localObject = this.K3;
    if (this.V3 == 0) {
      bool = false;
    }
    ((TPRefreshableButton)localObject).setEnabled(bool);
    localObject = (Button)findViewById(2131362110);
    this.U3 = ((Button)localObject);
    ((Button)localObject).setOnClickListener(this);
    K1();
    N1();
  }
  
  private void N1()
  {
    if (this.b4)
    {
      this.p2.setText(2131953997);
      this.p3.setText(2131953962);
    }
  }
  
  public static void S1(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, TimerActivity.class);
    localIntent.putExtra("device_id_md5", paramString);
    paramContext.startActivity(localIntent);
  }
  
  private void T1(boolean paramBoolean)
  {
    boolean bool = this.a4;
    int i = 0;
    if (!bool)
    {
      localObject = this.Z3;
      if ((!((TimerViewModel)localObject).h) && (((TimerViewModel)localObject).e))
      {
        j = 1;
        break label42;
      }
    }
    int j = 0;
    label42:
    Object localObject = this.J3;
    if ((paramBoolean) && (j != 0)) {
      j = 0;
    } else {
      j = 8;
    }
    ((TextView)localObject).setVisibility(j);
    this.I3.setText(J1(paramBoolean));
    if (this.b4)
    {
      if (paramBoolean) {
        localObject = ResourcesCompat.getDrawable(getResources(), 2131689914, null);
      } else {
        localObject = ResourcesCompat.getDrawable(getResources(), 2131690442, null);
      }
    }
    else if (paramBoolean) {
      localObject = ResourcesCompat.getDrawable(getResources(), 2131690443, null);
    } else {
      localObject = ResourcesCompat.getDrawable(getResources(), 2131690442, null);
    }
    if (localObject != null) {
      ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getMinimumWidth(), ((Drawable)localObject).getMinimumHeight());
    }
    this.I3.setCompoundDrawables((Drawable)localObject, null, null, null);
    localObject = findViewById(2131362026);
    if (paramBoolean) {
      j = i;
    } else {
      j = 4;
    }
    ((View)localObject).setVisibility(j);
  }
  
  private void U1(int paramInt)
  {
    int i = 1;
    int j = 0;
    boolean bool1;
    if (paramInt == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2 = "on".equals(this.X3);
    Object localObject = this.z;
    int k = 4;
    if (bool1) {
      paramInt = 4;
    } else {
      paramInt = 0;
    }
    ((View)localObject).setVisibility(paramInt);
    localObject = this.L3;
    if (bool1) {
      paramInt = 0;
    } else {
      paramInt = 4;
    }
    ((LinearLayout)localObject).setVisibility(paramInt);
    localObject = this.K3;
    if (bool1) {
      paramInt = 0;
    } else {
      paramInt = 4;
    }
    ((FrameLayout)localObject).setVisibility(paramInt);
    a2(bool1);
    localObject = this.H3;
    if (bool1) {
      paramInt = 8;
    } else {
      paramInt = 0;
    }
    ((LinearLayout)localObject).setVisibility(paramInt);
    localObject = this.U3;
    if (bool1) {
      paramInt = k;
    } else {
      paramInt = 0;
    }
    ((Button)localObject).setVisibility(paramInt);
    this.R3.setEnable(bool1);
    this.S3.setViewEnabled(bool1);
    if (bool1)
    {
      this.R3.setDesiredStates(null);
      this.S3.setDesiredStates(null);
    }
    paramInt = i;
    if (!bool1)
    {
      paramInt = i;
      if (!this.a4) {
        if (this.Z3.h) {
          paramInt = i;
        } else {
          paramInt = 0;
        }
      }
    }
    localObject = this.P3;
    if ((paramInt != 0) && (bool2)) {
      paramInt = j;
    } else {
      paramInt = 8;
    }
    ((View)localObject).setVisibility(paramInt);
    if (bool1) {
      this.L3.setMinuteOfDay(this.V3 / 60);
    } else {
      T1(bool2);
    }
  }
  
  private void V1(DesiredStatesBean paramDesiredStatesBean)
  {
    if (paramDesiredStatesBean == null) {
      return;
    }
    paramDesiredStatesBean.isTRV = this.b4;
  }
  
  private void W1()
  {
    this.e4 = new Timer();
    g localg = new g();
    this.f4 = localg;
    this.e4.schedule(localg, 0L, 1000L);
  }
  
  private void X1()
  {
    Object localObject = this.e4;
    if (localObject != null)
    {
      ((Timer)localObject).cancel();
      this.e4 = null;
    }
    localObject = this.f4;
    if (localObject != null)
    {
      ((TimerTask)localObject).cancel();
      this.f4 = null;
    }
  }
  
  @SuppressLint({"CheckResult"})
  private void Y1()
  {
    this.Z3.p().observe(this, new a());
    this.Z3.k().observe(this, new b());
    this.Z3.i().observe(this, new c());
    this.Z3.j().observe(this, new d());
    this.Z3.o().observe(this, new f(this));
    this.Z3.r().observe(this, new e(this));
  }
  
  private void Z1(boolean paramBoolean)
  {
    boolean bool = this.Z3.e;
    int i = 1;
    int j = 0;
    int k;
    if ((!bool) && (!this.b4)) {
      k = 0;
    } else {
      k = 1;
    }
    if ((k != 0) && (paramBoolean)) {
      k = i;
    } else {
      k = 0;
    }
    View localView = this.P3;
    if (k != 0) {
      i = 0;
    } else {
      i = 8;
    }
    localView.setVisibility(i);
    localView = this.M3;
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
      this.p2.setBackgroundColor(this.O3);
      this.p3.setBackgroundColor(this.O3);
    }
  }
  
  private void a2(boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    this.p2.setVisibility(i);
    this.p3.setVisibility(i);
    this.N3.setVisibility(i);
  }
  
  private void b2(Integer paramInteger)
  {
    if (paramInteger != null) {
      if (paramInteger.intValue() == 1)
      {
        this.K3.g();
        H1(false);
      }
      else
      {
        this.K3.h();
        H1(true);
        if (paramInteger.intValue() == -1) {
          s0.p(this, getString(2131953328));
        } else if (paramInteger.intValue() == 10000) {
          s0.s(this, 2131953727);
        }
      }
    }
  }
  
  private void c2(@NonNull CountdownRuleBean paramCountdownRuleBean)
  {
    this.Y3 = paramCountdownRuleBean;
    int i = paramCountdownRuleBean.getDelay();
    this.V3 = i;
    this.L3.setMinuteOfDay(i / 60);
    Object localObject = this.K3;
    if (this.V3 != 0) {
      bool = true;
    } else {
      bool = false;
    }
    ((TPRefreshableButton)localObject).setEnabled(bool);
    DesiredStatesBean localDesiredStatesBean = paramCountdownRuleBean.getFormatDesiredStates();
    boolean bool = this.Z3.t();
    String str = "off";
    if (bool)
    {
      if ((localDesiredStatesBean != null) && (localDesiredStatesBean.isOn())) {
        localObject = "on";
      } else {
        localObject = "off";
      }
      this.X3 = ((String)localObject);
    }
    else
    {
      if ("on".equals(this.Y3.getAction())) {
        localObject = "on";
      } else {
        localObject = "off";
      }
      this.X3 = ((String)localObject);
    }
    if (localDesiredStatesBean != null) {
      if (this.b4)
      {
        if (localDesiredStatesBean.isFrostProtectionOn()) {
          localObject = str;
        } else {
          localObject = "on";
        }
        this.X3 = ((String)localObject);
        localObject = b.e(localDesiredStatesBean.getTargetTemp(), localDesiredStatesBean.getTempUnit());
        this.I3.setText(getString(2131953998, new Object[] { localObject }));
        if (!localDesiredStatesBean.isFrostProtectionOn())
        {
          this.T3.setTemperature(localDesiredStatesBean.getTargetTemp());
          this.T3.setTemperatureUnit(EnumTemperatureUnit.fromString(localDesiredStatesBean.getTempUnit()));
        }
      }
      else
      {
        if (localDesiredStatesBean.isOn()) {
          i = localDesiredStatesBean.getBrightness();
        } else {
          i = 50;
        }
        this.Q3.setBrightness(i);
        this.J3.setText(String.format("%s%%", new Object[] { String.valueOf(i) }));
        if (localDesiredStatesBean.isOn())
        {
          this.S3.setDesiredStates(localDesiredStatesBean);
          this.R3.setDesiredStates(localDesiredStatesBean);
        }
        else
        {
          this.S3.setDesiredStates(null);
          this.R3.setDesiredStates(null);
        }
      }
    }
    L1("on".equals(this.X3));
    if ((paramCountdownRuleBean.isEnable()) && (this.Z3.s()))
    {
      U1(1);
      this.c4 = this.Z3.m();
      W1();
    }
    else
    {
      U1(0);
    }
  }
  
  public void d()
  {
    f1(this.W3);
  }
  
  public void h1()
  {
    this.R3.f();
    this.S3.g();
  }
  
  public void m()
  {
    int i = this.L3.getMinutesOfDay() * 60;
    this.V3 = i;
    TPRefreshableButton localTPRefreshableButton = this.K3;
    boolean bool;
    if (i != 0) {
      bool = true;
    } else {
      bool = false;
    }
    localTPRefreshableButton.setEnabled(bool);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131362109)
    {
      this.Z3.g(F1());
      i.F(this.W3, this.Y3);
    }
    else if (i == 2131362110)
    {
      this.Y3.setEnable(false);
      this.Z3.u(this.Y3);
      i.H(this.W3);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558691);
    if (getIntent() != null) {
      this.W3 = getIntent().getStringExtra("device_id_md5");
    }
    paramBundle = (TimerViewModel)ViewModelProviders.of(this, new IoTViewModelFactory(this, this.W3)).get(TimerViewModel.class);
    this.Z3 = paramBundle;
    this.a4 = paramBundle.f;
    boolean bool;
    if ((paramBundle.i) && (paramBundle.j)) {
      bool = true;
    } else {
      bool = false;
    }
    this.b4 = bool;
    M1();
    U1(this.Z3.s());
    Y1();
    this.Z3.l();
    i.v();
  }
  
  protected void onDestroy()
  {
    X1();
    super.onDestroy();
  }
  
  public void p() {}
  
  class a
    implements Observer<Integer>
  {
    a() {}
    
    public void a(@Nullable Integer paramInteger)
    {
      TimerActivity.n1(TimerActivity.this, paramInteger);
    }
  }
  
  class b
    implements Observer<CountdownRuleBean>
  {
    b() {}
    
    public void a(@Nullable CountdownRuleBean paramCountdownRuleBean)
    {
      if ((paramCountdownRuleBean != null) && (!TextUtils.isEmpty(paramCountdownRuleBean.getId())))
      {
        TimerActivity.o1(TimerActivity.this, paramCountdownRuleBean);
      }
      else
      {
        TimerActivity localTimerActivity = TimerActivity.this;
        if (!TimerActivity.y1(localTimerActivity).n()) {
          paramCountdownRuleBean = "on";
        } else {
          paramCountdownRuleBean = "off";
        }
        TimerActivity.x1(localTimerActivity, paramCountdownRuleBean);
        paramCountdownRuleBean = TimerActivity.this;
        TimerActivity.z1(paramCountdownRuleBean, "on".equals(TimerActivity.w1(paramCountdownRuleBean)));
        TimerActivity.A1(TimerActivity.this, 0);
      }
    }
  }
  
  class c
    implements Observer<List<Integer>>
  {
    c() {}
    
    public void a(@Nullable List<Integer> paramList)
    {
      TimerActivity.B1(TimerActivity.this).setPresets(paramList);
    }
  }
  
  class d
    implements Observer<List<LightStateBean>>
  {
    d() {}
    
    public void a(@Nullable List<LightStateBean> paramList)
    {
      TimerActivity.C1(TimerActivity.this).setPresetList(paramList);
    }
  }
  
  class e
    implements RadioGroup.OnCheckedChangeListener
  {
    e() {}
    
    public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
    {
      paramRadioGroup = TimerActivity.this;
      boolean bool;
      if (paramInt == 2131364315) {
        bool = true;
      } else {
        bool = false;
      }
      TimerActivity.D1(paramRadioGroup, bool);
    }
  }
  
  class f
    implements LightingEffectPresetStatusView.d
  {
    f() {}
    
    public void a() {}
    
    public void q()
    {
      TimerActivity localTimerActivity = TimerActivity.this;
      localTimerActivity.f1(TimerActivity.E1(localTimerActivity));
    }
  }
  
  class g
    extends TimerTask
  {
    g() {}
    
    public void run()
    {
      TimerActivity.this.runOnUiThread(new a());
    }
    
    class a
      implements Runnable
    {
      a() {}
      
      public void run()
      {
        int i = (int)(System.currentTimeMillis() / 1000L);
        Object localObject = TimerActivity.this;
        TimerActivity.q1((TimerActivity)localObject, (int)(TimerActivity.r1((TimerActivity)localObject) - i));
        if (TimerActivity.p1(TimerActivity.this) < 0)
        {
          TimerActivity.s1(TimerActivity.this).setEnable(false);
          TimerActivity.t1(TimerActivity.this);
          TimerActivity.A1(TimerActivity.this, 0);
        }
        else
        {
          localObject = TimerActivity.v1(TimerActivity.this);
          TimerActivity localTimerActivity = TimerActivity.this;
          ((TextView)localObject).setText(TimerActivity.u1(localTimerActivity, TimerActivity.p1(localTimerActivity)));
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\feature\TimerActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */