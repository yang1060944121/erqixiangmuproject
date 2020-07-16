package com.aaa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigInteger;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class MenuInfo {
    private BigInteger menu_id;
    private BigInteger parent_id;

}
