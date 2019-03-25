package com.example.sweater.database.Service;

import com.example.sweater.database.entities.Role;
import com.example.sweater.database.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.sweater.database.repos.UsersRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class UsersService implements UserDetailsService {
    @Autowired
    UsersRepo usersRepo;

    @Autowired
    MailSender mailSender;

    @Autowired
    PasswordEncoder encoder;

    void delete (long id) {
        usersRepo.deleteById(id);
    }

    void editUsers(Long id, String username){
        Users users = usersRepo.getOne(id);
        users.setUsersurname(username);
        usersRepo.saveAndFlush(users);
    }
    void editUsers10(Long id, String usersurname){
        Users users = usersRepo.getOne(id);
        users.setUsersurname(usersurname);
        usersRepo.saveAndFlush(users);
    }
    void editUsers2(Long id, String name){
        Users users = usersRepo.getOne(id);
        users.setName(name);
        usersRepo.saveAndFlush(users);
    }
    void editUsers3(Long id, String usercountry){
        Users users = usersRepo.getOne(id);
        users.setUsercountry(usercountry);
        usersRepo.saveAndFlush(users);
    }
    void editUsers5(Long id, String useremail){
        Users users = usersRepo.getOne(id);
        users.setUseremail(useremail);
        usersRepo.saveAndFlush(users);
    }


    public boolean addUser(Users user) {
        Users userFromDb = usersRepo.findByUsername(user.getUsername());

        if (userFromDb != null) {
            return false;
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        user.setActivationCode(UUID.randomUUID().toString());
        user.setPassword(encoder.encode(user.getPassword()));
        usersRepo.save(user);

        sendMessage(user);

        return true;
    }

    private void sendMessage(Users user) {
        if (!StringUtils.isEmpty(user.getUseremail())) {
            String message = String.format(
                    "Hello, %s! \n" +
                            "Welcome to Sweater. Please, visit next link: http://localhost:8080/activate/%s",
                    user.getUsername(),
                    user.getActivationCode()
            );

            mailSender.send(user.getUseremail(), "Activation code", message);
        }
    }

    public boolean activateUser(String code) {
        Users user = usersRepo.findByActivationCode(code);

        if (user == null) {
            return false;
        }

        user.setActivationCode(null);

        usersRepo.save(user);

        return true;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       return usersRepo.findByUsername(username);
    }
}

