package com.tplink.iot.view.group.detail;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.x0.n;
import com.tplink.iot.adapter.group.DeviceAdapter;
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

public class GroupAddDeviceListActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private DeviceListViewModel H3;
  private String I3;
  private GroupInfo J3;
  private View p0;
  private View p1;
  private View p2;
  private View p3;
  private EditDeviceAdapter y;
  private DeviceAdapter z;
  
  private void l1()
  {
    Object localObject1 = this.y.r();
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      ArrayList localArrayList = new ArrayList();
      localObject1 = ((List)localObject1).iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (BaseALIoTDevice)((Iterator)localObject1).next();
        if ((localObject2 != null) && (((BaseALIoTDevice)localObject2).getDeviceId() != null)) {
          localArrayList.add(((BaseALIoTDevice)localObject2).getDeviceId());
        }
      }
      localObject1 = this.J3;
      if ((localObject1 != null) && (((GroupInfo)localObject1).getThingNames() != null))
      {
        localObject2 = this.J3.getThingNames().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject1 = (String)((Iterator)localObject2).next();
          if (!localArrayList.contains(localObject1)) {
            localArrayList.add(localObject1);
          }
        }
      }
      if (!localArrayList.isEmpty())
      {
        s0.l(this);
        this.H3.i(this.I3, localArrayList);
      }
    }
  }
  
  private GroupInfo m1(List<GroupInfo> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (GroupInfo)localIterator.next();
      if ((paramList != null) && (paramList.getId() != null) && (paramList.getId().equals(this.I3))) {
        return paramList;
      }
    }
    return null;
  }
  
  private void n1()
  {
    Intent localIntent = getIntent();
    if (localIntent != null) {
      this.I3 = localIntent.getStringExtra("group_id");
    }
    if (this.I3 == null) {
      this.I3 = "";
    }
  }
  
  private void o1()
  {
    Object localObject = this.H3.k();
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      List localList = this.J3.getThingNames();
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        localObject = (BaseALIoTDevice)localIterator.next();
        if ((localObject != null) && (((BaseALIoTDevice)localObject).isBulb()) && (!((BaseALIoTDevice)localObject).isLightStrip()) && (q1(localList, ((BaseALIoTDevice)localObject).getDeviceId()))) {
          if (((BaseALIoTDevice)localObject).isSupportIoTCloud()) {
            localArrayList1.add(localObject);
          } else {
            localArrayList2.add(localObject);
          }
        }
      }
      if ((localArrayList1.isEmpty()) && (localArrayList2.isEmpty()))
      {
        u1();
        return;
      }
      t1();
      if (localArrayList1.isEmpty())
      {
        this.p1.setVisibility(8);
      }
      else
      {
        t.h(localArrayList1);
        int i = this.H3.n(this.J3);
        this.y.t(localArrayList1, true, i);
        this.p1.setVisibility(0);
      }
      if (localArrayList2.isEmpty())
      {
        this.p2.setVisibility(8);
      }
      else
      {
        t.h(localArrayList2);
        this.z.n(localArrayList2);
        this.p2.setVisibility(0);
      }
      return;
    }
    u1();
  }
  
  private void p1()
  {
    this.H3 = ((DeviceListViewModel)ViewModelProviders.of(this).get(DeviceListViewModel.class));
    c1(getString(2131952821));
    final Object localObject1 = (Button)findViewById(2131362037);
    ((Button)localObject1).setText(getString(2131952455));
    ((Button)localObject1).setEnabled(false);
    ((Button)localObject1).setOnClickListener(this);
    this.p3 = findViewById(2131363174);
    this.p0 = findViewById(2131363172);
    this.p1 = findViewById(2131363164);
    this.p2 = findViewById(2131363186);
    RecyclerView localRecyclerView = (RecyclerView)findViewById(2131363820);
    localRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
    Object localObject2 = new EditDeviceAdapter(this);
    this.y = ((EditDeviceAdapter)localObject2);
    ((RecyclerView.Adapter)localObject2).setHasStableIds(true);
    this.y.u(new a((Button)localObject1));
    localRecyclerView.setAdapter(this.y);
    localObject2 = (RecyclerView)findViewById(2131363824);
    ((RecyclerView)localObject2).setLayoutManager(new GridLayoutManager(this, 2));
    localObject1 = new DeviceAdapter(this);
    this.z = ((DeviceAdapter)localObject1);
    ((RecyclerView.Adapter)localObject1).setHasStableIds(true);
    ((RecyclerView)localObject2).setAdapter(this.z);
  }
  
  private boolean q1(List<String> paramList, String paramString)
  {
    boolean bool;
    if ((paramList != null) && (paramList.contains(paramString))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static void r1(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, GroupAddDeviceListActivity.class);
    localIntent.putExtra("group_id", paramString);
    paramContext.startActivity(localIntent);
  }
  
  private void s1()
  {
    s0.p(this, getString(2131952444));
  }
  
  private void t1()
  {
    this.p3.setVisibility(8);
    this.p0.setVisibility(0);
  }
  
  private void u1()
  {
    this.p3.setVisibility(0);
    this.p0.setVisibility(8);
  }
  
  private void v1()
  {
    s0.p(this, getString(2131952782, new Object[] { "32" }));
  }
  
  private void w1()
  {
    this.H3.o().observe(this, new b());
    this.H3.j().observe(this, new c());
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131362037) {
      l1();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558524);
    n1();
    p1();
    w1();
  }
  
  class a
    implements EditDeviceAdapter.a
  {
    a(Button paramButton) {}
    
    public void b(int paramInt)
    {
      Button localButton = localObject1;
      boolean bool;
      if (paramInt > 0) {
        bool = true;
      } else {
        bool = false;
      }
      localButton.setEnabled(bool);
    }
    
    public void o()
    {
      GroupAddDeviceListActivity localGroupAddDeviceListActivity = GroupAddDeviceListActivity.this;
      s0.p(localGroupAddDeviceListActivity, localGroupAddDeviceListActivity.getString(2131952782, new Object[] { "32" }));
    }
  }
  
  class b
    implements Observer<List<GroupInfo>>
  {
    b() {}
    
    public void a(List<GroupInfo> paramList)
    {
      GroupAddDeviceListActivity localGroupAddDeviceListActivity = GroupAddDeviceListActivity.this;
      GroupAddDeviceListActivity.f1(localGroupAddDeviceListActivity, GroupAddDeviceListActivity.g1(localGroupAddDeviceListActivity, paramList));
      if (GroupAddDeviceListActivity.e1(GroupAddDeviceListActivity.this) == null)
      {
        GroupAddDeviceListActivity.h1(GroupAddDeviceListActivity.this);
        return;
      }
      GroupAddDeviceListActivity.i1(GroupAddDeviceListActivity.this);
    }
  }
  
  class c
    implements Observer<Integer>
  {
    c() {}
    
    public void a(Integer paramInteger)
    {
      
      if (paramInteger != null) {
        if (paramInteger.intValue() == 0)
        {
          GroupAddDeviceListActivity.this.finish();
          n.b();
        }
        else if (paramInteger.intValue() == 15017)
        {
          GroupAddDeviceListActivity.j1(GroupAddDeviceListActivity.this);
        }
        else
        {
          GroupAddDeviceListActivity.k1(GroupAddDeviceListActivity.this);
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\group\detail\GroupAddDeviceListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */