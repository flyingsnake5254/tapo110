package com.tplink.libmediaapi.live.repo;

import b.d.u.m;
import b.d.v.b.c;
import com.tplink.libmediaapi.common.apicallback.DoubleTalkStreamCallback;
import com.tplink.libtpappcommonmedia.bean.TPMediaDeviceContext;
import com.tplink.libtpmediamanager.d;
import com.tplink.libtpmediamanager.g.b;
import com.tplink.libtpmediamanager.talk.TalkMediaBaseRepository;

public class TalkMediaRepository
  extends TalkMediaBaseRepository
{
  private DoubleTalkStreamCallback doubleTalkStreamCallback;
  private final c doubleTalkStreamCallbackInner = new c()
  {
    public void onDoubleTalkClose(String paramAnonymousString)
    {
      if (TalkMediaRepository.this.doubleTalkStreamCallback != null) {
        TalkMediaRepository.this.doubleTalkStreamCallback.onDoubleTalkClose(paramAnonymousString);
      }
    }
    
    public void onDoubleTalkCreateFailure(String paramAnonymousString, int paramAnonymousInt)
    {
      if (TalkMediaRepository.this.doubleTalkStreamCallback != null) {
        TalkMediaRepository.this.doubleTalkStreamCallback.onDoubleTalkCreateFailure(paramAnonymousString, paramAnonymousInt);
      }
    }
    
    public void onDoubleTalkCreateSuccess(String paramAnonymousString)
    {
      if (TalkMediaRepository.this.doubleTalkStreamCallback != null) {
        TalkMediaRepository.this.doubleTalkStreamCallback.onDoubleTalkCreateSuccess(paramAnonymousString);
      }
    }
    
    public void onDoubleTalkSendDataFailure(String paramAnonymousString, int paramAnonymousInt, Exception paramAnonymousException)
    {
      if (TalkMediaRepository.this.doubleTalkStreamCallback != null) {
        TalkMediaRepository.this.doubleTalkStreamCallback.onDoubleTalkSendDataFailure(paramAnonymousString, paramAnonymousInt, paramAnonymousException);
      }
    }
  };
  
  public TalkMediaRepository(TPMediaDeviceContext paramTPMediaDeviceContext)
  {
    super(paramTPMediaDeviceContext);
  }
  
  private m getClient()
  {
    return d.h().g(this.deviceContext.getDeviceIdMd5());
  }
  
  public void addDoubleTalkStreamCallback(String paramString, DoubleTalkStreamCallback paramDoubleTalkStreamCallback)
  {
    this.doubleTalkStreamCallback = paramDoubleTalkStreamCallback;
    d.h().d(paramString, this.doubleTalkStreamCallbackInner);
  }
  
  public void destroyAllDoubleTalkClient()
  {
    d.h().e();
  }
  
  public void destroyDoubleTalkClient(String paramString)
  {
    d.h().f(paramString);
  }
  
  public void loadCacheData() {}
  
  public void muteRecordAudio(boolean paramBoolean)
  {
    m localm = getClient();
    if (localm != null) {
      localm.e(paramBoolean);
    }
  }
  
  public void onCleared() {}
  
  public void openDoubleTalkClient(String paramString1, String paramString2)
  {
    d.h().j(paramString1, paramString2);
  }
  
  public void pauseSendAudio()
  {
    m localm = getClient();
    if (localm != null) {
      localm.d();
    }
  }
  
  public void setMaxVolume(int paramInt)
  {
    m localm = getClient();
    if (localm != null) {
      localm.g(paramInt);
    }
  }
  
  public void setVolume(int paramInt)
  {
    m localm = getClient();
    if (localm != null) {
      localm.i(paramInt);
    }
  }
  
  public void startSendAudio()
  {
    m localm = getClient();
    if (localm != null) {
      localm.j();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libmediaapi\live\repo\TalkMediaRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */