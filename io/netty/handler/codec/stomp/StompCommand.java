package io.netty.handler.codec.stomp;

public enum StompCommand
{
  static
  {
    StompCommand localStompCommand1 = new StompCommand("STOMP", 0);
    STOMP = localStompCommand1;
    StompCommand localStompCommand2 = new StompCommand("CONNECT", 1);
    CONNECT = localStompCommand2;
    StompCommand localStompCommand3 = new StompCommand("CONNECTED", 2);
    CONNECTED = localStompCommand3;
    StompCommand localStompCommand4 = new StompCommand("SEND", 3);
    SEND = localStompCommand4;
    StompCommand localStompCommand5 = new StompCommand("SUBSCRIBE", 4);
    SUBSCRIBE = localStompCommand5;
    StompCommand localStompCommand6 = new StompCommand("UNSUBSCRIBE", 5);
    UNSUBSCRIBE = localStompCommand6;
    StompCommand localStompCommand7 = new StompCommand("ACK", 6);
    ACK = localStompCommand7;
    StompCommand localStompCommand8 = new StompCommand("NACK", 7);
    NACK = localStompCommand8;
    StompCommand localStompCommand9 = new StompCommand("BEGIN", 8);
    BEGIN = localStompCommand9;
    StompCommand localStompCommand10 = new StompCommand("DISCONNECT", 9);
    DISCONNECT = localStompCommand10;
    StompCommand localStompCommand11 = new StompCommand("MESSAGE", 10);
    MESSAGE = localStompCommand11;
    StompCommand localStompCommand12 = new StompCommand("RECEIPT", 11);
    RECEIPT = localStompCommand12;
    StompCommand localStompCommand13 = new StompCommand("ERROR", 12);
    ERROR = localStompCommand13;
    StompCommand localStompCommand14 = new StompCommand("UNKNOWN", 13);
    UNKNOWN = localStompCommand14;
    $VALUES = new StompCommand[] { localStompCommand1, localStompCommand2, localStompCommand3, localStompCommand4, localStompCommand5, localStompCommand6, localStompCommand7, localStompCommand8, localStompCommand9, localStompCommand10, localStompCommand11, localStompCommand12, localStompCommand13, localStompCommand14 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\stomp\StompCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */