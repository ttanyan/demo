package com.jimi.utils;

public enum SendType {

  SMS_CLIETENT("CLIENT"),

  SMS_HTTP("HTTP");

  /**发送方式*/
  private String SEND_TYPE;

  SendType(String SMS_TYPE) {
    this.SEND_TYPE = SMS_TYPE;
  }

  /**
   * Gets the value of SMS_TYPE.
   *
   * @return the value of SMS_TYPE
   */
  public String getSEND_TYPE() {
    return SEND_TYPE;
  }
}
