package com.tplink.iot.view.iothub;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.adapter.quicksetup.DeviceCategoryBean;
import com.tplink.iot.adapter.quicksetup.SelectCategoryNewAdapter;
import com.tplink.iot.adapter.quicksetup.SelectCategoryNewAdapter.e;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.cloud.bean.thing.common.SubThingCategoryBean;
import com.tplink.iot.view.iotcommon.IoTFirmwareUpdateActivity;
import com.tplink.iot.view.quicksetup.sub.SubGOnBoardingActivity;
import com.tplink.iot.view.quicksetup.sub.common.SubDeviceModel;
import com.tplink.iot.viewmodel.iothub.HubChildDeviceViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.libtpnetwork.IoTNetwork.repository.HubRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HubAddChildDeviceActivity
  extends BaseActivity
{
  private HubChildDeviceViewModel p0;
  private RecyclerView y;
  private String z;
  
  private void f1(DeviceCategoryBean paramDeviceCategoryBean)
  {
    if (this.p0.f())
    {
      new TPMaterialDialogV2.Builder(this).h(2131954140).o(2131952441, 2131099808, null).y();
      return;
    }
    s0.l(this);
    this.p0.g().l0(io.reactivex.d0.b.a.a()).E(new a(this, paramDeviceCategoryBean)).C(new b(this)).F0();
  }
  
  private List<SubThingCategoryBean> g1()
  {
    return (List)((HubRepository)e.d(this.z, HubRepository.class)).s5().getValue();
  }
  
  private List<DeviceCategoryBean> h1()
  {
    Object localObject1 = g1();
    Object localObject2 = new ArrayList();
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((List)localObject2).addAll(SubDeviceModel.getOrEmptyModelList(((SubThingCategoryBean)((Iterator)localObject1).next()).getCategory()));
      }
    }
    localObject1 = new ArrayList();
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((List)localObject1).add(new DeviceCategoryBean((String)((Iterator)localObject2).next()));
    }
    return (List<DeviceCategoryBean>)localObject1;
  }
  
  private void i1(DeviceCategoryBean paramDeviceCategoryBean)
  {
    if (!paramDeviceCategoryBean.isCategory()) {
      SubGOnBoardingActivity.E1(this, this.z, paramDeviceCategoryBean.getDevice());
    }
  }
  
  private void j1(boolean paramBoolean, DeviceCategoryBean paramDeviceCategoryBean)
  {
    if (paramBoolean) {
      IoTFirmwareUpdateActivity.t1(this, this.z, true);
    } else {
      i1(paramDeviceCategoryBean);
    }
  }
  
  private void k1()
  {
    c1("");
    Object localObject = h1();
    this.y = ((RecyclerView)findViewById(2131363820));
    GridLayoutManager localGridLayoutManager = new GridLayoutManager(this, 2);
    localGridLayoutManager.setOrientation(1);
    this.y.setLayoutManager(localGridLayoutManager);
    localObject = new SelectCategoryNewAdapter(this, (List)localObject);
    ((SelectCategoryNewAdapter)localObject).q(new a());
    this.y.setAdapter((RecyclerView.Adapter)localObject);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558538);
    paramBundle = getIntent().getStringExtra("device_id_md5");
    this.z = paramBundle;
    this.p0 = ((HubChildDeviceViewModel)new ViewModelProvider(this, new IoTViewModelFactory(this, paramBundle)).get(HubChildDeviceViewModel.class));
    k1();
  }
  
  class a
    implements SelectCategoryNewAdapter.e
  {
    a() {}
    
    public void a(DeviceCategoryBean paramDeviceCategoryBean)
    {
      HubAddChildDeviceActivity.e1(HubAddChildDeviceActivity.this, paramDeviceCategoryBean);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\iothub\HubAddChildDeviceActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */