package com.tplink.iot.dailysummary.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialog;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import b.d.q.b.p.b;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.c1;
import com.google.android.exoplayer2.f2;
import com.google.android.exoplayer2.h2;
import com.google.android.exoplayer2.h2.b;
import com.google.android.exoplayer2.j2;
import com.google.android.exoplayer2.l1;
import com.google.android.exoplayer2.l1.c;
import com.google.android.exoplayer2.t0;
import com.google.android.exoplayer2.u1.e;
import com.google.android.exoplayer2.ui.PlayerView;
import com.tplink.iot.Utils.TPMaterialDialogV3;
import com.tplink.iot.Utils.TPMaterialDialogV3.Builder;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.dailysummary.network.bean.common.SummaryClip;
import com.tplink.iot.dailysummary.network.bean.common.SummaryClipVideo;
import com.tplink.iot.dailysummary.view.adapter.SummaryClipAdapter;
import com.tplink.iot.dailysummary.viewmodel.SummaryClipListViewModel;
import com.tplink.iot.databinding.ActivitySummaryClipListBinding;
import com.tplink.iot.widget.CirclePercentBar;
import com.tplink.iot.widget.CirclePercentBar.c;
import io.reactivex.q;
import io.reactivex.r;
import io.reactivex.s;
import java.io.File;
import java.util.List;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class SummaryClipListActivity
  extends BaseActivity
{
  public static final a y = new a(null);
  private boolean H3;
  private SummaryClipAdapter I3;
  private View J3;
  private View K3;
  private View L3;
  private View M3;
  private View N3;
  private View O3;
  private ImageView P3;
  private ImageView Q3;
  private ImageView R3;
  private View S3;
  private View T3;
  private PlayerView U3;
  private CirclePercentBar V3;
  private View W3;
  private TPMaterialDialogV3 X3;
  private RecyclerView p0;
  private h2 p1;
  private io.reactivex.e0.c p2;
  private Thread p3;
  private SummaryClipListViewModel z;
  
  private final void A1()
  {
    SummaryClipListViewModel localSummaryClipListViewModel = this.z;
    if (localSummaryClipListViewModel == null) {
      j.t("mViewModel");
    }
    localSummaryClipListViewModel.r().observe(this, new m(this));
    localSummaryClipListViewModel.s().observe(this, new n(this));
    localSummaryClipListViewModel.v().observe(this, new o(this));
  }
  
  private final void C1(Configuration paramConfiguration)
  {
    boolean bool;
    if (paramConfiguration.orientation == 2) {
      bool = true;
    } else {
      bool = false;
    }
    this.H3 = bool;
    Object localObject1;
    Object localObject2;
    int i;
    if (bool)
    {
      localObject1 = getWindow();
      paramConfiguration = ((Window)localObject1).getDecorView();
      j.d(paramConfiguration, "decorView");
      paramConfiguration.setSystemUiVisibility(4102);
      ((Window)localObject1).setFlags(1024, 1024);
      paramConfiguration = getWindowManager();
      j.d(paramConfiguration, "windowManager");
      paramConfiguration.getDefaultDisplay().getRealMetrics(new DisplayMetrics());
      paramConfiguration = this.S3;
      if (paramConfiguration != null) {
        paramConfiguration.setVisibility(0);
      }
      paramConfiguration = this.O3;
      if (paramConfiguration != null) {
        paramConfiguration.setVisibility(0);
      }
      paramConfiguration = this.Q3;
      if (paramConfiguration != null) {
        paramConfiguration.setVisibility(0);
      }
      paramConfiguration = this.M3;
      if (paramConfiguration != null) {
        paramConfiguration.setVisibility(0);
      }
      localObject1 = this.Q3;
      if (localObject1 != null)
      {
        paramConfiguration = getResources();
        localObject2 = this.z;
        if (localObject2 == null) {
          j.t("mViewModel");
        }
        if (j.a((Boolean)((SummaryClipListViewModel)localObject2).u().getValue(), Boolean.TRUE)) {
          i = 2131231625;
        } else {
          i = 2131231626;
        }
        ((ImageView)localObject1).setImageDrawable(paramConfiguration.getDrawable(i));
      }
    }
    else
    {
      paramConfiguration = getWindow();
      localObject1 = paramConfiguration.getDecorView();
      j.d(localObject1, "decorView");
      ((View)localObject1).setSystemUiVisibility(256);
      paramConfiguration.getAttributes().flags &= 0xFBFF;
      paramConfiguration.clearFlags(512);
      paramConfiguration = getWindowManager();
      j.d(paramConfiguration, "windowManager");
      paramConfiguration.getDefaultDisplay().getRealMetrics(new DisplayMetrics());
      paramConfiguration = this.S3;
      if (paramConfiguration != null) {
        paramConfiguration.setVisibility(8);
      }
      paramConfiguration = this.O3;
      if (paramConfiguration != null) {
        paramConfiguration.setVisibility(8);
      }
      paramConfiguration = this.Q3;
      if (paramConfiguration != null) {
        paramConfiguration.setVisibility(8);
      }
      paramConfiguration = this.M3;
      if (paramConfiguration != null) {
        paramConfiguration.setVisibility(8);
      }
      paramConfiguration = this.P3;
      if (paramConfiguration != null)
      {
        localObject2 = getResources();
        localObject1 = this.z;
        if (localObject1 == null) {
          j.t("mViewModel");
        }
        if (j.a((Boolean)((SummaryClipListViewModel)localObject1).u().getValue(), Boolean.TRUE)) {
          i = 2131231585;
        } else {
          i = 2131231581;
        }
        paramConfiguration.setImageDrawable(((Resources)localObject2).getDrawable(i));
      }
    }
  }
  
  private final void q1()
  {
    Object localObject = this.z;
    if (localObject == null) {
      j.t("mViewModel");
    }
    if (j.a((Boolean)((SummaryClipListViewModel)localObject).t().getValue(), Boolean.TRUE))
    {
      localObject = this.U3;
      if (localObject == null) {
        j.t("mPlayerView");
      }
      localObject = ((PlayerView)localObject).getVideoSurfaceView();
      if (localObject != null)
      {
        Bitmap localBitmap = ((TextureView)localObject).getBitmap();
        if (localBitmap != null)
        {
          localObject = this.z;
          if (localObject == null) {
            j.t("mViewModel");
          }
          j.d(localBitmap, "bitmap");
          ((SummaryClipListViewModel)localObject).m(localBitmap);
        }
      }
    }
  }
  
  private final void r1(boolean paramBoolean)
  {
    setRequestedOrientation(paramBoolean ^ true);
  }
  
  private final void s1()
  {
    Object localObject = this.p1;
    if (localObject != null) {
      if (((h2)localObject).c1() == 0.0F)
      {
        ((h2)localObject).t1(1.0F);
        localObject = this.z;
        if (localObject == null) {
          j.t("mViewModel");
        }
        ((SummaryClipListViewModel)localObject).o(true);
        localObject = this.Q3;
        if (localObject != null) {
          ((ImageView)localObject).setImageDrawable(getResources().getDrawable(2131231625));
        }
      }
      else
      {
        ((h2)localObject).t1(0.0F);
        localObject = this.z;
        if (localObject == null) {
          j.t("mViewModel");
        }
        ((SummaryClipListViewModel)localObject).o(false);
        localObject = this.Q3;
        if (localObject != null) {
          ((ImageView)localObject).setImageDrawable(getResources().getDrawable(2131231626));
        }
      }
    }
  }
  
  private final void t1()
  {
    SummaryClipListViewModel localSummaryClipListViewModel = this.z;
    if (localSummaryClipListViewModel == null) {
      j.t("mViewModel");
    }
    localSummaryClipListViewModel.p();
  }
  
  private final void u1()
  {
    Object localObject1 = LayoutInflater.from(this).inflate(2131558833, null);
    Object localObject2 = (TextView)((View)localObject1).findViewById(2131364425);
    if (localObject2 != null) {
      ((TextView)localObject2).setText(2131952594);
    }
    localObject2 = p.a;
    j.d(localObject1, "LayoutInflater.from(this…ownloading)\n            }");
    this.W3 = ((View)localObject1);
    if (localObject1 == null) {
      j.t("mDownloadDialogView");
    }
    localObject1 = ((View)localObject1).findViewById(2131363623);
    localObject2 = (CirclePercentBar)localObject1;
    ((CirclePercentBar)localObject2).setListener(new b(this));
    j.d(localObject1, "mDownloadDialogView.find… { download() }\n        }");
    this.V3 = ((CirclePercentBar)localObject2);
    localObject2 = new TPMaterialDialogV3.Builder(this);
    localObject1 = this.W3;
    if (localObject1 == null) {
      j.t("mDownloadDialogView");
    }
    localObject1 = ((TPMaterialDialogV3.Builder)localObject2).s((View)localObject1).b(false).c(false).a();
    localObject2 = this.W3;
    if (localObject2 == null) {
      j.t("mDownloadDialogView");
    }
    ((Button)((View)localObject2).findViewById(2131362081)).setOnClickListener(new c((TPMaterialDialogV3)localObject1, this));
    if (!((Dialog)localObject1).isShowing()) {
      ((TPMaterialDialogV3)localObject1).show();
    }
    this.X3 = ((TPMaterialDialogV3)localObject1);
  }
  
  private final void v1()
  {
    Object localObject = new com.tplink.iot.Utils.hls.d(this);
    ((c1)localObject).i(2);
    h2 localh2 = new h2.b(this, (f2)localObject).z();
    localh2.N(new d(this));
    localObject = p.a;
    this.p1 = localh2;
    localObject = this.U3;
    if (localObject == null) {
      j.t("mPlayerView");
    }
    ((PlayerView)localObject).setPlayer(this.p1);
  }
  
  private final void w1(int paramInt)
  {
    Object localObject1 = getWindow();
    j.d(localObject1, "window");
    localObject1 = ((Window)localObject1).getDecorView();
    j.d(localObject1, "window.decorView");
    ((View)localObject1).setSystemUiVisibility(0);
    com.tplink.iot.view.quicksetup.base.d.b0(this, 2131099799);
    Object localObject2 = (ActivitySummaryClipListBinding)DataBindingUtil.setContentView(this, 2131558683);
    ((ViewDataBinding)localObject2).setLifecycleOwner(this);
    localObject1 = this.z;
    if (localObject1 == null) {
      j.t("mViewModel");
    }
    ((ActivitySummaryClipListBinding)localObject2).h((SummaryClipListViewModel)localObject1);
    this.p0 = ((ActivitySummaryClipListBinding)localObject2).p1;
    this.J3 = ((ActivitySummaryClipListBinding)localObject2).c;
    this.L3 = ((ActivitySummaryClipListBinding)localObject2).d;
    this.N3 = ((ActivitySummaryClipListBinding)localObject2).q;
    this.P3 = ((ActivitySummaryClipListBinding)localObject2).f;
    localObject1 = ((ActivitySummaryClipListBinding)localObject2).p0;
    j.d(localObject1, "playerViewSummaryClip");
    this.U3 = ((PlayerView)localObject1);
    this.K3 = findViewById(2131362145);
    this.S3 = findViewById(2131363200);
    this.T3 = findViewById(2131363198);
    this.O3 = findViewById(2131363137);
    this.Q3 = ((ImageView)findViewById(2131363132));
    this.R3 = ((ImageView)findViewById(2131363055));
    if (paramInt >= 0) {
      this.I3 = new SummaryClipAdapter(this, paramInt);
    }
    SummaryClipAdapter localSummaryClipAdapter = this.I3;
    if (localSummaryClipAdapter != null)
    {
      RecyclerView localRecyclerView = this.p0;
      if (localRecyclerView != null)
      {
        localObject1 = new GridLayoutManager(this, 2);
        ((LinearLayoutManager)localObject1).setOrientation(1);
        localObject2 = p.a;
        localRecyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject1);
        localRecyclerView.setAdapter(localSummaryClipAdapter);
      }
    }
  }
  
  private final void y1(int paramInt)
  {
    Object localObject = com.tplink.iot.e.a.c.k.h();
    if (localObject != null)
    {
      if (((List)localObject).size() < paramInt + 1) {
        return;
      }
      localObject = (SummaryClipVideo)((SummaryClip)((List)localObject).get(paramInt)).getVideo().get(0);
      if ((localObject != null) && (!TextUtils.isEmpty(((SummaryClipVideo)localObject).getUri())) && (!TextUtils.isEmpty(((SummaryClipVideo)localObject).getM3u8()))) {
        B1((SummaryClipVideo)localObject);
      }
      localObject = this.p0;
      if (localObject != null)
      {
        SummaryClipAdapter localSummaryClipAdapter = this.I3;
        if (localSummaryClipAdapter != null) {
          ((RecyclerView)localObject).scrollToPosition(localSummaryClipAdapter.r());
        }
      }
    }
  }
  
  private final void z1()
  {
    Object localObject = this.J3;
    if (localObject != null) {
      ((View)localObject).setOnClickListener(new e(this));
    }
    localObject = this.L3;
    if (localObject != null) {
      ((View)localObject).setOnClickListener(new f(this));
    }
    localObject = this.N3;
    if (localObject != null) {
      ((View)localObject).setOnClickListener(new g(this));
    }
    localObject = this.O3;
    if (localObject != null) {
      ((View)localObject).setOnClickListener(new h(this));
    }
    localObject = this.P3;
    if (localObject != null) {
      ((ImageView)localObject).setOnClickListener(new i(this));
    }
    localObject = this.Q3;
    if (localObject != null) {
      ((ImageView)localObject).setOnClickListener(new j(this));
    }
    localObject = this.R3;
    if (localObject != null) {
      ((ImageView)localObject).setOnClickListener(new k(this));
    }
    localObject = this.K3;
    if (localObject != null) {
      ((View)localObject).setOnClickListener(new l(this));
    }
  }
  
  public final void B1(final SummaryClipVideo paramSummaryClipVideo)
  {
    j.e(paramSummaryClipVideo, "video");
    Object localObject = this.z;
    if (localObject == null) {
      j.t("mViewModel");
    }
    ((SummaryClipListViewModel)localObject).x(paramSummaryClipVideo);
    localObject = this.p2;
    if (localObject != null) {
      ((io.reactivex.e0.c)localObject).dispose();
    }
    this.p2 = q.m(new p(this, paramSummaryClipVideo)).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).H0(new q(this), r.c);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    j.e(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    x1(this, 0, 1, null);
    C1(paramConfiguration);
    z1();
    paramConfiguration = this.U3;
    if (paramConfiguration == null) {
      j.t("mPlayerView");
    }
    paramConfiguration.setPlayer(this.p1);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    int i = getIntent().getIntExtra("clip_index", 0);
    paramBundle = new ViewModelProvider(this).get(SummaryClipListViewModel.class);
    j.d(paramBundle, "ViewModelProvider(this).…istViewModel::class.java)");
    SummaryClipListViewModel localSummaryClipListViewModel = (SummaryClipListViewModel)paramBundle;
    localSummaryClipListViewModel.w();
    paramBundle = p.a;
    this.z = localSummaryClipListViewModel;
    w1(i);
    z1();
    v1();
    A1();
    y1(i);
  }
  
  protected void onDestroy()
  {
    Object localObject = this.p2;
    if (localObject != null) {
      ((io.reactivex.e0.c)localObject).dispose();
    }
    localObject = this.p1;
    if (localObject != null) {
      ((h2)localObject).release();
    }
    super.onDestroy();
  }
  
  public static final class a
  {
    public final void a(Context paramContext, int paramInt)
    {
      j.e(paramContext, "context");
      Intent localIntent = new Intent(paramContext, SummaryClipListActivity.class);
      localIntent.putExtra("clip_index", paramInt);
      paramContext.startActivity(localIntent);
    }
  }
  
  static final class b
    implements CirclePercentBar.c
  {
    b(SummaryClipListActivity paramSummaryClipListActivity) {}
    
    public final void n()
    {
      SummaryClipListActivity.h1(this.c);
    }
  }
  
  static final class c
    implements View.OnClickListener
  {
    c(TPMaterialDialogV3 paramTPMaterialDialogV3, SummaryClipListActivity paramSummaryClipListActivity) {}
    
    public final void onClick(View paramView)
    {
      this.c.dismiss();
      SummaryClipListActivity.n1(jdField_this).l();
    }
  }
  
  public static final class d
    implements u1.e
  {
    d(SummaryClipListActivity paramSummaryClipListActivity) {}
    
    public void P(PlaybackException paramPlaybackException)
    {
      j.e(paramPlaybackException, "error");
      SummaryClipListActivity.n1(this.c).z(true);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPlayerError: ");
      localStringBuilder.append(paramPlaybackException.getMessage());
      b.d.w.c.a.c("SPlayActivity-tyler", localStringBuilder.toString());
    }
    
    public void U(boolean paramBoolean, int paramInt)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          int i = 6;
          if (paramInt != 3)
          {
            if (paramInt == 4) {
              SummaryClipListActivity.n1(this.c).B(6);
            }
          }
          else
          {
            SummaryClipListActivity.n1(this.c).A(true);
            SummaryClipListActivity.n1(this.c).y(false);
            SummaryClipListViewModel localSummaryClipListViewModel = SummaryClipListActivity.n1(this.c);
            paramInt = i;
            if (paramBoolean) {
              paramInt = 5;
            }
            localSummaryClipListViewModel.B(paramInt);
          }
        }
        else
        {
          SummaryClipListActivity.n1(this.c).y(true);
        }
      }
      else {
        SummaryClipListActivity.n1(this.c).A(false);
      }
    }
    
    public void g(boolean paramBoolean)
    {
      SummaryClipListActivity.n1(this.c).y(paramBoolean);
    }
    
    public void o(j2 paramj2, int paramInt)
    {
      j.e(paramj2, "timeline");
    }
  }
  
  static final class e
    implements View.OnClickListener
  {
    e(SummaryClipListActivity paramSummaryClipListActivity) {}
    
    public final void onClick(View paramView)
    {
      this.c.finish();
    }
  }
  
  static final class f
    implements View.OnClickListener
  {
    f(SummaryClipListActivity paramSummaryClipListActivity) {}
    
    public final void onClick(View paramView)
    {
      SummaryClipListActivity.e1(this.c);
    }
  }
  
  static final class g
    implements View.OnClickListener
  {
    g(SummaryClipListActivity paramSummaryClipListActivity) {}
    
    public final void onClick(View paramView)
    {
      SummaryClipListActivity.h1(this.c);
    }
  }
  
  static final class h
    implements View.OnClickListener
  {
    h(SummaryClipListActivity paramSummaryClipListActivity) {}
    
    public final void onClick(View paramView)
    {
      SummaryClipListActivity.h1(this.c);
    }
  }
  
  static final class i
    implements View.OnClickListener
  {
    i(SummaryClipListActivity paramSummaryClipListActivity) {}
    
    public final void onClick(View paramView)
    {
      SummaryClipListActivity.g1(this.c);
    }
  }
  
  static final class j
    implements View.OnClickListener
  {
    j(SummaryClipListActivity paramSummaryClipListActivity) {}
    
    public final void onClick(View paramView)
    {
      SummaryClipListActivity.g1(this.c);
    }
  }
  
  static final class k
    implements View.OnClickListener
  {
    k(SummaryClipListActivity paramSummaryClipListActivity) {}
    
    public final void onClick(View paramView)
    {
      paramView = this.c;
      SummaryClipListActivity.f1(paramView, SummaryClipListActivity.j1(paramView) ^ true);
    }
  }
  
  static final class l
    implements View.OnClickListener
  {
    l(SummaryClipListActivity paramSummaryClipListActivity) {}
    
    public final void onClick(View paramView)
    {
      SummaryClipListActivity.f1(this.c, false);
    }
  }
  
  static final class m<T>
    implements Observer<Boolean>
  {
    m(SummaryClipListActivity paramSummaryClipListActivity) {}
    
    public final void a(Boolean paramBoolean)
    {
      j.d(paramBoolean, "it");
      if (paramBoolean.booleanValue())
      {
        paramBoolean = this.a;
        String str = paramBoolean.getString(2131954392);
        j.d(str, "getString(R.string.video_capture_saved)");
        com.tplink.iot.e.a.a.d(paramBoolean, str, false, 4, null);
      }
    }
  }
  
  static final class n<T>
    implements Observer<Integer>
  {
    n(SummaryClipListActivity paramSummaryClipListActivity) {}
    
    public final void a(Integer paramInteger)
    {
      CirclePercentBar localCirclePercentBar = SummaryClipListActivity.k1(this.a);
      j.d(paramInteger, "it");
      localCirclePercentBar.setPercentData(paramInteger.intValue());
    }
  }
  
  static final class o<T>
    implements Observer<Integer>
  {
    o(SummaryClipListActivity paramSummaryClipListActivity) {}
    
    public final void a(Integer paramInteger)
    {
      if (((paramInteger == null) || (paramInteger.intValue() != 5)) && ((paramInteger == null) || (paramInteger.intValue() != 6)) && ((paramInteger == null) || (paramInteger.intValue() != 0))) {
        if ((paramInteger != null) && (paramInteger.intValue() == 1))
        {
          paramInteger = SummaryClipListActivity.l1(this.a);
          if (paramInteger != null) {
            paramInteger.p(false);
          }
          SummaryClipListActivity.o1(this.a);
        }
        else if ((paramInteger != null) && (paramInteger.intValue() == 2))
        {
          SummaryClipListActivity.k1(this.a).setPercentData(100);
          paramInteger = (TextView)SummaryClipListActivity.i1(this.a).findViewById(2131364425);
          if (paramInteger != null) {
            paramInteger.setText(2131952592);
          }
          paramInteger = (Button)SummaryClipListActivity.i1(this.a).findViewById(2131362081);
          if (paramInteger != null) {
            paramInteger.setText(2131952441);
          }
        }
        else if ((paramInteger != null) && (paramInteger.intValue() == 3))
        {
          SummaryClipListActivity.k1(this.a).m();
          paramInteger = (TextView)SummaryClipListActivity.i1(this.a).findViewById(2131364425);
          if (paramInteger != null) {
            paramInteger.setText(2131952593);
          }
        }
        else if ((paramInteger != null) && (paramInteger.intValue() == 4))
        {
          com.tplink.iot.e.a.a.d(this.a, "Summary has already been downloaded.", false, 4, null);
        }
      }
    }
  }
  
  static final class p<T>
    implements s<l1>
  {
    p(SummaryClipListActivity paramSummaryClipListActivity, SummaryClipVideo paramSummaryClipVideo) {}
    
    public final void subscribe(r<l1> paramr)
    {
      j.e(paramr, "it");
      Object localObject1 = Thread.currentThread();
      SummaryClipListActivity.p1(this.a, (Thread)localObject1);
      Object localObject2 = com.tplink.iot.h.j.a.e(b.d.w.h.a.a(paramSummaryClipVideo.getM3u8()), paramSummaryClipVideo.getUri());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(b.h());
      String str = File.separator;
      localStringBuilder.append(str);
      localStringBuilder.append("cloudvideo");
      localStringBuilder.append(str);
      localStringBuilder.append("playing.m3u8");
      str = localStringBuilder.toString();
      com.tplink.iot.h.j.a.f(str, (String)localObject2);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("file://");
      ((StringBuilder)localObject2).append(str);
      localObject2 = Uri.parse(((StringBuilder)localObject2).toString());
      if (j.a(localObject1, SummaryClipListActivity.m1(this.a)))
      {
        localObject1 = new l1.c().u((Uri)localObject2).q("application/x-mpegURL").a();
        j.d(localObject1, "MediaItem.Builder().setU…APPLICATION_M3U8).build()");
        paramr.onNext(localObject1);
      }
    }
  }
  
  static final class q<T>
    implements io.reactivex.g0.g<l1>
  {
    q(SummaryClipListActivity paramSummaryClipListActivity) {}
    
    public final void a(l1 paraml1)
    {
      h2 localh2 = SummaryClipListActivity.l1(this.c);
      if (localh2 != null)
      {
        localh2.D(paraml1);
        localh2.prepare();
        localh2.B(0, 0L);
        localh2.p(true);
      }
    }
  }
  
  static final class r<T>
    implements io.reactivex.g0.g<Throwable>
  {
    public static final r c = new r();
    
    public final void a(Throwable paramThrowable)
    {
      b.d.w.c.a.c("tylerTest", "setVideo failed!");
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\dailysummary\view\SummaryClipListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */