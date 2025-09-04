package com.tutorial.demo.exceptions;

public class UserAlreadyExist extends RuntimeException {
  public UserAlreadyExist(String message) {
    super(message);
  }
}
