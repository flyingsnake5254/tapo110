package com.tplink.iot.view.ipcamera.play;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.databinding.BaseObservable;
import androidx.databinding.Observable;
import androidx.databinding.Observable.OnPropertyChangedCallback;
import androidx.databinding.ObservableBoolean;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.Utils.v0.b.a;
import com.tplink.iot.Utils.v0.d;
import com.tplink.iot.Utils.z0.h;
import com.tplink.iot.Utils.z0.j.a;
import com.tplink.iot.Utils.z0.k;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.cloud.bean.cloudvideo.common.DeviceCloudProduct;
import com.tplink.iot.cloud.bean.cloudvideo.common.OrderInfo;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.cloudvideo.CloudVideoViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.CloudTerraceControlViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.LensMaskViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.MultiLiveVideoViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.VideoControlPanelViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.VideoPlayViewModel;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.cameranetwork.business.repo.FirmwareRepository;
import com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a;
import io.reactivex.e0.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class VideoControlPanelFragment
  extends BaseFragment
  implements b.a
{
  private List<k> H3 = new ArrayList();
  private List<TextView> I3 = new ArrayList();
  private CloudVideoViewModel J3;
  private DeviceCloudProduct K3;
  private Boolean L3;
  private boolean M3 = false;
  private boolean N3 = false;
  private boolean O3 = false;
  private CameraLoadingView P3;
  private TextView Q3;
  private TextView R3;
  private final Observable.OnPropertyChangedCallback S3 = new d();
  private final View.OnClickListener T3 = new n2(this);
  private final View.OnClickListener U3 = new o2(this);
  private final View.OnClickListener V3 = new m2(this);
  private final View.OnClickListener W3 = new r2(this);
  private final View.OnClickListener X3 = new v2(this);
  private final View.OnClickListener Y3 = new s2(this);
  private final View.OnClickListener Z3 = new h2(this);
  private MultiLiveVideoViewModel p0;
  private String p1;
  private MutableLiveData<Boolean> p2 = new MutableLiveData();
  private b p3 = new b();
  private VideoPlayViewModel q;
  private LensMaskViewModel x;
  private VideoControlPanelViewModel y;
  private CloudTerraceControlViewModel z;
  
  private void F1()
  {
    Iterator localIterator = com.tplink.iot.Utils.z0.j.b.a().values().iterator();
    while (localIterator.hasNext())
    {
      k localk = (k)localIterator.next();
      if (localk != null) {
        localk.e(null);
      }
    }
  }
  
  private void G1()
  {
    this.q.k.observe(this, new t2(this));
    this.q.D.addOnPropertyChangedCallback(new a());
    Object localObject = new p2(this);
    this.x.p1.observe(this, (Observer)localObject);
    this.y.g.observe(this, (Observer)localObject);
    if (!this.x.c.hasActiveObservers())
    {
      MutableLiveData localMutableLiveData = this.x.c;
      localObject = getActivity();
      Objects.requireNonNull(localObject);
      localMutableLiveData.observe((LifecycleOwner)localObject, new i2(this));
    }
    this.x.c.observe(this, new j2(this));
    this.J3.y().observe(this, new b());
    this.J3.N().observe(this, new c());
    this.x.d.observe(this, new u2(this));
    this.y.a.observe(this, new f2(this));
    this.y.h.observe(this, new l2(this));
  }
  
  private void H1()
  {
    Object localObject1 = this.y.g();
    if (localObject1 != null)
    {
      boolean bool1 = false;
      Object localObject2 = S0(0);
      float f1 = 0.5F;
      boolean bool2;
      int i;
      float f2;
      if (localObject2 != null)
      {
        if ((!this.N3) && ((!((VideoPlayViewModel)localObject1).H.get()) || (!((VideoPlayViewModel)localObject1).D.get()) || (this.M3) || (this.O3))) {
          bool2 = false;
        } else {
          bool2 = true;
        }
        if ((!this.N3) && (((VideoPlayViewModel)localObject1).H.get()) && (((VideoPlayViewModel)localObject1).D.get()) && (!this.M3) && (!this.O3)) {
          i = 0;
        } else {
          i = 1;
        }
        ((TextView)localObject2).setEnabled(bool2);
        if (i != 0) {
          f2 = 0.5F;
        } else {
          f2 = 1.0F;
        }
        ((TextView)localObject2).setAlpha(f2);
      }
      localObject2 = S0(1);
      if (localObject2 != null)
      {
        if ((!this.N3) && ((!((VideoPlayViewModel)localObject1).H.get()) || (!((VideoPlayViewModel)localObject1).D.get()) || (this.M3) || (this.O3))) {
          bool2 = false;
        } else {
          bool2 = true;
        }
        if ((!this.N3) && (((VideoPlayViewModel)localObject1).H.get()) && (((VideoPlayViewModel)localObject1).D.get()) && (!this.M3) && (!this.O3)) {
          i = 0;
        } else {
          i = 1;
        }
        ((TextView)localObject2).setEnabled(bool2);
        if (i != 0) {
          f2 = 0.5F;
        } else {
          f2 = 1.0F;
        }
        ((TextView)localObject2).setAlpha(f2);
      }
      localObject2 = S0(2);
      if (localObject2 != null)
      {
        if ((!this.N3) && ((!((VideoPlayViewModel)localObject1).D.get()) || (this.M3) || (this.O3))) {
          bool2 = false;
        } else {
          bool2 = true;
        }
        if ((!this.N3) && (((VideoPlayViewModel)localObject1).D.get()) && (!this.M3) && (!this.O3)) {
          i = 0;
        } else {
          i = 1;
        }
        ((TextView)localObject2).setEnabled(bool2);
        if (i != 0) {
          f2 = 0.5F;
        } else {
          f2 = 1.0F;
        }
        ((TextView)localObject2).setAlpha(f2);
      }
      TextView localTextView = S0(3);
      if (localTextView != null)
      {
        if ((!this.N3) && ((!((VideoPlayViewModel)localObject1).J.get()) || (this.O3) || (!((VideoPlayViewModel)localObject1).E.get()))) {
          bool2 = false;
        } else {
          bool2 = true;
        }
        if ((!this.N3) && (((VideoPlayViewModel)localObject1).J.get()) && (((VideoPlayViewModel)localObject1).E.get()) && (!this.O3)) {
          i = 0;
        } else {
          i = 1;
        }
        localTextView.setEnabled(bool2);
        if (i != 0) {
          f2 = 0.5F;
        } else {
          f2 = 1.0F;
        }
        localTextView.setAlpha(f2);
        localObject2 = getContext();
        if (this.M3) {
          i = 2131231399;
        } else {
          i = 2131231356;
        }
        localTextView.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable((Context)localObject2, i), null, null);
      }
      localTextView = S0(4);
      if (localTextView != null)
      {
        if ((!this.N3) && ((!((VideoPlayViewModel)localObject1).L.get()) || (!((VideoPlayViewModel)localObject1).D.get()) || (this.M3) || (this.O3))) {
          bool2 = false;
        } else {
          bool2 = true;
        }
        if ((!this.N3) && (((VideoPlayViewModel)localObject1).L.get()) && (((VideoPlayViewModel)localObject1).D.get()) && (!this.M3) && (!this.O3)) {
          i = 0;
        } else {
          i = 1;
        }
        localTextView.setEnabled(bool2);
        if (i != 0) {
          f2 = 0.5F;
        } else {
          f2 = 1.0F;
        }
        localTextView.setAlpha(f2);
        localObject2 = getContext();
        if (((VideoPlayViewModel)localObject1).l.get()) {
          i = 2131230815;
        } else {
          i = 2131230814;
        }
        localTextView.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable((Context)localObject2, i), null, null);
        if (((VideoPlayViewModel)localObject1).l.get()) {
          i = 2131951860;
        } else {
          i = 2131951859;
        }
        localTextView.setText(i);
      }
      localObject1 = S0(5);
      if (localObject1 != null)
      {
        bool2 = com.tplink.libtpnetwork.Utils.j.h(this.p2) ^ true;
        ((TextView)localObject1).setEnabled(bool2);
        if (bool2) {
          f2 = 1.0F;
        } else {
          f2 = 0.5F;
        }
        ((TextView)localObject1).setAlpha(f2);
      }
      localObject1 = S0(9);
      if (localObject1 != null)
      {
        bool2 = bool1;
        if (!this.N3)
        {
          bool2 = bool1;
          if (!com.tplink.libtpnetwork.Utils.j.h(this.p2)) {
            bool2 = true;
          }
        }
        ((TextView)localObject1).setEnabled(bool2);
        f2 = f1;
        if (bool2) {
          f2 = 1.0F;
        }
        ((TextView)localObject1).setAlpha(f2);
      }
    }
  }
  
  private void O0(int paramInt, View.OnClickListener paramOnClickListener)
  {
    k localk = (k)com.tplink.iot.Utils.z0.j.b.a().get(Integer.valueOf(paramInt));
    if (localk != null)
    {
      localk.e(paramOnClickListener);
      this.H3.add(localk);
    }
  }
  
  private void P0(int paramInt1, View.OnClickListener paramOnClickListener, int paramInt2)
  {
    k localk = (k)com.tplink.iot.Utils.z0.j.b.a().get(Integer.valueOf(paramInt1));
    if (localk != null)
    {
      localk.e(paramOnClickListener);
      this.H3.add(paramInt2, localk);
    }
  }
  
  private void Q0(String paramString)
  {
    if (paramString != null) {
      ((FirmwareRepository)e.c(paramString, FirmwareRepository.class)).d.observe(this, new g2(this));
    }
  }
  
  private boolean R0()
  {
    if (com.tplink.libtpnetwork.Utils.j.h(this.p2)) {
      return true;
    }
    if (com.tplink.libtpnetwork.Utils.j.h(this.q.m))
    {
      Toast.makeText(getContext(), 2131952051, 0).show();
      return true;
    }
    return false;
  }
  
  private TextView S0(int paramInt)
  {
    Object localObject = this.I3;
    if (localObject == null) {
      return null;
    }
    Iterator localIterator = ((List)localObject).iterator();
    while (localIterator.hasNext())
    {
      localObject = (TextView)localIterator.next();
      if ((((TextView)localObject).getTag() != null) && (((Integer)((TextView)localObject).getTag()).intValue() == paramInt)) {
        return (TextView)localObject;
      }
    }
    return null;
  }
  
  private void T0()
  {
    this.H3.clear();
    O0(0, this.U3);
    if (this.q.I.get()) {
      O0(2, this.V3);
    }
    O0(1, this.T3);
    O0(3, this.W3);
    O0(4, this.X3);
    O0(5, this.Y3);
    if ((!TextUtils.isEmpty(this.p1)) && (d.c(this.p1))) {
      if (this.H3.size() < 5) {
        O0(9, this.Z3);
      } else if (this.H3.size() == 5) {
        P0(9, this.Z3, 4);
      } else {
        P0(9, this.Z3, 5);
      }
    }
  }
  
  private void U0()
  {
    TextView localTextView;
    if (this.H3.size() <= 6)
    {
      localTextView = this.Q3;
      if ((localTextView != null) && (this.R3 != null))
      {
        localTextView.setVisibility(8);
        this.R3.setVisibility(8);
        this.I3.remove(this.Q3);
        this.I3.remove(this.R3);
      }
    }
    else if ((!this.I3.contains(this.Q3)) && (!this.I3.contains(this.R3)))
    {
      this.Q3.setVisibility(0);
      this.R3.setVisibility(0);
      this.I3.add(3, this.Q3);
      this.I3.add(this.R3);
    }
    for (int i = 0; i < this.I3.size(); i++)
    {
      localTextView = (TextView)this.I3.get(i);
      if (localTextView != null) {
        if ((this.H3.size() > i) && (this.H3.get(i) != null))
        {
          localTextView.setVisibility(0);
          Object localObject = (k)this.H3.get(i);
          localTextView.setText(((k)localObject).d());
          localTextView.setTag(Integer.valueOf(((k)localObject).c()));
          localTextView.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(getContext(), ((k)localObject).b()), null, null);
          localObject = ((k)localObject).a();
          if (localObject != null) {
            localTextView.setOnClickListener((View.OnClickListener)localObject);
          }
        }
        else
        {
          localTextView.setVisibility(4);
        }
      }
    }
  }
  
  private void V0()
  {
    Object localObject = getActivity();
    Objects.requireNonNull(localObject);
    FragmentActivity localFragmentActivity = (FragmentActivity)localObject;
    this.p1 = localFragmentActivity.getIntent().getStringExtra("device_id_md5");
    this.q = ((VideoPlayViewModel)ViewModelProviders.of(localFragmentActivity).get(VideoPlayViewModel.class));
    this.p0 = ((MultiLiveVideoViewModel)ViewModelProviders.of(localFragmentActivity).get(MultiLiveVideoViewModel.class));
    localObject = (LensMaskViewModel)ViewModelProviders.of(localFragmentActivity).get(LensMaskViewModel.class);
    this.x = ((LensMaskViewModel)localObject);
    ((LensMaskViewModel)localObject).D(localFragmentActivity);
    this.y = ((VideoControlPanelViewModel)ViewModelProviders.of(getActivity()).get(VideoControlPanelViewModel.class));
    this.J3 = ((CloudVideoViewModel)ViewModelProviders.of(getActivity()).get(CloudVideoViewModel.class));
    this.z = ((CloudTerraceControlViewModel)ViewModelProviders.of(localFragmentActivity).get(CloudTerraceControlViewModel.class));
  }
  
  private void W0()
  {
    if (this.y.g() != null)
    {
      this.y.g().D.addOnPropertyChangedCallback(this.S3);
      this.y.g().l.addOnPropertyChangedCallback(this.S3);
      this.y.g().E.addOnPropertyChangedCallback(this.S3);
    }
  }
  
  public void D0()
  {
    this.J3.w(h.j(this.p1));
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1345) {
      this.J3.w(h.j(this.p1));
    } else {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    V0();
    G1();
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2131558988, paramViewGroup, false);
    paramViewGroup = (TextView)localView.findViewById(2131364151);
    paramBundle = (TextView)localView.findViewById(2131362335);
    TextView localTextView1 = (TextView)localView.findViewById(2131362169);
    paramLayoutInflater = (TextView)localView.findViewById(2131363708);
    TextView localTextView2 = (TextView)localView.findViewById(2131361955);
    TextView localTextView3 = (TextView)localView.findViewById(2131363449);
    this.Q3 = ((TextView)localView.findViewById(2131362689));
    this.R3 = ((TextView)localView.findViewById(2131362532));
    this.P3 = ((CameraLoadingView)localView.findViewById(2131363372));
    this.I3.add(paramViewGroup);
    this.I3.add(paramBundle);
    this.I3.add(localTextView1);
    this.I3.add(this.Q3);
    this.I3.add(paramLayoutInflater);
    this.I3.add(localTextView2);
    this.I3.add(localTextView3);
    this.I3.add(this.R3);
    return localView;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.p3.d();
    F1();
    this.I3.clear();
    this.I3 = null;
    if (this.y.g() != null)
    {
      this.y.g().D.removeOnPropertyChangedCallback(this.S3);
      this.y.g().l.removeOnPropertyChangedCallback(this.S3);
      this.y.g().E.removeOnPropertyChangedCallback(this.S3);
    }
  }
  
  class a
    extends Observable.OnPropertyChangedCallback
  {
    a() {}
    
    public void onPropertyChanged(Observable paramObservable, int paramInt)
    {
      if ((VideoControlPanelFragment.H0(VideoControlPanelFragment.this).D.get()) && (VideoControlPanelFragment.H0(VideoControlPanelFragment.this).p != null))
      {
        paramObservable = (a)VideoControlPanelFragment.H0(VideoControlPanelFragment.this).e.getValue();
        if (paramObservable == null) {
          return;
        }
        paramObservable = (String)paramObservable.c();
        if ((paramObservable != null) && (TextUtils.equals(VideoControlPanelFragment.H0(VideoControlPanelFragment.this).p, VideoControlPanelFragment.H0(VideoControlPanelFragment.this).j))) {
          VideoControlPanelFragment.H0(VideoControlPanelFragment.this).y(paramObservable);
        }
        VideoControlPanelFragment.H0(VideoControlPanelFragment.this).p = null;
        VideoControlPanelFragment.I0(VideoControlPanelFragment.this).p1.setValue(Boolean.FALSE);
      }
    }
  }
  
  class b
    implements Observer<DeviceCloudProduct>
  {
    b() {}
    
    public void a(DeviceCloudProduct paramDeviceCloudProduct)
    {
      VideoControlPanelFragment.J0(VideoControlPanelFragment.this, paramDeviceCloudProduct);
    }
  }
  
  class c
    implements Observer<List<OrderInfo>>
  {
    c() {}
    
    public void a(List<OrderInfo> paramList)
    {
      VideoControlPanelFragment localVideoControlPanelFragment = VideoControlPanelFragment.this;
      VideoControlPanelFragment.K0(localVideoControlPanelFragment, Boolean.valueOf(VideoControlPanelFragment.L0(localVideoControlPanelFragment).H(paramList, "")));
    }
  }
  
  class d
    extends Observable.OnPropertyChangedCallback
  {
    d() {}
    
    public void onPropertyChanged(Observable paramObservable, int paramInt)
    {
      VideoControlPanelFragment.N0(VideoControlPanelFragment.this);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\play\VideoControlPanelFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */