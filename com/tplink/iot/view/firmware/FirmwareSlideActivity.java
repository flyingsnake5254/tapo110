package com.tplink.iot.view.firmware;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.Utils.x0.m;
import com.tplink.iot.adapter.firmware.FirmwareMainAdapter;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.model.firmware.IotSeriesBean;
import com.tplink.iot.viewmodel.firmware.FirmwareSlideViewModel;
import com.tplink.iot.widget.g;
import com.tplink.iot.widget.springview.widget.PullToRefreshContainer;
import com.tplink.iot.widget.springview.widget.PullToRefreshContainer.e;
import com.tplink.libtpcontrols.tppulltorefresh.TPCircleProgressBar;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import java.util.ArrayList;
import java.util.List;

public class FirmwareSlideActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private TPCircleProgressBar H3;
  private TextView I3;
  private Button J3;
  private FirmwareMainAdapter K3;
  private List<IotSeriesBean> L3 = new ArrayList();
  private FirmwareSlideViewModel M3;
  private List<IotSeriesBean> N3;
  private View p0;
  private View p1;
  private View p2;
  private RecyclerView p3;
  private PullToRefreshContainer y;
  private View z;
  
  private void f1()
  {
    this.H3.i();
    this.z.setVisibility(8);
  }
  
  private void g1()
  {
    b1(2131952696);
    this.y = ((PullToRefreshContainer)findViewById(2131363828));
    this.H3 = ((TPCircleProgressBar)findViewById(2131362244));
    this.z = findViewById(2131363183);
    this.p1 = findViewById(2131363174);
    this.p0 = findViewById(2131363194);
    this.p3 = ((RecyclerView)findViewById(2131363820));
    this.I3 = ((TextView)findViewById(2131364554));
    this.p2 = findViewById(2131363265);
    this.J3 = ((Button)findViewById(2131362149));
    this.H3.setProgressBarColor(ContextCompat.getColor(this, 2131099806));
    this.y.setHeader(new g());
    this.y.setEnableHeader(true);
    this.y.setEnableFooter(false);
    this.y.setListener(new a());
    this.J3.setOnClickListener(this);
    this.p3.setLayoutManager(new LinearLayoutManager(this));
    FirmwareMainAdapter localFirmwareMainAdapter = new FirmwareMainAdapter(this, this.L3);
    this.K3 = localFirmwareMainAdapter;
    this.p3.setAdapter(localFirmwareMainAdapter);
  }
  
  private void p1()
  {
    Object localObject = getIntent();
    if (localObject != null) {
      localObject = ((Intent)localObject).getStringExtra("entry");
    } else {
      localObject = "";
    }
    m.c((String)localObject);
  }
  
  public static void q1(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, FirmwareSlideActivity.class);
    localIntent.putExtra("entry", paramString);
    paramContext.startActivity(localIntent);
  }
  
  private void r1()
  {
    this.p0.setVisibility(8);
    this.z.setVisibility(0);
    this.H3.g();
  }
  
  private void s1()
  {
    this.M3.g().observe(this, new c(this));
    this.M3.i().observe(this, new b(this));
    this.M3.h().observe(this, new a(this));
    this.M3.j().observe(this, new d(this));
  }
  
  private void t1(List<IotSeriesBean> paramList)
  {
    f1();
    if ((paramList != null) && (paramList.size() != 0))
    {
      this.I3.setVisibility(0);
      this.p1.setVisibility(8);
      this.p0.setVisibility(0);
      this.p2.setVisibility(0);
      this.p3.setVisibility(0);
      this.K3.r(paramList);
    }
    else
    {
      this.I3.setVisibility(8);
      this.p2.setVisibility(8);
      this.p3.setVisibility(8);
      this.p0.setVisibility(0);
      this.p1.setVisibility(0);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131362149)
    {
      this.M3.v(this.N3);
      m.a();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558518);
    this.M3 = ((FirmwareSlideViewModel)ViewModelProviders.of(this).get(FirmwareSlideViewModel.class));
    g1();
    s1();
    this.M3.k();
    p1();
  }
  
  protected void onDestroy()
  {
    FirmwareSlideViewModel localFirmwareSlideViewModel = this.M3;
    if (localFirmwareSlideViewModel != null) {
      localFirmwareSlideViewModel.f();
    }
    super.onDestroy();
  }
  
  class a
    implements PullToRefreshContainer.e
  {
    a() {}
    
    public void a() {}
    
    public void onRefresh()
    {
      FirmwareSlideActivity.e1(FirmwareSlideActivity.this).t();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\firmware\FirmwareSlideActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */