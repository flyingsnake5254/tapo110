package com.tplink.iot.view.authflip;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import b.d.w.f.b;
import com.tplink.cloud.bean.account.result.LoginV1Result;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.Utils.TPMaterialDialogV2.d;
import com.tplink.iot.Utils.e;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.view.ipcamera.onboardingv2.z1;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar;
import com.tplink.iot.view.quicksetup.base.d;
import com.tplink.iot.viewmodel.authflip.AppFlipAuthViewModel;
import com.tplink.iot.viewmodel.quicksetup.i;
import com.tplink.iot.widget.DrawableEditText;
import com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a;
import java.util.Objects;

public class LoginFragment
  extends BaseAppFlipFragment
  implements View.OnClickListener, TextWatcher
{
  private TextView q;
  private DrawableEditText x;
  private DrawableEditText y;
  private TextView z;
  
  private String G0()
  {
    String str;
    if (O0()) {
      str = this.x.getText().toString().trim();
    } else {
      str = "";
    }
    return str;
  }
  
  private void H0(i<LoginV1Result> parami)
  {
    
    if ((parami.b() == 0) && (parami.a() != null))
    {
      parami = (LoginV1Result)parami.a();
      int i = parami.getErrorCode();
      int j = parami.getLockedMinutes();
      if (i != 42533)
      {
        if (i != 44875)
        {
          if ((i != 44921) && (i != 45336))
          {
            if (i != 0)
            {
              switch (i)
              {
              default: 
                s0.p(getActivity(), getString(2131951723));
                break;
              case -20600: 
                K0();
                break;
              case -20601: 
                int k = parami.getFailedAttempts();
                i = parami.getRemainAttempts();
                int m = parami.getRemainAttempts() + parami.getFailedAttempts();
                if (k == m) {
                  e.d(getActivity(), j, G0());
                } else if (i == 1) {
                  e.e(getActivity(), i, m, j);
                } else {
                  N0();
                }
                break;
              case -20602: 
                L0();
                break;
              }
            }
            else
            {
              parami = this.d;
              if (parami != null) {
                parami.e0("AuthFragment", null);
              }
            }
          }
          else {
            N0();
          }
        }
        else {
          e.d(getActivity(), j, G0());
        }
      }
      else {
        e.g(getActivity());
      }
    }
    else
    {
      s0.p(getActivity(), getString(2131951723));
    }
  }
  
  private void I0()
  {
    this.q = ((TextView)this.c.findViewById(2131364487));
    this.x = ((DrawableEditText)this.c.findViewById(2131362549));
    this.y = ((DrawableEditText)this.c.findViewById(2131362550));
    TextView localTextView = (TextView)this.c.findViewById(2131362076);
    this.z = localTextView;
    localTextView.setOnClickListener(this);
    this.x.f(this);
    this.y.f(this);
    this.c.findViewById(2131364520).setOnClickListener(this);
    this.x.setText(this.f.v());
    Selection.setSelection(this.x.getText(), this.x.getText().length());
  }
  
  private void J0()
  {
    this.f.s().observe(this, new a());
  }
  
  private void K0()
  {
    TSnackbar.B(this, 2131952078, 0).F(2131953652, new b()).I(getResources().getColor(2131099808)).N();
  }
  
  private void L0()
  {
    new TPMaterialDialogV2.Builder(getActivity()).i(2131953661, 2131099799).o(2131952452, 2131099808, new c()).l(2131952391, 2131099804, null).b(false).c(false).g(8, 8).y();
  }
  
  private void N0()
  {
    this.q.setVisibility(0);
    this.q.setText(2131951729);
  }
  
  private boolean O0()
  {
    boolean bool;
    if (this.x.getText().toString().length() > 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private boolean P0()
  {
    boolean bool;
    if ((O0()) && (Q0())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private boolean Q0()
  {
    boolean bool;
    if (this.y.getText().toString().length() > 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public int A0()
  {
    return 2131558935;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    this.z.setEnabled(P0());
    this.q.setVisibility(8);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131362076)
    {
      if (i == 2131364520)
      {
        paramView = this.x.getText().toString().trim();
        this.f.A(paramView);
        paramView = this.d;
        if (paramView != null) {
          paramView.e0("ForgetPasswordFragment", null);
        }
      }
    }
    else
    {
      d.I(getActivity());
      this.q.setVisibility(8);
      paramView = getActivity();
      Objects.requireNonNull(paramView);
      if (!b.h((Context)paramView))
      {
        s0.p(getActivity(), getString(2131953208));
        return;
      }
      s0.l(getActivity());
      this.f.x(this.x.getText().toString().trim(), this.y.getText().toString());
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    I0();
    J0();
  }
  
  class a
    implements Observer<a<i<LoginV1Result>>>
  {
    a() {}
    
    public void a(a<i<LoginV1Result>> parama)
    {
      parama = (i)parama.a();
      if (parama == null) {
        return;
      }
      LoginFragment.C0(LoginFragment.this, parama);
    }
  }
  
  class b
    implements View.OnClickListener
  {
    b() {}
    
    public void onClick(View paramView) {}
  }
  
  class c
    implements TPMaterialDialogV2.d
  {
    c() {}
    
    public void onClick(View paramView) {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\authflip\LoginFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */