package com.tplink.iot.view.ipcamera.play;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.State;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.OnItemTouchListener;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;
import androidx.recyclerview.widget.RecyclerView.SimpleOnItemTouchListener;
import androidx.recyclerview.widget.RecyclerView.State;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tplink.iot.Utils.MultiScreenSnapHelper;
import com.tplink.iot.adapter.databinding.DataBindingListAdapter;
import com.tplink.iot.adapter.databinding.DataBindingListAdapter.ViewHolder;
import com.tplink.iot.databinding.DialogMultiLiveDragBinding;
import com.tplink.iot.databinding.FragmentMultiLiveVideoBinding;
import com.tplink.iot.databinding.LayoutFullScreenBottomBarBinding;
import com.tplink.iot.databinding.LayoutMultiLiveToolbarBottomBinding;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar;
import com.tplink.iot.viewmodel.ipcamera.play.MultiLiveVideoViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.TalkViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.VideoPlayViewModel;
import com.tplink.libmediaapi.live.LiveMediaAPI;
import java.util.ArrayList;
import java.util.Objects;

public class MultiLiveAdvancedFragment
  extends MultiLiveBaseFragment
{
  private final String u4 = MultiLiveAdvancedFragment.class.getSimpleName();
  protected com.tplink.iot.adapter.databinding.d v4 = new p(this);
  protected com.tplink.iot.adapter.databinding.e w4 = new v(this);
  protected RecyclerView.OnItemTouchListener x4 = new a();
  
  private void P0()
  {
    ArrayList localArrayList = this.z;
    io.reactivex.m0.d locald = this.p4;
    Object localObject1 = this.v4;
    com.tplink.iot.adapter.databinding.e locale = this.w4;
    Object localObject2 = this.f;
    ObservableBoolean localObservableBoolean1 = ((MultiLiveVideoViewModel)localObject2).p0;
    MutableLiveData localMutableLiveData1 = ((MultiLiveVideoViewModel)localObject2).y;
    MutableLiveData localMutableLiveData2 = this.o4;
    ObservableBoolean localObservableBoolean2 = ((MultiLiveVideoViewModel)localObject2).X3;
    ObservableBoolean localObservableBoolean3 = this.d.G;
    localObject2 = ((MultiLiveVideoViewModel)localObject2).Z3;
    localObject1 = new b(2131559059, new int[] { 16, 86, 9, 59, 46, 13, 83, 39, 25, 101 }, new int[] { 16 }, new Object[] { localArrayList, locald, localObject1, locale, localObservableBoolean1, localMutableLiveData1, localMutableLiveData2, localObservableBoolean2, localObservableBoolean3, localObject2 });
    this.L3 = ((DataBindingListAdapter)localObject1);
    ((DataBindingListAdapter)localObject1).B(this);
  }
  
  private void S0()
  {
    this.J3.z.addOnItemTouchListener(this.x4);
  }
  
  private int V1(Rect paramRect1, Rect paramRect2)
  {
    int i = paramRect1.left;
    int j = paramRect2.left;
    if (i <= j) {
      i = j;
    }
    int k = paramRect1.right;
    j = paramRect2.right;
    if (k < j) {
      j = k;
    }
    int m = 0;
    if (i >= j) {
      return 0;
    }
    int n = paramRect1.top;
    k = paramRect2.top;
    if (n > k) {
      k = n;
    }
    int i1 = paramRect1.bottom;
    n = paramRect2.bottom;
    if (i1 < n) {
      n = i1;
    }
    if (k >= n) {
      return 0;
    }
    i = (n - k) * (j - i);
    if (i < 0) {
      i = m;
    }
    return i;
  }
  
  private void X1()
  {
    if ((this.s4 != null) && (this.y.t.get()))
    {
      this.s4.C0(true);
      this.y.t.set(false);
    }
  }
  
  private void Y1(GridLayoutManager paramGridLayoutManager, int paramInt)
  {
    int i = paramGridLayoutManager.findFirstVisibleItemPosition();
    int j = paramGridLayoutManager.findLastVisibleItemPosition();
    int m;
    for (int k = 0; i <= j; k = m)
    {
      View localView = paramGridLayoutManager.findViewByPosition(i);
      m = k;
      if (localView != null)
      {
        m = k;
        if (localView.getWidth() != paramInt)
        {
          localView.getLayoutParams().width = paramInt;
          m = 1;
        }
      }
      i++;
    }
    if (k != 0)
    {
      this.P3.setInitialPrefetchItemCount(0);
      this.P3.setItemPrefetchEnabled(false);
      this.J3.z.setItemViewCacheSize(0);
      this.P3.setInitialPrefetchItemCount(2);
      this.P3.setItemPrefetchEnabled(true);
      this.J3.z.setItemViewCacheSize(2);
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void b2()
  {
    this.y.t.set(true);
    this.s4.show(getChildFragmentManager(), "CameraAudioDialog");
    this.s4.Q0(new s(this));
    this.s4.P0(new o(this));
    this.f.Q3.set(false);
    this.f.a4.set(false);
  }
  
  private void d2(boolean paramBoolean)
  {
    Object localObject = (com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a)this.d.l().getValue();
    if (localObject == null) {
      localObject = "";
    } else {
      localObject = (String)((com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a)localObject).c();
    }
    if (paramBoolean)
    {
      if ("VideoPlay.CloudTerraceControlFragment".equals(localObject)) {
        this.f.I3.set(true);
      } else if ("VideoPlay.VideoControlPanelFragment".equals(localObject)) {
        this.f.I3.set(false);
      }
    }
    else if (!this.y.k.get()) {
      if (this.f.I3.get())
      {
        if ("VideoPlay.VideoControlPanelFragment".equals(localObject)) {
          this.d.y("VideoPlay.CloudTerraceControlFragment");
        }
      }
      else if ("VideoPlay.CloudTerraceControlFragment".equals(localObject)) {
        this.d.y("VideoPlay.VideoControlPanelFragment");
      }
    }
  }
  
  protected void B0()
  {
    if (this.d.j != null) {
      com.tplink.iot.Utils.x0.e.d(this.f.C());
    }
    if (this.f.y())
    {
      localObject = TSnackbar.B(this, 2131953166, 3000);
      ((TSnackbar)localObject).J(Color.parseColor("#4CA6FF"));
      if (getContext() != null) {
        ((TSnackbar)localObject).G(getContext().getResources().getDrawable(2131689573), null);
      }
      ((TSnackbar)localObject).N();
    }
    LiveMediaAPI.keepDoubleTalk(this.f.C());
    boolean bool = this.f.p0.get();
    P1();
    this.f.E0();
    this.L3.n();
    int i = this.Y3;
    Object localObject = this.f;
    this.M3 = ((i - 1) * ((MultiLiveVideoViewModel)localObject).x);
    localObject = ((MultiLiveVideoViewModel)localObject).y;
    int j = 0;
    int k = ((Integer)com.tplink.libtpnetwork.Utils.j.e((MutableLiveData)localObject, Integer.valueOf(0))).intValue();
    int m = 4;
    if (bool)
    {
      int n = this.M3;
      i = j;
      if (k > n)
      {
        i = j;
        if (k - n < 4) {
          i = 1;
        }
      }
      if (i != 0) {
        this.M3 = k;
      }
    }
    bool ^= true;
    localObject = this.f;
    if (bool) {
      i = 4;
    } else {
      i = 1;
    }
    ((MultiLiveVideoViewModel)localObject).x = i;
    ((MultiLiveVideoViewModel)localObject).p0.set(bool);
    localObject = this.K3;
    if (bool) {
      i = m;
    } else {
      i = 1;
    }
    ((MultiScreenSnapHelper)localObject).d(i);
    this.N3 = true;
    localObject = getContext();
    if (bool) {
      i = 2;
    } else {
      i = 1;
    }
    localObject = new c((Context)localObject, i, 0, false);
    this.P3 = ((GridLayoutManager)localObject);
    this.J3.z.setLayoutManager((RecyclerView.LayoutManager)localObject);
  }
  
  protected void C2()
  {
    if ((this.z.get(this.b4) != null) && (!((String)this.z.get(this.b4)).equals(this.p0)) && (c2()))
    {
      this.l4.setBackground(getResources().getDrawable(2131231009));
      this.k4.setVisibility(4);
      return;
    }
    this.l4.setBackground(null);
    this.k4.setVisibility(0);
    if (this.f.p0.get())
    {
      int i = a2();
      ConstraintLayout.LayoutParams localLayoutParams = (ConstraintLayout.LayoutParams)this.k4.getLayoutParams();
      Rect localRect1;
      int j;
      if (i == -1)
      {
        i = localLayoutParams.getMarginStart();
        localRect1 = this.i4;
        j = localRect1.left;
        if ((i != j) || (localLayoutParams.topMargin != localRect1.top))
        {
          localLayoutParams.setMarginStart(j);
          localLayoutParams.topMargin = this.i4.top;
          this.k4.setLayoutParams(localLayoutParams);
        }
      }
      else
      {
        Rect localRect2 = this.g4[(i & 0x3)];
        localRect1 = this.i4;
        i = localRect1.left;
        j = localRect2.left;
        Rect localRect3 = this.c4;
        i += j - localRect3.left;
        j = localRect1.top + (localRect2.top - localRect3.top);
        if ((localLayoutParams.getMarginStart() != i) || (localLayoutParams.topMargin != j))
        {
          localLayoutParams.setMarginStart(i);
          localLayoutParams.topMargin = j;
          this.k4.setLayoutParams(localLayoutParams);
        }
      }
    }
  }
  
  protected void D2()
  {
    int i = this.P3.findFirstVisibleItemPosition();
    int j = this.P3.findLastVisibleItemPosition();
    int k = ((Integer)com.tplink.libtpnetwork.Utils.j.e(this.f.y, Integer.valueOf(0))).intValue();
    if ((i != -1) && ((i > k) || (k > j)))
    {
      for (k = i; k <= j; k++) {
        if (!TextUtils.isEmpty((CharSequence)this.f.z.get(k)))
        {
          this.f.y.setValue(Integer.valueOf(k));
          return;
        }
      }
      if (!com.tplink.libtpnetwork.Utils.j.b(this.f.y, Integer.valueOf(i))) {
        this.f.y.setValue(Integer.valueOf(i));
      }
    }
  }
  
  protected void E2()
  {
    boolean bool = this.f.p0.get();
    int i;
    if (bool) {
      i = 8;
    } else {
      i = 32;
    }
    int j = this.Z3;
    int k = 1;
    if (j != i)
    {
      this.Z3 = i;
      i = 1;
    }
    else
    {
      i = 0;
    }
    j = this.P3.findFirstVisibleItemPosition();
    if ((bool) && ((j & 0x3) > 1)) {
      return;
    }
    j = j / this.f.x + 1;
    if (this.Y3 != j)
    {
      this.Y3 = j;
      i = k;
    }
    if (i != 0) {
      this.J3.p0.setText(Z1());
    }
  }
  
  protected void H0()
  {
    X1();
  }
  
  protected void I0()
  {
    X1();
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  protected void J1()
  {
    if (this.y.t.get()) {
      return;
    }
    this.s4 = MicrophoneControlDialogFragment.S0(this.d.G.get());
    Context localContext = getContext();
    if (localContext != null)
    {
      int i;
      int j;
      if (this.d.G.get())
      {
        i = b.d.w.f.a.a(localContext, 27.0F);
        j = -b.d.w.f.a.a(localContext, 6.0F);
        this.s4.A0(this.J3.d.f, i, j);
      }
      else
      {
        i = b.d.w.f.a.a(localContext, 74.0F);
        j = -b.d.w.f.a.a(localContext, 36.0F);
        this.s4.A0(this.J3.p3.p3, i, j);
      }
    }
    b2();
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  protected void K1()
  {
    if (getContext() == null) {
      return;
    }
    Object localObject = this.h4;
    if (localObject == null)
    {
      localObject = new Dialog(getContext(), 2132017477);
      this.h4 = ((Dialog)localObject);
      ((Dialog)localObject).setContentView(2131558810);
      H1(this.h4);
      localObject = (DialogMultiLiveDragBinding)DataBindingUtil.bind(this.h4.findViewById(2131362321));
      if (localObject != null)
      {
        ((ViewDataBinding)localObject).setLifecycleOwner(this);
        ((DialogMultiLiveDragBinding)localObject).h(this.n4);
      }
      localObject = (ImageView)this.h4.findViewById(2131363508);
      this.l4 = ((ImageView)localObject);
      ((ImageView)localObject).setImageResource(2131230904);
      this.h4.findViewById(2131362321).setOnTouchListener(new x(this));
      this.k4 = this.h4.findViewById(2131363685);
      this.j4 = ((ImageView)this.h4.findViewById(2131362810));
      this.h4.setCanceledOnTouchOutside(false);
      this.h4.setOnDismissListener(new u(this));
      this.h4.setOnShowListener(new w(this));
    }
    else
    {
      H1((Dialog)localObject);
    }
    this.h4.show();
  }
  
  protected void M1(Bitmap paramBitmap)
  {
    if ((getContext() != null) && (paramBitmap != null))
    {
      Object localObject1 = this.h4;
      if (((localObject1 == null) || (!((Dialog)localObject1).isShowing())) && (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED)))
      {
        this.p3 = paramBitmap;
        if (this.H3 == null)
        {
          this.H3 = new Rect();
          paramBitmap = getActivity();
          Objects.requireNonNull(paramBitmap);
          paramBitmap = ((FragmentActivity)paramBitmap).findViewById(2131363449);
          if (paramBitmap == null) {
            return;
          }
          localObject2 = new int[2];
          paramBitmap.getLocationOnScreen((int[])localObject2);
          localObject1 = this.H3;
          i = localObject2[0];
          ((Rect)localObject1).left = i;
          ((Rect)localObject1).top = localObject2[1];
          ((Rect)localObject1).right = (i + paramBitmap.getWidth());
          localObject1 = this.H3;
          ((Rect)localObject1).bottom = (((Rect)localObject1).top + paramBitmap.getHeight());
        }
        paramBitmap = this.f.C();
        int i = this.f.z.indexOf(paramBitmap);
        paramBitmap = this.P3.findViewByPosition(i);
        if (paramBitmap == null) {
          return;
        }
        localObject1 = new int[2];
        paramBitmap.getLocationOnScreen((int[])localObject1);
        Object localObject2 = this.I3;
        i = localObject1[0];
        ((Rect)localObject2).left = i;
        ((Rect)localObject2).top = localObject1[1];
        ((Rect)localObject2).right = (i + paramBitmap.getWidth());
        localObject1 = this.I3;
        ((Rect)localObject1).bottom = (((Rect)localObject1).top + paramBitmap.getHeight());
        if (this.p1 == null)
        {
          paramBitmap = new Dialog(getContext(), 2132017477);
          this.p1 = paramBitmap;
          paramBitmap.setContentView(2131558811);
          H1(this.p1);
          this.p1.setCancelable(false);
          paramBitmap = (ImageView)this.p1.findViewById(2131363966);
          this.p2 = paramBitmap;
          paramBitmap.setPivotX(0.0F);
          this.p2.setPivotY(0.0F);
          paramBitmap = this.p1.getWindow();
          if (paramBitmap == null) {
            return;
          }
          paramBitmap.setDimAmount(0.2F);
          localObject1 = new Rect();
          paramBitmap.getDecorView().getWindowVisibleDisplayFrame((Rect)localObject1);
          i = ((Rect)localObject1).top;
          this.p1.setOnShowListener(new t(this, i));
        }
        this.p1.show();
      }
    }
  }
  
  protected void N1()
  {
    if (this.y.t.get()) {
      return;
    }
    this.s4 = VolumeControlDialogFragment.S0(true);
    Context localContext = getContext();
    if (localContext != null)
    {
      int i = -b.d.w.f.a.a(localContext, 10.0F);
      int j = -b.d.w.f.a.a(localContext, 6.0F);
      this.s4.A0(this.J3.d.x, i, j);
      b2();
    }
  }
  
  protected void P1()
  {
    for (int i = 0; i < 32; i += 4)
    {
      Object localObject1 = this.z;
      int j = i + 1;
      localObject1 = (String)((ArrayList)localObject1).get(j);
      Object localObject2 = this.z;
      int k = i + 2;
      localObject2 = (String)((ArrayList)localObject2).get(k);
      if ((localObject1 != null) || (localObject2 != null))
      {
        this.z.set(j, localObject2);
        this.z.set(k, localObject1);
      }
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  protected void Q0()
  {
    this.J3.p0.setText("<   01/32   >");
    this.J3.z.addOnScrollListener(new d());
    this.J3.p0.setOnTouchListener(new r(this));
    this.J3.p0.setOnClickListener(new y(this));
  }
  
  protected void S1(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
  {
    int i;
    if ((paramArrayList1.size() <= 0) && (paramArrayList2.size() <= 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i == 0) {
      return;
    }
    if (this.f.p0.get())
    {
      P1();
      int j = this.X3;
      int k = j & 0x3;
      if (k == 2)
      {
        i = j - 1;
      }
      else
      {
        i = j;
        if (k == 1) {
          i = j + 1;
        }
      }
      this.f.J0(paramArrayList1, paramArrayList2, i);
      P1();
    }
    else
    {
      this.f.J0(paramArrayList1, paramArrayList2, this.X3);
    }
    if (paramArrayList1.size() > 0) {
      this.f.y.setValue(Integer.valueOf(this.X3));
    }
    this.M3 = this.f.E(this.X3);
    this.L3.s();
    this.P3.scrollToPositionWithOffset(this.M3, 0);
  }
  
  protected void U1()
  {
    int i;
    Object localObject;
    if ((!TextUtils.equals((CharSequence)this.z.get(this.b4), this.p0)) && (c2()))
    {
      this.z.set(this.b4, null);
      this.L3.notifyItemChanged(this.b4);
      if (!this.f.p0.get())
      {
        i = this.f.p3;
        this.M3 = i;
        this.P3.scrollToPosition(i);
      }
      else
      {
        localObject = this.f;
        i = ((MultiLiveVideoViewModel)localObject).p3;
        this.M3 = i;
        ((MultiLiveVideoViewModel)localObject).y.setValue(Integer.valueOf(i));
      }
      this.J3.z.invalidateItemDecorations();
    }
    else if (this.f.p0.get())
    {
      i = a2();
      if (i != -1)
      {
        String str = (String)this.z.get(this.b4);
        localObject = (String)this.z.get(i);
        this.z.set(i, str);
        this.z.set(this.b4, localObject);
        this.M3 = this.f.E(i);
        this.f.y.setValue(Integer.valueOf(i));
        this.L3.s();
        if ((i & 0x3) == 0) {
          this.P3.scrollToPositionWithOffset(this.M3, 0);
        } else {
          this.P3.scrollToPosition(this.M3);
        }
        this.J3.z.invalidateItemDecorations();
      }
    }
  }
  
  protected void W1(MotionEvent paramMotionEvent)
  {
    this.f.z();
    Dialog localDialog = this.h4;
    if ((localDialog != null) && (localDialog.isShowing()) && (this.j4 != null))
    {
      int i = paramMotionEvent.getAction();
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3) {
            return;
          }
        }
        else
        {
          if (this.d4 == -1)
          {
            this.d4 = ((int)paramMotionEvent.getRawX());
            this.e4 = ((int)paramMotionEvent.getRawY());
            return;
          }
          i = (int)paramMotionEvent.getRawX();
          int j = (int)paramMotionEvent.getRawY();
          int k = this.d4;
          int m = this.e4;
          paramMotionEvent = this.j4;
          paramMotionEvent.setTranslationX(paramMotionEvent.getTranslationX() + (i - k));
          paramMotionEvent = this.j4;
          paramMotionEvent.setTranslationY(paramMotionEvent.getTranslationY() + (j - m));
          this.d4 = i;
          this.e4 = j;
          C2();
          return;
        }
      }
      U1();
      paramMotionEvent = this.h4;
      if ((paramMotionEvent != null) && (paramMotionEvent.isShowing())) {
        this.h4.dismiss();
      }
    }
  }
  
  protected String Z1()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<   ");
    int i = this.Y3;
    String str1 = "0";
    String str2;
    if (i < 10) {
      str2 = "0";
    } else {
      str2 = "";
    }
    localStringBuilder.append(str2);
    localStringBuilder.append(this.Y3);
    localStringBuilder.append("/");
    if (this.Z3 < 10) {
      str2 = str1;
    } else {
      str2 = "";
    }
    localStringBuilder.append(str2);
    localStringBuilder.append(this.Z3);
    localStringBuilder.append("   >");
    return localStringBuilder.toString();
  }
  
  protected int a2()
  {
    Rect localRect = J0(this.j4);
    int i = this.f4;
    int j = this.f.E(this.b4);
    Rect[] arrayOfRect = this.g4;
    int k = -1;
    if (arrayOfRect == null) {
      return -1;
    }
    int m = 0;
    int n = -1;
    while (m < 4)
    {
      int i1 = V1(this.g4[m], localRect);
      int i2 = i;
      if (i1 > i)
      {
        n = j + m;
        i2 = i1;
      }
      m++;
      i = i2;
    }
    if (this.b4 == n) {
      n = k;
    }
    return n;
  }
  
  protected boolean c2()
  {
    boolean bool;
    if (V1(J0(this.l4), J0(this.j4)) > 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (com.tplink.libtpnetwork.Utils.j.a(this.d.f, 2131952997)) {
      this.d.f.setValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(""));
    }
    Object localObject = getActivity();
    boolean bool1 = true;
    if (localObject != null)
    {
      localObject = this.P3;
      if (localObject != null)
      {
        int i = ((LinearLayoutManager)localObject).findFirstVisibleItemPosition();
        int j = this.P3.findLastVisibleItemPosition();
        boolean bool2 = com.tplink.iot.Utils.j.e(getActivity());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("CameraScreen hasCutout: ");
        ((StringBuilder)localObject).append(bool2);
        b.d.w.c.a.a(((StringBuilder)localObject).toString());
        if ((paramConfiguration.orientation == 2) && (bool2)) {
          this.R3 = (this.O3.getHeight() - b.d.w.f.a.f(getActivity()));
        } else {
          this.R3 = this.O3.getHeight();
        }
        this.Q3 = ((int)(this.R3 / 2.0F));
        bool2 = this.f.p0.get();
        while (i <= j)
        {
          localObject = this.P3.findViewByPosition(i);
          if (localObject != null)
          {
            localObject = ((View)localObject).getLayoutParams();
            int k;
            if (bool2) {
              k = this.Q3;
            } else {
              k = this.R3;
            }
            ((ViewGroup.LayoutParams)localObject).width = k;
          }
          i++;
        }
        this.P3.setInitialPrefetchItemCount(0);
        this.P3.setItemPrefetchEnabled(false);
        this.J3.z.setItemViewCacheSize(0);
        this.P3.setInitialPrefetchItemCount(2);
        this.P3.setItemPrefetchEnabled(true);
        this.J3.z.setItemViewCacheSize(2);
      }
    }
    if (paramConfiguration.orientation != 2) {
      bool1 = false;
    }
    d2(bool1);
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    P0();
    if (getActivity() != null)
    {
      paramBundle = getActivity().getWindow().getDecorView();
      paramBundle.setOnSystemUiVisibilityChangeListener(new q(this, paramBundle));
    }
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    S0();
    return paramLayoutInflater;
  }
  
  public void onStart()
  {
    super.onStart();
    GridLayoutManager localGridLayoutManager = this.P3;
    int i;
    if (this.f.p0.get()) {
      i = this.Q3;
    } else {
      i = this.R3;
    }
    Y1(localGridLayoutManager, i);
    LiveMediaAPI.bindRecordingVariable(this.f.e4);
  }
  
  public void onStop()
  {
    super.onStop();
    if (LiveMediaAPI.getRecordingObservable() == this.f.e4) {
      LiveMediaAPI.bindRecordingVariable(null);
    }
  }
  
  class a
    extends RecyclerView.SimpleOnItemTouchListener
  {
    a() {}
    
    public boolean onInterceptTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
    {
      MultiLiveAdvancedFragment.this.f.z();
      Dialog localDialog = MultiLiveAdvancedFragment.this.h4;
      if ((localDialog != null) && (localDialog.isShowing()) && (MultiLiveAdvancedFragment.this.j4 != null))
      {
        if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
        {
          MultiLiveAdvancedFragment.this.U1();
          paramRecyclerView = MultiLiveAdvancedFragment.this.h4;
          if ((paramRecyclerView != null) && (paramRecyclerView.isShowing())) {
            MultiLiveAdvancedFragment.this.h4.dismiss();
          }
        }
        return true;
      }
      return super.onInterceptTouchEvent(paramRecyclerView, paramMotionEvent);
    }
    
    public void onTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
    {
      MultiLiveAdvancedFragment.this.W1(paramMotionEvent);
      super.onTouchEvent(paramRecyclerView, paramMotionEvent);
    }
  }
  
  class b
    extends DataBindingListAdapter
  {
    b(int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2, Object... paramVarArgs)
    {
      super(paramArrayOfInt1, paramArrayOfInt2, paramVarArgs);
    }
    
    public void u(DataBindingListAdapter.ViewHolder paramViewHolder, int paramInt)
    {
      boolean bool = MultiLiveAdvancedFragment.this.f.p0.get();
      Object localObject = MultiLiveAdvancedFragment.this;
      if (((MultiLiveBaseFragment)localObject).R3 != ((MultiLiveBaseFragment)localObject).O3.getWidth())
      {
        localObject = MultiLiveAdvancedFragment.this;
        ((MultiLiveBaseFragment)localObject).R3 = ((MultiLiveBaseFragment)localObject).O3.getWidth();
        localObject = MultiLiveAdvancedFragment.this;
        ((MultiLiveBaseFragment)localObject).Q3 = ((int)(((MultiLiveBaseFragment)localObject).R3 / 2.0F));
      }
      localObject = paramViewHolder.itemView.getLayoutParams();
      int i;
      if (bool) {
        i = MultiLiveAdvancedFragment.this.Q3;
      } else {
        i = MultiLiveAdvancedFragment.this.R3;
      }
      ((ViewGroup.LayoutParams)localObject).width = i;
      super.u(paramViewHolder, paramInt);
    }
  }
  
  class c
    extends GridLayoutManager
  {
    c(Context paramContext, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      super(paramInt1, paramInt2, paramBoolean);
    }
    
    public void onLayoutCompleted(RecyclerView.State paramState)
    {
      super.onLayoutCompleted(paramState);
      paramState = MultiLiveAdvancedFragment.this;
      if (paramState.N3)
      {
        if (paramState.M3 < paramState.L3.getItemCount())
        {
          paramState = MultiLiveAdvancedFragment.this;
          int i = paramState.M3;
          if (i >= 0) {
            try
            {
              paramState.J3.z.smoothScrollToPosition(i);
            }
            catch (IllegalArgumentException paramState)
            {
              paramState.printStackTrace();
            }
          }
        }
        paramState = MultiLiveAdvancedFragment.T1(MultiLiveAdvancedFragment.this);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("scrollToBrowsingPos:");
        localStringBuilder.append(MultiLiveAdvancedFragment.this.M3);
        b.d.w.c.a.c(paramState, localStringBuilder.toString());
        paramState = MultiLiveAdvancedFragment.this;
        paramState.N3 = false;
        paramState.f.o0();
      }
      MultiLiveAdvancedFragment.this.D2();
    }
  }
  
  class d
    extends RecyclerView.OnScrollListener
  {
    d() {}
    
    public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      if (paramInt == 0)
      {
        paramRecyclerView.invalidateItemDecorations();
        MultiLiveAdvancedFragment.this.E2();
        MultiLiveAdvancedFragment.this.D2();
      }
    }
    
    public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      MultiLiveAdvancedFragment.this.E2();
    }
  }
  
  class e
    extends AnimatorListenerAdapter
  {
    e() {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      paramAnimator = MultiLiveAdvancedFragment.this.p1;
      if ((paramAnimator != null) && (paramAnimator.isShowing())) {
        MultiLiveAdvancedFragment.this.p1.dismiss();
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\play\MultiLiveAdvancedFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */