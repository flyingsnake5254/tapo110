package com.tplink.iot.view.smart.myactions;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ExpandableListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.a.f;
import com.scwang.smart.refresh.layout.c.e;
import com.scwang.smart.refresh.layout.c.g;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.adapter.smart.q;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.cloud.bean.smart.common.SmartLog;
import com.tplink.iot.viewmodel.smart.SmartLogViewModel;
import com.tplink.iot.widget.refreshlayout.SmartRefreshFooter;
import com.tplink.iot.widget.refreshlayout.SmartRefreshHeader;
import com.tplink.iot.widget.refreshlayout.TPSmartRefreshLayout;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import java.util.ArrayList;
import java.util.List;

public class ActionHistoryActivity
  extends BaseActivity
{
  private List<SmartLog> p0 = new ArrayList();
  private q p1;
  private SmartLogViewModel p2;
  private TextView y;
  private TPSmartRefreshLayout z;
  
  private void f1()
  {
    this.y = ((TextView)findViewById(2131364447));
    this.p1 = new q(this);
    ((ExpandableListView)findViewById(2131363942)).setAdapter(this.p1);
    TPSmartRefreshLayout localTPSmartRefreshLayout = (TPSmartRefreshLayout)findViewById(2131363384);
    this.z = localTPSmartRefreshLayout;
    localTPSmartRefreshLayout.Q(new SmartRefreshHeader(this));
    this.z.O(new SmartRefreshFooter(this));
    this.z.G(true);
    this.z.E(true);
    this.z.F(false);
    this.z.N(new a());
    this.z.L(new b());
    this.p0 = this.p2.j();
    n1();
  }
  
  public static void m1(Context paramContext)
  {
    paramContext.startActivity(new Intent(paramContext, ActionHistoryActivity.class));
  }
  
  private void n1()
  {
    this.p1.h(this.p0);
    TextView localTextView = this.y;
    int i;
    if (this.p0.isEmpty()) {
      i = 0;
    } else {
      i = 8;
    }
    localTextView.setVisibility(i);
  }
  
  private void p1()
  {
    new TPMaterialDialogV2.Builder(this).j(getString(2131954048)).l(2131952391, 2131099804, null).o(2131952394, 2131099808, new a(this)).g(8, 8).b(false).c(false).a().show();
  }
  
  private void q1()
  {
    this.p2.h().observe(this, new b(this));
    this.p2.g().observe(this, new c(this));
  }
  
  public void o1()
  {
    TPSmartRefreshLayout localTPSmartRefreshLayout = this.z;
    if (localTPSmartRefreshLayout != null) {
      localTPSmartRefreshLayout.j();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558660);
    b1(2131954047);
    this.p2 = ((SmartLogViewModel)ViewModelProviders.of(this).get(SmartLogViewModel.class));
    f1();
    q1();
    paramBundle = this.p2;
    paramBundle.l(paramBundle.m());
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131623939, paramMenu);
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 2131362298) {
      p1();
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  class a
    implements g
  {
    a() {}
    
    public void m(@NonNull f paramf)
    {
      ActionHistoryActivity.e1(ActionHistoryActivity.this).l(ActionHistoryActivity.e1(ActionHistoryActivity.this).m());
    }
  }
  
  class b
    implements e
  {
    b() {}
    
    public void q(@NonNull f paramf)
    {
      ActionHistoryActivity.e1(ActionHistoryActivity.this).i(ActionHistoryActivity.e1(ActionHistoryActivity.this).k());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\smart\myactions\ActionHistoryActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */