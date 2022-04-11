package com.tplink.iot.view.ipcamera.setting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.tplink.iot.Utils.x0.g;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityTimeZoneNewIpcBinding;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.setting.TimezoneViewModel;
import com.tplink.iot.widget.UniversalDialog;
import com.tplink.iot.widget.UniversalDialog.a;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CameraSettingRepository;
import io.reactivex.e0.b;
import io.reactivex.q;
import java.util.List;

public class TimezoneActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private TimezoneViewModel p0;
  private b p1 = new b();
  private ActivityTimeZoneNewIpcBinding y;
  private TimezoneListAdapter z;
  
  private void e1()
  {
    Object localObject = getIntent().getStringExtra("device_id_md5");
    this.y = ((ActivityTimeZoneNewIpcBinding)DataBindingUtil.setContentView(this, 2131558690));
    localObject = (TimezoneViewModel)ViewModelProviders.of(this, new CameraViewModelFactory(this, (String)localObject)).get(TimezoneViewModel.class);
    this.p0 = ((TimezoneViewModel)localObject);
    ((TimezoneViewModel)localObject).h();
    this.y.h(this);
    this.y.i(this.p0);
    localObject = new TimezoneListAdapter();
    this.z = ((TimezoneListAdapter)localObject);
    this.y.x.setAdapter((RecyclerView.Adapter)localObject);
    this.y.x.setLayoutManager(new LinearLayoutManager(this));
    TimezoneListAdapter localTimezoneListAdapter = this.z;
    localObject = this.p0;
    localTimezoneListAdapter.r(((TimezoneViewModel)localObject).b, ((TimezoneViewModel)localObject).g());
    if (this.p0.g() != null)
    {
      localObject = this.p0;
      int i = ((TimezoneViewModel)localObject).b.indexOf(((TimezoneViewModel)localObject).g());
      if (i != -1) {
        this.y.x.scrollToPosition(i);
      }
    }
    this.y.y.setNavigationOnClickListener(new s4(this));
  }
  
  private void n1()
  {
    g.d(this.p0.c);
  }
  
  public void o1(String paramString1, String paramString2)
  {
    paramString1 = this.p0.f().H1(paramString1, paramString2).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).H0(new u4(this, paramString2, paramString1), new r4(this));
    this.p1.b(paramString1);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131363954)
    {
      n1();
      new UniversalDialog.a().u(getString(2131953268)).q(getString(2131953808)).s(getString(2131951757)).t(new t4(this)).l().show(getSupportFragmentManager(), "");
    }
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    e1();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.p1.d();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\setting\TimezoneActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */