package com.tplink.iot.view.ipcamera.play;

import android.app.Activity;
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
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.Utils.x0.e;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.databinding.FragmentVoiceCallBinding;
import com.tplink.iot.viewmodel.ipcamera.play.TalkViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.VideoPlayViewModel;
import java.util.Objects;

public class VoiceCallFragment
  extends BaseFragment
{
  private AudioManager p0;
  private String p1;
  private VolumeControlDialogFragment p2;
  private FragmentVoiceCallBinding q;
  private VideoPlayViewModel x;
  private TalkViewModel y;
  private ContentObserver z;
  
  private void I0()
  {
    this.y.k("aec");
    AudioManager localAudioManager = this.p0;
    if (localAudioManager != null)
    {
      int i = localAudioManager.getStreamMaxVolume(3);
      int j = this.p0.getStreamVolume(3);
      this.y.S(i, j);
    }
  }
  
  private void J0()
  {
    AudioManager localAudioManager = (AudioManager)getActivity().getSystemService("audio");
    this.p0 = localAudioManager;
    localAudioManager.setMode(-1);
    this.p0.setSpeakerphoneOn(true);
  }
  
  private void Q0()
  {
    long l = this.y.p();
    if (l == 0L) {
      return;
    }
    double d = (System.currentTimeMillis() - l) / 1000.0D;
    e.D(this.p1, d);
    this.y.R(0L);
  }
  
  private void R0()
  {
    AudioManager localAudioManager = this.p0;
    if (localAudioManager != null)
    {
      int i = localAudioManager.getStreamVolume(3);
      int j = this.p0.getStreamMaxVolume(3);
      this.y.S(j, i);
    }
  }
  
  private void T0()
  {
    this.q.d.setAlpha(0.4F);
    VolumeControlDialogFragment localVolumeControlDialogFragment = VolumeControlDialogFragment.S0(false);
    this.p2 = localVolumeControlDialogFragment;
    localVolumeControlDialogFragment.Q0(new z3(this));
    this.p2.B0(this.q.d, 0, 0);
    this.p2.Q0(new y3(this));
    this.p2.show(getChildFragmentManager(), "VOLUME_DIALOG");
    this.y.t.set(true);
  }
  
  private void U0()
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
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131364080: 
      this.y.b0();
      break;
    case 2131363456: 
      this.y.c0();
      break;
    case 2131362334: 
      T0();
      break;
    case 2131362168: 
      this.y.k.set(false);
      this.x.y("VideoPlay.VideoControlPanelFragment");
      break;
    case 2131362002: 
      this.x.y("VideoPlay.VideoControlPanelFragment");
    }
  }
  
  public void S0()
  {
    this.z = new a(new Handler());
    Context localContext = getContext();
    Objects.requireNonNull(localContext);
    ((Context)localContext).getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this.z);
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    this.q = ((FragmentVoiceCallBinding)DataBindingUtil.inflate(paramLayoutInflater, 2131558989, paramViewGroup, false));
    J0();
    paramLayoutInflater = (VideoPlayViewModel)ViewModelProviders.of(getActivity()).get(VideoPlayViewModel.class);
    this.x = paramLayoutInflater;
    this.p1 = paramLayoutInflater.j;
    paramLayoutInflater = (TalkViewModel)ViewModelProviders.of(getActivity()).get(TalkViewModel.class);
    this.y = paramLayoutInflater;
    paramLayoutInflater.m();
    this.y.k.set(true);
    this.y.m.set(true);
    this.q.i(this.y);
    this.q.h(new x3(this));
    I0();
    return this.q.getRoot();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    Q0();
    VolumeControlDialogFragment localVolumeControlDialogFragment = this.p2;
    if (localVolumeControlDialogFragment != null) {
      localVolumeControlDialogFragment.dismissAllowingStateLoss();
    }
    if (this.y.i.get()) {
      this.y.P(false, this.p1);
    }
    this.y.k.set(false);
    this.y.m.set(false);
    if (this.y.n.get() != null) {
      this.x.B((String)this.y.n.get());
    }
  }
  
  public void onPause()
  {
    super.onPause();
    U0();
  }
  
  public void onResume()
  {
    super.onResume();
    S0();
  }
  
  public void onStop()
  {
    super.onStop();
    this.y.l(this.p1);
    this.y.m.set(false);
    this.y.Z();
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
      VoiceCallFragment.H0(VoiceCallFragment.this);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\play\VoiceCallFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */