package com.tplink.iot.view.group.detail;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.tplink.iot.Utils.TPLongMaterialDialogV2;
import com.tplink.iot.Utils.TPLongMaterialDialogV2.Builder;
import com.tplink.iot.Utils.TPLongMaterialDialogV2.d;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.adapter.group.EditDeviceAdapter;
import com.tplink.iot.adapter.group.EditDeviceAdapter.a;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.cloud.bean.group.common.GroupInfo;
import com.tplink.iot.viewmodel.group.DeviceListViewModel;
import com.tplink.iot.viewmodel.home.t;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GroupEditDeviceListActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private View p0;
  private DeviceListViewModel p1;
  private String p2;
  private EditDeviceAdapter y;
  private RecyclerView z;
  
  private GroupInfo m1(List<GroupInfo> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (GroupInfo)localIterator.next();
      if ((paramList != null) && (paramList.getId() != null) && (paramList.getId().equals(this.p2))) {
        return paramList;
      }
    }
    return null;
  }
  
  private void n1()
  {
    Intent localIntent = getIntent();
    if (localIntent != null) {
      this.p2 = localIntent.getStringExtra("group_id");
    }
    if (this.p2 == null) {
      this.p2 = "";
    }
  }
  
  private void o1()
  {
    this.p1 = ((DeviceListViewModel)ViewModelProviders.of(this).get(DeviceListViewModel.class));
    c1(getString(2131952790));
    ((ViewGroup)findViewById(2131363191)).setVisibility(0);
    TextView localTextView1 = (TextView)findViewById(2131364331);
    final TextView localTextView2 = (TextView)findViewById(2131364596);
    localTextView2.setEnabled(false);
    localTextView2.setAlpha(0.6F);
    this.p0 = findViewById(2131363174);
    Object localObject = (RecyclerView)findViewById(2131363820);
    this.z = ((RecyclerView)localObject);
    ((RecyclerView)localObject).setLayoutManager(new GridLayoutManager(this, 2));
    localObject = new EditDeviceAdapter(this);
    this.y = ((EditDeviceAdapter)localObject);
    ((RecyclerView.Adapter)localObject).setHasStableIds(true);
    this.y.u(new a(localTextView2));
    this.z.setAdapter(this.y);
    localTextView1.setOnClickListener(this);
    localTextView2.setOnClickListener(this);
  }
  
  private boolean p1(List<BaseALIoTDevice> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (!((BaseALIoTDevice)paramList.next()).isDeviceOffLine()) {
        return false;
      }
    }
    return true;
  }
  
  public static void q1(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, GroupEditDeviceListActivity.class);
    localIntent.putExtra("group_id", paramString);
    paramContext.startActivity(localIntent);
  }
  
  private void r1()
  {
    s0.p(this, getString(2131952444));
  }
  
  private void s1()
  {
    Object localObject = this.y.r();
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      ArrayList localArrayList = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        BaseALIoTDevice localBaseALIoTDevice = (BaseALIoTDevice)((Iterator)localObject).next();
        if ((localBaseALIoTDevice != null) && (localBaseALIoTDevice.getDeviceId() != null)) {
          localArrayList.add(localBaseALIoTDevice.getDeviceId());
        }
      }
      if (!localArrayList.isEmpty())
      {
        s0.l(this);
        this.p1.r(this.p2, localArrayList);
      }
    }
  }
  
  private void t1()
  {
    this.p0.setVisibility(8);
    this.z.setVisibility(0);
  }
  
  private void u1()
  {
    this.p0.setVisibility(0);
    this.z.setVisibility(8);
  }
  
  private void v1()
  {
    new TPLongMaterialDialogV2.Builder(this).g(getString(2131953657)).i(2131952391, 2131099804, null).l(2131953656, 2131099812, new d()).d(8, 8).b(false).c(false).a().show();
  }
  
  private void w1()
  {
    this.p1.o().observe(this, new b());
    this.p1.m().observe(this, new c());
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131364331)
    {
      if (i == 2131364596) {
        v1();
      }
    }
    else {
      GroupAddDeviceListActivity.r1(this, this.p2);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558531);
    n1();
    o1();
    w1();
  }
  
  class a
    implements EditDeviceAdapter.a
  {
    a(TextView paramTextView) {}
    
    public void b(int paramInt)
    {
      if (paramInt > 0)
      {
        localTextView2.setEnabled(true);
        localTextView2.setAlpha(1.0F);
      }
      else
      {
        localTextView2.setEnabled(false);
        localTextView2.setAlpha(0.6F);
      }
    }
    
    public void o() {}
  }
  
  class b
    implements Observer<List<GroupInfo>>
  {
    b() {}
    
    public void a(List<GroupInfo> paramList)
    {
      paramList = GroupEditDeviceListActivity.e1(GroupEditDeviceListActivity.this, paramList);
      if (paramList == null)
      {
        GroupEditDeviceListActivity.f1(GroupEditDeviceListActivity.this);
        return;
      }
      paramList = GroupEditDeviceListActivity.g1(GroupEditDeviceListActivity.this).p(paramList.getThingNames());
      if ((paramList != null) && (!paramList.isEmpty()) && (!GroupEditDeviceListActivity.h1(GroupEditDeviceListActivity.this, paramList)))
      {
        t.h(paramList);
        GroupEditDeviceListActivity.i1(GroupEditDeviceListActivity.this).s(paramList);
        GroupEditDeviceListActivity.j1(GroupEditDeviceListActivity.this);
        return;
      }
      GroupEditDeviceListActivity.this.Y0();
    }
  }
  
  class c
    implements Observer<Boolean>
  {
    c() {}
    
    public void a(Boolean paramBoolean)
    {
      if ((paramBoolean != null) && (paramBoolean.booleanValue()))
      {
        s0.g();
      }
      else
      {
        s0.g();
        GroupEditDeviceListActivity.k1(GroupEditDeviceListActivity.this);
      }
    }
  }
  
  class d
    implements TPLongMaterialDialogV2.d
  {
    d() {}
    
    public void onClick(View paramView)
    {
      GroupEditDeviceListActivity.l1(GroupEditDeviceListActivity.this);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\group\detail\GroupEditDeviceListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */