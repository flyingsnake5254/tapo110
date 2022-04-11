package com.tplink.iot.view.ipcamera.play;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings.System;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.databinding.FragmentTalkBinding;
import com.tplink.iot.viewmodel.ipcamera.play.TalkViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.VideoPlayViewModel;
import java.util.Objects;

public class TalkFragment
  extends BaseFragment
{
  private AudioManager p0;
  private VolumeControlDialogFragment p1;
  private String p2;
  private FragmentTalkBinding q;
  private VideoPlayViewModel x;
  private TalkViewModel y;
  private ContentObserver z;
  
  private void I0()
  {
    this.y.k("half_duplex");
    AudioManager localAudioManager = this.p0;
    if (localAudioManager != null)
    {
      int i = localAudioManager.getStreamMaxVolume(3);
      int j = this.p0.getStreamVolume(3);
      this.y.S(i, j);
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void J0()
  {
    this.q.q.setOnTouchListener(new e2(this));
  }
  
  private void S0()
  {
    AudioManager localAudioManager = this.p0;
    if (localAudioManager != null)
    {
      int i = localAudioManager.getStreamVolume(3);
      int j = this.p0.getStreamMaxVolume(3);
      this.y.S(j, i);
    }
  }
  
  private void U0()
  {
    this.q.c.setAlpha(0.4F);
    VolumeControlDialogFragment localVolumeControlDialogFragment = VolumeControlDialogFragment.S0(false);
    this.p1 = localVolumeControlDialogFragment;
    localVolumeControlDialogFragment.B0(this.q.c, 0, 0);
    this.p1.Q0(new d2(this));
    this.p1.show(getChildFragmentManager(), "VOLUME_DIALOG");
    this.y.t.set(true);
  }
  
  private void V0()
  {
    if (this.z != null)
    {
      Context localContext = getContext();
      Objects.requireNonNull(localContext);
      ((Context)localContext).getContentResolver().unregisterContentObserver(this.z);
    }
  }
  
  private void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131362002)
    {
      if (i == 2131362334) {
        U0();
      }
    }
    else {
      this.x.y("VideoPlay.VideoControlPanelFragment");
    }
  }
  
  public void T0()
  {
    this.z = new a(new Handler());
    Context localContext = getContext();
    Objects.requireNonNull(localContext);
    ((Context)localContext).getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this.z);
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    this.q = ((FragmentTalkBinding)DataBindingUtil.inflate(paramLayoutInflater, 2131558981, paramViewGroup, false));
    paramLayoutInflater = getActivity();
    Objects.requireNonNull(paramLayoutInflater);
    this.x = ((VideoPlayViewModel)ViewModelProviders.of((FragmentActivity)paramLayoutInflater).get(VideoPlayViewModel.class));
    paramLayoutInflater = (TalkViewModel)ViewModelProviders.of(getActivity()).get(TalkViewModel.class);
    this.y = paramLayoutInflater;
    if (paramLayoutInflater.e.get() == 0)
    {
      this.y.e.set(60);
      this.y.N();
    }
    this.p2 = this.x.j;
    this.q.h(new c2(this));
    this.q.i(this.y);
    paramLayoutInflater = getContext();
    Objects.requireNonNull(paramLayoutInflater);
    paramLayoutInflater = (AudioManager)((Context)paramLayoutInflater).getSystemService("audio");
    this.p0 = paramLayoutInflater;
    paramLayoutInflater.setMode(-1);
    J0();
    this.y.k.set(true);
    this.y.m.set(false);
    return this.q.getRoot();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    VolumeControlDialogFragment localVolumeControlDialogFragment = this.p1;
    if (localVolumeControlDialogFragment != null) {
      localVolumeControlDialogFragment.dismissAllowingStateLoss();
    }
    if (this.y.i.get()) {
      this.y.P(false, this.p2);
    }
    this.y.k.set(false);
    this.y.m.set(false);
    if (this.y.n.get() != null) {
      this.x.B((String)this.y.n.get());
    }
  }
  
  public void onResume()
  {
    super.onResume();
    I0();
    T0();
  }
  
  public void onStop()
  {
    super.onStop();
    V0();
    this.y.k.set(false);
    this.y.l(this.p2);
    this.x.y("VideoPlay.VideoControlPanelFragment");
  }
  
  class a
    extends ContentObserver
  {
    a(Handler paramHandler)
    {
      super();
    }
    
    public void onChange(boolean paramBoolean)
    {
      super.onChange(paramBoolean);
      TalkFragment.H0(TalkFragment.this);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\play\TalkFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */