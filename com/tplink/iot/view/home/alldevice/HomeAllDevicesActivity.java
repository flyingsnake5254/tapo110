package com.tplink.iot.view.home.alldevice;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.google.android.material.tabs.TabLayout;
import com.tplink.iot.Utils.x;
import com.tplink.iot.adapter.home.RoomPagerAdapter;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.cloud.bean.family.common.FamilyInfo;
import com.tplink.iot.cloud.bean.family.common.RoomInfo;
import com.tplink.iot.model.home.e;
import com.tplink.iot.model.home.g;
import com.tplink.iot.model.home.k;
import com.tplink.iot.view.quicksetup.base.d;
import com.tplink.iot.viewmodel.home.HomeAllDeviceViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HomeAllDevicesActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private TextView H3;
  private TextView I3;
  private ImageView J3;
  private List<String> K3 = new ArrayList();
  private List<RoomDevicesFragment> L3 = new ArrayList();
  private int M3 = 0;
  private boolean N3 = false;
  private boolean O3 = true;
  private List<e> P3;
  private HomeAllDeviceViewModel Q3;
  private View p0;
  private TextView p1;
  private TextView p2;
  private TextView p3;
  private ViewPager y;
  private View z;
  
  private void k1()
  {
    if (this.O3) {
      this.p2.setText(getResources().getString(2131952412));
    } else {
      this.p2.setText(getResources().getString(2131954214));
    }
  }
  
  private void l1()
  {
    ((RoomDevicesFragment)this.L3.get(this.y.getCurrentItem())).V1();
  }
  
  private void m1(List<e> paramList)
  {
    if (paramList.isEmpty())
    {
      this.z.setAlpha(0.8F);
      v1(false);
      return;
    }
    this.z.setAlpha(1.0F);
    v1(true);
    Iterator localIterator = paramList.iterator();
    int i = 0;
    int j = 0;
    while (localIterator.hasNext())
    {
      paramList = (e)localIterator.next();
      if ((paramList instanceof g)) {
        j = 1;
      } else if (((paramList instanceof k)) && (((k)paramList).w())) {
        i = 1;
      }
    }
    if (i != 0) {
      w1(this.H3, false);
    }
    if ((i != 0) || (j != 0)) {
      w1(this.p3, false);
    }
  }
  
  private void n1()
  {
    ((RoomDevicesFragment)this.L3.get(this.y.getCurrentItem())).W1();
  }
  
  private void o1()
  {
    ((RoomDevicesFragment)this.L3.get(this.y.getCurrentItem())).X1();
  }
  
  private void p1()
  {
    Iterator localIterator = this.L3.iterator();
    while (localIterator.hasNext()) {
      ((RoomDevicesFragment)localIterator.next()).Y1();
    }
  }
  
  private void r1()
  {
    ((RoomDevicesFragment)this.L3.get(this.y.getCurrentItem())).h2();
  }
  
  private void s1(FamilyInfo paramFamilyInfo)
  {
    this.J3.setVisibility(8);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    localArrayList1.add(getString(2131951815));
    localArrayList3.add("room_all");
    if (paramFamilyInfo != null) {
      paramFamilyInfo = paramFamilyInfo.getRooms();
    } else {
      paramFamilyInfo = null;
    }
    int i = 0;
    if ((paramFamilyInfo != null) && (!paramFamilyInfo.isEmpty()))
    {
      paramFamilyInfo = paramFamilyInfo.iterator();
      while (paramFamilyInfo.hasNext())
      {
        RoomInfo localRoomInfo = (RoomInfo)paramFamilyInfo.next();
        if (!TextUtils.isEmpty(localRoomInfo.getName()))
        {
          localArrayList1.add(localRoomInfo.getName());
          localArrayList3.add(localRoomInfo.getId());
        }
      }
      this.J3.setVisibility(0);
    }
    localArrayList1.add(getString(2131953921));
    localArrayList3.add("room_share");
    while (i < localArrayList3.size())
    {
      if (i == 0) {
        localArrayList2.add(RoomDevicesFragment.c2());
      } else if (i == localArrayList3.size() - 1) {
        localArrayList2.add(RoomDevicesFragment.f2());
      } else {
        localArrayList2.add(RoomDevicesFragment.e2((String)localArrayList3.get(i)));
      }
      i++;
    }
    this.L3.clear();
    this.K3.clear();
    this.L3.addAll(localArrayList2);
    this.K3.addAll(localArrayList1);
    paramFamilyInfo = new RoomPagerAdapter(getSupportFragmentManager(), this.L3, this.K3);
    this.y.setAdapter(paramFamilyInfo);
    this.y.addOnPageChangeListener(new b());
    i = this.M3;
    if ((i > 0) && (i < this.L3.size())) {
      this.y.setCurrentItem(this.M3);
    }
  }
  
  private void t1()
  {
    setTitle(2131953195);
    TabLayout localTabLayout = (TabLayout)findViewById(2131364136);
    this.y = ((ViewPager)findViewById(2131362330));
    this.p0 = findViewById(2131363910);
    this.p1 = ((TextView)findViewById(2131364696));
    this.z = findViewById(2131364786);
    this.p2 = ((TextView)findViewById(2131364333));
    this.p3 = ((TextView)findViewById(2131364414));
    this.H3 = ((TextView)findViewById(2131364593));
    this.I3 = ((TextView)findViewById(2131363025));
    ImageView localImageView = (ImageView)findViewById(2131363916);
    this.J3 = localImageView;
    localImageView.setVisibility(8);
    localTabLayout.setupWithViewPager(this.y, false);
    findViewById(2131364695).setVisibility(8);
    this.J3.setOnClickListener(this);
    findViewById(2131363150).setOnClickListener(this);
    this.I3.setOnClickListener(this);
    this.p2.setOnClickListener(this);
    this.H3.setOnClickListener(this);
    this.p3.setOnClickListener(this);
  }
  
  private void v1(boolean paramBoolean)
  {
    w1(this.I3, paramBoolean);
    w1(this.p2, paramBoolean);
    w1(this.H3, paramBoolean);
    w1(this.p3, paramBoolean);
  }
  
  private void w1(TextView paramTextView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramTextView.setAlpha(1.0F);
      paramTextView.setClickable(true);
    }
    else
    {
      paramTextView.setAlpha(0.6F);
      paramTextView.setClickable(false);
    }
  }
  
  private void x1()
  {
    if (this.Q3.g().getValue() == null) {
      s1(null);
    }
    this.Q3.g().observe(this, new a());
  }
  
  private void y1()
  {
    ((RoomDevicesFragment)this.L3.get(this.y.getCurrentItem())).i2();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramInt1 == 1))
    {
      int i = paramIntent.getIntExtra("select_index", 0);
      if ((i >= 0) && (i < this.L3.size()) && (i != this.M3))
      {
        this.M3 = i;
        this.y.setCurrentItem(i);
      }
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    if (this.N3) {
      q1();
    } else {
      super.onBackPressed();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131364593: 
      n1();
      break;
    case 2131364414: 
      r1();
      break;
    case 2131364333: 
      if (this.O3) {
        l1();
      } else {
        o1();
      }
      break;
    case 2131363916: 
      q1();
      startActivityForResult(new Intent(this, RoomNavigationActivity.class), 1);
      break;
    case 2131363150: 
      q1();
      break;
    case 2131363025: 
      y1();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558442);
    d.J(this, findViewById(2131364275));
    d.e(this, findViewById(2131364817));
    this.Q3 = ((HomeAllDeviceViewModel)ViewModelProviders.of(this).get(HomeAllDeviceViewModel.class));
    t1();
    x1();
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if ((paramMenuItem.getItemId() == 16908332) && (this.N3)) {
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  public void q1()
  {
    View localView = this.p0;
    if ((localView != null) && (this.z != null) && (this.N3))
    {
      x.c(localView);
      p1();
      x.d(this.z);
      this.N3 = false;
    }
  }
  
  public void u1(final int paramInt, boolean paramBoolean, List<e> paramList)
  {
    this.O3 = paramBoolean;
    this.P3 = paramList;
    this.c.post(new c(paramInt));
  }
  
  public void z1()
  {
    this.N3 = true;
    x.b(this.p0);
    this.p1.setText(2131952842);
    x.a(this.z);
    this.z.setAlpha(0.8F);
  }
  
  class a
    implements Observer<FamilyInfo>
  {
    a() {}
    
    public void a(@Nullable FamilyInfo paramFamilyInfo)
    {
      HomeAllDevicesActivity.e1(HomeAllDevicesActivity.this, paramFamilyInfo);
    }
  }
  
  class b
    implements ViewPager.OnPageChangeListener
  {
    b() {}
    
    public void onPageScrollStateChanged(int paramInt) {}
    
    public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
    
    public void onPageSelected(int paramInt)
    {
      HomeAllDevicesActivity.f1(HomeAllDevicesActivity.this, paramInt);
      HomeAllDevicesActivity.this.q1();
    }
  }
  
  class c
    implements Runnable
  {
    c(int paramInt) {}
    
    public void run()
    {
      HomeAllDevicesActivity.g1(HomeAllDevicesActivity.this);
      HomeAllDevicesActivity.h1(HomeAllDevicesActivity.this).setText(HomeAllDevicesActivity.this.getResources().getString(2131952843, new Object[] { Integer.valueOf(paramInt) }));
      HomeAllDevicesActivity localHomeAllDevicesActivity = HomeAllDevicesActivity.this;
      HomeAllDevicesActivity.j1(localHomeAllDevicesActivity, HomeAllDevicesActivity.i1(localHomeAllDevicesActivity));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\home\alldevice\HomeAllDevicesActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */