package com.tplink.iot.view.authflip;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import b.d.k.f.a;
import com.tplink.iot.thirdpartlink.ThirdPartLinkNetworkType;
import com.tplink.iot.view.ipcamera.base.d;
import com.tplink.iot.view.ipcamera.base.f;
import com.tplink.iot.view.ipcamera.onboardingv2.z1;
import com.tplink.iot.viewmodel.authflip.AppFlipAuthViewModel;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

public class AppFlipAuthActivity
  extends AppCompatActivity
  implements z1
{
  private Stack<f> c;
  private boolean d = true;
  private AppFlipAuthViewModel f;
  private String q;
  
  private void P0()
  {
    if (this.c.size() <= 1)
    {
      finish();
    }
    else
    {
      this.c.pop();
      f localf = (f)this.c.peek();
      W0(localf.b(), localf.a(), 4);
    }
  }
  
  private AuthFragment Q0()
  {
    AuthFragment localAuthFragment1 = (AuthFragment)getSupportFragmentManager().findFragmentByTag(AuthFragment.class.getSimpleName());
    AuthFragment localAuthFragment2 = localAuthFragment1;
    if (localAuthFragment1 == null) {
      localAuthFragment2 = new AuthFragment();
    }
    return localAuthFragment2;
  }
  
  private ForgetPasswordFragment R0()
  {
    ForgetPasswordFragment localForgetPasswordFragment1 = (ForgetPasswordFragment)getSupportFragmentManager().findFragmentByTag(ForgetPasswordFragment.class.getSimpleName());
    ForgetPasswordFragment localForgetPasswordFragment2 = localForgetPasswordFragment1;
    if (localForgetPasswordFragment1 == null) {
      localForgetPasswordFragment2 = new ForgetPasswordFragment();
    }
    return localForgetPasswordFragment2;
  }
  
  private LoginFragment S0()
  {
    LoginFragment localLoginFragment1 = (LoginFragment)getSupportFragmentManager().findFragmentByTag(LoginFragment.class.getSimpleName());
    LoginFragment localLoginFragment2 = localLoginFragment1;
    if (localLoginFragment1 == null) {
      localLoginFragment2 = new LoginFragment();
    }
    return localLoginFragment2;
  }
  
  private WebViewFragment T0()
  {
    WebViewFragment localWebViewFragment1 = (WebViewFragment)getSupportFragmentManager().findFragmentByTag(WebViewFragment.class.getSimpleName());
    WebViewFragment localWebViewFragment2 = localWebViewFragment1;
    if (localWebViewFragment1 == null) {
      localWebViewFragment2 = new WebViewFragment();
    }
    return localWebViewFragment2;
  }
  
  private void U0()
  {
    String str = this.f.m();
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("bundle_anim_tag", false);
    if (TextUtils.isEmpty(str)) {
      e0("LoginFragment", localBundle);
    } else {
      e0("AuthFragment", localBundle);
    }
  }
  
  private void W0(String paramString, Bundle paramBundle, int paramInt)
  {
    Object localObject = S0();
    this.q = paramString;
    paramString.hashCode();
    int i = paramString.hashCode();
    int j = -1;
    switch (i)
    {
    default: 
      break;
    case -605450696: 
      if (paramString.equals("ForgetPasswordFragment")) {
        j = 3;
      }
      break;
    case -1779110727: 
      if (paramString.equals("LoginFragment")) {
        j = 2;
      }
      break;
    case -1892528072: 
      if (paramString.equals("AuthFragment")) {
        j = 1;
      }
      break;
    case -1980005015: 
      if (paramString.equals("WebViewFragment")) {
        j = 0;
      }
      break;
    }
    switch (j)
    {
    }
    for (;;)
    {
      break;
      localObject = R0();
      continue;
      localObject = S0();
      continue;
      localObject = Q0();
      continue;
      localObject = T0();
    }
    this.d = true;
    V0((Fragment)localObject, paramString, paramBundle, paramInt, 2131362690);
  }
  
  protected void V0(Fragment paramFragment, String paramString, Bundle paramBundle, int paramInt1, int paramInt2)
  {
    FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
    if ((paramBundle != null) && (paramBundle.size() > 0)) {
      if ((!paramFragment.isAdded()) && (!paramFragment.isVisible()) && (paramFragment.getArguments() == null))
      {
        paramFragment.setArguments(paramBundle);
      }
      else
      {
        Bundle localBundle = paramFragment.getArguments();
        if (localBundle != null)
        {
          Iterator localIterator = paramBundle.keySet().iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            if (str != null) {
              if ((paramBundle.get(str) instanceof String)) {
                localBundle.putString(str, paramBundle.getString(str));
              } else if ((paramBundle.get(str) instanceof Boolean)) {
                localBundle.putBoolean(str, paramBundle.getBoolean(str));
              } else if ((paramBundle.get(str) instanceof Long)) {
                localBundle.putLong(str, paramBundle.getLong(str));
              } else if ((paramBundle.get(str) instanceof Serializable)) {
                localBundle.putSerializable(str, paramBundle.getSerializable(str));
              } else if ((paramBundle.get(str) instanceof Parcelable)) {
                localBundle.putParcelable(str, paramBundle.getParcelable(str));
              }
            }
          }
        }
      }
    }
    paramBundle = d.a(paramInt1);
    if ((paramBundle[0] != 0) && (paramBundle[1] != 0)) {
      localFragmentTransaction.setCustomAnimations(paramBundle[0], paramBundle[1]);
    }
    localFragmentTransaction.replace(paramInt2, paramFragment, paramString).commitAllowingStateLoss();
  }
  
  public void e0(String paramString, Bundle paramBundle)
  {
    f localf = new f();
    localf.d(paramString);
    localf.c(paramBundle);
    if ((this.c.size() > 0) && (TextUtils.equals(paramString, ((f)this.c.peek()).b()))) {
      return;
    }
    Iterator localIterator = this.c.iterator();
    boolean bool2;
    do
    {
      boolean bool1 = localIterator.hasNext();
      bool2 = true;
      if (!bool1) {
        break;
      }
    } while (!((f)localIterator.next()).b().equalsIgnoreCase(paramString));
    int i = 1;
    while ((i != 0) && (!((f)this.c.pop()).b().equalsIgnoreCase(paramString)) && (this.c.size() > 0)) {}
    this.c.push(localf);
    if (paramBundle != null) {
      bool2 = paramBundle.getBoolean("bundle_anim_tag", true);
    }
    if (bool2)
    {
      if (i != 0) {
        W0(paramString, paramBundle, 4);
      } else {
        W0(paramString, paramBundle, 0);
      }
    }
    else {
      W0(paramString, paramBundle, 2);
    }
  }
  
  public void onBackPressed()
  {
    if (this.d) {
      P0();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558443);
    this.f = ((AppFlipAuthViewModel)ViewModelProviders.of(this).get(AppFlipAuthViewModel.class));
    this.c = new Stack();
    if (a.d(getIntent()).booleanValue())
    {
      this.f.z(ThirdPartLinkNetworkType.AMAZON);
    }
    else
    {
      if (!a.c(getApplicationContext(), getCallingActivity(), getIntent())) {
        break label98;
      }
      this.f.z(ThirdPartLinkNetworkType.GOOGLE);
    }
    U0();
    return;
    label98:
    finish();
  }
  
  public void q0()
  {
    this.d = false;
  }
  
  public void y0(String paramString) {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\authflip\AppFlipAuthActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */