package com.tplink.iot.adapter.cloudvideo;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.b;
import butterknife.internal.c;

public class CloudVideoListAdapter$HeaderViewHolder_ViewBinding
  implements Unbinder
{
  private CloudVideoListAdapter.HeaderViewHolder b;
  private View c;
  
  @UiThread
  public CloudVideoListAdapter$HeaderViewHolder_ViewBinding(final CloudVideoListAdapter.HeaderViewHolder paramHeaderViewHolder, View paramView)
  {
    this.b = paramHeaderViewHolder;
    paramHeaderViewHolder.mCloudServiceExpireTv = ((TextView)c.d(paramView, 2131364365, "field 'mCloudServiceExpireTv'", TextView.class));
    paramView = c.c(paramView, 2131363017, "field 'mCloudServiceExpireCloseIv' and method 'close'");
    paramHeaderViewHolder.mCloudServiceExpireCloseIv = ((ImageView)c.b(paramView, 2131363017, "field 'mCloudServiceExpireCloseIv'", ImageView.class));
    this.c = paramView;
    paramView.setOnClickListener(new a(paramHeaderViewHolder));
  }
  
  @CallSuper
  public void a()
  {
    CloudVideoListAdapter.HeaderViewHolder localHeaderViewHolder = this.b;
    if (localHeaderViewHolder != null)
    {
      this.b = null;
      localHeaderViewHolder.mCloudServiceExpireTv = null;
      localHeaderViewHolder.mCloudServiceExpireCloseIv = null;
      this.c.setOnClickListener(null);
      this.c = null;
      return;
    }
    throw new IllegalStateException("Bindings already cleared.");
  }
  
  class a
    extends b
  {
    a(CloudVideoListAdapter.HeaderViewHolder paramHeaderViewHolder) {}
    
    public void a(View paramView)
    {
      paramHeaderViewHolder.close();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\cloudvideo\CloudVideoListAdapter$HeaderViewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */