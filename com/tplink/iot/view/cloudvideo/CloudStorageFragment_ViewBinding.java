package com.tplink.iot.view.cloudvideo;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.b;
import butterknife.internal.c;

public class CloudStorageFragment_ViewBinding
  implements Unbinder
{
  private CloudStorageFragment b;
  private View c;
  private View d;
  private View e;
  private View f;
  private View g;
  private View h;
  
  @UiThread
  public CloudStorageFragment_ViewBinding(final CloudStorageFragment paramCloudStorageFragment, View paramView)
  {
    this.b = paramCloudStorageFragment;
    View localView = c.c(paramView, 2131363188, "field 'mCloudStorageView' and method 'gotoStorageService'");
    paramCloudStorageFragment.mCloudStorageView = localView;
    this.c = localView;
    localView.setOnClickListener(new a(paramCloudStorageFragment));
    paramCloudStorageFragment.mCloudStorageVideoListView = c.c(paramView, 2131363189, "field 'mCloudStorageVideoListView'");
    paramCloudStorageFragment.mEmptyView = c.c(paramView, 2131363170, "field 'mEmptyView'");
    paramCloudStorageFragment.mCloudVideoListView = c.c(paramView, 2131363273, "field 'mCloudVideoListView'");
    paramCloudStorageFragment.mCloudStorageTitleTv = ((TextView)c.d(paramView, 2131364371, "field 'mCloudStorageTitleTv'", TextView.class));
    paramCloudStorageFragment.mCloudStorageContentTv = ((TextView)c.d(paramView, 2131364370, "field 'mCloudStorageContentTv'", TextView.class));
    paramCloudStorageFragment.mCloudStorageConfirmTv = ((TextView)c.d(paramView, 2131364382, "field 'mCloudStorageConfirmTv'", TextView.class));
    paramCloudStorageFragment.mFirstCloudVideoView = c.c(paramView, 2131363288, "field 'mFirstCloudVideoView'");
    paramCloudStorageFragment.mSecondCloudVideoView = c.c(paramView, 2131363333, "field 'mSecondCloudVideoView'");
    paramCloudStorageFragment.mThirdCloudVideoView = c.c(paramView, 2131363347, "field 'mThirdCloudVideoView'");
    localView = c.c(paramView, 2131363052, "field 'mFirstCloudVideoIv' and method 'firstCloudVideoClicked'");
    paramCloudStorageFragment.mFirstCloudVideoIv = ((ImageView)c.b(localView, 2131363052, "field 'mFirstCloudVideoIv'", ImageView.class));
    this.d = localView;
    localView.setOnClickListener(new b(paramCloudStorageFragment));
    localView = c.c(paramView, 2131363115, "field 'mSecondCloudVideoIv' and method 'secondCloudVideoClicked'");
    paramCloudStorageFragment.mSecondCloudVideoIv = ((ImageView)c.b(localView, 2131363115, "field 'mSecondCloudVideoIv'", ImageView.class));
    this.e = localView;
    localView.setOnClickListener(new c(paramCloudStorageFragment));
    localView = c.c(paramView, 2131363143, "field 'mThirdCloudVideoIv' and method 'thirdCloudVideoClicked'");
    paramCloudStorageFragment.mThirdCloudVideoIv = ((ImageView)c.b(localView, 2131363143, "field 'mThirdCloudVideoIv'", ImageView.class));
    this.f = localView;
    localView.setOnClickListener(new d(paramCloudStorageFragment));
    paramCloudStorageFragment.mFirstCloudNoVideoIv = ((ImageView)c.d(paramView, 2131363051, "field 'mFirstCloudNoVideoIv'", ImageView.class));
    paramCloudStorageFragment.mSecondCloudNoVideoIv = ((ImageView)c.d(paramView, 2131363114, "field 'mSecondCloudNoVideoIv'", ImageView.class));
    paramCloudStorageFragment.mThirdCloudNoVideoIv = ((ImageView)c.d(paramView, 2131363142, "field 'mThirdCloudNoVideoIv'", ImageView.class));
    paramCloudStorageFragment.mFirstCloudVideoTv = ((TextView)c.d(paramView, 2131364461, "field 'mFirstCloudVideoTv'", TextView.class));
    paramCloudStorageFragment.mSecondCloudVideoTv = ((TextView)c.d(paramView, 2131364616, "field 'mSecondCloudVideoTv'", TextView.class));
    paramCloudStorageFragment.mThirdCloudVideoTv = ((TextView)c.d(paramView, 2131364669, "field 'mThirdCloudVideoTv'", TextView.class));
    paramCloudStorageFragment.mExpireTimeTv = ((TextView)c.d(paramView, 2131364367, "field 'mExpireTimeTv'", TextView.class));
    paramCloudStorageFragment.mCloseIv = ((ImageView)c.d(paramView, 2131363016, "field 'mCloseIv'", ImageView.class));
    paramCloudStorageFragment.mNewDailySummaryPoint = ((ImageView)c.d(paramView, 2131363085, "field 'mNewDailySummaryPoint'", ImageView.class));
    localView = c.c(paramView, 2131363478, "method 'showVideoList'");
    this.g = localView;
    localView.setOnClickListener(new e(paramCloudStorageFragment));
    paramView = c.c(paramView, 2131363878, "method 'onExpireClick'");
    this.h = paramView;
    paramView.setOnClickListener(new f(paramCloudStorageFragment));
  }
  
  @CallSuper
  public void a()
  {
    CloudStorageFragment localCloudStorageFragment = this.b;
    if (localCloudStorageFragment != null)
    {
      this.b = null;
      localCloudStorageFragment.mCloudStorageView = null;
      localCloudStorageFragment.mCloudStorageVideoListView = null;
      localCloudStorageFragment.mEmptyView = null;
      localCloudStorageFragment.mCloudVideoListView = null;
      localCloudStorageFragment.mCloudStorageTitleTv = null;
      localCloudStorageFragment.mCloudStorageContentTv = null;
      localCloudStorageFragment.mCloudStorageConfirmTv = null;
      localCloudStorageFragment.mFirstCloudVideoView = null;
      localCloudStorageFragment.mSecondCloudVideoView = null;
      localCloudStorageFragment.mThirdCloudVideoView = null;
      localCloudStorageFragment.mFirstCloudVideoIv = null;
      localCloudStorageFragment.mSecondCloudVideoIv = null;
      localCloudStorageFragment.mThirdCloudVideoIv = null;
      localCloudStorageFragment.mFirstCloudNoVideoIv = null;
      localCloudStorageFragment.mSecondCloudNoVideoIv = null;
      localCloudStorageFragment.mThirdCloudNoVideoIv = null;
      localCloudStorageFragment.mFirstCloudVideoTv = null;
      localCloudStorageFragment.mSecondCloudVideoTv = null;
      localCloudStorageFragment.mThirdCloudVideoTv = null;
      localCloudStorageFragment.mExpireTimeTv = null;
      localCloudStorageFragment.mCloseIv = null;
      localCloudStorageFragment.mNewDailySummaryPoint = null;
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
      return;
    }
    throw new IllegalStateException("Bindings already cleared.");
  }
  
  class a
    extends b
  {
    a(CloudStorageFragment paramCloudStorageFragment) {}
    
    public void a(View paramView)
    {
      paramCloudStorageFragment.gotoStorageService();
    }
  }
  
  class b
    extends b
  {
    b(CloudStorageFragment paramCloudStorageFragment) {}
    
    public void a(View paramView)
    {
      paramCloudStorageFragment.firstCloudVideoClicked();
    }
  }
  
  class c
    extends b
  {
    c(CloudStorageFragment paramCloudStorageFragment) {}
    
    public void a(View paramView)
    {
      paramCloudStorageFragment.secondCloudVideoClicked();
    }
  }
  
  class d
    extends b
  {
    d(CloudStorageFragment paramCloudStorageFragment) {}
    
    public void a(View paramView)
    {
      paramCloudStorageFragment.thirdCloudVideoClicked();
    }
  }
  
  class e
    extends b
  {
    e(CloudStorageFragment paramCloudStorageFragment) {}
    
    public void a(View paramView)
    {
      paramCloudStorageFragment.showVideoList();
    }
  }
  
  class f
    extends b
  {
    f(CloudStorageFragment paramCloudStorageFragment) {}
    
    public void a(View paramView)
    {
      paramCloudStorageFragment.onExpireClick();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\cloudvideo\CloudStorageFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */