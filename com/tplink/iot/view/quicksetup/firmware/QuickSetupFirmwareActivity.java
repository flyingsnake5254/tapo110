package com.tplink.iot.view.quicksetup.firmware;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.view.quicksetup.base.c;
import com.tplink.iot.view.quicksetup.base.d;
import com.tplink.iot.view.quicksetup.common.CommonQuickSetupBean;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.viewmodel.quicksetup.QsFirmwareViewModel;
import com.tplink.iot.widget.ProgressBarButton;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result.FwDownloadStatus;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;

public class QuickSetupFirmwareActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private TPRefreshableButton p0;
  private ProgressBarButton p1;
  private EnumDeviceType p2;
  private String p3;
  private CommonQuickSetupBean y;
  private QsFirmwareViewModel z;
  
  private void f1()
  {
    this.p0.setVisibility(4);
    this.p1.setVisibility(0);
  }
  
  private void g1()
  {
    Object localObject = getIntent();
    if (localObject != null)
    {
      localObject = ((Intent)localObject).getExtras();
      if (localObject != null) {
        this.y = ((CommonQuickSetupBean)((Bundle)localObject).getSerializable("common_quick_setup_bean"));
      }
    }
  }
  
  private void h1()
  {
    Object localObject = (TPRefreshableButton)findViewById(2131362148);
    this.p0 = ((TPRefreshableButton)localObject);
    ((TPRefreshableButton)localObject).setOnClickListener(this);
    this.p1 = ((ProgressBarButton)findViewById(2131363713));
    ImageView localImageView = (ImageView)findViewById(2131362818);
    this.p2 = d.s(this.y);
    localObject = d.r(this.y);
    this.p3 = ((String)localObject);
    localImageView.setImageResource(c.X(this.p2, (String)localObject));
  }
  
  public static void i1(Context paramContext, CommonQuickSetupBean paramCommonQuickSetupBean)
  {
    Intent localIntent = new Intent(paramContext, QuickSetupFirmwareActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("common_quick_setup_bean", paramCommonQuickSetupBean);
    localIntent.putExtras(localBundle);
    paramContext.startActivity(localIntent);
  }
  
  private void j1(FwDownloadStatus paramFwDownloadStatus)
  {
    if (paramFwDownloadStatus == null)
    {
      l1();
      return;
    }
    Object localObject1;
    Object localObject2;
    switch (paramFwDownloadStatus.getErrorCode())
    {
    default: 
      l1();
      break;
    case 6: 
      m1();
      break;
    case 5: 
      this.p1.d(2, getResources().getString(2131952733));
      break;
    case 4: 
      int i = paramFwDownloadStatus.getDownloadProgress();
      localObject1 = this.p1;
      paramFwDownloadStatus = getString(2131952730);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(String.valueOf(i));
      ((StringBuilder)localObject2).append("%");
      ((ProgressBarButton)localObject1).f(i, String.format(paramFwDownloadStatus, new Object[] { ((StringBuilder)localObject2).toString() }));
      break;
    case 3: 
      l1();
      break;
    case 2: 
      f1();
      localObject2 = this.p1;
      paramFwDownloadStatus = getString(2131952730);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(String.valueOf(0));
      ((StringBuilder)localObject1).append("%");
      ((ProgressBarButton)localObject2).f(0, String.format(paramFwDownloadStatus, new Object[] { ((StringBuilder)localObject1).toString() }));
      break;
    case 1: 
      l1();
    }
  }
  
  private void k1()
  {
    this.z.t().observe(this, new a());
  }
  
  private void l1()
  {
    QuickSetupFirmwareFailActivity.k1(this, this.y);
    finish();
  }
  
  private void m1()
  {
    QuickSetupFirmwareSuccessActivity.l1(this, this.y);
    finish();
  }
  
  public void onBackPressed() {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131362148) {
      this.z.z();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (o.a() == 0) {
      return;
    }
    setContentView(2131558622);
    g1();
    paramBundle = this.y;
    if (paramBundle == null) {
      paramBundle = "";
    } else {
      paramBundle = paramBundle.getDeviceIdMD5();
    }
    this.z = ((QsFirmwareViewModel)ViewModelProviders.of(this, new IoTViewModelFactory(this, paramBundle)).get(QsFirmwareViewModel.class));
    h1();
    k1();
  }
  
  protected void onDestroy()
  {
    TPRefreshableButton localTPRefreshableButton = this.p0;
    if (localTPRefreshableButton != null) {
      localTPRefreshableButton.h();
    }
    super.onDestroy();
  }
  
  class a
    implements Observer<FwDownloadStatus>
  {
    a() {}
    
    public void a(@Nullable FwDownloadStatus paramFwDownloadStatus)
    {
      QuickSetupFirmwareActivity.e1(QuickSetupFirmwareActivity.this, paramFwDownloadStatus);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\firmware\QuickSetupFirmwareActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */