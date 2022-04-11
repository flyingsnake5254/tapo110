package com.tplink.iot.view.feedback;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Parcelable;
import android.provider.MediaStore.Images.Media;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.FileChooserParams;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialog;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.fragment.app.FragmentActivity;
import com.tplink.iot.Utils.StatusBarUtils;
import com.tplink.iot.Utils.TPMaterialDialog;
import com.tplink.iot.Utils.TPMaterialDialog.Builder;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.Utils.TPMaterialDialogV2.d;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.t0;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CommonCameraRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.LdcDianoseSettingRepository;
import com.tplink.libtpnetwork.cameranetwork.util.f;
import io.reactivex.q;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class FeedBackWebActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private static File y;
  private String H3;
  private List<String> I3 = new ArrayList();
  private Map<String, String> J3 = new HashMap();
  public ValueCallback<Uri> K3;
  public ValueCallback<Uri[]> L3;
  private boolean M3;
  private CameraLoadingView N3;
  private ProgressBar p0 = null;
  private View p1 = null;
  private MenuItem p2 = null;
  public TPMaterialDialog p3 = null;
  private WebView z = null;
  
  @TargetApi(23)
  private void A1()
  {
    ArrayList localArrayList = new ArrayList();
    if (com.tplink.libtpnetwork.Utils.o.h0().m0())
    {
      t1(localArrayList, "android.permission.CAMERA");
      t1(localArrayList, "android.permission.READ_EXTERNAL_STORAGE");
      if (com.tplink.iot.Utils.a1.b.c()) {
        t1(localArrayList, "android.permission.WRITE_EXTERNAL_STORAGE");
      }
    }
    else
    {
      if (!t1(localArrayList, "android.permission.CAMERA"))
      {
        Q1();
        O1();
        return;
      }
      if (B1(localArrayList))
      {
        R1();
        O1();
        return;
      }
    }
    if (!localArrayList.isEmpty()) {
      requestPermissions((String[])localArrayList.toArray(new String[localArrayList.size()]), 4);
    } else {
      M1();
    }
  }
  
  private boolean B1(List<String> paramList)
  {
    boolean bool1 = com.tplink.iot.Utils.a1.b.c();
    boolean bool2 = true;
    if (bool1)
    {
      bool1 = bool2;
      if (t1(paramList, "android.permission.READ_EXTERNAL_STORAGE")) {
        if (!t1(paramList, "android.permission.WRITE_EXTERNAL_STORAGE")) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
      }
      return bool1;
    }
    return t1(paramList, "android.permission.READ_EXTERNAL_STORAGE") ^ true;
  }
  
  private void J1()
  {
    if (t0.g(this))
    {
      this.M3 = false;
      c1("");
      this.p0.setProgress(0);
      this.p0.setVisibility(0);
      this.p1.setVisibility(8);
      WebView localWebView = this.z;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("https://www.tapo.com/app/#/feedback2?locale=");
      localStringBuilder.append(com.tplink.iot.model.about.d.f());
      localWebView.loadUrl(localStringBuilder.toString());
    }
    else
    {
      this.M3 = true;
      this.p1.setVisibility(0);
      this.z.setVisibility(8);
      this.p0.setVisibility(8);
    }
  }
  
  private void K1(ValueCallback<Uri> paramValueCallback)
  {
    this.K3 = paramValueCallback;
    P1();
  }
  
  private void L1(ValueCallback<Uri[]> paramValueCallback)
  {
    this.L3 = paramValueCallback;
    P1();
  }
  
  private void M1()
  {
    Object localObject1 = x1(this);
    if (localObject1 == null)
    {
      s0.p(this, getString(2131952444));
      return;
    }
    Object localObject2 = new File((File)localObject1, "tapo_feedback");
    if (!((File)localObject2).exists()) {
      ((File)localObject2).mkdirs();
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(localObject2);
    ((StringBuilder)localObject1).append(File.separator);
    ((StringBuilder)localObject1).append("img_");
    ((StringBuilder)localObject1).append(String.valueOf(System.currentTimeMillis()));
    ((StringBuilder)localObject1).append(".png");
    y = new File(((StringBuilder)localObject1).toString());
    if (Build.VERSION.SDK_INT < 21)
    {
      localObject1 = Uri.fromFile(y);
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(getApplicationContext().getPackageName());
      ((StringBuilder)localObject1).append(".provider");
      localObject1 = FileProvider.getUriForFile(this, ((StringBuilder)localObject1).toString(), y);
    }
    localObject2 = new Intent("android.media.action.IMAGE_CAPTURE");
    ((Intent)localObject2).putExtra("output", (Parcelable)localObject1);
    startActivityForResult((Intent)localObject2, 2);
  }
  
  private void N1()
  {
    Intent localIntent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
    localIntent.setType("image/*");
    startActivityForResult(localIntent, 1);
  }
  
  private void O1()
  {
    ValueCallback localValueCallback = this.L3;
    if (localValueCallback != null)
    {
      localValueCallback.onReceiveValue(null);
      this.L3 = null;
    }
    localValueCallback = this.K3;
    if (localValueCallback != null)
    {
      localValueCallback.onReceiveValue(null);
      this.K3 = null;
    }
  }
  
  private void P1()
  {
    if (this.p3 == null)
    {
      View localView = getLayoutInflater().inflate(2131559112, null);
      Object localObject = new TPMaterialDialog.Builder(this).d(localView).b(true).c(false).a();
      this.p3 = ((TPMaterialDialog)localObject);
      ((Dialog)localObject).setOnCancelListener(new a());
      localObject = localView.findViewById(2131362488);
      localView = localView.findViewById(2131362487);
      ((View)localObject).setOnClickListener(new b());
      localView.setOnClickListener(new c());
    }
    this.p3.show();
  }
  
  private void Q1()
  {
    new TPMaterialDialogV2.Builder(this).r(2131952447).h(2131953012).p(2131951765, new e()).g(8, 8).l(2131952391, 2131099804, null).y();
  }
  
  private void R1()
  {
    new TPMaterialDialogV2.Builder(this).r(2131953013).h(2131953012).p(2131951765, new d()).g(8, 8).l(2131952391, 2131099804, null).y();
  }
  
  private void S1()
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) {
        requestPermissions(new String[] { "android.permission.READ_EXTERNAL_STORAGE" }, 3);
      } else {
        N1();
      }
    }
    else {
      N1();
    }
  }
  
  private void T1()
  {
    if (Build.VERSION.SDK_INT >= 23) {
      A1();
    } else {
      M1();
    }
  }
  
  @TargetApi(23)
  private boolean t1(List<String> paramList, String paramString)
  {
    if (checkSelfPermission(paramString) != 0)
    {
      paramList.add(paramString);
      return shouldShowRequestPermissionRationale(paramString);
    }
    return true;
  }
  
  private void u1()
  {
    if (this.z.canGoBack()) {
      this.z.goBack();
    } else {
      finish();
    }
  }
  
  private q<Boolean> v1(String paramString)
  {
    Object localObject = b.d.w.h.a.g(paramString);
    paramString = TPIoTClientManager.I1((String)localObject);
    if (!(paramString instanceof ALCameraDevice)) {
      return q.f0(Boolean.FALSE);
    }
    ALCameraDevice localALCameraDevice = (ALCameraDevice)paramString;
    if (localALCameraDevice.isRemoteOnly()) {
      return q.f0(Boolean.FALSE);
    }
    paramString = (CommonCameraRepository)e.c((String)localObject, CommonCameraRepository.class);
    localObject = (LdcDianoseSettingRepository)e.c((String)localObject, LdcDianoseSettingRepository.class);
    return paramString.K0().N(new b(this, (LdcDianoseSettingRepository)localObject, localALCameraDevice));
  }
  
  private void w1()
  {
    if ((getIntent() != null) && (getIntent().getExtras() != null))
    {
      Bundle localBundle = getIntent().getExtras();
      this.H3 = localBundle.getString("feed_back_faq_params", "");
      this.I3 = localBundle.getStringArrayList("feed_back_faq_devices");
    }
  }
  
  public static File x1(@NonNull Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 29)
    {
      paramContext = paramContext.getApplicationContext().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
    }
    else
    {
      if (!Environment.getExternalStorageState().equals("mounted")) {
        break label59;
      }
      paramContext = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
    }
    if ((paramContext != null) && (!paramContext.exists())) {
      paramContext.mkdirs();
    }
    return paramContext;
    label59:
    return null;
  }
  
  @SuppressLint({"JavascriptInterface"})
  private void y1()
  {
    c1("");
    Object localObject = (ProgressBar)findViewById(2131362632);
    this.p0 = ((ProgressBar)localObject);
    ((ProgressBar)localObject).setMax(100);
    this.p0.setVisibility(0);
    localObject = findViewById(2131362630);
    this.p1 = ((View)localObject);
    ((View)localObject).setVisibility(8);
    this.p1.setOnClickListener(this);
    this.z = ((WebView)findViewById(2131362631));
    z1();
    this.z.setWebViewClient(new h(null));
    this.z.setWebChromeClient(new g(null));
    this.z.addJavascriptInterface(new f(), "uploadDeviceInfo");
    this.N3 = ((CameraLoadingView)findViewById(2131363250));
  }
  
  private void z1()
  {
    this.z.getSettings().setJavaScriptEnabled(true);
    this.z.getSettings().setDefaultTextEncodingName("UTF-8");
    this.z.getSettings().setAllowFileAccess(true);
    this.z.getSettings().setAllowFileAccessFromFileURLs(true);
    this.z.getSettings().setAllowContentAccess(true);
    this.z.getSettings().setDomStorageEnabled(true);
    this.z.getSettings().setAppCacheEnabled(false);
    this.z.getSettings().setCacheMode(2);
    this.z.getSettings().setSupportZoom(false);
    this.z.getSettings().setBuiltInZoomControls(false);
  }
  
  public void I1()
  {
    this.N3.b();
    this.z.setVisibility(8);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.I3.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!TextUtils.isEmpty(str)) {
        localArrayList.add(v1(str));
      }
    }
    q.j0(localArrayList).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).y(new a(this)).F0();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 != -1)
    {
      O1();
      return;
    }
    Object localObject;
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        O1();
      }
      else
      {
        try
        {
          paramIntent = MediaStore.Images.Media.insertImage(getContentResolver(), y.getAbsolutePath(), "", "");
        }
        catch (FileNotFoundException paramIntent)
        {
          paramIntent.printStackTrace();
          paramIntent = null;
        }
        if (paramIntent != null) {
          paramIntent = Uri.parse(paramIntent);
        } else {
          paramIntent = null;
        }
        if (com.tplink.iot.d.a.a.equalsIgnoreCase("android4.4.4")) {
          paramIntent = Uri.fromFile(y);
        }
        localObject = this.K3;
        if (localObject != null) {
          ((ValueCallback)localObject).onReceiveValue(paramIntent);
        }
        localObject = this.L3;
        if (localObject != null) {
          ((ValueCallback)localObject).onReceiveValue(new Uri[] { paramIntent });
        }
        this.K3 = null;
        this.L3 = null;
      }
    }
    else
    {
      if (paramIntent == null) {
        paramIntent = null;
      } else {
        paramIntent = paramIntent.getData();
      }
      localObject = paramIntent;
      if (paramIntent != null)
      {
        localObject = paramIntent;
        if (com.tplink.iot.d.a.a.equalsIgnoreCase("android4.4.4"))
        {
          String str = d.b(this, paramIntent);
          localObject = paramIntent;
          if (str != null)
          {
            paramIntent = str;
            if (!str.startsWith("file://"))
            {
              paramIntent = new StringBuilder();
              paramIntent.append("file://");
              paramIntent.append(str);
              paramIntent = paramIntent.toString();
            }
            localObject = Uri.parse(paramIntent);
          }
        }
      }
      paramIntent = this.K3;
      if (paramIntent != null) {
        paramIntent.onReceiveValue(localObject);
      }
      paramIntent = this.L3;
      if (paramIntent != null) {
        paramIntent.onReceiveValue(new Uri[] { localObject });
      }
      this.K3 = null;
      this.L3 = null;
    }
  }
  
  public void onBackPressed()
  {
    u1();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131362630) {
      J1();
    }
  }
  
  @SuppressLint({"SetJavaScriptEnabled"})
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (com.tplink.iot.core.o.a() == 0) {
      return;
    }
    setContentView(2131558516);
    w1();
    y1();
    paramBundle = this.I3;
    if ((paramBundle != null) && (!paramBundle.isEmpty())) {
      I1();
    } else {
      J1();
    }
    StatusBarUtils.n(this, ContextCompat.getColor(this, 2131099771));
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131623938, paramMenu);
    paramMenu = paramMenu.findItem(2131362297);
    this.p2 = paramMenu;
    paramMenu.setVisible(false);
    return true;
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (com.tplink.iot.core.o.a() == 0) {
      return;
    }
    WebView localWebView = this.z;
    if (localWebView != null)
    {
      localWebView.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
      this.z.clearHistory();
      ((ViewGroup)this.z.getParent()).removeView(this.z);
      this.z.destroy();
      this.z = null;
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    int i = paramMenuItem.getItemId();
    if (i == 2131362297)
    {
      finish();
      return true;
    }
    if (i == 16908332)
    {
      u1();
      return false;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  public void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt)
  {
    int i = 0;
    int j = 1;
    if (paramInt != 3)
    {
      if (paramInt == 4)
      {
        paramInt = 1;
        i = 0;
        while (i < paramArrayOfString.length)
        {
          int k;
          int m;
          if ("android.permission.CAMERA".equals(paramArrayOfString[i]))
          {
            k = j;
            m = paramInt;
            if (paramArrayOfInt[i] != 0)
            {
              k = 0;
              m = paramInt;
            }
          }
          else if (!"android.permission.READ_EXTERNAL_STORAGE".equals(paramArrayOfString[i]))
          {
            k = j;
            m = paramInt;
            if (!"android.permission.WRITE_EXTERNAL_STORAGE".equals(paramArrayOfString[i])) {}
          }
          else
          {
            k = j;
            m = paramInt;
            if (paramArrayOfInt[i] != 0)
            {
              m = 0;
              k = j;
            }
          }
          i++;
          j = k;
          paramInt = m;
        }
        if ((j != 0) && (paramInt != 0))
        {
          try
          {
            M1();
          }
          catch (Exception paramArrayOfInt)
          {
            paramArrayOfString = new StringBuilder();
            paramArrayOfString.append("permission error --- ");
            paramArrayOfString.append(paramArrayOfInt.getMessage());
            b.d.w.c.a.a(paramArrayOfString.toString());
          }
        }
        else if (j == 0)
        {
          Q1();
          O1();
        }
        else
        {
          R1();
          O1();
        }
        com.tplink.libtpnetwork.Utils.o.h0().B0();
      }
    }
    else
    {
      j = paramArrayOfInt.length;
      for (paramInt = 0; paramInt < j; paramInt++) {
        if (paramArrayOfInt[paramInt] != 0)
        {
          paramInt = i;
          break label248;
        }
      }
      paramInt = 1;
      label248:
      if (paramInt != 0)
      {
        N1();
      }
      else
      {
        R1();
        O1();
      }
    }
  }
  
  class a
    implements DialogInterface.OnCancelListener
  {
    a() {}
    
    public void onCancel(DialogInterface paramDialogInterface)
    {
      FeedBackWebActivity.h1(FeedBackWebActivity.this);
    }
  }
  
  class b
    implements View.OnClickListener
  {
    b() {}
    
    public void onClick(View paramView)
    {
      FeedBackWebActivity.i1(FeedBackWebActivity.this);
      FeedBackWebActivity.this.p3.dismiss();
    }
  }
  
  class c
    implements View.OnClickListener
  {
    c() {}
    
    public void onClick(View paramView)
    {
      FeedBackWebActivity.j1(FeedBackWebActivity.this);
      FeedBackWebActivity.this.p3.dismiss();
    }
  }
  
  class d
    implements TPMaterialDialogV2.d
  {
    d() {}
    
    public void onClick(View paramView)
    {
      paramView = new StringBuilder();
      paramView.append("package:");
      paramView.append(FeedBackWebActivity.this.getPackageName());
      paramView = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse(paramView.toString()));
      FeedBackWebActivity.this.startActivityForResult(paramView, 5);
    }
  }
  
  class e
    implements TPMaterialDialogV2.d
  {
    e() {}
    
    public void onClick(View paramView)
    {
      paramView = new StringBuilder();
      paramView.append("package:");
      paramView.append(FeedBackWebActivity.this.getPackageName());
      paramView = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse(paramView.toString()));
      FeedBackWebActivity.this.startActivity(paramView);
    }
  }
  
  public class f
  {
    public f() {}
    
    @JavascriptInterface
    public String getAppParameters()
    {
      return FeedBackWebActivity.m1(FeedBackWebActivity.this);
    }
    
    @JavascriptInterface
    public String getDutEncryptLog(String paramString)
    {
      String str1 = "";
      String str2 = str1;
      if (paramString != null)
      {
        paramString = f.a(paramString);
        paramString = (String)FeedBackWebActivity.n1(FeedBackWebActivity.this).get(paramString);
        str2 = str1;
        if (paramString != null) {
          str2 = paramString;
        }
      }
      return str2;
    }
    
    @JavascriptInterface
    public void postMessage(String paramString)
    {
      if (paramString != null) {
        try
        {
          Object localObject = new org/json/JSONObject;
          ((JSONObject)localObject).<init>(paramString);
          paramString = ((JSONObject)localObject).getString("message");
          if (paramString != null)
          {
            int i = -1;
            int j = paramString.hashCode();
            if (j != -1357520532)
            {
              if ((j == 348678395) && (paramString.equals("submitted"))) {
                i = 0;
              }
            }
            else if (paramString.equals("closed")) {
              i = 1;
            }
            if (i != 0)
            {
              if (i == 1)
              {
                paramString = FeedBackWebActivity.l1(FeedBackWebActivity.this);
                localObject = new com/tplink/iot/view/feedback/FeedBackWebActivity$f$b;
                ((b)localObject).<init>(this);
                paramString.postDelayed((Runnable)localObject, 500L);
              }
            }
            else
            {
              paramString = FeedBackWebActivity.k1(FeedBackWebActivity.this);
              localObject = new com/tplink/iot/view/feedback/FeedBackWebActivity$f$a;
              ((a)localObject).<init>(this);
              paramString.postDelayed((Runnable)localObject, 500L);
            }
          }
        }
        catch (JSONException paramString)
        {
          paramString.printStackTrace();
        }
      }
    }
    
    class a
      implements Runnable
    {
      a() {}
      
      public void run()
      {
        FeedBackWebActivity.this.finish();
      }
    }
    
    class b
      implements Runnable
    {
      b() {}
      
      public void run()
      {
        FeedBackWebActivity.this.finish();
      }
    }
  }
  
  private class g
    extends WebChromeClient
  {
    private g() {}
    
    public void onProgressChanged(WebView paramWebView, int paramInt)
    {
      if (paramInt == 100) {
        FeedBackWebActivity.o1(FeedBackWebActivity.this).setVisibility(8);
      } else {
        FeedBackWebActivity.o1(FeedBackWebActivity.this).setProgress(paramInt);
      }
    }
    
    public void onReceivedTitle(WebView paramWebView, String paramString)
    {
      FeedBackWebActivity.this.c1(paramString);
      super.onReceivedTitle(paramWebView, paramString);
    }
    
    public boolean onShowFileChooser(WebView paramWebView, ValueCallback<Uri[]> paramValueCallback, WebChromeClient.FileChooserParams paramFileChooserParams)
    {
      FeedBackWebActivity.g1(FeedBackWebActivity.this, paramValueCallback);
      return true;
    }
    
    public void openFileChooser(ValueCallback<Uri> paramValueCallback)
    {
      FeedBackWebActivity.f1(FeedBackWebActivity.this, paramValueCallback);
    }
    
    public void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString)
    {
      FeedBackWebActivity.f1(FeedBackWebActivity.this, paramValueCallback);
    }
    
    public void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
    {
      FeedBackWebActivity.f1(FeedBackWebActivity.this, paramValueCallback);
    }
  }
  
  private class h
    extends WebViewClient
  {
    private h() {}
    
    public void onPageFinished(WebView paramWebView, String paramString)
    {
      super.onPageFinished(paramWebView, paramString);
      if (FeedBackWebActivity.e1(FeedBackWebActivity.this) != null)
      {
        paramWebView = FeedBackWebActivity.e1(FeedBackWebActivity.this);
        boolean bool;
        if ((FeedBackWebActivity.s1(FeedBackWebActivity.this) != null) && (FeedBackWebActivity.s1(FeedBackWebActivity.this).canGoBack())) {
          bool = true;
        } else {
          bool = false;
        }
        paramWebView.setVisible(bool);
      }
      if ((!FeedBackWebActivity.p1(FeedBackWebActivity.this)) && (FeedBackWebActivity.r1(FeedBackWebActivity.this) != null) && (FeedBackWebActivity.s1(FeedBackWebActivity.this) != null))
      {
        FeedBackWebActivity.r1(FeedBackWebActivity.this).setVisibility(8);
        FeedBackWebActivity.s1(FeedBackWebActivity.this).setVisibility(0);
      }
    }
    
    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      super.onPageStarted(paramWebView, paramString, paramBitmap);
    }
    
    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      FeedBackWebActivity.q1(FeedBackWebActivity.this, true);
      if ((FeedBackWebActivity.r1(FeedBackWebActivity.this) != null) && (FeedBackWebActivity.s1(FeedBackWebActivity.this) != null))
      {
        FeedBackWebActivity.r1(FeedBackWebActivity.this).setVisibility(0);
        FeedBackWebActivity.s1(FeedBackWebActivity.this).setVisibility(8);
      }
      super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    }
    
    public void onReceivedError(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceError paramWebResourceError)
    {
      FeedBackWebActivity.q1(FeedBackWebActivity.this, true);
      if ((FeedBackWebActivity.r1(FeedBackWebActivity.this) != null) && (FeedBackWebActivity.s1(FeedBackWebActivity.this) != null))
      {
        FeedBackWebActivity.r1(FeedBackWebActivity.this).setVisibility(0);
        FeedBackWebActivity.s1(FeedBackWebActivity.this).setVisibility(8);
      }
      super.onReceivedError(paramWebView, paramWebResourceRequest, paramWebResourceError);
    }
    
    @RequiresApi(api=21)
    public WebResourceResponse shouldInterceptRequest(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
    {
      return super.shouldInterceptRequest(paramWebView, paramWebResourceRequest);
    }
    
    public boolean shouldOverrideUrlLoading(WebView paramWebView, final String paramString)
    {
      if (paramString.startsWith("tel:"))
      {
        new TPMaterialDialogV2.Builder(FeedBackWebActivity.this).k(paramString.substring(4), 2131099937).l(2131952391, 2131099804, null).o(2131952680, 2131099808, new a(paramString)).g(8, 8).a().show();
        return true;
      }
      if (paramString.startsWith("mailto:"))
      {
        paramWebView = new Intent("android.intent.action.SENDTO");
        paramWebView.setData(Uri.parse(paramString));
        FeedBackWebActivity.this.startActivity(paramWebView);
        return true;
      }
      FeedBackWebActivity.o1(FeedBackWebActivity.this).setProgress(0);
      FeedBackWebActivity.o1(FeedBackWebActivity.this).setVisibility(0);
      return super.shouldOverrideUrlLoading(paramWebView, paramString);
    }
    
    class a
      implements TPMaterialDialogV2.d
    {
      a(String paramString) {}
      
      public void onClick(View paramView)
      {
        paramView = new Intent("android.intent.action.DIAL");
        paramView.setData(Uri.parse(paramString));
        FeedBackWebActivity.this.startActivity(paramView);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\feedback\FeedBackWebActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */