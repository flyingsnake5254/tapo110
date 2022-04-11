package com.tplink.iot.view.ipcamera.play;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableFloat;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.d.w.c.a;
import com.tplink.iot.adapter.playback.RecordTypeAdapter;
import com.tplink.iot.adapter.playback.SnapshotAdapter;
import com.tplink.iot.adapter.playback.SnapshotAdapter.a;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.databinding.FragmentPlayBackControlBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.view.ipcamera.widget.calendar.b;
import com.tplink.iot.view.ipcamera.widget.calendar.c;
import com.tplink.iot.view.ipcamera.widget.calendar.d;
import com.tplink.iot.view.ipcamera.widget.timeaxis.TimeAxisLayout.b;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.play.PlayBackControlViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.PlaybackMainViewModel;
import java.util.Calendar;
import java.util.Objects;
import java.util.TimeZone;

public class PlayBackControlFragment
  extends BaseFragment
  implements g, b, c, TimeAxisLayout.b
{
  private RecyclerView p0;
  private RecyclerView p1;
  private RecordTypeAdapter p2;
  private SnapshotAdapter.a p3 = new w0(this);
  private FragmentPlayBackControlBinding q;
  private PlaybackMainViewModel x;
  private PlayBackControlViewModel y;
  private SnapshotAdapter z;
  
  private void i1()
  {
    this.y.C0(this);
    this.y.w().observe(this, new v0(this));
    this.y.p().observe(this, new u0(this));
    this.y.z().observe(this, new c1(this));
    this.y.r().observe(this, new b1(this));
    this.y.u().observe(this, new y0(this));
    this.y.y().observe(this, new t0(this));
    this.y.s().observe(this, new z0(this));
    this.y.t().observe(this, new x0(this));
    this.y.A().observe(this, new a1(this));
    this.x.z.observe(this, new e1(this));
    this.y.Y3.observe(this, new d1(this));
    this.y.D().observe(this, new s0(this));
  }
  
  public void L() {}
  
  public void M0(d paramd)
  {
    Object localObject = this.y.C();
    localObject = new d(((Calendar)localObject).get(1), ((Calendar)localObject).get(2) + 1, ((Calendar)localObject).get(5));
    if (paramd.b((d)localObject) > 0)
    {
      if (this.y.T3.get()) {
        this.y.G();
      }
    }
    else if (paramd.b((d)localObject) < 0) {
      this.y.I();
    }
  }
  
  public void T() {}
  
  public void g0(int paramInt1, int paramInt2, int paramInt3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("year ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" month ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" day ");
    localStringBuilder.append(paramInt3);
    a.c("VideoPlay.PlayBackControlFragment", localStringBuilder.toString());
    this.y.u0(paramInt1, paramInt2, paramInt3);
    this.y.n0();
  }
  
  public void onClick(View paramView)
  {
    if (this.y.Z3.get()) {
      return;
    }
    int i = paramView.getId();
    if (i != 2131362367)
    {
      boolean bool1 = false;
      boolean bool2 = false;
      boolean bool3 = false;
      boolean bool4 = false;
      boolean bool5;
      ObservableBoolean localObservableBoolean;
      switch (i)
      {
      default: 
        int j;
        int k;
        switch (i)
        {
        default: 
          break;
        case 2131362364: 
          if (this.y.U3.get())
          {
            this.y.G();
          }
          else
          {
            this.y.F();
            j = this.y.l().get(1);
            i = this.y.l().get(2);
            k = this.y.l().get(5);
            this.y.g4.set(new d(j, i + 1, k));
          }
          break;
        case 2131362363: 
          if (this.y.U3.get())
          {
            this.y.I();
          }
          else
          {
            this.y.H();
            j = this.y.l().get(1);
            i = this.y.l().get(2);
            k = this.y.l().get(5);
            this.y.g4.set(new d(j, i + 1, k));
          }
          break;
        case 2131362362: 
          paramView = this.y.U3;
          paramView.set(paramView.get() ^ true);
          paramView = this.y;
          paramView.f(paramView.U3.get());
          paramView = this.y.W3;
          if ((!paramView.get()) && (this.x.q.get())) {
            bool5 = true;
          } else {
            bool5 = false;
          }
          paramView.set(bool5);
          paramView = this.y.V3;
          bool5 = bool4;
          if (!paramView.get())
          {
            bool5 = bool4;
            if (!this.x.q.get())
            {
              bool5 = bool4;
              if (!this.y.Z3.get()) {
                bool5 = true;
              }
            }
          }
          paramView.set(bool5);
          break;
        case 2131362361: 
          if (this.y.U3.get()) {
            break;
          }
          paramView = this.y.U3;
          paramView.set(paramView.get() ^ true);
          paramView = this.y;
          paramView.f(paramView.U3.get());
          paramView = this.y.W3;
          if ((!paramView.get()) && (this.x.q.get())) {
            bool5 = true;
          } else {
            bool5 = false;
          }
          paramView.set(bool5);
          paramView = this.y.V3;
          bool5 = bool1;
          if (!paramView.get())
          {
            bool5 = bool1;
            if (!this.x.q.get())
            {
              bool5 = bool1;
              if (!this.y.Z3.get()) {
                bool5 = true;
              }
            }
          }
          paramView.set(bool5);
        }
        break;
      case 2131362227: 
        this.y.j();
        paramView = this.y;
        localObservableBoolean = paramView.b4;
        bool5 = bool2;
        if (paramView.a4.get())
        {
          bool5 = bool2;
          if (this.y.c4.get()) {
            bool5 = true;
          }
        }
        localObservableBoolean.set(bool5);
        break;
      case 2131362226: 
        this.y.j();
        paramView = this.y;
        localObservableBoolean = paramView.d4;
        bool5 = bool3;
        if (paramView.a4.get())
        {
          bool5 = bool3;
          if (this.y.c4.get()) {
            bool5 = true;
          }
        }
        localObservableBoolean.set(bool5);
        break;
      }
    }
    else
    {
      this.y.E();
    }
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    this.q = ((FragmentPlayBackControlBinding)DataBindingUtil.inflate(paramLayoutInflater, 2131558942, paramViewGroup, false));
    paramLayoutInflater = getActivity();
    Objects.requireNonNull(paramLayoutInflater);
    paramLayoutInflater = ((FragmentActivity)paramLayoutInflater).getIntent().getStringExtra("device_id_md5");
    paramViewGroup = getActivity();
    Objects.requireNonNull(paramViewGroup);
    long l = ((FragmentActivity)paramViewGroup).getIntent().getLongExtra("record_time", 0L);
    this.x = ((PlaybackMainViewModel)ViewModelProviders.of(getActivity(), new CameraViewModelFactory(getActivity(), paramLayoutInflater)).get(PlaybackMainViewModel.class));
    paramLayoutInflater = (PlayBackControlViewModel)ViewModelProviders.of(getActivity(), new CameraViewModelFactory(getActivity(), paramLayoutInflater)).get(PlayBackControlViewModel.class);
    this.y = paramLayoutInflater;
    paramLayoutInflater.J();
    this.y.K(this.x);
    this.y.x0();
    if (l > 0L) {
      this.y.r0(System.currentTimeMillis(), l);
    } else {
      this.y.q0(System.currentTimeMillis());
    }
    this.q.n(this.y);
    this.q.h(this);
    this.q.l(this);
    this.q.m(this);
    this.q.i(this);
    this.y.j4.set(4.0F);
    paramLayoutInflater = Calendar.getInstance();
    paramLayoutInflater.setTimeZone(TimeZone.getDefault());
    paramLayoutInflater.setTimeInMillis(System.currentTimeMillis());
    this.y.e4.set(new d(paramLayoutInflater.get(1), paramLayoutInflater.get(2) + 1, paramLayoutInflater.get(5)));
    paramLayoutInflater = (RecyclerView)this.q.z.findViewById(2131363950);
    this.p0 = paramLayoutInflater;
    paramLayoutInflater.setLayoutManager(new LinearLayoutManager(getActivity()));
    paramLayoutInflater = new SnapshotAdapter(getActivity(), this.p3, this.y);
    this.z = paramLayoutInflater;
    this.p0.setAdapter(paramLayoutInflater);
    paramLayoutInflater = (RecyclerView)this.q.x.findViewById(2131363947);
    this.p1 = paramLayoutInflater;
    paramLayoutInflater.setLayoutManager(new GridLayoutManager(getActivity(), 2));
    paramLayoutInflater = new RecordTypeAdapter(getActivity());
    this.p2 = paramLayoutInflater;
    this.p1.setAdapter(paramLayoutInflater);
    i1();
    return this.q.getRoot();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void onStop()
  {
    super.onStop();
  }
  
  public void x(int paramInt, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("secondsInDay ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" minus ");
    localStringBuilder.append(paramBoolean);
    a.c("VideoPlay.PlayBackControlFragment", localStringBuilder.toString());
    this.y.s0(paramInt, paramBoolean);
  }
  
  public void y0(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("byUser secondsInDay ");
      localStringBuilder.append(paramInt);
      a.c("VideoPlay.PlayBackControlFragment", localStringBuilder.toString());
      this.y.z0(true);
      this.y.y0(paramInt, paramBoolean2);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\play\PlayBackControlFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */