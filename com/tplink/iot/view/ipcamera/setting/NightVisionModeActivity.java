package com.tplink.iot.view.ipcamera.setting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.Utils.t0;
import com.tplink.iot.a;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.setting.NightVisionModeViewModel;
import com.tplink.libtpnetwork.cameranetwork.model.NightVisionModeType;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.j;

public final class NightVisionModeActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private HashMap p0;
  private NightVisionModeViewModel y;
  private String z;
  
  private final void g1()
  {
    Object localObject = getIntent().getStringExtra("device_id_md5");
    if (localObject == null) {
      localObject = "";
    }
    this.z = ((String)localObject);
    if (localObject == null) {
      j.t("mDeviceIdMD5");
    }
    localObject = ViewModelProviders.of(this, new CameraViewModelFactory(this, (String)localObject)).get(NightVisionModeViewModel.class);
    j.d(localObject, "ViewModelProviders.of(th…odeViewModel::class.java)");
    localObject = (NightVisionModeViewModel)localObject;
    this.y = ((NightVisionModeViewModel)localObject);
    if (localObject == null) {
      j.t("mViewModel");
    }
    ((NightVisionModeViewModel)localObject).m();
  }
  
  private final void h1()
  {
    NightVisionModeViewModel localNightVisionModeViewModel = this.y;
    if (localNightVisionModeViewModel == null) {
      j.t("mViewModel");
    }
    localNightVisionModeViewModel.n().observe(this, new a(this));
    localNightVisionModeViewModel = this.y;
    if (localNightVisionModeViewModel == null) {
      j.t("mViewModel");
    }
    localNightVisionModeViewModel.j().observe(this, new b(this));
    localNightVisionModeViewModel = this.y;
    if (localNightVisionModeViewModel == null) {
      j.t("mViewModel");
    }
    localNightVisionModeViewModel.i().observe(this, new c(this));
    localNightVisionModeViewModel = this.y;
    if (localNightVisionModeViewModel == null) {
      j.t("mViewModel");
    }
    localNightVisionModeViewModel.h().observe(this, new d(this));
  }
  
  private final void i1()
  {
    setContentView(2131558590);
    setTitle(2131952046);
    View localView = findViewById(2131364275);
    j.d(localView, "findViewById(R.id.toolbar)");
    ((Toolbar)localView).setNavigationOnClickListener(new e(this));
    ((LinearLayout)e1(a.ll_full_color)).setOnClickListener(new f(this));
    ((LinearLayout)e1(a.ll_infrared)).setOnClickListener(new g(this));
    ((LinearLayout)e1(a.ll_smart)).setOnClickListener(new h(this));
  }
  
  public View e1(int paramInt)
  {
    if (this.p0 == null) {
      this.p0 = new HashMap();
    }
    View localView1 = (View)this.p0.get(Integer.valueOf(paramInt));
    View localView2 = localView1;
    if (localView1 == null)
    {
      localView2 = findViewById(paramInt);
      this.p0.put(Integer.valueOf(paramInt), localView2);
    }
    return localView2;
  }
  
  public void onClick(View paramView) {}
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    g1();
    i1();
    h1();
  }
  
  static final class a<T>
    implements Observer<Boolean>
  {
    a(NightVisionModeActivity paramNightVisionModeActivity) {}
    
    public final void a(Boolean paramBoolean)
    {
      j.d(paramBoolean, "it");
      if (paramBoolean.booleanValue()) {
        ((CameraLoadingView)this.a.e1(a.live_loading_view)).b();
      } else {
        ((CameraLoadingView)this.a.e1(a.live_loading_view)).a();
      }
    }
  }
  
  static final class b<T>
    implements Observer<NightVisionModeType>
  {
    b(NightVisionModeActivity paramNightVisionModeActivity) {}
    
    public final void a(NightVisionModeType paramNightVisionModeType)
    {
      if (paramNightVisionModeType != null)
      {
        int i = a5.a[paramNightVisionModeType.ordinal()];
        if (i != 1)
        {
          if (i != 2)
          {
            if (i == 3)
            {
              paramNightVisionModeType = (ImageView)this.a.e1(a.iv_full_color);
              j.d(paramNightVisionModeType, "iv_full_color");
              paramNightVisionModeType.setVisibility(4);
              paramNightVisionModeType = (ImageView)this.a.e1(a.iv_infrared);
              j.d(paramNightVisionModeType, "iv_infrared");
              paramNightVisionModeType.setVisibility(0);
              paramNightVisionModeType = (ImageView)this.a.e1(a.iv_smart);
              j.d(paramNightVisionModeType, "iv_smart");
              paramNightVisionModeType.setVisibility(4);
              ((ImageView)this.a.e1(a.iv_night_vision)).setBackgroundResource(2131689928);
            }
          }
          else
          {
            paramNightVisionModeType = (ImageView)this.a.e1(a.iv_full_color);
            j.d(paramNightVisionModeType, "iv_full_color");
            paramNightVisionModeType.setVisibility(4);
            paramNightVisionModeType = (ImageView)this.a.e1(a.iv_infrared);
            j.d(paramNightVisionModeType, "iv_infrared");
            paramNightVisionModeType.setVisibility(4);
            paramNightVisionModeType = (ImageView)this.a.e1(a.iv_smart);
            j.d(paramNightVisionModeType, "iv_smart");
            paramNightVisionModeType.setVisibility(0);
            ((ImageView)this.a.e1(a.iv_night_vision)).setBackgroundResource(2131690386);
          }
        }
        else
        {
          paramNightVisionModeType = (ImageView)this.a.e1(a.iv_full_color);
          j.d(paramNightVisionModeType, "iv_full_color");
          paramNightVisionModeType.setVisibility(0);
          paramNightVisionModeType = (ImageView)this.a.e1(a.iv_infrared);
          j.d(paramNightVisionModeType, "iv_infrared");
          paramNightVisionModeType.setVisibility(4);
          paramNightVisionModeType = (ImageView)this.a.e1(a.iv_smart);
          j.d(paramNightVisionModeType, "iv_smart");
          paramNightVisionModeType.setVisibility(4);
          ((ImageView)this.a.e1(a.iv_night_vision)).setBackgroundResource(2131689672);
        }
      }
    }
  }
  
  static final class c<T>
    implements Observer<List<? extends NightVisionModeType>>
  {
    c(NightVisionModeActivity paramNightVisionModeActivity) {}
    
    public final void a(List<? extends NightVisionModeType> paramList)
    {
      if (paramList != null)
      {
        LinearLayout localLinearLayout;
        if (paramList.contains(NightVisionModeType.INFRARED))
        {
          localLinearLayout = (LinearLayout)this.a.e1(a.ll_infrared);
          j.d(localLinearLayout, "ll_infrared");
          localLinearLayout.setVisibility(0);
        }
        if (paramList.contains(NightVisionModeType.SMART))
        {
          localLinearLayout = (LinearLayout)this.a.e1(a.ll_smart);
          j.d(localLinearLayout, "ll_smart");
          localLinearLayout.setVisibility(0);
        }
        if (paramList.contains(NightVisionModeType.FULL_COLOR))
        {
          paramList = (LinearLayout)this.a.e1(a.ll_full_color);
          j.d(paramList, "ll_full_color");
          paramList.setVisibility(0);
        }
      }
    }
  }
  
  static final class d<T>
    implements Observer<Boolean>
  {
    d(NightVisionModeActivity paramNightVisionModeActivity) {}
    
    public final void a(Boolean paramBoolean)
    {
      j.d(paramBoolean, "it");
      if (paramBoolean.booleanValue()) {
        if (t0.g(this.a)) {
          TSnackbar.x(this.a, 2131952741, 0).N();
        } else {
          TSnackbar.x(this.a, 2131953208, 0).N();
        }
      }
    }
  }
  
  static final class e
    implements View.OnClickListener
  {
    e(NightVisionModeActivity paramNightVisionModeActivity) {}
    
    public final void onClick(View paramView)
    {
      this.c.onBackPressed();
    }
  }
  
  static final class f
    implements View.OnClickListener
  {
    f(NightVisionModeActivity paramNightVisionModeActivity) {}
    
    public final void onClick(View paramView)
    {
      NightVisionModeActivity.f1(this.c).p(NightVisionModeType.FULL_COLOR);
    }
  }
  
  static final class g
    implements View.OnClickListener
  {
    g(NightVisionModeActivity paramNightVisionModeActivity) {}
    
    public final void onClick(View paramView)
    {
      NightVisionModeActivity.f1(this.c).p(NightVisionModeType.INFRARED);
    }
  }
  
  static final class h
    implements View.OnClickListener
  {
    h(NightVisionModeActivity paramNightVisionModeActivity) {}
    
    public final void onClick(View paramView)
    {
      NightVisionModeActivity.f1(this.c).p(NightVisionModeType.SMART);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\setting\NightVisionModeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */