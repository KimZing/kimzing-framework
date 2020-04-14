package example.scannable;

import com.kimzing.framework.core.annotation.Controller;
import com.kimzing.framework.inject.annotation.Autowired;
import lombok.Data;

/**
 * 商店控制层.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/4/14 15:00
 */
@Data
@Controller
public class ShopController {

    @Autowired
    private ShopService shopService;

}
