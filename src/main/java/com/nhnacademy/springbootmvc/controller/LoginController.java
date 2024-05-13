package com.nhnacademy.springbootmvc.controller;

import com.nhnacademy.springbootmvc.repository.UserRepository;

// TODO #1: Controller로 만드세요.
public class LoginController {
    private final UserRepository userRepository;

    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    // TODO #2: `GET /login` 요청을 처리하세요.
    //          `SESSION` 이라는 쿠키가 있으면 로그인 완료 메세지 출력 (`loginSuccess.html`).
    //          `SESSION` 이라는 쿠키가 없으면 로그인 폼 화면 출력 (`loginForm.html`).
    public String login() {
        return null;
    }

    // TODO #3: `POST /login` 요청을 처리하세요.
    //          `userRepository.matches(id, password)` 메서드 이용.
    //          로그인 성공 시 `SESSION` 쿠키에 session id 값 저장하고
    //          모델을 이용해서 `loginSuccess.html`에 세션 아이디 전달.
    //          로그인 실패 시 `/login`으로 redirect.
    public String doLogin() {
        return null;
    }

}
