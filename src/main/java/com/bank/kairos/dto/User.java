package com.bank.kairos.dto;

import com.bank.kairos.enums.AccessRole;
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
    private Long id;
    private String displayedName;
    private String username;
    private String email;
    private AccessRole accessRole;
    private List<String> tenants;
    private String selectedTenant;
}
