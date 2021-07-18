package com.dio.personapi.presentation.viewmodel;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class PhoneViewModel {
  private Long id;
  private String type;
  private String number;

  public String getType() {
    return this.type != null ? this.type.toLowerCase() : this.type;
  }
}
