package com.tplink.iot.view.group.device;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.adapter.group.GroupAdapter;
import com.tplink.iot.adapter.group.GroupAdapter.a;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.cloud.bean.group.common.GroupInfo;
import com.tplink.iot.view.group.create.CreateGroupActivity;
import com.tplink.iot.viewmodel.group.GroupListViewModel;
import java.util.List;

public class DeviceShowGroupListActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private List<GroupInfo> H3;
  private TextView p0;
  private GroupListViewModel p1;
  private GroupAdapter p2;
  private String p3;
  private LinearLayout y;
  private LinearLayout z;
  
  private void o1()
  {
    Intent localIntent = getIntent();
    if (localIntent != null) {
      this.p3 = localIntent.getStringExtra("device_id");
    }
  }
  
  private void p1()
  {
    if (s1()) {
      DeviceAddGroupListActivity.o1(this, this.p3);
    } else {
      CreateGroupActivity.l1(this, this.p3);
    }
  }
  
  private void q1(GroupInfo paramGroupInfo)
  {
    com.tplink.iot.Utils.z0.o.e(this, paramGroupInfo);
  }
  
  private void r1()
  {
    b1(2131952791);
    Object localObject = (TextView)findViewById(2131364331);
    this.p0 = ((TextView)localObject);
    ((TextView)localObject).setText(getString(2131952529));
    this.p0.setOnClickListener(this);
    this.y = ((LinearLayout)findViewById(2131363277));
    this.z = ((LinearLayout)findViewById(2131363285));
    this.p2 = new GroupAdapter(this);
    localObject = (RecyclerView)findViewById(2131363815);
    ((RecyclerView)localObject).setLayoutManager(new GridLayoutManager(this, 2));
    ((RecyclerView)localObject).setItemAnimator(new DefaultItemAnimator());
    ((RecyclerView)localObject).setAdapter(this.p2);
    this.p2.p(new a());
  }
  
  private boolean s1()
  {
    return this.p1.m(this.p3);
  }
  
  public static void t1(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, DeviceShowGroupListActivity.class);
    localIntent.putExtra("device_id", paramString);
    paramContext.startActivity(localIntent);
  }
  
  private void u1()
  {
    this.p1.k().observe(this, new b());
  }
  
  private void v1()
  {
    this.y.setVisibility(8);
    this.z.setVisibility(0);
  }
  
  private void w1()
  {
    this.y.setVisibility(0);
    this.z.setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131364331) {
      p1();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (com.tplink.iot.core.o.a() == 0) {
      return;
    }
    setContentView(2131558508);
    this.p1 = ((GroupListViewModel)ViewModelProviders.of(this).get(GroupListViewModel.class));
    o1();
    r1();
    u1();
  }
  
  class a
    implements GroupAdapter.a
  {
    a() {}
    
    public void a(View paramView, GroupInfo paramGroupInfo)
    {
      DeviceShowGroupListActivity.e1(DeviceShowGroupListActivity.this, paramGroupInfo);
    }
  }
  
  class b
    implements Observer<List<GroupInfo>>
  {
    b() {}
    
    public void a(List<GroupInfo> paramList)
    {
      DeviceShowGroupListActivity localDeviceShowGroupListActivity = DeviceShowGroupListActivity.this;
      DeviceShowGroupListActivity.g1(localDeviceShowGroupListActivity, DeviceShowGroupListActivity.i1(localDeviceShowGroupListActivity).l(paramList, DeviceShowGroupListActivity.h1(DeviceShowGroupListActivity.this)));
      if (DeviceShowGroupListActivity.j1(DeviceShowGroupListActivity.this)) {
        DeviceShowGroupListActivity.k1(DeviceShowGroupListActivity.this).setText(DeviceShowGroupListActivity.this.getString(2131952530));
      } else {
        DeviceShowGroupListActivity.k1(DeviceShowGroupListActivity.this).setText(DeviceShowGroupListActivity.this.getString(2131952529));
      }
      if ((DeviceShowGroupListActivity.f1(DeviceShowGroupListActivity.this) != null) && (!DeviceShowGroupListActivity.f1(DeviceShowGroupListActivity.this).isEmpty()))
      {
        DeviceShowGroupListActivity.m1(DeviceShowGroupListActivity.this).o(DeviceShowGroupListActivity.f1(DeviceShowGroupListActivity.this));
        DeviceShowGroupListActivity.n1(DeviceShowGroupListActivity.this);
      }
      else
      {
        DeviceShowGroupListActivity.l1(DeviceShowGroupListActivity.this);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\group\device\DeviceShowGroupListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */