package com.tplink.iot.view.notification;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.Utils.x0.q;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.viewmodel.notification.MessagePushViewModel;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.Utils.o;
import java.util.ArrayList;
import java.util.List;

public class NotificationFragment
  extends BaseFragment
{
  private View p0;
  private View p1;
  private MessagePushViewModel p2;
  private List<BaseALIoTDevice> p3 = new ArrayList();
  private SwitchCompat q;
  private SwitchCompat x;
  private SwitchCompat y;
  private View z;
  
  private void O0(View paramView)
  {
    this.q = ((SwitchCompat)paramView.findViewById(2131362794));
    this.x = ((SwitchCompat)paramView.findViewById(2131362647));
    this.y = ((SwitchCompat)paramView.findViewById(2131364132));
    this.z = paramView.findViewById(2131363168);
    this.p1 = paramView.findViewById(2131363173);
    paramView = paramView.findViewById(2131363180);
    this.p0 = paramView;
    paramView.setOnClickListener(new a(this));
  }
  
  private void R0()
  {
    this.q.setChecked(this.p2.o());
    this.q.setOnCheckedChangeListener(new a());
    this.p2.g().observe(this, new b());
  }
  
  public void onActivityCreated(@Nullable Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.p2 = ((MessagePushViewModel)ViewModelProviders.of(this).get(MessagePushViewModel.class));
    R0();
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131558939, paramViewGroup, false);
    O0(paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  class a
    implements CompoundButton.OnCheckedChangeListener
  {
    a() {}
    
    public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      NotificationFragment.H0(NotificationFragment.this).u(paramBoolean);
    }
  }
  
  class b
    implements Observer<List<BaseALIoTDevice>>
  {
    b() {}
    
    public void a(@Nullable List<BaseALIoTDevice> paramList)
    {
      if ((paramList != null) && (paramList.size() > 0))
      {
        NotificationFragment.I0(NotificationFragment.this).clear();
        NotificationFragment.I0(NotificationFragment.this).addAll(paramList);
        NotificationFragment.J0(NotificationFragment.this).setChecked(NotificationFragment.H0(NotificationFragment.this).n());
        NotificationFragment.J0(NotificationFragment.this).setOnCheckedChangeListener(new a());
        NotificationFragment.K0(NotificationFragment.this).setChecked(NotificationFragment.H0(NotificationFragment.this).m());
        NotificationFragment.K0(NotificationFragment.this).setOnCheckedChangeListener(new b());
        if (NotificationFragment.H0(NotificationFragment.this).k(paramList)) {
          NotificationFragment.L0(NotificationFragment.this).setVisibility(0);
        } else {
          NotificationFragment.L0(NotificationFragment.this).setVisibility(8);
        }
        if (NotificationFragment.H0(NotificationFragment.this).l(paramList)) {
          NotificationFragment.N0(NotificationFragment.this).setVisibility(0);
        } else {
          NotificationFragment.N0(NotificationFragment.this).setVisibility(8);
        }
      }
      else
      {
        NotificationFragment.J0(NotificationFragment.this).setChecked(NotificationFragment.H0(NotificationFragment.this).n());
        NotificationFragment.J0(NotificationFragment.this).setOnCheckedChangeListener(new c());
      }
    }
    
    class a
      implements CompoundButton.OnCheckedChangeListener
    {
      a() {}
      
      public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
      {
        if ((NotificationFragment.I0(NotificationFragment.this) != null) && (NotificationFragment.I0(NotificationFragment.this).size() > 0))
        {
          NotificationFragment.H0(NotificationFragment.this).x(NotificationFragment.I0(NotificationFragment.this), paramBoolean);
          q.n(paramBoolean, "tapoNewFirmware");
        }
      }
    }
    
    class b
      implements CompoundButton.OnCheckedChangeListener
    {
      b() {}
      
      public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
      {
        if ((NotificationFragment.I0(NotificationFragment.this) != null) && (NotificationFragment.I0(NotificationFragment.this).size() > 0))
        {
          NotificationFragment.H0(NotificationFragment.this).v(NotificationFragment.I0(NotificationFragment.this), paramBoolean);
          q.n(paramBoolean, "tapoCameraSD");
        }
      }
    }
    
    class c
      implements CompoundButton.OnCheckedChangeListener
    {
      c() {}
      
      public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
      {
        o.h0().g1(paramBoolean);
        q.n(paramBoolean, "tapoCameraSD");
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\notification\NotificationFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */