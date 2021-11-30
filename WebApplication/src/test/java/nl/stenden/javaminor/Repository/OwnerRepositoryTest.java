package nl.stenden.javaminor.Repository;

import nl.stenden.javaminor.Model.Owner;
import nl.stenden.javaminor.config.TestApplicationConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestApplicationConfig.class)
@Transactional
public class OwnerRepositoryTest {

    @Autowired
    private OwnerRepository ownerRepository;

    @Test
    public void testMethodGetOwnersResponse() {
        Collection<Owner> owners = ownerRepository.getOwners();
        System.out.println("==========================");
        System.out.println(owners);
        System.out.println("==========================");
    }
}
