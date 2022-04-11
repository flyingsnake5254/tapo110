package com.tplink.iot.view.voice;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.appcompat.app.AppCompatActivity;
import com.tplink.iot.Utils.x0.q;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.model.about.d;
import com.tplink.iot.view.about.CommonWebActivity;
import com.tplink.iot.view.authflip.GoogleAssistantActivity;
import com.tplink.iot.view.wss.WssAlexaActivity;
import com.tplink.libtpnetwork.Utils.x;

public class VoiceControlActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private View y;
  private View z;
  
  public void onClick(View paramView)
  {
    Object localObject;
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131364641: 
      paramView = getResources().getString(2131953675);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("https://www.tapo.com/app/#/guidance/smartThings?locale=");
      ((StringBuilder)localObject).append(d.f());
      CommonWebActivity.s1(this, paramView, ((StringBuilder)localObject).toString());
      q.t();
      break;
    case 2131364524: 
      paramView = getResources().getString(2131953018);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("https://www.tapo.com/app/#/guidance/mailRu?locale=");
      ((StringBuilder)localObject).append(d.f());
      CommonWebActivity.s1(this, paramView, ((StringBuilder)localObject).toString());
      q.l();
      break;
    case 2131364464: 
      W0(GoogleAssistantActivity.class);
      q.k();
      break;
    case 2131364341: 
      W0(WssAlexaActivity.class);
      q.c();
      break;
    case 2131364338: 
      localObject = getResources().getString(2131954523);
      paramView = new StringBuilder();
      paramView.append("https://www.tapo.com/app/#/guidance/alice?locale=");
      paramView.append(d.f());
      CommonWebActivity.s1(this, (String)localObject, paramView.toString());
      q.b();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558709);
    b1(2131952604);
    findViewById(2131364464).setOnClickListener(this);
    findViewById(2131364341).setOnClickListener(this);
    findViewById(2131364338).setOnClickListener(this);
    findViewById(2131364641).setOnClickListener(this);
    findViewById(2131364524).setOnClickListener(this);
    this.y = findViewById(2131363257);
    this.z = findViewById(2131363308);
  }
  
  protected void onStart()
  {
    super.onStart();
    View localView = this.y;
    boolean bool = x.a();
    int i = 0;
    int j;
    if (bool) {
      j = 0;
    } else {
      j = 8;
    }
    localView.setVisibility(j);
    localView = this.z;
    if (x.a()) {
      j = i;
    } else {
      j = 8;
    }
    localView.setVisibility(j);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\voice\VoiceControlActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */