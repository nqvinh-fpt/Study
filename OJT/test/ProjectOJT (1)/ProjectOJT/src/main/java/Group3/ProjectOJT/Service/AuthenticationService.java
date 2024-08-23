package Group3.ProjectOJT.Service;

import Group3.ProjectOJT.Dto.JwtAuthenticationResponse;
import Group3.ProjectOJT.Dto.RefreshTokenRequest;
import Group3.ProjectOJT.Dto.SignUpRequest;
import Group3.ProjectOJT.Dto.SigninRequest;
import Group3.ProjectOJT.Entities.Account;

public interface AuthenticationService {
    Account signup(SignUpRequest signUpRequest);
    JwtAuthenticationResponse signin(SigninRequest signinRequest);
    JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
