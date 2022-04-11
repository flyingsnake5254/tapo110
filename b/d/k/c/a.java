package b.d.k.c;

import com.tplink.libtpgoogleassistant.bean.params.AuthClientListParams;
import com.tplink.libtpgoogleassistant.bean.params.AuthCodeParams;
import com.tplink.libtpgoogleassistant.bean.result.AuthCodeResult;
import com.tplink.libtpgoogleassistant.bean.result.AuthResult;
import com.tplink.libtpgoogleassistant.bean.result.AuthValidClientList;
import io.reactivex.q;
import retrofit2.x.o;

public abstract interface a
{
  @o("oauth2/api/getAuthCode")
  public abstract q<AuthResult<AuthCodeResult>> a(@retrofit2.x.a AuthCodeParams paramAuthCodeParams);
  
  @o("oauth2/api/getValidClientList")
  public abstract q<AuthResult<AuthValidClientList>> b(@retrofit2.x.a AuthClientListParams paramAuthClientListParams);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\k\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */