package com.tplink.iot.dailysummary.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.MediaStore.Video.Media;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialog;
import androidx.core.content.FileProvider;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.h;
import com.bumptech.glide.i;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.c1;
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
import com.tplink.iot.Utils.q0;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.dailysummary.network.bean.common.SummaryClip;
import com.tplink.iot.dailysummary.network.bean.common.SummaryVideo;
import com.tplink.iot.dailysummary.viewmodel.SummaryPlayViewModel;
import com.tplink.iot.dailysummary.widget.SummaryTimeAxisLayout;
import com.tplink.iot.dailysummary.widget.SummaryTimeAxisLayout.b;
import com.tplink.iot.databinding.ActivitySummaryPlayBinding;
import com.tplink.iot.view.ipcamera.widget.calendar.scrollCalendar.ScrollCalendar;
import com.tplink.iot.widget.CirclePercentBar;
import com.tplink.iot.widget.CirclePercentBar.c;
import io.reactivex.q;
import io.reactivex.r;
import io.reactivex.s;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.Future;
import kotlin.jvm.internal.Lambda;

public final class SummaryPlayActivity
  extends BaseActivity
  implements SummaryTimeAxisLayout.b, com.tplink.iot.view.ipcamera.widget.calendar.b, com.tplink.iot.view.ipcamera.widget.calendar.c
{
  public static final a y = new a(null);
  private boolean H3;
  private com.tplink.iot.view.ipcamera.widget.calendar.d I3;
  private com.tplink.iot.view.ipcamera.widget.calendar.d J3;
  private Calendar K3;
  private Calendar L3;
  private com.tplink.iot.view.ipcamera.widget.calendar.d M3;
  private io.reactivex.e0.c N3;
  private Thread O3;
  private LinkedList<com.tplink.iot.dailysummary.model.c> P3 = new LinkedList();
  private LinkedList<com.tplink.iot.dailysummary.model.c> Q3 = new LinkedList();
  private io.reactivex.e0.c R3;
  private View S3;
  private View T3;
  private View U3;
  private View V3;
  private View W3;
  private View X3;
  private View Y3;
  private View Z3;
  private View a4;
  private TextView b4;
  private View c4;
  private ScrollCalendar d4;
  private PlayerView e4;
  private SummaryTimeAxisLayout f4;
  private LottieAnimationView g4;
  private View h4;
  private View i4;
  private View j4;
  private View k4;
  private View l4;
  private View m4;
  private View n4;
  private View o4;
  private SummaryPlayViewModel p0;
  private boolean p1;
  private h2 p2;
  private boolean p3;
  private View p4;
  private View q4;
  private View r4;
  private View s4;
  private TextView t4;
  private CirclePercentBar u4;
  private View v4;
  private TPMaterialDialogV3 w4;
  private ActivitySummaryPlayBinding z;
  
  private final int I1(com.tplink.iot.view.ipcamera.widget.calendar.d paramd)
  {
    Calendar localCalendar1 = this.L3;
    int i;
    if (localCalendar1 != null)
    {
      i = localCalendar1.get(1);
      int j = paramd.e();
      Calendar localCalendar2 = Calendar.getInstance();
      localCalendar2.set(paramd.e(), paramd.d() - 1, paramd.c());
      i = (i - j) * 365 + (localCalendar1.get(6) - localCalendar2.get(6));
    }
    else
    {
      i = 0;
    }
    return i;
  }
  
  private final void J1()
  {
    Object localObject = this.p0;
    if (localObject == null) {
      kotlin.jvm.internal.j.t("mViewModel");
    }
    if (kotlin.jvm.internal.j.a((Boolean)((SummaryPlayViewModel)localObject).x0().getValue(), Boolean.TRUE))
    {
      localObject = this.e4;
      if (localObject == null) {
        kotlin.jvm.internal.j.t("mPlayerView");
      }
      localObject = ((PlayerView)localObject).getVideoSurfaceView();
      if (localObject != null)
      {
        localObject = ((TextureView)localObject).getBitmap();
        if (localObject != null)
        {
          SummaryPlayViewModel localSummaryPlayViewModel = this.p0;
          if (localSummaryPlayViewModel == null) {
            kotlin.jvm.internal.j.t("mViewModel");
          }
          kotlin.jvm.internal.j.d(localObject, "bitmap");
          localSummaryPlayViewModel.V((Bitmap)localObject);
        }
      }
    }
  }
  
  private final void K1(boolean paramBoolean)
  {
    if (this.p1 != paramBoolean)
    {
      this.p1 = paramBoolean;
      setRequestedOrientation(paramBoolean ^ true);
    }
  }
  
  private final void L1()
  {
    Object localObject = this.p2;
    if (localObject != null)
    {
      boolean bool = ((h2)localObject).E() ^ true;
      ((h2)localObject).p(bool);
      localObject = this.p0;
      if (localObject == null) {
        kotlin.jvm.internal.j.t("mViewModel");
      }
      int i;
      if (bool) {
        i = 5;
      } else {
        i = 6;
      }
      ((SummaryPlayViewModel)localObject).k1(i);
      localObject = this.p0;
      if (localObject == null) {
        kotlin.jvm.internal.j.t("mViewModel");
      }
      ((SummaryPlayViewModel)localObject).l1(bool ^ true);
    }
  }
  
  private final void M1(boolean paramBoolean)
  {
    Object localObject = this.p2;
    if (localObject != null)
    {
      ((h2)localObject).p(paramBoolean);
      localObject = this.p0;
      if (localObject == null) {
        kotlin.jvm.internal.j.t("mViewModel");
      }
      int i;
      if (paramBoolean) {
        i = 5;
      } else {
        i = 6;
      }
      ((SummaryPlayViewModel)localObject).k1(i);
      localObject = this.p0;
      if (localObject == null) {
        kotlin.jvm.internal.j.t("mViewModel");
      }
      ((SummaryPlayViewModel)localObject).l1(paramBoolean ^ true);
    }
  }
  
  private final void N1()
  {
    h2 localh2 = this.p2;
    if (localh2 != null)
    {
      float f;
      if (localh2.c1() == 0.0F) {
        f = 1.0F;
      } else {
        f = 0.0F;
      }
      localh2.t1(f);
      SummaryPlayViewModel localSummaryPlayViewModel = this.p0;
      if (localSummaryPlayViewModel == null) {
        kotlin.jvm.internal.j.t("mViewModel");
      }
      boolean bool;
      if (localh2.c1() == 0.0F) {
        bool = true;
      } else {
        bool = false;
      }
      localSummaryPlayViewModel.Y(bool);
    }
  }
  
  private final void O1()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(System.currentTimeMillis());
    TimeZone localTimeZone = TimeZone.getDefault();
    kotlin.jvm.internal.j.d(localTimeZone, "TimeZone.getDefault()");
    localCalendar.setTimeZone(TimeZone.getTimeZone(localTimeZone.getID()));
    Z1(new com.tplink.iot.view.ipcamera.widget.calendar.d(localCalendar.get(1), localCalendar.get(2) + 1, localCalendar.get(5)));
  }
  
  private final void P1(boolean paramBoolean)
  {
    SummaryPlayViewModel localSummaryPlayViewModel = this.p0;
    if (localSummaryPlayViewModel == null) {
      kotlin.jvm.internal.j.t("mViewModel");
    }
    localSummaryPlayViewModel.d0(paramBoolean);
  }
  
  private final void Q1()
  {
    if (this.L3 == null)
    {
      localObject1 = Calendar.getInstance();
      localObject2 = TimeZone.getDefault();
      kotlin.jvm.internal.j.d(localObject2, "TimeZone.getDefault()");
      ((Calendar)localObject1).setTimeZone(TimeZone.getTimeZone(((TimeZone)localObject2).getID()));
      ((Calendar)localObject1).setTimeInMillis(System.currentTimeMillis());
      this.M3 = new com.tplink.iot.view.ipcamera.widget.calendar.d(((Calendar)localObject1).get(1), ((Calendar)localObject1).get(2) + 1, ((Calendar)localObject1).get(5));
      localObject2 = kotlin.p.a;
      this.L3 = ((Calendar)localObject1);
    }
    Object localObject2 = this.L3;
    if (localObject2 != null)
    {
      localObject1 = this.d4;
      if (localObject1 == null) {
        kotlin.jvm.internal.j.t("mScrollCalendar");
      }
      ((ScrollCalendar)localObject1).d((Calendar)localObject2);
      ((ScrollCalendar)localObject1).setCurrentDate(new com.tplink.iot.view.ipcamera.widget.calendar.d(((Calendar)localObject2).get(1), ((Calendar)localObject2).get(2) + 1, ((Calendar)localObject2).get(5)));
      ((ScrollCalendar)localObject1).setMonthDateClickListener(this);
      ((ScrollCalendar)localObject1).setOnMonthSelectedListener(this);
      ((ScrollCalendar)localObject1).setMarkDays(new ArrayList());
      localObject1 = this.I3;
      if (localObject1 == null) {
        kotlin.jvm.internal.j.t("mSelectDateInfo");
      }
      Y1((com.tplink.iot.view.ipcamera.widget.calendar.d)localObject1);
    }
    localObject2 = this.p0;
    if (localObject2 == null) {
      kotlin.jvm.internal.j.t("mViewModel");
    }
    Object localObject1 = this.I3;
    if (localObject1 == null) {
      kotlin.jvm.internal.j.t("mSelectDateInfo");
    }
    ((SummaryPlayViewModel)localObject2).U0(I1((com.tplink.iot.view.ipcamera.widget.calendar.d)localObject1));
    localObject2 = (ArrayList)((SummaryPlayViewModel)localObject2).K0().getValue();
    if (localObject2 != null)
    {
      localObject1 = this.d4;
      if (localObject1 == null) {
        kotlin.jvm.internal.j.t("mScrollCalendar");
      }
      ((ScrollCalendar)localObject1).setMarkDays((List)localObject2);
    }
  }
  
  private final void R1()
  {
    Object localObject1 = LayoutInflater.from(this).inflate(2131558833, null);
    Object localObject2 = (TextView)((View)localObject1).findViewById(2131364425);
    if (localObject2 != null) {
      ((TextView)localObject2).setText(2131952594);
    }
    localObject2 = kotlin.p.a;
    kotlin.jvm.internal.j.d(localObject1, "LayoutInflater.from(this…ng.downloading)\n        }");
    this.v4 = ((View)localObject1);
    if (localObject1 == null) {
      kotlin.jvm.internal.j.t("mDownloadDialogView");
    }
    localObject1 = ((View)localObject1).findViewById(2131363623);
    localObject2 = (CirclePercentBar)localObject1;
    ((CirclePercentBar)localObject2).setListener(new b(this));
    kotlin.jvm.internal.j.d(localObject1, "mDownloadDialogView.find…wnload(false) }\n        }");
    this.u4 = ((CirclePercentBar)localObject2);
    localObject1 = new TPMaterialDialogV3.Builder(this);
    localObject2 = this.v4;
    if (localObject2 == null) {
      kotlin.jvm.internal.j.t("mDownloadDialogView");
    }
    localObject1 = ((TPMaterialDialogV3.Builder)localObject1).s((View)localObject2).b(false).c(false).a();
    localObject2 = this.v4;
    if (localObject2 == null) {
      kotlin.jvm.internal.j.t("mDownloadDialogView");
    }
    ((Button)((View)localObject2).findViewById(2131362081)).setOnClickListener(new c((TPMaterialDialogV3)localObject1, this));
    if (!((Dialog)localObject1).isShowing()) {
      ((TPMaterialDialogV3)localObject1).show();
    }
    this.w4 = ((TPMaterialDialogV3)localObject1);
  }
  
  private final void S1()
  {
    h2 localh2 = new h2.b(this, new c1(this)).z();
    localh2.N(new d(localh2, this));
    Object localObject = kotlin.p.a;
    this.p2 = localh2;
    localObject = this.e4;
    if (localObject == null) {
      kotlin.jvm.internal.j.t("mPlayerView");
    }
    ((PlayerView)localObject).setPlayer(this.p2);
    this.p3 = false;
  }
  
  private final void T1()
  {
    Object localObject1 = getWindow();
    kotlin.jvm.internal.j.d(localObject1, "window");
    localObject1 = ((Window)localObject1).getDecorView();
    kotlin.jvm.internal.j.d(localObject1, "window.decorView");
    ((View)localObject1).setSystemUiVisibility(0);
    com.tplink.iot.view.quicksetup.base.d.b0(this, 2131099799);
    localObject1 = DataBindingUtil.setContentView(this, 2131558685);
    ActivitySummaryPlayBinding localActivitySummaryPlayBinding = (ActivitySummaryPlayBinding)localObject1;
    localActivitySummaryPlayBinding.setLifecycleOwner(this);
    localActivitySummaryPlayBinding.h(this);
    Object localObject2 = this.p0;
    if (localObject2 == null) {
      kotlin.jvm.internal.j.t("mViewModel");
    }
    localActivitySummaryPlayBinding.i((SummaryPlayViewModel)localObject2);
    this.p4 = localActivitySummaryPlayBinding.p3;
    this.q4 = localActivitySummaryPlayBinding.H3;
    localObject2 = localActivitySummaryPlayBinding.K3;
    kotlin.jvm.internal.j.d(localObject2, "btnSummaryToolbarDownload");
    this.S3 = ((View)localObject2);
    localObject2 = localActivitySummaryPlayBinding.N3;
    kotlin.jvm.internal.j.d(localObject2, "btnSummaryToolbarPlay");
    this.T3 = ((View)localObject2);
    this.h4 = localActivitySummaryPlayBinding.J3;
    this.i4 = localActivitySummaryPlayBinding.p1;
    localObject2 = localActivitySummaryPlayBinding.M3;
    kotlin.jvm.internal.j.d(localObject2, "btnSummaryToolbarMute");
    this.V3 = ((View)localObject2);
    localObject2 = localActivitySummaryPlayBinding.O3;
    kotlin.jvm.internal.j.d(localObject2, "btnSummaryToolbarShare");
    this.W3 = ((View)localObject2);
    this.j4 = localActivitySummaryPlayBinding.L3;
    this.k4 = localActivitySummaryPlayBinding.I3;
    localObject2 = localActivitySummaryPlayBinding.p0;
    kotlin.jvm.internal.j.d(localObject2, "btnSummaryDateSelectorToday");
    this.X3 = ((View)localObject2);
    localObject2 = localActivitySummaryPlayBinding.e4;
    kotlin.jvm.internal.j.d(localObject2, "playerViewSummary");
    this.e4 = ((PlayerView)localObject2);
    this.t4 = localActivitySummaryPlayBinding.h4;
    localObject2 = localActivitySummaryPlayBinding.i4;
    kotlin.jvm.internal.j.d(localObject2, "tvSummaryDateSelectorMonth");
    this.b4 = ((TextView)localObject2);
    localObject2 = localActivitySummaryPlayBinding.W3;
    kotlin.jvm.internal.j.d(localObject2, "layoutSummaryDataSelectorCalendar");
    this.c4 = ((View)localObject2);
    localObject2 = localActivitySummaryPlayBinding.X3;
    kotlin.jvm.internal.j.d(localObject2, "layoutSummaryDataSelectorScrollCalendar");
    this.d4 = ((ScrollCalendar)localObject2);
    this.r4 = localActivitySummaryPlayBinding.U3;
    this.s4 = localActivitySummaryPlayBinding.b4;
    this.l4 = localActivitySummaryPlayBinding.f;
    this.m4 = localActivitySummaryPlayBinding.p2;
    localObject2 = localActivitySummaryPlayBinding.d4;
    kotlin.jvm.internal.j.d(localObject2, "layoutSummaryTimeAxis");
    this.f4 = ((SummaryTimeAxisLayout)localObject2);
    localObject2 = localActivitySummaryPlayBinding.x;
    kotlin.jvm.internal.j.d(localObject2, "btnSummaryDateSelectorLastMonth");
    this.Y3 = ((View)localObject2);
    localObject2 = localActivitySummaryPlayBinding.z;
    kotlin.jvm.internal.j.d(localObject2, "btnSummaryDateSelectorNextMonth");
    this.Z3 = ((View)localObject2);
    this.o4 = localActivitySummaryPlayBinding.q;
    this.n4 = localActivitySummaryPlayBinding.y;
    localObject2 = localActivitySummaryPlayBinding.c;
    kotlin.jvm.internal.j.d(localObject2, "animationViewPlayerLoading");
    this.g4 = ((LottieAnimationView)localObject2);
    localObject2 = localActivitySummaryPlayBinding.P3;
    kotlin.jvm.internal.j.d(localObject2, "btnTapRefresh");
    this.U3 = ((View)localObject2);
    localObject2 = localActivitySummaryPlayBinding.Q3;
    kotlin.jvm.internal.j.d(localObject2, "btnViewClip");
    this.a4 = ((View)localObject2);
    localObject2 = kotlin.p.a;
    kotlin.jvm.internal.j.d(localObject1, "DataBindingUtil.setConte…n = btnViewClip\n        }");
    this.z = localActivitySummaryPlayBinding;
    Q1();
  }
  
  private final boolean U1(com.tplink.iot.view.ipcamera.widget.calendar.d paramd)
  {
    com.tplink.iot.view.ipcamera.widget.calendar.d locald = this.M3;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (locald != null)
    {
      bool2 = bool1;
      if (locald.b(paramd) == 0) {
        bool2 = true;
      }
    }
    return bool2;
  }
  
  private final boolean V1(com.tplink.iot.view.ipcamera.widget.calendar.d paramd)
  {
    com.tplink.iot.view.ipcamera.widget.calendar.d locald = this.M3;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (locald != null)
    {
      bool2 = bool1;
      if (locald.e() == paramd.e())
      {
        bool2 = bool1;
        if (locald.d() == paramd.d()) {
          bool2 = true;
        }
      }
    }
    return bool2;
  }
  
  private final boolean W1(com.tplink.iot.view.ipcamera.widget.calendar.d paramd1, com.tplink.iot.view.ipcamera.widget.calendar.d paramd2)
  {
    boolean bool;
    if ((paramd1.e() == paramd2.e()) && (paramd1.d() == paramd2.d()) && (paramd1.c() == paramd2.c())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private final void Y1(com.tplink.iot.view.ipcamera.widget.calendar.d paramd)
  {
    this.I3 = paramd;
    if (paramd == null) {
      kotlin.jvm.internal.j.t("mSelectDateInfo");
    }
    this.J3 = paramd;
    Object localObject = this.d4;
    if (localObject == null) {
      kotlin.jvm.internal.j.t("mScrollCalendar");
    }
    ((ScrollCalendar)localObject).setSelectedDay(paramd);
    localObject = this.p0;
    if (localObject == null) {
      kotlin.jvm.internal.j.t("mViewModel");
    }
    ((SummaryPlayViewModel)localObject).Y0(V1(paramd) ^ true);
  }
  
  private final void Z1(com.tplink.iot.view.ipcamera.widget.calendar.d paramd)
  {
    if (this.L3 != null)
    {
      Object localObject = this.M3;
      if (localObject != null)
      {
        if (((com.tplink.iot.view.ipcamera.widget.calendar.d)localObject).e() < paramd.e()) {}
        do
        {
          i = 0;
          break label84;
          if (((com.tplink.iot.view.ipcamera.widget.calendar.d)localObject).e() != paramd.e()) {
            break;
          }
        } while (((com.tplink.iot.view.ipcamera.widget.calendar.d)localObject).d() < paramd.d());
        while ((((com.tplink.iot.view.ipcamera.widget.calendar.d)localObject).d() == paramd.d()) && (((com.tplink.iot.view.ipcamera.widget.calendar.d)localObject).c() < paramd.c())) {}
      }
      int i = 1;
      label84:
      if (i != 0)
      {
        localObject = this.d4;
        if (localObject == null) {
          kotlin.jvm.internal.j.t("mScrollCalendar");
        }
        ((ScrollCalendar)localObject).setSelectedDay(paramd);
        ((ScrollCalendar)localObject).setSelectMonth(paramd);
        localObject = this.I3;
        if (localObject == null) {
          kotlin.jvm.internal.j.t("mSelectDateInfo");
        }
        if (!W1(paramd, (com.tplink.iot.view.ipcamera.widget.calendar.d)localObject))
        {
          localObject = this.p2;
          if (localObject != null)
          {
            ((h2)localObject).p(false);
            ((t0)localObject).b();
          }
          localObject = this.p0;
          if (localObject == null) {
            kotlin.jvm.internal.j.t("mViewModel");
          }
          ((SummaryPlayViewModel)localObject).o1(new LinkedList());
          this.I3 = paramd;
          h2(paramd);
          localObject = this.p0;
          if (localObject == null) {
            kotlin.jvm.internal.j.t("mViewModel");
          }
          ((SummaryPlayViewModel)localObject).a1(paramd);
          localObject = this.p0;
          if (localObject == null) {
            kotlin.jvm.internal.j.t("mViewModel");
          }
          ((SummaryPlayViewModel)localObject).Y0(V1(paramd) ^ true);
        }
      }
      else
      {
        O1();
      }
    }
  }
  
  private final void a2(boolean paramBoolean)
  {
    Calendar localCalendar = Calendar.getInstance();
    Object localObject = TimeZone.getDefault();
    kotlin.jvm.internal.j.d(localObject, "TimeZone.getDefault()");
    localCalendar.setTimeZone(TimeZone.getTimeZone(((TimeZone)localObject).getID()));
    localObject = this.I3;
    if (localObject == null) {
      kotlin.jvm.internal.j.t("mSelectDateInfo");
    }
    int i = ((com.tplink.iot.view.ipcamera.widget.calendar.d)localObject).e();
    localObject = this.I3;
    if (localObject == null) {
      kotlin.jvm.internal.j.t("mSelectDateInfo");
    }
    int j = ((com.tplink.iot.view.ipcamera.widget.calendar.d)localObject).d();
    localObject = this.I3;
    if (localObject == null) {
      kotlin.jvm.internal.j.t("mSelectDateInfo");
    }
    localCalendar.set(i, j - 1, ((com.tplink.iot.view.ipcamera.widget.calendar.d)localObject).c());
    if (paramBoolean) {
      i = 1;
    } else {
      i = -1;
    }
    localCalendar.add(5, i);
    Z1(new com.tplink.iot.view.ipcamera.widget.calendar.d(localCalendar.get(1), localCalendar.get(2) + 1, localCalendar.get(5)));
  }
  
  private final void b2(boolean paramBoolean)
  {
    Object localObject2;
    if (this.K3 == null)
    {
      localObject1 = Calendar.getInstance();
      localObject2 = TimeZone.getDefault();
      kotlin.jvm.internal.j.d(localObject2, "TimeZone.getDefault()");
      ((Calendar)localObject1).setTimeZone(TimeZone.getTimeZone(((TimeZone)localObject2).getID()));
      localObject2 = kotlin.p.a;
      this.K3 = ((Calendar)localObject1);
    }
    Object localObject1 = this.K3;
    if (localObject1 != null)
    {
      localObject2 = this.J3;
      if (localObject2 == null) {
        kotlin.jvm.internal.j.t("mTempSelectDateInfo");
      }
      int i = ((com.tplink.iot.view.ipcamera.widget.calendar.d)localObject2).e();
      localObject2 = this.J3;
      if (localObject2 == null) {
        kotlin.jvm.internal.j.t("mTempSelectDateInfo");
      }
      int j = ((com.tplink.iot.view.ipcamera.widget.calendar.d)localObject2).d();
      localObject2 = this.J3;
      if (localObject2 == null) {
        kotlin.jvm.internal.j.t("mTempSelectDateInfo");
      }
      ((Calendar)localObject1).set(i, j - 1, ((com.tplink.iot.view.ipcamera.widget.calendar.d)localObject2).c());
      if (paramBoolean) {
        i = 1;
      } else {
        i = -1;
      }
      ((Calendar)localObject1).add(2, i);
      this.J3 = new com.tplink.iot.view.ipcamera.widget.calendar.d(((Calendar)localObject1).get(1), ((Calendar)localObject1).get(2) + 1, 1);
      localObject2 = this.d4;
      if (localObject2 == null) {
        kotlin.jvm.internal.j.t("mScrollCalendar");
      }
      localObject1 = this.J3;
      if (localObject1 == null) {
        kotlin.jvm.internal.j.t("mTempSelectDateInfo");
      }
      ((ScrollCalendar)localObject2).setSelectMonth((com.tplink.iot.view.ipcamera.widget.calendar.d)localObject1);
      localObject1 = this.J3;
      if (localObject1 == null) {
        kotlin.jvm.internal.j.t("mTempSelectDateInfo");
      }
      h2((com.tplink.iot.view.ipcamera.widget.calendar.d)localObject1);
      localObject2 = this.L3;
      if (localObject2 != null)
      {
        localObject1 = this.p0;
        if (localObject1 == null) {
          kotlin.jvm.internal.j.t("mViewModel");
        }
        ((SummaryPlayViewModel)localObject1).Y0(q0.g(this.K3, (Calendar)localObject2) ^ true);
      }
    }
  }
  
  private final void c2()
  {
    Object localObject = this.t4;
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener(new r(this));
    }
    localObject = this.b4;
    if (localObject == null) {
      kotlin.jvm.internal.j.t("mDateSelectorMonth");
    }
    ((TextView)localObject).setOnClickListener(new w(this));
    localObject = this.T3;
    if (localObject == null) {
      kotlin.jvm.internal.j.t("mPlayBtn");
    }
    ((View)localObject).setOnClickListener(new x(this));
    localObject = this.V3;
    if (localObject == null) {
      kotlin.jvm.internal.j.t("mMuteBtn");
    }
    ((View)localObject).setOnClickListener(new y(this));
    localObject = this.S3;
    if (localObject == null) {
      kotlin.jvm.internal.j.t("mDownloadBtn");
    }
    ((View)localObject).setOnClickListener(new z(this));
    localObject = this.X3;
    if (localObject == null) {
      kotlin.jvm.internal.j.t("mTodayBtn");
    }
    ((View)localObject).setOnClickListener(new a0(this));
    localObject = this.W3;
    if (localObject == null) {
      kotlin.jvm.internal.j.t("mShareBtn");
    }
    ((View)localObject).setOnClickListener(new b0(this));
    localObject = this.p4;
    if (localObject != null) {
      ((View)localObject).setOnClickListener(new c0(this));
    }
    localObject = this.q4;
    if (localObject != null) {
      ((View)localObject).setOnClickListener(new d0(this));
    }
    localObject = this.j4;
    if (localObject != null) {
      ((View)localObject).setOnClickListener(new h(this));
    }
    localObject = this.h4;
    if (localObject != null) {
      ((View)localObject).setOnClickListener(new i(this));
    }
    localObject = this.i4;
    if (localObject != null) {
      ((View)localObject).setOnClickListener(new j(this));
    }
    localObject = this.k4;
    if (localObject != null) {
      ((View)localObject).setOnClickListener(new k(this));
    }
    localObject = this.r4;
    if (localObject != null) {
      ((View)localObject).setOnClickListener(new l(this));
    }
    localObject = this.l4;
    if (localObject != null) {
      ((View)localObject).setOnClickListener(new m(this));
    }
    localObject = this.s4;
    if (localObject != null) {
      ((View)localObject).setOnClickListener(new n(this));
    }
    localObject = this.m4;
    if (localObject != null) {
      ((View)localObject).setOnClickListener(new o(this));
    }
    localObject = this.Y3;
    if (localObject == null) {
      kotlin.jvm.internal.j.t("mLastMonthBtn");
    }
    ((View)localObject).setOnClickListener(new p(this));
    localObject = this.Z3;
    if (localObject == null) {
      kotlin.jvm.internal.j.t("mNextMonthBtn");
    }
    ((View)localObject).setOnClickListener(new q(this));
    localObject = this.o4;
    if (localObject != null) {
      ((View)localObject).setOnClickListener(new s(this));
    }
    localObject = this.n4;
    if (localObject != null) {
      ((View)localObject).setOnClickListener(new t(this));
    }
    localObject = this.U3;
    if (localObject == null) {
      kotlin.jvm.internal.j.t("mTapRefreshBtn");
    }
    ((View)localObject).setOnClickListener(new u(this));
    localObject = this.a4;
    if (localObject == null) {
      kotlin.jvm.internal.j.t("mViewClipBtn");
    }
    ((View)localObject).setOnClickListener(new v(this));
  }
  
  private final void d2()
  {
    SummaryPlayViewModel localSummaryPlayViewModel = this.p0;
    if (localSummaryPlayViewModel == null) {
      kotlin.jvm.internal.j.t("mViewModel");
    }
    localSummaryPlayViewModel.K0().observe(this, new h0(this));
    localSummaryPlayViewModel.G0().observe(this, new i0(this));
    localSummaryPlayViewModel.M0().observe(this, new j0(this));
    localSummaryPlayViewModel.s0().observe(this, new k0(this));
    localSummaryPlayViewModel.h0().observe(this, new l0(this));
    localSummaryPlayViewModel.q0().observe(this, new m0(localSummaryPlayViewModel, this));
    localSummaryPlayViewModel.z0().observe(this, new n0(this));
    localSummaryPlayViewModel.B0().observe(this, new o0(this));
    localSummaryPlayViewModel.i0().observe(this, new p0(this));
    localSummaryPlayViewModel.m0().observe(this, new e0(this));
    localSummaryPlayViewModel.A0().observe(this, new f0(this));
    localSummaryPlayViewModel.E0().observe(this, new g0(this));
  }
  
  private final void e2(final SummaryVideo paramSummaryVideo, final boolean paramBoolean)
  {
    io.reactivex.e0.c localc = this.N3;
    if (localc != null) {
      localc.dispose();
    }
    this.N3 = q.m(new q0(this, paramSummaryVideo)).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).H0(new r0(this, paramBoolean), s0.c);
  }
  
  private final void f2(String paramString)
  {
    try
    {
      File localFile = new java/io/File;
      localFile.<init>(paramString);
      if (!localFile.exists())
      {
        b.d.w.c.a.c("SPlayActivity-tyler", "share file is not exist!");
        return;
      }
      paramString = Uri.fromFile(localFile);
      if (Build.VERSION.SDK_INT >= 20)
      {
        kotlin.jvm.internal.j.d(paramString, "uri");
        if (kotlin.jvm.internal.j.a("file", paramString.getScheme()))
        {
          paramString = new java/lang/StringBuilder;
          paramString.<init>();
          paramString.append(b.d.q.b.p.b.n());
          paramString.append(".provider");
          paramString = paramString.toString();
          try
          {
            paramString = FileProvider.getUriForFile(this, paramString, localFile);
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            paramString = new java/lang/StringBuilder;
            paramString.<init>();
            paramString.append("Exception: ");
            paramString.append(localIllegalArgumentException.getMessage());
            b.d.w.c.a.c("SPlayActivity-tyler", paramString.toString());
            localIllegalArgumentException.printStackTrace();
            return;
          }
        }
      }
      paramString = getContentResolver();
      Uri localUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
      Object localObject = new android/content/ContentValues;
      ((ContentValues)localObject).<init>();
      paramString = paramString.insert(localUri, (ContentValues)localObject);
      localObject = new android/content/Intent;
      ((Intent)localObject).<init>("android.intent.action.SEND");
      ((Intent)localObject).setType("*/*");
      ((Intent)localObject).putExtra("android.intent.extra.STREAM", paramString);
      paramString = kotlin.p.a;
      startActivity((Intent)localObject);
      return;
    }
    catch (Exception paramString)
    {
      b.d.w.c.a.c("SPlayActivity-tyler", "share file is not exist!");
    }
  }
  
  private final void g2(boolean paramBoolean)
  {
    SummaryPlayViewModel localSummaryPlayViewModel = this.p0;
    if (localSummaryPlayViewModel == null) {
      kotlin.jvm.internal.j.t("mViewModel");
    }
    localSummaryPlayViewModel.j1(paramBoolean);
  }
  
  private final void h2(com.tplink.iot.view.ipcamera.widget.calendar.d paramd)
  {
    Object localObject = kotlin.jvm.internal.p.a;
    localObject = String.format("%04d-%02d", Arrays.copyOf(new Object[] { Integer.valueOf(paramd.e()), Integer.valueOf(paramd.d()) }, 2));
    kotlin.jvm.internal.j.d(localObject, "java.lang.String.format(format, *args)");
    paramd = this.p0;
    if (paramd == null) {
      kotlin.jvm.internal.j.t("mViewModel");
    }
    paramd.Z0((String)localObject);
  }
  
  private final void i2()
  {
    Object localObject1 = this.p0;
    if (localObject1 == null) {
      kotlin.jvm.internal.j.t("mViewModel");
    }
    localObject1 = (Long)((SummaryPlayViewModel)localObject1).k0().getValue();
    if (localObject1 != null)
    {
      Object localObject2 = this.p0;
      if (localObject2 == null) {
        kotlin.jvm.internal.j.t("mViewModel");
      }
      List localList = (List)((SummaryPlayViewModel)localObject2).G0().getValue();
      if (localList != null)
      {
        int i = 0;
        K1(false);
        int j = localList.size() - 1;
        if (j >= 0) {
          for (;;)
          {
            localObject2 = ((SummaryClip)localList.get(i)).getSplitPoint();
            long l;
            if (localObject2 != null) {
              l = ((Long)localObject2).longValue();
            } else {
              l = 0L;
            }
            kotlin.jvm.internal.j.d(localObject1, "currentTime");
            if (l > ((Long)localObject1).longValue())
            {
              SummaryClipListActivity.y.a(this, i);
              break;
            }
            if (i == j) {
              break;
            }
            i++;
          }
        }
      }
    }
  }
  
  public void K0(long paramLong)
  {
    Object localObject = this.p0;
    if (localObject == null) {
      kotlin.jvm.internal.j.t("mViewModel");
    }
    ((SummaryPlayViewModel)localObject).k1(6);
    localObject = this.p2;
    if (localObject != null) {
      ((t0)localObject).seekTo(paramLong);
    }
    this.H3 = false;
  }
  
  public void M0(com.tplink.iot.view.ipcamera.widget.calendar.d paramd)
  {
    kotlin.jvm.internal.j.e(paramd, "oneDayInfo");
    Object localObject = this.J3;
    if (localObject == null) {
      kotlin.jvm.internal.j.t("mTempSelectDateInfo");
    }
    boolean bool;
    if (paramd.b((com.tplink.iot.view.ipcamera.widget.calendar.d)localObject) > 0) {
      bool = true;
    } else {
      bool = false;
    }
    b2(bool);
    localObject = this.p0;
    if (localObject == null) {
      kotlin.jvm.internal.j.t("mViewModel");
    }
    ((SummaryPlayViewModel)localObject).U0(I1(paramd));
  }
  
  public final void X1(final List<? extends SummaryClip> paramList)
  {
    kotlin.jvm.internal.j.e(paramList, "list");
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = Long.valueOf(0L);
    localArrayList.add(localObject1);
    Object localObject2 = this.p0;
    if (localObject2 == null) {
      kotlin.jvm.internal.j.t("mViewModel");
    }
    localObject2 = (Long)((SummaryPlayViewModel)localObject2).I0().getValue();
    if (localObject2 != null) {
      localObject1 = localObject2;
    }
    kotlin.jvm.internal.j.d(localObject1, "mViewModel.getSummaryDuration().value ?: 0");
    final long l1 = ((Long)localObject1).longValue();
    int i = paramList.size() - 1;
    if (i >= 0) {
      for (int j = 0;; j++)
      {
        localObject1 = ((SummaryClip)paramList.get(j)).getSplitPoint();
        if (localObject1 != null)
        {
          long l2 = ((Number)localObject1).longValue();
          if (l2 <= l1)
          {
            localArrayList.add(Long.valueOf(l2));
          }
          else
          {
            localArrayList.add(Long.valueOf(l1));
            k = 1;
            break label160;
          }
        }
        int k = 0;
        label160:
        if ((k != 0) || (j == i)) {
          break;
        }
      }
    }
    localObject1 = this.p0;
    if (localObject1 == null) {
      kotlin.jvm.internal.j.t("mViewModel");
    }
    ((SummaryPlayViewModel)localObject1).m1(localArrayList);
    localObject1 = this.R3;
    if (localObject1 != null) {
      ((io.reactivex.e0.c)localObject1).dispose();
    }
    if (this.P3.size() > 0)
    {
      localObject1 = this.P3;
      this.Q3 = ((LinkedList)localObject1);
      ((LinkedList)localObject1).clear();
      this.P3 = new LinkedList();
    }
    this.R3 = q.m(new e(this, paramList, l1)).L0(io.reactivex.l0.a.d()).l0(io.reactivex.d0.b.a.a()).H0(new f(this), g.c);
  }
  
  public void g0(int paramInt1, int paramInt2, int paramInt3)
  {
    Z1(new com.tplink.iot.view.ipcamera.widget.calendar.d(paramInt1, paramInt2 + 1, paramInt3));
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    kotlin.jvm.internal.j.e(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    T1();
    c2();
    Object localObject = this.e4;
    if (localObject == null) {
      kotlin.jvm.internal.j.t("mPlayerView");
    }
    ((PlayerView)localObject).setPlayer(this.p2);
    int i = paramConfiguration.orientation;
    if (i != 1)
    {
      if (i == 2)
      {
        localObject = getWindow();
        paramConfiguration = ((Window)localObject).getDecorView();
        kotlin.jvm.internal.j.d(paramConfiguration, "decorView");
        paramConfiguration.setSystemUiVisibility(4102);
        ((Window)localObject).setFlags(1024, 1024);
      }
    }
    else
    {
      paramConfiguration = getWindow();
      localObject = paramConfiguration.getDecorView();
      kotlin.jvm.internal.j.d(localObject, "decorView");
      ((View)localObject).setSystemUiVisibility(256);
      localObject = getWindow();
      kotlin.jvm.internal.j.d(localObject, "window");
      localObject = ((Window)localObject).getAttributes();
      paramConfiguration.getAttributes().flags = (((WindowManager.LayoutParams)localObject).flags & 0xFBFF);
      paramConfiguration.setAttributes((WindowManager.LayoutParams)localObject);
      paramConfiguration.clearFlags(512);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    try
    {
      paramBundle = getIntent().getStringExtra("summaryDate");
      if (paramBundle == null) {
        paramBundle = "";
      }
      kotlin.jvm.internal.j.d(paramBundle, "intent\n                .…ICATION_PARAM_DATE) ?: \"\"");
      this.I3 = com.tplink.iot.e.a.a.a(paramBundle);
    }
    catch (Exception localException)
    {
      paramBundle = new StringBuilder();
      paramBundle.append("datestrToOnedayinfo exception: ");
      paramBundle.append(localException.getMessage());
      b.d.w.c.a.c("SPlayActivity-tyler", paramBundle.toString());
      finish();
    }
    paramBundle = new ViewModelProvider(this).get(SummaryPlayViewModel.class);
    kotlin.jvm.internal.j.d(paramBundle, "ViewModelProvider(this).…layViewModel::class.java)");
    paramBundle = (SummaryPlayViewModel)paramBundle;
    Object localObject = this.I3;
    if (localObject == null) {
      kotlin.jvm.internal.j.t("mSelectDateInfo");
    }
    paramBundle.a1((com.tplink.iot.view.ipcamera.widget.calendar.d)localObject);
    paramBundle.O0();
    localObject = kotlin.p.a;
    this.p0 = paramBundle;
    T1();
    c2();
    S1();
    d2();
  }
  
  protected void onDestroy()
  {
    this.p3 = false;
    SummaryPlayViewModel localSummaryPlayViewModel = this.p0;
    if (localSummaryPlayViewModel == null) {
      kotlin.jvm.internal.j.t("mViewModel");
    }
    Object localObject = this.p2;
    if (localObject != null)
    {
      localSummaryPlayViewModel.h1(((h2)localObject).V());
      localSummaryPlayViewModel.h1(((h2)localObject).V());
      localSummaryPlayViewModel.d1(((h2)localObject).m());
    }
    localSummaryPlayViewModel.V0();
    localObject = this.N3;
    if (localObject != null) {
      ((io.reactivex.e0.c)localObject).dispose();
    }
    localObject = this.p2;
    if (localObject != null) {
      ((h2)localObject).release();
    }
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      if (this.p1 == true) {
        K1(false);
      } else {
        finish();
      }
    }
    return false;
  }
  
  protected void onRestart()
  {
    super.onRestart();
    Object localObject = this.p0;
    if (localObject == null) {
      kotlin.jvm.internal.j.t("mViewModel");
    }
    localObject = (SummaryVideo)((SummaryPlayViewModel)localObject).M0().getValue();
    if (localObject != null)
    {
      kotlin.jvm.internal.j.d(localObject, "it");
      e2((SummaryVideo)localObject, false);
      localObject = this.e4;
      if (localObject == null) {
        kotlin.jvm.internal.j.t("mPlayerView");
      }
      ((PlayerView)localObject).setPlayer(this.p2);
    }
  }
  
  protected void onStop()
  {
    M1(false);
    Object localObject = this.p2;
    if (localObject != null)
    {
      SummaryPlayViewModel localSummaryPlayViewModel = this.p0;
      if (localSummaryPlayViewModel == null) {
        kotlin.jvm.internal.j.t("mViewModel");
      }
      localSummaryPlayViewModel.W0(((h2)localObject).m(), ((h2)localObject).V(), ((h2)localObject).E());
      localObject = this.p0;
      if (localObject == null) {
        kotlin.jvm.internal.j.t("mViewModel");
      }
      ((SummaryPlayViewModel)localObject).G0();
    }
    super.onStop();
  }
  
  public void x(long paramLong, boolean paramBoolean)
  {
    SummaryPlayViewModel localSummaryPlayViewModel = this.p0;
    if (localSummaryPlayViewModel == null) {
      kotlin.jvm.internal.j.t("mViewModel");
    }
    localSummaryPlayViewModel.S0(paramLong);
    this.H3 = true;
  }
  
  public static final class a
  {
    public final void a(Context paramContext, String paramString)
    {
      kotlin.jvm.internal.j.e(paramContext, "context");
      kotlin.jvm.internal.j.e(paramString, "date");
      Intent localIntent = new Intent(paramContext, SummaryPlayActivity.class);
      localIntent.putExtra("summaryDate", paramString);
      paramContext.startActivity(localIntent);
    }
  }
  
  static final class a0
    implements View.OnClickListener
  {
    a0(SummaryPlayActivity paramSummaryPlayActivity) {}
    
    public final void onClick(View paramView)
    {
      SummaryPlayActivity.i1(this.c);
    }
  }
  
  static final class b
    implements CirclePercentBar.c
  {
    b(SummaryPlayActivity paramSummaryPlayActivity) {}
    
    public final void n()
    {
      SummaryPlayActivity.j1(this.c, false);
    }
  }
  
  static final class b0
    implements View.OnClickListener
  {
    b0(SummaryPlayActivity paramSummaryPlayActivity) {}
    
    public final void onClick(View paramView)
    {
      SummaryPlayActivity.j1(this.c, true);
    }
  }
  
  static final class c
    implements View.OnClickListener
  {
    c(TPMaterialDialogV3 paramTPMaterialDialogV3, SummaryPlayActivity paramSummaryPlayActivity) {}
    
    public final void onClick(View paramView)
    {
      this.c.dismiss();
      SummaryPlayActivity.v1(jdField_this).U();
    }
  }
  
  static final class c0
    implements View.OnClickListener
  {
    c0(SummaryPlayActivity paramSummaryPlayActivity) {}
    
    public final void onClick(View paramView)
    {
      this.c.finish();
    }
  }
  
  public static final class d
    implements u1.e
  {
    d(h2 paramh2, SummaryPlayActivity paramSummaryPlayActivity) {}
    
    public void P(PlaybackException paramPlaybackException)
    {
      kotlin.jvm.internal.j.e(paramPlaybackException, "error");
      SummaryPlayActivity.v1(jdField_this).f1(true);
      if (paramPlaybackException.getMessage() != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onPlayerError : error.message = ");
        localStringBuilder.append(paramPlaybackException.getMessage());
        b.d.w.c.a.c("SPlayActivity-tyler", localStringBuilder.toString());
      }
      else
      {
        b.d.w.c.a.c("SPlayActivity-tyler", "onPlayerError : error.message = null");
      }
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
              SummaryPlayActivity.v1(jdField_this).k1(6);
            }
          }
          else
          {
            SummaryPlayViewModel localSummaryPlayViewModel = SummaryPlayActivity.v1(jdField_this);
            localSummaryPlayViewModel.i1(true);
            localSummaryPlayViewModel.g1(true);
            localSummaryPlayViewModel.e1(false);
            paramInt = i;
            if (paramBoolean) {
              paramInt = 5;
            }
            localSummaryPlayViewModel.k1(paramInt);
          }
        }
        else
        {
          SummaryPlayActivity.v1(jdField_this).e1(true);
        }
      }
      else {
        SummaryPlayActivity.v1(jdField_this).g1(false);
      }
    }
    
    public void g(boolean paramBoolean)
    {
      SummaryPlayActivity.v1(jdField_this).e1(paramBoolean);
    }
    
    public void o(j2 paramj2, int paramInt)
    {
      kotlin.jvm.internal.j.e(paramj2, "timeline");
      if (this.c.v() > 0L) {
        SummaryPlayActivity.v1(jdField_this).n1(this.c.v());
      }
    }
  }
  
  static final class d0
    implements View.OnClickListener
  {
    d0(SummaryPlayActivity paramSummaryPlayActivity) {}
    
    public final void onClick(View paramView)
    {
      SummaryPlayActivity.f1(this.c, false);
    }
  }
  
  static final class e<T>
    implements s<com.tplink.iot.dailysummary.model.c>
  {
    e(SummaryPlayActivity paramSummaryPlayActivity, List paramList, long paramLong) {}
    
    public final void subscribe(r<com.tplink.iot.dailysummary.model.c> paramr)
    {
      kotlin.jvm.internal.j.e(paramr, "emitter");
      int i = paramList.size() - 1;
      if (i >= 0) {
        for (int j = 0;; j++)
        {
          Object localObject = (SummaryClip)paramList.get(j);
          if (localObject != null)
          {
            Bitmap localBitmap = (Bitmap)((h)com.bumptech.glide.c.x(this.a).k().A0(new com.tplink.iot.e.a.b((SummaryClip)localObject)).f(com.bumptech.glide.load.engine.j.a)).t0(192, 108).get();
            if (((SummaryClip)localObject).getSplitPoint().longValue() <= l1)
            {
              kotlin.jvm.internal.j.d(localBitmap, "bitmap");
              localObject = ((SummaryClip)localObject).getSplitPoint();
              kotlin.jvm.internal.j.d(localObject, "clip.splitPoint");
              paramr.onNext(new com.tplink.iot.dailysummary.model.c(localBitmap, ((Long)localObject).longValue()));
            }
            else
            {
              kotlin.jvm.internal.j.d(localBitmap, "bitmap");
              paramr.onNext(new com.tplink.iot.dailysummary.model.c(localBitmap, l1));
              k = 1;
              break label188;
            }
          }
          int k = 0;
          label188:
          if ((k != 0) || (j == i)) {
            break;
          }
        }
      }
    }
  }
  
  static final class e0<T>
    implements Observer<Integer>
  {
    e0(SummaryPlayActivity paramSummaryPlayActivity) {}
    
    public final void a(Integer paramInteger)
    {
      CirclePercentBar localCirclePercentBar = SummaryPlayActivity.l1(this.a);
      kotlin.jvm.internal.j.d(paramInteger, "it");
      localCirclePercentBar.setPercentData(paramInteger.intValue());
    }
  }
  
  static final class f<T>
    implements io.reactivex.g0.g<com.tplink.iot.dailysummary.model.c>
  {
    f(SummaryPlayActivity paramSummaryPlayActivity) {}
    
    public final void a(com.tplink.iot.dailysummary.model.c paramc)
    {
      SummaryPlayActivity.t1(this.c).add(paramc);
      SummaryPlayActivity.v1(this.c).o1(SummaryPlayActivity.t1(this.c));
    }
  }
  
  static final class f0<T>
    implements Observer<String>
  {
    f0(SummaryPlayActivity paramSummaryPlayActivity) {}
    
    public final void a(String paramString)
    {
      Object localObject = SummaryPlayActivity.o1(this.a);
      if ((localObject != null) && (((Dialog)localObject).isShowing())) {
        ((AppCompatDialog)localObject).dismiss();
      }
      localObject = this.a;
      kotlin.jvm.internal.j.d(paramString, "it");
      SummaryPlayActivity.F1((SummaryPlayActivity)localObject, paramString);
    }
  }
  
  static final class g<T>
    implements io.reactivex.g0.g<Throwable>
  {
    public static final g c = new g();
    
    public final void a(Throwable paramThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadSummaryThumbnailList failed: ");
      localStringBuilder.append(paramThrowable.getMessage());
      b.d.w.c.a.e("SPlayActivity-tyler", localStringBuilder.toString());
    }
  }
  
  static final class g0<T>
    implements Observer<Integer>
  {
    g0(SummaryPlayActivity paramSummaryPlayActivity) {}
    
    public final void a(Integer paramInteger)
    {
      if ((paramInteger != null) && (paramInteger.intValue() == 5))
      {
        SummaryPlayActivity.D1(this.a, true);
        kotlin.r.a.b(false, false, null, null, 0, new a(this), 31, null);
      }
      else if ((paramInteger != null) && (paramInteger.intValue() == 6))
      {
        SummaryPlayActivity.D1(this.a, false);
      }
      else if ((paramInteger != null) && (paramInteger.intValue() == 0))
      {
        SummaryPlayActivity.D1(this.a, false);
      }
      else if ((paramInteger != null) && (paramInteger.intValue() == 1))
      {
        SummaryPlayActivity.D1(this.a, false);
        paramInteger = SummaryPlayActivity.n1(this.a);
        if (paramInteger != null) {
          paramInteger.p(false);
        }
        SummaryPlayActivity.w1(this.a);
      }
      else if ((paramInteger != null) && (paramInteger.intValue() == 2))
      {
        SummaryPlayActivity.l1(this.a).setPercentData(100);
        paramInteger = (TextView)SummaryPlayActivity.k1(this.a).findViewById(2131364425);
        if (paramInteger != null) {
          paramInteger.setText(2131952592);
        }
        paramInteger = (Button)SummaryPlayActivity.k1(this.a).findViewById(2131362081);
        if (paramInteger != null) {
          paramInteger.setText(2131952441);
        }
      }
      else if ((paramInteger != null) && (paramInteger.intValue() == 3))
      {
        SummaryPlayActivity.l1(this.a).m();
        paramInteger = (TextView)SummaryPlayActivity.k1(this.a).findViewById(2131364425);
        if (paramInteger != null) {
          paramInteger.setText(2131952593);
        }
      }
      else if ((paramInteger != null) && (paramInteger.intValue() == 4))
      {
        com.tplink.iot.e.a.a.d(this.a, "Summary has already been downloaded.", false, 4, null);
      }
    }
    
    static final class a
      extends Lambda
      implements kotlin.jvm.b.a<kotlin.p>
    {
      a(SummaryPlayActivity.g0 paramg0)
      {
        super();
      }
      
      public final void a()
      {
        while (SummaryPlayActivity.u1(this.c.a))
        {
          SummaryPlayActivity.v1(this.c.a).i1(true);
          Thread.sleep(16L);
        }
      }
    }
  }
  
  static final class h
    implements View.OnClickListener
  {
    h(SummaryPlayActivity paramSummaryPlayActivity) {}
    
    public final void onClick(View paramView)
    {
      SummaryPlayActivity.f1(this.c, true);
    }
  }
  
  static final class h0<T>
    implements Observer<ArrayList<com.tplink.iot.view.ipcamera.widget.calendar.d>>
  {
    h0(SummaryPlayActivity paramSummaryPlayActivity) {}
    
    public final void a(ArrayList<com.tplink.iot.view.ipcamera.widget.calendar.d> paramArrayList)
    {
      SummaryPlayActivity.p1(this.a).setMarkDays(paramArrayList);
    }
  }
  
  static final class i
    implements View.OnClickListener
  {
    i(SummaryPlayActivity paramSummaryPlayActivity) {}
    
    public final void onClick(View paramView)
    {
      SummaryPlayActivity.e1(this.c);
    }
  }
  
  static final class i0<T>
    implements Observer<List<? extends SummaryClip>>
  {
    i0(SummaryPlayActivity paramSummaryPlayActivity) {}
    
    public final void a(List<? extends SummaryClip> paramList)
    {
      com.tplink.iot.e.a.c localc = com.tplink.iot.e.a.c.k;
      kotlin.jvm.internal.j.d(paramList, "it");
      localc.q(paramList);
      this.a.X1(paramList);
    }
  }
  
  static final class j
    implements View.OnClickListener
  {
    j(SummaryPlayActivity paramSummaryPlayActivity) {}
    
    public final void onClick(View paramView)
    {
      SummaryPlayActivity.e1(this.c);
    }
  }
  
  static final class j0<T>
    implements Observer<SummaryVideo>
  {
    j0(SummaryPlayActivity paramSummaryPlayActivity) {}
    
    public final void a(SummaryVideo paramSummaryVideo)
    {
      if (paramSummaryVideo != null) {
        SummaryPlayActivity.E1(this.a, paramSummaryVideo, true);
      }
    }
  }
  
  static final class k
    implements View.OnClickListener
  {
    k(SummaryPlayActivity paramSummaryPlayActivity) {}
    
    public final void onClick(View paramView)
    {
      SummaryPlayActivity.G1(this.c, true);
    }
  }
  
  static final class k0<T>
    implements Observer<Boolean>
  {
    k0(SummaryPlayActivity paramSummaryPlayActivity) {}
    
    public final void a(Boolean paramBoolean)
    {
      kotlin.jvm.internal.j.d(paramBoolean, "it");
      if (paramBoolean.booleanValue()) {
        SummaryPlayActivity.m1(this.a).o();
      } else {
        SummaryPlayActivity.m1(this.a).g();
      }
    }
  }
  
  static final class l
    implements View.OnClickListener
  {
    l(SummaryPlayActivity paramSummaryPlayActivity) {}
    
    public final void onClick(View paramView)
    {
      SummaryPlayActivity.G1(this.c, false);
    }
  }
  
  static final class l0<T>
    implements Observer<Boolean>
  {
    l0(SummaryPlayActivity paramSummaryPlayActivity) {}
    
    public final void a(Boolean paramBoolean)
    {
      kotlin.jvm.internal.j.d(paramBoolean, "it");
      if (paramBoolean.booleanValue())
      {
        SummaryPlayActivity localSummaryPlayActivity = this.a;
        paramBoolean = localSummaryPlayActivity.getString(2131954392);
        kotlin.jvm.internal.j.d(paramBoolean, "getString(R.string.video_capture_saved)");
        com.tplink.iot.e.a.a.d(localSummaryPlayActivity, paramBoolean, false, 4, null);
      }
    }
  }
  
  static final class m
    implements View.OnClickListener
  {
    m(SummaryPlayActivity paramSummaryPlayActivity) {}
    
    public final void onClick(View paramView)
    {
      SummaryPlayActivity.G1(this.c, true);
    }
  }
  
  static final class m0<T>
    implements Observer<Long>
  {
    m0(SummaryPlayViewModel paramSummaryPlayViewModel, SummaryPlayActivity paramSummaryPlayActivity) {}
    
    public final void a(Long paramLong)
    {
      if (!SummaryPlayActivity.q1(jdField_this))
      {
        SummaryPlayViewModel localSummaryPlayViewModel = this.a;
        kotlin.jvm.internal.j.d(paramLong, "it");
        localSummaryPlayViewModel.S0(paramLong.longValue());
      }
    }
  }
  
  static final class n
    implements View.OnClickListener
  {
    n(SummaryPlayActivity paramSummaryPlayActivity) {}
    
    public final void onClick(View paramView)
    {
      SummaryPlayActivity.v1(this.c).a0();
    }
  }
  
  static final class n0<T>
    implements Observer<Boolean>
  {
    n0(SummaryPlayActivity paramSummaryPlayActivity) {}
    
    public final void a(Boolean paramBoolean)
    {
      paramBoolean = SummaryPlayActivity.n1(this.a);
      if (paramBoolean != null) {
        SummaryPlayActivity.v1(this.a).c1(paramBoolean.V());
      }
    }
  }
  
  static final class o
    implements View.OnClickListener
  {
    o(SummaryPlayActivity paramSummaryPlayActivity) {}
    
    public final void onClick(View paramView)
    {
      SummaryPlayActivity.v1(this.c).X();
    }
  }
  
  static final class o0<T>
    implements Observer<Boolean>
  {
    o0(SummaryPlayActivity paramSummaryPlayActivity) {}
    
    public final void a(Boolean paramBoolean)
    {
      kotlin.jvm.internal.j.d(paramBoolean, "it");
      if (paramBoolean.booleanValue())
      {
        paramBoolean = this.a;
        SummaryPlayActivity.y1(paramBoolean, SummaryPlayActivity.r1(paramBoolean));
      }
      else
      {
        paramBoolean = this.a;
        SummaryPlayActivity.C1(paramBoolean, SummaryPlayActivity.r1(paramBoolean));
      }
    }
  }
  
  static final class p
    implements View.OnClickListener
  {
    p(SummaryPlayActivity paramSummaryPlayActivity) {}
    
    public final void onClick(View paramView)
    {
      SummaryPlayActivity.A1(this.c, false);
    }
  }
  
  static final class p0<T>
    implements Observer<String>
  {
    p0(SummaryPlayActivity paramSummaryPlayActivity) {}
    
    public final void a(String paramString)
    {
      SummaryPlayViewModel localSummaryPlayViewModel = SummaryPlayActivity.v1(this.a);
      SummaryPlayActivity localSummaryPlayActivity = this.a;
      kotlin.jvm.internal.j.d(paramString, "it");
      localSummaryPlayViewModel.X0(SummaryPlayActivity.x1(localSummaryPlayActivity, com.tplink.iot.e.a.a.a(paramString)) ^ true);
    }
  }
  
  static final class q
    implements View.OnClickListener
  {
    q(SummaryPlayActivity paramSummaryPlayActivity) {}
    
    public final void onClick(View paramView)
    {
      SummaryPlayActivity.A1(this.c, true);
    }
  }
  
  static final class q0<T>
    implements s<l1>
  {
    q0(SummaryPlayActivity paramSummaryPlayActivity, SummaryVideo paramSummaryVideo) {}
    
    public final void subscribe(r<l1> paramr)
    {
      kotlin.jvm.internal.j.e(paramr, "it");
      Object localObject1 = Thread.currentThread();
      SummaryPlayActivity.B1(this.a, (Thread)localObject1);
      Object localObject2 = paramSummaryVideo.getUri();
      Object localObject3 = paramSummaryVideo.getM3u8();
      if ((localObject3 != null) && (((String)localObject3).length() != 0))
      {
        localObject2 = com.tplink.iot.h.j.a.e(b.d.w.h.a.a((String)localObject3), (String)localObject2);
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("setVideo: m3u8FileStr = ");
        ((StringBuilder)localObject3).append((String)localObject2);
        b.d.w.c.a.c("SPlayActivity-tyler", ((StringBuilder)localObject3).toString());
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(b.d.q.b.p.b.h());
        localObject3 = File.separator;
        localStringBuilder.append((String)localObject3);
        localStringBuilder.append("cloudvideo");
        localStringBuilder.append((String)localObject3);
        localStringBuilder.append("playing.m3u8");
        localObject3 = localStringBuilder.toString();
        com.tplink.iot.h.j.a.f((String)localObject3, (String)localObject2);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("file://");
        ((StringBuilder)localObject2).append((String)localObject3);
        localObject2 = Uri.parse(((StringBuilder)localObject2).toString());
        if (kotlin.jvm.internal.j.a(localObject1, SummaryPlayActivity.s1(this.a)))
        {
          localObject1 = new l1.c().u((Uri)localObject2).q("application/x-mpegURL").a();
          kotlin.jvm.internal.j.d(localObject1, "MediaItem.Builder().setU…APPLICATION_M3U8).build()");
          paramr.onNext(localObject1);
        }
      }
      else
      {
        localObject2 = Uri.parse((String)localObject2);
        if (kotlin.jvm.internal.j.a(localObject1, SummaryPlayActivity.s1(this.a)))
        {
          localObject1 = new l1.c().u((Uri)localObject2).q("video/mp4").a();
          kotlin.jvm.internal.j.d(localObject1, "MediaItem.Builder().setU…eTypes.VIDEO_MP4).build()");
          paramr.onNext(localObject1);
        }
      }
    }
  }
  
  static final class r
    implements View.OnClickListener
  {
    r(SummaryPlayActivity paramSummaryPlayActivity) {}
    
    public final void onClick(View paramView)
    {
      SummaryPlayActivity.G1(this.c, true);
    }
  }
  
  static final class r0<T>
    implements io.reactivex.g0.g<l1>
  {
    r0(SummaryPlayActivity paramSummaryPlayActivity, boolean paramBoolean) {}
    
    public final void a(l1 paraml1)
    {
      h2 localh2 = SummaryPlayActivity.n1(this.c);
      if (localh2 != null)
      {
        localh2.D(paraml1);
        localh2.prepare();
        paraml1 = SummaryPlayActivity.v1(this.c);
        localh2.B(paraml1.r0(), paraml1.y0());
        boolean bool;
        if ((!paraml1.w0()) && (!paramBoolean)) {
          bool = false;
        } else {
          bool = true;
        }
        localh2.p(bool);
        if (paramBoolean) {
          paraml1.N0();
        }
      }
    }
  }
  
  static final class s
    implements View.OnClickListener
  {
    s(SummaryPlayActivity paramSummaryPlayActivity) {}
    
    public final void onClick(View paramView)
    {
      SummaryPlayActivity.z1(this.c, false);
    }
  }
  
  static final class s0<T>
    implements io.reactivex.g0.g<Throwable>
  {
    public static final s0 c = new s0();
    
    public final void a(Throwable paramThrowable)
    {
      b.d.w.c.a.c("SPlayActivity-tyler", "setVideo failed!");
    }
  }
  
  static final class t
    implements View.OnClickListener
  {
    t(SummaryPlayActivity paramSummaryPlayActivity) {}
    
    public final void onClick(View paramView)
    {
      SummaryPlayActivity.z1(this.c, true);
    }
  }
  
  static final class u
    implements View.OnClickListener
  {
    u(SummaryPlayActivity paramSummaryPlayActivity) {}
    
    public final void onClick(View paramView)
    {
      SummaryPlayActivity.v1(this.c).T0();
    }
  }
  
  static final class v
    implements View.OnClickListener
  {
    v(SummaryPlayActivity paramSummaryPlayActivity) {}
    
    public final void onClick(View paramView)
    {
      SummaryPlayActivity.H1(this.c);
    }
  }
  
  static final class w
    implements View.OnClickListener
  {
    w(SummaryPlayActivity paramSummaryPlayActivity) {}
    
    public final void onClick(View paramView)
    {
      SummaryPlayActivity.G1(this.c, false);
    }
  }
  
  static final class x
    implements View.OnClickListener
  {
    x(SummaryPlayActivity paramSummaryPlayActivity) {}
    
    public final void onClick(View paramView)
    {
      SummaryPlayActivity.g1(this.c);
    }
  }
  
  static final class y
    implements View.OnClickListener
  {
    y(SummaryPlayActivity paramSummaryPlayActivity) {}
    
    public final void onClick(View paramView)
    {
      SummaryPlayActivity.h1(this.c);
    }
  }
  
  static final class z
    implements View.OnClickListener
  {
    z(SummaryPlayActivity paramSummaryPlayActivity) {}
    
    public final void onClick(View paramView)
    {
      SummaryPlayActivity.j1(this.c, false);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\dailysummary\view\SummaryPlayActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */