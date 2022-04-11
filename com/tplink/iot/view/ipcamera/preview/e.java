package com.tplink.iot.view.ipcamera.preview;

import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import java.util.Comparator;
import kotlin.jvm.internal.j;

public final class e
  implements Comparator<ALCameraDevice>
{
  public int a(ALCameraDevice paramALCameraDevice1, ALCameraDevice paramALCameraDevice2)
  {
    j.e(paramALCameraDevice1, "o1");
    j.e(paramALCameraDevice2, "o2");
    paramALCameraDevice1 = paramALCameraDevice1.getDeviceAlias();
    paramALCameraDevice2 = paramALCameraDevice2.getDeviceAlias();
    j.d(paramALCameraDevice2, "o2.deviceAlias");
    return paramALCameraDevice1.compareTo(paramALCameraDevice2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\preview\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */