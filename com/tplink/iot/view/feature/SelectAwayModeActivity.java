package com.tplink.iot.view.feature;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tplink.iot.Utils.n0;
import com.tplink.iot.Utils.o0;
import com.tplink.iot.Utils.w0.a;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.base.BaseLocationActivity;
import com.tplink.iot.cloud.enumerate.RuleTimeType;
import com.tplink.iot.widget.InnerTimePicker;
import com.tplink.iot.widget.InnerTimePicker.a;
import com.tplink.iot.widget.ItemSunriseSunsetSetting;
import com.tplink.iot.widget.ItemSunriseSunsetSetting.b;
import com.tplink.iot.widget.TimeOffsetPickerDialog;
import com.tplink.iot.widget.TimeOffsetPickerDialog.a;

public class SelectAwayModeActivity
  extends BaseLocationActivity
  implements InnerTimePicker.a, TimeOffsetPickerDialog.a, View.OnClickListener, ItemSunriseSunsetSetting.b
{
  private int H3;
  private int I3;
  private int J3;
  private RuleTimeType K3 = RuleTimeType.NORMAL;
  private int L3;
  private ItemSunriseSunsetSetting p0;
  private ItemSunriseSunsetSetting p1;
  private ItemSunriseSunsetSetting p2;
  private String p3;
  private InnerTimePicker z;
  
  private void n1()
  {
    if (getIntent() != null)
    {
      this.p3 = getIntent().getStringExtra("device_id_md5");
      Object localObject = (RuleTimeType)getIntent().getSerializableExtra("tag_mode");
      this.K3 = ((RuleTimeType)localObject);
      if (localObject == null) {
        this.K3 = RuleTimeType.NORMAL;
      }
      localObject = this.K3;
      if (localObject == RuleTimeType.SUNRISE) {
        this.H3 = getIntent().getIntExtra("tag_sunset_offset", 0);
      } else if (localObject == RuleTimeType.SUNSET) {
        this.I3 = getIntent().getIntExtra("tag_sunset_offset", 0);
      } else {
        this.J3 = getIntent().getIntExtra("tag_sunset_offset", 0);
      }
      int i;
      if (getIntent().getIntExtra("request_code", 1) == 1)
      {
        localObject = getResources();
        i = 2131952461;
      }
      else
      {
        localObject = getResources();
        i = 2131952409;
      }
      c1(((Resources)localObject).getString(i));
    }
  }
  
  private void o1()
  {
    this.z = ((InnerTimePicker)findViewById(2131362862));
    this.p0 = ((ItemSunriseSunsetSetting)findViewById(2131362969));
    this.p1 = ((ItemSunriseSunsetSetting)findViewById(2131362972));
    this.p2 = ((ItemSunriseSunsetSetting)findViewById(2131362899));
    this.p0.setOnClickListener(this);
    this.p1.setOnClickListener(this);
    this.p2.setOnClickListener(this);
    this.p0.setOnOffsetSettingClickListener(this);
    this.p1.setOnOffsetSettingClickListener(this);
    this.p2.setOnOffsetSettingClickListener(this);
    this.z.setOnTimePickerChangeListener(this);
    this.z.setMinuteOfDay(this.J3);
    RuleTimeType localRuleTimeType = this.K3;
    if (localRuleTimeType == RuleTimeType.SUNSET)
    {
      this.p1.setChecked(true);
      this.p0.setChecked(false);
      this.p2.setChecked(false);
      this.p1.setOffset(o0.n(this, this.I3));
      this.z.setVisibility(8);
    }
    else if (localRuleTimeType == RuleTimeType.SUNRISE)
    {
      this.p1.setChecked(false);
      this.p0.setChecked(true);
      this.p2.setChecked(false);
      this.z.setVisibility(8);
      this.p0.setOffset(o0.n(this, this.H3));
    }
    else
    {
      this.p1.setChecked(false);
      this.p0.setChecked(false);
      this.p2.setChecked(true);
      this.z.setVisibility(0);
    }
    if (!a.k(this.p3))
    {
      this.p0.setVisibility(8);
      this.p1.setVisibility(8);
    }
  }
  
  public static void p1(Activity paramActivity, String paramString, int paramInt1, RuleTimeType paramRuleTimeType, int paramInt2)
  {
    Intent localIntent = new Intent(paramActivity, SelectAwayModeActivity.class);
    localIntent.putExtra("device_id_md5", paramString);
    localIntent.putExtra("tag_sunset_offset", paramInt2);
    localIntent.putExtra("tag_mode", paramRuleTimeType);
    localIntent.putExtra("request_code", paramInt1);
    paramActivity.startActivityForResult(localIntent, paramInt1);
  }
  
  public void F0(TimeOffsetPickerDialog paramTimeOffsetPickerDialog, int paramInt)
  {
    if (TextUtils.equals(paramTimeOffsetPickerDialog.getTag(), "tag_sunrise_offset_picker"))
    {
      this.H3 = paramInt;
      this.K3 = RuleTimeType.SUNRISE;
      this.p0.setOffset(o0.n(this, paramInt));
    }
    else if (TextUtils.equals(paramTimeOffsetPickerDialog.getTag(), "tag_sunset_offset_picker"))
    {
      this.I3 = paramInt;
      this.K3 = RuleTimeType.SUNSET;
      this.p1.setOffset(o0.n(this, paramInt));
    }
  }
  
  public void finish()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("tag_mode", this.K3);
    RuleTimeType localRuleTimeType = this.K3;
    if (localRuleTimeType == RuleTimeType.SUNRISE) {
      localIntent.putExtra("tag_sunset_offset", this.H3);
    } else if (localRuleTimeType == RuleTimeType.SUNSET) {
      localIntent.putExtra("tag_sunset_offset", this.I3);
    } else {
      localIntent.putExtra("tag_sunset_offset", this.J3);
    }
    setResult(-1, localIntent);
    super.finish();
  }
  
  public void h1()
  {
    if (k1(this.p3))
    {
      int i = this.L3;
      if (i != 2131362969)
      {
        if (i == 2131362972) {
          onClick(this.p1);
        }
      }
      else {
        onClick(this.p0);
      }
    }
  }
  
  public void m()
  {
    this.J3 = this.z.getMinutesOfDay();
  }
  
  public void onClick(View paramView)
  {
    if ((!k1(this.p3)) && (paramView.getId() != 2131362899))
    {
      this.L3 = paramView.getId();
      f1(this.p3);
      onClick(this.p2);
    }
    else
    {
      int i = paramView.getId();
      if (i != 2131362899)
      {
        if (i != 2131362969)
        {
          if (i == 2131362972)
          {
            this.K3 = RuleTimeType.SUNSET;
            this.p0.setChecked(false);
            this.p1.setChecked(true);
            this.p2.setChecked(false);
            this.z.setVisibility(8);
          }
        }
        else
        {
          this.K3 = RuleTimeType.SUNRISE;
          this.p0.setChecked(true);
          this.p1.setChecked(false);
          this.p2.setChecked(false);
          this.z.setVisibility(8);
        }
      }
      else
      {
        this.K3 = RuleTimeType.NORMAL;
        this.p0.setChecked(false);
        this.p1.setChecked(false);
        this.p2.setChecked(true);
        this.z.setVisibility(0);
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558644);
    n1();
    o1();
  }
  
  public void onOffsetSettingClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131362969)
    {
      if (i == 2131362972) {
        n0.c(getSupportFragmentManager(), this.I3, this, "tag_sunset_offset_picker");
      }
    }
    else {
      n0.c(getSupportFragmentManager(), this.H3, this, "tag_sunrise_offset_picker");
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\feature\SelectAwayModeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */