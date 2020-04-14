package example.scannable.sub;

import com.kimzing.framework.core.annotation.Service;
import example.scannable.ShopRepository;
import example.scannable.ShopService;

/**
 * 商店存储实现.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/4/14 15:04
 */
@Service
public class ShopServiceImpl implements ShopService {

    private ShopRepository shopRepository;

}
