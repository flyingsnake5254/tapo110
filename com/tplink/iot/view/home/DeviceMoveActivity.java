package com.tplink.iot.view.home;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.adapter.home.DeviceMoveAdapter;
import com.tplink.iot.adapter.home.DeviceMoveAdapter.b;
import com.tplink.iot.adapter.home.DeviceMoveSelectMenuAdapter;
import com.tplink.iot.adapter.home.DeviceMoveSelectMenuAdapter.b;
import com.tplink.iot.adapter.home.HomeFamilySelectBean;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.model.home.b;
import com.tplink.iot.model.home.c;
import com.tplink.iot.viewmodel.home.DeviceMoveViewModel;
import com.tplink.libtpcontrols.DropDownView;
import com.tplink.libtpcontrols.DropDownView.d;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class DeviceMoveActivity
  extends BaseActivity
  implements DeviceMoveAdapter.b, View.OnClickListener
{
  private TextView H3;
  private ImageView I3;
  private DropDownView J3 = null;
  private TextView K3;
  private b p0;
  private List<String> p1 = new ArrayList();
  private List<String> p2 = new ArrayList();
  private List<HomeFamilySelectBean> p3 = new ArrayList();
  private DeviceMoveAdapter y;
  private DeviceMoveViewModel z;
  
  private void j1(HomeFamilySelectBean paramHomeFamilySelectBean)
  {
    this.p0 = this.z.h(paramHomeFamilySelectBean.getFamilyId());
    q1();
    r1(this.p0.c());
  }
  
  private List<HomeFamilySelectBean> k1()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.z.f().iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      HomeFamilySelectBean localHomeFamilySelectBean = new HomeFamilySelectBean();
      localHomeFamilySelectBean.setFamilyId(localb.b());
      if ((localb.a()) && (TextUtils.isEmpty(localb.c()))) {
        localHomeFamilySelectBean.setFamilyName(getString(2131952817));
      } else {
        localHomeFamilySelectBean.setFamilyName(localb.c());
      }
      localHomeFamilySelectBean.setSelected(o1(localb));
      if (localHomeFamilySelectBean.isSelected()) {
        localArrayList.add(0, localHomeFamilySelectBean);
      } else {
        localArrayList.add(localHomeFamilySelectBean);
      }
    }
    return localArrayList;
  }
  
  private void l1()
  {
    Object localObject1 = getIntent();
    if (localObject1 != null)
    {
      Object localObject2 = ((Intent)localObject1).getStringExtra("family_id");
      this.p0 = this.z.h((String)localObject2);
      localObject1 = ((Intent)localObject1).getExtras();
      if (localObject1 != null)
      {
        localObject2 = (List)((Bundle)localObject1).getSerializable("device_id_list");
        if ((localObject2 != null) && (!((List)localObject2).isEmpty())) {
          this.p1.addAll((Collection)localObject2);
        }
        localObject1 = (List)((Bundle)localObject1).getSerializable("group_id_list");
        if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
          this.p2.addAll((Collection)localObject1);
        }
      }
    }
  }
  
  private void m1()
  {
    Object localObject = LayoutInflater.from(this).inflate(2131558997, null, false);
    ((View)localObject).findViewById(2131363179).setVisibility(8);
    this.J3.setExpandedView((View)localObject);
    this.J3.setDropDownListener(new a());
    this.p3 = k1();
    RecyclerView localRecyclerView = (RecyclerView)findViewById(2131363810);
    localObject = new DeviceMoveSelectMenuAdapter(this, this.p3);
    localRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    localRecyclerView.setAdapter((RecyclerView.Adapter)localObject);
    ((DeviceMoveSelectMenuAdapter)localObject).o(new b());
  }
  
  private void n1()
  {
    this.H3 = ((TextView)findViewById(2131364290));
    this.J3 = ((DropDownView)findViewById(2131362496));
    this.I3 = ((ImageView)findViewById(2131362279));
    this.K3 = ((TextView)findViewById(2131364551));
    RecyclerView localRecyclerView = (RecyclerView)findViewById(2131363820);
    localRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    DeviceMoveAdapter localDeviceMoveAdapter = new DeviceMoveAdapter(this);
    this.y = localDeviceMoveAdapter;
    localDeviceMoveAdapter.o(this);
    localRecyclerView.setAdapter(this.y);
    q1();
    s1(this.z.m());
    r1(this.p0.c());
    this.H3.setOnClickListener(this);
  }
  
  private boolean o1(b paramb)
  {
    b localb = this.p0;
    if ((localb != null) && (localb.b() != null)) {
      return this.p0.b().equals(paramb.b());
    }
    return false;
  }
  
  public static void p1(Context paramContext, String paramString, List<String> paramList1, List<String> paramList2)
  {
    Intent localIntent = new Intent(paramContext, DeviceMoveActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("device_id_list", (Serializable)paramList1);
    localBundle.putSerializable("group_id_list", (Serializable)paramList2);
    localIntent.putExtras(localBundle);
    localIntent.putExtra("family_id", paramString);
    paramContext.startActivity(localIntent);
  }
  
  private void q1()
  {
    List localList = this.p0.d();
    this.y.n(localList);
    if ((localList != null) && (!localList.isEmpty())) {
      this.K3.setVisibility(8);
    } else {
      this.K3.setVisibility(0);
    }
  }
  
  private void r1(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      c1(getString(2131952817));
    } else {
      c1(paramString);
    }
  }
  
  private void s1(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.I3.setVisibility(0);
      this.H3.setEnabled(true);
    }
    else
    {
      this.I3.setVisibility(8);
      this.H3.setEnabled(false);
    }
  }
  
  private void t1()
  {
    s0.p(this, getString(2131952444));
  }
  
  private void u1()
  {
    this.z.k().observe(this, new c());
  }
  
  public void Z(c paramc)
  {
    s0.l(this);
    this.z.w(this.p0.b(), paramc.b(), this.p1, this.p2);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131364290) {
      if (this.J3.l()) {
        this.J3.g();
      } else {
        this.J3.i();
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558498);
    this.z = ((DeviceMoveViewModel)ViewModelProviders.of(this).get(DeviceMoveViewModel.class));
    l1();
    n1();
    m1();
    u1();
  }
  
  class a
    implements DropDownView.d
  {
    a() {}
    
    public void a()
    {
      DeviceMoveActivity.e1(DeviceMoveActivity.this).setVisibility(0);
      ObjectAnimator.ofFloat(DeviceMoveActivity.f1(DeviceMoveActivity.this), View.ROTATION.getName(), new float[] { 180.0F }).start();
    }
    
    public void b()
    {
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(DeviceMoveActivity.f1(DeviceMoveActivity.this), View.ROTATION.getName(), new float[] { -180.0F, 0.0F });
      localObjectAnimator.addListener(new a());
      localObjectAnimator.start();
    }
    
    class a
      extends AnimatorListenerAdapter
    {
      a() {}
      
      public void onAnimationEnd(Animator paramAnimator)
      {
        DeviceMoveActivity.e1(DeviceMoveActivity.this).setVisibility(4);
      }
    }
  }
  
  class b
    implements DeviceMoveSelectMenuAdapter.b
  {
    b() {}
    
    public void a(View paramView, int paramInt)
    {
      if (DeviceMoveActivity.e1(DeviceMoveActivity.this).l()) {
        DeviceMoveActivity.e1(DeviceMoveActivity.this).g();
      }
      paramView = DeviceMoveActivity.this;
      DeviceMoveActivity.h1(paramView, (HomeFamilySelectBean)DeviceMoveActivity.g1(paramView).get(paramInt));
    }
  }
  
  class c
    implements Observer<Boolean>
  {
    c() {}
    
    public void a(@Nullable Boolean paramBoolean)
    {
      
      if ((paramBoolean != null) && (paramBoolean.booleanValue())) {
        DeviceMoveActivity.this.finish();
      } else {
        DeviceMoveActivity.i1(DeviceMoveActivity.this);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\home\DeviceMoveActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */