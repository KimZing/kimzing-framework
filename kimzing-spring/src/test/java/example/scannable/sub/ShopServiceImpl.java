package example.scannable.sub;

import com.kimzing.framework.core.annotation.Service;
import com.kimzing.framework.inject.annotation.Autowired;
import example.scannable.ShopRepository;
import example.scannable.ShopService;
import lombok.Getter;

/**
 * 商店存储实现.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/4/14 15:04
 */
@Getter
@Service
public class ShopServiceImpl implements ShopService {

    @Autowired("shopMySQLRepositoryImpl")
    private ShopRepository shopRepository;

}
