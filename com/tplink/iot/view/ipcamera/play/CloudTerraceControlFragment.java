package com.tplink.iot.view.ipcamera.play;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.databinding.FragmentCloudTerraceControlBinding;
import com.tplink.iot.view.ipcamera.widget.CloudTerraceControlPanel;
import com.tplink.iot.view.ipcamera.widget.CloudTerraceControlPanel.c;
import com.tplink.iot.viewmodel.ipcamera.play.CloudTerraceControlViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.CloudTerracePresetViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.MultiLiveVideoViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.VideoPlayViewModel;
import com.tplink.libtpnetwork.Utils.j;
import com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a;
import io.reactivex.e0.b;
import java.util.Objects;

public class CloudTerraceControlFragment
  extends BaseFragment
{
  @BindView
  CloudTerraceControlPanel controlPanel;
  View p0;
  ViewGroup p1;
  private Unbinder p2;
  private b p3 = new b();
  VideoPlayViewModel q;
  CloudTerracePresetViewModel x;
  CloudTerraceControlViewModel y;
  FragmentCloudTerraceControlBinding z;
  
  private void W0(boolean paramBoolean)
  {
    if (paramBoolean) {
      com.tplink.iot.Utils.x0.e.h(this.q.j);
    } else {
      com.tplink.iot.Utils.x0.e.i(this.q.j);
    }
  }
  
  protected void H0()
  {
    FragmentActivity localFragmentActivity = getActivity();
    Fragment localFragment = getParentFragment();
    if (localFragmentActivity != null)
    {
      this.q = ((VideoPlayViewModel)ViewModelProviders.of(localFragmentActivity).get(VideoPlayViewModel.class));
      CloudTerraceControlViewModel localCloudTerraceControlViewModel = (CloudTerraceControlViewModel)ViewModelProviders.of(localFragmentActivity).get(CloudTerraceControlViewModel.class);
      this.y = localCloudTerraceControlViewModel;
      localCloudTerraceControlViewModel.n0(localFragmentActivity);
    }
    if (localFragment != null) {
      this.x = ((CloudTerracePresetViewModel)ViewModelProviders.of(localFragment).get(CloudTerracePresetViewModel.class));
    }
  }
  
  public void I0()
  {
    this.q.k.observe(this, new e(this));
    this.y.Q3.observe(this, new d(this));
    FragmentActivity localFragmentActivity = getActivity();
    Objects.requireNonNull(localFragmentActivity);
    ((MultiLiveVideoViewModel)ViewModelProviders.of((FragmentActivity)localFragmentActivity).get(MultiLiveVideoViewModel.class)).v(this.y.P3);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  protected void J0()
  {
    Object localObject = this.z;
    if (localObject != null)
    {
      ((ViewDataBinding)localObject).setLifecycleOwner(this);
      this.z.h(this.y);
      FragmentCloudTerraceControlBinding localFragmentCloudTerraceControlBinding = this.z;
      localObject = getArguments();
      boolean bool1 = false;
      boolean bool2 = bool1;
      if (localObject != null)
      {
        bool2 = bool1;
        if (getArguments().getBoolean("cloud_terrace_feature_visible", false)) {
          bool2 = true;
        }
      }
      localFragmentCloudTerraceControlBinding.i(Boolean.valueOf(bool2));
      this.z.c.setOnTouchListener(new i(this));
    }
    this.controlPanel.setOnLongPressListener(new a());
  }
  
  public void X0(CloudTerraceControlPanel paramCloudTerraceControlPanel)
  {
    if (j.h(this.y.K3)) {
      this.y.K3.setValue(Boolean.FALSE);
    }
    int i = paramCloudTerraceControlPanel.getClickedArea();
    if (i == -1) {
      return;
    }
    this.y.l0(i);
  }
  
  @OnClick
  public void cruiseHorizontal()
  {
    if (j.h(this.y.O3))
    {
      W0(false);
      this.y.m();
    }
    else
    {
      W0(true);
      this.y.l(false);
    }
  }
  
  @OnClick
  public void cruiseVertical()
  {
    if (j.h(this.y.N3))
    {
      W0(false);
      this.y.m();
    }
    else
    {
      W0(true);
      this.y.l(true);
    }
  }
  
  @OnClick
  public void markPosition()
  {
    CloudTerracePresetViewModel localCloudTerracePresetViewModel = this.x;
    if (localCloudTerracePresetViewModel != null) {
      localCloudTerracePresetViewModel.C().setValue(new a(Boolean.TRUE));
    }
  }
  
  @OnClick
  public void move(CloudTerraceControlPanel paramCloudTerraceControlPanel)
  {
    if (j.h(this.y.K3)) {
      this.y.K3.setValue(Boolean.FALSE);
    }
    int i = paramCloudTerraceControlPanel.getClickedArea();
    if (i == -1) {
      return;
    }
    this.y.n(false, new f(this, i));
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    this.p1 = paramViewGroup;
    paramLayoutInflater = paramLayoutInflater.inflate(2131558910, paramViewGroup, false);
    this.p0 = paramLayoutInflater;
    this.p2 = ButterKnife.b(this, paramLayoutInflater);
    this.z = ((FragmentCloudTerraceControlBinding)DataBindingUtil.bind(this.p0));
    H0();
    J0();
    I0();
    return this.p0;
  }
  
  public void onDestroyView()
  {
    this.p2.a();
    FragmentActivity localFragmentActivity = getActivity();
    Objects.requireNonNull(localFragmentActivity);
    ((MultiLiveVideoViewModel)ViewModelProviders.of((FragmentActivity)localFragmentActivity).get(MultiLiveVideoViewModel.class)).p0(this.y.P3);
    this.y.K3.setValue(Boolean.FALSE);
    this.p3.d();
    super.onDestroyView();
  }
  
  @OnClick
  @SuppressLint({"ClickableViewAccessibility"})
  public void openSensitivityPanel()
  {
    CloudTerraceSensitivityDialogFragment localCloudTerraceSensitivityDialogFragment = CloudTerraceSensitivityDialogFragment.N0();
    localCloudTerraceSensitivityDialogFragment.A0(this.z.z, 0, 0);
    localCloudTerraceSensitivityDialogFragment.P0(this.y);
    localCloudTerraceSensitivityDialogFragment.O0(g.c);
    localCloudTerraceSensitivityDialogFragment.show(getChildFragmentManager(), CloudTerraceSensitivityDialogFragment.c);
  }
  
  class a
    implements CloudTerraceControlPanel.c
  {
    a() {}
    
    public void a()
    {
      if (CloudTerraceControlFragment.this.y.y()) {
        return;
      }
      CloudTerraceControlFragment localCloudTerraceControlFragment = CloudTerraceControlFragment.this;
      localCloudTerraceControlFragment.X0(localCloudTerraceControlFragment.controlPanel);
    }
    
    public void b()
    {
      CloudTerraceControlFragment.this.y.q0();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\play\CloudTerraceControlFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */