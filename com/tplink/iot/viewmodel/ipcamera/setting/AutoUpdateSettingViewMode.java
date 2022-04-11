package com.tplink.iot.viewmodel.ipcamera.setting;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.repo.FirmwareRepository;
import com.tplink.libtpnetwork.cameranetwork.model.AutoUpdateInfo;
import com.tplink.libtpnetwork.cameranetwork.model.OptionSwitch;
import io.reactivex.e0.b;
import io.reactivex.e0.c;
import io.reactivex.q;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AutoUpdateSettingViewMode
  extends AndroidViewModel
{
  private FirmwareRepository a;
  private MutableLiveData<AutoUpdateInfo> b = new MutableLiveData();
  private SingleLiveEvent<Boolean> c = new SingleLiveEvent();
  private SingleLiveEvent<Integer> d = new SingleLiveEvent();
  private b e = new b();
  public AutoUpdateInfo f;
  
  public AutoUpdateSettingViewMode(@NonNull Application paramApplication, TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    super(paramApplication);
    this.a = ((FirmwareRepository)e.b(paramTPCameraDeviceContext, FirmwareRepository.class));
  }
  
  private String B(int paramInt)
  {
    int i = paramInt / 60 % 24;
    paramInt %= 60;
    Object localObject = new java/lang/StringBuilder;
    if (i < 10)
    {
      ((StringBuilder)localObject).<init>();
      ((StringBuilder)localObject).append("0");
    }
    else
    {
      ((StringBuilder)localObject).<init>();
      ((StringBuilder)localObject).append("");
    }
    ((StringBuilder)localObject).append(i);
    String str = ((StringBuilder)localObject).toString();
    if (paramInt < 10)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("0");
      ((StringBuilder)localObject).append(paramInt);
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(paramInt);
      localObject = ((StringBuilder)localObject).toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(":");
    localStringBuilder.append((String)localObject);
    return localStringBuilder.toString();
  }
  
  public void A(boolean paramBoolean, int paramInt)
  {
    Object localObject = new AutoUpdateInfo(OptionSwitch.fromBoolean(paramBoolean).getRaw(), B(paramInt), Integer.valueOf(120));
    localObject = this.a.U((AutoUpdateInfo)localObject).F(new f1(this)).y(new e1(this)).H0(new g1(this), new j1(this));
    this.e.b((c)localObject);
  }
  
  public void f()
  {
    c localc = this.a.t().F(new l1(this)).y(new h1(this)).H0(new i1(this), k1.c);
    this.e.b(localc);
  }
  
  public LiveData<AutoUpdateInfo> g()
  {
    return this.b;
  }
  
  public SingleLiveEvent<Boolean> h()
  {
    return this.c;
  }
  
  public SingleLiveEvent<Integer> i()
  {
    return this.d;
  }
  
  public int j(String paramString)
  {
    if (Pattern.compile("(\\d{2}):(\\d{2})").matcher(paramString).matches())
    {
      paramString = paramString.split(":");
      return Integer.parseInt(paramString[0]) * 60 + Integer.parseInt(paramString[1]);
    }
    return 180;
  }
  
  protected void onCleared()
  {
    super.onCleared();
    this.e.dispose();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\setting\AutoUpdateSettingViewMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */