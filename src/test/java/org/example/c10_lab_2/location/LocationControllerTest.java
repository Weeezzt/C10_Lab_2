package org.example.c10_lab_2.location;

import org.example.c10_lab_2.location.dto.LocationDto;
import org.example.c10_lab_2.security.Security;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = LocationController.class)
//@AutoConfigureMockMvc(addFilters = false)
@Import(Security.class)
@EnableMethodSecurity
public class LocationControllerTest {

    @MockBean
    private LocationService locationService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithAnonymousUser
    public void testGetAllPublicLocations() throws Exception {
        mockMvc.perform(get("/locations"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    @WithMockUser(username = "user", roles = "user")
    public void testGetUsersLocationsIfAuthenticated() throws Exception {
        mockMvc.perform(get("/locations/user/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testGetLocationById() throws Exception {
        when(locationService.getLocationsById(1)).thenReturn(List.of(
                new LocationDto("Test Location", "PUBLIC", "Description", null, 1, 1)
        ));

        mockMvc.perform(get("/locations/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[{\"name\":\"Test Location\",\"status\":\"PUBLIC\",\"description\":\"Description\",\"coordinate\":null,\"userId\":1,\"categoryId\":1}]"));

        verify(locationService).getLocationsById(1);
    }
}

