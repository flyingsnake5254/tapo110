package com.tplink.iot.view.group.device;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.adapter.group.EditGroupAdapter;
import com.tplink.iot.adapter.group.EditGroupAdapter.a;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.cloud.bean.group.common.GroupInfo;
import com.tplink.iot.view.group.create.CreateGroupActivity;
import com.tplink.iot.viewmodel.group.GroupListViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DeviceAddGroupListActivity
  extends BaseActivity
  implements EditGroupAdapter.a, View.OnClickListener
{
  private MenuItem p0;
  private GroupListViewModel p1;
  private String p2;
  private List<GroupInfo> p3;
  private EditGroupAdapter y;
  private View z;
  
  private void l1()
  {
    s0.l(this);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.y.p().iterator();
    while (localIterator.hasNext())
    {
      GroupInfo localGroupInfo = (GroupInfo)localIterator.next();
      if ((localGroupInfo != null) && (!TextUtils.isEmpty(localGroupInfo.getId()))) {
        localArrayList.add(localGroupInfo.getId());
      }
    }
    this.p1.h(this.p2, localArrayList);
  }
  
  private void m1()
  {
    Intent localIntent = getIntent();
    if (localIntent != null) {
      this.p2 = localIntent.getStringExtra("device_id");
    }
  }
  
  private void n1()
  {
    this.p1 = ((GroupListViewModel)ViewModelProviders.of(this).get(GroupListViewModel.class));
    this.z = findViewById(2131362360);
    b1(2131952530);
    Object localObject = (TextView)findViewById(2131364331);
    ((TextView)localObject).setText(getString(2131952529));
    ((TextView)localObject).setOnClickListener(this);
    RecyclerView localRecyclerView = (RecyclerView)findViewById(2131363820);
    localRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
    localObject = new EditGroupAdapter(this);
    this.y = ((EditGroupAdapter)localObject);
    ((EditGroupAdapter)localObject).r(this);
    this.y.setHasStableIds(true);
    localRecyclerView.setAdapter(this.y);
  }
  
  public static void o1(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, DeviceAddGroupListActivity.class);
    localIntent.putExtra("device_id", paramString);
    paramContext.startActivity(localIntent);
  }
  
  private void p1()
  {
    s0.p(this, getString(2131952444));
  }
  
  private void q1()
  {
    this.p1.k().observe(this, new a());
    this.p1.i().observe(this, new b());
  }
  
  public void b(int paramInt)
  {
    MenuItem localMenuItem = this.p0;
    if (localMenuItem != null)
    {
      boolean bool;
      if (paramInt > 0) {
        bool = true;
      } else {
        bool = false;
      }
      localMenuItem.setEnabled(bool);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131364331) {
      CreateGroupActivity.l1(this, this.p2);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558435);
    m1();
    n1();
    q1();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131623941, paramMenu);
    MenuItem localMenuItem = paramMenu.findItem(2131362300);
    this.p0 = localMenuItem;
    localMenuItem.setEnabled(false);
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 2131362300) {
      l1();
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  class a
    implements Observer<List<GroupInfo>>
  {
    a() {}
    
    public void a(List<GroupInfo> paramList)
    {
      paramList = DeviceAddGroupListActivity.this;
      DeviceAddGroupListActivity.f1(paramList, DeviceAddGroupListActivity.h1(paramList).j(DeviceAddGroupListActivity.g1(DeviceAddGroupListActivity.this)));
      if ((DeviceAddGroupListActivity.e1(DeviceAddGroupListActivity.this) != null) && (!DeviceAddGroupListActivity.e1(DeviceAddGroupListActivity.this).isEmpty()))
      {
        DeviceAddGroupListActivity.j1(DeviceAddGroupListActivity.this).q(DeviceAddGroupListActivity.e1(DeviceAddGroupListActivity.this));
        DeviceAddGroupListActivity.i1(DeviceAddGroupListActivity.this).setVisibility(0);
      }
      else
      {
        DeviceAddGroupListActivity.i1(DeviceAddGroupListActivity.this).setVisibility(8);
      }
    }
  }
  
  class b
    implements Observer<Boolean>
  {
    b() {}
    
    public void a(Boolean paramBoolean)
    {
      if ((paramBoolean != null) && (paramBoolean.booleanValue()))
      {
        s0.g();
        DeviceAddGroupListActivity.this.finish();
      }
      else
      {
        s0.g();
        DeviceAddGroupListActivity.k1(DeviceAddGroupListActivity.this);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\group\device\DeviceAddGroupListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */