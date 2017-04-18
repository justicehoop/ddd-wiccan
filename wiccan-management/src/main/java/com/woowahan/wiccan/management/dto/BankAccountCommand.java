package com.woowahan.wiccan.management.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by justicehoop on 2017. 4. 18..
 */
@Getter
@Setter
@NoArgsConstructor
public class BankAccountCommand {
    private String bankName;
    private String bankOwnerName;
    private String birthday;
    private String accountNumber;
}
