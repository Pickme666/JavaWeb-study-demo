package mvc.util;

import mvc.service.BrandService;

public class BrandServiceUtils {

    private static final BrandService brandService;

    static {
        brandService = new BrandService();
    }

    public static BrandService getBrandService() {
        return brandService;
    }
}
