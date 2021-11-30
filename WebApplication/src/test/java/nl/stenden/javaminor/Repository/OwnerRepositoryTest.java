package nl.stenden.javaminor.Repository;

import nl.stenden.javaminor.config.TestApplicationConfig;
import nl.stenden.javaminor.Model.Owner;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestApplicationConfig.class)
@Transactional
public class OwnerRepositoryTest {

    @Autowired
    private OwnerRepository ownerRepository;

    @Test
    public void testMethodGetOwnersResponse() {
        Collection<Owner> owners = ownerRepository.getOwners();
        assertThat(owners, null);
    }
}
