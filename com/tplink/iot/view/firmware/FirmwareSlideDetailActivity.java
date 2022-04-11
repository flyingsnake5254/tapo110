package com.tplink.iot.view.firmware;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.Utils.x0.m;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.model.firmware.EnumIoTSeriesState;
import com.tplink.iot.model.firmware.IotSeriesBean;
import com.tplink.iot.model.firmware.s;
import com.tplink.iot.viewmodel.firmware.FirmwareSlideDetailViewModel;
import com.tplink.iot.viewmodel.firmware.factory.IotFirmwareViewModelFactory;
import com.tplink.iot.widget.FirmwareDetailLayout;
import com.tplink.iot.widget.ProgressBarButton;
import java.util.List;

public class FirmwareSlideDetailActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private TextView H3;
  private FirmwareDetailLayout I3;
  private FirmwareDetailLayout J3;
  private FirmwareDetailLayout K3;
  private FirmwareDetailLayout L3;
  private ProgressBarButton M3;
  private IotSeriesBean N3;
  private FirmwareSlideDetailViewModel O3;
  private int P3;
  private int Q3;
  private TextView p0;
  private TextView p1;
  private View p2;
  private TextView p3;
  private String y;
  private ImageView z;
  
  private void e1()
  {
    b1(2131952696);
    this.z = ((ImageView)findViewById(2131363072));
    this.p0 = ((TextView)findViewById(2131364493));
    this.p1 = ((TextView)findViewById(2131364495));
    this.p2 = findViewById(2131363312);
    this.p3 = ((TextView)findViewById(2131364538));
    this.H3 = ((TextView)findViewById(2131364726));
    this.I3 = ((FirmwareDetailLayout)findViewById(2131362626));
    this.J3 = ((FirmwareDetailLayout)findViewById(2131362625));
    this.K3 = ((FirmwareDetailLayout)findViewById(2131362624));
    this.L3 = ((FirmwareDetailLayout)findViewById(2131362627));
    this.I3.setMode(1);
    this.J3.setMode(2);
    this.K3.setMode(3);
    this.L3.setMode(4);
    ProgressBarButton localProgressBarButton = (ProgressBarButton)findViewById(2131362038);
    this.M3 = localProgressBarButton;
    localProgressBarButton.setOnClickListener(this);
  }
  
  private void h1(IotSeriesBean paramIotSeriesBean)
  {
    int i = a.a[paramIotSeriesBean.getCurrentState().ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i == 4) {
            this.M3.d(2, getString(2131952733));
          }
        }
        else
        {
          if (this.Q3 == this.P3)
          {
            if (paramIotSeriesBean.isInstallFollowDownloaded()) {
              this.M3.d(0, getString(2131952405));
            } else {
              this.M3.d(4, getString(2131952466));
            }
          }
          else {
            this.M3.d(0, getString(2131954363));
          }
          m.b(paramIotSeriesBean);
        }
      }
      else
      {
        ProgressBarButton localProgressBarButton = this.M3;
        i = paramIotSeriesBean.getProgress();
        String str = getString(2131952730);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramIotSeriesBean.getProgress());
        localStringBuilder.append("%");
        localProgressBarButton.f(i, String.format(str, new Object[] { localStringBuilder.toString() }));
      }
    }
    else {
      this.M3.d(0, getString(2131952738));
    }
  }
  
  private void i1()
  {
    this.O3.i().observe(this, new e(this));
  }
  
  private void j1(IotSeriesBean paramIotSeriesBean)
  {
    if (paramIotSeriesBean == null) {
      return;
    }
    this.P3 = paramIotSeriesBean.getIoTDeviceStateList().size();
    this.Q3 = paramIotSeriesBean.getSuccessCount();
    String str1 = s.a(this, paramIotSeriesBean, true);
    String str2 = s.a(this, paramIotSeriesBean, false);
    this.z.setImageResource(l.f(paramIotSeriesBean.getCountrySpecs(), paramIotSeriesBean.getModel(), s.b(paramIotSeriesBean)));
    this.p0.setText(paramIotSeriesBean.getModel());
    this.H3.setText(paramIotSeriesBean.getReleaseNote());
    this.p3.setText(String.format(getString(2131952736), new Object[] { l.r(paramIotSeriesBean.getNewVersion()) }));
    Object localObject = this.p2;
    EnumIoTSeriesState localEnumIoTSeriesState1 = paramIotSeriesBean.getCurrentState();
    EnumIoTSeriesState localEnumIoTSeriesState2 = EnumIoTSeriesState.SUCCESS;
    int i;
    if (localEnumIoTSeriesState1 == localEnumIoTSeriesState2) {
      i = 8;
    } else {
      i = 0;
    }
    ((View)localObject).setVisibility(i);
    this.p1.setVisibility(0);
    if (paramIotSeriesBean.getCurrentState() != localEnumIoTSeriesState2)
    {
      this.p1.setTextColor(ContextCompat.getColor(this, 2131099799));
      localObject = this.p1;
      if (this.P3 == 1) {
        str2 = String.format(getString(2131952695), new Object[] { str1 });
      } else {
        str2 = String.format(getString(2131952694), new Object[] { Integer.valueOf(this.P3), str2 });
      }
      ((TextView)localObject).setText(str2);
    }
    else
    {
      i = this.Q3;
      if (i == this.P3)
      {
        this.p1.setTextColor(ContextCompat.getColor(this, 2131099803));
        this.p1.setText(2131952707);
      }
      else if (i == 0)
      {
        this.p1.setTextColor(ContextCompat.getColor(this, 2131099812));
        this.p1.setText(2131952712);
      }
      else
      {
        this.p1.setVisibility(8);
      }
    }
    this.I3.setIotSeriesBean(paramIotSeriesBean);
    this.J3.setIotSeriesBean(paramIotSeriesBean);
    this.K3.setIotSeriesBean(paramIotSeriesBean);
    this.L3.setIotSeriesBean(paramIotSeriesBean);
    h1(paramIotSeriesBean);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131362038)
    {
      paramView = this.N3;
      if ((paramView != null) && (paramView.getCurrentState() == EnumIoTSeriesState.SUCCESS) && (this.Q3 == this.P3))
      {
        onBackPressed();
      }
      else
      {
        this.O3.j();
        m.a();
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558519);
    paramBundle = getIntent().getStringExtra("series_key");
    this.y = paramBundle;
    this.O3 = ((FirmwareSlideDetailViewModel)ViewModelProviders.of(this, new IotFirmwareViewModelFactory(this, paramBundle)).get(FirmwareSlideDetailViewModel.class));
    e1();
    i1();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\firmware\FirmwareSlideDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */