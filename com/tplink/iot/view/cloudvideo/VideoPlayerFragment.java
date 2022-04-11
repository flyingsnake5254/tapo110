package com.tplink.iot.view.cloudvideo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialog;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
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
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.airbnb.lottie.LottieAnimationView;
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
import com.google.android.exoplayer2.ui.DefaultTimeBar;
import com.google.android.exoplayer2.ui.PlayerView;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.c.e;
import com.scwang.smart.refresh.layout.c.g;
import com.tplink.iot.Utils.TPMaterialDialogV3;
import com.tplink.iot.Utils.TPMaterialDialogV3.Builder;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.x0.w;
import com.tplink.iot.Utils.z0.h;
import com.tplink.iot.adapter.cloudvideo.CloudVideoListAdapter;
import com.tplink.iot.adapter.cloudvideo.CloudVideoListAdapter.d;
import com.tplink.iot.adapter.home.HomeMainSpaceItemDecoration;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.cloud.bean.cloudvideo.common.CloudVideo;
import com.tplink.iot.cloud.bean.cloudvideo.common.PartCloudVideo;
import com.tplink.iot.model.cloudvideo.CloudVideoItem;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar;
import com.tplink.iot.viewmodel.cloudvideo.VideoPlayerViewModel;
import com.tplink.iot.widget.CirclePercentBar;
import com.tplink.iot.widget.CirclePercentBar.c;
import com.tplink.iot.widget.refreshlayout.SmartRefreshFooter;
import com.tplink.iot.widget.refreshlayout.SmartRefreshHeader;
import com.tplink.iot.widget.refreshlayout.TPSmartRefreshLayout;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import java.io.File;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;

public class VideoPlayerFragment
  extends BaseFragment
  implements CloudVideoListAdapter.d, CirclePercentBar.c
{
  private boolean H3 = false;
  private CloudVideoListAdapter I3;
  private List<CloudVideoItem> J3 = new ArrayList();
  private VideoPlayerViewModel K3;
  private String L3 = "";
  private ALCameraDevice M3;
  private com.tplink.iot.h.f N3;
  private boolean O3 = false;
  @BindView
  LinearLayout mBottomToolButtonsView;
  @BindView
  ImageView mCaptureIv;
  @BindView
  ImageView mCaptureLandIv;
  @BindView
  RelativeLayout mCaptureLandView;
  @BindView
  RecyclerView mCloudVideoRv;
  @BindView
  ImageView mDownloadIv;
  @BindView
  ImageView mDownloadLandIv;
  @BindView
  TextView mDurationTv;
  @BindView
  View mEmptyPlayView;
  @BindView
  ImageView mFullScreenOrSelectVideoIv;
  @BindView
  LottieAnimationView mLoadingAnimationView;
  @BindView
  ImageView mMuteIv;
  @BindView
  ImageView mMuteLandIv;
  @BindView
  ImageView mPauseIv;
  @BindView
  ImageView mPlayIv;
  @BindView
  RelativeLayout mPlayTitleView;
  @BindView
  PlayerView mPlayerView;
  @BindView
  TextView mPositionTv;
  @BindView
  LinearLayout mRootView;
  @BindView
  LinearLayout mSelectCloudVideoView;
  @BindView
  LinearLayout mTapRefreshView;
  @BindView
  DefaultTimeBar mTimeBar;
  @BindView
  RelativeLayout mTopControlView;
  @BindView
  FrameLayout mVideoPlayLayout;
  private h2 p0;
  private int p1 = 0;
  private long p2 = 0L;
  private float p3;
  private CirclePercentBar q;
  @BindView
  TPSmartRefreshLayout refreshLayout;
  private View x;
  private TPMaterialDialogV3 y;
  private CloudVideoItem z;
  
  private void S0()
  {
    TextureView localTextureView = (TextureView)this.mPlayerView.getVideoSurfaceView();
    if (localTextureView != null) {
      this.K3.h(localTextureView.getBitmap());
    }
  }
  
  private String W0(long paramLong)
  {
    Object localObject = new StringBuilder();
    Formatter localFormatter = new Formatter((Appendable)localObject, Locale.getDefault());
    long l1 = paramLong;
    if (paramLong == -9223372036854775807L) {
      l1 = 0L;
    }
    long l2 = (l1 + 500L) / 1000L;
    paramLong = l2 % 60L;
    l1 = l2 / 60L % 60L;
    l2 /= 3600L;
    ((StringBuilder)localObject).setLength(0);
    if (l2 > 0L) {
      localObject = localFormatter.format("%d:%02d:%02d", new Object[] { Long.valueOf(l2), Long.valueOf(l1), Long.valueOf(paramLong) }).toString();
    } else {
      localObject = localFormatter.format("%02d:%02d", new Object[] { Long.valueOf(l1), Long.valueOf(paramLong) }).toString();
    }
    return (String)localObject;
  }
  
  private void X0()
  {
    com.tplink.iot.view.quicksetup.base.d.b0(getActivity(), 2131099799);
    Object localObject = new GridLayoutManager(getActivity(), 2);
    ((LinearLayoutManager)localObject).setOrientation(1);
    this.mCloudVideoRv.setLayoutManager((RecyclerView.LayoutManager)localObject);
    localObject = new HomeMainSpaceItemDecoration(getActivity(), 2);
    this.mCloudVideoRv.addItemDecoration((RecyclerView.ItemDecoration)localObject);
    localObject = new CloudVideoListAdapter(getActivity(), true);
    this.I3 = ((CloudVideoListAdapter)localObject);
    this.mCloudVideoRv.setAdapter((RecyclerView.Adapter)localObject);
    this.I3.H(this.J3);
    this.I3.J(this);
    this.refreshLayout.Q(new SmartRefreshHeader(getContext()));
    this.refreshLayout.O(new SmartRefreshFooter(getContext()));
    this.refreshLayout.G(true);
    this.refreshLayout.E(true);
    this.refreshLayout.F(false);
    this.refreshLayout.N(new d());
    this.refreshLayout.L(new e());
  }
  
  private void Y0(CloudVideoItem paramCloudVideoItem)
  {
    if ((paramCloudVideoItem != null) && (paramCloudVideoItem.getCloudVideo() != null))
    {
      if (this.p0 == null)
      {
        Object localObject = new com.tplink.iot.Utils.hls.d(getActivity());
        ((c1)localObject).i(2);
        localObject = new h2.b(getActivity(), (f2)localObject).z();
        this.p0 = ((h2)localObject);
        ((h2)localObject).N(new f());
        this.p0.B(this.p1, this.p2);
        this.mPlayerView.setPlayer(this.p0);
      }
      c1(paramCloudVideoItem);
    }
  }
  
  private void Z0(CloudVideo paramCloudVideo)
  {
    if (paramCloudVideo == null) {
      return;
    }
    if ((paramCloudVideo.getPartCloudVideos() != null) && (!paramCloudVideo.getPartCloudVideos().isEmpty()))
    {
      Object localObject = (PartCloudVideo)paramCloudVideo.getPartCloudVideos().get(0);
      if (localObject == null) {
        return;
      }
      long l = ((PartCloudVideo)localObject).getDuration();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("videoDuration=");
      ((StringBuilder)localObject).append(l);
      b.d.w.c.a.d(((StringBuilder)localObject).toString());
      if (!TextUtils.isEmpty(this.L3)) {
        if (this.O3)
        {
          w.C(b.d.w.h.a.g(this.L3), l);
        }
        else
        {
          if (!TextUtils.isEmpty(paramCloudVideo.getUuid())) {
            paramCloudVideo = paramCloudVideo.getUuid();
          } else {
            paramCloudVideo = "";
          }
          w.B(b.d.w.h.a.g(this.L3), l, paramCloudVideo);
        }
      }
    }
  }
  
  private void a1()
  {
    h2 localh2 = this.p0;
    if (localh2 != null) {
      localh2.p(false);
    }
  }
  
  private void c1(CloudVideoItem paramCloudVideoItem)
  {
    Object localObject1 = paramCloudVideoItem.getCloudVideo();
    if (localObject1 == null) {
      return;
    }
    Z0((CloudVideo)localObject1);
    if ((((CloudVideo)localObject1).getPartCloudVideos() != null) && (!((CloudVideo)localObject1).getPartCloudVideos().isEmpty()))
    {
      Object localObject2 = (PartCloudVideo)((CloudVideo)localObject1).getPartCloudVideos().get(0);
      if (localObject2 == null) {
        return;
      }
      Object localObject3 = ((PartCloudVideo)localObject2).getM3u8();
      localObject1 = ((PartCloudVideo)localObject2).getUri();
      long l = ((PartCloudVideo)localObject2).getDuration();
      this.mDurationTv.setText(W0(l));
      localObject1 = com.tplink.iot.h.j.a.e(b.d.w.h.a.a((String)localObject3), (String)localObject1);
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(b.d.q.b.p.b.h());
      localObject2 = File.separator;
      ((StringBuilder)localObject3).append((String)localObject2);
      ((StringBuilder)localObject3).append("cloudvideo");
      ((StringBuilder)localObject3).append((String)localObject2);
      ((StringBuilder)localObject3).append("playing.m3u8");
      localObject3 = ((StringBuilder)localObject3).toString();
      com.tplink.iot.h.j.a.f((String)localObject3, (String)localObject1);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("file://");
      ((StringBuilder)localObject1).append((String)localObject3);
      localObject1 = Uri.parse(((StringBuilder)localObject1).toString());
      localObject1 = new l1.c().u((Uri)localObject1).q("application/x-mpegURL").a();
      this.p0.D((l1)localObject1);
      this.p0.p(true);
      this.p0.prepare();
      localObject1 = this.I3;
      if (localObject1 != null) {
        ((CloudVideoListAdapter)localObject1).N(paramCloudVideoItem.getCloudVideo().getUuid());
      }
    }
  }
  
  private void d1(boolean paramBoolean)
  {
    CloudVideoListFragment localCloudVideoListFragment = (CloudVideoListFragment)getFragmentManager().findFragmentById(2131362270);
    if (localCloudVideoListFragment != null) {
      localCloudVideoListFragment.k1(paramBoolean);
    }
  }
  
  private void e1()
  {
    h2 localh2 = this.p0;
    if (localh2 != null)
    {
      this.p2 = localh2.V();
      this.p1 = this.p0.m();
      this.p0.release();
    }
  }
  
  private void i1()
  {
    Object localObject = this.y;
    if ((localObject != null) && (((Dialog)localObject).isShowing())) {
      return;
    }
    localObject = LayoutInflater.from(getActivity()).inflate(2131558833, null);
    this.x = ((View)localObject);
    localObject = (CirclePercentBar)((View)localObject).findViewById(2131363623);
    this.q = ((CirclePercentBar)localObject);
    ((CirclePercentBar)localObject).setListener(this);
    this.y = new TPMaterialDialogV3.Builder(getActivity()).s(this.x).b(false).c(false).a();
    ((Button)this.x.findViewById(2131362081)).setOnClickListener(new b());
    if (!this.y.isShowing()) {
      this.y.show();
    }
  }
  
  private void j1()
  {
    this.K3.j().observe(this, new c());
  }
  
  private void k1(Configuration paramConfiguration)
  {
    boolean bool;
    if (paramConfiguration.orientation == 2) {
      bool = true;
    } else {
      bool = false;
    }
    ViewGroup.MarginLayoutParams localMarginLayoutParams1 = (ViewGroup.MarginLayoutParams)this.mVideoPlayLayout.getLayoutParams();
    paramConfiguration = (ViewGroup.MarginLayoutParams)this.mSelectCloudVideoView.getLayoutParams();
    ViewGroup.MarginLayoutParams localMarginLayoutParams2 = (ViewGroup.MarginLayoutParams)this.mEmptyPlayView.getLayoutParams();
    Object localObject;
    if (bool)
    {
      this.mRootView.setBackgroundColor(ContextCompat.getColor(getActivity(), 2131100139));
      getActivity().getWindow().getDecorView().setSystemUiVisibility(4102);
      getActivity().getWindow().setFlags(1024, 1024);
      localObject = new DisplayMetrics();
      getActivity().getWindowManager().getDefaultDisplay().getRealMetrics((DisplayMetrics)localObject);
      int i = ((DisplayMetrics)localObject).widthPixels;
      localMarginLayoutParams1.width = i;
      int j = ((DisplayMetrics)localObject).heightPixels;
      localMarginLayoutParams1.height = j;
      int k = (int)(i / 2.5F);
      paramConfiguration.width = k;
      paramConfiguration.height = j;
      localMarginLayoutParams2.width = (i - k);
      localMarginLayoutParams2.height = j;
    }
    else
    {
      this.mRootView.setBackgroundColor(ContextCompat.getColor(getActivity(), 2131100139));
      getActivity().getWindow().getDecorView().setSystemUiVisibility(256);
      localObject = getActivity().getWindow().getAttributes();
      ((WindowManager.LayoutParams)localObject).flags &= 0xFBFF;
      getActivity().getWindow().setAttributes((WindowManager.LayoutParams)localObject);
      getActivity().getWindow().clearFlags(512);
      localObject = new DisplayMetrics();
      getActivity().getWindowManager().getDefaultDisplay().getRealMetrics((DisplayMetrics)localObject);
      localMarginLayoutParams1.width = ((DisplayMetrics)localObject).widthPixels;
      localMarginLayoutParams1.height = h.p(getActivity());
      paramConfiguration.width = 0;
      paramConfiguration.height = 0;
      localMarginLayoutParams2.width = 0;
      localMarginLayoutParams2.height = 0;
    }
    m1(bool);
  }
  
  private void l1()
  {
    h2 localh2 = this.p0;
    if (localh2 != null)
    {
      if (this.H3)
      {
        localh2.t1(this.p3);
        this.mMuteIv.setImageDrawable(getResources().getDrawable(2131231625));
        this.mMuteLandIv.setImageDrawable(getResources().getDrawable(2131231625));
      }
      else
      {
        this.p3 = localh2.c1();
        this.p0.t1(0.0F);
        this.mMuteIv.setImageDrawable(getResources().getDrawable(2131231626));
        this.mMuteLandIv.setImageDrawable(getResources().getDrawable(2131231626));
      }
      this.H3 ^= true;
    }
  }
  
  private void m1(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mTopControlView.setVisibility(8);
      this.mBottomToolButtonsView.setVisibility(8);
      this.mPlayTitleView.setVisibility(0);
      this.mFullScreenOrSelectVideoIv.setImageDrawable(getResources().getDrawable(2131231615));
      this.mDownloadLandIv.setVisibility(0);
      this.mMuteLandIv.setVisibility(0);
      this.mCaptureLandView.setVisibility(0);
    }
    else
    {
      this.mTopControlView.setVisibility(0);
      this.mBottomToolButtonsView.setVisibility(0);
      this.mPlayTitleView.setVisibility(8);
      this.mFullScreenOrSelectVideoIv.setImageDrawable(getResources().getDrawable(2131231612));
      this.mDownloadLandIv.setVisibility(8);
      this.mMuteLandIv.setVisibility(8);
      this.mCaptureLandView.setVisibility(8);
    }
  }
  
  private void n1(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      this.mLoadingAnimationView.o();
      this.mLoadingAnimationView.setVisibility(0);
    }
    else
    {
      this.mLoadingAnimationView.g();
      this.mLoadingAnimationView.setVisibility(8);
      if (paramBoolean2) {
        this.mTapRefreshView.setVisibility(0);
      } else {
        this.mTapRefreshView.setVisibility(8);
      }
    }
    if ((!paramBoolean1) && (!paramBoolean2))
    {
      this.mPlayIv.setAlpha(1.0F);
      this.mPauseIv.setAlpha(1.0F);
      this.mPositionTv.setAlpha(1.0F);
      this.mDurationTv.setAlpha(1.0F);
      this.mCaptureIv.setAlpha(1.0F);
      this.mCaptureIv.setClickable(true);
      this.mCaptureLandIv.setAlpha(1.0F);
      this.mCaptureLandView.setClickable(true);
      this.mTimeBar.setPlayedColor(getResources().getColor(2131099808));
      this.mTimeBar.setScrubberColor(getResources().getColor(2131099808));
      this.mTimeBar.setClickable(true);
    }
    else
    {
      this.mPlayIv.setAlpha(0.4F);
      this.mPauseIv.setAlpha(0.4F);
      this.mPositionTv.setAlpha(0.4F);
      this.mDurationTv.setAlpha(0.4F);
      this.mCaptureIv.setAlpha(0.4F);
      this.mCaptureIv.setClickable(false);
      this.mCaptureLandIv.setAlpha(0.4F);
      this.mCaptureLandView.setClickable(false);
      this.mTimeBar.setPlayedColor(getResources().getColor(2131099804));
      this.mTimeBar.setScrubberColor(getResources().getColor(2131099804));
      this.mTimeBar.setClickable(false);
    }
  }
  
  public void T0()
  {
    TPSmartRefreshLayout localTPSmartRefreshLayout = this.refreshLayout;
    if (localTPSmartRefreshLayout != null) {
      localTPSmartRefreshLayout.l();
    }
  }
  
  public void U0()
  {
    TPSmartRefreshLayout localTPSmartRefreshLayout = this.refreshLayout;
    if (localTPSmartRefreshLayout != null) {
      localTPSmartRefreshLayout.q();
    }
  }
  
  public void V0()
  {
    TPSmartRefreshLayout localTPSmartRefreshLayout = this.refreshLayout;
    if (localTPSmartRefreshLayout != null)
    {
      localTPSmartRefreshLayout.q();
      this.refreshLayout.l();
    }
  }
  
  public void b1(CloudVideoItem paramCloudVideoItem)
  {
    if (paramCloudVideoItem == null) {
      return;
    }
    n1(false, false);
    this.z = paramCloudVideoItem;
    this.p2 = 0L;
    this.p1 = 0;
    this.p0.B(0, 0L);
    c1(this.z);
    CloudVideoListFragment localCloudVideoListFragment = (CloudVideoListFragment)getFragmentManager().findFragmentById(2131362270);
    if (localCloudVideoListFragment != null) {
      localCloudVideoListFragment.s1(paramCloudVideoItem.getCloudVideo().getUuid());
    }
  }
  
  @OnClick
  void capture()
  {
    S0();
  }
  
  @SuppressLint({"SourceLockedOrientationActivity"})
  public boolean d()
  {
    if (getResources().getConfiguration().orientation == 2)
    {
      getActivity().setRequestedOrientation(1);
      this.mSelectCloudVideoView.setVisibility(8);
      this.mEmptyPlayView.setVisibility(8);
      return true;
    }
    return super.d();
  }
  
  @OnClick
  @SuppressLint({"SourceLockedOrientationActivity"})
  void doBack()
  {
    d();
  }
  
  @OnClick
  void download()
  {
    Object localObject1 = (PartCloudVideo)this.z.getCloudVideo().getPartCloudVideos().get(0);
    long l = ((PartCloudVideo)localObject1).getDuration();
    if (!TextUtils.isEmpty(this.L3))
    {
      if ((this.z.getCloudVideo() != null) && (this.z.getCloudVideo().getUuid() != null)) {
        str = this.z.getCloudVideo().getUuid();
      } else {
        str = "";
      }
      w.y(b.d.w.h.a.g(this.L3), l, str);
    }
    String str = b.d.w.h.a.a(((PartCloudVideo)localObject1).getM3u8());
    localObject1 = ((PartCloudVideo)localObject1).getUri();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.z.getCloudVideo().getEventLocalTime());
    ((StringBuilder)localObject2).append(".mp4");
    localObject2 = ((StringBuilder)localObject2).toString();
    com.tplink.iot.h.f localf = new com.tplink.iot.h.f("1000");
    this.N3 = localf;
    localf.z((String)localObject2, str, (String)localObject1, new a());
  }
  
  public void f0() {}
  
  public void f1(List<CloudVideoItem> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.J3.clear();
    this.J3.addAll(paramList);
    if (paramList.isEmpty())
    {
      paramList = this.refreshLayout;
      if (paramList != null) {
        paramList.G(false);
      }
      paramList = this.mCloudVideoRv;
      if (paramList != null) {
        paramList.setVisibility(8);
      }
    }
    else
    {
      paramList = this.refreshLayout;
      if (paramList != null) {
        paramList.G(true);
      }
      paramList = this.mCloudVideoRv;
      if (paramList != null) {
        paramList.setVisibility(0);
      }
    }
    paramList = this.I3;
    if (paramList != null) {
      paramList.H(this.J3);
    }
  }
  
  public void g1(CloudVideoItem paramCloudVideoItem)
  {
    this.z = paramCloudVideoItem;
    Z0(paramCloudVideoItem.getCloudVideo());
  }
  
  public void h1(String paramString)
  {
    CloudVideoListAdapter localCloudVideoListAdapter = this.I3;
    if (localCloudVideoListAdapter != null) {
      localCloudVideoListAdapter.N(paramString);
    }
  }
  
  @OnClick
  void hideVideoList()
  {
    this.mSelectCloudVideoView.setVisibility(8);
    this.mEmptyPlayView.setVisibility(8);
  }
  
  @OnClick
  void mute()
  {
    l1();
  }
  
  public void n()
  {
    download();
  }
  
  public void onActivityCreated(@Nullable Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if (getArguments() != null)
    {
      this.L3 = getArguments().getString("cloud_video_device_id");
      this.M3 = ((ALCameraDevice)getArguments().getSerializable("cloud_video_device"));
      this.O3 = getArguments().getBoolean("cloud_video_open_from_me");
    }
    this.K3 = ((VideoPlayerViewModel)ViewModelProviders.of(this).get(VideoPlayerViewModel.class));
    paramBundle = b.d.w.h.a.g(this.L3);
    ALCameraDevice localALCameraDevice = this.M3;
    if (localALCameraDevice == null) {
      this.K3.n(paramBundle);
    } else {
      this.K3.o(paramBundle, localALCameraDevice);
    }
    j1();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    k1(paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131558743, paramViewGroup, false);
    ButterKnife.b(this, paramLayoutInflater);
    X0();
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    e1();
    com.tplink.iot.view.quicksetup.base.d.b0(getActivity(), 2131100140);
    getActivity().getWindow().getDecorView().setSystemUiVisibility(8192);
  }
  
  public void onPause()
  {
    super.onPause();
    a1();
  }
  
  public void onResume()
  {
    super.onResume();
    k1(getResources().getConfiguration());
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    Y0(this.z);
  }
  
  public void p(CloudVideoItem paramCloudVideoItem)
  {
    if (paramCloudVideoItem.isHasVideo()) {
      b1(paramCloudVideoItem);
    } else {
      s0.p(getActivity(), getString(2131954391));
    }
  }
  
  @OnClick
  void reload()
  {
    n1(false, false);
    if (this.K3.l(((PartCloudVideo)this.z.getCloudVideo().getPartCloudVideos().get(0)).getUriExpiresAt()))
    {
      CloudVideoItem localCloudVideoItem = this.K3.k(this.z.getCloudVideo().getUuid(), this.J3);
      if (localCloudVideoItem != null) {
        this.z = localCloudVideoItem;
      }
    }
    c1(this.z);
  }
  
  @OnClick
  @SuppressLint({"SourceLockedOrientationActivity"})
  void showVideoList()
  {
    if (getResources().getConfiguration().orientation == 2)
    {
      if (this.mSelectCloudVideoView.getVisibility() == 8)
      {
        this.mSelectCloudVideoView.setVisibility(0);
        this.mEmptyPlayView.setVisibility(0);
      }
    }
    else {
      getActivity().setRequestedOrientation(6);
    }
  }
  
  @OnClick
  void topBack()
  {
    getActivity().finish();
  }
  
  @OnClick
  void topClose()
  {
    Object localObject = (CloudVideoListFragment)getFragmentManager().findFragmentById(2131362270);
    if (localObject != null) {
      ((CloudVideoListFragment)localObject).l1();
    }
    localObject = this.N3;
    if (localObject != null)
    {
      ((com.tplink.iot.h.f)localObject).y();
      this.N3 = null;
    }
  }
  
  class a
    implements com.tplink.iot.h.i.b
  {
    a() {}
    
    public void a(long paramLong1, long paramLong2, int paramInt)
    {
      if ((VideoPlayerFragment.H0(VideoPlayerFragment.this) != null) && (VideoPlayerFragment.L0(VideoPlayerFragment.this) != null) && (VideoPlayerFragment.L0(VideoPlayerFragment.this).isShowing()) && (VideoPlayerFragment.J0(VideoPlayerFragment.this).E())) {
        VideoPlayerFragment.H0(VideoPlayerFragment.this).setPercentData((int)(paramLong2 * 100L / paramLong1));
      }
    }
    
    public void b(int paramInt1, int paramInt2)
    {
      if ((VideoPlayerFragment.H0(VideoPlayerFragment.this) != null) && (VideoPlayerFragment.I0(VideoPlayerFragment.this) != null))
      {
        VideoPlayerFragment.H0(VideoPlayerFragment.this).setPercentData(100);
        ((TextView)VideoPlayerFragment.I0(VideoPlayerFragment.this).findViewById(2131364425)).setText(2131952592);
        ((Button)VideoPlayerFragment.I0(VideoPlayerFragment.this).findViewById(2131362081)).setText(2131952441);
        VideoPlayerFragment.K0(VideoPlayerFragment.this).m(VideoPlayerFragment.J0(VideoPlayerFragment.this).B(), paramInt2);
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      if ((VideoPlayerFragment.H0(VideoPlayerFragment.this) != null) && (VideoPlayerFragment.I0(VideoPlayerFragment.this) != null))
      {
        VideoPlayerFragment.H0(VideoPlayerFragment.this).m();
        ((TextView)VideoPlayerFragment.I0(VideoPlayerFragment.this).findViewById(2131364425)).setText(2131952593);
      }
    }
    
    public void onStart()
    {
      VideoPlayerFragment.N0(VideoPlayerFragment.this);
      VideoPlayerFragment.O0(VideoPlayerFragment.this);
      if ((VideoPlayerFragment.H0(VideoPlayerFragment.this) != null) && (VideoPlayerFragment.I0(VideoPlayerFragment.this) != null))
      {
        ((TextView)VideoPlayerFragment.I0(VideoPlayerFragment.this).findViewById(2131364425)).setText(2131952594);
        VideoPlayerFragment.H0(VideoPlayerFragment.this).k();
      }
    }
  }
  
  class b
    implements View.OnClickListener
  {
    b() {}
    
    public void onClick(View paramView)
    {
      VideoPlayerFragment.L0(VideoPlayerFragment.this).dismiss();
      if (VideoPlayerFragment.J0(VideoPlayerFragment.this) != null) {
        VideoPlayerFragment.J0(VideoPlayerFragment.this).y();
      }
    }
  }
  
  class c
    implements Observer<Boolean>
  {
    c() {}
    
    public void a(@Nullable Boolean paramBoolean)
    {
      if ((paramBoolean != null) && (paramBoolean.booleanValue())) {
        TSnackbar.y(VideoPlayerFragment.this.getActivity(), VideoPlayerFragment.this.getString(2131954392), -1).N();
      }
    }
  }
  
  class d
    implements g
  {
    d() {}
    
    public void m(@NonNull com.scwang.smart.refresh.layout.a.f paramf)
    {
      VideoPlayerFragment.P0(VideoPlayerFragment.this, false);
    }
  }
  
  class e
    implements e
  {
    e() {}
    
    public void q(@NonNull com.scwang.smart.refresh.layout.a.f paramf)
    {
      VideoPlayerFragment.P0(VideoPlayerFragment.this, true);
    }
  }
  
  class f
    implements u1.e
  {
    f() {}
    
    public void M(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        VideoPlayerFragment.this.mLoadingAnimationView.o();
        VideoPlayerFragment.this.mLoadingAnimationView.setVisibility(0);
      }
      else
      {
        VideoPlayerFragment.this.mLoadingAnimationView.g();
        VideoPlayerFragment.this.mLoadingAnimationView.setVisibility(8);
      }
    }
    
    public void P(@NonNull PlaybackException paramPlaybackException)
    {
      if (paramPlaybackException.getMessage() != null) {
        VideoPlayerFragment.Q0(VideoPlayerFragment.this, false, true);
      }
      if (VideoPlayerFragment.K0(VideoPlayerFragment.this).l(((PartCloudVideo)VideoPlayerFragment.R0(VideoPlayerFragment.this).getCloudVideo().getPartCloudVideos().get(0)).getUriExpiresAt()))
      {
        paramPlaybackException = (CloudVideoListFragment)VideoPlayerFragment.this.getFragmentManager().findFragmentById(2131362270);
        if (paramPlaybackException != null) {
          paramPlaybackException.j1();
        }
      }
    }
    
    public void o(j2 paramj2, int paramInt) {}
    
    public void q(int paramInt)
    {
      if (paramInt == 3) {
        VideoPlayerFragment.Q0(VideoPlayerFragment.this, false, false);
      } else if (paramInt == 2) {
        VideoPlayerFragment.Q0(VideoPlayerFragment.this, true, false);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\cloudvideo\VideoPlayerFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */