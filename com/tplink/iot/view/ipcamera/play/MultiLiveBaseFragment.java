package com.tplink.iot.view.ipcamera.play;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ItemDecoration;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.State;
import b.d.d.m.f;
import com.tplink.iot.Utils.MultiScreenSnapHelper;
import com.tplink.iot.Utils.h;
import com.tplink.iot.Utils.x0.e;
import com.tplink.iot.adapter.databinding.DataBindingListAdapter;
import com.tplink.iot.databinding.FragmentMultiLiveVideoBinding;
import com.tplink.iot.databinding.LayoutDayNightModeBinding;
import com.tplink.iot.databinding.LayoutVoiceTalkPanelBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.view.ipcamera.widget.CloudTerraceControlPanel;
import com.tplink.iot.view.ipcamera.widget.CloudTerraceControlPanel.c;
import com.tplink.iot.view.ipcamera.widget.scollitem.ScrollPlayRatePicker.a;
import com.tplink.iot.viewmodel.ipcamera.play.CloudTerraceControlViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.LensMaskViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.MultiLiveVideoViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.TalkViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.VideoPlayViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.VodPlayRate;
import com.tplink.libmediaapi.live.LiveMediaAPI;
import com.tplink.libtpappcommonmedia.bean.stream.BitStreamType;
import com.tplink.libtpnetwork.Utils.j;
import com.tplink.libtpnetwork.cameranetwork.model.NightMode;
import io.reactivex.e0.b;
import io.reactivex.e0.c;
import io.reactivex.m0.d;
import io.reactivex.q;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Objects;

public class MultiLiveBaseFragment
  extends Fragment
  implements g, ScrollPlayRatePicker.a
{
  protected static final String c = MultiLiveBaseFragment.class.getSimpleName();
  protected Rect H3;
  protected Rect I3 = new Rect();
  protected FragmentMultiLiveVideoBinding J3;
  protected MultiScreenSnapHelper K3 = new MultiScreenSnapHelper();
  protected DataBindingListAdapter L3;
  protected int M3;
  protected boolean N3;
  protected View O3;
  protected GridLayoutManager P3;
  protected int Q3;
  protected int R3;
  final int S3 = 4;
  final int T3 = 1;
  final int U3 = 8;
  final int V3 = 32;
  protected h W3;
  protected int X3;
  protected int Y3 = 1;
  protected int Z3 = 32;
  protected float a4;
  protected int b4;
  protected Rect c4 = new Rect();
  protected VideoPlayViewModel d;
  protected int d4 = -1;
  protected int e4 = -1;
  protected MultiLiveVideoViewModel f;
  protected int f4;
  protected Rect[] g4;
  protected Dialog h4;
  protected Rect i4 = new Rect();
  protected ImageView j4;
  protected View k4;
  protected ImageView l4;
  final MutableLiveData<f<Pair<Bitmap, String>>> m4 = new MutableLiveData();
  final MutableLiveData<Boolean> n4 = new MutableLiveData();
  final MutableLiveData<Boolean> o4 = new MutableLiveData();
  protected String p0;
  protected Dialog p1;
  protected ImageView p2;
  protected Bitmap p3;
  protected final d<Integer> p4 = d.n1();
  protected CloudTerraceControlViewModel q;
  RelayLimitDialogFragment q4;
  private boolean r4 = false;
  protected CameraAudioDialogFragment s4;
  b t4 = new b();
  protected LensMaskViewModel x;
  protected TalkViewModel y;
  protected ArrayList<String> z;
  
  private void C0()
  {
    RelayLimitDialogFragment localRelayLimitDialogFragment = this.q4;
    if (localRelayLimitDialogFragment != null) {
      localRelayLimitDialogFragment.dismissAllowingStateLoss();
    }
  }
  
  private void F1()
  {
    e.t(this.d.j);
  }
  
  private void G1()
  {
    e.v(this.d.j);
  }
  
  private void I1()
  {
    int i = this.J3.p1.getClickedArea();
    if (i == -1) {
      return;
    }
    this.q.n(false, new b0(this, i));
  }
  
  private int L0(Context paramContext)
  {
    WindowManager localWindowManager = (WindowManager)paramContext.getSystemService("window");
    int i = 0;
    if (localWindowManager == null) {
      return 0;
    }
    Object localObject = localWindowManager.getDefaultDisplay();
    paramContext = new DisplayMetrics();
    try
    {
      Class.forName("android.view.Display").getMethod("getRealMetrics", new Class[] { DisplayMetrics.class }).invoke(localObject, new Object[] { paramContext });
      localObject = new android/graphics/Point;
      ((Point)localObject).<init>();
      localWindowManager.getDefaultDisplay().getSize((Point)localObject);
      int j = paramContext.heightPixels;
      int k = ((Point)localObject).y;
      i = j - k;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return i;
  }
  
  private void L1(String paramString)
  {
    if (this.r4) {
      return;
    }
    this.r4 = true;
    RelayLimitDialogFragment localRelayLimitDialogFragment = new RelayLimitDialogFragment();
    this.q4 = localRelayLimitDialogFragment;
    localRelayLimitDialogFragment.L0(new b());
    this.q4.K0(new a0(this));
    this.q4.J0(paramString);
    paramString = getActivity();
    if (paramString != null)
    {
      paramString = paramString.getSupportFragmentManager();
      this.q4.show(paramString, "main.RelayLimitDialogFragment");
    }
  }
  
  private void P0()
  {
    FragmentActivity localFragmentActivity = getActivity();
    Objects.requireNonNull(localFragmentActivity);
    localFragmentActivity = (FragmentActivity)localFragmentActivity;
    Object localObject = (VideoPlayViewModel)ViewModelProviders.of(localFragmentActivity).get(VideoPlayViewModel.class);
    this.d = ((VideoPlayViewModel)localObject);
    localObject = ((VideoPlayViewModel)localObject).j;
    this.p0 = ((String)localObject);
    if (localObject == null)
    {
      b.d.w.c.a.n(c, Log.getStackTraceString(new Throwable("persistedDeviceIdMD5 should not be null")));
      this.p0 = "";
    }
    this.W3 = new h(localFragmentActivity, this.p0);
    localObject = (MultiLiveVideoViewModel)ViewModelProviders.of(localFragmentActivity).get(MultiLiveVideoViewModel.class);
    this.f = ((MultiLiveVideoViewModel)localObject);
    ((MultiLiveVideoViewModel)localObject).x0(this.d);
    this.f.t0(this.W3.a());
    MultiLiveVideoViewModel localMultiLiveVideoViewModel = this.f;
    localObject = localMultiLiveVideoViewModel.z;
    this.z = ((ArrayList)localObject);
    localMultiLiveVideoViewModel.y.setValue(Integer.valueOf(((ArrayList)localObject).indexOf(this.p0)));
    localObject = (LensMaskViewModel)ViewModelProviders.of(localFragmentActivity).get(LensMaskViewModel.class);
    this.x = ((LensMaskViewModel)localObject);
    ((LensMaskViewModel)localObject).E(this.f);
    this.y = ((TalkViewModel)ViewModelProviders.of(localFragmentActivity).get(TalkViewModel.class));
    O0();
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void S0()
  {
    R0();
    Q0();
    N0();
    if (getActivity() != null) {
      this.O3 = getActivity().getWindow().getDecorView();
    }
    Object localObject = getContext();
    int i;
    if (this.f.p0.get()) {
      i = 2;
    } else {
      i = 1;
    }
    localObject = new GridLayoutManager((Context)localObject, i, 0, false);
    this.P3 = ((GridLayoutManager)localObject);
    this.J3.z.setLayoutManager((RecyclerView.LayoutManager)localObject);
    this.J3.z.setAdapter(this.L3);
    this.J3.z.addItemDecoration(new a());
    this.K3.attachToRecyclerView(this.J3.z);
    this.J3.z.setOnTouchListener(new z(this));
    this.J3.q.c.addOnLayoutChangeListener(new k0(this));
  }
  
  protected void B0() {}
  
  protected void G0()
  {
    this.y.l(this.d.j);
  }
  
  protected void H0() {}
  
  protected void H1(Dialog paramDialog)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    WindowManager localWindowManager = (WindowManager)paramDialog.getContext().getApplicationContext().getSystemService("window");
    if (localWindowManager == null) {
      return;
    }
    localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
    int i = localDisplayMetrics.heightPixels;
    int j = L0(paramDialog.getContext());
    paramDialog = paramDialog.getWindow();
    if (paramDialog == null) {
      return;
    }
    paramDialog.setLayout(-1, i + j);
    paramDialog = paramDialog.getDecorView();
    if (this.d.G.get()) {
      i = 4;
    } else {
      i = 0;
    }
    paramDialog.setSystemUiVisibility(i);
  }
  
  protected void I0() {}
  
  Rect J0(View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    return new Rect(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + paramView.getWidth(), arrayOfInt[1] + paramView.getHeight());
  }
  
  protected void J1() {}
  
  protected Bitmap K0(View paramView)
  {
    paramView.clearFocus();
    paramView.setPressed(false);
    boolean bool = paramView.willNotCacheDrawing();
    paramView.setWillNotCacheDrawing(false);
    int i = paramView.getDrawingCacheBackgroundColor();
    paramView.setDrawingCacheBackgroundColor(0);
    if (i != 0) {
      paramView.destroyDrawingCache();
    }
    paramView.buildDrawingCache();
    Bitmap localBitmap = paramView.getDrawingCache();
    if (localBitmap == null) {
      return null;
    }
    localBitmap = Bitmap.createBitmap(localBitmap);
    paramView.destroyDrawingCache();
    paramView.setWillNotCacheDrawing(bool);
    paramView.setDrawingCacheBackgroundColor(i);
    return localBitmap;
  }
  
  protected void K1() {}
  
  protected void M1(Bitmap paramBitmap) {}
  
  protected void N0()
  {
    this.J3.p1.setOnClickListener(new e0(this));
    this.J3.p1.setOnLongPressListener(new c());
  }
  
  protected void N1() {}
  
  protected void O0()
  {
    Object localObject = getActivity();
    Objects.requireNonNull(localObject);
    localObject = (CloudTerraceControlViewModel)ViewModelProviders.of((FragmentActivity)localObject).get(CloudTerraceControlViewModel.class);
    this.q = ((CloudTerraceControlViewModel)localObject);
    ((CloudTerraceControlViewModel)localObject).n0(getActivity());
    this.q.Q3.observe(this, new c0(this));
  }
  
  protected void O1()
  {
    this.f.C0(this);
    this.d.C(this);
    this.y.a0(this);
    this.m4.observe(this, new f0(this));
    this.d.k.observe(this, new q0(this));
    this.f.l4.observe(this, new i0(this));
    this.f.k4.observe(this, new d0(this));
    this.f.m4.observe(this, new p0(this));
    c localc = this.p4.G0(new h0(this));
    this.t4.b(localc);
    this.d.e.observe(this, new r0(this));
    this.d.h.observe(this, new g0(this));
    this.d.i.observe(this, new m0(this));
    this.x.c.observe(this, new n0(this));
  }
  
  protected void P1() {}
  
  @SuppressLint({"ClickableViewAccessibility"})
  protected void Q0() {}
  
  protected void Q1()
  {
    if (this.y.k.get())
    {
      G0();
      this.d.y("VideoPlay.VideoControlPanelFragment");
    }
    else if (this.f.p0.get())
    {
      this.d.e.setValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a("VideoPlay.TalkFragment"));
    }
    else
    {
      this.d.y("VideoPlay.TalkFragment");
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  protected void R0()
  {
    this.J3.y.x.setOnTouchListener(new j0(this));
  }
  
  protected void R1()
  {
    if (this.y.k.get())
    {
      G0();
      this.d.y("VideoPlay.VideoControlPanelFragment");
    }
    else if (this.f.p0.get())
    {
      this.d.e.setValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a("VideoPlay.VoiceCallFragment"));
    }
    else
    {
      this.d.y("VideoPlay.VoiceCallFragment");
    }
  }
  
  protected void S1(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2) {}
  
  public void e(VodPlayRate paramVodPlayRate) {}
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((2 == paramInt1) && (paramInt2 == -1)) {
      S1(paramIntent.getStringArrayListExtra("incremental_mac_list"), paramIntent.getStringArrayListExtra("reduced_mac_list"));
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    int j;
    if ((i != 2131362001) && (i != 2131364262) && (i != 2131362704) && (i != 2131364274)) {
      j = 1;
    } else {
      j = 0;
    }
    if ((j != 0) && (this.f.I())) {
      return;
    }
    if ((j.h(this.d.m)) && ((i == 2131362698) || (i == 2131362707) || (i == 2131362709) || (i == 2131362711)))
    {
      Toast.makeText(getActivity(), 2131952051, 0).show();
      return;
    }
    switch (i)
    {
    default: 
      switch (i)
      {
      default: 
        switch (i)
        {
        default: 
          switch (i)
          {
          default: 
            switch (i)
            {
            }
            break;
          case 2131364269: 
            boolean bool = this.f.j4.get() ^ true;
            this.f.j4.set(bool);
            if (bool) {
              LiveMediaAPI.resume(this.p0);
            } else {
              LiveMediaAPI.pause(this.p0);
            }
            break;
          case 2131364267: 
            this.f.y0(NightMode.NIGHT);
            this.f.j0(false);
            break;
          case 2131364266: 
            this.f.z0(BitStreamType.MINOR_VGA);
            e.f(this.d.j);
            this.f.k0(false);
            break;
          case 2131364265: 
            this.f.z0(BitStreamType.MAIN_HD);
            e.f(this.d.j);
            this.f.k0(false);
            break;
          case 2131364264: 
            this.f.y0(NightMode.DAY);
            this.f.j0(false);
            break;
          case 2131364263: 
            this.f.y0(NightMode.AUTO);
            this.f.j0(false);
            break;
          case 2131364262: 
            paramView = this.d;
            paramView.A(true ^ paramView.G.get());
            this.f.z();
          }
          break;
        case 2131362711: 
          R1();
          this.y.m.set(true);
          paramView = this.y.k;
          paramView.set(true ^ paramView.get());
          break;
        case 2131362709: 
          Q1();
          this.y.m.set(false);
          paramView = this.y.k;
          paramView.set(true ^ paramView.get());
          break;
        case 2131362708: 
          G1();
          this.f.s0();
          break;
        case 2131362707: 
          paramView = this.f.I3;
          paramView.set(true ^ paramView.get());
          break;
        case 2131362706: 
          N1();
        }
        break;
      case 2131362700: 
        J1();
        break;
      case 2131362699: 
        paramView = this.f;
        paramView.k0(true ^ paramView.a4.get());
        break;
      case 2131362698: 
        paramView = this.f;
        paramView.j0(true ^ paramView.Q3.get());
        this.d.h.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(""));
      }
      break;
    case 2131364080: 
      this.y.b0();
      break;
    case 2131363788: 
      F1();
      this.f.K0();
      break;
    case 2131363456: 
      this.y.c0();
      break;
    case 2131362704: 
      B0();
      break;
    case 2131362168: 
      this.y.k.set(false);
      this.y.l(this.d.j);
      this.y.Z();
      this.d.y("VideoPlay.VideoControlPanelFragment");
      break;
    case 2131362001: 
      this.d.A(false);
      this.f.z();
    }
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    P0();
    O1();
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramLayoutInflater = (FragmentMultiLiveVideoBinding)DataBindingUtil.inflate(paramLayoutInflater, 2131558938, paramViewGroup, false);
    this.J3 = paramLayoutInflater;
    paramLayoutInflater.setLifecycleOwner(this);
    this.J3.m(this);
    this.J3.l(this.d);
    this.J3.i(this.f);
    this.J3.h(this.q);
    this.J3.n(this.y);
    S0();
    if (getActivity() != null) {
      getActivity().getWindow().addFlags(128);
    }
    return this.J3.getRoot();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.f.p0.get()) {
      P1();
    }
    this.W3.c(this.f.p0.get() ^ true, this.z);
    this.t4.d();
    Dialog localDialog = this.p1;
    if ((localDialog != null) && (localDialog.isShowing())) {
      this.p1.dismiss();
    }
    localDialog = this.h4;
    if ((localDialog != null) && (localDialog.isShowing())) {
      this.h4.dismiss();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    C0();
    this.f.e4.set(false);
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    if (this.W3.b()) {
      this.P3.scrollToPosition(((Integer)j.e(this.f.y, Integer.valueOf(0))).intValue());
    } else {
      B0();
    }
  }
  
  class a
    extends RecyclerView.ItemDecoration
  {
    a() {}
    
    public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
    {
      int i = paramRecyclerView.getChildAdapterPosition(paramView);
      if (i == -1) {
        return;
      }
      boolean bool1 = MultiLiveBaseFragment.this.f.p0.get();
      boolean bool2 = true;
      if (bool1)
      {
        paramView = MultiLiveBaseFragment.this.f;
        if (paramRecyclerView.getScrollState() == 0) {
          bool2 = false;
        }
        paramRect.set(paramView.D(i, bool2));
      }
      else if ((i != 0) && (paramRecyclerView.getScrollState() != 0))
      {
        paramRect.left = 1;
        paramRect.right = 1;
      }
    }
    
    public void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.State paramState)
    {
      super.onDraw(paramCanvas, paramRecyclerView, paramState);
    }
  }
  
  class b
    implements RelayLimitDialogFragment.a
  {
    b() {}
    
    public void a() {}
    
    public void b()
    {
      MultiLiveBaseFragment.this.p4.onNext(Integer.valueOf(-1));
    }
  }
  
  class c
    implements CloudTerraceControlPanel.c
  {
    c() {}
    
    public void a()
    {
      MultiLiveBaseFragment.A0(MultiLiveBaseFragment.this);
    }
    
    public void b()
    {
      MultiLiveBaseFragment.this.q.q0();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\play\MultiLiveBaseFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */