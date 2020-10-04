package com.katanox.assessment.utils;

import org.json.JSONObject;

public class ResponseUtil {

  private ResponseUtil() {
    throw new IllegalStateException("Utility class");
  }

  public static String createJSONResponse(String response) {
    return new JSONObject().put("response", response).toString();
  }

  public static String createXMLResponse(String response) {
    StringBuilder xmlBuilder = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    xmlBuilder.append("<Response>").append("<Value>").append(response).append("</Value>");
    xmlBuilder.append("</Response>");
    xmlBuilder.toString();
    return xmlBuilder.toString();
  }
}
