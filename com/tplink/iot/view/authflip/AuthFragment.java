package com.tplink.iot.view.authflip;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tplink.iot.Utils.d0;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.view.ipcamera.onboardingv2.z1;
import com.tplink.iot.viewmodel.authflip.AppFlipAuthViewModel;
import com.tplink.iot.widget.PointTextView;
import com.tplink.libtpgoogleassistant.bean.params.AuthCodeParams;
import java.util.Objects;

public class AuthFragment
  extends BaseAppFlipFragment
  implements View.OnClickListener
{
  private void G0(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      b.d.w.c.a.e("AuthFragment", "getAuthCode Success");
      Uri localUri = getActivity().getIntent().getData();
      Uri.Builder localBuilder = Uri.parse(localUri.getQueryParameter("REDIRECT_URI".toLowerCase())).buildUpon();
      localBuilder.appendQueryParameter("state", localUri.getQueryParameter("state"));
      localBuilder.appendQueryParameter("code", paramString);
      requireActivity().startActivity(new Intent("android.intent.action.VIEW", localBuilder.build()));
    }
  }
  
  private void H0(String paramString)
  {
    s0.l(getActivity());
    AuthCodeParams localAuthCodeParams = new AuthCodeParams();
    localAuthCodeParams.setToken(paramString);
    localAuthCodeParams.setClientIdInternal(b.d.k.d.a.b());
    this.f.n(localAuthCodeParams);
  }
  
  @StringRes
  private int I0()
  {
    if (b.a[this.f.t().ordinal()] != 1) {
      return 2131952774;
    }
    return 2131951814;
  }
  
  private void J0()
  {
    Object localObject = (TextView)this.c.findViewById(2131364712);
    TextView localTextView1 = (TextView)this.c.findViewById(2131364466);
    TextView localTextView2 = (TextView)this.c.findViewById(2131364707);
    this.c.findViewById(2131362831).setOnClickListener(this);
    this.c.findViewById(2131362035).setOnClickListener(this);
    String str1 = this.f.r();
    if (!TextUtils.isEmpty(str1)) {
      ((TextView)localObject).setText(getString(2131952772, new Object[] { str1 }));
    }
    String str2 = getString(2131951657);
    String str4;
    String str5;
    String str6;
    String str7;
    if (b.a[this.f.t().ordinal()] != 1)
    {
      str3 = getString(2131952770, new Object[] { str2 });
      str4 = getString(2131952773);
      localObject = getString(2131952766);
      str1 = getString(2131952767);
      str5 = getString(2131952768);
      str6 = "https://myaccount.google.com/";
      str7 = "https://policies.google.com/";
    }
    else
    {
      str3 = getString(2131951812, new Object[] { str2 });
      str4 = getString(2131951813);
      localObject = getString(2131951809);
      str1 = getString(2131951810);
      str5 = getString(2131951811);
      str6 = "https://alexa.amazon.com/";
      str7 = "https://www.alexa.com/help/privacy";
    }
    d0.c(localTextView1, str3, str2, ContextCompat.getColor(requireActivity(), 2131099811), new b(this, str7));
    String str3 = getString(2131952430);
    d0.c(localTextView2, getString(2131952771, new Object[] { str3 }), str3, ContextCompat.getColor(requireActivity(), 2131099811), new a(this, str6));
    ((TextView)this.c.findViewById(2131364688)).setText(I0());
    ((TextView)this.c.findViewById(2131364511)).setText(str4);
    ((PointTextView)this.c.findViewById(2131364685)).setContent((String)localObject);
    ((PointTextView)this.c.findViewById(2131364686)).setContent(str1);
    ((PointTextView)this.c.findViewById(2131364687)).setContent(str5);
  }
  
  private void P0()
  {
    this.f.o().observe(this, new a());
  }
  
  private void Q0()
  {
    if ((getActivity() != null) && (getActivity().getIntent() != null) && (getActivity().getIntent().getData() != null))
    {
      Object localObject1 = getActivity().getIntent().getData();
      String str1 = ((Uri)localObject1).getQueryParameter("CLIENT_ID".toLowerCase());
      String str2 = ((Uri)localObject1).getQueryParameter("response_type");
      String str3 = ((Uri)localObject1).getQueryParameter("state");
      Object localObject2 = ((Uri)localObject1).getQueryParameter("SCOPE".toLowerCase());
      String str4 = ((Uri)localObject1).getQueryParameter("REDIRECT_URI".toLowerCase());
      localObject1 = Uri.parse(b.d.k.d.a.a()).buildUpon();
      ((Uri.Builder)localObject1).appendQueryParameter("CLIENT_ID".toLowerCase(), str1);
      ((Uri.Builder)localObject1).appendQueryParameter("response_type", str2);
      ((Uri.Builder)localObject1).appendQueryParameter("state", str3);
      ((Uri.Builder)localObject1).appendQueryParameter("SCOPE".toLowerCase(), (String)localObject2);
      ((Uri.Builder)localObject1).appendQueryParameter("REDIRECT_URI".toLowerCase(), str4);
      localObject2 = new Intent("android.intent.action.VIEW", ((Uri.Builder)localObject1).build());
      ((Intent)localObject2).addFlags(268435456);
      requireActivity().startActivity((Intent)localObject2);
    }
  }
  
  public int A0()
  {
    return 2131558855;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject;
    if (i != 2131362035)
    {
      if (i == 2131362831)
      {
        i = b.a[this.f.t().ordinal()];
        if (i != 1)
        {
          if (i == 2)
          {
            paramView = new Intent();
            localObject = getActivity();
            Objects.requireNonNull(localObject);
            ((FragmentActivity)localObject).setResult(0, paramView);
          }
        }
        else {
          Q0();
        }
        getActivity().finish();
      }
    }
    else
    {
      paramView = this.f.m();
      i = b.a[this.f.t().ordinal()];
      if (i != 1)
      {
        if (i == 2)
        {
          s0.l(getActivity());
          localObject = new AuthCodeParams();
          ((AuthCodeParams)localObject).setToken(paramView);
          ((AuthCodeParams)localObject).setClientIdInternal(b.d.k.d.a.b());
          this.f.n((AuthCodeParams)localObject);
        }
      }
      else {
        H0(paramView);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.d.q0();
    J0();
    P0();
  }
  
  class a
    implements Observer<String>
  {
    a() {}
    
    public void a(String paramString)
    {
      
      if (AuthFragment.b.a[AuthFragment.this.f.t().ordinal()] != 1)
      {
        Object localObject;
        if (!TextUtils.isEmpty(paramString))
        {
          b.d.w.c.a.e("AuthFragment", "getAuthCode Success");
          localObject = new Intent();
          ((Intent)localObject).putExtra("AUTHORIZATION_CODE", paramString);
          paramString = AuthFragment.this.getActivity();
          Objects.requireNonNull(paramString);
          ((FragmentActivity)paramString).setResult(-1, (Intent)localObject);
        }
        else
        {
          b.d.w.c.a.e("AuthFragment", "getAuthCode Fail");
          paramString = new Intent();
          paramString.putExtra("ERROR_TYPE", 1);
          paramString.putExtra("ERROR_CODE", 1);
          paramString.putExtra("ERROR_DESCRIPTION", "Invalid Request");
          localObject = AuthFragment.this.getActivity();
          Objects.requireNonNull(localObject);
          ((FragmentActivity)localObject).setResult(-2, paramString);
        }
      }
      else
      {
        AuthFragment.C0(AuthFragment.this, paramString);
      }
      AuthFragment.this.getActivity().finish();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\authflip\AuthFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */