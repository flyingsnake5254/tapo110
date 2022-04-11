package com.tplink.iot.view.group.create;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import b.d.b.f.b;
import b.d.s.a.a;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.x0.n;
import com.tplink.iot.Utils.z0.g;
import com.tplink.iot.adapter.group.CreateEditDeviceAdapter;
import com.tplink.iot.adapter.group.CreateEditDeviceAdapter.a;
import com.tplink.iot.adapter.group.DeviceAdapter;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.cloud.bean.group.common.GroupInfo;
import com.tplink.iot.view.group.info.GroupAvatarActivity;
import com.tplink.iot.view.group.info.GroupLocationSelectActivity;
import com.tplink.iot.view.group.info.GroupNameActivity;
import com.tplink.iot.viewmodel.group.AllDeviceListViewModel;
import com.tplink.iot.viewmodel.home.t;
import com.tplink.iot.widget.ItemSettingLayout;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.FamilyManagerRepository;
import com.tplink.libtpnetwork.enumerate.EnumBulbAvatarType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CreateGroupActivity
  extends BaseActivity
  implements CreateEditDeviceAdapter.a, View.OnClickListener
{
  private DeviceAdapter H3;
  private AllDeviceListViewModel I3;
  private Button J3;
  private String K3;
  private GroupInfo L3;
  private ItemSettingLayout p0;
  private View p1;
  private CreateEditDeviceAdapter p2;
  private View p3;
  private ImageView y;
  private ItemSettingLayout z;
  
  private boolean h1()
  {
    GroupInfo localGroupInfo = this.L3;
    if (localGroupInfo == null) {
      return false;
    }
    if (TextUtils.isEmpty(localGroupInfo.getName())) {
      return false;
    }
    if (TextUtils.isEmpty(this.L3.getAvatarUrl())) {
      return false;
    }
    return (!TextUtils.isEmpty(this.L3.getFamilyId())) && (!TextUtils.isEmpty(this.L3.getRoomId()));
  }
  
  private void i1()
  {
    Intent localIntent = getIntent();
    if (localIntent != null) {
      this.K3 = localIntent.getStringExtra("device_id");
    }
  }
  
  private void j1(List<BaseALIoTDevice> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        paramList = (BaseALIoTDevice)localIterator.next();
        if ((paramList != null) && (paramList.isBulb()) && (!paramList.isLightStrip())) {
          if (paramList.isSupportIoTCloud()) {
            localArrayList1.add(paramList);
          } else {
            localArrayList2.add(paramList);
          }
        }
      }
      if (localArrayList1.isEmpty())
      {
        this.p1.setVisibility(8);
      }
      else
      {
        t.h(localArrayList1);
        this.p2.r(localArrayList1);
        this.p1.setVisibility(0);
      }
      if (localArrayList2.isEmpty())
      {
        this.p3.setVisibility(8);
      }
      else
      {
        t.h(localArrayList2);
        this.H3.n(localArrayList2);
        this.p3.setVisibility(0);
      }
      return;
    }
    this.p1.setVisibility(8);
    this.p3.setVisibility(8);
  }
  
  private void k1()
  {
    this.I3 = ((AllDeviceListViewModel)ViewModelProviders.of(this).get(AllDeviceListViewModel.class));
    b1(2131952529);
    Object localObject1 = findViewById(2131362888);
    this.z = ((ItemSettingLayout)findViewById(2131362936));
    this.p0 = ((ItemSettingLayout)findViewById(2131362930));
    this.y = ((ImageView)findViewById(2131363673));
    Object localObject2 = new GroupInfo();
    this.L3 = ((GroupInfo)localObject2);
    ((GroupInfo)localObject2).setFamilyId(this.I3.l());
    this.L3.setCommon(Boolean.TRUE);
    localObject2 = EnumBulbAvatarType.BULB.getName();
    this.L3.setAvatarUrl((String)localObject2);
    this.y.setImageResource(g.d(EnumBulbAvatarType.fromString((String)localObject2)));
    n1();
    ((View)localObject1).setOnClickListener(this);
    this.z.setOnClickListener(this);
    this.p0.setOnClickListener(this);
    localObject1 = (Button)findViewById(2131362037);
    this.J3 = ((Button)localObject1);
    ((Button)localObject1).setText(getString(2131952455));
    this.J3.setOnClickListener(this);
    this.J3.setEnabled(false);
    this.p1 = findViewById(2131363164);
    localObject2 = (RecyclerView)findViewById(2131363821);
    ((RecyclerView)localObject2).setLayoutManager(new GridLayoutManager(this, 2));
    localObject1 = new CreateEditDeviceAdapter(this);
    this.p2 = ((CreateEditDeviceAdapter)localObject1);
    ((CreateEditDeviceAdapter)localObject1).t(this);
    this.p2.setHasStableIds(true);
    this.p2.s(this.K3);
    ((RecyclerView)localObject2).setAdapter(this.p2);
    this.p3 = findViewById(2131363186);
    localObject2 = (RecyclerView)findViewById(2131363824);
    ((RecyclerView)localObject2).setLayoutManager(new GridLayoutManager(this, 2));
    localObject1 = new DeviceAdapter(this);
    this.H3 = ((DeviceAdapter)localObject1);
    ((RecyclerView.Adapter)localObject1).setHasStableIds(true);
    ((RecyclerView)localObject2).setAdapter(this.H3);
  }
  
  public static void l1(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, CreateGroupActivity.class);
    localIntent.putExtra("device_id", paramString);
    paramContext.startActivity(localIntent);
  }
  
  private void m1()
  {
    if (!h1()) {
      return;
    }
    s0.l(this);
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.p2.q();
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        BaseALIoTDevice localBaseALIoTDevice = (BaseALIoTDevice)((Iterator)localObject).next();
        if (!TextUtils.isEmpty(localBaseALIoTDevice.getDeviceId())) {
          localArrayList.add(localBaseALIoTDevice.getDeviceId());
        }
      }
    }
    if (!localArrayList.isEmpty()) {
      this.L3.setThingNames(localArrayList);
    }
    this.I3.h(this.L3);
  }
  
  private void n1()
  {
    String str1 = this.K3;
    if (str1 != null)
    {
      Object localObject = this.I3.j(str1);
      if (localObject != null)
      {
        str1 = ((BaseALIoTDevice)localObject).getFamilyId();
        String str2 = ((BaseALIoTDevice)localObject).getRoomId();
        if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
        {
          localObject = ((FamilyManagerRepository)b.a(a.f(), FamilyManagerRepository.class)).f0(str1, str2);
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            this.L3.setFamilyId(str1);
            this.L3.setRoomId(str2);
            this.p0.setItemInfo((CharSequence)localObject);
          }
        }
      }
    }
  }
  
  private void o1()
  {
    s0.p(this, getString(2131952444));
  }
  
  private void p1()
  {
    s0.p(this, getString(2131952792, new Object[] { "32" }));
  }
  
  private void q1()
  {
    this.I3.i().observe(this, new a());
    this.I3.k().observe(this, new b());
  }
  
  public void b(int paramInt) {}
  
  public void o()
  {
    s0.p(this, getString(2131952782, new Object[] { "32" }));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    if (paramInt2 != -1)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
    }
    switch (paramInt1)
    {
    default: 
      break;
    case 102: 
      if (paramIntent != null)
      {
        String str = paramIntent.getStringExtra("room_id");
        paramIntent = paramIntent.getStringExtra("room_name");
        if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramIntent)))
        {
          this.L3.setRoomId(str);
          this.p0.setItemInfo(paramIntent);
        }
      }
      break;
    case 101: 
      if (paramIntent != null)
      {
        paramIntent = paramIntent.getStringExtra("group_avatar");
        if (!TextUtils.isEmpty(paramIntent))
        {
          this.L3.setAvatarUrl(paramIntent);
          this.y.setImageResource(g.d(EnumBulbAvatarType.fromString(paramIntent)));
        }
      }
      break;
    case 100: 
      if (paramIntent != null)
      {
        paramIntent = paramIntent.getStringExtra("group_name");
        if (!TextUtils.isEmpty(paramIntent))
        {
          this.L3.setName(paramIntent);
          this.z.setItemInfo(paramIntent);
        }
      }
      break;
    }
    paramIntent = this.J3;
    if (paramIntent != null) {
      paramIntent.setEnabled(h1());
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131362936: 
      GroupNameActivity.h1(this, 100, this.L3.getName());
      break;
    case 2131362930: 
      GroupLocationSelectActivity.p1(this, 102, this.L3.getRoomId());
      break;
    case 2131362888: 
      GroupAvatarActivity.i1(this, 101, this.L3.getAvatarUrl());
      break;
    case 2131362037: 
      m1();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558491);
    i1();
    k1();
    q1();
  }
  
  class a
    implements Observer<List<BaseALIoTDevice>>
  {
    a() {}
    
    public void a(List<BaseALIoTDevice> paramList)
    {
      CreateGroupActivity.e1(CreateGroupActivity.this, paramList);
    }
  }
  
  class b
    implements Observer<Integer>
  {
    b() {}
    
    public void a(Integer paramInteger)
    {
      
      if (paramInteger.intValue() == 0)
      {
        CreateGroupActivity.this.finish();
        n.a();
      }
      else if (paramInteger.intValue() == 15016)
      {
        CreateGroupActivity.f1(CreateGroupActivity.this);
      }
      else
      {
        CreateGroupActivity.g1(CreateGroupActivity.this);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\group\create\CreateGroupActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */