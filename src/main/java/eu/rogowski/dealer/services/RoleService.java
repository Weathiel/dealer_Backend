package eu.rogowski.dealer.services;

import eu.rogowski.dealer.models.Role;
import eu.rogowski.dealer.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getRolesNames(){
        return roleRepository.findAll();
    }
}
