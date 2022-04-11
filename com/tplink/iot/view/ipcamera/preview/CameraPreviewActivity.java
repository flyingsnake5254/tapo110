package com.tplink.iot.view.ipcamera.preview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.activity.ComponentActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.State;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.Utils.TPMaterialDialogV2.d;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.x0.w;
import com.tplink.iot.adapter.databinding.DataBindingListAdapter;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.cloud.bean.cloudvideo.common.OrderInfo;
import com.tplink.iot.core.AppContext;
import com.tplink.iot.databinding.ActivityCameraPreviewBinding;
import com.tplink.iot.databinding.ActivityCameraPreviewModePartBinding;
import com.tplink.iot.view.ipcamera.preview.mode.ModeSettingActivity;
import com.tplink.iot.view.ipcamera.preview.mode.ModeSettingActivity.a;
import com.tplink.iot.view.ipcamera.preview.mode.f;
import com.tplink.iot.view.ipcamera.setting.z4;
import com.tplink.iot.view.tapocare.BillingActivity;
import com.tplink.iot.viewmodel.cloudvideo.CloudVideoViewModel;
import com.tplink.iot.viewmodel.ipcamera.CameraPreviewViewModel;
import com.tplink.iot.widget.UniversalDialog;
import com.tplink.iot.widget.UniversalDialog.a;
import com.tplink.iot.widget.UniversalDialog.b;
import com.tplink.iot.widget.UniversalDialog.c;
import com.tplink.iot.widget.springview.widget.PullToRefreshContainer;
import com.tplink.iot.widget.springview.widget.PullToRefreshContainer.e;
import com.tplink.libmediaapi.live.LiveMediaAPI;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.Utils.o;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import com.tplink.libtpnetwork.cameranetwork.bean.CameraAvatarInfo;
import com.tplink.libtpnetwork.cameranetwork.util.JsonUtils;
import com.tplink.libtpnetwork.enumerate.EnumIoTDeviceState;
import io.reactivex.q;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

public final class CameraPreviewActivity
  extends BaseActivity
{
  private static final String y = "currentUserName";
  public static final a z = new a(null);
  private String H3;
  private final MutableLiveData<Boolean> I3;
  private final MutableLiveData<Boolean> J3;
  private final MutableLiveData<Boolean> K3;
  private final ArrayList<String> L3;
  private final ArrayList<CameraPreviewInfo> M3;
  private final ArrayList<d> N3;
  private final String O3;
  private final String P3;
  private final String Q3;
  private final HashMap<String, CameraPreviewInfo> R3;
  private DataBindingListAdapter S3;
  private final io.reactivex.e0.b T3;
  private b.a.a.a.a.a.a U3;
  private UniversalDialog V3;
  private UniversalDialog W3;
  private UniversalDialog X3;
  private RecyclerView Y3;
  private ActivityCameraPreviewBinding Z3;
  private HashMap a4;
  private final int p0 = 100;
  public CameraPreviewViewModel p1;
  public CloudVideoViewModel p2;
  private ArrayList<String> p3;
  
  public CameraPreviewActivity()
  {
    MutableLiveData localMutableLiveData = new MutableLiveData();
    Object localObject1 = Boolean.TRUE;
    localMutableLiveData.setValue(localObject1);
    Object localObject2 = kotlin.p.a;
    this.I3 = localMutableLiveData;
    localObject2 = new MutableLiveData();
    ((MutableLiveData)localObject2).setValue(localObject1);
    this.J3 = ((MutableLiveData)localObject2);
    localObject1 = new MutableLiveData();
    ((MutableLiveData)localObject1).setValue(Boolean.FALSE);
    this.K3 = ((MutableLiveData)localObject1);
    this.L3 = new ArrayList();
    this.M3 = new ArrayList();
    this.N3 = new ArrayList();
    this.O3 = "mode_loading_tag";
    this.P3 = "mode_fail_tag";
    this.Q3 = "mode_success_tag";
    this.R3 = new HashMap();
    this.T3 = new io.reactivex.e0.b();
  }
  
  private final void J1()
  {
    UniversalDialog localUniversalDialog = this.W3;
    if (localUniversalDialog != null) {
      localUniversalDialog.dismissAllowingStateLoss();
    }
    this.W3 = null;
    this.Y3 = null;
  }
  
  private final void K1()
  {
    UniversalDialog localUniversalDialog = this.X3;
    if (localUniversalDialog != null) {
      localUniversalDialog.dismissAllowingStateLoss();
    }
    this.X3 = null;
  }
  
  private final void L1()
  {
    UniversalDialog localUniversalDialog = this.V3;
    if (localUniversalDialog != null) {
      localUniversalDialog.dismissAllowingStateLoss();
    }
    this.V3 = null;
  }
  
  private final int M1()
  {
    Iterator localIterator = this.N3.iterator();
    for (int i = 0; localIterator.hasNext(); i++)
    {
      label10:
      d locald = (d)localIterator.next();
      if ((locald.d().m()) && (!locald.c())) {
        break label10;
      }
    }
    return i;
  }
  
  private final ArrayList<String> N1(boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    Object localObject;
    if (paramBoolean) {
      localObject = (HashSet)o.M();
    } else {
      localObject = (HashSet)o.x();
    }
    if (localObject == null) {
      paramArrayList.clear();
    } else {
      for (i = paramArrayList.size() - 1; i >= 0; i--) {
        if (!((HashSet)localObject).contains(paramArrayList.get(i))) {
          paramArrayList.remove(i);
        }
      }
    }
    for (int i = paramArrayList.size() - 1; i >= 0; i--)
    {
      localObject = TPIoTClientManager.K1((String)paramArrayList.get(i));
      j.d(localObject, "TPIoTClientManager.getCa…ntext(deviceIdMD5List[i])");
      localObject = (ALCameraDevice)((TPBaseDeviceContext)localObject).getCameraDevice();
      if ((localObject == null) || (((BaseALIoTDevice)localObject).isUserRoleTypeDevice())) {
        paramArrayList.remove(i);
      }
    }
    return paramArrayList;
  }
  
  private final String Q1(boolean paramBoolean)
  {
    int i = this.N3.size();
    int j = M1();
    int k = 2131953325;
    int m = 2131954108;
    Object localObject1 = Integer.valueOf(0);
    Object localObject2 = Integer.valueOf(1);
    if (i == 1)
    {
      StringBuilder localStringBuilder;
      if (j == 0)
      {
        localStringBuilder = new StringBuilder();
        if (!paramBoolean) {
          k = 2131953324;
        }
        localStringBuilder.append(getString(k, new Object[] { localObject2 }));
        localStringBuilder.append(" ");
        localStringBuilder.append(getString(2131954106, new Object[] { localObject1 }));
        localObject2 = localStringBuilder.toString();
      }
      else
      {
        localStringBuilder = new StringBuilder();
        if (!paramBoolean) {
          m = 2131954107;
        }
        localStringBuilder.append(getString(m, new Object[] { localObject1 }));
        localStringBuilder.append(" ");
        localStringBuilder.append(getString(2131953323, new Object[] { localObject2 }));
        localObject2 = localStringBuilder.toString();
      }
      return (String)localObject2;
    }
    if ((i == 2) && (j == 1))
    {
      localObject1 = new StringBuilder();
      if (!paramBoolean) {
        k = 2131953324;
      }
      ((StringBuilder)localObject1).append(getString(k, new Object[] { localObject2 }));
      ((StringBuilder)localObject1).append(" ");
      ((StringBuilder)localObject1).append(getString(2131953323, new Object[] { localObject2 }));
      return ((StringBuilder)localObject1).toString();
    }
    if (j == 1)
    {
      localObject1 = new StringBuilder();
      if (!paramBoolean) {
        m = 2131954107;
      }
      ((StringBuilder)localObject1).append(getString(m, new Object[] { Integer.valueOf(i - j) }));
      ((StringBuilder)localObject1).append(" ");
      ((StringBuilder)localObject1).append(getString(2131953323, new Object[] { localObject2 }));
      localObject2 = ((StringBuilder)localObject1).toString();
    }
    else if (j == i - 1)
    {
      localObject1 = new StringBuilder();
      if (!paramBoolean) {
        k = 2131953324;
      }
      ((StringBuilder)localObject1).append(getString(k, new Object[] { localObject2 }));
      ((StringBuilder)localObject1).append(" ");
      ((StringBuilder)localObject1).append(getString(2131954106, new Object[] { Integer.valueOf(j) }));
      localObject2 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject2 = new StringBuilder();
      if (!paramBoolean) {
        m = 2131954107;
      }
      ((StringBuilder)localObject2).append(getString(m, new Object[] { Integer.valueOf(i - j) }));
      ((StringBuilder)localObject2).append(" ");
      ((StringBuilder)localObject2).append(getString(2131954106, new Object[] { Integer.valueOf(j) }));
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    return (String)localObject2;
  }
  
  private final void R1()
  {
    Object localObject = ViewModelProviders.of(this).get(CameraPreviewViewModel.class);
    j.d(localObject, "ViewModelProviders.of(th…iewViewModel::class.java)");
    this.p1 = ((CameraPreviewViewModel)localObject);
    localObject = ViewModelProviders.of(this).get(CloudVideoViewModel.class);
    j.d(localObject, "ViewModelProviders.of(th…deoViewModel::class.java)");
    this.p2 = ((CloudVideoViewModel)localObject);
    localObject = CameraPreviewSortActivity.p0;
    localObject = new b.d.w.g.a(this, ((CameraPreviewSortActivity.a)localObject).a()).f(((CameraPreviewSortActivity.a)localObject).b(), "");
    j.d(localObject, "string");
    int i;
    if (((CharSequence)localObject).length() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      localObject = new ArrayList();
    }
    else
    {
      localObject = (ArrayList)JsonUtils.a((String)localObject, ArrayList.class);
      if (localObject == null) {
        localObject = new ArrayList();
      }
    }
    this.p3 = ((ArrayList)localObject);
    localObject = getIntent();
    if (localObject != null)
    {
      localObject = ((Intent)localObject).getExtras();
      if (localObject != null)
      {
        localObject = ((Bundle)localObject).get(y);
        break label178;
      }
    }
    localObject = null;
    label178:
    this.H3 = String.valueOf(localObject);
  }
  
  private final void S1()
  {
    io.reactivex.e0.c localc = b.a.a.a.a.a.d.a(AppContext.c).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).G0(new b(this));
    this.T3.b(localc);
  }
  
  private final void T1()
  {
    Object localObject1 = DataBindingUtil.setContentView(this, 2131558473);
    Object localObject2 = (ActivityCameraPreviewBinding)localObject1;
    ((ViewDataBinding)localObject2).setLifecycleOwner(this);
    ((ActivityCameraPreviewBinding)localObject2).i(this.I3);
    ((ActivityCameraPreviewBinding)localObject2).l(this.J3);
    ((ActivityCameraPreviewBinding)localObject2).h(this.K3);
    Object localObject3 = new c(this);
    d locald = new d(this);
    ((ActivityCameraPreviewBinding)localObject2).f.d.setOnClickListener((View.OnClickListener)localObject3);
    ((ActivityCameraPreviewBinding)localObject2).f.c.setOnClickListener((View.OnClickListener)localObject3);
    ((ActivityCameraPreviewBinding)localObject2).f.q.setOnClickListener(locald);
    ((ActivityCameraPreviewBinding)localObject2).f.f.setOnClickListener(locald);
    localObject3 = kotlin.p.a;
    j.d(localObject1, "DataBindingUtil.setConte…ckListener)\n            }");
    this.Z3 = ((ActivityCameraPreviewBinding)localObject2);
    c1(getString(2131952038));
    int i = com.tplink.iot.adapter.databinding.a.b;
    int j = com.tplink.iot.adapter.databinding.a.c;
    int k = com.tplink.iot.adapter.databinding.a.b;
    localObject1 = this.L3;
    localObject2 = this.M3;
    this.S3 = new DataBindingListAdapter(2131559003, new int[] { i, j }, new int[] { k }, new Object[] { localObject1, localObject2 });
    localObject2 = (RecyclerView)e1(com.tplink.iot.a.recyclerView);
    j.d(localObject2, "recyclerView");
    localObject1 = this.S3;
    if (localObject1 == null) {
      j.t("recyclerViewAdapter");
    }
    ((RecyclerView)localObject2).setAdapter((RecyclerView.Adapter)localObject1);
    localObject2 = (PullToRefreshContainer)e1(com.tplink.iot.a.refresh_container);
    ((PullToRefreshContainer)localObject2).setHeader(new com.tplink.iot.widget.g());
    ((PullToRefreshContainer)localObject2).setEnableFooter(false);
    ((PullToRefreshContainer)localObject2).setListener(new e(this));
    localObject2 = new g(this);
    e1(com.tplink.iot.a.ll_preview_cloud_video_server).setOnClickListener((View.OnClickListener)localObject2);
    ((ImageView)e1(com.tplink.iot.a.iv_cloud_service_close)).setOnClickListener(new f(this));
  }
  
  private final Calendar U1(long paramLong, TimeZone paramTimeZone)
  {
    Calendar localCalendar = Calendar.getInstance();
    j.d(localCalendar, "Calendar.getInstance()");
    localCalendar.setTimeZone(paramTimeZone);
    localCalendar.setTimeInMillis(paramLong * 'Ϩ');
    return localCalendar;
  }
  
  private final void V1(final boolean paramBoolean, final ArrayList<String> paramArrayList)
  {
    for (final int i = paramArrayList.size() - 1; i >= 0; i--)
    {
      localObject = TPIoTClientManager.K1((String)paramArrayList.get(i));
      j.d(localObject, "TPIoTClientManager.getCa…ntext(deviceIdMD5List[i])");
      localObject = (ALCameraDevice)((TPBaseDeviceContext)localObject).getCameraDevice();
      if ((localObject == null) || (((BaseALIoTDevice)localObject).isUserRoleTypeDevice())) {
        paramArrayList.remove(i);
      }
    }
    i = paramArrayList.size();
    if (i == 0) {
      return;
    }
    b2(paramArrayList.size());
    ArrayList localArrayList1 = new ArrayList();
    final ArrayList localArrayList2 = new ArrayList();
    e2(paramArrayList, localArrayList1, localArrayList2);
    Object localObject = new j(this, i);
    paramArrayList = new k(this, localArrayList2, paramBoolean, paramArrayList);
    f.c.h(localArrayList1, paramBoolean, (kotlin.jvm.b.l)localObject, paramArrayList);
  }
  
  private final void W1(final int paramInt, final boolean paramBoolean1, final String paramString, final boolean paramBoolean2)
  {
    Object localObject = this.Y3;
    if (localObject != null)
    {
      localObject = ((RecyclerView)localObject).getLayoutManager();
      if (localObject != null)
      {
        localObject = ((RecyclerView.LayoutManager)localObject).findViewByPosition(paramInt);
        break label37;
      }
    }
    localObject = null;
    label37:
    Objects.requireNonNull(localObject, "null cannot be cast to non-null type android.view.ViewGroup");
    localObject = ((ViewGroup)localObject).getChildAt(5);
    Objects.requireNonNull(localObject, "null cannot be cast to non-null type android.widget.ImageView");
    final ImageView localImageView = (ImageView)localObject;
    d2(true, localImageView);
    localObject = kotlin.collections.l.b(paramString);
    l locall = new l(this, paramBoolean1);
    paramString = new m(this, paramBoolean2, paramInt, paramString, localImageView, paramBoolean1);
    f.c.h((List)localObject, paramBoolean1, locall, paramString);
  }
  
  private final void X1(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.M3.iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(((CameraPreviewInfo)((Iterator)localObject).next()).d());
    }
    for (int i = localArrayList.size() - 1; i >= 0; i--)
    {
      localObject = TPIoTClientManager.K1((String)localArrayList.get(i));
      j.d(localObject, "TPIoTClientManager.getCa…ntext(deviceIdMD5List[i])");
      localObject = (ALCameraDevice)((TPBaseDeviceContext)localObject).getCameraDevice();
      if ((localObject == null) || (((BaseALIoTDevice)localObject).isUserRoleTypeDevice())) {
        localArrayList.remove(i);
      }
    }
    if (paramBoolean)
    {
      o.S0(new HashSet(localArrayList));
      o.O0();
    }
    else
    {
      o.z0(new HashSet(localArrayList));
      o.N0();
    }
  }
  
  private final void Y1()
  {
    o.h0().c1(false);
    new TPMaterialDialogV2.Builder(this).i(2131952815, 2131099799).o(2131952441, 2131099808, null).b(false).c(false).g(8, 8).y();
  }
  
  private final void Z1(final boolean paramBoolean, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
  {
    J1();
    this.N3.clear();
    Object localObject1 = paramArrayList2.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      paramArrayList2 = this.N3;
      localObject2 = (CameraPreviewInfo)this.R3.get(localObject2);
      if (localObject2 != null)
      {
        j.d(localObject2, "cameraPreviewInfoMap[deviceIdMD5] ?: continue");
        paramArrayList2.add(new d((CameraPreviewInfo)localObject2, false));
      }
    }
    paramArrayList2 = paramArrayList1.iterator();
    for (;;)
    {
      if (!paramArrayList2.hasNext()) {
        break label167;
      }
      localObject2 = (String)paramArrayList2.next();
      paramArrayList1 = this.N3.iterator();
      if (paramArrayList1.hasNext())
      {
        localObject1 = (d)paramArrayList1.next();
        if (!j.a(((d)localObject1).d().d(), localObject2)) {
          break;
        }
        ((d)localObject1).e(true);
      }
    }
    label167:
    paramArrayList1 = new Lambda(paramBoolean)
    {
      public final void a(View paramAnonymousView)
      {
        j.e(paramAnonymousView, "it");
        CameraPreviewActivity.A1(this.c, (RecyclerView)paramAnonymousView.findViewById(2131363820));
        paramAnonymousView = CameraPreviewActivity.n1(this.c);
        if (paramAnonymousView != null) {
          paramAnonymousView.setLayoutManager(new LinearLayoutManager(this.c) {});
        }
        paramAnonymousView = new a(this);
        RecyclerView localRecyclerView = CameraPreviewActivity.n1(this.c);
        int i;
        if (localRecyclerView != null)
        {
          i = com.tplink.iot.adapter.databinding.a.p;
          int j = com.tplink.iot.adapter.databinding.a.o;
          localObject = CameraPreviewActivity.m1(this.c);
          localRecyclerView.setAdapter(new DataBindingListAdapter(2131559039, new int[] { i, j }, new int[0], new Object[] { localObject, paramAnonymousView }));
        }
        paramAnonymousView = CameraPreviewActivity.n1(this.c);
        if (paramAnonymousView != null) {
          paramAnonymousView = paramAnonymousView.getLayoutParams();
        } else {
          paramAnonymousView = null;
        }
        if (CameraPreviewActivity.m1(this.c).size() > 3)
        {
          i = b.d.w.f.a.a(this.c, 80.0F);
          if (paramAnonymousView != null) {
            paramAnonymousView.height = (i * 3);
          }
        }
        Object localObject = CameraPreviewActivity.n1(this.c);
        if (localObject != null) {
          ((ViewGroup)localObject).setLayoutParams(paramAnonymousView);
        }
      }
      
      static final class a
        implements com.tplink.iot.adapter.databinding.d
      {
        a(CameraPreviewActivity.showModeActivateFailDialog.dialogInit.1 param1) {}
        
        public final void a(View paramView, int paramInt)
        {
          paramView = this.a;
          CameraPreviewActivity localCameraPreviewActivity = paramView.c;
          CameraPreviewActivity.z1(localCameraPreviewActivity, paramInt, paramView.d, ((d)CameraPreviewActivity.m1(localCameraPreviewActivity).get(paramInt)).d().d(), ((d)CameraPreviewActivity.m1(this.a.c).get(paramInt)).d().m());
        }
      }
    };
    paramArrayList1 = new UniversalDialog.a().p(2131558792, new c(paramArrayList1)).q(Q1(paramBoolean)).u(getString(2131954363)).s(getString(2131952413)).t(new n(this, paramBoolean)).r(new o(this)).m(true).l();
    this.W3 = paramArrayList1;
    if (paramArrayList1 != null) {
      paramArrayList1.setCancelable(false);
    }
    paramArrayList2 = getSupportFragmentManager().beginTransaction();
    j.d(paramArrayList2, "supportFragmentManager.beginTransaction()");
    paramArrayList1 = this.W3;
    j.c(paramArrayList1);
    paramArrayList2.add(paramArrayList1, this.P3);
    paramArrayList2.commitAllowingStateLoss();
  }
  
  private final void a2(boolean paramBoolean)
  {
    K1();
    Object localObject = new UniversalDialog.a().o(2131558794);
    int i;
    if (paramBoolean) {
      i = 2131951888;
    } else {
      i = 2131951868;
    }
    localObject = ((UniversalDialog.a)localObject).q(getString(2131953087, new Object[] { getString(i) })).s(getString(2131951761)).r(new p(this)).l();
    this.X3 = ((UniversalDialog)localObject);
    if (localObject != null) {
      ((DialogFragment)localObject).setCancelable(false);
    }
    FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
    j.d(localFragmentTransaction, "supportFragmentManager.beginTransaction()");
    localObject = this.X3;
    j.c(localObject);
    localFragmentTransaction.add((Fragment)localObject, this.Q3);
    localFragmentTransaction.commitAllowingStateLoss();
    com.tplink.iot.Utils.x0.e.r();
  }
  
  private final void b2(int paramInt)
  {
    int i;
    if (paramInt == 1) {
      i = 2131952836;
    } else {
      i = 2131952810;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("0/");
    ((StringBuilder)localObject1).append(paramInt);
    localObject1 = getString(i, new Object[] { ((StringBuilder)localObject1).toString() });
    j.d(localObject1, "getString(if (cameraNum …          \"0/$cameraNum\")");
    Object localObject2 = this.V3;
    if (localObject2 != null) {
      ((UniversalDialog)localObject2).J0((String)localObject1);
    }
    if (this.V3 == null)
    {
      localObject1 = new UniversalDialog.a().o(2131558793).q((String)localObject1).l();
      this.V3 = ((UniversalDialog)localObject1);
      if (localObject1 != null) {
        ((DialogFragment)localObject1).setCancelable(false);
      }
    }
    localObject2 = getSupportFragmentManager().beginTransaction();
    j.d(localObject2, "supportFragmentManager.beginTransaction()");
    localObject1 = this.V3;
    if (localObject1 != null) {
      localObject1 = Boolean.valueOf(((Fragment)localObject1).isAdded());
    } else {
      localObject1 = null;
    }
    if (!org.apache.commons.lang.b.b((Boolean)localObject1))
    {
      localObject1 = this.V3;
      j.c(localObject1);
      ((FragmentTransaction)localObject2).add((Fragment)localObject1, this.O3);
    }
    ((FragmentTransaction)localObject2).commitAllowingStateLoss();
  }
  
  private final void c2(final boolean paramBoolean)
  {
    new TPMaterialDialogV2.Builder(this).i(2131952812, 2131099799).o(2131952803, 2131099808, new q(this, paramBoolean)).l(2131951757, 2131099808, null).b(false).c(false).g(8, 8).y();
  }
  
  private final void d2(boolean paramBoolean, ImageView paramImageView)
  {
    if (paramBoolean) {
      paramImageView.startAnimation(AnimationUtils.loadAnimation(this, 2130771982));
    } else {
      paramImageView.clearAnimation();
    }
    paramImageView.setEnabled(paramBoolean ^ true);
  }
  
  private final void e2(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, ArrayList<String> paramArrayList3)
  {
    Iterator localIterator = paramArrayList1.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramArrayList1 = (CameraPreviewInfo)this.R3.get(str);
      if ((paramArrayList1 != null) && (paramArrayList1.m() == true)) {
        paramArrayList1 = paramArrayList2;
      } else {
        paramArrayList1 = paramArrayList3;
      }
      paramArrayList1.add(str);
    }
  }
  
  private final void f2()
  {
    CameraPreviewViewModel localCameraPreviewViewModel = this.p1;
    if (localCameraPreviewViewModel == null) {
      j.t("cameraPreviewViewModel");
    }
    localCameraPreviewViewModel.h().observe(this, new r(this));
    localCameraPreviewViewModel = this.p1;
    if (localCameraPreviewViewModel == null) {
      j.t("cameraPreviewViewModel");
    }
    localCameraPreviewViewModel.i().observe(this, new s(this));
  }
  
  private final String g2(ALCameraDevice paramALCameraDevice)
  {
    if (paramALCameraDevice.isLocalOnly())
    {
      paramALCameraDevice = getString(2131952987);
      j.d(paramALCameraDevice, "getString(R.string.live_list_camera_state_local)");
    }
    else if (paramALCameraDevice.getLastAlarmInfo() != null)
    {
      int i = (int)((System.currentTimeMillis() - paramALCameraDevice.getLastAlarmTime() * 'Ϩ') / 1000.0D / 60);
      if ((i >= 0) && (59 >= i))
      {
        paramALCameraDevice = getString(2131952991, new Object[] { Integer.valueOf(i + 1) });
      }
      else if (i < 1440)
      {
        paramALCameraDevice = getString(2131952990, new Object[] { Integer.valueOf(i / 60) });
      }
      else if (i < 10080)
      {
        paramALCameraDevice = getString(2131952989, new Object[] { Integer.valueOf(i / 60 / 24) });
      }
      else if (i < 44640)
      {
        String str = getResources().getString(2131952988);
        j.d(str, "resources.getString(R.st…st_detected_message_date)");
        Object localObject = TimeZone.getDefault();
        paramALCameraDevice = U1(paramALCameraDevice.getLastAlarmTime(), (TimeZone)localObject);
        localObject = kotlin.jvm.internal.p.a;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(String.valueOf(paramALCameraDevice.get(2) + 1));
        ((StringBuilder)localObject).append("/");
        ((StringBuilder)localObject).append(paramALCameraDevice.get(5));
        paramALCameraDevice = String.format(str, Arrays.copyOf(new Object[] { ((StringBuilder)localObject).toString() }, 1));
        j.d(paramALCameraDevice, "java.lang.String.format(format, *args)");
      }
      else
      {
        paramALCameraDevice = getString(2131952992);
      }
      j.d(paramALCameraDevice, "when {\n                 …0_days)\n                }");
    }
    else
    {
      paramALCameraDevice = getString(2131952992);
      j.d(paramALCameraDevice, "getString(R.string.live_list_no_detected_30_days)");
    }
    return paramALCameraDevice;
  }
  
  public final CameraPreviewViewModel O1()
  {
    CameraPreviewViewModel localCameraPreviewViewModel = this.p1;
    if (localCameraPreviewViewModel == null) {
      j.t("cameraPreviewViewModel");
    }
    return localCameraPreviewViewModel;
  }
  
  public final CloudVideoViewModel P1()
  {
    CloudVideoViewModel localCloudVideoViewModel = this.p2;
    if (localCloudVideoViewModel == null) {
      j.t("cloudVideoViewModel");
    }
    return localCloudVideoViewModel;
  }
  
  public View e1(int paramInt)
  {
    if (this.a4 == null) {
      this.a4 = new HashMap();
    }
    View localView1 = (View)this.a4.get(Integer.valueOf(paramInt));
    View localView2 = localView1;
    if (localView1 == null)
    {
      localView2 = findViewById(paramInt);
      this.a4.put(Integer.valueOf(paramInt), localView2);
    }
    return localView2;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == this.p0)
    {
      if (paramInt2 == -1)
      {
        if (paramIntent != null)
        {
          paramIntent = paramIntent.getStringArrayListExtra(CameraPreviewSortActivity.p0.b());
          if (paramIntent != null) {}
        }
        else
        {
          paramIntent = new ArrayList();
        }
        this.p3 = paramIntent;
        paramIntent = this.p1;
        if (paramIntent == null) {
          j.t("cameraPreviewViewModel");
        }
        paramIntent = paramIntent.h();
        CameraPreviewViewModel localCameraPreviewViewModel = this.p1;
        if (localCameraPreviewViewModel == null) {
          j.t("cameraPreviewViewModel");
        }
        paramIntent.setValue(localCameraPreviewViewModel.h().getValue());
      }
    }
    else if (paramInt1 == 1345)
    {
      paramIntent = this.p2;
      if (paramIntent == null) {
        j.t("cloudVideoViewModel");
      }
      paramIntent.O();
    }
    else
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    T1();
    R1();
    f2();
    S1();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    LiveMediaAPI.destroyAllDisplayAndStream();
    s0.h();
    this.T3.dispose();
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    j.e(paramMenuItem, "item");
    if (paramMenuItem.getItemId() == 2131361918) {
      startActivityForResult(new Intent(this, CameraPreviewSortActivity.class), this.p0);
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  protected void onPause()
  {
    super.onPause();
    LiveMediaAPI.allDisplayScreenshotPreview();
  }
  
  protected void onRestart()
  {
    super.onRestart();
    io.reactivex.e0.c localc = q.W0(1L, TimeUnit.SECONDS).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).G0(new h(this));
    this.T3.b(localc);
  }
  
  protected void onResume()
  {
    super.onResume();
    LiveMediaAPI.onDetectPipeResume();
  }
  
  protected void onStart()
  {
    super.onStart();
    LiveMediaAPI.setPlayInPreviewPage(true);
  }
  
  protected void onStop()
  {
    super.onStop();
    this.c.postDelayed(i.c, 500L);
    LiveMediaAPI.onDetectPipePause();
  }
  
  public static final class a
  {
    public final String a()
    {
      return CameraPreviewActivity.j1();
    }
  }
  
  static final class b<T>
    implements io.reactivex.g0.g<b.a.a.a.a.a.a>
  {
    b(CameraPreviewActivity paramCameraPreviewActivity) {}
    
    public final void a(b.a.a.a.a.a.a parama)
    {
      if (parama.a())
      {
        if (CameraPreviewActivity.s1(this.c) != null)
        {
          Object localObject = CameraPreviewActivity.s1(this.c);
          if ((localObject == null) || (((b.a.a.a.a.a.a)localObject).i() != 0) || (parama.i() != 0))
          {
            localObject = this.c.getLifecycle();
            j.d(localObject, "lifecycle");
            if (!((Lifecycle)localObject).getCurrentState().isAtLeast(Lifecycle.State.RESUMED)) {
              return;
            }
            CameraPreviewActivity.B1(this.c, parama);
            this.c.O1().l();
            LiveMediaAPI.onNetworkChanged();
            LiveMediaAPI.destroyAllDoubleTalkClient();
            return;
          }
        }
        CameraPreviewActivity.B1(this.c, parama);
      }
      else
      {
        parama = CameraPreviewActivity.t1(this.c).iterator();
        while (parama.hasNext()) {
          ((CameraPreviewInfo)parama.next()).o(false);
        }
        CameraPreviewActivity.u1(this.c).s();
      }
    }
  }
  
  static final class c
    implements View.OnClickListener
  {
    c(CameraPreviewActivity paramCameraPreviewActivity) {}
    
    public final void onClick(View paramView)
    {
      j.d(paramView, "it");
      boolean bool;
      if (paramView.getId() == 2131362923) {
        bool = true;
      } else {
        bool = false;
      }
      if (bool)
      {
        if (o.l0()) {
          CameraPreviewActivity.C1(this.c, bool);
        }
      }
      else if (o.k0()) {
        CameraPreviewActivity.C1(this.c, bool);
      }
      paramView = o.h0();
      j.d(paramView, "SP.instance()");
      if (paramView.j0())
      {
        CameraPreviewActivity.D1(this.c);
      }
      else
      {
        Object localObject = this.c;
        paramView = CameraPreviewActivity.k1((CameraPreviewActivity)localObject).clone();
        Objects.requireNonNull(paramView, "null cannot be cast to non-null type kotlin.collections.ArrayList<kotlin.String> /* = java.util.ArrayList<kotlin.String> */");
        if (CameraPreviewActivity.i1((CameraPreviewActivity)localObject, bool, (ArrayList)paramView).isEmpty())
        {
          CameraPreviewActivity.G1(this.c, bool);
        }
        else
        {
          paramView = this.c;
          localObject = CameraPreviewActivity.k1(paramView).clone();
          Objects.requireNonNull(localObject, "null cannot be cast to non-null type kotlin.collections.ArrayList<kotlin.String> /* = java.util.ArrayList<kotlin.String> */");
          CameraPreviewActivity.y1(paramView, bool, CameraPreviewActivity.i1(paramView, bool, (ArrayList)localObject));
          if (bool) {
            com.tplink.iot.Utils.x0.e.k();
          } else {
            com.tplink.iot.Utils.x0.e.c();
          }
        }
      }
    }
  }
  
  static final class d
    implements View.OnClickListener
  {
    d(CameraPreviewActivity paramCameraPreviewActivity) {}
    
    public final void onClick(View paramView)
    {
      j.d(paramView, "it");
      int i = paramView.getId();
      boolean bool1 = true;
      boolean bool2;
      if (i == 2131363065) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      if (bool2)
      {
        if (o.l0()) {
          CameraPreviewActivity.C1(this.c, bool2);
        }
      }
      else if (o.k0()) {
        CameraPreviewActivity.C1(this.c, bool2);
      }
      Object localObject = o.h0();
      j.d(localObject, "SP.instance()");
      if (((o)localObject).j0())
      {
        CameraPreviewActivity.D1(this.c);
      }
      else
      {
        ModeSettingActivity.a locala = ModeSettingActivity.y;
        localObject = this.c;
        if (paramView.getId() == 2131363065) {
          bool2 = bool1;
        } else {
          bool2 = false;
        }
        locala.a((Context)localObject, bool2, CameraPreviewActivity.t1(this.c));
      }
    }
  }
  
  public static final class e
    implements PullToRefreshContainer.e
  {
    e(CameraPreviewActivity paramCameraPreviewActivity) {}
    
    public void a() {}
    
    public void onRefresh()
    {
      this.a.O1().l();
    }
  }
  
  static final class f
    implements View.OnClickListener
  {
    f(CameraPreviewActivity paramCameraPreviewActivity) {}
    
    public final void onClick(View paramView)
    {
      CameraPreviewActivity.x1(this.c).setValue(Boolean.FALSE);
      this.c.P1().C0();
      w.v("preview");
    }
  }
  
  static final class g
    implements View.OnClickListener
  {
    g(CameraPreviewActivity paramCameraPreviewActivity) {}
    
    public final void onClick(View paramView)
    {
      w.r();
      BillingActivity.f1(this.c, com.tplink.iot.Utils.v0.e.f());
    }
  }
  
  static final class h<T>
    implements io.reactivex.g0.g<Long>
  {
    h(CameraPreviewActivity paramCameraPreviewActivity) {}
    
    public final void a(Long paramLong)
    {
      paramLong = CameraPreviewActivity.t1(this.c).iterator();
      while (paramLong.hasNext())
      {
        CameraPreviewInfo localCameraPreviewInfo = (CameraPreviewInfo)paramLong.next();
        b.d.q.b.l.e(localCameraPreviewInfo.d(), new a(localCameraPreviewInfo));
      }
      CameraPreviewActivity.u1(this.c).s();
    }
    
    static final class a<T>
      implements com.tplink.libtpnetwork.Utils.f0.b<com.tplink.libtpmediaother.database.model.c>
    {
      a(CameraPreviewInfo paramCameraPreviewInfo) {}
      
      public final void b(com.tplink.libtpmediaother.database.model.c paramc)
      {
        CameraPreviewInfo localCameraPreviewInfo = this.a;
        j.d(paramc, "deviceInfo");
        localCameraPreviewInfo.n(paramc.i());
      }
    }
  }
  
  static final class i
    implements Runnable
  {
    public static final i c = new i();
    
    public final void run()
    {
      if (!com.tplink.iot.core.p.d())
      {
        LiveMediaAPI.destroyAllDisplayAndStream();
        System.out.println("DisplayViewState,stopPlay due to enter background");
      }
    }
  }
  
  static final class j
    extends Lambda
    implements kotlin.jvm.b.l<Integer, kotlin.p>
  {
    j(CameraPreviewActivity paramCameraPreviewActivity, int paramInt)
    {
      super();
    }
    
    public final void a(int paramInt)
    {
      Object localObject1 = this.c;
      int i;
      if (i == 1) {
        i = 2131952836;
      } else {
        i = 2131952810;
      }
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append('/');
      ((StringBuilder)localObject2).append(i);
      localObject2 = ((Activity)localObject1).getString(i, new Object[] { ((StringBuilder)localObject2).toString() });
      j.d(localObject2, "getString(if (cameraNum …\"$sentNumber/$cameraNum\")");
      localObject1 = CameraPreviewActivity.r1(this.c);
      if (localObject1 != null) {
        ((UniversalDialog)localObject1).J0((String)localObject2);
      }
    }
  }
  
  static final class k
    extends Lambda
    implements kotlin.jvm.b.l<HashSet<String>, kotlin.p>
  {
    k(CameraPreviewActivity paramCameraPreviewActivity, ArrayList paramArrayList1, boolean paramBoolean, ArrayList paramArrayList2)
    {
      super();
    }
    
    public final void a(final HashSet<String> paramHashSet)
    {
      j.e(paramHashSet, "errorSet");
      if ((paramHashSet.size() <= 0) && (localArrayList2.size() <= 0))
      {
        CameraPreviewActivity.F1(this.c, paramBoolean);
        CameraPreviewActivity.h1(this.c);
      }
      else
      {
        long l;
        if (paramHashSet.size() + localArrayList2.size() >= CameraPreviewActivity.t1(this.c).size()) {
          l = 1000L;
        } else {
          l = 500L;
        }
        new Handler().postDelayed(new a(this, paramHashSet), l);
      }
    }
    
    static final class a
      implements Runnable
    {
      a(CameraPreviewActivity.k paramk, HashSet paramHashSet) {}
      
      public final void run()
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.addAll(paramHashSet);
        CameraPreviewActivity.k localk = this.c;
        CameraPreviewActivity.E1(localk.c, localk.f, localArrayList, localk.q);
        CameraPreviewActivity.h1(this.c.c);
      }
    }
  }
  
  static final class l
    extends Lambda
    implements kotlin.jvm.b.l<Integer, kotlin.p>
  {
    l(CameraPreviewActivity paramCameraPreviewActivity, boolean paramBoolean)
    {
      super();
    }
    
    public final void a(int paramInt)
    {
      UniversalDialog localUniversalDialog = CameraPreviewActivity.q1(this.c);
      if (localUniversalDialog != null) {
        localUniversalDialog.J0(CameraPreviewActivity.p1(this.c, paramBoolean1));
      }
    }
  }
  
  static final class m
    extends Lambda
    implements kotlin.jvm.b.l<HashSet<String>, kotlin.p>
  {
    m(CameraPreviewActivity paramCameraPreviewActivity, boolean paramBoolean1, int paramInt, String paramString, ImageView paramImageView, boolean paramBoolean2)
    {
      super();
    }
    
    public final void a(HashSet<String> paramHashSet)
    {
      j.e(paramHashSet, "errorSet");
      if (paramHashSet.isEmpty())
      {
        if (paramBoolean2)
        {
          ((d)CameraPreviewActivity.m1(this.c).get(paramInt)).e(false);
        }
        else if (CameraPreviewActivity.l1(this.c).get(paramString) != null)
        {
          paramHashSet = (d)CameraPreviewActivity.m1(this.c).get(paramInt);
          Object localObject = CameraPreviewActivity.l1(this.c).get(paramString);
          j.c(localObject);
          paramHashSet.f((CameraPreviewInfo)localObject);
        }
        else
        {
          j.d(CameraPreviewActivity.m1(this.c).remove(paramInt), "deviceListWithConnectionError.removeAt(position)");
        }
        paramHashSet = CameraPreviewActivity.n1(this.c);
        if (paramHashSet != null)
        {
          paramHashSet = paramHashSet.getAdapter();
          if (paramHashSet != null) {
            paramHashSet.notifyDataSetChanged();
          }
        }
      }
      new Handler().postDelayed(new a(this), 500L);
      paramHashSet = CameraPreviewActivity.q1(this.c);
      if (paramHashSet != null) {
        paramHashSet.J0(CameraPreviewActivity.p1(this.c, paramBoolean1));
      }
    }
    
    static final class a
      implements Runnable
    {
      a(CameraPreviewActivity.m paramm) {}
      
      public final void run()
      {
        CameraPreviewActivity.m localm = this.c;
        CameraPreviewActivity.H1(localm.c, false, localm.x);
      }
    }
  }
  
  static final class n
    implements UniversalDialog.c
  {
    n(CameraPreviewActivity paramCameraPreviewActivity, boolean paramBoolean) {}
    
    public final void a()
    {
      CameraPreviewActivity localCameraPreviewActivity = this.a;
      boolean bool = paramBoolean;
      Object localObject = CameraPreviewActivity.k1(localCameraPreviewActivity).clone();
      Objects.requireNonNull(localObject, "null cannot be cast to non-null type kotlin.collections.ArrayList<kotlin.String> /* = java.util.ArrayList<kotlin.String> */");
      CameraPreviewActivity.y1(localCameraPreviewActivity, bool, CameraPreviewActivity.i1(localCameraPreviewActivity, bool, (ArrayList)localObject));
      CameraPreviewActivity.f1(this.a);
    }
  }
  
  static final class o
    implements UniversalDialog.b
  {
    o(CameraPreviewActivity paramCameraPreviewActivity) {}
    
    public final void a()
    {
      CameraPreviewActivity.f1(this.a);
    }
  }
  
  static final class p
    implements UniversalDialog.b
  {
    p(CameraPreviewActivity paramCameraPreviewActivity) {}
    
    public final void a()
    {
      CameraPreviewActivity.g1(this.a);
    }
  }
  
  static final class q
    implements TPMaterialDialogV2.d
  {
    q(CameraPreviewActivity paramCameraPreviewActivity, boolean paramBoolean) {}
    
    public final void onClick(View paramView)
    {
      ModeSettingActivity.a locala = ModeSettingActivity.y;
      paramView = this.a;
      locala.a(paramView, paramBoolean, CameraPreviewActivity.t1(paramView));
    }
  }
  
  static final class r<T>
    implements Observer<List<? extends ALCameraDevice>>
  {
    r(CameraPreviewActivity paramCameraPreviewActivity) {}
    
    public final void a(final List<? extends ALCameraDevice> paramList)
    {
      ((PullToRefreshContainer)this.a.e1(com.tplink.iot.a.refresh_container)).A();
      if (LiveMediaAPI.getPlayingDevices().size() > 0) {
        return;
      }
      Collections.sort(paramList, new e());
      CameraPreviewActivity.k1(this.a).clear();
      CameraPreviewActivity.l1(this.a).clear();
      CameraPreviewActivity.t1(this.a).clear();
      final Object localObject1 = CameraPreviewActivity.v1(this.a);
      boolean bool1 = true;
      boolean bool2 = true;
      boolean bool3;
      if ((paramList != null) && (!paramList.isEmpty())) {
        bool3 = false;
      } else {
        bool3 = true;
      }
      ((MutableLiveData)localObject1).setValue(Boolean.valueOf(bool3));
      if (paramList != null)
      {
        Iterator localIterator = paramList.iterator();
        for (bool3 = bool2;; bool3 = bool1)
        {
          bool1 = bool3;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject1 = (ALCameraDevice)localIterator.next();
          bool1 = bool3;
          if (bool3)
          {
            bool1 = bool3;
            if (!((BaseALIoTDevice)localObject1).isUserRoleTypeDevice()) {
              bool1 = false;
            }
          }
          CameraPreviewActivity.k1(this.a).add(((ALCameraDevice)localObject1).getDeviceIdMD5());
          Object localObject2 = ((ALCameraDevice)localObject1).getCameraAvatarInfo();
          if ((localObject2 != null) && (!TextUtils.isEmpty(((CameraAvatarInfo)localObject2).getAvatarName())))
          {
            CameraPreviewActivity localCameraPreviewActivity = this.a;
            paramList = ((CameraAvatarInfo)localObject2).getAvatarName();
            localObject2 = ((CameraAvatarInfo)localObject2).getAvatarDefault();
            j.d(localObject2, "cameraAvatarInfo.avatarDefault");
            paramList = z4.c(localCameraPreviewActivity, paramList, ((Boolean)localObject2).booleanValue());
          }
          else
          {
            paramList = this.a.getString(2131953286);
          }
          b.d.q.b.l.e(((ALCameraDevice)localObject1).getDeviceIdMD5(), new a(this, (ALCameraDevice)localObject1, paramList));
        }
      }
      CameraPreviewActivity.w1(this.a).setValue(Boolean.valueOf(bool1));
      CameraPreviewActivity.u1(this.a).s();
      if ((!bool1) && (this.a.P1().p())) {
        this.a.P1().O();
      } else {
        CameraPreviewActivity.x1(this.a).setValue(Boolean.FALSE);
      }
    }
    
    static final class a<T>
      implements com.tplink.libtpnetwork.Utils.f0.b<com.tplink.libtpmediaother.database.model.c>
    {
      a(CameraPreviewActivity.r paramr, ALCameraDevice paramALCameraDevice, String paramString) {}
      
      public final void b(com.tplink.libtpmediaother.database.model.c paramc)
      {
        String str1 = localObject1.getDeviceIdMD5();
        j.d(str1, "device.deviceIdMD5");
        Object localObject = localObject1.getDeviceAlias();
        j.d(localObject, "device.deviceAlias");
        String str2 = CameraPreviewActivity.I1(this.a.a, localObject1);
        boolean bool1 = localObject1.isOnline();
        boolean bool2;
        if (localObject1.getDeviceState() == EnumIoTDeviceState.LOADING) {
          bool2 = true;
        } else {
          bool2 = false;
        }
        j.d(paramc, "deviceInfo");
        String str3 = paramc.i();
        paramc = paramList;
        j.d(paramc, "location");
        paramc = new CameraPreviewInfo(str1, (String)localObject, str2, bool1, bool2, str3, paramc);
        localObject = CameraPreviewActivity.l1(this.a.a);
        str1 = localObject1.getDeviceIdMD5();
        j.d(str1, "device.deviceIdMD5");
        ((Map)localObject).put(str1, paramc);
        CameraPreviewActivity.t1(this.a.a).add(paramc);
      }
    }
  }
  
  static final class s<T>
    implements Observer<List<? extends OrderInfo>>
  {
    s(CameraPreviewActivity paramCameraPreviewActivity) {}
    
    public final void a(List<? extends OrderInfo> paramList)
    {
      if (!com.tplink.iot.Utils.v0.d.d())
      {
        CameraPreviewActivity.x1(this.a).setValue(Boolean.FALSE);
        return;
      }
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        boolean bool = this.a.P1().H(paramList, CameraPreviewActivity.o1(this.a));
        CameraPreviewActivity.x1(this.a).setValue(Boolean.valueOf(bool ^ true));
      }
      else
      {
        CameraPreviewActivity.x1(this.a).setValue(Boolean.TRUE);
      }
    }
  }
  
  static final class showModeActivateFailDialog$dialogInit$1$a
    implements com.tplink.iot.adapter.databinding.d
  {
    showModeActivateFailDialog$dialogInit$1$a(CameraPreviewActivity.showModeActivateFailDialog.dialogInit.1 param1) {}
    
    public final void a(View paramView, int paramInt)
    {
      paramView = this.a;
      CameraPreviewActivity localCameraPreviewActivity = paramView.c;
      CameraPreviewActivity.z1(localCameraPreviewActivity, paramInt, paramView.d, ((d)CameraPreviewActivity.m1(localCameraPreviewActivity).get(paramInt)).d().d(), ((d)CameraPreviewActivity.m1(this.a.c).get(paramInt)).d().m());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\preview\CameraPreviewActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */