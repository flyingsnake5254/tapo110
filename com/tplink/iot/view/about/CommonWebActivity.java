package com.tplink.iot.view.about;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.webkit.JavascriptInterface;
import b.d.w.f.a;
import com.tplink.iot.model.about.d;
import org.json.JSONException;
import org.json.JSONObject;

public class CommonWebActivity
  extends AbsCommonWebActivity
{
  public static void s1(Activity paramActivity, String paramString1, String paramString2)
  {
    a.g(paramActivity);
    Intent localIntent = new Intent(paramActivity, CommonWebActivity.class);
    localIntent.putExtra("toolbar_title", paramString1);
    localIntent.putExtra("url", paramString2);
    paramActivity.startActivityForResult(localIntent, 1011);
    paramActivity.overridePendingTransition(2130772068, 2130772067);
  }
  
  public Object n1()
  {
    return new a();
  }
  
  public String o1()
  {
    return "uploadDeviceInfo";
  }
  
  public class a
  {
    public a() {}
    
    @JavascriptInterface
    public void backToApp()
    {
      CommonWebActivity.this.finish();
    }
    
    @JavascriptInterface
    public String getAppParameters()
    {
      return d.d(CommonWebActivity.this);
    }
    
    @JavascriptInterface
    public void postMessage(String paramString)
    {
      if (paramString != null) {
        try
        {
          Object localObject = new org/json/JSONObject;
          ((JSONObject)localObject).<init>(paramString);
          paramString = ((JSONObject)localObject).getString("message");
          if (paramString != null)
          {
            int i = -1;
            int j = paramString.hashCode();
            if (j != -1357520532)
            {
              if ((j == 348678395) && (paramString.equals("submitted"))) {
                i = 0;
              }
            }
            else if (paramString.equals("closed")) {
              i = 1;
            }
            if (i == 1)
            {
              paramString = CommonWebActivity.r1(CommonWebActivity.this);
              localObject = new com/tplink/iot/view/about/CommonWebActivity$a$a;
              ((a)localObject).<init>(this);
              paramString.postDelayed((Runnable)localObject, 500L);
            }
          }
        }
        catch (JSONException paramString)
        {
          paramString.printStackTrace();
        }
      }
    }
    
    class a
      implements Runnable
    {
      a() {}
      
      public void run()
      {
        CommonWebActivity.this.finish();
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\about\CommonWebActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */