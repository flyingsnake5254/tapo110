package com.tplink.iot.view.feature;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.Utils.o0;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.x0.i;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.cloud.bean.thing.common.ThingRuleAwayMode;
import com.tplink.iot.cloud.enumerate.RuleMode;
import com.tplink.iot.cloud.enumerate.RuleTimeType;
import com.tplink.iot.viewmodel.iotcommon.feature.AwayModeViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.widget.WeekdayPickerView;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;

public class AwayModeActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private LinearLayout H3;
  private TPRefreshableButton I3;
  private Button J3;
  private int K3 = 1170;
  private int L3 = 360;
  private String M3;
  private RuleTimeType N3;
  private RuleTimeType O3;
  private int P3;
  private int Q3;
  private ThingRuleAwayMode R3;
  private AwayModeViewModel S3;
  private TextView p0;
  private TextView p1;
  private TextView p2;
  private WeekdayPickerView p3;
  private TextView y;
  private TextView z;
  
  public AwayModeActivity()
  {
    RuleTimeType localRuleTimeType = RuleTimeType.NORMAL;
    this.N3 = localRuleTimeType;
    this.O3 = localRuleTimeType;
    this.R3 = new ThingRuleAwayMode();
  }
  
  private ThingRuleAwayMode j1()
  {
    if (this.R3 == null) {
      this.R3 = new ThingRuleAwayMode();
    }
    this.R3.setId(null);
    if (p1(this.N3))
    {
      this.N3 = RuleTimeType.NORMAL;
      this.R3.setStartTimeMin(this.S3.j(this.K3));
    }
    else
    {
      this.R3.setStartTimeOffset(this.P3);
    }
    if (p1(this.O3))
    {
      this.O3 = RuleTimeType.NORMAL;
      this.R3.setEndTimeMin(this.S3.j(this.L3));
    }
    else
    {
      this.R3.setEndTimeOffset(this.Q3);
    }
    ThingRuleAwayMode localThingRuleAwayMode = this.R3;
    RuleTimeType localRuleTimeType1 = this.N3;
    RuleTimeType localRuleTimeType2 = localRuleTimeType1;
    if (localRuleTimeType1 == null) {
      localRuleTimeType2 = RuleTimeType.NORMAL;
    }
    localThingRuleAwayMode.setStartTimeType(localRuleTimeType2);
    localThingRuleAwayMode = this.R3;
    localRuleTimeType1 = this.O3;
    localRuleTimeType2 = localRuleTimeType1;
    if (localRuleTimeType1 == null) {
      localRuleTimeType2 = RuleTimeType.NORMAL;
    }
    localThingRuleAwayMode.setEndTimeType(localRuleTimeType2);
    this.R3.setWeekOfDays((byte)this.p3.getWeekDay());
    this.R3.setEnable(true);
    this.R3.setFrequency(5);
    this.R3.setYear(null);
    this.R3.setMonth(null);
    this.R3.setDay(null);
    if (this.p3.getWeekDay() == 0) {
      this.R3.setMode(RuleMode.ONCE);
    } else {
      this.R3.setMode(RuleMode.REPEAT);
    }
    return this.R3;
  }
  
  private void m1()
  {
    c1(getString(2131953372));
    this.z = ((TextView)findViewById(2131364351));
    this.p0 = ((TextView)findViewById(2131364570));
    this.y = ((TextView)findViewById(2131364350));
    this.p1 = ((TextView)findViewById(2131364569));
    this.p2 = ((TextView)findViewById(2131364539));
    Object localObject = (WeekdayPickerView)findViewById(2131364834);
    this.p3 = ((WeekdayPickerView)localObject);
    ((WeekdayPickerView)localObject).setDescriptionVisibility(true);
    this.I3 = ((TPRefreshableButton)findViewById(2131362109));
    this.J3 = ((Button)findViewById(2131362110));
    this.p0.setOnClickListener(this);
    this.H3 = ((LinearLayout)findViewById(2131363258));
    this.p1.setOnClickListener(this);
    this.p2.setOnClickListener(this);
    this.I3.setOnClickListener(this);
    this.J3.setOnClickListener(this);
    this.p0.setText(o0.c(this, this.K3, this.N3));
    this.p1.setText(o0.c(this, this.L3, this.O3));
    localObject = this.p2;
    int i;
    if (o1()) {
      i = 0;
    } else {
      i = 4;
    }
    ((TextView)localObject).setVisibility(i);
    this.I3.setEnabled(n1());
  }
  
  private boolean n1()
  {
    boolean bool1 = p1(this.N3);
    boolean bool2 = true;
    int i;
    if ((bool1) && (p1(this.O3))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0 ? this.K3 == this.L3 : this.N3 == this.O3) {
      bool2 = false;
    }
    return bool2;
  }
  
  private boolean o1()
  {
    ThingRuleAwayMode localThingRuleAwayMode = this.R3;
    boolean bool = true;
    if (localThingRuleAwayMode == null) {
      return true;
    }
    int i;
    if ((p1(localThingRuleAwayMode.getStartTimeType())) && (p1(this.R3.getEndTimeType()))) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i == 0) || (this.K3 <= this.L3)) {
      bool = false;
    }
    return bool;
  }
  
  private boolean p1(RuleTimeType paramRuleTimeType)
  {
    boolean bool;
    if ((paramRuleTimeType != null) && (paramRuleTimeType != RuleTimeType.NONE) && (paramRuleTimeType != RuleTimeType.NORMAL)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private void r1(int paramInt)
  {
    if (paramInt == 0)
    {
      this.z.setText(getString(2131951833));
      this.p0.setEnabled(true);
      this.H3.setAlpha(1.0F);
      this.p1.setEnabled(true);
      this.p2.setEnabled(true);
      this.p3.l(127, true);
      this.J3.setVisibility(4);
      this.I3.setVisibility(0);
      this.y.setVisibility(8);
    }
    else if (paramInt == 1)
    {
      this.z.setText(getString(2131951832));
      this.p0.setEnabled(false);
      this.H3.setAlpha(0.5F);
      this.y.setVisibility(0);
      this.p1.setEnabled(false);
      this.p2.setEnabled(false);
      this.p3.i();
      this.I3.setVisibility(4);
      this.J3.setVisibility(0);
    }
  }
  
  private void s1()
  {
    this.S3.h().observe(this, new a());
    this.S3.m().observe(this, new b());
  }
  
  private void t1(ThingRuleAwayMode paramThingRuleAwayMode)
  {
    this.K3 = this.S3.l(paramThingRuleAwayMode.getStartTimeMin());
    this.L3 = this.S3.l(paramThingRuleAwayMode.getEndTimeMin());
    this.N3 = paramThingRuleAwayMode.getStartTimeType();
    this.O3 = paramThingRuleAwayMode.getEndTimeType();
    this.P3 = paramThingRuleAwayMode.getStartTimeOffset();
    this.Q3 = paramThingRuleAwayMode.getEndTimeOffset();
    this.p3.setWeekDay(paramThingRuleAwayMode.getWeekOfDays());
    this.p0.setText(o0.c(this, this.K3, this.N3));
    this.p1.setText(o0.c(this, this.L3, this.O3));
    paramThingRuleAwayMode = this.p2;
    int i;
    if (o1()) {
      i = 0;
    } else {
      i = 4;
    }
    paramThingRuleAwayMode.setVisibility(i);
    this.I3.setEnabled(n1());
  }
  
  private void u1(Integer paramInteger)
  {
    if (paramInteger != null) {
      if (paramInteger.intValue() == 1)
      {
        this.I3.g();
        this.p0.setEnabled(false);
        this.p1.setEnabled(false);
      }
      else
      {
        this.I3.h();
        boolean bool = this.S3.n();
        this.p0.setEnabled(bool ^ true);
        this.p1.setEnabled(bool ^ true);
        if (paramInteger.intValue() == -1) {
          s0.n(this, 2131953328);
        } else if (paramInteger.intValue() == 10000) {
          s0.u(this, 2131953727, null, 2000L);
        }
      }
    }
  }
  
  public int k1(int paramInt)
  {
    if (p1(this.R3.getEndTimeType())) {
      return paramInt;
    }
    return this.R3.getEndTimeOffset();
  }
  
  public int l1(int paramInt)
  {
    if (p1(this.R3.getStartTimeType())) {
      return paramInt;
    }
    return this.R3.getStartTimeOffset();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1)
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 != 2)
        {
          super.onActivityResult(paramInt1, paramInt2, paramIntent);
        }
        else
        {
          this.Q3 = paramIntent.getIntExtra("tag_sunset_offset", 0);
          paramIntent = (RuleTimeType)paramIntent.getSerializableExtra("tag_mode");
          this.O3 = paramIntent;
          q1(2, this.Q3, paramIntent);
        }
      }
      else
      {
        this.P3 = paramIntent.getIntExtra("tag_sunset_offset", 0);
        paramIntent = (RuleTimeType)paramIntent.getSerializableExtra("tag_mode");
        this.N3 = paramIntent;
        q1(1, this.P3, paramIntent);
      }
    }
    else {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131364570: 
      SelectAwayModeActivity.p1(this, this.M3, 1, this.R3.getStartTimeType(), l1(this.K3));
      break;
    case 2131364539: 
    case 2131364569: 
      SelectAwayModeActivity.p1(this, this.M3, 2, this.R3.getEndTimeType(), k1(this.L3));
      break;
    case 2131362110: 
      this.R3.setEnable(false);
      this.R3.setYear(null);
      this.R3.setMonth(null);
      this.R3.setDay(null);
      this.S3.p(this.R3);
      i.G(this.M3);
      break;
    case 2131362109: 
      paramView = j1();
      this.S3.g(paramView);
      i.E(this.M3, paramView, this.S3.o(), this.S3.k());
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558451);
    if (getIntent() == null) {
      return;
    }
    paramBundle = getIntent().getStringExtra("device_id_md5");
    this.M3 = paramBundle;
    this.S3 = ((AwayModeViewModel)ViewModelProviders.of(this, new IoTViewModelFactory(this, paramBundle)).get(AwayModeViewModel.class));
    m1();
    r1(this.S3.n());
    s1();
    this.S3.i();
    i.r();
  }
  
  protected void onResume()
  {
    super.onResume();
    this.p0.setText(o0.c(this, this.K3, this.N3));
    this.p1.setText(o0.c(this, this.L3, this.O3));
  }
  
  public void q1(int paramInt1, int paramInt2, RuleTimeType paramRuleTimeType)
  {
    if (paramInt1 == 1)
    {
      if (!p1(paramRuleTimeType))
      {
        this.R3.setStartTimeOffset(paramInt2);
      }
      else
      {
        this.R3.setStartTimeMin(paramInt2);
        this.K3 = paramInt2;
      }
      this.R3.setStartTimeType(paramRuleTimeType);
      this.p0.setText(o0.c(this, paramInt2, paramRuleTimeType));
    }
    else if (paramInt1 == 2)
    {
      if (!p1(paramRuleTimeType))
      {
        this.R3.setEndTimeOffset(paramInt2);
      }
      else
      {
        this.R3.setEndTimeMin(paramInt2);
        this.L3 = paramInt2;
      }
      this.R3.setEndTimeType(paramRuleTimeType);
      this.p1.setText(o0.c(this, paramInt2, paramRuleTimeType));
    }
    this.I3.setEnabled(n1());
    paramRuleTimeType = this.p2;
    if (o1()) {
      paramInt1 = 0;
    } else {
      paramInt1 = 4;
    }
    paramRuleTimeType.setVisibility(paramInt1);
  }
  
  class a
    implements Observer<ThingRuleAwayMode>
  {
    a() {}
    
    public void a(@Nullable ThingRuleAwayMode paramThingRuleAwayMode)
    {
      if (paramThingRuleAwayMode != null)
      {
        AwayModeActivity.f1(AwayModeActivity.this, paramThingRuleAwayMode);
        AwayModeActivity localAwayModeActivity = AwayModeActivity.this;
        AwayModeActivity.g1(localAwayModeActivity, AwayModeActivity.e1(localAwayModeActivity));
        if (paramThingRuleAwayMode.isEnable()) {
          AwayModeActivity.h1(AwayModeActivity.this, 1);
        } else {
          AwayModeActivity.h1(AwayModeActivity.this, 0);
        }
      }
      else
      {
        AwayModeActivity.h1(AwayModeActivity.this, 0);
      }
    }
  }
  
  class b
    implements Observer<Integer>
  {
    b() {}
    
    public void a(@Nullable Integer paramInteger)
    {
      AwayModeActivity.i1(AwayModeActivity.this, paramInteger);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\feature\AwayModeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */