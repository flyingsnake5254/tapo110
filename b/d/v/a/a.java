package b.d.v.a;

import com.tplink.libtpappcommonmedia.bean.DeviceModel;
import com.tplink.libtpstreampreconnect.bean.BaseConnection;

public class a
  extends BaseConnection
{
  private boolean a;
  private int b;
  
  public a(String paramString, DeviceModel paramDeviceModel)
  {
    super(paramString, paramDeviceModel);
    this.mediaType = 2;
  }
  
  public a a()
  {
    a locala = new a(this.deviceIdMD5, this.deviceModel);
    locala.port = this.port;
    locala.ip = this.ip;
    locala.isLocal = this.isLocal;
    locala.portId = this.portId;
    locala.statistics = this.statistics;
    locala.url = this.url;
    locala.streamType = this.streamType;
    locala.audioType = this.audioType;
    locala.connectionType = this.connectionType;
    locala.createTime = this.createTime;
    locala.encryptType = this.encryptType;
    locala.relayTime = this.relayTime;
    locala.talkMode = this.talkMode;
    locala.bitStreamType = this.bitStreamType;
    return locala;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public void c(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void d(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public String toString()
  {
    int i = this.connectionType;
    if (256 == i) {
      str = "Local";
    } else if (16 == i) {
      str = "P2P";
    } else {
      str = "Relay";
    }
    Object localObject = str;
    if (this.statistics != null) {
      localObject = str.concat("\nstatistics : ").concat(this.statistics.toString());
    }
    String str = "\n".concat(this.deviceIdMD5).concat("\nport : ").concat(String.valueOf(this.port)).concat("\nisLocal : ").concat(String.valueOf(this.isLocal)).concat("\nconnectionType : ").concat((String)localObject).concat("\ncreateTime : ");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(this.createTime);
    return str.concat(((StringBuilder)localObject).toString()).concat("\nrelayTime : ").concat(String.valueOf(this.relayTime)).concat("\nresolution : ").concat("\ntalkMode : ").concat(this.talkMode);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\v\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */