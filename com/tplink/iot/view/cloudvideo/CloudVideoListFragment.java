package com.tplink.iot.view.cloudvideo;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ItemDecoration;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import b.d.q.b.o;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.a.f;
import com.scwang.smart.refresh.layout.c.g;
import com.scwang.smart.refresh.layout.constant.RefreshState;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.Utils.TPMaterialDialogV2.d;
import com.tplink.iot.Utils.o0;
import com.tplink.iot.Utils.q0;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.x0.w;
import com.tplink.iot.adapter.cloudvideo.CloudVideoListAdapter;
import com.tplink.iot.adapter.cloudvideo.CloudVideoListAdapter.b;
import com.tplink.iot.adapter.cloudvideo.CloudVideoListAdapter.c;
import com.tplink.iot.adapter.cloudvideo.CloudVideoListAdapter.d;
import com.tplink.iot.adapter.home.HomeMainSpaceItemDecoration;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.cloud.bean.cloudvideo.common.CloudVideo;
import com.tplink.iot.cloud.bean.cloudvideo.common.HasVideoTime;
import com.tplink.iot.cloud.bean.cloudvideo.common.PartCloudVideo;
import com.tplink.iot.dailysummary.view.DailySummaryActivity;
import com.tplink.iot.dailysummary.view.DailySummaryActivity.a;
import com.tplink.iot.model.cloudvideo.CloudVideoItem;
import com.tplink.iot.view.firmware.FirmwareSlideActivity;
import com.tplink.iot.view.ipcamera.widget.calendar.c;
import com.tplink.iot.view.ipcamera.widget.calendar.scrollCalendar.ScrollCalendar;
import com.tplink.iot.view.tapocare.BillingActivity;
import com.tplink.iot.viewmodel.cloudvideo.CloudVideoViewModel;
import com.tplink.iot.widget.refreshlayout.SmartRefreshFooter;
import com.tplink.iot.widget.refreshlayout.SmartRefreshHeader;
import com.tplink.iot.widget.refreshlayout.TPSmartRefreshLayout;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.TimeZone;

public class CloudVideoListFragment
  extends BaseFragment
  implements com.tplink.iot.view.ipcamera.widget.calendar.b, c, CloudVideoListAdapter.d, CloudVideoListAdapter.b, CloudVideoListAdapter.c
{
  private ALCameraDevice H3;
  private boolean I3 = false;
  private long J3 = -1L;
  private long K3 = -1L;
  private Boolean L3;
  private Boolean M3;
  private Boolean N3;
  @BindView
  View mBtnIntoDailySummary;
  @BindView
  View mCloudVideoListEmptyView;
  @BindView
  View mCloudVideoPlayView;
  @BindView
  RecyclerView mCloudVideoRv;
  @BindView
  TextView mDailySummaryIntoInfo;
  @BindView
  TextView mDataCurDateTv;
  @BindView
  ImageView mDataIndexBackIv;
  @BindView
  LinearLayout mDateSelectWidget;
  @BindView
  View mDateSelectorView;
  @BindView
  TextView mDateToday;
  @BindView
  ImageView mEditBtn;
  @BindView
  ImageView mNewDailySummaryPoint;
  @BindView
  ImageView mNextMonthIv;
  @BindView
  TPSmartRefreshLayout mRefreshLayout;
  @BindView
  ScrollCalendar mScrollCalendar;
  @BindView
  View mSelectDateTopBar;
  @BindView
  View mShadowView;
  @BindView
  Toolbar mToolbar;
  private CloudVideoListAdapter p0;
  private List<HasVideoTime> p1 = new ArrayList();
  private VideoPlayerFragment p2;
  private String p3 = "";
  private CloudVideoViewModel q;
  private Calendar x;
  private Calendar y;
  private String z = "";
  
  public CloudVideoListFragment()
  {
    Boolean localBoolean = Boolean.FALSE;
    this.L3 = localBoolean;
    this.M3 = localBoolean;
    this.N3 = localBoolean;
  }
  
  private void T0(CloudVideoItem paramCloudVideoItem)
  {
    Object localObject1;
    if (this.p2 == null)
    {
      this.p2 = ((VideoPlayerFragment)Fragment.instantiate(getActivity(), VideoPlayerFragment.class.getName()));
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("cloud_video_device_id", this.p3);
      localObject2 = this.H3;
      if (localObject2 != null) {
        ((Bundle)localObject1).putSerializable("cloud_video_device", (Serializable)localObject2);
      }
      ((Bundle)localObject1).putBoolean("cloud_video_open_from_me", this.I3);
      this.p2.setArguments((Bundle)localObject1);
    }
    Object localObject2 = getActivity().getSupportFragmentManager().beginTransaction();
    if (!this.p2.isAdded())
    {
      ((FragmentTransaction)localObject2).setCustomAnimations(2130772029, 2130772030);
      localObject1 = this.p2;
      ((FragmentTransaction)localObject2).add(2131362275, (Fragment)localObject1, localObject1.getClass().getName());
    }
    ((FragmentTransaction)localObject2).commitAllowingStateLoss();
    if (this.p2.isVisible()) {
      this.p2.b1(paramCloudVideoItem);
    } else {
      this.p2.g1(paramCloudVideoItem);
    }
    this.p0.N(paramCloudVideoItem.getCloudVideo().getUuid());
    this.p2.f1(this.p0.u());
    this.p2.h1(paramCloudVideoItem.getCloudVideo().getUuid());
    this.mToolbar.setAlpha(0.0F);
    this.mCloudVideoPlayView.setVisibility(0);
    this.mBtnIntoDailySummary.setVisibility(8);
    new Handler().postDelayed(new m(this), 100L);
  }
  
  private Calendar U0()
  {
    if (this.x == null) {
      return null;
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeZone(TimeZone.getTimeZone(this.z));
    localCalendar.set(1, this.x.get(1));
    localCalendar.set(2, this.x.get(2));
    localCalendar.set(5, this.x.get(5));
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    return localCalendar;
  }
  
  private void V0()
  {
    this.q.I(this.p3);
  }
  
  private void W0(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.x.add(5, 1);
    } else {
      this.x.add(5, -1);
    }
    this.mScrollCalendar.setSelectedDay(new com.tplink.iot.view.ipcamera.widget.calendar.d(this.x.get(1), this.x.get(2) + 1, this.x.get(5)));
    n1();
    r1(this.x);
    j1();
  }
  
  private void X0(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.y.add(2, 1);
    } else {
      this.y.add(2, -1);
    }
    this.mScrollCalendar.setSelectMonth(new com.tplink.iot.view.ipcamera.widget.calendar.d(this.y.get(1), this.y.get(2) + 1, 1));
    o1(this.y);
  }
  
  private void Y0()
  {
    Object localObject = this.q.S();
    this.z = ((String)localObject);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      this.z = TimeZone.getDefault().getID();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initCalendar DeviceTimezone is empty use phone timezone:");
      ((StringBuilder)localObject).append(this.z);
      b.d.w.c.a.c("CloudVideoListFragment", ((StringBuilder)localObject).toString());
    }
    localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeZone(TimeZone.getTimeZone(this.z));
    if ((!this.p1.isEmpty()) && (this.p1.get(0) != null) && (((HasVideoTime)this.p1.get(0)).getUtcTime() > System.currentTimeMillis())) {
      ((Calendar)localObject).setTimeInMillis(((HasVideoTime)this.p1.get(0)).getUtcTime());
    } else {
      ((Calendar)localObject).setTimeInMillis(System.currentTimeMillis());
    }
    this.K3 = ((Calendar)localObject).getTimeInMillis();
    this.mScrollCalendar.setCurrentDate(new com.tplink.iot.view.ipcamera.widget.calendar.d(((Calendar)localObject).get(1), ((Calendar)localObject).get(2) + 1, ((Calendar)localObject).get(5)));
    this.mScrollCalendar.d((Calendar)localObject);
    localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeZone(TimeZone.getTimeZone(this.z));
    ((Calendar)localObject).setTimeInMillis(System.currentTimeMillis());
    long l = this.J3;
    if (l != -1L) {
      ((Calendar)localObject).setTimeInMillis(l);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initCalendar getDeviceTimezone:");
    localStringBuilder.append(this.z);
    localStringBuilder.append(" getCurrentTime:");
    localStringBuilder.append(((Calendar)localObject).getTimeInMillis());
    b.d.w.c.a.c("CloudVideoListFragment", localStringBuilder.toString());
    p1(((Calendar)localObject).get(1), ((Calendar)localObject).get(2), ((Calendar)localObject).get(5));
    localObject = Calendar.getInstance();
    this.y = ((Calendar)localObject);
    ((Calendar)localObject).setTimeZone(TimeZone.getTimeZone(this.z));
    this.y.setTimeInMillis(System.currentTimeMillis());
    l = this.J3;
    if (l != -1L) {
      this.y.setTimeInMillis(l);
    }
    r1(this.y);
    this.mScrollCalendar.setMonthDateClickListener(this);
    this.mScrollCalendar.setOnMonthSelectedListener(this);
    this.mSelectDateTopBar.setClickable(true);
    this.mSelectDateTopBar.setAlpha(1.0F);
    localObject = this.q.z0(this.p1, this.z);
    if ((localObject != null) && (!((List)localObject).isEmpty())) {
      this.mScrollCalendar.setMarkDays((List)localObject);
    }
    j1();
  }
  
  private void Z0()
  {
    if (getActivity() != null) {
      ((BaseActivity)getActivity()).setSupportActionBar(this.mToolbar);
    }
    this.mToolbar.setTitle(getString(2131952373));
    Object localObject = new GridLayoutManager(getActivity(), 2);
    ((LinearLayoutManager)localObject).setOrientation(1);
    this.mCloudVideoRv.setLayoutManager((RecyclerView.LayoutManager)localObject);
    localObject = new HomeMainSpaceItemDecoration(getActivity(), 4);
    this.mCloudVideoRv.addItemDecoration((RecyclerView.ItemDecoration)localObject);
    u1();
    localObject = new CloudVideoListAdapter(getActivity(), false);
    this.p0 = ((CloudVideoListAdapter)localObject);
    this.mCloudVideoRv.setAdapter((RecyclerView.Adapter)localObject);
    this.p0.J(this);
    this.p0.L(this);
    this.p0.M(this);
    this.mRefreshLayout.Q(new SmartRefreshHeader(getContext()));
    this.mRefreshLayout.O(new SmartRefreshFooter(getContext()));
    this.mRefreshLayout.G(true);
    this.mRefreshLayout.E(false);
    this.mRefreshLayout.F(false);
    this.mRefreshLayout.N(new b());
    this.mRefreshLayout.L(new c());
  }
  
  private void g1()
  {
    VideoPlayerFragment localVideoPlayerFragment = this.p2;
    if (localVideoPlayerFragment != null) {
      localVideoPlayerFragment.T0();
    }
  }
  
  private void h1()
  {
    VideoPlayerFragment localVideoPlayerFragment = this.p2;
    if (localVideoPlayerFragment != null) {
      localVideoPlayerFragment.U0();
    }
  }
  
  private void i1()
  {
    VideoPlayerFragment localVideoPlayerFragment = this.p2;
    if (localVideoPlayerFragment != null) {
      localVideoPlayerFragment.V0();
    }
  }
  
  private void m1()
  {
    this.q.D().observe(this, new d());
    this.q.F().observe(this, new e());
    this.q.J().observe(this, new f());
    this.q.L().observe(this, new g());
  }
  
  private void n1()
  {
    Object localObject;
    if (this.mDateSelectorView.getVisibility() == 0)
    {
      localObject = new SimpleDateFormat("yyyy-MM");
      ((SimpleDateFormat)localObject).setTimeZone(TimeZone.getTimeZone(this.z));
      this.mDataCurDateTv.setText(((SimpleDateFormat)localObject).format(this.x.getTime()));
    }
    else
    {
      localObject = Calendar.getInstance();
      ((Calendar)localObject).setTimeZone(TimeZone.getTimeZone(this.z));
      ((Calendar)localObject).setTimeInMillis(q0.c());
      boolean bool = q0.d((Calendar)localObject, this.x);
      localObject = new SimpleDateFormat("yyyy-MM-dd");
      ((SimpleDateFormat)localObject).setTimeZone(TimeZone.getTimeZone(this.z));
      TextView localTextView = this.mDataCurDateTv;
      if (bool) {
        localObject = getString(2131953360);
      } else {
        localObject = ((SimpleDateFormat)localObject).format(this.x.getTime());
      }
      localTextView.setText((CharSequence)localObject);
    }
  }
  
  private void o1(Calendar paramCalendar)
  {
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeZone(TimeZone.getTimeZone(this.z));
    ((Calendar)localObject).setTimeInMillis(q0.c());
    localObject = new SimpleDateFormat("yyyy-MM");
    ((SimpleDateFormat)localObject).setTimeZone(TimeZone.getTimeZone(this.z));
    this.mDataCurDateTv.setText(((SimpleDateFormat)localObject).format(paramCalendar.getTime()));
    r1(this.y);
  }
  
  private void p1(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updateCurrentSelectDate:");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("/");
    int i = paramInt2 + 1;
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append("/");
    ((StringBuilder)localObject).append(paramInt3);
    b.d.w.c.a.c("CloudVideoListFragment", ((StringBuilder)localObject).toString());
    if (this.x == null)
    {
      localObject = Calendar.getInstance();
      this.x = ((Calendar)localObject);
      ((Calendar)localObject).setTimeZone(TimeZone.getTimeZone(this.z));
    }
    this.x.set(1, paramInt1);
    this.x.set(2, paramInt2);
    this.x.set(5, paramInt3);
    this.mScrollCalendar.setSelectedDay(new com.tplink.iot.view.ipcamera.widget.calendar.d(paramInt1, i, paramInt3));
    n1();
  }
  
  private void q1(boolean paramBoolean)
  {
    this.mEditBtn.setEnabled(paramBoolean);
    ImageView localImageView = this.mEditBtn;
    float f;
    if (paramBoolean) {
      f = 1.0F;
    } else {
      f = 0.4F;
    }
    localImageView.setAlpha(f);
  }
  
  private void r1(Calendar paramCalendar)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeZone(TimeZone.getTimeZone(this.z));
    localCalendar.setTimeInMillis(this.K3);
    boolean bool;
    if (this.mDateSelectorView.getVisibility() == 0) {
      bool = q0.g(localCalendar, paramCalendar);
    } else {
      bool = q0.d(localCalendar, paramCalendar);
    }
    this.mNextMonthIv.setEnabled(bool ^ true);
    paramCalendar = this.mNextMonthIv;
    float f;
    if (bool) {
      f = 0.4F;
    } else {
      f = 1.0F;
    }
    paramCalendar.setAlpha(f);
  }
  
  private void t1(boolean paramBoolean)
  {
    int i = 2131099799;
    int j = 8;
    Object localObject;
    VideoPlayerFragment localVideoPlayerFragment;
    if (paramBoolean)
    {
      this.mDateSelectorView.setVisibility(0);
      this.mDataIndexBackIv.setVisibility(0);
      this.mEditBtn.setVisibility(8);
      localObject = Calendar.getInstance();
      ((Calendar)localObject).setTimeZone(TimeZone.getTimeZone(this.z));
      ((Calendar)localObject).setTimeInMillis(q0.c());
      paramBoolean = q0.d((Calendar)localObject, this.x);
      localObject = this.mDateToday;
      if (!paramBoolean) {
        j = 0;
      }
      ((TextView)localObject).setVisibility(j);
      this.mShadowView.setVisibility(0);
      localObject = getActivity();
      localVideoPlayerFragment = this.p2;
      if ((localVideoPlayerFragment == null) || (!localVideoPlayerFragment.isVisible())) {
        i = 2131099912;
      }
      com.tplink.iot.view.quicksetup.base.d.b0((Activity)localObject, i);
    }
    else
    {
      this.mDateSelectorView.setVisibility(8);
      this.mDataIndexBackIv.setVisibility(8);
      this.mEditBtn.setVisibility(0);
      this.mDateToday.setVisibility(8);
      this.mShadowView.setVisibility(8);
      localObject = getActivity();
      localVideoPlayerFragment = this.p2;
      if ((localVideoPlayerFragment == null) || (!localVideoPlayerFragment.isVisible())) {
        i = 2131100140;
      }
      com.tplink.iot.view.quicksetup.base.d.b0((Activity)localObject, i);
    }
    n1();
    r1(this.x);
  }
  
  private void u1()
  {
    if (this.mCloudVideoPlayView == null) {
      return;
    }
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.mRefreshLayout.getLayoutParams();
    int i = 0;
    int j = i;
    if (this.mCloudVideoPlayView.getVisibility() == 8)
    {
      j = i;
      if (this.mBtnIntoDailySummary.getVisibility() == 8) {
        j = 56;
      }
    }
    localMarginLayoutParams.topMargin = o.a(getActivity(), j);
  }
  
  private void v1(boolean paramBoolean)
  {
    this.p0.H(this.q.B());
    int i = this.p0.z();
    boolean bool = true;
    if (i == 0)
    {
      this.mCloudVideoListEmptyView.setVisibility(0);
      this.mRefreshLayout.E(false);
      this.mCloudVideoRv.setVisibility(8);
    }
    else
    {
      this.mCloudVideoListEmptyView.setVisibility(8);
      this.mRefreshLayout.E(true);
      this.mCloudVideoRv.setVisibility(0);
      if (!paramBoolean) {
        this.mCloudVideoRv.scrollToPosition(0);
      }
    }
    if (this.mCloudVideoPlayView.getVisibility() == 0)
    {
      VideoPlayerFragment localVideoPlayerFragment = this.p2;
      if (localVideoPlayerFragment != null) {
        localVideoPlayerFragment.f1(this.q.B());
      }
    }
    u1();
    if (this.p0.z() > 0) {
      paramBoolean = bool;
    } else {
      paramBoolean = false;
    }
    q1(paramBoolean);
  }
  
  public void B(int paramInt)
  {
    int i = 8;
    View localView;
    if (paramInt == 1)
    {
      this.mToolbar.setTitle("");
      this.mToolbar.setNavigationIcon(2131689570);
      this.mToolbar.setNavigationOnClickListener(new k(this));
      this.mEditBtn.setImageDrawable(getResources().getDrawable(2131689755));
      this.mRefreshLayout.G(false);
      localView = this.mCloudVideoPlayView;
      if ((localView != null) && (localView.isShown())) {
        l1();
      }
      this.mBtnIntoDailySummary.setVisibility(8);
    }
    else
    {
      this.mToolbar.setTitle(getString(2131952373));
      this.mToolbar.setNavigationIcon(2131689776);
      this.mToolbar.setNavigationOnClickListener(new l(this));
      this.mEditBtn.setImageDrawable(getResources().getDrawable(2131689757));
      this.mRefreshLayout.G(true);
      localView = this.mBtnIntoDailySummary;
      paramInt = i;
      if (this.L3.booleanValue()) {
        paramInt = 0;
      }
      localView.setVisibility(paramInt);
    }
    u1();
  }
  
  public void M0(com.tplink.iot.view.ipcamera.widget.calendar.d paramd)
  {
    if (paramd == null) {
      return;
    }
    com.tplink.iot.view.ipcamera.widget.calendar.d locald = new com.tplink.iot.view.ipcamera.widget.calendar.d(this.y.get(1), this.y.get(2) + 1, this.y.get(5));
    if (paramd.b(locald) > 0) {
      this.y.add(2, 1);
    } else if (paramd.b(locald) < 0) {
      this.y.add(2, -1);
    }
    this.mScrollCalendar.setSelectMonth(paramd);
    o1(this.y);
  }
  
  public void b0(int paramInt)
  {
    float f = 1.0F;
    if (paramInt == 0)
    {
      this.mToolbar.setTitle(getResources().getString(2131953751));
      ImageView localImageView = this.mEditBtn;
      if (this.p0.w() == 1) {
        f = 0.4F;
      }
      localImageView.setAlpha(f);
    }
    else
    {
      this.mEditBtn.setAlpha(1.0F);
      if (paramInt == 1) {
        this.mToolbar.setTitle(getResources().getString(2131953752, new Object[] { Integer.valueOf(paramInt) }));
      } else {
        this.mToolbar.setTitle(getResources().getString(2131953753, new Object[] { Integer.valueOf(paramInt) }));
      }
    }
    getActivity().invalidateOptionsMenu();
  }
  
  public boolean d()
  {
    if (this.p0.w() == 1) {
      this.p0.K(0);
    } else if (this.mDateSelectorView.getVisibility() == 0) {
      t1(false);
    } else {
      getActivity().finish();
    }
    return true;
  }
  
  @OnClick
  void dateCurDate()
  {
    if ((this.p0.w() != 1) && (this.x != null) && (this.mDateSelectorView.getVisibility() == 8)) {
      t1(true);
    }
  }
  
  @OnClick
  void dateMoveBackward()
  {
    if ((this.p0.w() != 1) && (this.x != null)) {
      if (this.mDateSelectorView.getVisibility() == 0) {
        X0(false);
      } else {
        W0(false);
      }
    }
  }
  
  @OnClick
  void dateMoveForward()
  {
    if ((this.p0.w() != 1) && (this.x != null)) {
      if (this.mDateSelectorView.getVisibility() == 0) {
        X0(true);
      } else {
        W0(true);
      }
    }
  }
  
  @OnClick
  void dateToday()
  {
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(System.currentTimeMillis());
    ((Calendar)localObject).setTimeZone(TimeZone.getTimeZone(this.z));
    if (!q0.d((Calendar)localObject, this.x)) {
      j1();
    }
    localObject = Calendar.getInstance();
    this.x = ((Calendar)localObject);
    ((Calendar)localObject).setTimeInMillis(System.currentTimeMillis());
    this.x.setTimeZone(TimeZone.getTimeZone(this.z));
    p1(this.x.get(1), this.x.get(2), this.x.get(5));
    localObject = new com.tplink.iot.view.ipcamera.widget.calendar.d(this.x.get(1), this.x.get(2) + 1, this.x.get(5));
    this.mScrollCalendar.setSelectMonth((com.tplink.iot.view.ipcamera.widget.calendar.d)localObject);
    this.y.setTimeInMillis(this.x.getTimeInMillis());
    r1(this.y);
    t1(false);
  }
  
  @OnClick
  void enterSelectMode()
  {
    if (this.p0.w() == 0)
    {
      if (this.p0.z() > 0) {
        this.p0.K(1);
      }
    }
    else
    {
      if (this.p0.y() == 0) {
        return;
      }
      new TPMaterialDialogV2.Builder(getContext()).j(getResources().getString(2131952518)).l(2131952391, 2131099804, null).o(2131952401, 2131099812, new a()).g(8, 8).b(false).c(false).a().show();
    }
  }
  
  public void f0()
  {
    CloudVideoViewModel localCloudVideoViewModel = this.q;
    if (localCloudVideoViewModel != null) {
      localCloudVideoViewModel.D0(this.p3);
    }
  }
  
  public void g0(int paramInt1, int paramInt2, int paramInt3)
  {
    t1(false);
    Calendar localCalendar = this.x;
    if ((localCalendar != null) && (localCalendar.get(1) == paramInt1) && (this.x.get(2) == paramInt2) && (this.x.get(5) == paramInt3)) {
      return;
    }
    p1(paramInt1, paramInt2, paramInt3);
    r1(this.x);
    if (this.mRefreshLayout.getState() != RefreshState.None) {
      k1(false);
    } else {
      j1();
    }
  }
  
  @OnClick
  void gotoDailySummary()
  {
    if (this.M3.booleanValue()) {
      FirmwareSlideActivity.q1(getActivity(), "daily summary");
    } else {
      DailySummaryActivity.y.a(getActivity(), this.p3);
    }
  }
  
  @OnClick
  void hideDateSelector()
  {
    t1(false);
    Object localObject = this.x;
    if (localObject != null)
    {
      p1(((Calendar)localObject).get(1), this.x.get(2), this.x.get(5));
      localObject = new com.tplink.iot.view.ipcamera.widget.calendar.d(this.x.get(1), this.x.get(2) + 1, this.x.get(5));
      this.mScrollCalendar.setSelectMonth((com.tplink.iot.view.ipcamera.widget.calendar.d)localObject);
      this.y.setTimeInMillis(this.x.getTimeInMillis());
      r1(this.y);
    }
  }
  
  public void j1()
  {
    if (this.mRefreshLayout != null)
    {
      this.mCloudVideoRv.setVisibility(8);
      this.mCloudVideoListEmptyView.setVisibility(8);
      this.mRefreshLayout.j();
    }
  }
  
  public void k1(boolean paramBoolean)
  {
    if (TextUtils.isEmpty(this.p3)) {
      return;
    }
    Object localObject = U0();
    if (localObject == null) {
      return;
    }
    q1(false);
    long l = ((Calendar)localObject).getTimeInMillis();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("refreshVideoList startTime = ");
    ((StringBuilder)localObject).append(l);
    ((StringBuilder)localObject).append("   mTimeZoneStr = ");
    ((StringBuilder)localObject).append(this.z);
    b.d.w.c.a.c("CloudVideoListFragment", ((StringBuilder)localObject).toString());
    String str1 = o0.f(l, this.z);
    String str2 = o0.f(86400000L + l, this.z);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("refreshVideoList startTimeStr = ");
    ((StringBuilder)localObject).append(str1);
    ((StringBuilder)localObject).append("   endTimeStr = ");
    ((StringBuilder)localObject).append(str2);
    b.d.w.c.a.c("CloudVideoListFragment", ((StringBuilder)localObject).toString());
    if (paramBoolean) {
      this.q.t0(this.p3, str1, str2);
    } else {
      this.q.U(this.p3, str1, str2, l);
    }
  }
  
  public void l1()
  {
    if (this.p2 != null)
    {
      this.mToolbar.setAlpha(1.0F);
      localObject = getActivity().getSupportFragmentManager().beginTransaction();
      ((FragmentTransaction)localObject).remove(this.p2);
      ((FragmentTransaction)localObject).commitAllowingStateLoss();
      this.p2 = null;
    }
    Object localObject = this.mCloudVideoPlayView;
    int i = 8;
    ((View)localObject).setVisibility(8);
    localObject = this.mBtnIntoDailySummary;
    if (this.L3.booleanValue()) {
      i = 0;
    }
    ((View)localObject).setVisibility(i);
    this.p0.N("");
    u1();
  }
  
  public void onActivityCreated(@Nullable Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.q = ((CloudVideoViewModel)ViewModelProviders.of(this).get(CloudVideoViewModel.class));
    if (getArguments() != null)
    {
      paramBundle = getArguments().getString("cloud_video_device_id");
      this.p3 = paramBundle;
      if ((this.p0 != null) && (!TextUtils.isEmpty(paramBundle))) {
        this.p0.I(b.d.w.h.a.g(this.p3));
      }
      this.H3 = ((ALCameraDevice)getArguments().getSerializable("cloud_video_device"));
      this.I3 = getArguments().getBoolean("cloud_video_open_from_me");
      paramBundle = getArguments().getString("cloud_video_m3u8");
      String str = getArguments().getString("cloud_video_uri");
      Object localObject = getArguments().getString("cloud_video_uuid");
      long l = getArguments().getLong("cloud_video_duration", -1L);
      this.J3 = getArguments().getLong("cloud_video_timestamp", -1L);
      if ((paramBundle != null) && (str != null))
      {
        CloudVideo localCloudVideo = new CloudVideo();
        localCloudVideo.setUuid((String)localObject);
        localObject = new PartCloudVideo();
        ((PartCloudVideo)localObject).setM3u8(paramBundle);
        ((PartCloudVideo)localObject).setUri(str);
        if (l != -1L) {
          ((PartCloudVideo)localObject).setDuration(l);
        }
        l = this.J3;
        if (l != -1L) {
          ((PartCloudVideo)localObject).setStartTimestamp(l);
        }
        localCloudVideo.setPartCloudVideos(Collections.singletonList(localObject));
        T0(new CloudVideoItem(localCloudVideo, 1));
      }
    }
    m1();
    V0();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1345)
    {
      j1();
      com.tplink.iot.Utils.v0.b.a().b();
    }
    else
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (paramConfiguration.orientation == 2)
    {
      this.mCloudVideoRv.setVisibility(8);
      this.mDateSelectWidget.setVisibility(8);
    }
    else
    {
      this.mCloudVideoRv.setVisibility(0);
      this.mDateSelectWidget.setVisibility(0);
    }
  }
  
  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    getActivity().getMenuInflater().inflate(2131623951, paramMenu);
    paramMenu = paramMenu.findItem(2131363451);
    if (this.p0.w() == 1)
    {
      paramMenu.setVisible(true);
      if (this.p0.B()) {
        paramMenu.setIcon(2131690251);
      } else {
        paramMenu.setIcon(2131690252);
      }
    }
    else
    {
      paramMenu.setVisible(false);
      this.mToolbar.setTitle(getString(2131952373));
    }
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131558740, paramViewGroup, false);
    setHasOptionsMenu(true);
    ButterKnife.b(this, paramLayoutInflater);
    Z0();
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (s0.j()) {
      s0.g();
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 2131363451) {
      if (this.p0.B())
      {
        this.p0.t();
        paramMenuItem.setIcon(2131690252);
      }
      else
      {
        this.p0.G();
      }
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
  }
  
  public void p(CloudVideoItem paramCloudVideoItem)
  {
    if (paramCloudVideoItem.getType() == 0)
    {
      if (this.p0.w() == 1) {
        return;
      }
      w.m();
      BillingActivity.f1(getActivity(), com.tplink.iot.Utils.v0.e.g(this.p3));
    }
    else if (paramCloudVideoItem.isHasVideo())
    {
      T0(paramCloudVideoItem);
    }
    else
    {
      s0.p(getActivity(), getString(2131954391));
    }
  }
  
  public void s1(String paramString)
  {
    CloudVideoListAdapter localCloudVideoListAdapter = this.p0;
    if (localCloudVideoListAdapter != null) {
      localCloudVideoListAdapter.N(paramString);
    }
    this.mBtnIntoDailySummary.setVisibility(8);
  }
  
  class a
    implements TPMaterialDialogV2.d
  {
    a() {}
    
    public void onClick(View paramView)
    {
      s0.l(CloudVideoListFragment.this.getActivity());
      CloudVideoListFragment.K0(CloudVideoListFragment.this).v(CloudVideoListFragment.H0(CloudVideoListFragment.this), CloudVideoListFragment.I0(CloudVideoListFragment.this).x());
    }
  }
  
  class b
    implements g
  {
    b() {}
    
    public void m(@NonNull f paramf)
    {
      CloudVideoListFragment.this.k1(false);
    }
  }
  
  class c
    implements com.scwang.smart.refresh.layout.c.e
  {
    c() {}
    
    public void q(@NonNull f paramf)
    {
      CloudVideoListFragment.this.k1(true);
    }
  }
  
  class d
    implements Observer<com.tplink.iot.model.cloudvideo.a>
  {
    d() {}
    
    public void a(@Nullable com.tplink.iot.model.cloudvideo.a parama)
    {
      if (parama == null)
      {
        CloudVideoListFragment.this.mRefreshLayout.q();
        CloudVideoListFragment.this.mRefreshLayout.l();
        CloudVideoListFragment.L0(CloudVideoListFragment.this);
        return;
      }
      if (parama.b())
      {
        CloudVideoListFragment.this.mRefreshLayout.l();
        CloudVideoListFragment.N0(CloudVideoListFragment.this);
      }
      else
      {
        CloudVideoListFragment.this.mRefreshLayout.q();
        CloudVideoListFragment.O0(CloudVideoListFragment.this);
      }
      if (parama.a()) {
        CloudVideoListFragment.P0(CloudVideoListFragment.this, parama.b());
      }
    }
  }
  
  class e
    implements Observer<Boolean>
  {
    e() {}
    
    public void a(@Nullable Boolean paramBoolean)
    {
      
      if ((paramBoolean != null) && (paramBoolean.booleanValue()))
      {
        CloudVideoListFragment.K0(CloudVideoListFragment.this).u0(CloudVideoListFragment.I0(CloudVideoListFragment.this).x());
        CloudVideoListFragment.P0(CloudVideoListFragment.this, false);
        if (CloudVideoListFragment.K0(CloudVideoListFragment.this).B().isEmpty())
        {
          paramBoolean = CloudVideoListFragment.Q0(CloudVideoListFragment.this);
          if (paramBoolean == null) {
            return;
          }
          long l = paramBoolean.getTimeInMillis();
          CloudVideoListFragment.K0(CloudVideoListFragment.this).v0(CloudVideoListFragment.H0(CloudVideoListFragment.this), l);
        }
      }
      else
      {
        s0.n(CloudVideoListFragment.this.getActivity(), 2131953328);
      }
      CloudVideoListFragment.I0(CloudVideoListFragment.this).K(0);
    }
  }
  
  class f
    implements Observer<List<HasVideoTime>>
  {
    f() {}
    
    public void a(@Nullable List<HasVideoTime> paramList)
    {
      if (paramList != null)
      {
        CloudVideoListFragment.R0(CloudVideoListFragment.this).clear();
        CloudVideoListFragment.R0(CloudVideoListFragment.this).addAll(paramList);
        CloudVideoListFragment.S0(CloudVideoListFragment.this);
      }
      else
      {
        s0.p(CloudVideoListFragment.this.getActivity(), CloudVideoListFragment.this.getString(2131952834));
        CloudVideoListFragment.P0(CloudVideoListFragment.this, false);
        CloudVideoListFragment.this.mRefreshLayout.q();
      }
    }
  }
  
  class g
    implements Observer<List<HasVideoTime>>
  {
    g() {}
    
    public void a(List<HasVideoTime> paramList)
    {
      paramList = CloudVideoListFragment.K0(CloudVideoListFragment.this).z0(paramList, CloudVideoListFragment.J0(CloudVideoListFragment.this));
      if ((paramList != null) && (!paramList.isEmpty())) {
        CloudVideoListFragment.this.mScrollCalendar.setMarkDays(paramList);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\cloudvideo\CloudVideoListFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */