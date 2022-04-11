package com.tplink.iot.e.a;

import android.app.Activity;
import com.tplink.iot.dailysummary.model.b;
import com.tplink.iot.dailysummary.network.bean.common.Summary;
import com.tplink.iot.dailysummary.network.bean.result.SummaryResult;
import com.tplink.iot.view.ipcamera.widget.calendar.d;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.l;
import kotlin.jvm.internal.j;

public final class a
{
  private static final ArrayList<String> a = l.c(new String[] { "", "JAN", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sept", "Oct", "Nov", "Dec" });
  
  public static final d a(String paramString)
  {
    j.e(paramString, "dateStr");
    if (paramString.length() >= 10)
    {
      int i = 0;
      int j = 0;
      int k = 0;
      while (j <= 3)
      {
        k = k * 10 + (paramString.charAt(j) - '0');
        j++;
      }
      int m = 5;
      j = 0;
      while (m <= 6)
      {
        j = j * 10 + (paramString.charAt(m) - '0');
        m++;
      }
      int n = 8;
      m = i;
      for (i = n; i <= 9; i++) {
        m = m * 10 + (paramString.charAt(i) - '0');
      }
      return new d(k, j, m);
    }
    throw new RuntimeException("datestrToOnedayinfo Exception: dateStr.length < 10");
  }
  
  public static final ArrayList<String> b()
  {
    return a;
  }
  
  public static final void c(Activity paramActivity, String paramString, boolean paramBoolean)
  {
    j.e(paramActivity, "activity");
    j.e(paramString, "msg");
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = -1;
    }
    TSnackbar.A(TSnackbar.r(paramActivity), paramString, i).N();
  }
  
  public static final b e(SummaryResult paramSummaryResult)
  {
    j.e(paramSummaryResult, "result");
    if (paramSummaryResult.getSummaryList().size() > 0)
    {
      Object localObject = paramSummaryResult.getSummaryList().get(0);
      j.d(localObject, "result.summaryList[0]");
      if (((Summary)localObject).getStatus() != -6)
      {
        localObject = (Summary)paramSummaryResult.getSummaryList().get(0);
        paramSummaryResult = paramSummaryResult.getDate();
        j.d(paramSummaryResult, "result.date");
        j.d(localObject, "resultData");
        int i = ((Summary)localObject).getStatus();
        String str = ((Summary)localObject).getUuid();
        int j = ((Summary)localObject).getClipSize();
        return new b(paramSummaryResult, i, str, ((Summary)localObject).getImage(), j, false, false, 96, null);
      }
    }
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\e\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */