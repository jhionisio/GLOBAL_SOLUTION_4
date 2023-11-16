package life.assisten.forall.login.controller;

import life.assisten.forall.login.domain.Credencial;
import life.assisten.forall.login.domain.Token;
import life.assisten.forall.login.useCase.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final TokenService tokenService;

    @Autowired
    public AuthController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    @Secured("permitAll")
    public Token login(@RequestBody Credencial credencial) {
        return tokenService.generateToken(credencial);
    }
}
