package com.manager.classroom_manager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T>
{
  private Integer code;
  private String message;
  private T data;
  
  public static<T> Result<T> success(T data)
  {
    return message(200, "success", data);
  }
  
  public static<T> Result<T> error(String message)
  {
    return message(500, message, null);
  }
  
  public static <T> Result<T> message(Integer code, String message, T data)
  {
    return new Result<>(code, message, data);
  }
}
