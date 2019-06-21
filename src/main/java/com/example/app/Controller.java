package com.example.app;

import java.util.Map;

public interface Controller {
  String execute(Map<String, Object> model) throws Exception;
}
