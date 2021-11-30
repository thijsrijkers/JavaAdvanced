package nl.stenden.javaminor.Repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import nl.stenden.javaminor.Model.Owner;
import nl.stenden.javaminor.config.TestApplicationConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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

    private Owner ownerTemp;

    @BeforeEach
    void setUp() {
        this.ownerTemp = new Owner();
        ownerTemp.setName("TobiasVanArkelen");
    }

    @Test
    @DisplayName("Testing if getOwners() returns a list of owners")
    public void testMethodGetOwners() {
        List<Owner> owners = ownerRepository.getOwners();
        assertNotNull(owners);
    }

    @Test
    @DisplayName("Testing if getOwner retrieves the right owner")
    public void testMethodGetOwner() {
        List<Owner> owner = ownerRepository.getOwner(1);
        assertEquals("tom", owner.get(0).getName());
    }

    @Test
    @DisplayName("Testing if postOwner has posted the right owner")
    public void testMethodPostOwner() {
        Owner owner = ownerRepository.postOwner(this.ownerTemp);
        assertEquals("TobiasVanArkelen", owner.getName());
    }

    @Test
    @DisplayName("Testing if putOwner changed the entry")
    public void testMethodPutOwner() {
        ownerRepository.putOwner(this.ownerTemp, 1);
        List<Owner> owner = ownerRepository.getOwner(1);
        assertEquals("TobiasVanArkelen", owner.get(0).getName());
    }

    @Test
    @DisplayName("Testing if deleteOwner works")
    public void testMethodDeleteOwner() {
        ownerRepository.deleteOwner(1);
    }

}
