package com.tplink.iot.view.authflip;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import androidx.activity.ComponentActivity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import b.d.w.h.b;
import com.tplink.iot.Utils.e;
import com.tplink.iot.Utils.f0;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.s0.h;
import com.tplink.iot.view.ipcamera.onboardingv2.z1;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar;
import com.tplink.iot.viewmodel.authflip.AppFlipAuthViewModel;
import com.tplink.iot.widget.DrawableEditText;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ForgetPasswordFragment
  extends BaseAppFlipFragment
  implements View.OnClickListener, TextWatcher
{
  private DrawableEditText q;
  private Button x;
  
  private void I0()
  {
    setHasOptionsMenu(true);
    ((Toolbar)this.c.findViewById(2131364275)).setNavigationOnClickListener(new a());
    this.q = ((DrawableEditText)this.c.findViewById(2131363840));
    Object localObject = (Button)this.c.findViewById(2131363842);
    this.x = ((Button)localObject);
    ((Button)localObject).setOnClickListener(this);
    this.q.f(this);
    localObject = Arrays.asList(getResources().getStringArray(2130903043));
    this.q.setEmailList((List)localObject);
    this.x.setEnabled(false);
    this.q.setText(this.f.v());
    Selection.setSelection(this.q.getText(), this.q.getText().length());
    this.q.m();
    localObject = getActivity();
    Objects.requireNonNull(localObject);
    b.d.w.f.a.j((Activity)localObject);
  }
  
  private void J0()
  {
    this.f.u().observe(this, new b());
    this.f.p().observe(this, new c());
  }
  
  private void K0()
  {
    TSnackbar.B(this, 2131952078, -1).N();
  }
  
  private void L0()
  {
    TSnackbar.B(this, 2131952612, -1).N();
  }
  
  private void N0(Integer paramInteger)
  {
    s0.g();
    int i = paramInteger.intValue();
    if (i != 45336) {
      switch (i)
      {
      default: 
        s0.p(getActivity(), getString(2131951708));
        break;
      case 19: 
        L0();
        break;
      case 18: 
        K0();
        break;
      case 16: 
      case 17: 
        s0.m(getActivity(), getString(2131952466));
        this.f.y(this.q.getText().toString().trim());
        break;
      }
    } else {
      s0.p(getActivity(), getString(2131951729));
    }
  }
  
  private void O0(Integer paramInteger)
  {
    if (paramInteger == null)
    {
      s0.m(getActivity(), getString(2131952466));
    }
    else
    {
      s0.g();
      int i = paramInteger.intValue();
      if (i != 44534)
      {
        if (i != 44936)
        {
          if (i != 45336)
          {
            if (i != 0)
            {
              s0.p(getActivity(), getString(2131952444));
              return;
            }
            s0.B(getActivity(), new d());
            return;
          }
        }
        else {
          K0();
        }
        s0.p(getActivity(), getString(2131951729));
      }
      else
      {
        e.f(getActivity());
      }
    }
  }
  
  private void P0()
  {
    if (TextUtils.isEmpty(this.q.getText().toString())) {
      this.x.setEnabled(false);
    } else if (!b.c(this.q.getText().toString())) {
      this.x.setEnabled(false);
    } else {
      this.x.setEnabled(true);
    }
  }
  
  public int A0()
  {
    return 2131558924;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (f0.c(this.q.getText().toString())) {
      this.q.setErrorText(2131951720);
    } else {
      this.q.setErrorText(null);
    }
    P0();
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131363842)
    {
      B0();
      s0.l(getActivity());
      this.f.k(this.q.getText().toString().trim());
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
    implements View.OnClickListener
  {
    a() {}
    
    public void onClick(View paramView)
    {
      paramView = ForgetPasswordFragment.this.getActivity();
      Objects.requireNonNull(paramView);
      ((FragmentActivity)paramView).onBackPressed();
    }
  }
  
  class b
    implements Observer<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer>>
  {
    b() {}
    
    public void a(com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer> parama)
    {
      parama = (Integer)parama.a();
      if (parama == null) {
        return;
      }
      ForgetPasswordFragment.C0(ForgetPasswordFragment.this, parama);
    }
  }
  
  class c
    implements Observer<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer>>
  {
    c() {}
    
    public void a(com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer> parama)
    {
      parama = (Integer)parama.a();
      if (parama == null) {
        return;
      }
      ForgetPasswordFragment.G0(ForgetPasswordFragment.this, parama);
    }
  }
  
  class d
    implements s0.h
  {
    d() {}
    
    public void onDismiss()
    {
      ForgetPasswordFragment localForgetPasswordFragment = ForgetPasswordFragment.this;
      if (localForgetPasswordFragment.d != null)
      {
        localForgetPasswordFragment.f.A(ForgetPasswordFragment.H0(localForgetPasswordFragment).getText().toString().trim());
        ForgetPasswordFragment.this.d.e0("LoginFragment", null);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\authflip\ForgetPasswordFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */