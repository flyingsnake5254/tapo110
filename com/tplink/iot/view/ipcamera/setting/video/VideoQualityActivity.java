package com.tplink.iot.view.ipcamera.setting.video;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.tplink.iot.Utils.t0;
import com.tplink.iot.adapter.camera.VideoQualityAdapter;
import com.tplink.iot.adapter.camera.VideoQualityAdapter.a;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityVideoQualityBinding;
import com.tplink.iot.databinding.MenuSaveBinding;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.setting.video.VideoQualityViewModel;
import com.tplink.libtpnetwork.Utils.f0.b;
import com.tplink.libtpnetwork.cameranetwork.model.ResolutionType;
import java.util.List;

public final class VideoQualityActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private String p0;
  private MenuItem p1;
  private VideoQualityAdapter p2;
  private final VideoQualityAdapter.a p3 = new e(this);
  private ActivityVideoQualityBinding y;
  private VideoQualityViewModel z;
  
  private final void g1()
  {
    Object localObject = getIntent().getStringExtra("device_id_md5");
    if (localObject == null) {
      localObject = "";
    }
    this.p0 = ((String)localObject);
    if (localObject == null) {
      kotlin.jvm.internal.j.t("mDeviceIdMD5");
    }
    localObject = ViewModelProviders.of(this, new CameraViewModelFactory(this, (String)localObject)).get(VideoQualityViewModel.class);
    kotlin.jvm.internal.j.d(localObject, "ViewModelProviders.of(th…ityViewModel::class.java)");
    this.z = ((VideoQualityViewModel)localObject);
    this.p2 = new VideoQualityAdapter(this, this.p3);
  }
  
  private final void h1()
  {
    VideoQualityViewModel localVideoQualityViewModel = this.z;
    if (localVideoQualityViewModel == null) {
      kotlin.jvm.internal.j.t("mViewModel");
    }
    com.tplink.libtpnetwork.Utils.j.c(localVideoQualityViewModel.l(), this, new a(this));
    localVideoQualityViewModel = this.z;
    if (localVideoQualityViewModel == null) {
      kotlin.jvm.internal.j.t("mViewModel");
    }
    localVideoQualityViewModel.j().observe(this, new b(this));
    localVideoQualityViewModel = this.z;
    if (localVideoQualityViewModel == null) {
      kotlin.jvm.internal.j.t("mViewModel");
    }
    localVideoQualityViewModel.k().observe(this, new c(this));
  }
  
  private final void i1()
  {
    Object localObject1 = DataBindingUtil.setContentView(this, 2131558707);
    kotlin.jvm.internal.j.d(localObject1, "DataBindingUtil.setConte…t.activity_video_quality)");
    localObject1 = (ActivityVideoQualityBinding)localObject1;
    this.y = ((ActivityVideoQualityBinding)localObject1);
    if (localObject1 == null) {
      kotlin.jvm.internal.j.t("mBinding");
    }
    ((ViewDataBinding)localObject1).setLifecycleOwner(this);
    Object localObject2 = this.y;
    if (localObject2 == null) {
      kotlin.jvm.internal.j.t("mBinding");
    }
    localObject1 = this.z;
    if (localObject1 == null) {
      kotlin.jvm.internal.j.t("mViewModel");
    }
    ((ActivityVideoQualityBinding)localObject2).i((VideoQualityViewModel)localObject1);
    localObject1 = this.y;
    if (localObject1 == null) {
      kotlin.jvm.internal.j.t("mBinding");
    }
    ((ActivityVideoQualityBinding)localObject1).h(this);
    localObject1 = this.y;
    if (localObject1 == null) {
      kotlin.jvm.internal.j.t("mBinding");
    }
    localObject2 = ((ActivityVideoQualityBinding)localObject1).d;
    kotlin.jvm.internal.j.d(localObject2, "mBinding.rv");
    localObject1 = this.p2;
    if (localObject1 == null) {
      kotlin.jvm.internal.j.t("mVideoQualityAdapter");
    }
    ((RecyclerView)localObject2).setAdapter((RecyclerView.Adapter)localObject1);
    setTitle(2131954428);
    localObject1 = findViewById(2131364275);
    kotlin.jvm.internal.j.d(localObject1, "findViewById(R.id.toolbar)");
    ((Toolbar)localObject1).setNavigationOnClickListener(new d(this));
  }
  
  public void onClick(View paramView) {}
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    g1();
    i1();
    h1();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    kotlin.jvm.internal.j.e(paramMenu, "menu");
    getMenuInflater().inflate(2131623941, paramMenu);
    paramMenu = paramMenu.findItem(2131362300);
    kotlin.jvm.internal.j.d(paramMenu, "menu.findItem(R.id.common_save)");
    this.p1 = paramMenu;
    if (paramMenu == null) {
      kotlin.jvm.internal.j.t("mSaveMenu");
    }
    paramMenu.setActionView(2131559272);
    paramMenu = this.p1;
    if (paramMenu == null) {
      kotlin.jvm.internal.j.t("mSaveMenu");
    }
    MenuSaveBinding localMenuSaveBinding = (MenuSaveBinding)DataBindingUtil.bind(paramMenu.getActionView());
    if (localMenuSaveBinding != null)
    {
      localMenuSaveBinding.setLifecycleOwner(this);
      paramMenu = this.z;
      if (paramMenu == null) {
        kotlin.jvm.internal.j.t("mViewModel");
      }
      localMenuSaveBinding.h(paramMenu.g());
      localMenuSaveBinding.c.setOnClickListener(new f(this));
    }
    return true;
  }
  
  static final class a<T>
    implements b<Boolean>
  {
    a(VideoQualityActivity paramVideoQualityActivity) {}
    
    public final void b(Boolean paramBoolean)
    {
      kotlin.jvm.internal.j.d(paramBoolean, "it");
      if (paramBoolean.booleanValue()) {
        this.a.finish();
      } else if (t0.g(this.a)) {
        TSnackbar.x(this.a, 2131952741, 0).N();
      } else {
        TSnackbar.x(this.a, 2131953208, 0).N();
      }
    }
  }
  
  static final class b<T>
    implements Observer<ResolutionType>
  {
    b(VideoQualityActivity paramVideoQualityActivity) {}
    
    public final void a(ResolutionType paramResolutionType)
    {
      VideoQualityActivity.e1(this.a).r(paramResolutionType);
      VideoQualityViewModel localVideoQualityViewModel = VideoQualityActivity.f1(this.a);
      kotlin.jvm.internal.j.d(paramResolutionType, "it");
      localVideoQualityViewModel.p(paramResolutionType);
    }
  }
  
  static final class c<T>
    implements Observer<List<? extends ResolutionType>>
  {
    c(VideoQualityActivity paramVideoQualityActivity) {}
    
    public final void a(List<? extends ResolutionType> paramList)
    {
      VideoQualityActivity.e1(this.a).s(paramList);
    }
  }
  
  static final class d
    implements View.OnClickListener
  {
    d(VideoQualityActivity paramVideoQualityActivity) {}
    
    public final void onClick(View paramView)
    {
      this.c.onBackPressed();
    }
  }
  
  static final class e
    implements VideoQualityAdapter.a
  {
    e(VideoQualityActivity paramVideoQualityActivity) {}
    
    public final void a(ResolutionType paramResolutionType)
    {
      VideoQualityViewModel localVideoQualityViewModel = VideoQualityActivity.f1(this.a);
      kotlin.jvm.internal.j.d(paramResolutionType, "resolutionType");
      localVideoQualityViewModel.p(paramResolutionType);
    }
  }
  
  static final class f
    implements View.OnClickListener
  {
    f(VideoQualityActivity paramVideoQualityActivity) {}
    
    public final void onClick(View paramView)
    {
      VideoQualityViewModel localVideoQualityViewModel = VideoQualityActivity.f1(this.c);
      paramView = VideoQualityActivity.e1(this.c).q();
      kotlin.jvm.internal.j.d(paramView, "mVideoQualityAdapter.checkedRes");
      localVideoQualityViewModel.o(paramView);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\setting\video\VideoQualityActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */