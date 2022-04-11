package com.tplink.iot.view.ipcamera.setting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import b.d.q.b.l;
import b.d.q.b.o;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityLineCrossingRegionSettingBinding;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.setting.LineCrossingViewModel;
import com.tplink.iot.widget.FlexibleLine;
import com.tplink.iot.widget.FlexibleLine.a;
import com.tplink.libtpnetwork.cameranetwork.model.LineCrossingDetectionRegion;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LineCrossingRegionSettingActivity
  extends BaseActivity
  implements FlexibleLine.a
{
  private ActivityLineCrossingRegionSettingBinding H3;
  private List<FlexibleLine> p0 = new ArrayList();
  private int p1;
  private int p2;
  private int p3 = 3;
  private FlexibleLine y;
  private LineCrossingViewModel z;
  
  public static void I1(Context paramContext, String paramString, int paramInt)
  {
    Intent localIntent = new Intent(paramContext, LineCrossingRegionSettingActivity.class);
    localIntent.putExtra("device_id_md5", paramString);
    localIntent.putExtra("detection_home_mode", paramInt);
    paramContext.startActivity(localIntent);
  }
  
  private void J1()
  {
    l.e(this.z.f(), new m2(this));
  }
  
  private void K1()
  {
    this.z.X(i1());
  }
  
  private void L1()
  {
    Iterator localIterator = this.p0.iterator();
    while (localIterator.hasNext())
    {
      FlexibleLine localFlexibleLine = (FlexibleLine)localIterator.next();
      if (localFlexibleLine != null) {
        this.H3.S3.removeView(localFlexibleLine);
      }
    }
    this.y = null;
  }
  
  public static void M1(Activity paramActivity, boolean paramBoolean)
  {
    paramActivity = (ViewGroup)paramActivity.findViewById(16908290);
    int i = paramActivity.getChildCount();
    for (int j = 0; j < i; j++)
    {
      View localView = paramActivity.getChildAt(j);
      if ((localView instanceof ViewGroup))
      {
        localView.setFitsSystemWindows(paramBoolean);
        ((ViewGroup)localView).setClipToPadding(paramBoolean);
      }
    }
  }
  
  private void N1()
  {
    Toolbar localToolbar = this.H3.V3;
    if (localToolbar != null)
    {
      setSupportActionBar(localToolbar);
      localToolbar.setNavigationOnClickListener(new k2(this));
    }
  }
  
  private void O1()
  {
    FlexibleLine localFlexibleLine = this.y;
    if (localFlexibleLine != null)
    {
      int i = localFlexibleLine.getArrowDirection();
      if (i != 0)
      {
        if (i != 1)
        {
          if (i == 2) {
            this.y.setArrowDirection(0);
          }
        }
        else {
          this.y.setArrowDirection(2);
        }
      }
      else {
        this.y.setArrowDirection(1);
      }
    }
    else
    {
      TSnackbar.y(this, getString(2131953812), 3000).N();
    }
  }
  
  private void P1()
  {
    if (!q1())
    {
      getWindow().getDecorView().setSystemUiVisibility(0);
      Object localObject = getWindow().getAttributes();
      ((WindowManager.LayoutParams)localObject).flags &= 0xFBFF;
      getWindow().setAttributes((WindowManager.LayoutParams)localObject);
      getWindow().clearFlags(512);
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.H3.S3.getLayoutParams();
      localObject = new DisplayMetrics();
      getWindowManager().getDefaultDisplay().getRealMetrics((DisplayMetrics)localObject);
      localMarginLayoutParams.width = ((DisplayMetrics)localObject).widthPixels;
      int i = o.a(this, 216.0F);
      int j = o.a(this, 30.0F);
      j = (int)((((DisplayMetrics)localObject).widthPixels - j) / 1.7777778F) + j;
      if (i < j) {
        i = j;
      }
      localMarginLayoutParams.height = i;
    }
  }
  
  private void Q1(FlexibleLine paramFlexibleLine)
  {
    FlexibleLine localFlexibleLine = this.y;
    if (localFlexibleLine != null) {
      localFlexibleLine.setActive(false);
    }
    this.y = paramFlexibleLine;
    paramFlexibleLine.setActive(true);
  }
  
  private void R1()
  {
    if (this.p0.size() < 4) {
      this.z.i.set(true);
    } else {
      this.z.i.set(false);
    }
    if (this.p0.size() == 0) {
      this.z.j.set(false);
    } else {
      this.z.j.set(true);
    }
  }
  
  private void e1()
  {
    if (this.p0.size() >= 4) {
      return;
    }
    FlexibleLine localFlexibleLine = new FlexibleLine(this);
    localFlexibleLine.setOnLineSelectListener(this);
    localFlexibleLine.setEditable(true);
    LineCrossingDetectionRegion localLineCrossingDetectionRegion = new LineCrossingDetectionRegion(String.valueOf(1666), String.valueOf(j1()), String.valueOf(8333), String.valueOf(j1()), "50", "both");
    localFlexibleLine.n(Integer.parseInt(localLineCrossingDetectionRegion.getPoint1X()), Integer.parseInt(localLineCrossingDetectionRegion.getPoint1Y()), Integer.parseInt(localLineCrossingDetectionRegion.getPoint2X()), Integer.parseInt(localLineCrossingDetectionRegion.getPoint2Y()), this.p1, this.p2);
    localFlexibleLine.setArrowDirection(this.z.g(localLineCrossingDetectionRegion));
    this.p0.add(localFlexibleLine);
    this.H3.S3.addView(localFlexibleLine);
    Q1(localFlexibleLine);
    R1();
  }
  
  private LineCrossingDetectionRegion f1(FlexibleLine paramFlexibleLine)
  {
    return new LineCrossingDetectionRegion(String.valueOf(paramFlexibleLine.getX1ForDevice()), String.valueOf(paramFlexibleLine.getY1ForDevice()), String.valueOf(paramFlexibleLine.getX2ForDevice()), String.valueOf(paramFlexibleLine.getY2ForDevice()), "50", this.z.h(paramFlexibleLine.getArrowDirection()));
  }
  
  private void g1()
  {
    if (this.p0.isEmpty())
    {
      TSnackbar.y(this, getString(2131953812), 3000).N();
      return;
    }
    this.H3.S3.removeView(this.y);
    this.p0.remove(this.y);
    if (this.p0.isEmpty())
    {
      this.y = null;
    }
    else
    {
      List localList = this.p0;
      Q1((FlexibleLine)localList.get(localList.size() - 1));
    }
    R1();
  }
  
  private void h1(boolean paramBoolean)
  {
    WindowManager.LayoutParams localLayoutParams;
    if (paramBoolean)
    {
      M1(this, false);
      localLayoutParams = getWindow().getAttributes();
      localLayoutParams.flags |= 0x400;
      getWindow().setAttributes(localLayoutParams);
    }
    else
    {
      M1(this, true);
      localLayoutParams = getWindow().getAttributes();
      localLayoutParams.flags &= 0xFBFF;
      getWindow().setAttributes(localLayoutParams);
    }
  }
  
  private List<LineCrossingDetectionRegion> i1()
  {
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; i < this.p0.size(); i++) {
      localArrayList.add(f1((FlexibleLine)this.p0.get(i)));
    }
    return localArrayList;
  }
  
  private int j1()
  {
    double d;
    if (this.p0.size() == 0) {
      d = 5000.0D;
    } else if (this.p0.size() == 1) {
      d = 6666.666666666667D;
    } else if (this.p0.size() == 2) {
      d = 3333.3333333333335D;
    } else {
      d = 8333.333333333334D;
    }
    return (int)d;
  }
  
  private void k1()
  {
    this.H3.getRoot().post(new p2(this));
  }
  
  private void l1()
  {
    ActivityLineCrossingRegionSettingBinding localActivityLineCrossingRegionSettingBinding = (ActivityLineCrossingRegionSettingBinding)DataBindingUtil.setContentView(this, 2131558571);
    this.H3 = localActivityLineCrossingRegionSettingBinding;
    localActivityLineCrossingRegionSettingBinding.i(this.z);
    this.H3.h(new l2(this));
  }
  
  private void m1()
  {
    Object localObject = getIntent().getStringExtra("device_id_md5");
    this.p3 = getIntent().getIntExtra("detection_home_mode", 3);
    this.H3 = ((ActivityLineCrossingRegionSettingBinding)DataBindingUtil.setContentView(this, 2131558571));
    localObject = (LineCrossingViewModel)ViewModelProviders.of(this, new CameraViewModelFactory(this, (String)localObject)).get(LineCrossingViewModel.class);
    this.z = ((LineCrossingViewModel)localObject);
    ((LineCrossingViewModel)localObject).n(this.p3);
  }
  
  private void n1(List<LineCrossingDetectionRegion> paramList)
  {
    this.p0.clear();
    Object localObject1 = paramList.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (LineCrossingDetectionRegion)((Iterator)localObject1).next();
      localObject2 = new FlexibleLine(this);
      this.p0.add(localObject2);
    }
    L1();
    if (this.p0.size() == 0) {
      return;
    }
    int j;
    for (int i = 0; i <= this.p0.size() - 1; i = j)
    {
      ((FlexibleLine)this.p0.get(i)).setOnLineSelectListener(this);
      ((FlexibleLine)this.p0.get(i)).setEditable(true);
      ((FlexibleLine)this.p0.get(i)).setArrowDirection(this.z.g((LineCrossingDetectionRegion)paramList.get(i)));
      ((FlexibleLine)this.p0.get(i)).n(Integer.parseInt(((LineCrossingDetectionRegion)paramList.get(i)).getPoint1X()), Integer.parseInt(((LineCrossingDetectionRegion)paramList.get(i)).getPoint1Y()), Integer.parseInt(((LineCrossingDetectionRegion)paramList.get(i)).getPoint2X()), Integer.parseInt(((LineCrossingDetectionRegion)paramList.get(i)).getPoint2Y()), this.p1, this.p2);
      localObject2 = this.H3.S3;
      localObject1 = (View)this.p0.get(i);
      j = i + 1;
      ((FrameLayout)localObject2).addView((View)localObject1, j);
      if (i == this.p0.size() - 1) {
        Q1((FlexibleLine)this.p0.get(i));
      } else {
        ((FlexibleLine)this.p0.get(i)).setActive(false);
      }
    }
  }
  
  private void o1()
  {
    this.z.j().observe(this, new h2(this));
    this.z.l().observe(this, new n2(this));
    this.z.m().observe(this, new j2(this));
    this.z.i().observe(this, new i2(this));
  }
  
  private void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131362489: 
    case 2131363582: 
      K1();
      break;
    case 2131362389: 
    case 2131362390: 
      L1();
      this.p0.clear();
      this.z.i.set(true);
      this.z.j.set(false);
      break;
    case 2131362386: 
    case 2131362387: 
      g1();
      break;
    case 2131362256: 
      onBackPressed();
      break;
    case 2131362223: 
      setRequestedOrientation(1);
      break;
    case 2131362222: 
      setRequestedOrientation(0);
      break;
    case 2131362219: 
    case 2131362220: 
      O1();
      break;
    case 2131361939: 
    case 2131361940: 
      e1();
      break;
    case 2131361937: 
    case 2131361938: 
      TSnackbar.y(this, String.format(getString(2131953800), new Object[] { Integer.valueOf(4) }), 3000).N();
    }
  }
  
  private void p1()
  {
    this.H3.i(this.z);
    this.H3.h(new l2(this));
    h1(q1());
    P1();
    N1();
    J1();
    k1();
  }
  
  public void F(FlexibleLine paramFlexibleLine)
  {
    Q1(paramFlexibleLine);
  }
  
  public void b0(boolean paramBoolean) {}
  
  public void onBackPressed()
  {
    if (q1()) {
      setRequestedOrientation(1);
    } else {
      finish();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = new ArrayList(i1());
    l1();
    h1(q1());
    P1();
    if (!q1()) {
      N1();
    }
    this.H3.getRoot().post(new o2(this, paramConfiguration));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    m1();
    p1();
    o1();
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 2131361893) {
      K1();
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  protected boolean q1()
  {
    boolean bool;
    if (getResources().getConfiguration().orientation == 2) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\setting\LineCrossingRegionSettingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */