package com.tplink.iot.view.ipcamera.setting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tplink.iot.Utils.n0;
import com.tplink.iot.Utils.o0;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar;
import com.tplink.iot.widget.TimeScrollPickerDialog;
import com.tplink.iot.widget.TimeScrollPickerDialog.a;
import com.tplink.iot.widget.UniversalDialog;
import com.tplink.iot.widget.UniversalDialog.a;
import com.tplink.iot.widget.WeekdayPickerView;

public class MsgPushCustomTimeActivity
  extends BaseActivity
  implements View.OnClickListener, TimeScrollPickerDialog.a
{
  private int H3 = 1020;
  private int I3;
  private TextView J3;
  private TextView K3;
  private TextView L3;
  private WeekdayPickerView M3;
  private int p0 = 540;
  private int p1 = 1020;
  private int p2 = 127;
  private int p3 = 540;
  private final String y = "tag_start_time";
  private final String z = "tag_end_time";
  
  private void e1()
  {
    if (f1()) {
      new UniversalDialog.a().q(getString(2131951857)).u(getString(2131951865)).s(getString(2131951856)).r(new h3(this)).l().show(getSupportFragmentManager(), "");
    } else {
      finish();
    }
  }
  
  private boolean f1()
  {
    boolean bool;
    if ((this.p0 == this.p3) && (this.p1 == this.H3) && (this.p2 == this.I3)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private void g1()
  {
    Intent localIntent = getIntent();
    if (localIntent != null)
    {
      int i = localIntent.getIntExtra("startTime", 540);
      this.p3 = i;
      this.p0 = i;
      i = localIntent.getIntExtra("endTime", 1020);
      this.H3 = i;
      this.p1 = i;
      i = localIntent.getIntExtra("weekday", 127);
      this.I3 = i;
      this.p2 = i;
    }
  }
  
  private void h1()
  {
    this.J3 = ((TextView)findViewById(2131364107));
    this.K3 = ((TextView)findViewById(2131362541));
    this.L3 = ((TextView)findViewById(2131362953));
    this.M3 = ((WeekdayPickerView)findViewById(2131364834));
    this.J3.setOnClickListener(this);
    this.K3.setOnClickListener(this);
    this.L3.setOnClickListener(this);
    findViewById(2131363955).setOnClickListener(this);
    this.M3.setWeekDay(this.I3);
  }
  
  public void onBackPressed()
  {
    e1();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131364107: 
      n0.b(getSupportFragmentManager(), this.p3, true, false, this.H3, this, "tag_start_time");
      break;
    case 2131363955: 
      if (this.p3 == this.H3)
      {
        TSnackbar.x(this, 2131951619, -1).N();
        return;
      }
      if (this.M3.getWeekDay() == 0)
      {
        TSnackbar.x(this, 2131951621, -1).N();
        return;
      }
      paramView = new Intent();
      paramView.putExtra("startTime", this.p3);
      paramView.putExtra("endTime", this.H3);
      paramView.putExtra("weekday", this.M3.getWeekDay());
      setResult(-1, paramView);
      finish();
      break;
    case 2131362541: 
    case 2131362953: 
      n0.b(getSupportFragmentManager(), this.H3, true, true, this.p3, this, "tag_end_time");
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558587);
    b1(2131952475);
    g1();
    h1();
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (16908332 == paramMenuItem.getItemId())
    {
      e1();
      return false;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  protected void onResume()
  {
    super.onResume();
    this.J3.setText(o0.a(this, this.p3));
    this.K3.setText(o0.a(this, this.H3));
  }
  
  public void z0(TimeScrollPickerDialog paramTimeScrollPickerDialog, int paramInt)
  {
    if ("tag_start_time".equals(paramTimeScrollPickerDialog.getTag()))
    {
      this.p3 = paramInt;
      this.J3.setText(o0.a(this, paramInt));
    }
    else if ("tag_end_time".equals(paramTimeScrollPickerDialog.getTag()))
    {
      this.H3 = paramInt;
      this.K3.setText(o0.a(this, paramInt));
    }
    paramTimeScrollPickerDialog = this.L3;
    if (this.p3 > this.H3) {
      paramInt = 0;
    } else {
      paramInt = 4;
    }
    paramTimeScrollPickerDialog.setVisibility(paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\setting\MsgPushCustomTimeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */