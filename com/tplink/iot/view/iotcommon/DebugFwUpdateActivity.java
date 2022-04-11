package com.tplink.iot.view.iotcommon;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.android.material.textfield.TextInputEditText;
import com.tplink.iot.Utils.extension.e;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityDebugFwUpdateBinding;
import com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.DeviceTimeInfo;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result.FwDownloadStatus;
import com.tplink.libtpnetwork.Utils.i;
import io.reactivex.e0.c;
import io.reactivex.g0.g;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.h;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlin.p;
import kotlin.text.m;

public final class DebugFwUpdateActivity
  extends IoTMVVMBaseActivity<ActivityDebugFwUpdateBinding>
{
  private final kotlin.f p0 = h.b(new i(this));
  private final kotlin.f p1 = h.b(new j(this));
  private final kotlin.f p2 = h.b(new h(this));
  private final kotlin.f p3 = h.b(new k(this));
  
  private final String A1()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("http://");
    TextInputEditText localTextInputEditText = ((ActivityDebugFwUpdateBinding)f1()).p1;
    j.d(localTextInputEditText, "mBinding.etIp");
    localStringBuilder.append(localTextInputEditText.getText());
    localStringBuilder.append(':');
    localTextInputEditText = ((ActivityDebugFwUpdateBinding)f1()).p2;
    j.d(localTextInputEditText, "mBinding.etPort");
    localStringBuilder.append(localTextInputEditText.getText());
    localStringBuilder.append('/');
    localTextInputEditText = ((ActivityDebugFwUpdateBinding)f1()).p0;
    j.d(localTextInputEditText, "mBinding.etFile");
    localStringBuilder.append(localTextInputEditText.getText());
    localStringBuilder.append(".bin");
    return localStringBuilder.toString();
  }
  
  private final void B1()
  {
    F1().j();
  }
  
  private final TextView C1()
  {
    return (TextView)this.p2.getValue();
  }
  
  private final ProgressBar D1()
  {
    return (ProgressBar)this.p0.getValue();
  }
  
  private final TextView E1()
  {
    return (TextView)this.p1.getValue();
  }
  
  private final DebugFwUpdateViewModel F1()
  {
    return (DebugFwUpdateViewModel)this.p3.getValue();
  }
  
  private final void G1(FwDownloadStatus paramFwDownloadStatus)
  {
    switch (paramFwDownloadStatus.getErrorCode())
    {
    default: 
      break;
    case 6: 
      paramFwDownloadStatus = ((ActivityDebugFwUpdateBinding)f1()).f;
      j.d(paramFwDownloadStatus, "mBinding.btnDownload");
      paramFwDownloadStatus.setEnabled(true);
      s0.C(this, "安装成功！", null);
      break;
    case 5: 
      paramFwDownloadStatus = ((ActivityDebugFwUpdateBinding)f1()).f;
      j.d(paramFwDownloadStatus, "mBinding.btnDownload");
      paramFwDownloadStatus.setEnabled(true);
      L1(100);
      s0.m(this, "安装固件中...");
      break;
    case 4: 
      L1(paramFwDownloadStatus.getDownloadProgress());
      break;
    case 2: 
      paramFwDownloadStatus = ((ActivityDebugFwUpdateBinding)f1()).f;
      j.d(paramFwDownloadStatus, "mBinding.btnDownload");
      paramFwDownloadStatus.setEnabled(true);
      L1(100);
      s0.C(this, "下载成功", null);
      break;
    case 1: 
    case 3: 
      paramFwDownloadStatus = ((ActivityDebugFwUpdateBinding)f1()).f;
      j.d(paramFwDownloadStatus, "mBinding.btnDownload");
      paramFwDownloadStatus.setEnabled(true);
      z1();
    }
  }
  
  private final void H1(String paramString)
  {
    F1().r(paramString).r(io.reactivex.d0.b.a.a()).l(new l(this)).i(new m(this)).j(new n(this)).y();
  }
  
  private final void I1(String paramString1, String paramString2, String paramString3)
  {
    F1().s(paramString1, paramString2, paramString3).r(io.reactivex.d0.b.a.a()).l(new o(this)).i(new p(this)).j(new q(this)).y();
  }
  
  private final void J1()
  {
    e.r(this, new r(i.j(F1().m())));
  }
  
  private final void K1()
  {
    String str = A1();
    if ((m.r(str) ^ true)) {
      F1().p(str).C(io.reactivex.l0.a.c()).r(io.reactivex.d0.b.a.a()).l(new u(this)).i(new v(this)).j(new w(this)).y();
    }
  }
  
  @SuppressLint({"SetTextI18n"})
  private final void L1(int paramInt)
  {
    D1().setProgress(paramInt);
    TextView localTextView = E1();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append('%');
    localTextView.setText(localStringBuilder.toString());
  }
  
  private final void z1()
  {
    s0.p(this, "下载失败");
    L1(0);
    Button localButton = ((ActivityDebugFwUpdateBinding)f1()).f;
    j.d(localButton, "mBinding.btnDownload");
    localButton.setEnabled(true);
  }
  
  public int e1()
  {
    return 2131558494;
  }
  
  @SuppressLint({"SetTextI18n"})
  public void j1()
  {
    c1("设备调试控制台");
    TextView localTextView = ((ActivityDebugFwUpdateBinding)f1()).V3;
    j.d(localTextView, "mBinding.tvConnectionType");
    String str;
    if (F1().n()) {
      str = "本地";
    } else {
      str = "远程";
    }
    localTextView.setText(str);
    ((ActivityDebugFwUpdateBinding)f1()).d.setOnClickListener(new a(this));
    ((ActivityDebugFwUpdateBinding)f1()).x.setOnClickListener(new b(this));
    ((ActivityDebugFwUpdateBinding)f1()).f.setOnClickListener(new c(this));
    ((ActivityDebugFwUpdateBinding)f1()).y.setOnClickListener(new d(this));
    ((ActivityDebugFwUpdateBinding)f1()).c.setOnClickListener(new e(this));
    ((ActivityDebugFwUpdateBinding)f1()).q.setOnClickListener(new f(this));
    ((ActivityDebugFwUpdateBinding)f1()).z.setOnClickListener(new g(this));
    L1(0);
  }
  
  public void k1()
  {
    F1().t(true);
  }
  
  public void l1()
  {
    super.l1();
    ((ActivityDebugFwUpdateBinding)f1()).h(F1());
  }
  
  public void m1()
  {
    F1().l().observe(this, new s(this));
    F1().k().observe(this, new t(this));
  }
  
  protected void onDestroy()
  {
    F1().u();
    super.onDestroy();
  }
  
  static final class a
    implements View.OnClickListener
  {
    a(DebugFwUpdateActivity paramDebugFwUpdateActivity) {}
    
    public final void onClick(View paramView)
    {
      paramView = this.c.getSystemService("clipboard");
      Objects.requireNonNull(paramView, "null cannot be cast to non-null type android.content.ClipboardManager");
      Object localObject = (ClipboardManager)paramView;
      paramView = DebugFwUpdateActivity.n1(this.c);
      ((ClipboardManager)localObject).setPrimaryClip(ClipData.newPlainText("FirmwareUrl", paramView));
      localObject = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("已复制：");
      localStringBuilder.append(paramView);
      Toast.makeText((Context)localObject, localStringBuilder.toString(), 0).show();
    }
  }
  
  static final class b
    implements View.OnClickListener
  {
    b(DebugFwUpdateActivity paramDebugFwUpdateActivity) {}
    
    public final void onClick(View paramView)
    {
      paramView = this.c.getSystemService("clipboard");
      Objects.requireNonNull(paramView, "null cannot be cast to non-null type android.content.ClipboardManager");
      paramView = ((ClipboardManager)paramView).getPrimaryClip();
      if (paramView != null)
      {
        paramView = paramView.getItemAt(0);
        if (paramView != null)
        {
          paramView = paramView.getText();
          if (paramView != null) {
            break label67;
          }
        }
      }
      Toast.makeText(this.c, "剪贴板为空", 0).show();
      paramView = "";
      label67:
      paramView = Pattern.compile("^http://(.*):(.*)/(.*).bin$").matcher(paramView);
      if ((paramView.matches()) && (paramView.groupCount() == 3))
      {
        DebugFwUpdateActivity.p1(this.c).p1.setText(paramView.group(1));
        DebugFwUpdateActivity.p1(this.c).p2.setText(paramView.group(2));
        DebugFwUpdateActivity.p1(this.c).p0.setText(paramView.group(3));
      }
    }
  }
  
  static final class c
    implements View.OnClickListener
  {
    c(DebugFwUpdateActivity paramDebugFwUpdateActivity) {}
    
    public final void onClick(View paramView)
    {
      j.d(paramView, "it");
      paramView.setEnabled(false);
      DebugFwUpdateActivity.x1(this.c);
    }
  }
  
  static final class d
    implements View.OnClickListener
  {
    d(DebugFwUpdateActivity paramDebugFwUpdateActivity) {}
    
    public final void onClick(View paramView)
    {
      paramView = this.c;
      DebugFwUpdateActivity.u1(paramView, DebugFwUpdateActivity.s1(paramView).h());
    }
  }
  
  static final class e
    implements View.OnClickListener
  {
    e(DebugFwUpdateActivity paramDebugFwUpdateActivity) {}
    
    public final void onClick(View paramView)
    {
      paramView = this.c;
      Object localObject1 = DebugFwUpdateActivity.p1(paramView).H3;
      j.d(localObject1, "mBinding.etWlanSsid");
      localObject1 = String.valueOf(((AppCompatEditText)localObject1).getText());
      Object localObject2 = DebugFwUpdateActivity.p1(this.c).p3;
      j.d(localObject2, "mBinding.etWlanPsd");
      localObject2 = String.valueOf(((AppCompatEditText)localObject2).getText());
      TextInputEditText localTextInputEditText = DebugFwUpdateActivity.p1(this.c).I3;
      j.d(localTextInputEditText, "mBinding.etWlanType");
      DebugFwUpdateActivity.v1(paramView, (String)localObject1, (String)localObject2, String.valueOf(localTextInputEditText.getText()));
    }
  }
  
  static final class f
    implements View.OnClickListener
  {
    f(DebugFwUpdateActivity paramDebugFwUpdateActivity) {}
    
    public final void onClick(View paramView)
    {
      DebugFwUpdateActivity.o1(this.c);
    }
  }
  
  static final class g
    implements View.OnClickListener
  {
    g(DebugFwUpdateActivity paramDebugFwUpdateActivity) {}
    
    public final void onClick(View paramView)
    {
      DebugFwUpdateActivity.w1(this.c);
    }
  }
  
  static final class h
    extends Lambda
    implements kotlin.jvm.b.a<TextView>
  {
    h(DebugFwUpdateActivity paramDebugFwUpdateActivity)
    {
      super();
    }
    
    public final TextView a()
    {
      TextView localTextView = DebugFwUpdateActivity.p1(this.c).W3;
      j.d(localTextView, "mBinding.tvDeviceTime");
      return localTextView;
    }
  }
  
  static final class i
    extends Lambda
    implements kotlin.jvm.b.a<ProgressBar>
  {
    i(DebugFwUpdateActivity paramDebugFwUpdateActivity)
    {
      super();
    }
    
    public final ProgressBar a()
    {
      ProgressBar localProgressBar = DebugFwUpdateActivity.p1(this.c).M3;
      j.d(localProgressBar, "mBinding.progressBar");
      return localProgressBar;
    }
  }
  
  static final class j
    extends Lambda
    implements kotlin.jvm.b.a<TextView>
  {
    j(DebugFwUpdateActivity paramDebugFwUpdateActivity)
    {
      super();
    }
    
    public final TextView a()
    {
      TextView localTextView = DebugFwUpdateActivity.p1(this.c).Z3;
      j.d(localTextView, "mBinding.tvProgress");
      return localTextView;
    }
  }
  
  static final class k
    extends Lambda
    implements kotlin.jvm.b.a<DebugFwUpdateViewModel>
  {
    k(DebugFwUpdateActivity paramDebugFwUpdateActivity)
    {
      super();
    }
    
    public final DebugFwUpdateViewModel a()
    {
      Object localObject = this.c;
      localObject = new ViewModelProvider((ViewModelStoreOwner)localObject, new IoTViewModelFactory((FragmentActivity)localObject, DebugFwUpdateActivity.q1((DebugFwUpdateActivity)localObject))).get(DebugFwUpdateViewModel.class);
      j.d(localObject, "ViewModelProvider(this, …ateViewModel::class.java)");
      return (DebugFwUpdateViewModel)localObject;
    }
  }
  
  static final class l<T>
    implements g<c>
  {
    l(DebugFwUpdateActivity paramDebugFwUpdateActivity) {}
    
    public final void a(c paramc)
    {
      e.m(this.c, null, 1, null);
    }
  }
  
  static final class m
    implements io.reactivex.g0.a
  {
    m(DebugFwUpdateActivity paramDebugFwUpdateActivity) {}
    
    public final void run()
    {
      e.g(this.a, null, 1, null);
    }
  }
  
  static final class n<T>
    implements g<Throwable>
  {
    n(DebugFwUpdateActivity paramDebugFwUpdateActivity) {}
    
    public final void a(Throwable paramThrowable)
    {
      e.e(this.c, null, 1, null);
    }
  }
  
  static final class o<T>
    implements g<c>
  {
    o(DebugFwUpdateActivity paramDebugFwUpdateActivity) {}
    
    public final void a(c paramc)
    {
      e.m(this.c, null, 1, null);
    }
  }
  
  static final class p
    implements io.reactivex.g0.a
  {
    p(DebugFwUpdateActivity paramDebugFwUpdateActivity) {}
    
    public final void run()
    {
      e.g(this.a, null, 1, null);
    }
  }
  
  static final class q<T>
    implements g<Throwable>
  {
    q(DebugFwUpdateActivity paramDebugFwUpdateActivity) {}
    
    public final void a(Throwable paramThrowable)
    {
      e.e(this.c, null, 1, null);
    }
  }
  
  static final class r
    extends Lambda
    implements l<com.tplink.iot.Utils.extension.f, p>
  {
    r(String paramString)
    {
      super();
    }
    
    public final void a(com.tplink.iot.Utils.extension.f paramf)
    {
      j.e(paramf, "$receiver");
      paramf.j("ThingModel");
      String str = this.c;
      j.d(str, "thingModelStr");
      paramf.i(str);
      com.tplink.iot.Utils.extension.f.g(paramf, 2131952441, paramf.b(), null, 4, null);
    }
  }
  
  static final class s<T>
    implements Observer<FwDownloadStatus>
  {
    s(DebugFwUpdateActivity paramDebugFwUpdateActivity) {}
    
    public final void a(FwDownloadStatus paramFwDownloadStatus)
    {
      DebugFwUpdateActivity localDebugFwUpdateActivity = this.a;
      j.d(paramFwDownloadStatus, "it");
      DebugFwUpdateActivity.t1(localDebugFwUpdateActivity, paramFwDownloadStatus);
    }
  }
  
  static final class t<T>
    implements Observer<DeviceTimeInfo>
  {
    t(DebugFwUpdateActivity paramDebugFwUpdateActivity) {}
    
    public final void a(DeviceTimeInfo paramDeviceTimeInfo)
    {
      DebugFwUpdateActivity.r1(this.a).setText(i.j(paramDeviceTimeInfo));
    }
  }
  
  static final class u<T>
    implements g<c>
  {
    u(DebugFwUpdateActivity paramDebugFwUpdateActivity) {}
    
    public final void a(c paramc)
    {
      s0.m(this.c, "Sending command...");
    }
  }
  
  static final class v
    implements io.reactivex.g0.a
  {
    v(DebugFwUpdateActivity paramDebugFwUpdateActivity) {}
    
    public final void run()
    {
      s0.C(this.a, "Send command success", null);
      DebugFwUpdateActivity.y1(this.a, 0);
      DebugFwUpdateActivity.s1(this.a).t(false);
    }
  }
  
  static final class w<T>
    implements g<Throwable>
  {
    w(DebugFwUpdateActivity paramDebugFwUpdateActivity) {}
    
    public final void a(Throwable paramThrowable)
    {
      Object localObject = DebugFwUpdateActivity.p1(this.c).f;
      j.d(localObject, "mBinding.btnDownload");
      ((Button)localObject).setEnabled(true);
      localObject = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Send command Failed：");
      localStringBuilder.append(paramThrowable);
      s0.p((Activity)localObject, localStringBuilder.toString());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\iotcommon\DebugFwUpdateActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */