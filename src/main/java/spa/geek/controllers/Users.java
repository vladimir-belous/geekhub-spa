package spa.geek.controllers;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import spa.geek.dtos.UserDto;
import spa.geek.entities.User;
import spa.geek.repositories.UserRepository;

import javax.inject.Inject;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author vladimirb
 * @since 3/4/15.
 */
@RestController
@RequestMapping("/users")
public class Users {

    private final MapperFacade mapper;

    {
        final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(User.class, UserDto.class)
                .byDefault()
                .register();
        mapper = mapperFactory.getMapperFacade();
    }

    @Inject
    private UserRepository userRepo;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UserDto get(@PathVariable Integer id) {
        return mapper.map(userRepo.getOne(id), UserDto.class);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<UserDto> list() {
        return mapper.mapAsList(userRepo.findAll(), UserDto.class);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void create(@RequestBody UserDto dto) {
        userRepo.save(mapper.map(dto, User.class));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable Integer id, @RequestBody UserDto dto) {
        User user = userRepo.getOne(id);
        checkNotNull(user);

        mapper.map(dto, user);
        user.setId(id);
        userRepo.save(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        userRepo.delete(id);
    }

}
