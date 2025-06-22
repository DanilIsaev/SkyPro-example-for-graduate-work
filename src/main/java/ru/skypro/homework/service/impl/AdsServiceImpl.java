package ru.skypro.homework.service.impl;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.ad.Ad;
import ru.skypro.homework.dto.ad.CreateOrUpdateAd;
import ru.skypro.homework.dto.ad.ExtendedAd;
import ru.skypro.homework.entity.Ads;
import ru.skypro.homework.entity.UserEntity;
import ru.skypro.homework.repository.AdRepository;
import ru.skypro.homework.repository.UserEntityRepository;
import ru.skypro.homework.service.AdsService;
import ru.skypro.homework.utils.AdServiceUtils;
import ru.skypro.homework.utils.ImageMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdsServiceImpl implements AdsService {

    private final AdRepository adRepository;
    private final UserEntityRepository userRepository;
    private final AdServiceUtils adUtils;

    private final Logger logger = LoggerFactory.getLogger(AdsServiceImpl.class);

    @Override
    public Ad createAds(CreateOrUpdateAd createAd, MultipartFile image, Authentication authentication)
            throws IOException {
        logger.info("Was invoked create Ad method");
        UserEntity user = adUtils.handleUser(authentication);
        String uniqueId = user.getEmail().concat("-").concat(createAd.getTitle());
        String link = new ImageMapper().mapFileToPath(image, uniqueId);
        Ads ads = createAd.mapDtoToAdEntity(link, user.getId());
        adRepository.save(ads);
        return Ad.mapEntityToDto(ads);
    }

    @Override
    public ExtendedAd getExtendedAd(Integer id, Authentication authentication) {
        logger.info("Was invoked get Ad info method");
        UserEntity user = adUtils.handleUser(authentication);
        Ads ads = adRepository.findById(id).get();
        return ExtendedAd.mapAdEntityToDto(ads, user);
    }

    @Override
    public ru.skypro.homework.dto.ad.Ads getAdsDto() {
        logger.info("Was invoked get all Ads method");
        ArrayList<Ad> ads = adRepository.findAll()
                .stream()
                .map(Ad::mapEntityToDto)
                .collect(Collectors.toCollection(ArrayList::new));
        Integer countAd = ads.size();
        return new ru.skypro.homework.dto.ad.Ads().getAds(countAd, ads);
    }

    @Override

    public void deleteAd(Integer id, Authentication authentication) {
        logger.info("Was invoked delete Ad method");
        adRepository.deleteById(id);

    }

    @Override
    public Ad updateAd(Integer id, CreateOrUpdateAd ad, Authentication authentication) {
        logger.info("Was invoked update Ad method");
        Ad updatedAd = ad.updateAd(adRepository.findById(id).get());
        adRepository.save(updatedAd.mapDtoToEntity(ad.getDescription()));
        return updatedAd;
    }

    @Override
    public ru.skypro.homework.dto.ad.Ads getAdsByUser(Authentication authentication) {
        logger.info("Was invoked get users Ads method");
        UserEntity user = adUtils.handleUser(authentication);
        ArrayList<Ad> ads = adRepository.findAllByAuthor(user.getId()).stream()
                .map(Ad::mapEntityToDto)
                .collect(Collectors.toCollection(ArrayList::new));
        Integer countAd = ads.size();
        return new ru.skypro.homework.dto.ad.Ads().getAds(countAd, ads);
    }

    @Override
    public void updateImage(Integer id, MultipartFile image, Authentication authentication) throws IOException {
        logger.info("Was invoked update Ads image method");
        Ads ad = adRepository.findById(id).get();
        UserEntity user = adUtils.handleUser(authentication);
        String uniqueId = user.getEmail().concat("-").concat(ad.getTitle());
        String imagePath = new ImageMapper().mapFileToPath(image, uniqueId);
        ad.setImage(imagePath);
        adRepository.save(ad);
    }

    @Override
    public Boolean foundById(Integer id) {
        logger.info("Was invoked find Ad by id method");
        return !adRepository.findById(id).isEmpty();
    }

    @Override
    public Ads findById(Integer id) {
        return adRepository.findById(id).get();
    }
}
