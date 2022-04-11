package com.tplink.iot.view.home.message;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ExpandableListView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.cloud.bean.push.NotificationMsgBean;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.u;
import com.tplink.iot.Utils.x;
import com.tplink.iot.adapter.home.j;
import com.tplink.iot.adapter.home.j.d;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.viewmodel.home.NotificationCenterViewModel;
import com.tplink.iot.widget.SuperExpandableListView;
import com.tplink.iot.widget.g;
import com.tplink.iot.widget.springview.widget.PullToRefreshContainer;
import com.tplink.iot.widget.springview.widget.PullToRefreshContainer.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NotificationCenterActivity
  extends BaseActivity
  implements View.OnClickListener, j.d
{
  private View H3;
  private View I3;
  private List<NotificationMsgBean> J3 = new ArrayList();
  private j K3;
  private boolean L3 = false;
  private NotificationCenterViewModel M3;
  private SuperExpandableListView p0;
  private View p1;
  private TextView p2;
  private TextView p3;
  private MenuItem y;
  private PullToRefreshContainer z;
  
  private void A1()
  {
    this.M3.l().observe(this, new b());
    this.M3.m().observe(this, new c());
    this.M3.j().observe(this, new d());
  }
  
  private void r1()
  {
    this.L3 = false;
    Object localObject = this.K3;
    if (localObject != null) {
      ((j)localObject).I(0);
    }
    localObject = this.y;
    if (localObject != null) {
      ((MenuItem)localObject).setTitle(2131952406);
    }
    t1();
  }
  
  private int s1()
  {
    Object localObject = this.J3;
    int i = 0;
    int j = 0;
    int k = i;
    if (localObject != null)
    {
      k = i;
      if (!((List)localObject).isEmpty())
      {
        localObject = this.J3.iterator();
        for (;;)
        {
          k = j;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          if (!((NotificationMsgBean)((Iterator)localObject).next()).isReadFlag()) {
            j++;
          }
        }
      }
    }
    return k;
  }
  
  private void t1()
  {
    x.d(this.p1);
  }
  
  private void u1()
  {
    x1(0);
    this.p1 = findViewById(2131364786);
    this.p2 = ((TextView)findViewById(2131364526));
    this.p3 = ((TextView)findViewById(2131364399));
    this.H3 = findViewById(2131364448);
    this.I3 = findViewById(2131362326);
    this.p2.setOnClickListener(this);
    this.p3.setOnClickListener(this);
    Object localObject = new j(this, getSupportFragmentManager());
    this.K3 = ((j)localObject);
    ((j)localObject).J(this);
    localObject = (SuperExpandableListView)findViewById(2131362616);
    this.p0 = ((SuperExpandableListView)localObject);
    ((ExpandableListView)localObject).setAdapter(this.K3);
    this.p0.setOnGroupClickListener(a.a);
    localObject = (PullToRefreshContainer)findViewById(2131363828);
    this.z = ((PullToRefreshContainer)localObject);
    ((PullToRefreshContainer)localObject).setHeader(new g());
    this.z.setEnableFooter(false);
    this.z.setListener(new a());
  }
  
  private void w1(List<NotificationMsgBean> paramList)
  {
    this.K3.H(paramList);
    int i = this.K3.getGroupCount();
    for (int j = 0; j < i; j++) {
      this.p0.expandGroup(j);
    }
  }
  
  private void x1(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("");
    c1(getString(2131953227, new Object[] { localStringBuilder.toString() }));
  }
  
  private void y1(int paramInt)
  {
    c1(getString(2131953228, new Object[] { Integer.valueOf(paramInt) }));
  }
  
  public void d0(int paramInt)
  {
    Object localObject = this.K3.n();
    y1(((List)localObject).size());
    if (paramInt == 0) {
      this.p2.setEnabled(this.M3.h(this.J3));
    } else {
      this.p2.setEnabled(this.M3.h((List)localObject));
    }
    localObject = this.p2;
    float f;
    if (((TextView)localObject).isEnabled()) {
      f = 1.0F;
    } else {
      f = 0.5F;
    }
    ((TextView)localObject).setAlpha(f);
    if (paramInt == 0)
    {
      this.p2.setText(2131953232);
      this.p3.setText(2131953221);
    }
    else
    {
      this.p2.setText(2131953226);
      this.p3.setText(2131952401);
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131364399)
    {
      if (i == 2131364526)
      {
        this.M3.n(this.K3.n());
        r1();
      }
    }
    else
    {
      s0.l(this);
      this.M3.i(this.K3.n());
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558592);
    this.M3 = ((NotificationCenterViewModel)ViewModelProviders.of(this).get(NotificationCenterViewModel.class));
    u1();
    A1();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131623959, paramMenu);
    MenuItem localMenuItem = paramMenu.findItem(2131361893);
    this.y = localMenuItem;
    boolean bool;
    if (this.J3.size() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    localMenuItem.setVisible(bool);
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 2131361893)
    {
      boolean bool = this.L3 ^ true;
      this.L3 = bool;
      if (bool)
      {
        this.p2.setText(2131953232);
        this.p3.setText(2131953221);
        paramMenuItem.setTitle(2131952405);
        this.K3.I(1);
        y1(this.K3.n().size());
        z1();
      }
      else
      {
        paramMenuItem.setTitle(2131952406);
        this.K3.I(0);
        x1(s1());
        t1();
      }
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  protected void onResume()
  {
    super.onResume();
    u.a(this);
  }
  
  protected void onStart()
  {
    super.onStart();
    this.M3.o(true);
    this.z.e();
  }
  
  protected void onStop()
  {
    super.onStop();
    this.M3.o(false);
  }
  
  public void s(NotificationMsgBean paramNotificationMsgBean)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramNotificationMsgBean);
    this.M3.n(localArrayList);
  }
  
  public void z1()
  {
    x.a(this.p1);
  }
  
  class a
    implements PullToRefreshContainer.e
  {
    a() {}
    
    public void a() {}
    
    public void onRefresh()
    {
      NotificationCenterActivity.e1(NotificationCenterActivity.this).k();
    }
  }
  
  class b
    implements Observer<List<NotificationMsgBean>>
  {
    b() {}
    
    public void a(@Nullable List<NotificationMsgBean> paramList)
    {
      NotificationCenterActivity.f1(NotificationCenterActivity.this).clear();
      if ((paramList != null) && (!paramList.isEmpty())) {
        NotificationCenterActivity.f1(NotificationCenterActivity.this).addAll(paramList);
      }
      paramList = NotificationCenterActivity.this;
      NotificationCenterActivity.j1(paramList, NotificationCenterActivity.f1(paramList));
      if (NotificationCenterActivity.f1(NotificationCenterActivity.this).isEmpty())
      {
        NotificationCenterActivity.k1(NotificationCenterActivity.this).setVisibility(0);
        NotificationCenterActivity.l1(NotificationCenterActivity.this).setVisibility(8);
        NotificationCenterActivity.m1(NotificationCenterActivity.this).I(0);
        NotificationCenterActivity.n1(NotificationCenterActivity.this).setVisibility(8);
        if (NotificationCenterActivity.o1(NotificationCenterActivity.this) != null) {
          NotificationCenterActivity.o1(NotificationCenterActivity.this).setVisible(false);
        }
      }
      else
      {
        NotificationCenterActivity.k1(NotificationCenterActivity.this).setVisibility(8);
        NotificationCenterActivity.l1(NotificationCenterActivity.this).setVisibility(0);
        if (NotificationCenterActivity.o1(NotificationCenterActivity.this) != null) {
          NotificationCenterActivity.o1(NotificationCenterActivity.this).setVisible(true);
        }
      }
      if (NotificationCenterActivity.m1(NotificationCenterActivity.this).l() == 0)
      {
        paramList = NotificationCenterActivity.this;
        NotificationCenterActivity.q1(paramList, NotificationCenterActivity.p1(paramList));
        NotificationCenterActivity.n1(NotificationCenterActivity.this).setVisibility(8);
      }
      else
      {
        paramList = NotificationCenterActivity.this;
        NotificationCenterActivity.g1(paramList, NotificationCenterActivity.m1(paramList).n().size());
      }
    }
  }
  
  class c
    implements Observer<Boolean>
  {
    c() {}
    
    public void a(@Nullable Boolean paramBoolean)
    {
      if ((paramBoolean != null) && (paramBoolean.booleanValue())) {
        NotificationCenterActivity.h1(NotificationCenterActivity.this).A();
      }
    }
  }
  
  class d
    implements Observer<Boolean>
  {
    d() {}
    
    public void a(@Nullable Boolean paramBoolean)
    {
      
      if ((paramBoolean != null) && (paramBoolean.booleanValue())) {
        NotificationCenterActivity.i1(NotificationCenterActivity.this);
      } else {
        s0.n(NotificationCenterActivity.this, 2131953328);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\home\message\NotificationCenterActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */