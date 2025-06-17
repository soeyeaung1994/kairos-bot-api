package com.bank.kairos.entity;

import lombok.*;

import java.util.List;

/**
 * @Author: Soe Ye Aung
 * @Date: 13/6/25
 * @Time: 7:05 pm
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private String id;
    private String username;
    private String tenant;
    private List<String> roles;
}
