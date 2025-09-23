package br.com.alepedidos.domain.service;

import br.com.alepedidos.application.request.user.UserRequest;
import br.com.alepedidos.application.response.user.UserResponse;
import br.com.alepedidos.domain.exception.ConflictException;
import br.com.alepedidos.domain.model.RoleModel;
import br.com.alepedidos.domain.model.UserModel;
import br.com.alepedidos.infrastructure.repository.RoleRepository;
import br.com.alepedidos.infrastructure.repository.UserRepository;
import br.com.alepedidos.utils.GenericMapper;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService implements IUserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final GenericMapper mapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponse createUser(UserRequest request) {
        if (userRepository.existsByCpfOrEmail(request.email(),
                request.cpf())) {
            throw new ConflictException("Usuário já cadastrado na base de dados.");
        }
        var user = mapper.map(request,
                UserModel.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        var userModel = userRepository.save(user);

        List<RoleModel> role = mapper.mapAll(request.roles(),
                RoleModel.class);
        List<RoleModel> r = role.stream()
                .map(element -> {
                    element.setUser(userModel);
                    return element;
                })
                .toList();

        roleRepository.saveAll(r);

        return mapper.map(userModel,
                UserResponse.class);
    }
}
