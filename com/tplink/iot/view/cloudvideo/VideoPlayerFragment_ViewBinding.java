package com.tplink.iot.view.cloudvideo;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.b;
import butterknife.internal.c;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.exoplayer2.ui.DefaultTimeBar;
import com.google.android.exoplayer2.ui.PlayerView;
import com.tplink.iot.widget.refreshlayout.TPSmartRefreshLayout;

public class VideoPlayerFragment_ViewBinding
  implements Unbinder
{
  private VideoPlayerFragment b;
  private View c;
  private View d;
  private View e;
  private View f;
  private View g;
  private View h;
  private View i;
  private View j;
  private View k;
  private View l;
  private View m;
  private View n;
  private View o;
  
  @UiThread
  public VideoPlayerFragment_ViewBinding(final VideoPlayerFragment paramVideoPlayerFragment, View paramView)
  {
    this.b = paramVideoPlayerFragment;
    paramVideoPlayerFragment.mPlayerView = ((PlayerView)c.d(paramView, 2131362277, "field 'mPlayerView'", PlayerView.class));
    View localView = c.c(paramView, 2131363009, "field 'mCaptureIv' and method 'capture'");
    paramVideoPlayerFragment.mCaptureIv = ((ImageView)c.b(localView, 2131363009, "field 'mCaptureIv'", ImageView.class));
    this.c = localView;
    localView.setOnClickListener(new e(paramVideoPlayerFragment));
    localView = c.c(paramView, 2131363083, "field 'mMuteIv' and method 'mute'");
    paramVideoPlayerFragment.mMuteIv = ((ImageView)c.b(localView, 2131363083, "field 'mMuteIv'", ImageView.class));
    this.d = localView;
    localView.setOnClickListener(new f(paramVideoPlayerFragment));
    localView = c.c(paramView, 2131363037, "field 'mDownloadIv' and method 'download'");
    paramVideoPlayerFragment.mDownloadIv = ((ImageView)c.b(localView, 2131363037, "field 'mDownloadIv'", ImageView.class));
    this.e = localView;
    localView.setOnClickListener(new g(paramVideoPlayerFragment));
    paramVideoPlayerFragment.mBottomToolButtonsView = ((LinearLayout)c.d(paramView, 2131363266, "field 'mBottomToolButtonsView'", LinearLayout.class));
    paramVideoPlayerFragment.mPlayTitleView = ((RelativeLayout)c.d(paramView, 2131363652, "field 'mPlayTitleView'", RelativeLayout.class));
    paramVideoPlayerFragment.mRootView = ((LinearLayout)c.d(paramView, 2131363919, "field 'mRootView'", LinearLayout.class));
    paramVideoPlayerFragment.mVideoPlayLayout = ((FrameLayout)c.d(paramView, 2131364771, "field 'mVideoPlayLayout'", FrameLayout.class));
    localView = c.c(paramView, 2131363056, "field 'mFullScreenOrSelectVideoIv' and method 'showVideoList'");
    paramVideoPlayerFragment.mFullScreenOrSelectVideoIv = ((ImageView)c.b(localView, 2131363056, "field 'mFullScreenOrSelectVideoIv'", ImageView.class));
    this.f = localView;
    localView.setOnClickListener(new h(paramVideoPlayerFragment));
    localView = c.c(paramView, 2131363039, "field 'mDownloadLandIv' and method 'download'");
    paramVideoPlayerFragment.mDownloadLandIv = ((ImageView)c.b(localView, 2131363039, "field 'mDownloadLandIv'", ImageView.class));
    this.g = localView;
    localView.setOnClickListener(new i(paramVideoPlayerFragment));
    localView = c.c(paramView, 2131363084, "field 'mMuteLandIv' and method 'mute'");
    paramVideoPlayerFragment.mMuteLandIv = ((ImageView)c.b(localView, 2131363084, "field 'mMuteLandIv'", ImageView.class));
    this.h = localView;
    localView.setOnClickListener(new j(paramVideoPlayerFragment));
    localView = c.c(paramView, 2131363270, "field 'mCaptureLandView' and method 'capture'");
    paramVideoPlayerFragment.mCaptureLandView = ((RelativeLayout)c.b(localView, 2131363270, "field 'mCaptureLandView'", RelativeLayout.class));
    this.i = localView;
    localView.setOnClickListener(new k(paramVideoPlayerFragment));
    paramVideoPlayerFragment.mCaptureLandIv = ((ImageView)c.d(paramView, 2131363010, "field 'mCaptureLandIv'", ImageView.class));
    paramVideoPlayerFragment.mSelectCloudVideoView = ((LinearLayout)c.d(paramView, 2131363334, "field 'mSelectCloudVideoView'", LinearLayout.class));
    localView = c.c(paramView, 2131364798, "field 'mEmptyPlayView' and method 'hideVideoList'");
    paramVideoPlayerFragment.mEmptyPlayView = localView;
    this.j = localView;
    localView.setOnClickListener(new l(paramVideoPlayerFragment));
    paramVideoPlayerFragment.mCloudVideoRv = ((RecyclerView)c.d(paramView, 2131363802, "field 'mCloudVideoRv'", RecyclerView.class));
    paramVideoPlayerFragment.mTopControlView = ((RelativeLayout)c.d(paramView, 2131363913, "field 'mTopControlView'", RelativeLayout.class));
    paramVideoPlayerFragment.mLoadingAnimationView = ((LottieAnimationView)c.d(paramView, 2131362274, "field 'mLoadingAnimationView'", LottieAnimationView.class));
    localView = c.c(paramView, 2131363275, "field 'mTapRefreshView' and method 'reload'");
    paramVideoPlayerFragment.mTapRefreshView = ((LinearLayout)c.b(localView, 2131363275, "field 'mTapRefreshView'", LinearLayout.class));
    this.k = localView;
    localView.setOnClickListener(new m(paramVideoPlayerFragment));
    paramVideoPlayerFragment.refreshLayout = ((TPSmartRefreshLayout)c.d(paramView, 2131362276, "field 'refreshLayout'", TPSmartRefreshLayout.class));
    paramVideoPlayerFragment.mPlayIv = ((ImageView)c.d(paramView, 2131362592, "field 'mPlayIv'", ImageView.class));
    paramVideoPlayerFragment.mPauseIv = ((ImageView)c.d(paramView, 2131362591, "field 'mPauseIv'", ImageView.class));
    paramVideoPlayerFragment.mPositionTv = ((TextView)c.d(paramView, 2131362595, "field 'mPositionTv'", TextView.class));
    paramVideoPlayerFragment.mDurationTv = ((TextView)c.d(paramView, 2131362344, "field 'mDurationTv'", TextView.class));
    paramVideoPlayerFragment.mTimeBar = ((DefaultTimeBar)c.d(paramView, 2131362597, "field 'mTimeBar'", DefaultTimeBar.class));
    localView = c.c(paramView, 2131363015, "method 'hideVideoList'");
    this.l = localView;
    localView.setOnClickListener(new a(paramVideoPlayerFragment));
    localView = c.c(paramView, 2131361999, "method 'doBack'");
    this.m = localView;
    localView.setOnClickListener(new b(paramVideoPlayerFragment));
    localView = c.c(paramView, 2131363148, "method 'topBack'");
    this.n = localView;
    localView.setOnClickListener(new c(paramVideoPlayerFragment));
    paramView = c.c(paramView, 2131363149, "method 'topClose'");
    this.o = paramView;
    paramView.setOnClickListener(new d(paramVideoPlayerFragment));
  }
  
  @CallSuper
  public void a()
  {
    VideoPlayerFragment localVideoPlayerFragment = this.b;
    if (localVideoPlayerFragment != null)
    {
      this.b = null;
      localVideoPlayerFragment.mPlayerView = null;
      localVideoPlayerFragment.mCaptureIv = null;
      localVideoPlayerFragment.mMuteIv = null;
      localVideoPlayerFragment.mDownloadIv = null;
      localVideoPlayerFragment.mBottomToolButtonsView = null;
      localVideoPlayerFragment.mPlayTitleView = null;
      localVideoPlayerFragment.mRootView = null;
      localVideoPlayerFragment.mVideoPlayLayout = null;
      localVideoPlayerFragment.mFullScreenOrSelectVideoIv = null;
      localVideoPlayerFragment.mDownloadLandIv = null;
      localVideoPlayerFragment.mMuteLandIv = null;
      localVideoPlayerFragment.mCaptureLandView = null;
      localVideoPlayerFragment.mCaptureLandIv = null;
      localVideoPlayerFragment.mSelectCloudVideoView = null;
      localVideoPlayerFragment.mEmptyPlayView = null;
      localVideoPlayerFragment.mCloudVideoRv = null;
      localVideoPlayerFragment.mTopControlView = null;
      localVideoPlayerFragment.mLoadingAnimationView = null;
      localVideoPlayerFragment.mTapRefreshView = null;
      localVideoPlayerFragment.refreshLayout = null;
      localVideoPlayerFragment.mPlayIv = null;
      localVideoPlayerFragment.mPauseIv = null;
      localVideoPlayerFragment.mPositionTv = null;
      localVideoPlayerFragment.mDurationTv = null;
      localVideoPlayerFragment.mTimeBar = null;
      this.c.setOnClickListener(null);
      this.c = null;
      this.d.setOnClickListener(null);
      this.d = null;
      this.e.setOnClickListener(null);
      this.e = null;
      this.f.setOnClickListener(null);
      this.f = null;
      this.g.setOnClickListener(null);
      this.g = null;
      this.h.setOnClickListener(null);
      this.h = null;
      this.i.setOnClickListener(null);
      this.i = null;
      this.j.setOnClickListener(null);
      this.j = null;
      this.k.setOnClickListener(null);
      this.k = null;
      this.l.setOnClickListener(null);
      this.l = null;
      this.m.setOnClickListener(null);
      this.m = null;
      this.n.setOnClickListener(null);
      this.n = null;
      this.o.setOnClickListener(null);
      this.o = null;
      return;
    }
    throw new IllegalStateException("Bindings already cleared.");
  }
  
  class a
    extends b
  {
    a(VideoPlayerFragment paramVideoPlayerFragment) {}
    
    public void a(View paramView)
    {
      paramVideoPlayerFragment.hideVideoList();
    }
  }
  
  class b
    extends b
  {
    b(VideoPlayerFragment paramVideoPlayerFragment) {}
    
    public void a(View paramView)
    {
      paramVideoPlayerFragment.doBack();
    }
  }
  
  class c
    extends b
  {
    c(VideoPlayerFragment paramVideoPlayerFragment) {}
    
    public void a(View paramView)
    {
      paramVideoPlayerFragment.topBack();
    }
  }
  
  class d
    extends b
  {
    d(VideoPlayerFragment paramVideoPlayerFragment) {}
    
    public void a(View paramView)
    {
      paramVideoPlayerFragment.topClose();
    }
  }
  
  class e
    extends b
  {
    e(VideoPlayerFragment paramVideoPlayerFragment) {}
    
    public void a(View paramView)
    {
      paramVideoPlayerFragment.capture();
    }
  }
  
  class f
    extends b
  {
    f(VideoPlayerFragment paramVideoPlayerFragment) {}
    
    public void a(View paramView)
    {
      paramVideoPlayerFragment.mute();
    }
  }
  
  class g
    extends b
  {
    g(VideoPlayerFragment paramVideoPlayerFragment) {}
    
    public void a(View paramView)
    {
      paramVideoPlayerFragment.download();
    }
  }
  
  class h
    extends b
  {
    h(VideoPlayerFragment paramVideoPlayerFragment) {}
    
    public void a(View paramView)
    {
      paramVideoPlayerFragment.showVideoList();
    }
  }
  
  class i
    extends b
  {
    i(VideoPlayerFragment paramVideoPlayerFragment) {}
    
    public void a(View paramView)
    {
      paramVideoPlayerFragment.download();
    }
  }
  
  class j
    extends b
  {
    j(VideoPlayerFragment paramVideoPlayerFragment) {}
    
    public void a(View paramView)
    {
      paramVideoPlayerFragment.mute();
    }
  }
  
  class k
    extends b
  {
    k(VideoPlayerFragment paramVideoPlayerFragment) {}
    
    public void a(View paramView)
    {
      paramVideoPlayerFragment.capture();
    }
  }
  
  class l
    extends b
  {
    l(VideoPlayerFragment paramVideoPlayerFragment) {}
    
    public void a(View paramView)
    {
      paramVideoPlayerFragment.hideVideoList();
    }
  }
  
  class m
    extends b
  {
    m(VideoPlayerFragment paramVideoPlayerFragment) {}
    
    public void a(View paramView)
    {
      paramVideoPlayerFragment.reload();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\cloudvideo\VideoPlayerFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */