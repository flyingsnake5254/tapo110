package com.tplink.libtpnetwork.Utils;

import com.tplink.iot.cloud.exception.IoTCloudException;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.IoTCloudExceptionDataResult;
import com.tplink.libtpnetwork.exception.IoTException;
import com.tplink.libtpnetwork.exception.IoTTransportException;
import com.tplink.tmp.exception.TPGeneralNetworkException;

public class y
{
  public static int a(Throwable paramThrowable)
  {
    boolean bool = paramThrowable instanceof IoTTransportException;
    int i = -1;
    int j;
    if (bool)
    {
      j = ((IoTTransportException)paramThrowable).getErrCode();
    }
    else if ((paramThrowable instanceof IoTException))
    {
      j = ((IoTException)paramThrowable).getErrCode();
    }
    else if ((paramThrowable instanceof TPGeneralNetworkException))
    {
      j = ((TPGeneralNetworkException)paramThrowable).getErrCode();
    }
    else if ((paramThrowable instanceof IoTCloudException))
    {
      Object localObject;
      try
      {
        IoTCloudExceptionDataResult localIoTCloudExceptionDataResult = (IoTCloudExceptionDataResult)i.a(((IoTCloudException)paramThrowable).getData(), IoTCloudExceptionDataResult.class);
      }
      catch (Exception localException)
      {
        localObject = null;
      }
      if (localObject != null) {
        j = ((IoTCloudExceptionDataResult)localObject).getCodeFromDevice();
      } else {
        j = ((IoTCloudException)paramThrowable).getCode();
      }
    }
    else
    {
      j = -1;
    }
    if (j == 0) {
      j = i;
    }
    return j;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\Utils\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */