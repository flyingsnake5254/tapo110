package com.tplink.iot.view.feature;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.tplink.iot.Utils.o0;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.w;
import com.tplink.iot.adapter.feature.ScheduleAdapter;
import com.tplink.iot.adapter.feature.ScheduleAdapter.f;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.devices.trv.view.TRVEarlyStartActivity;
import com.tplink.iot.viewmodel.iotcommon.feature.ScheduleViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.widget.g;
import com.tplink.iot.widget.springview.widget.PullToRefreshContainer;
import com.tplink.iot.widget.springview.widget.PullToRefreshContainer.e;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.DesiredStatesBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.ScheduleRuleBean;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ScheduleListActivity
  extends BaseActivity
  implements ScheduleAdapter.f
{
  private ScheduleAdapter H3;
  private ScheduleViewModel I3;
  private boolean J3;
  private Comparator<ScheduleRuleBean> K3 = new e();
  private PullToRefreshContainer p0;
  private MenuItem p1;
  private String p2;
  private boolean p3;
  private View y;
  private RecyclerView z;
  
  private void k1()
  {
    Object localObject = getIntent();
    boolean bool1 = false;
    boolean bool2 = ((Intent)localObject).getBooleanExtra("is_color_bulb", false);
    localObject = this.I3;
    localObject = new ScheduleAdapter(this, ((ScheduleViewModel)localObject).s, bool2, ((ScheduleViewModel)localObject).E(), this.I3.t());
    this.H3 = ((ScheduleAdapter)localObject);
    ((ScheduleAdapter)localObject).s(this);
    this.z.setLayoutManager(new LinearLayoutManager(this));
    this.z.setAdapter(this.H3);
    localObject = this.I3;
    bool2 = bool1;
    if (((ScheduleViewModel)localObject).p)
    {
      bool2 = bool1;
      if (((ScheduleViewModel)localObject).q) {
        bool2 = true;
      }
    }
    this.J3 = bool2;
  }
  
  private void l1()
  {
    c1(getString(2131953389));
    this.y = findViewById(2131364797);
    this.z = ((RecyclerView)findViewById(2131363820));
    PullToRefreshContainer localPullToRefreshContainer = (PullToRefreshContainer)findViewById(2131363828);
    this.p0 = localPullToRefreshContainer;
    localPullToRefreshContainer.setHeader(new g());
    this.p0.setEnableFooter(false);
    this.p0.setListener(new d());
  }
  
  public static void o1(Context paramContext, String paramString, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramContext, ScheduleListActivity.class);
    localIntent.putExtra("device_id_md5", paramString);
    localIntent.putExtra("is_color_bulb", paramBoolean);
    paramContext.startActivity(localIntent);
  }
  
  private void p1(List<ScheduleRuleBean> paramList)
  {
    if (paramList == null) {
      return;
    }
    Collections.sort(paramList, this.K3);
    this.H3.r(paramList);
  }
  
  private void q1(boolean paramBoolean)
  {
    MenuItem localMenuItem = this.p1;
    if (localMenuItem != null) {
      localMenuItem.setVisible(paramBoolean);
    }
  }
  
  private void r1(DesiredStatesBean paramDesiredStatesBean)
  {
    if (paramDesiredStatesBean == null) {
      return;
    }
    paramDesiredStatesBean.isTRV = this.J3;
  }
  
  private void s1()
  {
    this.I3.B().observe(this, new a());
    this.I3.v().observe(this, new b());
    this.I3.A().observe(this, new c());
    this.I3.y().observe(this, new d(this));
  }
  
  public void H0(ScheduleRuleBean paramScheduleRuleBean)
  {
    this.I3.H(paramScheduleRuleBean);
    com.tplink.iot.Utils.x0.i.A(this.p2);
  }
  
  public void N(ScheduleRuleBean paramScheduleRuleBean)
  {
    ScheduleDetailActivity.J1(this, paramScheduleRuleBean, this.p2);
  }
  
  public void W(ScheduleRuleBean paramScheduleRuleBean)
  {
    r1(paramScheduleRuleBean.getDesiredStates());
    this.I3.m(paramScheduleRuleBean, true);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558642);
    this.p3 = o0.p(this);
    paramBundle = getIntent().getStringExtra("device_id_md5");
    this.p2 = paramBundle;
    this.I3 = ((ScheduleViewModel)ViewModelProviders.of(this, new IoTViewModelFactory(this, paramBundle)).get(ScheduleViewModel.class));
    l1();
    k1();
    s1();
    this.p0.e();
    com.tplink.iot.Utils.x0.i.u();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131623964, paramMenu);
    this.p1 = paramMenu.findItem(2131363964);
    q1(this.I3.r);
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 2131363677)
    {
      if (this.H3.getItemCount() >= this.I3.z()) {
        s0.v(this, getResources().getString(2131953943, new Object[] { Integer.valueOf(this.I3.z()) }));
      } else {
        ScheduleDetailActivity.J1(this, null, this.p2);
      }
      return true;
    }
    if ((paramMenuItem.getItemId() == 2131363964) && (this.I3.r)) {
      X0(TRVEarlyStartActivity.class, this.p2);
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.p3 != o0.p(this))
    {
      ScheduleAdapter localScheduleAdapter = this.H3;
      if (localScheduleAdapter != null)
      {
        localScheduleAdapter.notifyDataSetChanged();
        this.p3 = o0.p(this);
      }
    }
  }
  
  class a
    implements Observer<List<ScheduleRuleBean>>
  {
    a() {}
    
    public void a(@Nullable List<ScheduleRuleBean> paramList)
    {
      ScheduleListActivity.e1(ScheduleListActivity.this).A();
      int i = 0;
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        ScheduleListActivity.f1(ScheduleListActivity.this).setVisibility(8);
        ScheduleListActivity.g1(ScheduleListActivity.this).setVisibility(0);
        ScheduleListActivity.h1(ScheduleListActivity.this, paramList);
        i = paramList.size();
      }
      else
      {
        ScheduleListActivity.f1(ScheduleListActivity.this).setVisibility(0);
        ScheduleListActivity.g1(ScheduleListActivity.this).setVisibility(8);
      }
      com.tplink.iot.Utils.x0.i.z(i);
    }
  }
  
  class b
    implements Observer<Boolean>
  {
    b() {}
    
    public void a(@Nullable Boolean paramBoolean)
    {
      if ((paramBoolean != null) && (paramBoolean.booleanValue()))
      {
        ScheduleListActivity.e1(ScheduleListActivity.this).A();
        s0.n(ScheduleListActivity.this, 2131952444);
      }
    }
  }
  
  class c
    implements Observer<com.tplink.iot.viewmodel.quicksetup.i<ScheduleRuleBean>>
  {
    c() {}
    
    public void a(com.tplink.iot.viewmodel.quicksetup.i<ScheduleRuleBean> parami)
    {
      if ((parami != null) && (parami.b() != 0))
      {
        ScheduleRuleBean localScheduleRuleBean = (ScheduleRuleBean)parami.a();
        if (localScheduleRuleBean != null)
        {
          localScheduleRuleBean.setDeleting(false);
          ScheduleListActivity.i1(ScheduleListActivity.this).notifyDataSetChanged();
          if (parami.b() == 64524) {
            w.f();
          } else {
            s0.n(ScheduleListActivity.this, 2131952444);
          }
        }
      }
    }
  }
  
  class d
    implements PullToRefreshContainer.e
  {
    d() {}
    
    public void a() {}
    
    public void onRefresh()
    {
      ScheduleListActivity.j1(ScheduleListActivity.this).G();
    }
  }
  
  class e
    implements Comparator<ScheduleRuleBean>
  {
    e() {}
    
    public int a(ScheduleRuleBean paramScheduleRuleBean1, ScheduleRuleBean paramScheduleRuleBean2)
    {
      return ScheduleListActivity.j1(ScheduleListActivity.this).u(paramScheduleRuleBean1.getStartTimeMin()) - ScheduleListActivity.j1(ScheduleListActivity.this).u(paramScheduleRuleBean2.getStartTimeMin());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\feature\ScheduleListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */