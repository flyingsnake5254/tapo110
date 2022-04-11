package com.tplink.iot.view.main;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import b.d.n.i.g;
import b.d.w.h.a;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener;
import com.tplink.iot.Utils.p;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.i.a.a;
import com.tplink.iot.model.about.c;
import com.tplink.iot.view.home.HomeFragment;
import com.tplink.iot.view.me.MeFragment;
import com.tplink.iot.view.smart.SmartFragment;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MainActivity
  extends BaseActivity
{
  private String H3;
  private String I3;
  private String J3;
  private String K3;
  private BottomNavigationView p0;
  private String p1;
  private String p2;
  private String p3;
  private String y;
  private Map<String, BaseFragment> z = new HashMap();
  
  private void f1()
  {
    if (!com.tplink.libtpnetwork.Utils.o.h0().i0())
    {
      com.tplink.libtpnetwork.Utils.o.h0().D0();
      com.tplink.iot.Utils.x0.o.k(com.tplink.iot.view.welcome.b.a(this), com.tplink.iot.view.welcome.b.b(this));
    }
  }
  
  private void m1()
  {
    if (!TextUtils.isEmpty(this.I3))
    {
      b.d.n.f.b.l().i(this.I3);
      this.I3 = null;
    }
  }
  
  private void n1()
  {
    t1("main_home");
  }
  
  private void o1(Bundle paramBundle)
  {
    BottomNavigationView localBottomNavigationView = (BottomNavigationView)findViewById(2131362167);
    this.p0 = localBottomNavigationView;
    localBottomNavigationView.setItemIconTintList(null);
    this.p0.setItemTextAppearanceActive(2132018007);
    this.p0.setItemTextAppearanceInactive(2132018006);
    this.p0.inflateMenu(2131623943);
    this.p0.setOnNavigationItemSelectedListener(new a());
    if (paramBundle == null) {
      n1();
    } else {
      q1(paramBundle.getString("current_tag", "main_home"));
    }
  }
  
  @NonNull
  private BaseFragment p1(String paramString)
  {
    if (paramString == null) {
      return new HomeFragment();
    }
    int i = -1;
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 831022558: 
      if (paramString.equals("main_me")) {
        i = 2;
      }
      break;
    case 807407555: 
      if (paramString.equals("main_smart")) {
        i = 1;
      }
      break;
    case -251374683: 
      if (paramString.equals("main_home")) {
        i = 0;
      }
      break;
    }
    switch (i)
    {
    default: 
      return new HomeFragment();
    case 2: 
      return new MeFragment();
    case 1: 
      return new SmartFragment();
    }
    return new HomeFragment();
  }
  
  private void q1(String paramString)
  {
    Object localObject = paramString;
    if (TextUtils.isEmpty(paramString)) {
      localObject = "main_home";
    }
    paramString = getSupportFragmentManager();
    FragmentTransaction localFragmentTransaction = paramString.beginTransaction();
    paramString = paramString.getFragments().iterator();
    while (paramString.hasNext())
    {
      Fragment localFragment = (Fragment)paramString.next();
      if ((localFragment instanceof HomeFragment)) {
        this.z.put("main_home", (BaseFragment)localFragment);
      } else if ((localFragment instanceof SmartFragment)) {
        this.z.put("main_smart", (BaseFragment)localFragment);
      } else if ((localFragment instanceof MeFragment)) {
        this.z.put("main_me", (BaseFragment)localFragment);
      }
      localFragmentTransaction.hide(localFragment);
    }
    this.y = ((String)localObject);
    localObject = (BaseFragment)this.z.get(localObject);
    paramString = (String)localObject;
    if (localObject == null)
    {
      paramString = p1(this.y);
      this.z.put(this.y, paramString);
    }
    if (paramString.isAdded()) {
      localFragmentTransaction.show(paramString);
    } else {
      localFragmentTransaction.add(2131362322, paramString, this.y);
    }
    localFragmentTransaction.commitAllowingStateLoss();
  }
  
  private void t1(String paramString)
  {
    Object localObject1 = this.y;
    if ((localObject1 != null) && (((String)localObject1).equals(paramString))) {
      return;
    }
    Object localObject2 = (BaseFragment)this.z.get(paramString);
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = p1(paramString);
      this.z.put(paramString, localObject1);
    }
    localObject2 = getSupportFragmentManager().beginTransaction();
    Object localObject3 = this.y;
    if (localObject3 != null)
    {
      localObject3 = (BaseFragment)this.z.get(localObject3);
      if (localObject3 != null) {
        ((FragmentTransaction)localObject2).hide((Fragment)localObject3);
      }
    }
    if (((Fragment)localObject1).isAdded()) {
      ((FragmentTransaction)localObject2).show((Fragment)localObject1);
    } else {
      ((FragmentTransaction)localObject2).add(2131362322, (Fragment)localObject1, paramString);
    }
    ((FragmentTransaction)localObject2).commitAllowingStateLoss();
    this.y = paramString;
  }
  
  public String g1()
  {
    String str = this.J3;
    this.J3 = null;
    return str;
  }
  
  public String h1()
  {
    String str = this.p1;
    this.p1 = null;
    return str;
  }
  
  public String i1()
  {
    String str = this.K3;
    this.K3 = null;
    return str;
  }
  
  public String j1()
  {
    return this.p2;
  }
  
  public String k1()
  {
    return this.H3;
  }
  
  public String l1()
  {
    return this.p3;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1345)
    {
      MeFragment localMeFragment = (MeFragment)getSupportFragmentManager().findFragmentByTag("main_me");
      if (localMeFragment != null) {
        localMeFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
      }
    }
  }
  
  public void onBackPressed()
  {
    if (!a.a.b(this)) {
      moveTaskToBack(true);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558577);
    if (paramBundle == null)
    {
      String str = getIntent().getStringExtra("fcm_device_id");
      this.p2 = getIntent().getStringExtra("fcm_event_time");
      this.p3 = getIntent().getStringExtra("notification_msg_type");
      this.H3 = getIntent().getStringExtra("fcm_uuid");
      this.I3 = getIntent().getStringExtra("task_id");
      if (str != null) {
        this.p1 = a.g(str);
      }
      this.J3 = getIntent().getStringExtra("deviceId");
      this.K3 = getIntent().getStringExtra("summaryDate");
    }
    o1(paramBundle);
    m1();
    f1();
    c.a();
    c.b();
    p.f();
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    Object localObject = paramIntent.getStringExtra("fcm_device_id");
    this.p2 = paramIntent.getStringExtra("fcm_event_time");
    this.p3 = paramIntent.getStringExtra("notification_msg_type");
    this.H3 = paramIntent.getStringExtra("fcm_uuid");
    this.J3 = paramIntent.getStringExtra("deviceId");
    this.K3 = paramIntent.getStringExtra("summaryDate");
    boolean bool = paramIntent.getBooleanExtra("app_downgrade_required", false);
    int i = 2131364135;
    if (bool)
    {
      paramIntent = (BaseFragment)this.z.get("main_home");
      if ((paramIntent instanceof HomeFragment))
      {
        t1("main_home");
        localObject = this.p0;
        if (localObject != null) {
          ((BottomNavigationView)localObject).setSelectedItemId(2131364135);
        }
        ((HomeFragment)paramIntent).f3();
      }
    }
    else if (localObject != null)
    {
      this.p1 = a.g((String)localObject);
      localObject = (BaseFragment)this.z.get("main_home");
      if ((localObject instanceof HomeFragment))
      {
        t1("main_home");
        paramIntent = this.p0;
        if (paramIntent != null) {
          paramIntent.setSelectedItemId(2131364135);
        }
        ((HomeFragment)localObject).p5(this);
      }
    }
    else
    {
      paramIntent = paramIntent.getStringExtra("tag_main_selected_item");
      if (!TextUtils.isEmpty(paramIntent))
      {
        if (!"main_home".equals(paramIntent)) {
          if ("main_smart".equals(paramIntent)) {
            i = 2131364140;
          } else if ("main_me".equals(paramIntent)) {
            i = 2131364137;
          } else {
            i = -1;
          }
        }
        if (i != -1) {
          this.p0.setSelectedItemId(i);
        }
      }
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putString("current_tag", this.y);
  }
  
  public void r1(boolean paramBoolean)
  {
    Object localObject = this.p0;
    if (localObject != null)
    {
      MenuItem localMenuItem = ((BottomNavigationView)localObject).getMenu().findItem(2131364137);
      localObject = getResources();
      int i;
      if (paramBoolean) {
        i = 2131231316;
      } else {
        i = 2131231317;
      }
      localMenuItem.setIcon(((Resources)localObject).getDrawable(i));
    }
  }
  
  public void s1(boolean paramBoolean)
  {
    BottomNavigationView localBottomNavigationView = this.p0;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localBottomNavigationView.setVisibility(i);
  }
  
  class a
    implements BottomNavigationView.OnNavigationItemSelectedListener
  {
    a() {}
    
    public boolean onNavigationItemSelected(@NonNull MenuItem paramMenuItem)
    {
      int i = paramMenuItem.getItemId();
      if (i != 2131364135)
      {
        if (i != 2131364137)
        {
          if (i == 2131364140) {
            MainActivity.e1(MainActivity.this, "main_smart");
          }
        }
        else {
          MainActivity.e1(MainActivity.this, "main_me");
        }
      }
      else {
        MainActivity.e1(MainActivity.this, "main_home");
      }
      return true;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\main\MainActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */