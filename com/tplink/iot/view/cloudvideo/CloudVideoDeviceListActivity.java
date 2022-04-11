package com.tplink.iot.view.cloudvideo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.v0.e;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.a;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.base.BaseAdapter;
import com.tplink.iot.base.BaseAdapter.VH;
import com.tplink.iot.base.BaseAdapter.a;
import com.tplink.iot.cloud.bean.cloudvideo.common.CloudVideoDevice;
import com.tplink.iot.view.ipcamera.base.c;
import com.tplink.iot.view.tapocare.BillingActivity;
import com.tplink.iot.viewmodel.cloudvideo.CloudVideoDeviceListViewModel;
import com.tplink.libtpnetwork.TPCloudNetwork.device.TCDeviceBean;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import com.tplink.libtpnetwork.cameranetwork.bean.DeviceModel;
import com.tplink.libtpnetwork.enumerate.EnumDeviceStatus;
import com.tplink.libtpnetwork.enumerate.EnumUserRole;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.j;

public final class CloudVideoDeviceListActivity
  extends BaseActivity
  implements BaseAdapter.a
{
  private CloudVideoDeviceListViewModel p0;
  private HashMap p1;
  private BaseAdapter<CloudVideoDevice> y;
  private final ArrayList<CloudVideoDevice> z = new ArrayList();
  
  private final void g1(CloudVideoDevice paramCloudVideoDevice)
  {
    TCDeviceBean localTCDeviceBean = new TCDeviceBean();
    localTCDeviceBean.setDeviceId(paramCloudVideoDevice.getDeviceId());
    localTCDeviceBean.setDeviceType(paramCloudVideoDevice.getDeviceType());
    localTCDeviceBean.setOemId(paramCloudVideoDevice.getOemId());
    localTCDeviceBean.setDeviceHwVer(paramCloudVideoDevice.getHwVer());
    localTCDeviceBean.setHwId(paramCloudVideoDevice.getHwId());
    if (paramCloudVideoDevice.getStatus() == 0) {
      localObject = EnumDeviceStatus.STATUS_OFFLINE;
    } else {
      localObject = EnumDeviceStatus.STATUS_ONLINE;
    }
    localTCDeviceBean.setStatus((EnumDeviceStatus)localObject);
    localTCDeviceBean.setAlias(paramCloudVideoDevice.getAlias());
    localTCDeviceBean.setDeviceMac(paramCloudVideoDevice.getDeviceMac());
    localTCDeviceBean.setDeviceModel(paramCloudVideoDevice.getDeviceModel());
    localTCDeviceBean.setFwVer(String.valueOf(paramCloudVideoDevice.getFwVerNum()));
    localTCDeviceBean.setAppServerUrl(paramCloudVideoDevice.getAppServerUrl());
    localTCDeviceBean.setDeviceName(paramCloudVideoDevice.getDeviceName());
    if (paramCloudVideoDevice.getRole() == 0) {
      localObject = EnumUserRole.ROLE_OWNER;
    } else {
      localObject = EnumUserRole.ROLE_USER;
    }
    localTCDeviceBean.setRole((EnumUserRole)localObject);
    localTCDeviceBean.setSameRegion(paramCloudVideoDevice.getSameRegion());
    paramCloudVideoDevice = new ALCameraDevice();
    paramCloudVideoDevice.setCloudIoTDevice(localTCDeviceBean);
    Object localObject = new Intent(this, CloudVideoListActivity.class);
    ((Intent)localObject).putExtra("cloud_video_device_id", paramCloudVideoDevice.getDeviceId());
    ((Intent)localObject).putExtra("cloud_video_open_from_me", true);
    ((Intent)localObject).putExtra("cloud_video_device", paramCloudVideoDevice);
    startActivity((Intent)localObject);
  }
  
  private final void h1()
  {
    CloudVideoDeviceListViewModel localCloudVideoDeviceListViewModel = this.p0;
    if (localCloudVideoDeviceListViewModel == null) {
      j.t("cloudVideoDeviceListViewModel");
    }
    localCloudVideoDeviceListViewModel.o();
    this.y = new BaseAdapter(this.z)
    {
      public int o(int paramAnonymousInt)
      {
        return 2131559123;
      }
      
      public void r(BaseAdapter.VH paramAnonymousVH, CloudVideoDevice paramAnonymousCloudVideoDevice, int paramAnonymousInt)
      {
        j.e(paramAnonymousVH, "holder");
        j.e(paramAnonymousCloudVideoDevice, "data");
        ((ImageView)paramAnonymousVH.d(2131362837, null)).setBackgroundResource(c.f(DeviceModel.fromValue(paramAnonymousCloudVideoDevice.getDeviceModel())));
        Object localObject = paramAnonymousVH.d(2131364536, null);
        j.d(localObject, "holder.getView<TextView>(R.id.tv_name,null)");
        TextView localTextView = (TextView)localObject;
        if (TextUtils.isEmpty(paramAnonymousCloudVideoDevice.getAlias())) {
          localObject = paramAnonymousCloudVideoDevice.getDeviceModel();
        } else {
          localObject = paramAnonymousCloudVideoDevice.getAlias();
        }
        localTextView.setText((CharSequence)localObject);
        localObject = paramAnonymousVH.d(2131364515, null);
        j.d(localObject, "holder.getView<TextView>(R.id.tv_location, null)");
        ((TextView)localObject).setText(l.a(paramAnonymousCloudVideoDevice.getDeviceMac()));
        paramAnonymousVH.d(2131362408, this.b);
      }
    };
  }
  
  private final void i1()
  {
    CloudVideoDeviceListViewModel localCloudVideoDeviceListViewModel = this.p0;
    if (localCloudVideoDeviceListViewModel == null) {
      j.t("cloudVideoDeviceListViewModel");
    }
    localCloudVideoDeviceListViewModel.p().observe(this, new a(this));
    localCloudVideoDeviceListViewModel = this.p0;
    if (localCloudVideoDeviceListViewModel == null) {
      j.t("cloudVideoDeviceListViewModel");
    }
    localCloudVideoDeviceListViewModel.n().observe(this, new b(this));
    localCloudVideoDeviceListViewModel = this.p0;
    if (localCloudVideoDeviceListViewModel == null) {
      j.t("cloudVideoDeviceListViewModel");
    }
    localCloudVideoDeviceListViewModel.r().observe(this, new c(this));
    localCloudVideoDeviceListViewModel = this.p0;
    if (localCloudVideoDeviceListViewModel == null) {
      j.t("cloudVideoDeviceListViewModel");
    }
    localCloudVideoDeviceListViewModel.s().observe(this, new d(this));
  }
  
  private final void j1()
  {
    RecyclerView localRecyclerView = (RecyclerView)e1(a.rv_device_list);
    localRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    localRecyclerView.setItemAnimator(new DefaultItemAnimator());
    BaseAdapter localBaseAdapter = this.y;
    if (localBaseAdapter == null) {
      j.t("deviceListAdapter");
    }
    localRecyclerView.setAdapter(localBaseAdapter);
    ((TextView)e1(a.tv_confirm)).setOnClickListener(new e(this));
  }
  
  public <T> void A0(int paramInt, View paramView)
  {
    j.e(paramView, "v");
    paramView = this.y;
    if (paramView == null) {
      j.t("deviceListAdapter");
    }
    paramView = paramView.getItem(paramInt);
    j.d(paramView, "deviceListAdapter.getItem(position)");
    g1((CloudVideoDevice)paramView);
  }
  
  public View e1(int paramInt)
  {
    if (this.p1 == null) {
      this.p1 = new HashMap();
    }
    View localView1 = (View)this.p1.get(Integer.valueOf(paramInt));
    View localView2 = localView1;
    if (localView1 == null)
    {
      localView2 = findViewById(paramInt);
      this.p1.put(Integer.valueOf(paramInt), localView2);
    }
    return localView2;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1345) && (paramInt2 == -1))
    {
      paramIntent = this.p0;
      if (paramIntent == null) {
        j.t("cloudVideoDeviceListViewModel");
      }
      paramIntent.t();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558497);
    c1(getString(2131952373));
    paramBundle = ViewModelProviders.of(this).get(CloudVideoDeviceListViewModel.class);
    j.d(paramBundle, "ViewModelProviders.of(th…istViewModel::class.java]");
    this.p0 = ((CloudVideoDeviceListViewModel)paramBundle);
    i1();
    h1();
    j1();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (s0.j()) {
      s0.g();
    }
  }
  
  static final class a<T>
    implements Observer<Boolean>
  {
    a(CloudVideoDeviceListActivity paramCloudVideoDeviceListActivity) {}
    
    public final void a(Boolean paramBoolean)
    {
      j.d(paramBoolean, "it");
      if (paramBoolean.booleanValue())
      {
        paramBoolean = (TextView)this.a.e1(a.iv_empty);
        j.d(paramBoolean, "iv_empty");
        paramBoolean.setVisibility(0);
        paramBoolean = (RecyclerView)this.a.e1(a.rv_device_list);
        j.d(paramBoolean, "rv_device_list");
        paramBoolean.setVisibility(8);
      }
    }
  }
  
  static final class b<T>
    implements Observer<List<? extends CloudVideoDevice>>
  {
    b(CloudVideoDeviceListActivity paramCloudVideoDeviceListActivity) {}
    
    public final void a(List<? extends CloudVideoDevice> paramList)
    {
      j.d(paramList, "it");
      Object localObject;
      if ((paramList.isEmpty() ^ true))
      {
        localObject = (TextView)this.a.e1(a.iv_empty);
        j.d(localObject, "iv_empty");
        ((TextView)localObject).setVisibility(8);
        localObject = (RecyclerView)this.a.e1(a.rv_device_list);
        j.d(localObject, "rv_device_list");
        ((ViewGroup)localObject).setVisibility(0);
      }
      else
      {
        localObject = (TextView)this.a.e1(a.iv_empty);
        j.d(localObject, "iv_empty");
        ((TextView)localObject).setVisibility(0);
      }
      CloudVideoDeviceListActivity.f1(this.a).m(paramList);
    }
  }
  
  static final class c<T>
    implements Observer<Boolean>
  {
    c(CloudVideoDeviceListActivity paramCloudVideoDeviceListActivity) {}
    
    public final void a(Boolean paramBoolean)
    {
      if (j.a(paramBoolean, Boolean.TRUE))
      {
        if (!this.a.isDestroyed()) {
          s0.l(this.a);
        }
      }
      else if (j.a(paramBoolean, Boolean.FALSE)) {
        s0.g();
      }
    }
  }
  
  static final class d<T>
    implements Observer<Boolean>
  {
    d(CloudVideoDeviceListActivity paramCloudVideoDeviceListActivity) {}
    
    public final void a(Boolean paramBoolean)
    {
      if (j.a(paramBoolean, Boolean.TRUE))
      {
        paramBoolean = (TextView)this.a.e1(a.tv_confirm);
        j.d(paramBoolean, "tv_confirm");
        paramBoolean.setVisibility(8);
        paramBoolean = (TextView)this.a.e1(a.iv_empty);
        j.d(paramBoolean, "iv_empty");
        paramBoolean.setText(this.a.getString(2131954235));
      }
      else if (j.a(paramBoolean, Boolean.FALSE))
      {
        paramBoolean = (TextView)this.a.e1(a.tv_confirm);
        j.d(paramBoolean, "tv_confirm");
        paramBoolean.setVisibility(0);
        paramBoolean = (TextView)this.a.e1(a.iv_empty);
        j.d(paramBoolean, "iv_empty");
        paramBoolean.setText(this.a.getString(2131954234));
      }
    }
  }
  
  static final class e
    implements View.OnClickListener
  {
    e(CloudVideoDeviceListActivity paramCloudVideoDeviceListActivity) {}
    
    public final void onClick(View paramView)
    {
      BillingActivity.f1(this.c, e.f());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\cloudvideo\CloudVideoDeviceListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */