package dev.java10x.CadastroDeNinjas.User;

public class UserMapper {
    public static UserModel toUser(UserRequest userRequest) {
        return new UserModel(null, userRequest.name(), userRequest.email(), userRequest.password());
    }

    public static UserResponse toUserResponse(UserModel user) {
        return new UserResponse(user.getId(), user.getName(), user.getEmail());
    }
}
