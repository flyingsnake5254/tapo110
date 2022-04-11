package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.view.ipcamera.widget.CloudTerraceControlPanel;
import com.tplink.iot.view.ipcamera.widget.tipsbar.TipsBar;
import com.tplink.iot.viewmodel.ipcamera.play.CloudTerraceControlViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.MultiLiveVideoViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.TalkViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.VideoPlayViewModel;

public abstract class FragmentMultiLiveVideoBinding
  extends ViewDataBinding
{
  @Bindable
  protected g H3;
  @Bindable
  protected VideoPlayViewModel I3;
  @Bindable
  protected TalkViewModel J3;
  @Bindable
  protected MultiLiveVideoViewModel K3;
  @Bindable
  protected CloudTerraceControlViewModel L3;
  @NonNull
  public final ImageView c;
  @NonNull
  public final LayoutFullScreenBottomBarBinding d;
  @NonNull
  public final LayoutFullScreenControlBinding f;
  @NonNull
  public final TextView p0;
  @NonNull
  public final CloudTerraceControlPanel p1;
  @NonNull
  public final TipsBar p2;
  @NonNull
  public final LayoutMultiLiveToolbarBottomBinding p3;
  @NonNull
  public final LayoutDayNightModeBinding q;
  @NonNull
  public final LayoutFullScreenQualityBinding x;
  @NonNull
  public final LayoutVoiceTalkPanelBinding y;
  @NonNull
  public final RecyclerView z;
  
  protected FragmentMultiLiveVideoBinding(Object paramObject, View paramView, int paramInt, ImageView paramImageView, LayoutFullScreenBottomBarBinding paramLayoutFullScreenBottomBarBinding, LayoutFullScreenControlBinding paramLayoutFullScreenControlBinding, LayoutDayNightModeBinding paramLayoutDayNightModeBinding, LayoutFullScreenQualityBinding paramLayoutFullScreenQualityBinding, LayoutVoiceTalkPanelBinding paramLayoutVoiceTalkPanelBinding, RecyclerView paramRecyclerView, TextView paramTextView, CloudTerraceControlPanel paramCloudTerraceControlPanel, TipsBar paramTipsBar, LayoutMultiLiveToolbarBottomBinding paramLayoutMultiLiveToolbarBottomBinding)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramImageView;
    this.d = paramLayoutFullScreenBottomBarBinding;
    this.f = paramLayoutFullScreenControlBinding;
    this.q = paramLayoutDayNightModeBinding;
    this.x = paramLayoutFullScreenQualityBinding;
    this.y = paramLayoutVoiceTalkPanelBinding;
    this.z = paramRecyclerView;
    this.p0 = paramTextView;
    this.p1 = paramCloudTerraceControlPanel;
    this.p2 = paramTipsBar;
    this.p3 = paramLayoutMultiLiveToolbarBottomBinding;
  }
  
  public abstract void h(@Nullable CloudTerraceControlViewModel paramCloudTerraceControlViewModel);
  
  public abstract void i(@Nullable MultiLiveVideoViewModel paramMultiLiveVideoViewModel);
  
  public abstract void l(@Nullable VideoPlayViewModel paramVideoPlayViewModel);
  
  public abstract void m(@Nullable g paramg);
  
  public abstract void n(@Nullable TalkViewModel paramTalkViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentMultiLiveVideoBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */