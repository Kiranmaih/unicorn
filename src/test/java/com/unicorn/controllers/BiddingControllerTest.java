package com.unicorn.controllers;

import com.unicorn.domain.Unicorn;
import com.unicorn.jpa.UnicornRepo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(MockitoJUnitRunner.class)
class BiddingControllerTest {



    BiddingController controller = new BiddingController();

    @Mock
    UnicornRepo repo = Mockito.mock(UnicornRepo.class);



    @Test
    void createUnicorn() throws SQLException {
        ReflectionTestUtils.setField(controller,"unicornRepo",repo);
        Mockito.when(repo.insert(Mockito.any(Unicorn.class))).thenReturn(1);
        Unicorn unicorn = new Unicorn();
        controller.createUnicorn(unicorn);
        Mockito.verify(repo,Mockito.atLeastOnce()).insert(unicorn);
    }

    @Test
    void getUnicorn() {
    }

    @Test
    void getUnicorns() {
    }

    @Test
    void updateUnicorns() {
    }
}