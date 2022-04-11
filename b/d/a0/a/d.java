package b.d.a0.a;

import com.tplink.libtpappcommonmedia.bean.DeviceModel;
import com.tplink.libtpstreampreconnect.bean.BaseConnection;

public class d
  extends BaseConnection
{
  public d(String paramString, DeviceModel paramDeviceModel)
  {
    super(paramString, paramDeviceModel);
    this.mediaType = 1;
    this.streamType = 1;
  }
  
  public d a()
  {
    d locald = new d(this.deviceIdMD5, this.deviceModel);
    locald.isLocal = this.isLocal;
    locald.portId = this.portId;
    locald.statistics = this.statistics;
    locald.url = this.url;
    locald.audioType = this.audioType;
    locald.connectionType = this.connectionType;
    locald.createTime = this.createTime;
    locald.encryptType = this.encryptType;
    locald.relayTime = this.relayTime;
    locald.bitStreamType = this.bitStreamType;
    return locald;
  }
  
  public String toString()
  {
    int i = this.streamType;
    if (1 == i) {
      localObject1 = "MIXED";
    } else if (3 == i) {
      localObject1 = "DUAL VIDEO";
    } else {
      localObject1 = "DUAL AUDIO";
    }
    i = this.connectionType;
    if (256 == i) {
      localObject2 = "Local";
    } else if (16 == i) {
      localObject2 = "P2P";
    } else {
      localObject2 = "Relay";
    }
    Object localObject3 = localObject2;
    if (this.statistics != null) {
      localObject3 = ((String)localObject2).concat("\nstatistics : ").concat(this.statistics.toString());
    }
    String str1 = "\n".concat(this.deviceIdMD5).concat("\nisLocal : ").concat(String.valueOf(this.isLocal)).concat("\nurl : ");
    Object localObject2 = this.url;
    String str2 = "";
    if (localObject2 == null) {
      localObject2 = "";
    }
    localObject2 = str1.concat((String)localObject2).concat("\nstreamType : ").concat((String)localObject1).concat("\nconnectionType : ").concat((String)localObject3).concat("\ncreateTime : ");
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append(this.createTime);
    localObject3 = ((String)localObject2).concat(((StringBuilder)localObject1).toString()).concat("\nencryptType : ");
    localObject1 = this.encryptType;
    localObject2 = str2;
    if (localObject1 != null) {
      localObject2 = localObject1;
    }
    return ((String)localObject3).concat(String.valueOf(localObject2)).concat("\nrelayTime : ").concat(String.valueOf(this.relayTime)).concat("\nresolution : ");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\a0\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */