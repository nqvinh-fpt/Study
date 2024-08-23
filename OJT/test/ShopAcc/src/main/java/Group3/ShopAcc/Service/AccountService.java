package Group3.ShopAcc.Service;

import Group3.ShopAcc.Dto.AccountDto;
import Group3.ShopAcc.Dto.CredientalDto;
import Group3.ShopAcc.Dto.SignUpDto;
import Group3.ShopAcc.Entity.Account;
import Group3.ShopAcc.Exceptions.AppException;
import Group3.ShopAcc.Mappers.AccountMapper;
import Group3.ShopAcc.Repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AccountService{
    @Autowired
    private AccountRepository accountRepository;
    private final AccountMapper accountMapper;
    private final PasswordEncoder passwordEncoder;
    public AccountDto findByLogin(String username) {
        Account account = accountRepository.findByUsername(username)
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));
        return accountMapper.toAccountDto(account);
    }
    public AccountDto login(CredientalDto credientalDto){
        Account account = accountRepository.findByUsername(credientalDto.getLogin())
                .orElseThrow(()->new AppException("Unknown user", HttpStatus.NOT_FOUND));
        if(passwordEncoder.matches(CharBuffer.wrap(credientalDto.getPassword()),account.getPassword())){
            return accountMapper.toAccountDto(account);
        }
        throw new AppException("Invalid password",HttpStatus.BAD_REQUEST);
    }
    public AccountDto register(SignUpDto accountDto){
        Optional<Account> optionalAccount = accountRepository.findByUsername(accountDto.getLogin());
        if(optionalAccount.isPresent()){
            throw new AppException("Login already exist", HttpStatus.BAD_REQUEST);
        }
        Account account = accountMapper.signUpToAccount(accountDto);
        account.setPassword(passwordEncoder.encode(CharBuffer.wrap(accountDto.getPassword())));
        Account savedAccount = accountRepository.save(account);
        return accountMapper.toAccountDto(account);
    }
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        List<Account> accounts = accountRepository.findByUsername(username);
//        String password = null;
//        List<GrantedAuthority> authorities = null;
//        if(accounts.isEmpty()){
//            throw new UsernameNotFoundException("Account not found");
//        }
//        username = accounts.get(0).getUsername();
//        password = accounts.get(0).getPassword();
//        authorities = new ArrayList<>();
//        authorities.add(new SimpleGrantedAuthority(String.valueOf(accounts.get(0).getRoleID())));
//        return new User(username,password,authorities);
//    }
}
