package com.tplink.iot.view.quicksetup.switches.quicksetup;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.Utils.extension.i;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.adapter.quicksetup.RoomLocationAdapter;
import com.tplink.iot.cloud.bean.family.common.RoomInfo;
import com.tplink.iot.databinding.FragmentSubGSetupLocationSelectBinding;
import com.tplink.iot.view.ipcamera.onboardingv2.z1;
import com.tplink.iot.view.quicksetup.switches.quicksetup.base.SwitchButton;
import com.tplink.iot.view.quicksetup.switches.quicksetup.base.SwitchQuickSetupBaseFragment;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGViewModel;
import com.tplink.iot.viewmodel.quicksetup.subg.SwitchQuickSetupViewModel;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.l;
import kotlin.h;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

public final class SwitchQuickSetupLocationSelectFragment
  extends SwitchQuickSetupBaseFragment<FragmentSubGSetupLocationSelectBinding>
{
  public static final a p3 = new a(null);
  private final kotlin.f H3 = h.b(new c(this));
  private int I3;
  private String J3 = "";
  private boolean K3 = true;
  private HashMap L3;
  
  private final void X0()
  {
    Object localObject = ((FragmentSubGSetupLocationSelectBinding)K0()).x;
    j.d(localObject, "mBinding.maskView");
    i.l((View)localObject);
    localObject = ((FragmentSubGSetupLocationSelectBinding)K0()).y;
    j.d(localObject, "mBinding.tvContinue");
    ((TextView)localObject).setEnabled(false);
  }
  
  private final void Y0()
  {
    Object localObject = ((FragmentSubGSetupLocationSelectBinding)K0()).x;
    j.d(localObject, "mBinding.maskView");
    i.j((View)localObject);
    ((FragmentSubGSetupLocationSelectBinding)K0()).c.h();
    localObject = ((FragmentSubGSetupLocationSelectBinding)K0()).y;
    j.d(localObject, "mBinding.tvContinue");
    ((TextView)localObject).setEnabled(true);
  }
  
  private final List<RoomInfo> Z0()
  {
    return (List)this.H3.getValue();
  }
  
  private final void a1()
  {
    P0().Q(this.J3);
    z1 localz1 = N0();
    if (localz1 != null) {
      localz1.e0("SwitchQuickSetupLocationCustomFragment", null);
    }
  }
  
  private final void b1()
  {
    if ((Z0().isEmpty() ^ true))
    {
      Object localObject = Z0().iterator();
      int i = 0;
      for (int j = 0; ((Iterator)localObject).hasNext(); j++) {
        if (j.a(((RoomInfo)((Iterator)localObject).next()).getName(), P0().D())) {
          break label73;
        }
      }
      j = -1;
      label73:
      if (j == -1) {
        j = i;
      }
      this.I3 = j;
      localObject = ((RoomInfo)Z0().get(this.I3)).getName();
      j.d(localObject, "mRoomList[mSelectPos].name");
      this.J3 = ((String)localObject);
    }
  }
  
  private final void c1()
  {
    RoomLocationAdapter localRoomLocationAdapter = new RoomLocationAdapter(getActivity(), Z0(), this.I3);
    localRoomLocationAdapter.q(new b(this));
    RecyclerView localRecyclerView = ((FragmentSubGSetupLocationSelectBinding)K0()).d;
    j.d(localRecyclerView, "mBinding.devicePlaceList");
    localRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    localRecyclerView = ((FragmentSubGSetupLocationSelectBinding)K0()).d;
    j.d(localRecyclerView, "mBinding.devicePlaceList");
    localRecyclerView.setAdapter(localRoomLocationAdapter);
  }
  
  private final void d1()
  {
    P0().Q(this.J3);
    P0().K();
    if (this.K3)
    {
      this.K3 = false;
      List localList = l.g(new String[] { P0().A(SwitchButton.FIRST), P0().A(SwitchButton.SECOND) });
      O0().D0(this.J3, localList);
    }
    X0();
    P0().x();
  }
  
  private final void e1()
  {
    P0().G().observe(getViewLifecycleOwner(), new d(this));
    P0().F().observe(getViewLifecycleOwner(), new e(this));
  }
  
  public void H0()
  {
    HashMap localHashMap = this.L3;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public int J0()
  {
    return 2131558972;
  }
  
  public void onClick(View paramView)
  {
    j.e(paramView, "v");
    int i = paramView.getId();
    if (i != 2131362037)
    {
      if (i != 2131362826)
      {
        if (i == 2131364387)
        {
          paramView = N0();
          if (paramView != null) {
            paramView.e0("SubGCompleteFragment.TAG", null);
          }
        }
      }
      else {
        O0().E0(20002);
      }
    }
    else {
      d1();
    }
  }
  
  public void onDestroyView()
  {
    P0().r();
    super.onDestroyView();
    H0();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    j.e(paramView, "view");
    super.onViewCreated(paramView, paramBundle);
    b1();
    c1();
    e1();
  }
  
  public static final class a {}
  
  static final class b
    implements com.tplink.iot.adapter.quicksetup.f
  {
    b(SwitchQuickSetupLocationSelectFragment paramSwitchQuickSetupLocationSelectFragment) {}
    
    public final void a(View paramView, int paramInt)
    {
      if (paramInt < SwitchQuickSetupLocationSelectFragment.S0(this.a).size())
      {
        paramView = this.a;
        String str = ((RoomInfo)SwitchQuickSetupLocationSelectFragment.S0(paramView).get(paramInt)).getName();
        j.d(str, "mRoomList[position].name");
        SwitchQuickSetupLocationSelectFragment.W0(paramView, str);
      }
      else
      {
        SwitchQuickSetupLocationSelectFragment.V0(this.a);
      }
    }
  }
  
  static final class c
    extends Lambda
    implements kotlin.jvm.b.a<List<? extends RoomInfo>>
  {
    c(SwitchQuickSetupLocationSelectFragment paramSwitchQuickSetupLocationSelectFragment)
    {
      super();
    }
    
    public final List<RoomInfo> a()
    {
      List localList = SwitchQuickSetupLocationSelectFragment.U0(this.c).s();
      if (localList == null) {
        localList = l.d();
      }
      return localList;
    }
  }
  
  static final class d<T>
    implements Observer<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>>
  {
    d(SwitchQuickSetupLocationSelectFragment paramSwitchQuickSetupLocationSelectFragment) {}
    
    public final void a(com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean> parama)
    {
      if (parama != null)
      {
        parama = (Boolean)parama.a();
        if (parama != null)
        {
          SwitchQuickSetupLocationSelectFragment.Q0(this.a);
          j.d(parama, "success");
          if (parama.booleanValue())
          {
            parama = SwitchQuickSetupLocationSelectFragment.T0(this.a);
            if (parama != null) {
              parama.e0("SubGCompleteFragment.TAG", null);
            }
          }
          else
          {
            s0.o(this.a.getActivity(), 2131952444, null);
          }
        }
      }
    }
  }
  
  static final class e<T>
    implements Observer<Integer>
  {
    e(SwitchQuickSetupLocationSelectFragment paramSwitchQuickSetupLocationSelectFragment) {}
    
    public final void a(Integer paramInteger)
    {
      TextView localTextView = SwitchQuickSetupLocationSelectFragment.R0(this.a).y;
      j.d(localTextView, "mBinding.tvContinue");
      int i = paramInteger.intValue();
      int j = 0;
      if (i > 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        i = j;
      } else {
        i = 8;
      }
      localTextView.setVisibility(i);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\switches\quicksetup\SwitchQuickSetupLocationSelectFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */