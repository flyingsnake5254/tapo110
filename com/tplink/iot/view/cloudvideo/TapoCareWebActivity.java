package com.tplink.iot.view.cloudvideo;

import android.os.Handler;
import android.webkit.JavascriptInterface;
import com.tplink.iot.view.about.AbsCommonWebActivity;
import org.json.JSONException;
import org.json.JSONObject;

public class TapoCareWebActivity
  extends AbsCommonWebActivity
{
  public Object n1()
  {
    return new a();
  }
  
  public String o1()
  {
    return "backToApp";
  }
  
  public class a
  {
    public a() {}
    
    @JavascriptInterface
    public void postMessage(String paramString)
    {
      if (paramString != null) {
        try
        {
          Object localObject = new org/json/JSONObject;
          ((JSONObject)localObject).<init>(paramString);
          paramString = ((JSONObject)localObject).getString("message");
          if ((paramString != null) && ("done".equals(paramString)))
          {
            localObject = TapoCareWebActivity.r1(TapoCareWebActivity.this);
            paramString = new com/tplink/iot/view/cloudvideo/n;
            paramString.<init>(this);
            ((Handler)localObject).postDelayed(paramString, 500L);
          }
        }
        catch (JSONException paramString)
        {
          paramString.printStackTrace();
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\cloudvideo\TapoCareWebActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */