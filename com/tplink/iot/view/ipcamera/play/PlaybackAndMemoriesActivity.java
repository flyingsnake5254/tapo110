package com.tplink.iot.view.ipcamera.play;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.ObservableBoolean;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import b.d.w.c.a;
import com.google.android.material.tabs.TabLayout;
import com.tplink.iot.Utils.ScreenOrientationListenHelper;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.view.ipcamera.memories.MemoriesFragment;
import com.tplink.iot.view.ipcamera.memories.MemoriesFragment.c;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.play.PlaybackMainViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.VideoDisplayMode;
import com.tplink.libmediaapi.vod.VodMediaAPI;
import com.tplink.libtpnetwork.cameranetwork.util.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

public class PlaybackAndMemoriesActivity
  extends AppCompatActivity
  implements ViewPager.OnPageChangeListener, View.OnClickListener, MemoriesFragment.c
{
  private static final String c = PlaybackAndMemoriesActivity.class.getSimpleName();
  private ArrayList<String> H3 = new ArrayList();
  private ScreenOrientationListenHelper I3;
  private PlaybackMainViewModel J3;
  private String d = "playback";
  String f;
  private TextView p0;
  private EasyViewPager p1;
  private TimeZone p2;
  private HashMap<String, BaseFragment> p3 = new HashMap();
  private View q;
  private ImageView x;
  private View y;
  private ImageView z;
  
  private void R0()
  {
    BaseFragment localBaseFragment = (BaseFragment)this.p3.get("memory");
    if ((localBaseFragment instanceof MemoriesFragment)) {
      ((MemoriesFragment)localBaseFragment).N0();
    }
  }
  
  private void U0()
  {
    if (!(this.p3.get("playback") instanceof PlayBackMainFragment)) {
      this.p3.put("playback", new PlayBackMainFragment());
    }
    if (!(this.p3.get("memory") instanceof MemoriesFragment))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("device_id_md5", this.f);
      MemoriesFragment localMemoriesFragment = new MemoriesFragment();
      localMemoriesFragment.setArguments(localBundle);
      localMemoriesFragment.c1(this);
      this.p3.put("memory", localMemoriesFragment);
    }
  }
  
  private void V0()
  {
    ScreenOrientationListenHelper localScreenOrientationListenHelper = new ScreenOrientationListenHelper(this);
    this.I3 = localScreenOrientationListenHelper;
    localScreenOrientationListenHelper.f(new p1(this));
  }
  
  private void W0(Bundle paramBundle)
  {
    this.q = findViewById(2131363669);
    this.x = ((ImageView)findViewById(2131363665));
    this.y = findViewById(2131363668);
    this.z = ((ImageView)findViewById(2131363667));
    Object localObject = (TextView)findViewById(2131363445);
    this.p0 = ((TextView)localObject);
    ((TextView)localObject).setVisibility(8);
    this.y.setVisibility(8);
    this.z.setVisibility(8);
    this.x.setOnClickListener(this);
    this.y.setOnClickListener(this);
    this.z.setOnClickListener(this);
    this.H3.add(getString(2131953366));
    this.H3.add(getString(2131953083));
    localObject = (EasyViewPager)findViewById(2131363666);
    this.p1 = ((EasyViewPager)localObject);
    ((ViewPager)localObject).setAdapter(new c(getSupportFragmentManager()));
    this.p1.addOnPageChangeListener(this);
    ((TabLayout)findViewById(2131363670)).setupWithViewPager(this.p1);
    if (paramBundle != null) {
      i1();
    }
    U0();
  }
  
  private boolean X0()
  {
    BaseFragment localBaseFragment = (BaseFragment)this.p3.get("memory");
    if ((localBaseFragment instanceof MemoriesFragment)) {
      return ((MemoriesFragment)localBaseFragment).T0();
    }
    return false;
  }
  
  public static void d1(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, PlaybackAndMemoriesActivity.class);
    localIntent.putExtra("device_id_md5", paramString);
    paramContext.startActivity(localIntent);
  }
  
  public static void e1(Context paramContext, String paramString, long paramLong)
  {
    Intent localIntent = new Intent(paramContext, PlaybackAndMemoriesActivity.class);
    localIntent.putExtra("device_id_md5", paramString);
    localIntent.putExtra("record_time", paramLong);
    paramContext.startActivity(localIntent);
  }
  
  private void f1(b paramb)
  {
    BaseFragment localBaseFragment = (BaseFragment)this.p3.get("memory");
    if ((localBaseFragment instanceof MemoriesFragment)) {
      paramb.a((MemoriesFragment)localBaseFragment);
    }
  }
  
  private void g1()
  {
    this.p2 = TimeZone.getDefault();
    TimeZone.setDefault(TimeZone.getTimeZone(i.c(i.d())));
  }
  
  private void h1(d paramd)
  {
    BaseFragment localBaseFragment = (BaseFragment)this.p3.get("playback");
    if ((localBaseFragment instanceof PlayBackMainFragment)) {
      paramd.a((PlayBackMainFragment)localBaseFragment);
    }
  }
  
  private void i1()
  {
    Iterator localIterator = getSupportFragmentManager().getFragments().iterator();
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if ((localFragment instanceof PlayBackMainFragment)) {
        this.p3.put("playback", (BaseFragment)localFragment);
      } else if ((localFragment instanceof MemoriesFragment)) {
        this.p3.put("memory", (BaseFragment)localFragment);
      }
    }
  }
  
  private void j1()
  {
    TimeZone localTimeZone = this.p2;
    if (localTimeZone != null) {
      TimeZone.setDefault(localTimeZone);
    }
  }
  
  private void k1()
  {
    ScreenOrientationListenHelper localScreenOrientationListenHelper = this.I3;
    if (localScreenOrientationListenHelper != null) {
      localScreenOrientationListenHelper.g();
    }
  }
  
  private void l1()
  {
    ScreenOrientationListenHelper localScreenOrientationListenHelper = this.I3;
    if (localScreenOrientationListenHelper != null) {
      localScreenOrientationListenHelper.h();
    }
  }
  
  private void m1()
  {
    this.J3.j().observe(this, new r1(this));
  }
  
  private void n1()
  {
    if (this.J3.r.get())
    {
      this.q.setVisibility(8);
      this.p1.setScroll(false);
      this.d = "playback";
    }
    else
    {
      this.q.setVisibility(0);
      this.p1.setScroll(true);
    }
    BaseFragment localBaseFragment = (BaseFragment)this.p3.get("playback");
    if ((localBaseFragment instanceof PlayBackMainFragment)) {
      ((PlayBackMainFragment)localBaseFragment).b1();
    }
  }
  
  private void o1(d paramd)
  {
    if ("playback".equals(this.d)) {
      h1(paramd);
    }
  }
  
  public void S0()
  {
    setRequestedOrientation(1);
  }
  
  public void T()
  {
    this.x.setImageResource(2131689501);
    this.z.setImageResource(2131690202);
    this.p0.setVisibility(8);
  }
  
  public void T0()
  {
    setRequestedOrientation(0);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      q1 localq1 = new com/tplink/iot/view/ipcamera/play/q1;
      localq1.<init>(paramMotionEvent);
      o1(localq1);
      return bool;
    }
    catch (IllegalArgumentException paramMotionEvent)
    {
      a.e(c, Log.getStackTraceString(paramMotionEvent));
    }
    return false;
  }
  
  public void k(int paramInt)
  {
    Object localObject2;
    if (paramInt <= 1)
    {
      localObject1 = this.p0;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(paramInt);
      ((TextView)localObject1).setText(getString(2131953076, new Object[] { ((StringBuilder)localObject2).toString() }));
    }
    else
    {
      localObject2 = this.p0;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(paramInt);
      ((TextView)localObject2).setText(getString(2131953077, new Object[] { ((StringBuilder)localObject1).toString() }));
    }
    this.x.setImageResource(2131689570);
    this.p0.setVisibility(0);
    Object localObject1 = this.z;
    if (X0()) {
      paramInt = 2131690203;
    } else {
      paramInt = 2131690204;
    }
    ((ImageView)localObject1).setImageResource(paramInt);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 100) && (paramIntent != null)) {
      this.J3.z.setValue(Integer.valueOf(paramIntent.getIntExtra("arg_result", 0)));
    }
  }
  
  public void onBackPressed()
  {
    if ("playback".equals(this.d))
    {
      if (this.J3.r.get())
      {
        this.J3.D(false);
        this.J3.u.set(false);
        this.J3.s.set(false);
        this.J3.t.set(false);
      }
    }
    else if ("memory".equals(this.d))
    {
      Object localObject = (Fragment)this.p3.get("memory");
      if ((localObject instanceof MemoriesFragment))
      {
        localObject = (MemoriesFragment)localObject;
        if (((MemoriesFragment)localObject).S0())
        {
          ((MemoriesFragment)localObject).K0();
          return;
        }
      }
    }
    VodMediaAPI.stopRecord(this.J3.e);
    VodMediaAPI.stopDisplay(this.J3.e);
    super.onBackPressed();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131363666: 
    default: 
      break;
    case 2131363668: 
      if (this.d.equals("playback"))
      {
        int i = 0;
        if (this.J3.z.getValue() != null) {
          i = ((Integer)this.J3.z.getValue()).intValue();
        }
        SnapshotsFilterActivity.y.a(this, i);
      }
      else
      {
        f1(f4.a);
      }
      break;
    case 2131363667: 
      R0();
      break;
    case 2131363665: 
      onBackPressed();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    int i = paramConfiguration.orientation;
    boolean bool = true;
    if (i == 1) {
      bool = false;
    }
    this.J3.C(bool);
    n1();
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558597);
    g1();
    this.f = getIntent().getStringExtra("device_id_md5");
    W0(paramBundle);
    paramBundle = (PlaybackMainViewModel)ViewModelProviders.of(this, new CameraViewModelFactory(this, this.f)).get(PlaybackMainViewModel.class);
    this.J3 = paramBundle;
    paramBundle.B(VideoDisplayMode.PLAY_BACK);
    m1();
    V0();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    VodMediaAPI.releaseDownloadImage();
    j1();
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    String str;
    if (paramInt == 0) {
      str = "playback";
    } else {
      str = "memory";
    }
    this.d = str;
    if ("playback".equals(str))
    {
      this.y.setVisibility(8);
      this.z.setVisibility(8);
    }
    else
    {
      this.y.setVisibility(0);
      this.z.setVisibility(0);
    }
    if ("memory".equals(this.d))
    {
      f1(a4.a);
      h1(c4.a);
      VodMediaAPI.disableRelayTimer();
    }
    else if ("playback".equals(this.d))
    {
      f1(b4.a);
      h1(e4.a);
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    l1();
  }
  
  protected void onResume()
  {
    super.onResume();
    o1(e4.a);
    k1();
  }
  
  protected void onStop()
  {
    super.onStop();
    o1(c4.a);
  }
  
  private static abstract interface b
  {
    public abstract void a(MemoriesFragment paramMemoriesFragment);
  }
  
  private class c
    extends FragmentPagerAdapter
  {
    c(FragmentManager paramFragmentManager)
    {
      super();
    }
    
    public int getCount()
    {
      return 2;
    }
    
    public Fragment getItem(int paramInt)
    {
      String str;
      if (paramInt == 0) {
        str = "playback";
      } else {
        str = "memory";
      }
      return (Fragment)PlaybackAndMemoriesActivity.P0(PlaybackAndMemoriesActivity.this).get(str);
    }
    
    @Nullable
    public CharSequence getPageTitle(int paramInt)
    {
      return (CharSequence)PlaybackAndMemoriesActivity.Q0(PlaybackAndMemoriesActivity.this).get(paramInt);
    }
  }
  
  private static abstract interface d
  {
    public abstract void a(PlayBackMainFragment paramPlayBackMainFragment);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\play\PlaybackAndMemoriesActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */