package nl.novi.Les11SpringBootTechItEasyApplication.dtos;

import nl.novi.Les11SpringBootTechItEasyApplication.models.Television;

public class TelevisionInputDto {
    private Long id;
    private String type;
    private String brand;
    private String name;
    private Double price;
    private Double availableSize;
    private Double refreshRate;
    private String screenType;
    private String screenQuality;
    private Boolean smartTv;
    private Boolean wifi;
    private Boolean voiceControl;
    private Boolean hdr;
    private Boolean bluetooth;
    private Boolean ambiLight;
    private Integer originalStock;
    private Integer sold;

    public Television toTelevision(){
        var television = new Television();

        television.setId(id);
        television.setType(type);
        television.setBrand(brand);
        television.setName(name);
        television.setPrice(price);
        television.setAvailableSize(availableSize);
        television.setRefreshRate(refreshRate);
        television.setScreenType(screenType);
        television.setScreenType(screenQuality);
        television.setSmartTv(smartTv);
        television.setWifi(wifi);
        television.setVoiceControl(voiceControl);
        television.setHdr(hdr);
        television.setBluetooth(bluetooth);
        television.setAmbiLight(ambiLight);
        television.setOriginalStock(originalStock);
        television.setSold(sold);

        return television;
    }
}
