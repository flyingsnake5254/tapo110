package com.tplink.iot.view.home;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.NetworkInfo.State;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AlertDialog.Builder;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.ItemTouchHelper.Callback;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener;
import com.google.android.material.appbar.CollapsingToolbarLayout.LayoutParams;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.iot.Utils.TPLongMaterialDialogV2;
import com.tplink.iot.Utils.TPLongMaterialDialogV2.Builder;
import com.tplink.iot.Utils.TPLongMaterialDialogV2.d;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.Utils.TPMaterialDialogV2.c;
import com.tplink.iot.Utils.a0;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.adapter.home.HomeFamilySelectBean;
import com.tplink.iot.adapter.home.HomeMainAdapter;
import com.tplink.iot.adapter.home.HomeShortcutAdapter;
import com.tplink.iot.adapter.home.HomeShortcutAdapter.c;
import com.tplink.iot.adapter.home.HomeShortcutItemDecoration;
import com.tplink.iot.adapter.home.ItemTouchHelperCallback;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.cloud.bean.cloudvideo.common.CloudVideo;
import com.tplink.iot.cloud.bean.cloudvideo.common.PartCloudVideo;
import com.tplink.iot.cloud.bean.family.common.FamilyInfo;
import com.tplink.iot.cloud.bean.smart.common.SmartInfo;
import com.tplink.iot.cloud.bean.thing.common.ThingNextEvent;
import com.tplink.iot.core.AppContext;
import com.tplink.iot.view.cloudvideo.CloudVideoListActivity;
import com.tplink.iot.view.familymanager.FamilyDetailActivity;
import com.tplink.iot.view.familymanager.FamilyListActivity;
import com.tplink.iot.view.home.alldevice.HomeAllDevicesActivity;
import com.tplink.iot.view.home.base.HomeBaseFragment;
import com.tplink.iot.view.home.message.NotificationCenterActivity;
import com.tplink.iot.view.home.nextevent.NextEventListActivity;
import com.tplink.iot.view.iothub.HubDetailActivity;
import com.tplink.iot.view.iotsensor.SensorDetailActivity;
import com.tplink.iot.view.ipcamera.play.VideoPlayActivity;
import com.tplink.iot.view.ipcamera.preview.CameraPreviewActivity;
import com.tplink.iot.view.ipcamera.preview.CameraPreviewActivity.a;
import com.tplink.iot.view.login.CloudRegionChooseActivity;
import com.tplink.iot.view.main.MainActivity;
import com.tplink.iot.view.quicksetup.common.SelectCategoryNewActivity;
import com.tplink.iot.view.quicksetup.discovery.DiscoveryDeviceListActivity;
import com.tplink.iot.viewmodel.home.HomeBaseViewModel;
import com.tplink.iot.viewmodel.home.HomeMainViewModel;
import com.tplink.iot.viewmodel.home.y.c;
import com.tplink.iot.widget.colorbulb.NextEventBulbTintView;
import com.tplink.iot.widget.springview.widget.PullToRefreshContainer;
import com.tplink.iot.widget.springview.widget.PullToRefreshContainer.e;
import com.tplink.libmediaapi.live.LiveMediaAPI;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.RunShortCutResultBean;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.TDPNetwork.bean.TDPIoTDevice;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CameraSettingRepository;
import com.tplink.libtpnetwork.enumerate.EnumHomeState;
import com.tplink.libtpnetwork.enumerate.EnumIoTDeviceState;
import com.tplink.libtpnetwork.enumerate.EnumMsgSubscribeType;
import com.tplink.libtpnetwork.enumerate.EnumNotificationMsgType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HomeFragment
  extends HomeBaseFragment
  implements com.tplink.iot.adapter.home.h, View.OnClickListener
{
  private long A4;
  private String B4;
  private String C4;
  private io.reactivex.e0.c D4;
  private Dialog E4;
  private AlertDialog F4;
  private AlertDialog G4;
  private TextView H3;
  private AlertDialog H4;
  private CardView I3;
  private com.tplink.iot.devicecommon.feature.a I4;
  private NextEventBulbTintView J3;
  private TPLongMaterialDialogV2 J4;
  private ImageView K3;
  private Runnable K4;
  private TextView L3;
  private Handler L4;
  private TextView M3;
  private String M4;
  private View N3;
  private String N4;
  private View O3;
  private View P3;
  private TextView Q3;
  private HomeMainViewModel R3;
  private boolean S3;
  private PullToRefreshContainer T3;
  private View U3;
  private View V3;
  private TextView W3;
  private int X3 = -1;
  private TextView Y3;
  private TextView Z3;
  private TextView a4;
  private TextView b4;
  private View c4;
  private View d4;
  private View e4;
  private MenuItem f4;
  private MenuItem g4;
  private View h4;
  private TextView i4;
  private ImageView j4;
  private int k4;
  private int l4;
  private ItemTouchHelperCallback m4;
  private com.tplink.iot.viewmodel.home.y n4;
  private String o4;
  private HomeMainAdapter p0;
  private HomeShortcutAdapter p1;
  private RecyclerView p2;
  private CardView p3;
  private String p4;
  private String q4;
  private b.a.a.a.a.a.a r4;
  private long s4 = 0L;
  private AlertDialog t4 = null;
  private WebView u4 = null;
  private AlertDialog v4 = null;
  private AlertDialog w4 = null;
  private String x = HomeFragment.class.getSimpleName();
  private String x4;
  private View y;
  private long y4;
  private RecyclerView z;
  private String z4;
  
  private void A3()
  {
    this.k4 = com.tplink.iot.Utils.k.a(this.y.getContext(), 70.0F);
    Object localObject = (Toolbar)this.y.findViewById(2131363400);
    if (getActivity() != null) {
      ((BaseActivity)getActivity()).setSupportActionBar((Toolbar)localObject);
    }
    this.I4 = new com.tplink.iot.devicecommon.feature.a();
    this.N3 = this.y.findViewById(2131364812);
    this.O3 = this.y.findViewById(2131364792);
    this.P3 = this.y.findViewById(2131362409);
    localObject = (CardView)this.y.findViewById(2131362245);
    this.I3 = ((CardView)localObject);
    ((FrameLayout)localObject).setVisibility(8);
    this.I3.setOnClickListener(this);
    localObject = (TextView)this.y.findViewById(2131364546);
    this.M3 = ((TextView)localObject);
    ((TextView)localObject).setVisibility(8);
    x3();
    v3();
    w3();
    ((AppBarLayout)this.y.findViewById(2131361815)).addOnOffsetChangedListener(new m());
    this.U3 = this.y.findViewById(2131364786);
    this.W3 = ((TextView)this.y.findViewById(2131364696));
    this.V3 = this.y.findViewById(2131363910);
    t3();
    y3();
    localObject = (TextView)this.y.findViewById(2131364340);
    this.Q3 = ((TextView)localObject);
    ((TextView)localObject).setOnClickListener(this);
    localObject = (CardView)this.y.findViewById(2131362193);
    this.p3 = ((CardView)localObject);
    ((FrameLayout)localObject).setOnClickListener(this);
    this.p3.setVisibility(8);
    this.L3 = ((TextView)this.y.findViewById(2131364540));
    this.J3 = ((NextEventBulbTintView)this.y.findViewById(2131363542));
    this.K3 = ((ImageView)this.y.findViewById(2131363080));
  }
  
  private boolean B3()
  {
    HomeMainAdapter localHomeMainAdapter = this.p0;
    boolean bool;
    if ((localHomeMainAdapter != null) && (localHomeMainAdapter.a())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private void J4()
  {
    com.tplink.iot.Utils.x0.o.d(this.p0.o() ^ true, this.x4);
    long l = System.currentTimeMillis();
    if (l - this.y4 > 86400000L)
    {
      com.tplink.iot.Utils.x0.o.z(this.p0.m());
      this.y4 = l;
    }
  }
  
  private void K4()
  {
    this.S3 = false;
    com.tplink.iot.Utils.x.b(this.V3);
    this.W3.setText(2131952842);
  }
  
  private void L4()
  {
    this.S3 = true;
    this.R3.U1(this.p0.m());
    O0();
    this.R3.q2(this.p0.m());
  }
  
  private void M4()
  {
    this.R3.a0();
  }
  
  private void N4(boolean paramBoolean)
  {
    O4(this.Y3, paramBoolean);
    O4(this.Z3, paramBoolean);
    O4(this.a4, paramBoolean);
    O4(this.b4, paramBoolean);
  }
  
  private void O2()
  {
    HomeMainViewModel localHomeMainViewModel = this.R3;
    if (localHomeMainViewModel != null) {
      localHomeMainViewModel.X();
    }
  }
  
  private void O4(TextView paramTextView, boolean paramBoolean)
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
  
  private void P2(HomeFamilySelectBean paramHomeFamilySelectBean)
  {
    s0.l(getActivity());
    this.R3.Y(paramHomeFamilySelectBean.getFamilyId());
  }
  
  private void P4()
  {
    if (this.H3 == null) {
      return;
    }
    if ((!this.R3.j1()) && (!this.R3.a1()))
    {
      int i = this.R3.g0();
      Object localObject1;
      Object localObject2;
      if (i == 1)
      {
        localObject1 = this.H3;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append("");
        ((TextView)localObject1).setText(getString(2131952836, new Object[] { ((StringBuilder)localObject2).toString() }));
      }
      else
      {
        localObject2 = this.H3;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(i);
        ((StringBuilder)localObject1).append("");
        ((TextView)localObject2).setText(getString(2131952810, new Object[] { ((StringBuilder)localObject1).toString() }));
      }
      this.H3.setVisibility(0);
    }
    else
    {
      this.H3.setVisibility(8);
    }
  }
  
  private void Q2(List<? extends com.tplink.iot.model.home.e> paramList)
  {
    if (com.tplink.iot.Utils.s.b(paramList)) {
      return;
    }
    this.z.setPadding(com.tplink.iot.Utils.j.a(getActivity(), 11.0F), com.tplink.iot.Utils.j.a(getActivity(), 10.0F), com.tplink.iot.Utils.j.a(getActivity(), 11.0F), com.tplink.iot.Utils.j.a(getActivity(), 80.0F));
  }
  
  private void Q4()
  {
    P4();
    S4();
    X4();
    R4();
  }
  
  private void R2(boolean paramBoolean) {}
  
  private void R4()
  {
    if (this.R3.Y0()) {
      this.I3.setVisibility(0);
    } else {
      this.I3.setVisibility(8);
    }
  }
  
  private void S2()
  {
    if ((!com.tplink.libtpnetwork.Utils.o.h0().c("rate_us_has_show", false)) && (!isHidden()))
    {
      long l = com.tplink.libtpnetwork.Utils.o.h0().e("rate_us_time_stamp", 0L);
      if ((l != 0L) && (System.currentTimeMillis() - l > 259200000L)) {
        this.R3.b2();
      }
    }
  }
  
  private void S4()
  {
    if ((this.R3.k1()) && (!this.R3.Y0())) {
      this.P3.setVisibility(0);
    } else {
      this.P3.setVisibility(8);
    }
  }
  
  private void T2()
  {
    Object localObject = this.p0.n();
    if (((List)localObject).isEmpty())
    {
      this.U3.setAlpha(0.8F);
      N4(false);
      return;
    }
    this.U3.setAlpha(1.0F);
    N4(true);
    Iterator localIterator = ((List)localObject).iterator();
    int i = 0;
    int j = 0;
    while (localIterator.hasNext())
    {
      localObject = (com.tplink.iot.model.home.e)localIterator.next();
      if ((localObject instanceof com.tplink.iot.model.home.g)) {
        j = 1;
      } else if (((localObject instanceof com.tplink.iot.model.home.k)) && (((com.tplink.iot.model.home.k)localObject).w())) {
        i = 1;
      }
    }
    if (i != 0) {
      O4(this.a4, false);
    }
    if ((i != 0) || (j != 0)) {
      O4(this.b4, false);
    }
  }
  
  private void T4(List<? extends com.tplink.iot.model.home.e> paramList)
  {
    if ((!com.tplink.iot.Utils.s.b(paramList)) && (paramList.size() >= 3) && (com.tplink.libtpnetwork.Utils.o.h0().O()))
    {
      b.d.w.c.a.e("dialog", "show  HomeLongPressTips");
      this.R3.Z1();
    }
  }
  
  private void U2(Boolean paramBoolean)
  {
    if (paramBoolean == null) {
      return;
    }
    if (!paramBoolean.booleanValue())
    {
      com.tplink.libtpnetwork.Utils.o.h0().W0(this.o4, System.currentTimeMillis());
      com.tplink.libtpnetwork.Utils.o.h0().M0(this.o4, com.tplink.libtpnetwork.Utils.o.h0().K(this.o4) + 1);
      c5();
    }
    else
    {
      com.tplink.libtpnetwork.Utils.o.h0().L0(this.o4, true);
    }
  }
  
  private void U4(List<? extends com.tplink.iot.model.home.e> paramList)
  {
    Object localObject = this.R3.i1();
    if ((localObject != null) && (!((Boolean)localObject).booleanValue()) && (!com.tplink.iot.Utils.s.b(paramList)) && (!com.tplink.libtpnetwork.Utils.o.h0().n0()))
    {
      paramList = paramList.iterator();
      int i;
      do
      {
        boolean bool = paramList.hasNext();
        i = 1;
        if (!bool) {
          break;
        }
        localObject = (com.tplink.iot.model.home.e)paramList.next();
      } while ((!(localObject instanceof com.tplink.iot.model.home.k)) || (((com.tplink.iot.model.home.k)localObject).p()));
      int j = 0;
      break label92;
      j = 1;
      label92:
      if (j != 0) {
        i = 2;
      }
      b.d.w.c.a.a("setHomeVoiceControlGuide");
      this.R3.c2(i);
    }
  }
  
  private List<com.tplink.iot.model.home.i> V2(List<SmartInfo> paramList, List<com.tplink.iot.model.home.i> paramList1)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList();
      int i = Math.min(paramList.size(), 5);
      for (int j = 0; j < i; j++)
      {
        SmartInfo localSmartInfo = (SmartInfo)paramList.get(j);
        com.tplink.iot.model.home.i locali = k3(localSmartInfo.getId(), paramList1);
        if (locali != null)
        {
          locali.f(localSmartInfo);
          locali.d(this.R3.n1(localSmartInfo.getId()));
          localArrayList.add(locali);
        }
        else
        {
          localArrayList.add(new com.tplink.iot.model.home.i(0, localSmartInfo, this.R3.n1(localSmartInfo.getId())));
        }
      }
      return localArrayList;
    }
    return new ArrayList();
  }
  
  private void V4(boolean paramBoolean)
  {
    if (getActivity() != null) {
      ((MainActivity)getActivity()).s1(paramBoolean);
    }
  }
  
  private void W2()
  {
    AlertDialog localAlertDialog = this.v4;
    if ((localAlertDialog != null) && (localAlertDialog.isShowing()))
    {
      this.v4.dismiss();
      g5();
    }
  }
  
  private void W4()
  {
    if ((this.R3.k1()) && (!this.R3.Y0())) {
      this.p3.setVisibility(0);
    } else {
      this.p3.setVisibility(8);
    }
  }
  
  private void X2()
  {
    b.d.w.c.a.a("dismissAppMarketingPage");
    WebView localWebView = this.u4;
    if (localWebView != null)
    {
      localWebView.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
      this.u4.clearHistory();
      ((ViewGroup)this.u4.getParent()).removeView(this.u4);
      this.u4.destroy();
      this.u4 = null;
    }
    if (this.t4 != null)
    {
      if ((getActivity() != null) && (!getActivity().isDestroyed()) && (!getActivity().isFinishing())) {
        this.t4.dismiss();
      }
      this.t4 = null;
    }
  }
  
  private void X4()
  {
    if ((this.R3.k1()) && (!this.R3.Y0()) && (this.R3.f1())) {
      this.M3.setVisibility(0);
    } else {
      this.M3.setVisibility(8);
    }
  }
  
  private void Y2()
  {
    com.tplink.iot.viewmodel.home.y localy = this.n4;
    if ((localy != null) && (localy.isShowing())) {
      this.n4.dismiss();
    }
  }
  
  private void Y4()
  {
    if (this.R3.k1()) {
      this.p2.setVisibility(0);
    } else {
      this.p2.setVisibility(8);
    }
  }
  
  private void Z2(EnumHomeState paramEnumHomeState)
  {
    if (paramEnumHomeState == null)
    {
      a3();
      return;
    }
    int i = d0.a[paramEnumHomeState.ordinal()];
    if (i != 1)
    {
      if (i != 2) {
        a3();
      } else {
        b3();
      }
    }
    else {
      c3();
    }
  }
  
  private void Z4()
  {
    if (this.R3.j1())
    {
      this.h4.setVisibility(8);
      return;
    }
    if (B3())
    {
      this.h4.setVisibility(4);
      return;
    }
    if (!this.R3.k1())
    {
      localObject = getResources().getDrawable(2131690228);
      ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getMinimumWidth(), ((Drawable)localObject).getMinimumHeight());
      this.i4.setText(2131952834);
      this.i4.setCompoundDrawables((Drawable)localObject, null, null, null);
      this.j4.setVisibility(8);
      this.h4.setVisibility(0);
      return;
    }
    Object localObject = this.R3.g();
    if ((!this.R3.h1()) && (localObject != null))
    {
      String str = ((FamilyInfo)localObject).getName();
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = getString(2131952817);
      }
      this.i4.setCompoundDrawables(null, null, null, null);
      this.i4.setText((CharSequence)localObject);
      this.j4.setVisibility(0);
      this.h4.setVisibility(0);
      return;
    }
    this.i4.setCompoundDrawables(null, null, null, null);
    this.i4.setText(2131952817);
    this.j4.setVisibility(8);
    this.h4.setVisibility(0);
  }
  
  private void a3()
  {
    Z4();
    this.O3.setVisibility(8);
    this.N3.setVisibility(0);
    Y2();
  }
  
  @SuppressLint({"SetJavaScriptEnabled"})
  private void a5(String paramString)
  {
    b.d.w.c.a.a("showAppMarketingPage advertUrl");
    if (this.t4 == null)
    {
      AlertDialog.Builder localBuilder = new AlertDialog.Builder(getContext(), 2132017570);
      View localView = getLayoutInflater().inflate(2131559097, null);
      localView.findViewById(2131363406).setOnClickListener(new z());
      WebView localWebView = (WebView)localView.findViewById(2131363407);
      this.u4 = localWebView;
      localWebView.getSettings().setJavaScriptEnabled(true);
      this.u4.setWebViewClient(new l0(paramString));
      this.u4.loadUrl(paramString);
      this.t4 = localBuilder.setView(localView).setOnDismissListener(new a0()).create();
    }
  }
  
  private void b3()
  {
    Z4();
    W4();
    Y4();
    Q4();
    this.O3.setVisibility(0);
    this.N3.setVisibility(8);
    Y2();
  }
  
  private void b5(int paramInt)
  {
    TPLongMaterialDialogV2 localTPLongMaterialDialogV2 = this.J4;
    if (localTPLongMaterialDialogV2 != null)
    {
      localTPLongMaterialDialogV2.dismiss();
      this.J4 = null;
    }
    this.J4 = new TPLongMaterialDialogV2.Builder(getContext()).o(2131952587).g(getString(2131952585, new Object[] { Integer.valueOf(paramInt) })).j(2131954260, new c0()).m(2131954433, new b0()).b(false).c(false).t();
  }
  
  private void c3()
  {
    Z4();
    Q4();
    this.O3.setVisibility(0);
    this.N3.setVisibility(8);
  }
  
  private void c5()
  {
    new TPMaterialDialogV2.Builder(getActivity()).d(2131559232).f(new x()).y();
  }
  
  private void d3()
  {
    HomeMainViewModel localHomeMainViewModel = this.R3;
    if (localHomeMainViewModel != null) {
      localHomeMainViewModel.Z();
    }
  }
  
  private void d5(View paramView)
  {
    final Object localObject1 = this.n4;
    if ((localObject1 != null) && (((PopupWindow)localObject1).isShowing())) {
      return;
    }
    localObject1 = new ArrayList();
    Iterator localIterator = this.R3.c0().iterator();
    while (localIterator.hasNext())
    {
      localObject2 = (FamilyInfo)localIterator.next();
      HomeFamilySelectBean localHomeFamilySelectBean = new HomeFamilySelectBean();
      localHomeFamilySelectBean.setFamilyId(((FamilyInfo)localObject2).getId());
      if ((((FamilyInfo)localObject2).isDefault()) && (((FamilyInfo)localObject2).getName() != null) && (((FamilyInfo)localObject2).getName().isEmpty())) {
        localHomeFamilySelectBean.setFamilyName(getString(2131952817));
      } else {
        localHomeFamilySelectBean.setFamilyName(((FamilyInfo)localObject2).getName());
      }
      localHomeFamilySelectBean.setSelected(this.R3.b1((FamilyInfo)localObject2));
      ((List)localObject1).add(localHomeFamilySelectBean);
    }
    Object localObject2 = new com.tplink.iot.viewmodel.home.y(getActivity(), (List)localObject1);
    this.n4 = ((com.tplink.iot.viewmodel.home.y)localObject2);
    ((PopupWindow)localObject2).setAnimationStyle(2132018131);
    this.n4.f(new s((List)localObject1));
    this.n4.g(paramView);
    ObjectAnimator.ofFloat(this.j4, View.ROTATION.getName(), new float[] { 180.0F }).start();
    this.n4.setOnDismissListener(new t());
  }
  
  @SuppressLint({"CheckResult"})
  private void e3(final String paramString1, final String paramString2)
  {
    String str1 = this.B4;
    String str2 = str1;
    if (str1 == null) {
      str2 = "";
    }
    if ((!TextUtils.isEmpty(str2)) && (a0.a(str2))) {
      this.R3.i0(paramString1, str2).l0(io.reactivex.d0.b.a.a()).H0(new y(paramString1, paramString2), new q(this, paramString1, paramString2));
    } else {
      l3(b.d.w.h.a.g(paramString1), paramString2);
    }
  }
  
  private void e5()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity != null) && (!localFragmentActivity.isDestroyed()) && (!localFragmentActivity.isFinishing()))
    {
      com.tplink.libtpnetwork.Utils.o.h0().U0(false);
      Dialog localDialog = new Dialog(localFragmentActivity, 2132017573);
      this.E4 = localDialog;
      localDialog.setContentView(2131559160);
      this.E4.setCancelable(false);
      this.E4.show();
      new Handler().postDelayed(new j(this, localFragmentActivity), 5000L);
    }
  }
  
  private void f5()
  {
    if (this.H4 == null)
    {
      FragmentActivity localFragmentActivity = getActivity();
      if ((localFragmentActivity != null) && (!localFragmentActivity.isDestroyed()) && (!localFragmentActivity.isFinishing()))
      {
        Object localObject = new AlertDialog.Builder(localFragmentActivity, 2132017570);
        View localView = getLayoutInflater().inflate(2131559184, null);
        localView.findViewById(2131363686).setOnClickListener(new p(this, localFragmentActivity));
        localView.findViewById(2131363537).setOnClickListener(new k(this, localFragmentActivity));
        localObject = ((AlertDialog.Builder)localObject).setView(localView).create();
        this.H4 = ((AlertDialog)localObject);
        ((Dialog)localObject).setCancelable(false);
        if ((!localFragmentActivity.isDestroyed()) && (!localFragmentActivity.isFinishing())) {
          this.H4.show();
        }
        localObject = this.H4.getWindow();
        if (localObject != null) {
          ((Window)localObject).setLayout(com.tplink.libtpnetwork.cameranetwork.util.e.a(320, localFragmentActivity), -2);
        }
      }
    }
  }
  
  private String g3(MainActivity paramMainActivity)
  {
    if (paramMainActivity == null) {
      return null;
    }
    return paramMainActivity.h1();
  }
  
  private void g5()
  {
    if (this.K4 == null) {
      this.K4 = new n(this);
    }
    if (this.L4 == null) {
      this.L4 = new Handler();
    }
    this.L4.postDelayed(this.K4, 1000L);
  }
  
  private long h3(MainActivity paramMainActivity)
  {
    long l1 = 0L;
    if (paramMainActivity == null) {
      return 0L;
    }
    long l2 = l1;
    if (paramMainActivity.j1() != null) {
      try
      {
        l2 = Long.parseLong(paramMainActivity.j1());
      }
      catch (Exception paramMainActivity)
      {
        paramMainActivity.printStackTrace();
        l2 = l1;
      }
    }
    return l2;
  }
  
  private void h5()
  {
    if (this.G4 == null)
    {
      FragmentActivity localFragmentActivity = getActivity();
      if ((localFragmentActivity != null) && (!localFragmentActivity.isDestroyed()) && (!localFragmentActivity.isFinishing()))
      {
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(localFragmentActivity, 2132017570);
        Object localObject = getLayoutInflater().inflate(2131559205, null);
        ((View)localObject).findViewById(2131363686).setOnClickListener(new t(this, localFragmentActivity));
        ((View)localObject).findViewById(2131363537).setOnClickListener(new d(this, localFragmentActivity));
        localObject = localBuilder.setView((View)localObject).create();
        this.G4 = ((AlertDialog)localObject);
        ((Dialog)localObject).setCancelable(false);
        if ((!localFragmentActivity.isDestroyed()) && (!localFragmentActivity.isFinishing())) {
          this.G4.show();
        }
        localObject = this.G4.getWindow();
        if (localObject != null) {
          ((Window)localObject).setLayout(com.tplink.libtpnetwork.cameranetwork.util.e.a(320, localFragmentActivity), -2);
        }
      }
    }
  }
  
  private String i3(MainActivity paramMainActivity)
  {
    if (paramMainActivity == null) {
      return null;
    }
    return paramMainActivity.k1();
  }
  
  private void i5()
  {
    if (this.F4 == null)
    {
      FragmentActivity localFragmentActivity = getActivity();
      if ((localFragmentActivity != null) && (!localFragmentActivity.isDestroyed()) && (!localFragmentActivity.isFinishing()))
      {
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(localFragmentActivity, 2132017570);
        Object localObject = getLayoutInflater().inflate(2131559213, null);
        ((View)localObject).findViewById(2131363686).setOnClickListener(new z(this, localFragmentActivity));
        ((View)localObject).findViewById(2131363537).setOnClickListener(new m(this, localFragmentActivity));
        ((View)localObject).findViewById(2131362254).setOnClickListener(new b0(this, localFragmentActivity));
        localObject = localBuilder.setView((View)localObject).create();
        this.F4 = ((AlertDialog)localObject);
        ((Dialog)localObject).setCancelable(false);
        if ((!localFragmentActivity.isDestroyed()) && (!localFragmentActivity.isFinishing()))
        {
          this.F4.show();
          com.tplink.libtpnetwork.Utils.o.h0().h("rate_us_has_show", true);
        }
        localObject = this.F4.getWindow();
        if (localObject != null) {
          ((Window)localObject).setLayout(com.tplink.libtpnetwork.cameranetwork.util.e.a(320, localFragmentActivity), -2);
        }
      }
    }
  }
  
  private String j3(MainActivity paramMainActivity)
  {
    if (paramMainActivity == null) {
      return null;
    }
    return paramMainActivity.l1();
  }
  
  private void j5()
  {
    if (this.w4 == null)
    {
      Object localObject1 = new AlertDialog.Builder(getActivity(), 2132017570);
      Object localObject2 = getLayoutInflater().inflate(2131558825, null);
      ((View)localObject2).findViewById(2131362831).setOnClickListener(new c(this));
      ((View)localObject2).findViewById(2131362037).setOnClickListener(new b(this));
      localObject2 = ((AlertDialog.Builder)localObject1).setView((View)localObject2).create();
      this.w4 = ((AlertDialog)localObject2);
      ((Dialog)localObject2).setCancelable(false);
      localObject1 = this.w4.getWindow();
      if (localObject1 != null)
      {
        ((Window)localObject1).setGravity(80);
        ((Window)localObject1).getDecorView().setPadding(0, net.lucode.hackware.magicindicator.g.b.a(getActivity(), 60.0D), 0, 0);
        localObject2 = ((Window)localObject1).getAttributes();
        ((WindowManager.LayoutParams)localObject2).width = -1;
        ((WindowManager.LayoutParams)localObject2).horizontalMargin = 0.0F;
        ((Window)localObject1).setAttributes((WindowManager.LayoutParams)localObject2);
        ((Window)localObject1).setWindowAnimations(2132017164);
      }
      this.w4.show();
    }
  }
  
  private com.tplink.iot.model.home.i k3(String paramString, List<com.tplink.iot.model.home.i> paramList)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        com.tplink.iot.model.home.i locali = (com.tplink.iot.model.home.i)paramList.next();
        if ((locali != null) && (locali.b() != null) && (paramString.equals(locali.b().getId()))) {
          return locali;
        }
      }
    }
    return null;
  }
  
  private void k5(int paramInt)
  {
    if (this.v4 == null)
    {
      com.tplink.libtpnetwork.Utils.o.h0().P0();
      Object localObject1 = new AlertDialog.Builder(getActivity(), 2132017570);
      View localView1 = getLayoutInflater().inflate(2131558826, null);
      localView1.findViewById(2131362826).setOnClickListener(new g(this));
      localView1.findViewById(2131364464).setOnClickListener(new y(this));
      localView1.findViewById(2131364341).setOnClickListener(new x(this));
      localView1.findViewById(2131364641).setOnClickListener(new w(this));
      Object localObject2 = localView1.findViewById(2131363257);
      View localView2 = localView1.findViewById(2131363308);
      int i = 8;
      if (paramInt == 2)
      {
        ((View)localObject2).setVisibility(8);
        localView2.setVisibility(8);
      }
      else
      {
        if (com.tplink.libtpnetwork.Utils.x.a()) {
          paramInt = 0;
        } else {
          paramInt = 8;
        }
        ((View)localObject2).setVisibility(paramInt);
        localView1.findViewById(2131364338).setOnClickListener(new r(this));
        paramInt = i;
        if (com.tplink.libtpnetwork.Utils.x.a()) {
          paramInt = 0;
        }
        localView2.setVisibility(paramInt);
        localView1.findViewById(2131364524).setOnClickListener(new s(this));
      }
      localView1.findViewById(2131364498).setOnClickListener(new u(this));
      localObject2 = ((AlertDialog.Builder)localObject1).setView(localView1).create();
      this.v4 = ((AlertDialog)localObject2);
      ((Dialog)localObject2).setCancelable(false);
      localObject1 = this.v4.getWindow();
      if (localObject1 != null)
      {
        ((Window)localObject1).setGravity(80);
        ((Window)localObject1).getDecorView().setPadding(0, net.lucode.hackware.magicindicator.g.b.a(getActivity(), 60.0D), 0, 0);
        localObject2 = ((Window)localObject1).getAttributes();
        ((WindowManager.LayoutParams)localObject2).width = -1;
        ((WindowManager.LayoutParams)localObject2).horizontalMargin = 0.0F;
        ((Window)localObject1).setAttributes((WindowManager.LayoutParams)localObject2);
        ((Window)localObject1).setWindowAnimations(2132017164);
      }
      this.v4.show();
    }
  }
  
  private void l3(String paramString1, String paramString2)
  {
    CameraSettingRepository localCameraSettingRepository = (CameraSettingRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(paramString1, CameraSettingRepository.class);
    this.D4 = this.R3.D0(paramString1).H0(new a(this, paramString1, localCameraSettingRepository, paramString2), new e(this));
  }
  
  private void l5()
  {
    this.R3.t0().observe(getViewLifecycleOwner(), new k());
    this.R3.r0().observe(getViewLifecycleOwner(), new v());
    this.R3.q0().observe(getViewLifecycleOwner(), new e0());
    this.R3.h0().observe(getViewLifecycleOwner(), new f0());
    this.R3.P0().observe(getViewLifecycleOwner(), new g0());
    this.R3.L0().observe(getViewLifecycleOwner(), new h0());
    this.R3.m0().observe(getViewLifecycleOwner(), new i0());
    this.R3.s0().observe(getViewLifecycleOwner(), new j0());
    this.R3.E0().observe(getViewLifecycleOwner(), new k0());
    this.R3.R0().observe(getViewLifecycleOwner(), new a());
    this.R3.k0().observe(getViewLifecycleOwner(), new b());
    this.R3.y0().observe(getViewLifecycleOwner(), new c());
    this.R3.C0().observe(getViewLifecycleOwner(), new d());
    this.R3.I0().observe(getViewLifecycleOwner(), new e());
    this.R3.z0().observe(getViewLifecycleOwner(), new f());
    this.R3.S0().observe(getViewLifecycleOwner(), new g());
    this.R3.u0().observe(getViewLifecycleOwner(), new h());
    this.R3.l0().observe(getViewLifecycleOwner(), new l(this));
    this.R3.B0().observe(getViewLifecycleOwner(), new i());
    this.R3.Q0().observe(getViewLifecycleOwner(), new j());
    com.tplink.libtpnetwork.Utils.j.c(this.R3.x0(), this, new h(this));
    this.R3.d0().observe(getViewLifecycleOwner(), new d0(this));
    this.R3.J0().observe(getViewLifecycleOwner(), new e0(this));
    this.R3.G0().observe(getViewLifecycleOwner(), new f(this));
    this.R3.K0().observe(getViewLifecycleOwner(), new l());
    this.R3.F0().observe(getViewLifecycleOwner(), new i(this));
    this.R3.H0().observe(getViewLifecycleOwner(), new o(this));
    this.R3.n0().observe(getViewLifecycleOwner(), new c0(this));
  }
  
  private void m3()
  {
    s0.g();
    this.z4 = null;
    this.A4 = 0L;
    this.C4 = null;
    this.B4 = null;
    com.tplink.iot.Utils.login.a.g(getActivity());
    if (getActivity() != null) {
      getActivity().finish();
    }
  }
  
  private void m5(TCAccountBean paramTCAccountBean)
  {
    if (paramTCAccountBean == null) {
      return;
    }
    String str = paramTCAccountBean.getCloudUserName();
    paramTCAccountBean = paramTCAccountBean.getEmail();
    if (com.tplink.libtpnetwork.Utils.o.h0().J(str)) {
      return;
    }
    int i = com.tplink.libtpnetwork.Utils.o.h0().K(str);
    long l1 = com.tplink.libtpnetwork.Utils.o.h0().R(str);
    long l2 = System.currentTimeMillis();
    if (i == 0)
    {
      com.tplink.libtpnetwork.Utils.o.h0().W0(str, l2);
      com.tplink.libtpnetwork.Utils.o.h0().M0(str, 1);
    }
    else if ((i == 1) && (l2 - l1 > 172800000L))
    {
      this.R3.p0(paramTCAccountBean);
    }
  }
  
  private void n3(CloudVideo paramCloudVideo, String paramString)
  {
    if (paramCloudVideo != null) {
      if ((paramCloudVideo.getPartCloudVideos() != null) && (paramCloudVideo.getPartCloudVideos().size() > 0))
      {
        PartCloudVideo localPartCloudVideo = (PartCloudVideo)paramCloudVideo.getPartCloudVideos().get(0);
        if ((localPartCloudVideo != null) && (localPartCloudVideo.getUri() != null)) {
          o3(paramString, localPartCloudVideo.getM3u8(), localPartCloudVideo.getUri(), localPartCloudVideo.getDuration(), localPartCloudVideo.getStartTimestamp(), paramCloudVideo.getUuid());
        }
      }
      else
      {
        s0.p(getActivity(), getString(2131954391));
      }
    }
  }
  
  private void n5()
  {
    Object localObject = this.R3;
    if ((localObject != null) && (((HomeMainViewModel)localObject).o1()))
    {
      Handler localHandler = this.L4;
      if (localHandler != null)
      {
        localObject = this.K4;
        if (localObject != null) {
          localHandler.removeCallbacks((Runnable)localObject);
        }
      }
      this.R3.k2();
    }
  }
  
  private void o3(String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, String paramString4)
  {
    Intent localIntent = new Intent(getActivity(), CloudVideoListActivity.class);
    localIntent.putExtra("cloud_video_device_id", paramString1);
    if ((paramString2 != null) && (paramString3 != null))
    {
      localIntent.putExtra("cloud_video_m3u8", paramString2);
      localIntent.putExtra("cloud_video_uri", paramString3);
      localIntent.putExtra("cloud_video_duration", paramLong1);
      localIntent.putExtra("cloud_video_timestamp", paramLong2);
      localIntent.putExtra("cloud_video_uuid", paramString4);
    }
    startActivity(localIntent);
  }
  
  private void o5(Boolean paramBoolean)
  {
    int i;
    if ((paramBoolean != null) && (paramBoolean.booleanValue())) {
      i = 1;
    } else {
      i = 0;
    }
    paramBoolean = this.g4;
    if (paramBoolean != null)
    {
      if (i != 0) {
        i = 2131689715;
      } else {
        i = 2131689714;
      }
      paramBoolean.setIcon(i);
    }
  }
  
  private void p3(String paramString)
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null)
    {
      Intent localIntent = new Intent(localFragmentActivity, VideoPlayActivity.class);
      localIntent.putExtra("device_id_md5", paramString);
      localIntent.putExtra("online", true);
      localFragmentActivity.startActivity(localIntent);
    }
  }
  
  private void q3(BaseALIoTDevice paramBaseALIoTDevice, String paramString)
  {
    EnumMsgSubscribeType localEnumMsgSubscribeType = EnumMsgSubscribeType.fromString(paramString);
    int i = d0.b[localEnumMsgSubscribeType.ordinal()];
    if ((i != 1) && (i != 2)) {
      if ((i != 3) && (i != 4)) {
        e3(paramBaseALIoTDevice.getDeviceId(), paramString);
      } else {
        l3(paramBaseALIoTDevice.getDeviceIdMD5(), paramString);
      }
    }
  }
  
  private void q5(boolean paramBoolean)
  {
    if (getActivity() != null) {
      ((MainActivity)getActivity()).r1(paramBoolean);
    }
  }
  
  private void r3(List<TDPIoTDevice> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      b5(paramList.size());
      return;
    }
    paramList = this.J4;
    if (paramList != null)
    {
      paramList.dismiss();
      this.J4 = null;
    }
    g5();
  }
  
  private void r5(boolean paramBoolean)
  {
    MenuItem localMenuItem = this.f4;
    if (localMenuItem != null)
    {
      int i;
      if (paramBoolean) {
        i = 2131231239;
      } else {
        i = 2131689716;
      }
      localMenuItem.setIcon(i);
    }
  }
  
  private void s3()
  {
    Object localObject1 = this.z4;
    if (localObject1 != null)
    {
      Object localObject2 = this.R3;
      if (localObject2 != null)
      {
        Object localObject3 = this.C4;
        localObject1 = ((HomeMainViewModel)localObject2).f0((String)localObject1);
        if ((localObject1 != null) && (((BaseALIoTDevice)localObject1).getDeviceState() == EnumIoTDeviceState.LOADING)) {
          return;
        }
        if ((EnumMsgSubscribeType.TAPO_HUB_TRIGGERED.getName().equals(this.C4)) && (localObject1 != null) && (((BaseALIoTDevice)localObject1).isHub()))
        {
          this.z4 = null;
          this.C4 = null;
          s0.g();
          localObject3 = getActivity();
          if (((BaseALIoTDevice)localObject1).isDeviceOffLine())
          {
            if (localObject3 != null) {
              s0.s((Activity)localObject3, 2131954296);
            }
            n5();
          }
          else if ((((BaseALIoTDevice)localObject1).isOnline()) && (localObject3 != null))
          {
            HubDetailActivity.K1((Context)localObject3, ((BaseALIoTDevice)localObject1).getDeviceIdMD5());
          }
          return;
        }
        int i;
        if ((!EnumNotificationMsgType.TAPO_SENSOR_FREQUENTLY_TRIGGERED.getName().equals(this.C4)) && (!EnumNotificationMsgType.TAPO_MOTION_SENSOR_TRIGGERED.getName().equals(this.C4)) && (!EnumNotificationMsgType.TAPO_CONTACT_SENSOR_TRIGGERED.getName().equals(this.C4)) && (!EnumNotificationMsgType.TAPO_SMART_BUTTON_TRIGGERED.getName().equals(this.C4))) {
          i = 0;
        } else {
          i = 1;
        }
        if ((i != 0) && (localObject1 != null) && (((BaseALIoTDevice)localObject1).isSensor()))
        {
          s0.g();
          localObject3 = getActivity();
          if (((BaseALIoTDevice)localObject1).isDeviceOffLine())
          {
            if (localObject3 != null) {
              s0.s((Activity)localObject3, 2131954296);
            }
            n5();
          }
          else if ((((BaseALIoTDevice)localObject1).isOnline()) && (localObject3 != null))
          {
            SensorDetailActivity.E1((Context)localObject3, ((BaseALIoTDevice)localObject1).getDeviceIdMD5(), this.C4);
          }
          this.z4 = null;
          this.C4 = null;
          return;
        }
        if (!(localObject1 instanceof ALCameraDevice))
        {
          this.z4 = null;
          n5();
          s0.g();
          return;
        }
        localObject2 = (ALCameraDevice)localObject1;
        if (((ALCameraDevice)localObject2).isCameraLocked())
        {
          this.z4 = null;
          s0.g();
          localObject3 = getActivity();
          if (localObject3 != null) {
            com.tplink.iot.viewmodel.home.u.f((Activity)localObject3, ((ALCameraDevice)localObject2).getLockMessage());
          }
          return;
        }
        if (((BaseALIoTDevice)localObject1).isDeviceOffLine())
        {
          this.z4 = null;
          s0.g();
          localObject3 = getActivity();
          if (localObject3 != null) {
            s0.s((Activity)localObject3, 2131954296);
          }
          n5();
          return;
        }
        this.z4 = null;
        this.C4 = null;
        q3((BaseALIoTDevice)localObject1, (String)localObject3);
      }
    }
  }
  
  private void t3()
  {
    this.c4 = this.y.findViewById(2131364808);
    this.d4 = this.y.findViewById(2131364807);
    this.e4 = this.y.findViewById(2131364809);
    TextView localTextView = (TextView)this.y.findViewById(2131363025);
    this.Y3 = localTextView;
    localTextView.setAlpha(1.0F);
    this.Y3.setClickable(true);
    this.Y3.setOnClickListener(this);
    localTextView = (TextView)this.y.findViewById(2131364414);
    this.b4 = localTextView;
    localTextView.setAlpha(1.0F);
    this.b4.setClickable(true);
    this.b4.setOnClickListener(this);
    localTextView = (TextView)this.y.findViewById(2131364532);
    this.a4 = localTextView;
    localTextView.setAlpha(1.0F);
    this.a4.setClickable(true);
    this.a4.setOnClickListener(this);
    localTextView = (TextView)this.y.findViewById(2131364599);
    this.Z3 = localTextView;
    localTextView.setAlpha(1.0F);
    this.Z3.setClickable(true);
    this.Z3.setOnClickListener(this);
  }
  
  @SuppressLint({"CheckResult"})
  private void u3()
  {
    if (getActivity() == null) {
      return;
    }
    b.a.a.a.a.a.d.a(AppContext.c).L0(io.reactivex.l0.a.c()).L(b.a.a.a.a.a.b.b(new NetworkInfo.State[] { NetworkInfo.State.CONNECTED })).L(b.a.a.a.a.a.b.c(new int[] { 0, 1 })).l0(io.reactivex.d0.b.a.a()).G0(new w());
  }
  
  private void v3()
  {
    this.z = ((RecyclerView)this.y.findViewById(2131363944));
    Object localObject = new HomeMainAdapter(getActivity());
    this.p0 = ((HomeMainAdapter)localObject);
    ((HomeMainAdapter)localObject).u(this);
    this.p0.setHasStableIds(true);
    localObject = new GridLayoutManager(getActivity(), 2);
    if (Build.VERSION.SDK_INT < 21)
    {
      ((LinearLayoutManager)localObject).setSmoothScrollbarEnabled(true);
      ((RecyclerView.LayoutManager)localObject).setAutoMeasureEnabled(true);
      this.z.setHasFixedSize(true);
      this.z.setNestedScrollingEnabled(false);
    }
    this.z.setLayoutManager((RecyclerView.LayoutManager)localObject);
    this.z.setAdapter(this.p0);
    localObject = (PullToRefreshContainer)this.y.findViewById(2131364094);
    this.T3 = ((PullToRefreshContainer)localObject);
    ((PullToRefreshContainer)localObject).setHeader(new com.tplink.iot.widget.g());
    this.T3.setEnableFooter(false);
    this.T3.setListener(new n());
    localObject = new ItemTouchHelperCallback(this.p0);
    this.m4 = ((ItemTouchHelperCallback)localObject);
    new ItemTouchHelper((ItemTouchHelper.Callback)localObject).attachToRecyclerView(this.z);
  }
  
  private void w3()
  {
    this.p1 = new HomeShortcutAdapter(getActivity());
    this.p2 = ((RecyclerView)this.y.findViewById(2131363814));
    HomeShortcutItemDecoration localHomeShortcutItemDecoration = new HomeShortcutItemDecoration(getActivity());
    this.p2.addItemDecoration(localHomeShortcutItemDecoration);
    this.p2.setLayoutManager(new LinearLayoutManager(getActivity(), 0, false));
    this.p2.setItemAnimator(new DefaultItemAnimator());
    this.p2.setAdapter(this.p1);
    this.p2.setVisibility(8);
    this.p1.q(new o());
  }
  
  private void x3()
  {
    if (getContext() != null) {
      this.l4 = com.tplink.iot.Utils.k.a(getContext(), 100.0F);
    }
    this.h4 = this.y.findViewById(2131363350);
    this.i4 = ((TextView)this.y.findViewById(2131364256));
    int i = getResources().getDisplayMetrics().widthPixels;
    this.i4.setMaxWidth(i * 3 / 5);
    Object localObject = (ImageView)this.y.findViewById(2131364254);
    this.j4 = ((ImageView)localObject);
    ((ImageView)localObject).setVisibility(8);
    localObject = (CollapsingToolbarLayout.LayoutParams)this.h4.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).setMargins(((FrameLayout.LayoutParams)localObject).leftMargin, ((FrameLayout.LayoutParams)localObject).topMargin, ((FrameLayout.LayoutParams)localObject).rightMargin, this.l4);
    this.h4.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.h4.setOnClickListener(this);
    localObject = (TextView)this.y.findViewById(2131362179);
    this.H3 = ((TextView)localObject);
    ((TextView)localObject).setVisibility(8);
    this.H3.setOnClickListener(this);
  }
  
  private void y3()
  {
    this.y.findViewById(2131363150).setOnClickListener(new p());
    View localView = this.y.findViewById(2131364695);
    localView.setVisibility(0);
    localView.setOnClickListener(new q());
    localView = this.y.findViewById(2131364817);
    if (getActivity() != null)
    {
      ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
      localLayoutParams.height = com.tplink.iot.Utils.j.b(getActivity());
      localView.setLayoutParams(localLayoutParams);
    }
  }
  
  private void z3(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.x4 = b.d.w.h.a.g(paramString);
    } else {
      this.x4 = "";
    }
  }
  
  public void J0(List<com.tplink.iot.model.home.e> paramList) {}
  
  public void O0()
  {
    View localView = this.V3;
    if (localView != null)
    {
      com.tplink.iot.Utils.x.c(localView);
      this.p0.c(false);
      this.U3.setAlpha(1.0F);
      this.U3.setVisibility(8);
      V4(true);
      if (!this.S3) {
        this.R3.V1();
      }
      this.T3.setEnableHeader(true);
      this.h4.setVisibility(0);
      this.p2.setAlpha(1.0F);
      this.p1.p(false);
      this.p3.setAlpha(1.0F);
      this.H3.setAlpha(1.0F);
      this.Q3.setAlpha(1.0F);
    }
    n5();
  }
  
  public FamilyInfo P0()
  {
    return this.R3.g();
  }
  
  public void b(final int paramInt)
  {
    this.c.post(new r(paramInt));
  }
  
  public boolean d()
  {
    if (B3())
    {
      O0();
      return true;
    }
    return super.d();
  }
  
  public void f(int paramInt1, int paramInt2)
  {
    this.R3.T0(paramInt2, this.p0.m());
    com.tplink.iot.Utils.x0.o.i();
  }
  
  public void f3()
  {
    this.R3.o0();
  }
  
  public void i(com.tplink.iot.model.home.e parame)
  {
    if ((parame instanceof com.tplink.iot.model.home.k)) {
      U0((com.tplink.iot.model.home.k)parame);
    } else if ((parame instanceof com.tplink.iot.model.home.g)) {
      V0((com.tplink.iot.model.home.g)parame);
    }
  }
  
  public void j(com.tplink.iot.model.home.e parame)
  {
    this.R3.u();
    this.m4.a(this.R3.k1());
    if (this.R3.k1())
    {
      this.Z3.setVisibility(0);
      this.b4.setVisibility(0);
      this.a4.setVisibility(0);
      this.d4.setVisibility(0);
      this.e4.setVisibility(0);
      this.c4.setVisibility(0);
    }
    else
    {
      this.Z3.setVisibility(8);
      this.b4.setVisibility(8);
      this.a4.setVisibility(8);
      this.d4.setVisibility(8);
      this.e4.setVisibility(8);
      this.c4.setVisibility(8);
    }
    V4(false);
    com.tplink.iot.Utils.x.a(this.U3);
    this.U3.setAlpha(0.8F);
    K4();
    this.T3.setEnableHeader(false);
    this.h4.setVisibility(4);
    this.p2.setAlpha(0.6F);
    this.p1.p(true);
    this.p3.setAlpha(0.6F);
    this.H3.setAlpha(0.6F);
    this.Q3.setAlpha(0.6F);
    O2();
    com.tplink.iot.Utils.x0.o.h();
  }
  
  protected void k1(String paramString)
  {
    com.tplink.iot.Utils.x0.o.p(paramString);
  }
  
  public void l(int paramInt, com.tplink.iot.model.home.e parame, boolean paramBoolean)
  {
    if ((parame instanceof com.tplink.iot.model.home.g)) {
      Y0((com.tplink.iot.model.home.g)parame, paramBoolean);
    } else if ((parame instanceof com.tplink.iot.model.home.k)) {
      X0((com.tplink.iot.model.home.k)parame, paramBoolean);
    }
  }
  
  protected void l1(BaseALIoTDevice paramBaseALIoTDevice, boolean paramBoolean)
  {
    String str = paramBaseALIoTDevice.getDeviceIdMD5();
    if (paramBaseALIoTDevice.isPlug()) {
      com.tplink.iot.Utils.x0.o.q(str, paramBoolean);
    } else if (paramBaseALIoTDevice.isBulb()) {
      com.tplink.iot.Utils.x0.o.g(str, paramBoolean);
    }
  }
  
  protected void o1()
  {
    this.c.post(new u());
  }
  
  public void onActivityCreated(@Nullable Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if (paramBundle == null) {
      this.R3.e0(false);
    } else {
      this.R3.e0(paramBundle.getBoolean("app_marketing_source", false));
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1001) {
      if (paramInt2 == -1)
      {
        String str = paramIntent.getStringExtra("REGION_CODE");
        if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(this.o4)))
        {
          com.tplink.libtpnetwork.Utils.o.h0().v0(this.o4, str);
          this.R3.l2(this.o4, this.q4, str);
        }
      }
      else if (paramInt2 == 101)
      {
        this.R3.I1();
      }
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131364599: 
      N0(this.p0.n());
      com.tplink.iot.Utils.x0.o.y(this.p0.n());
      break;
    case 2131364532: 
      L0(this.p0.n());
      com.tplink.iot.Utils.x0.o.s(this.p0.n());
      break;
    case 2131364414: 
      u1(this.p0.n());
      com.tplink.iot.Utils.x0.o.w(this.p0.n());
      break;
    case 2131364340: 
      if (!B3())
      {
        d3();
        C0(HomeAllDevicesActivity.class);
        com.tplink.iot.Utils.x0.o.f();
      }
      break;
    case 2131363350: 
      if ((!B3()) && (this.R3.k1()) && (!this.R3.h1())) {
        d5(paramView);
      }
      break;
    case 2131363025: 
      A1(this.p0.n());
      com.tplink.iot.Utils.x0.o.t(this.p0.n());
      break;
    case 2131362245: 
      C0(SelectCategoryNewActivity.class);
      break;
    case 2131362193: 
      if ((!B3()) && (this.R3.g() != null) && (this.R3.g().getId() != null))
      {
        NextEventListActivity.g1(getActivity(), this.R3.g().getId());
        com.tplink.iot.Utils.x0.o.n();
      }
      break;
    case 2131362179: 
      if (!B3())
      {
        paramView = new Intent(getContext(), CameraPreviewActivity.class);
        paramView.putExtra(CameraPreviewActivity.z.a(), this.o4);
        paramView.addFlags(67108864);
        startActivity(paramView);
        com.tplink.iot.Utils.x0.o.r();
      }
      break;
    }
  }
  
  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    super.onCreateOptionsMenu(paramMenu, paramMenuInflater);
    paramMenuInflater.inflate(2131623955, paramMenu);
    this.f4 = paramMenu.findItem(2131361904);
    this.g4 = paramMenu.findItem(2131361870);
    paramMenu = this.R3;
    if (paramMenu != null)
    {
      paramMenu = (Boolean)paramMenu.B0().getValue();
      boolean bool;
      if ((paramMenu != null) && (paramMenu.booleanValue())) {
        bool = true;
      } else {
        bool = false;
      }
      r5(bool);
      o5((Boolean)this.R3.n0().getValue());
    }
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    this.y = paramLayoutInflater.inflate(2131558729, paramViewGroup, false);
    com.tplink.iot.view.quicksetup.base.d.J(getActivity(), this.y.findViewById(2131363400));
    setHasOptionsMenu(true);
    this.R3 = ((HomeMainViewModel)ViewModelProviders.of(this).get(HomeMainViewModel.class));
    A3();
    p5(getContext());
    l5();
    M4();
    u3();
    b.d.n.f.b.l().f("tapo_pageid_home");
    return this.y;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    Object localObject = this.R3;
    if (localObject != null) {
      ((HomeMainViewModel)localObject).i2();
    }
    X2();
    localObject = this.D4;
    if (localObject != null) {
      ((io.reactivex.e0.c)localObject).dispose();
    }
    localObject = this.E4;
    if (localObject != null)
    {
      ((Dialog)localObject).dismiss();
      this.E4 = null;
    }
    localObject = this.F4;
    if (localObject != null)
    {
      ((AppCompatDialog)localObject).dismiss();
      this.F4 = null;
    }
    localObject = this.G4;
    if (localObject != null)
    {
      ((AppCompatDialog)localObject).dismiss();
      this.G4 = null;
    }
    localObject = this.H4;
    if (localObject != null)
    {
      ((AppCompatDialog)localObject).dismiss();
      this.H4 = null;
    }
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    HomeMainViewModel localHomeMainViewModel;
    if (!paramBoolean)
    {
      localHomeMainViewModel = this.R3;
      if (localHomeMainViewModel != null) {
        localHomeMainViewModel.M1();
      }
      n5();
    }
    else
    {
      localHomeMainViewModel = this.R3;
      if (localHomeMainViewModel != null) {
        localHomeMainViewModel.L1();
      }
      O2();
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (B3()) {
      return super.onOptionsItemSelected(paramMenuItem);
    }
    int i = paramMenuItem.getItemId();
    if (i != 2131361870)
    {
      if (i == 2131361904)
      {
        C0(NotificationCenterActivity.class);
        com.tplink.iot.Utils.x0.o.o();
      }
    }
    else
    {
      C0(SelectCategoryNewActivity.class);
      com.tplink.iot.Utils.x0.o.e();
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  public void onPause()
  {
    super.onPause();
    HomeMainViewModel localHomeMainViewModel = this.R3;
    if (localHomeMainViewModel != null) {
      localHomeMainViewModel.L1();
    }
    O2();
  }
  
  public void onResume()
  {
    super.onResume();
    if (!isHidden())
    {
      HomeMainViewModel localHomeMainViewModel = this.R3;
      if (localHomeMainViewModel != null) {
        localHomeMainViewModel.M1();
      }
      n5();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    S2();
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    com.tplink.iot.view.quicksetup.base.d.e(getActivity(), this.y.findViewById(2131364817));
  }
  
  protected void p1()
  {
    d3();
    if (com.tplink.libtpnetwork.Utils.o.h0().e("rate_us_time_stamp", 0L) == 0L) {
      com.tplink.libtpnetwork.Utils.o.h0().j("rate_us_time_stamp", System.currentTimeMillis());
    }
  }
  
  public void p5(Context paramContext)
  {
    if ((paramContext instanceof MainActivity))
    {
      MainActivity localMainActivity = (MainActivity)paramContext;
      String str = g3(localMainActivity);
      if ((str != null) && (this.R3 != null))
      {
        paramContext = this.D4;
        if (paramContext != null) {
          paramContext.dispose();
        }
        O2();
        s0.l(getActivity());
        this.A4 = h3(localMainActivity);
        this.C4 = j3(localMainActivity);
        this.z4 = str;
        this.B4 = i3(localMainActivity);
      }
      this.M4 = localMainActivity.g1();
      this.N4 = localMainActivity.i1();
    }
  }
  
  public void q1(List<com.tplink.iot.model.home.e> paramList)
  {
    this.R3.m(paramList);
    this.S3 = true;
    this.R3.U1(this.p0.m());
    O0();
    boolean bool1 = false;
    boolean bool2 = false;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      bool1 = false;
      while (paramList.hasNext())
      {
        com.tplink.iot.model.home.e locale = (com.tplink.iot.model.home.e)paramList.next();
        if ((locale instanceof com.tplink.iot.model.home.k)) {
          bool2 = true;
        } else if ((locale instanceof com.tplink.iot.model.home.g)) {
          bool1 = true;
        }
      }
    }
    else
    {
      bool2 = false;
    }
    com.tplink.iot.viewmodel.home.u.o(getActivity(), this.o4, bool1, bool2);
  }
  
  public void r1(List<com.tplink.iot.model.home.e> paramList)
  {
    this.S3 = true;
    this.R3.o(paramList);
  }
  
  protected void s1(boolean paramBoolean, String paramString)
  {
    this.R3.p(false, paramString);
  }
  
  protected void t1(String paramString, boolean paramBoolean)
  {
    this.R3.s(paramString, paramBoolean);
  }
  
  class a
    implements Observer<ThingNextEvent>
  {
    a() {}
    
    public void a(@Nullable ThingNextEvent paramThingNextEvent)
    {
      if ((paramThingNextEvent != null) && (!TextUtils.isEmpty(paramThingNextEvent.getThingName())))
      {
        localObject = TPIoTClientManager.I1(b.d.w.h.a.g(paramThingNextEvent.getThingName()));
        if (localObject != null)
        {
          localObject = ((BaseALIoTDevice)localObject).getDeviceRegion();
          break label39;
        }
      }
      Object localObject = null;
      label39:
      if (com.tplink.iot.Utils.t.i(paramThingNextEvent, (String)localObject))
      {
        if (com.tplink.iot.Utils.t.g(paramThingNextEvent.getNextEvent()))
        {
          HomeFragment.Y1(HomeFragment.this).setVisibility(8);
          HomeFragment.a2(HomeFragment.this).setVisibility(0);
        }
        else
        {
          HomeFragment.a2(HomeFragment.this).setVisibility(8);
          HomeFragment.Y1(HomeFragment.this).setVisibility(0);
          HomeFragment.Y1(HomeFragment.this).setTintColor(com.tplink.iot.Utils.t.c(paramThingNextEvent.getNextEvent()));
        }
        HomeFragment.b2(HomeFragment.this).setText(String.format("%s %s", new Object[] { paramThingNextEvent.getNickname(), com.tplink.iot.Utils.t.d(HomeFragment.this.getContext(), paramThingNextEvent.getNextEvent(), (String)localObject) }));
        HomeFragment.c2(HomeFragment.this);
      }
      else
      {
        HomeFragment.d2(HomeFragment.this).setVisibility(8);
      }
    }
  }
  
  class a0
    implements DialogInterface.OnDismissListener
  {
    a0() {}
    
    public void onDismiss(DialogInterface paramDialogInterface)
    {
      HomeFragment.F2(HomeFragment.this);
      HomeFragment.G2(HomeFragment.this);
    }
  }
  
  class b
    implements Observer<Boolean>
  {
    b() {}
    
    public void a(@Nullable Boolean paramBoolean)
    {
      HomeFragment.e2(HomeFragment.this).A();
    }
  }
  
  class b0
    implements TPLongMaterialDialogV2.d
  {
    b0() {}
    
    public void onClick(View paramView)
    {
      HomeFragment.K2(HomeFragment.this).J1();
      HomeFragment.this.C0(DiscoveryDeviceListActivity.class);
    }
  }
  
  class c
    implements Observer<Boolean>
  {
    c() {}
    
    public void a(@Nullable Boolean paramBoolean)
    {
      if (paramBoolean == null) {
        s0.l(HomeFragment.this.getActivity());
      } else {
        HomeFragment.f2(HomeFragment.this);
      }
    }
  }
  
  class c0
    implements TPLongMaterialDialogV2.d
  {
    c0() {}
    
    public void onClick(View paramView)
    {
      HomeFragment.K2(HomeFragment.this).J1();
      HomeFragment.G2(HomeFragment.this);
    }
  }
  
  class d
    implements Observer<RunShortCutResultBean>
  {
    d() {}
    
    public void a(@Nullable RunShortCutResultBean paramRunShortCutResultBean)
    {
      if ((paramRunShortCutResultBean != null) && (paramRunShortCutResultBean.getSmartId() != null))
      {
        if (paramRunShortCutResultBean.getCode() == 404)
        {
          s0.n(HomeFragment.this.getActivity(), 2131953955);
          HomeFragment.K2(HomeFragment.this).S1();
          return;
        }
        if (paramRunShortCutResultBean.isSuccess())
        {
          List localList = paramRunShortCutResultBean.getFailedDeviceNames();
          if ((localList != null) && (!localList.isEmpty())) {
            com.tplink.iot.view.smart.a.g.e(HomeFragment.this.getContext(), localList, HomeFragment.this.getString(2131953980), HomeFragment.this.getString(2131953979));
          }
        }
        else
        {
          s0.n(HomeFragment.this.getActivity(), 2131953328);
        }
        HomeFragment.U1(HomeFragment.this).u(paramRunShortCutResultBean);
      }
    }
  }
  
  class e
    implements Observer<Boolean>
  {
    e() {}
    
    public void a(@Nullable Boolean paramBoolean)
    {
      if (paramBoolean != null) {
        HomeFragment.g2(HomeFragment.this, paramBoolean.booleanValue());
      }
    }
  }
  
  class e0
    implements Observer<Boolean>
  {
    e0() {}
    
    public void a(@Nullable Boolean paramBoolean)
    {
      HomeFragment.O1(HomeFragment.this);
    }
  }
  
  class f
    implements Observer<Boolean>
  {
    f() {}
    
    public void a(@Nullable Boolean paramBoolean)
    {
      HomeFragment localHomeFragment = HomeFragment.this;
      boolean bool;
      if ((paramBoolean != null) && (paramBoolean.booleanValue())) {
        bool = true;
      } else {
        bool = false;
      }
      HomeFragment.h2(localHomeFragment, bool);
    }
  }
  
  class f0
    implements Observer<Boolean>
  {
    f0() {}
    
    public void a(@Nullable Boolean paramBoolean) {}
  }
  
  class g
    implements Observer<Boolean>
  {
    g() {}
    
    public void a(@Nullable Boolean paramBoolean)
    {
      HomeFragment.i2(HomeFragment.this, paramBoolean);
    }
  }
  
  class g0
    implements Observer<TCAccountBean>
  {
    g0() {}
    
    public void a(@Nullable TCAccountBean paramTCAccountBean)
    {
      if (paramTCAccountBean == null) {
        return;
      }
      b.d.c.a.e.l().d(b.d.s.a.a.e());
      b.d.c.a.e.l().a(b.d.s.a.a.d());
      b.d.n.f.b.l().a(b.d.s.a.a.d());
      HomeFragment.Z1(HomeFragment.this, paramTCAccountBean.getEmail());
      com.tplink.iot.Utils.x0.o.j();
    }
  }
  
  class h
    implements Observer<Boolean>
  {
    h() {}
    
    public void a(@Nullable Boolean paramBoolean)
    {
      HomeFragment.e2(HomeFragment.this).A();
      HomeFragment.j2(HomeFragment.this);
      HomeFragment.K2(HomeFragment.this).K1();
    }
  }
  
  class h0
    implements Observer<TCAccountBean>
  {
    h0() {}
    
    public void a(@Nullable TCAccountBean paramTCAccountBean)
    {
      if (paramTCAccountBean == null) {
        return;
      }
      HomeFragment.m2(HomeFragment.this, paramTCAccountBean.getCloudUserName());
      HomeFragment.z2(HomeFragment.this, paramTCAccountBean.getEmail());
      HomeFragment.J2(HomeFragment.this, paramTCAccountBean.getNickName());
      if (TextUtils.isEmpty(paramTCAccountBean.getCountryCode()))
      {
        paramTCAccountBean = com.tplink.libtpnetwork.Utils.o.h0().t(HomeFragment.k2(HomeFragment.this));
        if (paramTCAccountBean != null)
        {
          HomeFragment.K2(HomeFragment.this).l2(HomeFragment.k2(HomeFragment.this), HomeFragment.I2(HomeFragment.this), paramTCAccountBean);
        }
        else
        {
          paramTCAccountBean = new Intent(HomeFragment.this.getActivity(), CloudRegionChooseActivity.class);
          paramTCAccountBean.putExtra("REGION_CODE", com.tplink.iot.Utils.login.a.b(HomeFragment.this.getActivity()));
          paramTCAccountBean.putExtra("args_is_from_dashboard", true);
          HomeFragment.this.startActivityForResult(paramTCAccountBean, 1001);
        }
      }
      else if ((!TextUtils.isEmpty(HomeFragment.k2(HomeFragment.this))) && (!TextUtils.isEmpty(HomeFragment.x2(HomeFragment.this))))
      {
        HomeFragment.L2(HomeFragment.this, paramTCAccountBean);
      }
    }
  }
  
  class i
    implements Observer<Boolean>
  {
    i() {}
    
    public void a(@Nullable Boolean paramBoolean)
    {
      HomeFragment localHomeFragment = HomeFragment.this;
      boolean bool;
      if ((paramBoolean != null) && (paramBoolean.booleanValue())) {
        bool = true;
      } else {
        bool = false;
      }
      HomeFragment.l2(localHomeFragment, bool);
    }
  }
  
  class i0
    implements Observer<List<com.tplink.iot.model.home.e>>
  {
    i0() {}
    
    public void a(@Nullable List<com.tplink.iot.model.home.e> paramList)
    {
      HomeFragment.M2(HomeFragment.this).t(paramList);
      HomeFragment.N2(HomeFragment.this, paramList);
    }
  }
  
  class j
    implements Observer<Boolean>
  {
    j() {}
    
    public void a(@Nullable Boolean paramBoolean) {}
  }
  
  class j0
    implements Observer<List<com.tplink.iot.model.home.e>>
  {
    j0() {}
    
    public void a(@Nullable List<com.tplink.iot.model.home.e> paramList)
    {
      if (HomeFragment.P1(HomeFragment.this)) {
        return;
      }
      HomeFragment.Q1(HomeFragment.this);
      HomeFragment.M2(HomeFragment.this).s(paramList);
      HomeFragment.N2(HomeFragment.this, paramList);
      HomeFragment.R1(HomeFragment.this, paramList);
      HomeFragment.S1(HomeFragment.this, paramList);
      HomeFragment.T1(HomeFragment.this);
    }
  }
  
  class k
    implements Observer<EnumHomeState>
  {
    k() {}
    
    public void a(@Nullable EnumHomeState paramEnumHomeState)
    {
      HomeFragment.N1(HomeFragment.this, paramEnumHomeState);
    }
  }
  
  class k0
    implements Observer<List<SmartInfo>>
  {
    k0() {}
    
    public void a(@Nullable List<SmartInfo> paramList)
    {
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        HomeShortcutAdapter localHomeShortcutAdapter = HomeFragment.U1(HomeFragment.this);
        HomeFragment localHomeFragment = HomeFragment.this;
        localHomeShortcutAdapter.t(HomeFragment.V1(localHomeFragment, paramList, HomeFragment.U1(localHomeFragment).o()));
        HomeFragment.W1(HomeFragment.this);
      }
      else
      {
        HomeFragment.U1(HomeFragment.this).t(new ArrayList());
        HomeFragment.X1(HomeFragment.this).setVisibility(8);
      }
    }
  }
  
  class l
    implements Observer<Integer>
  {
    l() {}
    
    public void a(Integer paramInteger)
    {
      if ((paramInteger != null) && ((paramInteger.intValue() == 1) || (paramInteger.intValue() == 2))) {
        HomeFragment.n2(HomeFragment.this, paramInteger.intValue());
      }
    }
  }
  
  private class l0
    extends WebViewClient
  {
    private String a;
    
    l0(String paramString)
    {
      this.a = paramString;
    }
    
    public void onPageFinished(WebView paramWebView, String paramString)
    {
      b.d.w.c.a.c(HomeFragment.H2(HomeFragment.this), paramString);
      b.d.w.c.a.a("onPageFinished");
      super.onPageFinished(paramWebView, paramString);
      if (HomeFragment.K2(HomeFragment.this) != null) {
        HomeFragment.K2(HomeFragment.this).Y1();
      }
    }
    
    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      b.d.w.c.a.c(HomeFragment.H2(HomeFragment.this), paramString);
      b.d.w.c.a.a("onPageStarted");
      super.onPageStarted(paramWebView, paramString, paramBitmap);
    }
    
    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      b.d.w.c.a.c(HomeFragment.H2(HomeFragment.this), paramString);
      if (TextUtils.equals(paramString, this.a)) {
        return super.shouldOverrideUrlLoading(paramWebView, paramString);
      }
      b.d.w.f.a.i(HomeFragment.this.getContext(), paramString);
      return true;
    }
  }
  
  class m
    implements AppBarLayout.OnOffsetChangedListener
  {
    m() {}
    
    public void onOffsetChanged(AppBarLayout paramAppBarLayout, int paramInt)
    {
      if (HomeFragment.o2(HomeFragment.this) == paramInt) {
        return;
      }
      HomeFragment.p2(HomeFragment.this, paramInt);
      int i = paramAppBarLayout.getTotalScrollRange();
      float f = (float)(Math.abs(paramInt) * 1.0D / i);
      if (HomeFragment.e2(HomeFragment.this) != null)
      {
        paramInt = (int)((1.0F - f) * HomeFragment.q2(HomeFragment.this));
        paramAppBarLayout = (CoordinatorLayout.LayoutParams)HomeFragment.e2(HomeFragment.this).getLayoutParams();
        paramAppBarLayout.setMargins(0, -paramInt, 0, 0);
        HomeFragment.e2(HomeFragment.this).setLayoutParams(paramAppBarLayout);
      }
      if (HomeFragment.r2(HomeFragment.this) != null)
      {
        HomeFragment.s2(HomeFragment.this).setTextSize(2, 24.0F - 4.0F * f);
        paramInt = (int)((1.0F - f) * HomeFragment.t2(HomeFragment.this));
        paramAppBarLayout = (CollapsingToolbarLayout.LayoutParams)HomeFragment.r2(HomeFragment.this).getLayoutParams();
        paramAppBarLayout.setMargins(paramAppBarLayout.leftMargin, paramAppBarLayout.topMargin, paramAppBarLayout.rightMargin, paramInt);
        HomeFragment.r2(HomeFragment.this).setLayoutParams(paramAppBarLayout);
      }
    }
  }
  
  class n
    implements PullToRefreshContainer.e
  {
    n() {}
    
    public void a() {}
    
    public void onRefresh()
    {
      HomeFragment.K2(HomeFragment.this).R1();
    }
  }
  
  class o
    implements HomeShortcutAdapter.c
  {
    o() {}
    
    public void a(View paramView, int paramInt, String paramString)
    {
      if (!HomeFragment.P1(HomeFragment.this))
      {
        HomeFragment.K2(HomeFragment.this).W1(paramString);
        com.tplink.iot.Utils.x0.o.x();
      }
    }
  }
  
  class p
    implements View.OnClickListener
  {
    p() {}
    
    public void onClick(View paramView)
    {
      HomeFragment.this.O0();
    }
  }
  
  class q
    implements View.OnClickListener
  {
    q() {}
    
    public void onClick(View paramView)
    {
      HomeFragment.u2(HomeFragment.this);
    }
  }
  
  class r
    implements Runnable
  {
    r(int paramInt) {}
    
    public void run()
    {
      HomeFragment.v2(HomeFragment.this).setText(HomeFragment.this.getResources().getString(2131952843, new Object[] { Integer.valueOf(paramInt) }));
      HomeFragment.w2(HomeFragment.this);
    }
  }
  
  class s
    implements y.c
  {
    s(List paramList) {}
    
    public void a(View paramView, int paramInt)
    {
      if ((paramInt >= 0) && (paramInt < localObject1.size())) {
        HomeFragment.y2(HomeFragment.this, (HomeFamilySelectBean)localObject1.get(paramInt));
      }
    }
    
    public void b(View paramView)
    {
      if (localObject1.size() == 1)
      {
        paramView = new Intent(HomeFragment.this.getActivity(), FamilyDetailActivity.class);
        paramView.putExtra("args_key_need_add_home", true);
        HomeFragment.this.startActivity(paramView);
      }
      else
      {
        HomeFragment.this.C0(FamilyListActivity.class);
      }
      com.tplink.iot.Utils.x0.o.l();
    }
  }
  
  class t
    implements PopupWindow.OnDismissListener
  {
    t() {}
    
    public void onDismiss()
    {
      ObjectAnimator.ofFloat(HomeFragment.A2(HomeFragment.this), View.ROTATION.getName(), new float[] { -180.0F, 0.0F }).start();
    }
  }
  
  class u
    implements Runnable
  {
    u() {}
    
    public void run()
    {
      HomeFragment.M2(HomeFragment.this).notifyDataSetChanged();
    }
  }
  
  class v
    implements Observer<FamilyInfo>
  {
    v() {}
    
    public void a(@Nullable FamilyInfo paramFamilyInfo)
    {
      HomeFragment.O1(HomeFragment.this);
    }
  }
  
  class w
    implements io.reactivex.g0.g<b.a.a.a.a.a.a>
  {
    w() {}
    
    public void a(b.a.a.a.a.a.a parama)
      throws Exception
    {
      if (parama == null) {
        return;
      }
      if ((HomeFragment.B2(HomeFragment.this) != null) && ((HomeFragment.B2(HomeFragment.this).i() != 0) || (parama.i() != 0)))
      {
        HomeFragment.C2(HomeFragment.this, parama);
        if (HomeFragment.K2(HomeFragment.this) == null) {
          return;
        }
        if (HomeFragment.K2(HomeFragment.this).l1())
        {
          HomeFragment.K2(HomeFragment.this).P1();
          LiveMediaAPI.onNetworkChanged();
          LiveMediaAPI.destroyAllDoubleTalkClient();
        }
        else if ((HomeFragment.K2(HomeFragment.this).g1()) && (parama.i() == 0))
        {
          HomeFragment.K2(HomeFragment.this).T1();
        }
      }
      else
      {
        HomeFragment.C2(HomeFragment.this, parama);
      }
    }
  }
  
  class x
    implements TPMaterialDialogV2.c
  {
    x() {}
    
    public void a(final TPMaterialDialogV2 paramTPMaterialDialogV2, View paramView)
    {
      ((TextView)paramView.findViewById(2131364654)).setText(2131952080);
      ((TextView)paramView.getRootView().findViewById(2131364326)).setOnClickListener(new a(paramTPMaterialDialogV2));
      ((TextView)paramView.findViewById(2131364553)).setOnClickListener(new b(paramTPMaterialDialogV2));
    }
    
    class a
      implements View.OnClickListener
    {
      a(TPMaterialDialogV2 paramTPMaterialDialogV2) {}
      
      public void onClick(View paramView)
      {
        HomeFragment.K2(HomeFragment.this).u2(HomeFragment.x2(HomeFragment.this), true);
        paramView = paramTPMaterialDialogV2;
        if (paramView != null) {
          paramView.dismiss();
        }
      }
    }
    
    class b
      implements View.OnClickListener
    {
      b(TPMaterialDialogV2 paramTPMaterialDialogV2) {}
      
      public void onClick(View paramView)
      {
        paramView = paramTPMaterialDialogV2;
        if (paramView != null) {
          paramView.dismiss();
        }
      }
    }
  }
  
  class y
    implements io.reactivex.g0.g<CloudVideo>
  {
    y(String paramString1, String paramString2) {}
    
    public void a(CloudVideo paramCloudVideo)
      throws Exception
    {
      if (paramCloudVideo == null)
      {
        HomeFragment.D2(HomeFragment.this, b.d.w.h.a.g(paramString1), paramString2);
      }
      else
      {
        s0.g();
        HomeFragment.E2(HomeFragment.this, paramCloudVideo, paramString1);
      }
    }
  }
  
  class z
    implements View.OnClickListener
  {
    z() {}
    
    public void onClick(View paramView)
    {
      b.d.w.c.a.a("dismissAppMarketingPage close");
      HomeFragment.F2(HomeFragment.this);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\home\HomeFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */