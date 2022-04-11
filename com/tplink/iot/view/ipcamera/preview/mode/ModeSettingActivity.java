package com.tplink.iot.view.ipcamera.preview.mode;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialog;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.Utils.TPMaterialDialogV2.d;
import com.tplink.iot.adapter.databinding.DataBindingListAdapter;
import com.tplink.iot.adapter.databinding.d;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ModeSettingFooterViewBinding;
import com.tplink.iot.view.home.DeviceOfflineTroubleshootingActivity;
import com.tplink.iot.view.ipcamera.preview.CameraPreviewInfo;
import com.tplink.iot.view.ipcamera.setting.z4;
import com.tplink.iot.viewmodel.home.u;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.Utils.o;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import com.tplink.libtpnetwork.cameranetwork.bean.CameraAvatarInfo;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import kotlin.collections.l;
import kotlin.jvm.internal.j;

public final class ModeSettingActivity
  extends BaseActivity
{
  public static final a y = new a(null);
  private HashSet<String> H3 = new HashSet();
  private ArrayList<CameraPreviewInfo> I3;
  private ArrayList<Boolean> J3 = new ArrayList();
  private ArrayList<String> K3 = new ArrayList();
  private ArrayList<Integer> L3 = new ArrayList();
  private BottomSheetDialog M3;
  private RecyclerView N3;
  private TextView O3;
  private TextView P3;
  private ImageView Q3;
  private TextView R3;
  private HashMap S3;
  private ArrayList<CameraPreviewInfo> p0;
  private ArrayList<String> p1 = new ArrayList();
  private MenuItem p2;
  private ArrayList<Boolean> p3 = new ArrayList();
  private boolean z;
  
  private final void A1()
  {
    if (this.z) {
      localObject = (HashSet)o.M();
    } else {
      localObject = (HashSet)o.x();
    }
    this.H3 = ((HashSet)localObject);
    if (localObject == null)
    {
      this.H3 = new HashSet();
      localObject = this.p0;
      if (localObject == null) {
        j.t("previewInfoList");
      }
      localObject = ((ArrayList)localObject).clone();
      Objects.requireNonNull(localObject, "null cannot be cast to non-null type kotlin.collections.ArrayList<com.tplink.iot.view.ipcamera.preview.CameraPreviewInfo> /* = java.util.ArrayList<com.tplink.iot.view.ipcamera.preview.CameraPreviewInfo> */");
      this.I3 = ((ArrayList)localObject);
      localObject = this.p0;
      if (localObject == null) {
        j.t("previewInfoList");
      }
      ((ArrayList)localObject).clear();
      this.p1.clear();
      this.p3.clear();
      return;
    }
    Object localObject = this.p0;
    if (localObject == null) {
      j.t("previewInfoList");
    }
    for (int i = ((ArrayList)localObject).size() - 1; i >= 0; i--)
    {
      localObject = this.H3;
      j.c(localObject);
      ArrayList localArrayList = this.p0;
      if (localArrayList == null) {
        j.t("previewInfoList");
      }
      if (!((HashSet)localObject).contains(((CameraPreviewInfo)localArrayList.get(i)).d()))
      {
        localObject = this.I3;
        if (localObject == null) {
          j.t("deviceAddedList");
        }
        localArrayList = this.p0;
        if (localArrayList == null) {
          j.t("previewInfoList");
        }
        ((ArrayList)localObject).add(localArrayList.get(i));
        localObject = this.p0;
        if (localObject == null) {
          j.t("previewInfoList");
        }
        ((ArrayList)localObject).remove(i);
        this.p1.remove(i);
        this.p3.remove(i);
      }
    }
  }
  
  private final void B1()
  {
    Object localObject = this.p0;
    if (localObject == null) {
      j.t("previewInfoList");
    }
    for (int i = ((ArrayList)localObject).size() - 1; i >= 0; i--)
    {
      localObject = this.p0;
      if (localObject == null) {
        j.t("previewInfoList");
      }
      localObject = TPIoTClientManager.K1(((CameraPreviewInfo)((ArrayList)localObject).get(i)).d());
      if (localObject != null)
      {
        localObject = (ALCameraDevice)((TPBaseDeviceContext)localObject).getCameraDevice();
        if ((localObject != null) && (((BaseALIoTDevice)localObject).isUserRoleTypeDevice() == true))
        {
          localObject = this.p0;
          if (localObject == null) {
            j.t("previewInfoList");
          }
          ((ArrayList)localObject).remove(i);
        }
      }
    }
  }
  
  private final String C1(CameraPreviewInfo paramCameraPreviewInfo)
  {
    paramCameraPreviewInfo = TPIoTClientManager.K1(paramCameraPreviewInfo.d());
    if (paramCameraPreviewInfo != null)
    {
      paramCameraPreviewInfo = (ALCameraDevice)paramCameraPreviewInfo.getCameraDevice();
      if (paramCameraPreviewInfo != null)
      {
        paramCameraPreviewInfo = paramCameraPreviewInfo.getCameraAvatarInfo();
        break label34;
      }
    }
    paramCameraPreviewInfo = null;
    label34:
    if ((paramCameraPreviewInfo != null) && (!TextUtils.isEmpty(paramCameraPreviewInfo.getAvatarName())))
    {
      String str = paramCameraPreviewInfo.getAvatarName();
      paramCameraPreviewInfo = paramCameraPreviewInfo.getAvatarDefault();
      j.d(paramCameraPreviewInfo, "cameraAvatarInfo.avatarDefault");
      paramCameraPreviewInfo = z4.c(this, str, paramCameraPreviewInfo.booleanValue());
      j.d(paramCameraPreviewInfo, "DeviceAvatarUtil.getLoca…atarDefault\n            )");
    }
    else
    {
      paramCameraPreviewInfo = getString(2131953286);
      j.d(paramCameraPreviewInfo, "getString(R.string.onBoarding_set_location_home)");
    }
    return paramCameraPreviewInfo;
  }
  
  private final void D1()
  {
    HashSet localHashSet;
    if (this.z)
    {
      localHashSet = this.H3;
      if ((localHashSet != null) && (localHashSet.isEmpty() == true)) {
        localHashSet = new HashSet(l.b("0"));
      } else {
        localHashSet = this.H3;
      }
      o.S0(localHashSet);
    }
    else
    {
      localHashSet = this.H3;
      if ((localHashSet != null) && (localHashSet.isEmpty() == true)) {
        localHashSet = new HashSet(l.b("0"));
      } else {
        localHashSet = this.H3;
      }
      o.z0(localHashSet);
    }
  }
  
  private final void E1()
  {
    boolean bool = this.J3.isEmpty();
    int i = 0;
    Object localObject;
    if ((bool ^ true))
    {
      int j = this.J3.size();
      bool = false;
      while (i < j)
      {
        localObject = this.J3.get(i);
        j.d(localObject, "isSelected[i]");
        bool |= ((Boolean)localObject).booleanValue();
        i++;
      }
      localObject = this.O3;
      if (localObject == null) {
        j.t("bottomAdd");
      }
      ((TextView)localObject).setEnabled(bool);
    }
    else
    {
      localObject = this.O3;
      if (localObject == null) {
        j.t("bottomAdd");
      }
      ((TextView)localObject).setEnabled(false);
    }
  }
  
  private final void F1()
  {
    ArrayList localArrayList = this.I3;
    if (localArrayList == null) {
      j.t("deviceAddedList");
    }
    int i = localArrayList.size();
    int j = 0;
    for (int k = 0; k < i; k++)
    {
      localArrayList = this.I3;
      if (localArrayList == null) {
        j.t("deviceAddedList");
      }
      if (!((CameraPreviewInfo)localArrayList.get(k)).m()) {
        break label71;
      }
    }
    k = -1;
    label71:
    this.L3.clear();
    localArrayList = this.I3;
    if (localArrayList == null) {
      j.t("deviceAddedList");
    }
    i = localArrayList.size();
    while (j < i)
    {
      this.L3.add(Integer.valueOf(k));
      j++;
    }
  }
  
  @SuppressLint({"CutPasteId"})
  private final void G1()
  {
    Object localObject1 = this.M3;
    int i = 0;
    if (localObject1 == null)
    {
      localObject1 = new BottomSheetDialog(this);
      this.M3 = ((BottomSheetDialog)localObject1);
      ((BottomSheetDialog)localObject1).setContentView(2131558772);
      localObject1 = this.M3;
      localObject2 = null;
      if (localObject1 != null) {
        localObject1 = (ViewGroup)((AppCompatDialog)localObject1).findViewById(2131362392);
      } else {
        localObject1 = null;
      }
      if (localObject1 != null) {
        ((ViewGroup)localObject1).setBackgroundColor(0);
      }
      if (localObject1 != null)
      {
        localObject1 = ((ViewGroup)localObject1).getChildAt(0);
        if (localObject1 != null)
        {
          localObject1 = ((View)localObject1).getLayoutParams();
          if (localObject1 != null)
          {
            localObject3 = getResources();
            j.d(localObject3, "resources");
            ((ViewGroup.LayoutParams)localObject1).height = (((Resources)localObject3).getDisplayMetrics().heightPixels * 9 / 10);
          }
        }
      }
      localObject1 = this.M3;
      if (localObject1 != null) {
        localObject1 = (RecyclerView)((AppCompatDialog)localObject1).findViewById(2131363929);
      } else {
        localObject1 = null;
      }
      j.c(localObject1);
      this.N3 = ((RecyclerView)localObject1);
      localObject1 = this.M3;
      if (localObject1 != null) {
        localObject1 = (TextView)((AppCompatDialog)localObject1).findViewById(2131364332);
      } else {
        localObject1 = null;
      }
      j.c(localObject1);
      this.O3 = ((TextView)localObject1);
      localObject1 = this.M3;
      if (localObject1 != null) {
        localObject1 = (TextView)((AppCompatDialog)localObject1).findViewById(2131364358);
      } else {
        localObject1 = null;
      }
      j.c(localObject1);
      this.P3 = ((TextView)localObject1);
      localObject1 = this.M3;
      if (localObject1 != null) {
        localObject1 = (TextView)((AppCompatDialog)localObject1).findViewById(2131364545);
      } else {
        localObject1 = null;
      }
      j.c(localObject1);
      this.R3 = ((TextView)localObject1);
      localObject1 = this.M3;
      if (localObject1 != null) {
        localObject1 = (ImageView)((AppCompatDialog)localObject1).findViewById(2131363090);
      } else {
        localObject1 = null;
      }
      j.c(localObject1);
      this.Q3 = ((ImageView)localObject1);
      Object localObject3 = this.M3;
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = ((AppCompatDialog)localObject3).findViewById(2131362392);
      }
      j.c(localObject1);
      localObject2 = BottomSheetBehavior.from((View)localObject1);
      j.d(localObject2, "BottomSheetBehavior.from…d.design_bottom_sheet)!!)");
      localObject1 = getResources();
      j.d(localObject1, "resources");
      ((BottomSheetBehavior)localObject2).setPeekHeight(((Resources)localObject1).getDisplayMetrics().heightPixels * 9 / 10);
      localObject1 = this.M3;
      if (localObject1 != null)
      {
        localObject1 = (ImageView)((AppCompatDialog)localObject1).findViewById(2131363013);
        if (localObject1 != null) {
          ((ImageView)localObject1).setOnClickListener(new e(this));
        }
      }
      localObject1 = this.O3;
      if (localObject1 == null) {
        j.t("bottomAdd");
      }
      ((TextView)localObject1).setOnClickListener(new f(this));
      localObject3 = new g(this);
      RecyclerView localRecyclerView = this.N3;
      if (localRecyclerView == null) {
        j.t("bottomRecyclerView");
      }
      int j = com.tplink.iot.adapter.databinding.a.p;
      k = com.tplink.iot.adapter.databinding.a.q;
      int m = com.tplink.iot.adapter.databinding.a.o;
      int n = com.tplink.iot.adapter.databinding.a.s;
      int i1 = com.tplink.iot.adapter.databinding.a.t;
      i2 = com.tplink.iot.adapter.databinding.a.p;
      localObject2 = this.I3;
      if (localObject2 == null) {
        j.t("deviceAddedList");
      }
      ArrayList localArrayList1 = this.K3;
      localObject1 = this.J3;
      ArrayList localArrayList2 = this.L3;
      localRecyclerView.setAdapter(new DataBindingListAdapter(2131559056, new int[] { j, k, m, n, i1 }, new int[] { i2 }, new Object[] { localObject2, localArrayList1, localObject3, localObject1, localArrayList2 }));
    }
    localObject1 = this.P3;
    if (localObject1 == null) {
      j.t("bottomTitle");
    }
    ((TextView)localObject1).setText(getString(2131953077, new Object[] { "0" }));
    this.J3.clear();
    this.K3.clear();
    E1();
    localObject1 = this.I3;
    if (localObject1 == null) {
      j.t("deviceAddedList");
    }
    I1((ArrayList)localObject1);
    localObject1 = this.I3;
    if (localObject1 == null) {
      j.t("deviceAddedList");
    }
    int i2 = ((ArrayList)localObject1).size();
    for (int k = 0; k < i2; k++)
    {
      this.J3.add(Boolean.FALSE);
      localObject1 = this.K3;
      localObject2 = this.I3;
      if (localObject2 == null) {
        j.t("deviceAddedList");
      }
      localObject2 = ((ArrayList)localObject2).get(k);
      j.d(localObject2, "deviceAddedList[i]");
      ((ArrayList)localObject1).add(C1((CameraPreviewInfo)localObject2));
    }
    F1();
    localObject1 = this.Q3;
    if (localObject1 == null) {
      j.t("bottomIv");
    }
    Object localObject2 = this.I3;
    if (localObject2 == null) {
      j.t("deviceAddedList");
    }
    if (((ArrayList)localObject2).isEmpty()) {
      k = 0;
    } else {
      k = 8;
    }
    ((ImageView)localObject1).setVisibility(k);
    localObject2 = this.R3;
    if (localObject2 == null) {
      j.t("bottomTip");
    }
    localObject1 = this.I3;
    if (localObject1 == null) {
      j.t("deviceAddedList");
    }
    if (((ArrayList)localObject1).isEmpty()) {
      k = i;
    } else {
      k = 8;
    }
    ((TextView)localObject2).setVisibility(k);
    localObject1 = this.N3;
    if (localObject1 == null) {
      j.t("bottomRecyclerView");
    }
    localObject1 = ((RecyclerView)localObject1).getAdapter();
    if (localObject1 != null) {
      ((RecyclerView.Adapter)localObject1).notifyDataSetChanged();
    }
    localObject1 = this.M3;
    if (localObject1 != null) {
      ((Dialog)localObject1).show();
    }
  }
  
  private final void H1(boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean)
    {
      localObject = (RecyclerView)e1(com.tplink.iot.a.recycler_view);
      j.d(localObject, "recycler_view");
      ((ViewGroup)localObject).setVisibility(8);
      localObject = (RelativeLayout)e1(com.tplink.iot.a.rl_no_camera);
      j.d(localObject, "rl_no_camera");
      ((RelativeLayout)localObject).setVisibility(0);
      localObject = e1(com.tplink.iot.a.divide_line0);
      j.d(localObject, "divide_line0");
      ((View)localObject).setVisibility(8);
    }
    else
    {
      localObject = (RecyclerView)e1(com.tplink.iot.a.recycler_view);
      j.d(localObject, "recycler_view");
      ((ViewGroup)localObject).setVisibility(0);
      localObject = (RelativeLayout)e1(com.tplink.iot.a.rl_no_camera);
      j.d(localObject, "rl_no_camera");
      ((RelativeLayout)localObject).setVisibility(8);
      localObject = e1(com.tplink.iot.a.divide_line0);
      j.d(localObject, "divide_line0");
      ((View)localObject).setVisibility(0);
    }
  }
  
  private final void I1(ArrayList<CameraPreviewInfo> paramArrayList)
  {
    l.o(paramArrayList, h.c);
    int i = 0;
    int j = 0;
    while (i < paramArrayList.size() - j)
    {
      Object localObject = paramArrayList.get(i);
      j.d(localObject, "list[i]");
      localObject = (CameraPreviewInfo)localObject;
      if (!((CameraPreviewInfo)localObject).m())
      {
        paramArrayList.remove(i);
        paramArrayList.add(localObject);
        j++;
      }
      else
      {
        i++;
      }
    }
  }
  
  private final void y1()
  {
    int i = this.p3.size();
    for (int j = 0; j < i; j++)
    {
      localObject = this.p3;
      ((ArrayList)localObject).set(j, Boolean.valueOf(true ^ ((Boolean)((ArrayList)localObject).get(j)).booleanValue()));
    }
    Object localObject = (RecyclerView)e1(com.tplink.iot.a.recycler_view);
    j.d(localObject, "recycler_view");
    localObject = ((RecyclerView)localObject).getAdapter();
    if (localObject != null) {
      ((RecyclerView.Adapter)localObject).notifyDataSetChanged();
    }
    boolean bool = this.p3.isEmpty();
    j = 2131231341;
    if ((bool ^ true))
    {
      MenuItem localMenuItem = this.p2;
      if (localMenuItem == null) {
        j.t("editItem");
      }
      localObject = this.p3.get(0);
      j.d(localObject, "isEditMode[0]");
      if (((Boolean)localObject).booleanValue()) {
        j = 0;
      }
      localMenuItem.setIcon(j);
      localObject = this.p2;
      if (localObject == null) {
        j.t("editItem");
      }
      ((MenuItem)localObject).setEnabled(true);
      Z0(((Boolean)this.p3.get(0)).booleanValue() ^ true);
    }
    else
    {
      localObject = this.p2;
      if (localObject == null) {
        j.t("editItem");
      }
      ((MenuItem)localObject).setIcon(2131231341);
      localObject = this.p2;
      if (localObject == null) {
        j.t("editItem");
      }
      ((MenuItem)localObject).setEnabled(false);
    }
  }
  
  private final int z1()
  {
    int i = this.J3.size();
    int j = 0;
    int m;
    for (int k = 0; j < i; k = m)
    {
      Object localObject = this.J3.get(j);
      j.d(localObject, "isSelected[i]");
      m = k;
      if (((Boolean)localObject).booleanValue()) {
        m = k + 1;
      }
      j++;
    }
    return k;
  }
  
  public View e1(int paramInt)
  {
    if (this.S3 == null) {
      this.S3 = new HashMap();
    }
    View localView1 = (View)this.S3.get(Integer.valueOf(paramInt));
    View localView2 = localView1;
    if (localView1 == null)
    {
      localView2 = findViewById(paramInt);
      this.S3.put(Integer.valueOf(paramInt), localView2);
    }
    return localView2;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558583);
    this.z = getIntent().getBooleanExtra("detection_home_mode", true);
    paramBundle = getIntent().getParcelableArrayListExtra("preview_info_list");
    if (paramBundle == null) {
      paramBundle = new ArrayList();
    }
    this.p0 = paramBundle;
    this.I3 = new ArrayList();
    B1();
    paramBundle = this.p0;
    if (paramBundle == null) {
      j.t("previewInfoList");
    }
    I1(paramBundle);
    if (this.z) {
      i = 2131951889;
    } else {
      i = 2131951869;
    }
    setTitle(i);
    paramBundle = new ArrayList();
    Object localObject1 = this.p0;
    if (localObject1 == null) {
      j.t("previewInfoList");
    }
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (CameraPreviewInfo)((Iterator)localObject1).next();
      localArrayList1 = this.p1;
      j.d(localObject2, "previewInfo");
      localArrayList1.add(C1((CameraPreviewInfo)localObject2));
      this.p3.add(Boolean.FALSE);
      if (((CameraPreviewInfo)localObject2).m()) {
        paramBundle.add(((CameraPreviewInfo)localObject2).d());
      }
    }
    A1();
    localObject1 = new d(this);
    int j = com.tplink.iot.a.recycler_view;
    paramBundle = (RecyclerView)e1(j);
    j.d(paramBundle, "recycler_view");
    int i = com.tplink.iot.adapter.databinding.a.p;
    int k = com.tplink.iot.adapter.databinding.a.q;
    int m = com.tplink.iot.adapter.databinding.a.o;
    int n = com.tplink.iot.adapter.databinding.a.r;
    int i1 = com.tplink.iot.adapter.databinding.a.p;
    Object localObject2 = this.p0;
    if (localObject2 == null) {
      j.t("previewInfoList");
    }
    ArrayList localArrayList1 = this.p1;
    ArrayList localArrayList2 = this.p3;
    paramBundle.setAdapter(new DataBindingListAdapter(2131559057, new int[] { i, k, m, n }, new int[] { i1 }, new Object[] { localObject2, localArrayList1, localObject1, localArrayList2 }));
    paramBundle = (ModeSettingFooterViewBinding)DataBindingUtil.inflate(getLayoutInflater(), 2131559273, (RecyclerView)e1(j), false);
    j.d(paramBundle, "binding");
    paramBundle.getRoot().setOnClickListener(new b(this));
    localObject1 = (RecyclerView)e1(j);
    j.d(localObject1, "recycler_view");
    localObject1 = ((RecyclerView)localObject1).getAdapter();
    Objects.requireNonNull(localObject1, "null cannot be cast to non-null type com.tplink.iot.adapter.databinding.DataBindingListAdapter");
    ((DataBindingListAdapter)localObject1).y(paramBundle.getRoot());
    ((Button)e1(com.tplink.iot.a.btn_bottom)).setOnClickListener(new c(this));
    H1(this.p3.isEmpty());
    a1(2131231339);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131623962, paramMenu);
    j.c(paramMenu);
    MenuItem localMenuItem = paramMenu.findItem(2131361912);
    j.d(localMenuItem, "menu!!.findItem(R.id.action_remove_device)");
    this.p2 = localMenuItem;
    if (localMenuItem == null) {
      j.t("editItem");
    }
    ArrayList localArrayList = this.p0;
    if (localArrayList == null) {
      j.t("previewInfoList");
    }
    localMenuItem.setEnabled(localArrayList.isEmpty() ^ true);
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    j.e(paramMenuItem, "item");
    if (paramMenuItem.getItemId() == 2131361912) {
      y1();
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  public static final class a
  {
    public final void a(Context paramContext, boolean paramBoolean, ArrayList<CameraPreviewInfo> paramArrayList)
    {
      j.e(paramContext, "context");
      j.e(paramArrayList, "previewInfoList");
      Intent localIntent = new Intent(paramContext, ModeSettingActivity.class);
      localIntent.putExtra("detection_home_mode", paramBoolean);
      localIntent.putParcelableArrayListExtra("preview_info_list", paramArrayList);
      paramContext.startActivity(localIntent);
    }
  }
  
  static final class b
    implements View.OnClickListener
  {
    b(ModeSettingActivity paramModeSettingActivity) {}
    
    public final void onClick(View paramView)
    {
      ModeSettingActivity.v1(this.c);
    }
  }
  
  static final class c
    implements View.OnClickListener
  {
    c(ModeSettingActivity paramModeSettingActivity) {}
    
    public final void onClick(View paramView)
    {
      ModeSettingActivity.v1(this.c);
    }
  }
  
  static final class d
    implements d
  {
    d(ModeSettingActivity paramModeSettingActivity) {}
    
    public final void a(View paramView, final int paramInt)
    {
      if (!((Boolean)ModeSettingActivity.q1(this.a).get(0)).booleanValue())
      {
        paramView = ModeSettingActivity.p1(this.a).get(paramInt);
        j.d(paramView, "previewInfoList[position]");
        paramView = (CameraPreviewInfo)paramView;
        if (paramView.m())
        {
          ModeDetectSettingActivity.m1(this.a, paramView.d(), ModeSettingActivity.m1(this.a));
        }
        else
        {
          paramView = TPIoTClientManager.K1(paramView.d());
          j.d(paramView, "TPIoTClientManager.getCa…aPreviewInfo.deviceIdMD5)");
          paramView = (ALCameraDevice)paramView.getCameraDevice();
          if (paramView != null)
          {
            ModeSettingActivity localModeSettingActivity = this.a;
            String str = EnumDeviceType.CAMERA.getDeviceType();
            j.d(paramView, "it");
            u.j(localModeSettingActivity, str, paramView.getDeviceModel(), paramView.getDeviceHwVer());
          }
        }
      }
      else
      {
        j.d(paramView, "view");
        if (paramView.getId() == 2131363024) {
          new TPMaterialDialogV2.Builder(this.a).i(2131952813, 2131099799).l(2131951757, 2131099808, null).o(2131952451, 2131099812, new a(this, paramInt)).b(false).c(false).g(8, 8).y();
        }
      }
    }
    
    static final class a
      implements TPMaterialDialogV2.d
    {
      a(ModeSettingActivity.d paramd, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        paramView = ModeSettingActivity.j1(this.a.a);
        if (paramView != null) {
          paramView.remove(((CameraPreviewInfo)ModeSettingActivity.p1(this.a.a).get(paramInt)).d());
        }
        ModeSettingActivity.k1(this.a.a).add(ModeSettingActivity.p1(this.a.a).get(paramInt));
        ModeSettingActivity.p1(this.a.a).remove(paramInt);
        ModeSettingActivity.o1(this.a.a).remove(paramInt);
        ModeSettingActivity.q1(this.a.a).remove(paramInt);
        paramView = (RecyclerView)this.a.a.e1(com.tplink.iot.a.recycler_view);
        j.d(paramView, "recycler_view");
        paramView = paramView.getAdapter();
        if (paramView != null) {
          paramView.notifyDataSetChanged();
        }
        if (ModeSettingActivity.q1(this.a.a).isEmpty())
        {
          ModeSettingActivity.l1(this.a.a).setIcon(2131231341);
          ModeSettingActivity.l1(this.a.a).setEnabled(false);
          this.a.a.Z0(true);
          ModeSettingActivity.w1(this.a.a, true);
        }
        ModeSettingActivity.s1(this.a.a);
      }
    }
  }
  
  static final class e
    implements View.OnClickListener
  {
    e(ModeSettingActivity paramModeSettingActivity) {}
    
    public final void onClick(View paramView)
    {
      paramView = ModeSettingActivity.h1(this.c);
      if (paramView != null) {
        paramView.dismiss();
      }
    }
  }
  
  static final class f
    implements View.OnClickListener
  {
    f(ModeSettingActivity paramModeSettingActivity) {}
    
    public final void onClick(View paramView)
    {
      for (int i = ModeSettingActivity.r1(this.c).size() - 1; i >= 0; i--)
      {
        paramView = ModeSettingActivity.r1(this.c).get(i);
        j.d(paramView, "isSelected[i]");
        if (((Boolean)paramView).booleanValue())
        {
          ModeSettingActivity.p1(this.c).add(ModeSettingActivity.k1(this.c).get(i));
          paramView = ModeSettingActivity.j1(this.c);
          if (paramView != null) {
            paramView.add(((CameraPreviewInfo)ModeSettingActivity.k1(this.c).get(i)).d());
          }
          ModeSettingActivity.k1(this.c).remove(i);
          ModeSettingActivity.r1(this.c).remove(i);
        }
      }
      paramView = this.c;
      ModeSettingActivity.x1(paramView, ModeSettingActivity.p1(paramView));
      ModeSettingActivity.o1(this.c).clear();
      ModeSettingActivity.q1(this.c).clear();
      Iterator localIterator = ModeSettingActivity.p1(this.c).iterator();
      while (localIterator.hasNext())
      {
        CameraPreviewInfo localCameraPreviewInfo = (CameraPreviewInfo)localIterator.next();
        paramView = ModeSettingActivity.o1(this.c);
        ModeSettingActivity localModeSettingActivity = this.c;
        j.d(localCameraPreviewInfo, "previewInfo");
        paramView.add(ModeSettingActivity.n1(localModeSettingActivity, localCameraPreviewInfo));
        ModeSettingActivity.q1(this.c).add(Boolean.FALSE);
      }
      ModeSettingActivity.u1(this.c);
      ModeSettingActivity.s1(this.c);
      ModeSettingActivity.t1(this.c);
      paramView = (RecyclerView)this.c.e1(com.tplink.iot.a.recycler_view);
      j.d(paramView, "recycler_view");
      paramView = paramView.getAdapter();
      if (paramView != null) {
        paramView.notifyDataSetChanged();
      }
      paramView = ModeSettingActivity.g1(this.c).getAdapter();
      if (paramView != null) {
        paramView.notifyDataSetChanged();
      }
      this.c.Z0(true);
      paramView = ModeSettingActivity.h1(this.c);
      if (paramView != null) {
        paramView.dismiss();
      }
      ModeSettingActivity.l1(this.c).setIcon(2131231341);
      ModeSettingActivity.l1(this.c).setEnabled(true);
      ModeSettingActivity.w1(this.c, false);
    }
  }
  
  static final class g
    implements d
  {
    g(ModeSettingActivity paramModeSettingActivity) {}
    
    public final void a(final View paramView, int paramInt)
    {
      final Object localObject1;
      if (!((CameraPreviewInfo)ModeSettingActivity.k1(this.a).get(paramInt)).m())
      {
        paramView = TPIoTClientManager.K1(((CameraPreviewInfo)ModeSettingActivity.k1(this.a).get(paramInt)).d());
        j.d(paramView, "TPIoTClientManager.getCa…st[position].deviceIdMD5)");
        localObject1 = (ALCameraDevice)paramView.getCameraDevice();
        localObject2 = new TPMaterialDialogV2.Builder(this.a);
        paramView = ((TPMaterialDialogV2.Builder)localObject2).a();
        j.d(paramView, "dialogBuilder.create()");
        ((TPMaterialDialogV2.Builder)localObject2).r(2131952575);
        ((TPMaterialDialogV2.Builder)localObject2).h(2131952541);
        ((TPMaterialDialogV2.Builder)localObject2).c(false);
        ((TPMaterialDialogV2.Builder)localObject2).b(false);
        ((TPMaterialDialogV2.Builder)localObject2).l(2131952391, 2131099804, null);
        ((TPMaterialDialogV2.Builder)localObject2).o(2131952402, 2131099808, new a(this, paramView, (ALCameraDevice)localObject1));
        ((TPMaterialDialogV2.Builder)localObject2).g(8, 8);
        localObject2 = paramView.getWindow();
        if (localObject2 != null) {
          ((Window)localObject2).clearFlags(2);
        }
        paramView.show();
        return;
      }
      ModeSettingActivity.r1(this.a).set(paramInt, Boolean.valueOf(((Boolean)ModeSettingActivity.r1(this.a).get(paramInt)).booleanValue() ^ true));
      ModeSettingActivity.t1(this.a);
      paramInt = ModeSettingActivity.f1(this.a);
      Object localObject2 = ModeSettingActivity.i1(this.a);
      if (paramInt == 1)
      {
        localObject1 = this.a;
        paramView = new StringBuilder();
        paramView.append("");
        paramView.append(paramInt);
        paramView = ((Activity)localObject1).getString(2131953076, new Object[] { paramView.toString() });
      }
      else
      {
        paramView = this.a;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(paramInt);
        paramView = paramView.getString(2131953077, new Object[] { ((StringBuilder)localObject1).toString() });
      }
      ((TextView)localObject2).setText(paramView);
      paramView = ModeSettingActivity.g1(this.a).getAdapter();
      if (paramView != null) {
        paramView.notifyDataSetChanged();
      }
    }
    
    static final class a
      implements TPMaterialDialogV2.d
    {
      a(ModeSettingActivity.g paramg, TPMaterialDialogV2 paramTPMaterialDialogV2, ALCameraDevice paramALCameraDevice) {}
      
      public final void onClick(View paramView)
      {
        paramView = paramView;
        if (paramView != null) {
          paramView.dismiss();
        }
        ModeSettingActivity localModeSettingActivity = this.a.a;
        String str1 = EnumDeviceType.CAMERA.getDeviceType();
        paramView = localObject1;
        String str2 = null;
        if (paramView != null) {
          paramView = paramView.getDeviceModel();
        } else {
          paramView = null;
        }
        ALCameraDevice localALCameraDevice = localObject1;
        if (localALCameraDevice != null) {
          str2 = localALCameraDevice.getDeviceHwVer();
        }
        DeviceOfflineTroubleshootingActivity.p1(localModeSettingActivity, str1, paramView, str2);
      }
    }
  }
  
  static final class h<T>
    implements Comparator<CameraPreviewInfo>
  {
    public static final h c = new h();
    
    public final int a(CameraPreviewInfo paramCameraPreviewInfo1, CameraPreviewInfo paramCameraPreviewInfo2)
    {
      return paramCameraPreviewInfo1.l().compareTo(paramCameraPreviewInfo2.l());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\preview\mode\ModeSettingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */