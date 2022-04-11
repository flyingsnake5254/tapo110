package com.tplink.iot.Utils;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;

public class ImageTPMaterialDialogV2
  extends AlertDialog
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558797);
    findViewById(2131364625).setOnClickListener(new a());
    findViewById(2131364359).setOnClickListener(new b());
  }
  
  class a
    implements View.OnClickListener
  {
    a() {}
    
    public void onClick(View paramView)
    {
      paramView = new StringBuilder();
      paramView.append("package:");
      paramView.append(ImageTPMaterialDialogV2.this.getContext().getPackageName());
      paramView = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse(paramView.toString()));
      ImageTPMaterialDialogV2.this.getContext().startActivity(paramView);
    }
  }
  
  class b
    implements View.OnClickListener
  {
    b() {}
    
    public void onClick(View paramView)
    {
      ImageTPMaterialDialogV2.this.dismiss();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\ImageTPMaterialDialogV2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */