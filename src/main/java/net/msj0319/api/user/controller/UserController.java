package net.msj0319.api.user.controller;

import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import net.msj0319.api.user.domain.User;
import net.msj0319.api.user.domain.UserDto;
import net.msj0319.api.user.service.UserServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Api(tags = "users") @RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserServiceImpl userService;
    private final ModelMapper modelMapper;

    @PostMapping("/signup")
    @ApiOperation(value = "${UserController.signup}")
    @ApiResponses(value={
            @ApiResponse(code=400, message = "something wrong"),
            @ApiResponse(code=403, message = "승인거절"),
            @ApiResponse(code=422, message = "중복된 username")})

    public ResponseEntity<String> signup(@ApiParam("Signup User")
                                         @RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.signup(modelMapper.map(userDto, User.class)));
    }

    @PostMapping("/signin")
    @ApiOperation(value = "${UserController.signin}")
    @ApiResponses(value={
            @ApiResponse(code=400, message = "something wrong"),
            @ApiResponse(code=422, message = "유효하지 않은 아이디/비밀번호")})

    public ResponseEntity<UserDto> signin(@ApiParam("Signin User")
                                         @RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.signin(modelMapper.map(userDto, User.class)));
    }


    public List<User> findAll() {
        return null;
    }

    public Optional<User> findById(@PathVariable long id) {
        return Optional.empty();
    }

    public void save(User user) {

    }
    public void update(User user){

    }

    public boolean existsById(long id) {
        return false;
    }

    public long count() {
        return 0;
    }

    public void deleteById(long id) {

    }

}
