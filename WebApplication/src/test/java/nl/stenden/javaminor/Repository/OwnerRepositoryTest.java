package nl.stenden.javaminor.Repository;

import nl.stenden.javaminor.Model.Owner;
import nl.stenden.javaminor.config.TestApplicationConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static java.lang.System.in;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestApplicationConfig.class)
@Transactional
public class OwnerRepositoryTest {

    @Autowired
    private OwnerRepository ownerRepository;

    @Test
    public void testMethodGetOwners() {
        List<Owner> owners = ownerRepository.getOwners();
        System.out.println("=========================");
        for (Owner owner : owners)
        {
            System.out.println(owner.getName());
        }
        System.out.println("=========================");
        assertNotNull(owners);
    }

    @Test
    public void testMethodGetOwner() {
        List<Owner> owner = ownerRepository.getOwner(1);
        System.out.println("=========================");
        System.out.println(owner.get(0).getName());
        System.out.println("=========================");
        assertNotNull(owner);
    }
}
