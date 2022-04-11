package com.tplink.iot.widget.camerapreview;

import android.content.Context;
import android.view.ViewGroup;
import com.hannesdorfmann.mosby3.k.b;
import com.tplink.iot.view.ipcamera.preview.CameraPreviewInfo;
import io.reactivex.q;

public abstract interface d
  extends b
{
  public abstract q<CameraPreviewInfo> K();
  
  public abstract q<Boolean> P();
  
  public abstract Context getContextForView();
  
  public abstract q<Boolean> getFirmwareIntent();
  
  public abstract ViewGroup getParentView();
  
  public abstract void s0(e parame);
  
  public abstract q<Boolean> x0();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\camerapreview\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */