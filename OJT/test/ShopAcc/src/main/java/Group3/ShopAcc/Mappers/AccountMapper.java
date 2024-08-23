package Group3.ShopAcc.Mappers;

import Group3.ShopAcc.Dto.AccountDto;
import Group3.ShopAcc.Dto.SignUpDto;
import Group3.ShopAcc.Entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "Spring")
public interface AccountMapper {
    public AccountDto toAccountDto(Account account);
@Mapping(target = "password", ignore = true)
    Account signUpToAccount(SignUpDto accountDto);
}
