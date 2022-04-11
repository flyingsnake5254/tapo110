package com.tplink.iot.view.quicksetup.common;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import b.d.n.i.g;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.z;
import com.tplink.iot.adapter.quicksetup.DeviceCategoryBean;
import com.tplink.iot.adapter.quicksetup.SelectCategoryNewAdapter;
import com.tplink.iot.adapter.quicksetup.SelectCategoryNewAdapter.e;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.model.about.d;
import com.tplink.iot.view.about.CommonWebActivity;
import com.tplink.iot.view.authflip.GoogleAssistantActivity;
import com.tplink.iot.view.quicksetup.discovery.DiscoveryDeviceListActivity;
import com.tplink.iot.view.wss.WssAlexaActivity;
import com.tplink.iot.viewmodel.quicksetup.QuickDiscoveryViewModel;
import com.tplink.iot.viewmodel.quicksetup.QuickSetupVerifyPwdViewModel;
import com.tplink.libtpnetwork.TDPNetwork.bean.TDPIoTDevice;
import com.tplink.libtpnetwork.Utils.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SelectCategoryNewActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private TextView H3;
  private QuickSetupVerifyPwdViewModel I3;
  private QuickDiscoveryViewModel J3;
  private boolean K3 = false;
  private RecyclerView p0;
  private TextView p1;
  private RadioGroup p2;
  private CardView p3;
  private List<DeviceCategoryBean> y = new ArrayList();
  private Map<Integer, Integer> z = new HashMap();
  
  private void m1(int paramInt, String paramString, List<String> paramList)
  {
    this.z.put(Integer.valueOf(paramInt), Integer.valueOf(this.y.size()));
    this.y.add(new DeviceCategoryBean(true, paramString));
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      paramString = (String)paramList.next();
      this.y.add(new DeviceCategoryBean(paramString));
    }
  }
  
  private void n1(int paramInt, RadioGroup paramRadioGroup)
  {
    Iterator localIterator = this.z.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((Integer)localEntry.getValue()).intValue() == paramInt)
      {
        paramInt = ((Integer)localEntry.getKey()).intValue();
        break label71;
      }
    }
    paramInt = -1;
    label71:
    if ((paramInt != -1) && (paramRadioGroup != null)) {
      paramRadioGroup.check(paramInt);
    }
  }
  
  private void o1()
  {
    for (int i = 0; i < this.p2.getChildCount(); i++)
    {
      Object localObject = this.p2.getChildAt(i);
      if ((localObject instanceof RadioButton))
      {
        localObject = (RadioButton)localObject;
        if (!((RadioButton)localObject).getText().toString().contains(" ")) {
          ((RadioButton)localObject).setMaxLines(1);
        }
      }
    }
  }
  
  private int p1(int paramInt)
  {
    Integer localInteger = (Integer)this.z.get(Integer.valueOf(paramInt));
    if (localInteger != null) {
      paramInt = localInteger.intValue();
    } else {
      paramInt = 0;
    }
    return paramInt;
  }
  
  private void q1()
  {
    s0.g();
    com.tplink.iot.Utils.login.a.g(this);
  }
  
  private void r1(List<TDPIoTDevice> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.H3.setText(getString(2131952588, new Object[] { Integer.valueOf(paramList.size()) }));
      this.p3.setVisibility(0);
    }
    else
    {
      this.H3.setText("");
      this.p3.setVisibility(8);
    }
  }
  
  private void s1()
  {
    m1(2131362893, getString(2131952870), com.tplink.iot.view.quicksetup.base.b.b());
    m1(2131362944, getString(2131952881), com.tplink.iot.view.quicksetup.base.b.e());
    m1(2131362892, getString(2131952867), com.tplink.iot.view.quicksetup.base.b.a());
    m1(2131362929, getString(2131952875), com.tplink.iot.view.quicksetup.base.b.d());
  }
  
  private void t1()
  {
    s1();
    findViewById(2131364342).setOnClickListener(this);
    findViewById(2131364465).setOnClickListener(this);
    final Object localObject = (TextView)findViewById(2131364338);
    this.p1 = ((TextView)localObject);
    ((TextView)localObject).setOnClickListener(this);
    this.p2 = ((RadioGroup)findViewById(2131363850));
    this.p0 = ((RecyclerView)findViewById(2131363820));
    localObject = (CardView)findViewById(2131362350);
    this.p3 = ((CardView)localObject);
    ((FrameLayout)localObject).setOnClickListener(this);
    this.H3 = ((TextView)findViewById(2131364417));
    localObject = new GridLayoutManager(this, 2);
    ((LinearLayoutManager)localObject).setOrientation(1);
    this.p0.setLayoutManager((RecyclerView.LayoutManager)localObject);
    SelectCategoryNewAdapter localSelectCategoryNewAdapter = new SelectCategoryNewAdapter(this, this.y);
    this.p0.setAdapter(localSelectCategoryNewAdapter);
    localSelectCategoryNewAdapter.q(new a());
    this.p2.setOnCheckedChangeListener(new b());
    o1();
    this.p0.addOnScrollListener(new c((GridLayoutManager)localObject));
  }
  
  private void v1()
  {
    QuickSetupVerifyPwdViewModel localQuickSetupVerifyPwdViewModel = this.I3;
    if ((localQuickSetupVerifyPwdViewModel != null) && (localQuickSetupVerifyPwdViewModel.i() != null)) {
      this.I3.i().observeForever(new d());
    }
    this.J3.g().observe(this, new a(this));
  }
  
  private void w1()
  {
    s0.l(this);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131364465: 
      W0(GoogleAssistantActivity.class);
      break;
    case 2131364342: 
      W0(WssAlexaActivity.class);
      break;
    case 2131364338: 
      paramView = getResources().getString(2131954523);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("https://www.tapo.com/app/#/guidance/alice?locale=");
      localStringBuilder.append(d.f());
      CommonWebActivity.s1(this, paramView, localStringBuilder.toString());
      break;
    case 2131362350: 
      W0(DiscoveryDeviceListActivity.class);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558646);
    this.I3 = ((QuickSetupVerifyPwdViewModel)ViewModelProviders.of(this).get(QuickSetupVerifyPwdViewModel.class));
    this.J3 = ((QuickDiscoveryViewModel)new ViewModelProvider(this).get(QuickDiscoveryViewModel.class));
    b1(2131953490);
    t1();
    v1();
    this.I3.k();
    b.d.n.f.b.l().f("tapo_pageid_add_your_device");
  }
  
  protected void onDestroy()
  {
    QuickSetupVerifyPwdViewModel localQuickSetupVerifyPwdViewModel = this.I3;
    if ((localQuickSetupVerifyPwdViewModel != null) && (localQuickSetupVerifyPwdViewModel.i() != null)) {
      this.I3.i().removeObservers(this);
    }
    super.onDestroy();
  }
  
  protected void onSaveInstanceState(Bundle paramBundle) {}
  
  protected void onStart()
  {
    super.onStart();
    TextView localTextView = this.p1;
    int i;
    if (x.a()) {
      i = 0;
    } else {
      i = 8;
    }
    localTextView.setVisibility(i);
  }
  
  class a
    implements SelectCategoryNewAdapter.e
  {
    a() {}
    
    public void a(DeviceCategoryBean paramDeviceCategoryBean)
    {
      if (!paramDeviceCategoryBean.isCategory()) {
        com.tplink.iot.view.quicksetup.base.b.g(SelectCategoryNewActivity.this, paramDeviceCategoryBean.getDevice());
      }
    }
  }
  
  class b
    implements RadioGroup.OnCheckedChangeListener
  {
    b() {}
    
    public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
    {
      if (SelectCategoryNewActivity.e1(SelectCategoryNewActivity.this)) {
        return;
      }
      paramInt = SelectCategoryNewActivity.g1(SelectCategoryNewActivity.this, paramInt);
      z.a(SelectCategoryNewActivity.h1(SelectCategoryNewActivity.this), paramInt);
    }
  }
  
  class c
    extends RecyclerView.OnScrollListener
  {
    c(GridLayoutManager paramGridLayoutManager) {}
    
    private void a()
    {
      int i = localObject.findFirstVisibleItemPosition();
      if (i != -1)
      {
        Object localObject = SelectCategoryNewActivity.h1(SelectCategoryNewActivity.this).findViewHolderForLayoutPosition(i);
        if ((localObject != null) && (((RecyclerView.ViewHolder)localObject).getItemViewType() == 0))
        {
          localObject = SelectCategoryNewActivity.this;
          SelectCategoryNewActivity.j1((SelectCategoryNewActivity)localObject, i, SelectCategoryNewActivity.i1((SelectCategoryNewActivity)localObject));
        }
      }
    }
    
    public void onScrollStateChanged(@NonNull RecyclerView paramRecyclerView, int paramInt)
    {
      if (paramInt == 1) {
        SelectCategoryNewActivity.f1(SelectCategoryNewActivity.this, true);
      } else if (paramInt == 0) {
        SelectCategoryNewActivity.f1(SelectCategoryNewActivity.this, false);
      }
    }
    
    public void onScrolled(@NonNull RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      if (SelectCategoryNewActivity.e1(SelectCategoryNewActivity.this)) {
        a();
      }
    }
  }
  
  class d
    implements Observer<Boolean>
  {
    d() {}
    
    public void a(Boolean paramBoolean)
    {
      if (paramBoolean == null) {
        SelectCategoryNewActivity.k1(SelectCategoryNewActivity.this);
      } else {
        SelectCategoryNewActivity.l1(SelectCategoryNewActivity.this);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\common\SelectCategoryNewActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */