package ru.skypro.homework.service;

import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.ad.Ad;
import ru.skypro.homework.dto.ad.CreateOrUpdateAd;
import ru.skypro.homework.dto.ad.ExtendedAd;
import ru.skypro.homework.entity.Ads;

import java.io.IOException;


public interface AdsService {

    
    Ad createAds(CreateOrUpdateAd createAd, MultipartFile image, Authentication authentication)
            throws IOException;

    
    ExtendedAd getExtendedAd(Integer id, Authentication authentication);

    
    ru.skypro.homework.dto.ad.Ads getAdsDto();

    
    void deleteAd(Integer id, Authentication authentication);

    
    Ad updateAd(Integer id, CreateOrUpdateAd adDto, Authentication authentication);

    
    ru.skypro.homework.dto.ad.Ads getAdsByUser(Authentication authentication);

    
    void updateImage(Integer id, MultipartFile image, Authentication authentication)
            throws IOException;

    
    Boolean foundById(Integer id);

    
    Ads findById(Integer id);
}