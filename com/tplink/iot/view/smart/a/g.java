package com.tplink.iot.view.smart.a;

import android.app.Dialog;
import android.content.Context;
import androidx.lifecycle.LiveData;
import b.d.b.f.b;
import com.google.gson.k;
import com.tplink.iot.cloud.bean.common.AsyncResult;
import com.tplink.iot.cloud.bean.smart.common.SmartInfo;
import com.tplink.iot.cloud.bean.smart.common.SmartLog;
import com.tplink.iot.cloud.bean.smart.common.SmartLogAction;
import com.tplink.iot.cloud.bean.smart.common.SmartTemplate;
import com.tplink.iot.cloud.bean.smart.common.SmartThingAction;
import com.tplink.iot.cloud.bean.smart.common.SmartTrigger;
import com.tplink.iot.cloud.enumerate.StateValueDataType;
import com.tplink.iot.core.AppContext;
import com.tplink.iot.widget.ListContentDialog;
import com.tplink.iot.widget.ListContentDialog.Builder;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.RunShortCutResultBean;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.j;

public final class g
{
  public static final g a = new g();
  
  public static final String a(SmartInfo paramSmartInfo)
  {
    String str = "";
    if (paramSmartInfo != null)
    {
      SmartTrigger localSmartTrigger = paramSmartInfo.getTriggerSetting();
      if (localSmartTrigger != null)
      {
        if (localSmartTrigger.isManual()) {
          return "";
        }
        paramSmartInfo = localSmartTrigger.getSchedules();
        int i;
        if (paramSmartInfo != null) {
          i = paramSmartInfo.size();
        } else {
          i = 0;
        }
        paramSmartInfo = localSmartTrigger.getThings();
        int j;
        if (paramSmartInfo != null) {
          j = paramSmartInfo.size();
        } else {
          j = 0;
        }
        if (i + j >= 2)
        {
          paramSmartInfo = com.tplink.libtpnetwork.IoTNetwork.repository.SmartRepository.h[2];
          j.d(paramSmartInfo, "SmartRepository.AUTOMATION_AVATARS[2]");
        }
        else
        {
          if (i == 1)
          {
            paramSmartInfo = com.tplink.libtpnetwork.IoTNetwork.repository.SmartRepository.h[0];
          }
          else
          {
            paramSmartInfo = str;
            if (j == 1) {
              paramSmartInfo = com.tplink.libtpnetwork.IoTNetwork.repository.SmartRepository.h[1];
            }
          }
          j.d(paramSmartInfo, "if (schedulesCount == 1)…         \"\"\n            }");
        }
        return paramSmartInfo;
      }
    }
    return "";
  }
  
  public static final String b(SmartInfo paramSmartInfo)
  {
    paramSmartInfo = a(paramSmartInfo);
    int i;
    if (paramSmartInfo.length() > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0)
    {
      paramSmartInfo = com.tplink.libtpnetwork.IoTNetwork.repository.SmartRepository.h[0];
      j.d(paramSmartInfo, "SmartRepository.AUTOMATION_AVATARS[0]");
    }
    return paramSmartInfo;
  }
  
  public static final boolean c(SmartTemplate paramSmartTemplate)
  {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramSmartTemplate != null)
    {
      paramSmartTemplate = paramSmartTemplate.getTriggerSetting();
      bool2 = bool1;
      if (paramSmartTemplate != null)
      {
        bool2 = bool1;
        if (!paramSmartTemplate.isManual()) {
          bool2 = true;
        }
      }
    }
    return bool2;
  }
  
  public static final RunShortCutResultBean d(AsyncResult paramAsyncResult, String paramString)
  {
    j.e(paramAsyncResult, "asyncResult");
    if (paramAsyncResult.getCode() == 0)
    {
      paramAsyncResult = paramAsyncResult.getData();
      if (paramAsyncResult != null)
      {
        try
        {
          paramAsyncResult = paramAsyncResult.c().n("logs");
          j.d(paramAsyncResult, "data.asJsonObject.get(\"logs\")");
          localObject1 = paramAsyncResult.b();
          j.d(localObject1, "data.asJsonObject.get(\"logs\").asJsonArray");
          paramAsyncResult = new com/tplink/iot/view/smart/a/g$a;
          paramAsyncResult.<init>();
          paramAsyncResult = (List)com.tplink.libtpnetwork.Utils.i.c((com.google.gson.i)localObject1, paramAsyncResult.getType());
          if (paramAsyncResult == null) {
            paramAsyncResult = kotlin.collections.l.d();
          }
        }
        catch (Exception paramAsyncResult)
        {
          paramAsyncResult.printStackTrace();
          paramAsyncResult = kotlin.collections.l.d();
        }
        Object localObject1 = (TPIoTClientManager)b.a(b.d.s.a.a.f(), TPIoTClientManager.class);
        j.d(localObject1, "tpIoTClientManager");
        localObject1 = ((TPIoTClientManager)localObject1).C1();
        j.d(localObject1, "tpIoTClientManager.allIoTDeviceLiveData");
        localObject1 = (List)((LiveData)localObject1).getValue();
        if (localObject1 == null) {
          localObject1 = kotlin.collections.l.d();
        }
        ArrayList localArrayList = new ArrayList();
        int i = 1;
        Iterator localIterator1 = paramAsyncResult.iterator();
        while (localIterator1.hasNext())
        {
          paramAsyncResult = (SmartLog)localIterator1.next();
          if (paramAsyncResult.getCode() != 0)
          {
            paramAsyncResult = paramAsyncResult.getActionSetting();
            Object localObject2 = null;
            if (paramAsyncResult != null) {
              paramAsyncResult = paramAsyncResult.getThing();
            } else {
              paramAsyncResult = null;
            }
            if (paramAsyncResult != null)
            {
              Iterator localIterator2 = ((Iterable)localObject1).iterator();
              BaseALIoTDevice localBaseALIoTDevice;
              do
              {
                localObject3 = localObject2;
                if (!localIterator2.hasNext()) {
                  break;
                }
                localObject3 = localIterator2.next();
                localBaseALIoTDevice = (BaseALIoTDevice)localObject3;
                j.d(localBaseALIoTDevice, "it");
              } while (!j.a(localBaseALIoTDevice.getDeviceId(), paramAsyncResult.getThingName()));
              Object localObject3 = (BaseALIoTDevice)localObject3;
              if (localObject3 != null)
              {
                paramAsyncResult = com.tplink.iot.Utils.z0.l.c(AppContext.c, (BaseALIoTDevice)localObject3);
              }
              else
              {
                paramAsyncResult = paramAsyncResult.getNickname();
                if (paramAsyncResult == null) {
                  paramAsyncResult = "";
                }
              }
              j.d(paramAsyncResult, "if (device != null) {\n  …                        }");
              localArrayList.add(paramAsyncResult);
            }
            i = 0;
          }
        }
        if (i != 0) {
          paramAsyncResult = new RunShortCutResultBean(paramString, 0);
        } else {
          paramAsyncResult = new RunShortCutResultBean(paramString, 0, localArrayList);
        }
        return paramAsyncResult;
      }
      return new RunShortCutResultBean(paramString, 0);
    }
    return new RunShortCutResultBean(paramString, paramAsyncResult.getCode());
  }
  
  public static final void e(Context paramContext, List<String> paramList, String paramString1, String paramString2)
  {
    j.e(paramList, "failedDeviceNames");
    j.e(paramString1, "title");
    j.e(paramString2, "content");
    if (paramContext != null)
    {
      paramContext = new ListContentDialog.Builder(paramContext).h(paramString1).b(paramString2).g(paramContext.getString(2131952441)).d(paramList).a();
      j.d(paramContext, "ListContentDialog.Builde…es)\n            .create()");
      paramContext.setCancelable(false);
      paramContext.show();
    }
  }
  
  public static final StateValueDataType f(String paramString)
  {
    if (paramString != null)
    {
      switch (paramString.hashCode())
      {
      default: 
        break;
      case 3556653: 
        if (!paramString.equals("text")) {
          break label169;
        }
        break;
      case 3327612: 
        if (!paramString.equals("long")) {
          break label169;
        }
        paramString = StateValueDataType.LONG;
        break;
      case 3118337: 
        if (!paramString.equals("enum")) {
          break label169;
        }
        paramString = StateValueDataType.STRING;
        break;
      case 3029738: 
        if (!paramString.equals("bool")) {
          break label169;
        }
        paramString = StateValueDataType.BOOL;
        break;
      case 104431: 
        if (!paramString.equals("int")) {
          break label169;
        }
        paramString = StateValueDataType.INT;
        break;
      }
      if (paramString.equals("double")) {
        return StateValueDataType.DOUBLE;
      }
    }
    label169:
    paramString = null;
    return paramString;
  }
  
  public static final class a
    extends com.google.gson.r.a<List<? extends SmartLog>>
  {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\smart\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */