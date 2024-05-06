package com.capstone.mobilestore.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.capstone.mobilestore.entity.Mobile;
import com.capstone.mobilestore.repository.MobileRepository;
import com.capstone.mobilestore.service.MobileServiceImpl;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@SpringBootTest(properties = "eureka.client.enabled=false")
public class MobileServiceTest {

    @Mock
    private MobileRepository mobileRepository;

    @InjectMocks
    private MobileServiceImpl mobileService;

    @Test
    void testFindAllMobiles() {
        List<Mobile> expectedMobiles = new ArrayList<>();
        expectedMobiles.add(new Mobile());
        expectedMobiles.add(new Mobile());

        when(mobileRepository.findAll()).thenReturn(expectedMobiles);

        List<Mobile> result = mobileService.findAllMobiles();
        assertEquals(expectedMobiles.size(), result.size());
    }

   

    @Test
    void testSaveMobile() {
        Mobile mobile = new Mobile();
        mobile.setId(1);
        mobile.setBrand("Iphonex");
        mobile.setModel("15Pro");
        mobile.setPrice(90000);
		when(mobileRepository.save(mobile)).thenReturn(mobile);


        Mobile savedMobile = mobileService.saveMobile(mobile);

		verify(mobileRepository, times(1)).save(mobile);

		assertNotNull(savedMobile);

		assertEquals(mobile.getId(), savedMobile.getId());
		assertEquals(mobile.getBrand(), savedMobile.getBrand());
		assertEquals(mobile.getModel(),savedMobile.getModel());
		assertEquals(mobile.getPrice(),savedMobile.getPrice());
		
	
    }

    @Test
    void testDeleteMobile() {
        Long id = 1L;
        Mobile existingMobile = new Mobile();
        existingMobile.setId(1L);

        Mobile updatedMobile = new Mobile();
        updatedMobile.setId(1L);
        updatedMobile.setBrand("Iphonex");
        
        
        when(mobileRepository.findById(1L)).thenReturn(Optional.of(existingMobile));

		doNothing().when(mobileRepository).delete(existingMobile);

		mobileService.deleteMobile(1L);

		verify(mobileRepository, times(1)).findById(1L);
		verify(mobileRepository, times(1)).delete(existingMobile);
    }
//
//    @Test
//    void testUpdateMobile() {
//        Long id = 1L;
//        Mobile existingMobile = new Mobile();
//        existingMobile.setId(1L);
//
//        Mobile updatedMobile = new Mobile();
//        updatedMobile.setId(1L);
//        updatedMobile.setBrand("Iphonex");
//
//        
//    }

    @Test
    void testSearchMobilesByBrand() {
        String brand = "Samsung";
        List<Mobile> expectedMobiles = new ArrayList<>();
        expectedMobiles.add(new Mobile());
        expectedMobiles.add(new Mobile());

        when(mobileRepository.searchByBrand(brand)).thenReturn(expectedMobiles);

        List<Mobile> result = mobileService.searchMobilesByBrand(brand);
        assertEquals(expectedMobiles.size(), result.size());
    }

    @Test
    void testSearchMobilesByModel() {
        String model = "Galaxy";
        List<Mobile> expectedMobiles = new ArrayList<>();
        expectedMobiles.add(new Mobile());
        expectedMobiles.add(new Mobile());

        when(mobileRepository.searchByModel(model)).thenReturn(expectedMobiles);

        List<Mobile> result = mobileService.searchMobilesByModel(model);
        assertEquals(expectedMobiles.size(), result.size());
    }

//    @Test
//    void testSearchMobilesByPriceRange() {
//        Double priceMin = 100.0;
//        Double priceMax = 9000000.0;
//        List<Mobile> expectedMobiles = new ArrayList<>();
//        expectedMobiles.add(new Mobile());
//        expectedMobiles.add(new Mobile());
//
//        when(mobileRepository.findByPriceBetween(priceMin, priceMax)).thenReturn(expectedMobiles);
//
//        List<Mobile> result = mobileService.searchMobilesByPriceRange(priceMin, priceMax);
//        assertEquals(expectedMobiles.size(), result.size());
//    }
}