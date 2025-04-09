package cl.sanitas.application.usecase;

import cl.sanitas.application.port.UserRepository;
import cl.sanitas.domain.model.User;

public class CrearUsuarioUseCase {

    private final UserRepository userRepository;

    public CrearUsuarioUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User crearUsuario(User user) {
        return userRepository.save(user);
    }
}

