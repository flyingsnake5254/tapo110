package com.tplink.iot.adapter.cloudvideo;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.c;

public class CloudVideoListAdapter$VideoViewHolder_ViewBinding
  implements Unbinder
{
  private CloudVideoListAdapter.VideoViewHolder b;
  
  @UiThread
  public CloudVideoListAdapter$VideoViewHolder_ViewBinding(CloudVideoListAdapter.VideoViewHolder paramVideoViewHolder, View paramView)
  {
    this.b = paramVideoViewHolder;
    paramVideoViewHolder.mVideoIv = ((ImageView)c.d(paramView, 2131363153, "field 'mVideoIv'", ImageView.class));
    paramVideoViewHolder.mNoVideoIv = ((ImageView)c.d(paramView, 2131363091, "field 'mNoVideoIv'", ImageView.class));
    paramVideoViewHolder.mPlayVideoIv = ((ImageView)c.d(paramView, 2131363098, "field 'mPlayVideoIv'", ImageView.class));
    paramVideoViewHolder.mRecordTimeTv = ((TextView)c.d(paramView, 2131364590, "field 'mRecordTimeTv'", TextView.class));
    paramVideoViewHolder.mSelectIv = ((ImageView)c.d(paramView, 2131363116, "field 'mSelectIv'", ImageView.class));
  }
  
  @CallSuper
  public void a()
  {
    CloudVideoListAdapter.VideoViewHolder localVideoViewHolder = this.b;
    if (localVideoViewHolder != null)
    {
      this.b = null;
      localVideoViewHolder.mVideoIv = null;
      localVideoViewHolder.mNoVideoIv = null;
      localVideoViewHolder.mPlayVideoIv = null;
      localVideoViewHolder.mRecordTimeTv = null;
      localVideoViewHolder.mSelectIv = null;
      return;
    }
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\cloudvideo\CloudVideoListAdapter$VideoViewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */