package com.tplink.iot.adapter.cloudvideo;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.c;

public class CloudVideoListAdapter$TitleViewHolder_ViewBinding
  implements Unbinder
{
  private CloudVideoListAdapter.TitleViewHolder b;
  
  @UiThread
  public CloudVideoListAdapter$TitleViewHolder_ViewBinding(CloudVideoListAdapter.TitleViewHolder paramTitleViewHolder, View paramView)
  {
    this.b = paramTitleViewHolder;
    paramTitleViewHolder.mTitleTv = ((TextView)c.d(paramView, 2131364688, "field 'mTitleTv'", TextView.class));
  }
  
  @CallSuper
  public void a()
  {
    CloudVideoListAdapter.TitleViewHolder localTitleViewHolder = this.b;
    if (localTitleViewHolder != null)
    {
      this.b = null;
      localTitleViewHolder.mTitleTv = null;
      return;
    }
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\cloudvideo\CloudVideoListAdapter$TitleViewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */