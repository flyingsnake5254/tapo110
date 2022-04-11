package com.tplink.iot.view.ipcamera.setting;

import androidx.databinding.BindingAdapter;
import com.tplink.iot.widget.camerasetting.SimpleProcessBarNewIpc;
import com.tplink.libtpnetwork.cameranetwork.model.SdCardStatus;

public class c5
{
  @BindingAdapter({"percent"})
  public static void a(SimpleProcessBarNewIpc paramSimpleProcessBarNewIpc, int paramInt)
  {
    paramSimpleProcessBarNewIpc.setProcess(paramInt);
  }
  
  @BindingAdapter({"status"})
  public static void b(SimpleProcessBarNewIpc paramSimpleProcessBarNewIpc, SdCardStatus paramSdCardStatus)
  {
    paramSimpleProcessBarNewIpc.setStatus(paramSdCardStatus);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\setting\c5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */