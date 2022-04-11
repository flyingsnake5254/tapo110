package b.d.z.a;

import com.tplink.libtpappcommonmedia.bean.stream.BitStreamType;
import com.tplink.libtpvideorender.view.GLSurfaceViewGPU;

public abstract interface a
{
  public abstract void changeVideoBitStreamType(String paramString, BitStreamType paramBitStreamType, boolean paramBoolean, int paramInt);
  
  public abstract void displayDestroy();
  
  public abstract void displayNetworkSpeed(float paramFloat);
  
  public abstract void framePerSecond(String paramString, int paramInt);
  
  public abstract void hideLoadingView();
  
  public abstract void onRenderProgramAdd(String paramString, GLSurfaceViewGPU paramGLSurfaceViewGPU);
  
  public abstract void onSnapshotComplete(String paramString);
  
  public abstract void onStreamFinish();
  
  public abstract void playFatalException(Exception paramException);
  
  public abstract void recordFailed(int paramInt);
  
  public abstract void recordProgress(long paramLong);
  
  public abstract void recordStart();
  
  public abstract void recordStop();
  
  public abstract void recordSuccess(int paramInt, String paramString);
  
  public abstract void relayPreviewTimeLimit(int paramInt);
  
  public abstract void retryResolutions(BitStreamType paramBitStreamType);
  
  public abstract void showLoadingView();
  
  public abstract void startHoldToTalk();
  
  public abstract void stopHoldToTalk();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\z\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */