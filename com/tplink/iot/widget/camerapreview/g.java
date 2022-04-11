package com.tplink.iot.widget.camerapreview;

import androidx.databinding.BindingAdapter;
import com.tplink.iot.view.ipcamera.preview.CameraPreviewInfo;

public class g
{
  @BindingAdapter({"deviceIdMD5"})
  public static void a(PreviewDisplayView paramPreviewDisplayView, String paramString)
  {
    paramPreviewDisplayView.setDeviceIdMD5(paramString);
  }
  
  @BindingAdapter({"previewInfo"})
  public static void b(PreviewDisplayView paramPreviewDisplayView, CameraPreviewInfo paramCameraPreviewInfo)
  {
    paramPreviewDisplayView.setPreviewInfo(paramCameraPreviewInfo);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\camerapreview\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */