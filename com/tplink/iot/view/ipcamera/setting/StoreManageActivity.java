package com.tplink.iot.view.ipcamera.setting;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.Utils.d0;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityStoreManageBinding;
import com.tplink.iot.databinding.DialogFormatProcessBinding;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.setting.StoreManageViewModel;
import com.tplink.iot.widget.UniversalDialog;
import com.tplink.iot.widget.UniversalDialog.a;
import com.tplink.libtpcontrols.tppulltorefresh.TPCircleProgressBar;
import com.tplink.libtpnetwork.Utils.j;
import io.reactivex.e0.b;

public class StoreManageActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private b H3 = new b();
  private a p0;
  private UniversalDialog p1;
  private UniversalDialog p2;
  private boolean p3 = false;
  private ActivityStoreManageBinding y;
  private StoreManageViewModel z;
  
  private void A1()
  {
    if (this.p1 == null) {
      this.p1 = new UniversalDialog.a().u(getString(2131952441)).q(getString(2131953826)).v(getResources().getColor(2131099808)).t(new k4(this)).l();
    }
    if (this.p3) {
      return;
    }
    this.p3 = true;
    this.p1.show(getSupportFragmentManager(), "formatSuccessDialog");
  }
  
  private void B1()
  {
    if (this.p0 == null) {
      this.p0 = new a();
    }
    if (a.a(this.p0)) {
      return;
    }
    this.p0.b(this.z);
    this.p0.show(getFragmentManager(), "");
  }
  
  private void e1()
  {
    this.z.t.observe(this, new p4(this));
    this.y.f.setOnClickListener(new n4(this));
    this.z.v.observe(this, new o4(this));
    j.c(this.z.w, this, new m4(this));
  }
  
  private void z1()
  {
    if (this.p2 == null) {
      this.p2 = new UniversalDialog.a().q(getString(2131953825)).s(getString(2131951757)).v(getResources().getColor(2131099812)).u(getString(2131952555)).t(new q4(this)).l();
    }
    this.p2.show(getSupportFragmentManager(), "");
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131362688) {
      z1();
    }
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("device_id_md5");
    this.y = ((ActivityStoreManageBinding)DataBindingUtil.setContentView(this, 2131558681));
    paramBundle = (StoreManageViewModel)ViewModelProviders.of(this, new CameraViewModelFactory(this, paramBundle)).get(StoreManageViewModel.class);
    this.z = paramBundle;
    paramBundle.G(getIntent().getStringExtra("device_id_md5"));
    this.y.i(this.z);
    this.y.h(this);
    this.y.y.setNavigationOnClickListener(new l4(this));
    d0.h(this.y.z, getString(2131954500), ContextCompat.getColor(this, 2131099811), new i4(this));
    this.z.i();
    e1();
  }
  
  protected void onDestroy()
  {
    this.z.f();
    this.H3.dispose();
    super.onDestroy();
  }
  
  public static class a
    extends DialogFragment
  {
    private DialogFormatProcessBinding c;
    private StoreManageViewModel d;
    private boolean f = false;
    
    public void b(StoreManageViewModel paramStoreManageViewModel)
    {
      this.d = paramStoreManageViewModel;
    }
    
    public void dismiss()
    {
      if (!this.f) {
        return;
      }
      super.dismiss();
      this.f = false;
    }
    
    @Nullable
    public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
    {
      paramLayoutInflater = (DialogFormatProcessBinding)DataBindingUtil.inflate(paramLayoutInflater, 2131558788, paramViewGroup, false);
      this.c = paramLayoutInflater;
      paramLayoutInflater.h(this.d);
      this.c.c.setProgressBarColor(getResources().getColor(2131099807));
      setCancelable(false);
      this.c.c.h();
      return this.c.getRoot();
    }
    
    public void show(FragmentManager paramFragmentManager, String paramString)
    {
      if (this.f) {
        return;
      }
      super.show(paramFragmentManager, paramString);
      this.f = true;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\setting\StoreManageActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */