package com.tplink.libtpmediastatistics;

public class ConnectionInfoVO
{
  private BasicVO connectionBasicVO;
  private ConnectionVO localConnectionVO;
  private ConnectionVO p2pConnectionVO;
  private ConnectionVO relayConnectionVO;
  
  public BasicVO getConnectionBasicVO()
  {
    return this.connectionBasicVO;
  }
  
  public ConnectionVO getLocalConnectionVO()
  {
    if (this.localConnectionVO == null) {
      this.localConnectionVO = new ConnectionVO();
    }
    return this.localConnectionVO;
  }
  
  public ConnectionVO getP2pConnectionVO()
  {
    if (this.p2pConnectionVO == null) {
      this.p2pConnectionVO = new ConnectionVO();
    }
    return this.p2pConnectionVO;
  }
  
  public ConnectionVO getRelayConnectionVO()
  {
    if (this.relayConnectionVO == null) {
      this.relayConnectionVO = new ConnectionVO();
    }
    return this.relayConnectionVO;
  }
  
  public void setConnectionBasicVO(BasicVO paramBasicVO)
  {
    this.connectionBasicVO = paramBasicVO;
  }
  
  public void setLocalConnectionVO(ConnectionVO paramConnectionVO)
  {
    this.localConnectionVO = paramConnectionVO;
  }
  
  public void setP2pConnectionVO(ConnectionVO paramConnectionVO)
  {
    this.p2pConnectionVO = paramConnectionVO;
  }
  
  public void setRelayConnectionVO(ConnectionVO paramConnectionVO)
  {
    this.relayConnectionVO = paramConnectionVO;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ConnectionInfoVO{connectionBasicVO=");
    localStringBuilder.append(this.connectionBasicVO);
    localStringBuilder.append(", p2pConnectionVO=");
    localStringBuilder.append(this.p2pConnectionVO);
    localStringBuilder.append(", relayConnectionVO=");
    localStringBuilder.append(this.relayConnectionVO);
    localStringBuilder.append(", localConnectionVO=");
    localStringBuilder.append(this.localConnectionVO);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpmediastatistics\ConnectionInfoVO.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */