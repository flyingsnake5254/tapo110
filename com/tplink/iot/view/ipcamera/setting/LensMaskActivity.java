package com.tplink.iot.view.ipcamera.setting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityPrivacyModeBinding;
import com.tplink.iot.viewmodel.ipcamera.play.CloudTerraceControlViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.LensMaskViewModel;
import com.tplink.libmediaapi.common.apicallback.SimpleStreamNotificationCallback;
import com.tplink.libmediaapi.live.LiveMediaAPI;
import com.tplink.libtpnetwork.cameranetwork.business.repo.LensMaskRepository;

public class LensMaskActivity
  extends BaseActivity
{
  ActivityPrivacyModeBinding p0;
  String p1;
  String p2;
  LensMaskViewModel y;
  CloudTerraceControlViewModel z;
  
  private void e1()
  {
    this.p1 = getIntent().getStringExtra("device_id_md5");
    Object localObject = (LensMaskViewModel)ViewModelProviders.of(this).get(LensMaskViewModel.class);
    this.y = ((LensMaskViewModel)localObject);
    ((LensMaskViewModel)localObject).D(this);
    this.y.C(this.p1);
    localObject = (CloudTerraceControlViewModel)ViewModelProviders.of(this).get(CloudTerraceControlViewModel.class);
    this.z = ((CloudTerraceControlViewModel)localObject);
    ((CloudTerraceControlViewModel)localObject).n0(this);
    this.z.m0(this.p1);
  }
  
  private void f1()
  {
    x1 localx1 = new x1(this);
    this.z.Q3.observe(this, localx1);
    this.y.p1.observe(this, localx1);
  }
  
  private void g1()
  {
    ActivityPrivacyModeBinding localActivityPrivacyModeBinding = (ActivityPrivacyModeBinding)DataBindingUtil.setContentView(this, 2131558617);
    this.p0 = localActivityPrivacyModeBinding;
    localActivityPrivacyModeBinding.setLifecycleOwner(this);
    this.p0.i(this.y);
    this.p0.h(this.p1);
    this.p0.f.setOnCheckedChangeListener(new v1(this));
  }
  
  private void t1()
  {
    setTitle(2131953853);
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    e1();
    g1();
    t1();
    f1();
    LiveMediaAPI.setStreamControlNotificationCallback(this.p1, new a());
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    LiveMediaAPI.stopDisplay(this.p1);
  }
  
  protected void onStop()
  {
    super.onStop();
  }
  
  class a
    extends SimpleStreamNotificationCallback
  {
    a() {}
    
    public void onReceiveLensMaskInfo(String paramString, boolean paramBoolean)
    {
      LensMaskActivity.this.y.i().x().postValue(Boolean.valueOf(paramBoolean));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\setting\LensMaskActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */