package com.tplink.iot.view.iotplug.settings.led;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tplink.iot.Utils.n0;
import com.tplink.iot.Utils.o0;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.widget.ItemSettingLayout;
import com.tplink.iot.widget.TimeOffsetPickerDialog;
import com.tplink.iot.widget.TimeOffsetPickerDialog.a;

public class LedOffsetSettingActivity
  extends BaseActivity
  implements View.OnClickListener, TimeOffsetPickerDialog.a
{
  private int p0;
  private int p1;
  private ItemSettingLayout y;
  private ItemSettingLayout z;
  
  public static void e1(Activity paramActivity, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent(paramActivity, LedOffsetSettingActivity.class);
    localIntent.putExtra("tag_sunset_offset", paramInt1);
    localIntent.putExtra("tag_sunrise_offset", paramInt2);
    paramActivity.startActivityForResult(localIntent, 101);
  }
  
  public void F0(TimeOffsetPickerDialog paramTimeOffsetPickerDialog, int paramInt)
  {
    if ("tag_sunset_offset".equals(paramTimeOffsetPickerDialog.getTag()))
    {
      this.p0 = paramInt;
      this.y.setItemInfo(o0.n(this, paramInt));
    }
    if ("tag_sunrise_offset".equals(paramTimeOffsetPickerDialog.getTag()))
    {
      this.p1 = paramInt;
      this.z.setItemInfo(o0.n(this, paramInt));
    }
  }
  
  public void finish()
  {
    Intent localIntent = new Intent(this, LedScheduleActivity.class);
    localIntent.putExtra("tag_sunset_offset", this.p0);
    localIntent.putExtra("tag_sunrise_offset", this.p1);
    setResult(101, localIntent);
    super.finish();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131362970)
    {
      if (i == 2131362973) {
        n0.c(getSupportFragmentManager(), this.p0, this, "tag_sunset_offset");
      }
    }
    else {
      n0.c(getSupportFragmentManager(), this.p1, this, "tag_sunrise_offset");
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558553);
    c1(getString(2131952898));
    if (getIntent() != null)
    {
      this.p0 = getIntent().getIntExtra("tag_sunset_offset", 0);
      this.p1 = getIntent().getIntExtra("tag_sunrise_offset", 0);
    }
    this.y = ((ItemSettingLayout)findViewById(2131362973));
    this.z = ((ItemSettingLayout)findViewById(2131362970));
    this.y.setOnClickListener(this);
    this.z.setOnClickListener(this);
    this.y.setItemInfo(o0.n(this, this.p0));
    this.z.setItemInfo(o0.n(this, this.p1));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\iotplug\settings\led\LedOffsetSettingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */