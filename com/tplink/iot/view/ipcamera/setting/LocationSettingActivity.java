package com.tplink.iot.view.ipcamera.setting;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.i;
import com.bumptech.glide.request.l.b;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivitySetLocationBinding;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.setting.LocateSettingViewModel;
import com.tplink.iot.viewmodel.ipcamera.setting.j9;
import com.tplink.iot.widget.ErrorBar;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;
import org.apache.commons.lang.e;

public class LocationSettingActivity
  extends BaseActivity
  implements LocationSettingAdapter.b, View.OnClickListener
{
  private LocationSettingAdapter p0;
  private LocateSettingViewModel p1;
  public final int p2 = 12;
  private String y;
  private ActivitySetLocationBinding z;
  
  private void g1(String paramString, boolean paramBoolean)
  {
    this.z.f.d();
    Intent localIntent = new Intent();
    localIntent.putExtra("locationName", paramString);
    localIntent.putExtra("isDefault", paramBoolean);
    setResult(103, localIntent);
    finish();
  }
  
  public static void j1(Activity paramActivity, String paramString, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramActivity, LocationSettingActivity.class);
    localIntent.putExtra("device_id_md5", paramString);
    localIntent.putExtra("is_support_iot", paramBoolean);
    paramActivity.startActivity(localIntent);
  }
  
  public void a(View paramView, int paramInt)
  {
    this.z.z.setEnabled(true);
    this.p0.x(paramInt);
  }
  
  public void k1(final String paramString1, String paramString2, final boolean paramBoolean)
  {
    this.z.z.h();
    if (e.a(paramString2))
    {
      g1(paramString1, paramBoolean);
    }
    else
    {
      com.bumptech.glide.request.g localg = new com.bumptech.glide.request.g();
      ((com.bumptech.glide.request.g)localg.f0(new com.tplink.iot.Utils.y0.c())).U(this.z.c.getWidth(), this.z.c.getHeight());
      paramString1 = new b(paramString1, paramBoolean);
      com.bumptech.glide.c.x(this).s(paramString2).m0(localg).u0(paramString1);
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 12) && (paramInt2 == 13))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("locationName", paramIntent.getStringExtra("locationName"));
      setResult(103, localIntent);
      finish();
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131363541)
    {
      this.z.f.d();
      int i = this.p0.p();
      if (this.p0.s(i))
      {
        paramView = this.p0.n(i);
        this.p1.u(this, this.y, paramView, this.p0.o(i));
      }
      else
      {
        paramView = this.p0.n(i);
        this.p1.r(this.y, this.p0.n(i), this.p0.o(i));
      }
      com.tplink.iot.Utils.x0.g.b(this.y, paramView);
    }
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.y = getIntent().getStringExtra("device_id_md5");
    paramBundle = getIntent();
    boolean bool1 = false;
    boolean bool2 = paramBundle.getBooleanExtra("is_support_iot", false);
    this.z = ((ActivitySetLocationBinding)DataBindingUtil.setContentView(this, 2131558655));
    this.p1 = ((LocateSettingViewModel)ViewModelProviders.of(this, new CameraViewModelFactory(this, this.y)).get(LocateSettingViewModel.class));
    paramBundle = new LocationSettingAdapter(this, bool2);
    this.p0 = paramBundle;
    paramBundle.v(this);
    this.z.q.setLayoutManager(new GridLayoutManager(this, 3));
    this.z.q.setAdapter(this.p0);
    this.z.h(this);
    this.p1.d.observe(this, new a());
    this.p0.w(this.p1.g(), this.p1.f());
    paramBundle = this.z.z;
    if (this.p0.p() >= 0) {
      bool1 = true;
    }
    paramBundle.setEnabled(bool1);
    this.z.d.setNavigationOnClickListener(new v2(this));
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  class a
    implements Observer<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<j9>>
  {
    a() {}
    
    public void a(@Nullable com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<j9> parama)
    {
      parama = (j9)parama.a();
      if (parama != null)
      {
        LocationSettingActivity.e1(LocationSettingActivity.this).p();
        LocationSettingActivity.this.k1(parama.a(), parama.b(), parama.c());
      }
    }
  }
  
  class b
    extends com.bumptech.glide.request.k.h<Drawable>
  {
    b(String paramString, boolean paramBoolean) {}
    
    public void g(Drawable paramDrawable, b<? super Drawable> paramb)
    {
      LocationSettingActivity.f1(LocationSettingActivity.this, paramString1, paramBoolean);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\setting\LocationSettingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */