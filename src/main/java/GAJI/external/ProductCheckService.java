
package GAJI.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.Date;

@FeignClient(name="productcheck", url="${api.url.productcheck}")
public interface ProductCheckService {

    @RequestMapping(method= RequestMethod.POST, path="/productChecks")
    public void requestCheck(@RequestBody ProductCheck productCheck);

}