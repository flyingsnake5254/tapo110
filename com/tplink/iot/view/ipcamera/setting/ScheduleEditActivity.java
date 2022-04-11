package com.tplink.iot.view.ipcamera.setting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableField;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import butterknife.OnClick;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityScheduleEditBinding;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.setting.AlarmSettingViewModel;
import com.tplink.iot.widget.UniversalDialog;
import com.tplink.iot.widget.UniversalDialog.a;

public class ScheduleEditActivity
  extends BaseActivity
  implements View.OnClickListener, TimeWheelDialog.a
{
  int H3 = 0;
  int I3 = 0;
  int J3 = 0;
  int K3 = -1;
  int L3 = -1;
  boolean[] M3;
  TimeWheelDialog N3;
  String O3;
  boolean p0;
  int p1 = -1;
  int p2 = -1;
  int p3 = 0;
  private ActivityScheduleEditBinding y;
  private AlarmSettingViewModel z;
  
  private void e1()
  {
    if (f1()) {
      new UniversalDialog.a().q(getString(2131951857)).u(getString(2131951865)).s(getString(2131951856)).r(new v3(this)).l().show(getSupportFragmentManager(), "");
    } else {
      finish();
    }
  }
  
  private boolean f1()
  {
    boolean[] arrayOfBoolean = this.y.q.getChosenArray();
    for (int i = 0; i < arrayOfBoolean.length; i++) {
      if (arrayOfBoolean[i] != this.M3[i]) {
        return true;
      }
    }
    if (this.K3 != this.p1) {
      return true;
    }
    return this.L3 != this.p2;
  }
  
  private void p1()
  {
    if (this.p1 == -1)
    {
      TSnackbar.x(this, 2131951618, -1).N();
      return;
    }
    if (this.p2 == -1)
    {
      TSnackbar.x(this, 2131951617, -1).N();
      return;
    }
    boolean[] arrayOfBoolean = this.y.q.getChosenArray();
    int i = 0;
    for (int j = 0;; j++)
    {
      k = i;
      if (j >= arrayOfBoolean.length) {
        break;
      }
      if (arrayOfBoolean[j] != 0)
      {
        k = 1;
        break;
      }
    }
    if (k == 0)
    {
      TSnackbar.x(this, 2131951621, -1).N();
      return;
    }
    int k = this.p1;
    j = this.p2;
    if (k == j)
    {
      TSnackbar.x(this, 2131951619, -1).N();
      return;
    }
    if ((!this.p0) && (k > j))
    {
      TSnackbar.x(this, 2131951620, -1).N();
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("startTime", this.y.y.getText().toString());
    localIntent.putExtra("endTime", this.y.c.getText().toString());
    localIntent.putExtra("weekDayArr", arrayOfBoolean);
    if (this.O3.equals("add")) {
      setResult(100, localIntent);
    } else {
      setResult(101, localIntent);
    }
    finish();
  }
  
  protected void g1()
  {
    Object localObject = getIntent();
    this.O3 = ((Intent)localObject).getStringExtra("mode");
    boolean bool = ((Intent)localObject).getBooleanExtra("deletable", true);
    int i = 0;
    this.p0 = ((Intent)localObject).getBooleanExtra("canPastMidnight", false);
    if (this.O3.equals("modify"))
    {
      String str1 = ((Intent)localObject).getStringExtra("startTime");
      this.p3 = Integer.parseInt(str1.split(":")[0]);
      int j = Integer.parseInt(str1.split(":")[1]);
      this.H3 = j;
      j = this.p3 * 60 + j;
      this.K3 = j;
      this.p1 = j;
      this.y.y.setText(str1);
      String str2 = ((Intent)localObject).getStringExtra("endTime");
      this.I3 = Integer.parseInt(str2.split(":")[0]);
      j = Integer.parseInt(str2.split(":")[1]);
      this.J3 = j;
      j = this.I3 * 60 + j;
      this.L3 = j;
      this.p2 = j;
      this.y.c.setText(str2);
      this.z.h.set(str1);
      this.z.i.set(str2);
      this.y.z.setTitle(2131953095);
      localObject = (boolean[])((Intent)localObject).getSerializableExtra("weekDayArr");
      this.M3 = new boolean[localObject.length];
      while (i < localObject.length)
      {
        this.M3[i] = localObject[i];
        i++;
      }
      this.y.q.setInitial((boolean[])localObject);
      if (!bool) {
        this.y.x.setVisibility(8);
      }
    }
    else
    {
      this.y.z.setTitle(2131953089);
      this.y.x.setVisibility(8);
    }
  }
  
  public void n(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject1;
    if (paramInt2 < 10)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("0");
      ((StringBuilder)localObject1).append(paramInt2);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = String.valueOf(paramInt2);
    }
    Object localObject2;
    Object localObject3;
    if (paramBoolean)
    {
      this.p1 = (paramInt1 * 60 + paramInt2);
      this.p3 = paramInt1;
      this.H3 = paramInt2;
      localObject2 = this.y.y;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramInt1);
      ((StringBuilder)localObject3).append(":");
      ((StringBuilder)localObject3).append((String)localObject1);
      ((TextView)localObject2).setText(((StringBuilder)localObject3).toString());
    }
    else
    {
      this.p2 = (paramInt1 * 60 + paramInt2);
      this.I3 = paramInt1;
      this.J3 = paramInt2;
      localObject3 = this.y.c;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append(":");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((TextView)localObject3).setText(((StringBuilder)localObject2).toString());
    }
    paramInt2 = this.p2;
    paramInt1 = this.p1;
    if ((paramInt2 < paramInt1) && (paramInt1 != -1) && (paramInt2 != -1)) {
      this.y.d.setVisibility(0);
    } else {
      this.y.d.setVisibility(8);
    }
  }
  
  public void onBackPressed()
  {
    e1();
  }
  
  public void onClick(View paramView) {}
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("device_id_md5");
    this.y = ((ActivityScheduleEditBinding)DataBindingUtil.setContentView(this, 2131558640));
    paramBundle = (AlarmSettingViewModel)ViewModelProviders.of(this, new CameraViewModelFactory(this, paramBundle)).get(AlarmSettingViewModel.class);
    this.z = paramBundle;
    this.y.h(paramBundle);
    g1();
    paramBundle = (boolean[])getIntent().getSerializableExtra("weekDayArr");
    this.y.q.setInitial(paramBundle);
    this.y.q.invalidate();
    this.y.f.setOnClickListener(new t3(this));
    this.y.y.setOnClickListener(new u3(this));
    this.y.c.setOnClickListener(new w3(this));
    setSupportActionBar(this.y.z);
  }
  
  @OnClick
  public void onDeleteClick()
  {
    setResult(102);
    finish();
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
  
  void q1()
  {
    if (this.N3 == null)
    {
      TimeWheelDialog localTimeWheelDialog = TimeWheelDialog.C0();
      this.N3 = localTimeWheelDialog;
      localTimeWheelDialog.G0(this);
    }
    this.N3.A0(this.I3, this.J3, false);
    this.N3.show(getSupportFragmentManager(), "modeTimePickerDialog");
  }
  
  void r1()
  {
    if (this.N3 == null)
    {
      TimeWheelDialog localTimeWheelDialog = TimeWheelDialog.C0();
      this.N3 = localTimeWheelDialog;
      localTimeWheelDialog.G0(this);
    }
    this.N3.A0(this.p3, this.H3, true);
    this.N3.show(getSupportFragmentManager(), "modeTimePickerDialog");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\setting\ScheduleEditActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */