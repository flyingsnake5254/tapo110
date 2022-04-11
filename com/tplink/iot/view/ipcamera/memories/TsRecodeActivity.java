package com.tplink.iot.view.ipcamera.memories;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.tplink.iot.base.BaseActivity;
import java.io.File;

@Deprecated
public class TsRecodeActivity
  extends BaseActivity
{
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558703);
    paramBundle = new StringBuilder();
    paramBundle.append(Environment.getExternalStorageDirectory().getAbsolutePath());
    paramBundle.append("/Download/segment-mp3.ts");
    paramBundle = paramBundle.toString();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Environment.getExternalStorageDirectory().getAbsolutePath());
    ((StringBuilder)localObject).append("/Download/result.mp4");
    localObject = ((StringBuilder)localObject).toString();
    findViewById(2131364300).setOnClickListener(new l(this, paramBundle, (String)localObject));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\memories\TsRecodeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */