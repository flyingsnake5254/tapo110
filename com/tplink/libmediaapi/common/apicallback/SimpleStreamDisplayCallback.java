package com.tplink.libmediaapi.common.apicallback;

import com.tplink.libtpappcommonmedia.bean.stream.BitStreamType;
import com.tplink.libtpvideorender.view.GLSurfaceViewGPU;

public class SimpleStreamDisplayCallback
  implements StreamDisplayCommonCallback
{
  public void changeVideoBitStreamType(String paramString, BitStreamType paramBitStreamType, boolean paramBoolean, int paramInt) {}
  
  public void displayDestroy() {}
  
  public void displayNetworkSpeed(float paramFloat) {}
  
  public void framePerSecond(String paramString, int paramInt) {}
  
  public void hideLoadingView() {}
  
  public void onRenderProgramAdd(String paramString, GLSurfaceViewGPU paramGLSurfaceViewGPU) {}
  
  public void onSnapshotComplete(String paramString) {}
  
  public void onStreamFinish() {}
  
  public void playFatalException(Exception paramException) {}
  
  public void recordFailed(int paramInt) {}
  
  public void recordProgress(long paramLong) {}
  
  public void recordStart() {}
  
  public void recordStop() {}
  
  public void recordSuccess(int paramInt, String paramString) {}
  
  public void relayPreviewTimeLimit(int paramInt) {}
  
  public void retryResolutions(BitStreamType paramBitStreamType) {}
  
  public void showLoadingView() {}
  
  public void startHoldToTalk() {}
  
  public void stopHoldToTalk() {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libmediaapi\common\apicallback\SimpleStreamDisplayCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */